package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class UserPhotoLayout extends LinearLayout implements AbsListView.RecyclerListener {
    public boolean mAutoChangeStyle;
    public d mChildClickListener;
    public int mChildCount;
    public Context mContext;
    public List<MetaData> mDatas;
    public int mItemSize;
    public int mNormalShowCount;
    public int mPadding;
    public e mTbRecyclerListener;
    public d.a.c.e.k.b<HeadImageView> mUserPhotoPool;

    /* loaded from: classes3.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (!(view2 instanceof HeadImageView) || UserPhotoLayout.this.mUserPhotoPool == null) {
                return;
            }
            UserPhotoLayout.this.mUserPhotoPool.e((HeadImageView) view2);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.c.e.k.c<HeadImageView> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12439a;

        public b(Context context) {
            this.f12439a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ HeadImageView a(HeadImageView headImageView) {
            HeadImageView headImageView2 = headImageView;
            e(headImageView2);
            return headImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ HeadImageView c(HeadImageView headImageView) {
            HeadImageView headImageView2 = headImageView;
            h(headImageView2);
            return headImageView2;
        }

        public HeadImageView e(HeadImageView headImageView) {
            return headImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(HeadImageView headImageView) {
            headImageView.setBackgroundResource(0);
            headImageView.setImageDrawable(null);
            headImageView.setTag(null);
            headImageView.setOnClickListener(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public HeadImageView d() {
            return new HeadImageView(this.f12439a);
        }

        public HeadImageView h(HeadImageView headImageView) {
            headImageView.setBackgroundResource(0);
            headImageView.setImageDrawable(null);
            headImageView.setTag(null);
            headImageView.setOnClickListener(null);
            return headImageView;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final int f12440e;

        public /* synthetic */ c(UserPhotoLayout userPhotoLayout, int i2, a aVar) {
            this(i2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UserPhotoLayout.this.mChildClickListener != null) {
                UserPhotoLayout.this.mChildClickListener.a(this.f12440e);
            }
        }

        public c(int i2) {
            this.f12440e = i2;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes3.dex */
    public static class e implements AbsListView.RecyclerListener {

        /* renamed from: e  reason: collision with root package name */
        public int f12442e;

        public e(int i2) {
            this.f12442e = 0;
            this.f12442e = i2;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById = view.findViewById(this.f12442e);
            if (findViewById == null || !(findViewById instanceof UserPhotoLayout)) {
                return;
            }
            ((UserPhotoLayout) findViewById).reset();
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        d.a.c.e.k.b<HeadImageView> a();

        int b();

        ListView getListView();
    }

    public UserPhotoLayout(Context context) {
        this(context, null);
    }

    public static d.a.c.e.k.b<HeadImageView> createUserPhotoPool(Context context, int i2) {
        return new d.a.c.e.k.b<>(new b(context), i2, 0);
    }

    private HeadImageView getImageView(Context context) {
        d.a.c.e.k.b<HeadImageView> bVar = this.mUserPhotoPool;
        HeadImageView b2 = bVar != null ? bVar.b() : null;
        return (b2 == null || b2.getParent() != null) ? new HeadImageView(context) : b2;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        view.setOnClickListener(new c(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<MetaData> list = this.mDatas;
        if (list == null || list.size() <= 0) {
            return;
        }
        int childCount = getChildCount();
        this.mChildCount = childCount;
        if (childCount == 0) {
            return;
        }
        long drawingTime = getDrawingTime();
        for (int i2 = 0; i2 < this.mChildCount; i2++) {
            drawChild(canvas, (HeadImageView) getChildAt(i2), drawingTime);
        }
    }

    public int getItemSize() {
        return this.mItemSize;
    }

    public int getNormalShowCount() {
        return this.mNormalShowCount;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.mChildCount == 0) {
            return;
        }
        int i6 = 0;
        while (i6 < this.mChildCount) {
            int i7 = this.mPadding;
            int i8 = this.mItemSize;
            int i9 = i7 * i6;
            i6++;
            ((HeadImageView) getChildAt(i6)).layout((i7 * i6) + (i8 * i6), 0, i9 + (i8 * i6), i8);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.mChildCount;
        if (i4 == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i5 = this.mItemSize;
        setMeasuredDimension((i4 * i5) + ((i4 - 1) * this.mPadding), i5);
        for (int i6 = 0; i6 < this.mChildCount; i6++) {
            int i7 = this.mItemSize;
            measureChild((HeadImageView) getChildAt(i6), i7, i7);
        }
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (view == null || !(view instanceof UserPhotoLayout)) {
            return;
        }
        reset();
    }

    public void reset() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setData(List<MetaData> list, boolean z) {
        reset();
        this.mDatas = list;
        if (list == null) {
            requestLayout();
            invalidate();
            return;
        }
        int size = list.size();
        this.mChildCount = size;
        int i2 = this.mNormalShowCount;
        if (size > i2) {
            this.mChildCount = i2;
        }
        for (int i3 = 0; i3 < this.mChildCount; i3++) {
            HeadImageView imageView = getImageView(this.mContext);
            imageView.setAutoChangeStyle(this.mAutoChangeStyle);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(imageView);
            imageView.V(this.mDatas.get(i3).getPortrait(), 12, false);
        }
        requestLayout();
        invalidate();
    }

    public void setItemSize(int i2) {
        this.mItemSize = i2;
    }

    public void setNormalShowCount(int i2) {
        this.mNormalShowCount = i2;
    }

    public void setOnChildClickListener(d dVar) {
        this.mChildClickListener = dVar;
    }

    public UserPhotoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUserPhotoPool = null;
        this.mTbRecyclerListener = null;
        this.mItemSize = 0;
        this.mPadding = 5;
        this.mAutoChangeStyle = true;
        this.mNormalShowCount = 6;
        this.mContext = context;
        this.mPadding = l.e(context, 5);
        this.mItemSize = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
        Context context2 = this.mContext;
        if (context2 instanceof f) {
            f fVar = (f) context2;
            this.mUserPhotoPool = fVar.a();
            if (fVar.getListView() != null && this.mTbRecyclerListener == null) {
                this.mTbRecyclerListener = new e(fVar.b());
                fVar.getListView().setRecyclerListener(this.mTbRecyclerListener);
            }
        }
        setOnHierarchyChangeListener(new a());
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        super.addView(view, i2);
        view.setOnClickListener(new c(this, getChildCount() - 1, null));
    }
}
