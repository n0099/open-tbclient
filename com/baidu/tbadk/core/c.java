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
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean SA = false;
    private static String SB = null;
    private static int SC = 0;
    private Resources Sy;
    private Resources Sz;
    private boolean isNightMode = false;
    Map<String, b> Sx = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cc;
        int g;
        boolean z = false;
        try {
            this.Sy = context.getResources();
            this.Sz = this.Sy;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cb(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cc2 = cc(attributeValue);
                    if (cc2 != null) {
                        bVar.bj(cc2[0]);
                        bVar.bk(cc2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cc3 = cc(attributeValue);
                    if (cc3 != null) {
                        bVar.bp(cc3[0]);
                        bVar.bq(cc3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cc4 = cc(attributeValue);
                    if (cc4 != null) {
                        bVar.bn(cc4[0]);
                        bVar.bo(cc4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cc5 = cc(attributeValue);
                    if (cc5 != null) {
                        bVar.bs(cc5[0]);
                        bVar.br(cc5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cc6 = cc(attributeValue);
                    if (cc6 != null) {
                        bVar.bf(cc6[0]);
                        bVar.bg(cc6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cc7 = cc(attributeValue);
                    if (cc7 != null) {
                        bVar.bd(cc7[0]);
                        bVar.be(cc7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cc8 = cc(attributeValue);
                    if (cc8 != null) {
                        bVar.bb(cc8[0]);
                        bVar.bc(cc8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cc9 = cc(attributeValue);
                    if (cc9 != null) {
                        bVar.bh(cc9[0]);
                        bVar.bi(cc9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cc10 = cc(attributeValue);
                    if (cc10 != null) {
                        bVar.bt(cc10[0]);
                        bVar.bu(cc10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cc = cc(attributeValue)) != null) {
                    bVar.bl(cc[0]);
                    bVar.bm(cc[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.ca(String.valueOf(attributeName) + "=" + this.Sy.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Sx != null && !this.Sx.containsKey(bVar.getId())) {
                    this.Sx.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.Sx.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] cc(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Sy, this.Sz, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (SA) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (SC == 0) {
                    SB = BdBaseApplication.getInst().getPackageName();
                    SC = SB.length();
                }
                if (resourceName.length() > SC && resourceName.charAt(SC) != ':' && resourceName.startsWith(SB)) {
                    resourceName = String.valueOf(SB) + resourceName.substring(resourceName.indexOf(":"));
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

    public void t(View view) {
        if (view != null) {
            Stack stack = new Stack();
            stack.push(view);
            while (!stack.isEmpty()) {
                View view2 = (View) stack.pop();
                if (view2 instanceof ViewGroup) {
                    a((ViewGroup) view2);
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

    private void a(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.Sx != null && this.Sx.containsKey(str)) {
            b bVar = this.Sx.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.oW() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.isNightMode, bVar.oV(), bVar.oW()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.pa() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Sy.getResourceTypeName(bVar.oZ());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.oZ(), bVar.pa()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.oZ(), bVar.pa()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void u(View view) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        String str = "@" + view.getId();
        if (this.Sx != null && this.Sx.containsKey(str)) {
            b bVar = this.Sx.get(str);
            if (view instanceof TextView) {
                if (bVar.pe() != 0) {
                    ((TextView) view).setTextColor(d(this.isNightMode, bVar.pd(), bVar.pe()));
                }
                if (bVar.pc() != 0) {
                    ((TextView) view).setHintTextColor(d(this.isNightMode, bVar.pb(), bVar.pc()));
                }
                if (bVar.ph() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.isNightMode ? bVar.ph() : bVar.pi());
                }
                if (bVar.oU() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.isNightMode, bVar.oT(), bVar.oU()), (Drawable) null, (Drawable) null);
                }
                if (bVar.oS() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.isNightMode, bVar.oR(), bVar.oS()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.oY() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.isNightMode, bVar.oX(), bVar.oY()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.pf() != 0 && (b3 = b(this.isNightMode, bVar.pg(), bVar.pf())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.pf() != 0 && (b2 = b(this.isNightMode, bVar.pg(), bVar.pf())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.pk() != 0 && (b = b(this.isNightMode, bVar.pj(), bVar.pk())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.pa() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Sy.getResourceTypeName(bVar.oZ());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.isNightMode, bVar.oZ(), bVar.pa()));
                } else {
                    view.setBackgroundDrawable(b(this.isNightMode, bVar.oZ(), bVar.pa()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return aq.getDrawable(i);
        }
        if (!z) {
            try {
                return this.Sy.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.Sz = this.Sy;
            i2 = a(this.Sy, this.Sz, i);
        }
        if (this.Sz == null) {
            try {
                return this.Sy.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.Sz.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Sy.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return aq.getColor(i);
        }
        if (!z) {
            return this.Sy.getColor(i);
        }
        if (i == i2) {
            this.Sz = this.Sy;
            i2 = a(this.Sy, this.Sz, i);
        }
        if (this.Sz == null) {
            return this.Sy.getColor(i);
        }
        try {
            return this.Sz.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Sy.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return aq.cN(i);
        }
        if (!z) {
            return this.Sy.getColorStateList(i);
        }
        if (i == i2) {
            this.Sz = this.Sy;
            i2 = a(this.Sy, this.Sz, i);
        }
        if (this.Sz == null) {
            return this.Sy.getColorStateList(i);
        }
        try {
            return this.Sz.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Sy.getColorStateList(i);
        }
    }

    public void aj(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.Sz = resources;
    }

    public void destroy() {
        if (this.Sx != null) {
            this.Sx.clear();
            this.Sx = null;
        }
    }
}
