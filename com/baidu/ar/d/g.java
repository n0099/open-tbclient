package com.baidu.ar.d;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.renderer.OnNeedCacheFrameListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.ar.arrender.c g;
    public long mI;
    public f mP;
    public e mQ;
    public ConcurrentHashMap mR;
    public List mS;
    public ConcurrentHashMap mT;
    public OnNeedCacheFrameListener mU;
    public boolean mV;

    public g(com.baidu.ar.arrender.c cVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mR = new ConcurrentHashMap();
        this.mS = Collections.synchronizedList(new ArrayList());
        this.mT = new ConcurrentHashMap();
        this.mI = 0L;
        this.g = cVar;
        OnNeedCacheFrameListener onNeedCacheFrameListener = new OnNeedCacheFrameListener(this) { // from class: com.baidu.ar.d.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g mW;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.mW = this;
            }

            @Override // com.baidu.ar.arplay.core.renderer.OnNeedCacheFrameListener
            public boolean isNeedCacheFrame(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeJ = interceptable2.invokeJ(1048576, this, j)) == null) {
                    if (this.mW.mP == null) {
                        return false;
                    }
                    if (this.mW.mI != j) {
                        g gVar = this.mW;
                        gVar.mV = gVar.mP.ap();
                    }
                    this.mW.mI = j;
                    return this.mW.mV;
                }
                return invokeJ.booleanValue;
            }
        };
        this.mU = onNeedCacheFrameListener;
        this.g.a(onNeedCacheFrameListener);
        this.mP = new f(looper);
        e eVar = new e(this) { // from class: com.baidu.ar.d.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g mW;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.mW = this;
            }

            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    this.mW.j(bVar);
                    if (this.mW.g != null) {
                        this.mW.g.f(bVar.getTimestamp());
                    }
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                    com.baidu.ar.h.b.c("DetectorManager", "mSyncDetectorGroup onSetup result = " + lVar.isSuccess());
                    this.mW.g(lVar);
                }
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                    com.baidu.ar.h.b.c("DetectorManager", "mSyncDetectorGroup onRelease result = " + lVar.isSuccess());
                    this.mW.h(lVar);
                }
            }
        };
        this.mQ = eVar;
        this.mP.a(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, lVar) == null) {
            synchronized (this) {
                if (lVar != null) {
                    if (lVar.dc() != "DetectorGroup") {
                        if (this.mR != null && this.mR.get(lVar.dc()) != null) {
                            ((e) this.mR.get(lVar.dc())).a(lVar);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, lVar) == null) {
            synchronized (this) {
                if (lVar != null) {
                    if (lVar.dc() != "DetectorGroup") {
                        if (this.mR != null && this.mR.get(lVar.dc()) != null) {
                            ((e) this.mR.get(lVar.dc())).b(lVar);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, bVar) == null) {
            synchronized (this) {
                if (bVar != null) {
                    if (bVar instanceof c) {
                        Iterator it = ((c) bVar).df().iterator();
                        while (it.hasNext()) {
                            b bVar2 = (b) it.next();
                            if (bVar2 != null && !TextUtils.isEmpty(bVar2.dc()) && this.mR != null && this.mR.get(bVar2.dc()) != null) {
                                ((e) this.mR.get(bVar2.dc())).a(bVar2);
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            synchronized (this) {
                if (jVar != null) {
                    if (!TextUtils.isEmpty(jVar.getName())) {
                        if (jVar.dj() && this.mS.contains(jVar)) {
                            if (this.mP.isEmpty()) {
                                this.g.j(true);
                            }
                            this.mS.remove(jVar);
                            this.mP.b(jVar, (e) this.mT.get(jVar.getName()));
                            e eVar = (e) this.mT.remove(jVar.getName());
                            if (eVar != null) {
                                this.mR.put(jVar.getName(), eVar);
                            }
                        } else if (!jVar.dj() && this.mP.c(jVar)) {
                            this.mP.d(jVar);
                            this.mS.add(jVar);
                            jVar.d((e) this.mR.get(jVar.getName()));
                            e eVar2 = (e) this.mR.remove(jVar.getName());
                            if (eVar2 != null) {
                                this.mT.put(jVar.getName(), eVar2);
                            }
                            if (this.mP.isEmpty()) {
                                this.g.j(false);
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized void a(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar) == null) {
            synchronized (this) {
                if (kVar == null) {
                    com.baidu.ar.h.b.b("DetectorManager", "handleRemoveDetector detector is NULLLLL!!!");
                    return;
                }
                if (this.mS != null && this.mS.contains(kVar)) {
                    kVar.release();
                    this.mS.remove(kVar);
                } else if (this.mP != null && this.mP.c(kVar)) {
                    this.mP.a(kVar);
                    if (this.mP.isEmpty()) {
                        this.g.j(false);
                    }
                }
            }
        }
    }

    public synchronized void a(k kVar, e eVar) {
        ConcurrentHashMap concurrentHashMap;
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, kVar, eVar) == null) {
            synchronized (this) {
                if (kVar == null) {
                    return;
                }
                if ((kVar instanceof j) && ((j) kVar).dj()) {
                    if (this.mP.isEmpty()) {
                        this.g.j(true);
                    }
                    if (!this.mP.c(kVar)) {
                        this.mP.a(kVar, eVar);
                        concurrentHashMap = this.mR;
                        name = kVar.getName();
                        concurrentHashMap.put(name, eVar);
                    }
                    return;
                }
                if (this.mS != null && !this.mS.contains(kVar)) {
                    kVar.a(eVar);
                    this.mS.add(kVar);
                    concurrentHashMap = this.mT;
                    name = kVar.getName();
                    concurrentHashMap.put(name, eVar);
                }
                return;
            }
        }
    }

    public synchronized void dh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.mS != null) {
                    for (k kVar : this.mS) {
                        kVar.release();
                    }
                    this.mS.clear();
                    this.mS = null;
                }
                if (this.mP != null) {
                    this.mP.release();
                    if (this.g != null) {
                        this.g.j(false);
                    }
                    this.mP = null;
                }
                if (this.mR != null) {
                    this.mR.clear();
                    this.mR = null;
                }
                if (this.mT != null) {
                    this.mT.clear();
                    this.mT = null;
                }
                this.mQ = null;
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dh();
            this.g = null;
            this.mU = null;
        }
    }
}
