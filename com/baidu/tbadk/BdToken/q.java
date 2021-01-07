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
    private ActiveCenterData eHe;
    private boolean eHf;
    private boolean eHg;
    private boolean eHh;
    private final e eHi;
    private final f eHj;
    private final h eHk;
    private final a eHl;
    private final g eHm;
    private final c eHn;
    private final b eHo;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static q eHw = new q();
    }

    public static q blB() {
        return i.eHw;
    }

    private q() {
        this.eHf = false;
        this.eHg = true;
        this.eHh = false;
        this.eHi = new e(12);
        this.eHj = new f(6);
        this.eHk = new h(10);
        this.eHl = new a(7);
        this.eHm = new g(5);
        this.eHn = new c(9);
        this.eHo = new b(13);
        if (com.baidu.tbadk.BdToken.c.bkU().blb()) {
            this.eHg = com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.eHg = true;
        com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void blC() {
        if (!this.eHh && com.baidu.tbadk.BdToken.c.bkU().bkX()) {
            this.eHh = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.eHe = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.b.kC().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                eQ(currentActivity);
            }
        }
    }

    public void ja(boolean z) {
        this.eHf = z;
    }

    public boolean blD() {
        return this.eHg;
    }

    public ActiveCenterData blE() {
        return this.eHe;
    }

    public void blF() {
        if (this.eHe != null && this.eHe.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.eHe.mission;
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

    public boolean blG() {
        return this.eHe != null && this.eHe.is_new_window;
    }

    public void eQ(Context context) {
        if (isValid()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissionCustomDialogActivityConfig(context)));
            blI();
            com.baidu.tbadk.core.sharedPref.b.bvr().putLong("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new aq("c13742").an("obj_source", com.baidu.tbadk.BdToken.c.bkU().bkZ() ? 2 : 1).an("obj_type", 1));
        }
    }

    private boolean isValid() {
        return (this.eHe == null || this.eHe.mission == null || !blG() || blH() || this.eHf) ? false : true;
    }

    private boolean blH() {
        int i2;
        if (blE() != null && (i2 = blE().win_jump_time) > 0) {
            if (com.baidu.tbadk.BdToken.c.bkU().blc()) {
                return com.baidu.tbadk.core.sharedPref.b.bvr().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            com.baidu.tbadk.core.sharedPref.b.bvr().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    private void blI() {
        com.baidu.tbadk.core.sharedPref.b.bvr().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, com.baidu.tbadk.core.sharedPref.b.bvr().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public e blJ() {
        return this.eHi;
    }

    public f blK() {
        return this.eHj;
    }

    public h blL() {
        return this.eHk;
    }

    public a blM() {
        return this.eHl;
    }

    public g blN() {
        return this.eHm;
    }

    public c blO() {
        return this.eHn;
    }

    public b blP() {
        return this.eHo;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.eHe != null) {
            int curTaskType = this.eHe.getCurTaskType();
            if (curTaskType == 12) {
                blJ().e(tbPageContext);
                blJ().blQ();
            } else if (curTaskType == 6) {
                blK().e(tbPageContext);
            } else if (curTaskType == 10) {
                blL().e(tbPageContext);
                blL().blQ();
            } else if (curTaskType == 7) {
                blM().e(tbPageContext);
            } else if (curTaskType == 5) {
                blN().e(tbPageContext);
            } else if (curTaskType == 9) {
                blO().e(tbPageContext);
            } else if (curTaskType == 13) {
                blP().e(tbPageContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends d {
        private s eHt;

        public e(int i) {
            super(i);
            this.eHt = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.eHt != null && q.this.eHe != null) {
                be.bwv().b(tbPageContext, new String[]{q.this.eHe.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.eHt != null && q.this.eHe != null) {
                this.eHt.blU();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d {
        private boolean eHu;

        public f(int i) {
            super(i);
            this.eHu = false;
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
            if (areNotificationsEnabled() && !this.eHu) {
                q.this.blF();
                this.eHu = true;
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
            q.this.blF();
        }
    }

    /* loaded from: classes.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.eHe != null && q.this.eHe.mission != null) {
                be.bwv().b(tbPageContext, new String[]{q.this.eHe.mission.final_reward_url});
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
            if (q.this.eHe != null && q.this.eHe.mission != null) {
                be.bwv().b(tbPageContext, new String[]{q.this.eHe.mission.final_reward_url});
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
            if (q.this.eHe != null && q.this.eHe.mission != null) {
                be.bwv().b(tbPageContext, new String[]{q.this.eHe.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class d {
        private int eHs;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.eHs = i;
        }

        public void e(TbPageContext<?> tbPageContext) {
            if (blR()) {
                d(tbPageContext);
            }
        }

        public void blQ() {
            if (blR()) {
                complete();
            }
        }

        protected boolean blR() {
            return (q.this.eHe == null || q.this.eHe.mission == null || q.this.eHe.getCurTaskType() != this.eHs) ? false : true;
        }
    }
}
