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
    private LruCache<String, c> aEG;
    private ArrayList<String> aEH;
    private a aEL;
    private com.baidu.live.gift.c aEN;
    private int aEy;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int aEF = 0;
    private int aEI = 0;
    private int aEJ = 0;
    private volatile boolean isInit = false;
    private int aEK = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.yB();
                    b.this.yA();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.yB();
                    break;
            }
            return true;
        }
    };
    private HandlerThread aEM = new HandlerThread("read_image_thread");

    public b() {
        this.aEM.start();
        this.mHandler = new Handler(this.aEM.getLooper(), this.mHandlerCallback);
        this.aEG = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.aEy = i;
        this.mScreenHeight = i2;
    }

    public c ca(int i) {
        if (i < this.mImageCount && i < this.aEH.size()) {
            this.aEI = i;
            c cVar = this.aEG.get(this.aEH.get(i));
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
    public void yA() {
        int i = this.aEJ;
        while (true) {
            int i2 = i;
            if (i2 < this.aEH.size() && this.aEG.size() < this.aEG.maxSize()) {
                c er = this.aEL.er(this.aEH.get(i2));
                if (er == null || er.bitmap == null || this.aEG.size() >= this.aEG.maxSize()) {
                    break;
                }
                this.aEG.put(this.aEH.get(i2), er);
                this.aEJ = (this.aEJ + 1) % this.aEH.size();
                if (this.aEJ < this.aEI) {
                    this.aEJ = this.aEI + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eq(String str) {
        this.aEG.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yB() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aEI) {
                c cVar = this.aEG.get(this.aEH.get(i2));
                if (cVar != null && cVar.aFh) {
                    this.aEG.remove(this.aEH.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.aEG != null) {
            this.aEG.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.aEM.quit();
        clearCache();
    }

    public boolean yy() {
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
            this.aEK = 1;
            this.aEI = 0;
            this.aEJ = 0;
            this.aEN = cVar;
            if (this.aEN.getDynamicGiftPicPathList().size() < this.aEN.aym.ayl.frame_count) {
                this.mImageCount = this.aEN.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.aEN.aym.ayl.frame_count;
            }
            this.aEH = this.aEN.getDynamicGiftPicPathList();
            this.aEL = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void yC() {
        this.aEK = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private a() {
        }

        public c er(String str) {
            return h(str, b.this.aEy, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.aEK;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.aFg = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
