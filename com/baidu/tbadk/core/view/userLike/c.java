package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    protected com.baidu.tbadk.core.view.userLike.a aoN;
    private b aoO;
    private BdUniqueId aoQ;
    private com.baidu.tbadk.d.a aoR;
    private a aoS;
    private TbPageContext mG;
    private String mFromType = "0";
    private CustomMessageListener aoT = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aoN != null && !StringUtils.isNull(c.this.aoN.getUserId()) && data != null && c.this.aoN.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.aoQ == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aoQ)) ? false : true;
                    if (data.arE == null) {
                        if (!data.BY) {
                            c.this.mG.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.aoO != null) {
                                if (z) {
                                    c.this.aoO.i(c.this.aoN.getIsLike(), z);
                                    return;
                                } else {
                                    c.this.aoO.aP(c.this.aoN.getIsLike());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.aoN.getFansNum();
                        if (data.isAttention && !c.this.aoN.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.aoN.getIsLike()) {
                            fansNum--;
                        }
                        c.this.aoN.setIsLike(data.isAttention);
                        c.this.aoN.setIsFromNetWork(false);
                        c.this.aoN.setFansNum(fansNum);
                        if (c.this.aoO != null) {
                            c.this.aoO.dG(fansNum);
                            if (z) {
                                if (c.this.aoS != null) {
                                    c.this.aoS.aQ(data.isAttention);
                                }
                                c.this.aoO.i(data.isAttention, true);
                                return;
                            }
                            c.this.aoO.aP(data.isAttention);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.c.a aoP = new com.baidu.tbadk.coreExtra.c.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void aQ(boolean z);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aoR = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.mG = tbPageContext;
        this.aoQ = this.mG.getUniqueId();
        tbPageContext.registerListener(this.aoT);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mG = tbPageContext;
        this.aoQ = this.mG.getUniqueId();
        tbPageContext.registerListener(this.aoT);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aoQ = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.aoT);
            this.aoT.setTag(this.aoQ);
            MessageManager.getInstance().registerListener(this.aoT);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.aoT);
        }
    }

    public void a(b bVar) {
        this.aoO = bVar;
        if (this.aoO != null) {
            this.aoO.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aoN = aVar;
        if (this.aoO != null && this.aoN != null) {
            this.aoO.aP(aVar.getIsLike());
            this.aoO.dG(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a wR() {
        return this.aoN;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aoR == null || !this.aoR.s(view)) {
            if (!j.gV()) {
                this.mG.showToast(d.l.network_ungeilivable);
            }
            if (this.aoO != null) {
                this.aoO.I(view);
            }
            if (ax.aU(this.mG.getPageActivity()) && this.aoN != null) {
                if (this.aoQ == null) {
                    this.aoP.a(this.aoN.getIsLike() ? false : true, this.aoN.getPortrait(), this.aoN.getUserId(), this.aoN.isGod(), this.mFromType, this.mG.getUniqueId(), null, "0");
                } else {
                    this.aoP.a(this.aoN.getIsLike() ? false : true, this.aoN.getPortrait(), this.aoN.getUserId(), this.aoN.isGod(), this.mFromType, this.aoQ, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.aoS = aVar;
    }
}
