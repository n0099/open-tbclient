package com.baidu.searchbox.player.kernel;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.constants.PlayerStatus;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class AbsVideoCyber extends AbsVideoKernel {
    public CyberPlayer mPlayer;

    public AbsVideoCyber() {
        initPlayer();
    }

    private void setCyberPlayerCallBack(IKernelPlayer iKernelPlayer) {
        this.mPlayer.setOnCompletionListener(iKernelPlayer);
        this.mPlayer.setOnErrorListener(iKernelPlayer);
        this.mPlayer.setOnInfoListener(iKernelPlayer);
        this.mPlayer.setOnSeekCompleteListener(iKernelPlayer);
        this.mPlayer.setOnPreparedListener(iKernelPlayer);
        this.mPlayer.setOnBufferingUpdateListener(iKernelPlayer);
        this.mPlayer.setOnVideoSizeChangedListener(iKernelPlayer);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getBufferingPosition() {
        return this.mBufferingPosition;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDuration() {
        return this.mPlayer.getDuration() / 1000;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDurationMs() {
        return this.mPlayer.getDuration();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPlayedTime() {
        return (int) this.mPlayer.getPlayedTime();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPosition() {
        if (this.mKernelStatus.isIdle() && getDurationMs() - this.mPlayer.getCurrentPosition() <= 2) {
            return getDuration();
        }
        return this.mPlayer.getCurrentPosition() / 1000;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPositionMs() {
        if (this.mKernelStatus.isIdle() && getDuration() - this.mPlayer.getCurrentPosition() <= 2) {
            return getDurationMs();
        }
        CyberPlayer cyberPlayer = this.mPlayer;
        if (cyberPlayer != null) {
            return cyberPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getSyncPositionMs() {
        CyberPlayer cyberPlayer = this.mPlayer;
        if (cyberPlayer != null) {
            return cyberPlayer.getCurrentPositionSync();
        }
        return 0;
    }

    public void initPlayer() {
        CyberPlayer cyberPlayer = this.mPlayer;
        if (cyberPlayer == null) {
            this.mPlayer = new CyberPlayer(1);
        } else {
            cyberPlayer.reset();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void mute(boolean z) {
        this.mPlayer.muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        super.onRelease();
        stop();
        setCyberPlayerCallBack(null);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void pause() {
        if (this.mKernelStatus.isPrepared()) {
            this.mKernelStatus.stateChangeNotify(PlayerStatus.PAUSE);
            this.mPlayer.pause();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void prepare() {
        super.prepare();
        this.mKernelStatus.stateChangeNotify(PlayerStatus.PREPARING);
        this.mPlayer.setDataSource(BDPlayerConfig.getAppContext(), Uri.parse(this.mVideoUrl), this.mHeader);
        this.mPlayer.prepareAsync();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void resume() {
        super.resume();
        if (this.mKernelStatus.isPrepared()) {
            this.mKernelStatus.stateChangeNotify(PlayerStatus.PLAYING);
            this.mPlayer.start();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void seekTo(int i2) {
        this.mPlayer.seekTo(i2);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDecodeMode(int i2) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setExternalInfo(String str, Object obj) {
        this.mPlayer.setExternalInfo(str, obj);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setHttpDns(@NonNull CyberPlayerManager.HttpDNS httpDNS) {
        super.setHttpDns(httpDNS);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        super.setKernelCallBack(iKernelPlayer);
        setCyberPlayerCallBack(iKernelPlayer);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setOption(String str, String str2) {
        this.mPlayer.setOption(str, str2);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setProxy(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mPlayer.setOption(CyberPlayerManager.OPT_HTTP_PROXY, str);
            this.mPlayer.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            return;
        }
        this.mPlayer.setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
        this.mPlayer.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setSpeed(float f2) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoRotation(int i2) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoScalingMode(int i2) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void start() {
        super.start();
        this.mKernelStatus.stateChangeNotify(PlayerStatus.PLAYING);
        this.mPlayer.start();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void stop() {
        super.stop();
        this.mPercent = 0;
        this.mSpeed = 0;
        this.mKernelStatus.stateChangeNotify(PlayerStatus.STOP);
        this.mPlayer.stop();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2) {
        return false;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void updateFreeProxy(@Nullable String str) {
        if (str != null) {
            this.mPlayer.changeProxyDynamic(str, true);
        } else {
            this.mPlayer.changeProxyDynamic(null, false);
        }
    }
}
