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
    public Context f10184a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.segmentbrowse.a f10185b;

    /* renamed from: c  reason: collision with root package name */
    public int f10186c;

    public d(Context context, com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar, int i) {
        super(context);
        this.f10184a = context;
        if (this.f10185b == null) {
            this.f10185b = new com.baidu.platform.comapi.walknavi.segmentbrowse.a();
        }
        this.f10186c = i;
        this.f10185b = aVar;
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
        int i;
        c cVar;
        char[] cArr;
        int i2;
        int i3;
        int i4;
        ArrayList<c> arrayList;
        char[] cArr2;
        Bitmap decodeResource;
        if (canvas == null || this.f10184a == null || this.f10185b == null) {
            return;
        }
        canvas.save();
        Paint paint = new Paint();
        float f3 = 22.0f;
        paint.setTextSize(b.a(this.f10184a, 22.0f));
        if (!TextUtils.isEmpty(this.f10185b.c())) {
            if (this.f10185b.e() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.a()) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == null) {
                    return;
                }
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE && com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE && com.baidu.platform.comapi.walknavi.b.a().J() != 4) {
                    decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.platform.comapi.walknavi.g.a.c.b(this.f10185b.c()));
                } else {
                    decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.platform.comapi.walknavi.g.a.c.a(this.f10185b.c()));
                }
            } else {
                decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.platform.comapi.walknavi.g.a.c.a(this.f10185b.c()));
            }
            RectF rectF = new RectF(b.a(this.f10184a, 27.0f), b.a(this.f10184a, 21.0f), b.a(this.f10184a, 80.0f), b.a(this.f10184a, 74.0f));
            if (decodeResource == null) {
                return;
            }
            try {
                canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), rectF, (Paint) null);
            } catch (Exception unused) {
            }
        }
        int a3 = a(this.f10185b) + b(this.f10185b);
        int i5 = 3;
        int i6 = 2;
        if (a3 == 1) {
            a2 = b.a(this.f10184a, 51.0f);
        } else if (a3 == 2) {
            a2 = b.a(this.f10184a, 40.0f);
        } else {
            a2 = a3 == 3 ? b.a(this.f10184a, 30.0f) : 0;
        }
        if (canvas == null || this.f10185b.a() == null || this.f10185b.a().size() == 0) {
            return;
        }
        ArrayList<c> a4 = this.f10185b.a();
        int size = a4.size();
        int i7 = a2;
        int i8 = 0;
        while (true) {
            f2 = 100.0f;
            if (i8 >= size) {
                break;
            }
            c a5 = a4.get(i8).a();
            float a6 = b.a(this.f10184a, 100.0f);
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING && com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == this.f10185b.e()) {
                float a7 = b.a(this.f10184a, f3);
                int length = a5.f10183c.length;
                int i9 = (int) ((((length * a7) + a6) - this.f10186c) / a7);
                if (i9 > 0 && i9 < length - 1) {
                    for (int i10 = length - i9; i10 < length; i10++) {
                        a5.f10183c[i10] = IStringUtil.EXTENSION_SEPARATOR;
                    }
                }
            }
            float f4 = a6;
            int i11 = 0;
            while (i11 < a5.f10183c.length) {
                if (size == 1) {
                    paint.setColor(-13400577);
                } else if (size != i6) {
                    if (size == i5) {
                        if (i8 != 0 && i8 != 1) {
                            if (i11 < e.a()) {
                                paint.setColor(-13400577);
                            } else {
                                paint.setColor(-13553101);
                            }
                        } else {
                            paint.setColor(-13400577);
                        }
                    }
                } else if (i8 == 0) {
                    paint.setColor(-13400577);
                } else {
                    paint.setColor(-13400577);
                }
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE || com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE || com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
                    paint.setColor(-13553101);
                }
                if (a5.f10181a[i11] == 0) {
                    paint.setTextSize(b.a(this.f10184a, 17.0f));
                } else {
                    paint.setTextSize(b.a(this.f10184a, 23.0f));
                }
                if (canvas == null || (cArr2 = a5.f10183c) == null) {
                    i2 = i8;
                    i3 = i7;
                    i4 = size;
                    arrayList = a4;
                } else {
                    i2 = i8;
                    i3 = i7;
                    i4 = size;
                    arrayList = a4;
                    canvas.drawText(cArr2, i11, 1, f4, i7, paint);
                }
                f4 += paint.measureText(String.valueOf(a5.f10183c[i11]));
                i11++;
                a4 = arrayList;
                i8 = i2;
                i7 = i3;
                size = i4;
                i5 = 3;
                i6 = 2;
            }
            i7 += b.a(this.f10184a, 26.0f);
            i8++;
            f3 = 22.0f;
            i5 = 3;
            i6 = 2;
        }
        int i12 = i7;
        int i13 = -13400577;
        if (this.f10185b.b() == null || this.f10185b.b().size() == 0) {
            return;
        }
        ArrayList<c> b2 = this.f10185b.b();
        int size2 = b2.size();
        int i14 = i12;
        int i15 = 0;
        while (i15 < size2) {
            c cVar2 = b2.get(i15);
            float a8 = b.a(this.f10184a, f2);
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING && com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == this.f10185b.e()) {
                float a9 = b.a(this.f10184a, 22.0f);
                int length2 = cVar2.f10183c.length;
                int i16 = (int) ((((length2 * a9) + a8) - this.f10186c) / a9);
                if (i16 > 0 && i16 < length2 - 1) {
                    for (int i17 = length2 - i16; i17 < length2; i17++) {
                        cVar2.f10183c[i17] = IStringUtil.EXTENSION_SEPARATOR;
                    }
                }
            }
            float f5 = a8;
            int i18 = 0;
            while (i18 < cVar2.f10183c.length) {
                paint.setColor(i13);
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE || com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
                }
                paint.setColor(-13553101);
                if (cVar2.f10181a[i18] == 0) {
                    paint.setTextSize(b.a(this.f10184a, 16.0f));
                } else {
                    paint.setTextSize(b.a(this.f10184a, 22.0f));
                }
                if (canvas == null || (cArr = cVar2.f10183c) == null) {
                    i = i18;
                    cVar = cVar2;
                } else {
                    i = i18;
                    cVar = cVar2;
                    canvas.drawText(cArr, i18, 1, f5, i14, paint);
                }
                f5 += paint.measureText(String.valueOf(cVar.f10183c[i]));
                i18 = i + 1;
                cVar2 = cVar;
                i13 = -13400577;
            }
            i14 += b.a(this.f10184a, 20.0f);
            i15++;
            f2 = 100.0f;
            i13 = -13400577;
        }
        canvas.restore();
    }
}
