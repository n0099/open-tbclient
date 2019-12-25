package com.baidu.ala.player;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
/* loaded from: classes2.dex */
public class CallStateReceiver {
    private Callback mCallback;
    private boolean mIsRegisted = false;
    private TelephonyManager mTelephonyManager = null;
    private boolean mIsCalling = false;
    private PhoneStateListener mPhoneStateListener = new PhoneStateListener() { // from class: com.baidu.ala.player.CallStateReceiver.1
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            super.onCallStateChanged(i, str);
            switch (i) {
                case 0:
                    if (CallStateReceiver.this.mCallback != null && CallStateReceiver.this.mIsCalling) {
                        CallStateReceiver.this.mCallback.onInterruptionEnd();
                        CallStateReceiver.this.mIsCalling = false;
                        return;
                    }
                    return;
                case 1:
                    CallStateReceiver.this.mIsCalling = true;
                    if (CallStateReceiver.this.mCallback != null) {
                        CallStateReceiver.this.mCallback.onInterruptionBegin();
                        return;
                    }
                    return;
                case 2:
                    CallStateReceiver.this.mIsCalling = true;
                    if (CallStateReceiver.this.mCallback != null) {
                        CallStateReceiver.this.mCallback.onInterruptionBegin();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface Callback {
        void onInterruptionBegin();

        void onInterruptionEnd();
    }

    public CallStateReceiver(Callback callback) {
        this.mCallback = null;
        this.mCallback = callback;
    }

    public void register(Context context) {
        if (context != null) {
            try {
                this.mTelephonyManager = (TelephonyManager) context.getSystemService("phone");
                this.mTelephonyManager.listen(this.mPhoneStateListener, 32);
                this.mIsRegisted = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void unregister(Context context) {
        try {
            if (this.mIsRegisted) {
                this.mTelephonyManager.listen(this.mPhoneStateListener, 0);
            }
            this.mTelephonyManager = null;
            this.mPhoneStateListener = null;
            this.mIsRegisted = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
