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
    public static boolean Tn = false;
    private static String To = null;
    private static int Tp = 0;
    private Resources Tl;
    private Resources Tm;
    private boolean isNightMode = false;
    Map<String, b> Tk = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] ct;
        int g;
        boolean z = false;
        try {
            this.Tl = context.getResources();
            this.Tm = this.Tl;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cs(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] ct2 = ct(attributeValue);
                    if (ct2 != null) {
                        bVar.bi(ct2[0]);
                        bVar.bj(ct2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] ct3 = ct(attributeValue);
                    if (ct3 != null) {
                        bVar.bo(ct3[0]);
                        bVar.bp(ct3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] ct4 = ct(attributeValue);
                    if (ct4 != null) {
                        bVar.bm(ct4[0]);
                        bVar.bn(ct4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] ct5 = ct(attributeValue);
                    if (ct5 != null) {
                        bVar.br(ct5[0]);
                        bVar.bq(ct5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] ct6 = ct(attributeValue);
                    if (ct6 != null) {
                        bVar.be(ct6[0]);
                        bVar.bf(ct6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] ct7 = ct(attributeValue);
                    if (ct7 != null) {
                        bVar.bc(ct7[0]);
                        bVar.bd(ct7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] ct8 = ct(attributeValue);
                    if (ct8 != null) {
                        bVar.ba(ct8[0]);
                        bVar.bb(ct8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] ct9 = ct(attributeValue);
                    if (ct9 != null) {
                        bVar.bg(ct9[0]);
                        bVar.bh(ct9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] ct10 = ct(attributeValue);
                    if (ct10 != null) {
                        bVar.bs(ct10[0]);
                        bVar.bt(ct10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (ct = ct(attributeValue)) != null) {
                    bVar.bk(ct[0]);
                    bVar.bl(ct[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.cr(attributeName + "=" + this.Tl.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Tk != null && !this.Tk.containsKey(bVar.getId())) {
                    this.Tk.put(bVar.getId(), bVar);
                    return;
                }
                if (TextUtils.isEmpty(bVar.getId()) || this.Tk.containsKey(bVar.getId())) {
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] ct(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Tl, this.Tm, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (Tn) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (Tp == 0) {
                    To = BdBaseApplication.getInst().getPackageName();
                    Tp = To.length();
                }
                if (resourceName.length() > Tp && resourceName.charAt(Tp) != ':' && resourceName.startsWith(To)) {
                    resourceName = To + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.Tk != null && this.Tk.containsKey(str)) {
            b bVar = this.Tk.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.oE() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.isNightMode, bVar.oD(), bVar.oE()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.oI() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Tl.getResourceTypeName(bVar.oH());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.oH(), bVar.oI()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.oH(), bVar.oI()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void u(View view) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        int oQ;
        String str = "@" + view.getId();
        if (this.Tk != null && this.Tk.containsKey(str)) {
            b bVar = this.Tk.get(str);
            if (view instanceof TextView) {
                if (bVar.oM() != 0) {
                    ((TextView) view).setTextColor(d(this.isNightMode, bVar.oL(), bVar.oM()));
                }
                if (bVar.oK() != 0) {
                    ((TextView) view).setHintTextColor(d(this.isNightMode, bVar.oJ(), bVar.oK()));
                }
                if (bVar.oP() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.isNightMode) {
                        oQ = bVar.oP();
                    } else {
                        oQ = bVar.oQ();
                    }
                    textView.setTextAppearance(context, oQ);
                }
                if (bVar.oC() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.isNightMode, bVar.oB(), bVar.oC()), (Drawable) null, (Drawable) null);
                }
                if (bVar.oA() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.isNightMode, bVar.oz(), bVar.oA()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.oG() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.isNightMode, bVar.oF(), bVar.oG()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.oN() != 0 && (b3 = b(this.isNightMode, bVar.oO(), bVar.oN())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.oN() != 0 && (b2 = b(this.isNightMode, bVar.oO(), bVar.oN())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.oS() != 0 && (b = b(this.isNightMode, bVar.oR(), bVar.oS())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.oI() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Tl.getResourceTypeName(bVar.oH());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.isNightMode, bVar.oH(), bVar.oI()));
                } else {
                    view.setBackgroundDrawable(b(this.isNightMode, bVar.oH(), bVar.oI()));
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
                return this.Tl.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.Tm = this.Tl;
            i2 = a(this.Tl, this.Tm, i);
        }
        if (this.Tm == null) {
            try {
                return this.Tl.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.Tm.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Tl.getDrawable(i);
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
            return this.Tl.getColor(i);
        }
        if (i == i2) {
            this.Tm = this.Tl;
            i2 = a(this.Tl, this.Tm, i);
        }
        if (this.Tm == null) {
            return this.Tl.getColor(i);
        }
        try {
            return this.Tm.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Tl.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return ai.cR(i);
        }
        if (!z) {
            return this.Tl.getColorStateList(i);
        }
        if (i == i2) {
            this.Tm = this.Tl;
            i2 = a(this.Tl, this.Tm, i);
        }
        if (this.Tm == null) {
            return this.Tl.getColorStateList(i);
        }
        try {
            return this.Tm.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Tl.getColorStateList(i);
        }
    }

    public void ah(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.Tm = resources;
    }

    public void destroy() {
        if (this.Tk != null) {
            this.Tk.clear();
            this.Tk = null;
        }
    }
}
