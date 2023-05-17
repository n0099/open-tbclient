package com.baidu.searchbox.account;

import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/account/IGetUserCertInfoListener;", "", "onChild", "", "errorCode", "", "(Ljava/lang/Integer;)V", "onFailed", "Companion", "lib-account-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IGetUserCertInfoListener {
    public static final int CHILD = 200;
    public static final int CHILD_HAS_GUARDER_AUTH = 202;
    public static final int CHILD_NOT_GUARDER_AUTH = 201;
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int NOT_CHILD = 100;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/account/IGetUserCertInfoListener$Companion;", "", "()V", "CHILD", "", "CHILD_HAS_GUARDER_AUTH", "CHILD_NOT_GUARDER_AUTH", "NOT_CHILD", "lib-account-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CHILD = 200;
        public static final int CHILD_HAS_GUARDER_AUTH = 202;
        public static final int CHILD_NOT_GUARDER_AUTH = 201;
        public static final int NOT_CHILD = 100;
    }

    void onChild(Integer num);

    void onFailed(Integer num);
}
