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
    private static /* synthetic */ int[] jk;
    private b jd;
    private Bitmap je;
    private boolean jf;
    private d jg;
    private View jh;
    private GifImageType ji;
    private final Handler jj;

    static /* synthetic */ int[] du() {
        int[] iArr = jk;
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
            jk = iArr;
        }
        return iArr;
    }

    /* loaded from: classes.dex */
    public enum GifImageType {
        WAIT_FINISH(0),
        SYNC_DECODER(1),
        COVER(2);
        
        final int nativeInt;

        /* JADX DEBUG: Replace access to removed values field (jm) with 'values()' method */
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
        if (this.jd == null) {
            this.jd = new b(this);
        }
        this.jd.setGifImage(bArr);
        this.jd.start();
    }

    private void setGifDecoderImage(InputStream inputStream) {
        if (this.jd == null) {
            this.jd = new b(this);
        }
        this.jd.setGifImage(inputStream);
        this.jd.start();
    }

    public void setAsBackground(View view) {
        this.jh = view;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        if (this.jd != null) {
            this.jd.free();
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
        if (this.jd == null) {
            this.ji = gifImageType;
        }
    }

    @Override // com.baidu.adp.lib.gif.a
    public void a(boolean z, int i) {
        if (z) {
            if (this.jd != null) {
                switch (du()[this.ji.ordinal()]) {
                    case 1:
                        if (i == -1) {
                            if (this.jd.bI() > 1) {
                                new d(this, null).start();
                                return;
                            } else {
                                dt();
                                return;
                            }
                        }
                        return;
                    case 2:
                        if (i == 1) {
                            this.je = this.jd.getImage();
                            dt();
                            return;
                        } else if (i == -1) {
                            dt();
                            return;
                        } else if (this.jg == null) {
                            this.jg = new d(this, null);
                            this.jg.start();
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        if (i == 1) {
                            this.je = this.jd.getImage();
                            dt();
                            return;
                        } else if (i == -1) {
                            if (this.jd.bI() > 1) {
                                if (this.jg == null) {
                                    this.jg = new d(this, null);
                                    this.jg.start();
                                    return;
                                }
                                return;
                            }
                            dt();
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
    public void dt() {
        if (this.jj != null) {
            this.jj.sendMessage(this.jj.obtainMessage());
        }
    }
}
