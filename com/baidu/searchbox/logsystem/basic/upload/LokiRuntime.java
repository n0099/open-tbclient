package com.baidu.searchbox.logsystem.basic.upload;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext;
import com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityNeedContext;
import d.a.k0.y2.l;
@Autowired
/* loaded from: classes2.dex */
public class LokiRuntime {
    public static final ILokiIdentityContext EMPTY = new ILokiIdentityContext() { // from class: com.baidu.searchbox.logsystem.basic.upload.LokiRuntime.1
        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getBDVCInfo() {
            return null;
        }

        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getC3Aid() {
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

        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getFrom() {
            return null;
        }

        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getSchemeHeader() {
            return null;
        }

        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getSid() {
            return null;
        }

        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public String getZid() {
            return null;
        }
    };

    @Inject(force = false)
    public static ILokiIdentityContext getIdentityContext() {
        return EMPTY;
    }

    @Inject
    public static ILokiIdentityNeedContext getIdentityNeedContext() {
        return l.a();
    }
}
