package com.baidu.adp.base;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> mH;
    private static a mI;
    private InterfaceC0000a mJ;
    private int mK = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0000a {
        void onActivityClosed();
    }

    public void a(InterfaceC0000a interfaceC0000a) {
        this.mJ = interfaceC0000a;
    }

    private a() {
        if (mH == null) {
            mH = new ArrayList<>(20);
        }
    }

    public static a ca() {
        if (mI == null) {
            mI = new a();
        }
        return mI;
    }

    public int getSize() {
        return mH.size();
    }

    public void h(Activity activity) {
        if (activity != null) {
            mH.add(new SoftReference<>(activity));
            E(this.mK);
        }
    }

    public Activity D(int i) {
        int size = mH.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = mH.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void i(Activity activity) {
        if (activity != null) {
            int size = mH.size();
            if (size == 0) {
                if (this.mJ != null) {
                    this.mJ.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = mH.get(i);
                if (softReference == null) {
                    mH.remove(i);
                } else if (activity.equals(softReference.get())) {
                    mH.remove(i);
                    if (mH.size() == 0 && this.mJ != null) {
                        this.mJ.onActivityClosed();
                        return;
                    }
                    return;
                } else if (mH.size() == 0 && this.mJ != null) {
                    this.mJ.onActivityClosed();
                }
            }
        }
    }

    public Activity cb() {
        SoftReference<Activity> softReference;
        int size = mH.size();
        if (size != 0 && (softReference = mH.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.mK = i;
        }
    }

    public void cc() {
        E(3);
    }

    public void cd() {
        Activity activity;
        if (mH != null) {
            while (!mH.isEmpty()) {
                SoftReference<Activity> remove = mH.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.mJ != null) {
            this.mJ.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.mK;
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
        if (mH == null || mH.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SoftReference<Activity>> it = mH.iterator();
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
