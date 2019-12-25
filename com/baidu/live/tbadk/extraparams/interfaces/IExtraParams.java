package com.baidu.live.tbadk.extraparams.interfaces;

import java.util.Map;
/* loaded from: classes2.dex */
public interface IExtraParams {
    String getCuid();

    boolean isShouldShowNotWifiToastByAudience();

    boolean isShouldShowNotWifiToastByMaster();

    Map<String, Object> process(Map<String, Object> map);

    String replaceFlvUrl(String str);

    String replaceHslUrl(String str);

    String replacePushUrl(String str);

    String replaceRtmpUrl(String str);
}
