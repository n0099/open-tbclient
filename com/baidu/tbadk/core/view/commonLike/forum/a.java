package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel azq;
    private com.baidu.tbadk.core.view.commonLike.b azr;
    private b azs;
    private View.OnClickListener azt;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001437) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.azs != null && l.equals(a.this.azs.getForumId()) && aVar.isSuccess) {
                    a.this.azs.setIsLike(true);
                    a.this.azs.ao(true);
                    a.this.azr.aV(true);
                }
            }
        }
    };
    private CustomMessageListener azu = new CustomMessageListener(2001438) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.azs != null && l.equals(a.this.azs.getForumId()) && aVar.isSuccess) {
                    a.this.azs.setIsLike(false);
                    a.this.azs.ao(false);
                    a.this.azr.aV(false);
                }
            }
        }
    };
    d azv = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if ((obj instanceof r) && ((r) obj).getErrorCode() != 0) {
                if (AntiHelper.al(a.this.azq.getErrorCode(), a.this.azq.getErrorString())) {
                    AntiHelper.aq(a.this.mPageContext.getPageActivity(), a.this.azq.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.azq.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.azq = new LikeModel(tbPageContext);
        this.azq.setLoadDataCallBack(this.azv);
        this.azr = bVar;
        this.azr.c(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.azu);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.azs = bVar;
            this.azr.aV(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.azu.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.azt = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.azr != null) {
            this.azr.L(view);
        }
        if (!j.jE()) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        if (ba.aV(this.mPageContext.getPageActivity())) {
            if (this.azs != null) {
                this.azq.ck(this.azs.getForumName(), this.azs.getForumId());
            } else {
                return;
            }
        }
        if (this.azt != null) {
            this.azt.onClick(view);
        }
    }
}
