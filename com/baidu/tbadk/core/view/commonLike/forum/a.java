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
    private LikeModel crO;
    private com.baidu.tbadk.core.view.commonLike.b crP;
    private b crQ;
    private View.OnClickListener crR;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.crQ != null && l.equals(a.this.crQ.getForumId()) && aVar.isSuccess) {
                    a.this.crQ.setIsLike(true);
                    a.this.crQ.dY(true);
                    a.this.crP.ew(true);
                }
            }
        }
    };
    private CustomMessageListener crS = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.crQ != null && l.equals(a.this.crQ.getForumId()) && aVar.isSuccess) {
                    a.this.crQ.setIsLike(false);
                    a.this.crQ.dY(false);
                    a.this.crP.ew(false);
                }
            }
        }
    };
    d crT = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof t) && ((t) obj).getErrorCode() != 0) {
                if (AntiHelper.aG(a.this.crO.getErrorCode(), a.this.crO.getErrorString())) {
                    AntiHelper.aS(a.this.mPageContext.getPageActivity(), a.this.crO.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.crO.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.crO = new LikeModel(tbPageContext);
        this.crO.setLoadDataCallBack(this.crT);
        this.crP = bVar;
        this.crP.f(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.crS);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.crQ = bVar;
            this.crP.ew(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.crS.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.crR = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.crP != null) {
            this.crP.aZ(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.crQ != null) {
                this.crO.dY(this.crQ.getForumName(), this.crQ.getForumId());
            } else {
                return;
            }
        }
        if (this.crR != null) {
            this.crR.onClick(view);
        }
    }
}
