package com.baidu.live.tbadk.encryption;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes7.dex */
public class EncryptionHelper {
    private static Encryptor encryptor;

    public static void setEncryptor(Encryptor encryptor2) {
        encryptor = encryptor2;
    }

    public static String getEncryptionUserId(String str) {
        return encryptor != null ? encryptor.doEncrypt(str) : ExtraParamsManager.getEncryptionUserId(str);
    }

    public static String getDecryptUserId(String str) {
        return encryptor != null ? encryptor.doDecrypt(str) : ExtraParamsManager.getDecryptUserId(str);
    }
}
