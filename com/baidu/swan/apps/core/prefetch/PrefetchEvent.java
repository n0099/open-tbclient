package com.baidu.swan.apps.core.prefetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.a1.e;
import c.a.o0.a.a2.d;
import c.a.o0.a.a2.e;
import c.a.o0.a.c2.f.p0.j;
import c.a.o0.a.f1.e.b;
import c.a.o0.a.g1.f;
import c.a.o0.a.h0.u.g;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.pms.model.PMSAppInfo;
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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes6.dex */
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
    public String version;

    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<PrefetchEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrefetchEvent createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new PrefetchEvent(parcel, null) : (PrefetchEvent) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PrefetchEvent[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new PrefetchEvent[i2] : (PrefetchEvent[]) invokeI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public PrefetchEvent f45802a;

        public b() {
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
            this.f45802a = new PrefetchEvent();
        }

        public b a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.f45802a.appId = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public PrefetchEvent b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45802a : (PrefetchEvent) invokeV.objValue;
        }

        public b c(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f45802a.scene = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f45802a.schema = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f45802a.state = str;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends c.a.o0.a.o0.d.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Map) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public Map<String, String> h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7774c : (Map) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.equals(this.f7767a, PrefetchEvent.MODULE) : invokeV.booleanValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Map<String, String> map = this.f7774c;
                if (map == null || map.size() <= 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                Set<Map.Entry<String, String>> entrySet = this.f7774c.entrySet();
                int size = entrySet.size();
                int i2 = 0;
                for (Map.Entry<String, String> entry : entrySet) {
                    sb.append(entry.getKey());
                    sb.append(":");
                    sb.append(entry.getValue());
                    i2++;
                    if (i2 < size) {
                        sb.append(",");
                    }
                }
                return sb.toString();
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

    public /* synthetic */ PrefetchEvent(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static c createFromAppReadyEvent(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map)) == null) {
            if (map == null) {
                return null;
            }
            b.a L = d.g().r().L();
            if (c.a.o0.a.h0.o.e.a.k(L.f0()) && c.a.o0.a.h0.o.e.a.a()) {
                HashMap hashMap = new HashMap(map);
                hashMap.put("appKey", L.H());
                hashMap.put("schema", L.W());
                hashMap.put("state", STATE_CLICK);
                hashMap.put("scene", SCENE_FROM_APP_READY);
                hashMap.remove(EVENT_DATA_WEBVIEW_ID);
                hashMap.remove(EVENT_DATA_EXTRA_DATA);
                hashMap.remove(EVENT_DATA_SHOW_PERFORMANCE_PANEL);
                hashMap.remove(EVENT_DATA_T7_AVAILABLE);
                hashMap.remove(EVENT_DATA_DEBUG_PRELOAD);
                return new c(hashMap, MODULE);
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    public static c createFromReLaunch(String str) {
        InterceptResult invokeL;
        e Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.equals(str, "relaunch") && (Q = e.Q()) != null && c.a.o0.a.h0.o.e.a.k(Q.L().f0()) && c.a.o0.a.h0.o.e.a.a()) {
                PrefetchEvent prefetchEvent = new PrefetchEvent();
                prefetchEvent.appId = Q.getAppId();
                prefetchEvent.state = STATE_CLICK;
                prefetchEvent.scene = str;
                prefetchEvent.schema = Q.L().W();
                prefetchEvent.pageUrl = c.a.o0.a.c2.f.p0.c.c(f.V(), Q.L(), Q.F());
                prefetchEvent.appConfig = Q.F().m;
                prefetchEvent.appPath = e.C0112e.i(Q.getAppId(), Q.Z()).getPath() + File.separator;
                prefetchEvent.pageType = Q.F().g(prefetchEvent.pageUrl);
                prefetchEvent.rootPath = c.a.o0.a.h0.u.a.c(Q, prefetchEvent.pageUrl);
                prefetchEvent.isT7Available = g.N().f0();
                prefetchEvent.sConsole = String.valueOf(Q.L().l0());
                return createMessage(prefetchEvent, MODULE);
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    public static c createMessage(@NonNull PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, prefetchEvent, pMSAppInfo)) == null) {
            return createMessage(prefetchEvent, c.a.o0.a.h0.o.e.a.k(pMSAppInfo) ? MODULE : "preload");
        }
        return (c) invokeLL.objValue;
    }

    private boolean isStateValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? TextUtils.equals(this.state, STATE_CLICK) || TextUtils.equals(this.state, "show") : invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.schema) || !isStateValid()) ? false : true : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "PrefetchEvent{appId='" + this.appId + ExtendedMessageFormat.QUOTE + ", pageUrl='" + this.pageUrl + ExtendedMessageFormat.QUOTE + ", schema='" + this.schema + ExtendedMessageFormat.QUOTE + ", state='" + this.state + ExtendedMessageFormat.QUOTE + ", appPath='" + this.appPath + ExtendedMessageFormat.QUOTE + ", scene='" + this.scene + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i2) == null) {
            parcel.writeString(this.appId);
            parcel.writeString(this.schema);
            parcel.writeString(this.state);
            parcel.writeString(this.scene);
        }
    }

    public PrefetchEvent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public PrefetchEvent(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                hashMap.put(EVENT_DATA_ROOT_PATH, prefetchEvent.rootPath);
            }
            if (!TextUtils.isEmpty(prefetchEvent.pageType)) {
                hashMap.put("pageType", prefetchEvent.pageType);
            }
            if (!TextUtils.isEmpty(prefetchEvent.sConsole)) {
                hashMap.put(EVENT_DATA_DEBUG_SCONSOLE, prefetchEvent.sConsole);
            }
            hashMap.put(EVENT_DATA_T7_AVAILABLE, String.valueOf(prefetchEvent.isT7Available));
            c.a.o0.a.t1.g.b.a(hashMap, "prefetch event");
            if (!TextUtils.isEmpty(prefetchEvent.pageUrl)) {
                hashMap.put("pageUrl", prefetchEvent.pageUrl);
                j.a(prefetchEvent.pageUrl, hashMap);
            } else {
                boolean z = k.f7049a;
            }
            return new c(hashMap, str);
        }
        return (c) invokeLL.objValue;
    }
}
