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
        int[] cl;
        int g;
        boolean z = false;
        try {
            this.Sp = context.getResources();
            this.Sq = this.Sp;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.ck(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cl2 = cl(attributeValue);
                    if (cl2 != null) {
                        bVar.bl(cl2[0]);
                        bVar.bm(cl2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cl3 = cl(attributeValue);
                    if (cl3 != null) {
                        bVar.br(cl3[0]);
                        bVar.bs(cl3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cl4 = cl(attributeValue);
                    if (cl4 != null) {
                        bVar.bp(cl4[0]);
                        bVar.bq(cl4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cl5 = cl(attributeValue);
                    if (cl5 != null) {
                        bVar.bu(cl5[0]);
                        bVar.bt(cl5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cl6 = cl(attributeValue);
                    if (cl6 != null) {
                        bVar.bh(cl6[0]);
                        bVar.bi(cl6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cl7 = cl(attributeValue);
                    if (cl7 != null) {
                        bVar.bf(cl7[0]);
                        bVar.bg(cl7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cl8 = cl(attributeValue);
                    if (cl8 != null) {
                        bVar.bd(cl8[0]);
                        bVar.be(cl8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cl9 = cl(attributeValue);
                    if (cl9 != null) {
                        bVar.bj(cl9[0]);
                        bVar.bk(cl9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cl10 = cl(attributeValue);
                    if (cl10 != null) {
                        bVar.bv(cl10[0]);
                        bVar.bw(cl10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cl = cl(attributeValue)) != null) {
                    bVar.bn(cl[0]);
                    bVar.bo(cl[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.g.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.cj(attributeName + "=" + this.Sp.getResourceName(g));
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

    private final int[] cl(String str) {
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
                if ((viewGroup instanceof ListView) && bVar.ot() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(a(this.Sn, bVar.os(), bVar.ot()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.ox() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Sp.getResourceTypeName(bVar.ow());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(b(this.Sn, bVar.ow(), bVar.ox()));
                } else {
                    viewGroup.setBackgroundDrawable(a(this.Sn, bVar.ow(), bVar.ox()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void u(View view) {
        Drawable a;
        Drawable a2;
        Drawable a3;
        int oF;
        String str = "@" + view.getId();
        if (this.So != null && this.So.containsKey(str)) {
            b bVar = this.So.get(str);
            if (view instanceof TextView) {
                if (bVar.oB() != 0) {
                    ((TextView) view).setTextColor(c(this.Sn, bVar.oA(), bVar.oB()));
                }
                if (bVar.oz() != 0) {
                    ((TextView) view).setHintTextColor(c(this.Sn, bVar.oy(), bVar.oz()));
                }
                if (bVar.oE() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.Sn) {
                        oF = bVar.oE();
                    } else {
                        oF = bVar.oF();
                    }
                    textView.setTextAppearance(context, oF);
                }
                if (bVar.or() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, a(this.Sn, bVar.oq(), bVar.or()), (Drawable) null, (Drawable) null);
                }
                if (bVar.op() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(a(this.Sn, bVar.oo(), bVar.op()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.ov() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a(this.Sn, bVar.ou(), bVar.ov()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.oC() != 0 && (a3 = a(this.Sn, bVar.oD(), bVar.oC())) != null) {
                    ((ImageView) view).setImageDrawable(a3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.oC() != 0 && (a2 = a(this.Sn, bVar.oD(), bVar.oC())) != null) {
                    ((ImageView) view).setImageDrawable(a2);
                }
            } else if ((view instanceof ProgressBar) && bVar.oH() != 0 && (a = a(this.Sn, bVar.oG(), bVar.oH())) != null) {
                ((ProgressBar) view).setProgressDrawable(a);
            }
            if (bVar.ox() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Sp.getResourceTypeName(bVar.ow());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(b(this.Sn, bVar.ow(), bVar.ox()));
                } else {
                    view.setBackgroundDrawable(a(this.Sn, bVar.ow(), bVar.ox()));
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
            return aj.cP(i);
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
