package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.r.q.t1;
import d.b.i0.r.s.a;
import d.b.i0.s.e.a;
/* loaded from: classes3.dex */
public class ReplyPrivacyCheckController {
    public static int PRIVACY_MYSELF = 4;
    public static int PRIVACY_MY_ATTENTION = 3;
    public static int PRIVACY_MY_FANS = 2;
    public static int TYPE_EMOTION_IMAGE = 2;
    public static int TYPE_FLOOR = 1;
    public static int TYPE_THREAD;
    public IAfterAttentionCallBack mAttentionCallback;
    public CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (ReplyPrivacyCheckController.this.mLikeData == null || StringUtils.isNull(ReplyPrivacyCheckController.this.mLikeData.uid) || data == null || !ReplyPrivacyCheckController.this.mLikeData.uid.equals(data.f13364c)) {
                    return;
                }
                boolean z = false;
                if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(ReplyPrivacyCheckController.this.mId)) {
                    if (updateAttentionMessage.getError() == 3250013) {
                        BdToast.h(ReplyPrivacyCheckController.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).q();
                    } else {
                        AntiHelper.s(ReplyPrivacyCheckController.this.mContext.getPageActivity(), data.k);
                    }
                    z = true;
                }
                if (data.f13362a) {
                    ReplyPrivacyCheckController.this.mLikeData.likeStatus = data.l;
                    ReplyPrivacyCheckController.this.mLikeData.isAttention = data.f13365d;
                }
                if (!z || ReplyPrivacyCheckController.this.mAttentionCallback == null) {
                    return;
                }
                ReplyPrivacyCheckController.this.mAttentionCallback.sendAfterAttention(data.f13362a, ReplyPrivacyCheckController.this.replyType);
            }
        }
    };
    public a mAttentionModel;
    public TbPageContext mContext;
    public d.b.i0.r.s.a mDialog;
    public BdUniqueId mId;
    public AttentionHostData mLikeData;
    public int replyType;

    /* loaded from: classes3.dex */
    public interface IAfterAttentionCallBack {
        void sendAfterAttention(boolean z, int i);
    }

    public ReplyPrivacyCheckController(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        BdUniqueId gen = BdUniqueId.gen();
        this.mId = gen;
        this.mAttentionListener.setTag(gen);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void followHost() {
        if (!j.A()) {
            this.mContext.showToast(R.string.network_ungeilivable);
        } else if (this.mLikeData != null && ViewHelper.checkUpIsLogin(this.mContext.getPageActivity())) {
            if (this.mAttentionModel == null) {
                this.mAttentionModel = new a(this.mContext);
            }
            a aVar = this.mAttentionModel;
            AttentionHostData attentionHostData = this.mLikeData;
            aVar.m(true, attentionHostData.portrait, attentionHostData.uid, attentionHostData.isGod, "0", this.mId, null, "0");
        }
    }

    private void showAttentionDialog() {
        if (this.mDialog == null) {
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.mContext.getPageActivity());
            this.mDialog = aVar;
            aVar.setMessageId(R.string.message_privacy_fans_can_reply);
            this.mDialog.setPositiveButton(R.string.attention_and_reply, new a.e() { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.1
                @Override // d.b.i0.r.s.a.e
                public void onClick(d.b.i0.r.s.a aVar2) {
                    ReplyPrivacyCheckController.this.followHost();
                    ReplyPrivacyCheckController.this.mDialog.dismiss();
                }
            });
            this.mDialog.setNegativeButton(R.string.cancel, new a.e() { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.2
                @Override // d.b.i0.r.s.a.e
                public void onClick(d.b.i0.r.s.a aVar2) {
                    ReplyPrivacyCheckController.this.mDialog.dismiss();
                }
            });
            this.mDialog.setAutoNight(true);
            this.mDialog.create(this.mContext);
        }
        this.mDialog.show();
    }

    public boolean checkPrivacyBeforeInvokeEditor(int i) {
        if (i == PRIVACY_MY_ATTENTION) {
            l.K(this.mContext.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean checkPrivacyBeforeSend(int i, int i2) {
        this.replyType = i2;
        if (i == PRIVACY_MY_FANS) {
            AttentionHostData attentionHostData = this.mLikeData;
            if (attentionHostData == null || attentionHostData.isAttention) {
                return true;
            }
            showAttentionDialog();
            return false;
        } else if (i == PRIVACY_MY_ATTENTION) {
            l.K(this.mContext.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        d.b.i0.r.s.a aVar = this.mDialog;
        if (aVar != null) {
            aVar.dismiss();
        }
        d.b.i0.s.e.a aVar2 = this.mAttentionModel;
        if (aVar2 != null) {
            aVar2.g();
        }
    }

    public void setAttentionCallback(IAfterAttentionCallBack iAfterAttentionCallBack) {
        this.mAttentionCallback = iAfterAttentionCallBack;
    }

    public void setLikeUserData(AttentionHostData attentionHostData) {
        this.mLikeData = attentionHostData;
    }

    public boolean showToastForPrivacy(int i) {
        if (i == PRIVACY_MY_FANS) {
            AttentionHostData attentionHostData = this.mLikeData;
            if (attentionHostData == null || attentionHostData.isAttention) {
                return true;
            }
            l.K(this.mContext.getPageActivity(), R.string.message_privacy_fans_can_reply);
            return false;
        } else if (i == PRIVACY_MY_ATTENTION) {
            l.K(this.mContext.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void showAttentionDialog(t1 t1Var) {
        if (t1Var != null && !StringUtils.isNull(t1Var.f51631a) && !StringUtils.isNull(t1Var.f51632b) && !StringUtils.isNull(t1Var.f51633c)) {
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.mContext.getPageActivity());
            aVar.setMessage(t1Var.f51631a);
            aVar.setPositiveButton(t1Var.f51633c, new a.e() { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.3
                @Override // d.b.i0.r.s.a.e
                public void onClick(d.b.i0.r.s.a aVar2) {
                    ReplyPrivacyCheckController.this.followHost();
                    aVar2.dismiss();
                }
            });
            aVar.setNegativeButton(t1Var.f51632b, new a.e() { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.4
                @Override // d.b.i0.r.s.a.e
                public void onClick(d.b.i0.r.s.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.create(this.mContext);
            aVar.show();
            return;
        }
        showAttentionDialog();
    }
}
