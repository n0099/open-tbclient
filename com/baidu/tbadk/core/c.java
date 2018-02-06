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
    public static boolean aJm = false;
    private static String aJn = null;
    private static int aJo = 0;
    private Resources aJk;
    private Resources aJl;
    private boolean isNightMode = false;
    Map<String, b> aJj = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cJ;
        int h;
        boolean z = false;
        try {
            this.aJk = context.getResources();
            this.aJl = this.aJk;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cI(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cJ2 = cJ(attributeValue);
                    if (cJ2 != null) {
                        bVar.ek(cJ2[0]);
                        bVar.el(cJ2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cJ3 = cJ(attributeValue);
                    if (cJ3 != null) {
                        bVar.eq(cJ3[0]);
                        bVar.er(cJ3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cJ4 = cJ(attributeValue);
                    if (cJ4 != null) {
                        bVar.eo(cJ4[0]);
                        bVar.ep(cJ4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cJ5 = cJ(attributeValue);
                    if (cJ5 != null) {
                        bVar.et(cJ5[0]);
                        bVar.es(cJ5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cJ6 = cJ(attributeValue);
                    if (cJ6 != null) {
                        bVar.eg(cJ6[0]);
                        bVar.eh(cJ6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cJ7 = cJ(attributeValue);
                    if (cJ7 != null) {
                        bVar.ee(cJ7[0]);
                        bVar.ef(cJ7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cJ8 = cJ(attributeValue);
                    if (cJ8 != null) {
                        bVar.ec(cJ8[0]);
                        bVar.ed(cJ8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cJ9 = cJ(attributeValue);
                    if (cJ9 != null) {
                        bVar.ei(cJ9[0]);
                        bVar.ej(cJ9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cJ10 = cJ(attributeValue);
                    if (cJ10 != null) {
                        bVar.eu(cJ10[0]);
                        bVar.ev(cJ10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cJ = cJ(attributeValue)) != null) {
                    bVar.em(cJ[0]);
                    bVar.en(cJ[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (h = com.baidu.adp.lib.g.b.h(attributeValue.substring(1), 0)) != 0) {
                    bVar.cH(attributeName + "=" + this.aJk.getResourceName(h));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.aJj != null && !this.aJj.containsKey(bVar.getId())) {
                    this.aJj.put(bVar.getId(), bVar);
                    return;
                }
                if (TextUtils.isEmpty(bVar.getId()) || this.aJj.containsKey(bVar.getId())) {
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] cJ(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.aJk, this.aJl, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (aJm) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (aJo == 0) {
                    aJn = BdBaseApplication.getInst().getPackageName();
                    aJo = aJn.length();
                }
                if (resourceName.length() > aJo && resourceName.charAt(aJo) != ':' && resourceName.startsWith(aJn)) {
                    resourceName = aJn + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.aJj != null && this.aJj.containsKey(str)) {
            b bVar = this.aJj.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.wV() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.isNightMode, bVar.wU(), bVar.wV()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.wZ() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.aJk.getResourceTypeName(bVar.wY());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.wY(), bVar.wZ()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.wY(), bVar.wZ()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void aN(View view) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        int xh;
        String str = "@" + view.getId();
        if (this.aJj != null && this.aJj.containsKey(str)) {
            b bVar = this.aJj.get(str);
            if (view instanceof TextView) {
                if (bVar.xd() != 0) {
                    ((TextView) view).setTextColor(d(this.isNightMode, bVar.xc(), bVar.xd()));
                }
                if (bVar.xb() != 0) {
                    ((TextView) view).setHintTextColor(d(this.isNightMode, bVar.xa(), bVar.xb()));
                }
                if (bVar.xg() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.isNightMode) {
                        xh = bVar.xg();
                    } else {
                        xh = bVar.xh();
                    }
                    textView.setTextAppearance(context, xh);
                }
                if (bVar.wT() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.isNightMode, bVar.wS(), bVar.wT()), (Drawable) null, (Drawable) null);
                }
                if (bVar.wR() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.isNightMode, bVar.wQ(), bVar.wR()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.wX() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.isNightMode, bVar.wW(), bVar.wX()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.xe() != 0 && (b3 = b(this.isNightMode, bVar.xf(), bVar.xe())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.xe() != 0 && (b2 = b(this.isNightMode, bVar.xf(), bVar.xe())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.xj() != 0 && (b = b(this.isNightMode, bVar.xi(), bVar.xj())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.wZ() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.aJk.getResourceTypeName(bVar.wY());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.isNightMode, bVar.wY(), bVar.wZ()));
                } else {
                    view.setBackgroundDrawable(b(this.isNightMode, bVar.wY(), bVar.wZ()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return aj.getDrawable(i);
        }
        if (!z) {
            try {
                return this.aJk.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.aJl = this.aJk;
            i2 = a(this.aJk, this.aJl, i);
        }
        if (this.aJl == null) {
            try {
                return this.aJk.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.aJl.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.aJk.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return aj.getColor(i);
        }
        if (!z) {
            return this.aJk.getColor(i);
        }
        if (i == i2) {
            this.aJl = this.aJk;
            i2 = a(this.aJk, this.aJl, i);
        }
        if (this.aJl == null) {
            return this.aJk.getColor(i);
        }
        try {
            return this.aJl.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.aJk.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return aj.fN(i);
        }
        if (!z) {
            return this.aJk.getColorStateList(i);
        }
        if (i == i2) {
            this.aJl = this.aJk;
            i2 = a(this.aJk, this.aJl, i);
        }
        if (this.aJl == null) {
            return this.aJk.getColorStateList(i);
        }
        try {
            return this.aJl.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.aJk.getColorStateList(i);
        }
    }

    public void aQ(boolean z) {
        this.isNightMode = z;
    }

    public void c(Resources resources) {
        this.aJl = resources;
    }

    public void destroy() {
        if (this.aJj != null) {
            this.aJj.clear();
            this.aJj = null;
        }
    }
}
