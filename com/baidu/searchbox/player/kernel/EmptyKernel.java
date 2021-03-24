package com.baidu.searchbox.player.kernel;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class EmptyKernel extends AbsVideoKernel {
    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void changePlayUrl(@NonNull String str) {
        BdVideoLog.e("player has released, cannot call changePlayUrl!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    public View getBVideoView() {
        BdVideoLog.e("player has released, cannot call getBVideoView!!!");
        return new FrameLayout(BDPlayerConfig.getAppContext());
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getBufferingPosition() {
        BdVideoLog.e("player has released, cannot call getBufferingPosition!!!");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDuration() {
        BdVideoLog.e("player has released, cannot call getDuration!!!");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDurationMs() {
        BdVideoLog.e("player has released, cannot call getDurationMs!!!");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPlayedTime() {
        BdVideoLog.e("player has released, cannot call getPlayedTime!!!");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPosition() {
        BdVideoLog.e("player has released, cannot call getPosition!!!");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPositionMs() {
        BdVideoLog.e("player has released, cannot call getPositionMs!!!");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getSyncPositionMs() {
        BdVideoLog.e("player has released, cannot call getSyncPositionMs!!!");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoHeight() {
        BdVideoLog.e("player has released, cannot call getVideoHeight!!!");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoWidth() {
        BdVideoLog.e("player has released, cannot call getVideoWidth!!!");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void mute(boolean z) {
        BdVideoLog.e("player has released, cannot call mute!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onComplete() {
        BdVideoLog.e("player has released, cannot call onComplete!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onError() {
        BdVideoLog.e("player has released, cannot call onError!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onInfo(int i, int i2, Object obj) {
        BdVideoLog.e("player has released, cannot call onInfo!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onPrepared() {
        BdVideoLog.e("player has released, cannot call onPrepared!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void play(@NonNull String str) {
        BdVideoLog.e("player has released, cannot call play!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void seekTo(int i) {
        BdVideoLog.e("player has released, cannot call seekTo!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDecodeMode(int i) {
        BdVideoLog.e("player has released, cannot call setDecodeMode!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setExternalInfo(String str, Object obj) {
        BdVideoLog.e("player has released, cannot call setExternalInfo!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setHttpHeader(@Nullable HashMap<String, String> hashMap) {
        BdVideoLog.e("player has released, cannot call setHttpHeader!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        BdVideoLog.e("player has released, cannot call setKernelCallBack!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setLooping(boolean z) {
        BdVideoLog.e("player has released, cannot call setLooping!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setOption(String str, String str2) {
        BdVideoLog.e("player has released, cannot call setOption!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setPageUrl(String str) {
        BdVideoLog.e("player has released, cannot call setPageUrl!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setProxy(@Nullable String str) {
        BdVideoLog.e("player has released, cannot call setProxy!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setSpeed(float f2) {
        BdVideoLog.e("player has released, cannot call setSpeed!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setUserAgent(String str) {
        BdVideoLog.e("player has released, cannot call setUserAgent!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
        BdVideoLog.e("player has released, cannot call setVideoFormatOptions!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoRotation(int i) {
        BdVideoLog.e("player has released, cannot call setVideoRotation!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoScalingMode(int i) {
        BdVideoLog.e("player has released, cannot call setVideoScalingMode!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoSession(@NonNull VideoSession videoSession) {
        BdVideoLog.e("player has released, cannot call setVideoSession!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoUrl(String str) {
        BdVideoLog.e("player has released, cannot call setVideoUrl!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void start() {
        BdVideoLog.e("player has released, cannot call start!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2) {
        return false;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void updateFreeProxy(@Nullable String str) {
        BdVideoLog.e("player has released, cannot call updateFreeProxy!!!");
    }
}
