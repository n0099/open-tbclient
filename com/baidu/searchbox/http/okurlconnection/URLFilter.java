package com.baidu.searchbox.http.okurlconnection;

import java.io.IOException;
import java.net.URL;
/* loaded from: classes2.dex */
public interface URLFilter {
    void checkURLPermitted(URL url) throws IOException;
}
