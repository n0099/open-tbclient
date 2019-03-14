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
    private com.baidu.tbadk.coreExtra.model.a bKy;
    private BdUniqueId bUA;
    private com.baidu.tbadk.h.b bUB;
    private a bUC;
    protected com.baidu.tbadk.core.view.userLike.a bUy;
    private b bUz;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.bUy != null && !StringUtils.isNull(c.this.bUy.getUserId()) && data != null && c.this.bUy.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.bUA == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.bUA)) ? false : true;
                    if (data.bYz == null) {
                        if (!data.Jy) {
                            BdToast.b(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, d.f.icon_toast_game_error, 3000).abh();
                            if (c.this.bUz != null) {
                                if (z) {
                                    c.this.bUz.d(c.this.bUy.getIsLike(), c.this.bUy.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.bUz.f(c.this.bUy.getIsLike(), c.this.bUy.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.bUy.getFansNum();
                        if (data.isAttention && !c.this.bUy.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.bUy.getIsLike()) {
                            fansNum--;
                        }
                        c.this.bUy.setLikeStatus(data.status);
                        c.this.bUy.setIsLike(data.isAttention);
                        c.this.bUy.setIsFromNetWork(false);
                        c.this.bUy.setFansNum(fansNum);
                        if (c.this.bUz != null) {
                            c.this.bUz.il(fansNum);
                            if (z) {
                                if (c.this.bUC != null) {
                                    c.this.bUC.dV(data.isAttention);
                                }
                                c.this.bUz.d(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.bUz.f(data.isAttention, data.status);
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
        this.bKy = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bUA = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bKy = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bUA = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bUA = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.bUA);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.bUz = bVar;
        if (this.bUz != null) {
            this.bUz.e(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.bUy = aVar;
        if (this.bUz != null && this.bUy != null) {
            this.bUz.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.bUz.il(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a afh() {
        return this.bUy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bUB == null || !this.bUB.ay(view)) {
            if (!j.kM()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.bUz != null) {
                this.bUz.aR(view);
            }
            if (bc.cZ(this.mPageContext.getPageActivity()) && this.bUy != null) {
                if (this.bUA == null) {
                    this.bKy.a(this.bUy.getIsLike() ? false : true, this.bUy.getPortrait(), this.bUy.getUserId(), this.bUy.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bKy.a(this.bUy.getIsLike() ? false : true, this.bUy.getPortrait(), this.bUy.getUserId(), this.bUy.isGod(), this.mFromType, this.bUA, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.bUC = aVar;
    }
}
