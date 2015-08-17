package com.baidu.tbadk.core.view;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.square.a> {
    final /* synthetic */ b acU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.acU = bVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        TbPageContext<?> tbPageContext;
        TbPageContext tbPageContext2;
        String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i));
        ax uR = ax.uR();
        tbPageContext = this.acU.LS;
        String[] strArr = new String[3];
        strArr[0] = str;
        strArr[2] = makeStatisticsParam;
        uR.b(tbPageContext, strArr);
        tbPageContext2 = this.acU.LS;
        TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "square_banner_picture", "click", 1, "loc", new StringBuilder(String.valueOf(i - 1)).toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tieba.square.a aVar) {
    }
}
