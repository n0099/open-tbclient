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
    private b bdA;
    private BdUniqueId bdC;
    private com.baidu.tbadk.d.a bdD;
    private a bdE;
    protected com.baidu.tbadk.core.view.userLike.a bdz;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.bdz != null && !StringUtils.isNull(c.this.bdz.getUserId()) && data != null && c.this.bdz.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.bdC == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.bdC)) ? false : true;
                    if (data.bgK == null) {
                        if (!data.apN) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.bdA != null) {
                                if (z) {
                                    c.this.bdA.a(c.this.bdz.getIsLike(), c.this.bdz.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.bdA.f(c.this.bdz.getIsLike(), c.this.bdz.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.bdz.getFansNum();
                        if (data.isAttention && !c.this.bdz.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.bdz.getIsLike()) {
                            fansNum--;
                        }
                        c.this.bdz.setLikeStatus(data.status);
                        c.this.bdz.setIsLike(data.isAttention);
                        c.this.bdz.setIsFromNetWork(false);
                        c.this.bdz.setFansNum(fansNum);
                        if (c.this.bdA != null) {
                            c.this.bdA.gB(fansNum);
                            if (z) {
                                if (c.this.bdE != null) {
                                    c.this.bdE.bu(data.isAttention);
                                }
                                c.this.bdA.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.bdA.f(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.model.a bdB = new com.baidu.tbadk.coreExtra.model.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void bu(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bdC = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bdC = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bdC = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.bdC);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.bdA = bVar;
        if (this.bdA != null) {
            this.bdA.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.bdz = aVar;
        if (this.bdA != null && this.bdz != null) {
            this.bdA.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.bdA.gB(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a Eh() {
        return this.bdz;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bdD == null || !this.bdD.aL(view)) {
            if (!j.ow()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.bdA != null) {
                this.bdA.bc(view);
            }
            if (ax.be(this.mPageContext.getPageActivity()) && this.bdz != null) {
                if (this.bdC == null) {
                    this.bdB.a(this.bdz.getIsLike() ? false : true, this.bdz.getPortrait(), this.bdz.getUserId(), this.bdz.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bdB.a(this.bdz.getIsLike() ? false : true, this.bdz.getPortrait(), this.bdz.getUserId(), this.bdz.isGod(), this.mFromType, this.bdC, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.bdE = aVar;
    }
}
