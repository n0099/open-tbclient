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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel dfN;
    private com.baidu.tbadk.core.view.commonLike.b dfO;
    private b dfP;
    private View.OnClickListener dfQ;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.dfP != null && l.equals(a.this.dfP.getForumId()) && aVar.isSuccess) {
                    a.this.dfP.setIsLike(true);
                    a.this.dfP.fr(true);
                    a.this.dfO.fN(true);
                }
            }
        }
    };
    private CustomMessageListener dfR = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.dfP != null && l.equals(a.this.dfP.getForumId()) && aVar.isSuccess) {
                    a.this.dfP.setIsLike(false);
                    a.this.dfP.fr(false);
                    a.this.dfO.fN(false);
                }
            }
        }
    };
    d dfS = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof t) && ((t) obj).getErrorCode() != 0) {
                if (AntiHelper.bc(a.this.dfN.getErrorCode(), a.this.dfN.getErrorString())) {
                    AntiHelper.bn(a.this.mPageContext.getPageActivity(), a.this.dfN.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.dfN.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.dfN = new LikeModel(tbPageContext);
        this.dfN.setLoadDataCallBack(this.dfS);
        this.dfO = bVar;
        this.dfO.g(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.dfR);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.dfP = bVar;
            this.dfO.fN(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.dfR.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.dfQ = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dfO != null) {
            this.dfO.ba(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.dfP != null) {
                this.dfN.et(this.dfP.getForumName(), this.dfP.getForumId());
            } else {
                return;
            }
        }
        if (this.dfQ != null) {
            this.dfQ.onClick(view);
        }
    }
}
