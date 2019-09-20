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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a bTT;
    private b ceA;
    private BdUniqueId ceB;
    private d ceC;
    private a ceD;
    protected com.baidu.tbadk.core.view.userLike.a cez;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.cez != null && !StringUtils.isNull(c.this.cez.getUserId()) && data != null && c.this.cez.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.ceB == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.ceB)) ? false : true;
                    if (data.ciI == null) {
                        if (!data.Hs) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).agW();
                            if (c.this.ceA != null) {
                                if (z) {
                                    c.this.ceA.d(c.this.cez.getIsLike(), c.this.cez.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.ceA.f(c.this.cez.getIsLike(), c.this.cez.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.cez.getFansNum();
                        if (data.isAttention && !c.this.cez.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.cez.getIsLike()) {
                            fansNum--;
                        }
                        c.this.cez.setLikeStatus(data.status);
                        c.this.cez.setIsLike(data.isAttention);
                        c.this.cez.setIsFromNetWork(false);
                        c.this.cez.setFansNum(fansNum);
                        if (c.this.ceA != null) {
                            c.this.ceA.ji(fansNum);
                            if (z) {
                                if (c.this.ceD != null) {
                                    c.this.ceD.ez(data.isAttention);
                                }
                                c.this.ceA.d(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.ceA.f(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ez(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bTT = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.ceB = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bTT = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.ceB = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ceB = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.ceB);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.ceA = bVar;
        if (this.ceA != null) {
            this.ceA.e(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.cez = aVar;
        if (this.ceA != null && this.cez != null) {
            this.ceA.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.ceA.ji(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a alw() {
        return this.cez;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ceC == null || !this.ceC.aG(view)) {
            if (!j.jQ()) {
                this.mPageContext.showToast(R.string.network_ungeilivable);
            }
            if (this.ceA != null) {
                this.ceA.aZ(view);
            }
            if (bc.cF(this.mPageContext.getPageActivity()) && this.cez != null) {
                if (this.ceB == null) {
                    this.bTT.a(this.cez.getIsLike() ? false : true, this.cez.getPortrait(), this.cez.getUserId(), this.cez.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bTT.a(this.cez.getIsLike() ? false : true, this.cez.getPortrait(), this.cez.getUserId(), this.cez.isGod(), this.mFromType, this.ceB, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.ceD = aVar;
    }
}
