package c.a.p0.j1.i.a;

import c.a.o0.s.f0.f;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
/* loaded from: classes3.dex */
public interface a extends f.g {
    void loadMore();

    void netCallback(c.a.p0.j1.i.a.b.a aVar);

    void netResidueCallback(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData);

    void onServerError(ErrorData errorData);

    void refresh();
}
