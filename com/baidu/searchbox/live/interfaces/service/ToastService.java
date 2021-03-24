package com.baidu.searchbox.live.interfaces.service;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.toast.ToastClickListener;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J9\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ToastService;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "title", "rightText", "", "duration", "Lcom/baidu/searchbox/live/interfaces/toast/ToastClickListener;", "listener", "", "showClickableToast", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/baidu/searchbox/live/interfaces/toast/ToastClickListener;)V", "text", "showNormal", "(Landroid/content/Context;Ljava/lang/String;I)V", "showToastBottom", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface ToastService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ToastService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef("toast");

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void showClickableToast$default(ToastService toastService, Context context, String str, String str2, int i, ToastClickListener toastClickListener, int i2, Object obj) {
            if (obj == null) {
                toastService.showClickableToast(context, str, str2, (i2 & 8) != 0 ? 0 : i, toastClickListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showClickableToast");
        }

        public static /* synthetic */ void showNormal$default(ToastService toastService, Context context, String str, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                toastService.showNormal(context, str, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNormal");
        }

        public static /* synthetic */ void showToastBottom$default(ToastService toastService, Context context, String str, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                toastService.showToastBottom(context, str, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showToastBottom");
        }
    }

    void showClickableToast(Context context, String str, String str2, int i, ToastClickListener toastClickListener);

    void showNormal(Context context, String str, int i);

    void showToastBottom(Context context, String str, int i);
}
