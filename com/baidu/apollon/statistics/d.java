package com.baidu.apollon.statistics;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f3993a = 10001;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3994b = 10002;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3995c = 10003;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f3996e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3997d;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static d f3999a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2081904200, "Lcom/baidu/apollon/statistics/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2081904200, "Lcom/baidu/apollon/statistics/d$a;");
                    return;
                }
            }
            f3999a = new d();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f3999a : (d) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f3997d) {
                return false;
            }
            this.f3997d = true;
            f3996e.sendEmptyMessage(10003);
            LogSender.getInstance().a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public d() {
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
        this.f3997d = false;
        f3996e = new Handler(this, b.a().b().getLooper()) { // from class: com.baidu.apollon.statistics.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f3998a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f3998a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (10001 == i4) {
                        e eVar = (e) message.obj;
                        BasicStoreTools.getInstance().setLastEvtId(PayStatisticsUtil.c(), eVar.m);
                        c.a().a(eVar);
                    } else if (10002 != i4) {
                        if (10003 == i4) {
                            c.a().b();
                        }
                    } else {
                        String str = (String) message.obj;
                        c.a().a(message.arg1, str);
                        c.a().b(str);
                    }
                }
            }
        };
    }

    public void a(String str, String str2, String str3, String str4, long j) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
            if (str3 != null) {
                arrayList = new ArrayList(1);
                arrayList.add(str3);
            } else {
                arrayList = null;
            }
            a(str, str2, arrayList, str4, j);
        }
    }

    public void a(String str, String str2, Collection<String> collection, String str3, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, collection, str3, Long.valueOf(j)}) == null) || g.a().b(str)) {
            return;
        }
        if (!b() && g.a().b()) {
            LogSender.getInstance().a();
        }
        f3996e.obtainMessage(10001, e.a(str, j, str2, f.a(), com.baidu.apollon.statistics.a.a(), collection, str3)).sendToTarget();
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            f3996e.obtainMessage(10002, i2, -1, str).sendToTarget();
        }
    }
}
