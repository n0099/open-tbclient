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
    private static /* synthetic */ int[] jc;
    private b iV;
    private Bitmap iW;
    private boolean iX;
    private d iY;
    private View iZ;
    private GifImageType ja;
    private final Handler jb;

    static /* synthetic */ int[] dx() {
        int[] iArr = jc;
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
            jc = iArr;
        }
        return iArr;
    }

    /* loaded from: classes.dex */
    public enum GifImageType {
        WAIT_FINISH(0),
        SYNC_DECODER(1),
        COVER(2);
        
        final int nativeInt;

        /* JADX DEBUG: Replace access to removed values field (je) with 'values()' method */
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
        if (this.iV == null) {
            this.iV = new b(this);
        }
        this.iV.setGifImage(bArr);
        this.iV.start();
    }

    private void setGifDecoderImage(InputStream inputStream) {
        if (this.iV == null) {
            this.iV = new b(this);
        }
        this.iV.setGifImage(inputStream);
        this.iV.start();
    }

    public void setAsBackground(View view) {
        this.iZ = view;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        if (this.iV != null) {
            this.iV.dd();
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
        if (this.iV == null) {
            this.ja = gifImageType;
        }
    }

    @Override // com.baidu.adp.lib.gif.a
    public void a(boolean z, int i) {
        if (z) {
            if (this.iV != null) {
                switch (dx()[this.ja.ordinal()]) {
                    case 1:
                        if (i == -1) {
                            if (this.iV.bj() > 1) {
                                new d(this, null).start();
                                return;
                            } else {
                                dw();
                                return;
                            }
                        }
                        return;
                    case 2:
                        if (i == 1) {
                            this.iW = this.iV.de();
                            dw();
                            return;
                        } else if (i == -1) {
                            dw();
                            return;
                        } else if (this.iY == null) {
                            this.iY = new d(this, null);
                            this.iY.start();
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        if (i == 1) {
                            this.iW = this.iV.de();
                            dw();
                            return;
                        } else if (i == -1) {
                            if (this.iV.bj() > 1) {
                                if (this.iY == null) {
                                    this.iY = new d(this, null);
                                    this.iY.start();
                                    return;
                                }
                                return;
                            }
                            dw();
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
    public void dw() {
        if (this.jb != null) {
            this.jb.sendMessage(this.jb.obtainMessage());
        }
    }
}
