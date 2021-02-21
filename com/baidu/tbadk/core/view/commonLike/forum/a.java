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
    private LikeModel fnw;
    private com.baidu.tbadk.core.view.commonLike.b fnx;
    private b fny;
    private View.OnClickListener fnz;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                String l = Long.toString(eVar.forumId);
                if (a.this.fny != null && l.equals(a.this.fny.getForumId()) && eVar.isSuccess) {
                    a.this.fny.setIsLike(true);
                    a.this.fny.jw(true);
                    a.this.fnx.aM(true);
                }
            }
        }
    };
    private CustomMessageListener fnA = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                String l = Long.toString(eVar.forumId);
                if (a.this.fny != null && l.equals(a.this.fny.getForumId()) && eVar.isSuccess) {
                    a.this.fny.setIsLike(false);
                    a.this.fny.jw(false);
                    a.this.fnx.aM(false);
                }
            }
        }
    };
    com.baidu.adp.base.e fnB = new com.baidu.adp.base.e() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if ((obj instanceof w) && ((w) obj).getErrorCode() != 0) {
                if (AntiHelper.bX(a.this.fnw.getErrorCode(), a.this.fnw.getErrorString())) {
                    AntiHelper.bq(a.this.mPageContext.getPageActivity(), a.this.fnw.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.fnw.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.fnw = new LikeModel(tbPageContext);
        this.fnw.setLoadDataCallBack(this.fnB);
        this.fnx = bVar;
        this.fnx.i(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.fnA);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.fny = bVar;
            this.fnx.aM(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.fnA.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.fnz = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fnx != null) {
            this.fnx.bG(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.fny != null) {
                this.fnw.gy(this.fny.getForumName(), this.fny.getForumId());
            } else {
                return;
            }
        }
        if (this.fnz != null) {
            this.fnz.onClick(view);
        }
    }
}
