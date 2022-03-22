package com.baidu.searchbox.v8engine;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.smallgame.sdk.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
@NotProguard
/* loaded from: classes4.dex */
public abstract class JsReleaser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "JsReleaser";
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicLong mNativeObject;
    public final long mOwnedNativeEngine;
    public final long mOwnedThreadId;

    public JsReleaser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNativeObject = new AtomicLong(0L);
        this.mOwnedThreadId = 0L;
        this.mOwnedNativeEngine = 0L;
    }

    public static void safeRelease(long j, long j2, long j3, boolean z, String str) {
        V8Engine v8Engine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), str}) == null) || (v8Engine = V8Engine.getInstance(j)) == null) {
            return;
        }
        v8Engine.runOnJSThread(new Runnable(j3, j2, z, str, j) { // from class: com.baidu.searchbox.v8engine.JsReleaser.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$className;
            public final /* synthetic */ boolean val$finalized;
            public final /* synthetic */ long val$nativeObject;
            public final /* synthetic */ long val$ownedNativeEngine;
            public final /* synthetic */ long val$ownedThreadId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Long.valueOf(j3), Long.valueOf(j2), Boolean.valueOf(z), str, Long.valueOf(j)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$nativeObject = j3;
                this.val$ownedThreadId = j2;
                this.val$finalized = z;
                this.val$className = str;
                this.val$ownedNativeEngine = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.val$nativeObject == 0) {
                    return;
                }
                long id = Thread.currentThread().getId();
                boolean z2 = this.val$ownedThreadId == id;
                if (!z2) {
                    Log.w(JsReleaser.TAG, "[JsReleaser][ERROR] Incorrect thread ID, current ID = " + id + ", expect ID = " + this.val$ownedThreadId + ", finalize=" + this.val$finalized);
                    return;
                }
                V8Engine.nativeDeleteJsReleaser(this.val$ownedNativeEngine, this.val$nativeObject, z2);
            }
        });
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                long andSet = this.mNativeObject.getAndSet(0L);
                if (andSet != 0) {
                    safeRelease(this.mOwnedNativeEngine, this.mOwnedThreadId, andSet, true, getClass().getName());
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public long nativePtr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mNativeObject.get() : invokeV.longValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long andSet = this.mNativeObject.getAndSet(0L);
            if (andSet != 0) {
                safeRelease(this.mOwnedNativeEngine, this.mOwnedThreadId, andSet, false, getClass().getName());
            }
        }
    }

    public JsReleaser(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        AtomicLong atomicLong = new AtomicLong(0L);
        this.mNativeObject = atomicLong;
        atomicLong.set(j);
        this.mOwnedThreadId = j3;
        this.mOwnedNativeEngine = j2;
    }
}
