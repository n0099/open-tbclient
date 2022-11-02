package com.baidu.searchbox.live.chainlog;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class NpsLoadChainLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERR_CODE_UNUSED = Integer.MIN_VALUE;
    public static final String FROM = "yysdk";
    public static final String PAGE = "liveroom";
    public static final int RESULT_FAIL = 0;
    public static final int RESULT_SUCCESS = 1;
    public static final int RESULT_UNUSED = -1;
    public static final String TYPE = "toload";
    public static final String UBC_ID_4347 = "4347";
    public static NpsLoadChainLog sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public AppInfoService appService;
    public String entry;
    public String hostName;
    public String hostVersion;
    public HandlerThread mHandlerThread;
    public Handler mSubHandler;
    public JSONObject pathJsonObj;
    public String pathTemp;
    public String pluginVersion;
    public String sessionId;
    public UBCManager ubcManager;

    /* loaded from: classes2.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final NpsLoadChainLog INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(509609826, "Lcom/baidu/searchbox/live/chainlog/NpsLoadChainLog$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(509609826, "Lcom/baidu/searchbox/live/chainlog/NpsLoadChainLog$Holder;");
                    return;
                }
            }
            INSTANCE = new NpsLoadChainLog();
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public NpsLoadChainLog() {
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
        this.ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.sessionId = "";
        this.pluginVersion = "";
        this.hostName = "";
        this.hostVersion = "";
        this.entry = "";
        HandlerThread handlerThread = new HandlerThread("nps_load_chain");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mSubHandler = new Handler(this.mHandlerThread.getLooper());
    }

    public void dLog(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && isDebug()) {
            Log.e("David990099", str);
        }
    }

    public void endInstallEntrance(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            postTask(new Runnable(this, z) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;
                public final /* synthetic */ boolean val$isSucc;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$isSucc = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("entranceEndInstall") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "entranceEndInstall";
                        try {
                            JSONObject jSONObject = this.this$0.pathJsonObj;
                            NpsLoadChainLog npsLoadChainLog2 = this.this$0;
                            if (this.val$isSucc) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            jSONObject.put("entranceEndInstall", npsLoadChainLog2.genNodeJsonObj(i, Integer.MIN_VALUE));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                        if (!this.val$isSucc) {
                            this.this$0.reset();
                        }
                    }
                }
            });
        }
    }

    public void setEntry(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            postTask(new Runnable(this, str) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;
                public final /* synthetic */ String val$entryValue;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$entryValue = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("entry") && this.this$0.pathJsonObj != null) {
                        this.this$0.entry = this.val$entryValue;
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "entry";
                        try {
                            this.this$0.pathJsonObj.put("entry", this.this$0.genNodeJsonObj(-1, Integer.MIN_VALUE));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                    }
                }
            });
        }
    }

    public void setPluginVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            postTask(new Runnable(this, str) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;
                public final /* synthetic */ String val$pluginVer;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$pluginVer = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.pluginVersion = this.val$pluginVer;
                    }
                }
            });
        }
    }

    public void endDownloadLiveNps(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            postTask(new Runnable(this, j, j2) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;
                public final /* synthetic */ long val$downloadSize;
                public final /* synthetic */ long val$totalSize;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$downloadSize = j;
                    this.val$totalSize = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("livenpsEndDowlonad") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "livenpsEndDowlonad";
                        try {
                            this.this$0.pathJsonObj.put("livenpsEndDowlonad", this.this$0.genNodeJsonObj(1, Integer.MIN_VALUE, this.val$downloadSize, this.val$totalSize));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                    }
                }
            });
        }
    }

    public void endInitYY(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) {
            postTask(new Runnable(this, z, str) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;
                public final /* synthetic */ String val$errorMsg;
                public final /* synthetic */ boolean val$isSucc;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$isSucc = z;
                    this.val$errorMsg = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("initEnd") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "initEnd";
                        try {
                            JSONObject jSONObject = this.this$0.pathJsonObj;
                            NpsLoadChainLog npsLoadChainLog2 = this.this$0;
                            if (this.val$isSucc) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            jSONObject.put("initEnd", npsLoadChainLog2.genNodeJsonObj(i, Integer.MIN_VALUE, this.val$errorMsg));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                        if (!this.val$isSucc) {
                            this.this$0.reset();
                        }
                    }
                }
            });
        }
    }

    public void endInstallLiveNps(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            postTask(new Runnable(this, z, i) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;
                public final /* synthetic */ int val$errCode;
                public final /* synthetic */ boolean val$isSucc;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$isSucc = z;
                    this.val$errCode = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("endInstallLiveNps") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "endInstallLiveNps";
                        try {
                            JSONObject jSONObject = this.this$0.pathJsonObj;
                            NpsLoadChainLog npsLoadChainLog2 = this.this$0;
                            if (this.val$isSucc) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            jSONObject.put("livenpsEndInstall", npsLoadChainLog2.genNodeJsonObj(i2, this.val$errCode));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                        if (!this.val$isSucc) {
                            this.this$0.reset();
                        }
                    }
                }
            });
        }
    }

    public void endLoadClazzLiveNps(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            postTask(new Runnable(this, z, i) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;
                public final /* synthetic */ int val$errCode;
                public final /* synthetic */ boolean val$isSucc;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$isSucc = z;
                    this.val$errCode = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("livenpsEndLoad") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "livenpsEndLoad";
                        try {
                            JSONObject jSONObject = this.this$0.pathJsonObj;
                            NpsLoadChainLog npsLoadChainLog2 = this.this$0;
                            if (this.val$isSucc) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            jSONObject.put("livenpsEndLoad", npsLoadChainLog2.genNodeJsonObj(i2, this.val$errCode));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                        if (!this.val$isSucc) {
                            this.this$0.reset();
                        }
                    }
                }
            });
        }
    }

    public void endMergeDexEntrance(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            postTask(new Runnable(this, z, i) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;
                public final /* synthetic */ int val$errCode;
                public final /* synthetic */ boolean val$isSucc;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$isSucc = z;
                    this.val$errCode = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("entranceEndLoad") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "entranceEndLoad";
                        try {
                            JSONObject jSONObject = this.this$0.pathJsonObj;
                            NpsLoadChainLog npsLoadChainLog2 = this.this$0;
                            if (this.val$isSucc) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            jSONObject.put("entranceEndLoad", npsLoadChainLog2.genNodeJsonObj(i2, this.val$errCode));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                        if (!this.val$isSucc) {
                            this.this$0.reset();
                        }
                    }
                }
            });
        }
    }

    public void endPreloadClazzLiveNps(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            postTask(new Runnable(this, z, i) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;
                public final /* synthetic */ int val$errCode;
                public final /* synthetic */ boolean val$isSucc;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$isSucc = z;
                    this.val$errCode = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("livenpsEndPreLoad") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "livenpsEndPreLoad";
                        try {
                            JSONObject jSONObject = this.this$0.pathJsonObj;
                            NpsLoadChainLog npsLoadChainLog2 = this.this$0;
                            if (this.val$isSucc) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            jSONObject.put("livenpsEndPreLoad", npsLoadChainLog2.genNodeJsonObj(i2, this.val$errCode));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                        if (!this.val$isSucc) {
                            this.this$0.reset();
                        }
                    }
                }
            });
        }
    }

    public void yyCompletionEvent(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, jSONObject) == null) {
            postTask(new Runnable(this, str, jSONObject) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;
                public final /* synthetic */ JSONObject val$pathObj;
                public final /* synthetic */ String val$tag;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$tag = str;
                    this.val$pathObj = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode(this.val$tag) && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + this.val$tag;
                        try {
                            this.this$0.pathJsonObj.put(this.val$tag, this.val$pathObj);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject genNodeJsonObj(int i, int i2, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65558, this, i, i2, str)) == null) {
            JSONObject genNodeJsonObj = genNodeJsonObj(i, i2);
            try {
                genNodeJsonObj.put("errorMsg", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return genNodeJsonObj;
        }
        return (JSONObject) invokeIIL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject genNodeJsonObj(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65556, this, i, i2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", System.currentTimeMillis());
                if (-1 != i) {
                    jSONObject.put("status", i);
                }
                if (1 != i && Integer.MIN_VALUE != i2) {
                    jSONObject.put("errorCode", i2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeII.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject genNodeJsonObj(int i, int i2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            JSONObject genNodeJsonObj = genNodeJsonObj(i, i2);
            try {
                genNodeJsonObj.put("downloadSize", j);
                genNodeJsonObj.put("totalSize", j2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return genNodeJsonObj;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject genNodeJsonObjWithTime(int i, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", j);
                if (-1 != i) {
                    jSONObject.put("status", i);
                }
                if (1 != i && Integer.MIN_VALUE != i2) {
                    jSONObject.put("errorCode", i2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject genNodeJsonObjWithTime(int i, int i2, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(j)})) == null) {
            JSONObject genNodeJsonObjWithTime = genNodeJsonObjWithTime(i, i2, j);
            try {
                genNodeJsonObjWithTime.put("errorMsg", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return genNodeJsonObjWithTime;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public void yyMinilibUbc(String str, long j, @Nullable Boolean bool, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{str, Long.valueOf(j), bool, str2}) == null) {
            if (bool == null) {
                postTask(new Runnable(this, str, j) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NpsLoadChainLog this$0;
                    public final /* synthetic */ String val$tag;
                    public final /* synthetic */ long val$time;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, Long.valueOf(j)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$tag = str;
                        this.val$time = j;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode(this.val$tag) && this.this$0.pathJsonObj != null) {
                            NpsLoadChainLog npsLoadChainLog = this.this$0;
                            npsLoadChainLog.pathTemp = this.this$0.pathTemp + this.val$tag;
                            try {
                                this.this$0.pathJsonObj.put(this.val$tag, this.this$0.genNodeJsonObjWithTime(-1, Integer.MIN_VALUE, this.val$time));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            this.this$0.showPathAndDuration();
                            this.this$0.ubcLog();
                        }
                    }
                });
            } else {
                postTask(new Runnable(this, str, bool, str2, j) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NpsLoadChainLog this$0;
                    public final /* synthetic */ String val$errorMsg;
                    public final /* synthetic */ Boolean val$isSucc;
                    public final /* synthetic */ String val$tag;
                    public final /* synthetic */ long val$time;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, bool, str2, Long.valueOf(j)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$tag = str;
                        this.val$isSucc = bool;
                        this.val$errorMsg = str2;
                        this.val$time = j;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        int i;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode(this.val$tag) && this.this$0.pathJsonObj != null) {
                            NpsLoadChainLog npsLoadChainLog = this.this$0;
                            npsLoadChainLog.pathTemp = this.this$0.pathTemp + this.val$tag;
                            try {
                                JSONObject jSONObject = this.this$0.pathJsonObj;
                                String str3 = this.val$tag;
                                NpsLoadChainLog npsLoadChainLog2 = this.this$0;
                                if (this.val$isSucc.booleanValue()) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                jSONObject.put(str3, npsLoadChainLog2.genNodeJsonObjWithTime(i, Integer.MIN_VALUE, this.val$errorMsg, this.val$time));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            this.this$0.showPathAndDuration();
                            this.this$0.ubcLog();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void genSessionId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.sessionId = this.appService.getCuid() + "-" + System.currentTimeMillis();
        }
    }

    public static NpsLoadChainLog getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            if (sInstance == null) {
                sInstance = Holder.INSTANCE;
            }
            return sInstance;
        }
        return (NpsLoadChainLog) invokeV.objValue;
    }

    private boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            AppInfoService appInfoService = this.appService;
            if (appInfoService != null) {
                return appInfoService.isDebug();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.entry;
        }
        return (String) invokeV.objValue;
    }

    public HandlerThread getHandlerThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mHandlerThread;
        }
        return (HandlerThread) invokeV.objValue;
    }

    public String getHostName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.hostName;
        }
        return (String) invokeV.objValue;
    }

    public String getHostVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.hostVersion;
        }
        return (String) invokeV.objValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            try {
                if (this.pathJsonObj == null) {
                    return "";
                }
                return this.pathJsonObj.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String getPluginVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.pluginVersion;
        }
        return (String) invokeV.objValue;
    }

    public String getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.sessionId;
        }
        return (String) invokeV.objValue;
    }

    public void initAndStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            postTask(new Runnable(this) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.reset();
                        this.this$0.genSessionId();
                        this.this$0.pathJsonObj = new JSONObject();
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.hostName = npsLoadChainLog.appService.getLiveAppId();
                        NpsLoadChainLog npsLoadChainLog2 = this.this$0;
                        npsLoadChainLog2.hostVersion = npsLoadChainLog2.appService.getVersionName();
                    }
                }
            });
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            postTask(new Runnable(this) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.this$0.sessionId = "";
                    this.this$0.pluginVersion = "";
                    this.this$0.entry = "";
                    this.this$0.hostName = "";
                    this.this$0.hostVersion = "";
                    this.this$0.pathJsonObj = null;
                    this.this$0.pathTemp = "";
                }
            });
        }
    }

    public void startDownloadLiveNps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            postTask(new Runnable(this) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("livenpsStartDownload") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "livenpsStartDownload";
                        try {
                            this.this$0.pathJsonObj.put("livenpsStartDownload", this.this$0.genNodeJsonObj(-1, Integer.MIN_VALUE));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                    }
                }
            });
        }
    }

    public void startInitYY() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            postTask(new Runnable(this) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("initStart") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "initStart";
                        try {
                            this.this$0.pathJsonObj.put("initStart", this.this$0.genNodeJsonObj(-1, Integer.MIN_VALUE));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                    }
                }
            });
        }
    }

    public void startInstallEntrance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            postTask(new Runnable(this) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("entranceStartInstall") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "entranceStartInstall";
                        try {
                            this.this$0.pathJsonObj.put("entranceStartInstall", this.this$0.genNodeJsonObj(-1, Integer.MIN_VALUE));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                    }
                }
            });
        }
    }

    public void startInstallLiveNps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            postTask(new Runnable(this) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("livenpsStartInstall") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "livenpsStartInstall";
                        try {
                            this.this$0.pathJsonObj.put("livenpsStartInstall", this.this$0.genNodeJsonObj(-1, Integer.MIN_VALUE));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                    }
                }
            });
        }
    }

    public void startLoadClazzLiveNps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            postTask(new Runnable(this) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("livenpsStartLoad") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "livenpsStartLoad";
                        try {
                            this.this$0.pathJsonObj.put("livenpsStartLoad", this.this$0.genNodeJsonObj(-1, Integer.MIN_VALUE));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                    }
                }
            });
        }
    }

    public void startLoadClazzLiveNpsPreload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            postTask(new Runnable(this) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("livenpsStartPreLoad") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "livenpsStartPreLoad";
                        try {
                            this.this$0.pathJsonObj.put("livenpsStartPreLoad", this.this$0.genNodeJsonObj(-1, Integer.MIN_VALUE));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                    }
                }
            });
        }
    }

    public void startMergeDexEntrance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            postTask(new Runnable(this) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("entranceStartLoad") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "entranceStartLoad";
                        try {
                            this.this$0.pathJsonObj.put("entranceStartLoad", this.this$0.genNodeJsonObj(-1, Integer.MIN_VALUE));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                    }
                }
            });
        }
    }

    public void startPreloadClazzLiveNps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            postTask(new Runnable(this) { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NpsLoadChainLog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.notLogPathNode("livenpsStartPreLoad") && this.this$0.pathJsonObj != null) {
                        NpsLoadChainLog npsLoadChainLog = this.this$0;
                        npsLoadChainLog.pathTemp = this.this$0.pathTemp + "livenpsStartPreLoad";
                        try {
                            this.this$0.pathJsonObj.put("livenpsStartPreLoad", this.this$0.genNodeJsonObj(-1, Integer.MIN_VALUE));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.this$0.showPathAndDuration();
                        this.this$0.ubcLog();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notLogPathNode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, this, str)) == null) {
            String str2 = this.pathTemp;
            if (str2 == null) {
                return false;
            }
            if (str2.contains(str)) {
                dLog(str + " 节点已经打过了");
            }
            return this.pathTemp.contains(str);
        }
        return invokeL.booleanValue;
    }

    private void postTask(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65565, this, runnable) != null) || runnable == null) {
            return;
        }
        if (Looper.myLooper() == this.mSubHandler.getLooper()) {
            dLog("********************主线程********************");
            runnable.run();
        } else if (this.mSubHandler != null) {
            dLog("@@@@@@@@@@@@@@@@@@@@子线程@@@@@@@@@@@@@@@@@@@@");
            this.mSubHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ubcLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            JSONObject jSONObject = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject.put("from", FROM);
                jSONObject.put("type", TYPE);
                jSONObject.put("page", PAGE);
                jSONObject.put("source", this.hostName);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("path", getPath());
                jSONObject2.put("entry", this.entry);
                jSONObject2.put("yysdk_ver", "");
                jSONObject2.put("plugin_ver", this.pluginVersion);
                jSONObject2.put("is_end", 0);
                jSONObject2.put("session_id", this.sessionId);
                jSONObject2.put("hdid", "");
                jSONObject2.put("app_ver", this.hostVersion);
                jSONObject2.put("sid", "");
                jSONObject2.put("tpl_id", "");
                jSONObject2.put("is_Mix", 0);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            dLog(jSONObject.toString());
            dLog("-----------------------\n");
            this.ubcManager.onEvent(UBC_ID_4347, jSONObject.toString());
            dLog("---report cost time = " + (System.currentTimeMillis() - currentTimeMillis) + "---\n");
        }
    }

    public void showPathAndDuration() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && isDebug() && this.pathJsonObj != null) {
            Log.e("David990099", "path = " + getPath());
        }
    }
}
