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
    private LikeModel aGV;
    private com.baidu.tbadk.core.view.commonLike.b aGW;
    private b aGX;
    private View.OnClickListener aGY;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aGX != null && l.equals(a.this.aGX.getForumId()) && aVar.isSuccess) {
                    a.this.aGX.setIsLike(true);
                    a.this.aGX.aI(true);
                    a.this.aGW.bs(true);
                }
            }
        }
    };
    private CustomMessageListener aGZ = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aGX != null && l.equals(a.this.aGX.getForumId()) && aVar.isSuccess) {
                    a.this.aGX.setIsLike(false);
                    a.this.aGX.aI(false);
                    a.this.aGW.bs(false);
                }
            }
        }
    };
    d aHa = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.am(a.this.aGV.getErrorCode(), a.this.aGV.getErrorString())) {
                    AntiHelper.aI(a.this.mPageContext.getPageActivity(), a.this.aGV.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.aGV.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.aGV = new LikeModel(tbPageContext);
        this.aGV.setLoadDataCallBack(this.aHa);
        this.aGW = bVar;
        this.aGW.c(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.aGZ);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.aGX = bVar;
            this.aGW.bs(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.aGZ.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.aGY = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aGW != null) {
            this.aGW.X(view);
        }
        if (!j.kX()) {
            this.mPageContext.showToast(e.j.neterror);
            return;
        }
        if (ba.bI(this.mPageContext.getPageActivity())) {
            if (this.aGX != null) {
                this.aGV.cF(this.aGX.getForumName(), this.aGX.getForumId());
            } else {
                return;
            }
        }
        if (this.aGY != null) {
            this.aGY.onClick(view);
        }
    }
}
