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
    private LikeModel aLQ;
    private com.baidu.tbadk.core.view.commonLike.b aLR;
    private b aLS;
    private View.OnClickListener aLT;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aLS != null && l.equals(a.this.aLS.getForumId()) && aVar.isSuccess) {
                    a.this.aLS.setIsLike(true);
                    a.this.aLS.ba(true);
                    a.this.aLR.bL(true);
                }
            }
        }
    };
    private CustomMessageListener aLU = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aLS != null && l.equals(a.this.aLS.getForumId()) && aVar.isSuccess) {
                    a.this.aLS.setIsLike(false);
                    a.this.aLS.ba(false);
                    a.this.aLR.bL(false);
                }
            }
        }
    };
    d aLV = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.al(a.this.aLQ.getErrorCode(), a.this.aLQ.getErrorString())) {
                    AntiHelper.aH(a.this.mPageContext.getPageActivity(), a.this.aLQ.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.aLQ.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.aLQ = new LikeModel(tbPageContext);
        this.aLQ.setLoadDataCallBack(this.aLV);
        this.aLR = bVar;
        this.aLR.d(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.aLU);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.aLS = bVar;
            this.aLR.bL(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.aLU.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.aLT = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aLR != null) {
            this.aLR.X(view);
        }
        if (!j.kV()) {
            this.mPageContext.showToast(e.j.neterror);
            return;
        }
        if (ba.bJ(this.mPageContext.getPageActivity())) {
            if (this.aLS != null) {
                this.aLQ.cM(this.aLS.getForumName(), this.aLS.getForumId());
            } else {
                return;
            }
        }
        if (this.aLT != null) {
            this.aLT.onClick(view);
        }
    }
}
