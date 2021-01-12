package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
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
    private final a eCA;
    private final g eCB;
    private final c eCC;
    private final b eCD;
    private ActiveCenterData eCt;
    private boolean eCu;
    private boolean eCv;
    private boolean eCw;
    private final e eCx;
    private final f eCy;
    private final h eCz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static q eCL = new q();
    }

    public static q bhH() {
        return i.eCL;
    }

    private q() {
        this.eCu = false;
        this.eCv = true;
        this.eCw = false;
        this.eCx = new e(12);
        this.eCy = new f(6);
        this.eCz = new h(10);
        this.eCA = new a(7);
        this.eCB = new g(5);
        this.eCC = new c(9);
        this.eCD = new b(13);
        if (com.baidu.tbadk.BdToken.c.bha().bhh()) {
            this.eCv = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.eCv = true;
        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void bhI() {
        if (!this.eCw && com.baidu.tbadk.BdToken.c.bha().bhd()) {
            this.eCw = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.eCt = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.b.kC().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                eO(currentActivity);
            }
        }
    }

    public void iW(boolean z) {
        this.eCu = z;
    }

    public boolean bhJ() {
        return this.eCv;
    }

    public ActiveCenterData bhK() {
        return this.eCt;
    }

    public void bhL() {
        if (this.eCt != null && this.eCt.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.eCt.mission;
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

    public boolean bhM() {
        return this.eCt != null && this.eCt.is_new_window;
    }

    public void eO(Context context) {
        if (isValid()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissionCustomDialogActivityConfig(context)));
            bhO();
            com.baidu.tbadk.core.sharedPref.b.brx().putLong("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new aq("c13742").an("obj_source", com.baidu.tbadk.BdToken.c.bha().bhf() ? 2 : 1).an("obj_type", 1));
        }
    }

    private boolean isValid() {
        return (this.eCt == null || this.eCt.mission == null || !bhM() || bhN() || this.eCu) ? false : true;
    }

    private boolean bhN() {
        int i2;
        if (bhK() != null && (i2 = bhK().win_jump_time) > 0) {
            if (com.baidu.tbadk.BdToken.c.bha().bhi()) {
                return com.baidu.tbadk.core.sharedPref.b.brx().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            com.baidu.tbadk.core.sharedPref.b.brx().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    private void bhO() {
        com.baidu.tbadk.core.sharedPref.b.brx().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, com.baidu.tbadk.core.sharedPref.b.brx().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public e bhP() {
        return this.eCx;
    }

    public f bhQ() {
        return this.eCy;
    }

    public h bhR() {
        return this.eCz;
    }

    public a bhS() {
        return this.eCA;
    }

    public g bhT() {
        return this.eCB;
    }

    public c bhU() {
        return this.eCC;
    }

    public b bhV() {
        return this.eCD;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.eCt != null) {
            int curTaskType = this.eCt.getCurTaskType();
            if (curTaskType == 12) {
                bhP().e(tbPageContext);
                bhP().bhW();
            } else if (curTaskType == 6) {
                bhQ().e(tbPageContext);
            } else if (curTaskType == 10) {
                bhR().e(tbPageContext);
                bhR().bhW();
            } else if (curTaskType == 7) {
                bhS().e(tbPageContext);
            } else if (curTaskType == 5) {
                bhT().e(tbPageContext);
            } else if (curTaskType == 9) {
                bhU().e(tbPageContext);
            } else if (curTaskType == 13) {
                bhV().e(tbPageContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends d {
        private s eCI;

        public e(int i) {
            super(i);
            this.eCI = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.eCI != null && q.this.eCt != null) {
                be.bsB().b(tbPageContext, new String[]{q.this.eCt.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.eCI != null && q.this.eCt != null) {
                this.eCI.bia();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d {
        private boolean eCJ;

        public f(int i) {
            super(i);
            this.eCJ = false;
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
            if (areNotificationsEnabled() && !this.eCJ) {
                q.this.bhL();
                this.eCJ = true;
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
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.q.h.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.e.b.B(tbPageContext.getPageActivity(), 1);
                }
            }, 100L);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            q.this.bhL();
        }
    }

    /* loaded from: classes.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.eCt != null && q.this.eCt.mission != null) {
                be.bsB().b(tbPageContext, new String[]{q.this.eCt.mission.final_reward_url});
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
            if (q.this.eCt != null && q.this.eCt.mission != null) {
                be.bsB().b(tbPageContext, new String[]{q.this.eCt.mission.final_reward_url});
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
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.q.c.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.e.b.B(tbPageContext.getPageActivity(), 1);
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
            if (q.this.eCt != null && q.this.eCt.mission != null) {
                be.bsB().b(tbPageContext, new String[]{q.this.eCt.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class d {
        private int eCH;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.eCH = i;
        }

        public void e(TbPageContext<?> tbPageContext) {
            if (bhX()) {
                d(tbPageContext);
            }
        }

        public void bhW() {
            if (bhX()) {
                complete();
            }
        }

        protected boolean bhX() {
            return (q.this.eCt == null || q.this.eCt.mission == null || q.this.eCt.getCurTaskType() != this.eCH) ? false : true;
        }
    }
}
