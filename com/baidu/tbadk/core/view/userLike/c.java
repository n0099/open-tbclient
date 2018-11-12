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
    protected com.baidu.tbadk.core.view.userLike.a aHT;
    private b aHU;
    private BdUniqueId aHV;
    private com.baidu.tbadk.f.b aHW;
    private a aHX;
    private com.baidu.tbadk.coreExtra.model.a ayB;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aHT != null && !StringUtils.isNull(c.this.aHT.getUserId()) && data != null && c.this.aHT.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.aHV == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aHV)) ? false : true;
                    if (data.aLS == null) {
                        if (!data.Jr) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, e.f.icon_toast_game_error, 3000).AJ();
                            if (c.this.aHU != null) {
                                if (z) {
                                    c.this.aHU.a(c.this.aHT.getIsLike(), c.this.aHT.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.aHU.d(c.this.aHT.getIsLike(), c.this.aHT.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.aHT.getFansNum();
                        if (data.isAttention && !c.this.aHT.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.aHT.getIsLike()) {
                            fansNum--;
                        }
                        c.this.aHT.setLikeStatus(data.status);
                        c.this.aHT.setIsLike(data.isAttention);
                        c.this.aHT.setIsFromNetWork(false);
                        c.this.aHT.setFansNum(fansNum);
                        if (c.this.aHU != null) {
                            c.this.aHU.eq(fansNum);
                            if (z) {
                                if (c.this.aHX != null) {
                                    c.this.aHX.bK(data.isAttention);
                                }
                                c.this.aHU.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.aHU.d(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bK(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ayB = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aHV = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.ayB = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aHV = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aHV = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.aHV);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.aHU = bVar;
        if (this.aHU != null) {
            this.aHU.d(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aHT = aVar;
        if (this.aHU != null && this.aHT != null) {
            this.aHU.d(aVar.getIsLike(), aVar.getLikeStatus());
            this.aHU.eq(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a Ev() {
        return this.aHT;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aHW == null || !this.aHW.F(view)) {
            if (!j.kK()) {
                this.mPageContext.showToast(e.j.network_ungeilivable);
            }
            if (this.aHU != null) {
                this.aHU.X(view);
            }
            if (ba.bG(this.mPageContext.getPageActivity()) && this.aHT != null) {
                if (this.aHV == null) {
                    this.ayB.a(this.aHT.getIsLike() ? false : true, this.aHT.getPortrait(), this.aHT.getUserId(), this.aHT.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.ayB.a(this.aHT.getIsLike() ? false : true, this.aHT.getPortrait(), this.aHT.getUserId(), this.aHT.isGod(), this.mFromType, this.aHV, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.aHX = aVar;
    }
}
