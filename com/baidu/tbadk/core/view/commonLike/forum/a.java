package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.writeModel.e;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel fpO;
    private com.baidu.tbadk.core.view.commonLike.b fpP;
    private b fpQ;
    private View.OnClickListener fpR;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                String l = Long.toString(eVar.forumId);
                if (a.this.fpQ != null && l.equals(a.this.fpQ.getForumId()) && eVar.isSuccess) {
                    a.this.fpQ.setIsLike(true);
                    a.this.fpQ.jy(true);
                    a.this.fpP.aM(true);
                }
            }
        }
    };
    private CustomMessageListener fpS = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                String l = Long.toString(eVar.forumId);
                if (a.this.fpQ != null && l.equals(a.this.fpQ.getForumId()) && eVar.isSuccess) {
                    a.this.fpQ.setIsLike(false);
                    a.this.fpQ.jy(false);
                    a.this.fpP.aM(false);
                }
            }
        }
    };
    com.baidu.adp.base.e fpT = new com.baidu.adp.base.e() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if ((obj instanceof w) && ((w) obj).getErrorCode() != 0) {
                if (AntiHelper.bP(a.this.fpO.getErrorCode(), a.this.fpO.getErrorString())) {
                    AntiHelper.bs(a.this.mPageContext.getPageActivity(), a.this.fpO.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.fpO.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.fpO = new LikeModel(tbPageContext);
        this.fpO.setLoadDataCallBack(this.fpT);
        this.fpP = bVar;
        this.fpP.i(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.fpS);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.fpQ = bVar;
            this.fpP.aM(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.fpS.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.fpR = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fpP != null) {
            this.fpP.bK(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.fpQ != null) {
                this.fpO.gr(this.fpQ.getForumName(), this.fpQ.getForumId());
            } else {
                return;
            }
        }
        if (this.fpR != null) {
            this.fpR.onClick(view);
        }
    }
}
