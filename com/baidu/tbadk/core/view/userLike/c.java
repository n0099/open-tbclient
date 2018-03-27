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
    protected com.baidu.tbadk.core.view.userLike.a bfr;
    private b bfs;
    private com.baidu.tbadk.coreExtra.model.a bft;
    private BdUniqueId bfu;
    private com.baidu.tbadk.d.a bfv;
    private a bfw;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.bfr != null && !StringUtils.isNull(c.this.bfr.getUserId()) && data != null && c.this.bfr.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.bfu == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.bfu)) ? false : true;
                    if (data.biK == null) {
                        if (!data.apH) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.bfs != null) {
                                if (z) {
                                    c.this.bfs.a(c.this.bfr.getIsLike(), c.this.bfr.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.bfs.f(c.this.bfr.getIsLike(), c.this.bfr.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.bfr.getFansNum();
                        if (data.isAttention && !c.this.bfr.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.bfr.getIsLike()) {
                            fansNum--;
                        }
                        c.this.bfr.setLikeStatus(data.status);
                        c.this.bfr.setIsLike(data.isAttention);
                        c.this.bfr.setIsFromNetWork(false);
                        c.this.bfr.setFansNum(fansNum);
                        if (c.this.bfs != null) {
                            c.this.bfs.gD(fansNum);
                            if (z) {
                                if (c.this.bfw != null) {
                                    c.this.bfw.bA(data.isAttention);
                                }
                                c.this.bfs.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.bfs.f(data.isAttention, data.status);
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
        this.bft = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bfu = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bft = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bfu = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bfu = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.bfu);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.bfs = bVar;
        if (this.bfs != null) {
            this.bfs.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.bfr = aVar;
        if (this.bfs != null && this.bfr != null) {
            this.bfs.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.bfs.gD(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a EE() {
        return this.bfr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bfv == null || !this.bfv.aL(view)) {
            if (!j.ox()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.bfs != null) {
                this.bfs.bc(view);
            }
            if (ay.ba(this.mPageContext.getPageActivity()) && this.bfr != null) {
                if (this.bfu == null) {
                    this.bft.a(this.bfr.getIsLike() ? false : true, this.bfr.getPortrait(), this.bfr.getUserId(), this.bfr.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bft.a(this.bfr.getIsLike() ? false : true, this.bfr.getPortrait(), this.bfr.getUserId(), this.bfr.isGod(), this.mFromType, this.bfu, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.bfw = aVar;
    }
}
