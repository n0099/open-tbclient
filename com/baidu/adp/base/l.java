package com.baidu.adp.base;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class l {
    private static l nw = null;
    private Resources nx = null;
    private ArrayList<String> ny = null;

    public static l dJ() {
        if (nw == null) {
            synchronized (l.class) {
                if (nw == null) {
                    nw = new l();
                }
            }
        }
        return nw;
    }

    public synchronized void a(Resources resources) {
        this.nx = resources;
    }

    public synchronized void D(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.nx == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (this.ny == null) {
            this.ny = new ArrayList<>();
        }
        if (!this.ny.contains(str)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.g.a(this.nx.getAssets(), "addAssetPath", new Object[]{str});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.ny.size() > 0) {
                    Iterator<String> it = this.ny.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.g.a(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.g.a(assetManager, "addAssetPath", new Object[]{str});
                com.baidu.adp.plugin.util.g.a(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.nx = new Resources(assetManager, this.nx.getDisplayMetrics(), this.nx.getConfiguration());
            }
            this.ny.add(str);
        }
    }

    public synchronized Resources getResources() {
        return this.nx;
    }
}
