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
    private com.baidu.tbadk.coreExtra.model.a daa;
    protected com.baidu.tbadk.core.view.userLike.a dkd;
    private b dke;
    private BdUniqueId dkf;
    private d dkg;
    private a dkh;
    private TbPageContext mPageContext;
    private String awq = "0";
    private CustomMessageListener dae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.dkd != null && !StringUtils.isNull(c.this.dkd.getUserId()) && data != null && c.this.dkd.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.dkf == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.dkf)) ? false : true;
                    if (data.dnT != null) {
                        String str = data.dnT.appeal_msg;
                        if (data.dnT.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEF();
                        if (c.this.dke != null) {
                            if (z) {
                                c.this.dke.b(c.this.dkd.getIsLike(), c.this.dkd.getLikeStatus(), z);
                            } else {
                                c.this.dke.m(c.this.dkd.getIsLike(), c.this.dkd.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.dkd.getFansNum();
                        if (data.isAttention && !c.this.dkd.getIsLike()) {
                            fansNum++;
                            c.this.mPageContext.showToast(R.string.attention_success);
                        } else if (!data.isAttention && c.this.dkd.getIsLike()) {
                            fansNum--;
                            c.this.mPageContext.showToast(R.string.un_attention_success);
                        }
                        c.this.dkd.setLikeStatus(data.status);
                        c.this.dkd.setIsLike(data.isAttention);
                        c.this.dkd.setIsFromNetWork(false);
                        c.this.dkd.setFansNum(fansNum);
                        if (c.this.dke != null) {
                            c.this.dke.lx(fansNum);
                            if (z) {
                                if (c.this.dkh != null) {
                                    c.this.dkh.fV(data.isAttention);
                                }
                                c.this.dke.b(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.dke.m(data.isAttention, data.status);
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
        this.daa = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.dkf = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.dae);
        a(bVar);
    }

    public void sE(String str) {
        this.awq = str;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dkf = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.dae);
            this.dae.setTag(this.dkf);
            MessageManager.getInstance().registerListener(this.dae);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.dae);
        }
    }

    public void a(b bVar) {
        this.dke = bVar;
        if (this.dke != null) {
            this.dke.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.dkd = aVar;
        if (this.dke != null && this.dkd != null) {
            this.dke.m(aVar.getIsLike(), aVar.getLikeStatus());
            this.dke.lx(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a aIt() {
        return this.dkd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dkg == null || !this.dkg.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.dke != null) {
                this.dke.ba(view);
            }
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.dkd != null) {
                if (this.dkf == null) {
                    this.daa.a(this.dkd.getIsLike() ? false : true, this.dkd.getPortrait(), this.dkd.getUserId(), this.dkd.isGod(), this.awq, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.daa.a(this.dkd.getIsLike() ? false : true, this.dkd.getPortrait(), this.dkd.getUserId(), this.dkd.isGod(), this.awq, this.dkf, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.dkh = aVar;
    }
}
