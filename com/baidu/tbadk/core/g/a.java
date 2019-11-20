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
    private static a cgP;
    private int activityId;
    private int cgQ;
    private int cgR;
    private int cgS;
    private CustomMessageListener cgT = new CustomMessageListener(2921406) { // from class: com.baidu.tbadk.core.g.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 1) {
                a.this.alO();
            }
        }
    };
    private int missionId;

    public static a alM() {
        if (cgP == null) {
            synchronized (a.class) {
                if (cgP == null) {
                    cgP = new a();
                }
            }
        }
        return cgP;
    }

    public void c(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
        Activity currentActivity;
        TbPageContext X;
        if (aVar != null) {
            boolean z = b.alP().getBoolean("key_task_system_new_user_popup_show_number", false);
            if (aVar.isNewUser && !StringUtils.isNull(aVar.bSr) && !z && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (X = X(currentActivity)) != null) {
                X.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", aVar.bSr + "?page_type=open_full_screen_opacity_web_page", true)));
                b.alP().putBoolean("key_task_system_new_user_popup_show_number", true);
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
            this.cgQ = missionInfo.total_limit.intValue();
            this.cgS = missionInfo.cleartype.intValue();
            this.cgR = missionInfo.cleartime.intValue();
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.aD(this.cgR);
            bVar.hf(this.cgS);
            b.alP().putInt("task_share_thread_success_data_total_limit", this.cgQ);
            b.alP().putInt("task_share_thread_success_data_mission_id", this.missionId);
            b.alP().putInt("task_share_thread_success_data_action_id", this.activityId);
            b.alP().putLong("task_share_thread_success_data_specific_clear_time", bVar.adF());
        }
    }

    private void alN() {
        b.alP().remove("task_share_thread_success_data_total_limit");
        b.alP().remove("task_share_thread_success_data_mission_id");
        b.alP().remove("task_share_thread_success_data_action_id");
        b.alP().remove("task_share_thread_success_data_specific_clear_time");
    }

    public void alO() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            int i2 = b.alP().getInt("task_share_thread_success_data_mission_id", 0);
            int i3 = b.alP().getInt("task_share_thread_success_data_action_id", 0);
            long j = b.alP().getLong("task_share_thread_success_data_specific_clear_time", 0L);
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.aE(j);
            if (bVar.adE()) {
                alN();
            } else if (i3 != 0 && i2 != 0 && (i = b.alP().getInt("task_share_thread_success_data_total_limit", 0)) > 0) {
                b.alP().putInt("task_share_thread_success_data_total_limit", i - 1);
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
        MessageManager.getInstance().registerListener(this.cgT);
    }
}
