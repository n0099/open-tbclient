package com.baidu.card;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    public static Rect a(com.baidu.adp.widget.ListView.s sVar, View view, int i) {
        View findViewByPosition;
        if (view.getTag() instanceof AutoVideoCardViewHolder) {
            return ay.bw(((AutoVideoCardViewHolder) view.getTag()).sP().getVideoContainer());
        }
        if (sVar instanceof BdTypeRecyclerView) {
            RecyclerView.LayoutManager layoutManager = ((BdTypeRecyclerView) sVar).getLayoutManager();
            if (layoutManager == null) {
                return null;
            }
            int firstVisiblePosition = ((BdTypeRecyclerView) sVar).getFirstVisiblePosition();
            int lastVisiblePosition = ((BdTypeRecyclerView) sVar).getLastVisiblePosition();
            List<com.baidu.adp.widget.ListView.n> data = sVar.getData();
            Object item = com.baidu.tbadk.core.util.x.getItem(data, i);
            if (!(item instanceof BaseCardInfo)) {
                return null;
            }
            BaseCardInfo baseCardInfo = (BaseCardInfo) item;
            int headerViewsCount = ((BdTypeRecyclerView) sVar).getHeaderViewsCount();
            for (int i2 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i2 <= lastVisiblePosition; i2++) {
                Object item2 = com.baidu.tbadk.core.util.x.getItem(data, i2 - headerViewsCount);
                if ((item2 instanceof BaseCardInfo) && baseCardInfo.position == ((BaseCardInfo) item2).position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null && (findViewByPosition.getTag() instanceof AutoVideoCardViewHolder)) {
                    return ay.bw(((AutoVideoCardViewHolder) findViewByPosition.getTag()).sP().getVideoContainer());
                }
            }
        }
        return null;
    }
}
