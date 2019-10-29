package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a cjV;
    protected com.baidu.tbadk.core.view.userLike.a csN;
    private b csO;
    private BdUniqueId csP;
    private d csQ;
    private a csR;
    private TbPageContext mPageContext;
    private String ajL = "0";
    private CustomMessageListener cjZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.csN != null && !StringUtils.isNull(c.this.csN.getUserId()) && data != null && c.this.csN.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.csP == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.csP)) ? false : true;
                    if (data.cwD == null) {
                        if (!data.isSucc) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).akT();
                            if (c.this.csO != null) {
                                if (z) {
                                    c.this.csO.d(c.this.csN.getIsLike(), c.this.csN.getLikeStatus(), z);
                                    return;
                                } else {
                                    c.this.csO.g(c.this.csN.getIsLike(), c.this.csN.getLikeStatus());
                                    return;
                                }
                            }
                            return;
                        }
                        int fansNum = c.this.csN.getFansNum();
                        if (data.isAttention && !c.this.csN.getIsLike()) {
                            fansNum++;
                        } else if (!data.isAttention && c.this.csN.getIsLike()) {
                            fansNum--;
                        }
                        c.this.csN.setLikeStatus(data.status);
                        c.this.csN.setIsLike(data.isAttention);
                        c.this.csN.setIsFromNetWork(false);
                        c.this.csN.setFansNum(fansNum);
                        if (c.this.csO != null) {
                            c.this.csO.iU(fansNum);
                            if (z) {
                                if (c.this.csR != null) {
                                    c.this.csR.ex(data.isAttention);
                                }
                                c.this.csO.d(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.csO.g(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ex(boolean z);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cjV = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.csP = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.cjZ);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.cjV = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.csP = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.cjZ);
        a(bVar);
    }

    public void mX(String str) {
        this.ajL = str;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.csP = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.cjZ);
            this.cjZ.setTag(this.csP);
            MessageManager.getInstance().registerListener(this.cjZ);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.cjZ);
        }
    }

    public void a(b bVar) {
        this.csO = bVar;
        if (this.csO != null) {
            this.csO.f(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.csN = aVar;
        if (this.csO != null && this.csN != null) {
            this.csO.g(aVar.getIsLike(), aVar.getLikeStatus());
            this.csO.iU(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a aok() {
        return this.csN;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.csQ == null || !this.csQ.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.network_ungeilivable);
            }
            if (this.csO != null) {
                this.csO.aZ(view);
            }
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.csN != null) {
                if (this.csP == null) {
                    this.cjV.a(this.csN.getIsLike() ? false : true, this.csN.getPortrait(), this.csN.getUserId(), this.csN.isGod(), this.ajL, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.cjV.a(this.csN.getIsLike() ? false : true, this.csN.getPortrait(), this.csN.getUserId(), this.csN.isGod(), this.ajL, this.csP, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.csR = aVar;
    }
}
