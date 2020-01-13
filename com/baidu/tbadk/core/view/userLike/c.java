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
    private com.baidu.tbadk.coreExtra.model.a cVY;
    protected com.baidu.tbadk.core.view.userLike.a dfX;
    private b dfY;
    private BdUniqueId dfZ;
    private d dga;
    private a dgb;
    private TbPageContext mPageContext;
    private String asg = "0";
    private CustomMessageListener cWc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.view.userLike.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (c.this.dfX != null && !StringUtils.isNull(c.this.dfX.getUserId()) && data != null && c.this.dfX.getUserId().equals(data.toUid)) {
                    boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.dfZ == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.dfZ)) ? false : true;
                    if (data.djO != null) {
                        String str = data.djO.appeal_msg;
                        if (data.djO.appeal_status == 1) {
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
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aCu();
                        if (c.this.dfY != null) {
                            if (z) {
                                c.this.dfY.b(c.this.dfX.getIsLike(), c.this.dfX.getLikeStatus(), z);
                            } else {
                                c.this.dfY.l(c.this.dfX.getIsLike(), c.this.dfX.getLikeStatus());
                            }
                        }
                    } else {
                        int fansNum = c.this.dfX.getFansNum();
                        if (data.isAttention && !c.this.dfX.getIsLike()) {
                            fansNum++;
                            c.this.mPageContext.showToast(R.string.attention_success);
                        } else if (!data.isAttention && c.this.dfX.getIsLike()) {
                            fansNum--;
                            c.this.mPageContext.showToast(R.string.un_attention_success);
                        }
                        c.this.dfX.setLikeStatus(data.status);
                        c.this.dfX.setIsLike(data.isAttention);
                        c.this.dfX.setIsFromNetWork(false);
                        c.this.dfX.setFansNum(fansNum);
                        if (c.this.dfY != null) {
                            c.this.dfY.lg(fansNum);
                            if (z) {
                                if (c.this.dgb != null) {
                                    c.this.dgb.fO(data.isAttention);
                                }
                                c.this.dfY.b(data.isAttention, data.status, true);
                                return;
                            }
                            c.this.dfY.l(data.isAttention, data.status);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void fO(boolean z);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.cVY = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.dfZ = this.mPageContext.getUniqueId();
        tbPageContext.registerListener(this.cWc);
        a(bVar);
    }

    public void sn(String str) {
        this.asg = str;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dfZ = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.cWc);
            this.cWc.setTag(this.dfZ);
            MessageManager.getInstance().registerListener(this.cWc);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            MessageManager.getInstance().unRegisterListener(this.cWc);
        }
    }

    public void a(b bVar) {
        this.dfY = bVar;
        if (this.dfY != null) {
            this.dfY.g(this);
        }
    }

    public void a(com.baidu.tbadk.core.view.userLike.a aVar) {
        this.dfX = aVar;
        if (this.dfY != null && this.dfX != null) {
            this.dfY.l(aVar.getIsLike(), aVar.getLikeStatus());
            this.dfY.lg(aVar.getFansNum());
        }
    }

    public com.baidu.tbadk.core.view.userLike.a aGe() {
        return this.dfX;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dga == null || !this.dga.onClickEvent(view)) {
            if (!j.isNetworkAvailableForImmediately()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            if (this.dfY != null) {
                this.dfY.ba(view);
            }
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.dfX != null) {
                if (this.dfZ == null) {
                    this.cVY.a(this.dfX.getIsLike() ? false : true, this.dfX.getPortrait(), this.dfX.getUserId(), this.dfX.isGod(), this.asg, this.mPageContext.getUniqueId(), null, "0");
                } else {
                    this.cVY.a(this.dfX.getIsLike() ? false : true, this.dfX.getPortrait(), this.dfX.getUserId(), this.dfX.isGod(), this.asg, this.dfZ, null, "0");
                }
            }
        }
    }

    public void a(a aVar) {
        this.dgb = aVar;
    }
}
