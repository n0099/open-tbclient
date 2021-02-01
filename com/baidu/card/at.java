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
    private int agU;
    private VoteView aji;
    private TbPageContext mPageContext;

    public at(Context context) {
        super(context);
        this.aji = new VoteView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aji.setPageContext(this.mPageContext);
    }

    public void setFromForPb(int i) {
        this.agU = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.aji;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(final com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar)) {
            this.aji.setVisibility(0);
            this.aji.setData(aVar.bln().bpY(), aVar.bln().getTid(), aVar.bln().getFid());
            this.aji.setOnItemClickListener(new View.OnClickListener() { // from class: com.baidu.card.at.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    az.a(aVar, (Context) at.this.mPageContext.getPageActivity(), at.this.agU, false);
                }
            });
            return;
        }
        this.aji.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aji.onChangeSkinType(i);
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bln() == null || aVar.bln().bpY() == null || aVar.bln().bpY().getOptions() == null || aVar.bln().bpY().getOptions().size() <= 0 || aVar.bln().bmv()) ? false : true;
    }
}
