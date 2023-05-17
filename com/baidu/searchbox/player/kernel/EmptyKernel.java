package com.baidu.searchbox.player.kernel;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.model.VideoUrlModel;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class EmptyKernel extends AbsVideoKernel {
    public static final String TAG = "EmptyKernel";

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDecodeMode() {
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public boolean takeSnapshotAsync(OnSnapShotFrameListener onSnapShotFrameListener, float f) {
        return false;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    public View getBVideoView() {
        BdVideoLog.e(TAG, "getBVideoView()");
        return new FrameLayout(BDPlayerConfig.getAppContext());
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getBufferingPosition() {
        BdVideoLog.e(TAG, "getBufferingPosition()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDuration() {
        BdVideoLog.e(TAG, "getDuration()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDurationMs() {
        BdVideoLog.e(TAG, "getDurationMs()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPlayedTime() {
        BdVideoLog.e(TAG, "getPlayedTime()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPosition() {
        BdVideoLog.e(TAG, "getPosition()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPositionMs() {
        BdVideoLog.e(TAG, "getPositionMs()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getSyncPositionMs() {
        BdVideoLog.e(TAG, "getSyncPositionMs()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoHeight() {
        BdVideoLog.e(TAG, "getVideoHeight()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoWidth() {
        BdVideoLog.e(TAG, "getVideoWidth()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onComplete() {
        BdVideoLog.e(TAG, "onComplete()");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onError() {
        BdVideoLog.e(TAG, "onError()");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onPrepared() {
        BdVideoLog.e(TAG, "onPrepared()");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDataSourceAndPrepare() {
        BdVideoLog.e("player has released, cannot call setDataSourceAndPrepare!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void start() {
        BdVideoLog.e(TAG, "start()");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public <T extends VideoUrlModel> void changePlayUrl(@NonNull T t) {
        BdVideoLog.e(TAG, "changePlayUrl(" + t.videoUrl + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void mute(boolean z) {
        BdVideoLog.e(TAG, "mute(" + z + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void play(@NonNull String str) {
        BdVideoLog.e(TAG, "play(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setClarityInfo(@Nullable String str) {
        BdVideoLog.e(TAG, "setClarityInfo(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDecodeMode(int i) {
        BdVideoLog.e(TAG, "setDecodeMode(" + i + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setHttpHeader(@Nullable HashMap<String, String> hashMap) {
        BdVideoLog.e(TAG, "setHttpHeader(" + hashMap + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        BdVideoLog.e(TAG, "setKernelCallBack(" + System.identityHashCode(iKernelPlayer) + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setLooping(boolean z) {
        BdVideoLog.e(TAG, "setLooping(" + z + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setPageUrl(String str) {
        BdVideoLog.e(TAG, "setPageUrl(" + System.identityHashCode(str) + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setPlayConf(@Nullable String str) {
        BdVideoLog.e(TAG, "setPlayConf(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setProxy(@Nullable String str) {
        BdVideoLog.e(TAG, "setProxy(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setSpeed(float f) {
        BdVideoLog.e(TAG, "setSpeed(" + f + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setUserAgent(String str) {
        BdVideoLog.e(TAG, "setUserAgent(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoRotation(int i) {
        BdVideoLog.e(TAG, "setVideoRotation(" + i + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoScalingMode(int i) {
        BdVideoLog.e(TAG, "setVideoScalingMode(" + i + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoUrl(String str) {
        BdVideoLog.e(TAG, "setVideoUrl(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void switchMediaSource(int i) {
        BdVideoLog.e(TAG, "switchMediaSource(" + i + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void updateFreeProxy(@Nullable String str) {
        BdVideoLog.e(TAG, "updateFreeProxy(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return TAG.equals(str);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onInfo(int i, int i2, Object obj) {
        BdVideoLog.e(TAG, "onInfo(" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void seekToMs(int i, int i2) {
        BdVideoLog.e(TAG, "seekTo(" + i + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setExternalInfo(String str, Object obj) {
        BdVideoLog.e(TAG, "setExternalInfo(" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setOption(String str, String str2) {
        BdVideoLog.e(TAG, "setOption(" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
        BdVideoLog.e(TAG, "setVideoFormatOptions(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoUrl(String str, boolean z) {
        BdVideoLog.e(TAG, "player has released, cannot call setVideoUrl!!! isNeedChangeState = " + z);
    }
}
