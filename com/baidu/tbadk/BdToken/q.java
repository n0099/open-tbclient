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
    private boolean emA;
    private boolean emB;
    private final e emC;
    private final f emD;
    private final h emE;
    private final a emF;
    private final g emG;
    private final c emH;
    private final b emI;
    private ActiveCenterData emy;
    private boolean emz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static q emQ = new q();
    }

    public static q bem() {
        return i.emQ;
    }

    private q() {
        this.emz = false;
        this.emA = true;
        this.emB = false;
        this.emC = new e(12);
        this.emD = new f(6);
        this.emE = new h(10);
        this.emF = new a(7);
        this.emG = new g(5);
        this.emH = new c(9);
        this.emI = new b(13);
        if (com.baidu.tbadk.BdToken.c.bdF().bdM()) {
            this.emA = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.emA = true;
        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void ben() {
        if (!this.emB && com.baidu.tbadk.BdToken.c.bdF().bdI()) {
            this.emB = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.emy = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.a.lg().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                dS(currentActivity);
            }
        }
    }

    public void ie(boolean z) {
        this.emz = z;
    }

    /* renamed from: if  reason: not valid java name */
    public void m36if(boolean z) {
        this.emA = z;
        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("key_delete_mission_home_entrance", z);
    }

    public boolean beo() {
        return this.emA;
    }

    public ActiveCenterData bep() {
        return this.emy;
    }

    public void beq() {
        if (this.emy != null && this.emy.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.emy.mission;
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

    public boolean ber() {
        return this.emy != null && this.emy.is_new_window;
    }

    public void dS(Context context) {
        if (isValid()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissionCustomDialogActivityConfig(context)));
            bet();
            com.baidu.tbadk.core.sharedPref.b.bnH().putLong("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new aq("c13742").aj("obj_source", com.baidu.tbadk.BdToken.c.bdF().bdK() ? 2 : 1).aj("obj_type", 1));
        }
    }

    private boolean isValid() {
        return (this.emy == null || this.emy.mission == null || !ber() || bes() || this.emz) ? false : true;
    }

    private boolean bes() {
        int i2;
        if (bep() != null && (i2 = bep().win_jump_time) > 0) {
            if (com.baidu.tbadk.BdToken.c.bdF().bdN()) {
                return com.baidu.tbadk.core.sharedPref.b.bnH().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            com.baidu.tbadk.core.sharedPref.b.bnH().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    private void bet() {
        com.baidu.tbadk.core.sharedPref.b.bnH().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, com.baidu.tbadk.core.sharedPref.b.bnH().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public e beu() {
        return this.emC;
    }

    public f bev() {
        return this.emD;
    }

    public h bew() {
        return this.emE;
    }

    public a bex() {
        return this.emF;
    }

    public g bey() {
        return this.emG;
    }

    public c bez() {
        return this.emH;
    }

    public b beA() {
        return this.emI;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.emy != null) {
            int curTaskType = this.emy.getCurTaskType();
            if (curTaskType == 12) {
                beu().e(tbPageContext);
                beu().beB();
            } else if (curTaskType == 6) {
                bev().e(tbPageContext);
            } else if (curTaskType == 10) {
                bew().e(tbPageContext);
                bew().beB();
            } else if (curTaskType == 7) {
                bex().e(tbPageContext);
            } else if (curTaskType == 5) {
                bey().e(tbPageContext);
            } else if (curTaskType == 9) {
                bez().e(tbPageContext);
            } else if (curTaskType == 13) {
                beA().e(tbPageContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends d {
        private s emN;

        public e(int i) {
            super(i);
            this.emN = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.emN != null && q.this.emy != null) {
                be.boR().b(tbPageContext, new String[]{q.this.emy.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.emN != null && q.this.emy != null) {
                this.emN.beF();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d {
        private boolean emO;

        public f(int i) {
            super(i);
            this.emO = false;
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
            if (areNotificationsEnabled() && !this.emO) {
                q.this.beq();
                this.emO = true;
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
            q.this.beq();
        }
    }

    /* loaded from: classes.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.emy != null && q.this.emy.mission != null) {
                be.boR().b(tbPageContext, new String[]{q.this.emy.mission.final_reward_url});
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
            if (q.this.emy != null && q.this.emy.mission != null) {
                be.boR().b(tbPageContext, new String[]{q.this.emy.mission.final_reward_url});
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
            if (q.this.emy != null && q.this.emy.mission != null) {
                be.boR().b(tbPageContext, new String[]{q.this.emy.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class d {
        private int emM;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.emM = i;
        }

        public void e(TbPageContext<?> tbPageContext) {
            if (beC()) {
                d(tbPageContext);
            }
        }

        public void beB() {
            if (beC()) {
                complete();
            }
        }

        protected boolean beC() {
            return (q.this.emy == null || q.this.emy.mission == null || q.this.emy.getCurTaskType() != this.emM) ? false : true;
        }
    }
}
