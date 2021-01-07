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
    private com.baidu.tbadk.coreExtra.model.a fcZ;
    protected com.baidu.tbadk.core.view.userLike.a fqP;
    private b fqQ;
    private BdUniqueId fqR;
    private boolean fqS;
    private d fqT;
    private a fqU;
    private TbPageContext mPageContext;
    private String bvZ = "0";
    private CustomMessageListener fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.fqP != null && !StringUtils.isNull(c.this.fqP.getUserId()) && data != null && c.this.fqP.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.fqR == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.fqR)) ? false : true;
                    if (data.fuV != null) {
                        String str = data.fuV.appeal_msg;
                        if (data.fuV.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bue();
                        if (c.this.fqQ != null) {
                            if (z) {
                                c.this.fqQ.c(c.this.fqP.getIsLike(), c.this.fqP.getLikeStatus(), z);
                            } else {
                                c.this.fqQ.r(c.this.fqP.getIsLike(), c.this.fqP.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.fqP.getFansNum();
                        boolean isLike = c.this.fqP.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            if (!c.this.fqS) {
                                c.this.mPageContext.showToast(R.string.un_attention_success);
                            }
                        }
                        c.this.fqP.setLikeStatus(data.status);
                        c.this.fqP.setIsLike(data.isAttention);
                        c.this.fqP.setIsFromNetWork(false);
                        c.this.fqP.setFansNum(fansNum);
                        if (c.this.fqQ != null) {
                            c.this.fqQ.rC(fansNum);
                            if (z) {
                                if (c.this.fqU != null) {
                                    c.this.fqU.ki(data.isAttention);
                                }
                                c.this.fqQ.c(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.fqQ.r(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ki(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.fcZ = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.fqR = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.fdd);
        a(bVar);
    }

    public void Ba(String str) {
        this.bvZ = str;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fqR = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.fdd);
            this.fdd.setTag(this.fqR);
            MessageManager.getInstance().registerListener(this.fdd);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.fdd);
        }
    }

    public void a(b bVar) {
        this.fqQ = bVar;
        if (this.fqQ != null) {
            this.fqQ.i(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.fqP = aVar;
        if (this.fqQ != null && this.fqP != null) {
            this.fqQ.r(aVar.getIsLike(), aVar.getLikeStatus());
            this.fqQ.rC(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a byS() {
        return this.fqP;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fqT == null || !this.fqT.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.fqQ != null) {
                this.fqQ.bK(view);
            }
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.fqP != null) {
                boolean z = !this.fqP.getIsLike();
                if (this.fqR == null) {
                    this.fcZ.a(z, this.fqP.getPortrait(), this.fqP.getUserId(), this.fqP.isGod(), this.bvZ, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.fcZ.a(z, this.fqP.getPortrait(), this.fqP.getUserId(), this.fqP.isGod(), this.bvZ, this.fqR, null, "0");
                }
            }
        }
    }

    public void kh(boolean z) {
        this.fqS = z;
        this.fcZ.kh(z);
    }

    public void a(a aVar) {
        this.fqU = aVar;
    }
}
