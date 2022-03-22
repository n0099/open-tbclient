package com.baidu.swan.apps.publisher.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f.d.k0;
import c.a.n0.a.p1.j.g;
import c.a.n0.a.z0.d.d.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class PhotoChooseView extends GridView implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f29046b;

    /* renamed from: c  reason: collision with root package name */
    public int f29047c;

    /* renamed from: d  reason: collision with root package name */
    public int f29048d;

    /* renamed from: e  reason: collision with root package name */
    public c f29049e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.a.p1.h.f.a f29050f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f29051g;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PhotoChooseView a;

        public a(PhotoChooseView photoChooseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {photoChooseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = photoChooseView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PhotoChooseView photoChooseView = this.a;
                photoChooseView.setAdapter((ListAdapter) photoChooseView.f29050f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 9;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getLeftCount() <= 0) {
            return;
        }
        g.i(getLeftCount(), this.f29049e);
    }

    public final void c(int i) {
        k0 C;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (C = c.a.n0.a.s0.a.C()) == null) {
            return;
        }
        C.d(getContext(), (String[]) this.f29050f.c().toArray(new String[0]), i);
    }

    public void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            this.f29051g = activity;
            this.f29050f = new c.a.n0.a.p1.h.f.a(activity.getApplicationContext(), this.f29046b, this.f29048d);
            setOnItemClickListener(this);
            postDelayed(new a(this), 10L);
        }
    }

    public List<String> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<String> c2 = this.f29050f.c();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int size = this.f29050f.c().size();
            int i = this.a;
            if (size >= i) {
                return 0;
            }
            return i - size;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (this.f29050f.e(i)) {
                if (i == this.f29050f.getCount() - 1) {
                    c.a.n0.a.p1.j.c.onEvent("pic_clk_content");
                    b();
                    return;
                }
                c(i);
                return;
            }
            c(i);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            super.onMeasure(i, i2);
            if (getCount() <= 0 || getChildAt(0) == null || (measuredHeight = getChildAt(0).getMeasuredHeight()) == -1) {
                return;
            }
            setMeasuredDimension(i, (measuredHeight * (((getCount() - 1) / this.f29048d) + 1)) + (this.f29047c * ((getCount() - 1) / this.f29048d)));
        }
    }

    public void setCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f29049e = cVar;
        }
    }

    public void setDeleteListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f29050f.g(bVar);
        }
    }

    @Override // android.widget.GridView
    public void setHorizontalSpacing(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.setHorizontalSpacing(i);
            this.f29046b = i;
        }
    }

    public void setMaxCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.a = i;
            this.f29050f.h(i);
        }
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            super.setNumColumns(i);
            this.f29048d = i;
        }
    }

    @Override // android.widget.GridView
    public void setVerticalSpacing(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            super.setVerticalSpacing(i);
            this.f29047c = i;
        }
    }

    public void update(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.f29050f.f(list);
            this.f29050f.notifyDataSetChanged();
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
        this.a = 9;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'c.a.n0.a.p1.h.f.a' to match base method */
    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: getAdapter */
    public ListAdapter getAdapter2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29050f : (c.a.n0.a.p1.h.f.a) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoChooseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 9;
    }
}
