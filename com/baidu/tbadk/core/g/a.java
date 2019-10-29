package com.baidu.tbadk.core.g;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.BdToken.completeTask.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private static a chG;
    private int activityId;
    private int chH;
    private int chI;
    private int chJ;
    private CustomMessageListener chK = new CustomMessageListener(2921406) { // from class: com.baidu.tbadk.core.g.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 1) {
                a.this.alQ();
            }
        }
    };
    private int missionId;

    public static a alO() {
        if (chG == null) {
            synchronized (a.class) {
                if (chG == null) {
                    chG = new a();
                }
            }
        }
        return chG;
    }

    public void c(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
        Activity currentActivity;
        TbPageContext X;
        if (aVar != null) {
            boolean z = b.alR().getBoolean("key_task_system_new_user_popup_show_number", false);
            if (aVar.isNewUser && !StringUtils.isNull(aVar.bTi) && !z && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (X = X(currentActivity)) != null) {
                X.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", aVar.bTi + "?page_type=open_full_screen_opacity_web_page", true)));
                b.alR().putBoolean("key_task_system_new_user_popup_show_number", true);
            }
        }
    }

    private TbPageContext X(Activity activity) {
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
            this.chH = missionInfo.total_limit.intValue();
            this.chJ = missionInfo.cleartype.intValue();
            this.chI = missionInfo.cleartime.intValue();
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.aE(this.chI);
            bVar.hg(this.chJ);
            b.alR().putInt("task_share_thread_success_data_total_limit", this.chH);
            b.alR().putInt("task_share_thread_success_data_mission_id", this.missionId);
            b.alR().putInt("task_share_thread_success_data_action_id", this.activityId);
            b.alR().putLong("task_share_thread_success_data_specific_clear_time", bVar.adH());
        }
    }

    private void alP() {
        b.alR().remove("task_share_thread_success_data_total_limit");
        b.alR().remove("task_share_thread_success_data_mission_id");
        b.alR().remove("task_share_thread_success_data_action_id");
        b.alR().remove("task_share_thread_success_data_specific_clear_time");
    }

    public void alQ() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            int i2 = b.alR().getInt("task_share_thread_success_data_mission_id", 0);
            int i3 = b.alR().getInt("task_share_thread_success_data_action_id", 0);
            long j = b.alR().getLong("task_share_thread_success_data_specific_clear_time", 0L);
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.aF(j);
            if (bVar.adG()) {
                alP();
            } else if (i3 != 0 && i2 != 0 && (i = b.alR().getInt("task_share_thread_success_data_total_limit", 0)) > 0) {
                b.alR().putInt("task_share_thread_success_data_total_limit", i - 1);
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
        MessageManager.getInstance().registerListener(this.chK);
    }
}
