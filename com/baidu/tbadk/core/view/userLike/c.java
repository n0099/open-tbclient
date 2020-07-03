package com.baidu.tbadk.core.view.userLike;

import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a dUB;
    protected com.baidu.tbadk.core.view.userLike.a ehD;
    private b ehE;
    private BdUniqueId ehF;
    private d ehG;
    private a ehH;
    private TbPageContext mPageContext;
    private String aZd = "0";
    private CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.ehD != null && !StringUtils.isNull(c.this.ehD.getUserId()) && data != null && c.this.ehD.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.ehF == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.ehF)) ? false : true;
                    if (data.els != null) {
                        String str = data.els.appeal_msg;
                        if (data.els.appeal_status == 1) {
                            if (TextUtils.isEmpty(str)) {
                                string = TbadkCoreApplication.getInst().getString(R.string.anti_account_exception_appealing);
                            }
                            string = str;
                        } else {
                            if (TextUtils.isEmpty(str)) {
                                string = TbadkCoreApplication.getInst().getString(R.string.anti_no_chance_com_tip);
                            }
                            string = str;
                        }
                        c.this.mPageContext.showToast(string);
                    } else if (!data.isSucc) {
                        String str2 = updateAttentionMessage.getData() != null ? updateAttentionMessage.getData().errorString : "";
                        if (TextUtils.isEmpty(str2)) {
                            str2 = TbadkCoreApplication.getInst().getString(R.string.operation_failed);
                        }
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aUS();
                        if (c.this.ehE != null) {
                            if (z) {
                                c.this.ehE.a(c.this.ehD.getIsLike(), c.this.ehD.getLikeStatus(), z);
                            } else {
                                c.this.ehE.r(c.this.ehD.getIsLike(), c.this.ehD.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.ehD.getFansNum();
                        boolean isLike = c.this.ehD.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            c.this.mPageContext.showToast(R.string.un_attention_success);
                        }
                        c.this.ehD.setLikeStatus(data.status);
                        c.this.ehD.setIsLike(data.isAttention);
                        c.this.ehD.setIsFromNetWork(false);
                        c.this.ehD.setFansNum(fansNum);
                        if (c.this.ehE != null) {
                            c.this.ehE.mK(fansNum);
                            if (z) {
                                if (c.this.ehH != null) {
                                    c.this.ehH.hB(data.isAttention);
                                }
                                c.this.ehE.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.ehE.r(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void hB(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.dUB = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.ehF = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.dUF);
        a(bVar);
    }

    public void vQ(String str) {
        this.aZd = str;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ehF = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.dUF);
            this.dUF.setTag(this.ehF);
            MessageManager.getInstance().registerListener(this.dUF);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.dUF);
        }
    }

    public void a(b bVar) {
        this.ehE = bVar;
        if (this.ehE != null) {
            this.ehE.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.ehD = aVar;
        if (this.ehE != null && this.ehD != null) {
            this.ehE.r(aVar.getIsLike(), aVar.getLikeStatus());
            this.ehE.mK(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a aZi() {
        return this.ehD;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ehG == null || !this.ehG.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.ehE != null) {
                this.ehE.bc(view);
            }
            if (be.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.ehD != null) {
                boolean z = !this.ehD.getIsLike();
                if (this.ehF == null) {
                    this.dUB.a(z, this.ehD.getPortrait(), this.ehD.getUserId(), this.ehD.isGod(), this.aZd, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.dUB.a(z, this.ehD.getPortrait(), this.ehD.getUserId(), this.ehD.isGod(), this.aZd, this.ehF, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.ehH = aVar;
    }
}
