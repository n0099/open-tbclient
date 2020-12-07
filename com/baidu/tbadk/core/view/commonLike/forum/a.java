package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel fgf;
    private com.baidu.tbadk.core.view.commonLike.b fgg;
    private b fgh;
    private View.OnClickListener fgi;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.fgh != null && l.equals(a.this.fgh.getForumId()) && aVar.isSuccess) {
                    a.this.fgh.setIsLike(true);
                    a.this.fgh.jc(true);
                    a.this.fgg.aP(true);
                }
            }
        }
    };
    private CustomMessageListener fgj = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.fgh != null && l.equals(a.this.fgh.getForumId()) && aVar.isSuccess) {
                    a.this.fgh.setIsLike(false);
                    a.this.fgh.jc(false);
                    a.this.fgg.aP(false);
                }
            }
        }
    };
    d fgk = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof w) && ((w) obj).getErrorCode() != 0) {
                if (AntiHelper.bP(a.this.fgf.getErrorCode(), a.this.fgf.getErrorString())) {
                    AntiHelper.bn(a.this.mPageContext.getPageActivity(), a.this.fgf.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.fgf.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.fgf = new LikeModel(tbPageContext);
        this.fgf.setLoadDataCallBack(this.fgk);
        this.fgg = bVar;
        this.fgg.h(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.fgj);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.fgh = bVar;
            this.fgg.aP(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.fgj.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.fgi = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fgg != null) {
            this.fgg.bB(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.fgh != null) {
                this.fgf.gu(this.fgh.getForumName(), this.fgh.getForumId());
            } else {
                return;
            }
        }
        if (this.fgi != null) {
            this.fgi.onClick(view);
        }
    }
}
