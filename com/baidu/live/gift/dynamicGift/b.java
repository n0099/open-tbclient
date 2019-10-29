package com.baidu.live.gift.dynamicGift;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.LruCache;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    private LruCache<String, c> abE;
    private ArrayList<String> abF;
    private int abJ;
    private a abK;
    private com.baidu.live.gift.c abM;
    private int abw;
    private Handler mHandler;
    private int mScreenHeight;
    private int abD = 0;
    private int abG = 0;
    private int abH = 0;
    private volatile boolean isInit = false;
    private int abI = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.qQ();
                    b.this.qP();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.qQ();
                    break;
            }
            return true;
        }
    };
    private HandlerThread abL = new HandlerThread("read_image_thread");

    public b() {
        this.abL.start();
        this.mHandler = new Handler(this.abL.getLooper(), this.mHandlerCallback);
        this.abE = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.abw = i;
        this.mScreenHeight = i2;
    }

    public c br(int i) {
        if (i < this.abJ && i < this.abF.size()) {
            this.abG = i;
            c cVar = this.abE.get(this.abF.get(i));
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
    public void qP() {
        int i = this.abH;
        while (true) {
            int i2 = i;
            if (i2 < this.abF.size() && this.abE.size() < this.abE.maxSize()) {
                c cw = this.abK.cw(this.abF.get(i2));
                if (cw == null || cw.bitmap == null || this.abE.size() >= this.abE.maxSize()) {
                    break;
                }
                this.abE.put(this.abF.get(i2), cw);
                this.abH = (this.abH + 1) % this.abF.size();
                if (this.abH < this.abG) {
                    this.abH = this.abG + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void cv(String str) {
        this.abE.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qQ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.abG) {
                c cVar = this.abE.get(this.abF.get(i2));
                if (cVar != null && cVar.acc) {
                    this.abE.remove(this.abF.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.abE != null) {
            this.abE.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.abL.quit();
        clearCache();
    }

    public boolean qN() {
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
            this.abI = 1;
            this.abG = 0;
            this.abH = 0;
            this.abM = cVar;
            if (this.abM.getDynamicGiftPicPathList().size() < this.abM.Wm.Wl.frame_count) {
                this.abJ = this.abM.getDynamicGiftPicPathList().size();
            } else {
                this.abJ = this.abM.Wm.Wl.frame_count;
            }
            this.abF = this.abM.getDynamicGiftPicPathList();
            this.abK = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void qR() {
        this.abI = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        private a() {
        }

        public c cw(String str) {
            return h(str, b.this.abw, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.abI;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.acb = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
