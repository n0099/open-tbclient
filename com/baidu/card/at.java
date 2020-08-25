package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.VoteView;
/* loaded from: classes15.dex */
public class at extends h {
    private int afv;
    private VoteView ahO;
    private TbPageContext mPageContext;

    public at(Context context) {
        super(context);
        this.ahO = new VoteView(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ahO.setPageContext(this.mPageContext);
    }

    public void setFromForPb(int i) {
        this.afv = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(final AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport)) {
            this.ahO.setVisibility(0);
            this.ahO.setData(absThreadDataSupport.bce().bgJ(), absThreadDataSupport.bce().getTid(), absThreadDataSupport.bce().getFid());
            this.ahO.setOnItemClickListener(new View.OnClickListener() { // from class: com.baidu.card.at.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ay.a(absThreadDataSupport, (Context) at.this.mPageContext.getPageActivity(), at.this.afv, false);
                }
            });
            return;
        }
        this.ahO.setVisibility(8);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahO.onChangeSkinType(i);
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bce() == null || absThreadDataSupport.bce().bgJ() == null || absThreadDataSupport.bce().bgJ().getOptions() == null || absThreadDataSupport.bce().bgJ().getOptions().size() <= 0 || absThreadDataSupport.bce().bdk()) ? false : true;
    }
}
