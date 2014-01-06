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
    private b a;
    private Bitmap b;
    private boolean c;
    private boolean d;
    private f e;
    private View f;
    private GifImageType g;
    private Handler h;

    /* loaded from: classes.dex */
    public enum GifImageType {
        WAIT_FINISH(0),
        SYNC_DECODER(1),
        COVER(2);
        
        final int nativeInt;

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
        this.f = view;
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
            this.g = gifImageType;
        }
    }

    @Override // com.baidu.adp.lib.gif.a
    public void a(boolean z, int i) {
        if (z) {
            if (this.a != null) {
                switch (this.g) {
                    case WAIT_FINISH:
                        if (i == -1) {
                            if (this.a.b() > 1) {
                                new f(this, null).start();
                                return;
                            } else {
                                a();
                                return;
                            }
                        }
                        return;
                    case COVER:
                        if (i == 1) {
                            this.b = this.a.c();
                            a();
                            return;
                        } else if (i == -1) {
                            if (this.a.b() > 1) {
                                if (this.e == null) {
                                    this.e = new f(this, null);
                                    this.e.start();
                                    return;
                                }
                                return;
                            }
                            a();
                            return;
                        } else {
                            return;
                        }
                    case SYNC_DECODER:
                        if (i == 1) {
                            this.b = this.a.c();
                            a();
                            return;
                        } else if (i == -1) {
                            a();
                            return;
                        } else if (this.e == null) {
                            this.e = new f(this, null);
                            this.e.start();
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
    public void a() {
        if (this.h != null) {
            this.h.sendMessage(this.h.obtainMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        setImageBitmap(this.b);
        invalidate();
    }
}
