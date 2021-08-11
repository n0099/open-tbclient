package c.a.p0.v0.d2;

import c.a.e.a.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes4.dex */
public interface a extends FrsLoadMoreModel.b {
    String getForumName();

    FrsViewData getFrsViewData();

    f getPageContext();

    BdUniqueId getUniqueId();
}
