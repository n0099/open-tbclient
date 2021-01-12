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
    private com.baidu.tbadk.coreExtra.model.a eYq;
    protected com.baidu.tbadk.core.view.userLike.a fmf;
    private b fmg;
    private BdUniqueId fmh;
    private boolean fmi;
    private d fmj;
    private a fmk;
    private TbPageContext mPageContext;
    private String brl = "0";
    private CustomMessageListener eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.fmf != null && !StringUtils.isNull(c.this.fmf.getUserId()) && data != null && c.this.fmf.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.fmh == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.fmh)) ? false : true;
                    if (data.fqk != null) {
                        String str = data.fqk.appeal_msg;
                        if (data.fqk.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqk();
                        if (c.this.fmg != null) {
                            if (z) {
                                c.this.fmg.c(c.this.fmf.getIsLike(), c.this.fmf.getLikeStatus(), z);
                            } else {
                                c.this.fmg.r(c.this.fmf.getIsLike(), c.this.fmf.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.fmf.getFansNum();
                        boolean isLike = c.this.fmf.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            if (!c.this.fmi) {
                                c.this.mPageContext.showToast(R.string.un_attention_success);
                            }
                        }
                        c.this.fmf.setLikeStatus(data.status);
                        c.this.fmf.setIsLike(data.isAttention);
                        c.this.fmf.setIsFromNetWork(false);
                        c.this.fmf.setFansNum(fansNum);
                        if (c.this.fmg != null) {
                            c.this.fmg.pW(fansNum);
                            if (z) {
                                if (c.this.fmk != null) {
                                    c.this.fmk.ke(data.isAttention);
                                }
                                c.this.fmg.c(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.fmg.r(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ke(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.eYq = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.fmh = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.eYu);
        a(bVar);
    }

    public void zP(String str) {
        this.brl = str;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fmh = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.eYu);
            this.eYu.setTag(this.fmh);
            MessageManager.getInstance().registerListener(this.eYu);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.eYu);
        }
    }

    public void a(b bVar) {
        this.fmg = bVar;
        if (this.fmg != null) {
            this.fmg.i(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.fmf = aVar;
        if (this.fmg != null && this.fmf != null) {
            this.fmg.r(aVar.getIsLike(), aVar.getLikeStatus());
            this.fmg.pW(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a buY() {
        return this.fmf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fmj == null || !this.fmj.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.fmg != null) {
                this.fmg.bK(view);
            }
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.fmf != null) {
                boolean z = !this.fmf.getIsLike();
                if (this.fmh == null) {
                    this.eYq.a(z, this.fmf.getPortrait(), this.fmf.getUserId(), this.fmf.isGod(), this.brl, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.eYq.a(z, this.fmf.getPortrait(), this.fmf.getUserId(), this.fmf.isGod(), this.brl, this.fmh, null, "0");
                }
            }
        }
    }

    public void kd(boolean z) {
        this.fmi = z;
        this.eYq.kd(z);
    }

    public void a(a aVar) {
        this.fmk = aVar;
    }
}
