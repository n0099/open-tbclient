package com.baidu.sofire.face.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.sofire.face.api.FaceProcessCallback;
import com.baidu.sofire.face.api.IVideoRecordProcess;
import com.baidu.sofire.face.api.RecordCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static e c = null;
    public static String d = null;
    public static int e = -1;
    public static int f = -1;
    public static boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public j a;
    public IVideoRecordProcess b;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceProcessCallback a;
        public final /* synthetic */ int b;

        public a(e eVar, FaceProcessCallback faceProcessCallback, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, faceProcessCallback, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceProcessCallback;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onEnd(this.b, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordCallback a;
        public final /* synthetic */ int b;

        public b(e eVar, RecordCallback recordCallback, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, recordCallback, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordCallback;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onEnd(this.b, null);
            }
        }
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (e.class) {
                if (context == null) {
                    return c;
                }
                if (c == null) {
                    c = new e(context);
                }
                return c;
            }
        }
        return (e) invokeL.objValue;
    }

    public static synchronized boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (e.class) {
                if (!g) {
                    g = FaceSDKManager.getInstance().getInitFlag();
                }
                z = g;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void a(Activity activity, FaceProcessCallback faceProcessCallback, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, activity, faceProcessCallback, i) == null) && faceProcessCallback != null) {
            activity.runOnUiThread(new a(this, faceProcessCallback, i));
        }
    }

    public final void a(Activity activity, RecordCallback recordCallback, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, recordCallback, i) == null) && recordCallback != null) {
            activity.runOnUiThread(new b(this, recordCallback, i));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x006e, code lost:
        if (r3.length > r0.length) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a() {
        InterceptResult invokeV;
        int i;
        String[] split;
        String[] split2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                if (e == -1) {
                    Class.forName("com.baidu.pass.face.platform.FaceSDKManager");
                    e = 1;
                }
                if (e != 1) {
                    return false;
                }
                if (f == -1) {
                    if ("4.1.1".equals(FaceSDKManager.getSecDecouplingVersion())) {
                        f = 1;
                    } else {
                        String secDecouplingVersion = FaceSDKManager.getSecDecouplingVersion();
                        if (!TextUtils.isEmpty(secDecouplingVersion) && !TextUtils.isEmpty("4.1.1")) {
                            try {
                                split = secDecouplingVersion.split("\\.");
                                split2 = "4.1.1".split("\\.");
                            } catch (Throwable unused) {
                            }
                            for (i2 = 0; i2 < split.length && i2 < split2.length; i2++) {
                                int intValue = Integer.valueOf(split[i2]).intValue() - Integer.valueOf(split2[i2]).intValue();
                                if (intValue != 0) {
                                    if (intValue > 0) {
                                        i = 1;
                                        f = i;
                                    }
                                }
                            }
                        }
                        i = 0;
                        f = i;
                    }
                }
                if (f != 1) {
                    return false;
                }
                return true;
            } catch (Throwable unused2) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
