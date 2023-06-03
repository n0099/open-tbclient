package com.baidu.searchbox.player.kernel;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.interfaces.OnMediaRuntimeInfoListener;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.KernelMediaInfo;
import com.baidu.searchbox.player.model.VideoUrlModel;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class EmptyKernel extends AbsVideoKernel {
    public static final String KERNEL_TYPE_EMPTY = "EmptyKernel";

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDecodeMode() {
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @Nullable
    public KernelMediaInfo getKernelMediaInfo() {
        return null;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    public String getKernelType() {
        return KERNEL_TYPE_EMPTY;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void getMediaRuntimeInfo(@Nullable OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public boolean takeSnapshotAsync(@Nullable OnSnapShotFrameListener onSnapShotFrameListener, float f) {
        return false;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    public View getBVideoView() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "getBVideoView()");
        return new FrameLayout(BDPlayerConfig.getAppContext());
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getBufferingPosition() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "getBufferingPosition()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDuration() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "getDuration()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDurationMs() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "getDurationMs()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPlayedTime() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "getPlayedTime()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPosition() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "getPosition()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPositionMs() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "getPositionMs()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getSyncPositionMs() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "getSyncPositionMs()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoHeight() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "getVideoHeight()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoWidth() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "getVideoWidth()");
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onComplete() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "onComplete()");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onError() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "onError()");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onPrepared() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "onPrepared()");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDataSourceAndPrepare() {
        BdVideoLog.e("player has released, cannot call setDataSourceAndPrepare!!!");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void start() {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "start()");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void changePlayUrl(@NonNull BasicVideoSeries basicVideoSeries, @Nullable Map<String, String> map) {
        super.changePlayUrl(basicVideoSeries, map);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void seekToMs(int i, int i2) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "seekTo(" + i + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDynamicOption(String str, String str2) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setDynamicOption(" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setExternalInfo(String str, Object obj) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setExternalInfo(" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setOption(String str, String str2) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setOption(" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setVideoFormatOptions(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void switchMediaSource(int i, int i2) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "switchMediaSource(" + i + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void mute(boolean z) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "mute(" + z + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void play(@NonNull String str) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "play(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setClarityInfo(@Nullable String str) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setClarityInfo(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDecodeMode(int i) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setDecodeMode(" + i + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setHttpHeader(@Nullable HashMap<String, String> hashMap) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setHttpHeader(" + hashMap + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setKernelCallBack(" + System.identityHashCode(iKernelPlayer) + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setLooping(boolean z) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setLooping(" + z + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setPageUrl(String str) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setPageUrl(" + System.identityHashCode(str) + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setProxy(@Nullable String str) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setProxy(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setSpeed(float f) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setSpeed(" + f + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setUserAgent(String str) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setUserAgent(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoRotation(int i) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setVideoRotation(" + i + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoScalingMode(int i) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "setVideoScalingMode(" + i + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void switchMediaSource(int i) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "switchMediaSource(" + i + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    public VideoUrlModel transformVideoUrlModel(@Nullable BasicVideoSeries basicVideoSeries) {
        return new VideoUrlModel();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void updateFreeProxy(@Nullable String str) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "updateFreeProxy(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return KERNEL_TYPE_EMPTY.equals(str);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onInfo(int i, int i2, Object obj) {
        BdVideoLog.e(KERNEL_TYPE_EMPTY, "onInfo(" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj + SmallTailInfo.EMOTION_SUFFIX);
    }
}
