package com.baidu.swan.gamecenter.appmanager.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.tieba.ar2;
import com.baidu.tieba.qz3;
import com.baidu.tieba.sy3;
import com.baidu.tieba.uz3;
/* loaded from: classes3.dex */
public class InstallNotifyReceiver extends BroadcastReceiver {
    public static final String KEY_PACKAGE_NAME = "key_pkg_name";
    public static final String NOTIFICATION_INSTALL_ACTION_ALARM = "gamecenter.intent.action.INSTALL_ALARM";
    public static final String NOTIFICATION_INSTALL_ACTION_MULTIPLE = "gamecenter.intent.action.INSTALL_MULTIPLE";
    public static final String NOTIFICATION_INSTALL_ACTION_ONE = "gamecenter.intent.action.INSTALL_ONE";
    public static final String OPPORTUNITY = "opportunity";
    public String mOpportunity;

    public static Intent createIntent(String str) {
        Intent intent = new Intent(AppRuntime.getAppContext(), InstallNotifyReceiver.class);
        intent.setAction(str);
        return intent;
    }

    public static Intent createToDownloadPageIntent(String str) {
        String installPageUrlScheme = getInstallPageUrlScheme();
        Intent intent = new Intent(AppRuntime.getAppContext(), InstallNotifyReceiver.class);
        intent.setAction(str);
        intent.setData(Uri.parse(installPageUrlScheme));
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.addFlags(134217728);
        return intent;
    }

    private void startInstall(Intent intent) {
        String stringExtra = intent.getStringExtra(KEY_PACKAGE_NAME);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        sy3.n().q(stringExtra, this.mOpportunity);
    }

    private void startInstallPage(Intent intent) {
        if (!TextUtils.isEmpty(this.mOpportunity)) {
            uz3.b("notifyList", this.mOpportunity);
        }
        SchemeRouter.invoke(ar2.c(), getInstallPageUrlScheme());
    }

    public static Intent createIntent(String str, String str2, String str3) {
        Intent intent = new Intent(AppRuntime.getAppContext(), InstallNotifyReceiver.class);
        intent.setAction(str);
        intent.putExtra(KEY_PACKAGE_NAME, str2);
        intent.putExtra(OPPORTUNITY, str3);
        return intent;
    }

    public static String getInstallPageUrlScheme() {
        String a = ar2.n().a();
        if (!TextUtils.isEmpty(a)) {
            if (a.equals(BaiduIdentityManager.VALUE_OSNAME)) {
                return "baiduboxapp://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/download/index?_baiduboxapp=%7B%22from%22%3A%221151005410000000%22%2C%22ext%22%3A%7B%7D%7D";
            }
            if (a.equals("baiduboxlite")) {
                return "baiduboxlite://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/download/index?_baiduboxapp=%7B%22from%22%3A%221151005410000000%22%2C%22ext%22%3A%7B%7D%7D";
            }
            if (a.equals("tiebaclient")) {
                return "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/download/index?_baiduboxapp=%7B%22from%22%3A%221151005410000000%22%2C%22ext%22%3A%7B%7D%7D";
            }
            if (a.equals("baiduhaokan")) {
                return "baiduhaokan://swan?params=%7B%22swanScheme%22%3A%22baiduhaokan%3A%2F%2Fswan%2FT43rINkXjgPfdKNXTuhQER2KdACVdB00%2Fpages%2Fdownload%2Findex%3F_baiduboxapp%3D%257B%2522from%2522%253A%25221151005410000000%2522%252C%2522ext%2522%253A%257B%257D%257D%22%7D";
            }
            if (a.equals("bdnetdisk")) {
                return "bdnetdisk://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/download/index?_baiduboxapp=%7B%22from%22%3A%221151005410000000%22%2C%22ext%22%3A%7B%7D%7D";
            }
        }
        return "";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && !TextUtils.isEmpty(intent.getAction())) {
            this.mOpportunity = intent.getStringExtra(OPPORTUNITY);
            String stringExtra = intent.getStringExtra(KEY_PACKAGE_NAME);
            String action = intent.getAction();
            char c = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -1289150944) {
                if (hashCode != -344997951) {
                    if (hashCode == 1169620469 && action.equals(NOTIFICATION_INSTALL_ACTION_ONE)) {
                        c = 0;
                    }
                } else if (action.equals(NOTIFICATION_INSTALL_ACTION_MULTIPLE)) {
                    c = 1;
                }
            } else if (action.equals(NOTIFICATION_INSTALL_ACTION_ALARM)) {
                c = 2;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        qz3.f().l();
                        qz3.f().n("todayfirst");
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(this.mOpportunity)) {
                    uz3.b("notifyClick", this.mOpportunity);
                }
                startInstallPage(intent);
                return;
            }
            if (!TextUtils.isEmpty(this.mOpportunity) && !TextUtils.isEmpty(stringExtra)) {
                uz3.c("notifyClick", this.mOpportunity, stringExtra);
            }
            startInstall(intent);
        }
    }
}
