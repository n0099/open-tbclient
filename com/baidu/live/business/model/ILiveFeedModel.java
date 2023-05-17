package com.baidu.live.business.model;

import com.baidu.live.business.model.data.LiveFeedData;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\n\u0010\tJ1\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\n\u0010\rJ[\u0010\u0014\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/baidu/live/business/model/ILiveFeedModel;", "Lkotlin/Any;", "", "getInitResource", "()Ljava/lang/String;", "Lcom/baidu/live/business/model/ILiveFeedModel$OnDataLoadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "reqFollow", "(Lcom/baidu/live/business/model/ILiveFeedModel$OnDataLoadCallback;)V", "reqInit", "tab", "channelId", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/live/business/model/ILiveFeedModel$OnDataLoadCallback;)V", "resourceParam", "sessionId", "", "refreshType", "subTab", "refreshIndex", "reqSingleData", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/baidu/live/business/model/ILiveFeedModel$OnDataLoadCallback;)V", "Companion", "OnDataLoadCallback", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface ILiveFeedModel {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int FEED_DATA_ERROR_CODE = -100;
    public static final int FEED_DATA_ERROR_CODE_PARSE_FAIL = -101;
    public static final String FEED_DATA_ERROR_MSG = "数据解析失败";
    public static final String FEED_NET_ERROR = "网络不给力，请稍后重试";
    public static final String FEED_SHOW_CACHE_TOAST = "服务器太累了，请稍后重试";
    public static final String RESOURCE_FOLLOW = "follow";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/baidu/live/business/model/ILiveFeedModel$Companion;", "", "FEED_DATA_ERROR_CODE", "I", "FEED_DATA_ERROR_CODE_PARSE_FAIL", "", "FEED_DATA_ERROR_MSG", "Ljava/lang/String;", "FEED_NET_ERROR", "FEED_SHOW_CACHE_TOAST", "RESOURCE_FOLLOW", "<init>", "()V", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int FEED_DATA_ERROR_CODE = -100;
        public static final int FEED_DATA_ERROR_CODE_PARSE_FAIL = -101;
        public static final String FEED_DATA_ERROR_MSG = "数据解析失败";
        public static final String FEED_NET_ERROR = "网络不给力，请稍后重试";
        public static final String FEED_SHOW_CACHE_TOAST = "服务器太累了，请稍后重试";
        public static final String RESOURCE_FOLLOW = "follow";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J;\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ3\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0018\u0010\u0007\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/live/business/model/ILiveFeedModel$OnDataLoadCallback;", "Lkotlin/Any;", "", StatConstants.KEY_EXT_ERR_CODE, "", StatConstants.KEY_EXT_ERR_MSG, "", "params", "", "onFail", "(ILjava/lang/String;Ljava/util/Map;)V", "Lcom/baidu/live/business/model/data/LiveFeedData;", "feedData", "onSuccess", "(Lcom/baidu/live/business/model/data/LiveFeedData;Ljava/util/Map;)V", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public interface OnDataLoadCallback {
        void onFail(int i, String str, Map<String, String> map);

        void onSuccess(LiveFeedData liveFeedData, Map<String, String> map);
    }

    String getInitResource();

    void reqFollow(OnDataLoadCallback onDataLoadCallback);

    void reqInit(OnDataLoadCallback onDataLoadCallback);

    void reqInit(String str, String str2, OnDataLoadCallback onDataLoadCallback);

    void reqSingleData(String str, String str2, int i, String str3, String str4, String str5, int i2, OnDataLoadCallback onDataLoadCallback);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void reqInit$default(ILiveFeedModel iLiveFeedModel, String str, String str2, OnDataLoadCallback onDataLoadCallback, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                iLiveFeedModel.reqInit(str, str2, onDataLoadCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reqInit");
        }
    }
}
