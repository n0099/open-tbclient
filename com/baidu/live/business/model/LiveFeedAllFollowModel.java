package com.baidu.live.business.model;

import android.text.TextUtils;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.LiveFeedAllFollowModel;
import com.baidu.live.business.model.data.LiveFeedFollowLivingData;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tieba.id0;
import com.baidu.tieba.jd0;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \b:\u0002\b\tB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/baidu/live/business/model/LiveFeedAllFollowModel;", "Lcom/baidu/live/business/model/LiveFeedAllFollowModel$OnFollowLivingDataLoadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "requestFollowLiving", "(Lcom/baidu/live/business/model/LiveFeedAllFollowModel$OnFollowLivingDataLoadCallback;)V", "<init>", "()V", "Companion", "OnFollowLivingDataLoadCallback", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveFeedAllFollowModel {
    public static final Companion Companion = new Companion(null);
    public static final String FEED_PAGE_FOLLOW_LIVING = "https://tiebac.baidu.com/livefeed/user/followLivingList";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/baidu/live/business/model/LiveFeedAllFollowModel$OnFollowLivingDataLoadCallback;", "Lkotlin/Any;", "", StatConstants.KEY_EXT_ERR_CODE, "", StatConstants.KEY_EXT_ERR_MSG, "", "onFail", "(ILjava/lang/String;)V", "Lcom/baidu/live/business/model/data/LiveFeedFollowLivingData;", "livingData", "onSuccess", "(Lcom/baidu/live/business/model/data/LiveFeedFollowLivingData;)V", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public interface OnFollowLivingDataLoadCallback {
        void onFail(int i, String str);

        void onSuccess(LiveFeedFollowLivingData liveFeedFollowLivingData);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/live/business/model/LiveFeedAllFollowModel$Companion;", "", "FEED_PAGE_FOLLOW_LIVING", "Ljava/lang/String;", "<init>", "()V", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void requestFollowLiving$default(LiveFeedAllFollowModel liveFeedAllFollowModel, OnFollowLivingDataLoadCallback onFollowLivingDataLoadCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            onFollowLivingDataLoadCallback = null;
        }
        liveFeedAllFollowModel.requestFollowLiving(onFollowLivingDataLoadCallback);
    }

    public final void requestFollowLiving(final OnFollowLivingDataLoadCallback onFollowLivingDataLoadCallback) {
        jd0.f(FEED_PAGE_FOLLOW_LIVING, new LinkedHashMap(), new id0<LiveFeedFollowLivingData>() { // from class: com.baidu.live.business.model.LiveFeedAllFollowModel$requestFollowLiving$1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tieba.id0
            public LiveFeedFollowLivingData onParseResponseInBackground(NetResponse netResponse) {
                LiveFeedFollowLivingData liveFeedFollowLivingData = new LiveFeedFollowLivingData();
                if (netResponse != null && !TextUtils.isEmpty(netResponse.decodedResponseStr)) {
                    try {
                        liveFeedFollowLivingData.parserJson(new JSONObject(netResponse.decodedResponseStr));
                    } catch (JSONException e) {
                        LiveFeedPageSdk.liveLog(e.getMessage());
                    }
                }
                return liveFeedFollowLivingData;
            }

            /* renamed from: onNetResponse  reason: avoid collision after fix types in other method */
            public void onNetResponse2(NetResponse netResponse, LiveFeedFollowLivingData liveFeedFollowLivingData, Map<String, String> map, List<String> list) {
                if (netResponse != null) {
                    if (netResponse.isSuccessful() && liveFeedFollowLivingData != null) {
                        LiveFeedAllFollowModel.OnFollowLivingDataLoadCallback onFollowLivingDataLoadCallback2 = LiveFeedAllFollowModel.OnFollowLivingDataLoadCallback.this;
                        if (onFollowLivingDataLoadCallback2 != null) {
                            onFollowLivingDataLoadCallback2.onSuccess(liveFeedFollowLivingData);
                            return;
                        }
                        return;
                    }
                    LiveFeedAllFollowModel.OnFollowLivingDataLoadCallback onFollowLivingDataLoadCallback3 = LiveFeedAllFollowModel.OnFollowLivingDataLoadCallback.this;
                    if (onFollowLivingDataLoadCallback3 != null) {
                        onFollowLivingDataLoadCallback3.onFail(netResponse.netErrorCode, netResponse.exception);
                        return;
                    }
                    return;
                }
                LiveFeedAllFollowModel.OnFollowLivingDataLoadCallback onFollowLivingDataLoadCallback4 = LiveFeedAllFollowModel.OnFollowLivingDataLoadCallback.this;
                if (onFollowLivingDataLoadCallback4 != null) {
                    onFollowLivingDataLoadCallback4.onFail(-100, "");
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.searchbox.live.interfaces.net.NetResponse, java.lang.Object, java.util.Map, java.util.List] */
            @Override // com.baidu.tieba.id0
            public /* bridge */ /* synthetic */ void onNetResponse(NetResponse netResponse, LiveFeedFollowLivingData liveFeedFollowLivingData, Map map, List list) {
                onNetResponse2(netResponse, liveFeedFollowLivingData, (Map<String, String>) map, (List<String>) list);
            }
        }, 0, 0, null, new ArrayList());
    }
}
