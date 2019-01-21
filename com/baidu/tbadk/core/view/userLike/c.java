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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a aCE;
    protected com.baidu.tbadk.core.view.userLike.a aLY;
    private b aLZ;
    private BdUniqueId aMa;
    private com.baidu.tbadk.f.b aMb;
    private a aMc;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aLY != null && !StringUtils.isNull(c.this.aLY.getUserId()) && data != null && c.this.aLY.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.aMa == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aMa)) ? false : true;
                    if (data.aPY == null) {
                        if (!data.Jr) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, e.f.icon_toast_game_error, 3000).Ca();
                            if (c.this.aLZ != null) {
                                if (z) {
                                    c.this.aLZ.a(c.this.aLY.getIsLike(), c.this.aLY.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.aLZ.d(c.this.aLY.getIsLike(), c.this.aLY.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.aLY.getFansNum();
                        if (data.isAttention && !c.this.aLY.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.aLY.getIsLike()) {
                            fansNum--;
                        }
                        c.this.aLY.setLikeStatus(data.status);
                        c.this.aLY.setIsLike(data.isAttention);
                        c.this.aLY.setIsFromNetWork(false);
                        c.this.aLY.setFansNum(fansNum);
                        if (c.this.aLZ != null) {
                            c.this.aLZ.eF(fansNum);
                            if (z) {
                                if (c.this.aMc != null) {
                                    c.this.aMc.bM(data.isAttention);
                                }
                                c.this.aLZ.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.aLZ.d(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bM(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aCE = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aMa = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.aCE = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aMa = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aMa = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.aMa);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.aLZ = bVar;
        if (this.aLZ != null) {
            this.aLZ.d(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aLY = aVar;
        if (this.aLZ != null && this.aLY != null) {
            this.aLZ.d(aVar.getIsLike(), aVar.getLikeStatus());
            this.aLZ.eF(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a FN() {
        return this.aLY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aMb == null || !this.aMb.F(view)) {
            if (!j.kK()) {
                this.mPageContext.showToast(e.j.network_ungeilivable);
            }
            if (this.aLZ != null) {
                this.aLZ.X(view);
            }
            if (ba.bJ(this.mPageContext.getPageActivity()) && this.aLY != null) {
                if (this.aMa == null) {
                    this.aCE.a(this.aLY.getIsLike() ? false : true, this.aLY.getPortrait(), this.aLY.getUserId(), this.aLY.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.aCE.a(this.aLY.getIsLike() ? false : true, this.aLY.getPortrait(), this.aLY.getUserId(), this.aLY.isGod(), this.mFromType, this.aMa, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.aMc = aVar;
    }
}
