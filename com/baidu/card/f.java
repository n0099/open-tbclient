package com.baidu.card;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.au;
import java.util.List;
/* loaded from: classes8.dex */
public class f {
    public static Rect a(com.baidu.adp.widget.ListView.t tVar, View view, int i) {
        View findViewByPosition;
        if (view.getTag() instanceof a) {
            return au.aQ(((a) view.getTag()).rq().getVideoContainer());
        }
        if (tVar instanceof BdTypeRecyclerView) {
            RecyclerView.LayoutManager layoutManager = ((BdTypeRecyclerView) tVar).getLayoutManager();
            if (layoutManager == null) {
                return null;
            }
            int firstVisiblePosition = ((BdTypeRecyclerView) tVar).getFirstVisiblePosition();
            int lastVisiblePosition = ((BdTypeRecyclerView) tVar).getLastVisiblePosition();
            List<com.baidu.adp.widget.ListView.o> data = tVar.getData();
            Object item = com.baidu.tbadk.core.util.v.getItem(data, i);
            if (!(item instanceof com.baidu.tieba.card.data.b)) {
                return null;
            }
            com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) item;
            int headerViewsCount = ((BdTypeRecyclerView) tVar).getHeaderViewsCount();
            for (int i2 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i2 <= lastVisiblePosition; i2++) {
                Object item2 = com.baidu.tbadk.core.util.v.getItem(data, i2 - headerViewsCount);
                if ((item2 instanceof com.baidu.tieba.card.data.b) && bVar.position == ((com.baidu.tieba.card.data.b) item2).position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null && (findViewByPosition.getTag() instanceof a)) {
                    return au.aQ(((a) findViewByPosition.getTag()).rq().getVideoContainer());
                }
            }
        }
        return null;
    }
}
