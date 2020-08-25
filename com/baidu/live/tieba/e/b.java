package com.baidu.live.tieba.e;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tieba.e.c;
/* loaded from: classes7.dex */
public class b {
    private SensorManager bnK;
    private a bnL;
    private Sensor bnM;
    private c bnP;
    private Activity mActivity;
    private boolean bnN = false;
    private boolean bnO = false;
    private boolean bnQ = false;
    private boolean bnR = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.live.tieba.e.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && b.this.mActivity != null && b.this.bnR) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = b.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!b.this.bnQ) {
                            if (i > 225 && i < 315) {
                                if (requestedOrientation == 8) {
                                    BdUtilHelper.hideSoftKeyPad(b.this.mActivity, b.this.mActivity.getWindow().getDecorView());
                                    b.this.mActivity.setRequestedOrientation(0);
                                    return;
                                }
                                return;
                            } else if (i > 45 && i < 135 && requestedOrientation == 0) {
                                BdUtilHelper.hideSoftKeyPad(b.this.mActivity, b.this.mActivity.getWindow().getDecorView());
                                b.this.mActivity.setRequestedOrientation(8);
                                return;
                            } else {
                                return;
                            }
                        } else if ((i > 235 && i < 305) || (i > 55 && i < 125)) {
                            if (!b.this.bnO) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        BdUtilHelper.hideSoftKeyPad(b.this.mActivity, b.this.mActivity.getWindow().getDecorView());
                                        b.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    BdUtilHelper.hideSoftKeyPad(b.this.mActivity, b.this.mActivity.getWindow().getDecorView());
                                    b.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            b.this.bnN = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!b.this.bnN && requestedOrientation != 1) {
                                BdUtilHelper.hideSoftKeyPad(b.this.mActivity, b.this.mActivity.getWindow().getDecorView());
                                b.this.mActivity.setRequestedOrientation(1);
                            }
                            b.this.bnO = false;
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private c.a bnS = new c.a() { // from class: com.baidu.live.tieba.e.b.2
        @Override // com.baidu.live.tieba.e.c.a
        public void onChange(boolean z) {
            b.this.bnQ = z;
        }
    };

    public b(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.bnK = (SensorManager) activity.getSystemService("sensor");
            this.bnM = this.bnK.getDefaultSensor(1);
            this.bnL = new a(this.mHandler);
            this.bnP = new c(this.mActivity, this.mHandler);
            this.bnP.a(this.bnS);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.bnP);
        }
    }

    public void Oh() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            if (this.mActivity.getRequestedOrientation() == 0) {
                this.mActivity.setRequestedOrientation(1);
                this.bnO = true;
                return;
            }
            this.mActivity.setRequestedOrientation(0);
            this.bnN = true;
        }
    }

    public void Oi() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            this.mActivity.setRequestedOrientation(0);
            this.bnN = true;
        }
    }

    public void Oj() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            this.mActivity.setRequestedOrientation(1);
            this.bnO = true;
        }
    }

    public void start() {
        if (this.bnK != null) {
            this.bnK.registerListener(this.bnL, this.bnM, 2);
        }
    }

    public void stop() {
        if (this.bnK != null) {
            this.bnK.unregisterListener(this.bnL);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.bnP);
        }
    }

    public void cs(boolean z) {
        this.bnR = z;
    }
}
