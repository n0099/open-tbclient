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
    private com.baidu.tbadk.coreExtra.model.a eNr;
    protected com.baidu.tbadk.core.view.userLike.a faA;
    private b faB;
    private BdUniqueId faC;
    private boolean faD;
    private d faE;
    private a faF;
    private TbPageContext mPageContext;
    private String bnW = "0";
    private CustomMessageListener eNv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.faA != null && !StringUtils.isNull(c.this.faA.getUserId()) && data != null && c.this.faA.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.faC == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.faC)) ? false : true;
                    if (data.feD != null) {
                        String str = data.feD.appeal_msg;
                        if (data.feD.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bpi();
                        if (c.this.faB != null) {
                            if (z) {
                                c.this.faB.a(c.this.faA.getIsLike(), c.this.faA.getLikeStatus(), z);
                            } else {
                                c.this.faB.s(c.this.faA.getIsLike(), c.this.faA.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.faA.getFansNum();
                        boolean isLike = c.this.faA.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            if (!c.this.faD) {
                                c.this.mPageContext.showToast(R.string.un_attention_success);
                            }
                        }
                        c.this.faA.setLikeStatus(data.status);
                        c.this.faA.setIsLike(data.isAttention);
                        c.this.faA.setIsFromNetWork(false);
                        c.this.faA.setFansNum(fansNum);
                        if (c.this.faB != null) {
                            c.this.faB.qr(fansNum);
                            if (z) {
                                if (c.this.faF != null) {
                                    c.this.faF.jv(data.isAttention);
                                }
                                c.this.faB.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.faB.s(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void jv(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.eNr = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.faC = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.eNv);
        a(bVar);
    }

    public void Ba(String str) {
        this.bnW = str;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.faC = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.eNv);
            this.eNv.setTag(this.faC);
            MessageManager.getInstance().registerListener(this.eNv);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.eNv);
        }
    }

    public void a(b bVar) {
        this.faB = bVar;
        if (this.faB != null) {
            this.faB.h(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.faA = aVar;
        if (this.faB != null && this.faA != null) {
            this.faB.s(aVar.getIsLike(), aVar.getLikeStatus());
            this.faB.qr(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a btI() {
        return this.faA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.faE == null || !this.faE.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.faB != null) {
                this.faB.bv(view);
            }
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.faA != null) {
                boolean z = !this.faA.getIsLike();
                if (this.faC == null) {
                    this.eNr.a(z, this.faA.getPortrait(), this.faA.getUserId(), this.faA.isGod(), this.bnW, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.eNr.a(z, this.faA.getPortrait(), this.faA.getUserId(), this.faA.isGod(), this.bnW, this.faC, null, "0");
                }
            }
        }
    }

    public void ju(boolean z) {
        this.faD = z;
        this.eNr.ju(z);
    }

    public void a(a aVar) {
        this.faF = aVar;
    }
}
