package com.baidu.live.follow.pendant;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ab;
import com.baidu.live.data.f;
import com.baidu.live.follow.a.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.utils.j;
/* loaded from: classes11.dex */
public class a implements View.OnClickListener {
    private LiveFollowPendantView aVc;
    private b aVd;
    private Context mContext;
    private boolean aVf = false;
    private c.a aVg = new c.a() { // from class: com.baidu.live.follow.pendant.a.1
        @Override // com.baidu.live.follow.a.c.a
        public void a(boolean z, String str, boolean z2) {
            if (!z || a.this.aVc == null) {
                a.this.fO(str);
            } else if (!z2) {
                a.this.aVc.getFollowView().setVisibility(0);
            } else {
                a.this.aVc.getFollowView().setVisibility(8);
            }
            if (a.this.aVd != null) {
                a.this.aVd.bz(z2);
            }
        }
    };
    private CustomMessageListener aVh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.follow.pendant.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.aVc != null) {
                if (!updateAttentionMessage.isSucc()) {
                    a.this.fO(updateAttentionMessage.getData().usermsg);
                } else if (!updateAttentionMessage.isAttention() || a.this.mContext == null) {
                    a.this.aVc.getFollowView().setVisibility(0);
                } else {
                    BdUtilHelper.showToast(a.this.mContext, a.this.mContext.getString(a.h.sdk_attention_success), 0);
                    a.this.aVc.getFollowView().setVisibility(8);
                }
            }
        }
    };
    private com.baidu.live.follow.a.a aVe = new com.baidu.live.follow.a.a();

    public a(Context context) {
        this.mContext = context;
        this.aVc = new LiveFollowPendantView(context);
    }

    public void m(String str, String str2, String str3) {
        this.aVd = new b(str2, str, str3);
    }

    public boolean d(ab abVar) {
        if (abVar == null || abVar.mLiveInfo == null) {
            return false;
        }
        return "1".equals(abVar.mLiveInfo.pubShowId);
    }

    public void m(ViewGroup viewGroup) {
        b(viewGroup, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean isDisplay() {
        return this.aVf;
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            if (viewGroup.getChildCount() > 0) {
                Dr();
            }
            if (viewGroup.getVisibility() == 8 || viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
            }
            updateView();
            viewGroup.addView(this.aVc, layoutParams);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913301));
            registerListener();
            Dq();
        }
    }

    public void Dq() {
        if (TbadkCoreApplication.isLogin() && this.aVe != null && this.aVd != null) {
            this.aVe.as(this.aVd.getUserId(), "");
        }
    }

    private void updateView() {
        this.aVf = true;
        if (this.aVc != null && this.aVd != null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.aVc.getFollowView().setVisibility(0);
            } else {
                this.aVc.getFollowView().setVisibility(8);
            }
            this.aVc.setHeadImage(this.aVd.Du());
            this.aVc.setNickName(j.K(this.aVd.getNickName(), 8));
        }
    }

    public void cF(int i) {
        if (this.aVc != null) {
            if (this.aVc.getParent() != null) {
                ((ViewGroup) this.aVc.getParent()).setVisibility(i);
                ((ViewGroup) this.aVc.getParent()).removeView(this.aVc);
            }
            unRegisterListener();
            release();
        }
        this.aVf = false;
    }

    public void Dr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913302));
        cF(8);
    }

    public void registerListener() {
        if (this.aVc != null) {
            this.aVc.c(this);
        }
        if (this.aVe != null) {
            this.aVe.a(this.aVg);
        }
        MessageManager.getInstance().registerListener(this.aVh);
    }

    public void unRegisterListener() {
        if (this.aVc != null) {
            this.aVc.setOnClickListener(null);
        }
        MessageManager.getInstance().unRegisterListener(this.aVh);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aVc != null) {
            if (view == this.aVc.getFollowView()) {
                Ds();
            } else if (view == this.aVc.getNickNameView() || view == this.aVc.getHeadView()) {
                Dt();
            }
        }
    }

    public void onDestroy() {
        this.aVc = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913302));
        release();
    }

    public void release() {
        this.aVd = null;
        if (this.aVe != null) {
            this.aVe.release();
        }
    }

    private void Ds() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity();
        } else if (this.aVd != null) {
            f fVar = new f(this.aVd.Du(), this.aVd.getUserId(), true, BdUniqueId.gen());
            fVar.setFrom("live_show_perference");
            com.baidu.live.view.a.Xo().a(this.aVd.getUserId(), fVar);
        }
    }

    private void Dt() {
        if (this.aVd != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), this.aVd.getUserId())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fO(String str) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str)) {
            str = "操作失败";
        }
        BdUtilHelper.showToast(this.mContext, str, 0);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.aVc != null) {
            this.aVc.setVisibility(z ? 4 : 0);
        }
    }
}
