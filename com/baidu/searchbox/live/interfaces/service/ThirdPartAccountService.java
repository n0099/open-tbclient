package com.baidu.searchbox.live.interfaces.service;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.live.interfaces.DI;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \f2\u00020\u0001:\u0003\f\r\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService;", "Lkotlin/Any;", "Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$OpenAccessTokenCallback;", "callback", "", "getOpenAccessToken", "(Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$OpenAccessTokenCallback;)V", "Landroid/content/Context;", "context", "Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$LoginResultCallback;", "showLoginDialog", "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$LoginResultCallback;)V", "Companion", "LoginResultCallback", "OpenAccessTokenCallback", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface ThirdPartAccountService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.THIRD_PART_ACCOUNT);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$LoginResultCallback;", "Lkotlin/Any;", "", "clickFrom", "", "onBtnClick", "(I)V", "state", "onResult", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
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
        /* loaded from: classes2.dex */
        public static final class Companion {
            public static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int CLICK_FROM_APPLE = 6;
            public static final int CLICK_FROM_DEFAULT = 0;
            public static final int CLICK_FROM_PHONE = 5;
            public static final int CLICK_FROM_QQ = 3;
            public static final int CLICK_FROM_QUICK = 7;
            public static final int CLICK_FROM_WECHAT = 1;
            public static final int CLICK_FROM_WEIBO = 2;
            public static final int CLICK_FROM_YY = 4;
        }

        void onBtnClick(int i);

        void onResult(int i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ThirdPartAccountService$OpenAccessTokenCallback;", "Lkotlin/Any;", "", "errMsg", "", "onFailed", "(Ljava/lang/String;)V", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, "onResult", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OpenAccessTokenCallback {
        void onFailed(String str);

        void onResult(String str);
    }

    void getOpenAccessToken(OpenAccessTokenCallback openAccessTokenCallback);

    void showLoginDialog(Context context, LoginResultCallback loginResultCallback);
}
