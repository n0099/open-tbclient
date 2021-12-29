package c.a.t0.d1.a3;

import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes7.dex */
public interface h {
    void hideLoadingView();

    void onLoadFail();

    void setData(List<BaseCardInfo> list, boolean z, boolean z2);

    void setPresenter(g gVar);

    void showMsg(String str);
}
