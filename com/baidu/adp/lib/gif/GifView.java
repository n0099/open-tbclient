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
    private static /* synthetic */ int[] h;
    private b a;
    private Bitmap b;
    private boolean c;
    private d d;
    private View e;
    private GifImageType f;
    private final Handler g;

    static /* synthetic */ int[] a() {
        int[] iArr = h;
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
            h = iArr;
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
        if (this.a == null) {
            this.a = new b(this);
        }
        this.a.a(bArr);
        this.a.start();
    }

    private void setGifDecoderImage(InputStream inputStream) {
        if (this.a == null) {
            this.a = new b(this);
        }
        this.a.a(inputStream);
        this.a.start();
    }

    public void setAsBackground(View view) {
        this.e = view;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        if (this.a != null) {
            this.a.a();
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

    public void setGifImage(int i) {
        setGifDecoderImage(getResources().openRawResource(i));
    }

    public void setGifImageType(GifImageType gifImageType) {
        if (this.a == null) {
            this.f = gifImageType;
        }
    }

    @Override // com.baidu.adp.lib.gif.a
    public void a(boolean z, int i) {
        if (z) {
            if (this.a != null) {
                switch (a()[this.f.ordinal()]) {
                    case 1:
                        if (i == -1) {
                            if (this.a.b() > 1) {
                                new d(this, null).start();
                                return;
                            } else {
                                b();
                                return;
                            }
                        }
                        return;
                    case 2:
                        if (i == 1) {
                            this.b = this.a.c();
                            b();
                            return;
                        } else if (i == -1) {
                            b();
                            return;
                        } else if (this.d == null) {
                            this.d = new d(this, null);
                            this.d.start();
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        if (i == 1) {
                            this.b = this.a.c();
                            b();
                            return;
                        } else if (i == -1) {
                            if (this.a.b() > 1) {
                                if (this.d == null) {
                                    this.d = new d(this, null);
                                    this.d.start();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.g != null) {
            this.g.sendMessage(this.g.obtainMessage());
        }
    }
}
