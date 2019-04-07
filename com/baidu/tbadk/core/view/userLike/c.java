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
    private com.baidu.tbadk.coreExtra.model.a bKA;
    protected com.baidu.tbadk.core.view.userLike.a bUA;
    private b bUB;
    private BdUniqueId bUC;
    private com.baidu.tbadk.h.b bUD;
    private a bUE;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.bUA != null && !StringUtils.isNull(c.this.bUA.getUserId()) && data != null && c.this.bUA.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.bUC == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.bUC)) ? false : true;
                    if (data.bYB == null) {
                        if (!data.Jy) {
                            BdToast.b(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, d.f.icon_toast_game_error, 3000).abe();
                            if (c.this.bUB != null) {
                                if (z) {
                                    c.this.bUB.d(c.this.bUA.getIsLike(), c.this.bUA.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.bUB.f(c.this.bUA.getIsLike(), c.this.bUA.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.bUA.getFansNum();
                        if (data.isAttention && !c.this.bUA.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.bUA.getIsLike()) {
                            fansNum--;
                        }
                        c.this.bUA.setLikeStatus(data.status);
                        c.this.bUA.setIsLike(data.isAttention);
                        c.this.bUA.setIsFromNetWork(false);
                        c.this.bUA.setFansNum(fansNum);
                        if (c.this.bUB != null) {
                            c.this.bUB.ik(fansNum);
                            if (z) {
                                if (c.this.bUE != null) {
                                    c.this.bUE.dV(data.isAttention);
                                }
                                c.this.bUB.d(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.bUB.f(data.isAttention, data.status);
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
        this.bKA = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bUC = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bKA = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bUC = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bUC = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.bUC);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.bUB = bVar;
        if (this.bUB != null) {
            this.bUB.e(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.bUA = aVar;
        if (this.bUB != null && this.bUA != null) {
            this.bUB.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.bUB.ik(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a afe() {
        return this.bUA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bUD == null || !this.bUD.ay(view)) {
            if (!j.kM()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.bUB != null) {
                this.bUB.aR(view);
            }
            if (bc.cZ(this.mPageContext.getPageActivity()) && this.bUA != null) {
                if (this.bUC == null) {
                    this.bKA.a(this.bUA.getIsLike() ? false : true, this.bUA.getPortrait(), this.bUA.getUserId(), this.bUA.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bKA.a(this.bUA.getIsLike() ? false : true, this.bUA.getPortrait(), this.bUA.getUserId(), this.bUA.isGod(), this.mFromType, this.bUC, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.bUE = aVar;
    }
}
