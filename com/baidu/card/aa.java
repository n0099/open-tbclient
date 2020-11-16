package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class aa extends i {
    private MultiLinkCardView agO;

    public aa(Context context) {
        super(context);
        this.agO = new MultiLinkCardView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar) || d(aVar) || aVar == null || aVar.bjd() == null || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.bjd().bnK()) && com.baidu.tbadk.core.util.y.getCount(aVar.bjd().bnL()) <= 1) || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.bjd().bnL()) && com.baidu.tbadk.core.util.y.getCount(aVar.bjd().bnK()) <= 1) || com.baidu.tbadk.core.util.y.getCount(aVar.bjd().bnK()) + com.baidu.tbadk.core.util.y.getCount(aVar.bjd().bnL()) <= 1))) {
            this.agO.setVisibility(8);
            return;
        }
        this.agO.l(aVar.bjd().bnK(), aVar.bjd().bnL());
        this.agO.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agO.onChangeSkinType();
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bjd() == null || aVar.bjd().bnJ() == null || aVar.bjd().bnJ().getOptions() == null || aVar.bjd().bnJ().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bjd() == null || !aVar.bjd().bki() || aVar.bjd().blU() == null) ? false : true;
    }
}
