package com.baidu.nadcore.lp.reward.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.bj0;
import com.baidu.tieba.cp0;
import com.baidu.tieba.ep0;
import com.baidu.tieba.fr0;
import com.baidu.tieba.gr0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.nj0;
import com.baidu.tieba.nr0;
import com.baidu.tieba.ph0;
import com.baidu.tieba.po0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.rr0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.tq0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.xq0;
import com.baidu.tieba.zm0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000B\u0007¢\u0006\u0004\b5\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\r\u0010\u0016\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u000bJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u000bJ\r\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u000bJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u000bJ\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\"R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010&R\u0016\u0010.\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010&R\u0016\u0010/\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010(R\u0016\u00100\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010(R\u0016\u00101\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010(R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010(R\u0018\u00103\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "response", "Lcom/baidu/nadcore/download/consts/AdDownloadStatus;", "downloadStatus", "", "ext", "", "activateDownloadTask", "(Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;Lcom/baidu/nadcore/download/consts/AdDownloadStatus;Ljava/lang/String;)V", "activateInvokeTask", "()V", "checkDownloadTaskComplete", "checkInvokeTaskComplete", "Landroid/content/Context;", "context", "", "isAppInstalled", "(Landroid/content/Context;)Z", "scheme", "(Ljava/lang/String;Landroid/content/Context;)Z", "isDownloadAvailable", "isDownloadTaskActivated", "()Z", "isInvokeAvailable", "postDownloadTaskEvent", "postInvokeTaskEvent", "registerBackForegroundEvent", "removeTask", "resetRewardTaskStatus", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setData", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Landroid/content/Context;", "Ljava/lang/Runnable;", "downloadTask", "Ljava/lang/Runnable;", "downloadTaskActivated", "Z", "downloadTaskComplete", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "invokeActiveTask", "invokeTask", "invokeTaskActivated", "invokeTaskComplete", "receivedDownloadReward", "receivedInvokeReward", "taskRewardResponse", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadRewardTaskHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public Handler b;
    public xq0 c;
    public po0 d;
    public boolean e;
    public boolean f;
    public boolean g;
    public Runnable h;
    public boolean i;
    public boolean j;
    public boolean k;
    public Runnable l;
    public Runnable m;

    /* loaded from: classes2.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardTaskHelper a;

        public a(NadRewardTaskHelper nadRewardTaskHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardTaskHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardTaskHelper;
        }

        @Override // java.lang.Runnable
        public final void run() {
            pr0 g;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            xq0 xq0Var = this.a.c;
            if (xq0Var != null && (g = xq0Var.g()) != null && g.a()) {
                return;
            }
            this.a.i = true;
            this.a.D();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardTaskHelper a;

        public b(NadRewardTaskHelper nadRewardTaskHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardTaskHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardTaskHelper;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.f = true;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardTaskHelper a;

        public c(NadRewardTaskHelper nadRewardTaskHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardTaskHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardTaskHelper;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.j = true;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends wm0<zm0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardTaskHelper b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(NadRewardTaskHelper nadRewardTaskHelper, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardTaskHelper, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nadRewardTaskHelper;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wm0
        public void onEvent(zm0 event) {
            xq0 xq0Var;
            fr0 b;
            Long h;
            tq0 tq0Var;
            xq0 xq0Var2;
            fr0 b2;
            Long d;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                String str = null;
                if (event.a) {
                    this.b.b.removeCallbacksAndMessages(null);
                    this.b.v();
                    this.b.w();
                    return;
                }
                if (!this.b.g && this.b.e && !this.b.f) {
                    NadRewardTaskHelper nadRewardTaskHelper = this.b;
                    if (nadRewardTaskHelper.x(nadRewardTaskHelper.a) && (xq0Var2 = this.b.c) != null && (b2 = xq0Var2.b()) != null && (d = b2.d()) != null) {
                        this.b.b.postDelayed(this.b.h, d.longValue());
                    }
                }
                if (!this.b.k && this.b.i && !this.b.j) {
                    NadRewardTaskHelper nadRewardTaskHelper2 = this.b;
                    xq0 xq0Var3 = nadRewardTaskHelper2.c;
                    if (xq0Var3 != null && (tq0Var = xq0Var3.f) != null) {
                        str = tq0Var.c;
                    }
                    if (nadRewardTaskHelper2.y(str, this.b.a) && (xq0Var = this.b.c) != null && (b = xq0Var.b()) != null && (h = b.h()) != null) {
                        this.b.b.postDelayed(this.b.l, h.longValue());
                    }
                }
            }
        }
    }

    public NadRewardTaskHelper() {
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
        Context b2 = nj0.b();
        Intrinsics.checkNotNullExpressionValue(b2, "AdRuntime.applicationContext()");
        this.a = b2;
        this.b = new Handler(this.a.getMainLooper());
        this.h = new b(this);
        this.l = new c(this);
    }

    public final void H(xq0 adModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adModel) == null) {
            Intrinsics.checkNotNullParameter(adModel, "adModel");
            this.c = adModel;
            G();
            u();
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.e && !this.f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            sm0.a().b(this, new d(this, zm0.class));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.removeCallbacksAndMessages(null);
            sm0.a().unregister(this);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e = false;
            this.f = false;
            this.g = false;
            this.d = null;
            this.i = false;
            this.j = false;
            this.k = false;
            this.b.removeCallbacksAndMessages(null);
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        int i;
        String str;
        rr0 rr0Var;
        nr0 f;
        nr0 f2;
        fr0 b2;
        tq0 tq0Var;
        tq0 tq0Var2;
        nr0 f3;
        rr0 q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            xq0 xq0Var = this.c;
            if (xq0Var != null && (f3 = xq0Var.f()) != null && (q = f3.q()) != null) {
                i = q.b();
            } else {
                i = -1;
            }
            gr0 gr0Var = null;
            r2 = null;
            String str2 = null;
            gr0Var = null;
            if (i <= 0) {
                xq0 xq0Var2 = this.c;
                if (xq0Var2 != null && (tq0Var2 = xq0Var2.f) != null) {
                    str2 = tq0Var2.d;
                }
                ep0.e(str2, "18", "18002");
                return false;
            }
            xq0 xq0Var3 = this.c;
            if (xq0Var3 != null && (tq0Var = xq0Var3.f) != null) {
                str = tq0Var.c;
            } else {
                str = null;
            }
            if (!y(str, this.a)) {
                return false;
            }
            xq0 xq0Var4 = this.c;
            if (xq0Var4 != null && (b2 = xq0Var4.b()) != null && b2.i() == 0) {
                return false;
            }
            xq0 xq0Var5 = this.c;
            if (xq0Var5 != null && (f2 = xq0Var5.f()) != null) {
                rr0Var = f2.q();
            } else {
                rr0Var = null;
            }
            if (rr0Var != null) {
                xq0 xq0Var6 = this.c;
                if (xq0Var6 != null && (f = xq0Var6.f()) != null) {
                    gr0Var = f.f();
                }
                if (gr0Var != null) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void C() {
        Integer num;
        pq0 pq0Var;
        String str;
        pq0 pq0Var2;
        fr0 b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ph0 ph0Var = new ph0();
            ph0Var.a = "2";
            xq0 xq0Var = this.c;
            String str2 = null;
            if (xq0Var != null && (b2 = xq0Var.b()) != null) {
                num = Integer.valueOf(b2.e());
            } else {
                num = null;
            }
            ph0Var.b = String.valueOf(num);
            po0 po0Var = this.d;
            if (po0Var != null) {
                str2 = po0Var.h();
            }
            ph0Var.c = str2;
            xq0 xq0Var2 = this.c;
            String str3 = "";
            ph0Var.d = (xq0Var2 == null || (pq0Var2 = xq0Var2.m) == null || (r1 = pq0Var2.i) == null) ? "" : "";
            xq0 xq0Var3 = this.c;
            if (xq0Var3 != null && (pq0Var = xq0Var3.m) != null && (str = pq0Var.j) != null) {
                str3 = str;
            }
            ph0Var.e = str3;
            AdDownloadStatus adDownloadStatus = AdDownloadStatus.NONE;
            ph0Var.h = this.f;
            new Function0<Unit>(this) { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$postDownloadTaskEvent$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NadRewardTaskHelper this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    xq0 xq0Var4;
                    fr0 b3;
                    Long d2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.this$0.e && !this.this$0.f && (xq0Var4 = this.this$0.c) != null && (b3 = xq0Var4.b()) != null && (d2 = b3.d()) != null) {
                        this.this$0.b.postDelayed(this.this$0.h, d2.longValue());
                    }
                }
            };
            sm0.a().a(ph0Var);
        }
    }

    public final void D() {
        Integer num;
        String str;
        String str2;
        String str3;
        String str4;
        tq0 tq0Var;
        pq0 pq0Var;
        pq0 pq0Var2;
        pq0 pq0Var3;
        pq0 pq0Var4;
        nr0 f;
        rr0 q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ph0 ph0Var = new ph0();
            ph0Var.a = "4";
            xq0 xq0Var = this.c;
            String str5 = null;
            if (xq0Var != null && (f = xq0Var.f()) != null && (q = f.q()) != null) {
                num = Integer.valueOf(q.b());
            } else {
                num = null;
            }
            ph0Var.c = String.valueOf(num);
            xq0 xq0Var2 = this.c;
            if (xq0Var2 != null && (pq0Var4 = xq0Var2.m) != null) {
                str = pq0Var4.k;
            } else {
                str = null;
            }
            ph0Var.d = str;
            xq0 xq0Var3 = this.c;
            if (xq0Var3 != null && (pq0Var3 = xq0Var3.m) != null) {
                str2 = pq0Var3.l;
            } else {
                str2 = null;
            }
            ph0Var.e = str2;
            xq0 xq0Var4 = this.c;
            if (xq0Var4 != null && (pq0Var2 = xq0Var4.m) != null) {
                str3 = pq0Var2.m;
            } else {
                str3 = null;
            }
            ph0Var.f = str3;
            xq0 xq0Var5 = this.c;
            if (xq0Var5 != null && (pq0Var = xq0Var5.m) != null) {
                str4 = pq0Var.n;
            } else {
                str4 = null;
            }
            ph0Var.g = str4;
            ph0Var.h = this.j;
            xq0 xq0Var6 = this.c;
            if (xq0Var6 != null && (tq0Var = xq0Var6.f) != null) {
                str5 = tq0Var.d;
            }
            ph0Var.i = str5;
            sm0.a().a(ph0Var);
        }
    }

    public final void v() {
        nr0 nr0Var;
        nr0 f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.g) {
            return;
        }
        po0 po0Var = this.d;
        if (!this.e || po0Var == null || !po0Var.a() || !x(this.a)) {
            return;
        }
        if (this.f) {
            cp0 cp0Var = cp0.a;
            xq0 xq0Var = this.c;
            if (xq0Var != null) {
                nr0Var = xq0Var.f();
            } else {
                nr0Var = null;
            }
            nr0 nr0Var2 = nr0Var;
            String g = po0Var.g();
            xq0 xq0Var2 = this.c;
            cp0Var.c(nr0Var2, g, (xq0Var2 == null || (f = xq0Var2.f()) == null || (r0 = f.e()) == null) ? "" : "", new Function2<String, String, Unit>(this) { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NadRewardTaskHelper this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                    invoke2(str, str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String coin, String str) {
                    String str2;
                    tq0 tq0Var;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coin, str) == null) {
                        Intrinsics.checkNotNullParameter(coin, "coin");
                        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                        Toast.makeText(this.this$0.a, "恭喜！成功领取金币啦～", 0).show();
                        xq0 xq0Var3 = this.this$0.c;
                        if (xq0Var3 != null && (tq0Var = xq0Var3.f) != null) {
                            str2 = tq0Var.d;
                        } else {
                            str2 = null;
                        }
                        ep0.g(str2, "2", coin);
                    }
                }
            }, new Function2<Throwable, Integer, Unit>(this) { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NadRewardTaskHelper this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th, Integer num) {
                    invoke(th, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Throwable th, int i) {
                    tq0 tq0Var;
                    tq0 tq0Var2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, i) == null) {
                        Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                        String str = null;
                        if (i == 1) {
                            xq0 xq0Var3 = this.this$0.c;
                            if (xq0Var3 != null && (tq0Var2 = xq0Var3.f) != null) {
                                str = tq0Var2.d;
                            }
                            ep0.l(str, "2");
                            return;
                        }
                        xq0 xq0Var4 = this.this$0.c;
                        if (xq0Var4 != null && (tq0Var = xq0Var4.f) != null) {
                            str = tq0Var.d;
                        }
                        ep0.k(str, "2");
                    }
                }
            });
            this.g = true;
            C();
            return;
        }
        Toast.makeText(this.a, "哎呀！差一点就成功啦，再试一次", 0).show();
    }

    public final void t(po0 response, AdDownloadStatus downloadStatus, String ext) {
        boolean z;
        String str;
        tq0 tq0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, response, downloadStatus, ext) == null) {
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
            Intrinsics.checkNotNullParameter(ext, "ext");
            if (response.h().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                ep0.e(ext, "18", "18001");
            }
            if (!response.a() || !z(this.a) || downloadStatus != AdDownloadStatus.NONE) {
                return;
            }
            this.d = response;
            C();
            this.e = true;
            xq0 xq0Var = this.c;
            if (xq0Var != null && (tq0Var = xq0Var.f) != null) {
                str = tq0Var.d;
            } else {
                str = null;
            }
            ep0.c(str, "2", response.h());
            E();
        }
    }

    public final void u() {
        fr0 b2;
        Long h;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || !B()) {
            return;
        }
        this.m = new a(this);
        xq0 xq0Var = this.c;
        if (xq0Var != null && (b2 = xq0Var.b()) != null && (h = b2.h()) != null) {
            long longValue = h.longValue();
            Handler handler = this.b;
            Runnable runnable = this.m;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, longValue);
        }
        E();
    }

    public final void w() {
        nr0 f;
        rr0 rr0Var;
        gr0 gr0Var;
        nr0 nr0Var;
        rr0 rr0Var2;
        gr0 gr0Var2;
        nr0 f2;
        nr0 f3;
        nr0 f4;
        nr0 f5;
        nr0 f6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.k || !this.i) {
            return;
        }
        String str = null;
        if (this.j) {
            xq0 xq0Var = this.c;
            if (xq0Var != null && (f6 = xq0Var.f()) != null) {
                rr0Var = f6.q();
            } else {
                rr0Var = null;
            }
            if (rr0Var != null) {
                xq0 xq0Var2 = this.c;
                if (xq0Var2 != null && (f5 = xq0Var2.f()) != null) {
                    gr0Var = f5.f();
                } else {
                    gr0Var = null;
                }
                if (gr0Var != null) {
                    cp0 cp0Var = cp0.a;
                    xq0 xq0Var3 = this.c;
                    if (xq0Var3 != null) {
                        nr0Var = xq0Var3.f();
                    } else {
                        nr0Var = null;
                    }
                    xq0 xq0Var4 = this.c;
                    if (xq0Var4 != null && (f4 = xq0Var4.f()) != null) {
                        rr0Var2 = f4.q();
                    } else {
                        rr0Var2 = null;
                    }
                    Intrinsics.checkNotNull(rr0Var2);
                    String a2 = rr0Var2.a();
                    xq0 xq0Var5 = this.c;
                    if (xq0Var5 != null && (f3 = xq0Var5.f()) != null) {
                        gr0Var2 = f3.f();
                    } else {
                        gr0Var2 = null;
                    }
                    Intrinsics.checkNotNull(gr0Var2);
                    cp0Var.c(nr0Var, a2, gr0Var2.c(), new Function2<String, String, Unit>(this) { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ NadRewardTaskHelper this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(String str2, String str3) {
                            invoke2(str2, str3);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(String coin, String nextCoin) {
                            String str2;
                            nr0 f7;
                            tq0 tq0Var;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coin, nextCoin) == null) {
                                Intrinsics.checkNotNullParameter(coin, "coin");
                                Intrinsics.checkNotNullParameter(nextCoin, "nextCoin");
                                xq0 xq0Var6 = this.this$0.c;
                                if (xq0Var6 != null && (tq0Var = xq0Var6.f) != null) {
                                    str2 = tq0Var.d;
                                } else {
                                    str2 = null;
                                }
                                ep0.g(str2, "4", coin);
                                xq0 xq0Var7 = this.this$0.c;
                                if (xq0Var7 != null && (f7 = xq0Var7.f()) != null) {
                                    f7.D(nextCoin);
                                }
                            }
                        }
                    }, new Function2<Throwable, Integer, Unit>(this) { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ NadRewardTaskHelper this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th, Integer num) {
                            invoke(th, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Throwable th, int i) {
                            tq0 tq0Var;
                            tq0 tq0Var2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, i) == null) {
                                Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                                String str2 = null;
                                if (i == 1) {
                                    xq0 xq0Var6 = this.this$0.c;
                                    if (xq0Var6 != null && (tq0Var2 = xq0Var6.f) != null) {
                                        str2 = tq0Var2.d;
                                    }
                                    ep0.l(str2, "4");
                                    return;
                                }
                                xq0 xq0Var7 = this.this$0.c;
                                if (xq0Var7 != null && (tq0Var = xq0Var7.f) != null) {
                                    str2 = tq0Var.d;
                                }
                                ep0.k(str2, "4");
                            }
                        }
                    });
                    Context context = this.a;
                    xq0 xq0Var6 = this.c;
                    if (xq0Var6 != null && (f2 = xq0Var6.f()) != null) {
                        str = f2.g();
                    }
                    Toast.makeText(context, String.valueOf(str), 0).show();
                    this.k = true;
                    D();
                    return;
                }
                return;
            }
            return;
        }
        Context context2 = this.a;
        xq0 xq0Var7 = this.c;
        if (xq0Var7 != null && (f = xq0Var7.f()) != null) {
            str = f.h();
        }
        Toast.makeText(context2, String.valueOf(str), 0).show();
    }

    public final boolean x(Context context) {
        InterceptResult invokeL;
        String str;
        boolean z;
        String str2;
        pq0 pq0Var;
        lq0 lq0Var;
        pq0 pq0Var2;
        lq0 lq0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            xq0 xq0Var = this.c;
            PackageInfo packageInfo = null;
            if (xq0Var != null && (pq0Var2 = xq0Var.m) != null && (lq0Var2 = pq0Var2.p) != null) {
                str = lq0Var2.a;
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                xq0 xq0Var2 = this.c;
                if (xq0Var2 != null && (pq0Var = xq0Var2.m) != null && (lq0Var = pq0Var.p) != null) {
                    str2 = lq0Var.a;
                } else {
                    str2 = null;
                }
                Intrinsics.checkNotNull(str2);
                packageInfo = packageManager.getPackageInfo(str2, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (packageInfo != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean y(String str, Context context) {
        InterceptResult invokeLL;
        Object m773constructorimpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, context)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            HashMap<String, String> d2 = new bj0(str).d();
            Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
            String str2 = d2.get("params");
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            try {
                Result.Companion companion = Result.Companion;
                Intrinsics.checkNotNull(str2);
                m773constructorimpl = Result.m773constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m779isFailureimpl(m773constructorimpl)) {
                m773constructorimpl = null;
            }
            String str3 = (String) m773constructorimpl;
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str3));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            if (context.getPackageManager().queryIntentActivities(intent, 0).size() <= 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean z(Context context) {
        InterceptResult invokeL;
        fr0 fr0Var;
        fr0 fr0Var2;
        String str;
        boolean z;
        boolean z2;
        nr0 f;
        nr0 f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            xq0 xq0Var = this.c;
            if ((xq0Var != null && !xq0Var.l()) || x(context)) {
                return false;
            }
            xq0 xq0Var2 = this.c;
            String str2 = null;
            if (xq0Var2 != null) {
                fr0Var = xq0Var2.b();
            } else {
                fr0Var = null;
            }
            if (fr0Var == null) {
                return false;
            }
            xq0 xq0Var3 = this.c;
            if (xq0Var3 != null) {
                fr0Var2 = xq0Var3.b();
            } else {
                fr0Var2 = null;
            }
            Intrinsics.checkNotNull(fr0Var2);
            if (fr0Var2.e() <= 0) {
                return false;
            }
            xq0 xq0Var4 = this.c;
            if (xq0Var4 != null && (f2 = xq0Var4.f()) != null) {
                str = f2.d();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
            xq0 xq0Var5 = this.c;
            if (xq0Var5 != null && (f = xq0Var5.f()) != null) {
                str2 = f.e();
            }
            if (str2 != null && str2.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
