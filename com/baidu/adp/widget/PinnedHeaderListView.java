package com.baidu.adp.widget;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PinnedHeaderListView extends BdListView implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AbsListView.OnScrollListener K;
    public final DataSetObserver L;
    public View M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public boolean U;
    public boolean V;
    public c W;

    /* loaded from: classes4.dex */
    public class a extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PinnedHeaderListView f36568a;

        public a(PinnedHeaderListView pinnedHeaderListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pinnedHeaderListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36568a = pinnedHeaderListView;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36568a.requestLayout();
                this.f36568a.invalidate();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f36568a.R = -1;
                this.f36568a.requestLayout();
                this.f36568a.invalidate();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PinnedHeaderListView f36569a;

        public b(PinnedHeaderListView pinnedHeaderListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pinnedHeaderListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36569a = pinnedHeaderListView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.r
        public void onScrollToPull(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f36569a.V = z;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class c implements ListAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final DataSetObservable f36570e;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36570e = new DataSetObservable();
        }

        public abstract View a();

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public abstract int b();

        public abstract void c(View view, AdapterView<?> adapterView, int i2);

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getCount() == 0 : invokeV.booleanValue;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                return true;
            }
            return invokeI.booleanValue;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, dataSetObserver) == null) {
                this.f36570e.registerObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dataSetObserver) == null) {
                this.f36570e.unregisterObserver(dataSetObserver);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PinnedHeaderListView(Context context) {
        this(context, null, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        B();
    }

    public final int A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            c cVar = this.W;
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                if (cVar.getItemViewType(i3) == this.N) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.S = this.R;
            setOnScrollToPullListener(new b(this));
        }
    }

    public final void C(int i2, int i3) {
        View view;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || (view = this.M) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        int i4 = layoutParams.width;
        if (i4 == -2) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
        } else if (i4 != -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        int i5 = layoutParams.height;
        if (i5 == -2) {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        } else if (i5 != -1) {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        } else {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        this.M.measure(makeMeasureSpec, makeMeasureSpec2);
        this.O = this.M.getMeasuredWidth();
        this.P = this.M.getMeasuredHeight();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.U && !this.V && this.M.getVisibility() == 0) {
                long drawingTime = getDrawingTime();
                int save = canvas.save();
                canvas.translate(0.0f, -this.Q);
                drawChild(canvas, this.M, drawingTime);
                if (save < 1 || save > canvas.getSaveCount()) {
                    return;
                }
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            z();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048583, this, absListView, i2, i3, i4) == null) {
            z();
            AbsListView.OnScrollListener onScrollListener = this.K;
            if (onScrollListener != null) {
                onScrollListener.onScroll(absListView, i2, i3, i4);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        AbsListView.OnScrollListener onScrollListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, absListView, i2) == null) || (onScrollListener = this.K) == null) {
            return;
        }
        onScrollListener.onScrollStateChanged(absListView, i2);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onScrollListener) == null) {
            this.K = onScrollListener;
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.M == null) {
            return;
        }
        c cVar = this.W;
        int firstVisiblePosition = getFirstVisiblePosition();
        if (firstVisiblePosition > 0) {
            firstVisiblePosition--;
        }
        int i2 = firstVisiblePosition + 1;
        int itemViewType = cVar.getItemViewType(firstVisiblePosition);
        int itemViewType2 = cVar.getItemViewType(i2);
        if (this.U) {
            int i3 = this.N;
            if (itemViewType2 == i3) {
                View childAt = getChildAt(1);
                if (childAt != null) {
                    int i4 = this.P;
                    this.Q = Math.min(i4, Math.max(0, i4 - childAt.getTop()));
                    invalidate(0, 0, this.O, this.P);
                }
            } else if (itemViewType == i3 && firstVisiblePosition != this.R) {
                cVar.c(this.M, this, firstVisiblePosition);
                C(getMeasuredWidth(), getMeasuredHeight());
                this.M.layout(0, 0, this.O, this.P);
                invalidate(0, 0, this.O, this.P);
                this.R = firstVisiblePosition;
                this.T = firstVisiblePosition;
            } else {
                this.Q = 0;
                invalidate(0, 0, this.O, this.P);
            }
            int A = A(i2);
            if (A == -1) {
                this.U = false;
                cVar.c(null, this, -1);
            } else if (A != this.T || A == 0) {
                cVar.c(this.M, this, A);
                C(getMeasuredWidth(), getMeasuredHeight());
                this.M.layout(0, 0, this.O, this.P);
                invalidate(0, 0, this.O, this.P);
                this.T = A;
                this.R = this.S;
            }
        } else if (itemViewType == this.N) {
            this.U = true;
            this.Q = 0;
            cVar.c(this.M, this, firstVisiblePosition);
            C(getMeasuredWidth(), getMeasuredHeight());
            this.M.layout(0, 0, this.O, this.P);
            invalidate(0, 0, this.O, this.P);
            this.R = firstVisiblePosition;
            this.S = firstVisiblePosition;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new AbsListView.LayoutParams(-1, -2) : (AbsListView.LayoutParams) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, listAdapter) == null) {
            if (listAdapter instanceof c) {
                super.setAdapter(listAdapter);
                c cVar = (c) listAdapter;
                this.W = cVar;
                this.N = cVar.b();
                View a2 = this.W.a();
                this.M = a2;
                if (a2 != null) {
                    if (a2.getLayoutParams() == null) {
                        this.M.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    }
                    setFadingEdgeLength(0);
                }
                this.W.registerDataSetObserver(this.L);
                return;
            }
            throw new RuntimeException("Adapter must extended from PinnedHeaderListAdapter");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        B();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.L = new a(this);
        this.N = -1;
        this.V = false;
        super.setOnScrollListener(this);
        String str = "head count = " + getHeaderViewsCount();
        B();
    }
}
