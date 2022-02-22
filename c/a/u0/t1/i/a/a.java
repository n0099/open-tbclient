package c.a.u0.t1.i.a;

import c.a.t0.s.l0.f;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
/* loaded from: classes9.dex */
public interface a extends f.g {
    void loadMore();

    void netCallback(c.a.u0.t1.i.a.b.a aVar);

    void netResidueCallback(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData);

    void onServerError(ErrorData errorData);

    void refresh();
}
