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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes4.dex */
public class UserPhotoLayout extends LinearLayout implements AbsListView.RecyclerListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes4.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserPhotoLayout f12625e;

        public a(UserPhotoLayout userPhotoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userPhotoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12625e = userPhotoLayout;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) {
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) && (view2 instanceof HeadImageView) && this.f12625e.mUserPhotoPool != null) {
                this.f12625e.mUserPhotoPool.e((HeadImageView) view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements d.a.c.e.k.c<HeadImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12626a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12626a = context;
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, headImageView)) == null) ? headImageView : (HeadImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(HeadImageView headImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, headImageView) == null) {
                headImageView.setBackgroundResource(0);
                headImageView.setImageDrawable(null);
                headImageView.setTag(null);
                headImageView.setOnClickListener(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public HeadImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new HeadImageView(this.f12626a) : (HeadImageView) invokeV.objValue;
        }

        public HeadImageView h(HeadImageView headImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, headImageView)) == null) {
                headImageView.setBackgroundResource(0);
                headImageView.setImageDrawable(null);
                headImageView.setTag(null);
                headImageView.setOnClickListener(null);
                return headImageView;
            }
            return (HeadImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f12627e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UserPhotoLayout f12628f;

        public /* synthetic */ c(UserPhotoLayout userPhotoLayout, int i2, a aVar) {
            this(userPhotoLayout, i2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12628f.mChildClickListener == null) {
                return;
            }
            this.f12628f.mChildClickListener.a(this.f12627e);
        }

        public c(UserPhotoLayout userPhotoLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userPhotoLayout, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12628f = userPhotoLayout;
            this.f12627e = i2;
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public static class e implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f12629e;

        public e(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12629e = 0;
            this.f12629e = i2;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (findViewById = view.findViewById(this.f12629e)) != null && (findViewById instanceof UserPhotoLayout)) {
                ((UserPhotoLayout) findViewById).reset();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        d.a.c.e.k.b<HeadImageView> a();

        int b();

        ListView getListView();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserPhotoLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static d.a.c.e.k.b<HeadImageView> createUserPhotoPool(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65540, null, context, i2)) == null) ? new d.a.c.e.k.b<>(new b(context), i2, 0) : (d.a.c.e.k.b) invokeLI.objValue;
    }

    private HeadImageView getImageView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
            d.a.c.e.k.b<HeadImageView> bVar = this.mUserPhotoPool;
            HeadImageView b2 = bVar != null ? bVar.b() : null;
            return (b2 == null || b2.getParent() != null) ? new HeadImageView(context) : b2;
        }
        return (HeadImageView) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            super.addView(view);
            view.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<MetaData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || (list = this.mDatas) == null || list.size() <= 0) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mItemSize : invokeV.intValue;
    }

    public int getNormalShowCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mNormalShowCount : invokeV.intValue;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
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
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
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
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view) == null) && view != null && (view instanceof UserPhotoLayout)) {
            reset();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || getChildCount() <= 0) {
            return;
        }
        removeAllViews();
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mAutoChangeStyle = z;
        }
    }

    public void setData(List<MetaData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
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
                imageView.M(this.mDatas.get(i3).getPortrait(), 12, false);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setItemSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mItemSize = i2;
        }
    }

    public void setNormalShowCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mNormalShowCount = i2;
        }
    }

    public void setOnChildClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.mChildClickListener = dVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPhotoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        setOnHierarchyChangeListener(new a(this));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            super.addView(view, i2);
            view.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }
}
