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
    public static boolean Sr = false;
    private static String Ss = null;
    private static int St = 0;
    private boolean Sn = false;
    Map<String, b> So = new HashMap();
    private Resources Sp;
    private Resources Sq;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cm;
        int g;
        boolean z = false;
        try {
            this.Sp = context.getResources();
            this.Sq = this.Sp;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cl(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cm2 = cm(attributeValue);
                    if (cm2 != null) {
                        bVar.bi(cm2[0]);
                        bVar.bj(cm2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cm3 = cm(attributeValue);
                    if (cm3 != null) {
                        bVar.bo(cm3[0]);
                        bVar.bp(cm3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cm4 = cm(attributeValue);
                    if (cm4 != null) {
                        bVar.bm(cm4[0]);
                        bVar.bn(cm4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cm5 = cm(attributeValue);
                    if (cm5 != null) {
                        bVar.br(cm5[0]);
                        bVar.bq(cm5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cm6 = cm(attributeValue);
                    if (cm6 != null) {
                        bVar.be(cm6[0]);
                        bVar.bf(cm6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cm7 = cm(attributeValue);
                    if (cm7 != null) {
                        bVar.bc(cm7[0]);
                        bVar.bd(cm7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cm8 = cm(attributeValue);
                    if (cm8 != null) {
                        bVar.ba(cm8[0]);
                        bVar.bb(cm8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cm9 = cm(attributeValue);
                    if (cm9 != null) {
                        bVar.bg(cm9[0]);
                        bVar.bh(cm9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cm10 = cm(attributeValue);
                    if (cm10 != null) {
                        bVar.bs(cm10[0]);
                        bVar.bt(cm10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cm = cm(attributeValue)) != null) {
                    bVar.bk(cm[0]);
                    bVar.bl(cm[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.ck(attributeName + "=" + this.Sp.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.So != null && !this.So.containsKey(bVar.getId())) {
                    this.So.put(bVar.getId(), bVar);
                    return;
                }
                if (TextUtils.isEmpty(bVar.getId()) || this.So.containsKey(bVar.getId())) {
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] cm(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Sp, this.Sq, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (Sr) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (St == 0) {
                    Ss = BdBaseApplication.getInst().getPackageName();
                    St = Ss.length();
                }
                if (resourceName.length() > St && resourceName.charAt(St) != ':' && resourceName.startsWith(Ss)) {
                    resourceName = Ss + resourceName.substring(resourceName.indexOf(":"));
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

    public void t(View view) {
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
                    u(view2);
                }
            }
        }
    }

    private void b(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.So != null && this.So.containsKey(str)) {
            b bVar = this.So.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.oz() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(a(this.Sn, bVar.oy(), bVar.oz()));
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
                String resourceTypeName = this.Sp.getResourceTypeName(bVar.oC());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(b(this.Sn, bVar.oC(), bVar.oD()));
                } else {
                    viewGroup.setBackgroundDrawable(a(this.Sn, bVar.oC(), bVar.oD()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void u(View view) {
        Drawable a;
        Drawable a2;
        Drawable a3;
        int oL;
        String str = "@" + view.getId();
        if (this.So != null && this.So.containsKey(str)) {
            b bVar = this.So.get(str);
            if (view instanceof TextView) {
                if (bVar.oH() != 0) {
                    ((TextView) view).setTextColor(c(this.Sn, bVar.oG(), bVar.oH()));
                }
                if (bVar.oF() != 0) {
                    ((TextView) view).setHintTextColor(c(this.Sn, bVar.oE(), bVar.oF()));
                }
                if (bVar.oK() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.Sn) {
                        oL = bVar.oK();
                    } else {
                        oL = bVar.oL();
                    }
                    textView.setTextAppearance(context, oL);
                }
                if (bVar.ox() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, a(this.Sn, bVar.ow(), bVar.ox()), (Drawable) null, (Drawable) null);
                }
                if (bVar.ov() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(a(this.Sn, bVar.ou(), bVar.ov()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.oB() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a(this.Sn, bVar.oA(), bVar.oB()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.oI() != 0 && (a3 = a(this.Sn, bVar.oJ(), bVar.oI())) != null) {
                    ((ImageView) view).setImageDrawable(a3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.oI() != 0 && (a2 = a(this.Sn, bVar.oJ(), bVar.oI())) != null) {
                    ((ImageView) view).setImageDrawable(a2);
                }
            } else if ((view instanceof ProgressBar) && bVar.oN() != 0 && (a = a(this.Sn, bVar.oM(), bVar.oN())) != null) {
                ((ProgressBar) view).setProgressDrawable(a);
            }
            if (bVar.oD() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Sp.getResourceTypeName(bVar.oC());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(b(this.Sn, bVar.oC(), bVar.oD()));
                } else {
                    view.setBackgroundDrawable(a(this.Sn, bVar.oC(), bVar.oD()));
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
                return this.Sp.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.Sq = this.Sp;
            i2 = a(this.Sp, this.Sq, i);
        }
        if (this.Sq == null) {
            try {
                return this.Sp.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.Sq.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.Sp.getDrawable(i);
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
            return this.Sp.getColor(i);
        }
        if (i == i2) {
            this.Sq = this.Sp;
            i2 = a(this.Sp, this.Sq, i);
        }
        if (this.Sq == null) {
            return this.Sp.getColor(i);
        }
        try {
            return this.Sq.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Sp.getColor(i);
        }
    }

    private ColorStateList c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            return aj.cS(i);
        }
        if (!z) {
            return this.Sp.getColorStateList(i);
        }
        if (i == i2) {
            this.Sq = this.Sp;
            i2 = a(this.Sp, this.Sq, i);
        }
        if (this.Sq == null) {
            return this.Sp.getColorStateList(i);
        }
        try {
            return this.Sq.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Sp.getColorStateList(i);
        }
    }

    public void ah(boolean z) {
        this.Sn = z;
    }

    public void b(Resources resources) {
        this.Sq = resources;
    }

    public void destroy() {
        if (this.So != null) {
            this.So.clear();
            this.So = null;
        }
    }
}
