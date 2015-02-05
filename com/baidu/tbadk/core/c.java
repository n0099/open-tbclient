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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    private boolean Ct = false;
    Map<String, b> Cu = new HashMap();
    private Resources Cv;
    private Resources Cw;

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] bH;
        int i;
        boolean z = false;
        try {
            this.Cv = context.getResources();
            this.Cw = this.Cv;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.bG(str);
            for (int i2 = 0; i2 < attributeCount; i2++) {
                String attributeName = attributeSet.getAttributeName(i2);
                String attributeValue = attributeSet.getAttributeValue(i2);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] bH2 = bH(attributeValue);
                    if (bH2 != null) {
                        bVar.aX(bH2[0]);
                        bVar.aY(bH2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] bH3 = bH(attributeValue);
                    if (bH3 != null) {
                        bVar.bd(bH3[0]);
                        bVar.be(bH3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] bH4 = bH(attributeValue);
                    if (bH4 != null) {
                        bVar.bb(bH4[0]);
                        bVar.bc(bH4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] bH5 = bH(attributeValue);
                    if (bH5 != null) {
                        bVar.bg(bH5[0]);
                        bVar.bf(bH5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] bH6 = bH(attributeValue);
                    if (bH6 != null) {
                        bVar.aT(bH6[0]);
                        bVar.aU(bH6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] bH7 = bH(attributeValue);
                    if (bH7 != null) {
                        bVar.aR(bH7[0]);
                        bVar.aS(bH7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] bH8 = bH(attributeValue);
                    if (bH8 != null) {
                        bVar.aP(bH8[0]);
                        bVar.aQ(bH8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] bH9 = bH(attributeValue);
                    if (bH9 != null) {
                        bVar.aV(bH9[0]);
                        bVar.aW(bH9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] bH10 = bH(attributeValue);
                    if (bH10 != null) {
                        bVar.bh(bH10[0]);
                        bVar.bi(bH10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (bH = bH(attributeValue)) != null) {
                    bVar.aZ(bH[0]);
                    bVar.ba(bH[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (i = com.baidu.adp.lib.g.c.toInt(attributeValue.substring(1), 0)) != 0) {
                    bVar.bF(String.valueOf(attributeName) + "=" + this.Cv.getResourceName(i));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.Cu != null && !this.Cu.containsKey(bVar.getId())) {
                    this.Cu.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.Cu.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] bH(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.Cv, this.Cw, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, Resources resources2, int i) {
        String resourceName = resources.getResourceName(i);
        int i2 = 0;
        if (!TextUtils.isEmpty(resourceName)) {
            i2 = resources2.getIdentifier(String.valueOf(resourceName) + "_1", null, null);
        }
        if (i2 == 0) {
            BdLog.e(String.valueOf(resourceName) + " 缺少夜间资源,使用了日间资源");
            return i;
        }
        return i2;
    }

    public void h(View view) {
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
                    i(view2);
                }
            }
        }
    }

    private void b(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.Cu != null && this.Cu.containsKey(str)) {
            b bVar = this.Cu.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.lD() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.Ct, bVar.lC(), bVar.lD()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.lH() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.Cv.getResourceTypeName(bVar.lG());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.Ct, bVar.lG(), bVar.lH()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.Ct, bVar.lG(), bVar.lH()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void i(View view) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        String str = "@" + view.getId();
        if (this.Cu != null && this.Cu.containsKey(str)) {
            b bVar = this.Cu.get(str);
            if (view instanceof TextView) {
                if (bVar.lL() != 0) {
                    ((TextView) view).setTextColor(d(this.Ct, bVar.lK(), bVar.lL()));
                }
                if (bVar.lJ() != 0) {
                    ((TextView) view).setHintTextColor(d(this.Ct, bVar.lI(), bVar.lJ()));
                }
                if (bVar.lO() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.Ct ? bVar.lO() : bVar.lP());
                }
                if (bVar.lB() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.Ct, bVar.lA(), bVar.lB()), (Drawable) null, (Drawable) null);
                }
                if (bVar.lz() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.Ct, bVar.ly(), bVar.lz()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.lF() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.Ct, bVar.lE(), bVar.lF()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.lM() != 0 && (b3 = b(this.Ct, bVar.lN(), bVar.lM())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.lM() != 0 && (b2 = b(this.Ct, bVar.lN(), bVar.lM())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.lR() != 0 && (b = b(this.Ct, bVar.lQ(), bVar.lR())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.lH() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.Cv.getResourceTypeName(bVar.lG());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.Ct, bVar.lG(), bVar.lH()));
                } else {
                    view.setBackgroundDrawable(b(this.Ct, bVar.lG(), bVar.lH()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (!z) {
            return this.Cv.getDrawable(i);
        }
        if (i == i2) {
            this.Cw = this.Cv;
            i2 = a(this.Cv, this.Cw, i);
        }
        if (this.Cw == null) {
            return this.Cv.getDrawable(i);
        }
        try {
            return this.Cw.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            return this.Cv.getDrawable(i);
        }
    }

    private int c(boolean z, int i, int i2) {
        if (!z) {
            return this.Cv.getColor(i);
        }
        if (i == i2) {
            this.Cw = this.Cv;
            i2 = a(this.Cv, this.Cw, i);
        }
        if (this.Cw == null) {
            return this.Cv.getColor(i);
        }
        try {
            return this.Cw.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.Cv.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (!z) {
            return this.Cv.getColorStateList(i);
        }
        if (i == i2) {
            this.Cw = this.Cv;
            i2 = a(this.Cv, this.Cw, i);
        }
        if (this.Cw == null) {
            return this.Cv.getColorStateList(i);
        }
        try {
            return this.Cw.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.Cv.getColorStateList(i);
        }
    }

    public void ab(boolean z) {
        this.Ct = z;
    }

    public void a(Resources resources) {
        this.Cw = resources;
    }

    public void destroy() {
        if (this.Cu != null) {
            this.Cu.clear();
            this.Cu = null;
        }
    }
}
