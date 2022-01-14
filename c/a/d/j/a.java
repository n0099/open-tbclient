package c.a.d.j;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import com.baidu.adp.ApsConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IPackageDownloadCallback;
import com.baidu.nps.interfa.IPackageGetCallback;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.searchbox.pms.bean.DegradeData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.bean.ResultData;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.download.DownloadOptions;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f3210e;
    public transient /* synthetic */ FieldHolder $fh;
    public IPackageGetCallback a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ResultData f3211b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ErrorInfo f3212c;

    /* renamed from: d  reason: collision with root package name */
    public RequestParams.Channel f3213d;

    /* renamed from: c.a.d.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0122a implements PackageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IPackageGetCallback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f3214b;

        public C0122a(a aVar, IPackageGetCallback iPackageGetCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, iPackageGetCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3214b = aVar;
            this.a = iPackageGetCallback;
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onDegradeData(DegradeData degradeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, degradeData) == null) {
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onFetchError(ErrorInfo errorInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorInfo) == null) {
                this.f3214b.n(errorInfo, this.a);
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onResultData(ResultData resultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) == null) {
                this.f3214b.o(resultData, this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements PackageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onDegradeData(DegradeData degradeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, degradeData) == null) {
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onFetchError(ErrorInfo errorInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorInfo) == null) {
                synchronized (this.a) {
                    this.a.f3212c = errorInfo;
                    this.a.p();
                }
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onResultData(ResultData resultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) == null) {
                synchronized (this.a) {
                    boolean unused = a.f3210e = true;
                    this.a.f3211b = resultData;
                    this.a.p();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1528894096, "Lc/a/d/j/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1528894096, "Lc/a/d/j/a;");
        }
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

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f3210e : invokeV.booleanValue;
    }

    public final List<IBundleInfo> g(List<PackageInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.isEmpty()) {
                return null;
            }
            for (PackageInfo packageInfo : list) {
                arrayList.add(new c.a.d.h.a(packageInfo));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final PackageInfo h(IBundleInfo iBundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iBundleInfo)) == null) {
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.channelId = ApsConstants.TYPE_ANDROID_PLUGIN;
            packageInfo.packageName = iBundleInfo.getPackageName();
            packageInfo.md5 = iBundleInfo.getMd5();
            packageInfo.downloadUrl = iBundleInfo.getDownloadUrl();
            packageInfo.isSilence = 1;
            return packageInfo;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public void i(IBundleInfo iBundleInfo, String str, int i2, IPackageDownloadCallback iPackageDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, iBundleInfo, str, i2, iPackageDownloadCallback) == null) {
            PackageInfo h2 = h(iBundleInfo);
            h2.filePath = str;
            DownloadOptions downloadOptions = new DownloadOptions();
            downloadOptions.saveToDb = false;
            if (i2 == 49) {
                if (l.H()) {
                    PmsManager.getInstance().download(h2, downloadOptions, new c.a.d.h.b(iPackageDownloadCallback));
                    return;
                } else {
                    iPackageDownloadCallback.onPackageDownloadFail(h2.packageName, -1, "no wifi");
                    return;
                }
            }
            PmsManager.getInstance().download(h2, downloadOptions, new c.a.d.h.b(iPackageDownloadCallback));
        }
    }

    public final void j(List<IBundleInfo> list, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, iPackageGetCallback) == null) {
            RequestParams requestParams = new RequestParams();
            requestParams.setRunType(ApsConstants.RUN_TYPE_ANDROID_PLUGIN);
            RequestParams.Channel channel = new RequestParams.Channel();
            channel.setChannelId(ApsConstants.TYPE_ANDROID_PLUGIN);
            ArrayList arrayList = new ArrayList();
            for (IBundleInfo iBundleInfo : list) {
                arrayList.add(iBundleInfo.getPackageName());
            }
            channel.setPackageNames(arrayList);
            channel.setCallback(new C0122a(this, iPackageGetCallback));
            requestParams.addChannel(channel);
            PmsManager.getInstance().execute(requestParams);
        }
    }

    public void k(List<IBundleInfo> list, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, iPackageGetCallback) == null) {
            if (list == null || list.isEmpty()) {
                synchronized (this) {
                    this.a = iPackageGetCallback;
                    p();
                }
                return;
            }
            j(list, iPackageGetCallback);
        }
    }

    public RequestParams.Channel l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequestParams.Channel channel = this.f3213d;
            if (channel != null) {
                return channel;
            }
            RequestParams.Channel channel2 = new RequestParams.Channel();
            this.f3213d = channel2;
            channel2.setFetchAllPackages(true);
            this.f3213d.setChannelId(ApsConstants.TYPE_ANDROID_PLUGIN);
            this.f3213d.setCallback(new b(this));
            return this.f3213d;
        }
        return (RequestParams.Channel) invokeV.objValue;
    }

    public final void n(ErrorInfo errorInfo, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, errorInfo, iPackageGetCallback) == null) {
            iPackageGetCallback.onBundleInfoGetFail(errorInfo.code, errorInfo.errorMsg);
        }
    }

    public final void o(ResultData resultData, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, resultData, iPackageGetCallback) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(resultData.addList);
            arrayList.addAll(resultData.updateList);
            iPackageGetCallback.onBundleInfoGetSuccess(g(arrayList));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a == null) {
            return;
        }
        if (this.f3212c != null) {
            n(this.f3212c, this.a);
            this.a = null;
            this.f3212c = null;
        } else if (this.f3211b != null) {
            o(this.f3211b, this.a);
            this.a = null;
            this.f3211b = null;
        }
    }
}
