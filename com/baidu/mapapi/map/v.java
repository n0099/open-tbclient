package com.baidu.mapapi.map;

import android.graphics.Point;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.v.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes2.dex */
public class v<T extends a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final m a;
    public final int b;
    public List<T> c;
    public List<v<T>> d;

    /* loaded from: classes2.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract Point getPoint();

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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v(double d, double d2, double d3, double d4, int i) {
        this(new m(d, d2, d3, d4), i);
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
                this((m) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v(m mVar) {
        this(mVar, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((m) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public v(m mVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar, Integer.valueOf(i)};
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
        this.a = mVar;
        this.b = i;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            ArrayList arrayList = new ArrayList(4);
            this.d = arrayList;
            m mVar = this.a;
            arrayList.add(new v(mVar.a, mVar.e, mVar.b, mVar.f, this.b + 1));
            List<v<T>> list = this.d;
            m mVar2 = this.a;
            list.add(new v<>(mVar2.e, mVar2.c, mVar2.b, mVar2.f, this.b + 1));
            List<v<T>> list2 = this.d;
            m mVar3 = this.a;
            list2.add(new v<>(mVar3.a, mVar3.e, mVar3.f, mVar3.d, this.b + 1));
            List<v<T>> list3 = this.d;
            m mVar4 = this.a;
            list3.add(new v<>(mVar4.e, mVar4.c, mVar4.f, mVar4.d, this.b + 1));
            List<T> list4 = this.c;
            this.c = null;
            for (T t : list4) {
                a(t.getPoint().x, t.getPoint().y, t);
            }
        }
    }

    private void a(double d, double d2, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Double.valueOf(d), Double.valueOf(d2), t}) == null) {
            List<v<T>> list = this.d;
            if (list != null) {
                m mVar = this.a;
                if (d2 < mVar.f) {
                    if (d < mVar.e) {
                        list.get(0).a(d, d2, t);
                        return;
                    } else {
                        list.get(1).a(d, d2, t);
                        return;
                    }
                } else if (d < mVar.e) {
                    list.get(2).a(d, d2, t);
                    return;
                } else {
                    list.get(3).a(d, d2, t);
                    return;
                }
            }
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(t);
            if (this.c.size() > 40 && this.b < 40) {
                a();
            }
        }
    }

    private void a(m mVar, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, this, mVar, collection) != null) || !this.a.a(mVar)) {
            return;
        }
        List<v<T>> list = this.d;
        if (list != null) {
            for (v<T> vVar : list) {
                vVar.a(mVar, collection);
            }
        } else if (this.c != null) {
            if (mVar.b(this.a)) {
                collection.addAll(this.c);
                return;
            }
            for (T t : this.c) {
                if (mVar.a(t.getPoint())) {
                    collection.add(t);
                }
            }
        }
    }

    public Collection<T> a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mVar)) == null) {
            ArrayList arrayList = new ArrayList();
            a(mVar, arrayList);
            return arrayList;
        }
        return (Collection) invokeL.objValue;
    }

    public void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            Point point = t.getPoint();
            if (this.a.a(point.x, point.y)) {
                a(point.x, point.y, t);
            }
        }
    }
}
