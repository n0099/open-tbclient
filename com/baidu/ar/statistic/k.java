package com.baidu.ar.statistic;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d wI;
    public ArrayList wJ;
    public int wK;
    public int wL;
    public boolean wM;
    public List wN;
    public a wO;

    /* loaded from: classes.dex */
    public interface a {
        void R(int i);
    }

    public k(d dVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wI = dVar;
        i = i <= 0 ? 20 : i;
        this.wK = i;
        this.wL = i2 < i ? i : i2;
        this.wJ = new ArrayList(this.wK);
        this.wM = false;
        this.wN = null;
        this.wO = null;
    }

    private boolean m(com.baidu.ar.statistic.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, aVar)) == null) ? aK(aVar.gf()) : invokeL.booleanValue;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.wO = aVar;
        }
    }

    public boolean aJ(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? !this.wM || aK(str) : invokeL.booleanValue;
    }

    public boolean aK(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            List list = this.wN;
            return list != null && list.contains(str);
        }
        return invokeL.booleanValue;
    }

    public int gp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int size = this.wJ.size();
            if (size > 0) {
                synchronized (this.wI) {
                    this.wI.addAll(this.wJ);
                }
                this.wJ.clear();
                a aVar = this.wO;
                if (aVar != null) {
                    aVar.R(size);
                }
            }
            return size;
        }
        return invokeV.intValue;
    }

    public void j(List list) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.wN = list;
            this.wM = true;
            if (this.wJ.isEmpty()) {
                return;
            }
            List list2 = this.wN;
            if (list2 == null || list2.isEmpty()) {
                this.wJ.clear();
                return;
            }
            int size = this.wJ.size() - 1;
            while (true) {
                arrayList = this.wJ;
                if (size < 0) {
                    break;
                }
                if (!this.wN.contains(((com.baidu.ar.statistic.a) arrayList.get(size)).gf())) {
                    this.wN.remove(size);
                }
                size--;
            }
            if (arrayList.size() >= this.wK) {
                gp();
            }
        }
    }

    public boolean n(com.baidu.ar.statistic.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            if (!this.wM) {
                if (this.wJ.size() < this.wL) {
                    this.wJ.add(aVar);
                    return true;
                }
                return false;
            } else if (m(aVar)) {
                this.wJ.add(aVar);
                if (this.wJ.size() >= this.wK) {
                    gp();
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
