package com.baidu.live.business.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.ILiveFeedModel;
import com.baidu.live.business.model.data.LiveFeedData;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.business.model.data.LiveTabWrapData;
import com.baidu.live.business.util.GrParasmUtil;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ca0;
import com.repackage.da0;
import com.repackage.g80;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFeedModel implements ILiveFeedModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FEED_PAGE_INTEREST_URL = "https://tiebac.baidu.com/livefeed/interest";
    public static final String FEED_PAGE_URL = "https://tiebac.baidu.com/livefeed/feed";
    public static final String RESOURCE_INIT = "banner,tab,feed,follow,config,reserve,diamond,topic";
    public transient /* synthetic */ FieldHolder $fh;
    public final String mPage;
    public String mParamScene;
    public final String mSource;

    public LiveFeedModel(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSource = str2;
        this.mPage = str;
        this.mParamScene = getSceneParam(str);
    }

    private String getSceneParam(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == 1137617387) {
                if (str.equals(LiveFeedPageSdk.IMMERSION)) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode != 1333267023) {
                if (hashCode == 1418021314 && str.equals(LiveFeedPageSdk.HOST_LIVE_TAB)) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (str.equals(LiveFeedPageSdk.VIDEO_BAR)) {
                    c = 2;
                }
                c = 65535;
            }
            return c != 0 ? c != 1 ? c != 2 ? "tab" : "videobar" : "immer" : "tab";
        }
        return (String) invokeL.objValue;
    }

    private void realReq(String str, String str2, int i, String str3, String str4, String str5, int i2, String str6, List<String> list, ILiveFeedModel.OnDataLoadCallback onDataLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, str2, Integer.valueOf(i), str3, str4, str5, Integer.valueOf(i2), str6, list, onDataLoadCallback}) == null) {
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
            hashMap.put(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY, System.currentTimeMillis() + "");
            hashMap.put("source", this.mSource);
            da0.f(FEED_PAGE_URL, hashMap, new ca0<LiveFeedData>(this, i, str, onDataLoadCallback) { // from class: com.baidu.live.business.model.LiveFeedModel.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveFeedModel this$0;
                public final /* synthetic */ ILiveFeedModel.OnDataLoadCallback val$callback;
                public final /* synthetic */ int val$refreshType;
                public final /* synthetic */ String val$resource;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), str, onDataLoadCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$refreshType = i;
                    this.val$resource = str;
                    this.val$callback = onDataLoadCallback;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.searchbox.live.interfaces.net.NetResponse, java.lang.Object, java.util.Map, java.util.List] */
                @Override // com.repackage.ca0
                public /* bridge */ /* synthetic */ void onNetResponse(NetResponse netResponse, LiveFeedData liveFeedData, Map map, List list2) {
                    onNetResponse2(netResponse, liveFeedData, (Map<String, String>) map, (List<String>) list2);
                }

                /* JADX WARN: Can't wrap try/catch for region: R(11:3|(2:5|(3:44|(1:46)|47)(3:8|(1:10)|11))(3:48|(1:50)|51)|12|(3:14|(9:38|39|40|18|(2:(1:36)(1:27)|28)(1:37)|29|30|31|32)|16)(1:43)|17|18|(0)(0)|29|30|31|32) */
                /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
                /* JADX WARN: Removed duplicated region for block: B:42:0x00c8  */
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
                    LiveTabWrapData liveTabWrapData;
                    List<LiveTabEntity> list3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, netResponse, liveFeedData, map, list2) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String str14 = "";
                        if (netResponse != null) {
                            if (netResponse.isSuccessful() && liveFeedData != null) {
                                ILiveFeedModel.OnDataLoadCallback onDataLoadCallback2 = this.val$callback;
                                if (onDataLoadCallback2 != null) {
                                    onDataLoadCallback2.onSuccess(liveFeedData, map);
                                }
                                GrParasmUtil.clear(list2);
                                i3 = liveFeedData.errno;
                                str8 = liveFeedData.msg;
                                str7 = liveFeedData.logId;
                            } else {
                                ILiveFeedModel.OnDataLoadCallback onDataLoadCallback3 = this.val$callback;
                                if (onDataLoadCallback3 != null) {
                                    onDataLoadCallback3.onFail(netResponse.netErrorCode, netResponse.exception, map);
                                }
                                int i4 = netResponse.netErrorCode;
                                str8 = netResponse.exception;
                                str7 = "";
                                i3 = i4;
                            }
                        } else {
                            ILiveFeedModel.OnDataLoadCallback onDataLoadCallback4 = this.val$callback;
                            if (onDataLoadCallback4 != null) {
                                onDataLoadCallback4.onFail(-100, "网络不给力，请稍后重试", map);
                            }
                            str7 = "";
                            str8 = "网络不给力，请稍后重试";
                            i3 = -100;
                        }
                        String n = g80.n(this.this$0.mPage);
                        if (map != null) {
                            String str15 = map.get("tab");
                            String str16 = map.get("subtab");
                            str10 = map.get("resource");
                            String str17 = map.get("session_id");
                            if (map.containsKey(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY)) {
                                try {
                                    j = currentTimeMillis - Long.parseLong(map.get(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY));
                                    str9 = str15;
                                    str11 = str16;
                                    str12 = str17;
                                } catch (NumberFormatException unused) {
                                }
                                if (str10.contains("tab")) {
                                    str13 = "";
                                } else {
                                    str13 = (liveFeedData == null || (liveTabWrapData = liveFeedData.tabWrapData) == null || (list3 = liveTabWrapData.tabList) == null || list3.isEmpty()) ? "1" : "0";
                                }
                                str14 = URLEncoder.encode(str10, "UTF-8");
                                g80.t(LiveFeedPageSdk.getInstance().getApplication(), this.this$0.mSource, n, j, i3, str8, str7, str14, str9, str11, str12, str13);
                            }
                            str9 = str15;
                            str11 = str16;
                            str12 = str17;
                        } else {
                            str9 = "";
                            str10 = str9;
                            str11 = str10;
                            str12 = str11;
                        }
                        j = 0;
                        if (str10.contains("tab")) {
                        }
                        str14 = URLEncoder.encode(str10, "UTF-8");
                        g80.t(LiveFeedPageSdk.getInstance().getApplication(), this.this$0.mSource, n, j, i3, str8, str7, str14, str9, str11, str12, str13);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.repackage.ca0
                public LiveFeedData onParseResponseInBackground(NetResponse netResponse) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, netResponse)) == null) {
                        LiveFeedData liveFeedData = new LiveFeedData();
                        if (netResponse != null && !TextUtils.isEmpty(netResponse.decodedResponseStr)) {
                            try {
                                liveFeedData.parserJson(new JSONObject(netResponse.decodedResponseStr), this.val$refreshType, LiveFeedModel.RESOURCE_INIT.equals(this.val$resource), true);
                            } catch (JSONException e) {
                                LiveFeedPageSdk.liveLog(e.getMessage());
                                if (TextUtils.equals(LiveFeedModel.RESOURCE_INIT, this.val$resource)) {
                                    liveFeedData.getDataByCache(-101, e.getMessage(), true, true);
                                }
                            }
                        }
                        return liveFeedData;
                    }
                    return (LiveFeedData) invokeL.objValue;
                }
            }, 0, 0, null, list);
        }
    }

    @Override // com.baidu.live.business.model.ILiveFeedModel
    @NonNull
    public String getInitResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? RESOURCE_INIT : (String) invokeV.objValue;
    }

    @Override // com.baidu.live.business.model.ILiveFeedModel
    public void reqFollow(ILiveFeedModel.OnDataLoadCallback onDataLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onDataLoadCallback) == null) {
            realReq("follow", "", 0, "", "", "", 1, "", null, onDataLoadCallback);
        }
    }

    @Override // com.baidu.live.business.model.ILiveFeedModel
    public void reqInit(ILiveFeedModel.OnDataLoadCallback onDataLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onDataLoadCallback) == null) {
            realReq(RESOURCE_INIT, "", 0, "", "", "", 1, GrParasmUtil.genUploadJson(), GrParasmUtil.uploadFeedList, onDataLoadCallback);
        }
    }

    @Override // com.baidu.live.business.model.ILiveFeedModel
    public void reqSingleData(String str, String str2, int i, String str3, String str4, String str5, int i2, ILiveFeedModel.OnDataLoadCallback onDataLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), str3, str4, str5, Integer.valueOf(i2), onDataLoadCallback}) == null) {
            realReq(str, str2, i, str3, str4, str5, i2, GrParasmUtil.genUploadJson(), GrParasmUtil.uploadFeedList, onDataLoadCallback);
        }
    }

    @Override // com.baidu.live.business.model.ILiveFeedModel
    public void reqInit(@Nullable String str, @Nullable String str2, @Nullable ILiveFeedModel.OnDataLoadCallback onDataLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, onDataLoadCallback) == null) {
            realReq(RESOURCE_INIT, "", 0, str, str2, "", 1, GrParasmUtil.genUploadJson(), GrParasmUtil.uploadFeedList, onDataLoadCallback);
        }
    }
}
