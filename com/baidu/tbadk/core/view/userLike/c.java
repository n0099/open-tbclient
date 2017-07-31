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
    private TbPageContext alI;
    protected com.baidu.tbadk.core.view.userLike.a apZ;
    private b aqa;
    private BdUniqueId aqd;
    private com.baidu.tbadk.e.a aqe;
    private a aqf;
    private String aqc = "0";
    private CustomMessageListener aqg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.apZ != null && !StringUtils.isNull(c.this.apZ.getUserId()) && data != null && c.this.apZ.getUserId().equals(data.toUid)) {
                    if (!data.Ea) {
                        c.this.alI.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    int fansNum = c.this.apZ.getFansNum();
                    if (data.isAttention && !c.this.apZ.getIsLike()) {
                        fansNum++;
                    } else if (!data.isAttention && c.this.apZ.getIsLike()) {
                        fansNum--;
                    }
                    c.this.apZ.setIsLike(data.isAttention);
                    c.this.apZ.setIsFromNetWork(false);
                    c.this.apZ.setFansNum(fansNum);
                    if (c.this.aqa != null) {
                        c.this.aqa.dv(fansNum);
                        if (updateAttentionMessage.getOrginalMessage() != null && c.this.aqd != null && updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aqd) && c.this.aqf != null) {
                            c.this.aqf.aR(data.isAttention);
                        }
                        c.this.aqa.aQ(data.isAttention);
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.c.a aqb = new com.baidu.tbadk.coreExtra.c.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void aR(boolean z);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.aqe = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.alI = tbPageContext;
        tbPageContext.registerListener(this.aqg);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.alI = tbPageContext;
        tbPageContext.registerListener(this.aqg);
        a(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aqd = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.aqg);
            this.aqg.setTag(this.aqd);
            MessageManager.getInstance().registerListener(this.aqg);
        }
    }

    public void a(b bVar) {
        this.aqa = bVar;
        if (this.aqa != null) {
            this.aqa.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.apZ = aVar;
        if (this.aqa != null && this.apZ != null) {
            this.aqa.aQ(aVar.getIsLike());
            this.aqa.dv(aVar.getFansNum());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aqe == null || !this.aqe.s(view)) {
            if (!i.hf()) {
                this.alI.showToast(d.l.network_ungeilivable);
            }
            if (this.aqa != null) {
                this.aqa.C(view);
            }
            if (aw.aO(this.alI.getPageActivity()) && this.apZ != null) {
                if (this.aqd == null) {
                    this.aqb.a(this.apZ.getIsLike() ? false : true, this.apZ.getPortrait(), this.apZ.getUserId(), this.apZ.isGod(), this.alI.getUniqueId());
                } else {
                    this.aqb.a(this.apZ.getIsLike() ? false : true, this.apZ.getPortrait(), this.apZ.getUserId(), this.apZ.isGod(), this.aqd);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aqf = aVar;
    }
}
