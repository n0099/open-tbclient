package com.baidu.searchbox.live.domain;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SlideListInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int hasMore;
    public ArrayList<SlideInfo> list;
    public String pageSession;

    /* loaded from: classes2.dex */
    public static class SlideInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String avcUrl;
        public String bgCover;
        public String cRoomId;
        public String cover;
        public String feedId;
        public String format;
        public String hevcUrl;
        public String highlightUrl;
        public JSONObject im;
        public boolean isBlurBg;
        public String kabrSpts;
        public String liveType;
        public JSONObject originJson;
        public String playUrl;
        public String quic;
        public String roomId;
        public String rtcUrl;
        public String scheme;
        public String screen;
        public JSONObject slog;
        public String status;
        public String template;
        public String templateId;
        public String title;

        public SlideInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void loadFromJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null) {
                this.cover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
                this.roomId = jSONObject.optString("room_id");
                this.scheme = jSONObject.optString("cmd");
                this.liveType = jSONObject.optString("live_type");
                this.playUrl = jSONObject.optString("play_url");
                this.status = jSONObject.optString("status");
                this.format = jSONObject.optString("format");
                this.screen = jSONObject.optString("screen");
                this.template = jSONObject.optString(MediaTrackConfig.AE_IMPORT_TEMPLATE);
                this.slog = jSONObject.optJSONObject("slog");
                this.feedId = jSONObject.optString("feed_id");
                this.templateId = jSONObject.optString("template_id");
                this.im = jSONObject.optJSONObject("im");
                this.bgCover = jSONObject.optString("live_bg_cover");
                this.title = jSONObject.optString("title");
                this.cRoomId = jSONObject.optString("live_custom_room_id");
                this.originJson = jSONObject;
                this.avcUrl = jSONObject.optString("avc_url");
                this.hevcUrl = jSONObject.optString("hevc_url");
                this.rtcUrl = jSONObject.optString("rtc_url");
                this.quic = jSONObject.optString("quic");
                boolean z = true;
                if (jSONObject.optInt("gaussian_blur") != 1) {
                    z = false;
                }
                this.isBlurBg = z;
                this.highlightUrl = jSONObject.optString("high_light_url");
                this.kabrSpts = jSONObject.optString(LivePreStartPlayServiceImpl.PARAM_KABR_SPTS);
            }
        }
    }

    public SlideListInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void loadFromJson(String str) throws JSONException {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
            this.pageSession = optJSONObject.optString("page_session");
            this.hasMore = optJSONObject.optInt("has_more");
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null) {
                this.list = new ArrayList<>();
                if (optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            SlideInfo slideInfo = new SlideInfo();
                            slideInfo.loadFromJson(optJSONObject2);
                            this.list.add(slideInfo);
                        }
                    }
                }
            }
        }
    }
}
