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
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private LikeModel ewX;
    private com.baidu.tbadk.core.view.commonLike.b ewY;
    private b ewZ;
    private View.OnClickListener exa;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.ewZ != null && l.equals(a.this.ewZ.getForumId()) && aVar.isSuccess) {
                    a.this.ewZ.setIsLike(true);
                    a.this.ewZ.hW(true);
                    a.this.ewY.aN(true);
                }
            }
        }
    };
    private CustomMessageListener exb = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.ewZ != null && l.equals(a.this.ewZ.getForumId()) && aVar.isSuccess) {
                    a.this.ewZ.setIsLike(false);
                    a.this.ewZ.hW(false);
                    a.this.ewY.aN(false);
                }
            }
        }
    };
    d exc = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof v) && ((v) obj).getErrorCode() != 0) {
                if (AntiHelper.bz(a.this.ewX.getErrorCode(), a.this.ewX.getErrorString())) {
                    AntiHelper.bb(a.this.mPageContext.getPageActivity(), a.this.ewX.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.ewX.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.ewX = new LikeModel(tbPageContext);
        this.ewX.setLoadDataCallBack(this.exc);
        this.ewY = bVar;
        this.ewY.g(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.exb);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.ewZ = bVar;
            this.ewY.aN(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.exb.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.exa = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ewY != null) {
            this.ewY.bk(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.ewZ != null) {
                this.ewX.fQ(this.ewZ.getForumName(), this.ewZ.getForumId());
            } else {
                return;
            }
        }
        if (this.exa != null) {
            this.exa.onClick(view);
        }
    }
}
