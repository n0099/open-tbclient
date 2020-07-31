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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private ActiveCenterData dGJ;
    private boolean dGK;
    private boolean dGL;
    private boolean dGM;
    private final e dGN;
    private final f dGO;
    private final h dGP;
    private final a dGQ;
    private final g dGR;
    private final c dGS;
    private final b dGT;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static q dHb = new q();
    }

    public static q aQI() {
        return i.dHb;
    }

    private q() {
        this.dGK = false;
        this.dGL = true;
        this.dGM = false;
        this.dGN = new e(12);
        this.dGO = new f(6);
        this.dGP = new h(10);
        this.dGQ = new a(7);
        this.dGR = new g(5);
        this.dGS = new c(9);
        this.dGT = new b(13);
        if (com.baidu.tbadk.BdToken.c.aQc().aQi()) {
            this.dGL = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.dGL = true;
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void aQJ() {
        if (!this.dGM && com.baidu.tbadk.BdToken.c.aQc().aQe()) {
            this.dGM = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.dGJ = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.a.jC().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                dG(currentActivity);
            }
        }
    }

    public void hb(boolean z) {
        this.dGK = z;
    }

    public void hc(boolean z) {
        this.dGL = z;
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("key_delete_mission_home_entrance", z);
    }

    public boolean aQK() {
        return this.dGL;
    }

    public ActiveCenterData aQL() {
        return this.dGJ;
    }

    public void aQM() {
        if (this.dGJ != null && this.dGJ.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.dGJ.mission;
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

    public boolean aQN() {
        return this.dGJ != null && this.dGJ.is_new_window;
    }

    public void dG(Context context) {
        if (isValid()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissionCustomDialogActivityConfig(context)));
            aQP();
            com.baidu.tbadk.core.sharedPref.b.aZP().putLong("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new ap("c13742").ah("obj_source", com.baidu.tbadk.BdToken.c.aQc().aQg() ? 2 : 1).ah("obj_type", 1));
        }
    }

    private boolean isValid() {
        return (this.dGJ == null || this.dGJ.mission == null || !aQN() || aQO() || this.dGK) ? false : true;
    }

    private boolean aQO() {
        int i2;
        if (aQL() != null && (i2 = aQL().win_jump_time) > 0) {
            if (com.baidu.tbadk.BdToken.c.aQc().aQj()) {
                return com.baidu.tbadk.core.sharedPref.b.aZP().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            com.baidu.tbadk.core.sharedPref.b.aZP().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    private void aQP() {
        com.baidu.tbadk.core.sharedPref.b.aZP().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, com.baidu.tbadk.core.sharedPref.b.aZP().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public e aQQ() {
        return this.dGN;
    }

    public f aQR() {
        return this.dGO;
    }

    public h aQS() {
        return this.dGP;
    }

    public a aQT() {
        return this.dGQ;
    }

    public g aQU() {
        return this.dGR;
    }

    public c aQV() {
        return this.dGS;
    }

    public b aQW() {
        return this.dGT;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.dGJ != null) {
            int curTaskType = this.dGJ.getCurTaskType();
            if (curTaskType == 12) {
                aQQ().e(tbPageContext);
                aQQ().aQX();
            } else if (curTaskType == 6) {
                aQR().e(tbPageContext);
            } else if (curTaskType == 10) {
                aQS().e(tbPageContext);
                aQS().aQX();
            } else if (curTaskType == 7) {
                aQT().e(tbPageContext);
            } else if (curTaskType == 5) {
                aQU().e(tbPageContext);
            } else if (curTaskType == 9) {
                aQV().e(tbPageContext);
            } else if (curTaskType == 13) {
                aQW().e(tbPageContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends d {
        private s dGY;

        public e(int i) {
            super(i);
            this.dGY = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.dGY != null && q.this.dGJ != null) {
                bd.baV().b(tbPageContext, new String[]{q.this.dGJ.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.dGY != null && q.this.dGJ != null) {
                this.dGY.aRb();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d {
        private boolean dGZ;

        public f(int i) {
            super(i);
            this.dGZ = false;
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
            if (areNotificationsEnabled() && !this.dGZ) {
                q.this.aQM();
                this.dGZ = true;
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
            q.this.aQM();
        }
    }

    /* loaded from: classes.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.dGJ != null && q.this.dGJ.mission != null) {
                bd.baV().b(tbPageContext, new String[]{q.this.dGJ.mission.final_reward_url});
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
            if (q.this.dGJ != null && q.this.dGJ.mission != null) {
                bd.baV().b(tbPageContext, new String[]{q.this.dGJ.mission.final_reward_url});
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
            if (q.this.dGJ != null && q.this.dGJ.mission != null) {
                bd.baV().b(tbPageContext, new String[]{q.this.dGJ.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class d {
        private int dGX;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.dGX = i;
        }

        public void e(TbPageContext<?> tbPageContext) {
            if (aQY()) {
                d(tbPageContext);
            }
        }

        public void aQX() {
            if (aQY()) {
                complete();
            }
        }

        protected boolean aQY() {
            return (q.this.dGJ == null || q.this.dGJ.mission == null || q.this.dGJ.getCurTaskType() != this.dGX) ? false : true;
        }
    }
}
