package b.a.p0.a.w2;

import android.os.SystemClock;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f8884e;

        /* renamed from: f  reason: collision with root package name */
        public long[] f8885f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Runnable f8886g;

        public a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8886g = runnable;
            this.f8884e = 5;
            this.f8885f = new long[5];
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                long[] jArr = this.f8885f;
                System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
                long[] jArr2 = this.f8885f;
                jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
                if (this.f8885f[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.f8885f = new long[this.f8884e];
                    this.f8886g.run();
                }
            }
        }
    }

    public static void a(View view, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, view, runnable) == null) {
            view.setOnClickListener(new a(runnable));
        }
    }
}
