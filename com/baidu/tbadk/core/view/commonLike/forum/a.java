package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel egK;
    private com.baidu.tbadk.core.view.commonLike.b egL;
    private b egM;
    private View.OnClickListener egN;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.egM != null && l.equals(a.this.egM.getForumId()) && aVar.isSuccess) {
                    a.this.egM.setIsLike(true);
                    a.this.egM.gW(true);
                    a.this.egL.hA(true);
                }
            }
        }
    };
    private CustomMessageListener egO = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.egM != null && l.equals(a.this.egM.getForumId()) && aVar.isSuccess) {
                    a.this.egM.setIsLike(false);
                    a.this.egM.gW(false);
                    a.this.egL.hA(false);
                }
            }
        }
    };
    d egP = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof u) && ((u) obj).getErrorCode() != 0) {
                if (AntiHelper.bA(a.this.egK.getErrorCode(), a.this.egK.getErrorString())) {
                    AntiHelper.aX(a.this.mPageContext.getPageActivity(), a.this.egK.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.egK.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.egK = new LikeModel(tbPageContext);
        this.egK.setLoadDataCallBack(this.egP);
        this.egL = bVar;
        this.egL.g(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.egO);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.egM = bVar;
            this.egL.hA(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.egO.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.egN = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.egL != null) {
            this.egL.bc(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (be.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.egM != null) {
                this.egK.fx(this.egM.getForumName(), this.egM.getForumId());
            } else {
                return;
            }
        }
        if (this.egN != null) {
            this.egN.onClick(view);
        }
    }
}
