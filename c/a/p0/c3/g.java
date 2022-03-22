package c.a.p0.c3;

import android.widget.MediaController;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
/* loaded from: classes2.dex */
public interface g extends MediaController.MediaPlayerControl {
    void a(long j, long j2, long j3);

    void b(TbVideoViewSet.b bVar);

    void changeRenderViewMode(int i);

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

    void j();

    void k();

    boolean l();

    void m();

    boolean n();

    void o();

    void p(TbVideoViewSet.b bVar);

    void q();

    void setCanShowPause(boolean z);

    void setContinuePlayEnable(boolean z);

    void setIsVolume0(boolean z);

    void setLocateSource(String str);

    void setLooping(boolean z);

    void setNoBussinessStats();

    void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar);

    void setOperableVideoContainer(c.a.p0.c3.w.a aVar);

    void setPlayMode(String str);

    void setStageType(String str);

    void setThreadDataForStatistic(ThreadData threadData);

    void setTryUseViewInSet(boolean z);

    void setVideoModel(s sVar);

    void setVideoPath(String str);

    void setVideoPath(String str, String str2);

    void setVideoScalingMode(int i);

    void setVideoStatData(u uVar);

    void setVideoStatusChangeListener(TbCyberVideoView.g gVar);

    void setVolume(float f2, float f3);

    void stop();

    void stopPlayback();
}
