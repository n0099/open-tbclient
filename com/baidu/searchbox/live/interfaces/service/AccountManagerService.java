package com.baidu.searchbox.live.interfaces.service;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.data.UserAccount;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001e\u001d\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\nH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001a\u00020\u00142\b\b\u0001\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u0006¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "Lkotlin/Any;", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService$AccountStatusChangedListener;", "listener", "", "addLoginStatusChangedListener", "(Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService$AccountStatusChangedListener;)V", "Lcom/baidu/searchbox/live/interfaces/data/UserAccount;", "getAccount", "()Lcom/baidu/searchbox/live/interfaces/data/UserAccount;", "", "plaintext", "tag", "getSocialDecrypt", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getSocialEncryption", "getUid", "()Ljava/lang/String;", "", "type", "", "isLogin", "(I)Z", "Landroid/content/Context;", "context", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService$LoginResultListener;", "login", "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService$LoginResultListener;)V", "removeLoginStatusChangedListener", "Companion", "AccountStatusChangedListener", "LoginResultListener", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface AccountManagerService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService$AccountStatusChangedListener;", "Lkotlin/Any;", "", "newStatus", "", "onAccountStatusChanged", "(Z)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public interface AccountStatusChangedListener {
        void onAccountStatusChanged(boolean z);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef("account");

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService$LoginResultListener;", "Lkotlin/Any;", "", "state", "", "onResult", "(I)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public interface LoginResultListener {
        void onResult(@LoginResult int i);
    }

    void addLoginStatusChangedListener(AccountStatusChangedListener accountStatusChangedListener);

    UserAccount getAccount();

    String getSocialDecrypt(String str, String str2);

    String getSocialEncryption(String str, String str2);

    String getUid();

    boolean isLogin(@LoginType int i);

    void login(Context context, LoginResultListener loginResultListener);

    void removeLoginStatusChangedListener(AccountStatusChangedListener accountStatusChangedListener);
}
