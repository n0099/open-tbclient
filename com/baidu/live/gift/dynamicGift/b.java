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
    private int aEE;
    private LruCache<String, c> aEM;
    private ArrayList<String> aEN;
    private a aER;
    private com.baidu.live.gift.c aET;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int aEL = 0;
    private int aEO = 0;
    private int aEP = 0;
    private volatile boolean isInit = false;
    private int aEQ = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.yA();
                    b.this.yz();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.yA();
                    break;
            }
            return true;
        }
    };
    private HandlerThread aES = new HandlerThread("read_image_thread");

    public b() {
        this.aES.start();
        this.mHandler = new Handler(this.aES.getLooper(), this.mHandlerCallback);
        this.aEM = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.aEE = i;
        this.mScreenHeight = i2;
    }

    public c ca(int i) {
        if (i < this.mImageCount && i < this.aEN.size()) {
            this.aEO = i;
            c cVar = this.aEM.get(this.aEN.get(i));
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
    public void yz() {
        int i = this.aEP;
        while (true) {
            int i2 = i;
            if (i2 < this.aEN.size() && this.aEM.size() < this.aEM.maxSize()) {
                c er = this.aER.er(this.aEN.get(i2));
                if (er == null || er.bitmap == null || this.aEM.size() >= this.aEM.maxSize()) {
                    break;
                }
                this.aEM.put(this.aEN.get(i2), er);
                this.aEP = (this.aEP + 1) % this.aEN.size();
                if (this.aEP < this.aEO) {
                    this.aEP = this.aEO + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eq(String str) {
        this.aEM.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yA() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aEO) {
                c cVar = this.aEM.get(this.aEN.get(i2));
                if (cVar != null && cVar.aFn) {
                    this.aEM.remove(this.aEN.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.aEM != null) {
            this.aEM.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.aES.quit();
        clearCache();
    }

    public boolean yx() {
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
            this.aEQ = 1;
            this.aEO = 0;
            this.aEP = 0;
            this.aET = cVar;
            if (this.aET.getDynamicGiftPicPathList().size() < this.aET.ays.ayr.frame_count) {
                this.mImageCount = this.aET.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.aET.ays.ayr.frame_count;
            }
            this.aEN = this.aET.getDynamicGiftPicPathList();
            this.aER = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void yB() {
        this.aEQ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private a() {
        }

        public c er(String str) {
            return h(str, b.this.aEE, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.aEQ;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.aFm = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
