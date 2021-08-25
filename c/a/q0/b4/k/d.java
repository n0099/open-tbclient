package c.a.q0.b4.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static d f16210g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f16211a;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f16212b;

    /* renamed from: c  reason: collision with root package name */
    public ContentObserver f16213c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<InterfaceC0773d> f16214d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f16215e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f16216f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f16217e;

        public a(d dVar) {
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
            this.f16217e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16217e.h(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d this$0;

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
            this.this$0 = dVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.i(intent);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f16218a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16218a = dVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f16218a.f16215e.removeCallbacks(this.f16218a.f16216f);
                this.f16218a.f16215e.postDelayed(this.f16218a.f16216f, 2000L);
            }
        }
    }

    /* renamed from: c.a.q0.b4.k.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0773d {
        void onImageRefresh(boolean z);
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
        this.f16211a = new Handler(Looper.getMainLooper());
        this.f16214d = new ArrayList<>();
        this.f16215e = new Handler();
        this.f16216f = new a(this);
    }

    public static d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f16210g == null) {
                synchronized (d.class) {
                    if (f16210g == null) {
                        d dVar = new d();
                        f16210g = dVar;
                        dVar.g(TbadkCoreApplication.getInst());
                    }
                }
            }
            return f16210g;
        }
        return (d) invokeV.objValue;
    }

    public void d(InterfaceC0773d interfaceC0773d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, interfaceC0773d) == null) || interfaceC0773d == null || this.f16214d.contains(interfaceC0773d)) {
            return;
        }
        this.f16214d.add(interfaceC0773d);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            j();
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            inst.unregisterReceiver(this.f16212b);
            inst.getContentResolver().unregisterContentObserver(this.f16213c);
            this.f16215e.removeCallbacks(this.f16216f);
            f16210g = null;
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f16212b = new b(this);
            this.f16213c = new c(this, this.f16211a);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
            intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
            intentFilter.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter.addDataScheme("file");
            context.registerReceiver(this.f16212b, intentFilter);
            context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f16213c);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            Iterator<InterfaceC0773d> it = this.f16214d.iterator();
            while (it.hasNext()) {
                it.next().onImageRefresh(z);
            }
        }
    }

    public final void i(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
                h(true);
                return;
            }
            this.f16215e.removeCallbacks(this.f16216f);
            this.f16215e.postDelayed(this.f16216f, 2000L);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f16214d.clear();
        }
    }

    public void k(InterfaceC0773d interfaceC0773d) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, interfaceC0773d) == null) && this.f16214d.contains(interfaceC0773d)) {
            this.f16214d.remove(interfaceC0773d);
        }
    }
}
