package com.baidu.tbadk.core.view;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bi;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.square.a> {
    final /* synthetic */ c XX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.XX = cVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void m(int i, String str) {
        TbPageContext<?> tbPageContext;
        TbPageContext tbPageContext2;
        String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i));
        bi tO = bi.tO();
        tbPageContext = this.XX.LH;
        String[] strArr = new String[3];
        strArr[0] = str;
        strArr[2] = makeStatisticsParam;
        tO.b(tbPageContext, strArr);
        tbPageContext2 = this.XX.LH;
        TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "square_banner_picture", "click", 1, "loc", new StringBuilder(String.valueOf(i - 1)).toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tieba.square.a aVar) {
    }
}
