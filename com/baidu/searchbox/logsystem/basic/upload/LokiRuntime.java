package com.baidu.searchbox.logsystem.basic.upload;

import com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext;
import com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityNeedContext;
import com.baidu.tieba.q.l;
/* loaded from: classes6.dex */
public class LokiRuntime {
    private static final ILokiIdentityContext EMPTY = new ILokiIdentityContext() { // from class: com.baidu.searchbox.logsystem.basic.upload.LokiRuntime.1
        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getZid() {
            return null;
        }

        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getSid() {
            return null;
        }

        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getC3Aid() {
            return null;
        }

        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getSchemeHeader() {
            return null;
        }

        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getFrom() {
            return null;
        }

        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getBDVCInfo() {
            return null;
        }

        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getCfrom() {
            return null;
        }

        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getDeviceScore() {
            return null;
        }
    };

    public static ILokiIdentityContext getIdentityContext() {
        return EMPTY;
    }

    public static ILokiIdentityNeedContext getIdentityNeedContext() {
        return l.dHU();
    }
}
