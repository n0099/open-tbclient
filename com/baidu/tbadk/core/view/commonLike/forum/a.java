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
    private LikeModel aLl;
    private com.baidu.tbadk.core.view.commonLike.b aLm;
    private b aLn;
    private View.OnClickListener aLo;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aLn != null && l.equals(a.this.aLn.getForumId()) && aVar.isSuccess) {
                    a.this.aLn.setIsLike(true);
                    a.this.aLn.aZ(true);
                    a.this.aLm.bK(true);
                }
            }
        }
    };
    private CustomMessageListener aLp = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.aLn != null && l.equals(a.this.aLn.getForumId()) && aVar.isSuccess) {
                    a.this.aLn.setIsLike(false);
                    a.this.aLn.aZ(false);
                    a.this.aLm.bK(false);
                }
            }
        }
    };
    d aLq = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.ai(a.this.aLl.getErrorCode(), a.this.aLl.getErrorString())) {
                    AntiHelper.aJ(a.this.mPageContext.getPageActivity(), a.this.aLl.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.aLl.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.aLl = new LikeModel(tbPageContext);
        this.aLl.setLoadDataCallBack(this.aLq);
        this.aLm = bVar;
        this.aLm.d(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.aLp);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.aLn = bVar;
            this.aLm.bK(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.aLp.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.aLo = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aLm != null) {
            this.aLm.X(view);
        }
        if (!j.kV()) {
            this.mPageContext.showToast(e.j.neterror);
            return;
        }
        if (ba.bJ(this.mPageContext.getPageActivity())) {
            if (this.aLn != null) {
                this.aLl.cK(this.aLn.getForumName(), this.aLn.getForumId());
            } else {
                return;
            }
        }
        if (this.aLo != null) {
            this.aLo.onClick(view);
        }
    }
}
