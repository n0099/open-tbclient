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
    private com.baidu.tbadk.coreExtra.model.a dap;
    protected com.baidu.tbadk.core.view.userLike.a dkE;
    private b dkF;
    private BdUniqueId dkG;
    private d dkH;
    private a dkI;
    private TbPageContext mPageContext;
    private String awC = "0";
    private CustomMessageListener dat = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.dkE != null && !StringUtils.isNull(c.this.dkE.getUserId()) && data != null && c.this.dkE.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.dkG == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.dkG)) ? false : true;
                    if (data.dow != null) {
                        String str = data.dow.appeal_msg;
                        if (data.dow.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEL();
                        if (c.this.dkF != null) {
                            if (z) {
                                c.this.dkF.b(c.this.dkE.getIsLike(), c.this.dkE.getLikeStatus(), z);
                            } else {
                                c.this.dkF.m(c.this.dkE.getIsLike(), c.this.dkE.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.dkE.getFansNum();
                        boolean z2 = c.this.dkE.getIsLike() || c.this.dkE.getLikeStatus() == 1 || c.this.dkE.getLikeStatus() == 2;
                        if (data.isAttention && !z2) {
                            i = fansNum + 1;
                            c.this.mPageContext.showToast(R.string.attention_success);
                        } else if (data.isAttention || !z2) {
                            i = fansNum;
                        } else {
                            i = fansNum - 1;
                            c.this.mPageContext.showToast(R.string.un_attention_success);
                        }
                        c.this.dkE.setLikeStatus(data.status);
                        c.this.dkE.setIsLike(data.isAttention);
                        c.this.dkE.setIsFromNetWork(false);
                        c.this.dkE.setFansNum(i);
                        if (c.this.dkF != null) {
                            c.this.dkF.lz(i);
                            if (z) {
                                if (c.this.dkI != null) {
                                    c.this.dkI.fW(data.isAttention);
                                }
                                c.this.dkF.b(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.dkF.m(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void fW(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.dap = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.dkG = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.dat);
        a(bVar);
    }

    public void sD(String str) {
        this.awC = str;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dkG = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.dat);
            this.dat.setTag(this.dkG);
            MessageManager.getInstance().registerListener(this.dat);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.dat);
        }
    }

    public void a(b bVar) {
        this.dkF = bVar;
        if (this.dkF != null) {
            this.dkF.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.dkE = aVar;
        if (this.dkF != null && this.dkE != null) {
            this.dkF.m(aVar.getIsLike(), aVar.getLikeStatus());
            this.dkF.lz(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a aIA() {
        return this.dkE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (this.dkH == null || !this.dkH.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.dkF != null) {
                this.dkF.ba(view);
            }
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.dkE != null) {
                z = (this.dkE.getIsLike() || this.dkE.getLikeStatus() == 1 || this.dkE.getLikeStatus() == 2) ? false : false;
                if (this.dkG == null) {
                    this.dap.a(z, this.dkE.getPortrait(), this.dkE.getUserId(), this.dkE.isGod(), this.awC, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.dap.a(z, this.dkE.getPortrait(), this.dkE.getUserId(), this.dkE.isGod(), this.awC, this.dkG, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.dkI = aVar;
    }
}
