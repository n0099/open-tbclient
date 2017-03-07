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
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean Si = false;
    private static String Sj = null;
    private static int Sk = 0;
    private Resources Sg;
    private Resources Sh;
    private boolean isNightMode = false;
    Map<String, b> Sf = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] bV;
        int g;
        boolean z = false;
        try {
            this.Sg = context.getResources();
            this.Sh = this.Sg;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.bU(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] bV2 = bV(attributeValue);
                    if (bV2 != null) {
                        bVar.bg(bV2[0]);
                        bVar.bh(bV2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] bV3 = bV(attributeValue);
                    if (bV3 != null) {
                        bVar.bm(bV3[0]);
                        bVar.bn(bV3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] bV4 = bV(attributeValue);
                    if (bV4 != null) {
                        bVar.bk(bV4[0]);
                        bVar.bl(bV4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] bV5 = bV(attributeValue);
                    if (bV5 != null) {
                        bVar.bp(bV5[0]);
                        bVar.bo(bV5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] bV6 = bV(attributeValue);
                    if (bV6 != null) {
                        bVar.bc(bV6[0]);
                        bVar.bd(bV6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] bV7 = bV(attributeValue);
                    if (bV7 != null) {
                        bVar.ba(bV7[0]);
                        bVar.bb(bV7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] bV8 = bV(attributeValue);
                    if (bV8 != null) {
                        bVar.aY(bV8[0]);
                        bVar.aZ(bV8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] bV9 = bV(attributeValue);
                    if (bV9 != null) {
                        bVar.be(bV9[0]);
                        bVar.bf(bV9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] bV10 = bV(attributeValue);
                    if (bV10 != null) {
                        bVar.bq(bV10[0]);
                        bVar.br(bV10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (bV = bV(attributeValue)) != null) {
                    bVar.bi(bV[0]);
                    bVar.bj(bV[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.bT(String.valueOf(attributeName) + "=" + this.Sg.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Sf != null && !this.Sf.containsKey(bVar.getId())) {
                    this.Sf.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.Sf.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] bV(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Sg, this.Sh, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (Si) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (Sk == 0) {
                    Sj = BdBaseApplication.getInst().getPackageName();
                    Sk = Sj.length();
                }
                if (resourceName.length() > Sk && resourceName.charAt(Sk) != ':' && resourceName.startsWith(Sj)) {
                    resourceName = String.valueOf(Sj) + resourceName.substring(resourceName.indexOf(":"));
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

    public void t(View view) {
        if (view != null) {
            Stack stack = new Stack();
            stack.push(view);
            while (!stack.isEmpty()) {
                View view2 = (View) stack.pop();
                if (view2 instanceof ViewGroup) {
                    a((ViewGroup) view2);
                    if (!(view2 instanceof AdapterView)) {
                        int childCount = ((ViewGroup) view2).getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            stack.push(((ViewGroup) view2).getChildAt(i));
                        }
                    }
                } else {
                    u(view2);
                }
            }
        }
    }

    private void a(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.Sf != null && this.Sf.containsKey(str)) {
            b bVar = this.Sf.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.oz() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.isNightMode, bVar.oy(), bVar.oz()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.oD() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Sg.getResourceTypeName(bVar.oC());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.isNightMode, bVar.oC(), bVar.oD()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.isNightMode, bVar.oC(), bVar.oD()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void u(View view) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        String str = "@" + view.getId();
        if (this.Sf != null && this.Sf.containsKey(str)) {
            b bVar = this.Sf.get(str);
            if (view instanceof TextView) {
                if (bVar.oH() != 0) {
                    ((TextView) view).setTextColor(d(this.isNightMode, bVar.oG(), bVar.oH()));
                }
                if (bVar.oF() != 0) {
                    ((TextView) view).setHintTextColor(d(this.isNightMode, bVar.oE(), bVar.oF()));
                }
                if (bVar.oK() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.isNightMode ? bVar.oK() : bVar.oL());
                }
                if (bVar.ox() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.isNightMode, bVar.ow(), bVar.ox()), (Drawable) null, (Drawable) null);
                }
                if (bVar.ov() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.isNightMode, bVar.ou(), bVar.ov()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.oB() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.isNightMode, bVar.oA(), bVar.oB()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.oI() != 0 && (b3 = b(this.isNightMode, bVar.oJ(), bVar.oI())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.oI() != 0 && (b2 = b(this.isNightMode, bVar.oJ(), bVar.oI())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.oN() != 0 && (b = b(this.isNightMode, bVar.oM(), bVar.oN())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.oD() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Sg.getResourceTypeName(bVar.oC());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.isNightMode, bVar.oC(), bVar.oD()));
                } else {
                    view.setBackgroundDrawable(b(this.isNightMode, bVar.oC(), bVar.oD()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return aq.getDrawable(i);
        }
        if (!z) {
            try {
                return this.Sg.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.Sh = this.Sg;
            i2 = a(this.Sg, this.Sh, i);
        }
        if (this.Sh == null) {
            try {
                return this.Sg.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.Sh.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Sg.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return aq.getColor(i);
        }
        if (!z) {
            return this.Sg.getColor(i);
        }
        if (i == i2) {
            this.Sh = this.Sg;
            i2 = a(this.Sg, this.Sh, i);
        }
        if (this.Sh == null) {
            return this.Sg.getColor(i);
        }
        try {
            return this.Sh.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Sg.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return aq.cK(i);
        }
        if (!z) {
            return this.Sg.getColorStateList(i);
        }
        if (i == i2) {
            this.Sh = this.Sg;
            i2 = a(this.Sg, this.Sh, i);
        }
        if (this.Sh == null) {
            return this.Sg.getColorStateList(i);
        }
        try {
            return this.Sh.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Sg.getColorStateList(i);
        }
    }

    public void ah(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.Sh = resources;
    }

    public void destroy() {
        if (this.Sf != null) {
            this.Sf.clear();
            this.Sf = null;
        }
    }
}
