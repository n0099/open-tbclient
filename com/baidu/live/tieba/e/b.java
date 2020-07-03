package com.baidu.live.tieba.e;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tieba.e.c;
/* loaded from: classes3.dex */
public class b {
    private SensorManager bhI;
    private a bhJ;
    private Sensor bhK;
    private c bhN;
    private Activity mActivity;
    private boolean bhL = false;
    private boolean bhM = false;
    private boolean bhO = false;
    private boolean bhP = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.live.tieba.e.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && b.this.mActivity != null && b.this.bhP) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = b.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!b.this.bhO) {
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
                            if (!b.this.bhM) {
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
                            b.this.bhL = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!b.this.bhL && requestedOrientation != 1) {
                                BdUtilHelper.hideSoftKeyPad(b.this.mActivity, b.this.mActivity.getWindow().getDecorView());
                                b.this.mActivity.setRequestedOrientation(1);
                            }
                            b.this.bhM = false;
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
    private c.a bhQ = new c.a() { // from class: com.baidu.live.tieba.e.b.2
        @Override // com.baidu.live.tieba.e.c.a
        public void onChange(boolean z) {
            b.this.bhO = z;
        }
    };

    public b(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.bhI = (SensorManager) activity.getSystemService("sensor");
            this.bhK = this.bhI.getDefaultSensor(1);
            this.bhJ = new a(this.mHandler);
            this.bhN = new c(this.mActivity, this.mHandler);
            this.bhN.a(this.bhQ);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.bhN);
        }
    }

    public void Ii() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            if (this.mActivity.getRequestedOrientation() == 0) {
                this.mActivity.setRequestedOrientation(1);
                this.bhM = true;
                return;
            }
            this.mActivity.setRequestedOrientation(0);
            this.bhL = true;
        }
    }

    public void Ij() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            this.mActivity.setRequestedOrientation(0);
            this.bhL = true;
        }
    }

    public void Ik() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            this.mActivity.setRequestedOrientation(1);
            this.bhM = true;
        }
    }

    public void start() {
        if (this.bhI != null) {
            this.bhI.registerListener(this.bhJ, this.bhK, 2);
        }
    }

    public void stop() {
        if (this.bhI != null) {
            this.bhI.unregisterListener(this.bhJ);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.bhN);
        }
    }

    public void ch(boolean z) {
        this.bhP = z;
    }
}
