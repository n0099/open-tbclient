package com.baidu.nps.interfa;

import android.content.pm.Signature;
/* loaded from: classes10.dex */
public interface ISignatureVerifier {
    boolean checkSignature(String str, Signature[] signatureArr);
}
