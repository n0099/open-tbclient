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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a aqF;
    protected com.baidu.tbadk.core.view.userLike.a azv;
    private b azw;
    private BdUniqueId azx;
    private com.baidu.tbadk.f.b azy;
    private a azz;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.azv != null && !StringUtils.isNull(c.this.azv.getUserId()) && data != null && c.this.azv.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.azx == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.azx)) ? false : true;
                    if (data.aDt == null) {
                        if (!data.Gp) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, f.C0146f.icon_toast_game_error, 3000).xm();
                            if (c.this.azw != null) {
                                if (z) {
                                    c.this.azw.a(c.this.azv.getIsLike(), c.this.azv.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.azw.d(c.this.azv.getIsLike(), c.this.azv.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.azv.getFansNum();
                        if (data.isAttention && !c.this.azv.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.azv.getIsLike()) {
                            fansNum--;
                        }
                        c.this.azv.setLikeStatus(data.status);
                        c.this.azv.setIsLike(data.isAttention);
                        c.this.azv.setIsFromNetWork(false);
                        c.this.azv.setFansNum(fansNum);
                        if (c.this.azw != null) {
                            c.this.azw.dH(fansNum);
                            if (z) {
                                if (c.this.azz != null) {
                                    c.this.azz.aX(data.isAttention);
                                }
                                c.this.azw.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.azw.d(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aX(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aqF = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.azx = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.aqF = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.azx = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.azx = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.azx);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.azw = bVar;
        if (this.azw != null) {
            this.azw.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.azv = aVar;
        if (this.azw != null && this.azv != null) {
            this.azw.d(aVar.getIsLike(), aVar.getLikeStatus());
            this.azw.dH(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a AU() {
        return this.azv;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.azy == null || !this.azy.v(view)) {
            if (!j.js()) {
                this.mPageContext.showToast(f.j.network_ungeilivable);
            }
            if (this.azw != null) {
                this.azw.L(view);
            }
            if (bb.aU(this.mPageContext.getPageActivity()) && this.azv != null) {
                if (this.azx == null) {
                    this.aqF.a(this.azv.getIsLike() ? false : true, this.azv.getPortrait(), this.azv.getUserId(), this.azv.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.aqF.a(this.azv.getIsLike() ? false : true, this.azv.getPortrait(), this.azv.getUserId(), this.azv.isGod(), this.mFromType, this.azx, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.azz = aVar;
    }
}
