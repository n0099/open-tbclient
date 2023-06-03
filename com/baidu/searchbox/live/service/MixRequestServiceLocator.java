package com.baidu.searchbox.live.service;

import androidx.collection.SimpleArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.live.arch.api.IService;
import com.baidu.nps.main.manager.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0003:\u0001\u0003B\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/live/service/MixRequestServiceLocator;", "<init>", "()V", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class MixRequestServiceLocator {
    public static final Companion Companion = new Companion(null);
    public static final SimpleArrayMap<Class<? extends IService>, IService> globalServices = new SimpleArrayMap<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u00020\b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fR*\u0010\u000e\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\u0012\u0004\u0012\u00020\u00010\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/service/MixRequestServiceLocator$Companion;", "Lcom/baidu/live/arch/api/IService;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "getGlobalService", "(Ljava/lang/Class;)Lcom/baidu/live/arch/api/IService;", "service", "", "registerGlobalServices", "(Ljava/lang/Class;Lcom/baidu/live/arch/api/IService;)V", "unregisterGlobalService", "(Ljava/lang/Class;)V", "Landroidx/collection/SimpleArrayMap;", "globalServices", "Landroidx/collection/SimpleArrayMap;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T extends IService> T getGlobalService(Class<T> cls) {
            Object obj = MixRequestServiceLocator.globalServices.get(cls);
            if (!(obj instanceof IService)) {
                obj = null;
            }
            return (T) obj;
        }

        public final void unregisterGlobalService(Class<? extends IService> cls) {
            MixRequestServiceLocator.globalServices.remove(cls);
        }

        public final void registerGlobalServices(Class<? extends IService> cls, IService iService) {
            MixRequestServiceLocator.globalServices.put(cls, iService);
        }
    }
}
