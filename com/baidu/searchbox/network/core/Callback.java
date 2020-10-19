package com.baidu.searchbox.network.core;

import java.io.IOException;
/* loaded from: classes15.dex */
public interface Callback {
    void onFailure(Call call, IOException iOException);

    void onResponse(Call call, Response response) throws IOException;
}
