package com.baidu.searchbox.devicescore;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class ScoreMetaBuilder {
    public static ScoreMetaData buildLaunchSpeedMetaData(long j) {
        ScoreMetaData scoreMetaData = new ScoreMetaData();
        scoreMetaData.type = IDeviceScore.TYPE_LAUNCH_SPEED;
        HashMap hashMap = new HashMap(1);
        scoreMetaData.params = hashMap;
        hashMap.put(ParamKeys.KEY_LAUNCH_SPEED_LAUNCH_TS, Long.valueOf(j));
        return scoreMetaData;
    }
}
