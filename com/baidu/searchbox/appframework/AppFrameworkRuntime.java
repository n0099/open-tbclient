package com.baidu.searchbox.appframework;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes3.dex */
public class AppFrameworkRuntime {
    public static final AppFrameworkIOC DUMMY_IOC = new AppFrameworkIOC() { // from class: com.baidu.searchbox.appframework.AppFrameworkRuntime.1
        @Override // com.baidu.searchbox.appframework.AppFrameworkIOC
        public void backPressUBC(String str, String str2, String str3, String str4, String str5) {
        }

        @Override // com.baidu.searchbox.appframework.AppFrameworkIOC
        public void slideBackUBC(String str, String str2, String str3, String str4, String str5) {
        }
    };

    @Inject(force = false)
    public static AppFrameworkIOC getAppFrameworkIOC() {
        return DUMMY_IOC;
    }

    public static void backPressUBC(String str, String str2, String str3, String str4) {
        backPressUBC(str, str2, str3, str4, null);
    }

    public static void slideBackUBC(String str, String str2, String str3, String str4) {
        slideBackUBC(str, str2, str3, str4, null);
    }

    public static void backPressUBC(String str, String str2, String str3, String str4, String str5) {
        AppFrameworkIOC appFrameworkIOC = getAppFrameworkIOC();
        if (appFrameworkIOC != DUMMY_IOC) {
            appFrameworkIOC.backPressUBC(str, str2, str3, str4, str5);
        }
    }

    public static void slideBackUBC(String str, String str2, String str3, String str4, String str5) {
        AppFrameworkIOC appFrameworkIOC = getAppFrameworkIOC();
        if (appFrameworkIOC != DUMMY_IOC) {
            appFrameworkIOC.slideBackUBC(str, str2, str3, str4, str5);
        }
    }
}
