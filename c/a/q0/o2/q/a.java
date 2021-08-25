package c.a.q0.o2.q;

import android.view.View;
import c.a.p0.s.q.c2;
import c.a.q0.o2.o;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes3.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnErrorListener, TbCyberVideoView.h {
    boolean C();

    void E(int i2);

    boolean F();

    void G(o oVar);

    void H();

    boolean I(boolean z);

    void M(View.OnClickListener onClickListener);

    int getCurrentPosition();

    View getMainView();

    boolean isFullScreen();

    boolean isPlaying();

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(c2 c2Var);

    void setFrom(String str);

    void setStageType(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();
}
