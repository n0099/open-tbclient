package com.baidu.rtc.logreport;

import com.baidu.rtc.CommonDefine;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ErrorInfoReport {
    public static ErrorInfoReport instance;
    public String appId;
    public String clientIp;
    public int code;
    public String device;
    public String env;
    public String message;
    public long publisherHandleId;
    public long roomId;
    public Map<BigInteger, String> serverIpMap = new ConcurrentHashMap();
    public long sessionId;
    public long userId;
    public long value;
    public String version;

    /* loaded from: classes2.dex */
    public enum ErrorCode {
        LOGIN_ERROR(102, "LOGIN_ERROR"),
        LOGIN_TIMEOUT(102, "LOGIN_TIMEOUT"),
        SIGNAL_CHANNEL_CONNECTION_LOST(103, "SIGNAL_CHANNEL_CONNECTION_LOST"),
        ROOM_LIVE_PUBLISH_FAIL(117, "ROOM_LIVE_PUBLISH_FAIL"),
        ANCHOR_LIVE_PUBLISH_FAIL(117, "ANCHOR_LIVE_PUBLISH_FAIL"),
        ROOM_LIVE_INTRERRUPT(118, "ROOM_LIVE_INTRERRUPT"),
        ANCHOR_LIVE_INTRERRUPT(118, "ANCHOR_LIVE_INTRERRUPT"),
        VIDEO_SENDING_MEDIA_FAILED(201, "VIDEO_SENDING_MEDIA_FAILED"),
        AUDIO_SENDING_MEDIA_FAILED(201, "AUDIO_SENDING_MEDIA_FAILED"),
        PEERCONNECTION_CREATE_ERROR(202, "PEERCONNECTION_CREATE_ERROR"),
        MEDIA_CHANNEL_CONNECTION_LOST(203, "MEDIA_CHANNEL_CONNECTION_LOST"),
        SO_LATER_DOWNLOADING_FAIL(400, "SO_LATER_DOWNLOADING_FAIL"),
        SO_LATER_LOADING_FAIL(401, "SO_LATER_LOADING_FAIL"),
        KEEPALIVE_TIMEOUT(402, "KEEPALIVE_TIMEOUT"),
        USR_ALREADY_EXIST(436, "USR_ALREADY_EXIST"),
        HANG_UP(440, "HANG_UP"),
        SET_EXTERNAL_SURFACE_ERROR(600, "SET_EXTERNAL_SURFACE_ERROR"),
        OTHER_ERROR(700, "OTHER_ERROR"),
        ENTER_FAILED(7000, CommonDefine.SLILoginEvent.ENTER_FAILED),
        ENTER_TIMEOUT(7000, CommonDefine.SLILoginEvent.ENTER_TIMEOUT),
        AUDIO_STUCK(7001, "AUDIO_STUCK"),
        VIDEO_STUCK(7002, "VIDEO_STUCK"),
        BAD_END_TO_END_DELAY(7003, "BAD_END_TO_END_DELAY"),
        BAD_FIRST_FRAME_TIME(7004, "BAD_FIRST_FRAME_TIME");
        
        public int code;
        public String message;

        ErrorCode(int i2, String str) {
            this.code = i2;
            this.message = str;
        }

        public int getErrorCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public static ErrorInfoReport getInstance() {
        if (instance == null) {
            instance = new ErrorInfoReport();
        }
        return instance;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public int getCode() {
        return this.code;
    }

    public String getDevice() {
        return this.device;
    }

    public String getEnv() {
        return this.env;
    }

    public String getMessage() {
        return this.message;
    }

    public long getPublishHandleId() {
        return this.publisherHandleId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public long getSessionId() {
        return this.sessionId;
    }

    public long getUserId() {
        return this.userId;
    }

    public long getValue() {
        return this.value;
    }

    public String getVersion() {
        return this.version;
    }

    public void putServerMap(BigInteger bigInteger, String str) {
        this.serverIpMap.put(bigInteger, str);
    }

    public void reportErrorInfo(ErrorCode errorCode) {
        reportErrorInfo(errorCode, -1L, this.serverIpMap.get(BigInteger.valueOf(this.publisherHandleId)), -1L, this.publisherHandleId);
    }

    public void reportErrorInfo(ErrorCode errorCode, long j, String str, long j2, long j3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("env", this.env);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("version", this.version);
            jSONObject.put("device", RtcLogReport.getDeviceModel());
            jSONObject.put("clientIp", this.clientIp);
            jSONObject.put("serverIp", str);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, this.roomId);
            jSONObject.put("userId", this.userId);
            if (j2 > 0) {
                jSONObject.put("feedId", j2);
            }
            jSONObject.put("sessionId", this.sessionId);
            jSONObject.put("handleId", j3);
            jSONObject.put("code", errorCode.getErrorCode());
            jSONObject.put("message", errorCode.getMessage());
            if (j > 0) {
                jSONObject.put("value", j);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        RtcLogReport.getInstance().report(jSONObject.toString(), 4);
    }

    public void reportErrorInfo(ErrorCode errorCode, long j, BigInteger bigInteger, BigInteger bigInteger2) {
        reportErrorInfo(errorCode, j, this.serverIpMap.containsKey(bigInteger) ? this.serverIpMap.get(bigInteger) : "", bigInteger2.longValue(), bigInteger.longValue());
    }

    public void resetParam() {
        this.env = "";
        this.version = "";
        this.device = "";
        this.clientIp = "";
        this.appId = "";
        this.roomId = -1L;
        this.userId = -1L;
        this.sessionId = -1L;
        this.publisherHandleId = -1L;
        this.code = 700;
        this.message = "";
        this.value = -1L;
        this.serverIpMap.clear();
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setClientIp(String str) {
        this.clientIp = str;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setEnv(String str) {
        this.env = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setPublishHandleId(long j) {
        this.publisherHandleId = j;
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void setSessionId(long j) {
        this.sessionId = j;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setValue(long j) {
        this.value = j;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
