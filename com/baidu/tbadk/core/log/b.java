package com.baidu.tbadk.core.log;

import com.baidu.location.BDLocationStatusCodes;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class b {
    private static Hashtable<Integer, String> Se;

    static {
        Se = null;
        if (Se == null) {
            Se = new Hashtable<>();
            Se.put(Integer.valueOf((int) BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES), "上线");
            Se.put(Integer.valueOf((int) BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE), "GROUP_UPDATE");
            Se.put(1003, "PING");
            Se.put(202003, "MESSAGE_SYNC");
            Se.put(202001, "GROUP_CHAT_MSG");
            Se.put(205001, "CMD_COMMIT_PERSONAL_MSG");
            Se.put(202006, "PUSH_NOTIFY");
            Se.put(103002, "吧的群组列表界面网络请求");
            Se.put(103004, "群资料页界面网络请求");
            Se.put(103005, "根据群的ID获取群的成员列表");
            Se.put(103112, "移除群的成员");
            Se.put(103006, "根据群的id获取群的等级信息");
            Se.put(103110, "加群申请");
            Se.put(103111, "往群增加成员");
            Se.put(103003, "进群页面接口");
            Se.put(103007, "搜群");
            Se.put(202004, "删系统群消息");
            Se.put(103008, "建群权限获取");
            Se.put(103101, "添加群组");
            Se.put(103103, "举报群组");
            Se.put(103102, "更新群组");
            Se.put(202101, "反推计数上传");
        }
    }

    public static String bL(int i) {
        if (Se == null || !Se.containsKey(Integer.valueOf(i))) {
            return "";
        }
        return Se.get(Integer.valueOf(i));
    }
}
