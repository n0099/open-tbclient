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
import com.baidu.tbadk.core.util.av;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean LG = false;
    private static String LH = null;
    private static int LI = 0;
    private boolean LC = false;
    Map<String, b> LD = new HashMap();
    private Resources LE;
    private Resources LF;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] ca;
        int g;
        boolean z = false;
        try {
            this.LE = context.getResources();
            this.LF = this.LE;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.bZ(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] ca2 = ca(attributeValue);
                    if (ca2 != null) {
                        bVar.aW(ca2[0]);
                        bVar.aX(ca2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] ca3 = ca(attributeValue);
                    if (ca3 != null) {
                        bVar.bc(ca3[0]);
                        bVar.bd(ca3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] ca4 = ca(attributeValue);
                    if (ca4 != null) {
                        bVar.ba(ca4[0]);
                        bVar.bb(ca4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] ca5 = ca(attributeValue);
                    if (ca5 != null) {
                        bVar.bf(ca5[0]);
                        bVar.be(ca5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] ca6 = ca(attributeValue);
                    if (ca6 != null) {
                        bVar.aS(ca6[0]);
                        bVar.aT(ca6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] ca7 = ca(attributeValue);
                    if (ca7 != null) {
                        bVar.aQ(ca7[0]);
                        bVar.aR(ca7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] ca8 = ca(attributeValue);
                    if (ca8 != null) {
                        bVar.aO(ca8[0]);
                        bVar.aP(ca8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] ca9 = ca(attributeValue);
                    if (ca9 != null) {
                        bVar.aU(ca9[0]);
                        bVar.aV(ca9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] ca10 = ca(attributeValue);
                    if (ca10 != null) {
                        bVar.bg(ca10[0]);
                        bVar.bh(ca10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (ca = ca(attributeValue)) != null) {
                    bVar.aY(ca[0]);
                    bVar.aZ(ca[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.h.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.bY(String.valueOf(attributeName) + "=" + this.LE.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.LD != null && !this.LD.containsKey(bVar.getId())) {
                    this.LD.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.LD.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] ca(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.LE, this.LF, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (LG) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (LI == 0) {
                    LH = BdBaseApplication.getInst().getPackageName();
                    LI = LH.length();
                }
                if (resourceName.length() > LI && resourceName.charAt(LI) != ':' && resourceName.startsWith(LH)) {
                    resourceName = String.valueOf(LH) + resourceName.substring(resourceName.indexOf(":"));
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

    public void w(View view) {
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
                    x(view2);
                }
            }
        }
    }

    private void b(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.LD != null && this.LD.containsKey(str)) {
            b bVar = this.LD.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.nE() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(a(this.LC, bVar.nD(), bVar.nE()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.nI() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.LE.getResourceTypeName(bVar.nH());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(b(this.LC, bVar.nH(), bVar.nI()));
                } else {
                    viewGroup.setBackgroundDrawable(a(this.LC, bVar.nH(), bVar.nI()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void x(View view) {
        Drawable a;
        Drawable a2;
        Drawable a3;
        String str = "@" + view.getId();
        if (this.LD != null && this.LD.containsKey(str)) {
            b bVar = this.LD.get(str);
            if (view instanceof TextView) {
                if (bVar.nM() != 0) {
                    ((TextView) view).setTextColor(c(this.LC, bVar.nL(), bVar.nM()));
                }
                if (bVar.nK() != 0) {
                    ((TextView) view).setHintTextColor(c(this.LC, bVar.nJ(), bVar.nK()));
                }
                if (bVar.nP() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.LC ? bVar.nP() : bVar.nQ());
                }
                if (bVar.nC() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, a(this.LC, bVar.nB(), bVar.nC()), (Drawable) null, (Drawable) null);
                }
                if (bVar.nA() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(a(this.LC, bVar.nz(), bVar.nA()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.nG() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a(this.LC, bVar.nF(), bVar.nG()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.nN() != 0 && (a3 = a(this.LC, bVar.nO(), bVar.nN())) != null) {
                    ((ImageView) view).setImageDrawable(a3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.nN() != 0 && (a2 = a(this.LC, bVar.nO(), bVar.nN())) != null) {
                    ((ImageView) view).setImageDrawable(a2);
                }
            } else if ((view instanceof ProgressBar) && bVar.nS() != 0 && (a = a(this.LC, bVar.nR(), bVar.nS())) != null) {
                ((ProgressBar) view).setProgressDrawable(a);
            }
            if (bVar.nI() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.LE.getResourceTypeName(bVar.nH());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(b(this.LC, bVar.nH(), bVar.nI()));
                } else {
                    view.setBackgroundDrawable(a(this.LC, bVar.nH(), bVar.nI()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable a(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return av.getDrawable(i);
        }
        if (!z) {
            try {
                return this.LE.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.LF = this.LE;
            i2 = a(this.LE, this.LF, i);
        }
        if (this.LF == null) {
            try {
                return this.LE.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.LF.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.LE.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return av.getColor(i);
        }
        if (!z) {
            return this.LE.getColor(i);
        }
        if (i == i2) {
            this.LF = this.LE;
            i2 = a(this.LE, this.LF, i);
        }
        if (this.LF == null) {
            return this.LE.getColor(i);
        }
        try {
            return this.LF.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.LE.getColor(i);
        }
    }

    private ColorStateList c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return av.cz(i);
        }
        if (!z) {
            return this.LE.getColorStateList(i);
        }
        if (i == i2) {
            this.LF = this.LE;
            i2 = a(this.LE, this.LF, i);
        }
        if (this.LF == null) {
            return this.LE.getColorStateList(i);
        }
        try {
            return this.LF.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.LE.getColorStateList(i);
        }
    }

    public void ad(boolean z) {
        this.LC = z;
    }

    public void b(Resources resources) {
        this.LF = resources;
    }

    public void destroy() {
        if (this.LD != null) {
            this.LD.clear();
            this.LD = null;
        }
    }
}
