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
    public static boolean Uw = false;
    private static String Ux = null;
    private static int Uy = 0;
    private Resources Uu;
    private Resources Uv;
    private boolean isNightMode = false;
    Map<String, b> Ut = new HashMap();

    public void b(String str, Context context, AttributeSet attributeSet) {
        int[] cB;
        int g;
        boolean z = false;
        try {
            this.Uu = context.getResources();
            this.Uv = this.Uu;
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
                    bVar.cz(attributeName + "=" + this.Uu.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Ut != null && !this.Ut.containsKey(bVar.getId())) {
                    this.Ut.put(bVar.getId(), bVar);
                    return;
                }
                if (TextUtils.isEmpty(bVar.getId()) || this.Ut.containsKey(bVar.getId())) {
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
            return new int[]{parseInt, a(this.Uu, this.Uv, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (Uw) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (Uy == 0) {
                    Ux = BdBaseApplication.getInst().getPackageName();
                    Uy = Ux.length();
                }
                if (resourceName.length() > Uy && resourceName.charAt(Uy) != ':' && resourceName.startsWith(Ux)) {
                    resourceName = Ux + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.Ut != null && this.Ut.containsKey(str)) {
            b bVar = this.Ut.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.pF() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.isNightMode, bVar.pE(), bVar.pF()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.pJ() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Uu.getResourceTypeName(bVar.pI());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.pI(), bVar.pJ()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.pI(), bVar.pJ()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void v(View view2) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        int pR;
        String str = "@" + view2.getId();
        if (this.Ut != null && this.Ut.containsKey(str)) {
            b bVar = this.Ut.get(str);
            if (view2 instanceof TextView) {
                if (bVar.pN() != 0) {
                    ((TextView) view2).setTextColor(d(this.isNightMode, bVar.pM(), bVar.pN()));
                }
                if (bVar.pL() != 0) {
                    ((TextView) view2).setHintTextColor(d(this.isNightMode, bVar.pK(), bVar.pL()));
                }
                if (bVar.pQ() != 0) {
                    TextView textView = (TextView) view2;
                    Context context = view2.getContext();
                    if (this.isNightMode) {
                        pR = bVar.pQ();
                    } else {
                        pR = bVar.pR();
                    }
                    textView.setTextAppearance(context, pR);
                }
                if (bVar.pD() != 0) {
                    ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.isNightMode, bVar.pC(), bVar.pD()), (Drawable) null, (Drawable) null);
                }
                if (bVar.pB() != 0) {
                    ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds(b(this.isNightMode, bVar.pA(), bVar.pB()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.pH() != 0) {
                    ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.isNightMode, bVar.pG(), bVar.pH()), (Drawable) null);
                }
            } else if (view2 instanceof ImageButton) {
                if (bVar.pO() != 0 && (b3 = b(this.isNightMode, bVar.pP(), bVar.pO())) != null) {
                    ((ImageView) view2).setImageDrawable(b3);
                }
            } else if (view2 instanceof ImageView) {
                if (bVar.pO() != 0 && (b2 = b(this.isNightMode, bVar.pP(), bVar.pO())) != null) {
                    ((ImageView) view2).setImageDrawable(b2);
                }
            } else if ((view2 instanceof ProgressBar) && bVar.pT() != 0 && (b = b(this.isNightMode, bVar.pS(), bVar.pT())) != null) {
                ((ProgressBar) view2).setProgressDrawable(b);
            }
            if (bVar.pJ() != 0) {
                int paddingLeft = view2.getPaddingLeft();
                int paddingTop = view2.getPaddingTop();
                int paddingRight = view2.getPaddingRight();
                int paddingBottom = view2.getPaddingBottom();
                String resourceTypeName = this.Uu.getResourceTypeName(bVar.pI());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view2.setBackgroundColor(c(this.isNightMode, bVar.pI(), bVar.pJ()));
                } else {
                    view2.setBackgroundDrawable(b(this.isNightMode, bVar.pI(), bVar.pJ()));
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
                return this.Uu.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.Uv = this.Uu;
            i2 = a(this.Uu, this.Uv, i);
        }
        if (this.Uv == null) {
            try {
                return this.Uu.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.Uv.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Uu.getDrawable(i);
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
            return this.Uu.getColor(i);
        }
        if (i == i2) {
            this.Uv = this.Uu;
            i2 = a(this.Uu, this.Uv, i);
        }
        if (this.Uv == null) {
            return this.Uu.getColor(i);
        }
        try {
            return this.Uv.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Uu.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return ak.cM(i);
        }
        if (!z) {
            return this.Uu.getColorStateList(i);
        }
        if (i == i2) {
            this.Uv = this.Uu;
            i2 = a(this.Uu, this.Uv, i);
        }
        if (this.Uv == null) {
            return this.Uu.getColorStateList(i);
        }
        try {
            return this.Uv.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Uu.getColorStateList(i);
        }
    }

    public void setNightMode(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.Uv = resources;
    }

    public void destroy() {
        if (this.Ut != null) {
            this.Ut.clear();
            this.Ut = null;
        }
    }
}
