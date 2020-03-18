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
    private LikeModel dku;
    private com.baidu.tbadk.core.view.commonLike.b dkv;
    private b dkw;
    private View.OnClickListener dkx;
    private TbPageContext mPageContext;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.dkw != null && l.equals(a.this.dkw.getForumId()) && aVar.isSuccess) {
                    a.this.dkw.setIsLike(true);
                    a.this.dkw.fz(true);
                    a.this.dkv.fV(true);
                }
            }
        }
    };
    private CustomMessageListener dky = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                String l = Long.toString(aVar.forumId);
                if (a.this.dkw != null && l.equals(a.this.dkw.getForumId()) && aVar.isSuccess) {
                    a.this.dkw.setIsLike(false);
                    a.this.dkw.fz(false);
                    a.this.dkv.fV(false);
                }
            }
        }
    };
    d dkz = new d() { // from class: com.baidu.tbadk.core.view.commonLike.forum.a.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if ((obj instanceof u) && ((u) obj).getErrorCode() != 0) {
                if (AntiHelper.bb(a.this.dku.getErrorCode(), a.this.dku.getErrorString())) {
                    AntiHelper.bn(a.this.mPageContext.getPageActivity(), a.this.dku.getErrorString());
                } else {
                    a.this.mPageContext.showToast(a.this.dku.getErrorString());
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, com.baidu.tbadk.core.view.commonLike.b bVar) {
        this.mPageContext = tbPageContext;
        this.dku = new LikeModel(tbPageContext);
        this.dku.setLoadDataCallBack(this.dkz);
        this.dkv = bVar;
        this.dkv.g(this);
        tbPageContext.registerListener(this.mLikeForumListener);
        tbPageContext.registerListener(this.dky);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.dkw = bVar;
            this.dkv.fV(bVar.getIsLike());
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.dky.setTag(bdUniqueId);
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        this.dkx = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dkv != null) {
            this.dkv.ba(view);
        }
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.dkw != null) {
                this.dku.eA(this.dkw.getForumName(), this.dkw.getForumId());
            } else {
                return;
            }
        }
        if (this.dkx != null) {
            this.dkx.onClick(view);
        }
    }
}
