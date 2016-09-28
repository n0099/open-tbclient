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
    public static boolean NU = false;
    private static String NV = null;
    private static int NW = 0;
    private Resources NR;
    private Resources NT;
    private boolean isNightMode = false;
    Map<String, b> NQ = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cc;
        int g;
        boolean z = false;
        try {
            this.NR = context.getResources();
            this.NT = this.NR;
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
                    bVar.ca(String.valueOf(attributeName) + "=" + this.NR.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.NQ != null && !this.NQ.containsKey(bVar.getId())) {
                    this.NQ.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.NQ.containsKey(bVar.getId());
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
            return new int[]{parseInt, a(this.NR, this.NT, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (NU) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (NW == 0) {
                    NV = BdBaseApplication.getInst().getPackageName();
                    NW = NV.length();
                }
                if (resourceName.length() > NW && resourceName.charAt(NW) != ':' && resourceName.startsWith(NV)) {
                    resourceName = String.valueOf(NV) + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.NQ != null && this.NQ.containsKey(str)) {
            b bVar = this.NQ.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.op() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.isNightMode, bVar.oo(), bVar.op()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.ot() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.NR.getResourceTypeName(bVar.os());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.os(), bVar.ot()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.os(), bVar.ot()));
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
        if (this.NQ != null && this.NQ.containsKey(str)) {
            b bVar = this.NQ.get(str);
            if (view instanceof TextView) {
                if (bVar.ox() != 0) {
                    ((TextView) view).setTextColor(d(this.isNightMode, bVar.ow(), bVar.ox()));
                }
                if (bVar.ov() != 0) {
                    ((TextView) view).setHintTextColor(d(this.isNightMode, bVar.ou(), bVar.ov()));
                }
                if (bVar.oA() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.isNightMode ? bVar.oA() : bVar.oB());
                }
                if (bVar.on() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.isNightMode, bVar.om(), bVar.on()), (Drawable) null, (Drawable) null);
                }
                if (bVar.ol() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.isNightMode, bVar.ok(), bVar.ol()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.or() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.isNightMode, bVar.oq(), bVar.or()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.oy() != 0 && (b3 = b(this.isNightMode, bVar.oz(), bVar.oy())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.oy() != 0 && (b2 = b(this.isNightMode, bVar.oz(), bVar.oy())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.oD() != 0 && (b = b(this.isNightMode, bVar.oC(), bVar.oD())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.ot() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.NR.getResourceTypeName(bVar.os());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.isNightMode, bVar.os(), bVar.ot()));
                } else {
                    view.setBackgroundDrawable(b(this.isNightMode, bVar.os(), bVar.ot()));
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
                return this.NR.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.NT = this.NR;
            i2 = a(this.NR, this.NT, i);
        }
        if (this.NT == null) {
            try {
                return this.NR.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.NT.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.NR.getDrawable(i);
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
            return this.NR.getColor(i);
        }
        if (i == i2) {
            this.NT = this.NR;
            i2 = a(this.NR, this.NT, i);
        }
        if (this.NT == null) {
            return this.NR.getColor(i);
        }
        try {
            return this.NT.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.NR.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return av.cM(i);
        }
        if (!z) {
            return this.NR.getColorStateList(i);
        }
        if (i == i2) {
            this.NT = this.NR;
            i2 = a(this.NR, this.NT, i);
        }
        if (this.NT == null) {
            return this.NR.getColorStateList(i);
        }
        try {
            return this.NT.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.NR.getColorStateList(i);
        }
    }

    public void ah(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.NT = resources;
    }

    public void destroy() {
        if (this.NQ != null) {
            this.NQ.clear();
            this.NQ = null;
        }
    }
}
