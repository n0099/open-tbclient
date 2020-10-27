package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel eTL;
    private com.baidu.tbadk.core.view.commonLike.b eTM;
    private b eTN;
    private View.OnClickListener eTO;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.eTN != null && l.equals(a.this.eTN.getForumId()) && aVar.isSuccess) {
                    a.this.eTN.setIsLike(true);
                    a.this.eTN.iD(true);
                    a.this.eTM.aN(true);
                }
            }
        }
    };
    private CustomMessageListener eTP = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.eTN != null && l.equals(a.this.eTN.getForumId()) && aVar.isSuccess) {
                    a.this.eTN.setIsLike(false);
                    a.this.eTN.iD(false);
                    a.this.eTM.aN(false);
                }
            }
        }
    };
    d eTQ = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof v) && ((v) obj).getErrorCode() != 0) {
                if (AntiHelper.bN(a.this.eTL.getErrorCode(), a.this.eTL.getErrorString())) {
                    AntiHelper.bm(a.this.mPageContext.getPageActivity(), a.this.eTL.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.eTL.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.eTL = new LikeModel(tbPageContext);
        this.eTL.setLoadDataCallBack(this.eTQ);
        this.eTM = bVar;
        this.eTM.g(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.eTP);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.eTN = bVar;
            this.eTM.aN(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.eTP.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.eTO = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eTM != null) {
            this.eTM.br(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.eTN != null) {
                this.eTL.gp(this.eTN.getForumName(), this.eTN.getForumId());
            } else {
                return;
            }
        }
        if (this.eTO != null) {
            this.eTO.onClick(view);
        }
    }
}
