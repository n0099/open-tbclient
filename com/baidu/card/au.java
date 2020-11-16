package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class au extends i {
    private int agn;
    private VoteView aiJ;
    private TbPageContext mPageContext;

    public au(Context context) {
        super(context);
        this.aiJ = new VoteView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aiJ.setPageContext(this.mPageContext);
    }

    public void setFromForPb(int i) {
        this.agn = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aiJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(final com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar)) {
            this.aiJ.setVisibility(0);
            this.aiJ.setData(aVar.bjd().bnJ(), aVar.bjd().getTid(), aVar.bjd().getFid());
            this.aiJ.setOnItemClickListener(new View.OnClickListener() { // from class: com.baidu.card.au.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    az.a(aVar, (Context) au.this.mPageContext.getPageActivity(), au.this.agn, false);
                }
            });
            return;
        }
        this.aiJ.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aiJ.onChangeSkinType(i);
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bjd() == null || aVar.bjd().bnJ() == null || aVar.bjd().bnJ().getOptions() == null || aVar.bjd().bnJ().getOptions().size() <= 0 || aVar.bjd().bki()) ? false : true;
    }
}
