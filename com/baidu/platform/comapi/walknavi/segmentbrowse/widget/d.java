package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.android.common.others.IStringUtil;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public Context f10102a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.segmentbrowse.a f10103b;

    /* renamed from: c  reason: collision with root package name */
    public int f10104c;

    public d(Context context, com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar, int i2) {
        super(context);
        this.f10102a = context;
        if (this.f10103b == null) {
            this.f10103b = new com.baidu.platform.comapi.walknavi.segmentbrowse.a();
        }
        this.f10104c = i2;
        this.f10103b = aVar;
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

    /* JADX WARN: Code restructure failed: missing block: B:128:0x0311, code lost:
        if (com.baidu.platform.comapi.walknavi.b.a().J() == 4) goto L137;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw(Canvas canvas) {
        int a2;
        float f2;
        int i2;
        c cVar;
        char[] cArr;
        int i3;
        int i4;
        int i5;
        ArrayList<c> arrayList;
        char[] cArr2;
        Bitmap decodeResource;
        if (canvas == null || this.f10102a == null || this.f10103b == null) {
            return;
        }
        canvas.save();
        Paint paint = new Paint();
        float f3 = 22.0f;
        paint.setTextSize(b.a(this.f10102a, 22.0f));
        if (!TextUtils.isEmpty(this.f10103b.c())) {
            if (this.f10103b.e() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.a()) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == null) {
                    return;
                }
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE && com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE && com.baidu.platform.comapi.walknavi.b.a().J() != 4) {
                    decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.platform.comapi.walknavi.g.a.c.b(this.f10103b.c()));
                } else {
                    decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.platform.comapi.walknavi.g.a.c.a(this.f10103b.c()));
                }
            } else {
                decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.platform.comapi.walknavi.g.a.c.a(this.f10103b.c()));
            }
            RectF rectF = new RectF(b.a(this.f10102a, 27.0f), b.a(this.f10102a, 21.0f), b.a(this.f10102a, 80.0f), b.a(this.f10102a, 74.0f));
            if (decodeResource == null) {
                return;
            }
            try {
                canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), rectF, (Paint) null);
            } catch (Exception unused) {
            }
        }
        int a3 = a(this.f10103b) + b(this.f10103b);
        int i6 = 3;
        int i7 = 2;
        if (a3 == 1) {
            a2 = b.a(this.f10102a, 51.0f);
        } else if (a3 == 2) {
            a2 = b.a(this.f10102a, 40.0f);
        } else {
            a2 = a3 == 3 ? b.a(this.f10102a, 30.0f) : 0;
        }
        if (canvas == null || this.f10103b.a() == null || this.f10103b.a().size() == 0) {
            return;
        }
        ArrayList<c> a4 = this.f10103b.a();
        int size = a4.size();
        int i8 = a2;
        int i9 = 0;
        while (true) {
            f2 = 100.0f;
            if (i9 >= size) {
                break;
            }
            c a5 = a4.get(i9).a();
            float a6 = b.a(this.f10102a, 100.0f);
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING && com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == this.f10103b.e()) {
                float a7 = b.a(this.f10102a, f3);
                int length = a5.f10101c.length;
                int i10 = (int) ((((length * a7) + a6) - this.f10104c) / a7);
                if (i10 > 0 && i10 < length - 1) {
                    for (int i11 = length - i10; i11 < length; i11++) {
                        a5.f10101c[i11] = IStringUtil.EXTENSION_SEPARATOR;
                    }
                }
            }
            float f4 = a6;
            int i12 = 0;
            while (i12 < a5.f10101c.length) {
                if (size == 1) {
                    paint.setColor(-13400577);
                } else if (size != i7) {
                    if (size == i6) {
                        if (i9 != 0 && i9 != 1) {
                            if (i12 < e.a()) {
                                paint.setColor(-13400577);
                            } else {
                                paint.setColor(-13553101);
                            }
                        } else {
                            paint.setColor(-13400577);
                        }
                    }
                } else if (i9 == 0) {
                    paint.setColor(-13400577);
                } else {
                    paint.setColor(-13400577);
                }
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE || com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE || com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
                    paint.setColor(-13553101);
                }
                if (a5.f10099a[i12] == 0) {
                    paint.setTextSize(b.a(this.f10102a, 17.0f));
                } else {
                    paint.setTextSize(b.a(this.f10102a, 23.0f));
                }
                if (canvas == null || (cArr2 = a5.f10101c) == null) {
                    i3 = i9;
                    i4 = i8;
                    i5 = size;
                    arrayList = a4;
                } else {
                    i3 = i9;
                    i4 = i8;
                    i5 = size;
                    arrayList = a4;
                    canvas.drawText(cArr2, i12, 1, f4, i8, paint);
                }
                f4 += paint.measureText(String.valueOf(a5.f10101c[i12]));
                i12++;
                a4 = arrayList;
                i9 = i3;
                i8 = i4;
                size = i5;
                i6 = 3;
                i7 = 2;
            }
            i8 += b.a(this.f10102a, 26.0f);
            i9++;
            f3 = 22.0f;
            i6 = 3;
            i7 = 2;
        }
        int i13 = i8;
        int i14 = -13400577;
        if (this.f10103b.b() == null || this.f10103b.b().size() == 0) {
            return;
        }
        ArrayList<c> b2 = this.f10103b.b();
        int size2 = b2.size();
        int i15 = i13;
        int i16 = 0;
        while (i16 < size2) {
            c cVar2 = b2.get(i16);
            float a8 = b.a(this.f10102a, f2);
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING && com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == this.f10103b.e()) {
                float a9 = b.a(this.f10102a, 22.0f);
                int length2 = cVar2.f10101c.length;
                int i17 = (int) ((((length2 * a9) + a8) - this.f10104c) / a9);
                if (i17 > 0 && i17 < length2 - 1) {
                    for (int i18 = length2 - i17; i18 < length2; i18++) {
                        cVar2.f10101c[i18] = IStringUtil.EXTENSION_SEPARATOR;
                    }
                }
            }
            float f5 = a8;
            int i19 = 0;
            while (i19 < cVar2.f10101c.length) {
                paint.setColor(i14);
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE || com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
                }
                paint.setColor(-13553101);
                if (cVar2.f10099a[i19] == 0) {
                    paint.setTextSize(b.a(this.f10102a, 16.0f));
                } else {
                    paint.setTextSize(b.a(this.f10102a, 22.0f));
                }
                if (canvas == null || (cArr = cVar2.f10101c) == null) {
                    i2 = i19;
                    cVar = cVar2;
                } else {
                    i2 = i19;
                    cVar = cVar2;
                    canvas.drawText(cArr, i19, 1, f5, i15, paint);
                }
                f5 += paint.measureText(String.valueOf(cVar.f10101c[i2]));
                i19 = i2 + 1;
                cVar2 = cVar;
                i14 = -13400577;
            }
            i15 += b.a(this.f10102a, 20.0f);
            i16++;
            f2 = 100.0f;
            i14 = -13400577;
        }
        canvas.restore();
    }
}
