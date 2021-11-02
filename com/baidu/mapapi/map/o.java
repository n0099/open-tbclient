package com.baidu.mapapi.map;

import android.graphics.Point;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.o.a;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes7.dex */
public class o<T extends a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h f39587a;

    /* renamed from: b  reason: collision with root package name */
    public final int f39588b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f39589c;

    /* renamed from: d  reason: collision with root package name */
    public List<o<T>> f39590d;

    /* loaded from: classes7.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract Point a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(double d2, double d3, double d4, double d5, int i2) {
        this(new h(d2, d3, d4, d5), i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((h) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public o(h hVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f39590d = null;
        this.f39587a = hVar;
        this.f39588b = i2;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            ArrayList arrayList = new ArrayList(4);
            this.f39590d = arrayList;
            h hVar = this.f39587a;
            arrayList.add(new o(hVar.f39574a, hVar.f39578e, hVar.f39575b, hVar.f39579f, this.f39588b + 1));
            List<o<T>> list = this.f39590d;
            h hVar2 = this.f39587a;
            list.add(new o<>(hVar2.f39578e, hVar2.f39576c, hVar2.f39575b, hVar2.f39579f, this.f39588b + 1));
            List<o<T>> list2 = this.f39590d;
            h hVar3 = this.f39587a;
            list2.add(new o<>(hVar3.f39574a, hVar3.f39578e, hVar3.f39579f, hVar3.f39577d, this.f39588b + 1));
            List<o<T>> list3 = this.f39590d;
            h hVar4 = this.f39587a;
            list3.add(new o<>(hVar4.f39578e, hVar4.f39576c, hVar4.f39579f, hVar4.f39577d, this.f39588b + 1));
            List<T> list4 = this.f39589c;
            this.f39589c = null;
            for (T t : list4) {
                a(t.a().x, t.a().y, t);
            }
        }
    }

    private void a(double d2, double d3, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), t}) == null) {
            List<o<T>> list = this.f39590d;
            if (list != null) {
                h hVar = this.f39587a;
                int i2 = (d3 > hVar.f39579f ? 1 : (d3 == hVar.f39579f ? 0 : -1));
                int i3 = (d2 > hVar.f39578e ? 1 : (d2 == hVar.f39578e ? 0 : -1));
                list.get(i2 < 0 ? i3 < 0 ? 0 : 1 : i3 < 0 ? 2 : 3).a(d2, d3, t);
                return;
            }
            if (this.f39589c == null) {
                this.f39589c = new ArrayList();
            }
            this.f39589c.add(t);
            if (this.f39589c.size() <= 40 || this.f39588b >= 40) {
                return;
            }
            a();
        }
    }

    private void a(h hVar, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, hVar, collection) == null) && this.f39587a.a(hVar)) {
            List<o<T>> list = this.f39590d;
            if (list != null) {
                for (o<T> oVar : list) {
                    oVar.a(hVar, collection);
                }
            } else if (this.f39589c != null) {
                if (hVar.b(this.f39587a)) {
                    collection.addAll(this.f39589c);
                    return;
                }
                for (T t : this.f39589c) {
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
            if (this.f39587a.a(a2.x, a2.y)) {
                a(a2.x, a2.y, t);
            }
        }
    }
}
