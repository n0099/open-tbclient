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
    protected com.baidu.tbadk.core.view.userLike.a aoW;
    private b aoX;
    private BdUniqueId aoZ;
    private com.baidu.tbadk.e.a apa;
    private a apb;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aoW != null && !StringUtils.isNull(c.this.aoW.getUserId()) && data != null && c.this.aoW.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.aoZ == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aoZ)) ? false : true;
                    if (data.arR == null) {
                        if (!data.BJ) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.aoX != null) {
                                if (z) {
                                    c.this.aoX.i(c.this.aoW.getIsLike(), z);
                                    return;
                                } else {
                                    c.this.aoX.aM(c.this.aoW.getIsLike());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.aoW.getFansNum();
                        if (data.isAttention && !c.this.aoW.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.aoW.getIsLike()) {
                            fansNum--;
                        }
                        c.this.aoW.setIsLike(data.isAttention);
                        c.this.aoW.setIsFromNetWork(false);
                        c.this.aoW.setFansNum(fansNum);
                        if (c.this.aoX != null) {
                            c.this.aoX.dF(fansNum);
                            if (z) {
                                if (c.this.apb != null) {
                                    c.this.apb.aN(data.isAttention);
                                }
                                c.this.aoX.i(data.isAttention, true);
                                return;
                            }
                            c.this.aoX.aM(data.isAttention);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.c.a aoY = new com.baidu.tbadk.coreExtra.c.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void aN(boolean z);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.apa = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aoZ = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.aoZ = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aoZ = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.aoZ);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.aoX = bVar;
        if (this.aoX != null) {
            this.aoX.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aoW = aVar;
        if (this.aoX != null && this.aoW != null) {
            this.aoX.aM(aVar.getIsLike());
            this.aoX.dF(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a wR() {
        return this.aoW;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.apa == null || !this.apa.s(view)) {
            if (!j.gV()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.aoX != null) {
                this.aoX.I(view);
            }
            if (ax.aT(this.mPageContext.getPageActivity()) && this.aoW != null) {
                if (this.aoZ == null) {
                    this.aoY.a(this.aoW.getIsLike() ? false : true, this.aoW.getPortrait(), this.aoW.getUserId(), this.aoW.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.aoY.a(this.aoW.getIsLike() ? false : true, this.aoW.getPortrait(), this.aoW.getUserId(), this.aoW.isGod(), this.mFromType, this.aoZ, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.apb = aVar;
    }
}
