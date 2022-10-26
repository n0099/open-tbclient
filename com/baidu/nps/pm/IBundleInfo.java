package com.baidu.nps.pm;

import java.util.List;
/* loaded from: classes2.dex */
public interface IBundleInfo {
    int getAbi();

    String getApkPath();

    String getDependence();

    List getDependency();

    String getDescription();

    int getDownloadType();

    String getDownloadUrl();

    String getExt();

    String getIconUrl();

    String getMainBudble();

    String getMd5();

    int getMinVersion();

    String getName();

    String getNetworkStrategy();

    String getPackageName();

    String getPatchMD5();

    String getPatchUrl();

    String getSignature();

    int getSilence();

    int getSilenceUpdate();

    long getSize();

    List getSubBundle();

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

    void setAbi(int i);

    void setApkPath(String str);

    void setBroken(boolean z);

    @Deprecated
    void setDependence(String str);

    void setDependency(List list);

    void setDescription(String str);

    void setDownloadUrl(String str);

    void setExt(String str);

    void setForbidden(boolean z);

    void setForceUpdate(boolean z);

    void setIconUrl(String str);

    void setMainBundle(String str);

    void setMd5(String str);

    void setMinVersion(int i);

    void setName(String str);

    void setNeedRemove(boolean z);

    void setNetworkStrategy(String str);

    void setPackageName(String str);

    void setPatchMD5(String str);

    void setPatchUrl(String str);

    void setRemovable(boolean z);

    void setSignature(String str);

    void setSilence(int i);

    void setSilenceUpdate(int i);

    void setSize(long j);

    void setSubBundle(List list);

    void setType(int i);

    void setUpdateV(long j);

    void setVersionCode(int i);

    void setVisible(boolean z);

    void setWifiOnly(int i);
}
