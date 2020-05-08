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
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private static a dxb;
    private static CustomMessageListener dxg = new CustomMessageListener(2921440) { // from class: com.baidu.tbadk.core.f.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                TbSingleton.getInstance().setCanWebViewActivityShowProgress(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private int activityId;
    private int dxc;
    private int dxd;
    private int dxe;
    private CustomMessageListener dxf = new CustomMessageListener(2921406) { // from class: com.baidu.tbadk.core.f.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ShareEvent) && ((ShareEvent) customResponsedMessage.getData()).status == 1) {
                e.mh(((ShareEvent) customResponsedMessage.getData()).channel);
                a.this.aNS();
            }
        }
    };
    private int missionId;

    public static a aNQ() {
        if (dxb == null) {
            synchronized (a.class) {
                if (dxb == null) {
                    dxb = new a();
                }
            }
        }
        return dxb;
    }

    public void c(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
        Activity currentActivity;
        TbPageContext n;
        if (aVar != null) {
            boolean z = b.aNT().getBoolean("key_task_system_new_user_popup_show_number", false);
            if (aVar.isNewUser && !StringUtils.isNull(aVar.diB) && !z && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (n = n(currentActivity)) != null) {
                n.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(currentActivity, "", aVar.diB + "?page_type=open_full_screen_opacity_web_page", true)));
                b.aNT().putBoolean("key_task_system_new_user_popup_show_number", true);
            }
        }
    }

    private TbPageContext n(Activity activity) {
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
            this.dxc = missionInfo.total_limit.intValue();
            this.dxe = missionInfo.cleartype.intValue();
            this.dxd = missionInfo.cleartime.intValue();
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.bU(this.dxd);
            bVar.jo(this.dxe);
            b.aNT().putInt("task_share_thread_success_data_total_limit", this.dxc);
            b.aNT().putInt("task_share_thread_success_data_mission_id", this.missionId);
            b.aNT().putInt("task_share_thread_success_data_action_id", this.activityId);
            b.aNT().putLong("task_share_thread_success_data_specific_clear_time", bVar.aFv());
        }
    }

    private void aNR() {
        b.aNT().remove("task_share_thread_success_data_total_limit");
        b.aNT().remove("task_share_thread_success_data_mission_id");
        b.aNT().remove("task_share_thread_success_data_action_id");
        b.aNT().remove("task_share_thread_success_data_specific_clear_time");
    }

    public void aNS() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            int i2 = b.aNT().getInt("task_share_thread_success_data_mission_id", 0);
            int i3 = b.aNT().getInt("task_share_thread_success_data_action_id", 0);
            long j = b.aNT().getLong("task_share_thread_success_data_specific_clear_time", 0L);
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
            bVar.bV(j);
            if (bVar.aFu()) {
                aNR();
            } else if (i3 != 0 && i2 != 0 && (i = b.aNT().getInt("task_share_thread_success_data_total_limit", 0)) > 0) {
                b.aNT().putInt("task_share_thread_success_data_total_limit", i - 1);
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
        MessageManager.getInstance().registerListener(this.dxf);
        MessageManager.getInstance().registerListener(dxg);
    }
}
