package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class d extends TextView {
    private Context a;
    private com.baidu.platform.comapi.walknavi.segmentbrowse.a b;
    private int c;

    public d(Context context, com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar, int i) {
        super(context);
        this.a = context;
        int i2 = Build.VERSION.SDK_INT;
        if (this.b == null) {
            this.b = new com.baidu.platform.comapi.walknavi.segmentbrowse.a();
        }
        this.c = i;
        this.b = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap decodeResource;
        if (canvas != null && this.a != null && this.b != null) {
            canvas.save();
            Paint paint = new Paint();
            paint.setTextSize(b.a(this.a, 22.0f));
            if (!TextUtils.isEmpty(this.b.c())) {
                if (this.b.e() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.a()) {
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != null) {
                        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE || com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE || com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
                            decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.platform.comapi.walknavi.g.a.c.a(this.b.c()));
                        } else {
                            decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.platform.comapi.walknavi.g.a.c.b(this.b.c()));
                        }
                    } else {
                        return;
                    }
                } else {
                    decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.platform.comapi.walknavi.g.a.c.a(this.b.c()));
                }
                RectF rectF = new RectF(b.a(this.a, 27.0f), b.a(this.a, 21.0f), b.a(this.a, 80.0f), b.a(this.a, 74.0f));
                if (decodeResource != null && rectF != null) {
                    try {
                        canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), rectF, (Paint) null);
                    } catch (Exception e) {
                    }
                } else {
                    return;
                }
            }
            int i = 0;
            int a = a(this.b) + b(this.b);
            if (a == 1) {
                i = b.a(this.a, 51.0f);
            } else if (a == 2) {
                i = b.a(this.a, 40.0f);
            } else if (a == 3) {
                i = b.a(this.a, 30.0f);
            }
            if (paint != null && canvas != null && this.b.a() != null && this.b.a().size() != 0) {
                ArrayList<c> a2 = this.b.a();
                int size = a2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    c a3 = a2.get(i2).a();
                    float a4 = b.a(this.a, 100.0f);
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING && com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == this.b.e()) {
                        float a5 = b.a(this.a, 22.0f);
                        int length = a3.c.length;
                        int i3 = (int) ((((length * a5) + a4) - this.c) / a5);
                        if (i3 > 0 && i3 < length - 1) {
                            for (int i4 = length - i3; i4 < length; i4++) {
                                a3.c[i4] = '.';
                            }
                        }
                    }
                    for (int i5 = 0; i5 < a3.c.length; i5++) {
                        switch (size) {
                            case 1:
                                paint.setColor(-13400577);
                                break;
                            case 2:
                                if (i2 == 0) {
                                    paint.setColor(-13400577);
                                    break;
                                } else {
                                    paint.setColor(-13400577);
                                    break;
                                }
                            case 3:
                                if (i2 == 0 || i2 == 1) {
                                    paint.setColor(-13400577);
                                    break;
                                } else if (i5 < e.a()) {
                                    paint.setColor(-13400577);
                                    break;
                                } else {
                                    paint.setColor(-13553101);
                                    break;
                                }
                        }
                        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE || com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE || com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
                            paint.setColor(-13553101);
                        }
                        if (a3.a[i5] == 0) {
                            paint.setTextSize(b.a(this.a, 17.0f));
                        } else {
                            paint.setTextSize(b.a(this.a, 23.0f));
                        }
                        if (canvas != null && a3.c != null && paint != null) {
                            canvas.drawText(a3.c, i5, 1, a4, i, paint);
                        }
                        a4 += paint.measureText(String.valueOf(a3.c[i5]));
                    }
                    i += b.a(this.a, 26.0f);
                }
                if (this.b.b() != null && this.b.b().size() != 0) {
                    ArrayList<c> b = this.b.b();
                    int size2 = b.size();
                    int i6 = 0;
                    int i7 = i;
                    while (i6 < size2) {
                        c cVar = b.get(i6);
                        float a6 = b.a(this.a, 100.0f);
                        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING && com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == this.b.e()) {
                            float a7 = b.a(this.a, 22.0f);
                            int length2 = cVar.c.length;
                            int i8 = (int) ((((length2 * a7) + a6) - this.c) / a7);
                            if (i8 > 0 && i8 < length2 - 1) {
                                for (int i9 = length2 - i8; i9 < length2; i9++) {
                                    cVar.c[i9] = '.';
                                }
                            }
                        }
                        for (int i10 = 0; i10 < cVar.c.length; i10++) {
                            paint.setColor(-13400577);
                            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE || com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE || com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
                                paint.setColor(-13553101);
                            }
                            if (cVar.a[i10] == 0) {
                                paint.setTextSize(b.a(this.a, 16.0f));
                            } else {
                                paint.setTextSize(b.a(this.a, 22.0f));
                            }
                            if (canvas != null && cVar.c != null && paint != null) {
                                canvas.drawText(cVar.c, i10, 1, a6, i7, paint);
                            }
                            a6 += paint.measureText(String.valueOf(cVar.c[i10]));
                        }
                        i6++;
                        i7 += b.a(this.a, 20.0f);
                    }
                    canvas.restore();
                }
            }
        }
    }

    private int a(com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar) {
        if (aVar == null || aVar.a() == null) {
            return 0;
        }
        return aVar.a().size();
    }

    private int b(com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar) {
        if (aVar == null || aVar.b() == null) {
            return 0;
        }
        return aVar.b().size();
    }
}
