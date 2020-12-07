package com.baidu.live.yuyingift.dynamicgift;

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
    private a bUe;
    private int bdA;
    private LruCache<String, c> bdI;
    private ArrayList<String> bdJ;
    private int bdN;
    private com.baidu.live.gift.c bdQ;
    private Handler mHandler;
    private int mScreenHeight;
    private int bdH = 0;
    private int bdK = 0;
    private int bdL = 0;
    private volatile boolean isInit = false;
    private int bdM = 1;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.yuyingift.dynamicgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.JV();
                    b.this.JU();
                    b.this.isInit = true;
                    break;
                case 2:
                    b.this.JV();
                    break;
            }
            return true;
        }
    };
    private HandlerThread bdP = new HandlerThread("read_image_thread");

    public b() {
        this.bdP.start();
        this.mHandler = new Handler(this.bdP.getLooper(), this.mHandlerCallback);
        this.bdI = new LruCache<String, c>(3) { // from class: com.baidu.live.yuyingift.dynamicgift.b.1
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
        this.bdA = i;
        this.mScreenHeight = i2;
    }

    public c gT(int i) {
        if (i < this.bdN && i < this.bdJ.size()) {
            this.bdK = i;
            c cVar = this.bdI.get(this.bdJ.get(i));
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
    public void JU() {
        int i = this.bdL;
        while (true) {
            int i2 = i;
            if (i2 < this.bdJ.size() && this.bdI.size() < this.bdI.maxSize()) {
                c jy = this.bUe.jy(this.bdJ.get(i2));
                if (jy == null || jy.bitmap == null || this.bdI.size() >= this.bdI.maxSize()) {
                    break;
                }
                this.bdI.put(this.bdJ.get(i2), jy);
                this.bdL = (this.bdL + 1) % this.bdJ.size();
                if (this.bdL < this.bdK) {
                    this.bdL = this.bdK + 1;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void hG(String str) {
        this.bdI.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JV() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bdK) {
                c cVar = this.bdI.get(this.bdJ.get(i2));
                if (cVar != null && cVar.beo) {
                    this.bdI.remove(this.bdJ.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void clearCache() {
        if (this.bdI != null) {
            this.bdI.evictAll();
        }
    }

    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.bdP.quit();
        clearCache();
    }

    public boolean JS() {
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
            this.bdM = 1;
            this.bdK = 0;
            this.bdL = 0;
            this.bdQ = cVar;
            if (this.bdQ.getDynamicGiftPicPathList().size() < this.bdQ.aVv.aVu.frame_count) {
                this.bdN = this.bdQ.getDynamicGiftPicPathList().size();
            } else {
                this.bdN = this.bdQ.aVv.aVu.frame_count;
            }
            this.bdJ = this.bdQ.getDynamicGiftPicPathList();
            this.bUe = new a();
            clearCache();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    public void JW() {
        this.bdM = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private a() {
        }

        public c jy(String str) {
            return j(str, b.this.bdA, b.this.mScreenHeight);
        }

        public c j(String str, int i, int i2) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = b.this.bdM;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                c cVar = new c(str);
                cVar.bitmap = decodeFile;
                cVar.ben = options.inSampleSize;
                return cVar;
            }
            return null;
        }
    }
}
