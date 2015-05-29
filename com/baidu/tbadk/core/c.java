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
    private Resources OB;
    private Resources OC;
    private boolean Oz = false;
    Map<String, b> OA = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] bZ;
        int i;
        boolean z = false;
        try {
            this.OB = context.getResources();
            this.OC = this.OB;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.bY(str);
            for (int i2 = 0; i2 < attributeCount; i2++) {
                String attributeName = attributeSet.getAttributeName(i2);
                String attributeValue = attributeSet.getAttributeValue(i2);
                if (attributeName.equals("id")) {
                    bVar.setId(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] bZ2 = bZ(attributeValue);
                    if (bZ2 != null) {
                        bVar.aS(bZ2[0]);
                        bVar.aT(bZ2[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] bZ3 = bZ(attributeValue);
                    if (bZ3 != null) {
                        bVar.aY(bZ3[0]);
                        bVar.aZ(bZ3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] bZ4 = bZ(attributeValue);
                    if (bZ4 != null) {
                        bVar.aW(bZ4[0]);
                        bVar.aX(bZ4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] bZ5 = bZ(attributeValue);
                    if (bZ5 != null) {
                        bVar.bb(bZ5[0]);
                        bVar.ba(bZ5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] bZ6 = bZ(attributeValue);
                    if (bZ6 != null) {
                        bVar.aO(bZ6[0]);
                        bVar.aP(bZ6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] bZ7 = bZ(attributeValue);
                    if (bZ7 != null) {
                        bVar.aM(bZ7[0]);
                        bVar.aN(bZ7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] bZ8 = bZ(attributeValue);
                    if (bZ8 != null) {
                        bVar.aK(bZ8[0]);
                        bVar.aL(bZ8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] bZ9 = bZ(attributeValue);
                    if (bZ9 != null) {
                        bVar.aQ(bZ9[0]);
                        bVar.aR(bZ9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] bZ10 = bZ(attributeValue);
                    if (bZ10 != null) {
                        bVar.bc(bZ10[0]);
                        bVar.bd(bZ10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (bZ = bZ(attributeValue)) != null) {
                    bVar.aU(bZ[0]);
                    bVar.aV(bZ[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (i = com.baidu.adp.lib.g.c.toInt(attributeValue.substring(1), 0)) != 0) {
                    bVar.bX(String.valueOf(attributeName) + "=" + this.OB.getResourceName(i));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.getId()) && this.OA != null && !this.OA.containsKey(bVar.getId())) {
                    this.OA.put(bVar.getId(), bVar);
                } else if (!TextUtils.isEmpty(bVar.getId())) {
                    this.OA.containsKey(bVar.getId());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] bZ(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.OB, this.OC, parseInt)};
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

    public void j(View view) {
        if (view != null) {
            Stack stack = new Stack();
            stack.push(view);
            while (!stack.isEmpty()) {
                View view2 = (View) stack.pop();
                if (view2 instanceof ViewGroup) {
                    c((ViewGroup) view2);
                    if (!(view2 instanceof AdapterView)) {
                        int childCount = ((ViewGroup) view2).getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            stack.push(((ViewGroup) view2).getChildAt(i));
                        }
                    }
                } else {
                    k(view2);
                }
            }
        }
    }

    private void c(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.OA != null && this.OA.containsKey(str)) {
            b bVar = this.OA.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.pK() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(b(this.Oz, bVar.pJ(), bVar.pK()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.pO() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.OB.getResourceTypeName(bVar.pN());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(c(this.Oz, bVar.pN(), bVar.pO()));
                } else {
                    viewGroup.setBackgroundDrawable(b(this.Oz, bVar.pN(), bVar.pO()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void k(View view) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        String str = "@" + view.getId();
        if (this.OA != null && this.OA.containsKey(str)) {
            b bVar = this.OA.get(str);
            if (view instanceof TextView) {
                if (bVar.pS() != 0) {
                    ((TextView) view).setTextColor(d(this.Oz, bVar.pR(), bVar.pS()));
                }
                if (bVar.pQ() != 0) {
                    ((TextView) view).setHintTextColor(d(this.Oz, bVar.pP(), bVar.pQ()));
                }
                if (bVar.pV() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.Oz ? bVar.pV() : bVar.pW());
                }
                if (bVar.pI() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(this.Oz, bVar.pH(), bVar.pI()), (Drawable) null, (Drawable) null);
                }
                if (bVar.pG() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(b(this.Oz, bVar.pF(), bVar.pG()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.pM() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, b(this.Oz, bVar.pL(), bVar.pM()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.pT() != 0 && (b3 = b(this.Oz, bVar.pU(), bVar.pT())) != null) {
                    ((ImageView) view).setImageDrawable(b3);
                }
            } else if (view instanceof ImageView) {
                if (bVar.pT() != 0 && (b2 = b(this.Oz, bVar.pU(), bVar.pT())) != null) {
                    ((ImageView) view).setImageDrawable(b2);
                }
            } else if ((view instanceof ProgressBar) && bVar.pY() != 0 && (b = b(this.Oz, bVar.pX(), bVar.pY())) != null) {
                ((ProgressBar) view).setProgressDrawable(b);
            }
            if (bVar.pO() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.OB.getResourceTypeName(bVar.pN());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(c(this.Oz, bVar.pN(), bVar.pO()));
                } else {
                    view.setBackgroundDrawable(b(this.Oz, bVar.pN(), bVar.pO()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private Drawable b(boolean z, int i, int i2) {
        if (!z) {
            return this.OB.getDrawable(i);
        }
        if (i == i2) {
            this.OC = this.OB;
            i2 = a(this.OB, this.OC, i);
        }
        if (this.OC == null) {
            return this.OB.getDrawable(i);
        }
        try {
            return this.OC.getDrawable(i2);
        } catch (Resources.NotFoundException e) {
            return this.OB.getDrawable(i);
        }
    }

    private int c(boolean z, int i, int i2) {
        if (!z) {
            return this.OB.getColor(i);
        }
        if (i == i2) {
            this.OC = this.OB;
            i2 = a(this.OB, this.OC, i);
        }
        if (this.OC == null) {
            return this.OB.getColor(i);
        }
        try {
            return this.OC.getColor(i2);
        } catch (Resources.NotFoundException e) {
            return this.OB.getColor(i);
        }
    }

    private ColorStateList d(boolean z, int i, int i2) {
        if (!z) {
            return this.OB.getColorStateList(i);
        }
        if (i == i2) {
            this.OC = this.OB;
            i2 = a(this.OB, this.OC, i);
        }
        if (this.OC == null) {
            return this.OB.getColorStateList(i);
        }
        try {
            return this.OC.getColorStateList(i2);
        } catch (Resources.NotFoundException e) {
            return this.OB.getColorStateList(i);
        }
    }

    public void ab(boolean z) {
        this.Oz = z;
    }

    public void b(Resources resources) {
        this.OC = resources;
    }

    public void destroy() {
        if (this.OA != null) {
            this.OA.clear();
            this.OA = null;
        }
    }
}
