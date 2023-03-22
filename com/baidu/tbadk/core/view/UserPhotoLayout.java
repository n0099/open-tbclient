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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.hi;
import com.baidu.tieba.xf;
import com.baidu.tieba.yf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
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
    public xf<HeadImageView> mUserPhotoPool;

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes3.dex */
    public interface f {
        xf<HeadImageView> a();

        int b();

        ListView getListView();
    }

    /* loaded from: classes3.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserPhotoLayout a;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
            }
        }

        public a(UserPhotoLayout userPhotoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userPhotoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userPhotoLayout;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) && (view3 instanceof HeadImageView) && this.a.mUserPhotoPool != null) {
                this.a.mUserPhotoPool.e((HeadImageView) view3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements yf<HeadImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public HeadImageView e(HeadImageView headImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, headImageView)) == null) ? headImageView : (HeadImageView) invokeL.objValue;
        }

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ HeadImageView a(HeadImageView headImageView) {
            HeadImageView headImageView2 = headImageView;
            e(headImageView2);
            return headImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ HeadImageView c(HeadImageView headImageView) {
            HeadImageView headImageView2 = headImageView;
            h(headImageView2);
            return headImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public HeadImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new HeadImageView(this.a);
            }
            return (HeadImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ UserPhotoLayout b;

        public c(UserPhotoLayout userPhotoLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userPhotoLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = userPhotoLayout;
            this.a = i;
        }

        public /* synthetic */ c(UserPhotoLayout userPhotoLayout, int i, a aVar) {
            this(userPhotoLayout, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.mChildClickListener != null) {
                this.b.mChildClickListener.a(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            this.a = i;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view2) {
            View findViewById;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (findViewById = view2.findViewById(this.a)) != null && (findViewById instanceof UserPhotoLayout)) {
                ((UserPhotoLayout) findViewById).reset();
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<MetaData> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) && (list = this.mDatas) != null && list.size() > 0) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.mPadding = hi.d(context, 5);
        this.mItemSize = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070253);
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

    private HeadImageView getImageView(Context context) {
        InterceptResult invokeL;
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            xf<HeadImageView> xfVar = this.mUserPhotoPool;
            if (xfVar != null) {
                headImageView = xfVar.b();
            } else {
                headImageView = null;
            }
            if (headImageView == null || headImageView.getParent() != null) {
                return new HeadImageView(context);
            }
            return headImageView;
        }
        return (HeadImageView) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public void addView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            super.addView(view2);
            view2.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view2) == null) && view2 != null && (view2 instanceof UserPhotoLayout)) {
            reset();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mAutoChangeStyle = z;
        }
    }

    public void setItemSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mItemSize = i;
        }
    }

    public void setNormalShowCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mNormalShowCount = i;
        }
    }

    public void setOnChildClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.mChildClickListener = dVar;
        }
    }

    public static xf<HeadImageView> createUserPhotoPool(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) {
            return new xf<>(new b(context), i, 0);
        }
        return (xf) invokeLI.objValue;
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
            super.addView(view2, i);
            view2.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }

    public int getItemSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mItemSize;
        }
        return invokeV.intValue;
    }

    public int getNormalShowCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mNormalShowCount;
        }
        return invokeV.intValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && getChildCount() > 0) {
            removeAllViews();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
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
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
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
            int i = this.mNormalShowCount;
            if (size > i) {
                this.mChildCount = i;
            }
            for (int i2 = 0; i2 < this.mChildCount; i2++) {
                HeadImageView imageView = getImageView(this.mContext);
                imageView.setAutoChangeStyle(this.mAutoChangeStyle);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(imageView);
                imageView.M(this.mDatas.get(i2).getPortrait(), 12, false);
            }
            requestLayout();
            invalidate();
        }
    }
}
