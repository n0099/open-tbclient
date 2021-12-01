package com.baidu.ala.data;

import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaChallengeInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class SdkLiveInfoData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_CHUSHOU_GAME_LIVE = 1;
    public static final int TYPE_TIEBA_GAME_LIVE = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public long createTime;
    public int from;
    public String labelUrl;
    public LiveAuthor liveAuthor;
    public String liveId;
    public AlaLiveInfo liveInfo;
    public String location;
    public String logid;
    public SdkMiddleStrategyInfo middleStrategyInfo;
    public String modeUrl;
    public String nid;
    public String recom_extra_img;
    public String recom_extra_img_dark;
    public int recom_extra_img_height;
    public String recom_extra_img_night;
    public int recom_extra_img_width;
    public String roomId;
    public int routerType;
    public String source;
    public String tid;
    public String title;
    public UiTransParam uiTransParam;

    /* loaded from: classes8.dex */
    public static class AlaLiveInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long audienceCount;
        public AlaChallengeInfoData challengeInfoData;
        public String cover;
        public String coverWide;
        public boolean haveRedpkg;
        public String hlsUrl;
        public int liveType;
        public int roomStatus;
        public String rtmpUrl;
        public int screenDirection;
        public String sessionId;
        public String showLabel;
        public YYExt yyExt;

        public AlaLiveInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void fromJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.cover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
            this.sessionId = jSONObject.optString("session_id");
            this.rtmpUrl = jSONObject.optString("rtmp_url");
            this.hlsUrl = jSONObject.optString("hls_url");
            this.audienceCount = jSONObject.optLong("audience_count");
            this.liveType = jSONObject.optInt("live_type");
            this.screenDirection = jSONObject.optInt("screen_direction");
            this.roomStatus = jSONObject.optInt("room_status");
            this.coverWide = jSONObject.optString("cover_wide");
            this.showLabel = jSONObject.optString("show_label");
            JSONObject optJSONObject = jSONObject.optJSONObject("challenge_info");
            if (optJSONObject != null) {
                AlaChallengeInfoData alaChallengeInfoData = new AlaChallengeInfoData();
                this.challengeInfoData = alaChallengeInfoData;
                alaChallengeInfoData.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("yy_ext");
            if (optJSONObject2 != null) {
                YYExt yYExt = new YYExt();
                this.yyExt = yYExt;
                yYExt.fromJson(optJSONObject2);
            }
            this.haveRedpkg = "1".equals(jSONObject.optString("red_packet", ""));
        }
    }

    /* loaded from: classes8.dex */
    public static class LiveAuthor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int gender;
        public String name;
        public String nameShow;
        public String open_id;
        public String portrait;

        public LiveAuthor() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void fromJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.name = jSONObject.optString("name");
            this.nameShow = jSONObject.optString("name_show");
            this.gender = jSONObject.optInt("gender");
            this.portrait = jSONObject.optString("portrait");
            this.open_id = jSONObject.optString("open_id");
        }

        public String getName_show() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (!StringUtils.isNull(this.nameShow)) {
                    return this.nameShow;
                }
                return this.name;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class UiTransParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String abTag;
        public String extra;
        public String sourceFrom;
        public String starId;

        public UiTransParam() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void fromJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.abTag = jSONObject.optString("ab_tag");
            this.starId = jSONObject.optString(TiebaStatic.Params.STAR_ID);
            this.extra = jSONObject.optString("extra");
            this.sourceFrom = jSONObject.optString("source_from");
        }
    }

    /* loaded from: classes8.dex */
    public static class YYExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int isYYGame;
        public String sid;
        public String ssid;
        public String streamInfo;
        public String templateId;
        public String yyUid;

        public YYExt() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void fromJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.sid = jSONObject.optString("sid");
            this.ssid = jSONObject.optString("ssid");
            this.templateId = jSONObject.optString("template_id");
            this.yyUid = jSONObject.optString("yy_uid");
            this.isYYGame = jSONObject.optInt("is_yy_game");
            this.streamInfo = jSONObject.optString("stream_info");
        }

        public YyExtData toYyExtData(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                YyExtData yyExtData = new YyExtData();
                yyExtData.mSid = this.sid;
                yyExtData.mSsid = this.ssid;
                yyExtData.mTemplateId = this.templateId;
                yyExtData.mYyUid = this.yyUid;
                yyExtData.isYyGame = this.isYYGame == 1;
                yyExtData.liveId = str;
                yyExtData.streamInfo = this.streamInfo;
                return yyExtData;
            }
            return (YyExtData) invokeL.objValue;
        }
    }

    public SdkLiveInfoData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.from = 1;
    }

    public void fromJson(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, str) == null) || jSONObject == null) {
            return;
        }
        this.liveId = jSONObject.optString("live_id");
        this.roomId = jSONObject.optString("room_id");
        this.tid = jSONObject.optString("tid");
        this.nid = jSONObject.optString("nid");
        this.logid = str;
        this.routerType = jSONObject.optInt("routerType");
        this.title = jSONObject.optString("title");
        this.createTime = jSONObject.optLong("create_time");
        this.from = jSONObject.optInt("from");
        this.source = jSONObject.optString("source");
        this.recom_extra_img = jSONObject.optString("recom_extra_img");
        this.recom_extra_img_night = jSONObject.optString("recom_extra_img_night");
        this.recom_extra_img_dark = jSONObject.optString("recom_extra_img_dark");
        this.recom_extra_img_width = jSONObject.optInt("recom_extra_img_width");
        this.recom_extra_img_height = jSONObject.optInt("recom_extra_img_height");
        this.labelUrl = jSONObject.optString("label_url");
        this.modeUrl = jSONObject.optString("mode_url");
        this.location = jSONObject.optString("location");
        this.liveAuthor = new LiveAuthor();
        JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
        if (optJSONObject != null) {
            this.liveAuthor.fromJson(optJSONObject);
        }
        this.liveInfo = new AlaLiveInfo();
        JSONObject optJSONObject2 = jSONObject.optJSONObject("ala_info");
        if (optJSONObject2 != null) {
            this.liveInfo.fromJson(optJSONObject2);
        }
        this.uiTransParam = new UiTransParam();
        JSONObject optJSONObject3 = jSONObject.optJSONObject("ui_transparam");
        if (optJSONObject3 != null) {
            this.uiTransParam.fromJson(optJSONObject3);
        }
    }

    public boolean shouldJumpChushouLiveRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.from != 2 : invokeV.booleanValue;
    }
}
