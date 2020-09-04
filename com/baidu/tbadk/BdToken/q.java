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
    private ActiveCenterData dPU;
    private boolean dPV;
    private boolean dPW;
    private boolean dPX;
    private final e dPY;
    private final f dPZ;
    private final h dQa;
    private final a dQb;
    private final g dQc;
    private final c dQd;
    private final b dQe;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static q dQm = new q();
    }

    public static q aYY() {
        return i.dQm;
    }

    private q() {
        this.dPV = false;
        this.dPW = true;
        this.dPX = false;
        this.dPY = new e(12);
        this.dPZ = new f(6);
        this.dQa = new h(10);
        this.dQb = new a(7);
        this.dQc = new g(5);
        this.dQd = new c(9);
        this.dQe = new b(13);
        if (com.baidu.tbadk.BdToken.c.aYs().aYy()) {
            this.dPW = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.dPW = true;
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void aYZ() {
        if (!this.dPX && com.baidu.tbadk.BdToken.c.aYs().aYu()) {
            this.dPX = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.dPU = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.a.lb().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                dN(currentActivity);
            }
        }
    }

    public void hy(boolean z) {
        this.dPV = z;
    }

    public void hz(boolean z) {
        this.dPW = z;
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_delete_mission_home_entrance", z);
    }

    public boolean aZa() {
        return this.dPW;
    }

    public ActiveCenterData aZb() {
        return this.dPU;
    }

    public void aZc() {
        if (this.dPU != null && this.dPU.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.dPU.mission;
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

    public boolean aZd() {
        return this.dPU != null && this.dPU.is_new_window;
    }

    public void dN(Context context) {
        if (isValid()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissionCustomDialogActivityConfig(context)));
            aZf();
            com.baidu.tbadk.core.sharedPref.b.bik().putLong("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new aq("c13742").ai("obj_source", com.baidu.tbadk.BdToken.c.aYs().aYw() ? 2 : 1).ai("obj_type", 1));
        }
    }

    private boolean isValid() {
        return (this.dPU == null || this.dPU.mission == null || !aZd() || aZe() || this.dPV) ? false : true;
    }

    private boolean aZe() {
        int i2;
        if (aZb() != null && (i2 = aZb().win_jump_time) > 0) {
            if (com.baidu.tbadk.BdToken.c.aYs().aYz()) {
                return com.baidu.tbadk.core.sharedPref.b.bik().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            com.baidu.tbadk.core.sharedPref.b.bik().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    private void aZf() {
        com.baidu.tbadk.core.sharedPref.b.bik().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, com.baidu.tbadk.core.sharedPref.b.bik().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public e aZg() {
        return this.dPY;
    }

    public f aZh() {
        return this.dPZ;
    }

    public h aZi() {
        return this.dQa;
    }

    public a aZj() {
        return this.dQb;
    }

    public g aZk() {
        return this.dQc;
    }

    public c aZl() {
        return this.dQd;
    }

    public b aZm() {
        return this.dQe;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.dPU != null) {
            int curTaskType = this.dPU.getCurTaskType();
            if (curTaskType == 12) {
                aZg().e(tbPageContext);
                aZg().aZn();
            } else if (curTaskType == 6) {
                aZh().e(tbPageContext);
            } else if (curTaskType == 10) {
                aZi().e(tbPageContext);
                aZi().aZn();
            } else if (curTaskType == 7) {
                aZj().e(tbPageContext);
            } else if (curTaskType == 5) {
                aZk().e(tbPageContext);
            } else if (curTaskType == 9) {
                aZl().e(tbPageContext);
            } else if (curTaskType == 13) {
                aZm().e(tbPageContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends d {
        private s dQj;

        public e(int i) {
            super(i);
            this.dQj = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.dQj != null && q.this.dPU != null) {
                be.bju().b(tbPageContext, new String[]{q.this.dPU.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.dQj != null && q.this.dPU != null) {
                this.dQj.aZr();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d {
        private boolean dQk;

        public f(int i) {
            super(i);
            this.dQk = false;
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
            if (areNotificationsEnabled() && !this.dQk) {
                q.this.aZc();
                this.dQk = true;
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
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.q.h.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.e.b.r(tbPageContext.getPageActivity(), 1);
                }
            }, 100L);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            q.this.aZc();
        }
    }

    /* loaded from: classes.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.dPU != null && q.this.dPU.mission != null) {
                be.bju().b(tbPageContext, new String[]{q.this.dPU.mission.final_reward_url});
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
            if (q.this.dPU != null && q.this.dPU.mission != null) {
                be.bju().b(tbPageContext, new String[]{q.this.dPU.mission.final_reward_url});
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
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.q.c.1
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
            if (q.this.dPU != null && q.this.dPU.mission != null) {
                be.bju().b(tbPageContext, new String[]{q.this.dPU.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class d {
        private int dQi;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.dQi = i;
        }

        public void e(TbPageContext<?> tbPageContext) {
            if (aZo()) {
                d(tbPageContext);
            }
        }

        public void aZn() {
            if (aZo()) {
                complete();
            }
        }

        protected boolean aZo() {
            return (q.this.dPU == null || q.this.dPU.mission == null || q.this.dPU.getCurTaskType() != this.dQi) ? false : true;
        }
    }
}
