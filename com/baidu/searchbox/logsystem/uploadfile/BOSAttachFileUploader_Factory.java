package com.baidu.searchbox.logsystem.uploadfile;
/* loaded from: classes4.dex */
public class BOSAttachFileUploader_Factory {
    public static volatile BOSAttachFileUploader instance;

    public static synchronized BOSAttachFileUploader get() {
        BOSAttachFileUploader bOSAttachFileUploader;
        synchronized (BOSAttachFileUploader_Factory.class) {
            if (instance == null) {
                instance = new BOSAttachFileUploader();
            }
            bOSAttachFileUploader = instance;
        }
        return bOSAttachFileUploader;
    }
}
