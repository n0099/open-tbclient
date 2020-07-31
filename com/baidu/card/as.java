package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.VoteView;
/* loaded from: classes15.dex */
public class as extends h {
    private int aem;
    private VoteView agF;
    private TbPageContext mPageContext;

    public as(Context context) {
        super(context);
        this.agF = new VoteView(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.agF.setPageContext(this.mPageContext);
    }

    public void setFromForPb(int i) {
        this.aem = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(final AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport)) {
            this.agF.setVisibility(0);
            this.agF.setData(absThreadDataSupport.aTN().aYq(), absThreadDataSupport.aTN().getTid(), absThreadDataSupport.aTN().getFid());
            this.agF.setOnItemClickListener(new View.OnClickListener() { // from class: com.baidu.card.as.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ax.a(absThreadDataSupport, (Context) as.this.mPageContext.getPageActivity(), as.this.aem, false);
                }
            });
            return;
        }
        this.agF.setVisibility(8);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agF.onChangeSkinType(i);
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.aTN() == null || absThreadDataSupport.aTN().aYq() == null || absThreadDataSupport.aTN().aYq().getOptions() == null || absThreadDataSupport.aTN().aYq().getOptions().size() <= 0) ? false : true;
    }
}
