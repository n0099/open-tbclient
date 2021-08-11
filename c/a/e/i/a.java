package c.a.e.i;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
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
    public static boolean f2836e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IPackageGetCallback f2837a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ResultData f2838b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ErrorInfo f2839c;

    /* renamed from: d  reason: collision with root package name */
    public RequestParams.Channel f2840d;

    /* renamed from: c.a.e.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0056a implements PackageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPackageGetCallback f2841a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f2842b;

        public C0056a(a aVar, IPackageGetCallback iPackageGetCallback) {
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
            this.f2842b = aVar;
            this.f2841a = iPackageGetCallback;
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
                this.f2842b.n(errorInfo, this.f2841a);
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onResultData(ResultData resultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) == null) {
                this.f2842b.o(resultData, this.f2841a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements PackageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f2843a;

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
            this.f2843a = aVar;
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
                synchronized (this.f2843a) {
                    this.f2843a.f2839c = errorInfo;
                    this.f2843a.p();
                }
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onResultData(ResultData resultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) == null) {
                synchronized (this.f2843a) {
                    boolean unused = a.f2836e = true;
                    this.f2843a.f2838b = resultData;
                    this.f2843a.p();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1500294736, "Lc/a/e/i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1500294736, "Lc/a/e/i/a;");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f2836e : invokeV.booleanValue;
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
                arrayList.add(new c.a.e.g.a(packageInfo));
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
                if (j.H()) {
                    PmsManager.getInstance().download(h2, downloadOptions, new c.a.e.g.b(iPackageDownloadCallback));
                    return;
                } else {
                    iPackageDownloadCallback.onPackageDownloadFail(h2.packageName, -1, "no wifi");
                    return;
                }
            }
            PmsManager.getInstance().download(h2, downloadOptions, new c.a.e.g.b(iPackageDownloadCallback));
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
            channel.setCallback(new C0056a(this, iPackageGetCallback));
            requestParams.addChannel(channel);
            PmsManager.getInstance().execute(requestParams);
        }
    }

    public void k(List<IBundleInfo> list, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, iPackageGetCallback) == null) {
            if (list == null || list.isEmpty()) {
                synchronized (this) {
                    this.f2837a = iPackageGetCallback;
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
            RequestParams.Channel channel = this.f2840d;
            if (channel != null) {
                return channel;
            }
            RequestParams.Channel channel2 = new RequestParams.Channel();
            this.f2840d = channel2;
            channel2.setFetchAllPackages(true);
            this.f2840d.setChannelId(ApsConstants.TYPE_ANDROID_PLUGIN);
            this.f2840d.setCallback(new b(this));
            return this.f2840d;
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f2837a == null) {
            return;
        }
        if (this.f2839c != null) {
            n(this.f2839c, this.f2837a);
            this.f2837a = null;
            this.f2839c = null;
        } else if (this.f2838b != null) {
            o(this.f2838b, this.f2837a);
            this.f2837a = null;
            this.f2838b = null;
        }
    }
}
