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
    private LikeModel eZA;
    private com.baidu.tbadk.core.view.commonLike.b eZB;
    private b eZC;
    private View.OnClickListener eZD;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.eZC != null && l.equals(a.this.eZC.getForumId()) && aVar.isSuccess) {
                    a.this.eZC.setIsLike(true);
                    a.this.eZC.iM(true);
                    a.this.eZB.aN(true);
                }
            }
        }
    };
    private CustomMessageListener eZE = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.eZC != null && l.equals(a.this.eZC.getForumId()) && aVar.isSuccess) {
                    a.this.eZC.setIsLike(false);
                    a.this.eZC.iM(false);
                    a.this.eZB.aN(false);
                }
            }
        }
    };
    d eZF = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof v) && ((v) obj).getErrorCode() != 0) {
                if (AntiHelper.bR(a.this.eZA.getErrorCode(), a.this.eZA.getErrorString())) {
                    AntiHelper.bm(a.this.mPageContext.getPageActivity(), a.this.eZA.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.eZA.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.eZA = new LikeModel(tbPageContext);
        this.eZA.setLoadDataCallBack(this.eZF);
        this.eZB = bVar;
        this.eZB.h(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.eZE);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.eZC = bVar;
            this.eZB.aN(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.eZE.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.eZD = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eZB != null) {
            this.eZB.bv(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.eZC != null) {
                this.eZA.gp(this.eZC.getForumName(), this.eZC.getForumId());
            } else {
                return;
            }
        }
        if (this.eZD != null) {
            this.eZD.onClick(view);
        }
    }
}
