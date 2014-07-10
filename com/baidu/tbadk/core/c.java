package com.baidu.tbadk.core;

import android.content.Context;
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
    private Resources c;
    private boolean b = false;
    Map<String, b> a = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] a;
        int a2;
        boolean z = false;
        try {
            this.c = context.getResources();
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.c(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    bVar.b(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] a3 = a(attributeValue);
                    if (a3 != null) {
                        bVar.i(a3[0]);
                        bVar.j(a3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] a4 = a(attributeValue);
                    if (a4 != null) {
                        bVar.o(a4[0]);
                        bVar.p(a4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] a5 = a(attributeValue);
                    if (a5 != null) {
                        bVar.m(a5[0]);
                        bVar.n(a5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] a6 = a(attributeValue);
                    if (a6 != null) {
                        bVar.r(a6[0]);
                        bVar.q(a6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] a7 = a(attributeValue);
                    if (a7 != null) {
                        bVar.e(a7[0]);
                        bVar.f(a7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] a8 = a(attributeValue);
                    if (a8 != null) {
                        bVar.c(a8[0]);
                        bVar.d(a8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] a9 = a(attributeValue);
                    if (a9 != null) {
                        bVar.a(a9[0]);
                        bVar.b(a9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] a10 = a(attributeValue);
                    if (a10 != null) {
                        bVar.g(a10[0]);
                        bVar.h(a10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] a11 = a(attributeValue);
                    if (a11 != null) {
                        bVar.s(a11[0]);
                        bVar.t(a11[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (a = a(attributeValue)) != null) {
                    bVar.k(a[0]);
                    bVar.l(a[1]);
                    z = true;
                }
                if (z && TbConfig.getDebugSwitch() && (a2 = com.baidu.adp.lib.f.b.a(attributeValue.substring(1), 0)) != 0) {
                    bVar.a(String.valueOf(attributeName) + "=" + this.c.getResourceName(a2));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.g()) && this.a != null && !this.a.containsKey(bVar.g())) {
                    this.a.put(bVar.g(), bVar);
                } else if (!TextUtils.isEmpty(bVar.g())) {
                    this.a.containsKey(bVar.g());
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] a(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.c, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, int i) {
        String resourceName = resources.getResourceName(i);
        if (resourceName != null) {
            int identifier = resources.getIdentifier(String.valueOf(resourceName) + "_1", null, null);
            if (identifier == 0) {
                BdLog.e(String.valueOf(resourceName) + " 缺少夜间资源,使用了日间资源");
                return i;
            }
            return identifier;
        }
        return i;
    }

    public void a(View view) {
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
                    b(view2);
                }
            }
        }
    }

    private void a(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.a != null && this.a.containsKey(str)) {
            b bVar = this.a.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.f() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(this.c.getDrawable(this.b ? bVar.f() : bVar.e()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.k() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                int k = this.b ? bVar.k() : bVar.j();
                String resourceTypeName = this.c.getResourceTypeName(k);
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(this.c.getColor(k));
                } else {
                    viewGroup.setBackgroundResource(k);
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void b(View view) {
        int h;
        int a;
        int c;
        int l;
        int n;
        String str = "@" + view.getId();
        if (this.a != null && this.a.containsKey(str)) {
            b bVar = this.a.get(str);
            if (view instanceof TextView) {
                if (bVar.o() != 0) {
                    Resources resources = this.c;
                    if (this.b) {
                        n = bVar.o();
                    } else {
                        n = bVar.n();
                    }
                    ((TextView) view).setTextColor(resources.getColorStateList(n));
                }
                if (bVar.m() != 0) {
                    Resources resources2 = this.c;
                    if (this.b) {
                        l = bVar.m();
                    } else {
                        l = bVar.l();
                    }
                    ((TextView) view).setHintTextColor(resources2.getColorStateList(l));
                }
                if (bVar.r() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.b ? bVar.r() : bVar.s());
                }
                if (bVar.d() != 0) {
                    Resources resources3 = this.c;
                    if (this.b) {
                        c = bVar.d();
                    } else {
                        c = bVar.c();
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, resources3.getDrawable(c), (Drawable) null, (Drawable) null);
                }
                if (bVar.b() != 0) {
                    Resources resources4 = this.c;
                    if (this.b) {
                        a = bVar.b();
                    } else {
                        a = bVar.a();
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(resources4.getDrawable(a), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.i() != 0) {
                    Resources resources5 = this.c;
                    if (this.b) {
                        h = bVar.i();
                    } else {
                        h = bVar.h();
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, resources5.getDrawable(h), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.p() != 0) {
                    Drawable drawable = this.c.getDrawable(this.b ? bVar.p() : bVar.q());
                    if (drawable != null) {
                        ((ImageView) view).setImageDrawable(drawable);
                    }
                }
            } else if (view instanceof ImageView) {
                if (bVar.p() != 0) {
                    Drawable drawable2 = this.c.getDrawable(this.b ? bVar.p() : bVar.q());
                    if (drawable2 != null) {
                        ((ImageView) view).setImageDrawable(drawable2);
                    }
                }
            } else if ((view instanceof ProgressBar) && bVar.u() != 0) {
                Drawable drawable3 = this.c.getDrawable(this.b ? bVar.u() : bVar.t());
                if (drawable3 != null) {
                    ((ProgressBar) view).setProgressDrawable(drawable3);
                }
            }
            if (bVar.k() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                int k = this.b ? bVar.k() : bVar.j();
                String resourceTypeName = this.c.getResourceTypeName(k);
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(this.c.getColor(k));
                } else {
                    view.setBackgroundResource(k);
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a() {
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
    }
}
