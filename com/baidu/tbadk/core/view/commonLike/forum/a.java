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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel cer;
    private com.baidu.tbadk.core.view.commonLike.b ces;
    private b cet;
    private View.OnClickListener ceu;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.cet != null && l.equals(a.this.cet.getForumId()) && aVar.isSuccess) {
                    a.this.cet.setIsLike(true);
                    a.this.cet.dI(true);
                    a.this.ces.ey(true);
                }
            }
        }
    };
    private CustomMessageListener cev = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.cet != null && l.equals(a.this.cet.getForumId()) && aVar.isSuccess) {
                    a.this.cet.setIsLike(false);
                    a.this.cet.dI(false);
                    a.this.ces.ey(false);
                }
            }
        }
    };
    d cew = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof t) && ((t) obj).getErrorCode() != 0) {
                if (AntiHelper.aG(a.this.cer.getErrorCode(), a.this.cer.getErrorString())) {
                    AntiHelper.aQ(a.this.mPageContext.getPageActivity(), a.this.cer.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.cer.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.cer = new LikeModel(tbPageContext);
        this.cer.setLoadDataCallBack(this.cew);
        this.ces = bVar;
        this.ces.e(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.cev);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.cet = bVar;
            this.ces.ey(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.cev.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.ceu = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ces != null) {
            this.ces.aZ(view);
        }
        if (!j.kc()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bc.cF(this.mPageContext.getPageActivity())) {
            if (this.cet != null) {
                this.cer.em(this.cet.getForumName(), this.cet.getForumId());
            } else {
                return;
            }
        }
        if (this.ceu != null) {
            this.ceu.onClick(view);
        }
    }
}
