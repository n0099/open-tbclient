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
    protected com.baidu.tbadk.core.view.userLike.a aoB;
    private b aoC;
    private BdUniqueId aoE;
    private com.baidu.tbadk.d.a aoF;
    private a aoG;
    private TbPageContext mH;
    private String mFromType = "0";
    private CustomMessageListener aoH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.aoB != null && !StringUtils.isNull(c.this.aoB.getUserId()) && data != null && c.this.aoB.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.aoE == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.aoE)) ? false : true;
                    if (data.ars == null) {
                        if (!data.BZ) {
                            c.this.mH.showToast(updateAttentionMessage.getData().errorString);
                            if (c.this.aoC != null) {
                                if (z) {
                                    c.this.aoC.i(c.this.aoB.getIsLike(), z);
                                    return;
                                } else {
                                    c.this.aoC.aO(c.this.aoB.getIsLike());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.aoB.getFansNum();
                        if (data.isAttention && !c.this.aoB.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.aoB.getIsLike()) {
                            fansNum--;
                        }
                        c.this.aoB.setIsLike(data.isAttention);
                        c.this.aoB.setIsFromNetWork(false);
                        c.this.aoB.setFansNum(fansNum);
                        if (c.this.aoC != null) {
                            c.this.aoC.dF(fansNum);
                            if (z) {
                                if (c.this.aoG != null) {
                                    c.this.aoG.aP(data.isAttention);
                                }
                                c.this.aoC.i(data.isAttention, true);
                                return;
                            }
                            c.this.aoC.aO(data.isAttention);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.c.a aoD = new com.baidu.tbadk.coreExtra.c.a(null);

    /* loaded from: classes.dex */
    public interface a {
        void aP(boolean z);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aoF = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.mH = tbPageContext;
        this.aoE = this.mH.getUniqueId();
        tbPageContext.registerListener(this.aoH);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mH = tbPageContext;
        this.aoE = this.mH.getUniqueId();
        tbPageContext.registerListener(this.aoH);
        a(bVar);
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aoE = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.aoH);
            this.aoH.setTag(this.aoE);
            MessageManager.getInstance().registerListener(this.aoH);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.aoH);
        }
    }

    public void a(b bVar) {
        this.aoC = bVar;
        if (this.aoC != null) {
            this.aoC.c(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.aoB = aVar;
        if (this.aoC != null && this.aoB != null) {
            this.aoC.aO(aVar.getIsLike());
            this.aoC.dF(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a wK() {
        return this.aoB;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aoF == null || !this.aoF.s(view)) {
            if (!j.gV()) {
                this.mH.showToast(d.l.network_ungeilivable);
            }
            if (this.aoC != null) {
                this.aoC.I(view);
            }
            if (ax.aT(this.mH.getPageActivity()) && this.aoB != null) {
                if (this.aoE == null) {
                    this.aoD.a(this.aoB.getIsLike() ? false : true, this.aoB.getPortrait(), this.aoB.getUserId(), this.aoB.isGod(), this.mFromType, this.mH.getUniqueId(), null, "0");
                } else {
                    this.aoD.a(this.aoB.getIsLike() ? false : true, this.aoB.getPortrait(), this.aoB.getUserId(), this.aoB.isGod(), this.mFromType, this.aoE, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.aoG = aVar;
    }
}
