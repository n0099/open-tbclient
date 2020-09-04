package com.baidu.rtc.utils;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
/* loaded from: classes11.dex */
public class b {
    private a bPj;
    private boolean mIsRegisted = false;
    private TelephonyManager mTelephonyManager = null;
    private boolean mIsCalling = false;
    private PhoneStateListener mPhoneStateListener = new PhoneStateListener() { // from class: com.baidu.rtc.utils.b.1
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            super.onCallStateChanged(i, str);
            switch (i) {
                case 0:
                    if (b.this.bPj != null && b.this.mIsCalling) {
                        b.this.bPj.onInterruptionEnd();
                        b.this.mIsCalling = false;
                        return;
                    }
                    return;
                case 1:
                    b.this.mIsCalling = true;
                    if (b.this.bPj != null) {
                        b.this.bPj.onInterruptionBegin();
                        return;
                    }
                    return;
                case 2:
                    b.this.mIsCalling = true;
                    if (b.this.bPj != null) {
                        b.this.bPj.onInterruptionBegin();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void onInterruptionBegin();

        void onInterruptionEnd();
    }

    public b(a aVar) {
        this.bPj = null;
        this.bPj = aVar;
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
