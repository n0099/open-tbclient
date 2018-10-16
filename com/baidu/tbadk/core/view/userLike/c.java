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
    protected com.baidu.tbadk.core.view.userLike.a aHd;
    private b aHe;
    private BdUniqueId aHf;
    private com.baidu.tbadk.f.b aHg;
    private a aHh;
    private com.baidu.tbadk.coreExtra.model.a axO;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aHd != null && !StringUtils.isNull(c.this.aHd.getUserId()) && data != null && c.this.aHd.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.aHf == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aHf)) ? false : true;
                    if (data.aLc == null) {
                        if (!data.Jo) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, e.f.icon_toast_game_error, 3000).AC();
                            if (c.this.aHe != null) {
                                if (z) {
                                    c.this.aHe.a(c.this.aHd.getIsLike(), c.this.aHd.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.aHe.d(c.this.aHd.getIsLike(), c.this.aHd.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.aHd.getFansNum();
                        if (data.isAttention && !c.this.aHd.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.aHd.getIsLike()) {
                            fansNum--;
                        }
                        c.this.aHd.setLikeStatus(data.status);
                        c.this.aHd.setIsLike(data.isAttention);
                        c.this.aHd.setIsFromNetWork(false);
                        c.this.aHd.setFansNum(fansNum);
                        if (c.this.aHe != null) {
                            c.this.aHe.ec(fansNum);
                            if (z) {
                                if (c.this.aHh != null) {
                                    c.this.aHh.bt(data.isAttention);
                                }
                                c.this.aHe.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.aHe.d(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bt(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.axO = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aHf = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.axO = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aHf = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aHf = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.aHf);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.aHe = bVar;
        if (this.aHe != null) {
            this.aHe.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aHd = aVar;
        if (this.aHe != null && this.aHd != null) {
            this.aHe.d(aVar.getIsLike(), aVar.getLikeStatus());
            this.aHe.ec(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a El() {
        return this.aHd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aHg == null || !this.aHg.F(view)) {
            if (!j.kM()) {
                this.mPageContext.showToast(e.j.network_ungeilivable);
            }
            if (this.aHe != null) {
                this.aHe.X(view);
            }
            if (ba.bI(this.mPageContext.getPageActivity()) && this.aHd != null) {
                if (this.aHf == null) {
                    this.axO.a(this.aHd.getIsLike() ? false : true, this.aHd.getPortrait(), this.aHd.getUserId(), this.aHd.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.axO.a(this.aHd.getIsLike() ? false : true, this.aHd.getPortrait(), this.aHd.getUserId(), this.aHd.isGod(), this.mFromType, this.aHf, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.aHh = aVar;
    }
}
