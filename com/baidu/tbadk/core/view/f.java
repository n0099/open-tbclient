package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.CarouselRecommendView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ CarouselRecommendView.e LH;
    private final /* synthetic */ com.baidu.tbadk.core.data.k LI;
    private final /* synthetic */ TbImageView LJ;
    private final /* synthetic */ int LK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CarouselRecommendView.e eVar, com.baidu.tbadk.core.data.k kVar, TbImageView tbImageView, int i) {
        this.LH = eVar;
        this.LI = kVar;
        this.LJ = tbImageView;
        this.LK = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CarouselRecommendView carouselRecommendView;
        TbPageContext<?> tbPageContext;
        TbPageContext<?> tbPageContext2;
        CarouselRecommendView carouselRecommendView2;
        int intValue;
        CarouselRecommendView carouselRecommendView3;
        String str;
        CarouselRecommendView carouselRecommendView4;
        CarouselRecommendView carouselRecommendView5;
        CarouselRecommendView carouselRecommendView6;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        TbPageContext tbPageContext5;
        String link = this.LI.getLink();
        carouselRecommendView = CarouselRecommendView.this;
        if (carouselRecommendView.Lw) {
            bh pK = bh.pK();
            tbPageContext2 = this.LH.mContext;
            carouselRecommendView2 = CarouselRecommendView.this;
            pK.b(tbPageContext2, new String[]{link, carouselRecommendView2.Ly});
            Object tag = this.LJ.getTag();
            if ((tag instanceof Integer) && (intValue = ((Integer) tag).intValue()) >= 1 && intValue <= 5) {
                carouselRecommendView3 = CarouselRecommendView.this;
                com.baidu.tbadk.core.data.k kVar = (com.baidu.tbadk.core.data.k) carouselRecommendView3.Lz.get(intValue - 1);
                if (!(kVar instanceof com.baidu.tbadk.core.data.k)) {
                    str = "";
                } else {
                    str = com.baidu.tieba.tbadkCore.util.k.in(kVar.getLink());
                }
                carouselRecommendView4 = CarouselRecommendView.this;
                if (!"4001001".equals(carouselRecommendView4.Ly)) {
                    carouselRecommendView5 = CarouselRecommendView.this;
                    if (!"4000201".equals(carouselRecommendView5.Ly)) {
                        carouselRecommendView6 = CarouselRecommendView.this;
                        if ("4000101".equals(carouselRecommendView6.Ly)) {
                            tbPageContext3 = this.LH.mContext;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "gamecenter_ad_index_" + intValue + "_click", "click", 1, "dev_id", str);
                            return;
                        }
                        return;
                    }
                    tbPageContext4 = this.LH.mContext;
                    TiebaStatic.eventStat(tbPageContext4.getPageActivity(), "gamecenter_ad_h5_" + intValue + "_click", "click", 1, "dev_id", str);
                    return;
                }
                tbPageContext5 = this.LH.mContext;
                TiebaStatic.eventStat(tbPageContext5.getPageActivity(), "gamecenter_ad_single_" + intValue + "_click", "click", 1, "dev_id", str);
                return;
            }
            return;
        }
        String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(this.LK));
        bh pK2 = bh.pK();
        tbPageContext = this.LH.mContext;
        String[] strArr = new String[3];
        strArr[0] = link;
        strArr[2] = makeStatisticsParam;
        pK2.b(tbPageContext, strArr);
    }
}
