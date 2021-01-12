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
    private LikeModel fle;
    private com.baidu.tbadk.core.view.commonLike.b flf;
    private b flg;
    private View.OnClickListener flh;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                String l = Long.toString(eVar.forumId);
                if (a.this.flg != null && l.equals(a.this.flg.getForumId()) && eVar.isSuccess) {
                    a.this.flg.setIsLike(true);
                    a.this.flg.ju(true);
                    a.this.flf.aM(true);
                }
            }
        }
    };
    private CustomMessageListener fli = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                String l = Long.toString(eVar.forumId);
                if (a.this.flg != null && l.equals(a.this.flg.getForumId()) && eVar.isSuccess) {
                    a.this.flg.setIsLike(false);
                    a.this.flg.ju(false);
                    a.this.flf.aM(false);
                }
            }
        }
    };
    com.baidu.adp.base.e flj = new com.baidu.adp.base.e() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if ((obj instanceof w) && ((w) obj).getErrorCode() != 0) {
                if (AntiHelper.bQ(a.this.fle.getErrorCode(), a.this.fle.getErrorString())) {
                    AntiHelper.bs(a.this.mPageContext.getPageActivity(), a.this.fle.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.fle.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.fle = new LikeModel(tbPageContext);
        this.fle.setLoadDataCallBack(this.flj);
        this.flf = bVar;
        this.flf.i(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.fli);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.flg = bVar;
            this.flf.aM(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.fli.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.flh = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.flf != null) {
            this.flf.bK(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.flg != null) {
                this.fle.gq(this.flg.getForumName(), this.flg.getForumId());
            } else {
                return;
            }
        }
        if (this.flh != null) {
            this.flh.onClick(view);
        }
    }
}
