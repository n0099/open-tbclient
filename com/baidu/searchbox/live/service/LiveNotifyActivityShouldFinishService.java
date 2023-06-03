package com.baidu.searchbox.live.service;

import com.baidu.live.arch.api.IService;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/service/LiveNotifyActivityShouldFinishService;", "Lcom/baidu/live/arch/api/IService;", "Lkotlin/Any;", "", "fetchNeedSmooth", "()Z", "", "notifyActivityShouldFinish", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface LiveNotifyActivityShouldFinishService extends IService {
    boolean fetchNeedSmooth();

    void notifyActivityShouldFinish();
}
