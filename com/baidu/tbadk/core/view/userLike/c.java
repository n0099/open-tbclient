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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private com.baidu.tbadk.coreExtra.model.a eaU;
    protected com.baidu.tbadk.core.view.userLike.a enO;
    private b enP;
    private BdUniqueId enQ;
    private d enR;
    private a enS;
    private TbPageContext mPageContext;
    private String aZb = "0";
    private CustomMessageListener eaY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.enO != null && !StringUtils.isNull(c.this.enO.getUserId()) && data != null && c.this.enO.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.enQ == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.enQ)) ? false : true;
                    if (data.erH != null) {
                        String str = data.erH.appeal_msg;
                        if (data.erH.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aYR();
                        if (c.this.enP != null) {
                            if (z) {
                                c.this.enP.a(c.this.enO.getIsLike(), c.this.enO.getLikeStatus(), z);
                            } else {
                                c.this.enP.r(c.this.enO.getIsLike(), c.this.enO.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.enO.getFansNum();
                        boolean isLike = c.this.enO.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            c.this.mPageContext.showToast(R.string.un_attention_success);
                        }
                        c.this.enO.setLikeStatus(data.status);
                        c.this.enO.setIsLike(data.isAttention);
                        c.this.enO.setIsFromNetWork(false);
                        c.this.enO.setFansNum(fansNum);
                        if (c.this.enP != null) {
                            c.this.enP.nc(fansNum);
                            if (z) {
                                if (c.this.enS != null) {
                                    c.this.enS.mo32if(data.isAttention);
                                }
                                c.this.enP.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.enP.r(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        /* renamed from: if  reason: not valid java name */
        void mo32if(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.eaU = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.enQ = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.eaY);
        a(bVar);
    }

    public void wX(String str) {
        this.aZb = str;
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.enQ = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.eaY);
            this.eaY.setTag(this.enQ);
            MessageManager.getInstance().registerListener(this.eaY);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.eaY);
        }
    }

    public void a(b bVar) {
        this.enP = bVar;
        if (this.enP != null) {
            this.enP.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.enO = aVar;
        if (this.enP != null && this.enO != null) {
            this.enP.r(aVar.getIsLike(), aVar.getLikeStatus());
            this.enP.nc(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a bdf() {
        return this.enO;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.enR == null || !this.enR.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.enP != null) {
                this.enP.bi(view);
            }
            if (bf.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.enO != null) {
                boolean z = !this.enO.getIsLike();
                if (this.enQ == null) {
                    this.eaU.a(z, this.enO.getPortrait(), this.enO.getUserId(), this.enO.isGod(), this.aZb, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.eaU.a(z, this.enO.getPortrait(), this.enO.getUserId(), this.enO.isGod(), this.aZb, this.enQ, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.enS = aVar;
    }
}
