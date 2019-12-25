package com.baidu.live.gift.dynamicGift;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.LruCache;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    private int ajf;
    private LruCache<String, c> ajn;
    private ArrayList<String> ajo;
    private a ajs;
    private com.baidu.live.gift.c aju;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int ajm = 0;
    private int ajp = 0;
    private int ajq = 0;
    private volatile boolean isInit = false;
    private int ajr = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.sA();
                    b.this.sz();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.sA();
                    break;
            }
            return true;
        }
    };
    private HandlerThread ajt = new HandlerThread("read_image_thread");

    public b() {
        this.ajt.start();
        this.mHandler = new Handler(this.ajt.getLooper(), this.mHandlerCallback);
        this.ajn = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.ajf = i;
        this.mScreenHeight = i2;
    }

    public c bD(int i) {
        if (i < this.mImageCount && i < this.ajo.size()) {
            this.ajp = i;
            c cVar = this.ajn.get(this.ajo.get(i));
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
    public void sz() {
        int i = this.ajq;
        while (true) {
            int i2 = i;
            if (i2 < this.ajo.size() && this.ajn.size() < this.ajn.maxSize()) {
                c m14do = this.ajs.m14do(this.ajo.get(i2));
                if (m14do == null || m14do.bitmap == null || this.ajn.size() >= this.ajn.maxSize()) {
                    break;
                }
                this.ajn.put(this.ajo.get(i2), m14do);
                this.ajq = (this.ajq + 1) % this.ajo.size();
                if (this.ajq < this.ajp) {
                    this.ajq = this.ajp + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dn(String str) {
        this.ajn.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sA() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ajp) {
                c cVar = this.ajn.get(this.ajo.get(i2));
                if (cVar != null && cVar.ajJ) {
                    this.ajn.remove(this.ajo.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.ajn != null) {
            this.ajn.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.ajt.quit();
        clearCache();
    }

    public boolean sx() {
        return this.isInit;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void a(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.isInit = false;
            this.ajr = 1;
            this.ajp = 0;
            this.ajq = 0;
            this.aju = cVar;
            if (this.aju.getDynamicGiftPicPathList().size() < this.aju.adu.adt.frame_count) {
                this.mImageCount = this.aju.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.aju.adu.adt.frame_count;
            }
            this.ajo = this.aju.getDynamicGiftPicPathList();
            this.ajs = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void sB() {
        this.ajr = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        private a() {
        }

        /* renamed from: do  reason: not valid java name */
        public c m14do(String str) {
            return h(str, b.this.ajf, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.ajr;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.ajI = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
