package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23;
import android.support.v4.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
/* loaded from: classes2.dex */
public final class FingerprintManagerCompat {
    static final b wH;
    private Context mContext;

    /* loaded from: classes2.dex */
    private interface b {
        void a(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler);

        boolean hasEnrolledFingerprints(Context context);

        boolean isHardwareDetected(Context context);
    }

    public static FingerprintManagerCompat from(Context context) {
        return new FingerprintManagerCompat(context);
    }

    private FingerprintManagerCompat(Context context) {
        this.mContext = context;
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            wH = new a();
        } else {
            wH = new c();
        }
    }

    public boolean hasEnrolledFingerprints() {
        return wH.hasEnrolledFingerprints(this.mContext);
    }

    public boolean isHardwareDetected() {
        return wH.isHardwareDetected(this.mContext);
    }

    public void authenticate(CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        wH.a(this.mContext, cryptoObject, i, cancellationSignal, authenticationCallback, handler);
    }

    /* loaded from: classes2.dex */
    public static class CryptoObject {
        private final Signature wK;
        private final Cipher wL;
        private final Mac wM;

        public CryptoObject(Signature signature) {
            this.wK = signature;
            this.wL = null;
            this.wM = null;
        }

        public CryptoObject(Cipher cipher) {
            this.wL = cipher;
            this.wK = null;
            this.wM = null;
        }

        public CryptoObject(Mac mac) {
            this.wM = mac;
            this.wL = null;
            this.wK = null;
        }

        public Signature getSignature() {
            return this.wK;
        }

        public Cipher getCipher() {
            return this.wL;
        }

        public Mac getMac() {
            return this.wM;
        }
    }

    /* loaded from: classes2.dex */
    public static final class AuthenticationResult {
        private CryptoObject wJ;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.wJ = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.wJ;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }

        public void onAuthenticationFailed() {
        }
    }

    /* loaded from: classes2.dex */
    private static class c implements b {
        @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompat.b
        public boolean hasEnrolledFingerprints(Context context) {
            return false;
        }

        @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompat.b
        public boolean isHardwareDetected(Context context) {
            return false;
        }

        @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompat.b
        public void a(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        }
    }

    /* loaded from: classes2.dex */
    private static class a implements b {
        @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompat.b
        public boolean hasEnrolledFingerprints(Context context) {
            return FingerprintManagerCompatApi23.hasEnrolledFingerprints(context);
        }

        @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompat.b
        public boolean isHardwareDetected(Context context) {
            return FingerprintManagerCompatApi23.isHardwareDetected(context);
        }

        @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompat.b
        public void a(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
            FingerprintManagerCompatApi23.authenticate(context, a(cryptoObject), i, cancellationSignal != null ? cancellationSignal.getCancellationSignalObject() : null, a(authenticationCallback), handler);
        }

        private static FingerprintManagerCompatApi23.CryptoObject a(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        static CryptoObject a(FingerprintManagerCompatApi23.CryptoObject cryptoObject) {
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

        private static FingerprintManagerCompatApi23.AuthenticationCallback a(final AuthenticationCallback authenticationCallback) {
            return new FingerprintManagerCompatApi23.AuthenticationCallback() { // from class: android.support.v4.hardware.fingerprint.FingerprintManagerCompat.a.1
                @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationError(int i, CharSequence charSequence) {
                    AuthenticationCallback.this.onAuthenticationError(i, charSequence);
                }

                @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationHelp(int i, CharSequence charSequence) {
                    AuthenticationCallback.this.onAuthenticationHelp(i, charSequence);
                }

                @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationSucceeded(FingerprintManagerCompatApi23.AuthenticationResultInternal authenticationResultInternal) {
                    AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(a.a(authenticationResultInternal.getCryptoObject())));
                }

                @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationFailed() {
                    AuthenticationCallback.this.onAuthenticationFailed();
                }
            };
        }
    }
}
