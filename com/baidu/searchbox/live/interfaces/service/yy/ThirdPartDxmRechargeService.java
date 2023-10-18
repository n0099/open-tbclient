package com.baidu.searchbox.live.interfaces.service.yy;

import android.app.Activity;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartDxmRechargeService;", "Lkotlin/Any;", "Landroid/app/Activity;", "activity", "", "orderUrl", "Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartDxmRechargeService$ThirdPartDxmRechargeCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "dxmRecharge", "(Landroid/app/Activity;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartDxmRechargeService$ThirdPartDxmRechargeCallback;)V", "Companion", "ThirdPartDxmRechargeCallback", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface ThirdPartDxmRechargeService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartDxmRechargeService$ThirdPartDxmRechargeCallback;", "Lkotlin/Any;", "", "code", "", "failReason", "", "onFail", "(ILjava/lang/String;)V", "state", "msg", "onSuccess", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public interface ThirdPartDxmRechargeCallback {
        void onFail(int i, String str);

        void onSuccess(int i, String str);
    }

    void dxmRecharge(Activity activity, String str, ThirdPartDxmRechargeCallback thirdPartDxmRechargeCallback);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartDxmRechargeService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.YY.THIRD_PART_DXM_RECHARGE);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }
}
