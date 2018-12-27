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
    protected com.baidu.tbadk.core.view.userLike.a aLv;
    private b aLw;
    private BdUniqueId aLx;
    private com.baidu.tbadk.f.b aLy;
    private a aLz;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aLv != null && !StringUtils.isNull(c.this.aLv.getUserId()) && data != null && c.this.aLv.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.aLx == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aLx)) ? false : true;
                    if (data.aPt == null) {
                        if (!data.Jr) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, e.f.icon_toast_game_error, 3000).BN();
                            if (c.this.aLw != null) {
                                if (z) {
                                    c.this.aLw.a(c.this.aLv.getIsLike(), c.this.aLv.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.aLw.d(c.this.aLv.getIsLike(), c.this.aLv.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.aLv.getFansNum();
                        if (data.isAttention && !c.this.aLv.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.aLv.getIsLike()) {
                            fansNum--;
                        }
                        c.this.aLv.setLikeStatus(data.status);
                        c.this.aLv.setIsLike(data.isAttention);
                        c.this.aLv.setIsFromNetWork(false);
                        c.this.aLv.setFansNum(fansNum);
                        if (c.this.aLw != null) {
                            c.this.aLw.eF(fansNum);
                            if (z) {
                                if (c.this.aLz != null) {
                                    c.this.aLz.bL(data.isAttention);
                                }
                                c.this.aLw.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.aLw.d(data.isAttention, data.status);
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
        this.aLx = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.aCb = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aLx = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aLx = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.aLx);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.aLw = bVar;
        if (this.aLw != null) {
            this.aLw.d(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aLv = aVar;
        if (this.aLw != null && this.aLv != null) {
            this.aLw.d(aVar.getIsLike(), aVar.getLikeStatus());
            this.aLw.eF(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a FA() {
        return this.aLv;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aLy == null || !this.aLy.F(view)) {
            if (!j.kK()) {
                this.mPageContext.showToast(e.j.network_ungeilivable);
            }
            if (this.aLw != null) {
                this.aLw.X(view);
            }
            if (ba.bJ(this.mPageContext.getPageActivity()) && this.aLv != null) {
                if (this.aLx == null) {
                    this.aCb.a(this.aLv.getIsLike() ? false : true, this.aLv.getPortrait(), this.aLv.getUserId(), this.aLv.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.aCb.a(this.aLv.getIsLike() ? false : true, this.aLv.getPortrait(), this.aLv.getUserId(), this.aLv.isGod(), this.mFromType, this.aLx, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.aLz = aVar;
    }
}
