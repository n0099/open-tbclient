package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class at extends h {
    private int ain;
    private VoteView akA;
    private TbPageContext mPageContext;

    public at(Context context) {
        super(context);
        this.akA = new VoteView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.akA.setPageContext(this.mPageContext);
    }

    public void setFromForPb(int i) {
        this.ain = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.akA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(final com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar)) {
            this.akA.setVisibility(0);
            this.akA.setData(aVar.blp().bqa(), aVar.blp().getTid(), aVar.blp().getFid());
            this.akA.setOnItemClickListener(new View.OnClickListener() { // from class: com.baidu.card.at.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    az.a(aVar, (Context) at.this.mPageContext.getPageActivity(), at.this.ain, false);
                }
            });
            return;
        }
        this.akA.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.akA.onChangeSkinType(i);
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.blp() == null || aVar.blp().bqa() == null || aVar.blp().bqa().getOptions() == null || aVar.blp().bqa().getOptions().size() <= 0 || aVar.blp().bmx()) ? false : true;
    }
}
