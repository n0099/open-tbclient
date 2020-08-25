package android.arch.lifecycle;

import android.app.Application;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes7.dex */
public class x {
    private final z mViewModelStore;
    private final b zI;

    /* loaded from: classes7.dex */
    public interface b {
        @NonNull
        <T extends w> T create(@NonNull Class<T> cls);
    }

    public x(@NonNull z zVar, @NonNull b bVar) {
        this.zI = bVar;
        this.mViewModelStore = zVar;
    }

    @NonNull
    @MainThread
    public <T extends w> T l(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) b("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    @NonNull
    @MainThread
    public <T extends w> T b(@NonNull String str, @NonNull Class<T> cls) {
        T t = (T) this.mViewModelStore.aX(str);
        if (!cls.isInstance(t)) {
            if (t != null) {
            }
            T t2 = (T) this.zI.create(cls);
            this.mViewModelStore.a(str, t2);
            return t2;
        }
        return t;
    }

    /* loaded from: classes7.dex */
    public static class c implements b {
        @Override // android.arch.lifecycle.x.b
        @NonNull
        public <T extends w> T create(@NonNull Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends c {
        private static a zJ;
        private Application mApplication;

        @NonNull
        public static a c(@NonNull Application application) {
            if (zJ == null) {
                zJ = new a(application);
            }
            return zJ;
        }

        public a(@NonNull Application application) {
            this.mApplication = application;
        }

        @Override // android.arch.lifecycle.x.c, android.arch.lifecycle.x.b
        @NonNull
        public <T extends w> T create(@NonNull Class<T> cls) {
            if (android.arch.lifecycle.a.class.isAssignableFrom(cls)) {
                try {
                    return cls.getConstructor(Application.class).newInstance(this.mApplication);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e2);
                } catch (NoSuchMethodException e3) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e3);
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e4);
                }
            }
            return (T) super.create(cls);
        }
    }
}
