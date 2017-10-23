package com.baidu.adp.base;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> mJ;
    private static a mK;
    private InterfaceC0000a mL;
    private int mM = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0000a {
        void onActivityClosed();
    }

    public void a(InterfaceC0000a interfaceC0000a) {
        this.mL = interfaceC0000a;
    }

    private a() {
        if (mJ == null) {
            mJ = new ArrayList<>(20);
        }
    }

    public static a ca() {
        if (mK == null) {
            mK = new a();
        }
        return mK;
    }

    public int getSize() {
        return mJ.size();
    }

    public void h(Activity activity) {
        if (activity != null) {
            mJ.add(new SoftReference<>(activity));
            E(this.mM);
        }
    }

    public Activity D(int i) {
        int size = mJ.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = mJ.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void i(Activity activity) {
        if (activity != null) {
            int size = mJ.size();
            if (size == 0) {
                if (this.mL != null) {
                    this.mL.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = mJ.get(i);
                if (softReference == null) {
                    mJ.remove(i);
                } else if (activity.equals(softReference.get())) {
                    mJ.remove(i);
                    if (mJ.size() == 0 && this.mL != null) {
                        this.mL.onActivityClosed();
                        return;
                    }
                    return;
                } else if (mJ.size() == 0 && this.mL != null) {
                    this.mL.onActivityClosed();
                }
            }
        }
    }

    public Activity cb() {
        SoftReference<Activity> softReference;
        int size = mJ.size();
        if (size != 0 && (softReference = mJ.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.mM = i;
        }
    }

    public void cc() {
        E(3);
    }

    public void cd() {
        Activity activity;
        if (mJ != null) {
            while (!mJ.isEmpty()) {
                SoftReference<Activity> remove = mJ.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.mL != null) {
            this.mL.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.mM;
    }

    private void E(int i) {
        if (i != 0) {
            int size = ca().getSize();
            while (size > i) {
                size--;
                Activity D = ca().D(1);
                if (D != null) {
                    D.finish();
                }
            }
        }
    }

    public String ce() {
        Activity activity;
        String str;
        if (mJ == null || mJ.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SoftReference<Activity>> it = mJ.iterator();
        while (it.hasNext()) {
            SoftReference<Activity> next = it.next();
            if (next != null && (activity = next.get()) != null) {
                if (activity == null || activity.getClass() == null) {
                    str = "";
                } else {
                    str = activity.getClass().getSimpleName();
                }
                if (!StringUtils.isNull(str)) {
                    sb.append(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                }
            }
        }
        return sb.toString();
    }
}
