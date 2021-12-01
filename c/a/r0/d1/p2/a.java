package c.a.r0.d1.p2;

import c.a.d.a.f;
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
