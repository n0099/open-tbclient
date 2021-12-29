package c.a.t0.z2;

import android.widget.MediaController;
import c.a.s0.s.q.d2;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
/* loaded from: classes9.dex */
public interface g extends MediaController.MediaPlayerControl {
    void changeRenderViewMode(int i2);

    void clearCallbackAndRemoveFromWindow();

    int getCurrentPositionSync();

    h getMediaProgressObserver();

    String getOriginUrl();

    int getPcdnState();

    int getPlayerHeight();

    int getPlayerWidth();

    int getVideoHeight();

    TbCyberVideoView.VideoStatus getVideoStatus();

    int getVideoWidth();

    boolean isCanShowPause();

    boolean isIntentToStart();

    void monitorAndStatsAtPrepare();

    void monitorAndStatsAtVerticalVideoReplay();

    void pauseWithoutMuteAudioFocus();

    void prepareByPause();

    void recordPlayTimeInfo(long j2, long j3, long j4);

    void resumePlay(TbVideoViewSet.b bVar);

    void setCanShowPause(boolean z);

    void setContinuePlayEnable(boolean z);

    void setIsVolume0(boolean z);

    void setLocateSource(String str);

    void setLooping(boolean z);

    void setNoBussinessStats();

    void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar);

    void setOperableVideoContainer(c.a.t0.z2.v.a aVar);

    void setPlayMode(String str);

    void setStageType(String str);

    void setThreadDataForStatistic(d2 d2Var);

    void setTryUseViewInSet(boolean z);

    void setVideoModel(r rVar);

    void setVideoPath(String str);

    void setVideoPath(String str, String str2);

    void setVideoScalingMode(int i2);

    void setVideoStatData(t tVar);

    void setVideoStatusChangeListener(TbCyberVideoView.g gVar);

    void setVolume(float f2, float f3);

    void start(TbVideoViewSet.b bVar);

    void stop();

    void stopPlayback();
}
