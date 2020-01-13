package com.baidu.tbadk.core.f;

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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private static CustomMessageListener cTB = new CustomMessageListener(2921440) { // from class: com.baidu.tbadk.core.f.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                TbSingleton.getInstance().setCanWebViewActivityShowProgress(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private static a cTw;
    private int activityId;
    private CustomMessageListener cTA = new CustomMessageListener(2921406) { // from class: com.baidu.tbadk.core.f.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 1) {
                a.this.aDq();
            }
        }
    };
    private int cTx;
    private int cTy;
    private int cTz;
    private int missionId;

    public static a aDo() {
        if (cTw == null) {
            synchronized (a.class) {
                if (cTw == null) {
                    cTw = new a();
                }
            }
        }
        return cTw;
    }

    public void c(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
        Activity currentActivity;
        TbPageContext r;
        if (aVar != null) {
            boolean z = b.aDr().getBoolean("key_task_system_new_user_popup_show_number", false);
            if (aVar.isNewUser && !StringUtils.isNull(aVar.cFb) && !z && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (r = r(currentActivity)) != null) {
                r.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", aVar.cFb + "?page_type=open_full_screen_opacity_web_page", true)));
                b.aDr().putBoolean("key_task_system_new_user_popup_show_number", true);
            }
        }
    }

    private TbPageContext r(Activity activity) {
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
            this.cTx = missionInfo.total_limit.intValue();
            this.cTz = missionInfo.cleartype.intValue();
            this.cTy = missionInfo.cleartime.intValue();
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.bl(this.cTy);
            bVar.iQ(this.cTz);
            b.aDr().putInt("task_share_thread_success_data_total_limit", this.cTx);
            b.aDr().putInt("task_share_thread_success_data_mission_id", this.missionId);
            b.aDr().putInt("task_share_thread_success_data_action_id", this.activityId);
            b.aDr().putLong("task_share_thread_success_data_specific_clear_time", bVar.auR());
        }
    }

    private void aDp() {
        b.aDr().remove("task_share_thread_success_data_total_limit");
        b.aDr().remove("task_share_thread_success_data_mission_id");
        b.aDr().remove("task_share_thread_success_data_action_id");
        b.aDr().remove("task_share_thread_success_data_specific_clear_time");
    }

    public void aDq() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            int i2 = b.aDr().getInt("task_share_thread_success_data_mission_id", 0);
            int i3 = b.aDr().getInt("task_share_thread_success_data_action_id", 0);
            long j = b.aDr().getLong("task_share_thread_success_data_specific_clear_time", 0L);
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.bm(j);
            if (bVar.auQ()) {
                aDp();
            } else if (i3 != 0 && i2 != 0 && (i = b.aDr().getInt("task_share_thread_success_data_total_limit", 0)) > 0) {
                b.aDr().putInt("task_share_thread_success_data_total_limit", i - 1);
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
        MessageManager.getInstance().registerListener(this.cTA);
        MessageManager.getInstance().registerListener(cTB);
    }
}
