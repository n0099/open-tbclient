package com.baidu.searchbox.player.utils;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.remote.BDRemotePlayerService;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"installCyber", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$InstallListener;", "useRemote", "", "installType", "", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "DumediaInstallUtils")
/* loaded from: classes4.dex */
public final class DumediaInstallUtils {
    @JvmOverloads
    public static final void installCyber(CyberPlayerManager.InstallListener installListener) {
        installCyber$default(installListener, false, 0, 6, null);
    }

    @JvmOverloads
    public static final void installCyber(CyberPlayerManager.InstallListener installListener, boolean z) {
        installCyber$default(installListener, z, 0, 4, null);
    }

    @JvmOverloads
    public static final void installCyber(CyberPlayerManager.InstallListener installListener, boolean z, int i) {
        Class<BDRemotePlayerService> cls;
        if (CyberPlayerManager.isCoreLoaded(i)) {
            if (installListener != null) {
                installListener.onInstallSuccess(i, "");
                return;
            }
            return;
        }
        if (z) {
            cls = BDRemotePlayerService.class;
        } else {
            cls = null;
        }
        CyberPlayerManager.install(BDPlayerConfig.getAppContext(), i, cls, installListener);
    }

    public static /* synthetic */ void installCyber$default(CyberPlayerManager.InstallListener installListener, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            i = 23;
        }
        installCyber(installListener, z, i);
    }
}
