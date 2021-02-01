package com.baidu.tbadk.core.f;

import android.app.Activity;
import com.baidu.adp.base.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.BdToken.completeTask.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserTropicGiftBagActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private static a eYC;
    private static CustomMessageListener eYH = new CustomMessageListener(2921440) { // from class: com.baidu.tbadk.core.f.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                TbSingleton.getInstance().setCanWebViewActivityShowProgress(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private int activityId;
    private int eYD;
    private int eYE;
    private int eYF;
    private CustomMessageListener eYG = new CustomMessageListener(2921406) { // from class: com.baidu.tbadk.core.f.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ShareEvent) && ((ShareEvent) customResponsedMessage.getData()).status == 1) {
                f.qz(((ShareEvent) customResponsedMessage.getData()).channel);
                a.this.brP();
            }
        }
    };
    private final c<com.baidu.adp.widget.ImageView.a> eYI = new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.f.a.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            Activity currentActivity;
            if (aVar != null && a.this.mNewUserRedPackageData != null && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && a.this.getCurrentActivityPageContext(currentActivity) != null) {
                TbSingleton.getInstance().setNewUserRedPackageData(a.this.mNewUserRedPackageData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921532));
            }
        }
    };
    private NewUserRedPackageData mNewUserRedPackageData;
    private int missionId;

    public static a brM() {
        if (eYC == null) {
            synchronized (a.class) {
                if (eYC == null) {
                    eYC = new a();
                }
            }
        }
        return eYC;
    }

    public void d(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
        Activity currentActivity;
        TbPageContext currentActivityPageContext;
        if (aVar != null) {
            if ((aVar.eFq == null || !aVar.eFq.is_new_window) && aVar.isNewUser && !StringUtils.isNull(aVar.eFm) && !TbSingleton.getInstance().isNewUserRedPackageShowed() && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (currentActivityPageContext = getCurrentActivityPageContext(currentActivity)) != null) {
                this.mNewUserRedPackageData = aVar.eFp;
                d.mw().a(this.mNewUserRedPackageData.topPicUrl, 10, this.eYI, 0, 0, currentActivityPageContext.getUniqueId(), new Object[0]);
            }
        }
    }

    public void brN() {
        TbPageContext currentActivityPageContext;
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null && (currentActivityPageContext = getCurrentActivityPageContext(currentActivity)) != null && b.kB().bo("MainTabActivity")) {
            currentActivityPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserTropicGiftBagActivityConfig(currentActivityPageContext.getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getCurrentActivityPageContext(Activity activity) {
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
            this.eYD = missionInfo.total_limit.intValue();
            this.eYF = missionInfo.cleartype.intValue();
            this.eYE = missionInfo.cleartime.intValue();
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.dF(this.eYE);
            bVar.mD(this.eYF);
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("task_share_thread_success_data_total_limit", this.eYD);
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("task_share_thread_success_data_mission_id", this.missionId);
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("task_share_thread_success_data_action_id", this.activityId);
            com.baidu.tbadk.core.sharedPref.b.brQ().putLong("task_share_thread_success_data_specific_clear_time", bVar.bgV());
        }
    }

    private void brO() {
        com.baidu.tbadk.core.sharedPref.b.brQ().remove("task_share_thread_success_data_total_limit");
        com.baidu.tbadk.core.sharedPref.b.brQ().remove("task_share_thread_success_data_mission_id");
        com.baidu.tbadk.core.sharedPref.b.brQ().remove("task_share_thread_success_data_action_id");
        com.baidu.tbadk.core.sharedPref.b.brQ().remove("task_share_thread_success_data_specific_clear_time");
    }

    public void brP() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("task_share_thread_success_data_mission_id", 0);
            int i3 = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("task_share_thread_success_data_action_id", 0);
            long j = com.baidu.tbadk.core.sharedPref.b.brQ().getLong("task_share_thread_success_data_specific_clear_time", 0L);
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.dG(j);
            if (bVar.bgU()) {
                brO();
            } else if (i3 != 0 && i2 != 0 && (i = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("task_share_thread_success_data_total_limit", 0)) > 0) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("task_share_thread_success_data_total_limit", i - 1);
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
        MessageManager.getInstance().registerListener(this.eYG);
        MessageManager.getInstance().registerListener(eYH);
    }
}
