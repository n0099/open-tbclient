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
    protected com.baidu.tbadk.core.view.userLike.a bdH;
    private b bdI;
    private BdUniqueId bdK;
    private com.baidu.tbadk.d.a bdL;
    private a bdM;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.bdH != null && !StringUtils.isNull(c.this.bdH.getUserId()) && data != null && c.this.bdH.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.bdK == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.bdK)) ? false : true;
                    if (data.bgS == null) {
                        if (!data.apQ) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.bdI != null) {
                                if (z) {
                                    c.this.bdI.a(c.this.bdH.getIsLike(), c.this.bdH.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.bdI.f(c.this.bdH.getIsLike(), c.this.bdH.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.bdH.getFansNum();
                        if (data.isAttention && !c.this.bdH.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.bdH.getIsLike()) {
                            fansNum--;
                        }
                        c.this.bdH.setLikeStatus(data.status);
                        c.this.bdH.setIsLike(data.isAttention);
                        c.this.bdH.setIsFromNetWork(false);
                        c.this.bdH.setFansNum(fansNum);
                        if (c.this.bdI != null) {
                            c.this.bdI.gB(fansNum);
                            if (z) {
                                if (c.this.bdM != null) {
                                    c.this.bdM.bv(data.isAttention);
                                }
                                c.this.bdI.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.bdI.f(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.model.a bdJ = new com.baidu.tbadk.coreExtra.model.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void bv(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bdK = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bdK = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bdK = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.bdK);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.bdI = bVar;
        if (this.bdI != null) {
            this.bdI.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.bdH = aVar;
        if (this.bdI != null && this.bdH != null) {
            this.bdI.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.bdI.gB(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a Ej() {
        return this.bdH;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bdL == null || !this.bdL.aL(view)) {
            if (!j.ox()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.bdI != null) {
                this.bdI.bc(view);
            }
            if (ax.bb(this.mPageContext.getPageActivity()) && this.bdH != null) {
                if (this.bdK == null) {
                    this.bdJ.a(this.bdH.getIsLike() ? false : true, this.bdH.getPortrait(), this.bdH.getUserId(), this.bdH.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bdJ.a(this.bdH.getIsLike() ? false : true, this.bdH.getPortrait(), this.bdH.getUserId(), this.bdH.isGod(), this.mFromType, this.bdK, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.bdM = aVar;
    }
}
