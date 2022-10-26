package com.baidu.ar.statistic;

import android.content.Context;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.k;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public class b implements k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference wn;
    public Map wo;
    public d wp;
    public String wq;
    public String wr;
    public String[][] ws;
    public Map wt;
    public long wu;
    public long wv;
    public k ww;

    public b(Context context, d dVar, String[][] strArr, Map map, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dVar, strArr, map, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wn = new WeakReference(context);
        this.wp = dVar;
        this.wo = new HashMap();
        this.ws = strArr;
        this.wu = 0L;
        this.wv = 0L;
        this.wt = map == null ? new HashMap() : map;
        this.ww = kVar;
        kVar.a(this);
    }

    private Pair a(long j, long j2) {
        InterceptResult invokeCommon;
        long j3;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j5 = this.wu;
            if (j5 <= 0 || j > j5) {
                j3 = j2 - j;
                j4 = 0;
            } else {
                long j6 = this.wv;
                if (j6 <= 0 || j2 < j6) {
                    long j7 = this.wu;
                    j3 = j7 - j;
                    j4 = j2 - j7;
                } else {
                    j3 = (j5 - j) + (j6 - j2);
                    j4 = j6 - j5;
                }
            }
            if (j3 < 0) {
                j3 = 0;
            }
            return new Pair(Long.valueOf(j3), Long.valueOf(j4 >= 0 ? j4 : 0L));
        }
        return (Pair) invokeCommon.objValue;
    }

    private ArrayList aH(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            String[][] strArr = this.ws;
            if (strArr != null && strArr.length > 0) {
                for (String[] strArr2 : strArr) {
                    if (strArr2 != null && strArr2.length >= 2 && str.equals(strArr2[0])) {
                        for (int i = 1; i < strArr2.length; i++) {
                            arrayList.add(strArr2[i]);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private String aI(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            Object[][] objArr = this.ws;
            if (objArr == null || objArr.length <= 0) {
                return null;
            }
            for (Object[] objArr2 : objArr) {
                if (objArr2 != null && objArr2.length >= 2) {
                    for (int i = 1; i < objArr2.length; i++) {
                        if (str.equals(objArr2[i])) {
                            return objArr2[0];
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    private void b(a... aVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVarArr) == null) {
            synchronized (this.wp) {
                this.wp.gl();
                for (a aVar : aVarArr) {
                    this.wp.k(aVar);
                }
                this.wp.notifyAll();
            }
        }
    }

    private void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, aVar) == null) {
            f(aVar);
            if (aVar.aE("event_label") || !this.wt.containsKey(aVar.gf())) {
                return;
            }
            aVar.b("event_label", this.wt.get(aVar.gf()));
        }
    }

    private void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, aVar) == null) {
            aVar.b(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, this.wr);
        }
    }

    private String gj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.wq == null) {
                Context context = (Context) this.wn.get();
                if (context == null) {
                    return "";
                }
                UUID gz = new com.baidu.ar.h.g(context).gz();
                this.wq = gz != null ? gz.toString() : "";
            }
            return this.wq;
        }
        return (String) invokeV.objValue;
    }

    private void x(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65544, this, j) == null) {
            this.wu = j;
        }
    }

    private void y(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65545, this, j) == null) {
            long j2 = this.wu;
            if (j < j2) {
                j = j2;
            }
            this.wv = j;
        }
    }

    public void A(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            y(j);
        }
    }

    @Override // com.baidu.ar.statistic.k.a
    public void R(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || i <= 0) {
            return;
        }
        synchronized (this.wp) {
            this.wp.notifyAll();
        }
    }

    public void c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            d(aVar);
            b(aVar);
        }
    }

    public void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            d(aVar);
            synchronized (this.wp) {
                this.wp.gl();
                String gf = aVar.gf();
                long longValue = ((Number) aVar.aC("_db_period")).longValue();
                ArrayList arrayList = new ArrayList();
                int size = this.wp.size();
                for (int i = 0; i < size; i++) {
                    a aVar2 = (a) this.wp.get(i);
                    if (gf.equals(aVar2.gf()) && longValue == aVar2.aD("_db_period") && aVar.getTimestamp() - aVar2.getTimestamp() < longValue) {
                        arrayList.add(Integer.valueOf(i));
                    }
                }
                if (!arrayList.isEmpty()) {
                    for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                        int intValue = ((Integer) arrayList.get(size2)).intValue();
                        this.wp.remove(intValue);
                        a.a((a) this.wp.get(intValue));
                    }
                }
                this.wp.k(aVar);
                this.wp.notifyAll();
            }
        }
    }

    public void g(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            String gf = aVar.gf();
            a aVar2 = (a) this.wo.get(gf);
            boolean equals = "1".equals(aVar.aC("__stt"));
            if (aVar2 == null) {
                if (equals) {
                    this.wo.put(gf, aVar);
                    a clone = aVar.clone();
                    clone.aA(gf);
                    clone.aF("__stt");
                    clone.aF("__falseev");
                    c(clone);
                }
            } else if (equals) {
            } else {
                String aB = aVar.aB("__falseev");
                if (aB != null && !aB.isEmpty()) {
                    a clone2 = aVar.clone();
                    clone2.aA(aB);
                    clone2.aF("__stt");
                    clone2.aF("__falseev");
                    c(clone2);
                }
                this.wo.remove(gf);
                a.a(aVar2);
            }
        }
    }

    public void gk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.ww.gp();
        }
    }

    public void h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            String gf = aVar.gf();
            ArrayList aH = aH(gf);
            if (aH.isEmpty()) {
                return;
            }
            c(aVar.clone());
            Iterator it = aH.iterator();
            while (it.hasNext()) {
                Map map = this.wo;
                map.put(gf + ":" + ((String) it.next()), aVar);
            }
        }
    }

    public void h(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.ww.j(list);
        }
    }

    public void i(a aVar) {
        String gf;
        String aI;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || (aI = aI((gf = aVar.gf()))) == null || aI.isEmpty()) {
            return;
        }
        String str = aI + ":" + gf;
        a aVar2 = (a) this.wo.get(str);
        if (aVar2 != null) {
            Pair a = a(aVar2.getTimestamp(), aVar.getTimestamp());
            aVar.b("st", String.valueOf(aVar2.getTimestamp()));
            aVar.b("duration", String.valueOf(((Long) a.first).longValue()));
            aVar.b("_pausedt", String.valueOf(((Long) a.second).longValue()));
            c(aVar);
            this.wo.remove(str);
            a.a(aVar2);
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || ((Context) this.wn.get()) == null) {
            return;
        }
        this.wr = com.baidu.ar.h.l.aT(gj() + String.valueOf(System.currentTimeMillis()));
    }

    public void j(a aVar) {
        boolean n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            f(aVar);
            synchronized (this.ww) {
                n = this.ww.n(aVar);
            }
            if (n) {
                return;
            }
            a.a(aVar);
        }
    }

    public void z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            x(j);
            synchronized (this.wp) {
                this.wp.flush();
            }
            gk();
        }
    }
}
