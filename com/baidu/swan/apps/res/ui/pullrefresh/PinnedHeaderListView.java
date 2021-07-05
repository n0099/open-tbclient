package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PinnedHeaderListView extends ListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f11383e;

    /* renamed from: f  reason: collision with root package name */
    public View f11384f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11385g;

    /* renamed from: h  reason: collision with root package name */
    public int f11386h;

    /* renamed from: i  reason: collision with root package name */
    public int f11387i;
    public AbsListView.OnScrollListener j;

    /* loaded from: classes4.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PinnedHeaderListView f11388e;

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
            this.f11388e = pinnedHeaderListView;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                this.f11388e.b(i2);
                if (this.f11388e.j != null) {
                    this.f11388e.j.onScroll(absListView, i2, i3, i4);
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) || this.f11388e.j == null) {
                return;
            }
            this.f11388e.j.onScrollStateChanged(absListView, i2);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, int i2, int i3);

        int b(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinnedHeaderListView(Context context) {
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
        c(context);
    }

    public void b(int i2) {
        b bVar;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f11384f == null || (bVar = this.f11383e) == null) {
            return;
        }
        int b2 = bVar.b(i2);
        if (b2 == 0) {
            this.f11385g = false;
            return;
        }
        int i4 = 255;
        if (b2 == 1) {
            this.f11383e.a(this.f11384f, i2, 255);
            if (this.f11384f.getTop() != 0) {
                this.f11384f.layout(0, 0, this.f11386h, this.f11387i);
            }
            this.f11385g = true;
        } else if (b2 != 2) {
        } else {
            int bottom = getChildAt(0).getBottom();
            int height = this.f11384f.getHeight();
            if (bottom < height) {
                i3 = bottom - height;
                i4 = ((height + i3) * 255) / height;
            } else {
                i3 = 0;
            }
            this.f11383e.a(this.f11384f, i2, i4);
            if (this.f11384f.getTop() != i3) {
                this.f11384f.layout(0, i3, this.f11386h, this.f11387i + i3);
            }
            this.f11385g = true;
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            super.setOnScrollListener(new a(this));
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.f11385g) {
                drawChild(canvas, this.f11384f, getDrawingTime());
            }
        }
    }

    public View getPinnedHeaderView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11384f : (View) invokeV.objValue;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            View view = this.f11384f;
            if (view != null) {
                view.layout(0, 0, this.f11386h, this.f11387i);
                b(getFirstVisiblePosition());
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            View view = this.f11384f;
            if (view != null) {
                measureChild(view, i2, i3);
                this.f11386h = this.f11384f.getMeasuredWidth();
                this.f11387i = this.f11384f.getMeasuredHeight();
            }
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onScrollListener) == null) {
            this.j = onScrollListener;
        }
    }

    public void setPinnedHeaderView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.f11384f = view;
            if (view != null) {
                setFadingEdgeLength(0);
            }
            requestLayout();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, listAdapter) == null) {
            super.setAdapter(listAdapter);
            if (listAdapter instanceof b) {
                this.f11383e = (b) listAdapter;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
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
        c(context);
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
        c(context);
    }
}
