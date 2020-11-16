package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel eYI;
    private com.baidu.tbadk.core.view.commonLike.b eYJ;
    private b eYK;
    private View.OnClickListener eYL;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.eYK != null && l.equals(a.this.eYK.getForumId()) && aVar.isSuccess) {
                    a.this.eYK.setIsLike(true);
                    a.this.eYK.iN(true);
                    a.this.eYJ.aP(true);
                }
            }
        }
    };
    private CustomMessageListener eYM = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.eYK != null && l.equals(a.this.eYK.getForumId()) && aVar.isSuccess) {
                    a.this.eYK.setIsLike(false);
                    a.this.eYK.iN(false);
                    a.this.eYJ.aP(false);
                }
            }
        }
    };
    d eYN = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof v) && ((v) obj).getErrorCode() != 0) {
                if (AntiHelper.bP(a.this.eYI.getErrorCode(), a.this.eYI.getErrorString())) {
                    AntiHelper.bj(a.this.mPageContext.getPageActivity(), a.this.eYI.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.eYI.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.eYI = new LikeModel(tbPageContext);
        this.eYI.setLoadDataCallBack(this.eYN);
        this.eYJ = bVar;
        this.eYJ.h(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.eYM);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.eYK = bVar;
            this.eYJ.aP(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.eYM.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.eYL = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eYJ != null) {
            this.eYJ.by(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.eYK != null) {
                this.eYI.gp(this.eYK.getForumName(), this.eYK.getForumId());
            } else {
                return;
            }
        }
        if (this.eYL != null) {
            this.eYL.onClick(view);
        }
    }
}
