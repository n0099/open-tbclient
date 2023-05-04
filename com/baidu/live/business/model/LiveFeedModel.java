package com.baidu.live.business.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.ILiveFeedModel;
import com.baidu.live.business.model.data.LiveFeedData;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.business.model.data.LiveTabWrapData;
import com.baidu.live.business.util.GrParasmUtil;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.tieba.fb0;
import com.baidu.tieba.g90;
import com.baidu.tieba.gb0;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFeedModel implements ILiveFeedModel {
    public static final String FEED_PAGE_URL = "https://tiebac.baidu.com/livefeed/feed";
    public static final String RESOURCE_ALL_FOLLOW = "all_follow,config";
    public static final String RESOURCE_INIT = "banner,tab,feed,follow,config,reserve,diamond,topic";
    public static final String RESOURCE_INIT_ALL_FOLLOW = "banner,tab,feed,all_follow,config,reserve,diamond,topic";
    public final String mPage;
    public String mParamScene;
    public final String mSource;

    public LiveFeedModel(String str, String str2) {
        this.mSource = str2;
        this.mPage = str;
        this.mParamScene = getSceneParam(str);
    }

    @Override // com.baidu.live.business.model.ILiveFeedModel
    public void reqFollow(ILiveFeedModel.OnDataLoadCallback onDataLoadCallback) {
        realReq(getFollowResource(), "", 0, "", "", "", 1, "", null, onDataLoadCallback);
    }

    @Override // com.baidu.live.business.model.ILiveFeedModel
    public void reqInit(ILiveFeedModel.OnDataLoadCallback onDataLoadCallback) {
        realReq(getInitResource(), "", 0, "", "", "", 1, GrParasmUtil.genUploadJson(), GrParasmUtil.uploadFeedList, onDataLoadCallback);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String getSceneParam(String str) {
        char c;
        switch (str.hashCode()) {
            case -2042598803:
                if (str.equals(LiveFeedPageSdk.FOLLOW_VIDEO)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1137617387:
                if (str.equals(LiveFeedPageSdk.IMMERSION)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1333267023:
                if (str.equals(LiveFeedPageSdk.VIDEO_BAR)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1418021314:
                if (str.equals(LiveFeedPageSdk.HOST_LIVE_TAB)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return "tab";
        }
        if (c != 1) {
            if (c != 2) {
                if (c != 3) {
                    return "tab";
                }
                return "followvideo";
            }
            return "videobar";
        }
        return "immer";
    }

    private void realReq(final String str, String str2, final int i, String str3, String str4, String str5, int i2, String str6, List<String> list, final ILiveFeedModel.OnDataLoadCallback onDataLoadCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("resource", str);
        hashMap.put("scene", this.mParamScene);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("session_id", str2);
        hashMap.put("refresh_type", String.valueOf(i));
        hashMap.put("tab", str3);
        hashMap.put("channel_id", str4);
        hashMap.put("subtab", str5);
        hashMap.put("upload_ids", str6);
        hashMap.put("refresh_index", String.valueOf(i2));
        hashMap.put("start_time", System.currentTimeMillis() + "");
        hashMap.put("source", this.mSource);
        gb0.f(FEED_PAGE_URL, hashMap, new fb0<LiveFeedData>() { // from class: com.baidu.live.business.model.LiveFeedModel.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.searchbox.live.interfaces.net.NetResponse, java.lang.Object, java.util.Map, java.util.List] */
            @Override // com.baidu.tieba.fb0
            public /* bridge */ /* synthetic */ void onNetResponse(NetResponse netResponse, LiveFeedData liveFeedData, Map map, List list2) {
                onNetResponse2(netResponse, liveFeedData, (Map<String, String>) map, (List<String>) list2);
            }

            /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(3:42|(1:44)|45)(3:6|(1:8)|9))(3:46|(1:48)|49)|10|(3:12|(9:36|37|38|16|(2:(1:34)(1:25)|26)(1:35)|27|28|29|30)|14)(1:41)|15|16|(0)(0)|27|28|29|30) */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x00ca  */
            /* renamed from: onNetResponse  reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onNetResponse2(NetResponse netResponse, LiveFeedData liveFeedData, Map<String, String> map, List<String> list2) {
                String str7;
                String str8;
                int i3;
                String str9;
                String str10;
                String str11;
                String str12;
                long j;
                String str13;
                String str14;
                LiveTabWrapData liveTabWrapData;
                List<LiveTabEntity> list3;
                long currentTimeMillis = System.currentTimeMillis();
                String str15 = "";
                if (netResponse != null) {
                    if (netResponse.isSuccessful() && liveFeedData != null) {
                        ILiveFeedModel.OnDataLoadCallback onDataLoadCallback2 = onDataLoadCallback;
                        if (onDataLoadCallback2 != null) {
                            onDataLoadCallback2.onSuccess(liveFeedData, map);
                        }
                        GrParasmUtil.clear(list2);
                        i3 = liveFeedData.errno;
                        str8 = liveFeedData.msg;
                        str7 = liveFeedData.logId;
                    } else {
                        ILiveFeedModel.OnDataLoadCallback onDataLoadCallback3 = onDataLoadCallback;
                        if (onDataLoadCallback3 != null) {
                            onDataLoadCallback3.onFail(netResponse.netErrorCode, netResponse.exception, map);
                        }
                        int i4 = netResponse.netErrorCode;
                        str8 = netResponse.exception;
                        str7 = "";
                        i3 = i4;
                    }
                } else {
                    ILiveFeedModel.OnDataLoadCallback onDataLoadCallback4 = onDataLoadCallback;
                    if (onDataLoadCallback4 != null) {
                        onDataLoadCallback4.onFail(-100, "网络不给力，请稍后重试", map);
                    }
                    str7 = "";
                    str8 = "网络不给力，请稍后重试";
                    i3 = -100;
                }
                String n = g90.n(LiveFeedModel.this.mPage);
                if (map == null) {
                    str9 = "";
                    str10 = str9;
                    str11 = str10;
                    str12 = str11;
                } else {
                    String str16 = map.get("tab");
                    String str17 = map.get("subtab");
                    str10 = map.get("resource");
                    String str18 = map.get("session_id");
                    if (map.containsKey("start_time")) {
                        try {
                            j = currentTimeMillis - Long.parseLong(map.get("start_time"));
                            str9 = str16;
                            str11 = str17;
                            str12 = str18;
                        } catch (NumberFormatException unused) {
                        }
                        if (str10.contains("tab")) {
                            str13 = "";
                        } else {
                            if (liveFeedData != null && (liveTabWrapData = liveFeedData.tabWrapData) != null && (list3 = liveTabWrapData.tabList) != null && !list3.isEmpty()) {
                                str14 = "0";
                            } else {
                                str14 = "1";
                            }
                            str13 = str14;
                        }
                        str15 = URLEncoder.encode(str10, "UTF-8");
                        g90.t(LiveFeedPageSdk.getInstance().getApplication(), LiveFeedModel.this.mSource, n, j, i3, str8, str7, str15, str9, str11, str12, str13);
                    }
                    str9 = str16;
                    str11 = str17;
                    str12 = str18;
                }
                j = 0;
                if (str10.contains("tab")) {
                }
                str15 = URLEncoder.encode(str10, "UTF-8");
                g90.t(LiveFeedPageSdk.getInstance().getApplication(), LiveFeedModel.this.mSource, n, j, i3, str8, str7, str15, str9, str11, str12, str13);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tieba.fb0
            public LiveFeedData onParseResponseInBackground(NetResponse netResponse) {
                LiveFeedData liveFeedData = new LiveFeedData();
                if (netResponse != null && !TextUtils.isEmpty(netResponse.decodedResponseStr)) {
                    try {
                        liveFeedData.parserJson(new JSONObject(netResponse.decodedResponseStr), i, LiveFeedModel.this.getInitResource().equals(str), true);
                    } catch (JSONException e) {
                        LiveFeedPageSdk.liveLog(e.getMessage());
                        if (TextUtils.equals(LiveFeedModel.this.getInitResource(), str)) {
                            liveFeedData.getDataByCache(-101, e.getMessage(), true, true);
                        }
                    }
                }
                return liveFeedData;
            }
        }, 0, 0, null, list);
    }

    public String getFollowResource() {
        if (!LiveFeedPageSdk.VIDEO_BAR.equals(this.mPage) && !LiveFeedPageSdk.FOLLOW_VIDEO.equals(this.mPage)) {
            return "follow";
        }
        return RESOURCE_ALL_FOLLOW;
    }

    @Override // com.baidu.live.business.model.ILiveFeedModel
    @NonNull
    public String getInitResource() {
        if (!LiveFeedPageSdk.VIDEO_BAR.equals(this.mPage) && !LiveFeedPageSdk.FOLLOW_VIDEO.equals(this.mPage)) {
            return RESOURCE_INIT;
        }
        return RESOURCE_INIT_ALL_FOLLOW;
    }

    @Override // com.baidu.live.business.model.ILiveFeedModel
    public void reqInit(@Nullable String str, @Nullable String str2, @Nullable ILiveFeedModel.OnDataLoadCallback onDataLoadCallback) {
        realReq(getInitResource(), "", 0, str, str2, "", 1, GrParasmUtil.genUploadJson(), GrParasmUtil.uploadFeedList, onDataLoadCallback);
    }

    @Override // com.baidu.live.business.model.ILiveFeedModel
    public void reqSingleData(String str, String str2, int i, String str3, String str4, String str5, int i2, ILiveFeedModel.OnDataLoadCallback onDataLoadCallback) {
        realReq(str, str2, i, str3, str4, str5, i2, GrParasmUtil.genUploadJson(), GrParasmUtil.uploadFeedList, onDataLoadCallback);
    }
}
