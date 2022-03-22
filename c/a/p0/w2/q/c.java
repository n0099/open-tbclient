package c.a.p0.w2.q;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes3.dex */
public interface c {
    PbModel.g U();

    void finish();

    TbPageContext getPageContext();

    void registerListener(MessageListener<?> messageListener);

    AbsVideoPbFragment t();

    PbModel w();

    AbsPbActivity x();

    PbFragment y0();
}
