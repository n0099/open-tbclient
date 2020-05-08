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
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel dKs;
    private com.baidu.tbadk.core.view.commonLike.b dKt;
    private b dKu;
    private View.OnClickListener dKv;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.dKu != null && l.equals(a.this.dKu.getForumId()) && aVar.isSuccess) {
                    a.this.dKu.setIsLike(true);
                    a.this.dKu.gw(true);
                    a.this.dKt.gT(true);
                }
            }
        }
    };
    private CustomMessageListener dKw = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.dKu != null && l.equals(a.this.dKu.getForumId()) && aVar.isSuccess) {
                    a.this.dKu.setIsLike(false);
                    a.this.dKu.gw(false);
                    a.this.dKt.gT(false);
                }
            }
        }
    };
    d dKx = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof u) && ((u) obj).getErrorCode() != 0) {
                if (AntiHelper.bq(a.this.dKs.getErrorCode(), a.this.dKs.getErrorString())) {
                    AntiHelper.aW(a.this.mPageContext.getPageActivity(), a.this.dKs.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.dKs.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.dKs = new LikeModel(tbPageContext);
        this.dKs.setLoadDataCallBack(this.dKx);
        this.dKt = bVar;
        this.dKt.g(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.dKw);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.dKu = bVar;
            this.dKt.gT(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.dKw.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.dKv = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dKt != null) {
            this.dKt.bb(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.dKu != null) {
                this.dKs.eP(this.dKu.getForumName(), this.dKu.getForumId());
            } else {
                return;
            }
        }
        if (this.dKv != null) {
            this.dKv.onClick(view);
        }
    }
}
