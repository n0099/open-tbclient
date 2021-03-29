package com.baidu.mobads;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXRewardVideoAdContainer;
import com.baidu.mobads.production.rewardvideo.MobRewardVideoActivity;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class MobRewardVideoImpl {
    public static String activityName;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f8142b;
    public static IXRewardVideoAdContainer mAdContainer;
    public static IXAdContainerContext mContext;
    public static boolean mVideoPlaying;

    /* renamed from: a  reason: collision with root package name */
    public Activity f8143a;

    /* renamed from: c  reason: collision with root package name */
    public Object f8144c;

    /* renamed from: d  reason: collision with root package name */
    public Method[] f8145d = null;

    public MobRewardVideoImpl(Activity activity) {
        this.f8143a = activity;
    }

    private void a(Bundle bundle) {
        DexClassLoader d2 = com.baidu.mobads.g.b.d();
        try {
            if (d2 == null) {
                f8142b = a("com.baidu.mobads.container.rewardvideo.RemoteRewardActivity");
            } else {
                f8142b = Class.forName("com.baidu.mobads.container.rewardvideo.RemoteRewardActivity", true, d2);
            }
            this.f8145d = f8142b.getDeclaredMethods();
            this.f8144c = f8142b.getConstructor(Activity.class, IXAdContainerContext.class, IXRewardVideoAdContainer.class).newInstance(this.f8143a, mContext, mAdContainer);
        } catch (Exception unused) {
        }
        a(MissionEvent.MESSAGE_CREATE, bundle);
    }

    private Method b(String str) {
        Method[] methodArr = this.f8145d;
        if (methodArr == null) {
            return null;
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    public static Class<?> getActivityClass() {
        if (TextUtils.isEmpty(activityName)) {
            return MobRewardVideoActivity.class;
        }
        try {
            return Class.forName(activityName);
        } catch (Exception e2) {
            com.baidu.mobads.utils.q.a().e(e2);
            return MobRewardVideoActivity.class;
        }
    }

    public static void setActivityName(String str) {
        activityName = str;
    }

    public void finish() {
        a("finish", new Object[0]);
    }

    public void onAttachedToWindow() {
        a("onAttachedToWindow", new Object[0]);
    }

    public boolean onBackPressed() {
        return b("onBackPressed", new Object[0]);
    }

    public void onCreate(Bundle bundle) {
        mVideoPlaying = true;
        IXAdContainerContext iXAdContainerContext = mContext;
        if (iXAdContainerContext != null && iXAdContainerContext.getAdInstanceInfo() != null) {
            mContext.getAdInstanceInfo().setAdHasDisplayed(true);
        }
        a(bundle);
    }

    public void onDestroy() {
        mVideoPlaying = false;
        a(MissionEvent.MESSAGE_DESTROY, new Object[0]);
    }

    public void onDetachedFromWindow() {
        mVideoPlaying = false;
        a("onDetachedFromWindow", new Object[0]);
    }

    public void onPause() {
        a(MissionEvent.MESSAGE_PAUSE, new Object[0]);
    }

    public void onResume() {
        a(MissionEvent.MESSAGE_RESUME, new Object[0]);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return b("onTouchEvent", motionEvent);
    }

    public void onWindowFocusChanged(boolean z) {
        a("onWindowFocusChanged", Boolean.valueOf(z));
    }

    private boolean b(String str, Object... objArr) {
        try {
            com.baidu.mobads.utils.q a2 = com.baidu.mobads.utils.q.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a2.d(objArr2);
            Method b2 = b(str);
            if (b2 != null) {
                if (objArr != null && objArr.length != 0) {
                    return ((Boolean) b2.invoke(this.f8144c, objArr)).booleanValue();
                }
                return ((Boolean) b2.invoke(this.f8144c, new Object[0])).booleanValue();
            }
        } catch (Exception e2) {
            com.baidu.mobads.utils.q.a().d(e2);
        }
        return false;
    }

    private Class<?> a(String str) {
        com.baidu.mobads.utils.q a2 = com.baidu.mobads.utils.q.a();
        Class<?> cls = null;
        try {
            cls = Class.forName(str, true, new DexClassLoader(com.baidu.mobads.g.g.a(this.f8143a), this.f8143a.getFilesDir().getAbsolutePath(), null, MobRewardVideoImpl.class.getClassLoader()));
        } catch (Exception e2) {
            a2.e(e2);
        }
        a2.i("jar.path=, clz=" + cls);
        return cls;
    }

    private void a(String str, Object... objArr) {
        try {
            com.baidu.mobads.utils.q a2 = com.baidu.mobads.utils.q.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a2.d(objArr2);
            Method b2 = b(str);
            if (b2 != null) {
                if (objArr != null && objArr.length != 0) {
                    b2.invoke(this.f8144c, objArr);
                    return;
                }
                b2.invoke(this.f8144c, new Object[0]);
            }
        } catch (Exception e2) {
            com.baidu.mobads.utils.q.a().d(e2);
        }
    }
}
