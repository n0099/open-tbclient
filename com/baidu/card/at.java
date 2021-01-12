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
    private int ahf;
    private VoteView ajt;
    private TbPageContext mPageContext;

    public at(Context context) {
        super(context);
        this.ajt = new VoteView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ajt.setPageContext(this.mPageContext);
    }

    public void setFromForPb(int i) {
        this.ahf = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ajt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(final com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar)) {
            this.ajt.setVisibility(0);
            this.ajt.setData(aVar.bkV().bpG(), aVar.bkV().getTid(), aVar.bkV().getFid());
            this.ajt.setOnItemClickListener(new View.OnClickListener() { // from class: com.baidu.card.at.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ay.a(aVar, (Context) at.this.mPageContext.getPageActivity(), at.this.ahf, false);
                }
            });
            return;
        }
        this.ajt.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajt.onChangeSkinType(i);
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bkV() == null || aVar.bkV().bpG() == null || aVar.bkV().bpG().getOptions() == null || aVar.bkV().bpG().getOptions().size() <= 0 || aVar.bkV().bmc()) ? false : true;
    }
}
