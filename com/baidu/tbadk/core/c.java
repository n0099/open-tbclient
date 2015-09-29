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
    public static boolean Td = false;
    private static String Te = null;
    private static int Tf = 0;
    private boolean SZ = false;
    Map<String, b> Ta = new HashMap();
    private Resources Tb;
    private Resources Tc;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] ca;
        int g;
        boolean z = false;
        try {
            this.Tb = context.getResources();
            this.Tc = this.Tb;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.bZ(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] ca2 = ca(attributeValue);
                    if (ca2 != null) {
                        bVar.bb(ca2[0]);
                        bVar.bc(ca2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] ca3 = ca(attributeValue);
                    if (ca3 != null) {
                        bVar.bh(ca3[0]);
                        bVar.bi(ca3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] ca4 = ca(attributeValue);
                    if (ca4 != null) {
                        bVar.bf(ca4[0]);
                        bVar.bg(ca4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] ca5 = ca(attributeValue);
                    if (ca5 != null) {
                        bVar.bk(ca5[0]);
                        bVar.bj(ca5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] ca6 = ca(attributeValue);
                    if (ca6 != null) {
                        bVar.aX(ca6[0]);
                        bVar.aY(ca6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] ca7 = ca(attributeValue);
                    if (ca7 != null) {
                        bVar.aV(ca7[0]);
                        bVar.aW(ca7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] ca8 = ca(attributeValue);
                    if (ca8 != null) {
                        bVar.aT(ca8[0]);
                        bVar.aU(ca8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] ca9 = ca(attributeValue);
                    if (ca9 != null) {
                        bVar.aZ(ca9[0]);
                        bVar.ba(ca9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] ca10 = ca(attributeValue);
                    if (ca10 != null) {
                        bVar.bl(ca10[0]);
                        bVar.bm(ca10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (ca = ca(attributeValue)) != null) {
                    bVar.bd(ca[0]);
                    bVar.be(ca[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.bY(String.valueOf(attributeName) + "=" + this.Tb.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Ta != null && !this.Ta.containsKey(bVar.getId())) {
                    this.Ta.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.Ta.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] ca(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Tb, this.Tc, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (Td) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (Tf == 0) {
                    Te = BdBaseApplication.getInst().getPackageName();
                    Tf = Te.length();
                }
                if (resourceName.length() > Tf && resourceName.charAt(Tf) != ':' && resourceName.startsWith(Te)) {
                    resourceName = String.valueOf(Te) + resourceName.substring(resourceName.indexOf(":"));
                }
                String str2 = resourceName;
                i2 = resources2.getIdentifier(String.valueOf(resourceName) + "_1", null, null);
                str = str2;
            }
            if (i2 == 0) {
                BdLog.e(String.valueOf(str) + " 缺少夜间资源,使用了日间资源");
                return i;
            }
            return i2;
        }
        return i;
    }

    public void k(View view) {
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
                    l(view2);
                }
            }
        }
    }

    private void b(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.Ta != null && this.Ta.containsKey(str)) {
            b bVar = this.Ta.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.qF() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.SZ, bVar.qE(), bVar.qF()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.qJ() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Tb.getResourceTypeName(bVar.qI());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.SZ, bVar.qI(), bVar.qJ()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.SZ, bVar.qI(), bVar.qJ()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void l(View view) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        String str = "@" + view.getId();
        if (this.Ta != null && this.Ta.containsKey(str)) {
            b bVar = this.Ta.get(str);
            if (view instanceof TextView) {
                if (bVar.qN() != 0) {
                    ((TextView) view).setTextColor(d(this.SZ, bVar.qM(), bVar.qN()));
                }
                if (bVar.qL() != 0) {
                    ((TextView) view).setHintTextColor(d(this.SZ, bVar.qK(), bVar.qL()));
                }
                if (bVar.qQ() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.SZ ? bVar.qQ() : bVar.qR());
                }
                if (bVar.qD() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.SZ, bVar.qC(), bVar.qD()), (Drawable) null, (Drawable) null);
                }
                if (bVar.qB() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.SZ, bVar.qA(), bVar.qB()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.qH() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.SZ, bVar.qG(), bVar.qH()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.qO() != 0 && (b3 = b(this.SZ, bVar.qP(), bVar.qO())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.qO() != 0 && (b2 = b(this.SZ, bVar.qP(), bVar.qO())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.qT() != 0 && (b = b(this.SZ, bVar.qS(), bVar.qT())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.qJ() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Tb.getResourceTypeName(bVar.qI());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.SZ, bVar.qI(), bVar.qJ()));
                } else {
                    view.setBackgroundDrawable(b(this.SZ, bVar.qI(), bVar.qJ()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return am.getDrawable(i);
        }
        if (!z) {
            try {
                return this.Tb.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.Tc = this.Tb;
            i2 = a(this.Tb, this.Tc, i);
        }
        if (this.Tc == null) {
            try {
                return this.Tb.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.Tc.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Tb.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        }
    }

    private int c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return am.getColor(i);
        }
        if (!z) {
            return this.Tb.getColor(i);
        }
        if (i == i2) {
            this.Tc = this.Tb;
            i2 = a(this.Tb, this.Tc, i);
        }
        if (this.Tc == null) {
            return this.Tb.getColor(i);
        }
        try {
            return this.Tc.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Tb.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return am.cv(i);
        }
        if (!z) {
            return this.Tb.getColorStateList(i);
        }
        if (i == i2) {
            this.Tc = this.Tb;
            i2 = a(this.Tb, this.Tc, i);
        }
        if (this.Tc == null) {
            return this.Tb.getColorStateList(i);
        }
        try {
            return this.Tc.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Tb.getColorStateList(i);
        }
    }

    public void ad(boolean z) {
        this.SZ = z;
    }

    public void b(Resources resources) {
        this.Tc = resources;
    }

    public void destroy() {
        if (this.Ta != null) {
            this.Ta.clear();
            this.Ta = null;
        }
    }
}
