package com.baidu.searchbox.live.interfaces.service;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u0000 \u00142\u00020\u0001:\u0004\u0015\u0014\u0016\u0017J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$BindPhoneCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "bindPhone", "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$BindPhoneCallback;)V", "Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$OpenAccessTokenCallback;", "", "forceRefresh", "getOpenAccessToken", "(Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$OpenAccessTokenCallback;Z)V", "Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$LoginResultCallback;", "showLoginDialog", "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$LoginResultCallback;)V", "", "title", "(Landroid/content/Context;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$LoginResultCallback;)V", "Companion", "BindPhoneCallback", "LoginResultCallback", "OpenAccessTokenCallback", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public interface ThirdPartAccountService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$BindPhoneCallback;", "Lkotlin/Any;", "", "state", "", "onResult", "(I)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes11.dex */
    public interface BindPhoneCallback {
        void onResult(int i2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes11.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE;
        public static /* synthetic */ Interceptable $ic;
        public static final ServiceReference SERVICE_REFERENCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1899213431, "Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1899213431, "Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$Companion;");
                    return;
                }
            }
            $$INSTANCE = new Companion();
            SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.THIRD_PART_ACCOUNT);
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

        public final ServiceReference getSERVICE_REFERENCE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SERVICE_REFERENCE : (ServiceReference) invokeV.objValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$LoginResultCallback;", "Lkotlin/Any;", "", "clickFrom", "", "onBtnClick", "(I)V", "state", "onResult", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes11.dex */
    public interface LoginResultCallback {
        public static final int CLICK_FROM_APPLE = 6;
        public static final int CLICK_FROM_DEFAULT = 0;
        public static final int CLICK_FROM_PHONE = 5;
        public static final int CLICK_FROM_QQ = 3;
        public static final int CLICK_FROM_QUICK = 7;
        public static final int CLICK_FROM_WECHAT = 1;
        public static final int CLICK_FROM_WEIBO = 2;
        public static final int CLICK_FROM_YY = 4;
        public static final Companion Companion = Companion.$$INSTANCE;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0003¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$LoginResultCallback$Companion;", "", "CLICK_FROM_APPLE", "I", "CLICK_FROM_DEFAULT", "CLICK_FROM_PHONE", "CLICK_FROM_QQ", "CLICK_FROM_QUICK", "CLICK_FROM_WECHAT", "CLICK_FROM_WEIBO", "CLICK_FROM_YY", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes11.dex */
        public static final class Companion {
            public static final /* synthetic */ Companion $$INSTANCE;
            public static /* synthetic */ Interceptable $ic = null;
            public static final int CLICK_FROM_APPLE = 6;
            public static final int CLICK_FROM_DEFAULT = 0;
            public static final int CLICK_FROM_PHONE = 5;
            public static final int CLICK_FROM_QQ = 3;
            public static final int CLICK_FROM_QUICK = 7;
            public static final int CLICK_FROM_WECHAT = 1;
            public static final int CLICK_FROM_WEIBO = 2;
            public static final int CLICK_FROM_YY = 4;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-357752432, "Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$LoginResultCallback$Companion;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-357752432, "Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$LoginResultCallback$Companion;");
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

        void onBtnClick(int i2);

        void onResult(int i2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$OpenAccessTokenCallback;", "Lkotlin/Any;", "", StatConstants.KEY_EXT_ERR_MSG, "", "onFailed", "(Ljava/lang/String;)V", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, "onResult", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes11.dex */
    public interface OpenAccessTokenCallback {
        void onFailed(String str);

        void onResult(String str);
    }

    void bindPhone(Context context, BindPhoneCallback bindPhoneCallback);

    void getOpenAccessToken(OpenAccessTokenCallback openAccessTokenCallback, boolean z);

    void showLoginDialog(Context context, LoginResultCallback loginResultCallback);

    void showLoginDialog(Context context, String str, LoginResultCallback loginResultCallback);
}
