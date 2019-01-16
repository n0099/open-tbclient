package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel aLP;
    private com.baidu.tbadk.core.view.commonLike.b aLQ;
    private b aLR;
    private View.OnClickListener aLS;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aLR != null && l.equals(a.this.aLR.getForumId()) && aVar.isSuccess) {
                    a.this.aLR.setIsLike(true);
                    a.this.aLR.ba(true);
                    a.this.aLQ.bL(true);
                }
            }
        }
    };
    private CustomMessageListener aLT = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aLR != null && l.equals(a.this.aLR.getForumId()) && aVar.isSuccess) {
                    a.this.aLR.setIsLike(false);
                    a.this.aLR.ba(false);
                    a.this.aLQ.bL(false);
                }
            }
        }
    };
    d aLU = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.al(a.this.aLP.getErrorCode(), a.this.aLP.getErrorString())) {
                    AntiHelper.aH(a.this.mPageContext.getPageActivity(), a.this.aLP.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.aLP.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.aLP = new LikeModel(tbPageContext);
        this.aLP.setLoadDataCallBack(this.aLU);
        this.aLQ = bVar;
        this.aLQ.d(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.aLT);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.aLR = bVar;
            this.aLQ.bL(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.aLT.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.aLS = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aLQ != null) {
            this.aLQ.X(view);
        }
        if (!j.kV()) {
            this.mPageContext.showToast(e.j.neterror);
            return;
        }
        if (ba.bJ(this.mPageContext.getPageActivity())) {
            if (this.aLR != null) {
                this.aLP.cM(this.aLR.getForumName(), this.aLR.getForumId());
            } else {
                return;
            }
        }
        if (this.aLS != null) {
            this.aLS.onClick(view);
        }
    }
}
