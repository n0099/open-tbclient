package com.baidu.apollon.statistics;
/* loaded from: classes2.dex */
public abstract class StatisticsSettings {
    public abstract String getCommonHeader();

    public String getCrashDataHeader() {
        return null;
    }

    public String getPackagesConcerned() {
        return null;
    }

    public abstract String getStrategy();

    public abstract String getUploadUrl();

    public boolean isEnableCrashHandler() {
        return true;
    }

    public boolean isEnabled() {
        return g.a().e();
    }

    public boolean isForbidToUploadNow() {
        return false;
    }

    public boolean isReleaseVersion() {
        return true;
    }
}
