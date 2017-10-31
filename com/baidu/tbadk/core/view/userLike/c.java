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
    protected com.baidu.tbadk.core.view.userLike.a aoX;
    private b aoY;
    private BdUniqueId apa;
    private com.baidu.tbadk.e.a apb;
    private a apc;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aoX != null && !StringUtils.isNull(c.this.aoX.getUserId()) && data != null && c.this.aoX.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.apa == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.apa)) ? false : true;
                    if (data.arL == null) {
                        if (!data.BJ) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.aoY != null) {
                                if (z) {
                                    c.this.aoY.i(c.this.aoX.getIsLike(), z);
                                    return;
                                } else {
                                    c.this.aoY.aM(c.this.aoX.getIsLike());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.aoX.getFansNum();
                        if (data.isAttention && !c.this.aoX.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.aoX.getIsLike()) {
                            fansNum--;
                        }
                        c.this.aoX.setIsLike(data.isAttention);
                        c.this.aoX.setIsFromNetWork(false);
                        c.this.aoX.setFansNum(fansNum);
                        if (c.this.aoY != null) {
                            c.this.aoY.dG(fansNum);
                            if (z) {
                                if (c.this.apc != null) {
                                    c.this.apc.aN(data.isAttention);
                                }
                                c.this.aoY.i(data.isAttention, true);
                                return;
                            }
                            c.this.aoY.aM(data.isAttention);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.c.a aoZ = new com.baidu.tbadk.coreExtra.c.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void aN(boolean z);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.apb = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.apa = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.apa = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.apa = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.apa);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.aoY = bVar;
        if (this.aoY != null) {
            this.aoY.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aoX = aVar;
        if (this.aoY != null && this.aoX != null) {
            this.aoY.aM(aVar.getIsLike());
            this.aoY.dG(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a wR() {
        return this.aoX;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.apb == null || !this.apb.s(view)) {
            if (!j.gV()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.aoY != null) {
                this.aoY.I(view);
            }
            if (ax.aT(this.mPageContext.getPageActivity()) && this.aoX != null) {
                if (this.apa == null) {
                    this.aoZ.a(this.aoX.getIsLike() ? false : true, this.aoX.getPortrait(), this.aoX.getUserId(), this.aoX.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.aoZ.a(this.aoX.getIsLike() ? false : true, this.aoX.getPortrait(), this.aoX.getUserId(), this.aoX.isGod(), this.mFromType, this.apa, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.apc = aVar;
    }
}
