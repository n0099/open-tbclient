package com.baidu.searchbox.live.service;

import android.content.Context;
import com.baidu.searchbox.live.interfaces.payment.IPaymentLogDelegate;
import com.baidu.searchbox.live.interfaces.payment.IPaymentStateCallback;
import com.baidu.searchbox.live.interfaces.service.Media2YYService;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ;\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJy\u0010\u001a\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/live/service/Media2YYServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/Media2YYService;", "Landroid/content/Context;", "context", "", "key", "", "params", "", "postOnBeforeMixLiveActivityLaunch", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V", "", "", "extraParams", "release", "(Ljava/util/Map;)V", "Lcom/baidu/searchbox/live/interfaces/payment/IPaymentStateCallback;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/searchbox/live/interfaces/payment/IPaymentLogDelegate;", "logDelegate", "title", "", PayUiEventContent.AMOUNT, "", "closeOnSuc", "customExpandParams", LiveYYPluginManager.USE_FROM_START_PAYMENT, "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/payment/IPaymentStateCallback;Lcom/baidu/searchbox/live/interfaces/payment/IPaymentLogDelegate;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;)V", "<init>", "()V", "lib-live-nps-ext_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class Media2YYServiceImpl implements Media2YYService {
    @Override // com.baidu.searchbox.live.interfaces.service.Media2YYService
    public void postOnBeforeMixLiveActivityLaunch(Context context, String str, Map<String, String> map) {
        LiveYYPluginManager.getInstance().dispatchHostEvent(context, str, map);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.Media2YYService
    public void release(Map<String, ? extends Object> map) {
        LiveYYPluginManager.getInstance().releasePayment(map);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.Media2YYService
    public void startPayment(Context context, IPaymentStateCallback iPaymentStateCallback, IPaymentLogDelegate iPaymentLogDelegate, String str, Long l, Boolean bool, Map<String, String> map, Map<String, ? extends Object> map2) {
        LiveYYPluginManager.getInstance().startPayment(context, iPaymentStateCallback, iPaymentLogDelegate, str, l, bool, map, map2);
    }
}
