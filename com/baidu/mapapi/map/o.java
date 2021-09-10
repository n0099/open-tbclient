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
/* loaded from: classes5.dex */
public class o<T extends a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h f41683a;

    /* renamed from: b  reason: collision with root package name */
    public final int f41684b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f41685c;

    /* renamed from: d  reason: collision with root package name */
    public List<o<T>> f41686d;

    /* loaded from: classes5.dex */
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
        this.f41686d = null;
        this.f41683a = hVar;
        this.f41684b = i2;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            ArrayList arrayList = new ArrayList(4);
            this.f41686d = arrayList;
            h hVar = this.f41683a;
            arrayList.add(new o(hVar.f41670a, hVar.f41674e, hVar.f41671b, hVar.f41675f, this.f41684b + 1));
            List<o<T>> list = this.f41686d;
            h hVar2 = this.f41683a;
            list.add(new o<>(hVar2.f41674e, hVar2.f41672c, hVar2.f41671b, hVar2.f41675f, this.f41684b + 1));
            List<o<T>> list2 = this.f41686d;
            h hVar3 = this.f41683a;
            list2.add(new o<>(hVar3.f41670a, hVar3.f41674e, hVar3.f41675f, hVar3.f41673d, this.f41684b + 1));
            List<o<T>> list3 = this.f41686d;
            h hVar4 = this.f41683a;
            list3.add(new o<>(hVar4.f41674e, hVar4.f41672c, hVar4.f41675f, hVar4.f41673d, this.f41684b + 1));
            List<T> list4 = this.f41685c;
            this.f41685c = null;
            for (T t : list4) {
                a(t.a().x, t.a().y, t);
            }
        }
    }

    private void a(double d2, double d3, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), t}) == null) {
            List<o<T>> list = this.f41686d;
            if (list != null) {
                h hVar = this.f41683a;
                int i2 = (d3 > hVar.f41675f ? 1 : (d3 == hVar.f41675f ? 0 : -1));
                int i3 = (d2 > hVar.f41674e ? 1 : (d2 == hVar.f41674e ? 0 : -1));
                list.get(i2 < 0 ? i3 < 0 ? 0 : 1 : i3 < 0 ? 2 : 3).a(d2, d3, t);
                return;
            }
            if (this.f41685c == null) {
                this.f41685c = new ArrayList();
            }
            this.f41685c.add(t);
            if (this.f41685c.size() <= 40 || this.f41684b >= 40) {
                return;
            }
            a();
        }
    }

    private void a(h hVar, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, hVar, collection) == null) && this.f41683a.a(hVar)) {
            List<o<T>> list = this.f41686d;
            if (list != null) {
                for (o<T> oVar : list) {
                    oVar.a(hVar, collection);
                }
            } else if (this.f41685c != null) {
                if (hVar.b(this.f41683a)) {
                    collection.addAll(this.f41685c);
                    return;
                }
                for (T t : this.f41685c) {
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
            if (this.f41683a.a(a2.x, a2.y)) {
                a(a2.x, a2.y, t);
            }
        }
    }
}
