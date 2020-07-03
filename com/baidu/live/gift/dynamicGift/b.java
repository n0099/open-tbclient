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
    private int aMM;
    private LruCache<String, c> aMU;
    private ArrayList<String> aMV;
    private a aMZ;
    private com.baidu.live.gift.c aNb;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int aMT = 0;
    private int aMW = 0;
    private int aMX = 0;
    private volatile boolean isInit = false;
    private int aMY = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Aq();
                    b.this.Ap();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.Aq();
                    break;
            }
            return true;
        }
    };
    private HandlerThread aNa = new HandlerThread("read_image_thread");

    public b() {
        this.aNa.start();
        this.mHandler = new Handler(this.aNa.getLooper(), this.mHandlerCallback);
        this.aMU = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.aMM = i;
        this.mScreenHeight = i2;
    }

    public c cp(int i) {
        if (i < this.mImageCount && i < this.aMV.size()) {
            this.aMW = i;
            c cVar = this.aMU.get(this.aMV.get(i));
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
    public void Ap() {
        int i = this.aMX;
        while (true) {
            int i2 = i;
            if (i2 < this.aMV.size() && this.aMU.size() < this.aMU.maxSize()) {
                c fh = this.aMZ.fh(this.aMV.get(i2));
                if (fh == null || fh.bitmap == null || this.aMU.size() >= this.aMU.maxSize()) {
                    break;
                }
                this.aMU.put(this.aMV.get(i2), fh);
                this.aMX = (this.aMX + 1) % this.aMV.size();
                if (this.aMX < this.aMW) {
                    this.aMX = this.aMW + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void fg(String str) {
        this.aMU.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aq() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aMW) {
                c cVar = this.aMU.get(this.aMV.get(i2));
                if (cVar != null && cVar.aNw) {
                    this.aMU.remove(this.aMV.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.aMU != null) {
            this.aMU.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.aNa.quit();
        clearCache();
    }

    public boolean An() {
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
            this.aMY = 1;
            this.aMW = 0;
            this.aMX = 0;
            this.aNb = cVar;
            if (this.aNb.getDynamicGiftPicPathList().size() < this.aNb.aGg.aGf.frame_count) {
                this.mImageCount = this.aNb.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.aNb.aGg.aGf.frame_count;
            }
            this.aMV = this.aNb.getDynamicGiftPicPathList();
            this.aMZ = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void Ar() {
        this.aMY = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private a() {
        }

        public c fh(String str) {
            return h(str, b.this.aMM, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.aMY;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.aNv = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
