package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.VoteView;
/* loaded from: classes20.dex */
public class au extends i {
    private int afP;
    private VoteView ail;
    private TbPageContext mPageContext;

    public au(Context context) {
        super(context);
        this.ail = new VoteView(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ail.setPageContext(this.mPageContext);
    }

    public void setFromForPb(int i) {
        this.afP = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ail;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(final AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport)) {
            this.ail.setVisibility(0);
            this.ail.setData(absThreadDataSupport.bcY().bhD(), absThreadDataSupport.bcY().getTid(), absThreadDataSupport.bcY().getFid());
            this.ail.setOnItemClickListener(new View.OnClickListener() { // from class: com.baidu.card.au.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ay.a(absThreadDataSupport, (Context) au.this.mPageContext.getPageActivity(), au.this.afP, false);
                }
            });
            return;
        }
        this.ail.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ail.onChangeSkinType(i);
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bcY() == null || absThreadDataSupport.bcY().bhD() == null || absThreadDataSupport.bcY().bhD().getOptions() == null || absThreadDataSupport.bcY().bhD().getOptions().size() <= 0 || absThreadDataSupport.bcY().bee()) ? false : true;
    }
}
