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
    private ActiveCenterData dSb;
    private boolean dSc;
    private boolean dSd;
    private boolean dSe;
    private final e dSf;
    private final f dSg;
    private final h dSh;
    private final a dSi;
    private final g dSj;
    private final c dSk;
    private final b dSl;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static q dSt = new q();
    }

    public static q aZL() {
        return i.dSt;
    }

    private q() {
        this.dSc = false;
        this.dSd = true;
        this.dSe = false;
        this.dSf = new e(12);
        this.dSg = new f(6);
        this.dSh = new h(10);
        this.dSi = new a(7);
        this.dSj = new g(5);
        this.dSk = new c(9);
        this.dSl = new b(13);
        if (com.baidu.tbadk.BdToken.c.aZe().aZl()) {
            this.dSd = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.dSd = true;
        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void aZM() {
        if (!this.dSe && com.baidu.tbadk.BdToken.c.aZe().aZh()) {
            this.dSe = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.dSb = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.a.lf().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                dM(currentActivity);
            }
        }
    }

    public void hv(boolean z) {
        this.dSc = z;
    }

    public void hw(boolean z) {
        this.dSd = z;
        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_delete_mission_home_entrance", z);
    }

    public boolean aZN() {
        return this.dSd;
    }

    public ActiveCenterData aZO() {
        return this.dSb;
    }

    public void aZP() {
        if (this.dSb != null && this.dSb.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.dSb.mission;
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

    public boolean aZQ() {
        return this.dSb != null && this.dSb.is_new_window;
    }

    public void dM(Context context) {
        if (isValid()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissionCustomDialogActivityConfig(context)));
            aZS();
            com.baidu.tbadk.core.sharedPref.b.bjf().putLong("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new aq("c13742").ai("obj_source", com.baidu.tbadk.BdToken.c.aZe().aZj() ? 2 : 1).ai("obj_type", 1));
        }
    }

    private boolean isValid() {
        return (this.dSb == null || this.dSb.mission == null || !aZQ() || aZR() || this.dSc) ? false : true;
    }

    private boolean aZR() {
        int i2;
        if (aZO() != null && (i2 = aZO().win_jump_time) > 0) {
            if (com.baidu.tbadk.BdToken.c.aZe().aZm()) {
                return com.baidu.tbadk.core.sharedPref.b.bjf().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            com.baidu.tbadk.core.sharedPref.b.bjf().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    private void aZS() {
        com.baidu.tbadk.core.sharedPref.b.bjf().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, com.baidu.tbadk.core.sharedPref.b.bjf().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public e aZT() {
        return this.dSf;
    }

    public f aZU() {
        return this.dSg;
    }

    public h aZV() {
        return this.dSh;
    }

    public a aZW() {
        return this.dSi;
    }

    public g aZX() {
        return this.dSj;
    }

    public c aZY() {
        return this.dSk;
    }

    public b aZZ() {
        return this.dSl;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.dSb != null) {
            int curTaskType = this.dSb.getCurTaskType();
            if (curTaskType == 12) {
                aZT().e(tbPageContext);
                aZT().baa();
            } else if (curTaskType == 6) {
                aZU().e(tbPageContext);
            } else if (curTaskType == 10) {
                aZV().e(tbPageContext);
                aZV().baa();
            } else if (curTaskType == 7) {
                aZW().e(tbPageContext);
            } else if (curTaskType == 5) {
                aZX().e(tbPageContext);
            } else if (curTaskType == 9) {
                aZY().e(tbPageContext);
            } else if (curTaskType == 13) {
                aZZ().e(tbPageContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends d {
        private s dSq;

        public e(int i) {
            super(i);
            this.dSq = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.dSq != null && q.this.dSb != null) {
                be.bkp().b(tbPageContext, new String[]{q.this.dSb.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.dSq != null && q.this.dSb != null) {
                this.dSq.bae();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d {
        private boolean dSr;

        public f(int i) {
            super(i);
            this.dSr = false;
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
            if (areNotificationsEnabled() && !this.dSr) {
                q.this.aZP();
                this.dSr = true;
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
            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.q.h.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.e.b.r(tbPageContext.getPageActivity(), 1);
                }
            }, 100L);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            q.this.aZP();
        }
    }

    /* loaded from: classes.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.dSb != null && q.this.dSb.mission != null) {
                be.bkp().b(tbPageContext, new String[]{q.this.dSb.mission.final_reward_url});
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
            if (q.this.dSb != null && q.this.dSb.mission != null) {
                be.bkp().b(tbPageContext, new String[]{q.this.dSb.mission.final_reward_url});
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
            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.q.c.1
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
            if (q.this.dSb != null && q.this.dSb.mission != null) {
                be.bkp().b(tbPageContext, new String[]{q.this.dSb.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class d {
        private int dSp;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.dSp = i;
        }

        public void e(TbPageContext<?> tbPageContext) {
            if (bab()) {
                d(tbPageContext);
            }
        }

        public void baa() {
            if (bab()) {
                complete();
            }
        }

        protected boolean bab() {
            return (q.this.dSb == null || q.this.dSb.mission == null || q.this.dSb.getCurTaskType() != this.dSp) ? false : true;
        }
    }
}
