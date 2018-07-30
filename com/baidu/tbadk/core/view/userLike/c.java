package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a aqE;
    private BdUniqueId azA;
    private com.baidu.tbadk.f.b azB;
    private a azC;
    protected com.baidu.tbadk.core.view.userLike.a azy;
    private b azz;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.azy != null && !StringUtils.isNull(c.this.azy.getUserId()) && data != null && c.this.azy.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.azA == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.azA)) ? false : true;
                    if (data.aDu == null) {
                        if (!data.Gp) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, d.f.icon_toast_game_error, 3000).xn();
                            if (c.this.azz != null) {
                                if (z) {
                                    c.this.azz.a(c.this.azy.getIsLike(), c.this.azy.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.azz.d(c.this.azy.getIsLike(), c.this.azy.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.azy.getFansNum();
                        if (data.isAttention && !c.this.azy.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.azy.getIsLike()) {
                            fansNum--;
                        }
                        c.this.azy.setLikeStatus(data.status);
                        c.this.azy.setIsLike(data.isAttention);
                        c.this.azy.setIsFromNetWork(false);
                        c.this.azy.setFansNum(fansNum);
                        if (c.this.azz != null) {
                            c.this.azz.dI(fansNum);
                            if (z) {
                                if (c.this.azC != null) {
                                    c.this.azC.aW(data.isAttention);
                                }
                                c.this.azz.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.azz.d(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aW(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aqE = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.azA = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.aqE = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.azA = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.azA = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.azA);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.azz = bVar;
        if (this.azz != null) {
            this.azz.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.azy = aVar;
        if (this.azz != null && this.azy != null) {
            this.azz.d(aVar.getIsLike(), aVar.getLikeStatus());
            this.azz.dI(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a AX() {
        return this.azy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.azB == null || !this.azB.v(view)) {
            if (!j.js()) {
                this.mPageContext.showToast(d.j.network_ungeilivable);
            }
            if (this.azz != null) {
                this.azz.L(view);
            }
            if (ba.aV(this.mPageContext.getPageActivity()) && this.azy != null) {
                if (this.azA == null) {
                    this.aqE.a(this.azy.getIsLike() ? false : true, this.azy.getPortrait(), this.azy.getUserId(), this.azy.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.aqE.a(this.azy.getIsLike() ? false : true, this.azy.getPortrait(), this.azy.getUserId(), this.azy.isGod(), this.mFromType, this.azA, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.azC = aVar;
    }
}
