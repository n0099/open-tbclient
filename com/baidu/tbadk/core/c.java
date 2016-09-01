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
    public static boolean NT = false;
    private static String NU = null;
    private static int NV = 0;
    private Resources NQ;
    private Resources NR;
    private boolean isNightMode = false;
    Map<String, b> NP = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cc;
        int g;
        boolean z = false;
        try {
            this.NQ = context.getResources();
            this.NR = this.NQ;
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
                        bVar.bm(cc2[0]);
                        bVar.bn(cc2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cc3 = cc(attributeValue);
                    if (cc3 != null) {
                        bVar.bs(cc3[0]);
                        bVar.bt(cc3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cc4 = cc(attributeValue);
                    if (cc4 != null) {
                        bVar.bq(cc4[0]);
                        bVar.br(cc4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cc5 = cc(attributeValue);
                    if (cc5 != null) {
                        bVar.bv(cc5[0]);
                        bVar.bu(cc5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cc6 = cc(attributeValue);
                    if (cc6 != null) {
                        bVar.bi(cc6[0]);
                        bVar.bj(cc6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cc7 = cc(attributeValue);
                    if (cc7 != null) {
                        bVar.bg(cc7[0]);
                        bVar.bh(cc7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cc8 = cc(attributeValue);
                    if (cc8 != null) {
                        bVar.be(cc8[0]);
                        bVar.bf(cc8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cc9 = cc(attributeValue);
                    if (cc9 != null) {
                        bVar.bk(cc9[0]);
                        bVar.bl(cc9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cc10 = cc(attributeValue);
                    if (cc10 != null) {
                        bVar.bw(cc10[0]);
                        bVar.bx(cc10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cc = cc(attributeValue)) != null) {
                    bVar.bo(cc[0]);
                    bVar.bp(cc[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.h.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.ca(String.valueOf(attributeName) + "=" + this.NQ.getResourceName(g));
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

    private final int[] cc(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.NQ, this.NR, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (NT) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (NV == 0) {
                    NU = BdBaseApplication.getInst().getPackageName();
                    NV = NU.length();
                }
                if (resourceName.length() > NV && resourceName.charAt(NV) != ':' && resourceName.startsWith(NU)) {
                    resourceName = String.valueOf(NU) + resourceName.substring(resourceName.indexOf(":"));
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
                if ((viewGroup instanceof ListView) && bVar.oo() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.isNightMode, bVar.on(), bVar.oo()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.os() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.NQ.getResourceTypeName(bVar.or());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.or(), bVar.os()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.or(), bVar.os()));
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
                if (bVar.ow() != 0) {
                    ((TextView) view).setTextColor(d(this.isNightMode, bVar.ov(), bVar.ow()));
                }
                if (bVar.ou() != 0) {
                    ((TextView) view).setHintTextColor(d(this.isNightMode, bVar.ot(), bVar.ou()));
                }
                if (bVar.oz() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.isNightMode ? bVar.oz() : bVar.oA());
                }
                if (bVar.om() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.isNightMode, bVar.ol(), bVar.om()), (Drawable) null, (Drawable) null);
                }
                if (bVar.ok() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.isNightMode, bVar.oj(), bVar.ok()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.oq() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.isNightMode, bVar.op(), bVar.oq()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.ox() != 0 && (b3 = b(this.isNightMode, bVar.oy(), bVar.ox())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.ox() != 0 && (b2 = b(this.isNightMode, bVar.oy(), bVar.ox())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.oC() != 0 && (b = b(this.isNightMode, bVar.oB(), bVar.oC())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.os() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.NQ.getResourceTypeName(bVar.or());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.isNightMode, bVar.or(), bVar.os()));
                } else {
                    view.setBackgroundDrawable(b(this.isNightMode, bVar.or(), bVar.os()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return av.getDrawable(i);
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
            return av.getColor(i);
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
            return av.cM(i);
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

    public void ah(boolean z) {
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
