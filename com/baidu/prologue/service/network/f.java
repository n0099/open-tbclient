package com.baidu.prologue.service.network;

import java.util.concurrent.atomic.AtomicReference;
import okhttp3.CookieJar;
/* loaded from: classes19.dex */
public interface f {
    public static final AtomicReference<f> cbs = new AtomicReference<>();

    CookieJar cookieJar();
}
