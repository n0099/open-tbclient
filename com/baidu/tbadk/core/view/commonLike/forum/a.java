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
    private LikeModel cco;
    private com.baidu.tbadk.core.view.commonLike.b ccp;
    private b ccq;
    private View.OnClickListener ccr;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.ccq != null && l.equals(a.this.ccq.getForumId()) && aVar.isSuccess) {
                    a.this.ccq.setIsLike(true);
                    a.this.ccq.dE(true);
                    a.this.ccp.er(true);
                }
            }
        }
    };
    private CustomMessageListener cct = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.ccq != null && l.equals(a.this.ccq.getForumId()) && aVar.isSuccess) {
                    a.this.ccq.setIsLike(false);
                    a.this.ccq.dE(false);
                    a.this.ccp.er(false);
                }
            }
        }
    };
    d ccu = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.aG(a.this.cco.getErrorCode(), a.this.cco.getErrorString())) {
                    AntiHelper.aI(a.this.mPageContext.getPageActivity(), a.this.cco.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.cco.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.cco = new LikeModel(tbPageContext);
        this.cco.setLoadDataCallBack(this.ccu);
        this.ccp = bVar;
        this.ccp.e(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.cct);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.ccq = bVar;
            this.ccp.er(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.cct.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.ccr = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ccp != null) {
            this.ccp.aX(view);
        }
        if (!j.jS()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bc.cE(this.mPageContext.getPageActivity())) {
            if (this.ccq != null) {
                this.cco.ek(this.ccq.getForumName(), this.ccq.getForumId());
            } else {
                return;
            }
        }
        if (this.ccr != null) {
            this.ccr.onClick(view);
        }
    }
}
