package c.a.r0.w0.p2;

import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes4.dex */
public interface h {
    void hideLoadingView();

    void onLoadFail();

    void setData(List<BaseCardInfo> list, boolean z, boolean z2);

    void setPresenter(g gVar);

    void showMsg(String str);
}
