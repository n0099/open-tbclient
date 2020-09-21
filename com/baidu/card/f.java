package com.baidu.card;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ay;
import java.util.List;
/* loaded from: classes20.dex */
public class f {
    public static Rect a(com.baidu.adp.widget.ListView.v vVar, View view, int i) {
        View findViewByPosition;
        if (view.getTag() instanceof a) {
            return ay.ba(((a) view.getTag()).tz().getVideoContainer());
        }
        if (vVar instanceof BdTypeRecyclerView) {
            RecyclerView.LayoutManager layoutManager = ((BdTypeRecyclerView) vVar).getLayoutManager();
            if (layoutManager == null) {
                return null;
            }
            int firstVisiblePosition = ((BdTypeRecyclerView) vVar).getFirstVisiblePosition();
            int lastVisiblePosition = ((BdTypeRecyclerView) vVar).getLastVisiblePosition();
            List<com.baidu.adp.widget.ListView.q> data = vVar.getData();
            Object item = com.baidu.tbadk.core.util.y.getItem(data, i);
            if (!(item instanceof com.baidu.tieba.card.data.b)) {
                return null;
            }
            com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) item;
            int headerViewsCount = ((BdTypeRecyclerView) vVar).getHeaderViewsCount();
            for (int i2 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i2 <= lastVisiblePosition; i2++) {
                Object item2 = com.baidu.tbadk.core.util.y.getItem(data, i2 - headerViewsCount);
                if ((item2 instanceof com.baidu.tieba.card.data.b) && bVar.position == ((com.baidu.tieba.card.data.b) item2).position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null && (findViewByPosition.getTag() instanceof a)) {
                    return ay.ba(((a) findViewByPosition.getTag()).tz().getVideoContainer());
                }
            }
        }
        return null;
    }
}
