package c.a.n0.j.b;

import android.app.Activity;
import android.content.DialogInterface;
import c.a.n0.a.p2.q0;
import c.a.n0.a.s1.b.b.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h a;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8602b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8603c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f8604d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f8605e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f8606f;

        public a(c cVar, Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, activity, str, str2, Boolean.valueOf(z), onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8606f = cVar;
            this.a = activity;
            this.f8602b = str;
            this.f8603c = str2;
            this.f8604d = z;
            this.f8605e = onClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8606f.a != null && this.f8606f.a.isShowing()) {
                    this.f8606f.a.dismiss();
                }
                Activity activity = this.a;
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                h.a d2 = this.f8606f.d(this.a, this.f8602b, this.f8603c, this.f8604d, this.f8605e);
                this.f8606f.a = d2.X();
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final h.a d(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{activity, str, str2, Boolean.valueOf(z), onClickListener})) == null) {
            h.a aVar = new h.a(activity);
            aVar.x(str);
            aVar.a();
            aVar.n(new c.a.n0.a.q2.h.a());
            aVar.m(z);
            aVar.Q(R.color.obfuscated_res_0x7f060a4a);
            aVar.f(true);
            aVar.P(str2, onClickListener);
            return aVar;
        }
        return (h.a) invokeCommon.objValue;
    }

    public void e() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.a) == null) {
            return;
        }
        if (hVar.isShowing()) {
            this.a.dismiss();
        }
        this.a = null;
    }

    public void f(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, str, str2, Boolean.valueOf(z), onClickListener}) == null) {
            q0.a0(new a(this, activity, str, str2, z, onClickListener));
        }
    }
}
