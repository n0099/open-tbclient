package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    protected com.baidu.tbadk.core.view.userLike.a bfo;
    private b bfp;
    private com.baidu.tbadk.coreExtra.model.a bfq;
    private BdUniqueId bfr;
    private com.baidu.tbadk.d.a bfs;
    private a bft;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.bfo != null && !StringUtils.isNull(c.this.bfo.getUserId()) && data != null && c.this.bfo.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.bfr == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.bfr)) ? false : true;
                    if (data.biH == null) {
                        if (!data.apG) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.bfp != null) {
                                if (z) {
                                    c.this.bfp.a(c.this.bfo.getIsLike(), c.this.bfo.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.bfp.f(c.this.bfo.getIsLike(), c.this.bfo.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.bfo.getFansNum();
                        if (data.isAttention && !c.this.bfo.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.bfo.getIsLike()) {
                            fansNum--;
                        }
                        c.this.bfo.setLikeStatus(data.status);
                        c.this.bfo.setIsLike(data.isAttention);
                        c.this.bfo.setIsFromNetWork(false);
                        c.this.bfo.setFansNum(fansNum);
                        if (c.this.bfp != null) {
                            c.this.bfp.gD(fansNum);
                            if (z) {
                                if (c.this.bft != null) {
                                    c.this.bft.bA(data.isAttention);
                                }
                                c.this.bfp.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.bfp.f(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bA(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bfq = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bfr = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bfq = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bfr = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bfr = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.bfr);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.bfp = bVar;
        if (this.bfp != null) {
            this.bfp.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.bfo = aVar;
        if (this.bfp != null && this.bfo != null) {
            this.bfp.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.bfp.gD(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a ED() {
        return this.bfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bfs == null || !this.bfs.aL(view)) {
            if (!j.ox()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.bfp != null) {
                this.bfp.bc(view);
            }
            if (ay.ba(this.mPageContext.getPageActivity()) && this.bfo != null) {
                if (this.bfr == null) {
                    this.bfq.a(this.bfo.getIsLike() ? false : true, this.bfo.getPortrait(), this.bfo.getUserId(), this.bfo.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bfq.a(this.bfo.getIsLike() ? false : true, this.bfo.getPortrait(), this.bfo.getUserId(), this.bfo.isGod(), this.mFromType, this.bfr, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.bft = aVar;
    }
}
