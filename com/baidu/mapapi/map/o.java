package com.baidu.mapapi.map;

import android.graphics.Point;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.o.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes4.dex */
public class o<T extends a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h a;

    /* renamed from: b  reason: collision with root package name */
    public final int f26339b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f26340c;

    /* renamed from: d  reason: collision with root package name */
    public List<o<T>> f26341d;

    /* loaded from: classes4.dex */
    public static abstract class a {
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
    public o(double d2, double d3, double d4, double d5, int i) {
        this(new h(d2, d3, d4, d5), i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Integer.valueOf(i)};
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
        this.f26341d = null;
        this.a = hVar;
        this.f26339b = i;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            ArrayList arrayList = new ArrayList(4);
            this.f26341d = arrayList;
            h hVar = this.a;
            arrayList.add(new o(hVar.a, hVar.f26334e, hVar.f26331b, hVar.f26335f, this.f26339b + 1));
            List<o<T>> list = this.f26341d;
            h hVar2 = this.a;
            list.add(new o<>(hVar2.f26334e, hVar2.f26332c, hVar2.f26331b, hVar2.f26335f, this.f26339b + 1));
            List<o<T>> list2 = this.f26341d;
            h hVar3 = this.a;
            list2.add(new o<>(hVar3.a, hVar3.f26334e, hVar3.f26335f, hVar3.f26333d, this.f26339b + 1));
            List<o<T>> list3 = this.f26341d;
            h hVar4 = this.a;
            list3.add(new o<>(hVar4.f26334e, hVar4.f26332c, hVar4.f26335f, hVar4.f26333d, this.f26339b + 1));
            List<T> list4 = this.f26340c;
            this.f26340c = null;
            for (T t : list4) {
                a(t.a().x, t.a().y, t);
            }
        }
    }

    private void a(double d2, double d3, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), t}) == null) {
            List<o<T>> list = this.f26341d;
            if (list != null) {
                h hVar = this.a;
                int i = (d3 > hVar.f26335f ? 1 : (d3 == hVar.f26335f ? 0 : -1));
                int i2 = (d2 > hVar.f26334e ? 1 : (d2 == hVar.f26334e ? 0 : -1));
                list.get(i < 0 ? i2 < 0 ? 0 : 1 : i2 < 0 ? 2 : 3).a(d2, d3, t);
                return;
            }
            if (this.f26340c == null) {
                this.f26340c = new ArrayList();
            }
            this.f26340c.add(t);
            if (this.f26340c.size() <= 40 || this.f26339b >= 40) {
                return;
            }
            a();
        }
    }

    private void a(h hVar, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, hVar, collection) == null) && this.a.a(hVar)) {
            List<o<T>> list = this.f26341d;
            if (list != null) {
                for (o<T> oVar : list) {
                    oVar.a(hVar, collection);
                }
            } else if (this.f26340c != null) {
                if (hVar.b(this.a)) {
                    collection.addAll(this.f26340c);
                    return;
                }
                for (T t : this.f26340c) {
                    if (hVar.a(t.a())) {
                        collection.add(t);
                    }
                }
            }
        }
    }

    public Collection<T> a(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVar)) == null) {
            ArrayList arrayList = new ArrayList();
            a(hVar, arrayList);
            return arrayList;
        }
        return (Collection) invokeL.objValue;
    }

    public void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            Point a2 = t.a();
            if (this.a.a(a2.x, a2.y)) {
                a(a2.x, a2.y, t);
            }
        }
    }
}
