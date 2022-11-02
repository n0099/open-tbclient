package com.baidu.searchbox.live.model.net;

import android.os.Handler;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.thread.MiniElasticExecutor;
import com.baidu.live.arch.utils.MiniUiThreadUtil;
import com.baidu.pass.biometrics.face.liveness.b.a;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.searchbox.live.interfaces.net.NetStatData;
import com.baidu.searchbox.live.interfaces.service.NetworkAgentService;
import com.baidu.searchbox.live.model.net.MixNetwork;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.util.BaiduActiveStatistic;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import com.baidu.webkit.sdk.WebChromeClient;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.common.util.UriUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000:\u0001<B\u0007¢\u0006\u0004\b;\u0010\u0003J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\u000bJ7\u0010\u0011\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0012JA\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0013\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0003J\u0015\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010!\u001a\u00020\u00012\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e¢\u0006\u0004\b!\u0010\"J5\u0010&\u001a\u00020\u00012&\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010#j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`$¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b(\u0010\u001fJ\u0015\u0010*\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u001c¢\u0006\u0004\b*\u0010\u001fJ\u0015\u0010,\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0006¢\u0006\u0004\b,\u0010-R\u001d\u00103\u001a\u00020.8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010+\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010:¨\u0006="}, d2 = {"Lcom/baidu/searchbox/live/model/net/MixNetwork;", "", "cancel", "()V", "", "key", "", "localPath", "Lcom/baidu/searchbox/live/model/net/MixNetDownloadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "download", "(Ljava/lang/Object;Ljava/lang/String;Lcom/baidu/searchbox/live/model/net/MixNetDownloadCallback;)V", "downloadSync", "ResponseDataT", "", "params", "Lcom/baidu/searchbox/live/model/net/MixNetCallback;", "get", "(Ljava/util/Map;Lcom/baidu/searchbox/live/model/net/MixNetCallback;)V", "post", "", "postImmediate", "(Ljava/util/Map;Lcom/baidu/searchbox/live/model/net/MixNetCallback;Z)V", "release", "Lcom/baidu/searchbox/live/interfaces/net/NetResponse;", UriUtil.LOCAL_RESOURCE_SCHEME, "sendUbcByReqFailed", "(Lcom/baidu/searchbox/live/interfaces/net/NetResponse;)V", "", "timeout", "setConnectTimeout", "(I)V", "extra", "setExtra", "(Ljava/util/Map;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "headers", "setHeaderData", "(Ljava/util/HashMap;)V", "setReadTimeout", "retryCount", "setRetryCount", "url", "setUrl", "(Ljava/lang/String;)V", "Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "getHandler", "()Landroid/os/Handler;", "handler", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "netImpl", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "Lcom/baidu/ubc/UBCManager;", UBCCloudControlProcessor.UBC_KEY, "Lcom/baidu/ubc/UBCManager;", "Ljava/lang/String;", "<init>", "Response", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixNetwork {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy handler$delegate;
    public INetWork netImpl;
    public final UBCManager ubc;
    public String url;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(796391272, "Lcom/baidu/searchbox/live/model/net/MixNetwork;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(796391272, "Lcom/baidu/searchbox/live/model/net/MixNetwork;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixNetwork.class), "handler", "getHandler()Landroid/os/Handler;"))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Lazy lazy = this.handler$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (Handler) lazy.getValue();
        }
        return (Handler) invokeV.objValue;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u0004\u0018\u00018\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/live/model/net/MixNetwork$Response;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/searchbox/live/interfaces/net/NetResponse;", "component1", "()Lcom/baidu/searchbox/live/interfaces/net/NetResponse;", "component2", "()Ljava/lang/Object;", "response", "data", "copy", "(Lcom/baidu/searchbox/live/interfaces/net/NetResponse;Ljava/lang/Object;)Lcom/baidu/searchbox/live/model/net/MixNetwork$Response;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getData", "Lcom/baidu/searchbox/live/interfaces/net/NetResponse;", "getResponse", "<init>", "(Lcom/baidu/searchbox/live/interfaces/net/NetResponse;Ljava/lang/Object;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Response<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T data;
        public final NetResponse response;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.live.model.net.MixNetwork$Response */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, NetResponse netResponse, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                netResponse = response.response;
            }
            if ((i & 2) != 0) {
                obj = response.data;
            }
            return response.copy(netResponse, obj);
        }

        public final NetResponse component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.response : (NetResponse) invokeV.objValue;
        }

        public final T component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.data : (T) invokeV.objValue;
        }

        public final Response<T> copy(NetResponse netResponse, T t) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, netResponse, t)) == null) ? new Response<>(netResponse, t) : (Response) invokeLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this != obj) {
                    if (obj instanceof Response) {
                        Response response = (Response) obj;
                        return Intrinsics.areEqual(this.response, response.response) && Intrinsics.areEqual(this.data, response.data);
                    }
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                NetResponse netResponse = this.response;
                int hashCode = (netResponse != null ? netResponse.hashCode() : 0) * 31;
                T t = this.data;
                return hashCode + (t != null ? t.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "Response(response=" + this.response + ", data=" + this.data + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        public Response(NetResponse netResponse, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netResponse, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.response = netResponse;
            this.data = t;
        }

        public final T getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.data;
            }
            return (T) invokeV.objValue;
        }

        public final NetResponse getResponse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.response;
            }
            return (NetResponse) invokeV.objValue;
        }
    }

    public MixNetwork() {
        INetWork iNetWork;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.handler$delegate = LazyKt__LazyJVMKt.lazy(MixNetwork$handler$2.INSTANCE);
        NetworkAgentService networkAgentService = (NetworkAgentService) ServiceManager.getService(NetworkAgentService.SERVICE_REFERENCE);
        if (networkAgentService != null) {
            iNetWork = networkAgentService.buildNetworkInstance();
        } else {
            iNetWork = null;
        }
        this.netImpl = iNetWork;
        this.ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    }

    public final void setConnectTimeout(int i) {
        INetWork iNetWork;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (iNetWork = this.netImpl) != null) {
            iNetWork.setConnectTimeout(i);
        }
    }

    public final void setExtra(Map<String, ? extends Object> map) {
        INetWork iNetWork;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, map) == null) && (iNetWork = this.netImpl) != null) {
            iNetWork.setExtra(map);
        }
    }

    public final void setHeaderData(HashMap<String, String> hashMap) {
        INetWork iNetWork;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, hashMap) == null) && (iNetWork = this.netImpl) != null) {
            iNetWork.setHeaderData(hashMap);
        }
    }

    public final void setReadTimeout(int i) {
        INetWork iNetWork;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (iNetWork = this.netImpl) != null) {
            iNetWork.setReadTimeout(i);
        }
    }

    public final void setRetryCount(int i) {
        INetWork iNetWork;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (iNetWork = this.netImpl) != null) {
            iNetWork.setRetryCount(i);
        }
    }

    public final void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.url = str;
            INetWork iNetWork = this.netImpl;
            if (iNetWork != null) {
                iNetWork.setUrl(str);
            }
        }
    }

    public final <ResponseDataT> void get(final Map<String, ? extends Object> map, final MixNetCallback<ResponseDataT> mixNetCallback) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, map, mixNetCallback) == null) && (str = this.url) != null && (!StringsKt__StringsJVMKt.isBlank(str)) && this.netImpl != null) {
            MiniElasticExecutor.INSTANCE.execute(new Runnable(this, map, mixNetCallback) { // from class: com.baidu.searchbox.live.model.net.MixNetwork$get$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ MixNetCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Map $params;
                public final /* synthetic */ MixNetwork this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, map, mixNetCallback};
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
                    this.$params = map;
                    this.$callback = mixNetCallback;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    INetWork iNetWork;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        NetStatData netStatData = new NetStatData();
                        netStatData.requestTimestamp = System.currentTimeMillis();
                        iNetWork = this.this$0.netImpl;
                        if (iNetWork == null) {
                            Intrinsics.throwNpe();
                        }
                        NetResponse res = iNetWork.getSync(this.$params);
                        netStatData.responseTimestamp = System.currentTimeMillis();
                        res.statData = netStatData;
                        Object obj = null;
                        try {
                            MixNetCallback mixNetCallback2 = this.$callback;
                            if (mixNetCallback2 != null) {
                                obj = mixNetCallback2.onParseResponseInBackground(res);
                            }
                        } catch (Exception unused) {
                        }
                        Intrinsics.checkExpressionValueIsNotNull(res, "res");
                        MiniUiThreadUtil.INSTANCE.runOnUiThread(new Runnable(this, new MixNetwork.Response(res, obj), res) { // from class: com.baidu.searchbox.live.model.net.MixNetwork$get$1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MixNetwork.Response $it;
                            public final /* synthetic */ NetResponse $res;
                            public final /* synthetic */ MixNetwork$get$1 this$0;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r7, res};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.$it = r7;
                                this.$res = res;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                NetResponse netResponse;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    MixNetCallback mixNetCallback3 = this.this$0.$callback;
                                    if (mixNetCallback3 != null) {
                                        MixNetwork.Response response = this.$it;
                                        Object obj2 = null;
                                        if (response != null) {
                                            netResponse = response.getResponse();
                                        } else {
                                            netResponse = null;
                                        }
                                        MixNetwork.Response response2 = this.$it;
                                        if (response2 != null) {
                                            obj2 = response2.getData();
                                        }
                                        mixNetCallback3.onNetResponse(netResponse, obj2);
                                    }
                                    MixNetwork mixNetwork = this.this$0.this$0;
                                    NetResponse res2 = this.$res;
                                    Intrinsics.checkExpressionValueIsNotNull(res2, "res");
                                    mixNetwork.sendUbcByReqFailed(res2);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public final <ResponseDataT> void post(Map<String, ? extends Object> map, MixNetCallback<ResponseDataT> mixNetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, map, mixNetCallback) == null) {
            post(map, mixNetCallback, false);
        }
    }

    public static /* synthetic */ void post$default(MixNetwork mixNetwork, Map map, MixNetCallback mixNetCallback, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        mixNetwork.post(map, mixNetCallback, z);
    }

    public final void cancel() {
        INetWork iNetWork;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (iNetWork = this.netImpl) != null) {
            iNetWork.cancel();
        }
    }

    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            cancel();
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    public final void download(final Object obj, String str, final MixNetDownloadCallback mixNetDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, str, mixNetDownloadCallback) == null) {
            String str2 = this.url;
            if (str2 != null && (!StringsKt__StringsJVMKt.isBlank(str2)) && (!StringsKt__StringsJVMKt.isBlank(str)) && this.netImpl != null) {
                MiniElasticExecutor.INSTANCE.executeBackground(new MixNetwork$download$1(this, obj, str, mixNetDownloadCallback));
            } else {
                getHandler().post(new Runnable(mixNetDownloadCallback, obj) { // from class: com.baidu.searchbox.live.model.net.MixNetwork$download$2
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ MixNetDownloadCallback $callback;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Object $key;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {mixNetDownloadCallback, obj};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$callback = mixNetDownloadCallback;
                        this.$key = obj;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MixNetDownloadCallback mixNetDownloadCallback2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (mixNetDownloadCallback2 = this.$callback) != null) {
                            mixNetDownloadCallback2.onFileDownloaded(this.$key, -1, -1, "env error");
                        }
                    }
                });
            }
        }
    }

    public final void downloadSync(final Object obj, String str, final MixNetDownloadCallback mixNetDownloadCallback) {
        INetWork iNetWork;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, str, mixNetDownloadCallback) == null) {
            String str2 = this.url;
            if (str2 != null && (!StringsKt__StringsJVMKt.isBlank(str2)) && (!StringsKt__StringsJVMKt.isBlank(str)) && (iNetWork = this.netImpl) != null) {
                if (iNetWork == null) {
                    Intrinsics.throwNpe();
                }
                iNetWork.download(obj, str, new MixNetwork$downloadSync$1(this, mixNetDownloadCallback));
                return;
            }
            String str3 = this.url;
            if (str3 != null && !(!StringsKt__StringsJVMKt.isBlank(str3))) {
                getHandler().post(new Runnable(mixNetDownloadCallback, obj) { // from class: com.baidu.searchbox.live.model.net.MixNetwork$downloadSync$2
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ MixNetDownloadCallback $callback;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Object $key;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {mixNetDownloadCallback, obj};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$callback = mixNetDownloadCallback;
                        this.$key = obj;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MixNetDownloadCallback mixNetDownloadCallback2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (mixNetDownloadCallback2 = this.$callback) != null) {
                            mixNetDownloadCallback2.onFileDownloaded(this.$key, -1, -1, "env error 1");
                        }
                    }
                });
            } else if (!(!StringsKt__StringsJVMKt.isBlank(str))) {
                getHandler().post(new Runnable(mixNetDownloadCallback, obj) { // from class: com.baidu.searchbox.live.model.net.MixNetwork$downloadSync$3
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ MixNetDownloadCallback $callback;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Object $key;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {mixNetDownloadCallback, obj};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$callback = mixNetDownloadCallback;
                        this.$key = obj;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MixNetDownloadCallback mixNetDownloadCallback2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (mixNetDownloadCallback2 = this.$callback) != null) {
                            mixNetDownloadCallback2.onFileDownloaded(this.$key, -1, -1, "env error 2");
                        }
                    }
                });
            } else if (this.netImpl == null) {
                getHandler().post(new Runnable(mixNetDownloadCallback, obj) { // from class: com.baidu.searchbox.live.model.net.MixNetwork$downloadSync$4
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ MixNetDownloadCallback $callback;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Object $key;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {mixNetDownloadCallback, obj};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$callback = mixNetDownloadCallback;
                        this.$key = obj;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MixNetDownloadCallback mixNetDownloadCallback2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (mixNetDownloadCallback2 = this.$callback) != null) {
                            mixNetDownloadCallback2.onFileDownloaded(this.$key, -1, -1, "env error 3");
                        }
                    }
                });
            } else {
                getHandler().post(new Runnable(mixNetDownloadCallback, obj) { // from class: com.baidu.searchbox.live.model.net.MixNetwork$downloadSync$5
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ MixNetDownloadCallback $callback;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Object $key;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {mixNetDownloadCallback, obj};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$callback = mixNetDownloadCallback;
                        this.$key = obj;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MixNetDownloadCallback mixNetDownloadCallback2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (mixNetDownloadCallback2 = this.$callback) != null) {
                            mixNetDownloadCallback2.onFileDownloaded(this.$key, -1, -1, "env error");
                        }
                    }
                });
            }
        }
    }

    public final <ResponseDataT> void post(final Map<String, ? extends Object> map, final MixNetCallback<ResponseDataT> mixNetCallback, final boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048581, this, map, mixNetCallback, z) == null) && (str = this.url) != null && (!StringsKt__StringsJVMKt.isBlank(str)) && this.netImpl != null) {
            MiniElasticExecutor.INSTANCE.execute(new Runnable(this, map, mixNetCallback, z) { // from class: com.baidu.searchbox.live.model.net.MixNetwork$post$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ MixNetCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Map $params;
                public final /* synthetic */ boolean $postImmediate;
                public final /* synthetic */ MixNetwork this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, map, mixNetCallback, Boolean.valueOf(z)};
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
                    this.$params = map;
                    this.$callback = mixNetCallback;
                    this.$postImmediate = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    INetWork iNetWork;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        NetStatData netStatData = new NetStatData();
                        netStatData.requestTimestamp = System.currentTimeMillis();
                        iNetWork = this.this$0.netImpl;
                        if (iNetWork == null) {
                            Intrinsics.throwNpe();
                        }
                        NetResponse res = iNetWork.postSync(this.$params);
                        netStatData.responseTimestamp = System.currentTimeMillis();
                        res.statData = netStatData;
                        Object obj = null;
                        try {
                            MixNetCallback mixNetCallback2 = this.$callback;
                            if (mixNetCallback2 != null) {
                                obj = mixNetCallback2.onParseResponseInBackground(res);
                            }
                        } catch (Exception unused) {
                        }
                        Intrinsics.checkExpressionValueIsNotNull(res, "res");
                        MiniUiThreadUtil.INSTANCE.runOnUiThread(new Runnable(this, new MixNetwork.Response(res, obj), res) { // from class: com.baidu.searchbox.live.model.net.MixNetwork$post$1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MixNetwork.Response $it;
                            public final /* synthetic */ NetResponse $res;
                            public final /* synthetic */ MixNetwork$post$1 this$0;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r7, res};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.$it = r7;
                                this.$res = res;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                NetResponse netResponse;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    MixNetCallback mixNetCallback3 = this.this$0.$callback;
                                    if (mixNetCallback3 != null) {
                                        MixNetwork.Response response = this.$it;
                                        Object obj2 = null;
                                        if (response != null) {
                                            netResponse = response.getResponse();
                                        } else {
                                            netResponse = null;
                                        }
                                        MixNetwork.Response response2 = this.$it;
                                        if (response2 != null) {
                                            obj2 = response2.getData();
                                        }
                                        mixNetCallback3.onNetResponse(netResponse, obj2);
                                    }
                                    MixNetwork mixNetwork = this.this$0.this$0;
                                    NetResponse res2 = this.$res;
                                    Intrinsics.checkExpressionValueIsNotNull(res2, "res");
                                    mixNetwork.sendUbcByReqFailed(res2);
                                }
                            }
                        }, this.$postImmediate);
                    }
                }
            });
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:11|12|(1:14)(2:46|(1:51)(1:50))|15|16|(4:18|(1:20)|21|(6:23|(1:25)|26|(1:28)|29|(8:31|32|33|34|35|(1:37)|38|39)(2:43|44)))|45|32|33|34|35|(0)|38|39) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f5, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f6, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fd A[Catch: Exception -> 0x0119, TryCatch #1 {Exception -> 0x0119, blocks: (B:5:0x0006, B:7:0x0018, B:10:0x0020, B:13:0x0031, B:20:0x0055, B:23:0x0071, B:25:0x0075, B:26:0x0078, B:28:0x0084, B:30:0x0088, B:31:0x008b, B:33:0x008f, B:34:0x0092, B:36:0x009e, B:40:0x00b8, B:41:0x00d1, B:45:0x00f9, B:47:0x00fd, B:48:0x0102, B:44:0x00f6, B:37:0x00ab, B:38:0x00b2, B:39:0x00b3, B:14:0x003e, B:16:0x0044, B:18:0x004a), top: B:58:0x0006, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void sendUbcByReqFailed(NetResponse netResponse) {
        String str;
        int i;
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, netResponse) == null) {
            try {
                String decode = netResponse.decodedResponseStr;
                Intrinsics.checkExpressionValueIsNotNull(decode, "decode");
                if (StringsKt__StringsKt.contains$default((CharSequence) decode, (CharSequence) "\"errno\":0", false, 2, (Object) null) && netResponse.isSuccessful()) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(decode);
                if (jSONObject.has("error")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("error");
                    i = optJSONObject.optInt("errno");
                    str = optJSONObject.optString("errmsg");
                } else if (!jSONObject.has("errno") || !jSONObject.has("errmsg")) {
                    str = "";
                    i = 0;
                } else {
                    i = jSONObject.optInt("errno");
                    str = jSONObject.optString("errmsg");
                }
                String optString = jSONObject.optString("logid");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("error_code", i);
                jSONObject2.put("error_messge", str);
                if (this.url != null) {
                    String str2 = this.url;
                    if (str2 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (StringsKt__StringsKt.indexOf$default((CharSequence) str2, "?", 0, false, 6, (Object) null) > 0) {
                        String str3 = this.url;
                        if (str3 == null) {
                            Intrinsics.throwNpe();
                        }
                        String str4 = this.url;
                        if (str4 == null) {
                            Intrinsics.throwNpe();
                        }
                        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str4, "?", 0, false, 6, (Object) null);
                        if (str3 != null) {
                            String substring = str3.substring(0, indexOf$default);
                            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            jSONObject2.put("url", substring);
                            jSONObject2.put("status", a.g0);
                            jSONObject2.put(TiebaStatic.Params.LOGID, optString);
                            jSONObject2.put(BaiduActiveStatistic.UBC_EXT_KEY_RESPONSE_CODE, netResponse.responseCode);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("from", "liveshow");
                            jSONObject3.put("type", "live_req");
                            jSONObject3.put("value", TiebaStatic.LogFields.RESULT);
                            jSONObject3.put("room_id", "0");
                            jSONObject3.put("ext", jSONObject2);
                            uBCManager = this.ubc;
                            if (uBCManager != null) {
                                uBCManager.onEvent("5153", jSONObject3);
                            }
                            Log.d("req", "@@ LiveNetWork ubcImpl=null jsonObj=" + jSONObject3);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                jSONObject2.put("url", this.url);
                jSONObject2.put("status", a.g0);
                jSONObject2.put(TiebaStatic.Params.LOGID, optString);
                jSONObject2.put(BaiduActiveStatistic.UBC_EXT_KEY_RESPONSE_CODE, netResponse.responseCode);
                JSONObject jSONObject32 = new JSONObject();
                jSONObject32.put("from", "liveshow");
                jSONObject32.put("type", "live_req");
                jSONObject32.put("value", TiebaStatic.LogFields.RESULT);
                jSONObject32.put("room_id", "0");
                jSONObject32.put("ext", jSONObject2);
                uBCManager = this.ubc;
                if (uBCManager != null) {
                }
                Log.d("req", "@@ LiveNetWork ubcImpl=null jsonObj=" + jSONObject32);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
