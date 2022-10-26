package com.baidu.searchbox.live.component.service;

import com.baidu.live.arch.api.IService;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/component/service/LiveItemModelListService;", "Lcom/baidu/live/arch/api/IService;", "Lkotlin/Any;", "", "getCurrentPosition", "()I", "", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "getLiveItemModels", "()Ljava/util/List;", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface LiveItemModelListService extends IService {
    int getCurrentPosition();

    List getLiveItemModels();
}
