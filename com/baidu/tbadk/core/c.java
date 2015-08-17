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
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean Tq = false;
    private static String Tr = null;
    private static int Ts = 0;
    private boolean Tm = false;
    Map<String, b> Tn = new HashMap();
    private Resources To;
    private Resources Tp;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] bZ;
        int g;
        boolean z = false;
        try {
            this.To = context.getResources();
            this.Tp = this.To;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.bY(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] bZ2 = bZ(attributeValue);
                    if (bZ2 != null) {
                        bVar.bb(bZ2[0]);
                        bVar.bc(bZ2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] bZ3 = bZ(attributeValue);
                    if (bZ3 != null) {
                        bVar.bh(bZ3[0]);
                        bVar.bi(bZ3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] bZ4 = bZ(attributeValue);
                    if (bZ4 != null) {
                        bVar.bf(bZ4[0]);
                        bVar.bg(bZ4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] bZ5 = bZ(attributeValue);
                    if (bZ5 != null) {
                        bVar.bk(bZ5[0]);
                        bVar.bj(bZ5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] bZ6 = bZ(attributeValue);
                    if (bZ6 != null) {
                        bVar.aX(bZ6[0]);
                        bVar.aY(bZ6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] bZ7 = bZ(attributeValue);
                    if (bZ7 != null) {
                        bVar.aV(bZ7[0]);
                        bVar.aW(bZ7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] bZ8 = bZ(attributeValue);
                    if (bZ8 != null) {
                        bVar.aT(bZ8[0]);
                        bVar.aU(bZ8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] bZ9 = bZ(attributeValue);
                    if (bZ9 != null) {
                        bVar.aZ(bZ9[0]);
                        bVar.ba(bZ9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] bZ10 = bZ(attributeValue);
                    if (bZ10 != null) {
                        bVar.bl(bZ10[0]);
                        bVar.bm(bZ10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (bZ = bZ(attributeValue)) != null) {
                    bVar.bd(bZ[0]);
                    bVar.be(bZ[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.bX(String.valueOf(attributeName) + "=" + this.To.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Tn != null && !this.Tn.containsKey(bVar.getId())) {
                    this.Tn.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.Tn.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] bZ(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.To, this.Tp, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (Tq) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (Ts == 0) {
                    Tr = BdBaseApplication.getInst().getPackageName();
                    Ts = Tr.length();
                }
                if (resourceName.length() > Ts && resourceName.charAt(Ts) != ':' && resourceName.startsWith(Tr)) {
                    resourceName = String.valueOf(Tr) + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.Tn != null && this.Tn.containsKey(str)) {
            b bVar = this.Tn.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.qL() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.Tm, bVar.qK(), bVar.qL()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.qP() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.To.getResourceTypeName(bVar.qO());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.Tm, bVar.qO(), bVar.qP()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.Tm, bVar.qO(), bVar.qP()));
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
        if (this.Tn != null && this.Tn.containsKey(str)) {
            b bVar = this.Tn.get(str);
            if (view instanceof TextView) {
                if (bVar.qT() != 0) {
                    ((TextView) view).setTextColor(d(this.Tm, bVar.qS(), bVar.qT()));
                }
                if (bVar.qR() != 0) {
                    ((TextView) view).setHintTextColor(d(this.Tm, bVar.qQ(), bVar.qR()));
                }
                if (bVar.qW() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.Tm ? bVar.qW() : bVar.qX());
                }
                if (bVar.qJ() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.Tm, bVar.qI(), bVar.qJ()), (Drawable) null, (Drawable) null);
                }
                if (bVar.qH() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.Tm, bVar.qG(), bVar.qH()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.qN() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.Tm, bVar.qM(), bVar.qN()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.qU() != 0 && (b3 = b(this.Tm, bVar.qV(), bVar.qU())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.qU() != 0 && (b2 = b(this.Tm, bVar.qV(), bVar.qU())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.qZ() != 0 && (b = b(this.Tm, bVar.qY(), bVar.qZ())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.qP() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.To.getResourceTypeName(bVar.qO());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.Tm, bVar.qO(), bVar.qP()));
                } else {
                    view.setBackgroundDrawable(b(this.Tm, bVar.qO(), bVar.qP()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (!z) {
            return this.To.getDrawable(i);
        }
        if (i == i2) {
            this.Tp = this.To;
            i2 = a(this.To, this.Tp, i);
        }
        if (this.Tp == null) {
            return this.To.getDrawable(i);
        }
        try {
            return this.Tp.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            return this.To.getDrawable(i);
        }
    }

    private int c(boolean z, int i, int i2) {
        if (!z) {
            return this.To.getColor(i);
        }
        if (i == i2) {
            this.Tp = this.To;
            i2 = a(this.To, this.Tp, i);
        }
        if (this.Tp == null) {
            return this.To.getColor(i);
        }
        try {
            return this.Tp.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.To.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (!z) {
            return this.To.getColorStateList(i);
        }
        if (i == i2) {
            this.Tp = this.To;
            i2 = a(this.To, this.Tp, i);
        }
        if (this.Tp == null) {
            return this.To.getColorStateList(i);
        }
        try {
            return this.Tp.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.To.getColorStateList(i);
        }
    }

    public void ad(boolean z) {
        this.Tm = z;
    }

    public void b(Resources resources) {
        this.Tp = resources;
    }

    public void destroy() {
        if (this.Tn != null) {
            this.Tn.clear();
            this.Tn = null;
        }
    }
}
