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
    public static boolean SK = false;
    private static String SL = null;
    private static int SM = 0;
    private boolean SF = false;
    Map<String, b> SG = new HashMap();
    private Resources SH;
    private Resources SJ;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cr;
        int g;
        boolean z = false;
        try {
            this.SH = context.getResources();
            this.SJ = this.SH;
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
                        bVar.bk(cr2[0]);
                        bVar.bl(cr2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cr3 = cr(attributeValue);
                    if (cr3 != null) {
                        bVar.bq(cr3[0]);
                        bVar.br(cr3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cr4 = cr(attributeValue);
                    if (cr4 != null) {
                        bVar.bo(cr4[0]);
                        bVar.bp(cr4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cr5 = cr(attributeValue);
                    if (cr5 != null) {
                        bVar.bt(cr5[0]);
                        bVar.bs(cr5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cr6 = cr(attributeValue);
                    if (cr6 != null) {
                        bVar.bg(cr6[0]);
                        bVar.bh(cr6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cr7 = cr(attributeValue);
                    if (cr7 != null) {
                        bVar.be(cr7[0]);
                        bVar.bf(cr7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cr8 = cr(attributeValue);
                    if (cr8 != null) {
                        bVar.bc(cr8[0]);
                        bVar.bd(cr8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cr9 = cr(attributeValue);
                    if (cr9 != null) {
                        bVar.bi(cr9[0]);
                        bVar.bj(cr9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cr10 = cr(attributeValue);
                    if (cr10 != null) {
                        bVar.bu(cr10[0]);
                        bVar.bv(cr10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cr = cr(attributeValue)) != null) {
                    bVar.bm(cr[0]);
                    bVar.bn(cr[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.cp(attributeName + "=" + this.SH.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.SG != null && !this.SG.containsKey(bVar.getId())) {
                    this.SG.put(bVar.getId(), bVar);
                    return;
                }
                if (TextUtils.isEmpty(bVar.getId()) || this.SG.containsKey(bVar.getId())) {
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
            return new int[]{parseInt, a(this.SH, this.SJ, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (SK) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (SM == 0) {
                    SL = BdBaseApplication.getInst().getPackageName();
                    SM = SL.length();
                }
                if (resourceName.length() > SM && resourceName.charAt(SM) != ':' && resourceName.startsWith(SL)) {
                    resourceName = SL + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.SG != null && this.SG.containsKey(str)) {
            b bVar = this.SG.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.oA() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(a(this.SF, bVar.oz(), bVar.oA()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.oE() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.SH.getResourceTypeName(bVar.oD());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(b(this.SF, bVar.oD(), bVar.oE()));
                } else {
                    viewGroup.setBackgroundDrawable(a(this.SF, bVar.oD(), bVar.oE()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void u(View view) {
        Drawable a;
        Drawable a2;
        Drawable a3;
        int oM;
        String str = "@" + view.getId();
        if (this.SG != null && this.SG.containsKey(str)) {
            b bVar = this.SG.get(str);
            if (view instanceof TextView) {
                if (bVar.oI() != 0) {
                    ((TextView) view).setTextColor(c(this.SF, bVar.oH(), bVar.oI()));
                }
                if (bVar.oG() != 0) {
                    ((TextView) view).setHintTextColor(c(this.SF, bVar.oF(), bVar.oG()));
                }
                if (bVar.oL() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.SF) {
                        oM = bVar.oL();
                    } else {
                        oM = bVar.oM();
                    }
                    textView.setTextAppearance(context, oM);
                }
                if (bVar.oy() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, a(this.SF, bVar.ox(), bVar.oy()), (Drawable) null, (Drawable) null);
                }
                if (bVar.ow() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(a(this.SF, bVar.ov(), bVar.ow()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.oC() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a(this.SF, bVar.oB(), bVar.oC()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.oJ() != 0 && (a3 = a(this.SF, bVar.oK(), bVar.oJ())) != null) {
                    ((ImageView) view).setImageDrawable(a3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.oJ() != 0 && (a2 = a(this.SF, bVar.oK(), bVar.oJ())) != null) {
                    ((ImageView) view).setImageDrawable(a2);
                }
            } else if ((view instanceof ProgressBar) && bVar.oO() != 0 && (a = a(this.SF, bVar.oN(), bVar.oO())) != null) {
                ((ProgressBar) view).setProgressDrawable(a);
            }
            if (bVar.oE() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.SH.getResourceTypeName(bVar.oD());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(b(this.SF, bVar.oD(), bVar.oE()));
                } else {
                    view.setBackgroundDrawable(a(this.SF, bVar.oD(), bVar.oE()));
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
                return this.SH.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.SJ = this.SH;
            i2 = a(this.SH, this.SJ, i);
        }
        if (this.SJ == null) {
            try {
                return this.SH.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.SJ.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.SH.getDrawable(i);
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
            return this.SH.getColor(i);
        }
        if (i == i2) {
            this.SJ = this.SH;
            i2 = a(this.SH, this.SJ, i);
        }
        if (this.SJ == null) {
            return this.SH.getColor(i);
        }
        try {
            return this.SJ.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.SH.getColor(i);
        }
    }

    private ColorStateList c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return aj.cQ(i);
        }
        if (!z) {
            return this.SH.getColorStateList(i);
        }
        if (i == i2) {
            this.SJ = this.SH;
            i2 = a(this.SH, this.SJ, i);
        }
        if (this.SJ == null) {
            return this.SH.getColorStateList(i);
        }
        try {
            return this.SJ.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.SH.getColorStateList(i);
        }
    }

    public void ag(boolean z) {
        this.SF = z;
    }

    public void b(Resources resources) {
        this.SJ = resources;
    }

    public void destroy() {
        if (this.SG != null) {
            this.SG.clear();
            this.SG = null;
        }
    }
}
