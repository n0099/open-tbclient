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
import com.baidu.tbadk.core.util.an;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean Te = false;
    private static String Tf = null;
    private static int Tg = 0;
    private boolean Ta = false;
    Map<String, b> Tb = new HashMap();
    private Resources Tc;
    private Resources Td;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cb;
        int g;
        boolean z = false;
        try {
            this.Tc = context.getResources();
            this.Td = this.Tc;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.ca(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cb2 = cb(attributeValue);
                    if (cb2 != null) {
                        bVar.bb(cb2[0]);
                        bVar.bc(cb2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cb3 = cb(attributeValue);
                    if (cb3 != null) {
                        bVar.bh(cb3[0]);
                        bVar.bi(cb3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cb4 = cb(attributeValue);
                    if (cb4 != null) {
                        bVar.bf(cb4[0]);
                        bVar.bg(cb4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cb5 = cb(attributeValue);
                    if (cb5 != null) {
                        bVar.bk(cb5[0]);
                        bVar.bj(cb5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cb6 = cb(attributeValue);
                    if (cb6 != null) {
                        bVar.aX(cb6[0]);
                        bVar.aY(cb6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cb7 = cb(attributeValue);
                    if (cb7 != null) {
                        bVar.aV(cb7[0]);
                        bVar.aW(cb7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cb8 = cb(attributeValue);
                    if (cb8 != null) {
                        bVar.aT(cb8[0]);
                        bVar.aU(cb8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cb9 = cb(attributeValue);
                    if (cb9 != null) {
                        bVar.aZ(cb9[0]);
                        bVar.ba(cb9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cb10 = cb(attributeValue);
                    if (cb10 != null) {
                        bVar.bl(cb10[0]);
                        bVar.bm(cb10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cb = cb(attributeValue)) != null) {
                    bVar.bd(cb[0]);
                    bVar.be(cb[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.bZ(String.valueOf(attributeName) + "=" + this.Tc.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Tb != null && !this.Tb.containsKey(bVar.getId())) {
                    this.Tb.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.Tb.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] cb(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Tc, this.Td, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (Te) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (Tg == 0) {
                    Tf = BdBaseApplication.getInst().getPackageName();
                    Tg = Tf.length();
                }
                if (resourceName.length() > Tg && resourceName.charAt(Tg) != ':' && resourceName.startsWith(Tf)) {
                    resourceName = String.valueOf(Tf) + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.Tb != null && this.Tb.containsKey(str)) {
            b bVar = this.Tb.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.qC() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.Ta, bVar.qB(), bVar.qC()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.qG() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Tc.getResourceTypeName(bVar.qF());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.Ta, bVar.qF(), bVar.qG()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.Ta, bVar.qF(), bVar.qG()));
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
        if (this.Tb != null && this.Tb.containsKey(str)) {
            b bVar = this.Tb.get(str);
            if (view instanceof TextView) {
                if (bVar.qK() != 0) {
                    ((TextView) view).setTextColor(d(this.Ta, bVar.qJ(), bVar.qK()));
                }
                if (bVar.qI() != 0) {
                    ((TextView) view).setHintTextColor(d(this.Ta, bVar.qH(), bVar.qI()));
                }
                if (bVar.qN() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.Ta ? bVar.qN() : bVar.qO());
                }
                if (bVar.qA() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.Ta, bVar.qz(), bVar.qA()), (Drawable) null, (Drawable) null);
                }
                if (bVar.qy() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.Ta, bVar.qx(), bVar.qy()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.qE() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.Ta, bVar.qD(), bVar.qE()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.qL() != 0 && (b3 = b(this.Ta, bVar.qM(), bVar.qL())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.qL() != 0 && (b2 = b(this.Ta, bVar.qM(), bVar.qL())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.qQ() != 0 && (b = b(this.Ta, bVar.qP(), bVar.qQ())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.qG() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Tc.getResourceTypeName(bVar.qF());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.Ta, bVar.qF(), bVar.qG()));
                } else {
                    view.setBackgroundDrawable(b(this.Ta, bVar.qF(), bVar.qG()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return an.getDrawable(i);
        }
        if (!z) {
            try {
                return this.Tc.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.Td = this.Tc;
            i2 = a(this.Tc, this.Td, i);
        }
        if (this.Td == null) {
            try {
                return this.Tc.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.Td.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Tc.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        }
    }

    private int c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return an.getColor(i);
        }
        if (!z) {
            return this.Tc.getColor(i);
        }
        if (i == i2) {
            this.Td = this.Tc;
            i2 = a(this.Tc, this.Td, i);
        }
        if (this.Td == null) {
            return this.Tc.getColor(i);
        }
        try {
            return this.Td.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Tc.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return an.cv(i);
        }
        if (!z) {
            return this.Tc.getColorStateList(i);
        }
        if (i == i2) {
            this.Td = this.Tc;
            i2 = a(this.Tc, this.Td, i);
        }
        if (this.Td == null) {
            return this.Tc.getColorStateList(i);
        }
        try {
            return this.Td.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Tc.getColorStateList(i);
        }
    }

    public void ad(boolean z) {
        this.Ta = z;
    }

    public void b(Resources resources) {
        this.Td = resources;
    }

    public void destroy() {
        if (this.Tb != null) {
            this.Tb.clear();
            this.Tb = null;
        }
    }
}
