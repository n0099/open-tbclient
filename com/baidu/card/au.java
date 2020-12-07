package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class au extends i {
    private int ahl;
    private VoteView ajI;
    private TbPageContext mPageContext;

    public au(Context context) {
        super(context);
        this.ajI = new VoteView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ajI.setPageContext(this.mPageContext);
    }

    public void setFromForPb(int i) {
        this.ahl = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ajI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(final com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar)) {
            this.ajI.setVisibility(0);
            this.ajI.setData(aVar.bmn().bqX(), aVar.bmn().getTid(), aVar.bmn().getFid());
            this.ajI.setOnItemClickListener(new View.OnClickListener() { // from class: com.baidu.card.au.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    az.a(aVar, (Context) au.this.mPageContext.getPageActivity(), au.this.ahl, false);
                }
            });
            return;
        }
        this.ajI.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajI.onChangeSkinType(i);
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bmn() == null || aVar.bmn().bqX() == null || aVar.bmn().bqX().getOptions() == null || aVar.bmn().bqX().getOptions().size() <= 0 || aVar.bmn().bnv()) ? false : true;
    }
}
