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
    public d.b.b.e.k.b<TbImageView> f13555e;

    /* renamed from: f  reason: collision with root package name */
    public Context f13556f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13557g;

    /* renamed from: h  reason: collision with root package name */
    public int f13558h;
    public int i;
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
            if (!(view2 instanceof TbImageView) || UserIconBox.this.f13555e == null) {
                return;
            }
            UserIconBox.this.f13555e.e((TbImageView) view2);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.b.b.e.k.c<TbImageView> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f13560a;

        public b(Context context) {
            this.f13560a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            return tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            tbImageView.setBackgroundResource(0);
            tbImageView.setImageDrawable(null);
            tbImageView.setTag(null);
            tbImageView.setOnClickListener(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            return new TbImageView(this.f13560a);
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
        d.b.b.e.k.b<TbImageView> getUserIconPool();
    }

    public UserIconBox(Context context) {
        super(context);
        this.f13555e = null;
        this.f13557g = true;
        f(context);
    }

    public static d.b.b.e.k.b<TbImageView> c(Context context, int i) {
        return new d.b.b.e.k.b<>(new b(context), i, 0);
    }

    public final boolean b(int i) {
        if (i <= 0) {
            return false;
        }
        int childCount = getChildCount();
        if (i == childCount) {
            return true;
        }
        int i2 = i - childCount;
        if (i2 > 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                addView(d(this.f13556f));
            }
        } else {
            removeViews(i, Math.abs(i2));
        }
        return true;
    }

    public final TbImageView d(Context context) {
        d.b.b.e.k.b<TbImageView> bVar = this.f13555e;
        TbImageView b2 = bVar != null ? bVar.b() : null;
        return (b2 == null || b2.getParent() != null) ? new TbImageView(context) : b2;
    }

    public final LinearLayout.LayoutParams e(int i, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = i3;
        return layoutParams;
    }

    public final void f(Context context) {
        this.f13556f = context;
        setOrientation(0);
        setGravity(16);
        Context context2 = this.f13556f;
        if (context2 instanceof c) {
            this.f13555e = ((c) context2).getUserIconPool();
        }
        setOnHierarchyChangeListener(new a());
    }

    public void g(List<IconData> list, int i, int i2, int i3, int i4) {
        h(list, i, i2, i3, i4, false);
    }

    public void h(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        if (list == null) {
            setVisibility(8);
            return;
        }
        int min = Math.min(i, ListUtils.getCount(list));
        if (min == 1 && TextUtils.isEmpty(list.get(0).getIcon())) {
            setVisibility(8);
            return;
        }
        this.f13558h = i2;
        this.i = i4;
        this.j = z;
        this.f13558h = i2;
        if (!b(min)) {
            setVisibility(8);
        } else if (min > 0) {
            setVisibility(0);
            for (int i5 = 0; i5 < min; i5++) {
                View childAt = getChildAt(i5);
                if (childAt instanceof TbImageView) {
                    if (StringUtils.isNull(list.get(i5).getIcon())) {
                        childAt.setVisibility(8);
                    } else {
                        childAt.setVisibility(0);
                        TbImageView tbImageView = (TbImageView) childAt;
                        tbImageView.setDefaultResource(R.drawable.icon_moren);
                        if (i5 == 0 && z) {
                            tbImageView.setLayoutParams(e(i2, i3, 0));
                        } else {
                            tbImageView.setLayoutParams(e(i2, i3, i4));
                        }
                        tbImageView.setTag(list.get(i5).getIcon());
                        if (!StringUtils.isNull(list.get(i5).getIconName())) {
                            tbImageView.setContentDescription(list.get(i5).getIconName());
                        }
                        tbImageView.setClickable(false);
                        tbImageView.setAutoChangeStyle(this.f13557g);
                        tbImageView.setImageDrawable(null);
                        tbImageView.T(list.get(i5).getIcon(), 21, i2, i3, false);
                    }
                }
            }
        } else {
            setVisibility(8);
        }
    }

    public void i(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkCoreApplication.getInst().getSkinType() == 1);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        int measuredWidth = getMeasuredWidth();
        int childCount = getChildCount();
        boolean z2 = false;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (!z2) {
                if (i7 == 0 && this.j) {
                    i5 = this.f13558h;
                } else {
                    i5 = this.f13558h + this.i;
                }
                i6 += i5;
                if (i6 > measuredWidth) {
                    z2 = true;
                }
            }
            if (z2) {
                childAt.layout(0, 0, 0, 0);
            }
        }
    }

    public void setAutoChangedStyle(boolean z) {
        this.f13557g = z;
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13555e = null;
        this.f13557g = true;
        f(context);
    }
}
