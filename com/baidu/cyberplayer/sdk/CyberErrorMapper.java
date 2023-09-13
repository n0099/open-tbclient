package com.baidu.cyberplayer.sdk;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class CyberErrorMapper {
    public static final int CYBER_ERROR_AUDIO_NOT_PLAY = -31804;
    public static final int CYBER_ERROR_CREATE_ASYNC_PLAYER_FAIL = -34002;
    public static final int CYBER_ERROR_MP_FOR_FUTURE = -31000;
    public static final int CYBER_ERROR_MP_IO = -31301;
    public static final int CYBER_ERROR_MP_LOWLEVEL_SYSTEM = -31899;
    public static final int CYBER_ERROR_MP_MALFORMED = -31302;
    public static final int CYBER_ERROR_MP_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = -31203;
    public static final int CYBER_ERROR_MP_SERVER_DIED = -31202;
    public static final int CYBER_ERROR_MP_UNKNOWN = -31201;
    public static final int CYBER_ERROR_MP_UNSUPPORTED = -31303;
    public static final int CYBER_ERROR_OPEN_VIDEO_FAIL = -34001;
    public static final int CYBER_ERROR_REMOTE_DIED = -34201;
    public static final int CYBER_ERROR_REMOTE_EXCEPTION = -34200;
    public static final int CYBER_ERROR_SETDATASOURCE_EXCEPTION = -31702;
    public static final int CYBER_ERROR_STATE_EXCEPTION = -31703;
    public static final int CYBER_ERROR_SURFACE_EXCEPTION = -31701;
    public static final int CYBER_ERROR_VIDEO_NOT_PLAY = -31805;
    public static volatile CyberErrorMapper sInstance;
    public Map<Integer, Integer> errNoMap = new HashMap<Integer, Integer>() { // from class: com.baidu.cyberplayer.sdk.CyberErrorMapper.1
        {
            put(1, Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_MP_UNKNOWN));
            put(100, Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_MP_SERVER_DIED));
            put(200, Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_MP_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK));
            put(-1004, Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_MP_IO));
            put(-1007, Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_MP_MALFORMED));
            put(-1010, Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_MP_UNSUPPORTED));
            put(-10000, Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_SURFACE_EXCEPTION));
            put(-10001, Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_SETDATASOURCE_EXCEPTION));
            put(-10002, Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_STATE_EXCEPTION));
            put(Integer.valueOf((int) CyberPlayerManager.MEDIA_ERROR_UNDEFINE_AUDIO_NOT_PLAY), Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_AUDIO_NOT_PLAY));
            put(Integer.valueOf((int) CyberPlayerManager.MEDIA_ERROR_UNDEFINE_VIDEO_NOT_PLAY), Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_VIDEO_NOT_PLAY));
            put(Integer.MIN_VALUE, Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_MP_LOWLEVEL_SYSTEM));
            put(-111, Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_OPEN_VIDEO_FAIL));
            put(-112, Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_CREATE_ASYNC_PLAYER_FAIL));
            put(Integer.valueOf((int) CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION), Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_REMOTE_EXCEPTION));
            put(Integer.valueOf((int) CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED), Integer.valueOf((int) CyberErrorMapper.CYBER_ERROR_REMOTE_DIED));
        }
    };

    @Keep
    public static CyberErrorMapper getInstance() {
        if (sInstance == null) {
            synchronized (CyberErrorMapper.class) {
                if (sInstance == null) {
                    sInstance = new CyberErrorMapper();
                }
            }
        }
        return sInstance;
    }

    @Keep
    public int mapErrNo(int i) {
        if (this.errNoMap.containsKey(Integer.valueOf(i))) {
            return this.errNoMap.get(Integer.valueOf(i)).intValue();
        }
        if (-131 <= i && i <= -1) {
            return i + CYBER_ERROR_MP_FOR_FUTURE;
        }
        return CYBER_ERROR_MP_FOR_FUTURE;
    }
}
