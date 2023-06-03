package com.baidu.searchbox.player.utils;

import androidx.transition.Transition;
import com.baidu.searchbox.player.model.ClaritySelectModel;
import com.baidu.searchbox.player.model.ClarityUrlList;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\"\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/player/utils/ClarityDependManager;", "", "()V", "provider", "Lcom/baidu/searchbox/player/utils/IClarityDependProvider;", "getDeviceScore", "", "getMultiRateSwitchEnable", "", "getShortVideoVideoClarityStrategy", "Lcom/baidu/searchbox/player/model/ClaritySelectModel;", "list", "Lcom/baidu/searchbox/player/model/ClarityUrlList;", "sdClarityScore", "", BasicVideoParserKt.PREFERRED_CLARITY_RANK, "", "setProvider", "", "Companion", "Helper", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClarityDependManager {
    public static final Companion Companion = new Companion(null);
    public IClarityDependProvider provider;

    public /* synthetic */ ClarityDependManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final ClarityDependManager get() {
        return Companion.get();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/player/utils/ClarityDependManager$Companion;", "", "()V", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "Lcom/baidu/searchbox/player/utils/ClarityDependManager;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }

        @JvmStatic
        public final ClarityDependManager get() {
            return Helper.INSTANCE.getInstance();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/player/utils/ClarityDependManager$Helper;", "", "()V", Transition.MATCH_INSTANCE_STR, "Lcom/baidu/searchbox/player/utils/ClarityDependManager;", "getInstance", "()Lcom/baidu/searchbox/player/utils/ClarityDependManager;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Helper {
        public static final Helper INSTANCE = new Helper();
        public static final ClarityDependManager instance = new ClarityDependManager(null);

        public final ClarityDependManager getInstance() {
            return instance;
        }
    }

    public ClarityDependManager() {
    }

    public final String getDeviceScore() {
        String deviceStaticScore;
        IClarityDependProvider iClarityDependProvider = this.provider;
        if (iClarityDependProvider == null || (deviceStaticScore = iClarityDependProvider.getDeviceStaticScore()) == null) {
            return "";
        }
        return deviceStaticScore;
    }

    public final boolean getMultiRateSwitchEnable() {
        IClarityDependProvider iClarityDependProvider = this.provider;
        if (iClarityDependProvider != null) {
            return iClarityDependProvider.getMultiRateSwitchEnable();
        }
        return false;
    }

    public final ClaritySelectModel getShortVideoVideoClarityStrategy(ClarityUrlList clarityUrlList, double d, int i) {
        IClarityDependProvider iClarityDependProvider = this.provider;
        if (iClarityDependProvider != null) {
            return iClarityDependProvider.getShortVideoVideoClarityStrategy(clarityUrlList, d, i);
        }
        return null;
    }

    public final void setProvider(IClarityDependProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.provider = provider;
    }
}
