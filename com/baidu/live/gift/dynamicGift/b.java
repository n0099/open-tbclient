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
    private int amg;
    private LruCache<String, c> amo;
    private ArrayList<String> amp;
    private a amt;
    private com.baidu.live.gift.c amv;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int amn = 0;
    private int amq = 0;
    private int amr = 0;
    private volatile boolean isInit = false;
    private int ams = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.uh();
                    b.this.ug();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.uh();
                    break;
            }
            return true;
        }
    };
    private HandlerThread amu = new HandlerThread("read_image_thread");

    public b() {
        this.amu.start();
        this.mHandler = new Handler(this.amu.getLooper(), this.mHandlerCallback);
        this.amo = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.amg = i;
        this.mScreenHeight = i2;
    }

    public c bK(int i) {
        if (i < this.mImageCount && i < this.amp.size()) {
            this.amq = i;
            c cVar = this.amo.get(this.amp.get(i));
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
    public void ug() {
        int i = this.amr;
        while (true) {
            int i2 = i;
            if (i2 < this.amp.size() && this.amo.size() < this.amo.maxSize()) {
                c dz = this.amt.dz(this.amp.get(i2));
                if (dz == null || dz.bitmap == null || this.amo.size() >= this.amo.maxSize()) {
                    break;
                }
                this.amo.put(this.amp.get(i2), dz);
                this.amr = (this.amr + 1) % this.amp.size();
                if (this.amr < this.amq) {
                    this.amr = this.amq + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dy(String str) {
        this.amo.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.amq) {
                c cVar = this.amo.get(this.amp.get(i2));
                if (cVar != null && cVar.amP) {
                    this.amo.remove(this.amp.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.amo != null) {
            this.amo.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.amu.quit();
        clearCache();
    }

    public boolean ue() {
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
            this.ams = 1;
            this.amq = 0;
            this.amr = 0;
            this.amv = cVar;
            if (this.amv.getDynamicGiftPicPathList().size() < this.amv.afV.afU.frame_count) {
                this.mImageCount = this.amv.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.amv.afV.afU.frame_count;
            }
            this.amp = this.amv.getDynamicGiftPicPathList();
            this.amt = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void ui() {
        this.ams = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private a() {
        }

        public c dz(String str) {
            return h(str, b.this.amg, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.ams;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.amO = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
