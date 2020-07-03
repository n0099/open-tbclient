package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.VoteView;
/* loaded from: classes8.dex */
public class as extends h {
    private int aew;
    private VoteView agO;
    private TbPageContext mPageContext;

    public as(Context context) {
        super(context);
        this.agO = new VoteView(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.agO.setPageContext(this.mPageContext);
    }

    public void setFromForPb(int i) {
        this.aew = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(final AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport)) {
            this.agO.setVisibility(0);
            this.agO.setData(absThreadDataSupport.aPS().aUw(), absThreadDataSupport.aPS().getTid(), absThreadDataSupport.aPS().getFid());
            this.agO.setOnItemClickListener(new View.OnClickListener() { // from class: com.baidu.card.as.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aw.a(absThreadDataSupport, (Context) as.this.mPageContext.getPageActivity(), as.this.aew, false);
                }
            });
            return;
        }
        this.agO.setVisibility(8);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agO.onChangeSkinType(i);
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.aPS() == null || absThreadDataSupport.aPS().aUw() == null || absThreadDataSupport.aPS().aUw().getOptions() == null || absThreadDataSupport.aPS().aUw().getOptions().size() <= 0) ? false : true;
    }
}
