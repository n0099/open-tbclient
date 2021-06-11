package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class UserIconBox extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.e.k.b<TbImageView> f12485e;

    /* renamed from: f  reason: collision with root package name */
    public Context f12486f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12487g;

    /* renamed from: h  reason: collision with root package name */
    public int f12488h;

    /* renamed from: i  reason: collision with root package name */
    public int f12489i;
    public boolean j;

    /* loaded from: classes3.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (!(view2 instanceof TbImageView) || UserIconBox.this.f12485e == null) {
                return;
            }
            UserIconBox.this.f12485e.e((TbImageView) view2);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.c.e.k.c<TbImageView> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12491a;

        public b(Context context) {
            this.f12491a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            return tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            tbImageView.setBackgroundResource(0);
            tbImageView.setImageDrawable(null);
            tbImageView.setTag(null);
            tbImageView.setOnClickListener(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            return new TbImageView(this.f12491a);
        }

        public TbImageView h(TbImageView tbImageView) {
            tbImageView.setBackgroundResource(0);
            tbImageView.setImageDrawable(null);
            tbImageView.setTag(null);
            tbImageView.setOnClickListener(null);
            return tbImageView;
        }
    }

    /* loaded from: classes3.dex */
    public interface c<T extends View> {
        d.a.c.e.k.b<TbImageView> getUserIconPool();
    }

    public UserIconBox(Context context) {
        super(context);
        this.f12485e = null;
        this.f12487g = true;
        f(context);
    }

    public static d.a.c.e.k.b<TbImageView> c(Context context, int i2) {
        return new d.a.c.e.k.b<>(new b(context), i2, 0);
    }

    public final boolean b(int i2) {
        if (i2 <= 0) {
            return false;
        }
        int childCount = getChildCount();
        if (i2 == childCount) {
            return true;
        }
        int i3 = i2 - childCount;
        if (i3 > 0) {
            for (int i4 = 0; i4 < i3; i4++) {
                addView(d(this.f12486f));
            }
        } else {
            removeViews(i2, Math.abs(i3));
        }
        return true;
    }

    public final TbImageView d(Context context) {
        d.a.c.e.k.b<TbImageView> bVar = this.f12485e;
        TbImageView b2 = bVar != null ? bVar.b() : null;
        return (b2 == null || b2.getParent() != null) ? new TbImageView(context) : b2;
    }

    public final LinearLayout.LayoutParams e(int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
        layoutParams.leftMargin = i4;
        return layoutParams;
    }

    public final void f(Context context) {
        this.f12486f = context;
        setOrientation(0);
        setGravity(16);
        Context context2 = this.f12486f;
        if (context2 instanceof c) {
            this.f12485e = ((c) context2).getUserIconPool();
        }
        setOnHierarchyChangeListener(new a());
    }

    public void g(List<IconData> list, int i2, int i3, int i4, int i5) {
        h(list, i2, i3, i4, i5, false);
    }

    public void h(List<IconData> list, int i2, int i3, int i4, int i5, boolean z) {
        if (list == null) {
            setVisibility(8);
            return;
        }
        int min = Math.min(i2, ListUtils.getCount(list));
        if (min == 1 && TextUtils.isEmpty(list.get(0).getIcon())) {
            setVisibility(8);
            return;
        }
        this.f12488h = i3;
        this.f12489i = i5;
        this.j = z;
        this.f12488h = i3;
        if (!b(min)) {
            setVisibility(8);
        } else if (min > 0) {
            setVisibility(0);
            for (int i6 = 0; i6 < min; i6++) {
                View childAt = getChildAt(i6);
                if (childAt instanceof TbImageView) {
                    if (StringUtils.isNull(list.get(i6).getIcon())) {
                        childAt.setVisibility(8);
                    } else {
                        childAt.setVisibility(0);
                        TbImageView tbImageView = (TbImageView) childAt;
                        tbImageView.setDefaultResource(R.drawable.icon_moren);
                        if (i6 == 0 && z) {
                            tbImageView.setLayoutParams(e(i3, i4, 0));
                        } else {
                            tbImageView.setLayoutParams(e(i3, i4, i5));
                        }
                        tbImageView.setTag(list.get(i6).getIcon());
                        if (!StringUtils.isNull(list.get(i6).getIconName())) {
                            tbImageView.setContentDescription(list.get(i6).getIconName());
                        }
                        tbImageView.setClickable(false);
                        tbImageView.setAutoChangeStyle(this.f12487g);
                        tbImageView.setImageDrawable(null);
                        tbImageView.R(list.get(i6).getIcon(), 21, i3, i4, false);
                    }
                }
            }
        } else {
            setVisibility(8);
        }
    }

    public void i(int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkCoreApplication.getInst().getSkinType() == 1);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        super.onLayout(z, i2, i3, i4, i5);
        int measuredWidth = getMeasuredWidth();
        int childCount = getChildCount();
        boolean z2 = false;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (!z2) {
                if (i8 == 0 && this.j) {
                    i6 = this.f12488h;
                } else {
                    i6 = this.f12488h + this.f12489i;
                }
                i7 += i6;
                if (i7 > measuredWidth) {
                    z2 = true;
                }
            }
            if (z2) {
                childAt.layout(0, 0, 0, 0);
            }
        }
    }

    public void setAutoChangedStyle(boolean z) {
        this.f12487g = z;
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12485e = null;
        this.f12487g = true;
        f(context);
    }
}
