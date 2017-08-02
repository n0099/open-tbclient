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
    public static boolean RO = false;
    private static String RP = null;
    private static int RQ = 0;
    private Resources RL;
    private Resources RM;
    private boolean isNightMode = false;
    Map<String, b> RK = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cn;
        int g;
        boolean z = false;
        try {
            this.RL = context.getResources();
            this.RM = this.RL;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cm(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cn2 = cn(attributeValue);
                    if (cn2 != null) {
                        bVar.bg(cn2[0]);
                        bVar.bh(cn2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cn3 = cn(attributeValue);
                    if (cn3 != null) {
                        bVar.bm(cn3[0]);
                        bVar.bn(cn3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cn4 = cn(attributeValue);
                    if (cn4 != null) {
                        bVar.bk(cn4[0]);
                        bVar.bl(cn4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cn5 = cn(attributeValue);
                    if (cn5 != null) {
                        bVar.bp(cn5[0]);
                        bVar.bo(cn5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cn6 = cn(attributeValue);
                    if (cn6 != null) {
                        bVar.bc(cn6[0]);
                        bVar.bd(cn6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cn7 = cn(attributeValue);
                    if (cn7 != null) {
                        bVar.ba(cn7[0]);
                        bVar.bb(cn7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cn8 = cn(attributeValue);
                    if (cn8 != null) {
                        bVar.aY(cn8[0]);
                        bVar.aZ(cn8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cn9 = cn(attributeValue);
                    if (cn9 != null) {
                        bVar.be(cn9[0]);
                        bVar.bf(cn9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cn10 = cn(attributeValue);
                    if (cn10 != null) {
                        bVar.bq(cn10[0]);
                        bVar.br(cn10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cn = cn(attributeValue)) != null) {
                    bVar.bi(cn[0]);
                    bVar.bj(cn[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.cl(attributeName + "=" + this.RL.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.RK != null && !this.RK.containsKey(bVar.getId())) {
                    this.RK.put(bVar.getId(), bVar);
                    return;
                }
                if (TextUtils.isEmpty(bVar.getId()) || this.RK.containsKey(bVar.getId())) {
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] cn(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.RL, this.RM, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (RO) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (RQ == 0) {
                    RP = BdBaseApplication.getInst().getPackageName();
                    RQ = RP.length();
                }
                if (resourceName.length() > RQ && resourceName.charAt(RQ) != ':' && resourceName.startsWith(RP)) {
                    resourceName = RP + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.RK != null && this.RK.containsKey(str)) {
            b bVar = this.RK.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.ou() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.isNightMode, bVar.ot(), bVar.ou()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.oy() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.RL.getResourceTypeName(bVar.ox());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.ox(), bVar.oy()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.ox(), bVar.oy()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void u(View view) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        int oG;
        String str = "@" + view.getId();
        if (this.RK != null && this.RK.containsKey(str)) {
            b bVar = this.RK.get(str);
            if (view instanceof TextView) {
                if (bVar.oC() != 0) {
                    ((TextView) view).setTextColor(d(this.isNightMode, bVar.oB(), bVar.oC()));
                }
                if (bVar.oA() != 0) {
                    ((TextView) view).setHintTextColor(d(this.isNightMode, bVar.oz(), bVar.oA()));
                }
                if (bVar.oF() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.isNightMode) {
                        oG = bVar.oF();
                    } else {
                        oG = bVar.oG();
                    }
                    textView.setTextAppearance(context, oG);
                }
                if (bVar.os() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.isNightMode, bVar.or(), bVar.os()), (Drawable) null, (Drawable) null);
                }
                if (bVar.oq() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.isNightMode, bVar.op(), bVar.oq()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.ow() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.isNightMode, bVar.ov(), bVar.ow()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.oD() != 0 && (b3 = b(this.isNightMode, bVar.oE(), bVar.oD())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.oD() != 0 && (b2 = b(this.isNightMode, bVar.oE(), bVar.oD())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.oI() != 0 && (b = b(this.isNightMode, bVar.oH(), bVar.oI())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.oy() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.RL.getResourceTypeName(bVar.ox());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.isNightMode, bVar.ox(), bVar.oy()));
                } else {
                    view.setBackgroundDrawable(b(this.isNightMode, bVar.ox(), bVar.oy()));
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
                return this.RL.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.RM = this.RL;
            i2 = a(this.RL, this.RM, i);
        }
        if (this.RM == null) {
            try {
                return this.RL.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.RM.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.RL.getDrawable(i);
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
            return this.RL.getColor(i);
        }
        if (i == i2) {
            this.RM = this.RL;
            i2 = a(this.RL, this.RM, i);
        }
        if (this.RM == null) {
            return this.RL.getColor(i);
        }
        try {
            return this.RM.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.RL.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return ai.cP(i);
        }
        if (!z) {
            return this.RL.getColorStateList(i);
        }
        if (i == i2) {
            this.RM = this.RL;
            i2 = a(this.RL, this.RM, i);
        }
        if (this.RM == null) {
            return this.RL.getColorStateList(i);
        }
        try {
            return this.RM.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.RL.getColorStateList(i);
        }
    }

    public void ah(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.RM = resources;
    }

    public void destroy() {
        if (this.RK != null) {
            this.RK.clear();
            this.RK = null;
        }
    }
}
