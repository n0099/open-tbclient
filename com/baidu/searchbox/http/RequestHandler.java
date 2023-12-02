package com.baidu.searchbox.http;

import java.io.IOException;
/* loaded from: classes4.dex */
public interface RequestHandler {

    /* loaded from: classes4.dex */
    public static class Default implements RequestHandler {
        @Override // com.baidu.searchbox.http.RequestHandler
        public void preExecuteRequest() throws IOException {
        }
    }

    void preExecuteRequest() throws IOException;
}
