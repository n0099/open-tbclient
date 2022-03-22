package c.a.p0.c3.w;

import android.view.View;
import c.a.p0.c3.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.play.TbVideoViewContainer;
/* loaded from: classes2.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnSeekCompleteListener, TbVideoViewContainer.a {
    void changeRenderViewMode(int i);

    int getCurrentPosition();

    View getMainView();

    boolean isFullScreen();

    boolean isPlaying();

    boolean onBackPress();

    boolean onBackground(boolean z);

    void onScroll();

    boolean onVolumeUp();

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(ThreadData threadData);

    void setFrom(String str);

    void setJumpToPbClickListener(View.OnClickListener onClickListener);

    void setStageType(String str);

    void setStatistic(u uVar);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();
}
