package b.a.r0.a4.j;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes4.dex */
public class a extends BdAsyncTask<Void, Void, List<b>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0808a f16097a;

    /* renamed from: b  reason: collision with root package name */
    public Context f16098b;

    /* renamed from: c  reason: collision with root package name */
    public int f16099c;

    /* renamed from: d  reason: collision with root package name */
    public SimpleDateFormat f16100d;

    /* renamed from: e  reason: collision with root package name */
    public SimpleDateFormat f16101e;

    /* renamed from: b.a.r0.a4.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0808a {
        void a(List<b> list);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1023771537, "Lb/a/r0/a4/j/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1023771537, "Lb/a/r0/a4/j/a;");
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16098b = context;
        this.f16099c = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.f16101e = new SimpleDateFormat("mm:ss");
        this.f16100d = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.f16101e.setTimeZone(timeZone);
        this.f16100d.setTimeZone(timeZone);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<b> doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            List<b> a2 = c.a(this.f16098b);
            c.d("/sdcard", a2, false);
            c.d("/sdcard/DCIM", a2, true);
            c.e(a2);
            return a2;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            super.onPostExecute(list);
            InterfaceC0808a interfaceC0808a = this.f16097a;
            if (interfaceC0808a != null) {
                interfaceC0808a.a(list);
            }
        }
    }

    public void d(InterfaceC0808a interfaceC0808a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0808a) == null) {
            this.f16097a = interfaceC0808a;
        }
    }
}
