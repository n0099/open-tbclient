package com.baidu.swan.apps.publisher.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.i1.d.d.c;
import c.a.p0.a.p.d.h0;
import c.a.p0.a.w1.j.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class PhotoChooseView extends GridView implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f46315e;

    /* renamed from: f  reason: collision with root package name */
    public int f46316f;

    /* renamed from: g  reason: collision with root package name */
    public int f46317g;

    /* renamed from: h  reason: collision with root package name */
    public int f46318h;

    /* renamed from: i  reason: collision with root package name */
    public c f46319i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.a.w1.h.f.a f46320j;
    public Activity k;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PhotoChooseView f46321e;

        public a(PhotoChooseView photoChooseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {photoChooseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46321e = photoChooseView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PhotoChooseView photoChooseView = this.f46321e;
                photoChooseView.setAdapter((ListAdapter) photoChooseView.f46320j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoChooseView(Context context) {
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
        this.f46315e = 9;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getLeftCount() <= 0) {
            return;
        }
        g.i(getLeftCount(), this.f46319i);
    }

    public final void c(int i2) {
        h0 y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (y = c.a.p0.a.c1.a.y()) == null) {
            return;
        }
        y.d(getContext(), (String[]) this.f46320j.c().toArray(new String[0]), i2);
    }

    public List<String> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<String> c2 = this.f46320j.c();
            if (c2 == null || c2.size() == 0) {
                return null;
            }
            return c2;
        }
        return (List) invokeV.objValue;
    }

    public int getLeftCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int size = this.f46320j.c().size();
            int i2 = this.f46315e;
            if (size >= i2) {
                return 0;
            }
            return i2 - size;
        }
        return invokeV.intValue;
    }

    public void init(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            this.k = activity;
            this.f46320j = new c.a.p0.a.w1.h.f.a(activity.getApplicationContext(), this.f46316f, this.f46318h);
            setOnItemClickListener(this);
            postDelayed(new a(this), 10L);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (this.f46320j.e(i2)) {
                if (i2 == this.f46320j.getCount() - 1) {
                    c.a.p0.a.w1.j.c.onEvent("pic_clk_content");
                    b();
                    return;
                }
                c(i2);
                return;
            }
            c(i2);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (getCount() <= 0 || getChildAt(0) == null || (measuredHeight = getChildAt(0).getMeasuredHeight()) == -1) {
                return;
            }
            setMeasuredDimension(i2, (measuredHeight * (((getCount() - 1) / this.f46318h) + 1)) + (this.f46317g * ((getCount() - 1) / this.f46318h)));
        }
    }

    public void setCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f46319i = cVar;
        }
    }

    public void setDeleteListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f46320j.g(bVar);
        }
    }

    @Override // android.widget.GridView
    public void setHorizontalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            super.setHorizontalSpacing(i2);
            this.f46316f = i2;
        }
    }

    public void setMaxCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f46315e = i2;
            this.f46320j.h(i2);
        }
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.setNumColumns(i2);
            this.f46318h = i2;
        }
    }

    @Override // android.widget.GridView
    public void setVerticalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            super.setVerticalSpacing(i2);
            this.f46317g = i2;
        }
    }

    public void update(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.f46320j.f(list);
            this.f46320j.notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoChooseView(Context context, AttributeSet attributeSet) {
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
        this.f46315e = 9;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'c.a.p0.a.w1.h.f.a' to match base method */
    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: getAdapter */
    public ListAdapter getAdapter2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f46320j : (c.a.p0.a.w1.h.f.a) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoChooseView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f46315e = 9;
    }
}
