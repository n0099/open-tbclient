package com.baidu.ar.arplay.core.engine;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPContent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class ARPDataInteraction implements ARPContent.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.ar.arplay.a.b mDataStore;
    public a mHtmlCallback;
    public b mInteraction;
    public boolean mIsCaseCreated;
    public ByteBuffer mMaskBuffer;
    public c mVideoCallback;

    /* loaded from: classes3.dex */
    public interface a {
        boolean c(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(float f2, float f3, float f4);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(String str, int i, String str2, String str3);
    }

    public ARPDataInteraction() {
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
        this.mInteraction = null;
        this.mIsCaseCreated = false;
    }

    public static String getValue(Object obj, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, obj, i, str)) == null) {
            ARPDataInteraction aRPDataInteraction = (ARPDataInteraction) ((WeakReference) obj).get();
            return aRPDataInteraction == null ? "" : aRPDataInteraction.getValue(i, str);
        }
        return (String) invokeLIL.objValue;
    }

    public static void onInteractionFinish(Object obj, float f2, float f3, float f4) {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{obj, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) || (aRPDataInteraction = (ARPDataInteraction) ((WeakReference) obj).get()) == null) {
            return;
        }
        aRPDataInteraction.onInteractionFinish(f2, f3, f4);
    }

    public static void setValue(Object obj, int i, String str, String str2) {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65539, null, obj, i, str, str2) == null) || (aRPDataInteraction = (ARPDataInteraction) ((WeakReference) obj).get()) == null) {
            return;
        }
        aRPDataInteraction.setValue(i, str, str2);
    }

    public static void updateVideoFrame(Object obj, String str, int i, String str2, String str3) {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{obj, str, Integer.valueOf(i), str2, str3}) == null) || (aRPDataInteraction = (ARPDataInteraction) ((WeakReference) obj).get()) == null) {
            return;
        }
        aRPDataInteraction.updateVideoFrame(str, i, str2, str3);
    }

    public static boolean updateWebViewFrame(Object obj, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, obj, i, i2)) == null) {
            ARPDataInteraction aRPDataInteraction = (ARPDataInteraction) ((WeakReference) obj).get();
            if (aRPDataInteraction == null) {
                return false;
            }
            return aRPDataInteraction.updateWebViewFrame(i, i2);
        }
        return invokeLII.booleanValue;
    }

    public void addAlgoType(int[] iArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, iArr, i) == null) {
            nativeAddAlgoType(iArr, i);
        }
    }

    public void clearARMemory() {
        com.baidu.ar.arplay.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.mDataStore) == null) {
            return;
        }
        bVar.clearARMemory();
    }

    public void clearAlgoCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            nativeClearAlgoCache();
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            nativeReleaseALgoCacheInstance();
        }
    }

    public void destroyMockAlgoHandle(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            nativeDestoryMockFaceAlgoHandle(j);
        }
    }

    public String getValue(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, str)) == null) {
            com.baidu.ar.arplay.a.b bVar = this.mDataStore;
            if (bVar != null) {
                return bVar.getValue(i, str);
            }
            Log.e("ARPDataInteraction", "get value error!");
            return "";
        }
        return (String) invokeIL.objValue;
    }

    public void initDataStore(SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, sharedPreferences) == null) && this.mDataStore == null) {
            com.baidu.ar.arplay.a.b bVar = new com.baidu.ar.arplay.a.b();
            this.mDataStore = bVar;
            bVar.a(sharedPreferences);
        }
    }

    public long mockFaceAlgoHandle(long j, float[] fArr) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048583, this, j, fArr)) == null) ? nativeMockFaceAlgoHandle(j, fArr) : invokeJL.longValue;
    }

    public native void nativeAddAlgoType(int[] iArr, int i);

    public native void nativeClearAlgoCache();

    public native void nativeDestoryMockFaceAlgoHandle(long j);

    public native long nativeMockFaceAlgoHandle(long j, float[] fArr);

    public native void nativeReleaseALgoCacheInstance();

    public native void nativeRemoveAlgoType(int[] iArr);

    public native void nativeSetAlgoDataHandle(long j);

    public native void nativeSetAlgoHandle(long j);

    public native void nativeSetFaceLandMark(long j, int i);

    public native void nativeSetFaceLandMarkFrameAcheMode(int i);

    public native void nativeSetup(Object obj);

    public native void nativeUpdateAlgoDataToNode(int i, int i2, ByteBuffer byteBuffer);

    @Override // com.baidu.ar.arplay.core.engine.ARPContent.a
    public void onCaseLoaded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mIsCaseCreated = z;
        }
    }

    public void onGestureUpdate(int i, long j, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, int i4, float f10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i3), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Integer.valueOf(i4), Float.valueOf(f10)}) == null) {
            onGestureUpdateNative(i, j, i2, f2, f3, f4, f5, i3, f6, f7, f8, f9, i4, f10, false);
        }
    }

    public native void onGestureUpdateNative(int i, long j, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, int i4, float f10, boolean z);

    public void onGestureUpdateWithScaleFinish(int i, long j, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, int i4, float f10, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i3), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Integer.valueOf(i4), Float.valueOf(f10), Boolean.valueOf(z)}) == null) {
            onGestureUpdateNative(i, j, i2, f2, f3, f4, f5, i3, f6, f7, f8, f9, i4, f10, z);
        }
    }

    public void onInteractionFinish(float f2, float f3, float f4) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) || (bVar = this.mInteraction) == null) {
            return;
        }
        bVar.a(f2, f3, f4);
    }

    public void onTouchUpdate(int i, float f2, float f3, float f4, float f5, long j, int i2, float f6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Long.valueOf(j), Integer.valueOf(i2), Float.valueOf(f6)}) == null) {
            onTouchUpdateNative(i, f2, f3, f4, f5, j, i2, f6);
        }
    }

    public native void onTouchUpdateNative(int i, float f2, float f3, float f4, float f5, long j, int i2, float f6);

    public void removeAlgoType(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, iArr) == null) {
            nativeRemoveAlgoType(iArr);
        }
    }

    public synchronized void setAlgoDataHandle(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            synchronized (this) {
                nativeSetAlgoHandle(j);
            }
        }
    }

    public void setFaceLandMarkFrameAcheMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            nativeSetFaceLandMarkFrameAcheMode(i);
        }
    }

    public synchronized void setHtmlUpdateCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, aVar) == null) {
            synchronized (this) {
                this.mHtmlCallback = aVar;
            }
        }
    }

    public void setInteraction(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bVar) == null) {
            this.mInteraction = bVar;
        }
    }

    public void setValue(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048608, this, i, str, str2) == null) {
            com.baidu.ar.arplay.a.b bVar = this.mDataStore;
            if (bVar != null) {
                bVar.setValue(i, str, str2);
            } else {
                Log.e("ARPDataInteraction", "set value error!");
            }
        }
    }

    public synchronized void setVideoUpdateCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, cVar) == null) {
            synchronized (this) {
                this.mVideoCallback = cVar;
            }
        }
    }

    public void setup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            nativeSetup(new WeakReference(this));
        }
    }

    public void updateAlgoDataToNode(int i, int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048611, this, i, i2, bArr) == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
            this.mMaskBuffer = allocateDirect;
            allocateDirect.put(bArr);
            nativeUpdateAlgoDataToNode(i, i2, this.mMaskBuffer);
        }
    }

    public void updateVideoFrame(String str, int i, String str2, String str3) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048612, this, str, i, str2, str3) == null) && (cVar = this.mVideoCallback) != null && this.mIsCaseCreated) {
            cVar.a(str, i, str2, str3);
        }
    }

    public boolean updateWebViewFrame(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048613, this, i, i2)) == null) {
            a aVar = this.mHtmlCallback;
            if (aVar == null || !this.mIsCaseCreated) {
                return false;
            }
            return aVar.c(i, i2);
        }
        return invokeII.booleanValue;
    }
}
