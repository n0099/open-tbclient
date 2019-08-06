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
    private com.baidu.tbadk.coreExtra.model.a bTs;
    protected com.baidu.tbadk.core.view.userLike.a cdG;
    private b cdH;
    private BdUniqueId cdI;
    private d cdJ;
    private a cdK;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.cdG != null && !StringUtils.isNull(c.this.cdG.getUserId()) && data != null && c.this.cdG.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.cdI == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.cdI)) ? false : true;
                    if (data.chM == null) {
                        if (!data.Hs) {
                            BdToast.b(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_toast_game_error, 3000).agS();
                            if (c.this.cdH != null) {
                                if (z) {
                                    c.this.cdH.d(c.this.cdG.getIsLike(), c.this.cdG.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.cdH.f(c.this.cdG.getIsLike(), c.this.cdG.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.cdG.getFansNum();
                        if (data.isAttention && !c.this.cdG.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.cdG.getIsLike()) {
                            fansNum--;
                        }
                        c.this.cdG.setLikeStatus(data.status);
                        c.this.cdG.setIsLike(data.isAttention);
                        c.this.cdG.setIsFromNetWork(false);
                        c.this.cdG.setFansNum(fansNum);
                        if (c.this.cdH != null) {
                            c.this.cdH.jf(fansNum);
                            if (z) {
                                if (c.this.cdK != null) {
                                    c.this.cdK.ew(data.isAttention);
                                }
                                c.this.cdH.d(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.cdH.f(data.isAttention, data.status);
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
        this.bTs = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.cdI = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.bTs = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.cdI = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cdI = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.cdI);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.cdH = bVar;
        if (this.cdH != null) {
            this.cdH.e(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.cdG = aVar;
        if (this.cdH != null && this.cdG != null) {
            this.cdH.f(aVar.getIsLike(), aVar.getLikeStatus());
            this.cdH.jf(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a alk() {
        return this.cdG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cdJ == null || !this.cdJ.aG(view)) {
            if (!j.jQ()) {
                this.mPageContext.showToast(R.string.network_ungeilivable);
            }
            if (this.cdH != null) {
                this.cdH.aZ(view);
            }
            if (bd.cF(this.mPageContext.getPageActivity()) && this.cdG != null) {
                if (this.cdI == null) {
                    this.bTs.a(this.cdG.getIsLike() ? false : true, this.cdG.getPortrait(), this.cdG.getUserId(), this.cdG.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.bTs.a(this.cdG.getIsLike() ? false : true, this.cdG.getPortrait(), this.cdG.getUserId(), this.cdG.isGod(), this.mFromType, this.cdI, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.cdK = aVar;
    }
}
