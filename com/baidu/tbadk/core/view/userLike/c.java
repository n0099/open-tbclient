package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a ard;
    protected com.baidu.tbadk.core.view.userLike.a azF;
    private b azG;
    private BdUniqueId azH;
    private com.baidu.tbadk.e.b azI;
    private a azJ;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.azF != null && !StringUtils.isNull(c.this.azF.getUserId()) && data != null && c.this.azF.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.azH == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.azH)) ? false : true;
                    if (data.aDu == null) {
                        if (!data.Gr) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.azG != null) {
                                if (z) {
                                    c.this.azG.a(c.this.azF.getIsLike(), c.this.azF.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.azG.d(c.this.azF.getIsLike(), c.this.azF.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.azF.getFansNum();
                        if (data.isAttention && !c.this.azF.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.azF.getIsLike()) {
                            fansNum--;
                        }
                        c.this.azF.setLikeStatus(data.status);
                        c.this.azF.setIsLike(data.isAttention);
                        c.this.azF.setIsFromNetWork(false);
                        c.this.azF.setFansNum(fansNum);
                        if (c.this.azG != null) {
                            c.this.azG.dF(fansNum);
                            if (z) {
                                if (c.this.azJ != null) {
                                    c.this.azJ.aY(data.isAttention);
                                }
                                c.this.azG.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.azG.d(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aY(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ard = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.azH = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.ard = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.azH = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.azH = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.azH);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.azG = bVar;
        if (this.azG != null) {
            this.azG.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.azF = aVar;
        if (this.azG != null && this.azF != null) {
            this.azG.d(aVar.getIsLike(), aVar.getLikeStatus());
            this.azG.dF(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a Bg() {
        return this.azF;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.azI == null || !this.azI.v(view)) {
            if (!j.jr()) {
                this.mPageContext.showToast(d.k.network_ungeilivable);
            }
            if (this.azG != null) {
                this.azG.L(view);
            }
            if (bb.aU(this.mPageContext.getPageActivity()) && this.azF != null) {
                if (this.azH == null) {
                    this.ard.a(this.azF.getIsLike() ? false : true, this.azF.getPortrait(), this.azF.getUserId(), this.azF.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.ard.a(this.azF.getIsLike() ? false : true, this.azF.getPortrait(), this.azF.getUserId(), this.azF.isGod(), this.mFromType, this.azH, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.azJ = aVar;
    }
}
