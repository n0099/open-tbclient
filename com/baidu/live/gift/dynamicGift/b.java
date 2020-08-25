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
    private LruCache<String, c> aTC;
    private ArrayList<String> aTD;
    private a aTH;
    private com.baidu.live.gift.c aTJ;
    private int aTu;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int aTB = 0;
    private int aTE = 0;
    private int aTF = 0;
    private volatile boolean isInit = false;
    private int aTG = 1;
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
    private HandlerThread aTI = new HandlerThread("read_image_thread");

    public b() {
        this.aTI.start();
        this.mHandler = new Handler(this.aTI.getLooper(), this.mHandlerCallback);
        this.aTC = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.aTu = i;
        this.mScreenHeight = i2;
    }

    public c ek(int i) {
        if (i < this.mImageCount && i < this.aTD.size()) {
            this.aTE = i;
            c cVar = this.aTC.get(this.aTD.get(i));
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
        int i = this.aTF;
        while (true) {
            int i2 = i;
            if (i2 < this.aTD.size() && this.aTC.size() < this.aTC.maxSize()) {
                c gB = this.aTH.gB(this.aTD.get(i2));
                if (gB == null || gB.bitmap == null || this.aTC.size() >= this.aTC.maxSize()) {
                    break;
                }
                this.aTC.put(this.aTD.get(i2), gB);
                this.aTF = (this.aTF + 1) % this.aTD.size();
                if (this.aTF < this.aTE) {
                    this.aTF = this.aTE + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void gA(String str) {
        this.aTC.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gv() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aTE) {
                c cVar = this.aTC.get(this.aTD.get(i2));
                if (cVar != null && cVar.aUf) {
                    this.aTC.remove(this.aTD.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.aTC != null) {
            this.aTC.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.aTI.quit();
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
            this.aTG = 1;
            this.aTE = 0;
            this.aTF = 0;
            this.aTJ = cVar;
            if (this.aTJ.getDynamicGiftPicPathList().size() < this.aTJ.aML.aMK.frame_count) {
                this.mImageCount = this.aTJ.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.aTJ.aML.aMK.frame_count;
            }
            this.aTD = this.aTJ.getDynamicGiftPicPathList();
            this.aTH = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void Gw() {
        this.aTG = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        private a() {
        }

        public c gB(String str) {
            return h(str, b.this.aTu, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.aTG;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.aUe = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
