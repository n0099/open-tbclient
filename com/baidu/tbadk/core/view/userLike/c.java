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
    private com.baidu.tbadk.coreExtra.model.a bSl;
    private a ccA;
    protected com.baidu.tbadk.core.view.userLike.a ccw;
    private b ccx;
    private BdUniqueId ccy;
    private d ccz;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.ccw != null && !StringUtils.isNull(c.this.ccw.getUserId()) && data != null && c.this.ccw.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.ccy == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.ccy)) ? false : true;
                    if (data.cgz == null) {
                        if (!data.Hi) {
                            BdToast.b(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_toast_game_error, 3000).afO();
                            if (c.this.ccx != null) {
                                if (z) {
                                    c.this.ccx.d(c.this.ccw.getIsLike(), c.this.ccw.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.ccx.f(c.this.ccw.getIsLike(), c.this.ccw.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.ccw.getFansNum();
                        if (data.isAttention && !c.this.ccw.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.ccw.getIsLike()) {
                            fansNum--;
                        }
                        c.this.ccw.setLikeStatus(data.status);
                        c.this.ccw.setIsLike(data.isAttention);
                        c.this.ccw.setIsFromNetWork(false);
                        c.this.ccw.setFansNum(fansNum);
                        if (c.this.ccx != null) {
                            c.this.ccx.iY(fansNum);
                            if (z) {
                                if (c.this.ccA != null) {
                                    c.this.ccA.es(data.isAttention);
                                }
                                c.this.ccx.d(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.ccx.f(data.isAttention, data.status);
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
        this.bSl = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.ccy = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bSl = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.ccy = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ccy = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.ccy);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.ccx = bVar;
        if (this.ccx != null) {
            this.ccx.e(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.ccw = aVar;
        if (this.ccx != null && this.ccw != null) {
            this.ccx.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.ccx.iY(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a akd() {
        return this.ccw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ccz == null || !this.ccz.aE(view)) {
            if (!j.jG()) {
                this.mPageContext.showToast(R.string.network_ungeilivable);
            }
            if (this.ccx != null) {
                this.ccx.aX(view);
            }
            if (bc.cE(this.mPageContext.getPageActivity()) && this.ccw != null) {
                if (this.ccy == null) {
                    this.bSl.a(this.ccw.getIsLike() ? false : true, this.ccw.getPortrait(), this.ccw.getUserId(), this.ccw.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bSl.a(this.ccw.getIsLike() ? false : true, this.ccw.getPortrait(), this.ccw.getUserId(), this.ccw.isGod(), this.mFromType, this.ccy, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.ccA = aVar;
    }
}
