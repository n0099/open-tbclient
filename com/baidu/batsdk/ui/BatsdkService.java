package com.baidu.batsdk.ui;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.batsdk.e.b;
import com.baidu.batsdk.f.a;
import java.util.Map;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class BatsdkService extends Service {
    private static Handler i;
    private LinearLayout b;
    private WindowManager c;
    private WindowManager.LayoutParams d;
    private int e;
    private int g;
    private boolean h = false;
    private static int f = 0;
    public static boolean a = false;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a.b("FloatWindowService go!!!");
        com.baidu.batsdk.a.a.a(getApplicationContext());
        b.a(getApplicationContext());
        com.baidu.batsdk.e.a.a(getApplicationContext());
        if (com.baidu.batsdk.a.b) {
            this.b = new LinearLayout(getApplicationContext());
            this.c = (WindowManager) getSystemService("window");
            this.d = new WindowManager.LayoutParams();
            this.d.type = 2003;
            this.d.format = 1;
            this.d.flags |= 8;
            this.d.alpha = com.baidu.batsdk.a.u;
            this.d.width = -2;
            this.d.height = -2;
            this.d.gravity = 51;
            this.d.x = 0;
            this.d.y = 260;
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setAdjustViewBounds(true);
            int[] f2 = com.baidu.batsdk.b.b.f(getApplicationContext());
            int i2 = f2[0] < f2[1] ? f2[0] : f2[1];
            int i3 = i2 <= 300 ? 36 : i2 <= 400 ? 48 : i2 <= 600 ? 72 : 96;
            a.a("screen size: " + f2[0] + "x" + f2[1] + ", icon size: " + i3);
            imageView.setMaxHeight(i3);
            imageView.setMaxWidth(i3);
            imageView.setImageBitmap(com.baidu.batsdk.b.b.f());
            this.b.addView(imageView, -2, -2);
            this.b.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.batsdk.ui.BatsdkService.2
                private float[] a = {0.0f, 0.0f};
                private float[] b = {0.0f, 0.0f};
                private long c;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    float f3;
                    int action = motionEvent.getAction();
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    switch (action) {
                        case 0:
                            this.c = System.currentTimeMillis();
                            BatsdkService.this.d.alpha = 0.95f;
                            this.a[0] = motionEvent.getX();
                            this.a[1] = motionEvent.getY();
                            this.b[0] = motionEvent.getRawX();
                            this.b[1] = motionEvent.getRawY();
                            break;
                        case 1:
                            BatsdkService.this.d.alpha = com.baidu.batsdk.a.u;
                            if (Math.abs(rawX - this.b[0]) < 5.0f && Math.abs(rawY - this.b[1]) < 5.0f) {
                                BatsdkService.this.d();
                                break;
                            } else {
                                BatsdkService.this.g = BatsdkService.this.c.getDefaultDisplay().getWidth();
                                if (rawX > BatsdkService.this.g / 2) {
                                    f3 = BatsdkService.this.g;
                                } else {
                                    f3 = 0.0f;
                                }
                                BatsdkService.a(BatsdkService.this, (int) (f3 - this.a[0]), (int) (rawY - this.a[1]));
                                if (System.currentTimeMillis() - this.c < 120) {
                                    BatsdkService.this.d();
                                    break;
                                }
                            }
                            break;
                        case 2:
                            if (Math.abs(rawX - this.b[0]) >= 4.0f && Math.abs(rawY - this.b[1]) >= 4.0f) {
                                BatsdkService.a(BatsdkService.this, (int) (motionEvent.getRawX() - this.a[0]), (int) (motionEvent.getRawY() - this.a[1]));
                                break;
                            }
                            break;
                    }
                    return true;
                }
            });
            if (f > 0) {
                this.h = true;
                this.c.addView(this.b, this.d);
            }
        }
        i = new Handler() { // from class: com.baidu.batsdk.ui.BatsdkService.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (com.baidu.batsdk.a.b) {
                    switch (message.what) {
                        case 1:
                            int i4 = BatsdkService.f + 1;
                            BatsdkService.f = i4;
                            if (i4 <= 0) {
                                return;
                            }
                            BatsdkService.this.f();
                            return;
                        case 2:
                            int i5 = BatsdkService.f - 1;
                            BatsdkService.f = i5;
                            if (i5 <= 0) {
                                BatsdkService.b(BatsdkService.this);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }

    public static Handler a() {
        return i;
    }

    public static void b() {
        if (i != null) {
            i.sendEmptyMessage(1);
        } else {
            f++;
        }
    }

    public static void c() {
        if (i != null) {
            i.sendEmptyMessage(2);
        } else {
            f--;
        }
    }

    static /* synthetic */ void a(BatsdkService batsdkService, int i2, int i3) {
        if (batsdkService.e == 0) {
            View rootView = batsdkService.b.getRootView();
            Rect rect = new Rect();
            rootView.getWindowVisibleDisplayFrame(rect);
            batsdkService.e = rect.top;
        }
        batsdkService.d.x = i2;
        batsdkService.d.y = i3 - batsdkService.e;
        batsdkService.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.h) {
            this.c.updateViewLayout(this.b, this.d);
            return;
        }
        this.h = true;
        this.c.addView(this.b, this.d);
    }

    static /* synthetic */ void b(BatsdkService batsdkService) {
        if (batsdkService.h) {
            batsdkService.h = false;
            batsdkService.c.removeView(batsdkService.b);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        a.a("FloatWindowService gone!!!");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (com.baidu.batsdk.a.b) {
            if (intent == null) {
                a.d("why intent is null?");
            } else {
                a.a("onStartCommand from action " + intent.getStringExtra("action") + " mShouldDisplay=" + f);
            }
        }
        return 2;
    }

    public final void d() {
        if (!a) {
            a = true;
            if (!FeedbackActivity.class.getName().equals(com.baidu.batsdk.b.a.c())) {
                Context applicationContext = getApplicationContext();
                com.baidu.batsdk.b.b.a(applicationContext, "信息收集中...", 0);
                Map<String, Object> l = com.baidu.batsdk.b.b.l(applicationContext);
                Intent intent = new Intent(applicationContext, FeedbackActivity.class);
                com.baidu.batsdk.b.b.a(l, intent);
                intent.addFlags(268435456);
                applicationContext.startActivity(intent);
                return;
            }
            a = false;
        }
    }
}
