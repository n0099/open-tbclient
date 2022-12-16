package com.baidu.searchbox.live.interfaces.mix;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.widget.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b$\b\u0016\u0018\u0000B\u0007¢\u0006\u0004\bz\u0010{R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R$\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u0005\"\u0004\b\u001d\u0010\u0007R$\u0010\u001e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\u0005\"\u0004\b \u0010\u0007R$\u0010!\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0003\u001a\u0004\b\"\u0010\u0005\"\u0004\b#\u0010\u0007R$\u0010$\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0003\u001a\u0004\b%\u0010\u0005\"\u0004\b&\u0010\u0007R$\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R$\u0010*\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R$\u0010-\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\"\u00101\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b1\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0003\u001a\u0004\b7\u0010\u0005\"\u0004\b8\u0010\u0007R\"\u00109\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0003\u001a\u0004\b:\u0010\u0005\"\u0004\b;\u0010\u0007R$\u0010<\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0010\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014R$\u0010?\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0010\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014R$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0003\u001a\u0004\bJ\u0010\u0005\"\u0004\bK\u0010\u0007R$\u0010L\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010\u0003\u001a\u0004\bM\u0010\u0005\"\u0004\bN\u0010\u0007R\"\u0010O\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010\u0003\u001a\u0004\bP\u0010\u0005\"\u0004\bQ\u0010\u0007R$\u0010R\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0003\u001a\u0004\bS\u0010\u0005\"\u0004\bT\u0010\u0007R$\u0010U\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010\u0003\u001a\u0004\bV\u0010\u0005\"\u0004\bW\u0010\u0007R\"\u0010Y\u001a\u00020X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010_\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010\u0003\u001a\u0004\b`\u0010\u0005\"\u0004\ba\u0010\u0007R$\u0010b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010\u0003\u001a\u0004\bc\u0010\u0005\"\u0004\bd\u0010\u0007R$\u0010e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010\u0010\u001a\u0004\bf\u0010\u0012\"\u0004\bg\u0010\u0014R$\u0010h\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010\u0010\u001a\u0004\bi\u0010\u0012\"\u0004\bj\u0010\u0014R\"\u0010k\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010\u0003\u001a\u0004\bl\u0010\u0005\"\u0004\bm\u0010\u0007R$\u0010n\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010\u0003\u001a\u0004\bo\u0010\u0005\"\u0004\bp\u0010\u0007R$\u0010q\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010\u0003\u001a\u0004\br\u0010\u0005\"\u0004\bs\u0010\u0007R$\u0010t\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010\u0003\u001a\u0004\bu\u0010\u0005\"\u0004\bv\u0010\u0007R\"\u0010w\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010\u0003\u001a\u0004\bx\u0010\u0005\"\u0004\by\u0010\u0007¨\u0006|"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/mix/BaseItemModel;", "", "avcUrl", "Ljava/lang/String;", "getAvcUrl", "()Ljava/lang/String;", "setAvcUrl", "(Ljava/lang/String;)V", "bgCover", "getBgCover", "setBgCover", "cRoomId", "getCRoomId", "setCRoomId", "Lorg/json/JSONObject;", "commonShareInfo", "Lorg/json/JSONObject;", "getCommonShareInfo", "()Lorg/json/JSONObject;", "setCommonShareInfo", "(Lorg/json/JSONObject;)V", AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, "getCover", "setCover", "ext", "getExt", "setExt", "feedId", "getFeedId", "setFeedId", "format", "getFormat", "setFormat", "hevcUrl", "getHevcUrl", "setHevcUrl", "highlightUrl", "getHighlightUrl", "setHighlightUrl", "hlReplay", "getHlReplay", "setHlReplay", "im", "getIm", "setIm", "introduceTips", "getIntroduceTips", "setIntroduceTips", "", "isBlurBg", "Z", "()Z", "setBlurBg", "(Z)V", "kabrSpts", "getKabrSpts", "setKabrSpts", "liveType", "getLiveType", "setLiveType", "originJson", "getOriginJson", "setOriginJson", "otherParams", "getOtherParams", "setOtherParams", "Lcom/baidu/searchbox/live/interfaces/mix/BasePlaySourceInfo;", "playSource", "Lcom/baidu/searchbox/live/interfaces/mix/BasePlaySourceInfo;", "getPlaySource", "()Lcom/baidu/searchbox/live/interfaces/mix/BasePlaySourceInfo;", "setPlaySource", "(Lcom/baidu/searchbox/live/interfaces/mix/BasePlaySourceInfo;)V", "playUrl", "getPlayUrl", "setPlayUrl", "quic", "getQuic", "setQuic", "roomId", "getRoomId", "setRoomId", "rtcHevcUrl", "getRtcHevcUrl", "setRtcHevcUrl", "rtcUrl", "getRtcUrl", "setRtcUrl", "Lcom/baidu/searchbox/live/interfaces/mix/BaseRuntimeStatus;", "runtimeStatus", "Lcom/baidu/searchbox/live/interfaces/mix/BaseRuntimeStatus;", "getRuntimeStatus", "()Lcom/baidu/searchbox/live/interfaces/mix/BaseRuntimeStatus;", "setRuntimeStatus", "(Lcom/baidu/searchbox/live/interfaces/mix/BaseRuntimeStatus;)V", "scheme", "getScheme", "setScheme", "screen", "getScreen", "setScreen", "shareTaskInfo", "getShareTaskInfo", "setShareTaskInfo", "slog", "getSlog", "setSlog", "source", "getSource", "setSource", "status", "getStatus", "setStatus", MediaTrackConfig.AE_IMPORT_TEMPLATE, "getTemplate", "setTemplate", "templateId", "getTemplateId", "setTemplateId", "title", "getTitle", d.o, "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class BaseItemModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String avcUrl;
    public String bgCover;
    public String cRoomId;
    public JSONObject commonShareInfo;
    public String cover;
    public JSONObject ext;
    public String feedId;
    public String format;
    public String hevcUrl;
    public String highlightUrl;
    public JSONObject hlReplay;
    public JSONObject im;
    public JSONObject introduceTips;
    public boolean isBlurBg;
    public String kabrSpts;
    public String liveType;
    public JSONObject originJson;
    public JSONObject otherParams;
    public BasePlaySourceInfo playSource;
    public String playUrl;
    public String quic;
    public String roomId;
    public String rtcHevcUrl;
    public String rtcUrl;
    public BaseRuntimeStatus runtimeStatus;
    public String scheme;
    public String screen;
    public JSONObject shareTaskInfo;
    public JSONObject slog;
    public String source;
    public String status;
    public String template;
    public String templateId;
    public String title;

    public BaseItemModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.roomId = "";
        this.cover = "";
        this.liveType = "";
        this.scheme = "";
        this.playUrl = "";
        this.bgCover = "";
        this.title = "";
        this.cRoomId = "";
        this.slog = new JSONObject();
        BaseRuntimeStatus baseRuntimeStatus = new BaseRuntimeStatus();
        baseRuntimeStatus.setPosition(-1);
        this.runtimeStatus = baseRuntimeStatus;
        this.isBlurBg = true;
        this.source = "";
    }

    public final String getAvcUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.avcUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getBgCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bgCover;
        }
        return (String) invokeV.objValue;
    }

    public final String getCRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.cRoomId;
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject getCommonShareInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.commonShareInfo;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final String getCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.cover;
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.ext;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final String getFeedId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.feedId;
        }
        return (String) invokeV.objValue;
    }

    public final String getFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.format;
        }
        return (String) invokeV.objValue;
    }

    public final String getHevcUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.hevcUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getHighlightUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.highlightUrl;
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject getHlReplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.hlReplay;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject getIm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.im;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject getIntroduceTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.introduceTips;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final String getKabrSpts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.kabrSpts;
        }
        return (String) invokeV.objValue;
    }

    public final String getLiveType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.liveType;
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject getOriginJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.originJson;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject getOtherParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.otherParams;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final BasePlaySourceInfo getPlaySource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.playSource;
        }
        return (BasePlaySourceInfo) invokeV.objValue;
    }

    public final String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.playUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getQuic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.quic;
        }
        return (String) invokeV.objValue;
    }

    public final String getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.roomId;
        }
        return (String) invokeV.objValue;
    }

    public final String getRtcHevcUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.rtcHevcUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getRtcUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.rtcUrl;
        }
        return (String) invokeV.objValue;
    }

    public final BaseRuntimeStatus getRuntimeStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.runtimeStatus;
        }
        return (BaseRuntimeStatus) invokeV.objValue;
    }

    public final String getScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.scheme;
        }
        return (String) invokeV.objValue;
    }

    public final String getScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.screen;
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject getShareTaskInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.shareTaskInfo;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject getSlog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.slog;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.source;
        }
        return (String) invokeV.objValue;
    }

    public final String getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.status;
        }
        return (String) invokeV.objValue;
    }

    public final String getTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.template;
        }
        return (String) invokeV.objValue;
    }

    public final String getTemplateId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.templateId;
        }
        return (String) invokeV.objValue;
    }

    public final String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public final boolean isBlurBg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.isBlurBg;
        }
        return invokeV.booleanValue;
    }

    public final void setAvcUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.avcUrl = str;
        }
    }

    public final void setBgCover(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.bgCover = str;
        }
    }

    public final void setBlurBg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.isBlurBg = z;
        }
    }

    public final void setCRoomId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.cRoomId = str;
        }
    }

    public final void setCommonShareInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, jSONObject) == null) {
            this.commonShareInfo = jSONObject;
        }
    }

    public final void setCover(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.cover = str;
        }
    }

    public final void setExt(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, jSONObject) == null) {
            this.ext = jSONObject;
        }
    }

    public final void setFeedId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.feedId = str;
        }
    }

    public final void setFormat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.format = str;
        }
    }

    public final void setHevcUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.hevcUrl = str;
        }
    }

    public final void setHighlightUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.highlightUrl = str;
        }
    }

    public final void setHlReplay(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, jSONObject) == null) {
            this.hlReplay = jSONObject;
        }
    }

    public final void setIm(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, jSONObject) == null) {
            this.im = jSONObject;
        }
    }

    public final void setIntroduceTips(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, jSONObject) == null) {
            this.introduceTips = jSONObject;
        }
    }

    public final void setKabrSpts(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.kabrSpts = str;
        }
    }

    public final void setLiveType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.liveType = str;
        }
    }

    public final void setOriginJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, jSONObject) == null) {
            this.originJson = jSONObject;
        }
    }

    public final void setOtherParams(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, jSONObject) == null) {
            this.otherParams = jSONObject;
        }
    }

    public final void setPlaySource(BasePlaySourceInfo basePlaySourceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, basePlaySourceInfo) == null) {
            this.playSource = basePlaySourceInfo;
        }
    }

    public final void setPlayUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.playUrl = str;
        }
    }

    public final void setQuic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.quic = str;
        }
    }

    public final void setRoomId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.roomId = str;
        }
    }

    public final void setRtcHevcUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.rtcHevcUrl = str;
        }
    }

    public final void setRtcUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.rtcUrl = str;
        }
    }

    public final void setRuntimeStatus(BaseRuntimeStatus baseRuntimeStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, baseRuntimeStatus) == null) {
            this.runtimeStatus = baseRuntimeStatus;
        }
    }

    public final void setScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.scheme = str;
        }
    }

    public final void setScreen(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.screen = str;
        }
    }

    public final void setShareTaskInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, jSONObject) == null) {
            this.shareTaskInfo = jSONObject;
        }
    }

    public final void setSlog(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, jSONObject) == null) {
            this.slog = jSONObject;
        }
    }

    public final void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.source = str;
        }
    }

    public final void setStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.status = str;
        }
    }

    public final void setTemplate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.template = str;
        }
    }

    public final void setTemplateId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.templateId = str;
        }
    }

    public final void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            this.title = str;
        }
    }
}
