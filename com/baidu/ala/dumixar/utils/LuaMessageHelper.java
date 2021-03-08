package com.baidu.ala.dumixar.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class LuaMessageHelper {
    public static final String KEY_EVENT_NAME = "event_name";
    public static final String KEY_GAME_SCORE = "game_score";
    public static final String KEY_IS_DEFAULT_CHILD = "isDefaultChild";
    public static final String KEY_POSITION_X = "position_x";
    public static final String KEY_POSITION_Y = "position_y";
    public static final String KEY_TEXT_CONTENT = "text_content";
    public static HashMap<String, HashMap> sLuaMessageHashMap = new HashMap<>();

    /* loaded from: classes5.dex */
    public interface ILuaMessageReadCallback {
        void onCaseReset();

        void onChildStatus(boolean z);

        void onNeedFace();

        void onRecordEnd();

        void onScoreInvoke(String str);

        void onShakeInvoke();

        void onShowTextInvoke(String str);
    }

    /* loaded from: classes5.dex */
    public @interface KEY_RECEIVE_LUA_MESSAGE {
        public static final String CASE_RESET = "case_reset";
        public static final String CHILD_STATUS = "child_status";
        public static final String GAME_END = "game_end";
        public static final String GAME_PAUSE = "game_pause";
        public static final String NEED_FACE = "need_face";
        public static final String PHONE_SHAKE = "phone_shake";
        public static final String SHOW_TEXT = "show_text";
    }

    /* loaded from: classes5.dex */
    public @interface KEY_SEND_LUA_MESSAGE {
        public static final String CAPTURE_TIMER_CLEAR = "capture_timer_clear";
        public static final String CAPTURE_TIMER_START = "capture_timer_start";
        public static final String PAUSE_RECORD = "pauseRecord";
        public static final String RESET_RECORD = "resetRecord";
        public static final String START_OVER_RECORD = "startOverRecord";
        public static final String START_RECORD = "startRecord";
    }

    private static boolean isEmptyParams(HashMap<String, Object> hashMap) {
        return hashMap == null || hashMap.size() <= 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void readLuaMessage(HashMap<String, Object> hashMap, ILuaMessageReadCallback iLuaMessageReadCallback) {
        Object obj;
        char c;
        if (!isEmptyParams(hashMap) && iLuaMessageReadCallback != null && (obj = hashMap.get(KEY_EVENT_NAME)) != null && (obj instanceof String)) {
            String str = (String) obj;
            switch (str.hashCode()) {
                case -1903331025:
                    if (str.equals(KEY_RECEIVE_LUA_MESSAGE.SHOW_TEXT)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1768834290:
                    if (str.equals(KEY_RECEIVE_LUA_MESSAGE.GAME_END)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -708270859:
                    if (str.equals(KEY_RECEIVE_LUA_MESSAGE.PHONE_SHAKE)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -672934016:
                    if (str.equals(KEY_RECEIVE_LUA_MESSAGE.CASE_RESET)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 902635637:
                    if (str.equals(KEY_RECEIVE_LUA_MESSAGE.CHILD_STATUS)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 967087977:
                    if (str.equals(KEY_RECEIVE_LUA_MESSAGE.GAME_PAUSE)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1076032614:
                    if (str.equals(KEY_RECEIVE_LUA_MESSAGE.NEED_FACE)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    if (hashMap.get(KEY_TEXT_CONTENT) instanceof String) {
                        iLuaMessageReadCallback.onShowTextInvoke((String) hashMap.get(KEY_TEXT_CONTENT));
                        return;
                    }
                    return;
                case 1:
                    iLuaMessageReadCallback.onShakeInvoke();
                    return;
                case 2:
                    if (hashMap.get(KEY_GAME_SCORE) != null) {
                        iLuaMessageReadCallback.onScoreInvoke(hashMap.get(KEY_GAME_SCORE).toString());
                        return;
                    }
                    return;
                case 3:
                    if (hashMap.get(KEY_GAME_SCORE) != null) {
                        iLuaMessageReadCallback.onScoreInvoke(hashMap.get(KEY_GAME_SCORE).toString());
                    }
                    iLuaMessageReadCallback.onRecordEnd();
                    return;
                case 4:
                    iLuaMessageReadCallback.onCaseReset();
                    return;
                case 5:
                    iLuaMessageReadCallback.onNeedFace();
                    return;
                case 6:
                    if (hashMap.get(KEY_IS_DEFAULT_CHILD) != null) {
                        String obj2 = hashMap.get(KEY_IS_DEFAULT_CHILD).toString();
                        iLuaMessageReadCallback.onChildStatus(TextUtils.equals(obj2, "1.0") || TextUtils.equals(obj2, "1"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static HashMap getLuaMessageByType(@KEY_SEND_LUA_MESSAGE String str) {
        if (sLuaMessageHashMap.get(str) != null) {
            return sLuaMessageHashMap.get(str);
        }
        HashMap hashMap = null;
        char c = 65535;
        switch (str.hashCode()) {
            case -1909077165:
                if (str.equals(KEY_SEND_LUA_MESSAGE.START_RECORD)) {
                    c = 0;
                    break;
                }
                break;
            case -1848594969:
                if (str.equals(KEY_SEND_LUA_MESSAGE.PAUSE_RECORD)) {
                    c = 1;
                    break;
                }
                break;
            case -815530368:
                if (str.equals(KEY_SEND_LUA_MESSAGE.RESET_RECORD)) {
                    c = 2;
                    break;
                }
                break;
            case -793791417:
                if (str.equals(KEY_SEND_LUA_MESSAGE.START_OVER_RECORD)) {
                    c = 5;
                    break;
                }
                break;
            case 473974106:
                if (str.equals(KEY_SEND_LUA_MESSAGE.CAPTURE_TIMER_CLEAR)) {
                    c = 3;
                    break;
                }
                break;
            case 488985455:
                if (str.equals(KEY_SEND_LUA_MESSAGE.CAPTURE_TIMER_START)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                hashMap = getRecordStartLua();
                break;
            case 1:
                hashMap = getRecordPauseLua();
                break;
            case 2:
                hashMap = getRecordResetLua();
                break;
            case 3:
                hashMap = getCaptureTimerClearLua();
                break;
            case 4:
                hashMap = getCaptureTimerStartLua();
                break;
            case 5:
                hashMap = getRecordStartOverLua();
                break;
        }
        if (hashMap != null) {
            sLuaMessageHashMap.put(str, hashMap);
            return hashMap;
        }
        return hashMap;
    }

    private static HashMap getRecordStartLua() {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", "game_start");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(KEY_EVENT_NAME, "recorder_video");
        hashMap2.put("event_data", hashMap);
        return hashMap2;
    }

    private static HashMap getRecordPauseLua() {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", KEY_RECEIVE_LUA_MESSAGE.GAME_PAUSE);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(KEY_EVENT_NAME, "recorder_video");
        hashMap2.put("event_data", hashMap);
        return hashMap2;
    }

    private static HashMap getRecordResetLua() {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", "game_reset");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(KEY_EVENT_NAME, "recorder_video");
        hashMap2.put("event_data", hashMap);
        return hashMap2;
    }

    private static HashMap getRecordStartOverLua() {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", "game_start_over");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(KEY_EVENT_NAME, "recorder_video");
        hashMap2.put("event_data", hashMap);
        return hashMap2;
    }

    private static HashMap getCaptureTimerClearLua() {
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_EVENT_NAME, KEY_SEND_LUA_MESSAGE.CAPTURE_TIMER_CLEAR);
        return hashMap;
    }

    private static HashMap getCaptureTimerStartLua() {
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_EVENT_NAME, KEY_SEND_LUA_MESSAGE.CAPTURE_TIMER_START);
        return hashMap;
    }

    private static HashMap getRecordEndLua() {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", KEY_RECEIVE_LUA_MESSAGE.GAME_END);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(KEY_EVENT_NAME, "recorder_video");
        hashMap2.put("event_data", hashMap);
        return hashMap2;
    }

    private static HashMap getRecordShakeLua() {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", KEY_RECEIVE_LUA_MESSAGE.PHONE_SHAKE);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(KEY_EVENT_NAME, "recorder_video");
        hashMap2.put("event_data", hashMap);
        return hashMap2;
    }

    private static HashMap getRecordTextLua() {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", KEY_RECEIVE_LUA_MESSAGE.SHOW_TEXT);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(KEY_EVENT_NAME, "recorder_video");
        hashMap2.put("event_data", hashMap);
        return hashMap2;
    }

    public static HashMap sendAlbumPathToLua(String str, int i, int i2, long j, int i3) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            hashMap.put("is_absolute", 0);
            hashMap.put("texture_path", "null");
        } else if (new File(str).exists()) {
            hashMap.put("is_absolute", 1);
            hashMap.put("texture_path", str);
            hashMap.put("width", Integer.valueOf(i));
            hashMap.put("height", Integer.valueOf(i2));
            hashMap.put(TiebaInitialize.LogFields.SIZE, Long.valueOf(j));
            hashMap.put("orientation", Integer.valueOf(i3));
        } else {
            hashMap.put("is_absolute", 0);
            hashMap.put("texture_path", "null");
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(KEY_EVENT_NAME, "replace_texture");
        hashMap2.put("event_data", hashMap);
        return hashMap2;
    }

    public static HashMap sendMeesage2LuaForVideoQualityDebug(String str, float f) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, Float.valueOf(f));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(KEY_EVENT_NAME, "on_quality_props_update");
        hashMap2.put("event_data", hashMap);
        return hashMap2;
    }

    public static HashMap sendMeesage2LuaForVideoQualityDebug(HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put(KEY_EVENT_NAME, "on_quality_props_update");
        hashMap2.put("event_data", hashMap);
        return hashMap2;
    }
}
