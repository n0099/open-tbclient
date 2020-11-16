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
    private int baa;
    private LruCache<String, c> bai;
    private ArrayList<String> baj;
    private a ban;
    private com.baidu.live.gift.c bap;
    private Handler mHandler;
    private int mImageCount;
    private int mScreenHeight;
    private int bah = 0;
    private int bak = 0;
    private int bal = 0;
    private volatile boolean isInit = false;
    private int bam = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.gift.dynamicGift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Ie();
                    b.this.Id();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.Ie();
                    break;
            }
            return true;
        }
    };
    private HandlerThread bao = new HandlerThread("read_image_thread");

    public b() {
        this.bao.start();
        this.mHandler = new Handler(this.bao.getLooper(), this.mHandlerCallback);
        this.bai = new LruCache<String, c>(3) { // from class: com.baidu.live.gift.dynamicGift.b.1
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
        this.baa = i;
        this.mScreenHeight = i2;
    }

    public c eq(int i) {
        if (i < this.mImageCount && i < this.baj.size()) {
            this.bak = i;
            c cVar = this.bai.get(this.baj.get(i));
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
    public void Id() {
        int i = this.bal;
        while (true) {
            int i2 = i;
            if (i2 < this.baj.size() && this.bai.size() < this.bai.maxSize()) {
                c hm = this.ban.hm(this.baj.get(i2));
                if (hm == null || hm.bitmap == null || this.bai.size() >= this.bai.maxSize()) {
                    break;
                }
                this.bai.put(this.baj.get(i2), hm);
                this.bal = (this.bal + 1) % this.baj.size();
                if (this.bal < this.bak) {
                    this.bal = this.bak + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void hl(String str) {
        this.bai.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ie() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bak) {
                c cVar = this.bai.get(this.baj.get(i2));
                if (cVar != null && cVar.baM) {
                    this.bai.remove(this.baj.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.bai != null) {
            this.bai.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.bao.quit();
        clearCache();
    }

    public boolean Ib() {
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
            this.bam = 1;
            this.bak = 0;
            this.bal = 0;
            this.bap = cVar;
            if (this.bap.getDynamicGiftPicPathList().size() < this.bap.aSt.aSs.frame_count) {
                this.mImageCount = this.bap.getDynamicGiftPicPathList().size();
            } else {
                this.mImageCount = this.bap.aSt.aSs.frame_count;
            }
            this.baj = this.bap.getDynamicGiftPicPathList();
            this.ban = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void If() {
        this.bam = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private a() {
        }

        public c hm(String str) {
            return h(str, b.this.baa, b.this.mScreenHeight);
        }

        public c h(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.bam;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.baL = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
