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
import com.baidu.tbadk.core.util.aj;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean Tp = false;
    private static String Tq = null;
    private static int Tr = 0;
    private Resources Tn;
    private Resources To;
    private boolean isNightMode = false;
    Map<String, b> Tm = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cr;
        int g;
        boolean z = false;
        try {
            this.Tn = context.getResources();
            this.To = this.Tn;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cq(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cr2 = cr(attributeValue);
                    if (cr2 != null) {
                        bVar.bl(cr2[0]);
                        bVar.bm(cr2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cr3 = cr(attributeValue);
                    if (cr3 != null) {
                        bVar.br(cr3[0]);
                        bVar.bs(cr3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cr4 = cr(attributeValue);
                    if (cr4 != null) {
                        bVar.bp(cr4[0]);
                        bVar.bq(cr4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cr5 = cr(attributeValue);
                    if (cr5 != null) {
                        bVar.bu(cr5[0]);
                        bVar.bt(cr5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cr6 = cr(attributeValue);
                    if (cr6 != null) {
                        bVar.bh(cr6[0]);
                        bVar.bi(cr6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cr7 = cr(attributeValue);
                    if (cr7 != null) {
                        bVar.bf(cr7[0]);
                        bVar.bg(cr7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cr8 = cr(attributeValue);
                    if (cr8 != null) {
                        bVar.bd(cr8[0]);
                        bVar.be(cr8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cr9 = cr(attributeValue);
                    if (cr9 != null) {
                        bVar.bj(cr9[0]);
                        bVar.bk(cr9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cr10 = cr(attributeValue);
                    if (cr10 != null) {
                        bVar.bv(cr10[0]);
                        bVar.bw(cr10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cr = cr(attributeValue)) != null) {
                    bVar.bn(cr[0]);
                    bVar.bo(cr[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.cp(attributeName + "=" + this.Tn.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Tm != null && !this.Tm.containsKey(bVar.getId())) {
                    this.Tm.put(bVar.getId(), bVar);
                    return;
                }
                if (TextUtils.isEmpty(bVar.getId()) || this.Tm.containsKey(bVar.getId())) {
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] cr(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Tn, this.To, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (Tp) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (Tr == 0) {
                    Tq = BdBaseApplication.getInst().getPackageName();
                    Tr = Tq.length();
                }
                if (resourceName.length() > Tr && resourceName.charAt(Tr) != ':' && resourceName.startsWith(Tq)) {
                    resourceName = Tq + resourceName.substring(resourceName.indexOf(":"));
                }
                String str2 = resourceName;
                i2 = resources2.getIdentifier(resourceName + "_1", null, null);
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

    public void t(View view) {
        if (view != null) {
            Stack stack = new Stack();
            stack.push(view);
            while (!stack.isEmpty()) {
                View view2 = (View) stack.pop();
                if (view2 instanceof ViewGroup) {
                    c((ViewGroup) view2);
                    if (!(view2 instanceof AdapterView)) {
                        int childCount = ((ViewGroup) view2).getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            stack.push(((ViewGroup) view2).getChildAt(i));
                        }
                    }
                } else {
                    u(view2);
                }
            }
        }
    }

    private void c(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.Tm != null && this.Tm.containsKey(str)) {
            b bVar = this.Tm.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.oF() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(a(this.isNightMode, bVar.oE(), bVar.oF()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.oJ() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Tn.getResourceTypeName(bVar.oI());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(b(this.isNightMode, bVar.oI(), bVar.oJ()));
                } else {
                    viewGroup.setBackgroundDrawable(a(this.isNightMode, bVar.oI(), bVar.oJ()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void u(View view) {
        Drawable a;
        Drawable a2;
        Drawable a3;
        int oR;
        String str = "@" + view.getId();
        if (this.Tm != null && this.Tm.containsKey(str)) {
            b bVar = this.Tm.get(str);
            if (view instanceof TextView) {
                if (bVar.oN() != 0) {
                    ((TextView) view).setTextColor(c(this.isNightMode, bVar.oM(), bVar.oN()));
                }
                if (bVar.oL() != 0) {
                    ((TextView) view).setHintTextColor(c(this.isNightMode, bVar.oK(), bVar.oL()));
                }
                if (bVar.oQ() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.isNightMode) {
                        oR = bVar.oQ();
                    } else {
                        oR = bVar.oR();
                    }
                    textView.setTextAppearance(context, oR);
                }
                if (bVar.oD() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, a(this.isNightMode, bVar.oC(), bVar.oD()), (Drawable) null, (Drawable) null);
                }
                if (bVar.oB() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(a(this.isNightMode, bVar.oA(), bVar.oB()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.oH() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a(this.isNightMode, bVar.oG(), bVar.oH()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.oO() != 0 && (a3 = a(this.isNightMode, bVar.oP(), bVar.oO())) != null) {
                    ((ImageView) view).setImageDrawable(a3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.oO() != 0 && (a2 = a(this.isNightMode, bVar.oP(), bVar.oO())) != null) {
                    ((ImageView) view).setImageDrawable(a2);
                }
            } else if ((view instanceof ProgressBar) && bVar.oT() != 0 && (a = a(this.isNightMode, bVar.oS(), bVar.oT())) != null) {
                ((ProgressBar) view).setProgressDrawable(a);
            }
            if (bVar.oJ() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Tn.getResourceTypeName(bVar.oI());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(b(this.isNightMode, bVar.oI(), bVar.oJ()));
                } else {
                    view.setBackgroundDrawable(a(this.isNightMode, bVar.oI(), bVar.oJ()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable a(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return aj.getDrawable(i);
        }
        if (!z) {
            try {
                return this.Tn.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.To = this.Tn;
            i2 = a(this.Tn, this.To, i);
        }
        if (this.To == null) {
            try {
                return this.Tn.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.To.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Tn.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return aj.getColor(i);
        }
        if (!z) {
            return this.Tn.getColor(i);
        }
        if (i == i2) {
            this.To = this.Tn;
            i2 = a(this.Tn, this.To, i);
        }
        if (this.To == null) {
            return this.Tn.getColor(i);
        }
        try {
            return this.To.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Tn.getColor(i);
        }
    }

    private ColorStateList c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return aj.cQ(i);
        }
        if (!z) {
            return this.Tn.getColorStateList(i);
        }
        if (i == i2) {
            this.To = this.Tn;
            i2 = a(this.Tn, this.To, i);
        }
        if (this.To == null) {
            return this.Tn.getColorStateList(i);
        }
        try {
            return this.To.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Tn.getColorStateList(i);
        }
    }

    public void ag(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.To = resources;
    }

    public void destroy() {
        if (this.Tm != null) {
            this.Tm.clear();
            this.Tm = null;
        }
    }
}
