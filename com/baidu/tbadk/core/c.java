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
    public static boolean RA = false;
    private static String RB = null;
    private static int RC = 0;
    private Resources Ry;
    private Resources Rz;
    private boolean isNightMode = false;
    Map<String, b> Rx = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] ci;
        int g;
        boolean z = false;
        try {
            this.Ry = context.getResources();
            this.Rz = this.Ry;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.ch(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] ci2 = ci(attributeValue);
                    if (ci2 != null) {
                        bVar.bh(ci2[0]);
                        bVar.bi(ci2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] ci3 = ci(attributeValue);
                    if (ci3 != null) {
                        bVar.bn(ci3[0]);
                        bVar.bo(ci3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] ci4 = ci(attributeValue);
                    if (ci4 != null) {
                        bVar.bl(ci4[0]);
                        bVar.bm(ci4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] ci5 = ci(attributeValue);
                    if (ci5 != null) {
                        bVar.bq(ci5[0]);
                        bVar.bp(ci5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] ci6 = ci(attributeValue);
                    if (ci6 != null) {
                        bVar.bd(ci6[0]);
                        bVar.be(ci6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] ci7 = ci(attributeValue);
                    if (ci7 != null) {
                        bVar.bb(ci7[0]);
                        bVar.bc(ci7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] ci8 = ci(attributeValue);
                    if (ci8 != null) {
                        bVar.aZ(ci8[0]);
                        bVar.ba(ci8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] ci9 = ci(attributeValue);
                    if (ci9 != null) {
                        bVar.bf(ci9[0]);
                        bVar.bg(ci9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] ci10 = ci(attributeValue);
                    if (ci10 != null) {
                        bVar.br(ci10[0]);
                        bVar.bs(ci10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (ci = ci(attributeValue)) != null) {
                    bVar.bj(ci[0]);
                    bVar.bk(ci[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.cg(String.valueOf(attributeName) + "=" + this.Ry.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Rx != null && !this.Rx.containsKey(bVar.getId())) {
                    this.Rx.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.Rx.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] ci(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Ry, this.Rz, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (RA) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (RC == 0) {
                    RB = BdBaseApplication.getInst().getPackageName();
                    RC = RB.length();
                }
                if (resourceName.length() > RC && resourceName.charAt(RC) != ':' && resourceName.startsWith(RB)) {
                    resourceName = String.valueOf(RB) + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.Rx != null && this.Rx.containsKey(str)) {
            b bVar = this.Rx.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.or() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.isNightMode, bVar.oq(), bVar.or()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.ov() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Ry.getResourceTypeName(bVar.ou());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.ou(), bVar.ov()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.ou(), bVar.ov()));
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
        if (this.Rx != null && this.Rx.containsKey(str)) {
            b bVar = this.Rx.get(str);
            if (view instanceof TextView) {
                if (bVar.oz() != 0) {
                    ((TextView) view).setTextColor(d(this.isNightMode, bVar.oy(), bVar.oz()));
                }
                if (bVar.ox() != 0) {
                    ((TextView) view).setHintTextColor(d(this.isNightMode, bVar.ow(), bVar.ox()));
                }
                if (bVar.oC() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.isNightMode ? bVar.oC() : bVar.oD());
                }
                if (bVar.op() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.isNightMode, bVar.oo(), bVar.op()), (Drawable) null, (Drawable) null);
                }
                if (bVar.on() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.isNightMode, bVar.om(), bVar.on()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.ot() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.isNightMode, bVar.os(), bVar.ot()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.oA() != 0 && (b3 = b(this.isNightMode, bVar.oB(), bVar.oA())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.oA() != 0 && (b2 = b(this.isNightMode, bVar.oB(), bVar.oA())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.oF() != 0 && (b = b(this.isNightMode, bVar.oE(), bVar.oF())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.ov() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Ry.getResourceTypeName(bVar.ou());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.isNightMode, bVar.ou(), bVar.ov()));
                } else {
                    view.setBackgroundDrawable(b(this.isNightMode, bVar.ou(), bVar.ov()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return as.getDrawable(i);
        }
        if (!z) {
            try {
                return this.Ry.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.Rz = this.Ry;
            i2 = a(this.Ry, this.Rz, i);
        }
        if (this.Rz == null) {
            try {
                return this.Ry.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.Rz.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Ry.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return as.getColor(i);
        }
        if (!z) {
            return this.Ry.getColor(i);
        }
        if (i == i2) {
            this.Rz = this.Ry;
            i2 = a(this.Ry, this.Rz, i);
        }
        if (this.Rz == null) {
            return this.Ry.getColor(i);
        }
        try {
            return this.Rz.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Ry.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return as.cN(i);
        }
        if (!z) {
            return this.Ry.getColorStateList(i);
        }
        if (i == i2) {
            this.Rz = this.Ry;
            i2 = a(this.Ry, this.Rz, i);
        }
        if (this.Rz == null) {
            return this.Ry.getColorStateList(i);
        }
        try {
            return this.Rz.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Ry.getColorStateList(i);
        }
    }

    public void ah(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.Rz = resources;
    }

    public void destroy() {
        if (this.Rx != null) {
            this.Rx.clear();
            this.Rx = null;
        }
    }
}
