package com.baidu.live.yuyingift.dynamicgift;

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
    private a bKW;
    private LruCache<String, c> baC;
    private ArrayList<String> baD;
    private com.baidu.live.gift.c baJ;
    private int bau;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int baB = 0;
    private int baE = 0;
    private int baF = 0;
    private volatile boolean isInit = false;
    private int baG = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.yuyingift.dynamicgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Im();
                    b.this.Il();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.Im();
                    break;
            }
            return true;
        }
    };
    private HandlerThread baI = new HandlerThread("read_image_thread");

    public b() {
        this.baI.start();
        this.mHandler = new Handler(this.baI.getLooper(), this.mHandlerCallback);
        this.baC = new LruCache<String, c>(3) { // from class: com.baidu.live.yuyingift.dynamicgift.b.1
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
        this.bau = i;
        this.mScreenHeight = i2;
    }

    public c gp(int i) {
        if (i < this.mImageCount && i < this.baD.size()) {
            this.baE = i;
            c cVar = this.baC.get(this.baD.get(i));
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
    public void Il() {
        int i = this.baF;
        while (true) {
            int i2 = i;
            if (i2 < this.baD.size() && this.baC.size() < this.baC.maxSize()) {
                c iN = this.bKW.iN(this.baD.get(i2));
                if (iN == null || iN.bitmap == null || this.baC.size() >= this.baC.maxSize()) {
                    break;
                }
                this.baC.put(this.baD.get(i2), iN);
                this.baF = (this.baF + 1) % this.baD.size();
                if (this.baF < this.baE) {
                    this.baF = this.baE + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void hk(String str) {
        this.baC.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Im() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.baE) {
                c cVar = this.baC.get(this.baD.get(i2));
                if (cVar != null && cVar.bbf) {
                    this.baC.remove(this.baD.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.baC != null) {
            this.baC.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.baI.quit();
        clearCache();
    }

    public boolean Ij() {
        return this.isInit;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void c(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.isInit = false;
            this.baG = 1;
            this.baE = 0;
            this.baF = 0;
            this.baJ = cVar;
            if (this.baJ.getDynamicGiftPicPathList().size() < this.baJ.aSL.aSK.frame_count) {
                this.mImageCount = this.baJ.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.baJ.aSL.aSK.frame_count;
            }
            this.baD = this.baJ.getDynamicGiftPicPathList();
            this.bKW = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void In() {
        this.baG = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private a() {
        }

        public c iN(String str) {
            return j(str, b.this.bau, b.this.mScreenHeight);
        }

        public c j(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.baG;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.bbe = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
