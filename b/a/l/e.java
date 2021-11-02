package b.a.l;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Rect a(b.a.e.l.e.s sVar, View view, int i2) {
        InterceptResult invokeLLI;
        BdTypeRecyclerView bdTypeRecyclerView;
        RecyclerView.LayoutManager layoutManager;
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, sVar, view, i2)) == null) {
            if (view.getTag() instanceof AutoVideoCardViewHolder) {
                return ThreadCardUtils.computeViewArea(((AutoVideoCardViewHolder) view.getTag()).getVideoSegment().getVideoContainer());
            }
            if (!(sVar instanceof BdTypeRecyclerView) || (layoutManager = (bdTypeRecyclerView = (BdTypeRecyclerView) sVar).getLayoutManager()) == null) {
                return null;
            }
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            List<b.a.e.l.e.n> data = sVar.getData();
            Object item = ListUtils.getItem(data, i2);
            if (item instanceof BaseCardInfo) {
                BaseCardInfo baseCardInfo = (BaseCardInfo) item;
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                for (int i3 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i3 <= lastVisiblePosition; i3++) {
                    Object item2 = ListUtils.getItem(data, i3 - headerViewsCount);
                    if ((item2 instanceof BaseCardInfo) && baseCardInfo.position == ((BaseCardInfo) item2).position && (findViewByPosition = layoutManager.findViewByPosition(i3)) != null && (findViewByPosition.getTag() instanceof AutoVideoCardViewHolder)) {
                        return ThreadCardUtils.computeViewArea(((AutoVideoCardViewHolder) findViewByPosition.getTag()).getVideoSegment().getVideoContainer());
                    }
                }
                return null;
            }
            return null;
        }
        return (Rect) invokeLLI.objValue;
    }
}
