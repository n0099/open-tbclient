package com.baidu.live.feedfollow;

import com.baidu.live.business.model.LiveFeedAllFollowModel;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/live/business/model/LiveFeedAllFollowModel;", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveFeedFollowContainer$allFollowLivingModel$2 extends Lambda implements Function0<LiveFeedAllFollowModel> {
    public static final LiveFeedFollowContainer$allFollowLivingModel$2 INSTANCE = new LiveFeedFollowContainer$allFollowLivingModel$2();

    public LiveFeedFollowContainer$allFollowLivingModel$2() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LiveFeedAllFollowModel invoke() {
        return new LiveFeedAllFollowModel();
    }
}
