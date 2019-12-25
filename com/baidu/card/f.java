package com.baidu.card;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.au;
import java.util.List;
/* loaded from: classes5.dex */
public class f {
    public static Rect a(com.baidu.adp.widget.ListView.r rVar, View view, int i) {
        View findViewByPosition;
        if (view.getTag() instanceof a) {
            return au.aL(((a) view.getTag()).mC().getVideoContainer());
        }
        if (rVar instanceof BdTypeRecyclerView) {
            RecyclerView.LayoutManager layoutManager = ((BdTypeRecyclerView) rVar).getLayoutManager();
            if (layoutManager == null) {
                return null;
            }
            int firstVisiblePosition = ((BdTypeRecyclerView) rVar).getFirstVisiblePosition();
            int lastVisiblePosition = ((BdTypeRecyclerView) rVar).getLastVisiblePosition();
            List<com.baidu.adp.widget.ListView.m> data = rVar.getData();
            Object item = com.baidu.tbadk.core.util.v.getItem(data, i);
            if (!(item instanceof com.baidu.tieba.card.data.b)) {
                return null;
            }
            com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) item;
            int headerViewsCount = ((BdTypeRecyclerView) rVar).getHeaderViewsCount();
            for (int i2 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i2 <= lastVisiblePosition; i2++) {
                Object item2 = com.baidu.tbadk.core.util.v.getItem(data, i2 - headerViewsCount);
                if ((item2 instanceof com.baidu.tieba.card.data.b) && bVar.position == ((com.baidu.tieba.card.data.b) item2).position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null && (findViewByPosition.getTag() instanceof a)) {
                    return au.aL(((a) findViewByPosition.getTag()).mC().getVideoContainer());
                }
            }
        }
        return null;
    }
}
