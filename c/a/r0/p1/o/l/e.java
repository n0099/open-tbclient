package c.a.r0.p1.o.l;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes3.dex */
public interface e<T extends ICardInfo> {
    void onScrollIdle();

    void onViewBackground();

    void onViewForeground();

    void registerListener(BdUniqueId bdUniqueId);

    void setAfterClickSchemeListener(c.a.r0.p1.o.a aVar);

    void setBusinessType(int i2);

    void setDownloadAppCallback(c.a.r0.p1.o.c cVar);

    void setFromCDN(boolean z);

    void setPosition(int i2);

    void update(Object obj);

    void updateFontSize();
}
