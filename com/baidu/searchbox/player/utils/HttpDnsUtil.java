package com.baidu.searchbox.player.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.List;
/* loaded from: classes4.dex */
public class HttpDnsUtil {
    public static void preResolveHosts(@Nullable List<String> list) {
        CyberPlayerManager.preResolveHosts(list);
    }

    public static void setHttpDNS2(@NonNull CyberPlayerManager.HttpDNS2 httpDNS2) {
        CyberPlayerManager.setHttpDNS2(httpDNS2);
    }
}
