package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.VoteView;
/* loaded from: classes21.dex */
public class au extends i {
    private int agh;
    private VoteView aiD;
    private TbPageContext mPageContext;

    public au(Context context) {
        super(context);
        this.aiD = new VoteView(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aiD.setPageContext(this.mPageContext);
    }

    public void setFromForPb(int i) {
        this.agh = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aiD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(final AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport)) {
            this.aiD.setVisibility(0);
            this.aiD.setData(absThreadDataSupport.bfG().bkm(), absThreadDataSupport.bfG().getTid(), absThreadDataSupport.bfG().getFid());
            this.aiD.setOnItemClickListener(new View.OnClickListener() { // from class: com.baidu.card.au.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ay.a(absThreadDataSupport, (Context) au.this.mPageContext.getPageActivity(), au.this.agh, false);
                }
            });
            return;
        }
        this.aiD.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aiD.onChangeSkinType(i);
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bfG() == null || absThreadDataSupport.bfG().bkm() == null || absThreadDataSupport.bfG().bkm().getOptions() == null || absThreadDataSupport.bfG().bkm().getOptions().size() <= 0 || absThreadDataSupport.bfG().bgN()) ? false : true;
    }
}
