package com.baidu.live.tieba.write.album;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class d {
    private static d bIe;
    private BroadcastReceiver bIf;
    private ContentObserver bIg;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> mListeners = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable bIh = new Runnable() { // from class: com.baidu.live.tieba.write.album.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.dg(false);
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void dh(boolean z);
    }

    public static d Te() {
        if (bIe == null) {
            synchronized (d.class) {
                if (bIe == null) {
                    bIe = new d();
                    bIe.init(TbadkCoreApplication.getInst());
                }
            }
        }
        return bIe;
    }

    private d() {
    }

    private void init(Context context) {
        this.bIf = new BroadcastReceiver() { // from class: com.baidu.live.tieba.write.album.d.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                d.this.p(intent);
            }
        };
        this.bIg = new ContentObserver(this.mHandler) { // from class: com.baidu.live.tieba.write.album.d.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                d.this.handler.removeCallbacks(d.this.bIh);
                d.this.handler.postDelayed(d.this.bIh, 2000L);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.bIf, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.bIg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            dg(true);
            return;
        }
        this.handler.removeCallbacks(this.bIh);
        this.handler.postDelayed(this.bIh, 2000L);
    }

    public void dg(boolean z) {
        Iterator<a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().dh(z);
        }
    }

    public void a(a aVar) {
        if (aVar != null && !this.mListeners.contains(aVar)) {
            this.mListeners.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.mListeners.contains(aVar)) {
            this.mListeners.remove(aVar);
        }
    }

    public void removeAllListeners() {
        this.mListeners.clear();
    }

    public void destory() {
        removeAllListeners();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.bIf);
        inst.getContentResolver().unregisterContentObserver(this.bIg);
        this.handler.removeCallbacks(this.bIh);
        bIe = null;
    }
}
