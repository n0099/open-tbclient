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
    private LikeModel aHL;
    private com.baidu.tbadk.core.view.commonLike.b aHM;
    private b aHN;
    private View.OnClickListener aHO;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aHN != null && l.equals(a.this.aHN.getForumId()) && aVar.isSuccess) {
                    a.this.aHN.setIsLike(true);
                    a.this.aHN.aY(true);
                    a.this.aHM.bJ(true);
                }
            }
        }
    };
    private CustomMessageListener aHP = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aHN != null && l.equals(a.this.aHN.getForumId()) && aVar.isSuccess) {
                    a.this.aHN.setIsLike(false);
                    a.this.aHN.aY(false);
                    a.this.aHM.bJ(false);
                }
            }
        }
    };
    d aHQ = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.ai(a.this.aHL.getErrorCode(), a.this.aHL.getErrorString())) {
                    AntiHelper.aG(a.this.mPageContext.getPageActivity(), a.this.aHL.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.aHL.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.aHL = new LikeModel(tbPageContext);
        this.aHL.setLoadDataCallBack(this.aHQ);
        this.aHM = bVar;
        this.aHM.d(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.aHP);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.aHN = bVar;
            this.aHM.bJ(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.aHP.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.aHO = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aHM != null) {
            this.aHM.X(view);
        }
        if (!j.kV()) {
            this.mPageContext.showToast(e.j.neterror);
            return;
        }
        if (ba.bG(this.mPageContext.getPageActivity())) {
            if (this.aHN != null) {
                this.aHL.cF(this.aHN.getForumName(), this.aHN.getForumId());
            } else {
                return;
            }
        }
        if (this.aHO != null) {
            this.aHO.onClick(view);
        }
    }
}
