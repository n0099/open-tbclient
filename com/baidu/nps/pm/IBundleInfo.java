package com.baidu.nps.pm;
/* loaded from: classes10.dex */
public interface IBundleInfo {
    int getAbi();

    String getApkPath();

    String getDependence();

    String getDescription();

    String getDownloadUrl();

    String getExt();

    String getIconUrl();

    String getMd5();

    int getMinVersion();

    String getName();

    String getPackageName();

    String getSignature();

    int getSilence();

    int getSilenceUpdate();

    long getSize();

    int getType();

    long getUpdateV();

    int getVersionCode();

    int getWifiOnly();

    boolean isBroken();

    boolean isForbidden();

    boolean isNeedRemove();

    boolean isRemovable();

    boolean isVisible();

    boolean needForceUpdate();

    void setAbi(int i2);

    void setApkPath(String str);

    void setBroken(boolean z);

    void setDependence(String str);

    void setDescription(String str);

    void setDownloadUrl(String str);

    void setExt(String str);

    void setForbidden(boolean z);

    void setForceUpdate(boolean z);

    void setIconUrl(String str);

    void setMd5(String str);

    void setMinVersion(int i2);

    void setName(String str);

    void setNeedRemove(boolean z);

    void setPackageName(String str);

    void setRemovable(boolean z);

    void setSignature(String str);

    void setSilence(int i2);

    void setSilenceUpdate(int i2);

    void setSize(long j2);

    void setType(int i2);

    void setUpdateV(long j2);

    void setVersionCode(int i2);

    void setVisible(boolean z);

    void setWifiOnly(int i2);
}
