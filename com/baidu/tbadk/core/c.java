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
import com.baidu.tbadk.core.util.aj;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean aHP = false;
    private static String aHQ = null;
    private static int aHR = 0;
    private Resources aHN;
    private Resources aHO;
    private boolean isNightMode = false;
    Map<String, b> aHM = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cy;
        int h;
        boolean z = false;
        try {
            this.aHN = context.getResources();
            this.aHO = this.aHN;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cx(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cy2 = cy(attributeValue);
                    if (cy2 != null) {
                        bVar.ek(cy2[0]);
                        bVar.el(cy2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cy3 = cy(attributeValue);
                    if (cy3 != null) {
                        bVar.eq(cy3[0]);
                        bVar.er(cy3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cy4 = cy(attributeValue);
                    if (cy4 != null) {
                        bVar.eo(cy4[0]);
                        bVar.ep(cy4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cy5 = cy(attributeValue);
                    if (cy5 != null) {
                        bVar.et(cy5[0]);
                        bVar.es(cy5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cy6 = cy(attributeValue);
                    if (cy6 != null) {
                        bVar.eg(cy6[0]);
                        bVar.eh(cy6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cy7 = cy(attributeValue);
                    if (cy7 != null) {
                        bVar.ee(cy7[0]);
                        bVar.ef(cy7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cy8 = cy(attributeValue);
                    if (cy8 != null) {
                        bVar.ec(cy8[0]);
                        bVar.ed(cy8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cy9 = cy(attributeValue);
                    if (cy9 != null) {
                        bVar.ei(cy9[0]);
                        bVar.ej(cy9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cy10 = cy(attributeValue);
                    if (cy10 != null) {
                        bVar.eu(cy10[0]);
                        bVar.ev(cy10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cy = cy(attributeValue)) != null) {
                    bVar.em(cy[0]);
                    bVar.en(cy[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (h = com.baidu.adp.lib.g.b.h(attributeValue.substring(1), 0)) != 0) {
                    bVar.cw(attributeName + "=" + this.aHN.getResourceName(h));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.aHM != null && !this.aHM.containsKey(bVar.getId())) {
                    this.aHM.put(bVar.getId(), bVar);
                    return;
                }
                if (TextUtils.isEmpty(bVar.getId()) || this.aHM.containsKey(bVar.getId())) {
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] cy(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.aHN, this.aHO, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (aHP) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (aHR == 0) {
                    aHQ = BdBaseApplication.getInst().getPackageName();
                    aHR = aHQ.length();
                }
                if (resourceName.length() > aHR && resourceName.charAt(aHR) != ':' && resourceName.startsWith(aHQ)) {
                    resourceName = aHQ + resourceName.substring(resourceName.indexOf(":"));
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

    public void aM(View view) {
        if (view != null) {
            Stack stack = new Stack();
            stack.push(view);
            while (!stack.isEmpty()) {
                View view2 = (View) stack.pop();
                if (view2 instanceof ViewGroup) {
                    k((ViewGroup) view2);
                    if (!(view2 instanceof AdapterView)) {
                        int childCount = ((ViewGroup) view2).getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            stack.push(((ViewGroup) view2).getChildAt(i));
                        }
                    }
                } else {
                    aN(view2);
                }
            }
        }
    }

    private void k(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.aHM != null && this.aHM.containsKey(str)) {
            b bVar = this.aHM.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.wh() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(a(this.isNightMode, bVar.wg(), bVar.wh()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.wl() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.aHN.getResourceTypeName(bVar.wk());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(b(this.isNightMode, bVar.wk(), bVar.wl()));
                } else {
                    viewGroup.setBackgroundDrawable(a(this.isNightMode, bVar.wk(), bVar.wl()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void aN(View view) {
        Drawable a;
        Drawable a2;
        Drawable a3;
        int wt;
        String str = "@" + view.getId();
        if (this.aHM != null && this.aHM.containsKey(str)) {
            b bVar = this.aHM.get(str);
            if (view instanceof TextView) {
                if (bVar.wp() != 0) {
                    ((TextView) view).setTextColor(c(this.isNightMode, bVar.wo(), bVar.wp()));
                }
                if (bVar.wn() != 0) {
                    ((TextView) view).setHintTextColor(c(this.isNightMode, bVar.wm(), bVar.wn()));
                }
                if (bVar.ws() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.isNightMode) {
                        wt = bVar.ws();
                    } else {
                        wt = bVar.wt();
                    }
                    textView.setTextAppearance(context, wt);
                }
                if (bVar.wf() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, a(this.isNightMode, bVar.we(), bVar.wf()), (Drawable) null, (Drawable) null);
                }
                if (bVar.wd() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(a(this.isNightMode, bVar.wc(), bVar.wd()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.wj() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a(this.isNightMode, bVar.wi(), bVar.wj()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.wq() != 0 && (a3 = a(this.isNightMode, bVar.wr(), bVar.wq())) != null) {
                    ((ImageView) view).setImageDrawable(a3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.wq() != 0 && (a2 = a(this.isNightMode, bVar.wr(), bVar.wq())) != null) {
                    ((ImageView) view).setImageDrawable(a2);
                }
            } else if ((view instanceof ProgressBar) && bVar.wv() != 0 && (a = a(this.isNightMode, bVar.wu(), bVar.wv())) != null) {
                ((ProgressBar) view).setProgressDrawable(a);
            }
            if (bVar.wl() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.aHN.getResourceTypeName(bVar.wk());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(b(this.isNightMode, bVar.wk(), bVar.wl()));
                } else {
                    view.setBackgroundDrawable(a(this.isNightMode, bVar.wk(), bVar.wl()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable a(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return aj.getDrawable(i);
        }
        if (!z) {
            try {
                return this.aHN.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.aHO = this.aHN;
            i2 = a(this.aHN, this.aHO, i);
        }
        if (this.aHO == null) {
            try {
                return this.aHN.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.aHO.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.aHN.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return aj.getColor(i);
        }
        if (!z) {
            return this.aHN.getColor(i);
        }
        if (i == i2) {
            this.aHO = this.aHN;
            i2 = a(this.aHN, this.aHO, i);
        }
        if (this.aHO == null) {
            return this.aHN.getColor(i);
        }
        try {
            return this.aHO.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.aHN.getColor(i);
        }
    }

    private ColorStateList c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return aj.fN(i);
        }
        if (!z) {
            return this.aHN.getColorStateList(i);
        }
        if (i == i2) {
            this.aHO = this.aHN;
            i2 = a(this.aHN, this.aHO, i);
        }
        if (this.aHO == null) {
            return this.aHN.getColorStateList(i);
        }
        try {
            return this.aHO.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.aHN.getColorStateList(i);
        }
    }

    public void aM(boolean z) {
        this.isNightMode = z;
    }

    public void c(Resources resources) {
        this.aHO = resources;
    }

    public void destroy() {
        if (this.aHM != null) {
            this.aHM.clear();
            this.aHM = null;
        }
    }
}
