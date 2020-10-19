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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private ActiveCenterData eec;
    private boolean eed;
    private boolean eee;
    private boolean eef;
    private final e eeg;
    private final f eeh;
    private final h eei;
    private final a eej;
    private final g eek;
    private final c eel;
    private final b eem;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static q eeu = new q();
    }

    public static q bct() {
        return i.eeu;
    }

    private q() {
        this.eed = false;
        this.eee = true;
        this.eef = false;
        this.eeg = new e(12);
        this.eeh = new f(6);
        this.eei = new h(10);
        this.eej = new a(7);
        this.eek = new g(5);
        this.eel = new c(9);
        this.eem = new b(13);
        if (com.baidu.tbadk.BdToken.c.bbM().bbT()) {
            this.eee = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.eee = true;
        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void bcu() {
        if (!this.eef && com.baidu.tbadk.BdToken.c.bbM().bbP()) {
            this.eef = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.eec = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.a.lg().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                dS(currentActivity);
            }
        }
    }

    public void hR(boolean z) {
        this.eed = z;
    }

    public void hS(boolean z) {
        this.eee = z;
        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("key_delete_mission_home_entrance", z);
    }

    public boolean bcv() {
        return this.eee;
    }

    public ActiveCenterData bcw() {
        return this.eec;
    }

    public void bcx() {
        if (this.eec != null && this.eec.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.eec.mission;
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

    public boolean bcy() {
        return this.eec != null && this.eec.is_new_window;
    }

    public void dS(Context context) {
        if (isValid()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissionCustomDialogActivityConfig(context)));
            bcA();
            com.baidu.tbadk.core.sharedPref.b.blO().putLong("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new aq("c13742").aj("obj_source", com.baidu.tbadk.BdToken.c.bbM().bbR() ? 2 : 1).aj("obj_type", 1));
        }
    }

    private boolean isValid() {
        return (this.eec == null || this.eec.mission == null || !bcy() || bcz() || this.eed) ? false : true;
    }

    private boolean bcz() {
        int i2;
        if (bcw() != null && (i2 = bcw().win_jump_time) > 0) {
            if (com.baidu.tbadk.BdToken.c.bbM().bbU()) {
                return com.baidu.tbadk.core.sharedPref.b.blO().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            com.baidu.tbadk.core.sharedPref.b.blO().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    private void bcA() {
        com.baidu.tbadk.core.sharedPref.b.blO().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, com.baidu.tbadk.core.sharedPref.b.blO().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public e bcB() {
        return this.eeg;
    }

    public f bcC() {
        return this.eeh;
    }

    public h bcD() {
        return this.eei;
    }

    public a bcE() {
        return this.eej;
    }

    public g bcF() {
        return this.eek;
    }

    public c bcG() {
        return this.eel;
    }

    public b bcH() {
        return this.eem;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.eec != null) {
            int curTaskType = this.eec.getCurTaskType();
            if (curTaskType == 12) {
                bcB().e(tbPageContext);
                bcB().bcI();
            } else if (curTaskType == 6) {
                bcC().e(tbPageContext);
            } else if (curTaskType == 10) {
                bcD().e(tbPageContext);
                bcD().bcI();
            } else if (curTaskType == 7) {
                bcE().e(tbPageContext);
            } else if (curTaskType == 5) {
                bcF().e(tbPageContext);
            } else if (curTaskType == 9) {
                bcG().e(tbPageContext);
            } else if (curTaskType == 13) {
                bcH().e(tbPageContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends d {
        private s eer;

        public e(int i) {
            super(i);
            this.eer = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.eer != null && q.this.eec != null) {
                be.bmY().b(tbPageContext, new String[]{q.this.eec.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.eer != null && q.this.eec != null) {
                this.eer.bcM();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d {
        private boolean ees;

        public f(int i) {
            super(i);
            this.ees = false;
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
            if (areNotificationsEnabled() && !this.ees) {
                q.this.bcx();
                this.ees = true;
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
            q.this.bcx();
        }
    }

    /* loaded from: classes.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.eec != null && q.this.eec.mission != null) {
                be.bmY().b(tbPageContext, new String[]{q.this.eec.mission.final_reward_url});
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
            if (q.this.eec != null && q.this.eec.mission != null) {
                be.bmY().b(tbPageContext, new String[]{q.this.eec.mission.final_reward_url});
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
            if (q.this.eec != null && q.this.eec.mission != null) {
                be.bmY().b(tbPageContext, new String[]{q.this.eec.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class d {
        private int eeq;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.eeq = i;
        }

        public void e(TbPageContext<?> tbPageContext) {
            if (bcJ()) {
                d(tbPageContext);
            }
        }

        public void bcI() {
            if (bcJ()) {
                complete();
            }
        }

        protected boolean bcJ() {
            return (q.this.eec == null || q.this.eec.mission == null || q.this.eec.getCurTaskType() != this.eeq) ? false : true;
        }
    }
}
