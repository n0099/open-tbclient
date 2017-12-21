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
    private a apA;
    protected com.baidu.tbadk.core.view.userLike.a apv;
    private b apw;
    private BdUniqueId apy;
    private com.baidu.tbadk.d.a apz;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.apv != null && !StringUtils.isNull(c.this.apv.getUserId()) && data != null && c.this.apv.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.apy == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.apy)) ? false : true;
                    if (data.ass == null) {
                        if (!data.BJ) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.apw != null) {
                                if (z) {
                                    c.this.apw.i(c.this.apv.getIsLike(), z);
                                    return;
                                } else {
                                    c.this.apw.aN(c.this.apv.getIsLike());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.apv.getFansNum();
                        if (data.isAttention && !c.this.apv.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.apv.getIsLike()) {
                            fansNum--;
                        }
                        c.this.apv.setIsLike(data.isAttention);
                        c.this.apv.setIsFromNetWork(false);
                        c.this.apv.setFansNum(fansNum);
                        if (c.this.apw != null) {
                            c.this.apw.dG(fansNum);
                            if (z) {
                                if (c.this.apA != null) {
                                    c.this.apA.aO(data.isAttention);
                                }
                                c.this.apw.i(data.isAttention, true);
                                return;
                            }
                            c.this.apw.aN(data.isAttention);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.model.a apx = new com.baidu.tbadk.coreExtra.model.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void aO(boolean z);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.apz = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.apy = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.apy = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.apy = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.apy);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.apw = bVar;
        if (this.apw != null) {
            this.apw.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.apv = aVar;
        if (this.apw != null && this.apv != null) {
            this.apw.aN(aVar.getIsLike());
            this.apw.dG(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a wR() {
        return this.apv;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.apz == null || !this.apz.s(view)) {
            if (!j.gV()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.apw != null) {
                this.apw.J(view);
            }
            if (ax.aS(this.mPageContext.getPageActivity()) && this.apv != null) {
                if (this.apy == null) {
                    this.apx.a(this.apv.getIsLike() ? false : true, this.apv.getPortrait(), this.apv.getUserId(), this.apv.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.apx.a(this.apv.getIsLike() ? false : true, this.apv.getPortrait(), this.apv.getUserId(), this.apv.isGod(), this.mFromType, this.apy, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.apA = aVar;
    }
}
