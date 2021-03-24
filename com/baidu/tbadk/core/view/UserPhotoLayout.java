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
import d.b.b.e.p.l;
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
    public d.b.b.e.k.b<HeadImageView> mUserPhotoPool;

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
    public static class b implements d.b.b.e.k.c<HeadImageView> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f13568a;

        public b(Context context) {
            this.f13568a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ HeadImageView a(HeadImageView headImageView) {
            HeadImageView headImageView2 = headImageView;
            e(headImageView2);
            return headImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ HeadImageView c(HeadImageView headImageView) {
            HeadImageView headImageView2 = headImageView;
            h(headImageView2);
            return headImageView2;
        }

        public HeadImageView e(HeadImageView headImageView) {
            return headImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(HeadImageView headImageView) {
            headImageView.setBackgroundResource(0);
            headImageView.setImageDrawable(null);
            headImageView.setTag(null);
            headImageView.setOnClickListener(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public HeadImageView d() {
            return new HeadImageView(this.f13568a);
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
        public final int f13569e;

        public /* synthetic */ c(UserPhotoLayout userPhotoLayout, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UserPhotoLayout.this.mChildClickListener != null) {
                UserPhotoLayout.this.mChildClickListener.a(this.f13569e);
            }
        }

        public c(int i) {
            this.f13569e = i;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes3.dex */
    public static class e implements AbsListView.RecyclerListener {

        /* renamed from: e  reason: collision with root package name */
        public int f13571e;

        public e(int i) {
            this.f13571e = 0;
            this.f13571e = i;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById = view.findViewById(this.f13571e);
            if (findViewById == null || !(findViewById instanceof UserPhotoLayout)) {
                return;
            }
            ((UserPhotoLayout) findViewById).reset();
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        d.b.b.e.k.b<HeadImageView> a();

        int b();

        ListView getListView();
    }

    public UserPhotoLayout(Context context) {
        this(context, null);
    }

    public static d.b.b.e.k.b<HeadImageView> createUserPhotoPool(Context context, int i) {
        return new d.b.b.e.k.b<>(new b(context), i, 0);
    }

    private HeadImageView getImageView(Context context) {
        d.b.b.e.k.b<HeadImageView> bVar = this.mUserPhotoPool;
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
        for (int i = 0; i < this.mChildCount; i++) {
            drawChild(canvas, (HeadImageView) getChildAt(i), drawingTime);
        }
    }

    public int getItemSize() {
        return this.mItemSize;
    }

    public int getNormalShowCount() {
        return this.mNormalShowCount;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mChildCount == 0) {
            return;
        }
        int i5 = 0;
        while (i5 < this.mChildCount) {
            int i6 = this.mPadding;
            int i7 = this.mItemSize;
            int i8 = i6 * i5;
            i5++;
            ((HeadImageView) getChildAt(i5)).layout((i6 * i5) + (i7 * i5), 0, i8 + (i7 * i5), i7);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.mChildCount;
        if (i3 == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i4 = this.mItemSize;
        setMeasuredDimension((i3 * i4) + ((i3 - 1) * this.mPadding), i4);
        for (int i5 = 0; i5 < this.mChildCount; i5++) {
            int i6 = this.mItemSize;
            measureChild((HeadImageView) getChildAt(i5), i6, i6);
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
        int i = this.mNormalShowCount;
        if (size > i) {
            this.mChildCount = i;
        }
        for (int i2 = 0; i2 < this.mChildCount; i2++) {
            HeadImageView imageView = getImageView(this.mContext);
            imageView.setAutoChangeStyle(this.mAutoChangeStyle);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(imageView);
            imageView.W(this.mDatas.get(i2).getPortrait(), 12, false);
        }
        requestLayout();
        invalidate();
    }

    public void setItemSize(int i) {
        this.mItemSize = i;
    }

    public void setNormalShowCount(int i) {
        this.mNormalShowCount = i;
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
    public void addView(View view, int i) {
        super.addView(view, i);
        view.setOnClickListener(new c(this, getChildCount() - 1, null));
    }
}
