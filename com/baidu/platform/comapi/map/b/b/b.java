package com.baidu.platform.comapi.map.b.b;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.b.a;
import com.baidu.platform.comapi.map.b.a.b;
import com.baidu.platform.comapi.map.b.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class b implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<a.C0126a> a;
    public f b;
    public MapController c;
    public boolean d;
    public a e;
    public int f;

    public b(MapController mapController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mapController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList<>();
        f fVar = new f();
        this.b = fVar;
        this.d = false;
        this.c = mapController;
        this.f = fVar.b / 3;
    }

    private void c(com.baidu.platform.comapi.map.b.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, bVar) == null) {
            if (this.a.size() < 5) {
                this.a.addLast(bVar.c);
                this.b.a(bVar.d);
            } else if (!this.d && this.a.size() == 5 && a()) {
                d(bVar);
            }
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        boolean z;
        int a;
        double a2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            this.d = true;
            Iterator<a.C0126a> it = this.a.iterator();
            while (it.hasNext()) {
                Double valueOf = Double.valueOf(a.d.a(com.baidu.platform.comapi.map.b.a.a.c(), it.next().c()));
                if (Math.abs(valueOf.doubleValue()) > 45.0d && Math.abs(valueOf.doubleValue()) < 135.0d) {
                    return false;
                }
            }
            Pair<a.d, a.d> c = this.b.c();
            a.d dVar = (a.d) c.first;
            a.d dVar2 = (a.d) c.second;
            if (Math.abs(dVar.b) > this.f && Math.abs(dVar2.b) > this.f) {
                z = true;
            } else {
                z = false;
            }
            a.C0126a first = this.a.getFirst();
            a.C0126a last = this.a.getLast();
            a.C0126a c0126a = new a.C0126a(last.a, first.a);
            a.C0126a c0126a2 = new a.C0126a(last.b, first.b);
            if (dVar.b > 0.0d && dVar2.b > 0.0d) {
                a = (int) a.d.a(c0126a.c(), com.baidu.platform.comapi.map.b.a.c.c());
                a2 = a.d.a(c0126a2.c(), com.baidu.platform.comapi.map.b.a.c.c());
            } else {
                a = (int) a.d.a(c0126a.c(), com.baidu.platform.comapi.map.b.a.b.c());
                a2 = a.d.a(c0126a2.c(), com.baidu.platform.comapi.map.b.a.b.c());
            }
            int i = (int) a2;
            if (Math.abs(a) < 40 && Math.abs(i) < 40) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && z2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void d(com.baidu.platform.comapi.map.b.a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, bVar) == null) && this.c.isOverlookGestureEnable()) {
            this.e.a(bVar, (Pair<a.d, a.d>) null);
            c cVar = new c(this.c);
            this.e = cVar;
            cVar.a(bVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.b.a.b.a
    public boolean a(com.baidu.platform.comapi.map.b.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            this.a.clear();
            this.b.a();
            this.e = new d(this.c);
            this.d = false;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.b.a.b.a
    public boolean b(com.baidu.platform.comapi.map.b.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            Pair<a.d, a.d> c = this.b.c();
            this.b.b();
            this.e.a(bVar, c);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.b.a.b.a
    public boolean a(com.baidu.platform.comapi.map.b.a.b bVar, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, motionEvent)) == null) {
            c(bVar);
            if (this.a.size() == 1) {
                this.e.a(bVar);
            }
            this.e.a(bVar, motionEvent);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
