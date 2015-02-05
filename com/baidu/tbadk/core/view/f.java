package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.view.CarouselRecommendView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ CarouselRecommendView.e LY;
    private final /* synthetic */ com.baidu.tbadk.core.data.l LZ;
    private final /* synthetic */ TbImageView Ma;
    private final /* synthetic */ int Mb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CarouselRecommendView.e eVar, com.baidu.tbadk.core.data.l lVar, TbImageView tbImageView, int i) {
        this.LY = eVar;
        this.LZ = lVar;
        this.Ma = tbImageView;
        this.Mb = i;
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
        CarouselRecommendView carouselRecommendView7;
        TbPageContext tbPageContext4;
        CarouselRecommendView carouselRecommendView8;
        TbPageContext tbPageContext5;
        CarouselRecommendView carouselRecommendView9;
        String link = this.LZ.getLink();
        carouselRecommendView = CarouselRecommendView.this;
        if (carouselRecommendView.LO) {
            bm pO = bm.pO();
            tbPageContext2 = this.LY.mContext;
            carouselRecommendView2 = CarouselRecommendView.this;
            pO.b(tbPageContext2, new String[]{link, carouselRecommendView2.LQ});
            Object tag = this.Ma.getTag();
            if ((tag instanceof Integer) && (intValue = ((Integer) tag).intValue()) >= 1 && intValue <= 5) {
                carouselRecommendView3 = CarouselRecommendView.this;
                com.baidu.tbadk.core.data.l lVar = (com.baidu.tbadk.core.data.l) carouselRecommendView3.LR.get(intValue - 1);
                if (!(lVar instanceof com.baidu.tbadk.core.data.l)) {
                    str = "";
                } else {
                    str = com.baidu.tieba.tbadkCore.util.k.is(lVar.getLink());
                }
                carouselRecommendView4 = CarouselRecommendView.this;
                if (!"4001001".equals(carouselRecommendView4.LQ)) {
                    carouselRecommendView5 = CarouselRecommendView.this;
                    if (!"4000201".equals(carouselRecommendView5.LQ)) {
                        carouselRecommendView6 = CarouselRecommendView.this;
                        if ("4000101".equals(carouselRecommendView6.LQ)) {
                            tbPageContext3 = this.LY.mContext;
                            carouselRecommendView7 = CarouselRecommendView.this;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "gamecenter_ad_index_" + intValue + "_click", "click", 1, "dev_id", str, "ref_id", carouselRecommendView7.LQ);
                            return;
                        }
                        return;
                    }
                    tbPageContext4 = this.LY.mContext;
                    carouselRecommendView8 = CarouselRecommendView.this;
                    TiebaStatic.eventStat(tbPageContext4.getPageActivity(), "gamecenter_ad_h5_" + intValue + "_click", "click", 1, "dev_id", str, "ref_id", carouselRecommendView8.LQ);
                    return;
                }
                tbPageContext5 = this.LY.mContext;
                carouselRecommendView9 = CarouselRecommendView.this;
                TiebaStatic.eventStat(tbPageContext5.getPageActivity(), "gamecenter_ad_single_" + intValue + "_click", "click", 1, "dev_id", str, "ref_id", carouselRecommendView9.LQ);
                return;
            }
            return;
        }
        String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(this.Mb));
        bm pO2 = bm.pO();
        tbPageContext = this.LY.mContext;
        String[] strArr = new String[3];
        strArr[0] = link;
        strArr[2] = makeStatisticsParam;
        pO2.b(tbPageContext, strArr);
    }
}
