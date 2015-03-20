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
    private static /* synthetic */ int[] uB;
    private final Handler uA;
    private b uu;
    private Bitmap uv;
    private boolean uw;
    private d ux;
    private View uy;
    private GifImageType uz;

    static /* synthetic */ int[] gS() {
        int[] iArr = uB;
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
            uB = iArr;
        }
        return iArr;
    }

    /* loaded from: classes.dex */
    public enum GifImageType {
        WAIT_FINISH(0),
        SYNC_DECODER(1),
        COVER(2);
        
        final int nativeInt;

        /* JADX DEBUG: Replace access to removed values field (uD) with 'values()' method */
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
        if (this.uu == null) {
            this.uu = new b(this);
        }
        this.uu.setGifImage(bArr);
        this.uu.start();
    }

    private void setGifDecoderImage(InputStream inputStream) {
        if (this.uu == null) {
            this.uu = new b(this);
        }
        this.uu.setGifImage(inputStream);
        this.uu.start();
    }

    public void setAsBackground(View view) {
        this.uy = view;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        if (this.uu != null) {
            this.uu.free();
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
        if (this.uu == null) {
            this.uz = gifImageType;
        }
    }

    @Override // com.baidu.adp.lib.gif.a
    public void a(boolean z, int i) {
        if (z) {
            if (this.uu != null) {
                switch (gS()[this.uz.ordinal()]) {
                    case 1:
                        if (i == -1) {
                            if (this.uu.fg() > 1) {
                                new d(this, null).start();
                                return;
                            } else {
                                gR();
                                return;
                            }
                        }
                        return;
                    case 2:
                        if (i == 1) {
                            this.uv = this.uu.getImage();
                            gR();
                            return;
                        } else if (i == -1) {
                            gR();
                            return;
                        } else if (this.ux == null) {
                            this.ux = new d(this, null);
                            this.ux.start();
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        if (i == 1) {
                            this.uv = this.uu.getImage();
                            gR();
                            return;
                        } else if (i == -1) {
                            if (this.uu.fg() > 1) {
                                if (this.ux == null) {
                                    this.ux = new d(this, null);
                                    this.ux.start();
                                    return;
                                }
                                return;
                            }
                            gR();
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

    public void gR() {
        if (this.uA != null) {
            this.uA.sendMessage(this.uA.obtainMessage());
        }
    }
}
