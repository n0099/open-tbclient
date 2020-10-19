package com.baidu.live.gift.dynamicGift;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.LruCache;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    private int aYW;
    private LruCache<String, c> aZe;
    private ArrayList<String> aZf;
    private a aZj;
    private com.baidu.live.gift.c aZl;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int aZd = 0;
    private int aZg = 0;
    private int aZh = 0;
    private volatile boolean isInit = false;
    private int aZi = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.HR();
                    b.this.HQ();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.HR();
                    break;
            }
            return true;
        }
    };
    private HandlerThread aZk = new HandlerThread("read_image_thread");

    public b() {
        this.aZk.start();
        this.mHandler = new Handler(this.aZk.getLooper(), this.mHandlerCallback);
        this.aZe = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.aYW = i;
        this.mScreenHeight = i2;
    }

    public c et(int i) {
        if (i < this.mImageCount && i < this.aZf.size()) {
            this.aZg = i;
            c cVar = this.aZe.get(this.aZf.get(i));
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
    public void HQ() {
        int i = this.aZh;
        while (true) {
            int i2 = i;
            if (i2 < this.aZf.size() && this.aZe.size() < this.aZe.maxSize()) {
                c ha = this.aZj.ha(this.aZf.get(i2));
                if (ha == null || ha.bitmap == null || this.aZe.size() >= this.aZe.maxSize()) {
                    break;
                }
                this.aZe.put(this.aZf.get(i2), ha);
                this.aZh = (this.aZh + 1) % this.aZf.size();
                if (this.aZh < this.aZg) {
                    this.aZh = this.aZg + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void gZ(String str) {
        this.aZe.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aZg) {
                c cVar = this.aZe.get(this.aZf.get(i2));
                if (cVar != null && cVar.aZH) {
                    this.aZe.remove(this.aZf.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.aZe != null) {
            this.aZe.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.aZk.quit();
        clearCache();
    }

    public boolean HO() {
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
            this.aZi = 1;
            this.aZg = 0;
            this.aZh = 0;
            this.aZl = cVar;
            if (this.aZl.getDynamicGiftPicPathList().size() < this.aZl.aRQ.aRP.frame_count) {
                this.mImageCount = this.aZl.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.aZl.aRQ.aRP.frame_count;
            }
            this.aZf = this.aZl.getDynamicGiftPicPathList();
            this.aZj = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void HS() {
        this.aZi = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private a() {
        }

        public c ha(String str) {
            return h(str, b.this.aYW, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.aZi;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.aZG = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
