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
    private LikeModel aCp;
    private com.baidu.tbadk.core.view.commonLike.b aCq;
    private b aCr;
    private View.OnClickListener aCs;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aCr != null && l.equals(a.this.aCr.getForumId()) && aVar.isSuccess) {
                    a.this.aCr.setIsLike(true);
                    a.this.aCr.ay(true);
                    a.this.aCq.bi(true);
                }
            }
        }
    };
    private CustomMessageListener aCt = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aCr != null && l.equals(a.this.aCr.getForumId()) && aVar.isSuccess) {
                    a.this.aCr.setIsLike(false);
                    a.this.aCr.ay(false);
                    a.this.aCq.bi(false);
                }
            }
        }
    };
    d aCu = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void j(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.am(a.this.aCp.getErrorCode(), a.this.aCp.getErrorString())) {
                    AntiHelper.aG(a.this.mPageContext.getPageActivity(), a.this.aCp.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.aCp.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.aCp = new LikeModel(tbPageContext);
        this.aCp.setLoadDataCallBack(this.aCu);
        this.aCq = bVar;
        this.aCq.c(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.aCt);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.aCr = bVar;
            this.aCq.bi(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.aCt.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.aCs = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aCq != null) {
            this.aCq.X(view);
        }
        if (!j.kK()) {
            this.mPageContext.showToast(e.j.neterror);
            return;
        }
        if (ba.bA(this.mPageContext.getPageActivity())) {
            if (this.aCr != null) {
                this.aCp.cu(this.aCr.getForumName(), this.aCr.getForumId());
            } else {
                return;
            }
        }
        if (this.aCs != null) {
            this.aCs.onClick(view);
        }
    }
}
