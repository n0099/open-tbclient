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
    private com.baidu.tbadk.coreExtra.model.a eMq;
    protected com.baidu.tbadk.core.view.userLike.a eZI;
    private b eZJ;
    private BdUniqueId eZK;
    private boolean eZL;
    private d eZM;
    private a eZN;
    private TbPageContext mPageContext;
    private String bml = "0";
    private CustomMessageListener eMu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.eZI != null && !StringUtils.isNull(c.this.eZI.getUserId()) && data != null && c.this.eZI.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.eZK == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.eZK)) ? false : true;
                    if (data.fdL != null) {
                        String str = data.fdL.appeal_msg;
                        if (data.fdL.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bom();
                        if (c.this.eZJ != null) {
                            if (z) {
                                c.this.eZJ.a(c.this.eZI.getIsLike(), c.this.eZI.getLikeStatus(), z);
                            } else {
                                c.this.eZJ.s(c.this.eZI.getIsLike(), c.this.eZI.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.eZI.getFansNum();
                        boolean isLike = c.this.eZI.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            if (!c.this.eZL) {
                                c.this.mPageContext.showToast(R.string.un_attention_success);
                            }
                        }
                        c.this.eZI.setLikeStatus(data.status);
                        c.this.eZI.setIsLike(data.isAttention);
                        c.this.eZI.setIsFromNetWork(false);
                        c.this.eZI.setFansNum(fansNum);
                        if (c.this.eZJ != null) {
                            c.this.eZJ.qP(fansNum);
                            if (z) {
                                if (c.this.eZN != null) {
                                    c.this.eZN.jw(data.isAttention);
                                }
                                c.this.eZJ.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.eZJ.s(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void jw(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.eMq = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.eZK = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.eMu);
        a(bVar);
    }

    public void Av(String str) {
        this.bml = str;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eZK = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.eMu);
            this.eMu.setTag(this.eZK);
            MessageManager.getInstance().registerListener(this.eMu);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.eMu);
        }
    }

    public void a(b bVar) {
        this.eZJ = bVar;
        if (this.eZJ != null) {
            this.eZJ.h(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.eZI = aVar;
        if (this.eZJ != null && this.eZI != null) {
            this.eZJ.s(aVar.getIsLike(), aVar.getLikeStatus());
            this.eZJ.qP(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a bsY() {
        return this.eZI;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eZM == null || !this.eZM.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.eZJ != null) {
                this.eZJ.by(view);
            }
            if (bh.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.eZI != null) {
                boolean z = !this.eZI.getIsLike();
                if (this.eZK == null) {
                    this.eMq.a(z, this.eZI.getPortrait(), this.eZI.getUserId(), this.eZI.isGod(), this.bml, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.eMq.a(z, this.eZI.getPortrait(), this.eZI.getUserId(), this.eZI.isGod(), this.bml, this.eZK, null, "0");
                }
            }
        }
    }

    public void jv(boolean z) {
        this.eZL = z;
        this.eMq.jv(z);
    }

    public void a(a aVar) {
        this.eZN = aVar;
    }
}
