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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private TbPageContext ako;
    protected com.baidu.tbadk.core.view.userLike.a aoF;
    private b aoG;
    private BdUniqueId aoJ;
    private com.baidu.tbadk.e.a aoK;
    private a aoL;
    private String aoI = "0";
    private CustomMessageListener aoM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aoF != null && !StringUtils.isNull(c.this.aoF.getUserId()) && data != null && c.this.aoF.getUserId().equals(data.toUid)) {
                    if (!data.CB) {
                        c.this.ako.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    int fansNum = c.this.aoF.getFansNum();
                    if (data.isAttention && !c.this.aoF.getIsLike()) {
                        fansNum++;
                    } else if (!data.isAttention && c.this.aoF.getIsLike()) {
                        fansNum--;
                    }
                    c.this.aoF.setIsLike(data.isAttention);
                    c.this.aoF.setIsFromNetWork(false);
                    c.this.aoF.setFansNum(fansNum);
                    if (c.this.aoG != null) {
                        c.this.aoG.dt(fansNum);
                        if (updateAttentionMessage.getOrginalMessage() != null && c.this.aoJ != null && updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aoJ) && c.this.aoL != null) {
                            c.this.aoL.aR(data.isAttention);
                        }
                        c.this.aoG.aQ(data.isAttention);
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.c.a aoH = new com.baidu.tbadk.coreExtra.c.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void aR(boolean z);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.aoK = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.ako = tbPageContext;
        tbPageContext.registerListener(this.aoM);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.ako = tbPageContext;
        tbPageContext.registerListener(this.aoM);
        a(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aoJ = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.aoM);
            this.aoM.setTag(this.aoJ);
            MessageManager.getInstance().registerListener(this.aoM);
        }
    }

    public void a(b bVar) {
        this.aoG = bVar;
        if (this.aoG != null) {
            this.aoG.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aoF = aVar;
        if (this.aoG != null && this.aoF != null) {
            this.aoG.aQ(aVar.getIsLike());
            this.aoG.dt(aVar.getFansNum());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aoK == null || !this.aoK.s(view)) {
            if (!i.gV()) {
                this.ako.showToast(d.l.network_ungeilivable);
            }
            if (this.aoG != null) {
                this.aoG.C(view);
            }
            if (aw.aN(this.ako.getPageActivity()) && this.aoF != null) {
                if (this.aoJ == null) {
                    this.aoH.a(this.aoF.getIsLike() ? false : true, this.aoF.getPortrait(), this.aoF.getUserId(), this.aoF.isGod(), this.ako.getUniqueId());
                } else {
                    this.aoH.a(this.aoF.getIsLike() ? false : true, this.aoF.getPortrait(), this.aoF.getUserId(), this.aoF.isGod(), this.aoJ);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aoL = aVar;
    }
}
