package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel azn;
    private com.baidu.tbadk.core.view.commonLike.b azo;
    private b azp;
    private View.OnClickListener azq;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.azp != null && l.equals(a.this.azp.getForumId()) && aVar.isSuccess) {
                    a.this.azp.setIsLike(true);
                    a.this.azp.ap(true);
                    a.this.azo.aW(true);
                }
            }
        }
    };
    private CustomMessageListener azr = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.azp != null && l.equals(a.this.azp.getForumId()) && aVar.isSuccess) {
                    a.this.azp.setIsLike(false);
                    a.this.azp.ap(false);
                    a.this.azo.aW(false);
                }
            }
        }
    };
    d azs = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.al(a.this.azn.getErrorCode(), a.this.azn.getErrorString())) {
                    AntiHelper.aq(a.this.mPageContext.getPageActivity(), a.this.azn.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.azn.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.azn = new LikeModel(tbPageContext);
        this.azn.setLoadDataCallBack(this.azs);
        this.azo = bVar;
        this.azo.c(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.azr);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.azp = bVar;
            this.azo.aW(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.azr.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.azq = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.azo != null) {
            this.azo.L(view);
        }
        if (!j.jE()) {
            this.mPageContext.showToast(f.j.neterror);
            return;
        }
        if (bb.aU(this.mPageContext.getPageActivity())) {
            if (this.azp != null) {
                this.azn.ck(this.azp.getForumName(), this.azp.getForumId());
            } else {
                return;
            }
        }
        if (this.azq != null) {
            this.azq.onClick(view);
        }
    }
}
