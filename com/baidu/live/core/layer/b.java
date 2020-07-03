package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    private static b awu;
    private ViewGroup awv;
    private LinkedHashMap<String, SoftReference<a>> aww;

    private b() {
    }

    public static b wk() {
        if (awu == null) {
            synchronized (b.class) {
                if (awu == null) {
                    awu = new b();
                }
            }
        }
        return awu;
    }

    public void k(ViewGroup viewGroup) {
        this.awv = viewGroup;
    }

    public void a(String str, a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, a aVar, boolean z) {
        a aVar2;
        View rootView;
        if (this.awv != null) {
            if (this.aww == null) {
                this.aww = new LinkedHashMap<>();
            }
            if (this.aww.containsKey(str)) {
                if (z) {
                    SoftReference<a> remove = this.aww.remove(str);
                    if (remove != null && (aVar2 = remove.get()) != null && (rootView = aVar2.getRootView()) != null && this.awv.indexOfChild(rootView) != -1) {
                        this.awv.removeView(rootView);
                    }
                } else {
                    return;
                }
            }
            this.aww.put(str, new SoftReference<>(aVar));
            View rootView2 = aVar.getRootView();
            if (this.awv.indexOfChild(rootView2) != -1) {
                this.awv.removeView(rootView2);
            }
            if (aVar.wj() != null) {
                this.awv.addView(rootView2, aVar.wj());
            } else {
                this.awv.addView(rootView2);
            }
        }
    }

    public a et(String str) {
        if (this.awv == null || this.aww == null) {
            return null;
        }
        if (this.aww.containsKey(str)) {
            SoftReference<a> remove = this.aww.remove(str);
            if (remove == null || remove.get() == null) {
                return null;
            }
            a aVar = remove.get();
            View rootView = aVar.getRootView();
            if (aVar.getRootView() == null) {
                return null;
            }
            if (this.awv.indexOfChild(rootView) != -1) {
                this.awv.removeView(rootView);
                return aVar;
            }
            return aVar;
        }
        return null;
    }

    public a wl() {
        if (this.awv == null || this.aww == null) {
            return null;
        }
        Iterator<Map.Entry<String, SoftReference<a>>> it = this.aww.entrySet().iterator();
        if (it.hasNext()) {
            SoftReference<a> remove = this.aww.remove(it.next().getKey());
            if (remove == null) {
                return null;
            }
            return remove.get();
        }
        return null;
    }

    public void wm() {
        if (this.aww != null) {
            if (!this.aww.isEmpty()) {
                for (Map.Entry<String, SoftReference<a>> entry : this.aww.entrySet()) {
                    SoftReference<a> value = entry.getValue();
                    if (value != null && value.get() != null) {
                        value.get().release();
                    }
                }
            }
            this.aww.clear();
            this.aww = null;
        }
        if (this.awv != null) {
            this.awv.removeAllViews();
            this.awv = null;
        }
    }

    public boolean onBackPressed() {
        if (this.aww != null && this.aww.size() > 0) {
            a wl = wl();
            if (wl == null || wl.getRootView() == null) {
                return false;
            }
            View rootView = wl.getRootView();
            if (this.awv.indexOfChild(rootView) != -1) {
                this.awv.removeView(rootView);
            }
            wl.release();
            return true;
        } else if (this.awv == null || this.awv.getChildCount() <= 0) {
            return false;
        } else {
            int childCount = this.awv.getChildCount() - 1;
            if (childCount >= 0) {
                this.awv.removeViewAt(childCount);
                return true;
            }
            return true;
        }
    }

    public void onDestroy() {
        wm();
    }
}
