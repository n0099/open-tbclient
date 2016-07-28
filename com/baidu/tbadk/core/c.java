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
    public static boolean LE = false;
    private static String LF = null;
    private static int LG = 0;
    private Resources LC;
    private Resources LD;
    private boolean isNightMode = false;
    Map<String, b> LB = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cb;
        int g;
        boolean z = false;
        try {
            this.LC = context.getResources();
            this.LD = this.LC;
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
                        bVar.aZ(cb2[0]);
                        bVar.ba(cb2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cb3 = cb(attributeValue);
                    if (cb3 != null) {
                        bVar.bf(cb3[0]);
                        bVar.bg(cb3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cb4 = cb(attributeValue);
                    if (cb4 != null) {
                        bVar.bd(cb4[0]);
                        bVar.be(cb4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cb5 = cb(attributeValue);
                    if (cb5 != null) {
                        bVar.bi(cb5[0]);
                        bVar.bh(cb5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cb6 = cb(attributeValue);
                    if (cb6 != null) {
                        bVar.aV(cb6[0]);
                        bVar.aW(cb6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cb7 = cb(attributeValue);
                    if (cb7 != null) {
                        bVar.aT(cb7[0]);
                        bVar.aU(cb7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cb8 = cb(attributeValue);
                    if (cb8 != null) {
                        bVar.aR(cb8[0]);
                        bVar.aS(cb8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cb9 = cb(attributeValue);
                    if (cb9 != null) {
                        bVar.aX(cb9[0]);
                        bVar.aY(cb9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cb10 = cb(attributeValue);
                    if (cb10 != null) {
                        bVar.bj(cb10[0]);
                        bVar.bk(cb10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cb = cb(attributeValue)) != null) {
                    bVar.bb(cb[0]);
                    bVar.bc(cb[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.h.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.bZ(String.valueOf(attributeName) + "=" + this.LC.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.LB != null && !this.LB.containsKey(bVar.getId())) {
                    this.LB.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.LB.containsKey(bVar.getId());
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
            return new int[]{parseInt, a(this.LC, this.LD, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (LE) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (LG == 0) {
                    LF = BdBaseApplication.getInst().getPackageName();
                    LG = LF.length();
                }
                if (resourceName.length() > LG && resourceName.charAt(LG) != ':' && resourceName.startsWith(LF)) {
                    resourceName = String.valueOf(LF) + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.LB != null && this.LB.containsKey(str)) {
            b bVar = this.LB.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.nt() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.isNightMode, bVar.ns(), bVar.nt()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.nx() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.LC.getResourceTypeName(bVar.nw());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.nw(), bVar.nx()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.nw(), bVar.nx()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void x(View view) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        String str = "@" + view.getId();
        if (this.LB != null && this.LB.containsKey(str)) {
            b bVar = this.LB.get(str);
            if (view instanceof TextView) {
                if (bVar.nB() != 0) {
                    ((TextView) view).setTextColor(d(this.isNightMode, bVar.nA(), bVar.nB()));
                }
                if (bVar.nz() != 0) {
                    ((TextView) view).setHintTextColor(d(this.isNightMode, bVar.ny(), bVar.nz()));
                }
                if (bVar.nE() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.isNightMode ? bVar.nE() : bVar.nF());
                }
                if (bVar.nr() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.isNightMode, bVar.nq(), bVar.nr()), (Drawable) null, (Drawable) null);
                }
                if (bVar.np() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.isNightMode, bVar.no(), bVar.np()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.nv() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.isNightMode, bVar.nu(), bVar.nv()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.nC() != 0 && (b3 = b(this.isNightMode, bVar.nD(), bVar.nC())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.nC() != 0 && (b2 = b(this.isNightMode, bVar.nD(), bVar.nC())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.nH() != 0 && (b = b(this.isNightMode, bVar.nG(), bVar.nH())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.nx() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.LC.getResourceTypeName(bVar.nw());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.isNightMode, bVar.nw(), bVar.nx()));
                } else {
                    view.setBackgroundDrawable(b(this.isNightMode, bVar.nw(), bVar.nx()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m10getInst().getSkinType() == 2) {
            return av.getDrawable(i);
        }
        if (!z) {
            try {
                return this.LC.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.LD = this.LC;
            i2 = a(this.LC, this.LD, i);
        }
        if (this.LD == null) {
            try {
                return this.LC.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.LD.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.LC.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m10getInst().getSkinType() == 2) {
            return av.getColor(i);
        }
        if (!z) {
            return this.LC.getColor(i);
        }
        if (i == i2) {
            this.LD = this.LC;
            i2 = a(this.LC, this.LD, i);
        }
        if (this.LD == null) {
            return this.LC.getColor(i);
        }
        try {
            return this.LD.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.LC.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m10getInst().getSkinType() == 2) {
            return av.cz(i);
        }
        if (!z) {
            return this.LC.getColorStateList(i);
        }
        if (i == i2) {
            this.LD = this.LC;
            i2 = a(this.LC, this.LD, i);
        }
        if (this.LD == null) {
            return this.LC.getColorStateList(i);
        }
        try {
            return this.LD.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.LC.getColorStateList(i);
        }
    }

    public void af(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.LD = resources;
    }

    public void destroy() {
        if (this.LB != null) {
            this.LB.clear();
            this.LB = null;
        }
    }
}
