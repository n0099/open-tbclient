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
    protected com.baidu.tbadk.core.view.userLike.a bfA;
    private b bfB;
    private com.baidu.tbadk.coreExtra.model.a bfC;
    private BdUniqueId bfD;
    private com.baidu.tbadk.d.a bfE;
    private a bfF;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.bfA != null && !StringUtils.isNull(c.this.bfA.getUserId()) && data != null && c.this.bfA.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.bfD == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.bfD)) ? false : true;
                    if (data.biU == null) {
                        if (!data.apP) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.bfB != null) {
                                if (z) {
                                    c.this.bfB.a(c.this.bfA.getIsLike(), c.this.bfA.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.bfB.f(c.this.bfA.getIsLike(), c.this.bfA.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.bfA.getFansNum();
                        if (data.isAttention && !c.this.bfA.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.bfA.getIsLike()) {
                            fansNum--;
                        }
                        c.this.bfA.setLikeStatus(data.status);
                        c.this.bfA.setIsLike(data.isAttention);
                        c.this.bfA.setIsFromNetWork(false);
                        c.this.bfA.setFansNum(fansNum);
                        if (c.this.bfB != null) {
                            c.this.bfB.gD(fansNum);
                            if (z) {
                                if (c.this.bfF != null) {
                                    c.this.bfF.bA(data.isAttention);
                                }
                                c.this.bfB.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.bfB.f(data.isAttention, data.status);
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
        this.bfC = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bfD = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bfC = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.bfD = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bfD = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.bfD);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.bfB = bVar;
        if (this.bfB != null) {
            this.bfB.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.bfA = aVar;
        if (this.bfB != null && this.bfA != null) {
            this.bfB.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.bfB.gD(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a EE() {
        return this.bfA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bfE == null || !this.bfE.aL(view)) {
            if (!j.ox()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.bfB != null) {
                this.bfB.bc(view);
            }
            if (ay.ba(this.mPageContext.getPageActivity()) && this.bfA != null) {
                if (this.bfD == null) {
                    this.bfC.a(this.bfA.getIsLike() ? false : true, this.bfA.getPortrait(), this.bfA.getUserId(), this.bfA.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bfC.a(this.bfA.getIsLike() ? false : true, this.bfA.getPortrait(), this.bfA.getUserId(), this.bfA.isGod(), this.mFromType, this.bfD, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.bfF = aVar;
    }
}
