package com.baidu.searchbox.live.interfaces.service;

import android.app.Activity;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveNickNameService;", "Lkotlin/Any;", "", "nickNameDialogStatus", "()I", "Landroid/app/Activity;", "activity", "", "source", "requestCode", "", "showNickNameDialog", "(Landroid/app/Activity;Ljava/lang/String;I)V", "type", "showNickNameGuideDialog", "(Landroid/app/Activity;ILjava/lang/String;I)V", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface LiveNickNameService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveNickNameService$Companion;", "", "NICKNAME_DIALOG_TYPE_DISTRIBUTE", "I", "getNICKNAME_DIALOG_TYPE_DISTRIBUTE", "()I", "setNICKNAME_DIALOG_TYPE_DISTRIBUTE", "(I)V", "NICKNAME_DIALOG_TYPE_RECOMMEND", "getNICKNAME_DIALOG_TYPE_RECOMMEND", "setNICKNAME_DIALOG_TYPE_RECOMMEND", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static int NICKNAME_DIALOG_TYPE_DISTRIBUTE;
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_NICK_NAME);
        public static int NICKNAME_DIALOG_TYPE_RECOMMEND = 1;

        public final int getNICKNAME_DIALOG_TYPE_DISTRIBUTE() {
            return NICKNAME_DIALOG_TYPE_DISTRIBUTE;
        }

        public final int getNICKNAME_DIALOG_TYPE_RECOMMEND() {
            return NICKNAME_DIALOG_TYPE_RECOMMEND;
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }

        public final void setNICKNAME_DIALOG_TYPE_DISTRIBUTE(int i) {
            NICKNAME_DIALOG_TYPE_DISTRIBUTE = i;
        }

        public final void setNICKNAME_DIALOG_TYPE_RECOMMEND(int i) {
            NICKNAME_DIALOG_TYPE_RECOMMEND = i;
        }
    }

    int nickNameDialogStatus();

    void showNickNameDialog(Activity activity, String str, int i);

    void showNickNameGuideDialog(Activity activity, int i, String str, int i2);
}
