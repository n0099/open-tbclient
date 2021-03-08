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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private ActiveCenterData eGb;
    private boolean eGc;
    private boolean eGd;
    private boolean eGe;
    private final e eGf;
    private final f eGg;
    private final h eGh;
    private final a eGi;
    private final g eGj;
    private final c eGk;
    private final b eGl;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static q eGt = new q();
    }

    public static q bhW() {
        return i.eGt;
    }

    private q() {
        this.eGc = false;
        this.eGd = true;
        this.eGe = false;
        this.eGf = new e(12);
        this.eGg = new f(6);
        this.eGh = new h(10);
        this.eGi = new a(7);
        this.eGj = new g(5);
        this.eGk = new c(9);
        this.eGl = new b(13);
        if (com.baidu.tbadk.BdToken.c.bhp().bhw()) {
            this.eGd = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.eGd = true;
        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void bhX() {
        if (!this.eGe && com.baidu.tbadk.BdToken.c.bhp().bhs()) {
            this.eGe = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.eGb = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.b.kB().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                eM(currentActivity);
            }
        }
    }

    public void iY(boolean z) {
        this.eGc = z;
    }

    public boolean bhY() {
        return this.eGd;
    }

    public ActiveCenterData bhZ() {
        return this.eGb;
    }

    public void bia() {
        if (this.eGb != null && this.eGb.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.eGb.mission;
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

    public boolean bib() {
        return this.eGb != null && this.eGb.is_new_window;
    }

    public void eM(Context context) {
        if (isValid()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissionCustomDialogActivityConfig(context)));
            bid();
            com.baidu.tbadk.core.sharedPref.b.brR().putLong("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new ar("c13742").aq("obj_source", com.baidu.tbadk.BdToken.c.bhp().bhu() ? 2 : 1).aq("obj_type", 1));
        }
    }

    private boolean isValid() {
        return (this.eGb == null || this.eGb.mission == null || !bib() || bic() || this.eGc) ? false : true;
    }

    private boolean bic() {
        int i2;
        if (bhZ() != null && (i2 = bhZ().win_jump_time) > 0) {
            if (com.baidu.tbadk.BdToken.c.bhp().bhx()) {
                return com.baidu.tbadk.core.sharedPref.b.brR().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            com.baidu.tbadk.core.sharedPref.b.brR().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    private void bid() {
        com.baidu.tbadk.core.sharedPref.b.brR().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, com.baidu.tbadk.core.sharedPref.b.brR().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public e bie() {
        return this.eGf;
    }

    public f bif() {
        return this.eGg;
    }

    public h big() {
        return this.eGh;
    }

    public a bih() {
        return this.eGi;
    }

    public g bii() {
        return this.eGj;
    }

    public c bij() {
        return this.eGk;
    }

    public b bik() {
        return this.eGl;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.eGb != null) {
            int curTaskType = this.eGb.getCurTaskType();
            if (curTaskType == 12) {
                bie().e(tbPageContext);
                bie().bil();
            } else if (curTaskType == 6) {
                bif().e(tbPageContext);
            } else if (curTaskType == 10) {
                big().e(tbPageContext);
                big().bil();
            } else if (curTaskType == 7) {
                bih().e(tbPageContext);
            } else if (curTaskType == 5) {
                bii().e(tbPageContext);
            } else if (curTaskType == 9) {
                bij().e(tbPageContext);
            } else if (curTaskType == 13) {
                bik().e(tbPageContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends d {
        private s eGq;

        public e(int i) {
            super(i);
            this.eGq = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.eGq != null && q.this.eGb != null) {
                bf.bsY().b(tbPageContext, new String[]{q.this.eGb.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.eGq != null && q.this.eGb != null) {
                this.eGq.bip();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d {
        private boolean eGr;

        public f(int i) {
            super(i);
            this.eGr = false;
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
            if (areNotificationsEnabled() && !this.eGr) {
                q.this.bia();
                this.eGr = true;
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
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.q.h.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.e.b.B(tbPageContext.getPageActivity(), 1);
                }
            }, 100L);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            q.this.bia();
        }
    }

    /* loaded from: classes.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.eGb != null && q.this.eGb.mission != null) {
                bf.bsY().b(tbPageContext, new String[]{q.this.eGb.mission.final_reward_url});
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
            if (q.this.eGb != null && q.this.eGb.mission != null) {
                bf.bsY().b(tbPageContext, new String[]{q.this.eGb.mission.final_reward_url});
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
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.q.c.1
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
            if (q.this.eGb != null && q.this.eGb.mission != null) {
                bf.bsY().b(tbPageContext, new String[]{q.this.eGb.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class d {
        private int eGp;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.eGp = i;
        }

        public void e(TbPageContext<?> tbPageContext) {
            if (bim()) {
                d(tbPageContext);
            }
        }

        public void bil() {
            if (bim()) {
                complete();
            }
        }

        protected boolean bim() {
            return (q.this.eGb == null || q.this.eGb.mission == null || q.this.eGb.getCurTaskType() != this.eGp) ? false : true;
        }
    }
}
