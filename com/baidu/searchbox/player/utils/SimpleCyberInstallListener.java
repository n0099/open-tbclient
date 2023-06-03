package com.baidu.searchbox.player.utils;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/player/utils/SimpleCyberInstallListener;", "Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$InstallListener2;", "()V", "onInstallError", "", "installType", "", "errorType", "detail", "", "onInstallInfo", "p0", ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "p2", "", "onInstallProgress", "progress", "onInstallSuccess", "coreVer", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class SimpleCyberInstallListener implements CyberPlayerManager.InstallListener2 {
    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
    public void onInstallError(int i, int i2, String str) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
    public void onInstallInfo(int i, int i2, Object obj) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
    public void onInstallProgress(int i, int i2) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
    public void onInstallSuccess(int i, String str) {
    }
}
