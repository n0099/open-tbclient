package com.baidu.live.gift.dynamicGift;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.LruCache;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class b {
    private LruCache<String, c> aTE;
    private ArrayList<String> aTF;
    private a aTJ;
    private com.baidu.live.gift.c aTL;
    private int aTw;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int aTD = 0;
    private int aTG = 0;
    private int aTH = 0;
    private volatile boolean isInit = false;
    private int aTI = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Gv();
                    b.this.Gu();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.Gv();
                    break;
            }
            return true;
        }
    };
    private HandlerThread aTK = new HandlerThread("read_image_thread");

    public b() {
        this.aTK.start();
        this.mHandler = new Handler(this.aTK.getLooper(), this.mHandlerCallback);
        this.aTE = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, c cVar, c cVar2) {
                if (cVar != null && cVar.bitmap != null) {
                    cVar.bitmap.recycle();
                }
            }
        };
    }

    public void setScreen(int i, int i2) {
        this.aTw = i;
        this.mScreenHeight = i2;
    }

    public c ek(int i) {
        if (i < this.mImageCount && i < this.aTF.size()) {
            this.aTG = i;
            c cVar = this.aTE.get(this.aTF.get(i));
            if (cVar == null) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                this.mHandler.sendMessage(obtain);
            } else {
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
        if (r0.bitmap == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
        r0.bitmap.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Gu() {
        int i = this.aTH;
        while (true) {
            int i2 = i;
            if (i2 < this.aTF.size() && this.aTE.size() < this.aTE.maxSize()) {
                c gC = this.aTJ.gC(this.aTF.get(i2));
                if (gC == null || gC.bitmap == null || this.aTE.size() >= this.aTE.maxSize()) {
                    break;
                }
                this.aTE.put(this.aTF.get(i2), gC);
                this.aTH = (this.aTH + 1) % this.aTF.size();
                if (this.aTH < this.aTG) {
                    this.aTH = this.aTG + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void gB(String str) {
        this.aTE.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gv() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aTG) {
                c cVar = this.aTE.get(this.aTF.get(i2));
                if (cVar != null && cVar.aUh) {
                    this.aTE.remove(this.aTF.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.aTE != null) {
            this.aTE.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.aTK.quit();
        clearCache();
    }

    public boolean Gs() {
        return this.isInit;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void b(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.isInit = false;
            this.aTI = 1;
            this.aTG = 0;
            this.aTH = 0;
            this.aTL = cVar;
            if (this.aTL.getDynamicGiftPicPathList().size() < this.aTL.aMN.aMM.frame_count) {
                this.mImageCount = this.aTL.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.aTL.aMN.aMM.frame_count;
            }
            this.aTF = this.aTL.getDynamicGiftPicPathList();
            this.aTJ = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void Gw() {
        this.aTI = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        private a() {
        }

        public c gC(String str) {
            return h(str, b.this.aTw, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.aTI;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.aUg = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
