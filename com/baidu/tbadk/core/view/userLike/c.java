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
    private com.baidu.tbadk.f.b aCA;
    private a aCB;
    protected com.baidu.tbadk.core.view.userLike.a aCx;
    private b aCy;
    private BdUniqueId aCz;
    private com.baidu.tbadk.coreExtra.model.a atd;
    private TbPageContext mPageContext;
    private String mFromType = "0";
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aCx != null && !StringUtils.isNull(c.this.aCx.getUserId()) && data != null && c.this.aCx.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.aCz == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aCz)) ? false : true;
                    if (data.aGz == null) {
                        if (!data.IM) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, e.f.icon_toast_game_error, 3000).yt();
                            if (c.this.aCy != null) {
                                if (z) {
                                    c.this.aCy.a(c.this.aCx.getIsLike(), c.this.aCx.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.aCy.d(c.this.aCx.getIsLike(), c.this.aCx.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.aCx.getFansNum();
                        if (data.isAttention && !c.this.aCx.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.aCx.getIsLike()) {
                            fansNum--;
                        }
                        c.this.aCx.setLikeStatus(data.status);
                        c.this.aCx.setIsLike(data.isAttention);
                        c.this.aCx.setIsFromNetWork(false);
                        c.this.aCx.setFansNum(fansNum);
                        if (c.this.aCy != null) {
                            c.this.aCy.dS(fansNum);
                            if (z) {
                                if (c.this.aCB != null) {
                                    c.this.aCB.bj(data.isAttention);
                                }
                                c.this.aCy.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.aCy.d(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bj(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.atd = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aCz = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.atd = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.aCz = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.mAttentionListener);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aCz = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
            this.mAttentionListener.setTag(this.aCz);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
        }
    }

    public void a(b bVar) {
        this.aCy = bVar;
        if (this.aCy != null) {
            this.aCy.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aCx = aVar;
        if (this.aCy != null && this.aCx != null) {
            this.aCy.d(aVar.getIsLike(), aVar.getLikeStatus());
            this.aCy.dS(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a Cg() {
        return this.aCx;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aCA == null || !this.aCA.F(view)) {
            if (!j.ky()) {
                this.mPageContext.showToast(e.j.network_ungeilivable);
            }
            if (this.aCy != null) {
                this.aCy.X(view);
            }
            if (ba.bA(this.mPageContext.getPageActivity()) && this.aCx != null) {
                if (this.aCz == null) {
                    this.atd.a(this.aCx.getIsLike() ? false : true, this.aCx.getPortrait(), this.aCx.getUserId(), this.aCx.isGod(), this.mFromType, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.atd.a(this.aCx.getIsLike() ? false : true, this.aCx.getPortrait(), this.aCx.getUserId(), this.aCx.isGod(), this.mFromType, this.aCz, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.aCB = aVar;
    }
}
