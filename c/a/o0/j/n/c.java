package c.a.o0.j.n;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.a.h1.c.h.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends c.a.o0.a.c0.b.a<TextureMapView, c.a.o0.a.h1.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public String f11731i;

    /* renamed from: j  reason: collision with root package name */
    public String f11732j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<b> n;
    public List<a> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull Context context, @NonNull c.a.o0.a.h1.c.c cVar) {
        super(context, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c.a.o0.a.c0.b.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.f11731i = cVar.f4630g;
        this.f11732j = cVar.f4629f;
        String str = cVar.f4631h;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = cVar.v;
    }

    public static c M(Context context, c.a.o0.a.h1.c.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, cVar)) == null) {
            if (context == null || cVar == null || !cVar.isValid()) {
                return null;
            }
            return new c(context, cVar);
        }
        return (c) invokeLL.objValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (b bVar : this.n) {
                this.l.removeView(bVar.f11724e);
            }
            this.n.clear();
            for (a aVar : this.o) {
                this.l.removeView(aVar.f11718b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public a I(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            for (a aVar : this.o) {
                if (aVar.f11718b == view) {
                    return aVar;
                }
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    @Nullable
    public b J(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (b bVar : this.n) {
                if (marker == bVar.f11721b) {
                    return bVar;
                }
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public List<b> K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (b bVar : this.n) {
                d dVar = bVar.f11720a;
                if (dVar != null && TextUtils.equals(str, dVar.f6507e)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.c0.b.a
    @NonNull
    /* renamed from: L */
    public TextureMapView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? this.l : (TextureMapView) invokeL.objValue;
    }
}
