package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a bKB;
    protected com.baidu.tbadk.core.view.userLike.a bUB;
    private b bUC;
    private BdUniqueId bUD;
    private com.baidu.tbadk.h.b bUE;
    private a bUF;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.bUB != null && !StringUtils.isNull(c.this.bUB.getUserId()) && data != null && c.this.bUB.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.bUD == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.bUD)) ? false : true;
                    if (data.bYC == null) {
                        if (!data.Jy) {
                            BdToast.b(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, d.f.icon_toast_game_error, 3000).abe();
                            if (c.this.bUC != null) {
                                if (z) {
                                    c.this.bUC.d(c.this.bUB.getIsLike(), c.this.bUB.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.bUC.f(c.this.bUB.getIsLike(), c.this.bUB.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.bUB.getFansNum();
                        if (data.isAttention && !c.this.bUB.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.bUB.getIsLike()) {
                            fansNum--;
                        }
                        c.this.bUB.setLikeStatus(data.status);
                        c.this.bUB.setIsLike(data.isAttention);
                        c.this.bUB.setIsFromNetWork(false);
                        c.this.bUB.setFansNum(fansNum);
                        if (c.this.bUC != null) {
                            c.this.bUC.ik(fansNum);
                            if (z) {
                                if (c.this.bUF != null) {
                                    c.this.bUF.dV(data.isAttention);
                                }
                                c.this.bUC.d(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.bUC.f(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void dV(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bKB = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bUD = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bKB = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bUD = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bUD = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.bUD);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.bUC = bVar;
        if (this.bUC != null) {
            this.bUC.e(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.bUB = aVar;
        if (this.bUC != null && this.bUB != null) {
            this.bUC.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.bUC.ik(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a afe() {
        return this.bUB;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bUE == null || !this.bUE.ay(view)) {
            if (!j.kM()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.bUC != null) {
                this.bUC.aR(view);
            }
            if (bc.cZ(this.mPageContext.getPageActivity()) && this.bUB != null) {
                if (this.bUD == null) {
                    this.bKB.a(this.bUB.getIsLike() ? false : true, this.bUB.getPortrait(), this.bUB.getUserId(), this.bUB.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bKB.a(this.bUB.getIsLike() ? false : true, this.bUB.getPortrait(), this.bUB.getUserId(), this.bUB.isGod(), this.mFromType, this.bUD, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.bUF = aVar;
    }
}
