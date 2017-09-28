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
    public static boolean SD = false;
    private static String SE = null;
    private static int SF = 0;
    private Resources SB;
    private Resources SC;
    private boolean Sz = false;
    Map<String, b> SA = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cm;
        int g;
        boolean z = false;
        try {
            this.SB = context.getResources();
            this.SC = this.SB;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cl(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cm2 = cm(attributeValue);
                    if (cm2 != null) {
                        bVar.bm(cm2[0]);
                        bVar.bn(cm2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cm3 = cm(attributeValue);
                    if (cm3 != null) {
                        bVar.bs(cm3[0]);
                        bVar.bt(cm3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cm4 = cm(attributeValue);
                    if (cm4 != null) {
                        bVar.bq(cm4[0]);
                        bVar.br(cm4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cm5 = cm(attributeValue);
                    if (cm5 != null) {
                        bVar.bv(cm5[0]);
                        bVar.bu(cm5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cm6 = cm(attributeValue);
                    if (cm6 != null) {
                        bVar.bi(cm6[0]);
                        bVar.bj(cm6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cm7 = cm(attributeValue);
                    if (cm7 != null) {
                        bVar.bg(cm7[0]);
                        bVar.bh(cm7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cm8 = cm(attributeValue);
                    if (cm8 != null) {
                        bVar.be(cm8[0]);
                        bVar.bf(cm8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cm9 = cm(attributeValue);
                    if (cm9 != null) {
                        bVar.bk(cm9[0]);
                        bVar.bl(cm9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cm10 = cm(attributeValue);
                    if (cm10 != null) {
                        bVar.bw(cm10[0]);
                        bVar.bx(cm10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cm = cm(attributeValue)) != null) {
                    bVar.bo(cm[0]);
                    bVar.bp(cm[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.ck(attributeName + "=" + this.SB.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.SA != null && !this.SA.containsKey(bVar.getId())) {
                    this.SA.put(bVar.getId(), bVar);
                    return;
                }
                if (TextUtils.isEmpty(bVar.getId()) || this.SA.containsKey(bVar.getId())) {
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] cm(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.SB, this.SC, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (SD) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (SF == 0) {
                    SE = BdBaseApplication.getInst().getPackageName();
                    SF = SE.length();
                }
                if (resourceName.length() > SF && resourceName.charAt(SF) != ':' && resourceName.startsWith(SE)) {
                    resourceName = SE + resourceName.substring(resourceName.indexOf(":"));
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
                    b((ViewGroup) view2);
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

    private void b(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.SA != null && this.SA.containsKey(str)) {
            b bVar = this.SA.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.oA() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(a(this.Sz, bVar.oz(), bVar.oA()));
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
                String resourceTypeName = this.SB.getResourceTypeName(bVar.oD());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(b(this.Sz, bVar.oD(), bVar.oE()));
                } else {
                    viewGroup.setBackgroundDrawable(a(this.Sz, bVar.oD(), bVar.oE()));
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
        if (this.SA != null && this.SA.containsKey(str)) {
            b bVar = this.SA.get(str);
            if (view instanceof TextView) {
                if (bVar.oI() != 0) {
                    ((TextView) view).setTextColor(c(this.Sz, bVar.oH(), bVar.oI()));
                }
                if (bVar.oG() != 0) {
                    ((TextView) view).setHintTextColor(c(this.Sz, bVar.oF(), bVar.oG()));
                }
                if (bVar.oL() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.Sz) {
                        oM = bVar.oL();
                    } else {
                        oM = bVar.oM();
                    }
                    textView.setTextAppearance(context, oM);
                }
                if (bVar.oy() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, a(this.Sz, bVar.ox(), bVar.oy()), (Drawable) null, (Drawable) null);
                }
                if (bVar.ow() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(a(this.Sz, bVar.ov(), bVar.ow()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.oC() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a(this.Sz, bVar.oB(), bVar.oC()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.oJ() != 0 && (a3 = a(this.Sz, bVar.oK(), bVar.oJ())) != null) {
                    ((ImageView) view).setImageDrawable(a3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.oJ() != 0 && (a2 = a(this.Sz, bVar.oK(), bVar.oJ())) != null) {
                    ((ImageView) view).setImageDrawable(a2);
                }
            } else if ((view instanceof ProgressBar) && bVar.oO() != 0 && (a = a(this.Sz, bVar.oN(), bVar.oO())) != null) {
                ((ProgressBar) view).setProgressDrawable(a);
            }
            if (bVar.oE() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.SB.getResourceTypeName(bVar.oD());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(b(this.Sz, bVar.oD(), bVar.oE()));
                } else {
                    view.setBackgroundDrawable(a(this.Sz, bVar.oD(), bVar.oE()));
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
                return this.SB.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.SC = this.SB;
            i2 = a(this.SB, this.SC, i);
        }
        if (this.SC == null) {
            try {
                return this.SB.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.SC.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.SB.getDrawable(i);
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
            return this.SB.getColor(i);
        }
        if (i == i2) {
            this.SC = this.SB;
            i2 = a(this.SB, this.SC, i);
        }
        if (this.SC == null) {
            return this.SB.getColor(i);
        }
        try {
            return this.SC.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.SB.getColor(i);
        }
    }

    private ColorStateList c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return aj.cQ(i);
        }
        if (!z) {
            return this.SB.getColorStateList(i);
        }
        if (i == i2) {
            this.SC = this.SB;
            i2 = a(this.SB, this.SC, i);
        }
        if (this.SC == null) {
            return this.SB.getColorStateList(i);
        }
        try {
            return this.SC.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.SB.getColorStateList(i);
        }
    }

    public void ai(boolean z) {
        this.Sz = z;
    }

    public void b(Resources resources) {
        this.SC = resources;
    }

    public void destroy() {
        if (this.SA != null) {
            this.SA.clear();
            this.SA = null;
        }
    }
}
