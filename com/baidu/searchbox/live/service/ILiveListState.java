package com.baidu.searchbox.live.service;

import com.baidu.live.arch.api.IService;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.frame.ListInfo;
import com.baidu.searchbox.live.frame.PageInfo;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/live/service/ILiveListState;", "Lcom/baidu/live/arch/api/IService;", "Lkotlin/Any;", "Lcom/baidu/searchbox/live/frame/IntentData;", "getIntent", "()Lcom/baidu/searchbox/live/frame/IntentData;", "Lcom/baidu/searchbox/live/frame/ListInfo;", "getListInfo", "()Lcom/baidu/searchbox/live/frame/ListInfo;", "Lcom/baidu/searchbox/live/frame/PageInfo;", "getPageInfo", "()Lcom/baidu/searchbox/live/frame/PageInfo;", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface ILiveListState extends IService {
    IntentData getIntent();

    ListInfo getListInfo();

    PageInfo getPageInfo();
}
