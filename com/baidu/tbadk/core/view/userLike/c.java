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
    protected com.baidu.tbadk.core.view.userLike.a aps;
    private b apt;
    private BdUniqueId apv;
    private com.baidu.tbadk.d.a apw;
    private a apx;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aps != null && !StringUtils.isNull(c.this.aps.getUserId()) && data != null && c.this.aps.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.apv == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.apv)) ? false : true;
                    if (data.asp == null) {
                        if (!data.BI) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.apt != null) {
                                if (z) {
                                    c.this.apt.i(c.this.aps.getIsLike(), z);
                                    return;
                                } else {
                                    c.this.apt.aN(c.this.aps.getIsLike());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.aps.getFansNum();
                        if (data.isAttention && !c.this.aps.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.aps.getIsLike()) {
                            fansNum--;
                        }
                        c.this.aps.setIsLike(data.isAttention);
                        c.this.aps.setIsFromNetWork(false);
                        c.this.aps.setFansNum(fansNum);
                        if (c.this.apt != null) {
                            c.this.apt.dG(fansNum);
                            if (z) {
                                if (c.this.apx != null) {
                                    c.this.apx.aO(data.isAttention);
                                }
                                c.this.apt.i(data.isAttention, true);
                                return;
                            }
                            c.this.apt.aN(data.isAttention);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.model.a apu = new com.baidu.tbadk.coreExtra.model.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void aO(boolean z);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.apw = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.apv = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.apv = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.apv = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.apv);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.apt = bVar;
        if (this.apt != null) {
            this.apt.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aps = aVar;
        if (this.apt != null && this.aps != null) {
            this.apt.aN(aVar.getIsLike());
            this.apt.dG(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a wR() {
        return this.aps;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.apw == null || !this.apw.s(view)) {
            if (!j.gV()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.apt != null) {
                this.apt.J(view);
            }
            if (ax.aS(this.mPageContext.getPageActivity()) && this.aps != null) {
                if (this.apv == null) {
                    this.apu.a(this.aps.getIsLike() ? false : true, this.aps.getPortrait(), this.aps.getUserId(), this.aps.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.apu.a(this.aps.getIsLike() ? false : true, this.aps.getPortrait(), this.aps.getUserId(), this.aps.isGod(), this.mFromType, this.apv, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.apx = aVar;
    }
}
