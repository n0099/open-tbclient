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
    private LikeModel aLn;
    private com.baidu.tbadk.core.view.commonLike.b aLo;
    private b aLp;
    private View.OnClickListener aLq;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aLp != null && l.equals(a.this.aLp.getForumId()) && aVar.isSuccess) {
                    a.this.aLp.setIsLike(true);
                    a.this.aLp.aZ(true);
                    a.this.aLo.bK(true);
                }
            }
        }
    };
    private CustomMessageListener aLr = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aLp != null && l.equals(a.this.aLp.getForumId()) && aVar.isSuccess) {
                    a.this.aLp.setIsLike(false);
                    a.this.aLp.aZ(false);
                    a.this.aLo.bK(false);
                }
            }
        }
    };
    d aLs = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.aj(a.this.aLn.getErrorCode(), a.this.aLn.getErrorString())) {
                    AntiHelper.aJ(a.this.mPageContext.getPageActivity(), a.this.aLn.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.aLn.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.aLn = new LikeModel(tbPageContext);
        this.aLn.setLoadDataCallBack(this.aLs);
        this.aLo = bVar;
        this.aLo.d(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.aLr);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.aLp = bVar;
            this.aLo.bK(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.aLr.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.aLq = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aLo != null) {
            this.aLo.X(view);
        }
        if (!j.kV()) {
            this.mPageContext.showToast(e.j.neterror);
            return;
        }
        if (ba.bJ(this.mPageContext.getPageActivity())) {
            if (this.aLp != null) {
                this.aLn.cK(this.aLp.getForumName(), this.aLp.getForumId());
            } else {
                return;
            }
        }
        if (this.aLq != null) {
            this.aLq.onClick(view);
        }
    }
}
