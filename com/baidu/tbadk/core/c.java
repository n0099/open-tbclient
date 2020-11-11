package com.baidu.tbadk.core;

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
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.webkit.internal.ETAG;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean IS_SUPPORT_NIGHT = false;
    private static String sPackagename = null;
    private static int sPacknameLength = 0;
    private Resources contextRes;
    private Resources pluginRes;
    private boolean isNightMode = false;
    Map<String, b> viewModeInfos = new HashMap();
    public boolean exe = false;

    public void initModeInfos(String str, Context context, AttributeSet attributeSet) {
        int[] resID;
        int i;
        boolean z = false;
        try {
            this.contextRes = context.getResources();
            this.pluginRes = this.contextRes;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.setViewClassName(str);
            for (int i2 = 0; i2 < attributeCount; i2++) {
                String attributeName = attributeSet.getAttributeName(i2);
                String attributeValue = attributeSet.getAttributeValue(i2);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] resID2 = getResID(attributeValue);
                    if (resID2 != null) {
                        bVar.setBackgroundResID(resID2[0]);
                        bVar.setBackgroundResID_(resID2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] resID3 = getResID(attributeValue);
                    if (resID3 != null) {
                        bVar.setImageResID(resID3[0]);
                        bVar.setImageResID_(resID3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] resID4 = getResID(attributeValue);
                    if (resID4 != null) {
                        bVar.setTextColorResID(resID4[0]);
                        bVar.setTextColorResID_(resID4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] resID5 = getResID(attributeValue);
                    if (resID5 != null) {
                        bVar.setStyleResID(resID5[0]);
                        bVar.setStyleResID_(resID5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] resID6 = getResID(attributeValue);
                    if (resID6 != null) {
                        bVar.setDivierResID(resID6[0]);
                        bVar.setDivierResID_(resID6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] resID7 = getResID(attributeValue);
                    if (resID7 != null) {
                        bVar.setDrawableTopResID(resID7[0]);
                        bVar.setDrawableTopResID_(resID7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] resID8 = getResID(attributeValue);
                    if (resID8 != null) {
                        bVar.setDrawableLeftResID(resID8[0]);
                        bVar.setDrawableLeftResID_(resID8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] resID9 = getResID(attributeValue);
                    if (resID9 != null) {
                        bVar.setDrawableRightResID(resID9[0]);
                        bVar.setDrawableRightResID_(resID9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] resID10 = getResID(attributeValue);
                    if (resID10 != null) {
                        bVar.setProgressDrawableID(resID10[0]);
                        bVar.setProgressDrawableID_(resID10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (resID = getResID(attributeValue)) != null) {
                    bVar.setTextColorHintResID(resID[0]);
                    bVar.setTextColorHintResID_(resID[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (i = com.baidu.adp.lib.f.b.toInt(attributeValue.substring(1), 0)) != 0) {
                    bVar.appendTag(attributeName + ETAG.EQUAL + this.contextRes.getResourceName(i));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.viewModeInfos != null && !this.viewModeInfos.containsKey(bVar.getId())) {
                    this.viewModeInfos.put(bVar.getId(), bVar);
                    return;
                }
                if (TextUtils.isEmpty(bVar.getId()) || this.viewModeInfos.containsKey(bVar.getId())) {
                }
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
                int identifier = resources2.getIdentifier(resourceName + "_1", null, null);
                if (identifier <= 0) {
                    String str2 = "com.baidu.tieba.pluginResource" + resourceName.substring(resourceName.indexOf(":"));
                    i2 = resources2.getIdentifier(str2 + "_1", null, null);
                    str = str2;
                } else {
                    String str3 = resourceName;
                    i2 = identifier;
                    str = str3;
                }
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
            b bVar = this.viewModeInfos.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.getDivierResID_() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(getDrawable(this.isNightMode, bVar.getDivierResID(), bVar.getDivierResID_()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.getBackgroundResID_() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.contextRes.getResourceTypeName(bVar.getBackgroundResID());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(getColor(this.isNightMode, bVar.getBackgroundResID(), bVar.getBackgroundResID_()));
                } else {
                    viewGroup.setBackgroundDrawable(getDrawable(this.isNightMode, bVar.getBackgroundResID(), bVar.getBackgroundResID_()));
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
            b bVar = this.viewModeInfos.get(str);
            if (view instanceof TextView) {
                if (bVar.getTextColorResID_() != 0) {
                    ((TextView) view).setTextColor(getColorList(this.isNightMode, bVar.getTextColorResID(), bVar.getTextColorResID_()));
                }
                if (bVar.getTextColorHintResID_() != 0) {
                    ((TextView) view).setHintTextColor(getColorList(this.isNightMode, bVar.getTextColorHintResID(), bVar.getTextColorHintResID_()));
                }
                if (bVar.getStyleResID_() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.isNightMode) {
                        styleResID = bVar.getStyleResID_();
                    } else {
                        styleResID = bVar.getStyleResID();
                    }
                    textView.setTextAppearance(context, styleResID);
                }
                if (bVar.getDrawableTopResID_() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getDrawable(this.isNightMode, bVar.getDrawableTopResID(), bVar.getDrawableTopResID_()), (Drawable) null, (Drawable) null);
                }
                if (bVar.getDrawableLeftResID_() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(getDrawable(this.isNightMode, bVar.getDrawableLeftResID(), bVar.getDrawableLeftResID_()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.getDrawableRightResID_() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getDrawable(this.isNightMode, bVar.getDrawableRightResID(), bVar.getDrawableRightResID_()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.getImageResID_() != 0 && (drawable3 = getDrawable(this.isNightMode, bVar.getImageResID(), bVar.getImageResID_())) != null) {
                    ((ImageView) view).setImageDrawable(drawable3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.getImageResID_() != 0 && (drawable2 = getDrawable(this.isNightMode, bVar.getImageResID(), bVar.getImageResID_())) != null) {
                    ((ImageView) view).setImageDrawable(drawable2);
                }
            } else if ((view instanceof ProgressBar) && bVar.getProgressDrawableID_() != 0 && (drawable = getDrawable(this.isNightMode, bVar.getProgressDrawableID(), bVar.getProgressDrawableID_())) != null) {
                ((ProgressBar) view).setProgressDrawable(drawable);
            }
            if (bVar.getBackgroundResID_() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.contextRes.getResourceTypeName(bVar.getBackgroundResID());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(getColor(this.isNightMode, bVar.getBackgroundResID(), bVar.getBackgroundResID_()));
                } else {
                    view.setBackgroundDrawable(getDrawable(this.isNightMode, bVar.getBackgroundResID(), bVar.getBackgroundResID_()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable getDrawable(boolean z, int i, int i2) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 2 || (!this.exe && skinType == 4)) {
            return ap.getDrawable(i);
        }
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
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 2 || (!this.exe && skinType == 4)) {
            return ap.getColor(i);
        }
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
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 2 || (!this.exe && skinType == 4)) {
            return ap.getColorList(i);
        }
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
