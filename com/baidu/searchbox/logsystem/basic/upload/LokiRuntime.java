package com.baidu.searchbox.logsystem.basic.upload;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext;
import com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityNeedContext;
import com.baidu.tieba.dr9;
import com.baidu.tieba.pr9;
@Autowired
/* loaded from: classes4.dex */
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
        public String getIID() {
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

        @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
        public boolean hasPrivacyAuthority() {
            return true;
        }
    };

    @Inject(force = false)
    public static ILokiIdentityContext getIdentityContext() {
        return dr9.a();
    }

    @Inject
    public static ILokiIdentityNeedContext getIdentityNeedContext() {
        return pr9.a();
    }
}
