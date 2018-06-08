package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a aqA;
    protected com.baidu.tbadk.core.view.userLike.a ayN;
    private b ayO;
    private BdUniqueId ayP;
    private com.baidu.tbadk.e.b ayQ;
    private a ayR;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.ayN != null && !StringUtils.isNull(c.this.ayN.getUserId()) && data != null && c.this.ayN.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.ayP == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.ayP)) ? false : true;
                    if (data.aCA == null) {
                        if (!data.Gp) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.ayO != null) {
                                if (z) {
                                    c.this.ayO.a(c.this.ayN.getIsLike(), c.this.ayN.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.ayO.d(c.this.ayN.getIsLike(), c.this.ayN.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.ayN.getFansNum();
                        if (data.isAttention && !c.this.ayN.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.ayN.getIsLike()) {
                            fansNum--;
                        }
                        c.this.ayN.setLikeStatus(data.status);
                        c.this.ayN.setIsLike(data.isAttention);
                        c.this.ayN.setIsFromNetWork(false);
                        c.this.ayN.setFansNum(fansNum);
                        if (c.this.ayO != null) {
                            c.this.ayO.dE(fansNum);
                            if (z) {
                                if (c.this.ayR != null) {
                                    c.this.ayR.aV(data.isAttention);
                                }
                                c.this.ayO.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.ayO.d(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aV(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aqA = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.ayP = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.aqA = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.ayP = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ayP = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.ayP);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.ayO = bVar;
        if (this.ayO != null) {
            this.ayO.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.ayN = aVar;
        if (this.ayO != null && this.ayN != null) {
            this.ayO.d(aVar.getIsLike(), aVar.getLikeStatus());
            this.ayO.dE(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a AO() {
        return this.ayN;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ayQ == null || !this.ayQ.v(view)) {
            if (!j.jr()) {
                this.mPageContext.showToast(d.k.network_ungeilivable);
            }
            if (this.ayO != null) {
                this.ayO.K(view);
            }
            if (ba.aU(this.mPageContext.getPageActivity()) && this.ayN != null) {
                if (this.ayP == null) {
                    this.aqA.a(this.ayN.getIsLike() ? false : true, this.ayN.getPortrait(), this.ayN.getUserId(), this.ayN.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.aqA.a(this.ayN.getIsLike() ? false : true, this.ayN.getPortrait(), this.ayN.getUserId(), this.ayN.isGod(), this.mFromType, this.ayP, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.ayR = aVar;
    }
}
