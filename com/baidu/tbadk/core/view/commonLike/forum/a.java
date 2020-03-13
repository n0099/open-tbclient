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
    private LikeModel dkh;
    private com.baidu.tbadk.core.view.commonLike.b dki;
    private b dkj;
    private View.OnClickListener dkk;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.dkj != null && l.equals(a.this.dkj.getForumId()) && aVar.isSuccess) {
                    a.this.dkj.setIsLike(true);
                    a.this.dkj.fy(true);
                    a.this.dki.fU(true);
                }
            }
        }
    };
    private CustomMessageListener dkl = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.dkj != null && l.equals(a.this.dkj.getForumId()) && aVar.isSuccess) {
                    a.this.dkj.setIsLike(false);
                    a.this.dkj.fy(false);
                    a.this.dki.fU(false);
                }
            }
        }
    };
    d dkm = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof t) && ((t) obj).getErrorCode() != 0) {
                if (AntiHelper.bb(a.this.dkh.getErrorCode(), a.this.dkh.getErrorString())) {
                    AntiHelper.bn(a.this.mPageContext.getPageActivity(), a.this.dkh.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.dkh.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.dkh = new LikeModel(tbPageContext);
        this.dkh.setLoadDataCallBack(this.dkm);
        this.dki = bVar;
        this.dki.g(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.dkl);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.dkj = bVar;
            this.dki.fU(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.dkl.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.dkk = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dki != null) {
            this.dki.ba(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.dkj != null) {
                this.dkh.eC(this.dkj.getForumName(), this.dkj.getForumId());
            } else {
                return;
            }
        }
        if (this.dkk != null) {
            this.dkk.onClick(view);
        }
    }
}
