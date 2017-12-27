package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.annotation.RestrictTo;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
@RestrictTo
/* loaded from: classes2.dex */
public final class FingerprintManagerCompatApi23 {
    private static FingerprintManager T(Context context) {
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    public static boolean hasEnrolledFingerprints(Context context) {
        return T(context).hasEnrolledFingerprints();
    }

    public static boolean isHardwareDetected(Context context) {
        return T(context).isHardwareDetected();
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
        T(context).authenticate(b(cryptoObject), (CancellationSignal) obj, i, a(authenticationCallback), handler);
    }

    private static FingerprintManager.CryptoObject b(CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CryptoObject a(FingerprintManager.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    private static FingerprintManager.AuthenticationCallback a(final AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback() { // from class: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.1
            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationError(int i, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationError(i, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationHelp(int i, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationHelp(i, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResultInternal(FingerprintManagerCompatApi23.a(authenticationResult.getCryptoObject())));
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationFailed() {
                AuthenticationCallback.this.onAuthenticationFailed();
            }
        };
    }

    /* loaded from: classes2.dex */
    public static class CryptoObject {
        private final Signature wP;
        private final Cipher wQ;
        private final Mac wR;

        public CryptoObject(Signature signature) {
            this.wP = signature;
            this.wQ = null;
            this.wR = null;
        }

        public CryptoObject(Cipher cipher) {
            this.wQ = cipher;
            this.wP = null;
            this.wR = null;
        }

        public CryptoObject(Mac mac) {
            this.wR = mac;
            this.wQ = null;
            this.wP = null;
        }

        public Signature getSignature() {
            return this.wP;
        }

        public Cipher getCipher() {
            return this.wQ;
        }

        public Mac getMac() {
            return this.wR;
        }
    }

    /* loaded from: classes2.dex */
    public static final class AuthenticationResultInternal {
        private CryptoObject wT;

        public AuthenticationResultInternal(CryptoObject cryptoObject) {
            this.wT = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.wT;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResultInternal authenticationResultInternal) {
        }

        public void onAuthenticationFailed() {
        }
    }
}
