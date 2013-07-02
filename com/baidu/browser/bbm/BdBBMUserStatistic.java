package com.baidu.browser.bbm;

import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class BdBBMUserStatistic {
    public static final short DEFAULT_INPUTMETHOD = 4;
    public static final short FF_VERSION = 0;
    public static final short FRAME_VERSION = 1;
    private static final short SHORT_TYPE_SPEC_URLS_CLICKS = 0;
    private static final short SHORT_TYPE_WEB_MAIN_CLICKS = 1;
    private static final short SHORT_TYPE_ZEUS_FAIL_STATUS = 3;
    private static final short SHORT_TYPE_ZEUS_INSTALLED = 2;
    public static final short TN_NUMBER = 3;
    public static final short ZEUS_VERSION = 2;

    byte[] getCommonInfo() {
        return null;
    }

    private String convertVersion(String str) {
        if (str != null) {
            return str.replace(".", "-");
        }
        return str;
    }

    private void writeShortTypeInfo(short s, short s2, ByteArrayOutputStream byteArrayOutputStream) {
        try {
            byteArrayOutputStream.write(BdBBMUtils.shortToBytes(s));
            byteArrayOutputStream.write(BdBBMUtils.intToBytes(2));
            byteArrayOutputStream.write(BdBBMUtils.shortToBytes(s2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
