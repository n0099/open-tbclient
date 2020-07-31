package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel emT;
    private com.baidu.tbadk.core.view.commonLike.b emU;
    private b emV;
    private View.OnClickListener emW;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.emV != null && l.equals(a.this.emV.getForumId()) && aVar.isSuccess) {
                    a.this.emV.setIsLike(true);
                    a.this.emV.hA(true);
                    a.this.emU.aM(true);
                }
            }
        }
    };
    private CustomMessageListener emX = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.emV != null && l.equals(a.this.emV.getForumId()) && aVar.isSuccess) {
                    a.this.emV.setIsLike(false);
                    a.this.emV.hA(false);
                    a.this.emU.aM(false);
                }
            }
        }
    };
    d emY = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof u) && ((u) obj).getErrorCode() != 0) {
                if (AntiHelper.bB(a.this.emT.getErrorCode(), a.this.emT.getErrorString())) {
                    AntiHelper.aW(a.this.mPageContext.getPageActivity(), a.this.emT.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.emT.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.emT = new LikeModel(tbPageContext);
        this.emT.setLoadDataCallBack(this.emY);
        this.emU = bVar;
        this.emU.g(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.emX);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.emV = bVar;
            this.emU.aM(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.emX.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.emW = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.emU != null) {
            this.emU.bi(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bf.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.emV != null) {
                this.emT.fz(this.emV.getForumName(), this.emV.getForumId());
            } else {
                return;
            }
        }
        if (this.emW != null) {
            this.emW.onClick(view);
        }
    }
}
