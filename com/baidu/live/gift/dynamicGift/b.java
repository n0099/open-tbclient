package com.baidu.live.gift.dynamicGift;

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
    private LruCache<String, c> baF;
    private ArrayList<String> baG;
    private int baK;
    private a baL;
    private com.baidu.live.gift.c baN;
    private int bax;
    private Handler mHandler;
    private int mScreenHeight;
    private int baE = 0;
    private int baH = 0;
    private int baI = 0;
    private volatile boolean isInit = false;
    private int baJ = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.FC();
                    b.this.FB();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.FC();
                    break;
            }
            return true;
        }
    };
    private HandlerThread baM = new HandlerThread("read_image_thread");

    public b() {
        this.baM.start();
        this.mHandler = new Handler(this.baM.getLooper(), this.mHandlerCallback);
        this.baF = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.bax = i;
        this.mScreenHeight = i2;
    }

    public c dd(int i) {
        if (i < this.baK && i < this.baG.size()) {
            this.baH = i;
            c cVar = this.baF.get(this.baG.get(i));
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
    public void FB() {
        int i = this.baI;
        while (true) {
            int i2 = i;
            if (i2 < this.baG.size() && this.baF.size() < this.baF.maxSize()) {
                c gg = this.baL.gg(this.baG.get(i2));
                if (gg == null || gg.bitmap == null || this.baF.size() >= this.baF.maxSize()) {
                    break;
                }
                this.baF.put(this.baG.get(i2), gg);
                this.baI = (this.baI + 1) % this.baG.size();
                if (this.baI < this.baH) {
                    this.baI = this.baH + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void gf(String str) {
        this.baF.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FC() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.baH) {
                c cVar = this.baF.get(this.baG.get(i2));
                if (cVar != null && cVar.bbk) {
                    this.baF.remove(this.baG.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.baF != null) {
            this.baF.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.baM.quit();
        clearCache();
    }

    public boolean Fz() {
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
            this.baJ = 1;
            this.baH = 0;
            this.baI = 0;
            this.baN = cVar;
            if (this.baN.getDynamicGiftPicPathList().size() < this.baN.aSo.aSm.frame_count) {
                this.baK = this.baN.getDynamicGiftPicPathList().size();
            } else {
                this.baK = this.baN.aSo.aSm.frame_count;
            }
            this.baG = this.baN.getDynamicGiftPicPathList();
            this.baL = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void FD() {
        this.baJ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        private a() {
        }

        public c gg(String str) {
            return h(str, b.this.bax, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.baJ;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.bbj = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
