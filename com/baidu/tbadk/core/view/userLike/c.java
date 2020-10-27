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
    private com.baidu.tbadk.coreExtra.model.a eHC;
    protected com.baidu.tbadk.core.view.userLike.a eUL;
    private b eUM;
    private BdUniqueId eUN;
    private boolean eUO;
    private d eUP;
    private a eUQ;
    private TbPageContext mPageContext;
    private String bmC = "0";
    private CustomMessageListener eHG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.eUL != null && !StringUtils.isNull(c.this.eUL.getUserId()) && data != null && c.this.eUL.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.eUN == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.eUN)) ? false : true;
                    if (data.eYM != null) {
                        String str = data.eYM.appeal_msg;
                        if (data.eYM.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bmI();
                        if (c.this.eUM != null) {
                            if (z) {
                                c.this.eUM.a(c.this.eUL.getIsLike(), c.this.eUL.getLikeStatus(), z);
                            } else {
                                c.this.eUM.s(c.this.eUL.getIsLike(), c.this.eUL.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.eUL.getFansNum();
                        boolean isLike = c.this.eUL.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            if (!c.this.eUO) {
                                c.this.mPageContext.showToast(R.string.un_attention_success);
                            }
                        }
                        c.this.eUL.setLikeStatus(data.status);
                        c.this.eUL.setIsLike(data.isAttention);
                        c.this.eUL.setIsFromNetWork(false);
                        c.this.eUL.setFansNum(fansNum);
                        if (c.this.eUM != null) {
                            c.this.eUM.qh(fansNum);
                            if (z) {
                                if (c.this.eUQ != null) {
                                    c.this.eUQ.jm(data.isAttention);
                                }
                                c.this.eUM.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.eUM.s(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void jm(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.eHC = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.eUN = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.eHG);
        a(bVar);
    }

    public void AM(String str) {
        this.bmC = str;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eUN = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.eHG);
            this.eHG.setTag(this.eUN);
            MessageManager.getInstance().registerListener(this.eHG);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.eHG);
        }
    }

    public void a(b bVar) {
        this.eUM = bVar;
        if (this.eUM != null) {
            this.eUM.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.eUL = aVar;
        if (this.eUM != null && this.eUL != null) {
            this.eUM.s(aVar.getIsLike(), aVar.getLikeStatus());
            this.eUM.qh(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a bri() {
        return this.eUL;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eUP == null || !this.eUP.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.eUM != null) {
                this.eUM.br(view);
            }
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.eUL != null) {
                boolean z = !this.eUL.getIsLike();
                if (this.eUN == null) {
                    this.eHC.a(z, this.eUL.getPortrait(), this.eUL.getUserId(), this.eUL.isGod(), this.bmC, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.eHC.a(z, this.eUL.getPortrait(), this.eUL.getUserId(), this.eUL.isGod(), this.bmC, this.eUN, null, "0");
                }
            }
        }
    }

    public void jl(boolean z) {
        this.eUO = z;
        this.eHC.jl(z);
    }

    public void a(a aVar) {
        this.eUQ = aVar;
    }
}
