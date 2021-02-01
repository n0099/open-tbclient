package com.baidu.live.gift.dynamicGift;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.LruCache;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class b {
    private int bdD;
    private LruCache<String, c> bdK;
    private ArrayList<String> bdL;
    private int bdP;
    private a bdQ;
    private com.baidu.live.gift.c bdS;
    private Handler mHandler;
    private int mScreenHeight;
    private int bdJ = 0;
    private int bdM = 0;
    private int bdN = 0;
    private volatile boolean isInit = false;
    private int bdO = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.GS();
                    b.this.GR();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.GS();
                    break;
            }
            return true;
        }
    };
    private HandlerThread bdR = new HandlerThread("read_image_thread");

    public b() {
        this.bdR.start();
        this.mHandler = new Handler(this.bdR.getLooper(), this.mHandlerCallback);
        this.bdK = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.bdD = i;
        this.mScreenHeight = i2;
    }

    public c di(int i) {
        if (i < this.bdP && i < this.bdL.size()) {
            this.bdM = i;
            c cVar = this.bdK.get(this.bdL.get(i));
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
    public void GR() {
        int i = this.bdN;
        while (true) {
            int i2 = i;
            if (i2 < this.bdL.size() && this.bdK.size() < this.bdK.maxSize()) {
                c gE = this.bdQ.gE(this.bdL.get(i2));
                if (gE == null || gE.bitmap == null || this.bdK.size() >= this.bdK.maxSize()) {
                    break;
                }
                this.bdK.put(this.bdL.get(i2), gE);
                this.bdN = (this.bdN + 1) % this.bdL.size();
                if (this.bdN < this.bdM) {
                    this.bdN = this.bdM + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void gD(String str) {
        this.bdK.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GS() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bdM) {
                c cVar = this.bdK.get(this.bdL.get(i2));
                if (cVar != null && cVar.beq) {
                    this.bdK.remove(this.bdL.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.bdK != null) {
            this.bdK.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.bdR.quit();
        clearCache();
    }

    public boolean GP() {
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
            this.bdO = 1;
            this.bdM = 0;
            this.bdN = 0;
            this.bdS = cVar;
            if (this.bdS.getDynamicGiftPicPathList().size() < this.bdS.aVs.aVq.frame_count) {
                this.bdP = this.bdS.getDynamicGiftPicPathList().size();
            } else {
                this.bdP = this.bdS.aVs.aVq.frame_count;
            }
            this.bdL = this.bdS.getDynamicGiftPicPathList();
            this.bdQ = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void GT() {
        this.bdO = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private a() {
        }

        public c gE(String str) {
            return h(str, b.this.bdD, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.bdO;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.bep = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
