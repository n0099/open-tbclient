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
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private LiveFollowPendantView aWC;
    private b aWD;
    private Context mContext;
    private boolean aWF = false;
    private c.a aWG = new c.a() { // from class: com.baidu.live.follow.pendant.a.1
        @Override // com.baidu.live.follow.a.c.a
        public void a(boolean z, String str, boolean z2) {
            if (!z || a.this.aWC == null) {
                a.this.fU(str);
            } else if (!z2) {
                a.this.aWC.getFollowView().setVisibility(0);
            } else {
                a.this.aWC.getFollowView().setVisibility(8);
            }
            if (a.this.aWD != null) {
                a.this.aWD.bz(z2);
            }
        }
    };
    private CustomMessageListener aWH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.follow.pendant.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.aWC != null) {
                if (!updateAttentionMessage.isSucc()) {
                    a.this.fU(updateAttentionMessage.getData().usermsg);
                } else if (!updateAttentionMessage.isAttention() || a.this.mContext == null) {
                    a.this.aWC.getFollowView().setVisibility(0);
                } else {
                    BdUtilHelper.showToast(a.this.mContext, a.this.mContext.getString(a.h.sdk_attention_success), 0);
                    a.this.aWC.getFollowView().setVisibility(8);
                }
            }
        }
    };
    private com.baidu.live.follow.a.a aWE = new com.baidu.live.follow.a.a();

    public a(Context context) {
        this.mContext = context;
        this.aWC = new LiveFollowPendantView(context);
    }

    public void m(String str, String str2, String str3) {
        this.aWD = new b(str2, str, str3);
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
        return this.aWF;
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            if (viewGroup.getChildCount() > 0) {
                Du();
            }
            if (viewGroup.getVisibility() == 8 || viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
            }
            updateView();
            viewGroup.addView(this.aWC, layoutParams);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913301));
            registerListener();
            Dt();
        }
    }

    public void Dt() {
        if (TbadkCoreApplication.isLogin() && this.aWE != null && this.aWD != null) {
            this.aWE.as(this.aWD.getUserId(), "");
        }
    }

    private void updateView() {
        this.aWF = true;
        if (this.aWC != null && this.aWD != null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.aWC.getFollowView().setVisibility(0);
            } else {
                this.aWC.getFollowView().setVisibility(8);
            }
            this.aWC.setHeadImage(this.aWD.Dx());
            this.aWC.setNickName(j.K(this.aWD.getNickName(), 8));
        }
    }

    public void cG(int i) {
        if (this.aWC != null) {
            if (this.aWC.getParent() != null) {
                ((ViewGroup) this.aWC.getParent()).setVisibility(i);
                ((ViewGroup) this.aWC.getParent()).removeView(this.aWC);
            }
            unRegisterListener();
            release();
        }
        this.aWF = false;
    }

    public void Du() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913302));
        cG(8);
    }

    public void registerListener() {
        if (this.aWC != null) {
            this.aWC.c(this);
        }
        if (this.aWE != null) {
            this.aWE.a(this.aWG);
        }
        MessageManager.getInstance().registerListener(this.aWH);
    }

    public void unRegisterListener() {
        if (this.aWC != null) {
            this.aWC.setOnClickListener(null);
        }
        MessageManager.getInstance().unRegisterListener(this.aWH);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aWC != null) {
            if (view == this.aWC.getFollowView()) {
                Dv();
            } else if (view == this.aWC.getNickNameView() || view == this.aWC.getHeadView()) {
                Dw();
            }
        }
    }

    public void onDestroy() {
        this.aWC = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913302));
        release();
    }

    public void release() {
        this.aWD = null;
        if (this.aWE != null) {
            this.aWE.release();
        }
    }

    private void Dv() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity();
        } else if (this.aWD != null) {
            f fVar = new f(this.aWD.Dx(), this.aWD.getUserId(), true, BdUniqueId.gen());
            fVar.setFrom("live_show_perference");
            com.baidu.live.view.a.Xr().a(this.aWD.getUserId(), fVar);
        }
    }

    private void Dw() {
        if (this.aWD != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), this.aWD.getUserId())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fU(String str) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str)) {
            str = "操作失败";
        }
        BdUtilHelper.showToast(this.mContext, str, 0);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.aWC != null) {
            this.aWC.setVisibility(z ? 4 : 0);
        }
    }
}
