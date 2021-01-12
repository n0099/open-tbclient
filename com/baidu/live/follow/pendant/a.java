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
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private LiveFollowPendantView aRY;
    private b aRZ;
    private Context mContext;
    private boolean aSb = false;
    private c.a aSc = new c.a() { // from class: com.baidu.live.follow.pendant.a.1
        @Override // com.baidu.live.follow.a.c.a
        public void a(boolean z, String str, boolean z2) {
            if (!z || a.this.aRY == null) {
                a.this.ft(str);
            } else if (!z2) {
                a.this.aRY.getFollowView().setVisibility(0);
            } else {
                a.this.aRY.getFollowView().setVisibility(8);
            }
            if (a.this.aRZ != null) {
                a.this.aRZ.bu(z2);
            }
        }
    };
    private CustomMessageListener aSd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.follow.pendant.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.aRY != null) {
                if (!updateAttentionMessage.isSucc()) {
                    a.this.ft(updateAttentionMessage.getData().usermsg);
                } else if (!updateAttentionMessage.isAttention() || a.this.mContext == null) {
                    a.this.aRY.getFollowView().setVisibility(0);
                } else {
                    BdUtilHelper.showToast(a.this.mContext, a.this.mContext.getString(a.h.sdk_attention_success), 0);
                    a.this.aRY.getFollowView().setVisibility(8);
                }
            }
        }
    };
    private com.baidu.live.follow.a.a aSa = new com.baidu.live.follow.a.a();

    public a(Context context) {
        this.mContext = context;
        this.aRY = new LiveFollowPendantView(context);
    }

    public void m(String str, String str2, String str3) {
        this.aRZ = new b(str2, str, str3);
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
        return this.aSb;
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            if (viewGroup.getChildCount() > 0) {
                Cc();
            }
            if (viewGroup.getVisibility() == 8 || viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
            }
            updateView();
            viewGroup.addView(this.aRY, layoutParams);
            registerListener();
            Cb();
        }
    }

    public void Cb() {
        if (TbadkCoreApplication.isLogin() && this.aSa != null && this.aRZ != null) {
            this.aSa.as(this.aRZ.getUserId(), "");
        }
    }

    private void updateView() {
        this.aSb = true;
        if (this.aRY != null && this.aRZ != null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.aRY.getFollowView().setVisibility(0);
            } else {
                this.aRY.getFollowView().setVisibility(8);
            }
            this.aRY.setHeadImage(this.aRZ.Cf());
            this.aRY.setNickName(j.J(this.aRZ.getNickName(), 8));
        }
    }

    public void cA(int i) {
        if (this.aRY != null) {
            if (this.aRY.getParent() != null) {
                ((ViewGroup) this.aRY.getParent()).setVisibility(i);
                ((ViewGroup) this.aRY.getParent()).removeView(this.aRY);
            }
            unRegisterListener();
            release();
        }
        this.aSb = false;
    }

    public void Cc() {
        cA(8);
    }

    public void registerListener() {
        if (this.aRY != null) {
            this.aRY.c(this);
        }
        if (this.aSa != null) {
            this.aSa.a(this.aSc);
        }
        MessageManager.getInstance().registerListener(this.aSd);
    }

    public void unRegisterListener() {
        if (this.aRY != null) {
            this.aRY.setOnClickListener(null);
        }
        MessageManager.getInstance().unRegisterListener(this.aSd);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aRY != null) {
            if (view == this.aRY.getFollowView()) {
                Cd();
            } else if (view == this.aRY.getNickNameView() || view == this.aRY.getHeadView()) {
                Ce();
            }
        }
    }

    public void onDestroy() {
        this.aRY = null;
        release();
    }

    public void release() {
        this.aRZ = null;
        if (this.aSa != null) {
            this.aSa.release();
        }
    }

    private void Cd() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity();
        } else if (this.aRZ != null) {
            f fVar = new f(this.aRZ.Cf(), this.aRZ.getUserId(), true, BdUniqueId.gen());
            fVar.setFrom("live_show_perference");
            com.baidu.live.view.a.VF().a(this.aRZ.getUserId(), fVar);
        }
    }

    private void Ce() {
        if (this.aRZ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), this.aRZ.getUserId())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ft(String str) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str)) {
            str = "操作失败";
        }
        BdUtilHelper.showToast(this.mContext, str, 0);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.aRY != null) {
            this.aRY.setVisibility(z ? 4 : 0);
        }
    }
}
