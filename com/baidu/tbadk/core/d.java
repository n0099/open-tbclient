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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.pluginArch.PluginHelper;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.pluginArch.PluginResourcesManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class d {
    private static String yF;
    private boolean yB = false;
    Map<String, c> yC = new HashMap();
    private Resources yD;
    private Resources yE;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] aV;
        int f;
        boolean z = false;
        try {
            this.yD = context.getResources();
            this.yE = PluginResourcesManager.getInstance().getPluginResource(PluginNameList.NAME_NIGHT_RESOURCE, this.yD);
            if (TextUtils.isEmpty(yF)) {
                yF = PluginHelper.getPluginPackage(PluginNameList.NAME_NIGHT_RESOURCE);
            }
            int attributeCount = attributeSet.getAttributeCount();
            c cVar = new c();
            cVar.aU(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    cVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] aV2 = aV(attributeValue);
                    if (aV2 != null) {
                        cVar.aw(aV2[0]);
                        cVar.ax(aV2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] aV3 = aV(attributeValue);
                    if (aV3 != null) {
                        cVar.aC(aV3[0]);
                        cVar.aD(aV3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] aV4 = aV(attributeValue);
                    if (aV4 != null) {
                        cVar.aA(aV4[0]);
                        cVar.aB(aV4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] aV5 = aV(attributeValue);
                    if (aV5 != null) {
                        cVar.aF(aV5[0]);
                        cVar.aE(aV5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] aV6 = aV(attributeValue);
                    if (aV6 != null) {
                        cVar.as(aV6[0]);
                        cVar.at(aV6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] aV7 = aV(attributeValue);
                    if (aV7 != null) {
                        cVar.aq(aV7[0]);
                        cVar.ar(aV7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] aV8 = aV(attributeValue);
                    if (aV8 != null) {
                        cVar.ao(aV8[0]);
                        cVar.ap(aV8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] aV9 = aV(attributeValue);
                    if (aV9 != null) {
                        cVar.au(aV9[0]);
                        cVar.av(aV9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] aV10 = aV(attributeValue);
                    if (aV10 != null) {
                        cVar.aG(aV10[0]);
                        cVar.aH(aV10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (aV = aV(attributeValue)) != null) {
                    cVar.ay(aV[0]);
                    cVar.az(aV[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (f = com.baidu.adp.lib.g.c.f(attributeValue.substring(1), 0)) != 0) {
                    cVar.aT(String.valueOf(attributeName) + "=" + this.yD.getResourceName(f));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(cVar.getId()) && this.yC != null && !this.yC.containsKey(cVar.getId())) {
                    this.yC.put(cVar.getId(), cVar);
                } else if (!TextUtils.isEmpty(cVar.getId())) {
                    this.yC.containsKey(cVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] aV(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.yD, this.yE, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        int indexOf;
        String resourceName = resources.getResourceName(i);
        int i2 = 0;
        if (!TextUtils.isEmpty(resourceName) && (indexOf = resourceName.indexOf(":")) > 0 && !TextUtils.isEmpty(yF)) {
            i2 = resources2.getIdentifier(String.valueOf(String.valueOf(yF) + resourceName.substring(indexOf)) + "_1", null, null);
        }
        if (i2 == 0) {
            BdLog.e(String.valueOf(resourceName) + " 缺少夜间资源,使用了日间资源");
            return i;
        }
        return i2;
    }

    public void h(View view) {
        if (view != null) {
            Stack stack = new Stack();
            stack.push(view);
            while (!stack.isEmpty()) {
                View view2 = (View) stack.pop();
                if (view2 instanceof ViewGroup) {
                    b((ViewGroup) view2);
                    if (!(view2 instanceof AdapterView)) {
                        int childCount = ((ViewGroup) view2).getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            stack.push(((ViewGroup) view2).getChildAt(i));
                        }
                    }
                } else {
                    i(view2);
                }
            }
        }
    }

    private void b(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.yC != null && this.yC.containsKey(str)) {
            c cVar = this.yC.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && cVar.ja() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(a(this.yB, cVar.iZ(), cVar.ja()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (cVar.je() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.yD.getResourceTypeName(cVar.jd());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(b(this.yB, cVar.jd(), cVar.je()));
                } else {
                    viewGroup.setBackgroundDrawable(a(this.yB, cVar.jd(), cVar.je()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void i(View view) {
        Drawable a;
        Drawable a2;
        Drawable a3;
        String str = "@" + view.getId();
        if (this.yC != null && this.yC.containsKey(str)) {
            c cVar = this.yC.get(str);
            if (view instanceof TextView) {
                if (cVar.ji() != 0) {
                    ((TextView) view).setTextColor(c(this.yB, cVar.jh(), cVar.ji()));
                }
                if (cVar.jg() != 0) {
                    ((TextView) view).setHintTextColor(c(this.yB, cVar.jf(), cVar.jg()));
                }
                if (cVar.jl() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.yB ? cVar.jl() : cVar.jm());
                }
                if (cVar.iY() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, a(this.yB, cVar.iX(), cVar.iY()), (Drawable) null, (Drawable) null);
                }
                if (cVar.iW() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(a(this.yB, cVar.iV(), cVar.iW()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (cVar.jc() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a(this.yB, cVar.jb(), cVar.jc()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (cVar.jj() != 0 && (a3 = a(this.yB, cVar.jk(), cVar.jj())) != null) {
                    ((ImageView) view).setImageDrawable(a3);
                }
            } else if (view instanceof ImageView) {
                if (cVar.jj() != 0 && (a2 = a(this.yB, cVar.jk(), cVar.jj())) != null) {
                    ((ImageView) view).setImageDrawable(a2);
                }
            } else if ((view instanceof ProgressBar) && cVar.jo() != 0 && (a = a(this.yB, cVar.jn(), cVar.jo())) != null) {
                ((ProgressBar) view).setProgressDrawable(a);
            }
            if (cVar.je() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.yD.getResourceTypeName(cVar.jd());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(b(this.yB, cVar.jd(), cVar.je()));
                } else {
                    view.setBackgroundDrawable(a(this.yB, cVar.jd(), cVar.je()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable a(boolean z, int i, int i2) {
        if (!z) {
            return this.yD.getDrawable(i);
        }
        if (i == i2) {
            this.yE = PluginResourcesManager.getInstance().getPluginResource(PluginNameList.NAME_NIGHT_RESOURCE, this.yD);
            if (TextUtils.isEmpty(yF)) {
                yF = PluginHelper.getPluginPackage(PluginNameList.NAME_NIGHT_RESOURCE);
            }
            i2 = a(this.yD, this.yE, i);
        }
        if (this.yE == null) {
            return this.yD.getDrawable(i);
        }
        try {
            return this.yE.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            return this.yD.getDrawable(i);
        }
    }

    private int b(boolean z, int i, int i2) {
        if (!z) {
            return this.yD.getColor(i);
        }
        if (i == i2) {
            this.yE = PluginResourcesManager.getInstance().getPluginResource(PluginNameList.NAME_NIGHT_RESOURCE, this.yD);
            if (TextUtils.isEmpty(yF)) {
                yF = PluginHelper.getPluginPackage(PluginNameList.NAME_NIGHT_RESOURCE);
            }
            i2 = a(this.yD, this.yE, i);
        }
        if (this.yE == null) {
            return this.yD.getColor(i);
        }
        try {
            return this.yE.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.yD.getColor(i);
        }
    }

    private ColorStateList c(boolean z, int i, int i2) {
        if (!z) {
            return this.yD.getColorStateList(i);
        }
        if (i == i2) {
            this.yE = PluginResourcesManager.getInstance().getPluginResource(PluginNameList.NAME_NIGHT_RESOURCE, this.yD);
            if (TextUtils.isEmpty(yF)) {
                yF = PluginHelper.getPluginPackage(PluginNameList.NAME_NIGHT_RESOURCE);
            }
            i2 = a(this.yD, this.yE, i);
        }
        if (this.yE == null) {
            return this.yD.getColorStateList(i);
        }
        try {
            return this.yE.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.yD.getColorStateList(i);
        }
    }

    public void L(boolean z) {
        this.yB = z;
    }

    public void a(Resources resources) {
        this.yE = resources;
    }

    public void destroy() {
        if (this.yC != null) {
            this.yC.clear();
            this.yC = null;
        }
    }
}
