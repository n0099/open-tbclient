package com.baidu.ar.libloader;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, List<ILibLoader.c>> sS;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sS = new HashMap();
    }

    private void g(List<ILibLoader.c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, list) == null) || list == null) {
            return;
        }
        int size = list.size();
        ILibLoader.c[] cVarArr = new ILibLoader.c[size];
        list.toArray(cVarArr);
        for (int i2 = 0; i2 < size; i2++) {
            cVarArr[i2].onReady();
        }
    }

    public void a(String str, ILibLoader.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            List<ILibLoader.c> list = this.sS.get(str);
            if (list != null) {
                list.add(cVar);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            this.sS.put(str, arrayList);
        }
    }

    public void clearAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.sS.clear();
        }
    }

    public void fi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (Map.Entry<String, List<ILibLoader.c>> entry : this.sS.entrySet()) {
                g(entry.getValue());
            }
        }
    }
}
