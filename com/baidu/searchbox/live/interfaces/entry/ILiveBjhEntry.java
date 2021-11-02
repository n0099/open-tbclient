package com.baidu.searchbox.live.interfaces.entry;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&¢\u0006\u0004\b\r\u0010\u000bJ+\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/entry/ILiveBjhEntry;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "key", "", "", "params", "", "dispatchHostEvent", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V", "path", "dispatchLiveMasterRouter", "Landroid/app/Application;", "Landroid/net/Uri;", "uri", "startLiveMasterActivity", "(Landroid/app/Application;Ljava/lang/String;Landroid/net/Uri;)V", "Companion", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public interface ILiveBjhEntry {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String HOST_IM_LOGIN_NOTICE = "host_im_login_notice";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/entry/ILiveBjhEntry$Companion;", "", "HOST_IM_LOGIN_NOTICE", "Ljava/lang/String;", "<init>", "()V", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE;
        public static /* synthetic */ Interceptable $ic = null;
        public static final String HOST_IM_LOGIN_NOTICE = "host_im_login_notice";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1362280917, "Lcom/baidu/searchbox/live/interfaces/entry/ILiveBjhEntry$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1362280917, "Lcom/baidu/searchbox/live/interfaces/entry/ILiveBjhEntry$Companion;");
                    return;
                }
            }
            $$INSTANCE = new Companion();
        }

        public Companion() {
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
    }

    void dispatchHostEvent(Context context, String str, Map<String, ? extends Object> map);

    void dispatchLiveMasterRouter(Context context, String str, Map<String, ? extends Object> map);

    void startLiveMasterActivity(Application application, String str, Uri uri);
}
