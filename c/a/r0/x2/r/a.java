package c.a.r0.x2.r;

import android.view.View;
import c.a.q0.s.q.d2;
import c.a.r0.x2.p;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes7.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnErrorListener, TbCyberVideoView.h {
    boolean H();

    void I(int i2);

    boolean J();

    void N(p pVar);

    void P();

    boolean R(boolean z);

    void U(View.OnClickListener onClickListener);

    int getCurrentPosition();

    View getMainView();

    boolean isFullScreen();

    boolean isPlaying();

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(d2 d2Var);

    void setFrom(String str);

    void setStageType(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();
}
