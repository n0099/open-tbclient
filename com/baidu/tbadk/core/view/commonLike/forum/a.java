package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel bUp;
    private com.baidu.tbadk.core.view.commonLike.b bUq;
    private b bUr;
    private View.OnClickListener bUs;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.bUr != null && l.equals(a.this.bUr.getForumId()) && aVar.isSuccess) {
                    a.this.bUr.setIsLike(true);
                    a.this.bUr.dj(true);
                    a.this.bUq.dU(true);
                }
            }
        }
    };
    private CustomMessageListener bUt = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.bUr != null && l.equals(a.this.bUr.getForumId()) && aVar.isSuccess) {
                    a.this.bUr.setIsLike(false);
                    a.this.bUr.dj(false);
                    a.this.bUq.dU(false);
                }
            }
        }
    };
    d bUu = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.aB(a.this.bUp.getErrorCode(), a.this.bUp.getErrorString())) {
                    AntiHelper.aV(a.this.mPageContext.getPageActivity(), a.this.bUp.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.bUp.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.bUp = new LikeModel(tbPageContext);
        this.bUp.setLoadDataCallBack(this.bUu);
        this.bUq = bVar;
        this.bUq.e(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.bUt);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.bUr = bVar;
            this.bUq.dU(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.bUt.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.bUs = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bUq != null) {
            this.bUq.aR(view);
        }
        if (!j.kY()) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        if (bc.cZ(this.mPageContext.getPageActivity())) {
            if (this.bUr != null) {
                this.bUp.dW(this.bUr.getForumName(), this.bUr.getForumId());
            } else {
                return;
            }
        }
        if (this.bUs != null) {
            this.bUs.onClick(view);
        }
    }
}
