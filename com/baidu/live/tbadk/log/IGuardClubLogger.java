package com.baidu.live.tbadk.log;
/* loaded from: classes4.dex */
public interface IGuardClubLogger {
    void doAccessLiveGuardMemberLog(String str, String str2, String str3, String str4);

    void doAccessLiveJoinGuardLog(String str, String str2, String str3, String str4);

    void doClickFollowLog(String str, String str2, String str3, String str4, String str5, String str6);

    void doClickLiveGuardButtonLog(String str, String str2, String str3, String str4);

    void doClickLiveGuardJoinLog(String str, String str2, String str3, String str4, String str5);

    void doClickLiveLeaveGuardLog();

    void doClickLiveRuleLog(String str, String str2, String str3, String str4, String str5);

    void doDisplayLiveGiftPopupLog(String str, String str2, String str3, String str4);

    void doDisplayLiveGuardButtonLog(String str, String str2, String str3, String str4);

    void doDisplayLiveGuardLog(String str, String str2, String str3, String str4, String str5);

    void doDisplayLiveLeaveGuardLog();

    void doStayTimeLiveGuardMemberLog(String str, String str2, String str3, long j, String str4);

    void doStayTimeLiveJoinGuardLog(String str, String str2, String str3, long j, String str4);
}
