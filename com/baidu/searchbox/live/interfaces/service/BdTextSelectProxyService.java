package com.baidu.searchbox.live.interfaces.service;

import android.view.View;
import android.widget.TextView;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.textmenu.IBdTextSelectHelper;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/BdTextSelectProxyService;", "Lkotlin/Any;", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "tokenView", "Lcom/baidu/searchbox/live/interfaces/textmenu/IBdTextSelectHelper;", "buildBdTextSelectHelper", "(Landroid/widget/TextView;Landroid/view/View;)Lcom/baidu/searchbox/live/interfaces/textmenu/IBdTextSelectHelper;", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface BdTextSelectProxyService {
    public static final Companion Companion = Companion.$$INSTANCE;

    IBdTextSelectHelper buildBdTextSelectHelper(TextView textView, View view2);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/BdTextSelectProxyService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_TEXT_SELECT);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ IBdTextSelectHelper buildBdTextSelectHelper$default(BdTextSelectProxyService bdTextSelectProxyService, TextView textView, View view2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    view2 = null;
                }
                return bdTextSelectProxyService.buildBdTextSelectHelper(textView, view2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildBdTextSelectHelper");
        }
    }
}
