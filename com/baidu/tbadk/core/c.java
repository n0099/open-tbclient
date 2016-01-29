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
import com.baidu.tbadk.core.util.ar;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean Tt = false;
    private static String Tu = null;
    private static int Tv = 0;
    private boolean Tp = false;
    Map<String, b> Tq = new HashMap();
    private Resources Tr;
    private Resources Ts;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cg;
        int g;
        boolean z = false;
        try {
            this.Tr = context.getResources();
            this.Ts = this.Tr;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cf(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cg2 = cg(attributeValue);
                    if (cg2 != null) {
                        bVar.bi(cg2[0]);
                        bVar.bj(cg2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cg3 = cg(attributeValue);
                    if (cg3 != null) {
                        bVar.bo(cg3[0]);
                        bVar.bp(cg3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cg4 = cg(attributeValue);
                    if (cg4 != null) {
                        bVar.bm(cg4[0]);
                        bVar.bn(cg4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cg5 = cg(attributeValue);
                    if (cg5 != null) {
                        bVar.br(cg5[0]);
                        bVar.bq(cg5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cg6 = cg(attributeValue);
                    if (cg6 != null) {
                        bVar.be(cg6[0]);
                        bVar.bf(cg6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cg7 = cg(attributeValue);
                    if (cg7 != null) {
                        bVar.bc(cg7[0]);
                        bVar.bd(cg7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cg8 = cg(attributeValue);
                    if (cg8 != null) {
                        bVar.ba(cg8[0]);
                        bVar.bb(cg8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cg9 = cg(attributeValue);
                    if (cg9 != null) {
                        bVar.bg(cg9[0]);
                        bVar.bh(cg9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cg10 = cg(attributeValue);
                    if (cg10 != null) {
                        bVar.bs(cg10[0]);
                        bVar.bt(cg10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cg = cg(attributeValue)) != null) {
                    bVar.bk(cg[0]);
                    bVar.bl(cg[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.h.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.ce(String.valueOf(attributeName) + "=" + this.Tr.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Tq != null && !this.Tq.containsKey(bVar.getId())) {
                    this.Tq.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.Tq.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] cg(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Tr, this.Ts, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (Tt) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (Tv == 0) {
                    Tu = BdBaseApplication.getInst().getPackageName();
                    Tv = Tu.length();
                }
                if (resourceName.length() > Tv && resourceName.charAt(Tv) != ':' && resourceName.startsWith(Tu)) {
                    resourceName = String.valueOf(Tu) + resourceName.substring(resourceName.indexOf(":"));
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

    public void x(View view) {
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
                    y(view2);
                }
            }
        }
    }

    private void c(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.Tq != null && this.Tq.containsKey(str)) {
            b bVar = this.Tq.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.qV() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.Tp, bVar.qU(), bVar.qV()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.qZ() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Tr.getResourceTypeName(bVar.qY());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.Tp, bVar.qY(), bVar.qZ()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.Tp, bVar.qY(), bVar.qZ()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void y(View view) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        String str = "@" + view.getId();
        if (this.Tq != null && this.Tq.containsKey(str)) {
            b bVar = this.Tq.get(str);
            if (view instanceof TextView) {
                if (bVar.rd() != 0) {
                    ((TextView) view).setTextColor(d(this.Tp, bVar.rc(), bVar.rd()));
                }
                if (bVar.rb() != 0) {
                    ((TextView) view).setHintTextColor(d(this.Tp, bVar.ra(), bVar.rb()));
                }
                if (bVar.rh() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.Tp ? bVar.rh() : bVar.ri());
                }
                if (bVar.qT() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.Tp, bVar.qS(), bVar.qT()), (Drawable) null, (Drawable) null);
                }
                if (bVar.qR() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.Tp, bVar.qQ(), bVar.qR()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.qX() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.Tp, bVar.qW(), bVar.qX()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.rf() != 0 && (b3 = b(this.Tp, bVar.rg(), bVar.rf())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.rf() != 0 && (b2 = b(this.Tp, bVar.rg(), bVar.rf())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.rk() != 0 && (b = b(this.Tp, bVar.rj(), bVar.rk())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.qZ() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Tr.getResourceTypeName(bVar.qY());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.Tp, bVar.qY(), bVar.qZ()));
                } else {
                    view.setBackgroundDrawable(b(this.Tp, bVar.qY(), bVar.qZ()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return ar.getDrawable(i);
        }
        if (!z) {
            try {
                return this.Tr.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.Ts = this.Tr;
            i2 = a(this.Tr, this.Ts, i);
        }
        if (this.Ts == null) {
            try {
                return this.Tr.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.Ts.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Tr.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        }
    }

    private int c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return ar.getColor(i);
        }
        if (!z) {
            return this.Tr.getColor(i);
        }
        if (i == i2) {
            this.Ts = this.Tr;
            i2 = a(this.Tr, this.Ts, i);
        }
        if (this.Ts == null) {
            return this.Tr.getColor(i);
        }
        try {
            return this.Ts.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Tr.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return ar.cN(i);
        }
        if (!z) {
            return this.Tr.getColorStateList(i);
        }
        if (i == i2) {
            this.Ts = this.Tr;
            i2 = a(this.Tr, this.Ts, i);
        }
        if (this.Ts == null) {
            return this.Tr.getColorStateList(i);
        }
        try {
            return this.Ts.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Tr.getColorStateList(i);
        }
    }

    public void ac(boolean z) {
        this.Tp = z;
    }

    public void b(Resources resources) {
        this.Ts = resources;
    }

    public void destroy() {
        if (this.Tq != null) {
            this.Tq.clear();
            this.Tq = null;
        }
    }
}
