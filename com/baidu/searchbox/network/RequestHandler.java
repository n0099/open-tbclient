package com.baidu.searchbox.network;

import java.io.IOException;
/* loaded from: classes11.dex */
public interface RequestHandler {
    void preExecuteRequest() throws IOException;

    /* loaded from: classes11.dex */
    public static class Default implements RequestHandler {
        @Override // com.baidu.searchbox.network.RequestHandler
        public void preExecuteRequest() throws IOException {
        }
    }
}
