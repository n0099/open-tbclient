package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel cdr;
    private com.baidu.tbadk.core.view.commonLike.b cds;
    private b cdt;
    private View.OnClickListener cdu;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.cdt != null && l.equals(a.this.cdt.getForumId()) && aVar.isSuccess) {
                    a.this.cdt.setIsLike(true);
                    a.this.cdt.dI(true);
                    a.this.cds.ev(true);
                }
            }
        }
    };
    private CustomMessageListener cdv = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.cdt != null && l.equals(a.this.cdt.getForumId()) && aVar.isSuccess) {
                    a.this.cdt.setIsLike(false);
                    a.this.cdt.dI(false);
                    a.this.cds.ev(false);
                }
            }
        }
    };
    d cdw = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.aG(a.this.cdr.getErrorCode(), a.this.cdr.getErrorString())) {
                    AntiHelper.aJ(a.this.mPageContext.getPageActivity(), a.this.cdr.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.cdr.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.cdr = new LikeModel(tbPageContext);
        this.cdr.setLoadDataCallBack(this.cdw);
        this.cds = bVar;
        this.cds.e(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.cdv);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.cdt = bVar;
            this.cds.ev(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.cdv.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.cdu = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cds != null) {
            this.cds.aZ(view);
        }
        if (!j.kc()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bd.cF(this.mPageContext.getPageActivity())) {
            if (this.cdt != null) {
                this.cdr.el(this.cdt.getForumName(), this.cdt.getForumId());
            } else {
                return;
            }
        }
        if (this.cdu != null) {
            this.cdu.onClick(view);
        }
    }
}
