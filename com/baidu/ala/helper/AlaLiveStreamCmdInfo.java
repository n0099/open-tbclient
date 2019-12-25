package com.baidu.ala.helper;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class AlaLiveStreamCmdInfo {
    public int appStatus;
    public boolean isCalling;
    public boolean isConnect;
    public int isDrop;
    public boolean isHardEncode;
    public int netType;
    public String phoneModel;
    public int platformType;
    public int recordType;
    public int sessionLine;
    public String streamIp;
    public int streamLevel;
    public String streamSpeed;
    public int streamStatus;

    public void fillByStatus(String str, String str2, String str3, String str4) {
        byte[] bytes;
        this.streamIp = str2;
        this.streamSpeed = str4;
        this.phoneModel = str3;
        if (!TextUtils.isEmpty(str) && (bytes = str.getBytes()) != null && bytes.length >= 4) {
            this.platformType = bytes[0] & 7;
            this.isHardEncode = (bytes[0] & 8) != 0;
            this.streamStatus = bytes[0] & 240;
            this.netType = (bytes[1] & 240) >> 4;
            this.sessionLine = bytes[1] & 15;
            this.streamLevel = (bytes[2] & 240) >> 4;
            this.isConnect = (bytes[2] & 8) != 0;
            this.isCalling = (bytes[2] & 4) != 0;
            this.appStatus = bytes[2] & 3;
            this.recordType = (bytes[3] & 240) >> 4;
            this.isDrop = bytes[3] & 15;
        }
    }
}
