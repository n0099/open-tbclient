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
    protected com.baidu.tbadk.core.view.userLike.a aqa;
    private b aqb;
    private BdUniqueId aqe;
    private com.baidu.tbadk.e.a aqf;
    private a aqg;
    private TbPageContext oW;
    private String aqd = "0";
    private CustomMessageListener aqh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aqa != null && !StringUtils.isNull(c.this.aqa.getUserId()) && data != null && c.this.aqa.getUserId().equals(data.toUid)) {
                    if (!data.Ec) {
                        c.this.oW.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    int fansNum = c.this.aqa.getFansNum();
                    if (data.isAttention && !c.this.aqa.getIsLike()) {
                        fansNum++;
                    } else if (!data.isAttention && c.this.aqa.getIsLike()) {
                        fansNum--;
                    }
                    c.this.aqa.setIsLike(data.isAttention);
                    c.this.aqa.setIsFromNetWork(false);
                    c.this.aqa.setFansNum(fansNum);
                    if (c.this.aqb != null) {
                        c.this.aqb.dv(fansNum);
                        if (updateAttentionMessage.getOrginalMessage() != null && c.this.aqe != null && updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aqe) && c.this.aqg != null) {
                            c.this.aqg.aR(data.isAttention);
                        }
                        c.this.aqb.aQ(data.isAttention);
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.c.a aqc = new com.baidu.tbadk.coreExtra.c.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void aR(boolean z);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.aqf = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.oW = tbPageContext;
        tbPageContext.registerListener(this.aqh);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.oW = tbPageContext;
        tbPageContext.registerListener(this.aqh);
        a(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aqe = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.aqh);
            this.aqh.setTag(this.aqe);
            MessageManager.getInstance().registerListener(this.aqh);
        }
    }

    public void a(b bVar) {
        this.aqb = bVar;
        if (this.aqb != null) {
            this.aqb.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aqa = aVar;
        if (this.aqb != null && this.aqa != null) {
            this.aqb.aQ(aVar.getIsLike());
            this.aqb.dv(aVar.getFansNum());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aqf == null || !this.aqf.s(view)) {
            if (!i.hf()) {
                this.oW.showToast(d.l.network_ungeilivable);
            }
            if (this.aqb != null) {
                this.aqb.C(view);
            }
            if (aw.aO(this.oW.getPageActivity()) && this.aqa != null) {
                if (this.aqe == null) {
                    this.aqc.a(this.aqa.getIsLike() ? false : true, this.aqa.getPortrait(), this.aqa.getUserId(), this.aqa.isGod(), this.oW.getUniqueId());
                } else {
                    this.aqc.a(this.aqa.getIsLike() ? false : true, this.aqa.getPortrait(), this.aqa.getUserId(), this.aqa.isGod(), this.aqe);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aqg = aVar;
    }
}
