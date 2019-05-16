package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel ccn;
    private com.baidu.tbadk.core.view.commonLike.b cco;
    private b ccp;
    private View.OnClickListener ccq;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.ccp != null && l.equals(a.this.ccp.getForumId()) && aVar.isSuccess) {
                    a.this.ccp.setIsLike(true);
                    a.this.ccp.dE(true);
                    a.this.cco.er(true);
                }
            }
        }
    };
    private CustomMessageListener ccr = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.ccp != null && l.equals(a.this.ccp.getForumId()) && aVar.isSuccess) {
                    a.this.ccp.setIsLike(false);
                    a.this.ccp.dE(false);
                    a.this.cco.er(false);
                }
            }
        }
    };
    d cct = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.aG(a.this.ccn.getErrorCode(), a.this.ccn.getErrorString())) {
                    AntiHelper.aI(a.this.mPageContext.getPageActivity(), a.this.ccn.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.ccn.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.ccn = new LikeModel(tbPageContext);
        this.ccn.setLoadDataCallBack(this.cct);
        this.cco = bVar;
        this.cco.e(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.ccr);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.ccp = bVar;
            this.cco.er(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.ccr.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.ccq = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cco != null) {
            this.cco.aX(view);
        }
        if (!j.jS()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bc.cE(this.mPageContext.getPageActivity())) {
            if (this.ccp != null) {
                this.ccn.ek(this.ccp.getForumName(), this.ccp.getForumId());
            } else {
                return;
            }
        }
        if (this.ccq != null) {
            this.ccq.onClick(view);
        }
    }
}
