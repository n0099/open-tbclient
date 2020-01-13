package com.baidu.live.tieba.e;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tieba.e.c;
/* loaded from: classes2.dex */
public class b {
    private SensorManager awS;
    private a awT;
    private Sensor awU;
    private c awX;
    private Activity mActivity;
    private boolean awV = false;
    private boolean awW = false;
    private boolean awY = false;
    private boolean awZ = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.live.tieba.e.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && b.this.mActivity != null && b.this.awZ) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = b.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!b.this.awY) {
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
                            if (!b.this.awW) {
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
                            b.this.awV = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!b.this.awV && requestedOrientation != 1) {
                                BdUtilHelper.hideSoftKeyPad(b.this.mActivity, b.this.mActivity.getWindow().getDecorView());
                                b.this.mActivity.setRequestedOrientation(1);
                            }
                            b.this.awW = false;
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
    private c.a axa = new c.a() { // from class: com.baidu.live.tieba.e.b.2
        @Override // com.baidu.live.tieba.e.c.a
        public void onChange(boolean z) {
            b.this.awY = z;
        }
    };

    public b(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.awS = (SensorManager) activity.getSystemService("sensor");
            this.awU = this.awS.getDefaultSensor(1);
            this.awT = new a(this.mHandler);
            this.awX = new c(this.mActivity, this.mHandler);
            this.awX.a(this.axa);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.awX);
        }
    }

    public void xH() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            if (this.mActivity.getRequestedOrientation() == 0) {
                this.mActivity.setRequestedOrientation(1);
                this.awW = true;
                return;
            }
            this.mActivity.setRequestedOrientation(0);
            this.awV = true;
        }
    }

    public void xI() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            this.mActivity.setRequestedOrientation(0);
            this.awV = true;
        }
    }

    public void xJ() {
        if (this.mActivity != null) {
            BdUtilHelper.hideSoftKeyPad(this.mActivity, this.mActivity.getWindow().getDecorView());
            this.mActivity.setRequestedOrientation(1);
            this.awW = true;
        }
    }

    public void start() {
        if (this.awS != null) {
            this.awS.registerListener(this.awT, this.awU, 2);
        }
    }

    public void stop() {
        if (this.awS != null) {
            this.awS.unregisterListener(this.awT);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.awX);
        }
    }

    public void bf(boolean z) {
        this.awZ = z;
    }
}
