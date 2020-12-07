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
    private ActiveCenterData exP;
    private boolean exQ;
    private boolean exR;
    private boolean exS;
    private final e exT;
    private final f exU;
    private final h exV;
    private final a exW;
    private final g exX;
    private final c exY;
    private final b exZ;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static q eyi = new q();
    }

    public static q bjk() {
        return i.eyi;
    }

    private q() {
        this.exQ = false;
        this.exR = true;
        this.exS = false;
        this.exT = new e(12);
        this.exU = new f(6);
        this.exV = new h(10);
        this.exW = new a(7);
        this.exX = new g(5);
        this.exY = new c(9);
        this.exZ = new b(13);
        if (com.baidu.tbadk.BdToken.c.biD().biK()) {
            this.exR = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.exR = true;
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void bjl() {
        if (!this.exS && com.baidu.tbadk.BdToken.c.biD().biG()) {
            this.exS = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.exP = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.a.lg().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                ex(currentActivity);
            }
        }
    }

    public void iF(boolean z) {
        this.exQ = z;
    }

    public boolean bjm() {
        return this.exR;
    }

    public ActiveCenterData bjn() {
        return this.exP;
    }

    public void bjo() {
        if (this.exP != null && this.exP.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.exP.mission;
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

    public boolean bjp() {
        return this.exP != null && this.exP.is_new_window;
    }

    public void ex(Context context) {
        if (isValid()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissionCustomDialogActivityConfig(context)));
            bjr();
            com.baidu.tbadk.core.sharedPref.b.bsO().putLong("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new ar("c13742").al("obj_source", com.baidu.tbadk.BdToken.c.biD().biI() ? 2 : 1).al("obj_type", 1));
        }
    }

    private boolean isValid() {
        return (this.exP == null || this.exP.mission == null || !bjp() || bjq() || this.exQ) ? false : true;
    }

    private boolean bjq() {
        int i2;
        if (bjn() != null && (i2 = bjn().win_jump_time) > 0) {
            if (com.baidu.tbadk.BdToken.c.biD().biL()) {
                return com.baidu.tbadk.core.sharedPref.b.bsO().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            com.baidu.tbadk.core.sharedPref.b.bsO().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    private void bjr() {
        com.baidu.tbadk.core.sharedPref.b.bsO().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, com.baidu.tbadk.core.sharedPref.b.bsO().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public e bjs() {
        return this.exT;
    }

    public f bjt() {
        return this.exU;
    }

    public h bju() {
        return this.exV;
    }

    public a bjv() {
        return this.exW;
    }

    public g bjw() {
        return this.exX;
    }

    public c bjx() {
        return this.exY;
    }

    public b bjy() {
        return this.exZ;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.exP != null) {
            int curTaskType = this.exP.getCurTaskType();
            if (curTaskType == 12) {
                bjs().e(tbPageContext);
                bjs().bjz();
            } else if (curTaskType == 6) {
                bjt().e(tbPageContext);
            } else if (curTaskType == 10) {
                bju().e(tbPageContext);
                bju().bjz();
            } else if (curTaskType == 7) {
                bjv().e(tbPageContext);
            } else if (curTaskType == 5) {
                bjw().e(tbPageContext);
            } else if (curTaskType == 9) {
                bjx().e(tbPageContext);
            } else if (curTaskType == 13) {
                bjy().e(tbPageContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends d {
        private s eyf;

        public e(int i) {
            super(i);
            this.eyf = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.eyf != null && q.this.exP != null) {
                bf.bua().b(tbPageContext, new String[]{q.this.exP.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.eyf != null && q.this.exP != null) {
                this.eyf.bjD();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d {
        private boolean eyg;

        public f(int i) {
            super(i);
            this.eyg = false;
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
            if (areNotificationsEnabled() && !this.eyg) {
                q.this.bjo();
                this.eyg = true;
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
                    com.baidu.tbadk.core.e.b.A(tbPageContext.getPageActivity(), 1);
                }
            }, 100L);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            q.this.bjo();
        }
    }

    /* loaded from: classes.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.exP != null && q.this.exP.mission != null) {
                bf.bua().b(tbPageContext, new String[]{q.this.exP.mission.final_reward_url});
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
            if (q.this.exP != null && q.this.exP.mission != null) {
                bf.bua().b(tbPageContext, new String[]{q.this.exP.mission.final_reward_url});
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
                    com.baidu.tbadk.core.e.b.A(tbPageContext.getPageActivity(), 1);
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
            if (q.this.exP != null && q.this.exP.mission != null) {
                bf.bua().b(tbPageContext, new String[]{q.this.exP.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class d {
        private int eyd;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.eyd = i;
        }

        public void e(TbPageContext<?> tbPageContext) {
            if (bjA()) {
                d(tbPageContext);
            }
        }

        public void bjz() {
            if (bjA()) {
                complete();
            }
        }

        protected boolean bjA() {
            return (q.this.exP == null || q.this.exP.mission == null || q.this.exP.getCurTaskType() != this.eyd) ? false : true;
        }
    }
}
