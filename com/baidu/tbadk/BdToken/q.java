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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private ActiveCenterData dAN;
    private boolean dAO;
    private boolean dAP;
    private boolean dAQ;
    private final e dAR;
    private final f dAS;
    private final h dAT;
    private final a dAU;
    private final g dAV;
    private final c dAW;
    private final b dAX;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static q dBf = new q();
    }

    public static q aMU() {
        return i.dBf;
    }

    private q() {
        this.dAO = false;
        this.dAP = true;
        this.dAQ = false;
        this.dAR = new e(12);
        this.dAS = new f(6);
        this.dAT = new h(10);
        this.dAU = new a(7);
        this.dAV = new g(5);
        this.dAW = new c(9);
        this.dAX = new b(13);
        if (com.baidu.tbadk.BdToken.c.aMo().aMu()) {
            this.dAP = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.dAP = true;
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void aMV() {
        if (!this.dAQ && com.baidu.tbadk.BdToken.c.aMo().aMq()) {
            this.dAQ = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.dAN = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.a.jC().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                dC(currentActivity);
            }
        }
    }

    public void gG(boolean z) {
        this.dAO = z;
    }

    public void gH(boolean z) {
        this.dAP = z;
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_delete_mission_home_entrance", z);
    }

    public boolean aMW() {
        return this.dAP;
    }

    public ActiveCenterData aMX() {
        return this.dAN;
    }

    public void aMY() {
        if (this.dAN != null && this.dAN.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.dAN.mission;
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

    public boolean aMZ() {
        return this.dAN != null && this.dAN.is_new_window;
    }

    public void dC(Context context) {
        if (isValid()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissionCustomDialogActivityConfig(context)));
            aNb();
            com.baidu.tbadk.core.sharedPref.b.aVP().putLong("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new ao("c13742").ag("obj_source", com.baidu.tbadk.BdToken.c.aMo().aMs() ? 2 : 1).ag("obj_type", 1));
        }
    }

    private boolean isValid() {
        return (this.dAN == null || this.dAN.mission == null || !aMZ() || aNa() || this.dAO) ? false : true;
    }

    private boolean aNa() {
        int i2;
        if (aMX() != null && (i2 = aMX().win_jump_time) > 0) {
            if (com.baidu.tbadk.BdToken.c.aMo().aMv()) {
                return com.baidu.tbadk.core.sharedPref.b.aVP().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            com.baidu.tbadk.core.sharedPref.b.aVP().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    private void aNb() {
        com.baidu.tbadk.core.sharedPref.b.aVP().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, com.baidu.tbadk.core.sharedPref.b.aVP().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public e aNc() {
        return this.dAR;
    }

    public f aNd() {
        return this.dAS;
    }

    public h aNe() {
        return this.dAT;
    }

    public a aNf() {
        return this.dAU;
    }

    public g aNg() {
        return this.dAV;
    }

    public c aNh() {
        return this.dAW;
    }

    public b aNi() {
        return this.dAX;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.dAN != null) {
            int curTaskType = this.dAN.getCurTaskType();
            if (curTaskType == 12) {
                aNc().e(tbPageContext);
                aNc().aNj();
            } else if (curTaskType == 6) {
                aNd().e(tbPageContext);
            } else if (curTaskType == 10) {
                aNe().e(tbPageContext);
                aNe().aNj();
            } else if (curTaskType == 7) {
                aNf().e(tbPageContext);
            } else if (curTaskType == 5) {
                aNg().e(tbPageContext);
            } else if (curTaskType == 9) {
                aNh().e(tbPageContext);
            } else if (curTaskType == 13) {
                aNi().e(tbPageContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends d {
        private s dBc;

        public e(int i) {
            super(i);
            this.dBc = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.dBc != null && q.this.dAN != null) {
                bc.aWU().b(tbPageContext, new String[]{q.this.dAN.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.dBc != null && q.this.dAN != null) {
                this.dBc.aNn();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d {
        private boolean dBd;

        public f(int i) {
            super(i);
            this.dBd = false;
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
            if (areNotificationsEnabled() && !this.dBd) {
                q.this.aMY();
                this.dBd = true;
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
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.q.h.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.e.b.q(tbPageContext.getPageActivity(), 1);
                }
            }, 100L);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            q.this.aMY();
        }
    }

    /* loaded from: classes.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.dAN != null && q.this.dAN.mission != null) {
                bc.aWU().b(tbPageContext, new String[]{q.this.dAN.mission.final_reward_url});
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
            if (q.this.dAN != null && q.this.dAN.mission != null) {
                bc.aWU().b(tbPageContext, new String[]{q.this.dAN.mission.final_reward_url});
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
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.q.c.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.e.b.q(tbPageContext.getPageActivity(), 1);
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
            if (q.this.dAN != null && q.this.dAN.mission != null) {
                bc.aWU().b(tbPageContext, new String[]{q.this.dAN.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class d {
        private int dBb;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.dBb = i;
        }

        public void e(TbPageContext<?> tbPageContext) {
            if (aNk()) {
                d(tbPageContext);
            }
        }

        public void aNj() {
            if (aNk()) {
                complete();
            }
        }

        protected boolean aNk() {
            return (q.this.dAN == null || q.this.dAN.mission == null || q.this.dAN.getCurTaskType() != this.dBb) ? false : true;
        }
    }
}
