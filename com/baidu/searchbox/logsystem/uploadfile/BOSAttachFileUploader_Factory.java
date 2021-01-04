package com.baidu.searchbox.logsystem.uploadfile;
/* loaded from: classes7.dex */
public class BOSAttachFileUploader_Factory {
    private static volatile BOSAttachFileUploader instance;

    private BOSAttachFileUploader_Factory() {
    }

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
