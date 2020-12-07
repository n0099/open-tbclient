package com.baidu.live.tbadk.core;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.searchbox.ugc.model.UgcConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes4.dex */
public class BDLayoutMode {
    private static final String ATTR_NAME_BACKGROUND = "tb_background";
    private static final String ATTR_NAME_DIVIDER = "tb_divider";
    private static final String ATTR_NAME_DRAWABLE_Left = "tb_drawableLeft";
    private static final String ATTR_NAME_DRAWABLE_Right = "tb_drawableRight";
    private static final String ATTR_NAME_DRAWABLE_TOP = "tb_drawableTop";
    private static final String ATTR_NAME_ID = "id";
    private static final String ATTR_NAME_IMAGE_SRC = "tb_src";
    private static final String ATTR_NAME_PROGRESS_DRAWABLE = "tb_progressDrawable";
    private static final String ATTR_NAME_STYLE = "tb_style";
    private static final String ATTR_NAME_TEXT_COLOR = "tb_textColor";
    private static final String ATTR_NAME_TEXT_COLOR_HINT = "tb_textColorHint";
    private static final String nightSufix = "_1";
    private Resources contextRes;
    private Resources pluginRes;
    public static boolean IS_SUPPORT_NIGHT = false;
    private static String sPackagename = null;
    private static int sPacknameLength = 0;
    private boolean isNightMode = false;
    Map<String, BDLayoutInfo> viewModeInfos = new HashMap();

