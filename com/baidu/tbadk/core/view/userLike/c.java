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
    private com.baidu.tbadk.coreExtra.model.a dac;
    protected com.baidu.tbadk.core.view.userLike.a dkr;
    private b dks;
    private BdUniqueId dkt;
    private d dku;
    private a dkv;
    private TbPageContext mPageContext;
    private String aws = "0";
    private CustomMessageListener dag = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.dkr != null && !StringUtils.isNull(c.this.dkr.getUserId()) && data != null && c.this.dkr.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.dkt == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.dkt)) ? false : true;
                    if (data.doi != null) {
                        String str = data.doi.appeal_msg;
                        if (data.doi.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEH();
                        if (c.this.dks != null) {
                            if (z) {
                                c.this.dks.b(c.this.dkr.getIsLike(), c.this.dkr.getLikeStatus(), z);
                            } else {
                                c.this.dks.m(c.this.dkr.getIsLike(), c.this.dkr.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.dkr.getFansNum();
                        if (data.isAttention && !c.this.dkr.getIsLike()) {
                            fansNum++;
                            c.this.mPageContext.showToast(R.string.attention_success);
                        } else if (!data.isAttention && c.this.dkr.getIsLike()) {
                            fansNum--;
                            c.this.mPageContext.showToast(R.string.un_attention_success);
                        }
                        c.this.dkr.setLikeStatus(data.status);
                        c.this.dkr.setIsLike(data.isAttention);
                        c.this.dkr.setIsFromNetWork(false);
                        c.this.dkr.setFansNum(fansNum);
                        if (c.this.dks != null) {
                            c.this.dks.lx(fansNum);
                            if (z) {
                                if (c.this.dkv != null) {
                                    c.this.dkv.fV(data.isAttention);
                                }
                                c.this.dks.b(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.dks.m(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void fV(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.dac = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.dkt = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.dag);
        a(bVar);
    }

    public void sE(String str) {
        this.aws = str;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dkt = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.dag);
            this.dag.setTag(this.dkt);
            MessageManager.getInstance().registerListener(this.dag);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.dag);
        }
    }

    public void a(b bVar) {
        this.dks = bVar;
        if (this.dks != null) {
            this.dks.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.dkr = aVar;
        if (this.dks != null && this.dkr != null) {
            this.dks.m(aVar.getIsLike(), aVar.getLikeStatus());
            this.dks.lx(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a aIw() {
        return this.dkr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dku == null || !this.dku.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.dks != null) {
                this.dks.ba(view);
            }
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.dkr != null) {
                if (this.dkt == null) {
                    this.dac.a(this.dkr.getIsLike() ? false : true, this.dkr.getPortrait(), this.dkr.getUserId(), this.dkr.isGod(), this.aws, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.dac.a(this.dkr.getIsLike() ? false : true, this.dkr.getPortrait(), this.dkr.getUserId(), this.dkr.isGod(), this.aws, this.dkt, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.dkv = aVar;
    }
}
