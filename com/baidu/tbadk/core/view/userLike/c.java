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
    private com.baidu.tbadk.coreExtra.model.a eTC;
    protected com.baidu.tbadk.core.view.userLike.a fhf;
    private b fhg;
    private BdUniqueId fhh;
    private boolean fhi;
    private d fhj;
    private a fhk;
    private TbPageContext mPageContext;
    private String brs = "0";
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.fhf != null && !StringUtils.isNull(c.this.fhf.getUserId()) && data != null && c.this.fhf.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.fhh == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.fhh)) ? false : true;
                    if (data.flk != null) {
                        String str = data.flk.appeal_msg;
                        if (data.flk.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).brB();
                        if (c.this.fhg != null) {
                            if (z) {
                                c.this.fhg.a(c.this.fhf.getIsLike(), c.this.fhf.getLikeStatus(), z);
                            } else {
                                c.this.fhg.s(c.this.fhf.getIsLike(), c.this.fhf.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.fhf.getFansNum();
                        boolean isLike = c.this.fhf.getIsLike();
                        if (data.isAttention && !isLike) {
                            fansNum++;
                        } else if (!data.isAttention && isLike) {
                            fansNum--;
                            if (!c.this.fhi) {
                                c.this.mPageContext.showToast(R.string.un_attention_success);
                            }
                        }
                        c.this.fhf.setLikeStatus(data.status);
                        c.this.fhf.setIsLike(data.isAttention);
                        c.this.fhf.setIsFromNetWork(false);
                        c.this.fhf.setFansNum(fansNum);
                        if (c.this.fhg != null) {
                            c.this.fhg.rq(fansNum);
                            if (z) {
                                if (c.this.fhk != null) {
                                    c.this.fhk.jM(data.isAttention);
                                }
                                c.this.fhg.a(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.fhg.s(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void jM(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.eTC = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.fhh = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.eTG);
        a(bVar);
    }

    public void Bc(String str) {
        this.brs = str;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fhh = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.eTG);
            this.eTG.setTag(this.fhh);
            MessageManager.getInstance().registerListener(this.eTG);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.eTG);
        }
    }

    public void a(b bVar) {
        this.fhg = bVar;
        if (this.fhg != null) {
            this.fhg.h(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.fhf = aVar;
        if (this.fhg != null && this.fhf != null) {
            this.fhg.s(aVar.getIsLike(), aVar.getLikeStatus());
            this.fhg.rq(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a bwy() {
        return this.fhf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fhj == null || !this.fhj.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.fhg != null) {
                this.fhg.bB(view);
            }
            if (bh.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.fhf != null) {
                boolean z = !this.fhf.getIsLike();
                if (this.fhh == null) {
                    this.eTC.a(z, this.fhf.getPortrait(), this.fhf.getUserId(), this.fhf.isGod(), this.brs, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.eTC.a(z, this.fhf.getPortrait(), this.fhf.getUserId(), this.fhf.isGod(), this.brs, this.fhh, null, "0");
                }
            }
        }
    }

    public void jL(boolean z) {
        this.fhi = z;
        this.eTC.jL(z);
    }

    public void a(a aVar) {
        this.fhk = aVar;
    }
}
