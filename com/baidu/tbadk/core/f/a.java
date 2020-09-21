package com.baidu.tbadk.core.f;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.BdToken.completeTask.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NewUserRedPackageActivityConfig;
import com.baidu.tbadk.core.atomData.UserTropicGiftBagActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private static a eko;
    private static CustomMessageListener ekt = new CustomMessageListener(2921440) { // from class: com.baidu.tbadk.core.f.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                TbSingleton.getInstance().setCanWebViewActivityShowProgress(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private int activityId;
    private int ekp;
    private int ekq;
    private int ekr;
    private CustomMessageListener eks = new CustomMessageListener(2921406) { // from class: com.baidu.tbadk.core.f.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ShareEvent) && ((ShareEvent) customResponsedMessage.getData()).status == 1) {
                f.pW(((ShareEvent) customResponsedMessage.getData()).channel);
                a.this.bje();
            }
        }
    };
    private final b<com.baidu.adp.widget.ImageView.a> eku = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.f.a.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            Activity currentActivity;
            TbPageContext o;
            if (aVar != null && a.this.mNewUserRedPackageData != null && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (o = a.this.o(currentActivity)) != null) {
                if (!com.baidu.adp.base.a.lf().bq("MainTabActivity")) {
                    TbSingleton.getInstance().setNewUserRedPackageData(a.this.mNewUserRedPackageData);
                } else {
                    o.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewUserRedPackageActivityConfig(o.getPageActivity(), a.this.mNewUserRedPackageData)));
                }
            }
        }
    };
    private NewUserRedPackageData mNewUserRedPackageData;
    private int missionId;

    public static a bjb() {
        if (eko == null) {
            synchronized (a.class) {
                if (eko == null) {
                    eko = new a();
                }
            }
        }
        return eko;
    }

    public void d(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
        Activity currentActivity;
        TbPageContext o;
        if (aVar != null) {
            if (aVar.dSQ == null || !aVar.dSQ.is_new_window) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_task_system_new_user_popup_show_number", false);
                if (aVar.isNewUser && !StringUtils.isNull(aVar.dSM) && !z && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (o = o(currentActivity)) != null) {
                    this.mNewUserRedPackageData = aVar.dSP;
                    c.mR().a(this.mNewUserRedPackageData.topPicUrl, 10, this.eku, 0, 0, o.getUniqueId(), new Object[0]);
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_task_system_new_user_popup_show_number", true);
                }
            }
        }
    }

    public void bjc() {
        TbPageContext o;
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null && (o = o(currentActivity)) != null && com.baidu.adp.base.a.lf().bq("MainTabActivity")) {
            o.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserTropicGiftBagActivityConfig(o.getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext o(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    public void a(MissionInfo missionInfo) {
        if (missionInfo != null && missionInfo.activityid.intValue() != 0 && missionInfo.missionid.intValue() != 0) {
            this.activityId = missionInfo.activityid.intValue();
            this.missionId = missionInfo.missionid.intValue();
            this.ekp = missionInfo.total_limit.intValue();
            this.ekr = missionInfo.cleartype.intValue();
            this.ekq = missionInfo.cleartime.intValue();
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.cu(this.ekq);
            bVar.mL(this.ekr);
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt("task_share_thread_success_data_total_limit", this.ekp);
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt("task_share_thread_success_data_mission_id", this.missionId);
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt("task_share_thread_success_data_action_id", this.activityId);
            com.baidu.tbadk.core.sharedPref.b.bjf().putLong("task_share_thread_success_data_specific_clear_time", bVar.aYM());
        }
    }

    private void bjd() {
        com.baidu.tbadk.core.sharedPref.b.bjf().remove("task_share_thread_success_data_total_limit");
        com.baidu.tbadk.core.sharedPref.b.bjf().remove("task_share_thread_success_data_mission_id");
        com.baidu.tbadk.core.sharedPref.b.bjf().remove("task_share_thread_success_data_action_id");
        com.baidu.tbadk.core.sharedPref.b.bjf().remove("task_share_thread_success_data_specific_clear_time");
    }

    public void bje() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("task_share_thread_success_data_mission_id", 0);
            int i3 = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("task_share_thread_success_data_action_id", 0);
            long j = com.baidu.tbadk.core.sharedPref.b.bjf().getLong("task_share_thread_success_data_specific_clear_time", 0L);
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.cv(j);
            if (bVar.aYL()) {
                bjd();
            } else if (i3 != 0 && i2 != 0 && (i = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("task_share_thread_success_data_total_limit", 0)) > 0) {
                com.baidu.tbadk.core.sharedPref.b.bjf().putInt("task_share_thread_success_data_total_limit", i - 1);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(String.valueOf(i3), String.valueOf(i2));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                sendCompleteTask(jSONObject.toString());
            }
        }
    }

    private void sendCompleteTask(String str) {
        CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(5);
        completeTaskReqMsg.completeId = str;
        completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
        completeTaskReqMsg.extra = new d.f();
        MessageManager.getInstance().sendMessage(completeTaskReqMsg);
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.eks);
        MessageManager.getInstance().registerListener(ekt);
    }
}
