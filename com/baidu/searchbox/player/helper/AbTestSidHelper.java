package com.baidu.searchbox.player.helper;

import androidx.transition.Transition;
import com.baidu.searchbox.player.interfaces.IAbTestSidProvider;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/player/helper/AbTestSidHelper;", "", "()V", "abTestSidProvider", "Lcom/baidu/searchbox/player/interfaces/IAbTestSidProvider;", "getSidsFromTids", "Ljava/util/ArrayList;", "", "tids", "", "setAbTestProvider", "", "provider", "Companion", "Helper", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AbTestSidHelper {
    public static final Companion Companion = new Companion(null);
    public IAbTestSidProvider abTestSidProvider;

    public /* synthetic */ AbTestSidHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final AbTestSidHelper get() {
        return Companion.get();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/player/helper/AbTestSidHelper$Companion;", "", "()V", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "Lcom/baidu/searchbox/player/helper/AbTestSidHelper;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }

        @JvmStatic
        public final AbTestSidHelper get() {
            return Helper.INSTANCE.getInstance();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/player/helper/AbTestSidHelper$Helper;", "", "()V", Transition.MATCH_INSTANCE_STR, "Lcom/baidu/searchbox/player/helper/AbTestSidHelper;", "getInstance", "()Lcom/baidu/searchbox/player/helper/AbTestSidHelper;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Helper {
        public static final Helper INSTANCE = new Helper();
        public static final AbTestSidHelper instance = new AbTestSidHelper(null);

        public final AbTestSidHelper getInstance() {
            return instance;
        }
    }

    public AbTestSidHelper() {
    }

    public final ArrayList<String> getSidsFromTids(ArrayList<Integer> tids) {
        Intrinsics.checkNotNullParameter(tids, "tids");
        IAbTestSidProvider iAbTestSidProvider = this.abTestSidProvider;
        if (iAbTestSidProvider != null) {
            return iAbTestSidProvider.getSidsFromTids(tids);
        }
        return null;
    }

    public final void setAbTestProvider(IAbTestSidProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.abTestSidProvider = provider;
    }
}
