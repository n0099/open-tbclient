package c.a.t0.s1.i.a;

import c.a.s0.s.i0.f;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
/* loaded from: classes8.dex */
public interface a extends f.g {
    void loadMore();

    void netCallback(c.a.t0.s1.i.a.b.a aVar);

    void netResidueCallback(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData);

    void onServerError(ErrorData errorData);

    void refresh();
}
