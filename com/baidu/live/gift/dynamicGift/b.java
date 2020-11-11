package com.baidu.live.gift.dynamicGift;

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
    private int bbM;
    private LruCache<String, c> bbU;
    private ArrayList<String> bbV;
    private a bbZ;
    private com.baidu.live.gift.c bcb;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int bbT = 0;
    private int bbW = 0;
    private int bbX = 0;
    private volatile boolean isInit = false;
    private int bbY = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.IN();
                    b.this.IM();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.IN();
                    break;
            }
            return true;
        }
    };
    private HandlerThread bca = new HandlerThread("read_image_thread");

    public b() {
        this.bca.start();
        this.mHandler = new Handler(this.bca.getLooper(), this.mHandlerCallback);
        this.bbU = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.bbM = i;
        this.mScreenHeight = i2;
    }

    public c eu(int i) {
        if (i < this.mImageCount && i < this.bbV.size()) {
            this.bbW = i;
            c cVar = this.bbU.get(this.bbV.get(i));
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
    public void IM() {
        int i = this.bbX;
        while (true) {
            int i2 = i;
            if (i2 < this.bbV.size() && this.bbU.size() < this.bbU.maxSize()) {
                c hs = this.bbZ.hs(this.bbV.get(i2));
                if (hs == null || hs.bitmap == null || this.bbU.size() >= this.bbU.maxSize()) {
                    break;
                }
                this.bbU.put(this.bbV.get(i2), hs);
                this.bbX = (this.bbX + 1) % this.bbV.size();
                if (this.bbX < this.bbW) {
                    this.bbX = this.bbW + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void hr(String str) {
        this.bbU.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bbW) {
                c cVar = this.bbU.get(this.bbV.get(i2));
                if (cVar != null && cVar.bcx) {
                    this.bbU.remove(this.bbV.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.bbU != null) {
            this.bbU.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.bca.quit();
        clearCache();
    }

    public boolean IK() {
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
            this.bbY = 1;
            this.bbW = 0;
            this.bbX = 0;
            this.bcb = cVar;
            if (this.bcb.getDynamicGiftPicPathList().size() < this.bcb.aUe.aUd.frame_count) {
                this.mImageCount = this.bcb.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.bcb.aUe.aUd.frame_count;
            }
            this.bbV = this.bcb.getDynamicGiftPicPathList();
            this.bbZ = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void IO() {
        this.bbY = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private a() {
        }

        public c hs(String str) {
            return h(str, b.this.bbM, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.bbY;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.bcw = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
