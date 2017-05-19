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
    public static boolean RU = false;
    private static String RV = null;
    private static int RW = 0;
    private Resources RS;
    private Resources RT;
    private boolean isNightMode = false;
    Map<String, b> RR = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cc;
        int g;
        boolean z = false;
        try {
            this.RS = context.getResources();
            this.RT = this.RS;
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
                        bVar.bg(cc2[0]);
                        bVar.bh(cc2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cc3 = cc(attributeValue);
                    if (cc3 != null) {
                        bVar.bm(cc3[0]);
                        bVar.bn(cc3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cc4 = cc(attributeValue);
                    if (cc4 != null) {
                        bVar.bk(cc4[0]);
                        bVar.bl(cc4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cc5 = cc(attributeValue);
                    if (cc5 != null) {
                        bVar.bp(cc5[0]);
                        bVar.bo(cc5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cc6 = cc(attributeValue);
                    if (cc6 != null) {
                        bVar.bc(cc6[0]);
                        bVar.bd(cc6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cc7 = cc(attributeValue);
                    if (cc7 != null) {
                        bVar.ba(cc7[0]);
                        bVar.bb(cc7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cc8 = cc(attributeValue);
                    if (cc8 != null) {
                        bVar.aY(cc8[0]);
                        bVar.aZ(cc8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cc9 = cc(attributeValue);
                    if (cc9 != null) {
                        bVar.be(cc9[0]);
                        bVar.bf(cc9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cc10 = cc(attributeValue);
                    if (cc10 != null) {
                        bVar.bq(cc10[0]);
                        bVar.br(cc10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cc = cc(attributeValue)) != null) {
                    bVar.bi(cc[0]);
                    bVar.bj(cc[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.ca(String.valueOf(attributeName) + "=" + this.RS.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.RR != null && !this.RR.containsKey(bVar.getId())) {
                    this.RR.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.RR.containsKey(bVar.getId());
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
            return new int[]{parseInt, a(this.RS, this.RT, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (RU) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (RW == 0) {
                    RV = BdBaseApplication.getInst().getPackageName();
                    RW = RV.length();
                }
                if (resourceName.length() > RW && resourceName.charAt(RW) != ':' && resourceName.startsWith(RV)) {
                    resourceName = String.valueOf(RV) + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.RR != null && this.RR.containsKey(str)) {
            b bVar = this.RR.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.oD() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.isNightMode, bVar.oC(), bVar.oD()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.oH() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.RS.getResourceTypeName(bVar.oG());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.oG(), bVar.oH()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.oG(), bVar.oH()));
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
        if (this.RR != null && this.RR.containsKey(str)) {
            b bVar = this.RR.get(str);
            if (view instanceof TextView) {
                if (bVar.oL() != 0) {
                    ((TextView) view).setTextColor(d(this.isNightMode, bVar.oK(), bVar.oL()));
                }
                if (bVar.oJ() != 0) {
                    ((TextView) view).setHintTextColor(d(this.isNightMode, bVar.oI(), bVar.oJ()));
                }
                if (bVar.oO() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.isNightMode ? bVar.oO() : bVar.oP());
                }
                if (bVar.oB() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.isNightMode, bVar.oA(), bVar.oB()), (Drawable) null, (Drawable) null);
                }
                if (bVar.oz() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.isNightMode, bVar.oy(), bVar.oz()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.oF() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.isNightMode, bVar.oE(), bVar.oF()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.oM() != 0 && (b3 = b(this.isNightMode, bVar.oN(), bVar.oM())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.oM() != 0 && (b2 = b(this.isNightMode, bVar.oN(), bVar.oM())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.oR() != 0 && (b = b(this.isNightMode, bVar.oQ(), bVar.oR())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.oH() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.RS.getResourceTypeName(bVar.oG());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.isNightMode, bVar.oG(), bVar.oH()));
                } else {
                    view.setBackgroundDrawable(b(this.isNightMode, bVar.oG(), bVar.oH()));
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
                return this.RS.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.RT = this.RS;
            i2 = a(this.RS, this.RT, i);
        }
        if (this.RT == null) {
            try {
                return this.RS.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.RT.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.RS.getDrawable(i);
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
            return this.RS.getColor(i);
        }
        if (i == i2) {
            this.RT = this.RS;
            i2 = a(this.RS, this.RT, i);
        }
        if (this.RT == null) {
            return this.RS.getColor(i);
        }
        try {
            return this.RT.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.RS.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return aq.cK(i);
        }
        if (!z) {
            return this.RS.getColorStateList(i);
        }
        if (i == i2) {
            this.RT = this.RS;
            i2 = a(this.RS, this.RT, i);
        }
        if (this.RT == null) {
            return this.RS.getColorStateList(i);
        }
        try {
            return this.RT.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.RS.getColorStateList(i);
        }
    }

    public void ai(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.RT = resources;
    }

    public void destroy() {
        if (this.RR != null) {
            this.RR.clear();
            this.RR = null;
        }
    }
}
