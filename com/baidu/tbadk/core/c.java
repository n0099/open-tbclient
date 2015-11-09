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
    public static boolean Tf = false;
    private static String Tg = null;
    private static int Th = 0;
    private boolean Tb = false;
    Map<String, b> Tc = new HashMap();
    private Resources Td;
    private Resources Te;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] bZ;
        int g;
        boolean z = false;
        try {
            this.Td = context.getResources();
            this.Te = this.Td;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.bY(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] bZ2 = bZ(attributeValue);
                    if (bZ2 != null) {
                        bVar.bb(bZ2[0]);
                        bVar.bc(bZ2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] bZ3 = bZ(attributeValue);
                    if (bZ3 != null) {
                        bVar.bh(bZ3[0]);
                        bVar.bi(bZ3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] bZ4 = bZ(attributeValue);
                    if (bZ4 != null) {
                        bVar.bf(bZ4[0]);
                        bVar.bg(bZ4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] bZ5 = bZ(attributeValue);
                    if (bZ5 != null) {
                        bVar.bk(bZ5[0]);
                        bVar.bj(bZ5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] bZ6 = bZ(attributeValue);
                    if (bZ6 != null) {
                        bVar.aX(bZ6[0]);
                        bVar.aY(bZ6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] bZ7 = bZ(attributeValue);
                    if (bZ7 != null) {
                        bVar.aV(bZ7[0]);
                        bVar.aW(bZ7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] bZ8 = bZ(attributeValue);
                    if (bZ8 != null) {
                        bVar.aT(bZ8[0]);
                        bVar.aU(bZ8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] bZ9 = bZ(attributeValue);
                    if (bZ9 != null) {
                        bVar.aZ(bZ9[0]);
                        bVar.ba(bZ9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] bZ10 = bZ(attributeValue);
                    if (bZ10 != null) {
                        bVar.bl(bZ10[0]);
                        bVar.bm(bZ10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (bZ = bZ(attributeValue)) != null) {
                    bVar.bd(bZ[0]);
                    bVar.be(bZ[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.bX(String.valueOf(attributeName) + "=" + this.Td.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Tc != null && !this.Tc.containsKey(bVar.getId())) {
                    this.Tc.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.Tc.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] bZ(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Td, this.Te, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (Tf) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (Th == 0) {
                    Tg = BdBaseApplication.getInst().getPackageName();
                    Th = Tg.length();
                }
                if (resourceName.length() > Th && resourceName.charAt(Th) != ':' && resourceName.startsWith(Tg)) {
                    resourceName = String.valueOf(Tg) + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.Tc != null && this.Tc.containsKey(str)) {
            b bVar = this.Tc.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.qD() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.Tb, bVar.qC(), bVar.qD()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.qH() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Td.getResourceTypeName(bVar.qG());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.Tb, bVar.qG(), bVar.qH()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.Tb, bVar.qG(), bVar.qH()));
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
        if (this.Tc != null && this.Tc.containsKey(str)) {
            b bVar = this.Tc.get(str);
            if (view instanceof TextView) {
                if (bVar.qL() != 0) {
                    ((TextView) view).setTextColor(d(this.Tb, bVar.qK(), bVar.qL()));
                }
                if (bVar.qJ() != 0) {
                    ((TextView) view).setHintTextColor(d(this.Tb, bVar.qI(), bVar.qJ()));
                }
                if (bVar.qO() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.Tb ? bVar.qO() : bVar.qP());
                }
                if (bVar.qB() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.Tb, bVar.qA(), bVar.qB()), (Drawable) null, (Drawable) null);
                }
                if (bVar.qz() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.Tb, bVar.qy(), bVar.qz()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.qF() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.Tb, bVar.qE(), bVar.qF()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.qM() != 0 && (b3 = b(this.Tb, bVar.qN(), bVar.qM())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.qM() != 0 && (b2 = b(this.Tb, bVar.qN(), bVar.qM())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.qR() != 0 && (b = b(this.Tb, bVar.qQ(), bVar.qR())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.qH() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Td.getResourceTypeName(bVar.qG());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.Tb, bVar.qG(), bVar.qH()));
                } else {
                    view.setBackgroundDrawable(b(this.Tb, bVar.qG(), bVar.qH()));
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
                return this.Td.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.Te = this.Td;
            i2 = a(this.Td, this.Te, i);
        }
        if (this.Te == null) {
            try {
                return this.Td.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.Te.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Td.getDrawable(i);
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
            return this.Td.getColor(i);
        }
        if (i == i2) {
            this.Te = this.Td;
            i2 = a(this.Td, this.Te, i);
        }
        if (this.Te == null) {
            return this.Td.getColor(i);
        }
        try {
            return this.Te.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Td.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return an.cv(i);
        }
        if (!z) {
            return this.Td.getColorStateList(i);
        }
        if (i == i2) {
            this.Te = this.Td;
            i2 = a(this.Td, this.Te, i);
        }
        if (this.Te == null) {
            return this.Td.getColorStateList(i);
        }
        try {
            return this.Te.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Td.getColorStateList(i);
        }
    }

    public void ad(boolean z) {
        this.Tb = z;
    }

    public void b(Resources resources) {
        this.Te = resources;
    }

    public void destroy() {
        if (this.Tc != null) {
            this.Tc.clear();
            this.Tc = null;
        }
    }
}
