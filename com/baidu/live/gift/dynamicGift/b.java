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
    private int bfA;
    private a bfB;
    private com.baidu.live.gift.c bfD;
    private int bfn;
    private LruCache<String, c> bfv;
    private ArrayList<String> bfw;
    private Handler mHandler;
    private int mScreenHeight;
    private int bfu = 0;
    private int bfx = 0;
    private int bfy = 0;
    private volatile boolean isInit = false;
    private int bfz = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Jx();
                    b.this.Jw();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.Jx();
                    break;
            }
            return true;
        }
    };
    private HandlerThread bfC = new HandlerThread("read_image_thread");

    public b() {
        this.bfC.start();
        this.mHandler = new Handler(this.bfC.getLooper(), this.mHandlerCallback);
        this.bfv = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.bfn = i;
        this.mScreenHeight = i2;
    }

    public c eJ(int i) {
        if (i < this.bfA && i < this.bfw.size()) {
            this.bfx = i;
            c cVar = this.bfv.get(this.bfw.get(i));
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
    public void Jw() {
        int i = this.bfy;
        while (true) {
            int i2 = i;
            if (i2 < this.bfw.size() && this.bfv.size() < this.bfv.maxSize()) {
                c hs = this.bfB.hs(this.bfw.get(i2));
                if (hs == null || hs.bitmap == null || this.bfv.size() >= this.bfv.maxSize()) {
                    break;
                }
                this.bfv.put(this.bfw.get(i2), hs);
                this.bfy = (this.bfy + 1) % this.bfw.size();
                if (this.bfy < this.bfx) {
                    this.bfy = this.bfx + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void hr(String str) {
        this.bfv.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jx() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bfx) {
                c cVar = this.bfv.get(this.bfw.get(i2));
                if (cVar != null && cVar.bga) {
                    this.bfv.remove(this.bfw.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.bfv != null) {
            this.bfv.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.bfC.quit();
        clearCache();
    }

    public boolean Ju() {
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
            this.bfz = 1;
            this.bfx = 0;
            this.bfy = 0;
            this.bfD = cVar;
            if (this.bfD.getDynamicGiftPicPathList().size() < this.bfD.aXb.aWZ.frame_count) {
                this.bfA = this.bfD.getDynamicGiftPicPathList().size();
            } else {
                this.bfA = this.bfD.aXb.aWZ.frame_count;
            }
            this.bfw = this.bfD.getDynamicGiftPicPathList();
            this.bfB = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void Jy() {
        this.bfz = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private a() {
        }

        public c hs(String str) {
            return h(str, b.this.bfn, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.bfz;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.bfZ = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
