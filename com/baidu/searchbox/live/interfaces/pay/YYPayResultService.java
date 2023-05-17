package com.baidu.searchbox.live.interfaces.pay;

import com.baidu.searchbox.live.interfaces.service.YYPayService;
/* loaded from: classes3.dex */
public interface YYPayResultService {
    void onFail(int i, String str);

    void onSuccess(YYPayService.YYPayResultMessage yYPayResultMessage);
}
