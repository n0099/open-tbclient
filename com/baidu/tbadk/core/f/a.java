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
import com.baidu.tbadk.BdToken.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NewUserRedPackageActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes2.dex */
public class a {
    private static a ehV;
    private static CustomMessageListener eia = new CustomMessageListener(2921440) { // from class: com.baidu.tbadk.core.f.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                TbSingleton.getInstance().setCanWebViewActivityShowProgress(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private int activityId;
    private int ehW;
    private int ehX;
    private int ehY;
    private CustomMessageListener ehZ = new CustomMessageListener(2921406) { // from class: com.baidu.tbadk.core.f.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ShareEvent) && ((ShareEvent) customResponsedMessage.getData()).status == 1) {
                f.pJ(((ShareEvent) customResponsedMessage.getData()).channel);
                a.this.bij();
            }
        }
    };
    private final b<com.baidu.adp.widget.ImageView.a> eib = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.f.a.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            Activity currentActivity;
            TbPageContext o;
            if (aVar != null && a.this.mNewUserRedPackageData != null && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (o = a.this.o(currentActivity)) != null) {
                if (!com.baidu.adp.base.a.lb().bo("MainTabActivity")) {
                    TbSingleton.getInstance().setNewUserRedPackageData(a.this.mNewUserRedPackageData);
                } else {
                    o.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewUserRedPackageActivityConfig(o.getPageActivity(), a.this.mNewUserRedPackageData)));
                }
            }
        }
    };
    private NewUserRedPackageData mNewUserRedPackageData;
    private int missionId;

    public static a bih() {
        if (ehV == null) {
            synchronized (a.class) {
                if (ehV == null) {
                    ehV = new a();
                }
            }
        }
        return ehV;
    }

    public void d(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
        Activity currentActivity;
        TbPageContext o;
        if (!q.aYY().aZd() && aVar != null) {
            boolean z = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_task_system_new_user_popup_show_number", false);
            if (aVar.isNewUser && !StringUtils.isNull(aVar.dQB) && !z && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (o = o(currentActivity)) != null) {
                this.mNewUserRedPackageData = aVar.dQE;
                c.mM().a(this.mNewUserRedPackageData.topPicUrl, 10, this.eib, 0, 0, o.getUniqueId(), new Object[0]);
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_task_system_new_user_popup_show_number", true);
            }
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
            this.ehW = missionInfo.total_limit.intValue();
            this.ehY = missionInfo.cleartype.intValue();
            this.ehX = missionInfo.cleartime.intValue();
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.ct(this.ehX);
            bVar.mA(this.ehY);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("task_share_thread_success_data_total_limit", this.ehW);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("task_share_thread_success_data_mission_id", this.missionId);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("task_share_thread_success_data_action_id", this.activityId);
            com.baidu.tbadk.core.sharedPref.b.bik().putLong("task_share_thread_success_data_specific_clear_time", bVar.aYa());
        }
    }

    private void bii() {
        com.baidu.tbadk.core.sharedPref.b.bik().remove("task_share_thread_success_data_total_limit");
        com.baidu.tbadk.core.sharedPref.b.bik().remove("task_share_thread_success_data_mission_id");
        com.baidu.tbadk.core.sharedPref.b.bik().remove("task_share_thread_success_data_action_id");
        com.baidu.tbadk.core.sharedPref.b.bik().remove("task_share_thread_success_data_specific_clear_time");
    }

    public void bij() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.bik().getInt("task_share_thread_success_data_mission_id", 0);
            int i3 = com.baidu.tbadk.core.sharedPref.b.bik().getInt("task_share_thread_success_data_action_id", 0);
            long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong("task_share_thread_success_data_specific_clear_time", 0L);
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.cu(j);
            if (bVar.aXZ()) {
                bii();
            } else if (i3 != 0 && i2 != 0 && (i = com.baidu.tbadk.core.sharedPref.b.bik().getInt("task_share_thread_success_data_total_limit", 0)) > 0) {
                com.baidu.tbadk.core.sharedPref.b.bik().putInt("task_share_thread_success_data_total_limit", i - 1);
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
        MessageManager.getInstance().registerListener(this.ehZ);
        MessageManager.getInstance().registerListener(eia);
    }
}
