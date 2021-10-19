package c.a.r0.y3.i.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends c.a.e.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f29233a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f29234b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.y3.i.h.a f29235c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.y3.i.c.b f29236d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.y3.i.d.a f29237e;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29238e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29238e = dVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                c.a.r0.y3.i.e.a aVar = (c.a.r0.y3.i.e.a) this.f29238e.f29236d.getItem(i2);
                if (this.f29238e.f29237e != null) {
                    this.f29238e.f29237e.h(aVar);
                }
                if (this.f29238e.f29235c == null || this.f29238e.f29235c.v() == null) {
                    return;
                }
                this.f29238e.f29235c.v().setFilter(aVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar, c.a.r0.y3.i.h.a aVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29235c = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.f29233a = inflate;
        inflate.getResources();
        i();
    }

    public c.a.r0.y3.i.e.a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            for (c.a.r0.y3.i.e.a aVar : this.f29236d.a()) {
                if (aVar != null && StringHelper.equals(aVar.f29180c, str)) {
                    return aVar;
                }
            }
            return null;
        }
        return (c.a.r0.y3.i.e.a) invokeL.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29233a : (View) invokeV.objValue;
    }

    public void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f29234b = (HorizontalListView) this.f29233a.findViewById(R.id.edit_filter_horizontal_list);
            this.f29236d = new c.a.r0.y3.i.c.b();
            o(c.a.r0.y3.i.d.a.c(this.f29233a.getContext()));
            this.f29234b.setOnItemClickListener(new a(this));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public void m(c.a.r0.y3.i.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f29236d.b(aVar);
        }
    }

    public void n(c.a.r0.y3.i.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f29237e = aVar;
        }
    }

    public void o(List<c.a.r0.y3.i.e.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.f29236d.c(list);
            this.f29234b.setAdapter((ListAdapter) this.f29236d);
        }
    }
}
