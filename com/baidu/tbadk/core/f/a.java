package com.baidu.tbadk.core.f;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
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
    private static a bOW;
    private int activityId;
    private int bOX;
    private int bOY;
    private int bOZ;
    private CustomMessageListener bPa = new CustomMessageListener(2921406) { // from class: com.baidu.tbadk.core.f.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 1) {
                a.this.agL();
            }
        }
    };
    private int missionId;

    public static a agJ() {
        if (bOW == null) {
            synchronized (a.class) {
                if (bOW == null) {
                    bOW = new a();
                }
            }
        }
        return bOW;
    }

    public void c(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
        Activity currentActivity;
        TbPageContext V;
        if (aVar != null) {
            boolean z = b.agM().getBoolean("key_task_system_new_user_popup_show_number", false);
            if (aVar.isNewUser && !StringUtils.isNull(aVar.bzh) && !z && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (V = V(currentActivity)) != null) {
                V.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", aVar.bzh + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
                b.agM().putBoolean("key_task_system_new_user_popup_show_number", true);
            }
        }
    }

    private TbPageContext V(Activity activity) {
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
            this.bOX = missionInfo.total_limit.intValue();
            this.bOZ = missionInfo.cleartype.intValue();
            this.bOY = missionInfo.cleartime.intValue();
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.ak(this.bOY);
            bVar.gg(this.bOZ);
            b.agM().putInt("task_share_thread_success_data_total_limit", this.bOX);
            b.agM().putInt("task_share_thread_success_data_mission_id", this.missionId);
            b.agM().putInt("task_share_thread_success_data_action_id", this.activityId);
            b.agM().putLong("task_share_thread_success_data_specific_clear_time", bVar.XS());
        }
    }

    private void agK() {
        b.agM().remove("task_share_thread_success_data_total_limit");
        b.agM().remove("task_share_thread_success_data_mission_id");
        b.agM().remove("task_share_thread_success_data_action_id");
        b.agM().remove("task_share_thread_success_data_specific_clear_time");
    }

    public void agL() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            int i2 = b.agM().getInt("task_share_thread_success_data_mission_id", 0);
            int i3 = b.agM().getInt("task_share_thread_success_data_action_id", 0);
            long j = b.agM().getLong("task_share_thread_success_data_specific_clear_time", 0L);
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.al(j);
            if (bVar.XR()) {
                agK();
            } else if (i3 != 0 && i2 != 0 && (i = b.agM().getInt("task_share_thread_success_data_total_limit", 0)) > 0) {
                b.agM().putInt("task_share_thread_success_data_total_limit", i - 1);
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
        completeTaskReqMsg.extra = new d.e();
        MessageManager.getInstance().sendMessage(completeTaskReqMsg);
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.bPa);
    }
}
