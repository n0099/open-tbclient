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
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a ekH;
    protected com.baidu.tbadk.core.view.userLike.a eyc;
    private b eyd;
    private BdUniqueId eyf;
    private boolean eyg;
    private d eyh;
    private a eyi;
    private TbPageContext mPageContext;
    private String bex = "0";
    private CustomMessageListener ekL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.eyc != null && !StringUtils.isNull(c.this.eyc.getUserId()) && data != null && c.this.eyc.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.eyf == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.eyf)) ? false : true;
                    if (data.eCe != null) {
                        String str = data.eCe.appeal_msg;
                        if (data.eCe.appeal_status == 1) {
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
                        if (c.this.eyd != null) {
                            if (z) {
                                c.this.eyd.a(c.this.eyc.getIsLike(), c.this.eyc.getLikeStatus(), z);
                            } else {
                                c.this.eyd.r(c.this.eyc.getIsLike(), c.this.eyc.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.eyc.getFansNum();
                        boolean isLike = c.this.eyc.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            if (!c.this.eyg) {
                                c.this.mPageContext.showToast(R.string.un_attention_success);
                            }
                        }
                        c.this.eyc.setLikeStatus(data.status);
                        c.this.eyc.setIsLike(data.isAttention);
                        c.this.eyc.setIsFromNetWork(false);
                        c.this.eyc.setFansNum(fansNum);
                        if (c.this.eyd != null) {
                            c.this.eyd.pk(fansNum);
                            if (z) {
                                if (c.this.eyi != null) {
                                    c.this.eyi.iE(data.isAttention);
                                }
                                c.this.eyd.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.eyd.r(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void iE(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.ekH = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.eyf = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.ekL);
        a(bVar);
    }

    public void zm(String str) {
        this.bex = str;
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eyf = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.ekL);
            this.ekL.setTag(this.eyf);
            MessageManager.getInstance().registerListener(this.ekL);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.ekL);
        }
    }

    public void a(b bVar) {
        this.eyd = bVar;
        if (this.eyd != null) {
            this.eyd.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.eyc = aVar;
        if (this.eyd != null && this.eyc != null) {
            this.eyd.r(aVar.getIsLike(), aVar.getLikeStatus());
            this.eyd.pk(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a blL() {
        return this.eyc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eyh == null || !this.eyh.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.eyd != null) {
                this.eyd.bk(view);
            }
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.eyc != null) {
                boolean z = !this.eyc.getIsLike();
                if (this.eyf == null) {
                    this.ekH.a(z, this.eyc.getPortrait(), this.eyc.getUserId(), this.eyc.isGod(), this.bex, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.ekH.a(z, this.eyc.getPortrait(), this.eyc.getUserId(), this.eyc.isGod(), this.bex, this.eyf, null, "0");
                }
            }
        }
    }

    public void iD(boolean z) {
        this.eyg = z;
        this.ekH.iD(z);
    }

    public void a(a aVar) {
        this.eyi = aVar;
    }
}
