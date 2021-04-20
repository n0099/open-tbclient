package com.baidu.mobads.container.config;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AppCommonConfig {
    public static final String CRASH_PROXY_ANTI = "com.bd.mobpack";
    public static final String CRASH_PROXY_COMMON = "com.baidu.mobads.sdk";
    public static final String CRASH_REMOTE_CONTAINER = "com.baidu.mobads.container";
    public static final String CRASH_THIRD_MTJ = "com.baidu.mobstat.forbes";
    public static volatile AppCommonConfig mSingleton;
    public List<String> crashPackage;
    public List<String> iad_StringList;
    public boolean mtj_switch;
    public boolean supportHttp;
    public String DEFAULT_PKG_LIST = "mvqVQhGGUhIbUv4MQh7sTa4Vmyk_QAPEUi49mv9GuguEQMuGTZPCUL0_mvqVQMw9UvF9Uz4YmyqBmyt_mvqVQMPdUh-8uz4VUvFGUAR8uyFdXikWIZFGTa49UhwzUv-bQMuGugT_mvqVQ-7dUh7zQAPEUi41my4oIy7GQhd-pgwdmy3_mvqVQhwGmy4spy4MQMmkQAPEUi4CUvd-UA-8pz49UhwzUv-bQAPEUi43Iy4Vuy4MQMKGUhwdUvwdUzkWUvY8XA-8uv-8QM9CTzkWUvY8UA-9UhGGmi4Buy-ouikWUvY8my4JIyV-Qh78uZFEpyf8mgKsQAPEUi4hmy4MuAf8UyqBpyk-QhubuA9EIgP-ULI8ugFLUhNzTvN_UakWUvY8ILNBmikWUvY8mh7GuZR8pA7Epv78QAPEUi4WUyPWQhPVIh-buyt_mvqVQMPVpyk-QhIGuhd9pvNzQAPEUi4sni4VUvFGUAR8TZNYUv4MQAPEUi4YmyqdQhd9pyd9pikWUvY8TvNWUvt_mvqVQhV9Uvk9QAPEUi4GUydEUyt8UyqVUzkWUvY8Ig9GUB4dTvNbmv7zQAPEUi4WIyFGmz49IgwEpAqVuikWUvY8XAP9TB49mLwGIh-YXikWUvY8mykGmh7Bmi4LpgF-UAN1TzkVui4-UAR_mvqVQhF9pywdQhdGUh-vpyw-UzkWUvY8mh7GuZR8TvN9ThPCmhq3QhkGIAR_mvqVQhF9pywdQMP-mgFWpAFEXa4VpgP1pyq8QAPEUi4Bmy-bIi4YpyNBmikWUvY8Tv-8mi4Luy-BUzkWUvY8mh7GuZR8TvN9ThPCmhq3QAPEUi4lpA-CIi49UhwzUv-bQAPEUi4kpg-GQMuGuANEQAPEUi4Yuy4Wuy4YQhdVQAPEUi4WUvdJpyD8pv78ph-9ugPYmgw-QAPEUi4kpy9EUz4_Uv78QAPEUi4Yuy4Wuy4YQMI-pgPCpikWUvY8uZNEIv78QhdEmh-_uikWUvY8IAN8mvN8Ia4YUyIsQMPMmyd-QAPEUi4VuMT8Thq9uAFEUv__mvqVQMw-UhP-UMf8IAdMTa4WuBkWUvY8IA7Emh7EQMwzpg0_mvqVQMw-UhP-UMf8pv7zmyqouis_mvqVQMP1Qh78uZFEpyf8IyIWQh7Luyd-QAPEUi4Yuy4Wuy4YQhdYIakWUvY8pvd3Tz4zuy7bugc_mvqVQMPEUhILUz4spyT_IZm8uA78Uy7oIi4BpykGQAPEUi41Tz49UhwzUv-bQh7zIA-WUAR8Ih-buyt_mvqVQhGGuhN8QM7dpv78QAPEUi4_uyPCIy78QhdbILC_UyR8Xy-bIyb_mvqVQM-Gmv9-Qh7dIAq-mgP4QAPEUi4oIy7GTv9EIi48uyFdUAD_mvqVQhNMQh78uZFEpyf8fykGTA74wLKCUv4-QAPEUi4Yuy4Wuy4YQh4-ILn_mvqVQMw-UhP-UMf8Tg7_pgu-";
    public final String DEFAULT_APP_LIST_SECEND = "mvqVQM-EIyVdQMKCUv4-QAPEUi41Tz49UhwzUv-bQMNMmz49IvNVui4_pgw-QAPEUi4VuyN_pgu-Qh-8uvV-uikWUvY8TgN4IyR8my4bThqGuakWUvY8TLn8my4bThqGua49TMwGmvk-QhkGIAR_mvqVQMP1Qh78uZFEpyf8mgFYpyP_ui48ugI1QAPEUi41my4oIy7GQhd-pgwdmy38IA7ouyqdIA4-IzkWUvY8IA7Emh7EQh-bUANhpgPCQAPEUi4VULPCuy4MQAPEUi4Jua4JuAkGIAR_mvqVQM7kuv7Vui4CUAwbXBkWUvY8mgNYUv49Ihb8Uy-8pyd9TakWUvY8NRPPUvFGUAR_mvqVQMw-UhP-UMf8Tg7VIgPGmzkWUvY8UA-8pvNbpy38my4bThqGuakWUvY8phf8pMF9TZ0_mvqVQM-JTykbTz4WUAN9UBkWUvY8XA-8pZR8mvk-my3_mvqVQhGbQMKGUhIEIikWUvY8mv7GUh-9Uz4LpgF-UAN1TzkWUvY8IA7Emh7EQhkGIANYmyt_mvqVQMPbIi4bpywGQMK1UhI-TBkWUvY8IAN8mvN8Ia49UhwzUv-bQM7kuAqLUhkEmyw-TBkWUvY8TvwdQhwGuAb8uLPdpikWUvY8uZF9uvq8QMF-myf_mvqVQh4EIhN_QMKGuz4hThN-QhF9UhT_UAqvui4VmgwWpa41ugf_mvqVQMP1Qh78uZFEpyf8IyIWQhkGIhRb";

    public AppCommonConfig() {
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
        if (mSingleton == null) {
            synchronized (AppCommonConfig.class) {
                if (mSingleton == null) {
                    mSingleton = new AppCommonConfig();
                }
            }
        }
        return mSingleton;
    }

    public List<String> getCrashPackage() {
        return this.crashPackage;
    }

    public List<String> getIadStringList() {
        return this.iad_StringList;
    }

    public boolean getMtjSwitch() {
        return this.mtj_switch;
    }

    public boolean getSupportHttp() {
        return this.supportHttp;
    }

    public Object getValueForKey(String str) {
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
}
