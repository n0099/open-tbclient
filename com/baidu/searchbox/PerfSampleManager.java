package com.baidu.searchbox;

import android.text.TextUtils;
import c.a.g0.a.a;
import c.a.g0.a.b.d;
import c.a.p.b.b;
import c.a.p0.d3.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ubc.ANRPerfSampleCallback;
import com.baidu.searchbox.ruka.ubc.LooperPerfSampleCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PerfSampleManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject(force = false)
    public d<IPerfSampleCallback> mCallbackList;

    /* loaded from: classes5.dex */
    public interface IPerfSampleCallback {
        String getSampleFlag();
    }

    /* loaded from: classes5.dex */
    public class IPerfSampleCallback_PerfSampleManager_ListProvider implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public IPerfSampleCallback_PerfSampleManager_ListProvider() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.g0.a.a
        public Object get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new b());
                arrayList.add(new ANRPerfSampleCallback());
                arrayList.add(new LooperPerfSampleCallback());
                arrayList.add(new p());
                return arrayList;
            }
            return invokeV.objValue;
        }
    }

    public PerfSampleManager() {
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
        initmCallbackList();
    }

    public String getSampleFlag() {
        InterceptResult invokeV;
        List<IPerfSampleCallback> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d<IPerfSampleCallback> dVar = this.mCallbackList;
            String str = 0;
            if (dVar != null && (list = dVar.getList()) != null && list.size() != 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String sampleFlag = list.get(i2).getSampleFlag();
                    if (!TextUtils.isEmpty(sampleFlag)) {
                        if (TextUtils.isEmpty(str)) {
                            str = sampleFlag;
                        } else if (!str.contains(sampleFlag)) {
                            str = str + "," + sampleFlag;
                        }
                    }
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public void initmCallbackList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.g0.a.b.b b2 = c.a.g0.a.b.b.b();
            this.mCallbackList = b2;
            b2.a(new IPerfSampleCallback_PerfSampleManager_ListProvider());
        }
    }
}
