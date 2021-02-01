package com.baidu.searchbox.http;

import java.io.IOException;
/* loaded from: classes6.dex */
public interface RequestHandler {
    void preExecuteRequest() throws IOException;

    /* loaded from: classes6.dex */
    public static class Default implements RequestHandler {
        @Override // com.baidu.searchbox.http.RequestHandler
        public void preExecuteRequest() throws IOException {
        }
    }
}
