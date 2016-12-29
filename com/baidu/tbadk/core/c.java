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
import com.baidu.tbadk.core.util.ar;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean NS = false;
    private static String NT = null;
    private static int NU = 0;
    private Resources NQ;
    private Resources NR;
    private boolean isNightMode = false;
    Map<String, b> NP = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] ce;
        int g;
        boolean z = false;
        try {
            this.NQ = context.getResources();
            this.NR = this.NQ;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cd(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] ce2 = ce(attributeValue);
                    if (ce2 != null) {
                        bVar.bn(ce2[0]);
                        bVar.bo(ce2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] ce3 = ce(attributeValue);
                    if (ce3 != null) {
                        bVar.bt(ce3[0]);
                        bVar.bu(ce3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] ce4 = ce(attributeValue);
                    if (ce4 != null) {
                        bVar.br(ce4[0]);
                        bVar.bs(ce4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] ce5 = ce(attributeValue);
                    if (ce5 != null) {
                        bVar.bw(ce5[0]);
                        bVar.bv(ce5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] ce6 = ce(attributeValue);
                    if (ce6 != null) {
                        bVar.bj(ce6[0]);
                        bVar.bk(ce6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] ce7 = ce(attributeValue);
                    if (ce7 != null) {
                        bVar.bh(ce7[0]);
                        bVar.bi(ce7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] ce8 = ce(attributeValue);
                    if (ce8 != null) {
                        bVar.bf(ce8[0]);
                        bVar.bg(ce8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] ce9 = ce(attributeValue);
                    if (ce9 != null) {
                        bVar.bl(ce9[0]);
                        bVar.bm(ce9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] ce10 = ce(attributeValue);
                    if (ce10 != null) {
                        bVar.bx(ce10[0]);
                        bVar.by(ce10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (ce = ce(attributeValue)) != null) {
                    bVar.bp(ce[0]);
                    bVar.bq(ce[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.h.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.cc(String.valueOf(attributeName) + "=" + this.NQ.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.NP != null && !this.NP.containsKey(bVar.getId())) {
                    this.NP.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.NP.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] ce(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.NQ, this.NR, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (NS) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (NU == 0) {
                    NT = BdBaseApplication.getInst().getPackageName();
                    NU = NT.length();
                }
                if (resourceName.length() > NU && resourceName.charAt(NU) != ':' && resourceName.startsWith(NT)) {
                    resourceName = String.valueOf(NT) + resourceName.substring(resourceName.indexOf(":"));
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

    public void x(View view) {
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
                    y(view2);
                }
            }
        }
    }

    private void b(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.NP != null && this.NP.containsKey(str)) {
            b bVar = this.NP.get(str);
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
                String resourceTypeName = this.NQ.getResourceTypeName(bVar.ou());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.ou(), bVar.ov()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.ou(), bVar.ov()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void y(View view) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        String str = "@" + view.getId();
        if (this.NP != null && this.NP.containsKey(str)) {
            b bVar = this.NP.get(str);
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
                String resourceTypeName = this.NQ.getResourceTypeName(bVar.ou());
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
            return ar.getDrawable(i);
        }
        if (!z) {
            try {
                return this.NQ.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.NR = this.NQ;
            i2 = a(this.NQ, this.NR, i);
        }
        if (this.NR == null) {
            try {
                return this.NQ.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.NR.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.NQ.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return ar.getColor(i);
        }
        if (!z) {
            return this.NQ.getColor(i);
        }
        if (i == i2) {
            this.NR = this.NQ;
            i2 = a(this.NQ, this.NR, i);
        }
        if (this.NR == null) {
            return this.NQ.getColor(i);
        }
        try {
            return this.NR.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.NQ.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return ar.cP(i);
        }
        if (!z) {
            return this.NQ.getColorStateList(i);
        }
        if (i == i2) {
            this.NR = this.NQ;
            i2 = a(this.NQ, this.NR, i);
        }
        if (this.NR == null) {
            return this.NQ.getColorStateList(i);
        }
        try {
            return this.NR.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.NQ.getColorStateList(i);
        }
    }

    public void ai(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.NR = resources;
    }

    public void destroy() {
        if (this.NP != null) {
            this.NP.clear();
            this.NP = null;
        }
    }
}
