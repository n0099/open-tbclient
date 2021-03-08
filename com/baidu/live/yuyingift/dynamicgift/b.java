package com.baidu.live.yuyingift.dynamicgift;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.LruCache;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class b {
    private int bfg;
    private LruCache<String, c> bfn;
    private ArrayList<String> bfo;
    private int bft;
    private com.baidu.live.gift.c bfw;
    private a caM;
    private Handler mHandler;
    private int mScreenHeight;
    private int bfm = 0;
    private int bfp = 0;
    private int bfq = 0;
    private volatile boolean isInit = false;
    private int bfr = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.yuyingift.dynamicgift.b.2
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
    private HandlerThread bfv = new HandlerThread("read_image_thread");

    public b() {
        this.bfv.start();
        this.mHandler = new Handler(this.bfv.getLooper(), this.mHandlerCallback);
        this.bfn = new LruCache<String, c>(3) { // from class: com.baidu.live.yuyingift.dynamicgift.b.1
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
        this.bfg = i;
        this.mScreenHeight = i2;
    }

    public c fu(int i) {
        if (i < this.bft && i < this.bfo.size()) {
            this.bfp = i;
            c cVar = this.bfn.get(this.bfo.get(i));
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
        int i = this.bfq;
        while (true) {
            int i2 = i;
            if (i2 < this.bfo.size() && this.bfn.size() < this.bfn.maxSize()) {
                c iS = this.caM.iS(this.bfo.get(i2));
                if (iS == null || iS.bitmap == null || this.bfn.size() >= this.bfn.maxSize()) {
                    break;
                }
                this.bfn.put(this.bfo.get(i2), iS);
                this.bfq = (this.bfq + 1) % this.bfo.size();
                if (this.bfq < this.bfp) {
                    this.bfq = this.bfp + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void gJ(String str) {
        this.bfn.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GV() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bfp) {
                c cVar = this.bfn.get(this.bfo.get(i2));
                if (cVar != null && cVar.bfT) {
                    this.bfn.remove(this.bfo.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.bfn != null) {
            this.bfn.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.bfv.quit();
        clearCache();
    }

    public boolean GS() {
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
            this.bfr = 1;
            this.bfp = 0;
            this.bfq = 0;
            this.bfw = cVar;
            if (this.bfw.getDynamicGiftPicPathList().size() < this.bfw.aWS.aWQ.frame_count) {
                this.bft = this.bfw.getDynamicGiftPicPathList().size();
            } else {
                this.bft = this.bfw.aWS.aWQ.frame_count;
            }
            this.bfo = this.bfw.getDynamicGiftPicPathList();
            this.caM = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void GW() {
        this.bfr = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        private a() {
        }

        public c iS(String str) {
            return j(str, b.this.bfg, b.this.mScreenHeight);
        }

        public c j(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.bfr;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.bfS = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
