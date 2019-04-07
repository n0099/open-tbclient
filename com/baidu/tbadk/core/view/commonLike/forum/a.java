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
    private LikeModel bUs;
    private com.baidu.tbadk.core.view.commonLike.b bUt;
    private b bUu;
    private View.OnClickListener bUv;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.bUu != null && l.equals(a.this.bUu.getForumId()) && aVar.isSuccess) {
                    a.this.bUu.setIsLike(true);
                    a.this.bUu.dj(true);
                    a.this.bUt.dU(true);
                }
            }
        }
    };
    private CustomMessageListener bUw = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.bUu != null && l.equals(a.this.bUu.getForumId()) && aVar.isSuccess) {
                    a.this.bUu.setIsLike(false);
                    a.this.bUu.dj(false);
                    a.this.bUt.dU(false);
                }
            }
        }
    };
    d bUx = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.aD(a.this.bUs.getErrorCode(), a.this.bUs.getErrorString())) {
                    AntiHelper.aU(a.this.mPageContext.getPageActivity(), a.this.bUs.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.bUs.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.bUs = new LikeModel(tbPageContext);
        this.bUs.setLoadDataCallBack(this.bUx);
        this.bUt = bVar;
        this.bUt.e(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.bUw);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.bUu = bVar;
            this.bUt.dU(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.bUw.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.bUv = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bUt != null) {
            this.bUt.aR(view);
        }
        if (!j.kY()) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        if (bc.cZ(this.mPageContext.getPageActivity())) {
            if (this.bUu != null) {
                this.bUs.dW(this.bUu.getForumName(), this.bUu.getForumId());
            } else {
                return;
            }
        }
        if (this.bUv != null) {
            this.bUv.onClick(view);
        }
    }
}
