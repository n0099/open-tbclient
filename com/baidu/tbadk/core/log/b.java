package com.baidu.tbadk.core.log;

import java.util.Hashtable;
/* loaded from: classes.dex */
public class b {
    private static Hashtable<Integer, String> Gc;

    static {
        Gc = null;
        if (Gc == null) {
            Gc = new Hashtable<>();
            Gc.put(1001, "上线");
            Gc.put(1002, "GROUP_UPDATE");
            Gc.put(1003, "PING");
            Gc.put(202003, "MESSAGE_SYNC");
            Gc.put(202001, "GROUP_CHAT_MSG");
            Gc.put(205001, "CMD_COMMIT_PERSONAL_MSG");
            Gc.put(202006, "PUSH_NOTIFY");
            Gc.put(103002, "吧的群组列表界面网络请求");
            Gc.put(103004, "群资料页界面网络请求");
            Gc.put(103005, "根据群的ID获取群的成员列表");
            Gc.put(103112, "移除群的成员");
            Gc.put(103006, "根据群的id获取群的等级信息");
            Gc.put(103110, "加群申请");
            Gc.put(103111, "往群增加成员");
            Gc.put(103003, "进群页面接口");
            Gc.put(103007, "搜群");
            Gc.put(202004, "删系统群消息");
            Gc.put(103008, "建群权限获取");
            Gc.put(103101, "添加群组");
            Gc.put(103103, "举报群组");
            Gc.put(103102, "更新群组");
            Gc.put(202101, "反推计数上传");
        }
    }

    public static String bK(int i) {
        if (Gc == null || !Gc.containsKey(Integer.valueOf(i))) {
            return "";
        }
        return Gc.get(Integer.valueOf(i));
    }
}
