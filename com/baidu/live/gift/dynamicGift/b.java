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
    private int aVL;
    private LruCache<String, c> aVT;
    private ArrayList<String> aVU;
    private a aVY;
    private com.baidu.live.gift.c aWa;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int aVS = 0;
    private int aVV = 0;
    private int aVW = 0;
    private volatile boolean isInit = false;
    private int aVX = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.GV();
                    b.this.GU();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.GV();
                    break;
            }
            return true;
        }
    };
    private HandlerThread aVZ = new HandlerThread("read_image_thread");

    public b() {
        this.aVZ.start();
        this.mHandler = new Handler(this.aVZ.getLooper(), this.mHandlerCallback);
        this.aVT = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.aVL = i;
        this.mScreenHeight = i2;
    }

    public c eo(int i) {
        if (i < this.mImageCount && i < this.aVU.size()) {
            this.aVV = i;
            c cVar = this.aVT.get(this.aVU.get(i));
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
    public void GU() {
        int i = this.aVW;
        while (true) {
            int i2 = i;
            if (i2 < this.aVU.size() && this.aVT.size() < this.aVT.maxSize()) {
                c gM = this.aVY.gM(this.aVU.get(i2));
                if (gM == null || gM.bitmap == null || this.aVT.size() >= this.aVT.maxSize()) {
                    break;
                }
                this.aVT.put(this.aVU.get(i2), gM);
                this.aVW = (this.aVW + 1) % this.aVU.size();
                if (this.aVW < this.aVV) {
                    this.aVW = this.aVV + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void gL(String str) {
        this.aVT.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GV() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aVV) {
                c cVar = this.aVT.get(this.aVU.get(i2));
                if (cVar != null && cVar.aWw) {
                    this.aVT.remove(this.aVU.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.aVT != null) {
            this.aVT.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.aVZ.quit();
        clearCache();
    }

    public boolean GS() {
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
            this.aVX = 1;
            this.aVV = 0;
            this.aVW = 0;
            this.aWa = cVar;
            if (this.aWa.getDynamicGiftPicPathList().size() < this.aWa.aOF.aOE.frame_count) {
                this.mImageCount = this.aWa.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.aWa.aOF.aOE.frame_count;
            }
            this.aVU = this.aWa.getDynamicGiftPicPathList();
            this.aVY = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void GW() {
        this.aVX = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private a() {
        }

        public c gM(String str) {
            return h(str, b.this.aVL, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.aVX;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.aWv = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
