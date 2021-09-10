package c.a.r0.w0.e2;

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
