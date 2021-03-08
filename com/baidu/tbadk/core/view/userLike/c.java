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
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a fce;
    protected com.baidu.tbadk.core.view.userLike.a fpY;
    private b fpZ;
    private BdUniqueId fqa;
    private boolean fqb;
    private d fqc;
    private a fqd;
    private TbPageContext mPageContext;
    private String bwo = "0";
    private CustomMessageListener fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.fpY != null && !StringUtils.isNull(c.this.fpY.getUserId()) && data != null && c.this.fpY.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.fqa == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.fqa)) ? false : true;
                    if (data.fud != null) {
                        String str = data.fud.appeal_msg;
                        if (data.fud.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqF();
                        if (c.this.fpZ != null) {
                            if (z) {
                                c.this.fpZ.b(c.this.fpY.getIsLike(), c.this.fpY.getLikeStatus(), z);
                            } else {
                                c.this.fpZ.r(c.this.fpY.getIsLike(), c.this.fpY.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.fpY.getFansNum();
                        boolean isLike = c.this.fpY.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            if (!c.this.fqb) {
                                c.this.mPageContext.showToast(R.string.un_attention_success);
                            }
                        }
                        c.this.fpY.setLikeStatus(data.status);
                        c.this.fpY.setIsLike(data.isAttention);
                        c.this.fpY.setIsFromNetWork(false);
                        c.this.fpY.setFansNum(fansNum);
                        if (c.this.fpZ != null) {
                            c.this.fpZ.qc(fansNum);
                            if (z) {
                                if (c.this.fqd != null) {
                                    c.this.fqd.kh(data.isAttention);
                                }
                                c.this.fpZ.b(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.fpZ.r(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void kh(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.fce = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.fqa = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.fci);
        a(bVar);
    }

    public void An(String str) {
        this.bwo = str;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fqa = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.fci);
            this.fci.setTag(this.fqa);
            MessageManager.getInstance().registerListener(this.fci);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.fci);
        }
    }

    public void a(b bVar) {
        this.fpZ = bVar;
        if (this.fpZ != null) {
            this.fpZ.i(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.fpY = aVar;
        if (this.fpZ != null && this.fpY != null) {
            this.fpZ.r(aVar.getIsLike(), aVar.getLikeStatus());
            this.fpZ.qc(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a bvv() {
        return this.fpY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fqc == null || !this.fqc.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.fpZ != null) {
                this.fpZ.bG(view);
            }
            if (bh.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.fpY != null) {
                boolean z = !this.fpY.getIsLike();
                if (this.fqa == null) {
                    this.fce.a(z, this.fpY.getPortrait(), this.fpY.getUserId(), this.fpY.isGod(), this.bwo, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.fce.a(z, this.fpY.getPortrait(), this.fpY.getUserId(), this.fpY.isGod(), this.bwo, this.fqa, null, "0");
                }
            }
        }
    }

    public void kg(boolean z) {
        this.fqb = z;
        this.fce.kg(z);
    }

    public void a(a aVar) {
        this.fqd = aVar;
    }
}
