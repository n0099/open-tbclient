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
    private com.baidu.tbadk.coreExtra.model.a dab;
    protected com.baidu.tbadk.core.view.userLike.a dke;
    private b dkf;
    private BdUniqueId dkg;
    private d dkh;
    private a dki;
    private TbPageContext mPageContext;
    private String awr = "0";
    private CustomMessageListener daf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.dke != null && !StringUtils.isNull(c.this.dke.getUserId()) && data != null && c.this.dke.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.dkg == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.dkg)) ? false : true;
                    if (data.dnU != null) {
                        String str = data.dnU.appeal_msg;
                        if (data.dnU.appeal_status == 1) {
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
                        if (c.this.dkf != null) {
                            if (z) {
                                c.this.dkf.b(c.this.dke.getIsLike(), c.this.dke.getLikeStatus(), z);
                            } else {
                                c.this.dkf.m(c.this.dke.getIsLike(), c.this.dke.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.dke.getFansNum();
                        if (data.isAttention && !c.this.dke.getIsLike()) {
                            fansNum++;
                            c.this.mPageContext.showToast(R.string.attention_success);
                        } else if (!data.isAttention && c.this.dke.getIsLike()) {
                            fansNum--;
                            c.this.mPageContext.showToast(R.string.un_attention_success);
                        }
                        c.this.dke.setLikeStatus(data.status);
                        c.this.dke.setIsLike(data.isAttention);
                        c.this.dke.setIsFromNetWork(false);
                        c.this.dke.setFansNum(fansNum);
                        if (c.this.dkf != null) {
                            c.this.dkf.lx(fansNum);
                            if (z) {
                                if (c.this.dki != null) {
                                    c.this.dki.fV(data.isAttention);
                                }
                                c.this.dkf.b(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.dkf.m(data.isAttention, data.status);
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
        this.dab = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.dkg = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.daf);
        a(bVar);
    }

    public void sE(String str) {
        this.awr = str;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dkg = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.daf);
            this.daf.setTag(this.dkg);
            MessageManager.getInstance().registerListener(this.daf);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.daf);
        }
    }

    public void a(b bVar) {
        this.dkf = bVar;
        if (this.dkf != null) {
            this.dkf.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.dke = aVar;
        if (this.dkf != null && this.dke != null) {
            this.dkf.m(aVar.getIsLike(), aVar.getLikeStatus());
            this.dkf.lx(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a aIv() {
        return this.dke;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dkh == null || !this.dkh.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.dkf != null) {
                this.dkf.ba(view);
            }
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.dke != null) {
                if (this.dkg == null) {
                    this.dab.a(this.dke.getIsLike() ? false : true, this.dke.getPortrait(), this.dke.getUserId(), this.dke.isGod(), this.awr, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.dab.a(this.dke.getIsLike() ? false : true, this.dke.getPortrait(), this.dke.getUserId(), this.dke.isGod(), this.awr, this.dkg, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.dki = aVar;
    }
}
