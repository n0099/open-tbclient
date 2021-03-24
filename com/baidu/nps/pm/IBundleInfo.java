package com.baidu.nps.pm;
/* loaded from: classes.dex */
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

    long getSize();

    int getType();

    long getUpdateV();

    int getVersionCode();

    boolean isBroken();

    boolean isForbidden();

    boolean isNeedRemove();

    boolean isRemovable();

    boolean isVisible();

    boolean needForceUpdate();

    void setAbi(int i);

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

    void setMinVersion(int i);

    void setName(String str);

    void setNeedRemove(boolean z);

    void setPackageName(String str);

    void setRemovable(boolean z);

    void setSignature(String str);

    void setSize(long j);

    void setType(int i);

    void setUpdateV(long j);

    void setVersionCode(int i);

    void setVisible(boolean z);
}
