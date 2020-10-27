package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.VoteView;
/* loaded from: classes21.dex */
public class au extends i {
    private int agi;
    private VoteView aiE;
    private TbPageContext mPageContext;

    public au(Context context) {
        super(context);
        this.aiE = new VoteView(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aiE.setPageContext(this.mPageContext);
    }

    public void setFromForPb(int i) {
        this.agi = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aiE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(final AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport)) {
            this.aiE.setVisibility(0);
            this.aiE.setData(absThreadDataSupport.bhz().bmf(), absThreadDataSupport.bhz().getTid(), absThreadDataSupport.bhz().getFid());
            this.aiE.setOnItemClickListener(new View.OnClickListener() { // from class: com.baidu.card.au.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ay.a(absThreadDataSupport, (Context) au.this.mPageContext.getPageActivity(), au.this.agi, false);
                }
            });
            return;
        }
        this.aiE.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aiE.onChangeSkinType(i);
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bhz() == null || absThreadDataSupport.bhz().bmf() == null || absThreadDataSupport.bhz().bmf().getOptions() == null || absThreadDataSupport.bhz().bmf().getOptions().size() <= 0 || absThreadDataSupport.bhz().biG()) ? false : true;
    }
}
