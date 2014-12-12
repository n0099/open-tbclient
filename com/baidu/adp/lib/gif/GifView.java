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
    private static /* synthetic */ int[] ji;
    private b jb;
    private Bitmap jc;
    private boolean jd;
    private d je;
    private View jf;
    private GifImageType jg;
    private final Handler jh;

    static /* synthetic */ int[] dw() {
        int[] iArr = ji;
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
            ji = iArr;
        }
        return iArr;
    }

    /* loaded from: classes.dex */
    public enum GifImageType {
        WAIT_FINISH(0),
        SYNC_DECODER(1),
        COVER(2);
        
        final int nativeInt;

        /* JADX DEBUG: Replace access to removed values field (jk) with 'values()' method */
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
        if (this.jb == null) {
            this.jb = new b(this);
        }
        this.jb.setGifImage(bArr);
        this.jb.start();
    }

    private void setGifDecoderImage(InputStream inputStream) {
        if (this.jb == null) {
            this.jb = new b(this);
        }
        this.jb.setGifImage(inputStream);
        this.jb.start();
    }

    public void setAsBackground(View view) {
        this.jf = view;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        if (this.jb != null) {
            this.jb.free();
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
        if (this.jb == null) {
            this.jg = gifImageType;
        }
    }

    @Override // com.baidu.adp.lib.gif.a
    public void a(boolean z, int i) {
        if (z) {
            if (this.jb != null) {
                switch (dw()[this.jg.ordinal()]) {
                    case 1:
                        if (i == -1) {
                            if (this.jb.bK() > 1) {
                                new d(this, null).start();
                                return;
                            } else {
                                dv();
                                return;
                            }
                        }
                        return;
                    case 2:
                        if (i == 1) {
                            this.jc = this.jb.getImage();
                            dv();
                            return;
                        } else if (i == -1) {
                            dv();
                            return;
                        } else if (this.je == null) {
                            this.je = new d(this, null);
                            this.je.start();
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        if (i == 1) {
                            this.jc = this.jb.getImage();
                            dv();
                            return;
                        } else if (i == -1) {
                            if (this.jb.bK() > 1) {
                                if (this.je == null) {
                                    this.je = new d(this, null);
                                    this.je.start();
                                    return;
                                }
                                return;
                            }
                            dv();
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
    public void dv() {
        if (this.jh != null) {
            this.jh.sendMessage(this.jh.obtainMessage());
        }
    }
}
