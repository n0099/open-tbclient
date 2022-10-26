package com.baidu.ar.content;

import com.baidu.ar.bean.ARCaseBundleInfo;
import java.util.Map;
/* loaded from: classes.dex */
public interface IARCaseInfo {
    String getARKey();

    int getARType();

    String getAcId();

    String getArCasePath();

    ARCaseBundleInfo getCaseBundleInfo();

    Map getFeatures();

    String[] getMultiResourceUrl();

    String getRedirectUrl();

    String getResourceUrl();

    String getThumbnailUrl();

    String getVersionCode();

    String getZipMd5();

    boolean isHardwareSatisfied();

    boolean isRefused();

    boolean isShowAudioDialog();
}
