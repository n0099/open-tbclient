package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel dYI;
    private com.baidu.tbadk.core.view.commonLike.b dYJ;
    private b dYK;
    private View.OnClickListener dYL;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.dYK != null && l.equals(a.this.dYK.getForumId()) && aVar.isSuccess) {
                    a.this.dYK.setIsLike(true);
                    a.this.dYK.gO(true);
                    a.this.dYJ.hr(true);
                }
            }
        }
    };
    private CustomMessageListener dYM = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.dYK != null && l.equals(a.this.dYK.getForumId()) && aVar.isSuccess) {
                    a.this.dYK.setIsLike(false);
                    a.this.dYK.gO(false);
                    a.this.dYJ.hr(false);
                }
            }
        }
    };
    d dYN = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof u) && ((u) obj).getErrorCode() != 0) {
                if (AntiHelper.bv(a.this.dYI.getErrorCode(), a.this.dYI.getErrorString())) {
                    AntiHelper.aX(a.this.mPageContext.getPageActivity(), a.this.dYI.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.dYI.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.dYI = new LikeModel(tbPageContext);
        this.dYI.setLoadDataCallBack(this.dYN);
        this.dYJ = bVar;
        this.dYJ.g(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.dYM);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.dYK = bVar;
            this.dYJ.hr(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.dYM.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.dYL = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dYJ != null) {
            this.dYJ.bc(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.dYK != null) {
                this.dYI.fq(this.dYK.getForumName(), this.dYK.getForumId());
            } else {
                return;
            }
        }
        if (this.dYL != null) {
            this.dYL.onClick(view);
        }
    }
}
