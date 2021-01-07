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
import com.baidu.live.data.f;
import com.baidu.live.data.x;
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
    private LiveFollowPendantView aWL;
    private b aWM;
    private Context mContext;
    private boolean aWO = false;
    private c.a aWP = new c.a() { // from class: com.baidu.live.follow.pendant.a.1
        @Override // com.baidu.live.follow.a.c.a
        public void a(boolean z, String str, boolean z2) {
            if (!z || a.this.aWL == null) {
                a.this.gF(str);
            } else if (!z2) {
                a.this.aWL.getFollowView().setVisibility(0);
            } else {
                a.this.aWL.getFollowView().setVisibility(8);
            }
            if (a.this.aWM != null) {
                a.this.aWM.by(z2);
            }
        }
    };
    private CustomMessageListener aWQ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.follow.pendant.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.aWL != null) {
                if (!updateAttentionMessage.isSucc()) {
                    a.this.gF(updateAttentionMessage.getData().usermsg);
                } else if (!updateAttentionMessage.isAttention() || a.this.mContext == null) {
                    a.this.aWL.getFollowView().setVisibility(0);
                } else {
                    BdUtilHelper.showToast(a.this.mContext, a.this.mContext.getString(a.h.sdk_attention_success), 0);
                    a.this.aWL.getFollowView().setVisibility(8);
                }
            }
        }
    };
    private com.baidu.live.follow.a.a aWN = new com.baidu.live.follow.a.a();

    public a(Context context) {
        this.mContext = context;
        this.aWL = new LiveFollowPendantView(context);
    }

    public void n(String str, String str2, String str3) {
        this.aWM = new b(str2, str, str3);
    }

    public boolean d(x xVar) {
        if (xVar == null || xVar.mLiveInfo == null) {
            return false;
        }
        return "1".equals(xVar.mLiveInfo.pubShowId);
    }

    public void m(ViewGroup viewGroup) {
        b(viewGroup, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean isDisplay() {
        return this.aWO;
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            if (viewGroup.getChildCount() > 0) {
                FX();
            }
            if (viewGroup.getVisibility() == 8 || viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
            }
            updateView();
            viewGroup.addView(this.aWL, layoutParams);
            registerListener();
            FW();
        }
    }

    public void FW() {
        if (TbadkCoreApplication.isLogin() && this.aWN != null && this.aWM != null) {
            this.aWN.at(this.aWM.getUserId(), "");
        }
    }

    private void updateView() {
        this.aWO = true;
        if (this.aWL != null && this.aWM != null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.aWL.getFollowView().setVisibility(0);
            } else {
                this.aWL.getFollowView().setVisibility(8);
            }
            this.aWL.setHeadImage(this.aWM.Ga());
            this.aWL.setNickName(j.J(this.aWM.getNickName(), 8));
        }
    }

    public void eg(int i) {
        if (this.aWL != null) {
            if (this.aWL.getParent() != null) {
                ((ViewGroup) this.aWL.getParent()).setVisibility(i);
                ((ViewGroup) this.aWL.getParent()).removeView(this.aWL);
            }
            unRegisterListener();
            release();
        }
        this.aWO = false;
    }

    public void FX() {
        eg(8);
    }

    public void registerListener() {
        if (this.aWL != null) {
            this.aWL.c(this);
        }
        if (this.aWN != null) {
            this.aWN.a(this.aWP);
        }
        MessageManager.getInstance().registerListener(this.aWQ);
    }

    public void unRegisterListener() {
        if (this.aWL != null) {
            this.aWL.setOnClickListener(null);
        }
        MessageManager.getInstance().unRegisterListener(this.aWQ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aWL != null) {
            if (view == this.aWL.getFollowView()) {
                FY();
            } else if (view == this.aWL.getNickNameView() || view == this.aWL.getHeadView()) {
                FZ();
            }
        }
    }

    public void onDestroy() {
        this.aWL = null;
        release();
    }

    public void release() {
        this.aWM = null;
        if (this.aWN != null) {
            this.aWN.release();
        }
    }

    private void FY() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity();
        } else if (this.aWM != null) {
            f fVar = new f(this.aWM.Ga(), this.aWM.getUserId(), true, BdUniqueId.gen());
            fVar.setFrom("live_show_perference");
            com.baidu.live.view.a.Zy().a(this.aWM.getUserId(), fVar);
        }
    }

    private void FZ() {
        if (this.aWM != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), this.aWM.getUserId())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(String str) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str)) {
            str = "操作失败";
        }
        BdUtilHelper.showToast(this.mContext, str, 0);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.aWL != null) {
            this.aWL.setVisibility(z ? 4 : 0);
        }
    }
}
