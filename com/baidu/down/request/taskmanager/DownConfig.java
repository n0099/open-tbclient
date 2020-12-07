package com.baidu.down.request.taskmanager;

import com.baidu.down.statistic.ConfigSpeedStat;
/* loaded from: classes6.dex */
public class DownConfig {
    public int mTrafficStatsTag;
    public boolean mDomainNameToIpEnable = false;
    public boolean mHttpRetryStrategyEnable = false;
    public boolean mDownSpeedStatEnable = false;
    public ConfigSpeedStat mConfigSpeedStat = new ConfigSpeedStat();

    public boolean speedStatEnable() {
        return true;
    }
}
