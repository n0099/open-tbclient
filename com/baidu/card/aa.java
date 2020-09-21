package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.MultiLinkCardView;
/* loaded from: classes20.dex */
public class aa extends i {
    private MultiLinkCardView agu;

    public aa(Context context) {
        super(context);
        this.agu = new MultiLinkCardView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport) || d(absThreadDataSupport) || absThreadDataSupport == null || absThreadDataSupport.bcY() == null || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bcY().bhE()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bcY().bhF()) <= 1) || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bcY().bhF()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bcY().bhE()) <= 1) || com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bcY().bhE()) + com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bcY().bhF()) <= 1))) {
            this.agu.setVisibility(8);
            return;
        }
        this.agu.i(absThreadDataSupport.bcY().bhE(), absThreadDataSupport.bcY().bhF());
        this.agu.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agu.onChangeSkinType();
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bcY() == null || absThreadDataSupport.bcY().bhD() == null || absThreadDataSupport.bcY().bhD().getOptions() == null || absThreadDataSupport.bcY().bhD().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bcY() == null || !absThreadDataSupport.bcY().bee() || absThreadDataSupport.bcY().bfQ() == null) ? false : true;
    }
}
