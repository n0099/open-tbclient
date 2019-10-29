package com.baidu.live.tieba.e;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tieba.e.c;
/* loaded from: classes6.dex */
public class b {
    private SensorManager aoB;
    private a aoC;
    private Sensor aoD;
    private c aoG;
    private Activity mActivity;
    private boolean aoE = false;
    private boolean aoF = false;
    private boolean aoH = false;
    private boolean aoI = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.live.tieba.e.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && b.this.mActivity != null && b.this.aoI) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = b.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!b.this.aoH) {
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
                            if (!b.this.aoF) {
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
                            b.this.aoE = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!b.this.aoE && requestedOrientation != 1) {
                                BdUtilHelper.hideSoftKeyPad(b.this.mActivity, b.this.mActivity.getWindow().getDecorView());
                                b.this.mActivity.setRequestedOrientation(1);
                            }
                            b.this.aoF = false;
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
    private c.a aoJ = new c.a() { // from class: com.baidu.live.tieba.e.b.2
        @Override // com.baidu.live.tieba.e.c.a
        public void onChange(boolean z) {
            b.this.aoH = z;
        }
    };

    public b(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.aoB = (SensorManager) activity.getSystemService("sensor");
            this.aoD = this.aoB.getDefaultSensor(1);
            this.aoC = new a(this.mHandler);
            this.aoG = new c(this.mActivity, this.mHandler);
            this.aoG.a(this.aoJ);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.aoG);
        }
    }

    public void vs() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            if (this.mActivity.getRequestedOrientation() == 0) {
                this.mActivity.setRequestedOrientation(1);
                this.aoF = true;
                return;
            }
            this.mActivity.setRequestedOrientation(0);
            this.aoE = true;
        }
    }

    public void vt() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            this.mActivity.setRequestedOrientation(0);
            this.aoE = true;
        }
    }

    public void vu() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            this.mActivity.setRequestedOrientation(1);
            this.aoF = true;
        }
    }

    public void start() {
        if (this.aoB != null) {
            this.aoB.registerListener(this.aoC, this.aoD, 2);
        }
    }

    public void stop() {
        if (this.aoB != null) {
            this.aoB.unregisterListener(this.aoC);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.aoG);
        }
    }

    public void aK(boolean z) {
        this.aoI = z;
    }
}
