package b.a.r0.x0.o2;

import b.a.e.a.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes5.dex */
public interface a extends FrsLoadMoreModel.b {
    String getForumName();

    FrsViewData getFrsViewData();

    f getPageContext();

    BdUniqueId getUniqueId();
}
