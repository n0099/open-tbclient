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
    private ActiveCenterData eEA;
    private boolean eEB;
    private boolean eEC;
    private boolean eED;
    private final e eEE;
    private final f eEF;
    private final h eEG;
    private final a eEH;
    private final g eEI;
    private final c eEJ;
    private final b eEK;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static q eES = new q();
    }

    public static q bhU() {
        return i.eES;
    }

    private q() {
        this.eEB = false;
        this.eEC = true;
        this.eED = false;
        this.eEE = new e(12);
        this.eEF = new f(6);
        this.eEG = new h(10);
        this.eEH = new a(7);
        this.eEI = new g(5);
        this.eEJ = new c(9);
        this.eEK = new b(13);
        if (com.baidu.tbadk.BdToken.c.bhn().bhu()) {
            this.eEC = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_delete_mission_home_entrance", true);
            return;
        }
        this.eEC = true;
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_delete_mission_home_entrance", true);
    }

    public void bhV() {
        if (!this.eED && com.baidu.tbadk.BdToken.c.bhn().bhq()) {
            this.eED = true;
        }
    }

    public void a(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            this.eEA = activeCenterData;
            Activity currentActivity = com.baidu.adp.base.b.kB().currentActivity();
            if (currentActivity != null && "MainTabActivity".equals(currentActivity.getClass().getSimpleName())) {
                eN(currentActivity);
            }
        }
    }

    public void iY(boolean z) {
        this.eEB = z;
    }

    public boolean bhW() {
        return this.eEC;
    }

    public ActiveCenterData bhX() {
        return this.eEA;
    }

    public void bhY() {
        if (this.eEA != null && this.eEA.mission != null) {
            ActiveCenterData.ActiveCenterMissionData activeCenterMissionData = this.eEA.mission;
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

    public boolean bhZ() {
        return this.eEA != null && this.eEA.is_new_window;
    }

    public void eN(Context context) {
        if (isValid()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissionCustomDialogActivityConfig(context)));
            bib();
            com.baidu.tbadk.core.sharedPref.b.brQ().putLong("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new ar("c13742").ap("obj_source", com.baidu.tbadk.BdToken.c.bhn().bhs() ? 2 : 1).ap("obj_type", 1));
        }
    }

    private boolean isValid() {
        return (this.eEA == null || this.eEA.mission == null || !bhZ() || bia() || this.eEB) ? false : true;
    }

    private boolean bia() {
        int i2;
        if (bhX() != null && (i2 = bhX().win_jump_time) > 0) {
            if (com.baidu.tbadk.BdToken.c.bhn().bhv()) {
                return com.baidu.tbadk.core.sharedPref.b.brQ().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            com.baidu.tbadk.core.sharedPref.b.brQ().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    private void bib() {
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, com.baidu.tbadk.core.sharedPref.b.brQ().getLong(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public e bic() {
        return this.eEE;
    }

    public f bid() {
        return this.eEF;
    }

    public h bie() {
        return this.eEG;
    }

    public a bif() {
        return this.eEH;
    }

    public g big() {
        return this.eEI;
    }

    public c bih() {
        return this.eEJ;
    }

    public b bii() {
        return this.eEK;
    }

    public void c(TbPageContext<?> tbPageContext) {
        if (this.eEA != null) {
            int curTaskType = this.eEA.getCurTaskType();
            if (curTaskType == 12) {
                bic().e(tbPageContext);
                bic().bij();
            } else if (curTaskType == 6) {
                bid().e(tbPageContext);
            } else if (curTaskType == 10) {
                bie().e(tbPageContext);
                bie().bij();
            } else if (curTaskType == 7) {
                bif().e(tbPageContext);
            } else if (curTaskType == 5) {
                big().e(tbPageContext);
            } else if (curTaskType == 9) {
                bih().e(tbPageContext);
            } else if (curTaskType == 13) {
                bii().e(tbPageContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends d {
        private s eEP;

        public e(int i) {
            super(i);
            this.eEP = new s();
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (this.eEP != null && q.this.eEA != null) {
                bf.bsV().b(tbPageContext, new String[]{q.this.eEA.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
            if (this.eEP != null && q.this.eEA != null) {
                this.eEP.bin();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d {
        private boolean eEQ;

        public f(int i) {
            super(i);
            this.eEQ = false;
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
            if (areNotificationsEnabled() && !this.eEQ) {
                q.this.bhY();
                this.eEQ = true;
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
            q.this.bhY();
        }
    }

    /* loaded from: classes.dex */
    public class a extends d {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void d(TbPageContext<?> tbPageContext) {
            if (q.this.eEA != null && q.this.eEA.mission != null) {
                bf.bsV().b(tbPageContext, new String[]{q.this.eEA.mission.final_reward_url});
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
            if (q.this.eEA != null && q.this.eEA.mission != null) {
                bf.bsV().b(tbPageContext, new String[]{q.this.eEA.mission.final_reward_url});
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
            if (q.this.eEA != null && q.this.eEA.mission != null) {
                bf.bsV().b(tbPageContext, new String[]{q.this.eEA.mission.final_reward_url});
            }
        }

        @Override // com.baidu.tbadk.BdToken.q.d
        protected void complete() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class d {
        private int eEO;

        protected abstract void complete();

        protected abstract void d(TbPageContext<?> tbPageContext);

        public d(int i) {
            this.eEO = i;
        }

        public void e(TbPageContext<?> tbPageContext) {
            if (bik()) {
                d(tbPageContext);
            }
        }

        public void bij() {
            if (bik()) {
                complete();
            }
        }

        protected boolean bik() {
            return (q.this.eEA == null || q.this.eEA.mission == null || q.this.eEA.getCurTaskType() != this.eEO) ? false : true;
        }
    }
}
