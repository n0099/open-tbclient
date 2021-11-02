package com.baidu.ar.arplay.core.engine;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class ARPContent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> mCaseLoadListenerList;
    public c mCaseState;
    public volatile boolean mIsEngineCreated;
    public boolean mIsFrontCamera;
    public volatile boolean mIsTempleteCreated;
    public volatile boolean mIsTempleteCreating;
    public volatile boolean mIsTempleteDestoring;
    public volatile boolean mIsTempleteDestoryed;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public long mStartTime;
    public int mWindowHeight;
    public int mWindowWidth;

    /* renamed from: com.baidu.ar.arplay.core.engine.ARPContent$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] eh;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1067535069, "Lcom/baidu/ar/arplay/core/engine/ARPContent$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1067535069, "Lcom/baidu/ar/arplay/core/engine/ARPContent$1;");
                    return;
                }
            }
            int[] iArr = new int[b.values().length];
            eh = iArr;
            try {
                iArr[b.ei.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eh[b.ej.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                eh[b.ek.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                eh[b.el.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface a {
        void onCaseLoaded(boolean z);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b ei;
        public static final b ej;
        public static final b ek;
        public static final b el;
        public static final /* synthetic */ b[] em;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1067536588, "Lcom/baidu/ar/arplay/core/engine/ARPContent$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1067536588, "Lcom/baidu/ar/arplay/core/engine/ARPContent$b;");
                    return;
                }
            }
            ei = new b("LoadCase", 0);
            ej = new b("UnloadCase", 1);
            ek = new b("OnCaseLoaded", 2);
            b bVar = new b("OnCaseUnloaded", 3);
            el = bVar;
            em = new b[]{ei, ej, ek, bVar};
        }

        public b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static b valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (b) Enum.valueOf(b.class, str) : (b) invokeL.objValue;
        }

        public static b[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (b[]) em.clone() : (b[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final c en;
        public static final c eo;
        public static final c ep;
        public static final c eq;
        public static final /* synthetic */ c[] er;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1067536619, "Lcom/baidu/ar/arplay/core/engine/ARPContent$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1067536619, "Lcom/baidu/ar/arplay/core/engine/ARPContent$c;");
                    return;
                }
            }
            en = new c("EUninit", 0);
            eo = new c("ECreating", 1);
            ep = new c("ECreated", 2);
            c cVar = new c("EDestroying", 3);
            eq = cVar;
            er = new c[]{en, eo, ep, cVar};
        }

        public c(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static c valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (c) Enum.valueOf(c.class, str) : (c) invokeL.objValue;
        }

        public static c[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (c[]) er.clone() : (c[]) invokeV.objValue;
        }
    }

    public ARPContent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCaseState = c.en;
        this.mIsEngineCreated = false;
        this.mIsTempleteCreating = false;
        this.mIsTempleteCreated = false;
        this.mIsTempleteDestoring = true;
        this.mIsTempleteDestoryed = false;
        this.mStartTime = 0L;
        this.mIsFrontCamera = true;
        this.mPreviewWidth = 0;
        this.mPreviewHeight = 0;
        this.mWindowWidth = 720;
        this.mWindowHeight = 1280;
        this.mCaseLoadListenerList = new ArrayList();
    }

    private void releaseComponents() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            com.baidu.ar.arplay.a.a.aA().aB();
            com.baidu.ar.arplay.a.e.aL().release();
            com.baidu.ar.arplay.d.b.bm().release();
            ARPScriptEnvironment.getInstance().release();
        }
    }

    public boolean checkValid(b bVar) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            int i2 = AnonymousClass1.eh[bVar.ordinal()];
            if (i2 != 2) {
                if (i2 == 3 && (!this.mIsEngineCreated || this.mCaseState != c.eo)) {
                    return false;
                }
            } else if (!this.mIsEngineCreated || (cVar = this.mCaseState) == c.eq || cVar == c.en) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void clearAllCaseLoadListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mCaseLoadListenerList.clear();
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mCaseState = c.en;
            notifyCaseLoadListener();
            clearAllCaseLoadListener();
            this.mIsEngineCreated = false;
            this.mIsTempleteCreating = false;
            this.mIsTempleteCreated = false;
            this.mIsTempleteDestoring = false;
            this.mIsTempleteDestoryed = false;
            releaseComponents();
        }
    }

    public float[] getWindowSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new float[]{this.mWindowWidth, this.mWindowHeight} : (float[]) invokeV.objValue;
    }

    public boolean isCaseCreated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCaseState == c.ep : invokeV.booleanValue;
    }

    public boolean isEngineCanAccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mIsEngineCreated && this.mCaseState == c.ep : invokeV.booleanValue;
    }

    public int loadCaseWithResPath(String str, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, str, i2, i3)) == null) {
            if (this.mIsEngineCreated) {
                c cVar = this.mCaseState;
                c cVar2 = c.eo;
                if (cVar == cVar2) {
                    return -1;
                }
                this.mCaseState = cVar2;
                notifyCaseLoadListener();
                ARPScriptEnvironment.getInstance().setDataPipKV(ARPScriptEnvironment.KEY_DATA_CAMERA_POSITION, Integer.valueOf(this.mIsFrontCamera ? 1 : 0));
                this.mStartTime = System.currentTimeMillis();
                int i5 = this.mPreviewWidth;
                if (i5 > 0) {
                    i2 = i5;
                }
                this.mPreviewWidth = i2;
                int i6 = this.mPreviewHeight;
                if (i6 > 0) {
                    i3 = i6;
                }
                this.mPreviewHeight = i3;
                int i7 = this.mWindowWidth;
                if (i7 > 0 && (i4 = this.mWindowHeight) > 0) {
                    nativeSetWindowSize(i7, i4);
                }
                nativeLoadCase(str, this.mPreviewWidth, this.mPreviewHeight);
                return 0;
            }
            return -1;
        }
        return invokeLII.intValue;
    }

    public void loadTempleteWithResPath(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048583, this, str, i2, i3) == null) || this.mIsTempleteCreating) {
            return;
        }
        if (!this.mIsTempleteDestoring) {
            unloadTemplete();
        }
        this.mIsTempleteCreating = true;
        this.mIsTempleteDestoring = false;
        this.mIsTempleteDestoryed = false;
        this.mIsTempleteCreated = false;
        ARPScriptEnvironment.getInstance().setDataPipKV(ARPScriptEnvironment.KEY_DATA_CAMERA_POSITION, Integer.valueOf(this.mIsFrontCamera ? 1 : 0));
        this.mStartTime = System.currentTimeMillis();
        nativeLoadTemplete(str, i2, i3);
    }

    public native void nativeLoadCase(String str, int i2, int i3);

    public native void nativeLoadTemplete(String str, int i2, int i3);

    public native void nativeSetPreviewSize(int i2, int i3);

    public native void nativeSetWindowSize(int i2, int i3);

    public native void nativeUnloadCase();

    public native void nativeUnloadTemplete();

    public void notifyCaseLoadListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (int i2 = 0; i2 < this.mCaseLoadListenerList.size(); i2++) {
                this.mCaseLoadListenerList.get(i2).onCaseLoaded(isCaseCreated());
            }
        }
    }

    public void onCaseLoadCompleted(Map map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, map) == null) && this.mIsEngineCreated && this.mCaseState == c.eo && map != null) {
            int a2 = com.baidu.ar.arplay.c.c.a(map.get("case_id"), 0);
            com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "caseId : " + a2);
            com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "caseId : " + a2 + " cost: " + (System.currentTimeMillis() - this.mStartTime));
            this.mCaseState = c.ep;
            notifyCaseLoadListener();
        }
    }

    public void onCaseUnloadCompleted() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.mIsEngineCreated && this.mCaseState == c.eq) {
            this.mCaseState = c.en;
        }
    }

    public void onTempleLoadCompleted(Map map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, map) == null) || map == null) {
            return;
        }
        int a2 = com.baidu.ar.arplay.c.c.a(map.get("case_id"), 0);
        com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "caseId : " + a2);
        com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "onTempleLoadCompleted : " + a2 + " cost: " + (System.currentTimeMillis() - this.mStartTime));
        this.mIsTempleteCreated = true;
        this.mIsTempleteCreating = false;
    }

    public void registerCaseLoadListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.mCaseLoadListenerList.add(aVar);
        }
    }

    public void setEngineCreated(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mIsEngineCreated = z;
        }
    }

    public void setIsFrontCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mIsFrontCamera = z;
        }
    }

    public void setPreviewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i2, i3) == null) {
            this.mPreviewWidth = i2;
            this.mPreviewHeight = i3;
            if (isEngineCanAccess()) {
                nativeSetPreviewSize(i2, i3);
            }
        }
    }

    public void setWindowSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) {
            this.mWindowWidth = i2;
            this.mWindowHeight = i3;
            if (isEngineCanAccess()) {
                nativeSetWindowSize(i2, i3);
            }
        }
    }

    public void unloadCase() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || !this.mIsEngineCreated || (cVar = this.mCaseState) == c.eq || cVar == c.en) {
            return;
        }
        com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "unloadCase");
        this.mCaseState = c.eq;
        notifyCaseLoadListener();
        this.mPreviewWidth = 0;
        this.mPreviewHeight = 0;
        nativeUnloadCase();
        releaseComponents();
        com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "unloadCase finished");
    }

    public void unloadTemplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "unloadTemplete");
            this.mIsTempleteDestoring = true;
            this.mIsTempleteCreated = false;
            nativeUnloadTemplete();
            com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "unloadTemplete finished");
            this.mIsTempleteDestoryed = true;
        }
    }

    public void unregisterCaseLoadListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, aVar) == null) {
            this.mCaseLoadListenerList.remove(aVar);
        }
    }
}
