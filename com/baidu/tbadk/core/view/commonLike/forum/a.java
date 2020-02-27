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
    private LikeModel djT;
    private com.baidu.tbadk.core.view.commonLike.b djU;
    private b djV;
    private View.OnClickListener djW;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.djV != null && l.equals(a.this.djV.getForumId()) && aVar.isSuccess) {
                    a.this.djV.setIsLike(true);
                    a.this.djV.fy(true);
                    a.this.djU.fU(true);
                }
            }
        }
    };
    private CustomMessageListener djX = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.djV != null && l.equals(a.this.djV.getForumId()) && aVar.isSuccess) {
                    a.this.djV.setIsLike(false);
                    a.this.djV.fy(false);
                    a.this.djU.fU(false);
                }
            }
        }
    };
    d djY = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof t) && ((t) obj).getErrorCode() != 0) {
                if (AntiHelper.bb(a.this.djT.getErrorCode(), a.this.djT.getErrorString())) {
                    AntiHelper.bn(a.this.mPageContext.getPageActivity(), a.this.djT.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.djT.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.djT = new LikeModel(tbPageContext);
        this.djT.setLoadDataCallBack(this.djY);
        this.djU = bVar;
        this.djU.g(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.djX);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.djV = bVar;
            this.djU.fU(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.djX.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.djW = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.djU != null) {
            this.djU.ba(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.djV != null) {
                this.djT.eC(this.djV.getForumName(), this.djV.getForumId());
            } else {
                return;
            }
        }
        if (this.djW != null) {
            this.djW.onClick(view);
        }
    }
}
