package com.baidu.mobads.container.config;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class AppCommonConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CRASH_PROXY_ANTI = "com.bd.mobpack";
    public static final String CRASH_PROXY_COMMON = "com.baidu.mobads.sdk";
    public static final String CRASH_REMOTE_CONTAINER = "com.baidu.mobads.container";
    public static final String CRASH_THIRD_MTJ = "com.baidu.mobstat.forbes";
    public static volatile AppCommonConfig mSingleton;
    public transient /* synthetic */ FieldHolder $fh;
    public final String DEFAULT_APP_LIST_SECEND;
    public String DEFAULT_PKG_LIST;
    public List<String> crashPackage;
    public List<String> iad_StringList;
    public boolean mtj_switch;
    public boolean supportHttp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1914159013, "Lcom/baidu/mobads/container/config/AppCommonConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1914159013, "Lcom/baidu/mobads/container/config/AppCommonConfig;");
        }
    }

    public AppCommonConfig() {
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
        this.DEFAULT_PKG_LIST = "mvqVQhGGUhIbUv4MQh7sTa4Vmyk_QAPEUi49mv9GuguEQMuGTZPCUL0_mvqVQMw9UvF9Uz4YmyqBmyt_mvqVQMPdUh-8uz4VUvFGUAR8uyFdXikWIZFGTa49UhwzUv-bQMuGugT_mvqVQ-7dUh7zQAPEUi41my4oIy7GQhd-pgwdmy3_mvqVQhwGmy4spy4MQMmkQAPEUi4CUvd-UA-8pz49UhwzUv-bQAPEUi43Iy4Vuy4MQMKGUhwdUvwdUzkWUvY8XA-8uv-8QM9CTzkWUvY8UA-9UhGGmi4Buy-ouikWUvY8my4JIyV-Qh78uZFEpyf8mgKsQAPEUi4hmy4MuAf8UyqBpyk-QhubuA9EIgP-ULI8ugFLUhNzTvN_UakWUvY8ILNBmikWUvY8mh7GuZR8pA7Epv78QAPEUi4WUyPWQhPVIh-buyt_mvqVQMPVpyk-QhIGuhd9pvNzQAPEUi4sni4VUvFGUAR8TZNYUv4MQAPEUi4YmyqdQhd9pyd9pikWUvY8TvNWUvt_mvqVQhV9Uvk9QAPEUi4GUydEUyt8UyqVUzkWUvY8Ig9GUB4dTvNbmv7zQAPEUi4WIyFGmz49IgwEpAqVuikWUvY8XAP9TB49mLwGIh-YXikWUvY8mykGmh7Bmi4LpgF-UAN1TzkVui4-UAR_mvqVQhF9pywdQhdGUh-vpyw-UzkWUvY8mh7GuZR8TvN9ThPCmhq3QhkGIAR_mvqVQhF9pywdQMP-mgFWpAFEXa4VpgP1pyq8QAPEUi4Bmy-bIi4YpyNBmikWUvY8Tv-8mi4Luy-BUzkWUvY8mh7GuZR8TvN9ThPCmhq3QAPEUi4lpA-CIi49UhwzUv-bQAPEUi4kpg-GQMuGuANEQAPEUi4Yuy4Wuy4YQhdVQAPEUi4WUvdJpyD8pv78ph-9ugPYmgw-QAPEUi4kpy9EUz4_Uv78QAPEUi4Yuy4Wuy4YQMI-pgPCpikWUvY8uZNEIv78QhdEmh-_uikWUvY8IAN8mvN8Ia4YUyIsQMPMmyd-QAPEUi4VuMT8Thq9uAFEUv__mvqVQMw-UhP-UMf8IAdMTa4WuBkWUvY8IA7Emh7EQMwzpg0_mvqVQMw-UhP-UMf8pv7zmyqouis_mvqVQMP1Qh78uZFEpyf8IyIWQh7Luyd-QAPEUi4Yuy4Wuy4YQhdYIakWUvY8pvd3Tz4zuy7bugc_mvqVQMPEUhILUz4spyT_IZm8uA78Uy7oIi4BpykGQAPEUi41Tz49UhwzUv-bQh7zIA-WUAR8Ih-buyt_mvqVQhGGuhN8QM7dpv78QAPEUi4_uyPCIy78QhdbILC_UyR8Xy-bIyb_mvqVQM-Gmv9-Qh7dIAq-mgP4QAPEUi4oIy7GTv9EIi48uyFdUAD_mvqVQhNMQh78uZFEpyf8fykGTA74wLKCUv4-QAPEUi4Yuy4Wuy4YQh4-ILn_mvqVQMw-UhP-UMf8Tg7_pgu-";
        this.DEFAULT_APP_LIST_SECEND = "mvqVQM-EIyVdQMKCUv4-QAPEUi41Tz49UhwzUv-bQMNMmz49IvNVui4_pgw-QAPEUi4VuyN_pgu-Qh-8uvV-uikWUvY8TgN4IyR8my4bThqGuakWUvY8TLn8my4bThqGua49TMwGmvk-QhkGIAR_mvqVQMP1Qh78uZFEpyf8mgFYpyP_ui48ugI1QAPEUi41my4oIy7GQhd-pgwdmy38IA7ouyqdIA4-IzkWUvY8IA7Emh7EQh-bUANhpgPCQAPEUi4VULPCuy4MQAPEUi4Jua4JuAkGIAR_mvqVQM7kuv7Vui4CUAwbXBkWUvY8mgNYUv49Ihb8Uy-8pyd9TakWUvY8NRPPUvFGUAR_mvqVQMw-UhP-UMf8Tg7VIgPGmzkWUvY8UA-8pvNbpy38my4bThqGuakWUvY8phf8pMF9TZ0_mvqVQM-JTykbTz4WUAN9UBkWUvY8XA-8pZR8mvk-my3_mvqVQhGbQMKGUhIEIikWUvY8mv7GUh-9Uz4LpgF-UAN1TzkWUvY8IA7Emh7EQhkGIANYmyt_mvqVQMPbIi4bpywGQMK1UhI-TBkWUvY8IAN8mvN8Ia49UhwzUv-bQM7kuAqLUhkEmyw-TBkWUvY8TvwdQhwGuAb8uLPdpikWUvY8uZF9uvq8QMF-myf_mvqVQh4EIhN_QMKGuz4hThN-QhF9UhT_UAqvui4VmgwWpa41ugf_mvqVQMP1Qh78uZFEpyf8IyIWQhkGIhRb";
        ArrayList arrayList = new ArrayList();
        this.crashPackage = arrayList;
        arrayList.add("com.baidu.mobads.container");
        this.crashPackage.add("com.bd.mobpack");
        this.crashPackage.add("com.baidu.mobads.sdk");
        this.crashPackage.add("com.baidu.mobstat.forbes");
        this.mtj_switch = false;
        ArrayList arrayList2 = new ArrayList();
        this.iad_StringList = arrayList2;
        arrayList2.add(this.DEFAULT_PKG_LIST);
        this.iad_StringList.add("mvqVQM-EIyVdQMKCUv4-QAPEUi41Tz49UhwzUv-bQMNMmz49IvNVui4_pgw-QAPEUi4VuyN_pgu-Qh-8uvV-uikWUvY8TgN4IyR8my4bThqGuakWUvY8TLn8my4bThqGua49TMwGmvk-QhkGIAR_mvqVQMP1Qh78uZFEpyf8mgFYpyP_ui48ugI1QAPEUi41my4oIy7GQhd-pgwdmy38IA7ouyqdIA4-IzkWUvY8IA7Emh7EQh-bUANhpgPCQAPEUi4VULPCuy4MQAPEUi4Jua4JuAkGIAR_mvqVQM7kuv7Vui4CUAwbXBkWUvY8mgNYUv49Ihb8Uy-8pyd9TakWUvY8NRPPUvFGUAR_mvqVQMw-UhP-UMf8Tg7VIgPGmzkWUvY8UA-8pvNbpy38my4bThqGuakWUvY8phf8pMF9TZ0_mvqVQM-JTykbTz4WUAN9UBkWUvY8XA-8pZR8mvk-my3_mvqVQhGbQMKGUhIEIikWUvY8mv7GUh-9Uz4LpgF-UAN1TzkWUvY8IA7Emh7EQhkGIANYmyt_mvqVQMPbIi4bpywGQMK1UhI-TBkWUvY8IAN8mvN8Ia49UhwzUv-bQM7kuAqLUhkEmyw-TBkWUvY8TvwdQhwGuAb8uLPdpikWUvY8uZF9uvq8QMF-myf_mvqVQh4EIhN_QMKGuz4hThN-QhF9UhT_UAqvui4VmgwWpa41ugf_mvqVQMP1Qh78uZFEpyf8IyIWQhkGIhRb");
        this.supportHttp = false;
    }

    public static AppCommonConfig getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mSingleton == null) {
                synchronized (AppCommonConfig.class) {
                    if (mSingleton == null) {
                        mSingleton = new AppCommonConfig();
                    }
                }
            }
            return mSingleton;
        }
        return (AppCommonConfig) invokeV.objValue;
    }

    public List<String> getCrashPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.crashPackage : (List) invokeV.objValue;
    }

    public List<String> getIadStringList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.iad_StringList : (List) invokeV.objValue;
    }

    public boolean getMtjSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mtj_switch : invokeV.booleanValue;
    }

    public boolean getSupportHttp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.supportHttp : invokeV.booleanValue;
    }

    public Object getValueForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str.equals("getIadStringList")) {
                return getIadStringList();
            }
            if (str.equals("getCrashPackage")) {
                return getCrashPackage();
            }
            if (str.equals("getMtjSwitch")) {
                return Boolean.valueOf(getMtjSwitch());
            }
            if (str.equals("getSupportHttp")) {
                return Boolean.valueOf(getSupportHttp());
            }
            return null;
        }
        return invokeL.objValue;
    }
}
