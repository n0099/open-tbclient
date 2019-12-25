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
    private com.baidu.tbadk.coreExtra.model.a cVO;
    protected com.baidu.tbadk.core.view.userLike.a dfL;
    private b dfM;
    private BdUniqueId dfN;
    private d dfO;
    private a dfP;
    private TbPageContext mPageContext;
    private String aru = "0";
    private CustomMessageListener cVS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.dfL != null && !StringUtils.isNull(c.this.dfL.getUserId()) && data != null && c.this.dfL.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.dfN == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.dfN)) ? false : true;
                    if (data.djy != null) {
                        String str = data.djy.appeal_msg;
                        if (data.djy.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aCb();
                        if (c.this.dfM != null) {
                            if (z) {
                                c.this.dfM.b(c.this.dfL.getIsLike(), c.this.dfL.getLikeStatus(), z);
                            } else {
                                c.this.dfM.k(c.this.dfL.getIsLike(), c.this.dfL.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.dfL.getFansNum();
                        if (data.isAttention && !c.this.dfL.getIsLike()) {
                            fansNum++;
                            c.this.mPageContext.showToast(R.string.attention_success);
                        } else if (!data.isAttention && c.this.dfL.getIsLike()) {
                            fansNum--;
                            c.this.mPageContext.showToast(R.string.un_attention_success);
                        }
                        c.this.dfL.setLikeStatus(data.status);
                        c.this.dfL.setIsLike(data.isAttention);
                        c.this.dfL.setIsFromNetWork(false);
                        c.this.dfL.setFansNum(fansNum);
                        if (c.this.dfM != null) {
                            c.this.dfM.lg(fansNum);
                            if (z) {
                                if (c.this.dfP != null) {
                                    c.this.dfP.fJ(data.isAttention);
                                }
                                c.this.dfM.b(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.dfM.k(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void fJ(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.cVO = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.dfN = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.cVS);
        a(bVar);
    }

    public void sk(String str) {
        this.aru = str;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dfN = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.cVS);
            this.cVS.setTag(this.dfN);
            MessageManager.getInstance().registerListener(this.cVS);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.cVS);
        }
    }

    public void a(b bVar) {
        this.dfM = bVar;
        if (this.dfM != null) {
            this.dfM.h(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.dfL = aVar;
        if (this.dfM != null && this.dfL != null) {
            this.dfM.k(aVar.getIsLike(), aVar.getLikeStatus());
            this.dfM.lg(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a aFL() {
        return this.dfL;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dfO == null || !this.dfO.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.dfM != null) {
                this.dfM.aW(view);
            }
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.dfL != null) {
                if (this.dfN == null) {
                    this.cVO.a(this.dfL.getIsLike() ? false : true, this.dfL.getPortrait(), this.dfL.getUserId(), this.dfL.isGod(), this.aru, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.cVO.a(this.dfL.getIsLike() ? false : true, this.dfL.getPortrait(), this.dfL.getUserId(), this.dfL.isGod(), this.aru, this.dfN, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.dfP = aVar;
    }
}
