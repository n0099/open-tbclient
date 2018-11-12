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
import com.baidu.tbadk.core.util.al;
import com.baidu.webkit.internal.ETAG;
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
    private static final String nightSufix = "_1";
    private Resources contextRes;
    private Resources pluginRes;
    public static boolean IS_SUPPORT_NIGHT = false;
    private static String sPackagename = null;
    private static int sPacknameLength = 0;
    private boolean isNightMode = false;
    Map<String, b> viewModeInfos = new HashMap();

    public void initModeInfos(String str, Context context, AttributeSet attributeSet) {
        int[] resID;
        int l;
        boolean z = false;
        try {
            this.contextRes = context.getResources();
            this.pluginRes = this.contextRes;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.dH(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals(ATTR_NAME_BACKGROUND)) {
                    int[] resID2 = getResID(attributeValue);
                    if (resID2 != null) {
                        bVar.bW(resID2[0]);
                        bVar.bX(resID2[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_IMAGE_SRC)) {
                    int[] resID3 = getResID(attributeValue);
                    if (resID3 != null) {
                        bVar.cc(resID3[0]);
                        bVar.cd(resID3[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_TEXT_COLOR)) {
                    int[] resID4 = getResID(attributeValue);
                    if (resID4 != null) {
                        bVar.ca(resID4[0]);
                        bVar.cb(resID4[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_STYLE)) {
                    int[] resID5 = getResID(attributeValue);
                    if (resID5 != null) {
                        bVar.cf(resID5[0]);
                        bVar.ce(resID5[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_DIVIDER)) {
                    int[] resID6 = getResID(attributeValue);
                    if (resID6 != null) {
                        bVar.bS(resID6[0]);
                        bVar.bT(resID6[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_DRAWABLE_TOP)) {
                    int[] resID7 = getResID(attributeValue);
                    if (resID7 != null) {
                        bVar.bQ(resID7[0]);
                        bVar.bR(resID7[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_DRAWABLE_Left)) {
                    int[] resID8 = getResID(attributeValue);
                    if (resID8 != null) {
                        bVar.bO(resID8[0]);
                        bVar.bP(resID8[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_DRAWABLE_Right)) {
                    int[] resID9 = getResID(attributeValue);
                    if (resID9 != null) {
                        bVar.bU(resID9[0]);
                        bVar.bV(resID9[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_PROGRESS_DRAWABLE)) {
                    int[] resID10 = getResID(attributeValue);
                    if (resID10 != null) {
                        bVar.cg(resID10[0]);
                        bVar.ch(resID10[1]);
                        z = true;
                    }
                } else if (attributeName.equals(ATTR_NAME_TEXT_COLOR_HINT) && (resID = getResID(attributeValue)) != null) {
                    bVar.bY(resID[0]);
                    bVar.bZ(resID[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (l = com.baidu.adp.lib.g.b.l(attributeValue.substring(1), 0)) != 0) {
                    bVar.dG(attributeName + ETAG.EQUAL + this.contextRes.getResourceName(l));
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
        String str = "@" + viewGroup.getId();
        if (this.viewModeInfos != null && this.viewModeInfos.containsKey(str)) {
            b bVar = this.viewModeInfos.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.wj() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(getDrawable(this.isNightMode, bVar.wi(), bVar.wj()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.wn() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.contextRes.getResourceTypeName(bVar.wm());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(getColor(this.isNightMode, bVar.wm(), bVar.wn()));
                } else {
                    viewGroup.setBackgroundDrawable(getDrawable(this.isNightMode, bVar.wm(), bVar.wn()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void changeForView(View view) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        int wv;
        String str = "@" + view.getId();
        if (this.viewModeInfos != null && this.viewModeInfos.containsKey(str)) {
            b bVar = this.viewModeInfos.get(str);
            if (view instanceof TextView) {
                if (bVar.wr() != 0) {
                    ((TextView) view).setTextColor(getColorList(this.isNightMode, bVar.wq(), bVar.wr()));
                }
                if (bVar.wp() != 0) {
                    ((TextView) view).setHintTextColor(getColorList(this.isNightMode, bVar.wo(), bVar.wp()));
                }
                if (bVar.wu() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.isNightMode) {
                        wv = bVar.wu();
                    } else {
                        wv = bVar.wv();
                    }
                    textView.setTextAppearance(context, wv);
                }
                if (bVar.wh() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getDrawable(this.isNightMode, bVar.wg(), bVar.wh()), (Drawable) null, (Drawable) null);
                }
                if (bVar.wf() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(getDrawable(this.isNightMode, bVar.we(), bVar.wf()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.wl() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getDrawable(this.isNightMode, bVar.wk(), bVar.wl()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.ws() != 0 && (drawable3 = getDrawable(this.isNightMode, bVar.wt(), bVar.ws())) != null) {
                    ((ImageView) view).setImageDrawable(drawable3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.ws() != 0 && (drawable2 = getDrawable(this.isNightMode, bVar.wt(), bVar.ws())) != null) {
                    ((ImageView) view).setImageDrawable(drawable2);
                }
            } else if ((view instanceof ProgressBar) && bVar.wx() != 0 && (drawable = getDrawable(this.isNightMode, bVar.ww(), bVar.wx())) != null) {
                ((ProgressBar) view).setProgressDrawable(drawable);
            }
            if (bVar.wn() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.contextRes.getResourceTypeName(bVar.wm());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(getColor(this.isNightMode, bVar.wm(), bVar.wn()));
                } else {
                    view.setBackgroundDrawable(getDrawable(this.isNightMode, bVar.wm(), bVar.wn()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable getDrawable(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return al.getDrawable(i);
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
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return al.getColor(i);
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
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return al.dz(i);
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
