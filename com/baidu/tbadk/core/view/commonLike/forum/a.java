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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private b cdA;
    private View.OnClickListener cdB;
    private LikeModel cdy;
    private com.baidu.tbadk.core.view.commonLike.b cdz;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.cdA != null && l.equals(a.this.cdA.getForumId()) && aVar.isSuccess) {
                    a.this.cdA.setIsLike(true);
                    a.this.cdA.dI(true);
                    a.this.cdz.ev(true);
                }
            }
        }
    };
    private CustomMessageListener cdC = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.cdA != null && l.equals(a.this.cdA.getForumId()) && aVar.isSuccess) {
                    a.this.cdA.setIsLike(false);
                    a.this.cdA.dI(false);
                    a.this.cdz.ev(false);
                }
            }
        }
    };
    d cdD = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof t) && ((t) obj).getErrorCode() != 0) {
                if (AntiHelper.aG(a.this.cdy.getErrorCode(), a.this.cdy.getErrorString())) {
                    AntiHelper.aJ(a.this.mPageContext.getPageActivity(), a.this.cdy.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.cdy.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.cdy = new LikeModel(tbPageContext);
        this.cdy.setLoadDataCallBack(this.cdD);
        this.cdz = bVar;
        this.cdz.e(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.cdC);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.cdA = bVar;
            this.cdz.ev(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.cdC.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.cdB = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cdz != null) {
            this.cdz.aZ(view);
        }
        if (!j.kc()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bd.cF(this.mPageContext.getPageActivity())) {
            if (this.cdA != null) {
                this.cdy.el(this.cdA.getForumName(), this.cdA.getForumId());
            } else {
                return;
            }
        }
        if (this.cdB != null) {
            this.cdB.onClick(view);
        }
    }
}
