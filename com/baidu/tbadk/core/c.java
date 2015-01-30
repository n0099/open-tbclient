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
    private boolean Cw = false;
    Map<String, b> Cx = new HashMap();
    private Resources Cy;
    private Resources Cz;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] bK;
        int i;
        boolean z = false;
        try {
            this.Cy = context.getResources();
            this.Cz = this.Cy;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.bJ(str);
            for (int i2 = 0; i2 < attributeCount; i2++) {
                String attributeName = attributeSet.getAttributeName(i2);
                String attributeValue = attributeSet.getAttributeValue(i2);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] bK2 = bK(attributeValue);
                    if (bK2 != null) {
                        bVar.aX(bK2[0]);
                        bVar.aY(bK2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] bK3 = bK(attributeValue);
                    if (bK3 != null) {
                        bVar.bd(bK3[0]);
                        bVar.be(bK3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] bK4 = bK(attributeValue);
                    if (bK4 != null) {
                        bVar.bb(bK4[0]);
                        bVar.bc(bK4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] bK5 = bK(attributeValue);
                    if (bK5 != null) {
                        bVar.bg(bK5[0]);
                        bVar.bf(bK5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] bK6 = bK(attributeValue);
                    if (bK6 != null) {
                        bVar.aT(bK6[0]);
                        bVar.aU(bK6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] bK7 = bK(attributeValue);
                    if (bK7 != null) {
                        bVar.aR(bK7[0]);
                        bVar.aS(bK7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] bK8 = bK(attributeValue);
                    if (bK8 != null) {
                        bVar.aP(bK8[0]);
                        bVar.aQ(bK8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] bK9 = bK(attributeValue);
                    if (bK9 != null) {
                        bVar.aV(bK9[0]);
                        bVar.aW(bK9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] bK10 = bK(attributeValue);
                    if (bK10 != null) {
                        bVar.bh(bK10[0]);
                        bVar.bi(bK10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (bK = bK(attributeValue)) != null) {
                    bVar.aZ(bK[0]);
                    bVar.ba(bK[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (i = com.baidu.adp.lib.g.c.toInt(attributeValue.substring(1), 0)) != 0) {
                    bVar.bI(String.valueOf(attributeName) + "=" + this.Cy.getResourceName(i));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Cx != null && !this.Cx.containsKey(bVar.getId())) {
                    this.Cx.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.Cx.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] bK(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Cy, this.Cz, parseInt)};
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
        if (this.Cx != null && this.Cx.containsKey(str)) {
            b bVar = this.Cx.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.lK() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.Cw, bVar.lJ(), bVar.lK()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.lO() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Cy.getResourceTypeName(bVar.lN());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.Cw, bVar.lN(), bVar.lO()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.Cw, bVar.lN(), bVar.lO()));
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
        if (this.Cx != null && this.Cx.containsKey(str)) {
            b bVar = this.Cx.get(str);
            if (view instanceof TextView) {
                if (bVar.lS() != 0) {
                    ((TextView) view).setTextColor(d(this.Cw, bVar.lR(), bVar.lS()));
                }
                if (bVar.lQ() != 0) {
                    ((TextView) view).setHintTextColor(d(this.Cw, bVar.lP(), bVar.lQ()));
                }
                if (bVar.lV() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.Cw ? bVar.lV() : bVar.lW());
                }
                if (bVar.lI() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.Cw, bVar.lH(), bVar.lI()), (Drawable) null, (Drawable) null);
                }
                if (bVar.lG() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.Cw, bVar.lF(), bVar.lG()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.lM() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.Cw, bVar.lL(), bVar.lM()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.lT() != 0 && (b3 = b(this.Cw, bVar.lU(), bVar.lT())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.lT() != 0 && (b2 = b(this.Cw, bVar.lU(), bVar.lT())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.lY() != 0 && (b = b(this.Cw, bVar.lX(), bVar.lY())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.lO() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Cy.getResourceTypeName(bVar.lN());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.Cw, bVar.lN(), bVar.lO()));
                } else {
                    view.setBackgroundDrawable(b(this.Cw, bVar.lN(), bVar.lO()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (!z) {
            return this.Cy.getDrawable(i);
        }
        if (i == i2) {
            this.Cz = this.Cy;
            i2 = a(this.Cy, this.Cz, i);
        }
        if (this.Cz == null) {
            return this.Cy.getDrawable(i);
        }
        try {
            return this.Cz.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            return this.Cy.getDrawable(i);
        }
    }

    private int c(boolean z, int i, int i2) {
        if (!z) {
            return this.Cy.getColor(i);
        }
        if (i == i2) {
            this.Cz = this.Cy;
            i2 = a(this.Cy, this.Cz, i);
        }
        if (this.Cz == null) {
            return this.Cy.getColor(i);
        }
        try {
            return this.Cz.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Cy.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (!z) {
            return this.Cy.getColorStateList(i);
        }
        if (i == i2) {
            this.Cz = this.Cy;
            i2 = a(this.Cy, this.Cz, i);
        }
        if (this.Cz == null) {
            return this.Cy.getColorStateList(i);
        }
        try {
            return this.Cz.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Cy.getColorStateList(i);
        }
    }

    public void ab(boolean z) {
        this.Cw = z;
    }

    public void a(Resources resources) {
        this.Cz = resources;
    }

    public void destroy() {
        if (this.Cx != null) {
            this.Cx.clear();
            this.Cx = null;
        }
    }
}
