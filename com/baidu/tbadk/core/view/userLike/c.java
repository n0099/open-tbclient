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
    protected com.baidu.tbadk.core.view.userLike.a eAi;
    private b eAj;
    private BdUniqueId eAk;
    private boolean eAl;
    private d eAm;
    private a eAn;
    private com.baidu.tbadk.coreExtra.model.a emW;
    private TbPageContext mPageContext;
    private String bhq = "0";
    private CustomMessageListener ena = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.eAi != null && !StringUtils.isNull(c.this.eAi.getUserId()) && data != null && c.this.eAi.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.eAk == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.eAk)) ? false : true;
                    if (data.eEj != null) {
                        String str = data.eEj.appeal_msg;
                        if (data.eEj.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).big();
                        if (c.this.eAj != null) {
                            if (z) {
                                c.this.eAj.a(c.this.eAi.getIsLike(), c.this.eAi.getLikeStatus(), z);
                            } else {
                                c.this.eAj.r(c.this.eAi.getIsLike(), c.this.eAi.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.eAi.getFansNum();
                        boolean isLike = c.this.eAi.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            if (!c.this.eAl) {
                                c.this.mPageContext.showToast(R.string.un_attention_success);
                            }
                        }
                        c.this.eAi.setLikeStatus(data.status);
                        c.this.eAi.setIsLike(data.isAttention);
                        c.this.eAi.setIsFromNetWork(false);
                        c.this.eAi.setFansNum(fansNum);
                        if (c.this.eAj != null) {
                            c.this.eAj.py(fansNum);
                            if (z) {
                                if (c.this.eAn != null) {
                                    c.this.eAn.iB(data.isAttention);
                                }
                                c.this.eAj.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.eAj.r(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void iB(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.emW = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.eAk = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.ena);
        a(bVar);
    }

    public void zH(String str) {
        this.bhq = str;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eAk = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.ena);
            this.ena.setTag(this.eAk);
            MessageManager.getInstance().registerListener(this.ena);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.ena);
        }
    }

    public void a(b bVar) {
        this.eAj = bVar;
        if (this.eAj != null) {
            this.eAj.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.eAi = aVar;
        if (this.eAj != null && this.eAi != null) {
            this.eAj.r(aVar.getIsLike(), aVar.getLikeStatus());
            this.eAj.py(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a bmF() {
        return this.eAi;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eAm == null || !this.eAm.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.eAj != null) {
                this.eAj.bm(view);
            }
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.eAi != null) {
                boolean z = !this.eAi.getIsLike();
                if (this.eAk == null) {
                    this.emW.a(z, this.eAi.getPortrait(), this.eAi.getUserId(), this.eAi.isGod(), this.bhq, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.emW.a(z, this.eAi.getPortrait(), this.eAi.getUserId(), this.eAi.isGod(), this.bhq, this.eAk, null, "0");
                }
            }
        }
    }

    public void iA(boolean z) {
        this.eAl = z;
        this.emW.iA(z);
    }

    public void a(a aVar) {
        this.eAn = aVar;
    }
}
