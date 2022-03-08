package c.a.r0.a3;

import android.widget.MediaController;
import c.a.q0.r.r.e2;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
/* loaded from: classes2.dex */
public interface g extends MediaController.MediaPlayerControl {
    void changeRenderViewMode(int i2);

    void clearCallbackAndRemoveFromWindow();

    int getCurrentPositionSync();

    h getMediaProgressObserver();

    String getOriginUrl();

    int getPcdnState();

    f getPlayer();

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

    void setOperableVideoContainer(c.a.r0.a3.v.a aVar);

    void setPlayMode(String str);

    void setStageType(String str);

    void setThreadDataForStatistic(e2 e2Var);

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
