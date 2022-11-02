package com.baidu.swan.apps.core.prefetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.an2;
import com.baidu.tieba.bp2;
import com.baidu.tieba.c03;
import com.baidu.tieba.d43;
import com.baidu.tieba.e43;
import com.baidu.tieba.e82;
import com.baidu.tieba.fe2;
import com.baidu.tieba.jx2;
import com.baidu.tieba.ok1;
import com.baidu.tieba.p73;
import com.baidu.tieba.rp2;
import com.baidu.tieba.sa2;
import com.baidu.tieba.w73;
import com.baidu.tieba.ya2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class PrefetchEvent extends SwanAppIPCData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean COMBINE_PREFETCH_ON = true;
    public static final Parcelable.Creator<PrefetchEvent> CREATOR;
    public static final String EVENT_DATA_DEBUG_PRELOAD = "masterPreload";
    public static final String EVENT_DATA_DEBUG_SCONSOLE = "devhook";
    public static final String EVENT_DATA_EXTRA_DATA = "extraData";
    public static final String EVENT_DATA_PAGE_TYPE = "pageType";
    public static final String EVENT_DATA_ROOT_PATH = "root";
    public static final String EVENT_DATA_SHOW_PERFORMANCE_PANEL = "showPerformancePanel";
    public static final String EVENT_DATA_T7_AVAILABLE = "isT7Available";
    public static final String EVENT_DATA_WEBVIEW_ID = "wvID";
    public static final String EVENT_KEY_APP_CONFIG = "appConfig";
    public static final String EVENT_KEY_APP_KEY = "appKey";
    public static final String EVENT_KEY_APP_PATH = "appPath";
    public static final String EVENT_KEY_PAGE_URL = "pageUrl";
    public static final String EVENT_KEY_SCENE = "scene";
    public static final String EVENT_KEY_SCHEMA = "schema";
    public static final String EVENT_KEY_STATE = "state";
    public static final String EVENT_KEY_VERSION = "version";
    public static final String EVENT_USER_ACTION_APIS = "userActionApis";
    public static final String KEY_CLICK_PREFETCH = "click_prefetch";
    public static final String MODULE = "prefetch";
    public static final String SCENE_FROM_APP_READY = "fromAppReady";
    public static final String STATE_CLICK = "click";
    public static final String STATE_SHOW = "show";
    public transient /* synthetic */ FieldHolder $fh;
    public String appConfig;
    public String appId;
    public String appPath;
    public boolean isT7Available;
    public String pageType;
    public String pageUrl;
    public String rootPath;
    public String sConsole;
    public String scene;
    public String schema;
    public String state;
    public String userActionApis;
    public String version;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<PrefetchEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrefetchEvent createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new PrefetchEvent(parcel, null);
            }
            return (PrefetchEvent) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PrefetchEvent[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new PrefetchEvent[i];
            }
            return (PrefetchEvent[]) invokeI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PrefetchEvent a;

        public b() {
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
            this.a = new PrefetchEvent();
        }

        public PrefetchEvent b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (PrefetchEvent) invokeV.objValue;
        }

        public b a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.a.appId = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b c(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.a.scene = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.a.schema = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.a.state = str;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends fe2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@Nullable Map<String, String> map, String str) {
            super(str, map);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Map) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public Map<String, String> t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return (Map) invokeV.objValue;
        }

        public boolean u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return TextUtils.equals(this.a, PrefetchEvent.MODULE);
            }
            return invokeV.booleanValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Map<String, String> map = this.c;
                if (map != null && map.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    Set<Map.Entry<String, String>> entrySet = this.c.entrySet();
                    int size = entrySet.size();
                    int i = 0;
                    for (Map.Entry<String, String> entry : entrySet) {
                        sb.append(entry.getKey());
                        sb.append(":");
                        sb.append(entry.getValue());
                        i++;
                        if (i < size) {
                            sb.append(",");
                        }
                    }
                    return sb.toString();
                }
                return "";
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1939028851, "Lcom/baidu/swan/apps/core/prefetch/PrefetchEvent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1939028851, "Lcom/baidu/swan/apps/core/prefetch/PrefetchEvent;");
                return;
            }
        }
        CREATOR = new a();
    }

    public PrefetchEvent() {
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

    private boolean isStateValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (!TextUtils.equals(this.state, "click") && !TextUtils.equals(this.state, "show")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void recordClickPrefetchEvent() {
        HybridUbcFlow p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, null) == null) && (p = jx2.p("startup")) != null) {
            p.F(new UbcFlowEvent(KEY_CLICK_PREFETCH));
        }
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.schema) && isStateValid()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public PrefetchEvent(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.appId = parcel.readString();
        this.schema = parcel.readString();
        this.state = parcel.readString();
        this.scene = parcel.readString();
    }

    public /* synthetic */ PrefetchEvent(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static c createMessage(@NonNull PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, prefetchEvent, pMSAppInfo)) == null) {
            if (e82.n(pMSAppInfo)) {
                str = MODULE;
            } else {
                str = "preload";
            }
            return createMessage(prefetchEvent, str);
        }
        return (c) invokeLL.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
            parcel.writeString(this.appId);
            parcel.writeString(this.schema);
            parcel.writeString(this.state);
            parcel.writeString(this.scene);
        }
    }

    public static c createFromAppReadyEvent(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map)) == null) {
            if (map == null) {
                return null;
            }
            bp2.a W = d43.K().q().W();
            if (!e82.a(W.f0())) {
                return null;
            }
            recordClickPrefetchEvent();
            HashMap hashMap = new HashMap(map);
            hashMap.put("appKey", W.H());
            hashMap.put("schema", W.W());
            hashMap.put("state", "click");
            hashMap.put("scene", SCENE_FROM_APP_READY);
            hashMap.put("version", W.v1());
            hashMap.remove(EVENT_DATA_WEBVIEW_ID);
            hashMap.remove(EVENT_DATA_EXTRA_DATA);
            hashMap.remove(EVENT_DATA_SHOW_PERFORMANCE_PANEL);
            hashMap.remove(EVENT_DATA_DEBUG_PRELOAD);
            return new c(hashMap, MODULE);
        }
        return (c) invokeL.objValue;
    }

    public static c createFromReLaunch(String str) {
        InterceptResult invokeL;
        e43 b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!TextUtils.equals(str, "relaunch") || (b0 = e43.b0()) == null) {
                return null;
            }
            PMSAppInfo f0 = b0.W().f0();
            if (!e82.a(f0)) {
                return null;
            }
            recordClickPrefetchEvent();
            PrefetchEvent prefetchEvent = new PrefetchEvent();
            prefetchEvent.appId = b0.getAppId();
            prefetchEvent.state = "click";
            prefetchEvent.scene = str;
            prefetchEvent.schema = b0.W().W();
            prefetchEvent.pageUrl = p73.d(rp2.U(), b0.W(), b0.Q());
            prefetchEvent.appConfig = b0.Q().n;
            prefetchEvent.appPath = an2.e.i(b0.getAppId(), b0.k0()).getPath() + File.separator;
            prefetchEvent.pageType = b0.Q().h(prefetchEvent.pageUrl);
            prefetchEvent.rootPath = sa2.c(b0, prefetchEvent.pageUrl);
            prefetchEvent.isT7Available = ya2.U().p0();
            prefetchEvent.sConsole = String.valueOf(b0.W().m0());
            prefetchEvent.version = b0.k0();
            if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                prefetchEvent.userActionApis = f0.userActionApis;
            }
            return createMessage(prefetchEvent, MODULE);
        }
        return (c) invokeL.objValue;
    }

    public static c createMessage(@NonNull PrefetchEvent prefetchEvent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, prefetchEvent, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("appKey", prefetchEvent.appId);
            hashMap.put("schema", prefetchEvent.schema);
            hashMap.put("state", prefetchEvent.state);
            hashMap.put("version", prefetchEvent.version);
            if (!TextUtils.isEmpty(prefetchEvent.scene)) {
                hashMap.put("scene", prefetchEvent.scene);
            }
            if (!TextUtils.isEmpty(prefetchEvent.appPath)) {
                hashMap.put(EVENT_KEY_APP_PATH, prefetchEvent.appPath);
            }
            if (!TextUtils.isEmpty(prefetchEvent.appConfig)) {
                hashMap.put(EVENT_KEY_APP_CONFIG, prefetchEvent.appConfig);
            }
            if (!TextUtils.isEmpty(prefetchEvent.rootPath)) {
                hashMap.put("root", prefetchEvent.rootPath);
            }
            if (!TextUtils.isEmpty(prefetchEvent.pageType)) {
                hashMap.put("pageType", prefetchEvent.pageType);
            }
            if (!TextUtils.isEmpty(prefetchEvent.sConsole)) {
                hashMap.put(EVENT_DATA_DEBUG_SCONSOLE, prefetchEvent.sConsole);
            }
            hashMap.put(EVENT_DATA_T7_AVAILABLE, String.valueOf(prefetchEvent.isT7Available));
            c03.a(hashMap, "prefetch event");
            if (!TextUtils.isEmpty(prefetchEvent.pageUrl)) {
                hashMap.put(EVENT_KEY_PAGE_URL, prefetchEvent.pageUrl);
                w73.a(prefetchEvent.pageUrl, hashMap);
            } else if (ok1.a) {
                Log.e("PrefetchEvent", "page url is empty, it's impossible !!!");
            }
            if (!TextUtils.isEmpty(prefetchEvent.userActionApis)) {
                hashMap.put(EVENT_USER_ACTION_APIS, prefetchEvent.userActionApis);
            }
            return new c(hashMap, str);
        }
        return (c) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "PrefetchEvent{appId='" + this.appId + "', pageUrl='" + this.pageUrl + "', schema='" + this.schema + "', state='" + this.state + "', appPath='" + this.appPath + "', scene='" + this.scene + "'}";
        }
        return (String) invokeV.objValue;
    }
}
