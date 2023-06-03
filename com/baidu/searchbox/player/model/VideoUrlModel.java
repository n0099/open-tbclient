package com.baidu.searchbox.player.model;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ&\u0010\"\u001a\u0002H#\"\u0006\b\u0000\u0010#\u0018\u00012\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u0002H#H\u0086\b¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010(J\u0018\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001J\u001c\u0010,\u001a\u00020*2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010(J\b\u0010.\u001a\u00020\u0003H\u0016R\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0012\"\u0004\b\u0015\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019¨\u0006/"}, d2 = {"Lcom/baidu/searchbox/player/model/VideoUrlModel;", "", "vid", "", "videoUrl", "isNeedPrepare", "", "playerStageType", "", "kLogId", "isOnlyCompareUriPath", "(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Z)V", "extBundle", "Lcom/baidu/searchbox/player/model/StringArrayBundle;", "getExtBundle", "()Lcom/baidu/searchbox/player/model/StringArrayBundle;", "extBundle$delegate", "Lkotlin/Lazy;", "()Z", "setNeedPrepare", "(Z)V", "setOnlyCompareUriPath", "getKLogId", "()Ljava/lang/String;", "setKLogId", "(Ljava/lang/String;)V", "getPlayerStageType", "()I", "setPlayerStageType", "(I)V", "getVid", "setVid", "getVideoUrl", "setVideoUrl", "getOption", ExifInterface.GPS_DIRECTION_TRUE, "key", "default", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getOptions", "", "setOption", "", "value", "setOptions", "optionList", "toString", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class VideoUrlModel {
    public final Lazy extBundle$delegate;
    public boolean isNeedPrepare;
    public boolean isOnlyCompareUriPath;
    public String kLogId;
    public int playerStageType;
    public String vid;
    public String videoUrl;

    public VideoUrlModel() {
        this(null, null, false, 0, null, false, 63, null);
    }

    public VideoUrlModel(String str, String str2, boolean z, int i, String kLogId, boolean z2) {
        Intrinsics.checkNotNullParameter(kLogId, "kLogId");
        this.vid = str;
        this.videoUrl = str2;
        this.isNeedPrepare = z;
        this.playerStageType = i;
        this.kLogId = kLogId;
        this.isOnlyCompareUriPath = z2;
        this.extBundle$delegate = LazyKt__LazyJVMKt.lazy(new Function0<StringArrayBundle>() { // from class: com.baidu.searchbox.player.model.VideoUrlModel$extBundle$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final StringArrayBundle invoke() {
                return new StringArrayBundle(0, 1, null);
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ VideoUrlModel(String str, String str2, boolean z, int i, String str3, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(r12, r0, r1, r2, r3, r11);
        String str4;
        boolean z3;
        int i3;
        boolean z4;
        if ((i2 & 1) != 0) {
            str4 = null;
        } else {
            str4 = str;
        }
        String str5 = (i2 & 2) == 0 ? str2 : null;
        if ((i2 & 4) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i2 & 8) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        String str6 = (i2 & 16) != 0 ? "" : str3;
        if ((i2 & 32) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
    }

    public final StringArrayBundle getExtBundle() {
        return (StringArrayBundle) this.extBundle$delegate.getValue();
    }

    public final String getKLogId() {
        return this.kLogId;
    }

    public final Map<String, String> getOptions() {
        Object obj = getExtBundle().get(VideoUrlModelKt.KEY_OPTION_LIST);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int getPlayerStageType() {
        return this.playerStageType;
    }

    public final String getVid() {
        return this.vid;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final boolean isNeedPrepare() {
        return this.isNeedPrepare;
    }

    public final boolean isOnlyCompareUriPath() {
        return this.isOnlyCompareUriPath;
    }

    public String toString() {
        return "VideoUrlModel{videoUrl=" + this.videoUrl + ", isNeedPrepare=" + this.isNeedPrepare + ", playerStageType=" + this.playerStageType + " }";
    }

    public final /* synthetic */ <T> T getOption(String key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t2 = (T) getExtBundle().get((Object) key);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (t2 instanceof Object) {
            return t2;
        }
        return t;
    }

    public final void setOption(String key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        getExtBundle().putExtra(key, obj);
    }

    public final void setKLogId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.kLogId = str;
    }

    public final void setNeedPrepare(boolean z) {
        this.isNeedPrepare = z;
    }

    public final void setOnlyCompareUriPath(boolean z) {
        this.isOnlyCompareUriPath = z;
    }

    public final void setOptions(Map<String, String> map) {
        if (map == null) {
            return;
        }
        getExtBundle().putExtra(VideoUrlModelKt.KEY_OPTION_LIST, map);
    }

    public final void setPlayerStageType(int i) {
        this.playerStageType = i;
    }

    public final void setVid(String str) {
        this.vid = str;
    }

    public final void setVideoUrl(String str) {
        this.videoUrl = str;
    }
}
