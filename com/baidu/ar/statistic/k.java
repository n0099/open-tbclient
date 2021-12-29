package com.baidu.ar.statistic;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d wI;
    public ArrayList<com.baidu.ar.statistic.a> wJ;
    public int wK;
    public int wL;
    public boolean wM;
    public List<String> wN;
    public a wO;

    /* loaded from: classes10.dex */
    public interface a {
        void R(int i2);
    }

    public k(d dVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wI = dVar;
        i2 = i2 <= 0 ? 20 : i2;
        this.wK = i2;
        this.wL = i3 < i2 ? i2 : i3;
        this.wJ = new ArrayList<>(this.wK);
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
            List<String> list = this.wN;
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

    public void j(List<String> list) {
        ArrayList<com.baidu.ar.statistic.a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.wN = list;
            this.wM = true;
            if (this.wJ.isEmpty()) {
                return;
            }
            List<String> list2 = this.wN;
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
                if (!this.wN.contains(arrayList.get(size).gf())) {
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
