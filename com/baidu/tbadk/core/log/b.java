package com.baidu.tbadk.core.log;

import java.util.Hashtable;
/* loaded from: classes.dex */
public class b {
    private static Hashtable<Integer, String> Gf;

    static {
        Gf = null;
        if (Gf == null) {
            Gf = new Hashtable<>();
            Gf.put(1001, "上线");
            Gf.put(1002, "GROUP_UPDATE");
            Gf.put(1003, "PING");
            Gf.put(202003, "MESSAGE_SYNC");
            Gf.put(202001, "GROUP_CHAT_MSG");
            Gf.put(205001, "CMD_COMMIT_PERSONAL_MSG");
            Gf.put(202006, "PUSH_NOTIFY");
            Gf.put(103002, "吧的群组列表界面网络请求");
            Gf.put(103004, "群资料页界面网络请求");
            Gf.put(103005, "根据群的ID获取群的成员列表");
            Gf.put(103112, "移除群的成员");
            Gf.put(103006, "根据群的id获取群的等级信息");
            Gf.put(103110, "加群申请");
            Gf.put(103111, "往群增加成员");
            Gf.put(103003, "进群页面接口");
            Gf.put(103007, "搜群");
            Gf.put(202004, "删系统群消息");
            Gf.put(103008, "建群权限获取");
            Gf.put(103101, "添加群组");
            Gf.put(103103, "举报群组");
            Gf.put(103102, "更新群组");
            Gf.put(202101, "反推计数上传");
        }
    }

    public static String bK(int i) {
        if (Gf == null || !Gf.containsKey(Integer.valueOf(i))) {
            return "";
        }
        return Gf.get(Integer.valueOf(i));
    }
}
