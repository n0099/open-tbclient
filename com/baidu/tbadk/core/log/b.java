package com.baidu.tbadk.core.log;

import java.util.Hashtable;
/* loaded from: classes.dex */
public class b {
    private static Hashtable<Integer, String> BR;

    static {
        BR = null;
        if (BR == null) {
            BR = new Hashtable<>();
            BR.put(1001, "上线");
            BR.put(1002, "GROUP_UPDATE");
            BR.put(1003, "PING");
            BR.put(202003, "MESSAGE_SYNC");
            BR.put(202001, "GROUP_CHAT_MSG");
            BR.put(205001, "CMD_COMMIT_PERSONAL_MSG");
            BR.put(202006, "PUSH_NOTIFY");
            BR.put(103002, "吧的群组列表界面网络请求");
            BR.put(103004, "群资料页界面网络请求");
            BR.put(103005, "根据群的ID获取群的成员列表");
            BR.put(103112, "移除群的成员");
            BR.put(103006, "根据群的id获取群的等级信息");
            BR.put(103110, "加群申请");
            BR.put(103111, "往群增加成员");
            BR.put(103003, "进群页面接口");
            BR.put(103007, "搜群");
            BR.put(202004, "删系统群消息");
            BR.put(103008, "建群权限获取");
            BR.put(103101, "添加群组");
            BR.put(103103, "举报群组");
            BR.put(103102, "更新群组");
            BR.put(202101, "反推计数上传");
        }
    }

    public static String bj(int i) {
        if (BR == null || !BR.containsKey(Integer.valueOf(i))) {
            return "";
        }
        return BR.get(Integer.valueOf(i));
    }
}
