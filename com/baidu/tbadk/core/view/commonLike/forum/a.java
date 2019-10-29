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
    private LikeModel csF;
    private com.baidu.tbadk.core.view.commonLike.b csG;
    private b csH;
    private View.OnClickListener csI;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.csH != null && l.equals(a.this.csH.getForumId()) && aVar.isSuccess) {
                    a.this.csH.setIsLike(true);
                    a.this.csH.dY(true);
                    a.this.csG.ew(true);
                }
            }
        }
    };
    private CustomMessageListener csJ = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.csH != null && l.equals(a.this.csH.getForumId()) && aVar.isSuccess) {
                    a.this.csH.setIsLike(false);
                    a.this.csH.dY(false);
                    a.this.csG.ew(false);
                }
            }
        }
    };
    d csK = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof t) && ((t) obj).getErrorCode() != 0) {
                if (AntiHelper.aH(a.this.csF.getErrorCode(), a.this.csF.getErrorString())) {
                    AntiHelper.aS(a.this.mPageContext.getPageActivity(), a.this.csF.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.csF.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.csF = new LikeModel(tbPageContext);
        this.csF.setLoadDataCallBack(this.csK);
        this.csG = bVar;
        this.csG.f(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.csJ);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.csH = bVar;
            this.csG.ew(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.csJ.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.csI = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.csG != null) {
            this.csG.aZ(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.csH != null) {
                this.csF.dY(this.csH.getForumName(), this.csH.getForumId());
            } else {
                return;
            }
        }
        if (this.csI != null) {
            this.csI.onClick(view);
        }
    }
}
