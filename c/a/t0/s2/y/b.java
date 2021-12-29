package c.a.t0.s2.y;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes8.dex */
public interface b {
    void finish();

    TbPageContext getPageContext();

    AbsPbActivity getPbActivity();

    PbFragment getPbFragment();

    PbModel.g getPbFragmentDataCallback();

    PbModel getPbModel();

    AbsVideoPbFragment getVideoPbFragment();

    void registerListener(MessageListener<?> messageListener);
}
