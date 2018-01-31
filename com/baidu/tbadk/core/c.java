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
    public static boolean aHS = false;
    private static String aHT = null;
    private static int aHU = 0;
    private Resources aHQ;
    private Resources aHR;
    private boolean isNightMode = false;
    Map<String, b> aHP = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cy;
        int h;
        boolean z = false;
        try {
            this.aHQ = context.getResources();
            this.aHR = this.aHQ;
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
                    bVar.cw(attributeName + "=" + this.aHQ.getResourceName(h));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.aHP != null && !this.aHP.containsKey(bVar.getId())) {
                    this.aHP.put(bVar.getId(), bVar);
                    return;
                }
                if (TextUtils.isEmpty(bVar.getId()) || this.aHP.containsKey(bVar.getId())) {
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
            return new int[]{parseInt, a(this.aHQ, this.aHR, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (aHS) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (aHU == 0) {
                    aHT = BdBaseApplication.getInst().getPackageName();
                    aHU = aHT.length();
                }
                if (resourceName.length() > aHU && resourceName.charAt(aHU) != ':' && resourceName.startsWith(aHT)) {
                    resourceName = aHT + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.aHP != null && this.aHP.containsKey(str)) {
            b bVar = this.aHP.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.wi() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(a(this.isNightMode, bVar.wh(), bVar.wi()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.wm() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.aHQ.getResourceTypeName(bVar.wl());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(b(this.isNightMode, bVar.wl(), bVar.wm()));
                } else {
                    viewGroup.setBackgroundDrawable(a(this.isNightMode, bVar.wl(), bVar.wm()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void aN(View view) {
        Drawable a;
        Drawable a2;
        Drawable a3;
        int wu;
        String str = "@" + view.getId();
        if (this.aHP != null && this.aHP.containsKey(str)) {
            b bVar = this.aHP.get(str);
            if (view instanceof TextView) {
                if (bVar.wq() != 0) {
                    ((TextView) view).setTextColor(c(this.isNightMode, bVar.wp(), bVar.wq()));
                }
                if (bVar.wo() != 0) {
                    ((TextView) view).setHintTextColor(c(this.isNightMode, bVar.wn(), bVar.wo()));
                }
                if (bVar.wt() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.isNightMode) {
                        wu = bVar.wt();
                    } else {
                        wu = bVar.wu();
                    }
                    textView.setTextAppearance(context, wu);
                }
                if (bVar.wg() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, a(this.isNightMode, bVar.wf(), bVar.wg()), (Drawable) null, (Drawable) null);
                }
                if (bVar.we() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(a(this.isNightMode, bVar.wd(), bVar.we()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.wk() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a(this.isNightMode, bVar.wj(), bVar.wk()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.wr() != 0 && (a3 = a(this.isNightMode, bVar.ws(), bVar.wr())) != null) {
                    ((ImageView) view).setImageDrawable(a3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.wr() != 0 && (a2 = a(this.isNightMode, bVar.ws(), bVar.wr())) != null) {
                    ((ImageView) view).setImageDrawable(a2);
                }
            } else if ((view instanceof ProgressBar) && bVar.ww() != 0 && (a = a(this.isNightMode, bVar.wv(), bVar.ww())) != null) {
                ((ProgressBar) view).setProgressDrawable(a);
            }
            if (bVar.wm() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.aHQ.getResourceTypeName(bVar.wl());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(b(this.isNightMode, bVar.wl(), bVar.wm()));
                } else {
                    view.setBackgroundDrawable(a(this.isNightMode, bVar.wl(), bVar.wm()));
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
                return this.aHQ.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.aHR = this.aHQ;
            i2 = a(this.aHQ, this.aHR, i);
        }
        if (this.aHR == null) {
            try {
                return this.aHQ.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.aHR.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.aHQ.getDrawable(i);
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
            return this.aHQ.getColor(i);
        }
        if (i == i2) {
            this.aHR = this.aHQ;
            i2 = a(this.aHQ, this.aHR, i);
        }
        if (this.aHR == null) {
            return this.aHQ.getColor(i);
        }
        try {
            return this.aHR.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.aHQ.getColor(i);
        }
    }

    private ColorStateList c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return aj.fN(i);
        }
        if (!z) {
            return this.aHQ.getColorStateList(i);
        }
        if (i == i2) {
            this.aHR = this.aHQ;
            i2 = a(this.aHQ, this.aHR, i);
        }
        if (this.aHR == null) {
            return this.aHQ.getColorStateList(i);
        }
        try {
            return this.aHR.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.aHQ.getColorStateList(i);
        }
    }

    public void aN(boolean z) {
        this.isNightMode = z;
    }

    public void c(Resources resources) {
        this.aHR = resources;
    }

    public void destroy() {
        if (this.aHP != null) {
            this.aHP.clear();
            this.aHP = null;
        }
    }
}
