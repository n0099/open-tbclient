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
import com.baidu.tbadk.core.util.as;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean Tu = false;
    private static String Tv = null;
    private static int Tw = 0;
    private boolean Tq = false;
    Map<String, b> Tr = new HashMap();
    private Resources Ts;
    private Resources Tt;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cf;
        int g;
        boolean z = false;
        try {
            this.Ts = context.getResources();
            this.Tt = this.Ts;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.ce(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cf2 = cf(attributeValue);
                    if (cf2 != null) {
                        bVar.bd(cf2[0]);
                        bVar.be(cf2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cf3 = cf(attributeValue);
                    if (cf3 != null) {
                        bVar.bj(cf3[0]);
                        bVar.bk(cf3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cf4 = cf(attributeValue);
                    if (cf4 != null) {
                        bVar.bh(cf4[0]);
                        bVar.bi(cf4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cf5 = cf(attributeValue);
                    if (cf5 != null) {
                        bVar.bm(cf5[0]);
                        bVar.bl(cf5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cf6 = cf(attributeValue);
                    if (cf6 != null) {
                        bVar.aZ(cf6[0]);
                        bVar.ba(cf6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cf7 = cf(attributeValue);
                    if (cf7 != null) {
                        bVar.aX(cf7[0]);
                        bVar.aY(cf7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cf8 = cf(attributeValue);
                    if (cf8 != null) {
                        bVar.aV(cf8[0]);
                        bVar.aW(cf8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cf9 = cf(attributeValue);
                    if (cf9 != null) {
                        bVar.bb(cf9[0]);
                        bVar.bc(cf9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cf10 = cf(attributeValue);
                    if (cf10 != null) {
                        bVar.bn(cf10[0]);
                        bVar.bo(cf10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cf = cf(attributeValue)) != null) {
                    bVar.bf(cf[0]);
                    bVar.bg(cf[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.h.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.cd(String.valueOf(attributeName) + "=" + this.Ts.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Tr != null && !this.Tr.containsKey(bVar.getId())) {
                    this.Tr.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.Tr.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] cf(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Ts, this.Tt, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (Tu) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (Tw == 0) {
                    Tv = BdBaseApplication.getInst().getPackageName();
                    Tw = Tv.length();
                }
                if (resourceName.length() > Tw && resourceName.charAt(Tw) != ':' && resourceName.startsWith(Tv)) {
                    resourceName = String.valueOf(Tv) + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.Tr != null && this.Tr.containsKey(str)) {
            b bVar = this.Tr.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.qP() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.Tq, bVar.qO(), bVar.qP()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.qT() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Ts.getResourceTypeName(bVar.qS());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.Tq, bVar.qS(), bVar.qT()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.Tq, bVar.qS(), bVar.qT()));
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
        if (this.Tr != null && this.Tr.containsKey(str)) {
            b bVar = this.Tr.get(str);
            if (view instanceof TextView) {
                if (bVar.qX() != 0) {
                    ((TextView) view).setTextColor(d(this.Tq, bVar.qW(), bVar.qX()));
                }
                if (bVar.qV() != 0) {
                    ((TextView) view).setHintTextColor(d(this.Tq, bVar.qU(), bVar.qV()));
                }
                if (bVar.ra() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.Tq ? bVar.ra() : bVar.rb());
                }
                if (bVar.qN() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.Tq, bVar.qM(), bVar.qN()), (Drawable) null, (Drawable) null);
                }
                if (bVar.qL() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.Tq, bVar.qK(), bVar.qL()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.qR() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.Tq, bVar.qQ(), bVar.qR()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.qY() != 0 && (b3 = b(this.Tq, bVar.qZ(), bVar.qY())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.qY() != 0 && (b2 = b(this.Tq, bVar.qZ(), bVar.qY())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.rd() != 0 && (b = b(this.Tq, bVar.rc(), bVar.rd())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.qT() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Ts.getResourceTypeName(bVar.qS());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.Tq, bVar.qS(), bVar.qT()));
                } else {
                    view.setBackgroundDrawable(b(this.Tq, bVar.qS(), bVar.qT()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return as.getDrawable(i);
        }
        if (!z) {
            try {
                return this.Ts.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.Tt = this.Ts;
            i2 = a(this.Ts, this.Tt, i);
        }
        if (this.Tt == null) {
            try {
                return this.Ts.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.Tt.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Ts.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        }
    }

    private int c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return as.getColor(i);
        }
        if (!z) {
            return this.Ts.getColor(i);
        }
        if (i == i2) {
            this.Tt = this.Ts;
            i2 = a(this.Ts, this.Tt, i);
        }
        if (this.Tt == null) {
            return this.Ts.getColor(i);
        }
        try {
            return this.Tt.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Ts.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return as.cD(i);
        }
        if (!z) {
            return this.Ts.getColorStateList(i);
        }
        if (i == i2) {
            this.Tt = this.Ts;
            i2 = a(this.Ts, this.Tt, i);
        }
        if (this.Tt == null) {
            return this.Ts.getColorStateList(i);
        }
        try {
            return this.Tt.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Ts.getColorStateList(i);
        }
    }

    public void af(boolean z) {
        this.Tq = z;
    }

    public void b(Resources resources) {
        this.Tt = resources;
    }

    public void destroy() {
        if (this.Tr != null) {
            this.Tr.clear();
            this.Tr = null;
        }
    }
}
