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
    private BdUniqueId dKA;
    private d dKB;
    private a dKC;
    protected com.baidu.tbadk.core.view.userLike.a dKy;
    private b dKz;
    private com.baidu.tbadk.coreExtra.model.a dzD;
    private TbPageContext mPageContext;
    private String aQf = "0";
    private CustomMessageListener dzH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.dKy != null && !StringUtils.isNull(c.this.dKy.getUserId()) && data != null && c.this.dKy.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.dKA == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.dKA)) ? false : true;
                    if (data.dOo != null) {
                        String str = data.dOo.appeal_msg;
                        if (data.dOo.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aMZ();
                        if (c.this.dKz != null) {
                            if (z) {
                                c.this.dKz.a(c.this.dKy.getIsLike(), c.this.dKy.getLikeStatus(), z);
                            } else {
                                c.this.dKz.n(c.this.dKy.getIsLike(), c.this.dKy.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.dKy.getFansNum();
                        boolean z2 = c.this.dKy.getIsLike() || c.this.dKy.getLikeStatus() == 1 || c.this.dKy.getLikeStatus() == 2;
                        if (data.isAttention && !z2) {
                            i = fansNum + 1;
                        } else if (data.isAttention || !z2) {
                            i = fansNum;
                        } else {
                            i = fansNum - 1;
                            c.this.mPageContext.showToast(R.string.un_attention_success);
                        }
                        c.this.dKy.setLikeStatus(data.status);
                        c.this.dKy.setIsLike(data.isAttention);
                        c.this.dKy.setIsFromNetWork(false);
                        c.this.dKy.setFansNum(i);
                        if (c.this.dKz != null) {
                            c.this.dKz.lL(i);
                            if (z) {
                                if (c.this.dKC != null) {
                                    c.this.dKC.gU(data.isAttention);
                                }
                                c.this.dKz.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.dKz.n(data.isAttention, data.status);
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
        this.dzD = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.dKA = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.dzH);
        a(bVar);
    }

    public void tR(String str) {
        this.aQf = str;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dKA = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.dzH);
            this.dzH.setTag(this.dKA);
            MessageManager.getInstance().registerListener(this.dzH);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.dzH);
        }
    }

    public void a(b bVar) {
        this.dKz = bVar;
        if (this.dKz != null) {
            this.dKz.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.dKy = aVar;
        if (this.dKz != null && this.dKy != null) {
            this.dKz.n(aVar.getIsLike(), aVar.getLikeStatus());
            this.dKz.lL(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a aQW() {
        return this.dKy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (this.dKB == null || !this.dKB.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.dKz != null) {
                this.dKz.bb(view);
            }
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.dKy != null) {
                z = (this.dKy.getIsLike() || this.dKy.getLikeStatus() == 1 || this.dKy.getLikeStatus() == 2) ? false : false;
                if (this.dKA == null) {
                    this.dzD.a(z, this.dKy.getPortrait(), this.dKy.getUserId(), this.dKy.isGod(), this.aQf, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.dzD.a(z, this.dKy.getPortrait(), this.dKy.getUserId(), this.dKy.isGod(), this.aQf, this.dKA, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.dKC = aVar;
    }
}
