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
import com.baidu.tbadk.core.data.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes.dex */
public final class c {
    private Resources c;
    private boolean b = false;
    Map<String, b> a = new HashMap();

    public final void a(String str, Context context, AttributeSet attributeSet) {
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
                if (z && n.a() && (a2 = com.baidu.adp.lib.f.b.a(attributeValue.substring(1), 0)) != 0) {
                    bVar.a(String.valueOf(attributeName) + "=" + this.c.getResourceName(a2));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.g()) && this.a != null && !this.a.containsKey(bVar.g())) {
                    this.a.put(bVar.g(), bVar);
                } else if (TextUtils.isEmpty(bVar.g())) {
                    com.baidu.adp.lib.util.f.b(String.valueOf(bVar.toString()) + " PLEASE SET ID!!!");
                } else {
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
                com.baidu.adp.lib.util.f.b(String.valueOf(resourceName) + " 缺少夜间资源,使用了日间资源");
                return i;
            }
            return identifier;
        }
        com.baidu.adp.lib.util.f.b(String.valueOf(i) + " cann't find name");
        return i;
    }

    public final void a(View view) {
        if (view != null) {
            Stack stack = new Stack();
            stack.push(view);
            while (!stack.isEmpty()) {
                View view2 = (View) stack.pop();
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
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
                        if (bVar.l() != 0) {
                            int paddingLeft = viewGroup.getPaddingLeft();
                            int paddingTop = viewGroup.getPaddingTop();
                            int paddingRight = viewGroup.getPaddingRight();
                            int paddingBottom = viewGroup.getPaddingBottom();
                            int l = this.b ? bVar.l() : bVar.k();
                            String resourceTypeName = this.c.getResourceTypeName(l);
                            if (resourceTypeName == null || !resourceTypeName.equals("color")) {
                                viewGroup.setBackgroundResource(l);
                                com.baidu.adp.lib.util.f.e("type:" + resourceTypeName + ",id:" + bVar.g() + ",name:" + bVar.j());
                            } else {
                                int color = this.c.getColor(l);
                                viewGroup.setBackgroundColor(color);
                                com.baidu.adp.lib.util.f.e("type:" + resourceTypeName + ",id:" + bVar.g() + ",name:" + bVar.j());
                                if (color == 0) {
                                    com.baidu.adp.lib.util.f.b("name = " + bVar.j() + " background color is missing");
                                }
                            }
                            viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                        }
                    }
                    if (!(view2 instanceof AdapterView)) {
                        int childCount = ((ViewGroup) view2).getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            stack.push(((ViewGroup) view2).getChildAt(i));
                        }
                    }
                } else {
                    String str2 = "@" + view2.getId();
                    if (this.a != null && this.a.containsKey(str2)) {
                        b bVar2 = this.a.get(str2);
                        if (view2 instanceof TextView) {
                            if (bVar2.p() != 0) {
                                ((TextView) view2).setTextColor(this.c.getColorStateList(this.b ? bVar2.p() : bVar2.o()));
                            }
                            if (bVar2.n() != 0) {
                                ((TextView) view2).setHintTextColor(this.c.getColorStateList(this.b ? bVar2.n() : bVar2.m()));
                            }
                            if (bVar2.s() != 0) {
                                ((TextView) view2).setTextAppearance(view2.getContext(), this.b ? bVar2.s() : bVar2.t());
                            }
                            if (bVar2.d() != 0) {
                                ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.c.getDrawable(this.b ? bVar2.d() : bVar2.c()), (Drawable) null, (Drawable) null);
                            }
                            if (bVar2.b() != 0) {
                                ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds(this.c.getDrawable(this.b ? bVar2.b() : bVar2.a()), (Drawable) null, (Drawable) null, (Drawable) null);
                            }
                            if (bVar2.i() != 0) {
                                ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.c.getDrawable(this.b ? bVar2.i() : bVar2.h()), (Drawable) null);
                            }
                        } else if (view2 instanceof ImageButton) {
                            if (bVar2.q() != 0) {
                                Drawable drawable = this.c.getDrawable(this.b ? bVar2.q() : bVar2.r());
                                if (drawable != null) {
                                    ((ImageView) view2).setImageDrawable(drawable);
                                }
                            }
                        } else if (view2 instanceof ImageView) {
                            if (bVar2.q() != 0) {
                                Drawable drawable2 = this.c.getDrawable(this.b ? bVar2.q() : bVar2.r());
                                if (drawable2 != null) {
                                    ((ImageView) view2).setImageDrawable(drawable2);
                                }
                            }
                        } else if ((view2 instanceof ProgressBar) && bVar2.v() != 0) {
                            Drawable drawable3 = this.c.getDrawable(this.b ? bVar2.v() : bVar2.u());
                            if (drawable3 != null) {
                                ((ProgressBar) view2).setProgressDrawable(drawable3);
                            }
                        }
                        if (bVar2.l() != 0) {
                            int paddingLeft2 = view2.getPaddingLeft();
                            int paddingTop2 = view2.getPaddingTop();
                            int paddingRight2 = view2.getPaddingRight();
                            int paddingBottom2 = view2.getPaddingBottom();
                            int l2 = this.b ? bVar2.l() : bVar2.k();
                            String resourceTypeName2 = this.c.getResourceTypeName(l2);
                            if (resourceTypeName2 == null || !resourceTypeName2.equals("color")) {
                                view2.setBackgroundResource(l2);
                                com.baidu.adp.lib.util.f.e("type:" + resourceTypeName2 + ",id:" + bVar2.g() + ",name:" + bVar2.j());
                            } else {
                                view2.setBackgroundColor(this.c.getColor(l2));
                                com.baidu.adp.lib.util.f.e("type:" + resourceTypeName2 + ",id:" + bVar2.g() + ",name:" + bVar2.j());
                            }
                            view2.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
                        }
                    }
                }
            }
        }
    }

    public final boolean a() {
        return this.b;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final void b() {
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
    }
}
