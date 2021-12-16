package c.a.s0.z2.r;

import android.view.View;
import c.a.r0.s.r.d2;
import c.a.s0.z2.p;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes9.dex */
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
