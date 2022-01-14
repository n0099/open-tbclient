package c.a.t0.z2.v;

import android.view.View;
import c.a.s0.s.q.e2;
import c.a.t0.z2.t;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.play.TbVideoViewContainer;
/* loaded from: classes9.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnSeekCompleteListener, TbVideoViewContainer.a {
    void changeRenderViewMode(int i2);

    int getCurrentPosition();

    View getMainView();

    boolean isFullScreen();

    boolean isPlaying();

    boolean onBackPress();

    boolean onBackground(boolean z);

    void onScroll();

    boolean onVolumeUp();

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(e2 e2Var);

    void setFrom(String str);

    void setJumpToPbClickListener(View.OnClickListener onClickListener);

    void setStageType(String str);

    void setStatistic(t tVar);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();
}
