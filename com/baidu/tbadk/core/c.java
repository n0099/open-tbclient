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
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    private boolean Od = false;
    Map<String, b> Oe = new HashMap();
    private Resources Of;
    private Resources Og;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] bM;
        int i;
        boolean z = false;
        try {
            this.Of = context.getResources();
            this.Og = this.Of;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.bL(str);
            for (int i2 = 0; i2 < attributeCount; i2++) {
                String attributeName = attributeSet.getAttributeName(i2);
                String attributeValue = attributeSet.getAttributeValue(i2);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] bM2 = bM(attributeValue);
                    if (bM2 != null) {
                        bVar.aV(bM2[0]);
                        bVar.aW(bM2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] bM3 = bM(attributeValue);
                    if (bM3 != null) {
                        bVar.bb(bM3[0]);
                        bVar.bc(bM3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] bM4 = bM(attributeValue);
                    if (bM4 != null) {
                        bVar.aZ(bM4[0]);
                        bVar.ba(bM4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] bM5 = bM(attributeValue);
                    if (bM5 != null) {
                        bVar.be(bM5[0]);
                        bVar.bd(bM5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] bM6 = bM(attributeValue);
                    if (bM6 != null) {
                        bVar.aR(bM6[0]);
                        bVar.aS(bM6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] bM7 = bM(attributeValue);
                    if (bM7 != null) {
                        bVar.aP(bM7[0]);
                        bVar.aQ(bM7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] bM8 = bM(attributeValue);
                    if (bM8 != null) {
                        bVar.aN(bM8[0]);
                        bVar.aO(bM8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] bM9 = bM(attributeValue);
                    if (bM9 != null) {
                        bVar.aT(bM9[0]);
                        bVar.aU(bM9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] bM10 = bM(attributeValue);
                    if (bM10 != null) {
                        bVar.bf(bM10[0]);
                        bVar.bg(bM10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (bM = bM(attributeValue)) != null) {
                    bVar.aX(bM[0]);
                    bVar.aY(bM[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (i = com.baidu.adp.lib.g.c.toInt(attributeValue.substring(1), 0)) != 0) {
                    bVar.bK(String.valueOf(attributeName) + "=" + this.Of.getResourceName(i));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Oe != null && !this.Oe.containsKey(bVar.getId())) {
                    this.Oe.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.Oe.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] bM(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Of, this.Og, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String resourceName = resources.getResourceName(i);
        int i2 = 0;
        if (!TextUtils.isEmpty(resourceName)) {
            i2 = resources2.getIdentifier(String.valueOf(resourceName) + "_1", null, null);
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
                    c((ViewGroup) view2);
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

    private void c(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.Oe != null && this.Oe.containsKey(str)) {
            b bVar = this.Oe.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.pf() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.Od, bVar.pe(), bVar.pf()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.pj() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Of.getResourceTypeName(bVar.pi());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.Od, bVar.pi(), bVar.pj()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.Od, bVar.pi(), bVar.pj()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void i(View view) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        String str = "@" + view.getId();
        if (this.Oe != null && this.Oe.containsKey(str)) {
            b bVar = this.Oe.get(str);
            if (view instanceof TextView) {
                if (bVar.pn() != 0) {
                    ((TextView) view).setTextColor(d(this.Od, bVar.pm(), bVar.pn()));
                }
                if (bVar.pl() != 0) {
                    ((TextView) view).setHintTextColor(d(this.Od, bVar.pk(), bVar.pl()));
                }
                if (bVar.pq() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.Od ? bVar.pq() : bVar.pr());
                }
                if (bVar.pd() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.Od, bVar.pc(), bVar.pd()), (Drawable) null, (Drawable) null);
                }
                if (bVar.pb() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.Od, bVar.pa(), bVar.pb()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.ph() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.Od, bVar.pg(), bVar.ph()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.po() != 0 && (b3 = b(this.Od, bVar.pp(), bVar.po())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.po() != 0 && (b2 = b(this.Od, bVar.pp(), bVar.po())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.pt() != 0 && (b = b(this.Od, bVar.ps(), bVar.pt())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.pj() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Of.getResourceTypeName(bVar.pi());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.Od, bVar.pi(), bVar.pj()));
                } else {
                    view.setBackgroundDrawable(b(this.Od, bVar.pi(), bVar.pj()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (!z) {
            return this.Of.getDrawable(i);
        }
        if (i == i2) {
            this.Og = this.Of;
            i2 = a(this.Of, this.Og, i);
        }
        if (this.Og == null) {
            return this.Of.getDrawable(i);
        }
        try {
            return this.Og.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            return this.Of.getDrawable(i);
        }
    }

    private int c(boolean z, int i, int i2) {
        if (!z) {
            return this.Of.getColor(i);
        }
        if (i == i2) {
            this.Og = this.Of;
            i2 = a(this.Of, this.Og, i);
        }
        if (this.Og == null) {
            return this.Of.getColor(i);
        }
        try {
            return this.Og.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Of.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (!z) {
            return this.Of.getColorStateList(i);
        }
        if (i == i2) {
            this.Og = this.Of;
            i2 = a(this.Of, this.Og, i);
        }
        if (this.Og == null) {
            return this.Of.getColorStateList(i);
        }
        try {
            return this.Og.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Of.getColorStateList(i);
        }
    }

    public void X(boolean z) {
        this.Od = z;
    }

    public void a(Resources resources) {
        this.Og = resources;
    }

    public void destroy() {
        if (this.Oe != null) {
            this.Oe.clear();
            this.Oe = null;
        }
    }
}
