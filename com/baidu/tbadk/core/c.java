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
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    public static boolean NW = false;
    private static String NX = null;
    private static int NY = 0;
    private Resources NU;
    private Resources NV;
    private boolean isNightMode = false;
    Map<String, b> NT = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] cd;
        int g;
        boolean z = false;
        try {
            this.NU = context.getResources();
            this.NV = this.NU;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.cc(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] cd2 = cd(attributeValue);
                    if (cd2 != null) {
                        bVar.bm(cd2[0]);
                        bVar.bn(cd2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] cd3 = cd(attributeValue);
                    if (cd3 != null) {
                        bVar.bs(cd3[0]);
                        bVar.bt(cd3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] cd4 = cd(attributeValue);
                    if (cd4 != null) {
                        bVar.bq(cd4[0]);
                        bVar.br(cd4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] cd5 = cd(attributeValue);
                    if (cd5 != null) {
                        bVar.bv(cd5[0]);
                        bVar.bu(cd5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] cd6 = cd(attributeValue);
                    if (cd6 != null) {
                        bVar.bi(cd6[0]);
                        bVar.bj(cd6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] cd7 = cd(attributeValue);
                    if (cd7 != null) {
                        bVar.bg(cd7[0]);
                        bVar.bh(cd7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] cd8 = cd(attributeValue);
                    if (cd8 != null) {
                        bVar.be(cd8[0]);
                        bVar.bf(cd8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] cd9 = cd(attributeValue);
                    if (cd9 != null) {
                        bVar.bk(cd9[0]);
                        bVar.bl(cd9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] cd10 = cd(attributeValue);
                    if (cd10 != null) {
                        bVar.bw(cd10[0]);
                        bVar.bx(cd10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (cd = cd(attributeValue)) != null) {
                    bVar.bo(cd[0]);
                    bVar.bp(cd[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (g = com.baidu.adp.lib.h.b.g(attributeValue.substring(1), 0)) != 0) {
                    bVar.cb(String.valueOf(attributeName) + "=" + this.NU.getResourceName(g));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.NT != null && !this.NT.containsKey(bVar.getId())) {
                    this.NT.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.NT.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] cd(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.NU, this.NV, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        if (NW) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                str = resourceName;
                i2 = i;
            } else {
                if (NY == 0) {
                    NX = BdBaseApplication.getInst().getPackageName();
                    NY = NX.length();
                }
                if (resourceName.length() > NY && resourceName.charAt(NY) != ':' && resourceName.startsWith(NX)) {
                    resourceName = String.valueOf(NX) + resourceName.substring(resourceName.indexOf(":"));
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
        if (this.NT != null && this.NT.containsKey(str)) {
            b bVar = this.NT.get(str);
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
                String resourceTypeName = this.NU.getResourceTypeName(bVar.ou());
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
        if (this.NT != null && this.NT.containsKey(str)) {
            b bVar = this.NT.get(str);
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
                String resourceTypeName = this.NU.getResourceTypeName(bVar.ou());
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
            return at.getDrawable(i);
        }
        if (!z) {
            try {
                return this.NU.getDrawable(i);
            } catch (Throwable th) {
                return null;
            }
        }
        if (i == i2) {
            this.NV = this.NU;
            i2 = a(this.NU, this.NV, i);
        }
        if (this.NV == null) {
            try {
                return this.NU.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
        try {
            return this.NV.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            try {
                return this.NU.getDrawable(i);
            } catch (Throwable th3) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        }
    }

    private int c(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return at.getColor(i);
        }
        if (!z) {
            return this.NU.getColor(i);
        }
        if (i == i2) {
            this.NV = this.NU;
            i2 = a(this.NU, this.NV, i);
        }
        if (this.NV == null) {
            return this.NU.getColor(i);
        }
        try {
            return this.NV.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.NU.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            return at.cN(i);
        }
        if (!z) {
            return this.NU.getColorStateList(i);
        }
        if (i == i2) {
            this.NV = this.NU;
            i2 = a(this.NU, this.NV, i);
        }
        if (this.NV == null) {
            return this.NU.getColorStateList(i);
        }
        try {
            return this.NV.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.NU.getColorStateList(i);
        }
    }

    public void ai(boolean z) {
        this.isNightMode = z;
    }

    public void b(Resources resources) {
        this.NV = resources;
    }

    public void destroy() {
        if (this.NT != null) {
            this.NT.clear();
            this.NT = null;
        }
    }
}
