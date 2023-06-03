package com.baidu.cyberplayer.sdk;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class CyberErrorMapper {
    public static volatile CyberErrorMapper b;
    public Map<Integer, Integer> a = new HashMap<Integer, Integer>() { // from class: com.baidu.cyberplayer.sdk.CyberErrorMapper.1
        {
            put(1, -31201);
            put(100, -31202);
            put(200, -31203);
            put(-1004, -31301);
            put(-1007, -31302);
            put(-1010, -31303);
            put(-10000, -31701);
            put(-10001, -31702);
            put(-10002, -31703);
            put(Integer.valueOf((int) CyberPlayerManager.MEDIA_ERROR_UNDEFINE_AUDIO_NOT_PLAY), -31804);
            put(Integer.valueOf((int) CyberPlayerManager.MEDIA_ERROR_UNDEFINE_VIDEO_NOT_PLAY), -31805);
            put(Integer.MIN_VALUE, -31899);
            put(-111, -34001);
            put(-112, -34002);
            put(Integer.valueOf((int) CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION), -34200);
            put(Integer.valueOf((int) CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED), -34201);
        }
    };

    @Keep
    public static CyberErrorMapper getInstance() {
        if (b == null) {
            synchronized (CyberErrorMapper.class) {
                if (b == null) {
                    b = new CyberErrorMapper();
                }
            }
        }
        return b;
    }

    @Keep
    public int mapErrNo(int i) {
        if (this.a.containsKey(Integer.valueOf(i))) {
            return this.a.get(Integer.valueOf(i)).intValue();
        }
        if (-131 <= i && i <= -1) {
            return i - 31000;
        }
        return -31000;
    }
}
