package b.a.r0.q2.r;

import android.view.View;
import b.a.q0.s.q.d2;
import b.a.r0.q2.p;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes5.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnErrorListener, TbCyberVideoView.h {
    boolean C();

    void E(int i2);

    boolean F();

    void G(p pVar);

    void H();

    boolean I(boolean z);

    void J(View.OnClickListener onClickListener);

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
