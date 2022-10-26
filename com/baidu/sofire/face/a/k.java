package com.baidu.sofire.face.a;

import android.app.Activity;
import android.media.AudioManager;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.face.api.RecordCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class k implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ m a;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecordCallback recordCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (recordCallback = this.a.a.d) != null) {
                recordCallback.onBegin();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ k b;

        public b(k kVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecordCallback recordCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (recordCallback = this.b.a.d) != null) {
                recordCallback.onDeviceCheckResult(this.a);
            }
        }
    }

    public k(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f1 A[Catch: all -> 0x0139, TryCatch #0 {all -> 0x0139, blocks: (B:5:0x0007, B:8:0x000e, B:10:0x0029, B:12:0x002d, B:13:0x0035, B:15:0x003b, B:17:0x0045, B:19:0x004d, B:22:0x0054, B:25:0x0061, B:27:0x0067, B:42:0x00c4, B:53:0x00dc, B:55:0x00e2, B:57:0x00e6, B:60:0x00f1, B:63:0x00f9, B:65:0x00ff, B:68:0x0106, B:71:0x0135, B:48:0x00d0, B:28:0x007f, B:30:0x0089, B:32:0x008f, B:34:0x00a9, B:36:0x00b3), top: B:79:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f7  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        m mVar;
        int i;
        Pair callSync;
        char c;
        m mVar2;
        int i2;
        m mVar3;
        Activity activity;
        m mVar4;
        int i3;
        Activity activity2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                m mVar5 = this.a;
                if (mVar5.m) {
                    return;
                }
                mVar5.l = com.baidu.sofire.face.b.b.a("3");
                m mVar6 = this.a;
                com.baidu.sofire.face.b.b.a(mVar6.a, mVar6.l, 101, 0, null);
                m mVar7 = this.a;
                if (mVar7.d != null && (activity2 = mVar7.b) != null) {
                    activity2.runOnUiThread(new a(this));
                }
                if (!FH.isInitSuc(1) && this.a.i.a()) {
                    this.a.a(-15);
                    return;
                }
                m mVar8 = this.a;
                if (mVar8.m) {
                    return;
                }
                if (mVar8.i.b() && (i3 = (mVar4 = this.a).k) == 0) {
                    FH.call(1, "fdrv", new Class[]{String.class, Integer.TYPE}, mVar4.l, Integer.valueOf(i3));
                } else if (this.a.i.b() && (i = (mVar = this.a).k) > 0 && (callSync = FH.callSync(1, "fdrv", new Class[]{String.class, Integer.TYPE}, mVar.l, Integer.valueOf(i))) != null && ((Integer) callSync.first).intValue() == 0) {
                    int intValue = ((Integer) callSync.second).intValue();
                    if (intValue == 1) {
                        c = 1;
                    } else if (intValue == 2) {
                        c = 65534;
                    }
                    mVar2 = this.a;
                    if (!mVar2.m) {
                        return;
                    }
                    if (c != 65534) {
                        if (c == 65535 && mVar2.i.e()) {
                        }
                        i2 = 1;
                        mVar3 = this.a;
                        if (mVar3.d != null && (activity = mVar3.b) != null) {
                            activity.runOnUiThread(new b(this, i2));
                        }
                        if (c != 65534) {
                            this.a.a(-3);
                            return;
                        } else if (i2 == -1) {
                            this.a.a(-3);
                            return;
                        } else {
                            m mVar9 = this.a;
                            if (mVar9.m) {
                                return;
                            }
                            ((AudioManager) mVar9.a.getSystemService("audio")).getStreamVolume(3);
                            DisplayMetrics displayMetrics = new DisplayMetrics();
                            mVar9.b.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                            mVar9.w = displayMetrics.widthPixels;
                            mVar9.x = displayMetrics.heightPixels;
                            m mVar10 = this.a;
                            if (mVar10.m) {
                                return;
                            }
                            mVar10.a();
                            return;
                        }
                    }
                    i2 = -1;
                    mVar3 = this.a;
                    if (mVar3.d != null) {
                        activity.runOnUiThread(new b(this, i2));
                    }
                    if (c != 65534) {
                    }
                }
                c = 65535;
                mVar2 = this.a;
                if (!mVar2.m) {
                }
            } catch (Throwable th) {
                m mVar11 = this.a;
                com.baidu.sofire.face.b.b.a(mVar11.a, mVar11.l, 1, th);
                this.a.a(-9);
            }
        }
    }
}
