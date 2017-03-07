package com.baidu.adp.base;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> nQ;
    private static a nR;
    private InterfaceC0001a nS;
    private int nT = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0001a {
        void onActivityClosed();
    }

    public void a(InterfaceC0001a interfaceC0001a) {
        this.nS = interfaceC0001a;
    }

    private a() {
        if (nQ == null) {
            nQ = new ArrayList<>(20);
        }
    }

    public static a cb() {
        if (nR == null) {
            nR = new a();
        }
        return nR;
    }

    public int getSize() {
        return nQ.size();
    }

    public void h(Activity activity) {
        if (activity != null) {
            nQ.add(new SoftReference<>(activity));
            G(this.nT);
        }
    }

    public Activity F(int i) {
        int size = nQ.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = nQ.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void i(Activity activity) {
        if (activity != null) {
            int size = nQ.size();
            if (size == 0) {
                if (this.nS != null) {
                    this.nS.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = nQ.get(i);
                if (softReference == null) {
                    nQ.remove(i);
                } else if (activity.equals(softReference.get())) {
                    nQ.remove(i);
                    if (nQ.size() == 0 && this.nS != null) {
                        this.nS.onActivityClosed();
                        return;
                    }
                    return;
                } else if (nQ.size() == 0 && this.nS != null) {
                    this.nS.onActivityClosed();
                }
            }
        }
    }

    public Activity cc() {
        SoftReference<Activity> softReference;
        int size = nQ.size();
        if (size != 0 && (softReference = nQ.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.nT = i;
        }
    }

    public void cd() {
        G(3);
    }

    public void ce() {
        Activity activity;
        if (nQ != null) {
            while (!nQ.isEmpty()) {
                SoftReference<Activity> remove = nQ.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.nS != null) {
            this.nS.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.nT;
    }

    private void G(int i) {
        if (i != 0) {
            int size = cb().getSize();
            while (size > i) {
                size--;
                Activity F = cb().F(1);
                if (F != null) {
                    F.finish();
                }
            }
        }
    }

    public String cf() {
        Activity activity;
        String str;
        if (nQ == null || nQ.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SoftReference<Activity>> it = nQ.iterator();
        while (it.hasNext()) {
            SoftReference<Activity> next = it.next();
            if (next != null && (activity = next.get()) != null) {
                if (activity == null || activity.getClass() == null) {
                    str = "";
                } else {
                    str = activity.getClass().getSimpleName();
                }
                if (!StringUtils.isNull(str)) {
                    sb.append(String.valueOf(str) + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                }
            }
        }
        return sb.toString();
    }
}
