package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a ait;
    protected com.baidu.tbadk.core.view.userLike.a aqG;
    private b aqH;
    private BdUniqueId aqI;
    private com.baidu.tbadk.e.a aqJ;
    private a aqK;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aqG != null && !StringUtils.isNull(c.this.aqG.getUserId()) && data != null && c.this.aqG.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.aqI == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aqI)) ? false : true;
                    if (data.aup == null) {
                        if (!data.Ai) {
                            c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.aqH != null) {
                                if (z) {
                                    c.this.aqH.a(c.this.aqG.getIsLike(), c.this.aqG.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.aqH.d(c.this.aqG.getIsLike(), c.this.aqG.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.aqG.getFansNum();
                        if (data.isAttention && !c.this.aqG.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.aqG.getIsLike()) {
                            fansNum--;
                        }
                        c.this.aqG.setLikeStatus(data.status);
                        c.this.aqG.setIsLike(data.isAttention);
                        c.this.aqG.setIsFromNetWork(false);
                        c.this.aqG.setFansNum(fansNum);
                        if (c.this.aqH != null) {
                            c.this.aqH.dC(fansNum);
                            if (z) {
                                if (c.this.aqK != null) {
                                    c.this.aqK.aR(data.isAttention);
                                }
                                c.this.aqH.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.aqH.d(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aR(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ait = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aqI = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.ait = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aqI = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aqI = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.aqI);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.aqH = bVar;
        if (this.aqH != null) {
            this.aqH.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aqG = aVar;
        if (this.aqH != null && this.aqG != null) {
            this.aqH.d(aVar.getIsLike(), aVar.getLikeStatus());
            this.aqH.dC(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a xn() {
        return this.aqG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.aqJ == null || !this.aqJ.t(view2)) {
            if (!j.gD()) {
                this.mPageContext.showToast(d.k.network_ungeilivable);
            }
            if (this.aqH != null) {
                this.aqH.K(view2);
            }
            if (az.aK(this.mPageContext.getPageActivity()) && this.aqG != null) {
                if (this.aqI == null) {
                    this.ait.a(this.aqG.getIsLike() ? false : true, this.aqG.getPortrait(), this.aqG.getUserId(), this.aqG.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.ait.a(this.aqG.getIsLike() ? false : true, this.aqG.getPortrait(), this.aqG.getUserId(), this.aqG.isGod(), this.mFromType, this.aqI, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.aqK = aVar;
    }
}