    public void initModeInfos(String str, Context context, AttributeSet attributeSet) {
        int[] resID;
        int i;
        boolean z = false;
        try {
            this.contextRes = context.getResources();
            this.pluginRes = this.contextRes;
            int attributeCount = attributeSet.getAttributeCount();
            BDLayoutInfo bDLayoutInfo = new BDLayoutInfo();
            bDLayoutInfo.setViewClassName(str);
            for (int i2 = 0; i2 < attributeCount; i2++) {
                String attributeName = attributeSet.getAttributeName(i2);
                String attributeValue = attributeSet.getAttributeValue(i2);
                if (attributeName.equals("id")) {
                    bDLayoutInfo.setId(attributeValue);
                } else if (attributeName.equals(ATTR_NAME_BACKGROUND)) {
                    int[] resID2 = getResID(attributeValue);
                    if (resID2 != null) {
                        bDLayoutInfo.setBackgroundResID(resID2[0]);
                        bDLayoutInfo.setBackgroundResID_(resID2[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_IMAGE_SRC)) {
                    int[] resID3 = getResID(attributeValue);
                    if (resID3 != null) {
                        bDLayoutInfo.setImageResID(resID3[0]);
                        bDLayoutInfo.setImageResID_(resID3[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_TEXT_COLOR)) {
                    int[] resID4 = getResID(attributeValue);
                    if (resID4 != null) {
                        bDLayoutInfo.setTextColorResID(resID4[0]);
                        bDLayoutInfo.setTextColorResID_(resID4[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_STYLE)) {
                    int[] resID5 = getResID(attributeValue);
                    if (resID5 != null) {
                        bDLayoutInfo.setStyleResID(resID5[0]);
                        bDLayoutInfo.setStyleResID_(resID5[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_DIVIDER)) {
                    int[] resID6 = getResID(attributeValue);
                    if (resID6 != null) {
                        bDLayoutInfo.setDivierResID(resID6[0]);
                        bDLayoutInfo.setDivierResID_(resID6[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_DRAWABLE_TOP)) {
                    int[] resID7 = getResID(attributeValue);
                    if (resID7 != null) {
                        bDLayoutInfo.setDrawableTopResID(resID7[0]);
                        bDLayoutInfo.setDrawableTopResID_(resID7[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_DRAWABLE_Left)) {
                    int[] resID8 = getResID(attributeValue);
                    if (resID8 != null) {
                        bDLayoutInfo.setDrawableLeftResID(resID8[0]);
                        bDLayoutInfo.setDrawableLeftResID_(resID8[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_DRAWABLE_Right)) {
                    int[] resID9 = getResID(attributeValue);
                    if (resID9 != null) {
                        bDLayoutInfo.setDrawableRightResID(resID9[0]);
                        bDLayoutInfo.setDrawableRightResID_(resID9[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_PROGRESS_DRAWABLE)) {
                    int[] resID10 = getResID(attributeValue);
                    if (resID10 != null) {
                        bDLayoutInfo.setProgressDrawableID(resID10[0]);
                        bDLayoutInfo.setProgressDrawableID_(resID10[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_TEXT_COLOR_HINT) && (resID = getResID(attributeValue)) != null) {
                    bDLayoutInfo.setTextColorHintResID(resID[0]);
                    bDLayoutInfo.setTextColorHintResID_(resID[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (i = JavaTypesHelper.toInt(attributeValue.substring(1), 0)) != 0) {
                    bDLayoutInfo.appendTag(attributeName + "=" + this.contextRes.getResourceName(i));
                }
            }
            if (z && !TextUtils.isEmpty(bDLayoutInfo.getId()) && this.viewModeInfos != null && !this.viewModeInfos.containsKey(bDLayoutInfo.getId())) {
                this.viewModeInfos.put(bDLayoutInfo.getId(), bDLayoutInfo);
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] getResID(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, getNightResouce(this.contextRes, this.pluginRes, parseInt)};
        }
        return null;
    }

    public static int getNightResouce(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (IS_SUPPORT_NIGHT) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (sPacknameLength == 0) {
                    sPackagename = BdBaseApplication.getInst().getPackageName();
                    sPacknameLength = sPackagename.length();
                }
                if (resourceName.length() > sPacknameLength && resourceName.charAt(sPacknameLength) != ':' && resourceName.startsWith(sPackagename)) {
                    resourceName = sPackagename + resourceName.substring(resourceName.indexOf(":"));
                }
                String str2 = resourceName;
                i2 = resources2.getIdentifier(resourceName + nightSufix, null, null);
                str = str2;
            }
            if (i2 == 0) {
                BdLog.e(str + " 缺少夜间资源,使用了日间资源");
                return i;
            }
            return i2;
        }
        return i;
    }

    public void onModeChanged(View view) {
        if (view != null) {
            Stack stack = new Stack();
            stack.push(view);
            while (!stack.isEmpty()) {
                View view2 = (View) stack.pop();
                if (view2 instanceof ViewGroup) {
                    changeForViewGroup((ViewGroup) view2);
                    if (!(view2 instanceof AdapterView)) {
                        int childCount = ((ViewGroup) view2).getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            stack.push(((ViewGroup) view2).getChildAt(i));
                        }
                    }
                } else {
                    changeForView(view2);
                }
            }
        }
    }

    private void changeForViewGroup(ViewGroup viewGroup) {
        String str = UgcConstant.AT_RULE_TAG + viewGroup.getId();
        if (this.viewModeInfos != null && this.viewModeInfos.containsKey(str)) {
            BDLayoutInfo bDLayoutInfo = this.viewModeInfos.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bDLayoutInfo.getDivierResID_() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(getDrawable(this.isNightMode, bDLayoutInfo.getDivierResID(), bDLayoutInfo.getDivierResID_()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bDLayoutInfo.getBackgroundResID_() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.contextRes.getResourceTypeName(bDLayoutInfo.getBackgroundResID());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(getColor(this.isNightMode, bDLayoutInfo.getBackgroundResID(), bDLayoutInfo.getBackgroundResID_()));
                } else {
                    viewGroup.setBackgroundDrawable(getDrawable(this.isNightMode, bDLayoutInfo.getBackgroundResID(), bDLayoutInfo.getBackgroundResID_()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void changeForView(View view) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        int styleResID;
        String str = UgcConstant.AT_RULE_TAG + view.getId();
        if (this.viewModeInfos != null && this.viewModeInfos.containsKey(str)) {
            BDLayoutInfo bDLayoutInfo = this.viewModeInfos.get(str);
            if (view instanceof TextView) {
                if (bDLayoutInfo.getTextColorResID_() != 0) {
                    ((TextView) view).setTextColor(getColorList(this.isNightMode, bDLayoutInfo.getTextColorResID(), bDLayoutInfo.getTextColorResID_()));
                }
                if (bDLayoutInfo.getTextColorHintResID_() != 0) {
                    ((TextView) view).setHintTextColor(getColorList(this.isNightMode, bDLayoutInfo.getTextColorHintResID(), bDLayoutInfo.getTextColorHintResID_()));
                }
                if (bDLayoutInfo.getStyleResID_() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.isNightMode) {
                        styleResID = bDLayoutInfo.getStyleResID_();
                    } else {
                        styleResID = bDLayoutInfo.getStyleResID();
                    }
                    textView.setTextAppearance(context, styleResID);
                }
                if (bDLayoutInfo.getDrawableTopResID_() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getDrawable(this.isNightMode, bDLayoutInfo.getDrawableTopResID(), bDLayoutInfo.getDrawableTopResID_()), (Drawable) null, (Drawable) null);
                }
                if (bDLayoutInfo.getDrawableLeftResID_() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(getDrawable(this.isNightMode, bDLayoutInfo.getDrawableLeftResID(), bDLayoutInfo.getDrawableLeftResID_()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bDLayoutInfo.getDrawableRightResID_() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getDrawable(this.isNightMode, bDLayoutInfo.getDrawableRightResID(), bDLayoutInfo.getDrawableRightResID_()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bDLayoutInfo.getImageResID_() != 0 && (drawable3 = getDrawable(this.isNightMode, bDLayoutInfo.getImageResID(), bDLayoutInfo.getImageResID_())) != null) {
                    ((ImageView) view).setImageDrawable(drawable3);
                }
            } else if (view instanceof ImageView) {
                if (bDLayoutInfo.getImageResID_() != 0 && (drawable2 = getDrawable(this.isNightMode, bDLayoutInfo.getImageResID(), bDLayoutInfo.getImageResID_())) != null) {
                    ((ImageView) view).setImageDrawable(drawable2);
                }
            } else if ((view instanceof ProgressBar) && bDLayoutInfo.getProgressDrawableID_() != 0 && (drawable = getDrawable(this.isNightMode, bDLayoutInfo.getProgressDrawableID(), bDLayoutInfo.getProgressDrawableID_())) != null) {
                ((ProgressBar) view).setProgressDrawable(drawable);
            }
            if (bDLayoutInfo.getBackgroundResID_() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.contextRes.getResourceTypeName(bDLayoutInfo.getBackgroundResID());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(getColor(this.isNightMode, bDLayoutInfo.getBackgroundResID(), bDLayoutInfo.getBackgroundResID_()));
                } else {
                    view.setBackgroundDrawable(getDrawable(this.isNightMode, bDLayoutInfo.getBackgroundResID(), bDLayoutInfo.getBackgroundResID_()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable getDrawable(boolean z, int i, int i2) {
        if (!z) {
            try {
                return this.contextRes.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.pluginRes = this.contextRes;
            i2 = getNightResouce(this.contextRes, this.pluginRes, i);
        }
        if (this.pluginRes == null) {
            try {
                return this.contextRes.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.pluginRes.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.contextRes.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int getColor(boolean z, int i, int i2) {
        if (!z) {
            return this.contextRes.getColor(i);
        }
        if (i == i2) {
            this.pluginRes = this.contextRes;
            i2 = getNightResouce(this.contextRes, this.pluginRes, i);
        }
        if (this.pluginRes == null) {
            return this.contextRes.getColor(i);
        }
        try {
            return this.pluginRes.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.contextRes.getColor(i);
        }
    }

    private ColorStateList getColorList(boolean z, int i, int i2) {
        if (!z) {
            return this.contextRes.getColorStateList(i);
        }
        if (i == i2) {
            this.pluginRes = this.contextRes;
            i2 = getNightResouce(this.contextRes, this.pluginRes, i);
        }
        if (this.pluginRes == null) {
            return this.contextRes.getColorStateList(i);
        }
        try {
            return this.pluginRes.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.contextRes.getColorStateList(i);
        }
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }

    public void setNightMode(boolean z) {
        this.isNightMode = z;
    }

    public void setPluginRes(Resources resources) {
        this.pluginRes = resources;
    }

    public void destroy() {
        if (this.viewModeInfos != null) {
            this.viewModeInfos.clear();
            this.viewModeInfos = null;
        }
    }
}
