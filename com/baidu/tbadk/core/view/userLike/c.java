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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a ekD;
    protected com.baidu.tbadk.core.view.userLike.a exY;
    private b exZ;
    private BdUniqueId eya;
    private boolean eyb;
    private d eyc;
    private a eyd;
    private TbPageContext mPageContext;
    private String bev = "0";
    private CustomMessageListener ekH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.exY != null && !StringUtils.isNull(c.this.exY.getUserId()) && data != null && c.this.exY.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.eya == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.eya)) ? false : true;
                    if (data.eCa != null) {
                        String str = data.eCa.appeal_msg;
                        if (data.eCa.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bhm();
                        if (c.this.exZ != null) {
                            if (z) {
                                c.this.exZ.a(c.this.exY.getIsLike(), c.this.exY.getLikeStatus(), z);
                            } else {
                                c.this.exZ.r(c.this.exY.getIsLike(), c.this.exY.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.exY.getFansNum();
                        boolean isLike = c.this.exY.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            if (!c.this.eyb) {
                                c.this.mPageContext.showToast(R.string.un_attention_success);
                            }
                        }
                        c.this.exY.setLikeStatus(data.status);
                        c.this.exY.setIsLike(data.isAttention);
                        c.this.exY.setIsFromNetWork(false);
                        c.this.exY.setFansNum(fansNum);
                        if (c.this.exZ != null) {
                            c.this.exZ.pk(fansNum);
                            if (z) {
                                if (c.this.eyd != null) {
                                    c.this.eyd.iD(data.isAttention);
                                }
                                c.this.exZ.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.exZ.r(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void iD(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.ekD = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.eya = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.ekH);
        a(bVar);
    }

    public void zl(String str) {
        this.bev = str;
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eya = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.ekH);
            this.ekH.setTag(this.eya);
            MessageManager.getInstance().registerListener(this.ekH);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.ekH);
        }
    }

    public void a(b bVar) {
        this.exZ = bVar;
        if (this.exZ != null) {
            this.exZ.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.exY = aVar;
        if (this.exZ != null && this.exY != null) {
            this.exZ.r(aVar.getIsLike(), aVar.getLikeStatus());
            this.exZ.pk(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a blL() {
        return this.exY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eyc == null || !this.eyc.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.exZ != null) {
                this.exZ.bk(view);
            }
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.exY != null) {
                boolean z = !this.exY.getIsLike();
                if (this.eya == null) {
                    this.ekD.a(z, this.exY.getPortrait(), this.exY.getUserId(), this.exY.isGod(), this.bev, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.ekD.a(z, this.exY.getPortrait(), this.exY.getUserId(), this.exY.isGod(), this.bev, this.eya, null, "0");
                }
            }
        }
    }

    public void iC(boolean z) {
        this.eyb = z;
        this.ekD.iC(z);
    }

    public void a(a aVar) {
        this.eyd = aVar;
    }
}
