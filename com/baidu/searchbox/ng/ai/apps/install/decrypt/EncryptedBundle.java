package com.baidu.searchbox.ng.ai.apps.install.decrypt;
/* loaded from: classes2.dex */
public class EncryptedBundle {
    public long appID;
    public byte[] cipher = new byte[48];
    public int dataLen;
    public int fileNumber;
    public int header;
    public int indexLen;
    public int versionCode;

    /* loaded from: classes2.dex */
    public static class Index {
        public int offset;
        public String path;
        public int pathLen;
        public int size;
    }
}
