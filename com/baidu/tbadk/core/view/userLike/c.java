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
    protected com.baidu.tbadk.core.view.userLike.a eMp;
    private b eMq;
    private BdUniqueId eMr;
    private boolean eMs;
    private d eMt;
    private a eMu;
    private com.baidu.tbadk.coreExtra.model.a ezg;
    private TbPageContext mPageContext;
    private String blg = "0";
    private CustomMessageListener ezk = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.eMp != null && !StringUtils.isNull(c.this.eMp.getUserId()) && data != null && c.this.eMp.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.eMr == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.eMr)) ? false : true;
                    if (data.eQq != null) {
                        String str = data.eQq.appeal_msg;
                        if (data.eQq.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bkP();
                        if (c.this.eMq != null) {
                            if (z) {
                                c.this.eMq.a(c.this.eMp.getIsLike(), c.this.eMp.getLikeStatus(), z);
                            } else {
                                c.this.eMq.s(c.this.eMp.getIsLike(), c.this.eMp.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.eMp.getFansNum();
                        boolean isLike = c.this.eMp.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            if (!c.this.eMs) {
                                c.this.mPageContext.showToast(R.string.un_attention_success);
                            }
                        }
                        c.this.eMp.setLikeStatus(data.status);
                        c.this.eMp.setIsLike(data.isAttention);
                        c.this.eMp.setIsFromNetWork(false);
                        c.this.eMp.setFansNum(fansNum);
                        if (c.this.eMq != null) {
                            c.this.eMq.pW(fansNum);
                            if (z) {
                                if (c.this.eMu != null) {
                                    c.this.eMu.iZ(data.isAttention);
                                }
                                c.this.eMq.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.eMq.s(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void iZ(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.ezg = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.eMr = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.ezk);
        a(bVar);
    }

    public void At(String str) {
        this.blg = str;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eMr = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.ezk);
            this.ezk.setTag(this.eMr);
            MessageManager.getInstance().registerListener(this.ezk);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.ezk);
        }
    }

    public void a(b bVar) {
        this.eMq = bVar;
        if (this.eMq != null) {
            this.eMq.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.eMp = aVar;
        if (this.eMq != null && this.eMp != null) {
            this.eMq.s(aVar.getIsLike(), aVar.getLikeStatus());
            this.eMq.pW(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a bpp() {
        return this.eMp;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eMt == null || !this.eMt.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.eMq != null) {
                this.eMq.bq(view);
            }
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.eMp != null) {
                boolean z = !this.eMp.getIsLike();
                if (this.eMr == null) {
                    this.ezg.a(z, this.eMp.getPortrait(), this.eMp.getUserId(), this.eMp.isGod(), this.blg, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.ezg.a(z, this.eMp.getPortrait(), this.eMp.getUserId(), this.eMp.isGod(), this.blg, this.eMr, null, "0");
                }
            }
        }
    }

    public void iY(boolean z) {
        this.eMs = z;
        this.ezg.iY(z);
    }

    public void a(a aVar) {
        this.eMu = aVar;
    }
}
