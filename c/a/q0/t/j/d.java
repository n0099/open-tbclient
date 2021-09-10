package c.a.q0.t.j;

import android.os.Handler;
import android.os.Message;
import c.a.e.e.p.j;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerC0713d f14966a;

    /* renamed from: b  reason: collision with root package name */
    public c f14967b;

    /* renamed from: c  reason: collision with root package name */
    public b f14968c;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Process f14969a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f14970b;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14970b = dVar;
            this.f14969a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.onCancelled();
                Process process = this.f14969a;
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (this.f14970b.f14967b != null) {
                    this.f14970b.f14967b.a(false);
                }
                if (this.f14970b.f14966a != null) {
                    this.f14970b.f14966a.removeMessages(0);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                boolean z = false;
                if (strArr != null && strArr.length >= 1) {
                    try {
                        try {
                            try {
                                Process exec = Runtime.getRuntime().exec(strArr[0]);
                                this.f14969a = exec;
                                if (exec.waitFor() == 0) {
                                    z = true;
                                }
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } catch (InterruptedException e3) {
                            e3.printStackTrace();
                        }
                    } finally {
                        this.f14969a.destroy();
                    }
                }
                return Boolean.valueOf(z);
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                if (this.f14970b.f14967b != null) {
                    this.f14970b.f14967b.a(bool == null ? false : bool.booleanValue());
                }
                if (this.f14970b.f14966a != null) {
                    this.f14970b.f14966a.removeMessages(0);
                }
            }
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z);
    }

    /* renamed from: c.a.q0.t.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0713d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f14971a;

        public HandlerC0713d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14971a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 0 || (dVar = this.f14971a.get()) == null) {
                    return;
                }
                dVar.e();
            }
        }
    }

    public d(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14966a = null;
        this.f14967b = null;
        this.f14968c = null;
        HandlerC0713d handlerC0713d = new HandlerC0713d(this);
        this.f14966a = handlerC0713d;
        this.f14967b = cVar;
        handlerC0713d.sendEmptyMessageDelayed(0, 50000L);
        b bVar = new b(this, null);
        this.f14968c = bVar;
        bVar.setSelfExecute(true);
        b bVar2 = this.f14968c;
        bVar2.execute(d() + str);
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int I = j.I();
            return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
        }
        return (String) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.f14968c;
            if (bVar != null) {
                bVar.cancel(true);
            }
            HandlerC0713d handlerC0713d = this.f14966a;
            if (handlerC0713d != null) {
                handlerC0713d.removeMessages(0);
            }
        }
    }
}
