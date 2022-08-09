package com.baidu.live.business.listener;

import com.baidu.live.business.model.data.LiveFollowEntity;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/baidu/live/business/listener/LiveFeedFollowListener;", "Lkotlin/Any;", "Lcom/baidu/live/business/model/data/LiveFollowEntity;", "entity", "", CriusAttrConstants.POSITION, "", "onClickFollow", "(Lcom/baidu/live/business/model/data/LiveFollowEntity;I)V", "onFollowShow", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface LiveFeedFollowListener {
    void onClickFollow(LiveFollowEntity liveFollowEntity, int i);

    void onFollowShow(LiveFollowEntity liveFollowEntity, int i);
}
