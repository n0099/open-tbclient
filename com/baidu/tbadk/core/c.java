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
import com.baidu.tbadk.core.util.ak;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean Us = false;
    private static String Ut = null;
    private static int Uu = 0;
    private Resources Uq;
    private Resources Ur;
    private boolean isNightMode = false;
    Map<String, b> Up = new HashMap();

    public void b(String str, Context context, AttributeSet attributeSet) {
        int[] cB;
        int g;
        boolean z = false;
        try {
            this.Uq = context.getResources();
            this.Ur = this.Uq;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cA(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cB2 = cB(attributeValue);
                    if (cB2 != null) {
                        bVar.bi(cB2[0]);
                        bVar.bj(cB2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cB3 = cB(attributeValue);
                    if (cB3 != null) {
                        bVar.bo(cB3[0]);
                        bVar.bp(cB3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cB4 = cB(attributeValue);
                    if (cB4 != null) {
                        bVar.bm(cB4[0]);
                        bVar.bn(cB4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cB5 = cB(attributeValue);
                    if (cB5 != null) {
                        bVar.br(cB5[0]);
                        bVar.bq(cB5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cB6 = cB(attributeValue);
                    if (cB6 != null) {
                        bVar.be(cB6[0]);
                        bVar.bf(cB6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cB7 = cB(attributeValue);
                    if (cB7 != null) {
                        bVar.bc(cB7[0]);
                        bVar.bd(cB7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cB8 = cB(attributeValue);
                    if (cB8 != null) {
                        bVar.ba(cB8[0]);
                        bVar.bb(cB8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cB9 = cB(attributeValue);
                    if (cB9 != null) {
                        bVar.bg(cB9[0]);
                        bVar.bh(cB9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cB10 = cB(attributeValue);
                    if (cB10 != null) {
                        bVar.bs(cB10[0]);
                        bVar.bt(cB10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cB = cB(attributeValue)) != null) {
                    bVar.bk(cB[0]);
                    bVar.bl(cB[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.cz(attributeName + "=" + this.Uq.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Up != null && !this.Up.containsKey(bVar.getId())) {
                    this.Up.put(bVar.getId(), bVar);
                    return;
                }
                if (TextUtils.isEmpty(bVar.getId()) || this.Up.containsKey(bVar.getId())) {
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] cB(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Uq, this.Ur, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (Us) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (Uu == 0) {
                    Ut = BdBaseApplication.getInst().getPackageName();
                    Uu = Ut.length();
                }
                if (resourceName.length() > Uu && resourceName.charAt(Uu) != ':' && resourceName.startsWith(Ut)) {
                    resourceName = Ut + resourceName.substring(resourceName.indexOf(":"));
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

    public void u(View view2) {
        if (view2 != null) {
            Stack stack = new Stack();
            stack.push(view2);
            while (!stack.isEmpty()) {
                View view3 = (View) stack.pop();
                if (view3 instanceof ViewGroup) {
                    g((ViewGroup) view3);
                    if (!(view3 instanceof AdapterView)) {
                        int childCount = ((ViewGroup) view3).getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            stack.push(((ViewGroup) view3).getChildAt(i));
                        }
                    }
                } else {
                    v(view3);
                }
            }
        }
    }

    private void g(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.Up != null && this.Up.containsKey(str)) {
            b bVar = this.Up.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.pE() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.isNightMode, bVar.pD(), bVar.pE()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.pI() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Uq.getResourceTypeName(bVar.pH());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.pH(), bVar.pI()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.pH(), bVar.pI()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void v(View view2) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        int pQ;
        String str = "@" + view2.getId();
        if (this.Up != null && this.Up.containsKey(str)) {
            b bVar = this.Up.get(str);
            if (view2 instanceof TextView) {
                if (bVar.pM() != 0) {
                    ((TextView) view2).setTextColor(d(this.isNightMode, bVar.pL(), bVar.pM()));
                }
                if (bVar.pK() != 0) {
                    ((TextView) view2).setHintTextColor(d(this.isNightMode, bVar.pJ(), bVar.pK()));
                }
                if (bVar.pP() != 0) {
                    TextView textView = (TextView) view2;
                    Context context = view2.getContext();
                    if (this.isNightMode) {
                        pQ = bVar.pP();
                    } else {
                        pQ = bVar.pQ();
                    }
                    textView.setTextAppearance(context, pQ);
                }
                if (bVar.pC() != 0) {
                    ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.isNightMode, bVar.pB(), bVar.pC()), (Drawable) null, (Drawable) null);
                }
                if (bVar.pA() != 0) {
                    ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds(b(this.isNightMode, bVar.pz(), bVar.pA()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.pG() != 0) {
                    ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.isNightMode, bVar.pF(), bVar.pG()), (Drawable) null);
                }
            } else if (view2 instanceof ImageButton) {
                if (bVar.pN() != 0 && (b3 = b(this.isNightMode, bVar.pO(), bVar.pN())) != null) {
                    ((ImageView) view2).setImageDrawable(b3);
                }
            } else if (view2 instanceof ImageView) {
                if (bVar.pN() != 0 && (b2 = b(this.isNightMode, bVar.pO(), bVar.pN())) != null) {
                    ((ImageView) view2).setImageDrawable(b2);
                }
            } else if ((view2 instanceof ProgressBar) && bVar.pS() != 0 && (b = b(this.isNightMode, bVar.pR(), bVar.pS())) != null) {
                ((ProgressBar) view2).setProgressDrawable(b);
            }
            if (bVar.pI() != 0) {
                int paddingLeft = view2.getPaddingLeft();
                int paddingTop = view2.getPaddingTop();
                int paddingRight = view2.getPaddingRight();
                int paddingBottom = view2.getPaddingBottom();
                String resourceTypeName = this.Uq.getResourceTypeName(bVar.pH());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view2.setBackgroundColor(c(this.isNightMode, bVar.pH(), bVar.pI()));
                } else {
                    view2.setBackgroundDrawable(b(this.isNightMode, bVar.pH(), bVar.pI()));
                }
                view2.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return ak.getDrawable(i);
        }
        if (!z) {
            try {
                return this.Uq.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.Ur = this.Uq;
            i2 = a(this.Uq, this.Ur, i);
        }
        if (this.Ur == null) {
            try {
                return this.Uq.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.Ur.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Uq.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return ak.getColor(i);
        }
        if (!z) {
            return this.Uq.getColor(i);
        }
        if (i == i2) {
            this.Ur = this.Uq;
            i2 = a(this.Uq, this.Ur, i);
        }
        if (this.Ur == null) {
            return this.Uq.getColor(i);
        }
        try {
            return this.Ur.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Uq.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return ak.cN(i);
        }
        if (!z) {
            return this.Uq.getColorStateList(i);
        }
        if (i == i2) {
            this.Ur = this.Uq;
            i2 = a(this.Uq, this.Ur, i);
        }
        if (this.Ur == null) {
            return this.Uq.getColorStateList(i);
        }
        try {
            return this.Ur.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Uq.getColorStateList(i);
        }
    }

    public void setNightMode(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.Ur = resources;
    }

    public void destroy() {
        if (this.Up != null) {
            this.Up.clear();
            this.Up = null;
        }
    }
}
