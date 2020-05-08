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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    protected com.baidu.tbadk.core.view.userLike.a dKC;
    private b dKD;
    private BdUniqueId dKE;
    private d dKF;
    private a dKG;
    private com.baidu.tbadk.coreExtra.model.a dzH;
    private TbPageContext mPageContext;
    private String aQl = "0";
    private CustomMessageListener dzL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.dKC != null && !StringUtils.isNull(c.this.dKC.getUserId()) && data != null && c.this.dKC.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.dKE == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.dKE)) ? false : true;
                    if (data.dOt != null) {
                        String str = data.dOt.appeal_msg;
                        if (data.dOt.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aMX();
                        if (c.this.dKD != null) {
                            if (z) {
                                c.this.dKD.a(c.this.dKC.getIsLike(), c.this.dKC.getLikeStatus(), z);
                            } else {
                                c.this.dKD.n(c.this.dKC.getIsLike(), c.this.dKC.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.dKC.getFansNum();
                        boolean z2 = c.this.dKC.getIsLike() || c.this.dKC.getLikeStatus() == 1 || c.this.dKC.getLikeStatus() == 2;
                        if (data.isAttention && !z2) {
                            i = fansNum + 1;
                        } else if (data.isAttention || !z2) {
                            i = fansNum;
                        } else {
                            i = fansNum - 1;
                            c.this.mPageContext.showToast(R.string.un_attention_success);
                        }
                        c.this.dKC.setLikeStatus(data.status);
                        c.this.dKC.setIsLike(data.isAttention);
                        c.this.dKC.setIsFromNetWork(false);
                        c.this.dKC.setFansNum(i);
                        if (c.this.dKD != null) {
                            c.this.dKD.lL(i);
                            if (z) {
                                if (c.this.dKG != null) {
                                    c.this.dKG.gU(data.isAttention);
                                }
                                c.this.dKD.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.dKD.n(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void gU(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.dzH = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.dKE = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.dzL);
        a(bVar);
    }

    public void tU(String str) {
        this.aQl = str;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dKE = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.dzL);
            this.dzL.setTag(this.dKE);
            MessageManager.getInstance().registerListener(this.dzL);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.dzL);
        }
    }

    public void a(b bVar) {
        this.dKD = bVar;
        if (this.dKD != null) {
            this.dKD.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.dKC = aVar;
        if (this.dKD != null && this.dKC != null) {
            this.dKD.n(aVar.getIsLike(), aVar.getLikeStatus());
            this.dKD.lL(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a aQT() {
        return this.dKC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (this.dKF == null || !this.dKF.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.dKD != null) {
                this.dKD.bb(view);
            }
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.dKC != null) {
                z = (this.dKC.getIsLike() || this.dKC.getLikeStatus() == 1 || this.dKC.getLikeStatus() == 2) ? false : false;
                if (this.dKE == null) {
                    this.dzH.a(z, this.dKC.getPortrait(), this.dKC.getUserId(), this.dKC.isGod(), this.aQl, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.dzH.a(z, this.dKC.getPortrait(), this.dKC.getUserId(), this.dKC.isGod(), this.aQl, this.dKE, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.dKG = aVar;
    }
}
