package com.baidu.ar.steploading;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.ICancellable;
import com.baidu.ar.callback.IError;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements com.baidu.ar.lua.c, IStepLoading {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public ARCaseBundleInfo xA;
    public a xB;
    public ICallbackWith<IStepLoading> xC;
    public String xD;
    public boolean xE;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
    }

    private ICancellable a(String str, ICallback iCallback, IError iError, IProgressCallback iProgressCallback) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, this, str, iCallback, iError, iProgressCallback)) == null) ? com.baidu.ar.e.d.b(new e(this.mContext, this.xA, this.xB), str).d(new c(this.xA, str, this.xB, iProgressCallback)).d(new b(iCallback, iError)) : (ICancellable) invokeLLLL.objValue;
    }

    public static void d(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, str, i2) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, str);
            hashMap.put(Constants.KEYS.RET, Integer.valueOf(i2));
            ARPMessage.getInstance().sendMessage(5003, hashMap);
        }
    }

    public static void e(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, str, i2) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, str);
            hashMap.put("progress", Integer.valueOf(i2));
            ARPMessage.getInstance().sendMessage(5002, hashMap);
        }
    }

    private void r(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, hashMap) == null) {
            String str = (String) hashMap.get("res_path");
            String str2 = (String) hashMap.get(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
            boolean z = ((Integer) hashMap.get("need_progress")).intValue() != 0;
            this.xD = str;
            a(str, new ICallback(this, z, str2) { // from class: com.baidu.ar.steploading.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean xF;
                public final /* synthetic */ String xG;
                public final /* synthetic */ d xH;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.xH = this;
                    this.xF = z;
                    this.xG = str2;
                }

                @Override // com.baidu.ar.callback.ICallback
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.xF) {
                            d.e(this.xG, 100);
                        }
                        d.d(this.xG, 0);
                    }
                }
            }, new IError(this, str2) { // from class: com.baidu.ar.steploading.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String xG;
                public final /* synthetic */ d xH;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.xH = this;
                    this.xG = str2;
                }

                @Override // com.baidu.ar.callback.IError
                public void onError(int i2, String str3, Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str3, exc) == null) {
                        d.d(this.xG, -1);
                    }
                }
            }, new IProgressCallback(this, z, str2) { // from class: com.baidu.ar.steploading.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean xF;
                public final /* synthetic */ String xG;
                public final /* synthetic */ d xH;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.xH = this;
                    this.xF = z;
                    this.xG = str2;
                }

                @Override // com.baidu.ar.ihttp.IProgressCallback
                public void onProgress(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) && this.xF && i3 > 0) {
                        d.e(this.xG, (int) (((i2 * 90) * 1.0f) / i3));
                    }
                }
            });
        }
    }

    @Override // com.baidu.ar.lua.c
    public void a(int i2, int i3, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, hashMap) == null) {
            if (i2 == 5001) {
                if (hashMap != null) {
                    this.xE = false;
                    r(hashMap);
                }
            } else if (i2 == 1901 && com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1) == 3010) {
                this.xE = true;
                ICallbackWith<IStepLoading> iCallbackWith = this.xC;
                if (iCallbackWith != null) {
                    iCallbackWith.run(this);
                } else {
                    cancel();
                }
            }
        }
    }

    public void b(com.baidu.ar.lua.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            bVar.c(this);
        }
    }

    @Override // com.baidu.ar.steploading.IStepLoading
    public void cancel() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) && this.xE && !TextUtils.isEmpty(this.xD)) {
            this.xE = false;
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("id", Integer.valueOf((int) SpeedStatsStampTable.CHECK_REAL_NAME_END_STAMP_KEY));
            hashMap.put("if_download", 0);
            hashMap.put("download_batchid", this.xD);
            ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        }
    }

    @Override // com.baidu.ar.lua.c
    public List<Integer> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5001);
            arrayList.add(Integer.valueOf((int) ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.xE = false;
            this.xD = null;
            this.xC = null;
            this.mContext = null;
            this.xA = null;
            this.xB = null;
        }
    }

    @Override // com.baidu.ar.steploading.IStepLoading
    public void retry() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.xE && !TextUtils.isEmpty(this.xD)) {
            this.xE = false;
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("id", Integer.valueOf((int) SpeedStatsStampTable.CHECK_REAL_NAME_END_STAMP_KEY));
            hashMap.put("if_download", 1);
            hashMap.put("download_batchid", this.xD);
            ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        }
    }

    @Override // com.baidu.ar.steploading.IStepLoading
    public void setLoadErrorListener(ICallbackWith<IStepLoading> iCallbackWith) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iCallbackWith) == null) {
            this.xC = iCallbackWith;
        }
    }

    public void switchCase(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            ARCaseBundleInfo aRCaseBundleInfo = new ARCaseBundleInfo();
            this.xA = aRCaseBundleInfo;
            aRCaseBundleInfo.caseDir = str;
            aRCaseBundleInfo.arKey = ARConfig.getARKey();
            this.xB = new a(this.xA.caseDir);
        }
    }
}
