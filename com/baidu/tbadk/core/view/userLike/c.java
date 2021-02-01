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
    private com.baidu.tbadk.coreExtra.model.a faF;
    private BdUniqueId foA;
    private boolean foB;
    private d foC;
    private a foD;
    protected com.baidu.tbadk.core.view.userLike.a foy;
    private b foz;
    private TbPageContext mPageContext;
    private String buO = "0";
    private CustomMessageListener faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.foy != null && !StringUtils.isNull(c.this.foy.getUserId()) && data != null && c.this.foy.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.foA == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.foA)) ? false : true;
                    if (data.fsD != null) {
                        String str = data.fsD.appeal_msg;
                        if (data.fsD.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqD();
                        if (c.this.foz != null) {
                            if (z) {
                                c.this.foz.c(c.this.foy.getIsLike(), c.this.foy.getLikeStatus(), z);
                            } else {
                                c.this.foz.r(c.this.foy.getIsLike(), c.this.foy.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.foy.getFansNum();
                        boolean isLike = c.this.foy.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            if (!c.this.foB) {
                                c.this.mPageContext.showToast(R.string.un_attention_success);
                            }
                        }
                        c.this.foy.setLikeStatus(data.status);
                        c.this.foy.setIsLike(data.isAttention);
                        c.this.foy.setIsFromNetWork(false);
                        c.this.foy.setFansNum(fansNum);
                        if (c.this.foz != null) {
                            c.this.foz.qb(fansNum);
                            if (z) {
                                if (c.this.foD != null) {
                                    c.this.foD.kh(data.isAttention);
                                }
                                c.this.foz.c(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.foz.r(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void kh(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.faF = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.foA = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.faJ);
        a(bVar);
    }

    public void Ag(String str) {
        this.buO = str;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.foA = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.faJ);
            this.faJ.setTag(this.foA);
            MessageManager.getInstance().registerListener(this.faJ);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.faJ);
        }
    }

    public void a(b bVar) {
        this.foz = bVar;
        if (this.foz != null) {
            this.foz.i(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.foy = aVar;
        if (this.foz != null && this.foy != null) {
            this.foz.r(aVar.getIsLike(), aVar.getLikeStatus());
            this.foz.qb(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a bvs() {
        return this.foy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.foC == null || !this.foC.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.foz != null) {
                this.foz.bG(view);
            }
            if (bh.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.foy != null) {
                boolean z = !this.foy.getIsLike();
                if (this.foA == null) {
                    this.faF.a(z, this.foy.getPortrait(), this.foy.getUserId(), this.foy.isGod(), this.buO, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.faF.a(z, this.foy.getPortrait(), this.foy.getUserId(), this.foy.isGod(), this.buO, this.foA, null, "0");
                }
            }
        }
    }

    public void kg(boolean z) {
        this.foB = z;
        this.faF.kg(z);
    }

    public void a(a aVar) {
        this.foD = aVar;
    }
}
