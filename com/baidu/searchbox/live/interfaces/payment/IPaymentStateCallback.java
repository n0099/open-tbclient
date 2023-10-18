package com.baidu.searchbox.live.interfaces.payment;

import com.baidu.searchbox.downloadcenter.service.DownloadCenterFunConstants;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J;\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/payment/IPaymentStateCallback;", "Lkotlin/Any;", "", "code", "", "msg", "", "", DownloadCenterFunConstants.EXTRA_INFO, "", "onFail", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)V", "onFinish", "()V", "type", "data", "onInfo", "(Ljava/lang/Integer;Ljava/lang/String;)V", "", "onIntercept", "()Z", "Lcom/baidu/searchbox/live/interfaces/payment/PayResultInfo;", "info", "onSuccess", "(Lcom/baidu/searchbox/live/interfaces/payment/PayResultInfo;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface IPaymentStateCallback {
    void onFail(Integer num, String str, Map<String, ? extends Object> map);

    void onFinish();

    void onInfo(Integer num, String str);

    boolean onIntercept();

    void onSuccess(PayResultInfo payResultInfo);
}
