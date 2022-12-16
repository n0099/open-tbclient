package com.baidu.sofire.face.a;

import android.app.Activity;
import android.media.AudioManager;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.TextureView;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.face.api.RecordCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class o implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ q a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
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

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ o b;

        public b(o oVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oVar;
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

    public o(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = qVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f1 A[Catch: all -> 0x013c, TryCatch #1 {all -> 0x013c, blocks: (B:5:0x0007, B:8:0x000e, B:10:0x0029, B:12:0x002d, B:13:0x0035, B:15:0x003b, B:17:0x0045, B:19:0x004d, B:22:0x0054, B:25:0x0061, B:27:0x0067, B:42:0x00c4, B:53:0x00dc, B:55:0x00e2, B:57:0x00e6, B:60:0x00f1, B:63:0x00f9, B:65:0x00ff, B:68:0x0106, B:72:0x0131, B:75:0x0138, B:48:0x00d0, B:28:0x007f, B:30:0x0089, B:32:0x008f, B:34:0x00a9, B:36:0x00b3), top: B:86:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f7  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        q qVar;
        int i;
        Pair<Integer, Object> callSync;
        char c;
        q qVar2;
        int i2;
        q qVar3;
        Activity activity;
        q qVar4;
        int i3;
        Activity activity2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                q qVar5 = this.a;
                if (qVar5.m) {
                    return;
                }
                qVar5.l = com.baidu.sofire.face.b.b.a("3");
                q qVar6 = this.a;
                com.baidu.sofire.face.b.b.a(qVar6.a, qVar6.l, 101, 0, null);
                q qVar7 = this.a;
                if (qVar7.d != null && (activity2 = qVar7.b) != null) {
                    activity2.runOnUiThread(new a(this));
                }
                if (!FH.isInitSuc(1) && this.a.i.a()) {
                    this.a.a(-15);
                    return;
                }
                q qVar8 = this.a;
                if (qVar8.m) {
                    return;
                }
                if (qVar8.i.b() && (i3 = (qVar4 = this.a).k) == 0) {
                    FH.call(1, "fdrv", new Class[]{String.class, Integer.TYPE}, qVar4.l, Integer.valueOf(i3));
                } else if (this.a.i.b() && (i = (qVar = this.a).k) > 0 && (callSync = FH.callSync(1, "fdrv", new Class[]{String.class, Integer.TYPE}, qVar.l, Integer.valueOf(i))) != null && ((Integer) callSync.first).intValue() == 0) {
                    int intValue = ((Integer) callSync.second).intValue();
                    if (intValue == 1) {
                        c = 1;
                    } else if (intValue == 2) {
                        c = 65534;
                    }
                    qVar2 = this.a;
                    if (!qVar2.m) {
                        return;
                    }
                    if (c != 65534) {
                        if (c == 65535 && qVar2.i.e()) {
                        }
                        i2 = 1;
                        qVar3 = this.a;
                        if (qVar3.d != null && (activity = qVar3.b) != null) {
                            activity.runOnUiThread(new b(this, i2));
                        }
                        if (c != 65534) {
                            this.a.a(-3);
                            return;
                        } else if (i2 == -1) {
                            this.a.a(-3);
                            return;
                        } else {
                            q qVar9 = this.a;
                            if (qVar9.m) {
                                return;
                            }
                            ((AudioManager) qVar9.a.getSystemService("audio")).getStreamVolume(3);
                            DisplayMetrics displayMetrics = new DisplayMetrics();
                            qVar9.b.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                            qVar9.w = displayMetrics.widthPixels;
                            try {
                                TextureView textureView = qVar9.c;
                                if (textureView != null) {
                                    textureView.setSurfaceTextureListener(qVar9);
                                }
                            } catch (Throwable unused) {
                            }
                            q qVar10 = this.a;
                            if (qVar10.m) {
                                return;
                            }
                            qVar10.a();
                            return;
                        }
                    }
                    i2 = -1;
                    qVar3 = this.a;
                    if (qVar3.d != null) {
                        activity.runOnUiThread(new b(this, i2));
                    }
                    if (c != 65534) {
                    }
                }
                c = 65535;
                qVar2 = this.a;
                if (!qVar2.m) {
                }
            } catch (Throwable th) {
                q qVar11 = this.a;
                com.baidu.sofire.face.b.b.a(qVar11.a, qVar11.l, 1, th);
                this.a.a(-9);
            }
        }
    }
}
