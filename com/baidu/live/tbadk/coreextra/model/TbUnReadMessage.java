package com.baidu.live.tbadk.coreextra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class TbUnReadMessage {
    private String groupMsgName;
    private String groupUpdatesEventContent;
    private String groupUpdatesEventTitle;
    private String groupUpdatesName;
    private String groupValidateName;
    private String latestSummaryGroupMessage;
    private String latestSummaryGroupUpdates;
    private String latestSummaryPrivateMessage;
    private String latestSummaryValidate;
    private String officialMessageContent;
    private String officialMessageTitle;
    private String privateMsgUserName;
    private String strangerMessageContent;
    private int unReadGroupMessageCount = 0;
    private int unReadGroupMessagePreCount = 0;
    private int unReadGroupMessageNotNotifyCount = 0;
    private int unReadGroupUpdatesCount = 0;
    private int unReadGroupUpdatesEventCount = 0;
    private int unReadGroupUpdatesPreCount = 0;
    private int unReadGroupValidateCount = 0;
    private int unReadGroupValidatePreCount = 0;
    private int unReadPrivateMessageCount = 0;
    private int unReadPrivateMessagePreCount = 0;
    private int unReadOfficialMessageCount = 0;
    private int unReadOfficialMessagePreCount = 0;
    private int unReadStrangerMsgCount = 0;
    private int unReadOfficialMergeCount = 0;
    private int unReadStrangerMergeCount = 0;
    private int unReadOfficialAccountCount = 0;
    private boolean isShowInNotifyBar = true;
    private boolean isTipMsg = true;
    private HashMap<String, String> groupGidName = new HashMap<>();
    private HashMap<String, String> privateGidName = new HashMap<>();
    private List<OfficialNotificationData> officialNotificationData = new ArrayList();

    /* loaded from: classes3.dex */
    public static class OfficialNotificationData {
        public String content;
        public String gName;
        public String gid;
        public String isShow;
        public String tickerText;
        public String title;
        public int unReadCount;
        public int unReadPreCount;
        public int userType;
    }

    public void reset() {
        this.groupGidName.clear();
        this.privateGidName.clear();
        this.officialNotificationData.clear();
        this.unReadGroupMessageCount = 0;
        this.unReadGroupMessagePreCount = 0;
        this.unReadGroupMessageNotNotifyCount = 0;
        this.unReadGroupUpdatesCount = 0;
        this.unReadGroupUpdatesEventCount = 0;
        this.unReadGroupUpdatesPreCount = 0;
        this.unReadGroupValidateCount = 0;
        this.unReadGroupValidatePreCount = 0;
        this.unReadPrivateMessageCount = 0;
        this.unReadPrivateMessagePreCount = 0;
        this.unReadOfficialMessageCount = 0;
        this.unReadOfficialMessagePreCount = 0;
        this.unReadStrangerMsgCount = 0;
        this.unReadOfficialMergeCount = 0;
        this.unReadStrangerMergeCount = 0;
        this.unReadOfficialAccountCount = 0;
        this.isShowInNotifyBar = true;
        this.isTipMsg = true;
        this.latestSummaryGroupMessage = null;
        this.latestSummaryGroupUpdates = null;
        this.latestSummaryValidate = null;
        this.latestSummaryPrivateMessage = null;
        this.groupMsgName = null;
        this.groupValidateName = null;
        this.groupUpdatesName = null;
        this.groupUpdatesEventTitle = null;
        this.privateMsgUserName = null;
        this.groupUpdatesEventTitle = null;
        this.groupUpdatesEventContent = null;
        this.officialMessageTitle = null;
        this.officialMessageContent = null;
        this.strangerMessageContent = null;
    }

    public void setLastMsgGroupName() {
        HashMap<String, String> groupGidName = getGroupGidName();
        Set<String> keySet = groupGidName.keySet();
        if (keySet.size() != 1) {
            setGroupMsgName(null);
        } else {
            setGroupMsgName(groupGidName.get(keySet.iterator().next()));
        }
    }

    public void setLastPrivateMsgUserName() {
        HashMap<String, String> privateGidName = getPrivateGidName();
        Set<String> keySet = privateGidName.keySet();
        if (keySet.size() != 1) {
            setPrivateMsgUserName(null);
        } else {
            setPrivateMsgUserName(privateGidName.get(keySet.iterator().next()));
        }
    }

    public int getUnReadGroupMessage() {
        return this.unReadGroupMessageCount;
    }

    public void setUnReadGroupMessage(int i) {
        this.unReadGroupMessageCount = i;
    }

    public int getUnReadGroupUpdates() {
        return this.unReadGroupUpdatesCount;
    }

    public void setUnReadGroupUpdates(int i) {
        this.unReadGroupUpdatesCount = i;
    }

    public int getUnReadGroupUpdatesEventCount() {
        return this.unReadGroupUpdatesEventCount;
    }

    public void setUnReadGroupUpdatesEventCount(int i) {
        this.unReadGroupUpdatesEventCount = i;
    }

    public int getUnReadGroupValidate() {
        return this.unReadGroupValidateCount;
    }

    public void setUnReadGroupValidate(int i) {
        this.unReadGroupValidateCount = i;
    }

    public int getUnReadOfficialMessageCount() {
        return this.unReadOfficialMessageCount;
    }

    public void setUnReadOfficialMessageCount(int i) {
        this.unReadOfficialMessageCount = i;
    }

    public int getUnReadPrivateMessagePreCount() {
        return this.unReadPrivateMessagePreCount;
    }

    public void setUnReadPrivateMessagePreCount(int i) {
        this.unReadPrivateMessagePreCount = i;
    }

    public int getUnReadGroupMessageCount() {
        return this.unReadGroupMessageCount;
    }

    public void setUnReadGroupMessageCount(int i) {
        this.unReadGroupMessageCount = i;
    }

    public String getOfficialMessageTitle() {
        return this.officialMessageTitle;
    }

    public void setOfficialMessageTitle(String str) {
        this.officialMessageTitle = str;
    }

    public String getOfficialMessageContent() {
        return this.officialMessageContent;
    }

    public void setOfficialMessageContent(String str) {
        this.officialMessageContent = str;
    }

    public int getUnReadGroupMessageNotNotify() {
        return this.unReadGroupMessageNotNotifyCount;
    }

    public void setUnReadGroupMessageNotNotify(int i) {
        this.unReadGroupMessageNotNotifyCount = i;
    }

    public boolean isShowInNotifyBar() {
        return this.isShowInNotifyBar;
    }

    public void setShowInNotifyBar(boolean z) {
        this.isShowInNotifyBar = z;
    }

    public boolean isTipMsg() {
        return this.isTipMsg;
    }

    public void setTipMsg(boolean z) {
        this.isTipMsg = z;
    }

    public String getLatestSummary() {
        return this.latestSummaryGroupMessage;
    }

    public void setLatestSummary(String str) {
        this.latestSummaryGroupMessage = str;
    }

    public String getGroupMsgName() {
        return this.groupMsgName;
    }

    public void setGroupMsgName(String str) {
        this.groupMsgName = str;
    }

    public String getGroupValidateName() {
        return this.groupValidateName;
    }

    public void setGroupValidateName(String str) {
        this.groupValidateName = str;
    }

    public int getUnReadGroupMessagePreCount() {
        return this.unReadGroupMessagePreCount;
    }

    public void setUnReadGroupMessagePreCount(int i) {
        this.unReadGroupMessagePreCount = i;
    }

    public String getGroupUpdatesName() {
        return this.groupUpdatesName;
    }

    public void setGroupUpdatesName(String str) {
        this.groupUpdatesName = str;
    }

    public String getGroupUpdatesEventTitle() {
        return this.groupUpdatesEventTitle;
    }

    public void setGroupUpdatesEventTitle(String str) {
        this.groupUpdatesEventTitle = str;
    }

    public String getGroupUpdatesEventContent() {
        return this.groupUpdatesEventContent;
    }

    public void setGroupUpdatesEventContent(String str) {
        this.groupUpdatesEventContent = str;
    }

    public HashMap<String, String> getGroupGidName() {
        return this.groupGidName;
    }

    public void setGroupGidName(HashMap<String, String> hashMap) {
        this.groupGidName = hashMap;
    }

    public int getUnReadGroupUpdatesPre() {
        return this.unReadGroupUpdatesPreCount;
    }

    public void setUnReadGroupUpdatesPre(int i) {
        this.unReadGroupUpdatesPreCount = i;
    }

    public int getUnReadGroupValidatePre() {
        return this.unReadGroupValidatePreCount;
    }

    public void setUnReadGroupValidatePre(int i) {
        this.unReadGroupValidatePreCount = i;
    }

    public int getUnReadOfficialMessagePreCount() {
        return this.unReadOfficialMessagePreCount;
    }

    public void setUnReadOfficialMessagePreCount(int i) {
        this.unReadOfficialMessagePreCount = i;
    }

    public String getLatestSummaryGroupUpdates() {
        return this.latestSummaryGroupUpdates;
    }

    public void setLatestSummaryGroupUpdates(String str) {
        this.latestSummaryGroupUpdates = str;
    }

    public String getLatestSummaryValidate() {
        return this.latestSummaryValidate;
    }

    public void setLatestSummaryValidate(String str) {
        this.latestSummaryValidate = str;
    }

    public int getUnReadPrivateMessageCount() {
        return this.unReadPrivateMessageCount;
    }

    public void setUnReadPrivateMessageCount(int i) {
        this.unReadPrivateMessageCount = i;
    }

    public String getLatestSummaryPrivateMessage() {
        return this.latestSummaryPrivateMessage;
    }

    public void setLatestSummaryPrivateMessage(String str) {
        this.latestSummaryPrivateMessage = str;
    }

    public HashMap<String, String> getPrivateGidName() {
        return this.privateGidName;
    }

    public void setPrivateGidName(HashMap<String, String> hashMap) {
        this.privateGidName = hashMap;
    }

    public String getPrivateMsgUserName() {
        return this.privateMsgUserName;
    }

    public void setPrivateMsgUserName(String str) {
        this.privateMsgUserName = str;
    }

    public int getUnReadStrangerMsgCount() {
        return this.unReadStrangerMsgCount;
    }

    public void setUnReadStrangerMsgCount(int i) {
        this.unReadStrangerMsgCount = i;
    }

    public String getStrangerMessageContent() {
        return this.strangerMessageContent;
    }

    public void setStrangerMessageContent(String str) {
        this.strangerMessageContent = str;
    }

    public int getUnReadOfficialMergeCount() {
        return this.unReadOfficialMergeCount;
    }

    public void setUnReadOfficialMergeCount(int i) {
        this.unReadOfficialMergeCount = i;
    }

    public int getUnReadStrangerMergeCount() {
        return this.unReadStrangerMergeCount;
    }

    public void setUnReadStrangerMergeCount(int i) {
        this.unReadStrangerMergeCount = i;
    }

    public List<OfficialNotificationData> getOfficialNotificationListData() {
        return this.officialNotificationData;
    }

    public int getUnReadOfficialAccountCount() {
        return this.unReadOfficialAccountCount;
    }

    public void setUnReadOfficialAccountCount(int i) {
        this.unReadOfficialAccountCount = i;
    }
}
