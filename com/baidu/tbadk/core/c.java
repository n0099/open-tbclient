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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.am;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
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
    private static final String PLUGIN_NIGHT_RESOURCE = "com.baidu.tieba.pluginResource";
    private static final String nightSufix = "_1";
    private Resources contextRes;
    private Resources pluginRes;
    public static boolean IS_SUPPORT_NIGHT = false;
    private static String sPackagename = null;
    private static int sPacknameLength = 0;
    private boolean isNightMode = false;
    private boolean forceDayMode = false;
    Map<String, b> viewModeInfos = new HashMap();
    public boolean isForceDayMode = false;

    public void initModeInfos(String str, Context context, AttributeSet attributeSet) {
        int[] resID;
        int f;
        boolean z = false;
        try {
            this.contextRes = context.getResources();
            this.pluginRes = this.contextRes;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.mj(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals(ATTR_NAME_BACKGROUND)) {
                    int[] resID2 = getResID(attributeValue);
                    if (resID2 != null) {
                        bVar.gC(resID2[0]);
                        bVar.gD(resID2[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_IMAGE_SRC)) {
                    int[] resID3 = getResID(attributeValue);
                    if (resID3 != null) {
                        bVar.gI(resID3[0]);
                        bVar.gJ(resID3[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_TEXT_COLOR)) {
                    int[] resID4 = getResID(attributeValue);
                    if (resID4 != null) {
                        bVar.gG(resID4[0]);
                        bVar.gH(resID4[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_STYLE)) {
                    int[] resID5 = getResID(attributeValue);
                    if (resID5 != null) {
                        bVar.gL(resID5[0]);
                        bVar.gK(resID5[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_DIVIDER)) {
                    int[] resID6 = getResID(attributeValue);
                    if (resID6 != null) {
                        bVar.gy(resID6[0]);
                        bVar.gz(resID6[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_DRAWABLE_TOP)) {
                    int[] resID7 = getResID(attributeValue);
                    if (resID7 != null) {
                        bVar.gw(resID7[0]);
                        bVar.gx(resID7[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_DRAWABLE_Left)) {
                    int[] resID8 = getResID(attributeValue);
                    if (resID8 != null) {
                        bVar.gu(resID8[0]);
                        bVar.gv(resID8[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_DRAWABLE_Right)) {
                    int[] resID9 = getResID(attributeValue);
                    if (resID9 != null) {
                        bVar.gA(resID9[0]);
                        bVar.gB(resID9[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_PROGRESS_DRAWABLE)) {
                    int[] resID10 = getResID(attributeValue);
                    if (resID10 != null) {
                        bVar.gM(resID10[0]);
                        bVar.gN(resID10[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_TEXT_COLOR_HINT) && (resID = getResID(attributeValue)) != null) {
                    bVar.gE(resID[0]);
                    bVar.gF(resID[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (f = com.baidu.adp.lib.g.b.f(attributeValue.substring(1), 0)) != 0) {
                    bVar.mi(attributeName + "=" + this.contextRes.getResourceName(f));
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
                int identifier = resources2.getIdentifier(resourceName + nightSufix, null, null);
                if (identifier <= 0) {
                    String str2 = PLUGIN_NIGHT_RESOURCE + resourceName.substring(resourceName.indexOf(":"));
                    i2 = resources2.getIdentifier(str2 + nightSufix, null, null);
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
        String str = "@" + viewGroup.getId();
        if (this.viewModeInfos != null && this.viewModeInfos.containsKey(str)) {
            b bVar = this.viewModeInfos.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.abN() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(getDrawable(this.isNightMode, bVar.abM(), bVar.abN()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.abR() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.contextRes.getResourceTypeName(bVar.abQ());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(getColor(this.isNightMode, bVar.abQ(), bVar.abR()));
                } else {
                    viewGroup.setBackgroundDrawable(getDrawable(this.isNightMode, bVar.abQ(), bVar.abR()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void changeForView(View view) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        int abZ;
        String str = "@" + view.getId();
        if (this.viewModeInfos != null && this.viewModeInfos.containsKey(str)) {
            b bVar = this.viewModeInfos.get(str);
            if (view instanceof TextView) {
                if (bVar.abV() != 0) {
                    ((TextView) view).setTextColor(getColorList(this.isNightMode, bVar.abU(), bVar.abV()));
                }
                if (bVar.abT() != 0) {
                    ((TextView) view).setHintTextColor(getColorList(this.isNightMode, bVar.abS(), bVar.abT()));
                }
                if (bVar.abY() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.isNightMode) {
                        abZ = bVar.abY();
                    } else {
                        abZ = bVar.abZ();
                    }
                    textView.setTextAppearance(context, abZ);
                }
                if (bVar.abL() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getDrawable(this.isNightMode, bVar.abK(), bVar.abL()), (Drawable) null, (Drawable) null);
                }
                if (bVar.abJ() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(getDrawable(this.isNightMode, bVar.abI(), bVar.abJ()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.abP() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getDrawable(this.isNightMode, bVar.abO(), bVar.abP()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.abW() != 0 && (drawable3 = getDrawable(this.isNightMode, bVar.abX(), bVar.abW())) != null) {
                    ((ImageView) view).setImageDrawable(drawable3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.abW() != 0 && (drawable2 = getDrawable(this.isNightMode, bVar.abX(), bVar.abW())) != null) {
                    ((ImageView) view).setImageDrawable(drawable2);
                }
            } else if ((view instanceof ProgressBar) && bVar.acb() != 0 && (drawable = getDrawable(this.isNightMode, bVar.aca(), bVar.acb())) != null) {
                ((ProgressBar) view).setProgressDrawable(drawable);
            }
            if (bVar.abR() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.contextRes.getResourceTypeName(bVar.abQ());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(getColor(this.isNightMode, bVar.abQ(), bVar.abR()));
                } else {
                    view.setBackgroundDrawable(getDrawable(this.isNightMode, bVar.abQ(), bVar.abR()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable getDrawable(boolean z, int i, int i2) {
        if (this.forceDayMode) {
            try {
                return this.contextRes.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 2 || (!this.isForceDayMode && skinType == 4)) {
            return am.getDrawable(i);
        }
        if (!z) {
            try {
                return this.contextRes.getDrawable(i);
            } catch (Throwable th2) {
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
            } catch (Throwable th3) {
                return null;
            }
        }
        try {
            return this.pluginRes.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.contextRes.getDrawable(i);
            } catch (Throwable th4) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int getColor(boolean z, int i, int i2) {
        if (this.forceDayMode) {
            return this.contextRes.getColor(i);
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 2 || (!this.isForceDayMode && skinType == 4)) {
            return am.getColor(i);
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
        if (this.forceDayMode) {
            return this.contextRes.getColorStateList(i);
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 2 || (!this.isForceDayMode && skinType == 4)) {
            return am.ii(i);
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

    public boolean isNightMode() {
        return this.isNightMode;
    }

    public void setNightMode(boolean z) {
        this.isNightMode = z;
    }

    public void setFroceDayMode(boolean z) {
        this.forceDayMode = z;
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
