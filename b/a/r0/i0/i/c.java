package b.a.r0.i0.i;

import android.os.Message;
import b.a.e.e.m.e;
import b.a.q0.d1.i0;
import b.a.q0.d1.l0;
import b.a.q0.d1.q;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static c f17859d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Wire f17860a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, b.a.r0.i0.i.a> f17861b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f17862c;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17863e;

        /* renamed from: b.a.r0.i0.i.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0910a extends i0<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Map f17864a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f17865b;

            public C0910a(a aVar, Map map) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, map};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17865b = aVar;
                this.f17864a = map;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.q0.d1.i0
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    WriteHistroyDataReqIdl.Builder builder = new WriteHistroyDataReqIdl.Builder();
                    builder.connect_point_list = new ArrayList();
                    for (Map.Entry entry : this.f17864a.entrySet()) {
                        ConnectPointData c2 = b.a.r0.i0.i.a.c((b.a.r0.i0.i.a) entry.getValue());
                        if (c2 != null) {
                            builder.connect_point_list.add(c2);
                        }
                    }
                    this.f17865b.f17863e.g(builder.build(true).toByteArray());
                    synchronized (c.class) {
                        this.f17865b.f17863e.f17861b = null;
                    }
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17863e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map map;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (c.class) {
                    map = this.f17863e.f17861b;
                }
                if (map == null) {
                    return;
                }
                l0.b(new C0910a(this, map), null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends i0<WriteHistroyDataReqIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17866a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17866a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.i0
        /* renamed from: a */
        public WriteHistroyDataReqIdl doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                byte[] f2 = this.f17866a.f();
                if (f2 != null) {
                    try {
                        return (WriteHistroyDataReqIdl) this.f17866a.f17860a.parseFrom(f2, WriteHistroyDataReqIdl.class);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
            return (WriteHistroyDataReqIdl) invokeV.objValue;
        }
    }

    /* renamed from: b.a.r0.i0.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0911c implements q<WriteHistroyDataReqIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f17867a;

        public C0911c(c cVar, q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17867a = qVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            q qVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, writeHistroyDataReqIdl) == null) || (qVar = this.f17867a) == null) {
                return;
            }
            qVar.onReturnDataInUI(writeHistroyDataReqIdl);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-580679940, "Lb/a/r0/i0/i/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-580679940, "Lb/a/r0/i0/i/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f17860a = new Wire(new Class[0]);
        this.f17861b = null;
        this.f17862c = new a(this);
    }

    public static final c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f17859d == null) {
                synchronized (c.class) {
                    if (f17859d == null) {
                        f17859d = new c();
                    }
                }
            }
            return f17859d;
        }
        return (c) invokeV.objValue;
    }

    public final byte[] f() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (byte[]) invokeV.objValue;
        }
        try {
            try {
                fileInputStream = BdBaseApplication.getInst().getContext().openFileInput("dnsproxydata");
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read >= 0) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                return byteArrayOutputStream.toByteArray();
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        BdLog.detailException(e);
                        b.a.r0.i0.d.c().a("read_dnsproxydata", e.getMessage());
                        return null;
                    } catch (IOException e3) {
                        e = e3;
                        BdLog.detailException(e);
                        b.a.r0.i0.d.c().a("read_dnsproxydata", e.getMessage());
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        BdLog.detailException(th);
                        b.a.r0.i0.d.c().a("read_dnsproxydata", th.getMessage());
                        return null;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    byteArrayOutputStream = null;
                } catch (IOException e5) {
                    e = e5;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
            } finally {
                b.a.e.e.m.a.c(fileInputStream);
                b.a.e.e.m.a.d(byteArrayOutputStream);
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileInputStream = null;
            byteArrayOutputStream = null;
        } catch (IOException e7) {
            e = e7;
            fileInputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    public final void g(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr) == null) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        fileOutputStream = BdBaseApplication.getInst().getContext().openFileOutput("dnsproxydata", 0);
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                    } catch (IOException e2) {
                        BdLog.detailException(e2);
                        b.a.r0.i0.d.c().a("save_dnsproxydata", e2.getMessage());
                    }
                } catch (FileNotFoundException e3) {
                    BdLog.detailException(e3);
                    b.a.r0.i0.d.c().a("save_dnsproxydata", e3.getMessage());
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    b.a.r0.i0.d.c().a("save_dnsproxydata", th.getMessage());
                }
                b.a.e.e.m.a.d(fileOutputStream);
            } catch (Throwable th2) {
                b.a.e.e.m.a.d(fileOutputStream);
                throw th2;
            }
        }
    }

    public void i(q<WriteHistroyDataReqIdl> qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qVar) == null) {
            l0.b(new b(this), new C0911c(this, qVar));
        }
    }

    public void j(Map<String, b.a.r0.i0.i.a> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, map) == null) && TbadkCoreApplication.getInst().isMainProcess(false) && map != null) {
            synchronized (c.class) {
                this.f17861b = map;
            }
            if (e.a().hasMessages(0, this)) {
                return;
            }
            Message obtain = Message.obtain(e.a(), this.f17862c);
            obtain.what = 0;
            obtain.obj = this;
            e.a().sendMessageDelayed(obtain, 30000L);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e.a().removeMessages(0, this);
            e.a().post(this.f17862c);
        }
    }
}
