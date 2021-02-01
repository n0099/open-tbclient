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
/* loaded from: classes5.dex */
public class MobRewardVideoImpl {
    public static String activityName = null;

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f3280b;
    public static IXRewardVideoAdContainer mAdContainer;
    public static IXAdContainerContext mContext;
    public static boolean mVideoPlaying;

    /* renamed from: a  reason: collision with root package name */
    private Activity f3281a;
    private Object c;
    private Method[] d = null;

    public MobRewardVideoImpl(Activity activity) {
        this.f3281a = activity;
    }

    public void onCreate(Bundle bundle) {
        mVideoPlaying = true;
        if (mContext != null && mContext.getAdInstanceInfo() != null) {
            mContext.getAdInstanceInfo().setAdHasDisplayed(true);
        }
        a(bundle);
    }

    public void onPause() {
        a(MissionEvent.MESSAGE_PAUSE, new Object[0]);
    }

    public void onResume() {
        a(MissionEvent.MESSAGE_RESUME, new Object[0]);
    }

    public void onDestroy() {
        mVideoPlaying = false;
        a(MissionEvent.MESSAGE_DESTROY, new Object[0]);
    }

    public boolean onBackPressed() {
        return b("onBackPressed", new Object[0]);
    }

    public void onWindowFocusChanged(boolean z) {
        a("onWindowFocusChanged", Boolean.valueOf(z));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return b("onTouchEvent", motionEvent);
    }

    public void onAttachedToWindow() {
        a("onAttachedToWindow", new Object[0]);
    }

    public void onDetachedFromWindow() {
        mVideoPlaying = false;
        a("onDetachedFromWindow", new Object[0]);
    }

    public void finish() {
        a("finish", new Object[0]);
    }

    private void a(Bundle bundle) {
        DexClassLoader d = com.baidu.mobads.g.b.d();
        try {
            if (d == null) {
                f3280b = a("com.baidu.mobads.container.rewardvideo.RemoteRewardActivity");
            } else {
                f3280b = Class.forName("com.baidu.mobads.container.rewardvideo.RemoteRewardActivity", true, d);
            }
            this.d = f3280b.getDeclaredMethods();
            this.c = f3280b.getConstructor(Activity.class, IXAdContainerContext.class, IXRewardVideoAdContainer.class).newInstance(this.f3281a, mContext, mAdContainer);
        } catch (Exception e) {
        }
        a(MissionEvent.MESSAGE_CREATE, bundle);
    }

    private Class<?> a(String str) {
        Class<?> cls = null;
        com.baidu.mobads.utils.q a2 = com.baidu.mobads.utils.q.a();
        try {
            cls = Class.forName(str, true, new DexClassLoader(com.baidu.mobads.g.g.a(this.f3281a), this.f3281a.getFilesDir().getAbsolutePath(), null, getClass().getClassLoader()));
        } catch (Exception e) {
            a2.e(e);
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
                if (objArr == null || objArr.length == 0) {
                    b2.invoke(this.c, new Object[0]);
                } else {
                    b2.invoke(this.c, objArr);
                }
            }
        } catch (Exception e) {
            com.baidu.mobads.utils.q.a().d(e);
        }
    }

    private Method b(String str) {
        Method[] methodArr;
        if (this.d == null) {
            return null;
        }
        for (Method method : this.d) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
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
                if (objArr == null || objArr.length == 0) {
                    return ((Boolean) b2.invoke(this.c, new Object[0])).booleanValue();
                }
                return ((Boolean) b2.invoke(this.c, objArr)).booleanValue();
            }
        } catch (Exception e) {
            com.baidu.mobads.utils.q.a().d(e);
        }
        return false;
    }

    public static Class<?> getActivityClass() {
        if (TextUtils.isEmpty(activityName)) {
            return MobRewardVideoActivity.class;
        }
        try {
            return Class.forName(activityName);
        } catch (Exception e) {
            com.baidu.mobads.utils.q.a().e(e);
            return MobRewardVideoActivity.class;
        }
    }

    public static void setActivityName(String str) {
        activityName = str;
    }
}
