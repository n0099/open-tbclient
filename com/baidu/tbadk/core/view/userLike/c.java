package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a cje;
    protected com.baidu.tbadk.core.view.userLike.a crW;
    private b crX;
    private BdUniqueId crY;
    private d crZ;
    private a csa;
    private TbPageContext mPageContext;
    private String ajt = "0";
    private CustomMessageListener cji = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.crW != null && !StringUtils.isNull(c.this.crW.getUserId()) && data != null && c.this.crW.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.crY == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.crY)) ? false : true;
                    if (data.cvM == null) {
                        if (!data.isSucc) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).akR();
                            if (c.this.crX != null) {
                                if (z) {
                                    c.this.crX.d(c.this.crW.getIsLike(), c.this.crW.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.crX.g(c.this.crW.getIsLike(), c.this.crW.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.crW.getFansNum();
                        if (data.isAttention && !c.this.crW.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.crW.getIsLike()) {
                            fansNum--;
                        }
                        c.this.crW.setLikeStatus(data.status);
                        c.this.crW.setIsLike(data.isAttention);
                        c.this.crW.setIsFromNetWork(false);
                        c.this.crW.setFansNum(fansNum);
                        if (c.this.crX != null) {
                            c.this.crX.iT(fansNum);
                            if (z) {
                                if (c.this.csa != null) {
                                    c.this.csa.ex(data.isAttention);
                                }
                                c.this.crX.d(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.crX.g(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ex(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cje = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.crY = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.cji);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.cje = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.crY = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.cji);
        a(bVar);
    }

    public void mX(String str) {
        this.ajt = str;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.crY = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.cji);
            this.cji.setTag(this.crY);
            MessageManager.getInstance().registerListener(this.cji);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.cji);
        }
    }

    public void a(b bVar) {
        this.crX = bVar;
        if (this.crX != null) {
            this.crX.f(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.crW = aVar;
        if (this.crX != null && this.crW != null) {
            this.crX.g(aVar.getIsLike(), aVar.getLikeStatus());
            this.crX.iT(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a aoi() {
        return this.crW;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.crZ == null || !this.crZ.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.network_ungeilivable);
            }
            if (this.crX != null) {
                this.crX.aZ(view);
            }
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.crW != null) {
                if (this.crY == null) {
                    this.cje.a(this.crW.getIsLike() ? false : true, this.crW.getPortrait(), this.crW.getUserId(), this.crW.isGod(), this.ajt, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.cje.a(this.crW.getIsLike() ? false : true, this.crW.getPortrait(), this.crW.getUserId(), this.crW.isGod(), this.ajt, this.crY, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.csa = aVar;
    }
}
