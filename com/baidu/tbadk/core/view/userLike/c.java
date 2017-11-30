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
    protected com.baidu.tbadk.core.view.userLike.a apo;
    private b apq;
    private BdUniqueId aps;
    private com.baidu.tbadk.d.a apt;
    private a apu;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.apo != null && !StringUtils.isNull(c.this.apo.getUserId()) && data != null && c.this.apo.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.aps == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aps)) ? false : true;
                    if (data.ask == null) {
                        if (!data.BJ) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.apq != null) {
                                if (z) {
                                    c.this.apq.i(c.this.apo.getIsLike(), z);
                                    return;
                                } else {
                                    c.this.apq.aM(c.this.apo.getIsLike());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.apo.getFansNum();
                        if (data.isAttention && !c.this.apo.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.apo.getIsLike()) {
                            fansNum--;
                        }
                        c.this.apo.setIsLike(data.isAttention);
                        c.this.apo.setIsFromNetWork(false);
                        c.this.apo.setFansNum(fansNum);
                        if (c.this.apq != null) {
                            c.this.apq.dG(fansNum);
                            if (z) {
                                if (c.this.apu != null) {
                                    c.this.apu.aN(data.isAttention);
                                }
                                c.this.apq.i(data.isAttention, true);
                                return;
                            }
                            c.this.apq.aM(data.isAttention);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.model.a apr = new com.baidu.tbadk.coreExtra.model.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void aN(boolean z);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.apt = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aps = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.aps = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aps = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.aps);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.apq = bVar;
        if (this.apq != null) {
            this.apq.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.apo = aVar;
        if (this.apq != null && this.apo != null) {
            this.apq.aM(aVar.getIsLike());
            this.apq.dG(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a wS() {
        return this.apo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.apt == null || !this.apt.s(view)) {
            if (!j.gV()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.apq != null) {
                this.apq.I(view);
            }
            if (ax.aV(this.mPageContext.getPageActivity()) && this.apo != null) {
                if (this.aps == null) {
                    this.apr.a(this.apo.getIsLike() ? false : true, this.apo.getPortrait(), this.apo.getUserId(), this.apo.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.apr.a(this.apo.getIsLike() ? false : true, this.apo.getPortrait(), this.apo.getUserId(), this.apo.isGod(), this.mFromType, this.aps, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.apu = aVar;
    }
}
