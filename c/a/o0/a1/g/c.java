package c.a.o0.a1.g;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.o0.a1.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, d> a;

    /* renamed from: b  reason: collision with root package name */
    public final ViewGroup f9799b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.o0.a1.i.a f9800c;

    /* renamed from: d  reason: collision with root package name */
    public final h f9801d;

    /* renamed from: e  reason: collision with root package name */
    public ViewType f9802e;

    /* renamed from: f  reason: collision with root package name */
    public d f9803f;

    public c(c.a.o0.a1.i.a aVar, @NonNull ViewGroup viewGroup, @NonNull h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, viewGroup, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.f9799b = viewGroup;
        this.f9800c = aVar;
        this.f9801d = hVar;
    }

    @Override // c.a.o0.a1.g.b
    public void a(ViewType viewType, String str) {
        h.a aVar;
        h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.f9801d.f9811c) != null) {
                bVar.a = str;
            } else if (viewType != ViewType.EMPTY || (aVar = this.f9801d.f9810b) == null) {
            } else {
                aVar.a = str;
            }
        }
    }

    @Override // c.a.o0.a1.g.b
    public void b(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewType) == null) || this.f9802e == viewType) {
            return;
        }
        this.f9802e = viewType;
        if (this.f9799b == null) {
            return;
        }
        c.a.o0.a1.i.a aVar = this.f9800c;
        if (aVar != null && aVar.getView() != null) {
            this.f9800c.getView().setVisibility(viewType == ViewType.CONTENT ? 0 : 8);
        }
        d dVar = this.f9803f;
        if (dVar != null) {
            dVar.b(this.f9799b);
        }
        d dVar2 = this.a.get(viewType);
        h.e d2 = d(viewType);
        if (dVar2 == null || d2 == null) {
            return;
        }
        dVar2.c(viewType, this.f9799b, d2);
        this.f9803f = dVar2;
        this.a.put(viewType, dVar2);
    }

    @Override // c.a.o0.a1.g.b
    public void c(ViewType viewType, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, dVar) == null) {
            this.a.put(viewType, dVar);
        }
    }

    public final h.e d(ViewType viewType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewType)) == null) {
            if (viewType == ViewType.ERROR) {
                return this.f9801d.f9811c;
            }
            if (viewType == ViewType.EMPTY) {
                return this.f9801d.f9810b;
            }
            if (viewType == ViewType.LOADING) {
                return this.f9801d.a;
            }
            return null;
        }
        return (h.e) invokeL.objValue;
    }

    @Override // c.a.o0.a1.g.b
    public void onChangeSkinType(int i) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (dVar = this.f9803f) == null) {
            return;
        }
        dVar.e(i);
    }

    @Override // c.a.o0.a1.g.b
    public void onDestroy() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (dVar = this.f9803f) == null) {
            return;
        }
        dVar.b(this.f9799b);
    }
}
