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
    private int alV;
    private LruCache<String, c> amd;
    private ArrayList<String> ame;
    private a ami;
    private com.baidu.live.gift.c amk;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int amc = 0;
    private int amf = 0;
    private int amg = 0;
    private volatile boolean isInit = false;
    private int amh = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.uc();
                    b.this.ub();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.uc();
                    break;
            }
            return true;
        }
    };
    private HandlerThread amj = new HandlerThread("read_image_thread");

    public b() {
        this.amj.start();
        this.mHandler = new Handler(this.amj.getLooper(), this.mHandlerCallback);
        this.amd = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.alV = i;
        this.mScreenHeight = i2;
    }

    public c bK(int i) {
        if (i < this.mImageCount && i < this.ame.size()) {
            this.amf = i;
            c cVar = this.amd.get(this.ame.get(i));
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
    public void ub() {
        int i = this.amg;
        while (true) {
            int i2 = i;
            if (i2 < this.ame.size() && this.amd.size() < this.amd.maxSize()) {
                c dA = this.ami.dA(this.ame.get(i2));
                if (dA == null || dA.bitmap == null || this.amd.size() >= this.amd.maxSize()) {
                    break;
                }
                this.amd.put(this.ame.get(i2), dA);
                this.amg = (this.amg + 1) % this.ame.size();
                if (this.amg < this.amf) {
                    this.amg = this.amf + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dz(String str) {
        this.amd.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.amf) {
                c cVar = this.amd.get(this.ame.get(i2));
                if (cVar != null && cVar.amE) {
                    this.amd.remove(this.ame.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.amd != null) {
            this.amd.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.amj.quit();
        clearCache();
    }

    public boolean tZ() {
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
            this.amh = 1;
            this.amf = 0;
            this.amg = 0;
            this.amk = cVar;
            if (this.amk.getDynamicGiftPicPathList().size() < this.amk.afL.afK.frame_count) {
                this.mImageCount = this.amk.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.amk.afL.afK.frame_count;
            }
            this.ame = this.amk.getDynamicGiftPicPathList();
            this.ami = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void ud() {
        this.amh = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private a() {
        }

        public c dA(String str) {
            return h(str, b.this.alV, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.amh;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.amD = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
