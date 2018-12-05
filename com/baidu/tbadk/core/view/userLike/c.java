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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a aCb;
    protected com.baidu.tbadk.core.view.userLike.a aLt;
    private b aLu;
    private BdUniqueId aLv;
    private com.baidu.tbadk.f.b aLw;
    private a aLx;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aLt != null && !StringUtils.isNull(c.this.aLt.getUserId()) && data != null && c.this.aLt.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.aLv == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aLv)) ? false : true;
                    if (data.aPr == null) {
                        if (!data.Jr) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, e.f.icon_toast_game_error, 3000).BN();
                            if (c.this.aLu != null) {
                                if (z) {
                                    c.this.aLu.a(c.this.aLt.getIsLike(), c.this.aLt.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.aLu.d(c.this.aLt.getIsLike(), c.this.aLt.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.aLt.getFansNum();
                        if (data.isAttention && !c.this.aLt.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.aLt.getIsLike()) {
                            fansNum--;
                        }
                        c.this.aLt.setLikeStatus(data.status);
                        c.this.aLt.setIsLike(data.isAttention);
                        c.this.aLt.setIsFromNetWork(false);
                        c.this.aLt.setFansNum(fansNum);
                        if (c.this.aLu != null) {
                            c.this.aLu.eE(fansNum);
                            if (z) {
                                if (c.this.aLx != null) {
                                    c.this.aLx.bL(data.isAttention);
                                }
                                c.this.aLu.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.aLu.d(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bL(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aCb = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aLv = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.aCb = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aLv = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aLv = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.aLv);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.aLu = bVar;
        if (this.aLu != null) {
            this.aLu.d(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aLt = aVar;
        if (this.aLu != null && this.aLt != null) {
            this.aLu.d(aVar.getIsLike(), aVar.getLikeStatus());
            this.aLu.eE(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a Fz() {
        return this.aLt;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aLw == null || !this.aLw.F(view)) {
            if (!j.kK()) {
                this.mPageContext.showToast(e.j.network_ungeilivable);
            }
            if (this.aLu != null) {
                this.aLu.X(view);
            }
            if (ba.bJ(this.mPageContext.getPageActivity()) && this.aLt != null) {
                if (this.aLv == null) {
                    this.aCb.a(this.aLt.getIsLike() ? false : true, this.aLt.getPortrait(), this.aLt.getUserId(), this.aLt.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.aCb.a(this.aLt.getIsLike() ? false : true, this.aLt.getPortrait(), this.aLt.getUserId(), this.aLt.isGod(), this.mFromType, this.aLv, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.aLx = aVar;
    }
}
