package com.baidu.searchbox.live.interfaces.mix;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 82\u00020\u0001:\u00018J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJE\u0010\u0010\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0018\u0010\u000f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\fH&¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\fH&¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\fH&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\fH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\fH&¢\u0006\u0004\b\u001f\u0010 J/\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\f2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000eH&¢\u0006\u0004\b\u001f\u0010\"J!\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b&\u0010'J=\u0010,\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010+\u001a\u00020\u001eH&¢\u0006\u0004\b,\u0010-JG\u0010,\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\b\b\u0002\u0010+\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010)H&¢\u0006\u0004\b,\u0010/J_\u0010,\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\b\b\u0002\u0010+\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u001e2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010)H&¢\u0006\u0004\b,\u00100J3\u0010,\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010+\u001a\u00020\u001eH&¢\u0006\u0004\b,\u00101J\u001f\u00103\u001a\u00020%2\u0006\u0010$\u001a\u00020#2\u0006\u00102\u001a\u00020\fH&¢\u0006\u0004\b3\u0010'J\u0019\u00106\u001a\u00020%2\b\u00105\u001a\u0004\u0018\u000104H&¢\u0006\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "Lkotlin/Any;", "", "createYYMixLiveImpl", "()Ljava/lang/Object;", "createYYMixLiveSingletonManagerImpl", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "genFakeActivityImpl", "()Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "", "getLiveNpsPluginWillLoadVersion", "()I", "", "key", "", "params", "getMediaLivePlayConfig", "(Ljava/lang/String;Ljava/util/Map;)Ljava/util/Map;", "pkgName", "Landroid/content/res/AssetManager;", "getPluginAssets", "(Ljava/lang/String;)Landroid/content/res/AssetManager;", "Ljava/lang/ClassLoader;", "getPluginClassLoader", "(Ljava/lang/String;)Ljava/lang/ClassLoader;", "Landroid/content/res/Resources;", "getPluginResource", "(Ljava/lang/String;)Landroid/content/res/Resources;", "getPluginVersionCode", "(Ljava/lang/String;)I", "", "isPluginLoaded", "(Ljava/lang/String;)Z", "loadParams", "(Ljava/lang/String;Ljava/util/Map;)Z", "Landroid/content/Context;", "context", "", "jumpToOuterWebView", "(Landroid/content/Context;Ljava/lang/String;)V", "source", "Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;", "loadCallback", "needYYLoading", "loadPlugin", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;Z)V", "showYYPage", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZLcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;Z)V", "url", "realJumpYY", "Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "stat", "updateStatInfo", "(Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;)V", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface PluginInvokeService {
    public static final Companion Companion = Companion.$$INSTANCE;

    Object createYYMixLiveImpl();

    Object createYYMixLiveSingletonManagerImpl();

    IMixActivityInterface genFakeActivityImpl();

    int getLiveNpsPluginWillLoadVersion();

    Map getMediaLivePlayConfig(String str, Map map);

    AssetManager getPluginAssets(String str);

    ClassLoader getPluginClassLoader(String str);

    Resources getPluginResource(String str);

    int getPluginVersionCode(String str);

    boolean isPluginLoaded(String str);

    boolean isPluginLoaded(String str, Map map);

    void jumpToOuterWebView(Context context, String str);

    void loadPlugin(Context context, String str, String str2, PluginLoadCallback pluginLoadCallback, boolean z);

    void loadPlugin(Context context, String str, String str2, boolean z, boolean z2, PluginLoadCallback pluginLoadCallback);

    void loadPlugin(Context context, String str, String str2, boolean z, boolean z2, Map map, PluginLoadCallback pluginLoadCallback);

    void loadPlugin(String str, String str2, PluginLoadCallback pluginLoadCallback, boolean z);

    void realJumpYY(Context context, String str);

    void updateStatInfo(YYStatInfo yYStatInfo);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE;
        public static /* synthetic */ Interceptable $ic;
        public static final ServiceReference SERVICE_REFERENCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(25633704, "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(25633704, "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService$Companion;");
                    return;
                }
            }
            $$INSTANCE = new Companion();
            SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.MINI_SHELL.PLUGIN_MANAGER);
        }

        public Companion() {
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

        public final ServiceReference getSERVICE_REFERENCE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return SERVICE_REFERENCE;
            }
            return (ServiceReference) invokeV.objValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static /* synthetic */ void loadPlugin$default(PluginInvokeService pluginInvokeService, Context context, String str, String str2, PluginLoadCallback pluginLoadCallback, boolean z, int i, Object obj) {
            boolean z2;
            if (obj == null) {
                if ((i & 16) != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                pluginInvokeService.loadPlugin(context, str, str2, pluginLoadCallback, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadPlugin");
        }

        public static /* synthetic */ void loadPlugin$default(PluginInvokeService pluginInvokeService, Context context, String str, String str2, boolean z, boolean z2, PluginLoadCallback pluginLoadCallback, int i, Object obj) {
            boolean z3;
            boolean z4;
            if (obj == null) {
                if ((i & 8) != 0) {
                    z3 = true;
                } else {
                    z3 = z;
                }
                if ((i & 16) != 0) {
                    z4 = false;
                } else {
                    z4 = z2;
                }
                pluginInvokeService.loadPlugin(context, str, str2, z3, z4, pluginLoadCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadPlugin");
        }

        public static /* synthetic */ void loadPlugin$default(PluginInvokeService pluginInvokeService, Context context, String str, String str2, boolean z, boolean z2, Map map, PluginLoadCallback pluginLoadCallback, int i, Object obj) {
            boolean z3;
            boolean z4;
            if (obj == null) {
                if ((i & 8) != 0) {
                    z3 = true;
                } else {
                    z3 = z;
                }
                if ((i & 16) != 0) {
                    z4 = false;
                } else {
                    z4 = z2;
                }
                pluginInvokeService.loadPlugin(context, str, str2, z3, z4, map, pluginLoadCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadPlugin");
        }

        public static /* synthetic */ void loadPlugin$default(PluginInvokeService pluginInvokeService, String str, String str2, PluginLoadCallback pluginLoadCallback, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    z = true;
                }
                pluginInvokeService.loadPlugin(str, str2, pluginLoadCallback, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadPlugin");
        }
    }
}
