package com.baidu.ar.paddle;

import android.content.Context;
import android.os.Bundle;
import com.baidu.ar.algo.a.a.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PaddleController {
    public static final int PADDLE_GESTURE_CONTROL = 5001;
    public static final int PADDLE_GESTURE_STATUS_DETECTED = 5002;
    public static final String SDK_TO_LUA_GESTURE_RESULT_BODY = "gesture_result";
    public static final String SDK_TO_LUA_GESTURE_RESULT_COUNT = "gesture_count";
    public static final String SDK_TO_LUA_GESTURE_RESULT_RESERVED = "reserved";
    public static final String SDK_TO_LUA_GESTURE_RESULT_SCORE = "score";
    public static final String SDK_TO_LUA_GESTURE_RESULT_TYPE = "type";
    public static final String SDK_TO_LUA_GESTURE_RESULT_X1 = "x1";
    public static final String SDK_TO_LUA_GESTURE_RESULT_X2 = "x2";
    public static final String SDK_TO_LUA_GESTURE_RESULT_Y1 = "y1";
    public static final String SDK_TO_LUA_GESTURE_RESULT_Y2 = "y2";
    private b b;
    private ActionListener f;
    private com.baidu.ar.algo.a.a.a g;
    private String h;
    private String i;
    private STATE a = STATE.CLOSED;
    private boolean d = false;
    private boolean e = true;
    private a c = new a(this);

    /* loaded from: classes3.dex */
    public interface ActionListener {
        void onResult(HashMap hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum STATE {
        INITING,
        INITED,
        CLOSING,
        CLOSED,
        WAIT_CLOSE
    }

    /* loaded from: classes3.dex */
    public static class a implements com.baidu.ar.algo.b.a.a {
        private PaddleController a;

        public a(PaddleController paddleController) {
            this.a = (PaddleController) new WeakReference(paddleController).get();
        }

        private HashMap a(float[] fArr) {
            int length = fArr.length / 7;
            HashMap hashMap = new HashMap();
            hashMap.put("id", 5002);
            hashMap.put(PaddleController.SDK_TO_LUA_GESTURE_RESULT_COUNT, Integer.valueOf(length));
            for (int i = 0; i < length; i++) {
                String concat = PaddleController.SDK_TO_LUA_GESTURE_RESULT_BODY.concat("" + (i + 1));
                HashMap hashMap2 = new HashMap();
                for (int i2 = 0; i2 < 7; i2++) {
                    switch (i2) {
                        case 0:
                            hashMap2.put(PaddleController.SDK_TO_LUA_GESTURE_RESULT_RESERVED, Float.valueOf(fArr[(i * 7) + i2]));
                            break;
                        case 1:
                            hashMap2.put("type", Float.valueOf(fArr[(i * 7) + i2]));
                            break;
                        case 2:
                            hashMap2.put("score", Float.valueOf(fArr[(i * 7) + i2]));
                            break;
                        case 3:
                            hashMap2.put(PaddleController.SDK_TO_LUA_GESTURE_RESULT_X1, Float.valueOf(fArr[(i * 7) + i2]));
                            break;
                        case 4:
                            hashMap2.put(PaddleController.SDK_TO_LUA_GESTURE_RESULT_Y1, Float.valueOf(fArr[(i * 7) + i2]));
                            break;
                        case 5:
                            hashMap2.put(PaddleController.SDK_TO_LUA_GESTURE_RESULT_X2, Float.valueOf(fArr[(i * 7) + i2]));
                            break;
                        case 6:
                            hashMap2.put(PaddleController.SDK_TO_LUA_GESTURE_RESULT_Y2, Float.valueOf(fArr[(i * 7) + i2]));
                            break;
                    }
                }
                hashMap.put(concat, hashMap2);
            }
            return hashMap;
        }

        @Override // com.baidu.ar.algo.b.a.a
        public void a(Bundle bundle) {
            if (bundle == null) {
                this.a.e = true;
                return;
            }
            float[] floatArray = bundle.getFloatArray("result");
            if (floatArray != null && floatArray.length != 0 && this.a != null && this.a.f != null) {
                this.a.f.onResult(a(floatArray));
            }
            this.a.e = true;
            if (this.a == null || this.a.a != STATE.WAIT_CLOSE) {
                return;
            }
            this.a.setEnabled(false);
        }
    }

    public PaddleController(Context context, String str, String str2, com.baidu.ar.algo.a.a.a aVar, ActionListener actionListener) {
        this.h = null;
        this.i = null;
        this.h = str;
        this.i = str2;
        this.g = aVar;
        this.f = actionListener;
        if (this.b == null) {
            this.b = new b(context, this.h, this.i, this.g);
        }
    }

    private boolean a() {
        if (this.b != null) {
            return this.b.a();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null) {
            com.baidu.ar.algo.a.a(this.b);
        }
    }

    public void detectGesture(byte[] bArr, int i, int i2) {
        if (this.d && this.e && this.a == STATE.INITED) {
            this.e = false;
            com.baidu.ar.algo.a.a(bArr, i, i2, this.b, this.c, 1);
        }
    }

    public void release() {
        setEnabled(false);
        if (this.b != null) {
            this.b.c();
            this.b = null;
        }
        if (this.c != null) {
            this.c = null;
        }
        if (this.f != null) {
            this.f = null;
        }
        if (this.g != null) {
            this.g = null;
        }
    }

    public void setCameraType(int i) {
        this.b.a(i);
    }

    public void setEnabled(boolean z) {
        if (z == this.d || this.a == STATE.INITING || this.a == STATE.CLOSING) {
            return;
        }
        if (!z) {
            this.a = STATE.CLOSING;
            if (this.e) {
                new Thread(new Runnable() { // from class: com.baidu.ar.paddle.PaddleController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PaddleController.this.b();
                        PaddleController.this.d = false;
                        PaddleController.this.a = STATE.CLOSED;
                    }
                }).start();
            } else {
                this.a = STATE.WAIT_CLOSE;
            }
        } else if (this.a != STATE.WAIT_CLOSE) {
            this.a = STATE.INITING;
            if (a()) {
                this.d = true;
                this.a = STATE.INITED;
                return;
            }
            this.d = false;
            this.a = STATE.CLOSED;
        }
    }
}
