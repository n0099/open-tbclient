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
    private com.baidu.tbadk.coreExtra.model.a aCD;
    protected com.baidu.tbadk.core.view.userLike.a aLX;
    private b aLY;
    private BdUniqueId aLZ;
    private com.baidu.tbadk.f.b aMa;
    private a aMb;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aLX != null && !StringUtils.isNull(c.this.aLX.getUserId()) && data != null && c.this.aLX.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.aLZ == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aLZ)) ? false : true;
                    if (data.aPX == null) {
                        if (!data.Jr) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, e.f.icon_toast_game_error, 3000).Ca();
                            if (c.this.aLY != null) {
                                if (z) {
                                    c.this.aLY.a(c.this.aLX.getIsLike(), c.this.aLX.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.aLY.d(c.this.aLX.getIsLike(), c.this.aLX.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.aLX.getFansNum();
                        if (data.isAttention && !c.this.aLX.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.aLX.getIsLike()) {
                            fansNum--;
                        }
                        c.this.aLX.setLikeStatus(data.status);
                        c.this.aLX.setIsLike(data.isAttention);
                        c.this.aLX.setIsFromNetWork(false);
                        c.this.aLX.setFansNum(fansNum);
                        if (c.this.aLY != null) {
                            c.this.aLY.eF(fansNum);
                            if (z) {
                                if (c.this.aMb != null) {
                                    c.this.aMb.bM(data.isAttention);
                                }
                                c.this.aLY.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.aLY.d(data.isAttention, data.status);
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
        this.aCD = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aLZ = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.aCD = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aLZ = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aLZ = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.aLZ);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.aLY = bVar;
        if (this.aLY != null) {
            this.aLY.d(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aLX = aVar;
        if (this.aLY != null && this.aLX != null) {
            this.aLY.d(aVar.getIsLike(), aVar.getLikeStatus());
            this.aLY.eF(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a FN() {
        return this.aLX;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aMa == null || !this.aMa.F(view)) {
            if (!j.kK()) {
                this.mPageContext.showToast(e.j.network_ungeilivable);
            }
            if (this.aLY != null) {
                this.aLY.X(view);
            }
            if (ba.bJ(this.mPageContext.getPageActivity()) && this.aLX != null) {
                if (this.aLZ == null) {
                    this.aCD.a(this.aLX.getIsLike() ? false : true, this.aLX.getPortrait(), this.aLX.getUserId(), this.aLX.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.aCD.a(this.aLX.getIsLike() ? false : true, this.aLX.getPortrait(), this.aLX.getUserId(), this.aLX.isGod(), this.mFromType, this.aLZ, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.aMb = aVar;
    }
}
