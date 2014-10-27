package com.baidu.tbadk.core.log;

import java.util.Hashtable;
/* loaded from: classes.dex */
public class b {
    private static Hashtable<Integer, String> BQ;

    static {
        BQ = null;
        if (BQ == null) {
            BQ = new Hashtable<>();
            BQ.put(1001, "上线");
            BQ.put(1002, "GROUP_UPDATE");
            BQ.put(1003, "PING");
            BQ.put(202003, "MESSAGE_SYNC");
            BQ.put(202001, "GROUP_CHAT_MSG");
            BQ.put(205001, "CMD_COMMIT_PERSONAL_MSG");
            BQ.put(202006, "PUSH_NOTIFY");
            BQ.put(103002, "吧的群组列表界面网络请求");
            BQ.put(103004, "群资料页界面网络请求");
            BQ.put(103005, "根据群的ID获取群的成员列表");
            BQ.put(103112, "移除群的成员");
            BQ.put(103006, "根据群的id获取群的等级信息");
            BQ.put(103110, "加群申请");
            BQ.put(103111, "往群增加成员");
            BQ.put(103003, "进群页面接口");
            BQ.put(103007, "搜群");
            BQ.put(202004, "删系统群消息");
            BQ.put(103008, "建群权限获取");
            BQ.put(103101, "添加群组");
            BQ.put(103103, "举报群组");
            BQ.put(103102, "更新群组");
            BQ.put(202101, "反推计数上传");
        }
    }

    public static String bj(int i) {
        if (BQ == null || !BQ.containsKey(Integer.valueOf(i))) {
            return "";
        }
        return BQ.get(Integer.valueOf(i));
    }
}
