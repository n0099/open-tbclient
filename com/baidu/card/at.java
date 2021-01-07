package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class at extends h {
    private int ahW;
    private VoteView akk;
    private TbPageContext mPageContext;

    public at(Context context) {
        super(context);
        this.akk = new VoteView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.akk.setPageContext(this.mPageContext);
    }

    public void setFromForPb(int i) {
        this.ahW = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.akk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(final com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar)) {
            this.akk.setVisibility(0);
            this.akk.setData(aVar.boP().btA(), aVar.boP().getTid(), aVar.boP().getFid());
            this.akk.setOnItemClickListener(new View.OnClickListener() { // from class: com.baidu.card.at.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ay.a(aVar, (Context) at.this.mPageContext.getPageActivity(), at.this.ahW, false);
                }
            });
            return;
        }
        this.akk.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.akk.onChangeSkinType(i);
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.boP() == null || aVar.boP().btA() == null || aVar.boP().btA().getOptions() == null || aVar.boP().btA().getOptions().size() <= 0 || aVar.boP().bpW()) ? false : true;
    }
}
