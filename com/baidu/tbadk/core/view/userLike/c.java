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
    protected com.baidu.tbadk.core.view.userLike.a apD;
    private b apE;
    private BdUniqueId apH;
    private com.baidu.tbadk.e.a apI;
    private a apJ;
    private TbPageContext mF;
    private String apG = "0";
    private CustomMessageListener apK = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.apD != null && !StringUtils.isNull(c.this.apD.getUserId()) && data != null && c.this.apD.getUserId().equals(data.toUid)) {
                    if (!data.BW) {
                        c.this.mF.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    int fansNum = c.this.apD.getFansNum();
                    if (data.isAttention && !c.this.apD.getIsLike()) {
                        fansNum++;
                    } else if (!data.isAttention && c.this.apD.getIsLike()) {
                        fansNum--;
                    }
                    c.this.apD.setIsLike(data.isAttention);
                    c.this.apD.setIsFromNetWork(false);
                    c.this.apD.setFansNum(fansNum);
                    if (c.this.apE != null) {
                        c.this.apE.dw(fansNum);
                        if (updateAttentionMessage.getOrginalMessage() != null && c.this.apH != null && updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.apH) && c.this.apJ != null) {
                            c.this.apJ.aR(data.isAttention);
                        }
                        c.this.apE.aQ(data.isAttention);
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.c.a apF = new com.baidu.tbadk.coreExtra.c.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void aR(boolean z);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.apI = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.mF = tbPageContext;
        tbPageContext.registerListener(this.apK);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mF = tbPageContext;
        tbPageContext.registerListener(this.apK);
        a(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.apH = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.apK);
            this.apK.setTag(this.apH);
            MessageManager.getInstance().registerListener(this.apK);
        }
    }

    public void a(b bVar) {
        this.apE = bVar;
        if (this.apE != null) {
            this.apE.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.apD = aVar;
        if (this.apE != null && this.apD != null) {
            this.apE.aQ(aVar.getIsLike());
            this.apE.dw(aVar.getFansNum());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.apI == null || !this.apI.s(view)) {
            if (!i.gW()) {
                this.mF.showToast(d.l.network_ungeilivable);
            }
            if (this.apE != null) {
                this.apE.H(view);
            }
            if (ax.aU(this.mF.getPageActivity()) && this.apD != null) {
                if (this.apH == null) {
                    this.apF.a(this.apD.getIsLike() ? false : true, this.apD.getPortrait(), this.apD.getUserId(), this.apD.isGod(), this.mF.getUniqueId());
                } else {
                    this.apF.a(this.apD.getIsLike() ? false : true, this.apD.getPortrait(), this.apD.getUserId(), this.apD.isGod(), this.apH);
                }
            }
        }
    }

    public void a(a aVar) {
        this.apJ = aVar;
    }
}
