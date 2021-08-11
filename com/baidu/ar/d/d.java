package com.baidu.ar.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e K;
    public List<k> O;
    public Looper mC;
    public Handler mD;
    public int mE;
    public ArrayList<c> mF;
    public HashMap<String, Boolean> mG;
    public HashMap<String, Boolean> mH;
    public long mI;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d mJ;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mJ = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1001:
                        this.mJ.e((l) message.obj);
                        return;
                    case 1002:
                        this.mJ.f((b) message.obj);
                        return;
                    case 1003:
                        this.mJ.f((l) message.obj);
                        return;
                    case 1004:
                        this.mJ.V();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public d(Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mF = new ArrayList<>();
        this.mG = new HashMap<>();
        this.mH = new HashMap<>();
        this.mI = 0L;
        this.mE = 180;
        this.mC = looper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            dg();
            this.mD.removeCallbacksAndMessages(null);
            this.mD = null;
        }
    }

    private void a(c cVar) {
        ArrayList<c> arrayList;
        List<k> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, cVar) == null) || cVar == null || (arrayList = this.mF) == null || arrayList.size() == 0 || (list = this.O) == null || list.size() == 0 || this.K == null) {
            return;
        }
        boolean z = true;
        Iterator<k> it = this.O.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (!cVar.X(it.next().getName())) {
                z = false;
                break;
            }
        }
        if (!z || cVar.getTimestamp() == this.mI) {
            return;
        }
        this.K.a(cVar);
        this.mI = cVar.getTimestamp();
        ArrayList<c> arrayList2 = this.mF;
        arrayList2.subList(0, arrayList2.indexOf(cVar)).clear();
    }

    private void dg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            List<k> list = this.O;
            if (list != null) {
                list.clear();
            }
            ArrayList<c> arrayList = this.mF;
            if (arrayList != null) {
                arrayList.clear();
            }
            HashMap<String, Boolean> hashMap = this.mG;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<String, Boolean> hashMap2 = this.mH;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, lVar) == null) {
            this.mG.put(lVar.dc(), Boolean.valueOf(lVar.isSuccess()));
            Iterator<k> it = this.O.iterator();
            boolean z = true;
            boolean z2 = true;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                k next = it.next();
                if (this.mG.get(next.getName()) == null) {
                    z = false;
                    break;
                } else if (!this.mG.get(next.getName()).booleanValue()) {
                    z2 = false;
                }
            }
            e eVar = this.K;
            if (eVar != null) {
                eVar.a(lVar);
                if (z) {
                    this.K.a(new l("DetectorGroup", z2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(b bVar) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, bVar) == null) || this.mF == null || (hashMap = this.mG) == null || hashMap.isEmpty()) {
            return;
        }
        c g2 = g(bVar);
        if (g2 == null) {
            g2 = h(bVar);
        }
        a(g2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, lVar) == null) {
            this.mH.put(lVar.dc(), Boolean.valueOf(lVar.isSuccess()));
            Iterator<k> it = this.O.iterator();
            boolean z = true;
            boolean z2 = true;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                k next = it.next();
                if (this.mH.get(next.getName()) == null) {
                    z = false;
                    break;
                } else if (!this.mH.get(next.getName()).booleanValue()) {
                    z2 = false;
                }
            }
            e eVar = this.K;
            if (eVar != null) {
                eVar.b(lVar);
                if (z) {
                    this.K.b(new l("DetectorGroup", z2));
                    dg();
                }
            }
        }
    }

    private c g(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, bVar)) == null) {
            Iterator<c> it = this.mF.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.getTimestamp() == bVar.getTimestamp()) {
                    next.c(bVar);
                    return next;
                }
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    private c h(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, bVar)) == null) {
            if (this.mF.size() >= this.mE) {
                com.baidu.ar.h.b.b("DetectResultSync", "add2NewDetectResultGroup detectResult list for sync is fulllll!!!");
                return null;
            }
            c cVar = new c();
            cVar.setTimestamp(bVar.getTimestamp());
            cVar.c(bVar);
            this.mF.add(cVar);
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public void a(List<k> list, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, eVar) == null) {
            this.O = list;
            this.K = eVar;
            if (this.mD != null || this.mC == null) {
                return;
            }
            this.mD = new a(this, this.mC);
        }
    }

    public synchronized void c(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            synchronized (this) {
                com.baidu.ar.h.b.c("DetectResultSync", "DetectorGroup onDetectorSetup result = " + lVar.dc());
                if (this.mD != null) {
                    this.mD.sendMessage(this.mD.obtainMessage(1001, lVar));
                }
            }
        }
    }

    public synchronized void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            synchronized (this) {
                if (this.mD != null) {
                    this.mD.sendMessage(this.mD.obtainMessage(1002, bVar));
                }
            }
        }
    }

    public synchronized void d(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lVar) == null) {
            synchronized (this) {
                com.baidu.ar.h.b.c("DetectResultSync", "DetectorGroup onDetectorRelease result = " + lVar.dc());
                if (this.mD != null) {
                    this.mD.sendMessage(this.mD.obtainMessage(1003, lVar));
                }
            }
        }
    }

    public synchronized boolean e(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            synchronized (this) {
                if (this.mF.size() != 0) {
                    if (this.mF.get(0).getTimestamp() < bVar.getTimestamp()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void release() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (handler = this.mD) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1004));
    }
}
