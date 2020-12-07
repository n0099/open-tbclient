package com.baidu.searchbox.logsystem.basic.upload;

import java.io.IOException;
/* loaded from: classes15.dex */
public abstract class ResponseWrapper {
    public abstract void close();

    public abstract String getBody() throws IOException;

    public abstract String getMessage();

    public abstract boolean isSuccessful();
}
