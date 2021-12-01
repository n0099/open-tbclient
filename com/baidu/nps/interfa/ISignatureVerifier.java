package com.baidu.nps.interfa;

import android.content.pm.Signature;
/* loaded from: classes8.dex */
public interface ISignatureVerifier {
    boolean checkSignature(String str, Signature[] signatureArr);
}
