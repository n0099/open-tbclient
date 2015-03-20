package com.baidu.tbadk.core.log;

import com.baidu.location.BDLocationStatusCodes;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class b {
    private static Hashtable<Integer, String> Sc;

    static {
        Sc = null;
        if (Sc == null) {
            Sc = new Hashtable<>();
            Sc.put(Integer.valueOf((int) BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES), "上线");
            Sc.put(Integer.valueOf((int) BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE), "GROUP_UPDATE");
            Sc.put(1003, "PING");
            Sc.put(202003, "MESSAGE_SYNC");
            Sc.put(202001, "GROUP_CHAT_MSG");
            Sc.put(205001, "CMD_COMMIT_PERSONAL_MSG");
            Sc.put(202006, "PUSH_NOTIFY");
            Sc.put(103002, "吧的群组列表界面网络请求");
            Sc.put(103004, "群资料页界面网络请求");
            Sc.put(103005, "根据群的ID获取群的成员列表");
            Sc.put(103112, "移除群的成员");
            Sc.put(103006, "根据群的id获取群的等级信息");
            Sc.put(103110, "加群申请");
            Sc.put(103111, "往群增加成员");
            Sc.put(103003, "进群页面接口");
            Sc.put(103007, "搜群");
            Sc.put(202004, "删系统群消息");
            Sc.put(103008, "建群权限获取");
            Sc.put(103101, "添加群组");
            Sc.put(103103, "举报群组");
            Sc.put(103102, "更新群组");
            Sc.put(202101, "反推计数上传");
        }
    }

    public static String bL(int i) {
        if (Sc == null || !Sc.containsKey(Integer.valueOf(i))) {
            return "";
        }
        return Sc.get(Integer.valueOf(i));
    }
}
