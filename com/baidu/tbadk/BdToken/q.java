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
    private final a esA;
    private final g esB;
    private final c esC;
    private final b esD;
    private ActiveCenterData est;
    private boolean esu;
    private boolean esv;
    private boolean esw;
    private final e esx;
    private final f esy;
    private final h esz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static q esL = new q();
    }

    public static q bgM() {
        return i.esL;
    }

    private q() {
        this.esu = false;
        this.esv = true;
        this.esw = false;
        this.esx = new e(12);
        this.esy = new f(6);
        this.esz = new h(10);
        this.esA = new a(7);
        this.esB = new g(5);
        this.esC = new c(9);
        this.esD = new b(13);
        if (com.baidu.tbadk.BdToken.c.bgf().bgm()) {
            this.esv = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.esv = true;
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void bgN() {
        if (!this.esw && com.baidu.tbadk.BdToken.c.bgf().bgi()) {
            this.esw = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.est = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.a.lg().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                dS(currentActivity);
            }
        }
    }

    public void in(boolean z) {
        this.esu = z;
    }

    public void io(boolean z) {
        this.esv = z;
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_delete_mission_home_entrance", z);
    }

    public boolean bgO() {
        return this.esv;
    }

    public ActiveCenterData bgP() {
        return this.est;
    }

    public void bgQ() {
        if (this.est != null && this.est.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.est.mission;
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

    public boolean bgR() {
        return this.est != null && this.est.is_new_window;
    }

    public void dS(Context context) {
        if (isValid()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissionCustomDialogActivityConfig(context)));
            bgT();
            com.baidu.tbadk.core.sharedPref.b.bqh().putLong("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new aq("c13742").al("obj_source", com.baidu.tbadk.BdToken.c.bgf().bgk() ? 2 : 1).al("obj_type", 1));
        }
    }

    private boolean isValid() {
        return (this.est == null || this.est.mission == null || !bgR() || bgS() || this.esu) ? false : true;
    }

    private boolean bgS() {
        int i2;
        if (bgP() != null && (i2 = bgP().win_jump_time) > 0) {
            if (com.baidu.tbadk.BdToken.c.bgf().bgn()) {
                return com.baidu.tbadk.core.sharedPref.b.bqh().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            com.baidu.tbadk.core.sharedPref.b.bqh().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    private void bgT() {
        com.baidu.tbadk.core.sharedPref.b.bqh().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, com.baidu.tbadk.core.sharedPref.b.bqh().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public e bgU() {
        return this.esx;
    }

    public f bgV() {
        return this.esy;
    }

    public h bgW() {
        return this.esz;
    }

    public a bgX() {
        return this.esA;
    }

    public g bgY() {
        return this.esB;
    }

    public c bgZ() {
        return this.esC;
    }

    public b bha() {
        return this.esD;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.est != null) {
            int curTaskType = this.est.getCurTaskType();
            if (curTaskType == 12) {
                bgU().e(tbPageContext);
                bgU().bhb();
            } else if (curTaskType == 6) {
                bgV().e(tbPageContext);
            } else if (curTaskType == 10) {
                bgW().e(tbPageContext);
                bgW().bhb();
            } else if (curTaskType == 7) {
                bgX().e(tbPageContext);
            } else if (curTaskType == 5) {
                bgY().e(tbPageContext);
            } else if (curTaskType == 9) {
                bgZ().e(tbPageContext);
            } else if (curTaskType == 13) {
                bha().e(tbPageContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends d {
        private s esI;

        public e(int i) {
            super(i);
            this.esI = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.esI != null && q.this.est != null) {
                be.brr().b(tbPageContext, new String[]{q.this.est.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.esI != null && q.this.est != null) {
                this.esI.bhf();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d {
        private boolean esJ;

        public f(int i) {
            super(i);
            this.esJ = false;
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
            if (areNotificationsEnabled() && !this.esJ) {
                q.this.bgQ();
                this.esJ = true;
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
            q.this.bgQ();
        }
    }

    /* loaded from: classes.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.est != null && q.this.est.mission != null) {
                be.brr().b(tbPageContext, new String[]{q.this.est.mission.final_reward_url});
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
            if (q.this.est != null && q.this.est.mission != null) {
                be.brr().b(tbPageContext, new String[]{q.this.est.mission.final_reward_url});
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
            if (q.this.est != null && q.this.est.mission != null) {
                be.brr().b(tbPageContext, new String[]{q.this.est.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class d {
        private int esH;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.esH = i;
        }

        public void e(TbPageContext<?> tbPageContext) {
            if (bhc()) {
                d(tbPageContext);
            }
        }

        public void bhb() {
            if (bhc()) {
                complete();
            }
        }

        protected boolean bhc() {
            return (q.this.est == null || q.this.est.mission == null || q.this.est.getCurTaskType() != this.esH) ? false : true;
        }
    }
}
