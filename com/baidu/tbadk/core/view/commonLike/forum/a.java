package com.baidu.tbadk.core.view.commonLike.forum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tieba.tbadkCore.writeModel.e;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private LikeModel foW;
    private com.baidu.tbadk.core.view.commonLike.b foX;
    private b foY;
    private View.OnClickListener foZ;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                String l = Long.toString(eVar.forumId);
                if (a.this.foY != null && l.equals(a.this.foY.getForumId()) && eVar.isSuccess) {
                    a.this.foY.setIsLike(true);
                    a.this.foY.jw(true);
                    a.this.foX.aM(true);
                }
            }
        }
    };
    private CustomMessageListener fpa = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                String l = Long.toString(eVar.forumId);
                if (a.this.foY != null && l.equals(a.this.foY.getForumId()) && eVar.isSuccess) {
                    a.this.foY.setIsLike(false);
                    a.this.foY.jw(false);
                    a.this.foX.aM(false);
                }
            }
        }
    };
    com.baidu.adp.base.e fpb = new com.baidu.adp.base.e() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if ((obj instanceof w) && ((w) obj).getErrorCode() != 0) {
                if (AntiHelper.bX(a.this.foW.getErrorCode(), a.this.foW.getErrorString())) {
                    AntiHelper.bq(a.this.mPageContext.getPageActivity(), a.this.foW.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.foW.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.foW = new LikeModel(tbPageContext);
        this.foW.setLoadDataCallBack(this.fpb);
        this.foX = bVar;
        this.foX.i(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.fpa);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.foY = bVar;
            this.foX.aM(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.fpa.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.foZ = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.foX != null) {
            this.foX.bG(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.foY != null) {
                this.foW.gy(this.foY.getForumName(), this.foY.getForumId());
            } else {
                return;
            }
        }
        if (this.foZ != null) {
            this.foZ.onClick(view);
        }
    }
}
