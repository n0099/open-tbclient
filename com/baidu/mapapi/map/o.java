package com.baidu.mapapi.map;

import android.graphics.Point;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes2.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h a;
    public final int b;
    public List c;
    public List d;

    /* loaded from: classes2.dex */
    public abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract Point a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(double d, double d2, double d3, double d4, int i) {
        this(new h(d, d2, d3, d4), i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((h) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(h hVar) {
        this(hVar, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((h) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public o(h hVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = null;
        this.a = hVar;
        this.b = i;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            ArrayList arrayList = new ArrayList(4);
            this.d = arrayList;
            h hVar = this.a;
            arrayList.add(new o(hVar.a, hVar.e, hVar.b, hVar.f, this.b + 1));
            List list = this.d;
            h hVar2 = this.a;
            list.add(new o(hVar2.e, hVar2.c, hVar2.b, hVar2.f, this.b + 1));
            List list2 = this.d;
            h hVar3 = this.a;
            list2.add(new o(hVar3.a, hVar3.e, hVar3.f, hVar3.d, this.b + 1));
            List list3 = this.d;
            h hVar4 = this.a;
            list3.add(new o(hVar4.e, hVar4.c, hVar4.f, hVar4.d, this.b + 1));
            List<a> list4 = this.c;
            this.c = null;
            for (a aVar : list4) {
                a(aVar.a().x, aVar.a().y, aVar);
            }
        }
    }

    private void a(double d, double d2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Double.valueOf(d), Double.valueOf(d2), aVar}) == null) {
            List list = this.d;
            if (list != null) {
                h hVar = this.a;
                int i = (d2 > hVar.f ? 1 : (d2 == hVar.f ? 0 : -1));
                int i2 = (d > hVar.e ? 1 : (d == hVar.e ? 0 : -1));
                ((o) list.get(i < 0 ? i2 < 0 ? 0 : 1 : i2 < 0 ? 2 : 3)).a(d, d2, aVar);
                return;
            }
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(aVar);
            if (this.c.size() <= 40 || this.b >= 40) {
                return;
            }
            a();
        }
    }

    private void a(h hVar, Collection collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, hVar, collection) == null) && this.a.a(hVar)) {
            List<o> list = this.d;
            if (list != null) {
                for (o oVar : list) {
                    oVar.a(hVar, collection);
                }
            } else if (this.c != null) {
                if (hVar.b(this.a)) {
                    collection.addAll(this.c);
                    return;
                }
                for (a aVar : this.c) {
                    if (hVar.a(aVar.a())) {
                        collection.add(aVar);
                    }
                }
            }
        }
    }

    public Collection a(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVar)) == null) {
            ArrayList arrayList = new ArrayList();
            a(hVar, arrayList);
            return arrayList;
        }
        return (Collection) invokeL.objValue;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            Point a2 = aVar.a();
            if (this.a.a(a2.x, a2.y)) {
                a(a2.x, a2.y, aVar);
            }
        }
    }
}
