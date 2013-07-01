package com.baidu.adp.lib.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements a {
    private static /* synthetic */ int[] i;

    /* renamed from: a */
    private b f169a;
    private Bitmap b;
    private boolean c;
    private boolean d;
    private d e;
    private View f;
    private GifImageType g;
    private Handler h;

    static /* synthetic */ int[] a() {
        int[] iArr = i;
        if (iArr == null) {
            iArr = new int[GifImageType.valuesCustom().length];
            try {
                iArr[GifImageType.COVER.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[GifImageType.SYNC_DECODER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[GifImageType.WAIT_FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            i = iArr;
        }
        return iArr;
    }

    /* loaded from: classes.dex */
    public enum GifImageType {
        WAIT_FINISH(0),
        SYNC_DECODER(1),
        COVER(2);
        
        final int nativeInt;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static GifImageType[] valuesCustom() {
            GifImageType[] valuesCustom = values();
            int length = valuesCustom.length;
            GifImageType[] gifImageTypeArr = new GifImageType[length];
            System.arraycopy(valuesCustom, 0, gifImageTypeArr, 0, length);
            return gifImageTypeArr;
        }

        GifImageType(int i) {
            this.nativeInt = i;
        }
    }

    private void setGifDecoderImage(byte[] bArr) {
        if (this.f169a == null) {
            this.f169a = new b(this);
        }
        this.f169a.a(bArr);
        this.f169a.start();
    }

    private void setGifDecoderImage(InputStream inputStream) {
        if (this.f169a == null) {
            this.f169a = new b(this);
        }
        this.f169a.a(inputStream);
        this.f169a.start();
    }

    public void setAsBackground(View view) {
        this.f = view;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        if (this.f169a != null) {
            this.f169a.a();
            return null;
        }
        return null;
    }

    public void setGifImage(byte[] bArr) {
        setGifDecoderImage(bArr);
    }

    public void setGifImage(InputStream inputStream) {
        setGifDecoderImage(inputStream);
    }

    public void setGifImage(int i2) {
        setGifDecoderImage(getResources().openRawResource(i2));
    }

    public void setGifImageType(GifImageType gifImageType) {
        if (this.f169a == null) {
            this.g = gifImageType;
        }
    }

    @Override // com.baidu.adp.lib.gif.a
    public void a(boolean z, int i2) {
        if (z) {
            if (this.f169a != null) {
                switch (a()[this.g.ordinal()]) {
                    case 1:
                        if (i2 == -1) {
                            if (this.f169a.b() > 1) {
                                new d(this, null).start();
                                return;
                            } else {
                                b();
                                return;
                            }
                        }
                        return;
                    case 2:
                        if (i2 == 1) {
                            this.b = this.f169a.c();
                            b();
                            return;
                        } else if (i2 == -1) {
                            b();
                            return;
                        } else if (this.e == null) {
                            this.e = new d(this, null);
                            this.e.start();
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        if (i2 == 1) {
                            this.b = this.f169a.c();
                            b();
                            return;
                        } else if (i2 == -1) {
                            if (this.f169a.b() > 1) {
                                if (this.e == null) {
                                    this.e = new d(this, null);
                                    this.e.start();
                                    return;
                                }
                                return;
                            }
                            b();
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
            Log.e("gif", "parse error");
        }
    }

    public void b() {
        if (this.h != null) {
            this.h.sendMessage(this.h.obtainMessage());
        }
    }
}
