package com.baidu.live.gift.dynamicGift;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.LruCache;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b {
    private int aKg;
    private LruCache<String, c> aKo;
    private ArrayList<String> aKp;
    private a aKt;
    private com.baidu.live.gift.c aKv;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int aKn = 0;
    private int aKq = 0;
    private int aKr = 0;
    private volatile boolean isInit = false;
    private int aKs = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.zQ();
                    b.this.zP();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.zQ();
                    break;
            }
            return true;
        }
    };
    private HandlerThread aKu = new HandlerThread("read_image_thread");

    public b() {
        this.aKu.start();
        this.mHandler = new Handler(this.aKu.getLooper(), this.mHandlerCallback);
        this.aKo = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.aKg = i;
        this.mScreenHeight = i2;
    }

    public c ch(int i) {
        if (i < this.mImageCount && i < this.aKp.size()) {
            this.aKq = i;
            c cVar = this.aKo.get(this.aKp.get(i));
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
    public void zP() {
        int i = this.aKr;
        while (true) {
            int i2 = i;
            if (i2 < this.aKp.size() && this.aKo.size() < this.aKo.maxSize()) {
                c fb = this.aKt.fb(this.aKp.get(i2));
                if (fb == null || fb.bitmap == null || this.aKo.size() >= this.aKo.maxSize()) {
                    break;
                }
                this.aKo.put(this.aKp.get(i2), fb);
                this.aKr = (this.aKr + 1) % this.aKp.size();
                if (this.aKr < this.aKq) {
                    this.aKr = this.aKq + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void fa(String str) {
        this.aKo.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zQ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aKq) {
                c cVar = this.aKo.get(this.aKp.get(i2));
                if (cVar != null && cVar.aKQ) {
                    this.aKo.remove(this.aKp.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.aKo != null) {
            this.aKo.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.aKu.quit();
        clearCache();
    }

    public boolean zN() {
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
            this.aKs = 1;
            this.aKq = 0;
            this.aKr = 0;
            this.aKv = cVar;
            if (this.aKv.getDynamicGiftPicPathList().size() < this.aKv.aDK.aDJ.frame_count) {
                this.mImageCount = this.aKv.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.aKv.aDK.aDJ.frame_count;
            }
            this.aKp = this.aKv.getDynamicGiftPicPathList();
            this.aKt = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void zR() {
        this.aKs = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private a() {
        }

        public c fb(String str) {
            return h(str, b.this.aKg, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.aKs;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.aKP = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
