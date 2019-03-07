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
    private com.baidu.tbadk.coreExtra.model.a bKx;
    private com.baidu.tbadk.h.b bUA;
    private a bUB;
    protected com.baidu.tbadk.core.view.userLike.a bUx;
    private b bUy;
    private BdUniqueId bUz;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.bUx != null && !StringUtils.isNull(c.this.bUx.getUserId()) && data != null && c.this.bUx.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.bUz == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.bUz)) ? false : true;
                    if (data.bYy == null) {
                        if (!data.Jy) {
                            BdToast.b(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, d.f.icon_toast_game_error, 3000).abh();
                            if (c.this.bUy != null) {
                                if (z) {
                                    c.this.bUy.d(c.this.bUx.getIsLike(), c.this.bUx.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.bUy.f(c.this.bUx.getIsLike(), c.this.bUx.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.bUx.getFansNum();
                        if (data.isAttention && !c.this.bUx.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.bUx.getIsLike()) {
                            fansNum--;
                        }
                        c.this.bUx.setLikeStatus(data.status);
                        c.this.bUx.setIsLike(data.isAttention);
                        c.this.bUx.setIsFromNetWork(false);
                        c.this.bUx.setFansNum(fansNum);
                        if (c.this.bUy != null) {
                            c.this.bUy.il(fansNum);
                            if (z) {
                                if (c.this.bUB != null) {
                                    c.this.bUB.dV(data.isAttention);
                                }
                                c.this.bUy.d(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.bUy.f(data.isAttention, data.status);
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
        this.bKx = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bUz = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bKx = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bUz = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bUz = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.bUz);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.bUy = bVar;
        if (this.bUy != null) {
            this.bUy.e(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.bUx = aVar;
        if (this.bUy != null && this.bUx != null) {
            this.bUy.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.bUy.il(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a afh() {
        return this.bUx;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bUA == null || !this.bUA.ay(view)) {
            if (!j.kM()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.bUy != null) {
                this.bUy.aR(view);
            }
            if (bc.cZ(this.mPageContext.getPageActivity()) && this.bUx != null) {
                if (this.bUz == null) {
                    this.bKx.a(this.bUx.getIsLike() ? false : true, this.bUx.getPortrait(), this.bUx.getUserId(), this.bUx.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bKx.a(this.bUx.getIsLike() ? false : true, this.bUx.getPortrait(), this.bUx.getUserId(), this.bUx.isGod(), this.mFromType, this.bUz, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.bUB = aVar;
    }
}
