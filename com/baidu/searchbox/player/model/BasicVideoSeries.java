package com.baidu.searchbox.player.model;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.model.ClarityUrlList;
import com.baidu.searchbox.player.ubc.PlayerStatConstants;
import com.baidu.searchbox.player.utils.BasicVideoParserKt;
import com.baidu.searchbox.player.utils.ClarityDependManager;
import com.baidu.searchbox.player.utils.VideoSceneModelCreator;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010H\u001a\u0002HI\"\u0006\b\u0000\u0010I\u0018\u00012\u0006\u0010J\u001a\u00020\u00102\u0006\u0010K\u001a\u0002HIH\u0086\n¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020\nH\u0016J\u0006\u0010N\u001a\u00020\nJ\b\u0010O\u001a\u00020\u0010H\u0016J\b\u0010P\u001a\u00020\nH\u0016J\u0006\u0010Q\u001a\u00020\nJ\u0006\u0010R\u001a\u00020\nJ\u0006\u0010S\u001a\u00020\nJ\b\u0010T\u001a\u00020%H\u0016J\b\u0010U\u001a\u00020%H\u0016J\b\u0010V\u001a\u00020%H\u0016J\u0006\u0010W\u001a\u00020%J\u001b\u0010X\u001a\u00020Y2\u0006\u0010J\u001a\u00020\u00102\b\u0010Z\u001a\u0004\u0018\u00010\u0001H\u0086\u0002J\u0010\u0010[\u001a\u00020Y2\b\u0010\\\u001a\u0004\u0018\u00010\u0010J\u0010\u0010[\u001a\u00020Y2\b\u0010\\\u001a\u0004\u0018\u00010]J\u0010\u0010^\u001a\u00020Y2\u0006\u0010_\u001a\u00020\nH\u0016J\u0010\u0010`\u001a\u00020Y2\u0006\u0010a\u001a\u00020\nH\u0016J\u0010\u0010b\u001a\u00020Y2\b\u0010c\u001a\u0004\u0018\u00010\u0010J\u0018\u0010d\u001a\u00020Y2\b\u0010\\\u001a\u0004\u0018\u00010\u00102\u0006\u0010e\u001a\u00020%J\u0016\u0010d\u001a\u00020Y2\u0006\u0010\\\u001a\u00020]2\u0006\u0010e\u001a\u00020%R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014R\u001a\u0010,\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0012\"\u0004\b.\u0010\u0014R\u001a\u0010/\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\f\"\u0004\b1\u0010\u000eR\u001a\u00102\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\f\"\u0004\b4\u0010\u000eR\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\f\"\u0004\b=\u0010\u000eR\u001c\u0010>\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0012\"\u0004\b@\u0010\u0014R\u001a\u0010A\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0012\"\u0004\bC\u0010\u0014R\u001a\u0010D\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0012\"\u0004\bF\u0010\u0014R\u000e\u0010G\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "", "()V", "clarityList", "Lcom/baidu/searchbox/player/model/ClarityUrlList;", "getClarityList", "()Lcom/baidu/searchbox/player/model/ClarityUrlList;", "setClarityList", "(Lcom/baidu/searchbox/player/model/ClarityUrlList;)V", "durationMs", "", "getDurationMs", "()I", "setDurationMs", "(I)V", "encodedUrl", "", "getEncodedUrl", "()Ljava/lang/String;", "setEncodedUrl", "(Ljava/lang/String;)V", "ext", "getExt", "setExt", "extLog", "getExtLog", "setExtLog", "extMap", "Lcom/baidu/searchbox/player/model/StringArrayBundle;", "getExtMap", "()Lcom/baidu/searchbox/player/model/StringArrayBundle;", "extMap$delegate", "Lkotlin/Lazy;", "from", "getFrom", "setFrom", "isNeedPrepare", "", "()Z", "setNeedPrepare", "(Z)V", PlayerStatConstants.STAT_KEY_KERNEL_TYPE, "getKernelType", "setKernelType", "page", "getPage", "setPage", "playerStageType", "getPlayerStageType", "setPlayerStageType", "positionMs", "getPositionMs", "setPositionMs", "preRenderOptionState", "Lcom/baidu/searchbox/player/model/OptionState;", "getPreRenderOptionState", "()Lcom/baidu/searchbox/player/model/OptionState;", "setPreRenderOptionState", "(Lcom/baidu/searchbox/player/model/OptionState;)V", BasicVideoParserKt.PREFERRED_CLARITY_RANK, "getPreferredClarityRank", "setPreferredClarityRank", BasicVideoParserKt.RESOURCE_TYPE, "getResourceType", "setResourceType", "source", "getSource", "setSource", "vid", "getVid", "setVid", "videoUrl", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, ExifInterface.GPS_DIRECTION_TRUE, "key", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getDuration", "getMoovSize", "getPlayUrl", "getPosition", "getVideoBps", "getVideoHeight", "getVideoWidth", "isFullScreenType", "isHDRVideo", "isInteractVideo", "isValid", "set", "", "value", "setClarityUrlList", BasicVideoParserKt.CLARITY, "Lorg/json/JSONArray;", "setDuration", "duration", "setPosition", CriusAttrConstants.POSITION, "setVideoUrl", "url", "updateClarityUrlList", "keepingSelection", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class BasicVideoSeries {
    public int durationMs;
    public boolean isNeedPrepare;
    public String kernelType;
    public int positionMs;
    public String vid = "";
    public String from = "";
    public String page = "";
    public String source = "";
    public String resourceType = "";
    public String videoUrl = "";
    public String encodedUrl = "";
    public String ext = "";
    public String extLog = "";
    public int playerStageType = -1;
    public ClarityUrlList clarityList = new ClarityUrlList();
    public int preferredClarityRank = -1;
    public OptionState preRenderOptionState = OptionState.UNSPECIFIED;
    public final Lazy extMap$delegate = LazyKt__LazyJVMKt.lazy(new Function0<StringArrayBundle>() { // from class: com.baidu.searchbox.player.model.BasicVideoSeries$extMap$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StringArrayBundle invoke() {
            return new StringArrayBundle(0, 1, null);
        }
    });

    public boolean isFullScreenType() {
        return false;
    }

    public boolean isInteractVideo() {
        return false;
    }

    public final ClarityUrlList getClarityList() {
        return this.clarityList;
    }

    public int getDuration() {
        return this.durationMs / 1000;
    }

    public final int getDurationMs() {
        return this.durationMs;
    }

    public final String getEncodedUrl() {
        return this.encodedUrl;
    }

    public final String getExt() {
        return this.ext;
    }

    public String getExtLog() {
        return this.extLog;
    }

    public final StringArrayBundle getExtMap() {
        return (StringArrayBundle) this.extMap$delegate.getValue();
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getKernelType() {
        return this.kernelType;
    }

    public final int getMoovSize() {
        ClarityUrlList.ClarityUrl currentClarityUrl = this.clarityList.getCurrentClarityUrl();
        if (currentClarityUrl != null) {
            return currentClarityUrl.getMoovSize();
        }
        return 0;
    }

    public final String getPage() {
        return this.page;
    }

    public String getPlayUrl() {
        if (this.clarityList.size() > 0) {
            String defaultUrl = this.clarityList.getDefaultUrl();
            Intrinsics.checkNotNullExpressionValue(defaultUrl, "clarityList.defaultUrl");
            return defaultUrl;
        }
        return this.videoUrl;
    }

    public final int getPlayerStageType() {
        return this.playerStageType;
    }

    public int getPosition() {
        return this.positionMs / 1000;
    }

    public final int getPositionMs() {
        return this.positionMs;
    }

    public final OptionState getPreRenderOptionState() {
        return this.preRenderOptionState;
    }

    public final int getPreferredClarityRank() {
        return this.preferredClarityRank;
    }

    public final String getResourceType() {
        return this.resourceType;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getVid() {
        return this.vid;
    }

    public final int getVideoBps() {
        ClarityUrlList.ClarityUrl currentClarityUrl = this.clarityList.getCurrentClarityUrl();
        if (currentClarityUrl != null) {
            return currentClarityUrl.getVideoBps();
        }
        return 0;
    }

    public final int getVideoHeight() {
        ClarityUrlList.ClarityUrl currentClarityUrl = this.clarityList.getCurrentClarityUrl();
        if (currentClarityUrl != null) {
            return currentClarityUrl.getHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        ClarityUrlList.ClarityUrl currentClarityUrl = this.clarityList.getCurrentClarityUrl();
        if (currentClarityUrl != null) {
            return currentClarityUrl.getWidth();
        }
        return 0;
    }

    public boolean isHDRVideo() {
        ClarityUrlList.ClarityUrl currentClarityUrl = this.clarityList.getCurrentClarityUrl();
        if (currentClarityUrl != null) {
            return currentClarityUrl.isHDR();
        }
        return false;
    }

    public final boolean isNeedPrepare() {
        return this.isNeedPrepare;
    }

    public final boolean isValid() {
        if (getPlayUrl().length() > 0) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ <T> T get(String key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t2 = (T) getExtMap().get((Object) key);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (t2 instanceof Object) {
            return t2;
        }
        return t;
    }

    public final void set(String key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        getExtMap().putExtra(key, obj);
    }

    public final void updateClarityUrlList(JSONArray clarityUrl, boolean z) {
        Intrinsics.checkNotNullParameter(clarityUrl, "clarityUrl");
        updateClarityUrlList(clarityUrl.toString(), z);
    }

    public final void setClarityList(ClarityUrlList clarityUrlList) {
        Intrinsics.checkNotNullParameter(clarityUrlList, "<set-?>");
        this.clarityList = clarityUrlList;
    }

    public final void setClarityUrlList(String str) {
        try {
            setClarityUrlList(new JSONArray(str));
        } catch (JSONException e) {
            if (BDPlayerConfig.isDebug()) {
                e.printStackTrace();
            }
            this.clarityList = new ClarityUrlList();
        }
    }

    public void setDuration(int i) {
        this.durationMs = i * 1000;
    }

    public final void setDurationMs(int i) {
        this.durationMs = i;
    }

    public final void setEncodedUrl(String str) {
        this.encodedUrl = str;
    }

    public final void setExt(String str) {
        this.ext = str;
    }

    public void setExtLog(String str) {
        this.extLog = str;
    }

    public final void setFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.from = str;
    }

    public final void setKernelType(String str) {
        this.kernelType = str;
    }

    public final void setNeedPrepare(boolean z) {
        this.isNeedPrepare = z;
    }

    public final void setPage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.page = str;
    }

    public final void setPlayerStageType(int i) {
        this.playerStageType = i;
    }

    public void setPosition(int i) {
        this.positionMs = i * 1000;
    }

    public final void setPositionMs(int i) {
        this.positionMs = i;
    }

    public final void setPreRenderOptionState(OptionState optionState) {
        Intrinsics.checkNotNullParameter(optionState, "<set-?>");
        this.preRenderOptionState = optionState;
    }

    public final void setPreferredClarityRank(int i) {
        this.preferredClarityRank = i;
    }

    public final void setResourceType(String str) {
        this.resourceType = str;
    }

    public final void setSource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.source = str;
    }

    public final void setVid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vid = str;
    }

    public final void setVideoUrl(String str) {
        if (str == null) {
            str = "";
        }
        this.videoUrl = str;
    }

    public final void setClarityUrlList(JSONArray jSONArray) {
        this.clarityList = new ClarityUrlList(jSONArray, isFullScreenType(), VideoSceneModelCreator.toSceneModel(this), this.clarityList.getClarityStrategyModel());
    }

    public final void updateClarityUrlList(String str, boolean z) {
        ClarityUrlList clarityUrlList = this.clarityList;
        try {
            setClarityUrlList(new JSONArray(str));
        } catch (JSONException e) {
            e.printStackTrace();
            this.clarityList = new ClarityUrlList();
        }
        int i = this.preferredClarityRank;
        int i2 = -1;
        if (i != -1) {
            this.clarityList.setPreferredClarityRank(i);
        }
        if (z && clarityUrlList.size() > 0) {
            ClarityUrlList.ClarityUrl currentClarityUrl = clarityUrlList.getCurrentClarityUrl();
            if (currentClarityUrl != null) {
                i2 = currentClarityUrl.getOriginRank();
            }
            ClarityUrlList.ClarityUrl clarityByOriginRank = this.clarityList.getClarityByOriginRank(i2);
            if (clarityByOriginRank != null) {
                this.clarityList.setCurrentClarityUrl(clarityByOriginRank);
                if (ClarityDependManager.Companion.get().getMultiRateSwitchEnable()) {
                    this.clarityList.setMultiRateSwitchRank(clarityByOriginRank.getRank());
                    return;
                }
                return;
            }
            this.clarityList.updateCurrentClarityToLowest();
        }
    }
}
