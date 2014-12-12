package com.baidu.tbadk.core.log;

import java.util.Hashtable;
/* loaded from: classes.dex */
public class b {
    private static Hashtable<Integer, String> FZ;

    static {
        FZ = null;
        if (FZ == null) {
            FZ = new Hashtable<>();
            FZ.put(1001, "上线");
            FZ.put(1002, "GROUP_UPDATE");
            FZ.put(1003, "PING");
            FZ.put(202003, "MESSAGE_SYNC");
            FZ.put(202001, "GROUP_CHAT_MSG");
            FZ.put(205001, "CMD_COMMIT_PERSONAL_MSG");
            FZ.put(202006, "PUSH_NOTIFY");
            FZ.put(103002, "吧的群组列表界面网络请求");
            FZ.put(103004, "群资料页界面网络请求");
            FZ.put(103005, "根据群的ID获取群的成员列表");
            FZ.put(103112, "移除群的成员");
            FZ.put(103006, "根据群的id获取群的等级信息");
            FZ.put(103110, "加群申请");
            FZ.put(103111, "往群增加成员");
            FZ.put(103003, "进群页面接口");
            FZ.put(103007, "搜群");
            FZ.put(202004, "删系统群消息");
            FZ.put(103008, "建群权限获取");
            FZ.put(103101, "添加群组");
            FZ.put(103103, "举报群组");
            FZ.put(103102, "更新群组");
            FZ.put(202101, "反推计数上传");
        }
    }

    public static String bF(int i) {
        if (FZ == null || !FZ.containsKey(Integer.valueOf(i))) {
            return "";
        }
        return FZ.get(Integer.valueOf(i));
    }
}
