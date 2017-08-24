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
import com.baidu.tbadk.core.util.ai;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean To = false;
    private static String Tp = null;
    private static int Tq = 0;
    private Resources Tm;
    private Resources Tn;
    private boolean isNightMode = false;
    Map<String, b> Tl = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cw;
        int g;
        boolean z = false;
        try {
            this.Tm = context.getResources();
            this.Tn = this.Tm;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cv(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cw2 = cw(attributeValue);
                    if (cw2 != null) {
                        bVar.bi(cw2[0]);
                        bVar.bj(cw2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cw3 = cw(attributeValue);
                    if (cw3 != null) {
                        bVar.bo(cw3[0]);
                        bVar.bp(cw3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cw4 = cw(attributeValue);
                    if (cw4 != null) {
                        bVar.bm(cw4[0]);
                        bVar.bn(cw4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cw5 = cw(attributeValue);
                    if (cw5 != null) {
                        bVar.br(cw5[0]);
                        bVar.bq(cw5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cw6 = cw(attributeValue);
                    if (cw6 != null) {
                        bVar.be(cw6[0]);
                        bVar.bf(cw6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cw7 = cw(attributeValue);
                    if (cw7 != null) {
                        bVar.bc(cw7[0]);
                        bVar.bd(cw7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cw8 = cw(attributeValue);
                    if (cw8 != null) {
                        bVar.ba(cw8[0]);
                        bVar.bb(cw8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cw9 = cw(attributeValue);
                    if (cw9 != null) {
                        bVar.bg(cw9[0]);
                        bVar.bh(cw9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cw10 = cw(attributeValue);
                    if (cw10 != null) {
                        bVar.bs(cw10[0]);
                        bVar.bt(cw10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cw = cw(attributeValue)) != null) {
                    bVar.bk(cw[0]);
                    bVar.bl(cw[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.cu(attributeName + "=" + this.Tm.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Tl != null && !this.Tl.containsKey(bVar.getId())) {
                    this.Tl.put(bVar.getId(), bVar);
                    return;
                }
                if (TextUtils.isEmpty(bVar.getId()) || this.Tl.containsKey(bVar.getId())) {
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] cw(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Tm, this.Tn, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (To) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (Tq == 0) {
                    Tp = BdBaseApplication.getInst().getPackageName();
                    Tq = Tp.length();
                }
                if (resourceName.length() > Tq && resourceName.charAt(Tq) != ':' && resourceName.startsWith(Tp)) {
                    resourceName = Tp + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.Tl != null && this.Tl.containsKey(str)) {
            b bVar = this.Tl.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.oF() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.isNightMode, bVar.oE(), bVar.oF()));
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
                String resourceTypeName = this.Tm.getResourceTypeName(bVar.oI());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.oI(), bVar.oJ()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.oI(), bVar.oJ()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void u(View view) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        int oR;
        String str = "@" + view.getId();
        if (this.Tl != null && this.Tl.containsKey(str)) {
            b bVar = this.Tl.get(str);
            if (view instanceof TextView) {
                if (bVar.oN() != 0) {
                    ((TextView) view).setTextColor(d(this.isNightMode, bVar.oM(), bVar.oN()));
                }
                if (bVar.oL() != 0) {
                    ((TextView) view).setHintTextColor(d(this.isNightMode, bVar.oK(), bVar.oL()));
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
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.isNightMode, bVar.oC(), bVar.oD()), (Drawable) null, (Drawable) null);
                }
                if (bVar.oB() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.isNightMode, bVar.oA(), bVar.oB()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.oH() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.isNightMode, bVar.oG(), bVar.oH()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.oO() != 0 && (b3 = b(this.isNightMode, bVar.oP(), bVar.oO())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.oO() != 0 && (b2 = b(this.isNightMode, bVar.oP(), bVar.oO())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.oT() != 0 && (b = b(this.isNightMode, bVar.oS(), bVar.oT())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.oJ() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Tm.getResourceTypeName(bVar.oI());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.isNightMode, bVar.oI(), bVar.oJ()));
                } else {
                    view.setBackgroundDrawable(b(this.isNightMode, bVar.oI(), bVar.oJ()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return ai.getDrawable(i);
        }
        if (!z) {
            try {
                return this.Tm.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.Tn = this.Tm;
            i2 = a(this.Tm, this.Tn, i);
        }
        if (this.Tn == null) {
            try {
                return this.Tm.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.Tn.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Tm.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return ai.getColor(i);
        }
        if (!z) {
            return this.Tm.getColor(i);
        }
        if (i == i2) {
            this.Tn = this.Tm;
            i2 = a(this.Tm, this.Tn, i);
        }
        if (this.Tn == null) {
            return this.Tm.getColor(i);
        }
        try {
            return this.Tn.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Tm.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return ai.cR(i);
        }
        if (!z) {
            return this.Tm.getColorStateList(i);
        }
        if (i == i2) {
            this.Tn = this.Tm;
            i2 = a(this.Tm, this.Tn, i);
        }
        if (this.Tn == null) {
            return this.Tm.getColorStateList(i);
        }
        try {
            return this.Tn.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Tm.getColorStateList(i);
        }
    }

    public void ah(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.Tn = resources;
    }

    public void destroy() {
        if (this.Tl != null) {
            this.Tl.clear();
            this.Tl = null;
        }
    }
}
