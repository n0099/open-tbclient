package c.a.p0.w;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static c.a.a0.a.g.b f15068a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements c.a.a0.a.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.p0.w.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0717a implements e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.a.a0.a.g.a f15069a;

            public C0717a(a aVar, c.a.a0.a.g.a aVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, aVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15069a = aVar2;
            }

            @Override // c.a.p0.w.e
            public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
                c.a.a0.a.g.a aVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) || (aVar = this.f15069a) == null) {
                    return;
                }
                aVar.onFailed(new Exception(str));
            }

            @Override // c.a.p0.w.e
            public void onFileDownloadSucceed(DownloadData downloadData) {
                c.a.a0.a.g.a aVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || (aVar = this.f15069a) == null) {
                    return;
                }
                aVar.b(downloadData.getPath());
            }

            @Override // c.a.p0.w.e
            public boolean onFileDownloaded(DownloadData downloadData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }

            @Override // c.a.p0.w.e
            public void onFileUpdateProgress(DownloadData downloadData) {
                c.a.a0.a.g.a aVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) || (aVar = this.f15069a) == null) {
                    return;
                }
                aVar.a(0L, 100L, (int) (downloadData.getLength() / downloadData.getSize()));
            }

            @Override // c.a.p0.w.e
            public boolean onPreDownload(DownloadData downloadData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                    c.a.a0.a.g.a aVar = this.f15069a;
                    if (aVar != null) {
                        aVar.onStarted();
                        return true;
                    }
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.a0.a.g.b
        public void a(String str, String str2, String str3, c.a.a0.a.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, aVar) == null) {
                DownloadData downloadData = new DownloadData();
                downloadData.setPath(str2 + "/" + str3);
                downloadData.setUrl(str);
                downloadData.setCallback(new C0717a(this, aVar));
                f.k().l(downloadData);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1885272504, "Lc/a/p0/w/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1885272504, "Lc/a/p0/w/d;");
                return;
            }
        }
        f15068a = new a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            c.a.a0.a.b.s(f15068a);
        }
    }
}
