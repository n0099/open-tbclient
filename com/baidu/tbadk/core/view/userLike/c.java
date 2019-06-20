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
    private com.baidu.tbadk.coreExtra.model.a bSm;
    private d ccA;
    private a ccB;
    protected com.baidu.tbadk.core.view.userLike.a ccx;
    private b ccy;
    private BdUniqueId ccz;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.ccx != null && !StringUtils.isNull(c.this.ccx.getUserId()) && data != null && c.this.ccx.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.ccz == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.ccz)) ? false : true;
                    if (data.cgA == null) {
                        if (!data.Hh) {
                            BdToast.b(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_toast_game_error, 3000).afO();
                            if (c.this.ccy != null) {
                                if (z) {
                                    c.this.ccy.d(c.this.ccx.getIsLike(), c.this.ccx.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.ccy.f(c.this.ccx.getIsLike(), c.this.ccx.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.ccx.getFansNum();
                        if (data.isAttention && !c.this.ccx.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.ccx.getIsLike()) {
                            fansNum--;
                        }
                        c.this.ccx.setLikeStatus(data.status);
                        c.this.ccx.setIsLike(data.isAttention);
                        c.this.ccx.setIsFromNetWork(false);
                        c.this.ccx.setFansNum(fansNum);
                        if (c.this.ccy != null) {
                            c.this.ccy.iY(fansNum);
                            if (z) {
                                if (c.this.ccB != null) {
                                    c.this.ccB.es(data.isAttention);
                                }
                                c.this.ccy.d(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.ccy.f(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void es(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bSm = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.ccz = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bSm = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.ccz = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ccz = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.ccz);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.ccy = bVar;
        if (this.ccy != null) {
            this.ccy.e(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.ccx = aVar;
        if (this.ccy != null && this.ccx != null) {
            this.ccy.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.ccy.iY(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a akd() {
        return this.ccx;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ccA == null || !this.ccA.aE(view)) {
            if (!j.jG()) {
                this.mPageContext.showToast(R.string.network_ungeilivable);
            }
            if (this.ccy != null) {
                this.ccy.aX(view);
            }
            if (bc.cE(this.mPageContext.getPageActivity()) && this.ccx != null) {
                if (this.ccz == null) {
                    this.bSm.a(this.ccx.getIsLike() ? false : true, this.ccx.getPortrait(), this.ccx.getUserId(), this.ccx.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bSm.a(this.ccx.getIsLike() ? false : true, this.ccx.getPortrait(), this.ccx.getUserId(), this.ccx.isGod(), this.mFromType, this.ccz, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.ccB = aVar;
    }
}
