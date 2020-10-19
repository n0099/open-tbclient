package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.MultiLinkCardView;
/* loaded from: classes21.dex */
public class aa extends i {
    private MultiLinkCardView agL;

    public aa(Context context) {
        super(context);
        this.agL = new MultiLinkCardView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport) || d(absThreadDataSupport) || absThreadDataSupport == null || absThreadDataSupport.bfG() == null || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bfG().bkn()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bfG().bko()) <= 1) || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bfG().bko()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bfG().bkn()) <= 1) || com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bfG().bkn()) + com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bfG().bko()) <= 1))) {
            this.agL.setVisibility(8);
            return;
        }
        this.agL.i(absThreadDataSupport.bfG().bkn(), absThreadDataSupport.bfG().bko());
        this.agL.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agL.onChangeSkinType();
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bfG() == null || absThreadDataSupport.bfG().bkm() == null || absThreadDataSupport.bfG().bkm().getOptions() == null || absThreadDataSupport.bfG().bkm().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bfG() == null || !absThreadDataSupport.bfG().bgN() || absThreadDataSupport.bfG().biz() == null) ? false : true;
    }
}
