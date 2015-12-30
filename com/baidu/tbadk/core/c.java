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
import com.baidu.tbadk.core.util.as;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean TW = false;
    private static String TX = null;
    private static int TY = 0;
    private boolean TS = false;
    Map<String, b> TT = new HashMap();
    private Resources TU;
    private Resources TV;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] ch;
        int g;
        boolean z = false;
        try {
            this.TU = context.getResources();
            this.TV = this.TU;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cg(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] ch2 = ch(attributeValue);
                    if (ch2 != null) {
                        bVar.aW(ch2[0]);
                        bVar.aX(ch2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] ch3 = ch(attributeValue);
                    if (ch3 != null) {
                        bVar.bc(ch3[0]);
                        bVar.bd(ch3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] ch4 = ch(attributeValue);
                    if (ch4 != null) {
                        bVar.ba(ch4[0]);
                        bVar.bb(ch4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] ch5 = ch(attributeValue);
                    if (ch5 != null) {
                        bVar.bf(ch5[0]);
                        bVar.be(ch5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] ch6 = ch(attributeValue);
                    if (ch6 != null) {
                        bVar.aS(ch6[0]);
                        bVar.aT(ch6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] ch7 = ch(attributeValue);
                    if (ch7 != null) {
                        bVar.aQ(ch7[0]);
                        bVar.aR(ch7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] ch8 = ch(attributeValue);
                    if (ch8 != null) {
                        bVar.aO(ch8[0]);
                        bVar.aP(ch8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] ch9 = ch(attributeValue);
                    if (ch9 != null) {
                        bVar.aU(ch9[0]);
                        bVar.aV(ch9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] ch10 = ch(attributeValue);
                    if (ch10 != null) {
                        bVar.bg(ch10[0]);
                        bVar.bh(ch10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (ch = ch(attributeValue)) != null) {
                    bVar.aY(ch[0]);
                    bVar.aZ(ch[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.h.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.cf(String.valueOf(attributeName) + "=" + this.TU.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.TT != null && !this.TT.containsKey(bVar.getId())) {
                    this.TT.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.TT.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] ch(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.TU, this.TV, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (TW) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (TY == 0) {
                    TX = BdBaseApplication.getInst().getPackageName();
                    TY = TX.length();
                }
                if (resourceName.length() > TY && resourceName.charAt(TY) != ':' && resourceName.startsWith(TX)) {
                    resourceName = String.valueOf(TX) + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.TT != null && this.TT.containsKey(str)) {
            b bVar = this.TT.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.qy() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(c(this.TS, bVar.qx(), bVar.qy()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.qC() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.TU.getResourceTypeName(bVar.qB());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(d(this.TS, bVar.qB(), bVar.qC()));
                } else {
                    viewGroup.setBackgroundDrawable(c(this.TS, bVar.qB(), bVar.qC()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void l(View view) {
        Drawable c;
        Drawable c2;
        Drawable c3;
        String str = "@" + view.getId();
        if (this.TT != null && this.TT.containsKey(str)) {
            b bVar = this.TT.get(str);
            if (view instanceof TextView) {
                if (bVar.qG() != 0) {
                    ((TextView) view).setTextColor(e(this.TS, bVar.qF(), bVar.qG()));
                }
                if (bVar.qE() != 0) {
                    ((TextView) view).setHintTextColor(e(this.TS, bVar.qD(), bVar.qE()));
                }
                if (bVar.qJ() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.TS ? bVar.qJ() : bVar.qK());
                }
                if (bVar.qw() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, c(this.TS, bVar.qv(), bVar.qw()), (Drawable) null, (Drawable) null);
                }
                if (bVar.qu() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(c(this.TS, bVar.qt(), bVar.qu()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.qA() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, c(this.TS, bVar.qz(), bVar.qA()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.qH() != 0 && (c3 = c(this.TS, bVar.qI(), bVar.qH())) != null) {
                    ((ImageView) view).setImageDrawable(c3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.qH() != 0 && (c2 = c(this.TS, bVar.qI(), bVar.qH())) != null) {
                    ((ImageView) view).setImageDrawable(c2);
                }
            } else if ((view instanceof ProgressBar) && bVar.qM() != 0 && (c = c(this.TS, bVar.qL(), bVar.qM())) != null) {
                ((ProgressBar) view).setProgressDrawable(c);
            }
            if (bVar.qC() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.TU.getResourceTypeName(bVar.qB());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(d(this.TS, bVar.qB(), bVar.qC()));
                } else {
                    view.setBackgroundDrawable(c(this.TS, bVar.qB(), bVar.qC()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return as.getDrawable(i);
        }
        if (!z) {
            try {
                return this.TU.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.TV = this.TU;
            i2 = a(this.TU, this.TV, i);
        }
        if (this.TV == null) {
            try {
                return this.TU.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.TV.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.TU.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        }
    }

    private int d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return as.getColor(i);
        }
        if (!z) {
            return this.TU.getColor(i);
        }
        if (i == i2) {
            this.TV = this.TU;
            i2 = a(this.TU, this.TV, i);
        }
        if (this.TV == null) {
            return this.TU.getColor(i);
        }
        try {
            return this.TV.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.TU.getColor(i);
        }
    }

    private ColorStateList e(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            return as.cw(i);
        }
        if (!z) {
            return this.TU.getColorStateList(i);
        }
        if (i == i2) {
            this.TV = this.TU;
            i2 = a(this.TU, this.TV, i);
        }
        if (this.TV == null) {
            return this.TU.getColorStateList(i);
        }
        try {
            return this.TV.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.TU.getColorStateList(i);
        }
    }

    public void ac(boolean z) {
        this.TS = z;
    }

    public void b(Resources resources) {
        this.TV = resources;
    }

    public void destroy() {
        if (this.TT != null) {
            this.TT.clear();
            this.TT = null;
        }
    }
}
