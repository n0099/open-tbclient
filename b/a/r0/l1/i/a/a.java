package b.a.r0.l1.i.a;

import b.a.q0.s.g0.f;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
/* loaded from: classes5.dex */
public interface a extends f.g {
    void loadMore();

    void netCallback(b.a.r0.l1.i.a.b.a aVar);

    void netResidueCallback(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData);

    void onServerError(ErrorData errorData);

    void refresh();
}
