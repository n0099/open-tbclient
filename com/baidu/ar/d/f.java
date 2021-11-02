package com.baidu.ar.d;

import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class f implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<k> O;
    public List<k> mK;
    public d mL;
    public e mv;

    public f(Looper looper) {
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
        this.O = new CopyOnWriteArrayList();
        this.mK = new CopyOnWriteArrayList();
        this.mL = new d(looper);
    }

    private void a(k kVar, e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, this, kVar, eVar, z) == null) {
            com.baidu.ar.h.b.c("DetectorGroup", "setupDetctor detector.getName() = " + kVar.getName());
            e eVar2 = new e(this, eVar, z) { // from class: com.baidu.ar.d.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f mM;
                public final /* synthetic */ e mN;
                public final /* synthetic */ boolean mO;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, eVar, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mM = this;
                    this.mN = eVar;
                    this.mO = z;
                }

                @Override // com.baidu.ar.d.e
                public void a(b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                        if (bVar == null) {
                            com.baidu.ar.h.b.b("DetectorGroup", "onDetected detectResult is NULLLLLL!!!");
                            return;
                        }
                        if (this.mM.mK != null && this.mM.mK.size() > 0) {
                            k kVar2 = null;
                            for (k kVar3 : this.mM.mK) {
                                if (this.mM.a(bVar, kVar3) && this.mM.i(bVar)) {
                                    kVar2 = kVar3;
                                }
                            }
                            if (kVar2 != null && this.mM.O != null) {
                                this.mM.O.add(kVar2);
                                this.mM.mK.remove(kVar2);
                                com.baidu.ar.h.b.c("DetectorGroup", "onDetected detector2Add = " + kVar2.getName());
                            }
                        }
                        if (this.mM.mL != null) {
                            this.mM.mL.d(bVar);
                        }
                    }
                }

                @Override // com.baidu.ar.d.e
                public void a(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                        com.baidu.ar.h.b.c("DetectorGroup", "setupDetctor result = " + lVar.dc() + " * " + lVar.isSuccess());
                        if (this.mM.mK != null && this.mM.mK.size() > 0 && !lVar.isSuccess()) {
                            k kVar2 = null;
                            for (k kVar3 : this.mM.mK) {
                                if (lVar.dc() != null && lVar.dc().equals(kVar3.getName())) {
                                    kVar2 = kVar3;
                                }
                            }
                            if (kVar2 != null) {
                                this.mM.mK.remove(kVar2);
                                com.baidu.ar.h.b.c("DetectorGroup", "onSetup detector2Remove = " + kVar2.getName());
                            }
                        }
                        if (this.mM.mL != null) {
                            this.mM.mL.c(lVar);
                        }
                        e eVar3 = this.mN;
                        if (eVar3 == null || !this.mO) {
                            return;
                        }
                        eVar3.a(lVar);
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                        if (this.mM.mL != null) {
                            this.mM.mL.d(lVar);
                        }
                        e eVar3 = this.mN;
                        if (eVar3 != null) {
                            eVar3.b(lVar);
                        }
                    }
                }
            };
            if (!z) {
                kVar.a(eVar2);
            } else if (kVar instanceof j) {
                ((j) kVar).d(eVar2);
                eVar2.a(new l(kVar.getName(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar, k kVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, bVar, kVar)) == null) ? bVar.dc() != null && bVar.dc().equals(kVar.getName()) : invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, bVar)) == null) {
            d dVar = this.mL;
            return dVar != null && dVar.e(bVar);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.ar.d.k
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.mv = eVar;
            this.mL.a(this.O, new e(this) { // from class: com.baidu.ar.d.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f mM;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mM = this;
                }

                @Override // com.baidu.ar.d.e
                public void a(b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) || this.mM.mv == null) {
                        return;
                    }
                    this.mM.mv.a(bVar);
                }

                @Override // com.baidu.ar.d.e
                public void a(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) || this.mM.mv == null) {
                        return;
                    }
                    this.mM.mv.a(lVar);
                }

                @Override // com.baidu.ar.d.e
                public void b(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) || this.mM.mv == null) {
                        return;
                    }
                    this.mM.mv.b(lVar);
                }
            });
        }
    }

    public void a(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar) == null) {
            List<k> list = this.mK;
            if (list == null || !list.contains(kVar)) {
                List<k> list2 = this.O;
                if (list2 == null || !list2.contains(kVar)) {
                    return;
                }
                this.O.remove(kVar);
            } else {
                this.mK.remove(kVar);
                com.baidu.ar.h.b.c("DetectorGroup", "removeDetector detector = " + kVar.getName());
            }
            kVar.release();
        }
    }

    public void a(k kVar, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, kVar, eVar) == null) || kVar == null) {
            return;
        }
        this.mK.add(kVar);
        com.baidu.ar.h.b.c("DetectorGroup", "addDetector detector = " + kVar.getName());
        a(kVar, eVar, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean ap() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<k> list = this.O;
            if (list != null && list.size() > 0) {
                for (k kVar : this.O) {
                    if (kVar == null || !(kVar instanceof j) || !((j) kVar).ap()) {
                        z = false;
                        break;
                    }
                    while (r0.hasNext()) {
                    }
                }
            }
            z = true;
            j.v(z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public void b(k kVar, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, kVar, eVar) == null) || kVar == null) {
            return;
        }
        this.mK.add(kVar);
        a(kVar, eVar, true);
    }

    public boolean c(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, kVar)) == null) {
            if (kVar == null) {
                return false;
            }
            List<k> list = this.O;
            if (list == null || !list.contains(kVar)) {
                List<k> list2 = this.mK;
                return list2 != null && list2.contains(kVar);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d(k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, kVar) == null) || kVar == null) {
            return;
        }
        List<k> list = this.mK;
        if (list != null) {
            list.remove(kVar);
        }
        List<k> list2 = this.O;
        if (list2 != null) {
            list2.remove(kVar);
        }
        d dVar = this.mL;
        if (dVar != null) {
            dVar.d(new l(kVar.getName(), true));
        }
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "DetectorGroup" : (String) invokeV.objValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        List<k> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<k> list2 = this.O;
            return (list2 == null || list2.size() <= 0) && ((list = this.mK) == null || list.size() <= 0);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ar.d.k
    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                if (this.O != null) {
                    for (k kVar : this.O) {
                        kVar.release();
                    }
                    this.O.clear();
                    this.O = null;
                }
                if (this.mL != null) {
                    this.mL.release();
                }
            }
        }
    }
}
