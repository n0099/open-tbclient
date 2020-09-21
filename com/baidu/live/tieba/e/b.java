package com.baidu.live.tieba.e;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tieba.e.c;
/* loaded from: classes4.dex */
public class b {
    private SensorManager bqI;
    private a bqJ;
    private Sensor bqK;
    private c bqN;
    private Activity mActivity;
    private boolean bqL = false;
    private boolean bqM = false;
    private boolean bqO = false;
    private boolean bqP = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.live.tieba.e.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && b.this.mActivity != null && b.this.bqP) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = b.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!b.this.bqO) {
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
                            if (!b.this.bqM) {
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
                            b.this.bqL = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!b.this.bqL && requestedOrientation != 1) {
                                BdUtilHelper.hideSoftKeyPad(b.this.mActivity, b.this.mActivity.getWindow().getDecorView());
                                b.this.mActivity.setRequestedOrientation(1);
                            }
                            b.this.bqM = false;
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
    private c.a bqQ = new c.a() { // from class: com.baidu.live.tieba.e.b.2
        @Override // com.baidu.live.tieba.e.c.a
        public void onChange(boolean z) {
            b.this.bqO = z;
        }
    };

    public b(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.bqI = (SensorManager) activity.getSystemService("sensor");
            this.bqK = this.bqI.getDefaultSensor(1);
            this.bqJ = new a(this.mHandler);
            this.bqN = new c(this.mActivity, this.mHandler);
            this.bqN.a(this.bqQ);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.bqN);
        }
    }

    public void OK() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            if (this.mActivity.getRequestedOrientation() == 0) {
                this.mActivity.setRequestedOrientation(1);
                this.bqM = true;
                return;
            }
            this.mActivity.setRequestedOrientation(0);
            this.bqL = true;
        }
    }

    public void OL() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            this.mActivity.setRequestedOrientation(0);
            this.bqL = true;
        }
    }

    public void OM() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            this.mActivity.setRequestedOrientation(1);
            this.bqM = true;
        }
    }

    public void start() {
        if (this.bqI != null) {
            this.bqI.registerListener(this.bqJ, this.bqK, 2);
        }
    }

    public void stop() {
        if (this.bqI != null) {
            this.bqI.unregisterListener(this.bqJ);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.bqN);
        }
    }

    public void cu(boolean z) {
        this.bqP = z;
    }
}
