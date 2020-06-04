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
    private com.baidu.tbadk.coreExtra.model.a dNL;
    protected com.baidu.tbadk.core.view.userLike.a dYT;
    private b dYU;
    private BdUniqueId dYV;
    private d dYW;
    private a dYX;
    private TbPageContext mPageContext;
    private String aWu = "0";
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.dYT != null && !StringUtils.isNull(c.this.dYT.getUserId()) && data != null && c.this.dYT.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.dYV == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.dYV)) ? false : true;
                    if (data.ecK != null) {
                        String str = data.ecK.appeal_msg;
                        if (data.ecK.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aSY();
                        if (c.this.dYU != null) {
                            if (z) {
                                c.this.dYU.a(c.this.dYT.getIsLike(), c.this.dYT.getLikeStatus(), z);
                            } else {
                                c.this.dYU.r(c.this.dYT.getIsLike(), c.this.dYT.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.dYT.getFansNum();
                        boolean isLike = c.this.dYT.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            c.this.mPageContext.showToast(R.string.un_attention_success);
                        }
                        c.this.dYT.setLikeStatus(data.status);
                        c.this.dYT.setIsLike(data.isAttention);
                        c.this.dYT.setIsFromNetWork(false);
                        c.this.dYT.setFansNum(fansNum);
                        if (c.this.dYU != null) {
                            c.this.dYU.mq(fansNum);
                            if (z) {
                                if (c.this.dYX != null) {
                                    c.this.dYX.hs(data.isAttention);
                                }
                                c.this.dYU.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.dYU.r(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void hs(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.dNL = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.dYV = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.dNP);
        a(bVar);
    }

    public void vA(String str) {
        this.aWu = str;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dYV = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.dNP);
            this.dNP.setTag(this.dYV);
            MessageManager.getInstance().registerListener(this.dNP);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.dNP);
        }
    }

    public void a(b bVar) {
        this.dYU = bVar;
        if (this.dYU != null) {
            this.dYU.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.dYT = aVar;
        if (this.dYU != null && this.dYT != null) {
            this.dYU.r(aVar.getIsLike(), aVar.getLikeStatus());
            this.dYU.mq(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a aXc() {
        return this.dYT;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dYW == null || !this.dYW.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.dYU != null) {
                this.dYU.bc(view);
            }
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.dYT != null) {
                boolean z = !this.dYT.getIsLike();
                if (this.dYV == null) {
                    this.dNL.a(z, this.dYT.getPortrait(), this.dYT.getUserId(), this.dYT.isGod(), this.aWu, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.dNL.a(z, this.dYT.getPortrait(), this.dYT.getUserId(), this.dYT.isGod(), this.aWu, this.dYV, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.dYX = aVar;
    }
}
