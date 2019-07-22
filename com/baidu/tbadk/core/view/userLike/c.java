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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a bTm;
    private b cdA;
    private BdUniqueId cdB;
    private d cdC;
    private a cdD;
    protected com.baidu.tbadk.core.view.userLike.a cdz;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.cdz != null && !StringUtils.isNull(c.this.cdz.getUserId()) && data != null && c.this.cdz.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.cdB == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.cdB)) ? false : true;
                    if (data.chF == null) {
                        if (!data.Hs) {
                            BdToast.b(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_toast_game_error, 3000).agQ();
                            if (c.this.cdA != null) {
                                if (z) {
                                    c.this.cdA.d(c.this.cdz.getIsLike(), c.this.cdz.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.cdA.f(c.this.cdz.getIsLike(), c.this.cdz.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.cdz.getFansNum();
                        if (data.isAttention && !c.this.cdz.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.cdz.getIsLike()) {
                            fansNum--;
                        }
                        c.this.cdz.setLikeStatus(data.status);
                        c.this.cdz.setIsLike(data.isAttention);
                        c.this.cdz.setIsFromNetWork(false);
                        c.this.cdz.setFansNum(fansNum);
                        if (c.this.cdA != null) {
                            c.this.cdA.je(fansNum);
                            if (z) {
                                if (c.this.cdD != null) {
                                    c.this.cdD.ew(data.isAttention);
                                }
                                c.this.cdA.d(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.cdA.f(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ew(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bTm = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.cdB = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bTm = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.cdB = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cdB = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.cdB);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.cdA = bVar;
        if (this.cdA != null) {
            this.cdA.e(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.cdz = aVar;
        if (this.cdA != null && this.cdz != null) {
            this.cdA.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.cdA.je(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a ali() {
        return this.cdz;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cdC == null || !this.cdC.aG(view)) {
            if (!j.jQ()) {
                this.mPageContext.showToast(R.string.network_ungeilivable);
            }
            if (this.cdA != null) {
                this.cdA.aZ(view);
            }
            if (bd.cF(this.mPageContext.getPageActivity()) && this.cdz != null) {
                if (this.cdB == null) {
                    this.bTm.a(this.cdz.getIsLike() ? false : true, this.cdz.getPortrait(), this.cdz.getUserId(), this.cdz.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bTm.a(this.cdz.getIsLike() ? false : true, this.cdz.getPortrait(), this.cdz.getUserId(), this.cdz.isGod(), this.mFromType, this.cdB, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.cdD = aVar;
    }
}
