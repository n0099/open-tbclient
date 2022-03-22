package c.a.p0.a4.r0.d.f;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class b extends c.a.p0.a4.r0.d.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public volatile d f12367g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f12368h;
    public int i;

    /* loaded from: classes2.dex */
    public class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable);
                thread.setName("VideoUploadThread@" + this.a);
                this.a = this.a + 1;
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* renamed from: c.a.p0.a4.r0.d.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0923b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RandomAccessFile a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f12369b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f12370c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f12371d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12372e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f12373f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f12374g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f12375h;

        public RunnableC0923b(b bVar, RandomAccessFile randomAccessFile, ArrayList arrayList, int i, int i2, String str, int i3, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, randomAccessFile, arrayList, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12375h = bVar;
            this.a = randomAccessFile;
            this.f12369b = arrayList;
            this.f12370c = i;
            this.f12371d = i2;
            this.f12372e = str;
            this.f12373f = i3;
            this.f12374g = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d h2 = this.f12375h.h(this.a, ((Integer) this.f12369b.get(this.f12370c)).intValue(), this.f12371d, this.f12372e);
                if (h2 != null) {
                    if (h2.f12377b != 0) {
                        this.f12375h.f12367g.f12377b = h2.f12377b;
                        this.f12375h.f12367g.f12378c = h2.f12378c;
                    }
                    if (!StringUtils.isNull(h2.a)) {
                        this.f12375h.f12367g.a = h2.a;
                    }
                    synchronized (this.f12375h) {
                        b.k(this.f12375h);
                        this.f12375h.d((int) (((this.f12375h.i * 50.0f) / this.f12373f) + 30.0f));
                    }
                }
                this.f12374g.countDown();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, int i, int i2, long j, String str2) {
        super(str, i, i2, j, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12367g = new d();
    }

    public static /* synthetic */ int k(b bVar) {
        int i = bVar.i;
        bVar.i = i + 1;
        return i;
    }

    @Override // c.a.p0.a4.r0.d.f.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12368h = true;
        }
    }

    @Override // c.a.p0.a4.r0.d.f.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (!this.f12368h && this.f12367g.f12377b == 0 && StringUtils.isNull(this.f12367g.a)) ? false : true : invokeV.booleanValue;
    }

    @Override // c.a.p0.a4.r0.d.f.a
    public d g(ArrayList<Integer> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, str, i)) == null) {
            int size = arrayList.size();
            CountDownLatch countDownLatch = new CountDownLatch(size);
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 2L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a(this));
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f12362b), "r");
                for (int i2 = 0; i2 < size; i2++) {
                    threadPoolExecutor.execute(new RunnableC0923b(this, randomAccessFile, arrayList, i2, i, str, size, countDownLatch));
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                threadPoolExecutor.shutdown();
                try {
                    randomAccessFile.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return this.f12367g;
            } catch (FileNotFoundException unused) {
                return this.f12367g;
            }
        }
        return (d) invokeLLI.objValue;
    }
}
