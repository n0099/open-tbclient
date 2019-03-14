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
    private LikeModel bUq;
    private com.baidu.tbadk.core.view.commonLike.b bUr;
    private b bUs;
    private View.OnClickListener bUt;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.bUs != null && l.equals(a.this.bUs.getForumId()) && aVar.isSuccess) {
                    a.this.bUs.setIsLike(true);
                    a.this.bUs.dj(true);
                    a.this.bUr.dU(true);
                }
            }
        }
    };
    private CustomMessageListener bUu = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.bUs != null && l.equals(a.this.bUs.getForumId()) && aVar.isSuccess) {
                    a.this.bUs.setIsLike(false);
                    a.this.bUs.dj(false);
                    a.this.bUr.dU(false);
                }
            }
        }
    };
    d bUv = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.aB(a.this.bUq.getErrorCode(), a.this.bUq.getErrorString())) {
                    AntiHelper.aU(a.this.mPageContext.getPageActivity(), a.this.bUq.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.bUq.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.bUq = new LikeModel(tbPageContext);
        this.bUq.setLoadDataCallBack(this.bUv);
        this.bUr = bVar;
        this.bUr.e(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.bUu);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.bUs = bVar;
            this.bUr.dU(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.bUu.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.bUt = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bUr != null) {
            this.bUr.aR(view);
        }
        if (!j.kY()) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        if (bc.cZ(this.mPageContext.getPageActivity())) {
            if (this.bUs != null) {
                this.bUq.dV(this.bUs.getForumName(), this.bUs.getForumId());
            } else {
                return;
            }
        }
        if (this.bUt != null) {
            this.bUt.onClick(view);
        }
    }
}
