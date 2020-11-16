package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MissionCustomDialogActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private ActiveCenterData eqN;
    private boolean eqO;
    private boolean eqP;
    private boolean eqQ;
    private final e eqR;
    private final f eqS;
    private final h eqT;
    private final a eqU;
    private final g eqV;
    private final c eqW;
    private final b eqX;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static q erf = new q();
    }

    public static q bgf() {
        return i.erf;
    }

    private q() {
        this.eqO = false;
        this.eqP = true;
        this.eqQ = false;
        this.eqR = new e(12);
        this.eqS = new f(6);
        this.eqT = new h(10);
        this.eqU = new a(7);
        this.eqV = new g(5);
        this.eqW = new c(9);
        this.eqX = new b(13);
        if (com.baidu.tbadk.BdToken.c.bfy().bfF()) {
            this.eqP = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.eqP = true;
        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void bgg() {
        if (!this.eqQ && com.baidu.tbadk.BdToken.c.bfy().bfB()) {
            this.eqQ = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.eqN = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.a.lg().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                dS(currentActivity);
            }
        }
    }

    public void iq(boolean z) {
        this.eqO = z;
    }

    public boolean bgh() {
        return this.eqP;
    }

    public ActiveCenterData bgi() {
        return this.eqN;
    }

    public void bgj() {
        if (this.eqN != null && this.eqN.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.eqN.mission;
            int i2 = activeCenterMissionData.active_id;
            int i3 = activeCenterMissionData.mission_id;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(String.valueOf(i2), String.valueOf(i3));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            String jSONObject2 = jSONObject.toString();
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
            completeTaskReqMsg.completeId = jSONObject2;
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    public boolean bgk() {
        return this.eqN != null && this.eqN.is_new_window;
    }

    public void dS(Context context) {
        if (isValid()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissionCustomDialogActivityConfig(context)));
            bgm();
            com.baidu.tbadk.core.sharedPref.b.bpu().putLong("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new ar("c13742").ak("obj_source", com.baidu.tbadk.BdToken.c.bfy().bfD() ? 2 : 1).ak("obj_type", 1));
        }
    }

    private boolean isValid() {
        return (this.eqN == null || this.eqN.mission == null || !bgk() || bgl() || this.eqO) ? false : true;
    }

    private boolean bgl() {
        int i2;
        if (bgi() != null && (i2 = bgi().win_jump_time) > 0) {
            if (com.baidu.tbadk.BdToken.c.bfy().bfG()) {
                return com.baidu.tbadk.core.sharedPref.b.bpu().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            com.baidu.tbadk.core.sharedPref.b.bpu().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    private void bgm() {
        com.baidu.tbadk.core.sharedPref.b.bpu().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, com.baidu.tbadk.core.sharedPref.b.bpu().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public e bgn() {
        return this.eqR;
    }

    public f bgo() {
        return this.eqS;
    }

    public h bgp() {
        return this.eqT;
    }

    public a bgq() {
        return this.eqU;
    }

    public g bgr() {
        return this.eqV;
    }

    public c bgs() {
        return this.eqW;
    }

    public b bgt() {
        return this.eqX;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.eqN != null) {
            int curTaskType = this.eqN.getCurTaskType();
            if (curTaskType == 12) {
                bgn().e(tbPageContext);
                bgn().bgu();
            } else if (curTaskType == 6) {
                bgo().e(tbPageContext);
            } else if (curTaskType == 10) {
                bgp().e(tbPageContext);
                bgp().bgu();
            } else if (curTaskType == 7) {
                bgq().e(tbPageContext);
            } else if (curTaskType == 5) {
                bgr().e(tbPageContext);
            } else if (curTaskType == 9) {
                bgs().e(tbPageContext);
            } else if (curTaskType == 13) {
                bgt().e(tbPageContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends d {
        private s erc;

        public e(int i) {
            super(i);
            this.erc = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.erc != null && q.this.eqN != null) {
                bf.bqF().b(tbPageContext, new String[]{q.this.eqN.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.erc != null && q.this.eqN != null) {
                this.erc.bgy();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d {
        private boolean erd;

        public f(int i) {
            super(i);
            this.erd = false;
        }

        public boolean areNotificationsEnabled() {
            return NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            Activity pageActivity = tbPageContext.getPageActivity();
            try {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                if (Build.VERSION.SDK_INT >= 9) {
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", pageActivity.getPackageName(), null));
                }
                pageActivity.startActivity(intent);
            } catch (Exception e) {
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        public void complete() {
            if (areNotificationsEnabled() && !this.erd) {
                q.this.bgj();
                this.erd = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public class h extends d {
        public h(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(final TbPageContext<?> tbPageContext) {
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.q.h.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.e.b.r(tbPageContext.getPageActivity(), 1);
                }
            }, 100L);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            q.this.bgj();
        }
    }

    /* loaded from: classes.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.eqN != null && q.this.eqN.mission != null) {
                bf.bqF().b(tbPageContext, new String[]{q.this.eqN.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public class g extends d {
        public g(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.eqN != null && q.this.eqN.mission != null) {
                bf.bqF().b(tbPageContext, new String[]{q.this.eqN.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public class c extends d {
        public c(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(final TbPageContext<?> tbPageContext) {
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.q.c.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.e.b.r(tbPageContext.getPageActivity(), 1);
                }
            }, 100L);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public class b extends d {
        public b(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.eqN != null && q.this.eqN.mission != null) {
                bf.bqF().b(tbPageContext, new String[]{q.this.eqN.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class d {
        private int erb;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.erb = i;
        }

        public void e(TbPageContext<?> tbPageContext) {
            if (bgv()) {
                d(tbPageContext);
            }
        }

        public void bgu() {
            if (bgv()) {
                complete();
            }
        }

        protected boolean bgv() {
            return (q.this.eqN == null || q.this.eqN.mission == null || q.this.eqN.getCurTaskType() != this.erb) ? false : true;
        }
    }
}
