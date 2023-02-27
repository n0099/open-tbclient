package com.baidu.searchbox.live.interfaces.mix;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b'\b\u0016\u0018\u0000B\t¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R$\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u0005\"\u0004\b\u001d\u0010\u0007R$\u0010\u001e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\u0005\"\u0004\b \u0010\u0007R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\u0005\"\u0004\b*\u0010\u0007R$\u0010+\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010\u0005\"\u0004\b-\u0010\u0007R$\u0010.\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0010\u001a\u0004\b/\u0010\u0012\"\u0004\b0\u0010\u0014R$\u00101\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0010\u001a\u0004\b2\u0010\u0012\"\u0004\b3\u0010\u0014R$\u00104\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0010\u001a\u0004\b5\u0010\u0012\"\u0004\b6\u0010\u0014R\"\u00107\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b7\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0003\u001a\u0004\b=\u0010\u0005\"\u0004\b>\u0010\u0007R\"\u0010?\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0003\u001a\u0004\b@\u0010\u0005\"\u0004\bA\u0010\u0007R$\u0010B\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0010\u001a\u0004\bC\u0010\u0012\"\u0004\bD\u0010\u0014R$\u0010E\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0010\u001a\u0004\bF\u0010\u0012\"\u0004\bG\u0010\u0014R$\u0010H\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0010\u001a\u0004\bI\u0010\u0012\"\u0004\bJ\u0010\u0014R\"\u0010L\u001a\u00020K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010S\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Y\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010\u0003\u001a\u0004\bZ\u0010\u0005\"\u0004\b[\u0010\u0007R$\u0010\\\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010\u0003\u001a\u0004\b]\u0010\u0005\"\u0004\b^\u0010\u0007R\"\u0010_\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010\u0003\u001a\u0004\b`\u0010\u0005\"\u0004\ba\u0010\u0007R$\u0010b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010\u0003\u001a\u0004\bc\u0010\u0005\"\u0004\bd\u0010\u0007R$\u0010e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010\u0003\u001a\u0004\bf\u0010\u0005\"\u0004\bg\u0010\u0007R\"\u0010i\u001a\u00020h8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010o\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010\u0003\u001a\u0004\bp\u0010\u0005\"\u0004\bq\u0010\u0007R$\u0010r\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010\u0003\u001a\u0004\bs\u0010\u0005\"\u0004\bt\u0010\u0007R$\u0010u\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010\u0010\u001a\u0004\bv\u0010\u0012\"\u0004\bw\u0010\u0014R$\u0010x\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010\u0010\u001a\u0004\by\u0010\u0012\"\u0004\bz\u0010\u0014R\"\u0010{\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010\u0003\u001a\u0004\b|\u0010\u0005\"\u0004\b}\u0010\u0007R%\u0010~\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b~\u0010\u0003\u001a\u0004\b\u007f\u0010\u0005\"\u0005\b\u0080\u0001\u0010\u0007R(\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010\u0003\u001a\u0005\b\u0082\u0001\u0010\u0005\"\u0005\b\u0083\u0001\u0010\u0007R(\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010\u0003\u001a\u0005\b\u0085\u0001\u0010\u0005\"\u0005\b\u0086\u0001\u0010\u0007R&\u0010\u0087\u0001\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010\u0003\u001a\u0005\b\u0088\u0001\u0010\u0005\"\u0005\b\u0089\u0001\u0010\u0007R(\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\u0010\u001a\u0005\b\u008b\u0001\u0010\u0012\"\u0005\b\u008c\u0001\u0010\u0014¨\u0006\u008f\u0001"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/mix/BaseItemModel;", "", "avcUrl", "Ljava/lang/String;", "getAvcUrl", "()Ljava/lang/String;", "setAvcUrl", "(Ljava/lang/String;)V", "bgCover", "getBgCover", "setBgCover", "cRoomId", "getCRoomId", "setCRoomId", "Lorg/json/JSONObject;", "commonShareInfo", "Lorg/json/JSONObject;", "getCommonShareInfo", "()Lorg/json/JSONObject;", "setCommonShareInfo", "(Lorg/json/JSONObject;)V", AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, "getCover", "setCover", "ext", "getExt", "setExt", "feedId", "getFeedId", "setFeedId", "format", "getFormat", "setFormat", "", "fromIntent", "Ljava/lang/Boolean;", "getFromIntent", "()Ljava/lang/Boolean;", "setFromIntent", "(Ljava/lang/Boolean;)V", "hevcUrl", "getHevcUrl", "setHevcUrl", "highlightUrl", "getHighlightUrl", "setHighlightUrl", "hlReplay", "getHlReplay", "setHlReplay", "im", "getIm", "setIm", "introduceTips", "getIntroduceTips", "setIntroduceTips", "isBlurBg", "Z", "()Z", "setBlurBg", "(Z)V", "kabrSpts", "getKabrSpts", "setKabrSpts", "liveType", "getLiveType", "setLiveType", "multiRate", "getMultiRate", "setMultiRate", "originJson", "getOriginJson", "setOriginJson", "otherParams", "getOtherParams", "setOtherParams", "", "playRateSetting", "I", "getPlayRateSetting", "()I", "setPlayRateSetting", "(I)V", "Lcom/baidu/searchbox/live/interfaces/mix/BasePlaySourceInfo;", "playSource", "Lcom/baidu/searchbox/live/interfaces/mix/BasePlaySourceInfo;", "getPlaySource", "()Lcom/baidu/searchbox/live/interfaces/mix/BasePlaySourceInfo;", "setPlaySource", "(Lcom/baidu/searchbox/live/interfaces/mix/BasePlaySourceInfo;)V", "playUrl", "getPlayUrl", "setPlayUrl", "quic", "getQuic", "setQuic", "roomId", "getRoomId", "setRoomId", "rtcHevcUrl", "getRtcHevcUrl", "setRtcHevcUrl", "rtcUrl", "getRtcUrl", "setRtcUrl", "Lcom/baidu/searchbox/live/interfaces/mix/BaseRuntimeStatus;", "runtimeStatus", "Lcom/baidu/searchbox/live/interfaces/mix/BaseRuntimeStatus;", "getRuntimeStatus", "()Lcom/baidu/searchbox/live/interfaces/mix/BaseRuntimeStatus;", "setRuntimeStatus", "(Lcom/baidu/searchbox/live/interfaces/mix/BaseRuntimeStatus;)V", "scheme", "getScheme", "setScheme", "screen", "getScreen", "setScreen", "shareTaskInfo", "getShareTaskInfo", "setShareTaskInfo", "slog", "getSlog", "setSlog", "source", "getSource", "setSource", "status", "getStatus", "setStatus", MediaTrackConfig.AE_IMPORT_TEMPLATE, "getTemplate", "setTemplate", "templateId", "getTemplateId", "setTemplateId", "title", "getTitle", "setTitle", "vrParams", "getVrParams", "setVrParams", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class BaseItemModel {
    public String avcUrl;
    public JSONObject commonShareInfo;
    public JSONObject ext;
    public String feedId;
    public String format;
    public Boolean fromIntent;
    public String hevcUrl;
    public String highlightUrl;
    public JSONObject hlReplay;
    public JSONObject im;
    public JSONObject introduceTips;
    public boolean isBlurBg;
    public String kabrSpts;
    public JSONObject multiRate;
    public JSONObject originJson;
    public JSONObject otherParams;
    public int playRateSetting;
    public BasePlaySourceInfo playSource;
    public String quic;
    public String rtcHevcUrl;
    public String rtcUrl;
    public BaseRuntimeStatus runtimeStatus;
    public String screen;
    public JSONObject shareTaskInfo;
    public String source;
    public String status;
    public String template;
    public String templateId;
    public JSONObject vrParams;
    public String roomId = "";
    public String cover = "";
    public String liveType = "";
    public String scheme = "";
    public String playUrl = "";
    public String bgCover = "";
    public String title = "";
    public String cRoomId = "";
    public JSONObject slog = new JSONObject();

    public BaseItemModel() {
        BaseRuntimeStatus baseRuntimeStatus = new BaseRuntimeStatus();
        baseRuntimeStatus.setPosition(-1);
        this.runtimeStatus = baseRuntimeStatus;
        this.isBlurBg = true;
        this.source = "";
    }

    public final String getAvcUrl() {
        return this.avcUrl;
    }

    public final String getBgCover() {
        return this.bgCover;
    }

    public final String getCRoomId() {
        return this.cRoomId;
    }

    public final JSONObject getCommonShareInfo() {
        return this.commonShareInfo;
    }

    public final String getCover() {
        return this.cover;
    }

    public final JSONObject getExt() {
        return this.ext;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final String getFormat() {
        return this.format;
    }

    public final Boolean getFromIntent() {
        return this.fromIntent;
    }

    public final String getHevcUrl() {
        return this.hevcUrl;
    }

    public final String getHighlightUrl() {
        return this.highlightUrl;
    }

    public final JSONObject getHlReplay() {
        return this.hlReplay;
    }

    public final JSONObject getIm() {
        return this.im;
    }

    public final JSONObject getIntroduceTips() {
        return this.introduceTips;
    }

    public final String getKabrSpts() {
        return this.kabrSpts;
    }

    public final String getLiveType() {
        return this.liveType;
    }

    public final JSONObject getMultiRate() {
        return this.multiRate;
    }

    public final JSONObject getOriginJson() {
        return this.originJson;
    }

    public final JSONObject getOtherParams() {
        return this.otherParams;
    }

    public final int getPlayRateSetting() {
        return this.playRateSetting;
    }

    public final BasePlaySourceInfo getPlaySource() {
        return this.playSource;
    }

    public final String getPlayUrl() {
        return this.playUrl;
    }

    public final String getQuic() {
        return this.quic;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getRtcHevcUrl() {
        return this.rtcHevcUrl;
    }

    public final String getRtcUrl() {
        return this.rtcUrl;
    }

    public final BaseRuntimeStatus getRuntimeStatus() {
        return this.runtimeStatus;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final String getScreen() {
        return this.screen;
    }

    public final JSONObject getShareTaskInfo() {
        return this.shareTaskInfo;
    }

    public final JSONObject getSlog() {
        return this.slog;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final JSONObject getVrParams() {
        return this.vrParams;
    }

    public final boolean isBlurBg() {
        return this.isBlurBg;
    }

    public final void setAvcUrl(String str) {
        this.avcUrl = str;
    }

    public final void setBgCover(String str) {
        this.bgCover = str;
    }

    public final void setBlurBg(boolean z) {
        this.isBlurBg = z;
    }

    public final void setCRoomId(String str) {
        this.cRoomId = str;
    }

    public final void setCommonShareInfo(JSONObject jSONObject) {
        this.commonShareInfo = jSONObject;
    }

    public final void setCover(String str) {
        this.cover = str;
    }

    public final void setExt(JSONObject jSONObject) {
        this.ext = jSONObject;
    }

    public final void setFeedId(String str) {
        this.feedId = str;
    }

    public final void setFormat(String str) {
        this.format = str;
    }

    public final void setFromIntent(Boolean bool) {
        this.fromIntent = bool;
    }

    public final void setHevcUrl(String str) {
        this.hevcUrl = str;
    }

    public final void setHighlightUrl(String str) {
        this.highlightUrl = str;
    }

    public final void setHlReplay(JSONObject jSONObject) {
        this.hlReplay = jSONObject;
    }

    public final void setIm(JSONObject jSONObject) {
        this.im = jSONObject;
    }

    public final void setIntroduceTips(JSONObject jSONObject) {
        this.introduceTips = jSONObject;
    }

    public final void setKabrSpts(String str) {
        this.kabrSpts = str;
    }

    public final void setLiveType(String str) {
        this.liveType = str;
    }

    public final void setMultiRate(JSONObject jSONObject) {
        this.multiRate = jSONObject;
    }

    public final void setOriginJson(JSONObject jSONObject) {
        this.originJson = jSONObject;
    }

    public final void setOtherParams(JSONObject jSONObject) {
        this.otherParams = jSONObject;
    }

    public final void setPlayRateSetting(int i) {
        this.playRateSetting = i;
    }

    public final void setPlaySource(BasePlaySourceInfo basePlaySourceInfo) {
        this.playSource = basePlaySourceInfo;
    }

    public final void setPlayUrl(String str) {
        this.playUrl = str;
    }

    public final void setQuic(String str) {
        this.quic = str;
    }

    public final void setRoomId(String str) {
        this.roomId = str;
    }

    public final void setRtcHevcUrl(String str) {
        this.rtcHevcUrl = str;
    }

    public final void setRtcUrl(String str) {
        this.rtcUrl = str;
    }

    public final void setRuntimeStatus(BaseRuntimeStatus baseRuntimeStatus) {
        this.runtimeStatus = baseRuntimeStatus;
    }

    public final void setScheme(String str) {
        this.scheme = str;
    }

    public final void setScreen(String str) {
        this.screen = str;
    }

    public final void setShareTaskInfo(JSONObject jSONObject) {
        this.shareTaskInfo = jSONObject;
    }

    public final void setSlog(JSONObject jSONObject) {
        this.slog = jSONObject;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final void setTemplate(String str) {
        this.template = str;
    }

    public final void setTemplateId(String str) {
        this.templateId = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setVrParams(JSONObject jSONObject) {
        this.vrParams = jSONObject;
    }
}
