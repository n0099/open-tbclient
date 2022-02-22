package c.a.u0.u2.y;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes9.dex */
public interface c {
    void finish();

    TbPageContext getPageContext();

    AbsPbActivity getPbActivity();

    PbFragment getPbFragment();

    PbModel.g getPbFragmentDataCallback();

    PbModel getPbModel();

    AbsVideoPbFragment getVideoPbFragment();

    void registerListener(MessageListener<?> messageListener);
}
