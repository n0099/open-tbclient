package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    protected com.baidu.tbadk.core.view.userLike.a apF;
    private b apG;
    private BdUniqueId apJ;
    private com.baidu.tbadk.e.a apK;
    private a apL;
    private TbPageContext mF;
    private String apI = "0";
    private CustomMessageListener apM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.apF != null && !StringUtils.isNull(c.this.apF.getUserId()) && data != null && c.this.apF.getUserId().equals(data.toUid)) {
                    if (!data.BW) {
                        c.this.mF.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    int fansNum = c.this.apF.getFansNum();
                    if (data.isAttention && !c.this.apF.getIsLike()) {
                        fansNum++;
                    } else if (!data.isAttention && c.this.apF.getIsLike()) {
                        fansNum--;
                    }
                    c.this.apF.setIsLike(data.isAttention);
                    c.this.apF.setIsFromNetWork(false);
                    c.this.apF.setFansNum(fansNum);
                    if (c.this.apG != null) {
                        c.this.apG.dw(fansNum);
                        if (updateAttentionMessage.getOrginalMessage() != null && c.this.apJ != null && updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.apJ) && c.this.apL != null) {
                            c.this.apL.aR(data.isAttention);
                        }
                        c.this.apG.aQ(data.isAttention);
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.c.a apH = new com.baidu.tbadk.coreExtra.c.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void aR(boolean z);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.apK = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.mF = tbPageContext;
        tbPageContext.registerListener(this.apM);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mF = tbPageContext;
        tbPageContext.registerListener(this.apM);
        a(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.apJ = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.apM);
            this.apM.setTag(this.apJ);
            MessageManager.getInstance().registerListener(this.apM);
        }
    }

    public void a(b bVar) {
        this.apG = bVar;
        if (this.apG != null) {
            this.apG.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.apF = aVar;
        if (this.apG != null && this.apF != null) {
            this.apG.aQ(aVar.getIsLike());
            this.apG.dw(aVar.getFansNum());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.apK == null || !this.apK.s(view)) {
            if (!i.gW()) {
                this.mF.showToast(d.l.network_ungeilivable);
            }
            if (this.apG != null) {
                this.apG.H(view);
            }
            if (ax.aT(this.mF.getPageActivity()) && this.apF != null) {
                if (this.apJ == null) {
                    this.apH.a(this.apF.getIsLike() ? false : true, this.apF.getPortrait(), this.apF.getUserId(), this.apF.isGod(), this.mF.getUniqueId());
                } else {
                    this.apH.a(this.apF.getIsLike() ? false : true, this.apF.getPortrait(), this.apF.getUserId(), this.apF.isGod(), this.apJ);
                }
            }
        }
    }

    public void a(a aVar) {
        this.apL = aVar;
    }
}
