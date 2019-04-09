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
    private LikeModel bUt;
    private com.baidu.tbadk.core.view.commonLike.b bUu;
    private b bUv;
    private View.OnClickListener bUw;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.bUv != null && l.equals(a.this.bUv.getForumId()) && aVar.isSuccess) {
                    a.this.bUv.setIsLike(true);
                    a.this.bUv.dj(true);
                    a.this.bUu.dU(true);
                }
            }
        }
    };
    private CustomMessageListener bUx = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.bUv != null && l.equals(a.this.bUv.getForumId()) && aVar.isSuccess) {
                    a.this.bUv.setIsLike(false);
                    a.this.bUv.dj(false);
                    a.this.bUu.dU(false);
                }
            }
        }
    };
    d bUy = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.aD(a.this.bUt.getErrorCode(), a.this.bUt.getErrorString())) {
                    AntiHelper.aU(a.this.mPageContext.getPageActivity(), a.this.bUt.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.bUt.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.bUt = new LikeModel(tbPageContext);
        this.bUt.setLoadDataCallBack(this.bUy);
        this.bUu = bVar;
        this.bUu.e(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.bUx);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.bUv = bVar;
            this.bUu.dU(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.bUx.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.bUw = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bUu != null) {
            this.bUu.aR(view);
        }
        if (!j.kY()) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        if (bc.cZ(this.mPageContext.getPageActivity())) {
            if (this.bUv != null) {
                this.bUt.dW(this.bUv.getForumName(), this.bUv.getForumId());
            } else {
                return;
            }
        }
        if (this.bUw != null) {
            this.bUw.onClick(view);
        }
    }
}
