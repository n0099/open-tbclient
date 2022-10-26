package com.baidu.searchbox;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.anr.ubc.ANRPerfSampleCallback;
import com.baidu.searchbox.block.ubc.BlockPerfSampleCallback;
import com.baidu.searchbox.fluency.ubc.FpsPerfSampleCallback;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionPerfSampleCallback;
import com.baidu.searchbox.ruka.ubc.LooperPerfSampleCallback;
import com.baidu.tieba.cj8;
import com.baidu.tieba.qe1;
import com.baidu.tieba.se1;
import com.baidu.tieba.ue1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PerfSampleManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ue1 mCallbackList;

    /* loaded from: classes2.dex */
    public interface IPerfSampleCallback {
        String getSampleFlag();
    }

    /* loaded from: classes2.dex */
    public class IPerfSampleCallback_PerfSampleManager_ListProvider implements qe1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public IPerfSampleCallback_PerfSampleManager_ListProvider() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.qe1
        public Object get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new ANRPerfSampleCallback());
                arrayList.add(new BlockPerfSampleCallback());
                arrayList.add(new FpsPerfSampleCallback());
                arrayList.add(new ExceptionPerfSampleCallback());
                arrayList.add(new LooperPerfSampleCallback());
                arrayList.add(new cj8());
                return arrayList;
            }
            return invokeV.objValue;
        }
    }

    public void initmCallbackList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            se1 b = se1.b();
            this.mCallbackList = b;
            b.a(new IPerfSampleCallback_PerfSampleManager_ListProvider());
        }
    }

    public PerfSampleManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        initmCallbackList();
    }

    public String getSampleFlag() {
        InterceptResult invokeV;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ue1 ue1Var = this.mCallbackList;
            String str = 0;
            if (ue1Var != null && (list = ue1Var.getList()) != null && list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    String sampleFlag = ((IPerfSampleCallback) list.get(i)).getSampleFlag();
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
}
