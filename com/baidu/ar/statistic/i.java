package com.baidu.ar.statistic;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int wF;
    public boolean wG;
    public e wH;
    public d wp;

    public i(d dVar, int i2, e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Integer.valueOf(i2), eVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (dVar == null || eVar == null) {
            throw null;
        }
        this.wp = dVar;
        this.wH = eVar;
        this.wF = i2 <= 0 ? 10 : i2;
        this.wG = z;
    }

    private boolean l(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, aVar)) == null) {
            Object aC = aVar.aC("_db_period");
            if (aC != null && (aC instanceof Number)) {
                if (System.currentTimeMillis() - aVar.getTimestamp() < ((Number) aC).longValue()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void a(Context context, List<a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, list) == null) || list.size() == 0) {
            return;
        }
        if (list.size() == 1) {
            this.wH.a(context, list.get(0));
        } else {
            this.wH.a(context, list);
        }
    }

    public List<List<a>> gn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.wp) {
                ArrayList arrayList = new ArrayList();
                if (this.wp.isEmpty()) {
                    return arrayList;
                }
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap = new HashMap();
                int size = this.wp.size();
                ArrayList arrayList3 = new ArrayList();
                for (int i2 = 0; i2 < size; i2++) {
                    a aVar = this.wp.get(i2);
                    String gg = aVar.gg();
                    if (!hashMap.containsKey(gg)) {
                        if (l(aVar)) {
                            arrayList3.add(Integer.valueOf(i2));
                        } else {
                            hashMap.put(gg, 1);
                            arrayList2.add(aVar);
                            if (arrayList2.size() == this.wF) {
                                arrayList.add(arrayList2);
                                arrayList2 = new ArrayList();
                            }
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    arrayList.add(arrayList2);
                }
                if (!arrayList3.isEmpty()) {
                    ArrayList arrayList4 = new ArrayList(arrayList3.size());
                    for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                        arrayList4.add(this.wp.remove(((Integer) arrayList3.get(size2)).intValue()));
                    }
                    for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
                        this.wp.k((a) arrayList4.get(size3));
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public boolean go() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !this.wp.isEmpty() : invokeV.booleanValue;
    }

    public void save() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.wG) {
            synchronized (this.wp) {
                this.wp.flush();
            }
        }
    }

    public void update(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            synchronized (this.wp) {
                this.wp.S(i2);
            }
        }
    }
}
