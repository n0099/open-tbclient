package c.a.q0.e1.f.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.q0.m.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a<T> extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f12344b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f12345c;

    /* renamed from: d  reason: collision with root package name */
    public Context f12346d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f12347e;

    /* renamed from: f  reason: collision with root package name */
    public e<T> f12348f;

    /* renamed from: c.a.q0.e1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0829a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public T f12349e;

        /* renamed from: f  reason: collision with root package name */
        public int f12350f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f12351g;

        public View$OnClickListenerC0829a(a aVar, T t, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, t, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12351g = aVar;
            this.f12349e = t;
            this.f12350f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e<T> eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (eVar = this.f12351g.f12348f) == null) {
                return;
            }
            T t = this.f12349e;
            int i2 = this.f12350f;
            eVar.a(view, t, i2, i2);
        }
    }

    public a(Context context, List<T> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12346d = context;
        this.f12345c = list == null ? new ArrayList() : new ArrayList(list);
        this.f12344b = i2;
        this.f12347e = LayoutInflater.from(this.f12346d);
    }

    @Override // c.a.q0.e1.f.a.b
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12345c.size() : invokeV.intValue;
    }

    @Override // c.a.q0.e1.f.a.b
    public View b(int i2, ViewGroup viewGroup) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, viewGroup)) == null) {
            View inflate = this.f12347e.inflate(this.f12344b, viewGroup, false);
            c cVar = new c(inflate);
            T t = this.f12345c.get(i2);
            f(cVar, t, i2);
            cVar.c(new View$OnClickListenerC0829a(this, t, i2));
            return inflate;
        }
        return (View) invokeIL.objValue;
    }

    public abstract void f(c cVar, T t, int i2);

    public void g(List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.f12345c = list;
            c();
        }
    }

    public void h(e<T> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f12348f = eVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, int i2) {
        this(context, null, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (List) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
