package com.baidu.searchbox.network.core;

import android.support.annotation.Nullable;
import com.baidu.searchbox.network.core.connect.Connection;
import java.io.IOException;
/* loaded from: classes14.dex */
public interface Interceptor {

    /* loaded from: classes14.dex */
    public interface Chain {
        Call call();

        @Nullable
        Connection connection();

        Response proceed(Request request) throws IOException;

        Request request();
    }

    Response intercept(Chain chain) throws IOException;
}
