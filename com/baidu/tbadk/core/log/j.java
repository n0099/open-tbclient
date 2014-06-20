package com.baidu.tbadk.core.log;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class j {
    private static Hashtable<Integer, String> a;

    static {
        a = null;
        if (a == null) {
            a = new Hashtable<>();
            a.put(1001, "上线");
            a.put(1002, "GROUP_UPDATE");
            a.put(1003, "PING");
            a.put(Integer.valueOf((int) MessageTypes.CMD_MESSAGE_SYNC), "MESSAGE_SYNC");
            a.put(Integer.valueOf((int) MessageTypes.CMD_GROUP_CHAT_MSG), "GROUP_CHAT_MSG");
            a.put(Integer.valueOf((int) MessageTypes.CMD_COMMIT_PERSONAL_MSG), "CMD_COMMIT_PERSONAL_MSG");
            a.put(Integer.valueOf((int) MessageTypes.CMD_PUSH_NOTIFY), "PUSH_NOTIFY");
            a.put(Integer.valueOf((int) MessageTypes.CMD_REQUEST_GROUPS_BYFID), "吧的群组列表界面网络请求");
            a.put(Integer.valueOf((int) MessageTypes.CMD_REQUEST_GROUP_INFO_BY_ID), "群资料页界面网络请求");
            a.put(Integer.valueOf((int) MessageTypes.CMD_REQUEST_MEMBERS_BY_ID), "根据群的ID获取群的成员列表");
            a.put(Integer.valueOf((int) MessageTypes.CMD_REMOVE_MEMBERS), "移除群的成员");
            a.put(Integer.valueOf((int) MessageTypes.CMD_REQUEST_GROUPLEVEL_BY_ID), "根据群的id获取群的等级信息");
            a.put(Integer.valueOf((int) MessageTypes.CMD_JOIN_GROUP), "加群申请");
            a.put(Integer.valueOf((int) MessageTypes.CMD_ADD_GROUP_USER), "往群增加成员");
            a.put(Integer.valueOf((int) MessageTypes.CMD_QUERY_GROUP_BY_UID), "进群页面接口");
            a.put(Integer.valueOf((int) MessageTypes.CMD_REQUEST_SEARCH_GROUP), "搜群");
            a.put(Integer.valueOf((int) MessageTypes.CMD_DELETE_GROUP_MSG), "删系统群消息");
            a.put(Integer.valueOf((int) MessageTypes.CMD_GET_USER_PERMISSION), "建群权限获取");
            a.put(Integer.valueOf((int) MessageTypes.CMD_ADD_GROUP), "添加群组");
            a.put(Integer.valueOf((int) MessageTypes.CMD_REPORT_GROUP), "举报群组");
            a.put(Integer.valueOf((int) MessageTypes.CMD_UPDATE_GROUP), "更新群组");
            a.put(Integer.valueOf((int) MessageTypes.CMD_PUSH_COUNT), "反推计数上传");
        }
    }

    public static String a(int i) {
        if (a == null || !a.containsKey(Integer.valueOf(i))) {
            return "";
        }
        return a.get(Integer.valueOf(i));
    }
}
