package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    protected com.baidu.tbadk.core.view.userLike.a bdt;
    private b bdu;
    private BdUniqueId bdw;
    private com.baidu.tbadk.d.a bdx;
    private a bdy;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.bdt != null && !StringUtils.isNull(c.this.bdt.getUserId()) && data != null && c.this.bdt.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.bdw == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.bdw)) ? false : true;
                    if (data.bgt == null) {
                        if (!data.apO) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.bdu != null) {
                                if (z) {
                                    c.this.bdu.a(c.this.bdt.getIsLike(), c.this.bdt.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.bdu.f(c.this.bdt.getIsLike(), c.this.bdt.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.bdt.getFansNum();
                        if (data.isAttention && !c.this.bdt.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.bdt.getIsLike()) {
                            fansNum--;
                        }
                        c.this.bdt.setLikeStatus(data.status);
                        c.this.bdt.setIsLike(data.isAttention);
                        c.this.bdt.setIsFromNetWork(false);
                        c.this.bdt.setFansNum(fansNum);
                        if (c.this.bdu != null) {
                            c.this.bdu.gE(fansNum);
                            if (z) {
                                if (c.this.bdy != null) {
                                    c.this.bdy.bu(data.isAttention);
                                }
                                c.this.bdu.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.bdu.f(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.model.a bdv = new com.baidu.tbadk.coreExtra.model.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void bu(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bdw = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bdw = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bdw = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.bdw);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.bdu = bVar;
        if (this.bdu != null) {
            this.bdu.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.bdt = aVar;
        if (this.bdu != null && this.bdt != null) {
            this.bdu.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.bdu.gE(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a Eq() {
        return this.bdt;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bdx == null || !this.bdx.aL(view)) {
            if (!j.ow()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.bdu != null) {
                this.bdu.bc(view);
            }
            if (ax.be(this.mPageContext.getPageActivity()) && this.bdt != null) {
                if (this.bdw == null) {
                    this.bdv.a(this.bdt.getIsLike() ? false : true, this.bdt.getPortrait(), this.bdt.getUserId(), this.bdt.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bdv.a(this.bdt.getIsLike() ? false : true, this.bdt.getPortrait(), this.bdt.getUserId(), this.bdt.isGod(), this.mFromType, this.bdw, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.bdy = aVar;
    }
}
