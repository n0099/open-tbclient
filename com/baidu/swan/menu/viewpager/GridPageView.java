package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import b.a.p0.n.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class GridPageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AutoGridView f45645e;

    /* renamed from: f  reason: collision with root package name */
    public SlideableGridView.a f45646f;

    /* renamed from: g  reason: collision with root package name */
    public int f45647g;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridPageView f45651e;

        public a(GridPageView gridPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gridPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45651e = gridPageView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            GridPageView gridPageView;
            SlideableGridView.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (aVar = (gridPageView = this.f45651e).f45646f) == null) {
                return;
            }
            aVar.e(gridPageView.f45647g, i2, view);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Context f45652e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GridPageView f45653f;

        public b(GridPageView gridPageView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gridPageView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45653f = gridPageView;
            this.f45652e = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                GridPageView gridPageView = this.f45653f;
                SlideableGridView.a aVar = gridPageView.f45646f;
                if (aVar == null) {
                    return 0;
                }
                return aVar.d(gridPageView.f45647g);
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                return null;
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                return 0L;
            }
            return invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
                GridPageView gridPageView = this.f45653f;
                return gridPageView.f45646f.b(gridPageView.f45647g, i2, view, viewGroup);
            }
            return (View) invokeILL.objValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, dataSetObserver) == null) || dataSetObserver == null) {
                return;
            }
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridPageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45645e = null;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            AutoGridView autoGridView = new AutoGridView(this, context);
            this.f45645e = autoGridView;
            autoGridView.setNumColumns(5);
            this.f45645e.setFocusableInTouchMode(false);
            this.f45645e.setStretchMode(2);
            this.f45645e.setVerticalSpacing((int) getResources().getDimension(g.common_grid_row_margin));
            this.f45645e.setSelector(new ColorDrawable(0));
            this.f45645e.setAdapter((ListAdapter) new b(this, context));
            this.f45645e.setOnItemClickListener(new a(this));
            addView(this.f45645e);
        }
    }

    public void configItem(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.f45645e.setNumColumns(i2);
            this.f45647g = i3;
            ((b) this.f45645e.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        }
    }

    public void setGridItemAdapter(SlideableGridView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f45646f = aVar;
        }
    }

    /* loaded from: classes8.dex */
    public class AutoGridView extends GridView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f45648e;

        /* renamed from: f  reason: collision with root package name */
        public int f45649f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ GridPageView f45650g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AutoGridView(GridPageView gridPageView, Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gridPageView, context, attributeSet, Integer.valueOf(i2)};
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
            this.f45650g = gridPageView;
            this.f45649f = 5;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getAdapter() == null) {
                return;
            }
            ArrayList<Integer> arrayList = new ArrayList();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i3 < getChildCount()) {
                int i5 = 0;
                for (int i6 = i3; i6 < this.f45649f + i3; i6++) {
                    View childAt = getChildAt(i6);
                    if (childAt != null && childAt.getHeight() > i5) {
                        i5 = childAt.getHeight();
                    }
                }
                if (i5 > 0) {
                    for (int i7 = i3; i7 < this.f45649f + i3; i7++) {
                        View childAt2 = getChildAt(i7);
                        if (childAt2 != null && childAt2.getHeight() != i5) {
                            childAt2.setMinimumHeight(i5);
                        }
                    }
                    arrayList.add(Integer.valueOf(i5));
                }
                i4++;
                i3 += this.f45649f;
            }
            for (Integer num : arrayList) {
                i2 += num.intValue();
            }
            getLayoutParams().height = i2 + ((i4 - 1) * getVerticalSpacing());
        }

        @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                super.onLayout(z, i2, i3, i4, i5);
                a();
            }
        }

        @Override // android.view.View
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
                int firstVisiblePosition = getFirstVisiblePosition();
                if (this.f45648e != firstVisiblePosition) {
                    this.f45648e = firstVisiblePosition;
                    a();
                }
                super.onScrollChanged(i2, i3, i4, i5);
            }
        }

        @Override // android.widget.GridView
        public void setNumColumns(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.f45649f = i2;
                super.setNumColumns(i2);
                setSelection(this.f45648e);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AutoGridView(GridPageView gridPageView, Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gridPageView, context, attributeSet};
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
            this.f45650g = gridPageView;
            this.f45649f = 5;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AutoGridView(GridPageView gridPageView, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gridPageView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45650g = gridPageView;
            this.f45649f = 5;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridPageView(Context context, AttributeSet attributeSet) {
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
        this.f45645e = null;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridPageView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f45645e = null;
        a(context);
    }
}
