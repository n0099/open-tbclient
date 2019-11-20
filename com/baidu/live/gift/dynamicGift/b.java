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
    private int abd;
    private LruCache<String, c> abl;
    private ArrayList<String> abm;
    private int abq;
    private a abr;
    private com.baidu.live.gift.c abu;
    private Handler mHandler;
    private int mScreenHeight;
    private int abk = 0;
    private int abn = 0;
    private int abo = 0;
    private volatile boolean isInit = false;
    private int abp = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.qR();
                    b.this.qQ();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.qR();
                    break;
            }
            return true;
        }
    };
    private HandlerThread abt = new HandlerThread("read_image_thread");

    public b() {
        this.abt.start();
        this.mHandler = new Handler(this.abt.getLooper(), this.mHandlerCallback);
        this.abl = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.abd = i;
        this.mScreenHeight = i2;
    }

    public c br(int i) {
        if (i < this.abq && i < this.abm.size()) {
            this.abn = i;
            c cVar = this.abl.get(this.abm.get(i));
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
    public void qQ() {
        int i = this.abo;
        while (true) {
            int i2 = i;
            if (i2 < this.abm.size() && this.abl.size() < this.abl.maxSize()) {
                c cw = this.abr.cw(this.abm.get(i2));
                if (cw == null || cw.bitmap == null || this.abl.size() >= this.abl.maxSize()) {
                    break;
                }
                this.abl.put(this.abm.get(i2), cw);
                this.abo = (this.abo + 1) % this.abm.size();
                if (this.abo < this.abn) {
                    this.abo = this.abn + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void cv(String str) {
        this.abl.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.abn) {
                c cVar = this.abl.get(this.abm.get(i2));
                if (cVar != null && cVar.abK) {
                    this.abl.remove(this.abm.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.abl != null) {
            this.abl.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.abt.quit();
        clearCache();
    }

    public boolean qO() {
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
            this.abp = 1;
            this.abn = 0;
            this.abo = 0;
            this.abu = cVar;
            if (this.abu.getDynamicGiftPicPathList().size() < this.abu.VT.VS.frame_count) {
                this.abq = this.abu.getDynamicGiftPicPathList().size();
            } else {
                this.abq = this.abu.VT.VS.frame_count;
            }
            this.abm = this.abu.getDynamicGiftPicPathList();
            this.abr = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void qS() {
        this.abp = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        private a() {
        }

        public c cw(String str) {
            return h(str, b.this.abd, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.abp;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.abJ = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
