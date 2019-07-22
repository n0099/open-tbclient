package com.baidu.tbadk.core.g;

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
    private static a bPW;
    private int activityId;
    private int bPX;
    private int bPY;
    private int bPZ;
    private CustomMessageListener bQa = new CustomMessageListener(2921406) { // from class: com.baidu.tbadk.core.g.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 1) {
                a.this.ahN();
            }
        }
    };
    private int missionId;

    public static a ahL() {
        if (bPW == null) {
            synchronized (a.class) {
                if (bPW == null) {
                    bPW = new a();
                }
            }
        }
        return bPW;
    }

    public void c(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
        Activity currentActivity;
        TbPageContext Y;
        if (aVar != null) {
            boolean z = b.ahO().getBoolean("key_task_system_new_user_popup_show_number", false);
            if (aVar.isNewUser && !StringUtils.isNull(aVar.bAe) && !z && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (Y = Y(currentActivity)) != null) {
                Y.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", aVar.bAe + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
                b.ahO().putBoolean("key_task_system_new_user_popup_show_number", true);
            }
        }
    }

    private TbPageContext Y(Activity activity) {
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
            this.bPX = missionInfo.total_limit.intValue();
            this.bPZ = missionInfo.cleartype.intValue();
            this.bPY = missionInfo.cleartime.intValue();
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.al(this.bPY);
            bVar.gk(this.bPZ);
            b.ahO().putInt("task_share_thread_success_data_total_limit", this.bPX);
            b.ahO().putInt("task_share_thread_success_data_mission_id", this.missionId);
            b.ahO().putInt("task_share_thread_success_data_action_id", this.activityId);
            b.ahO().putLong("task_share_thread_success_data_specific_clear_time", bVar.YO());
        }
    }

    private void ahM() {
        b.ahO().remove("task_share_thread_success_data_total_limit");
        b.ahO().remove("task_share_thread_success_data_mission_id");
        b.ahO().remove("task_share_thread_success_data_action_id");
        b.ahO().remove("task_share_thread_success_data_specific_clear_time");
    }

    public void ahN() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            int i2 = b.ahO().getInt("task_share_thread_success_data_mission_id", 0);
            int i3 = b.ahO().getInt("task_share_thread_success_data_action_id", 0);
            long j = b.ahO().getLong("task_share_thread_success_data_specific_clear_time", 0L);
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.am(j);
            if (bVar.YN()) {
                ahM();
            } else if (i3 != 0 && i2 != 0 && (i = b.ahO().getInt("task_share_thread_success_data_total_limit", 0)) > 0) {
                b.ahO().putInt("task_share_thread_success_data_total_limit", i - 1);
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
        MessageManager.getInstance().registerListener(this.bQa);
    }
}
