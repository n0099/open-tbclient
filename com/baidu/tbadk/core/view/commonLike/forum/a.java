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
    private LikeModel ezi;
    private com.baidu.tbadk.core.view.commonLike.b ezj;
    private b ezk;
    private View.OnClickListener ezl;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.ezk != null && l.equals(a.this.ezk.getForumId()) && aVar.isSuccess) {
                    a.this.ezk.setIsLike(true);
                    a.this.ezk.hU(true);
                    a.this.ezj.aN(true);
                }
            }
        }
    };
    private CustomMessageListener ezm = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.ezk != null && l.equals(a.this.ezk.getForumId()) && aVar.isSuccess) {
                    a.this.ezk.setIsLike(false);
                    a.this.ezk.hU(false);
                    a.this.ezj.aN(false);
                }
            }
        }
    };
    d ezn = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof v) && ((v) obj).getErrorCode() != 0) {
                if (AntiHelper.bC(a.this.ezi.getErrorCode(), a.this.ezi.getErrorString())) {
                    AntiHelper.bh(a.this.mPageContext.getPageActivity(), a.this.ezi.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.ezi.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.ezi = new LikeModel(tbPageContext);
        this.ezi.setLoadDataCallBack(this.ezn);
        this.ezj = bVar;
        this.ezj.g(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.ezm);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.ezk = bVar;
            this.ezj.aN(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.ezm.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.ezl = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ezj != null) {
            this.ezj.bm(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.ezk != null) {
                this.ezi.gd(this.ezk.getForumName(), this.ezk.getForumId());
            } else {
                return;
            }
        }
        if (this.ezl != null) {
            this.ezl.onClick(view);
        }
    }
}
