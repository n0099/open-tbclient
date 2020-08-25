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
/* loaded from: classes2.dex */
public class q {
    private ActiveCenterData dPQ;
    private boolean dPR;
    private boolean dPS;
    private boolean dPT;
    private final e dPU;
    private final f dPV;
    private final h dPW;
    private final a dPX;
    private final g dPY;
    private final c dPZ;
    private final b dQa;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class i {
        private static q dQi = new q();
    }

    public static q aYY() {
        return i.dQi;
    }

    private q() {
        this.dPR = false;
        this.dPS = true;
        this.dPT = false;
        this.dPU = new e(12);
        this.dPV = new f(6);
        this.dPW = new h(10);
        this.dPX = new a(7);
        this.dPY = new g(5);
        this.dPZ = new c(9);
        this.dQa = new b(13);
        if (com.baidu.tbadk.BdToken.c.aYs().aYy()) {
            this.dPS = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.dPS = true;
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void aYZ() {
        if (!this.dPT && com.baidu.tbadk.BdToken.c.aYs().aYu()) {
            this.dPT = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.dPQ = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.a.lb().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                dN(currentActivity);
            }
        }
    }

    public void hx(boolean z) {
        this.dPR = z;
    }

    public void hy(boolean z) {
        this.dPS = z;
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_delete_mission_home_entrance", z);
    }

    public boolean aZa() {
        return this.dPS;
    }

    public ActiveCenterData aZb() {
        return this.dPQ;
    }

    public void aZc() {
        if (this.dPQ != null && this.dPQ.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.dPQ.mission;
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
        return this.dPQ != null && this.dPQ.is_new_window;
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
        return (this.dPQ == null || this.dPQ.mission == null || !aZd() || aZe() || this.dPR) ? false : true;
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
        return this.dPU;
    }

    public f aZh() {
        return this.dPV;
    }

    public h aZi() {
        return this.dPW;
    }

    public a aZj() {
        return this.dPX;
    }

    public g aZk() {
        return this.dPY;
    }

    public c aZl() {
        return this.dPZ;
    }

    public b aZm() {
        return this.dQa;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.dPQ != null) {
            int curTaskType = this.dPQ.getCurTaskType();
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

    /* loaded from: classes2.dex */
    public class e extends d {
        private s dQf;

        public e(int i) {
            super(i);
            this.dQf = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.dQf != null && q.this.dPQ != null) {
                be.bju().b(tbPageContext, new String[]{q.this.dPQ.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.dQf != null && q.this.dPQ != null) {
                this.dQf.aZr();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d {
        private boolean dQg;

        public f(int i) {
            super(i);
            this.dQg = false;
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
            if (areNotificationsEnabled() && !this.dQg) {
                q.this.aZc();
                this.dQg = true;
            }
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.dPQ != null && q.this.dPQ.mission != null) {
                be.bju().b(tbPageContext, new String[]{q.this.dPQ.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes2.dex */
    public class g extends d {
        public g(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.dPQ != null && q.this.dPQ.mission != null) {
                be.bju().b(tbPageContext, new String[]{q.this.dPQ.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class b extends d {
        public b(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.dPQ != null && q.this.dPQ.mission != null) {
                be.bju().b(tbPageContext, new String[]{q.this.dPQ.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes2.dex */
    public abstract class d {
        private int dQe;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.dQe = i;
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
            return (q.this.dPQ == null || q.this.dPQ.mission == null || q.this.dPQ.getCurTaskType() != this.dQe) ? false : true;
        }
    }
}
