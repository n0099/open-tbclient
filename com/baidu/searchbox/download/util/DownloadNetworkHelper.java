package com.baidu.searchbox.download.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.unified.DialogClickCallback;
import com.baidu.tieba.R;
import java.util.HashSet;
/* loaded from: classes3.dex */
public final class DownloadNetworkHelper {
    public static final String APPSEARCH_DOWNLOAD_RESUME_IDS_KEY = "appsearch_download_resume_ids";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "DownloadNetworkHelper";

    /* loaded from: classes3.dex */
    public interface DownloadNetworkDialogListener {
        void callback();
    }

    public static void checkNetwork(Context context, final String str, final DownloadNetworkDialogListener downloadNetworkDialogListener) {
        final Activity topActivity;
        if (context != null && (context instanceof Activity)) {
            topActivity = (Activity) context;
        } else {
            topActivity = BdBoxActivityManager.getTopActivity();
        }
        if (topActivity != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) topActivity.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                new BoxAlertDialog.Builder(topActivity).setTitle(R.string.obfuscated_res_0x7f0f0607).setMessage(R.string.obfuscated_res_0x7f0f0606).setPositiveButton(R.string.obfuscated_res_0x7f0f0605, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.download.util.DownloadNetworkHelper.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!TextUtils.isEmpty(str)) {
                            DuplicateHelper.checkDuplicateDownload(topActivity, new DuplicateDownloadCallback(str) { // from class: com.baidu.searchbox.download.util.DownloadNetworkHelper.4.1
                                @Override // com.baidu.searchbox.download.util.DuplicateDownloadCallback
                                public void onDuplicate() {
                                }

                                @Override // com.baidu.searchbox.download.util.DuplicateDownloadCallback
                                public void onNotDuplicate() {
                                    DownloadNetworkDialogListener downloadNetworkDialogListener2 = downloadNetworkDialogListener;
                                    if (downloadNetworkDialogListener2 != null) {
                                        downloadNetworkDialogListener2.callback();
                                    }
                                }
                            });
                        } else {
                            DownloadNetworkDialogListener downloadNetworkDialogListener2 = downloadNetworkDialogListener;
                            if (downloadNetworkDialogListener2 != null) {
                                downloadNetworkDialogListener2.callback();
                            }
                        }
                        DownloadStatisticUtil.ubc("tool", "click", "network_change", "", "download", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
                    }
                }).setNegativeButton(BoxAlertDialog.Builder.DIALOG_NEGATIVE_TEXT_CANCEL, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.download.util.DownloadNetworkHelper.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DownloadStatisticUtil.ubc("tool", "click", "network_change", "", "close", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
                    }
                }).show(true);
                DownloadStatisticUtil.ubc("tool", "show", "network_change", "", "", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
            } else if (downloadNetworkDialogListener != null) {
                if (!TextUtils.isEmpty(str)) {
                    DuplicateHelper.checkDuplicateDownload(topActivity, new DuplicateDownloadCallback(str) { // from class: com.baidu.searchbox.download.util.DownloadNetworkHelper.5
                        @Override // com.baidu.searchbox.download.util.DuplicateDownloadCallback
                        public void onDuplicate() {
                        }

                        @Override // com.baidu.searchbox.download.util.DuplicateDownloadCallback
                        public void onNotDuplicate() {
                            DownloadNetworkDialogListener downloadNetworkDialogListener2 = downloadNetworkDialogListener;
                            if (downloadNetworkDialogListener2 != null) {
                                downloadNetworkDialogListener2.callback();
                            }
                        }
                    });
                } else if (downloadNetworkDialogListener != null) {
                    downloadNetworkDialogListener.callback();
                }
            }
        } else if (downloadNetworkDialogListener != null) {
            downloadNetworkDialogListener.callback();
        }
    }

    public static long[] getResumeDownloadTaskIds() {
        HashSet<String> hashSet = new HashSet(PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getStringSet(APPSEARCH_DOWNLOAD_RESUME_IDS_KEY, new HashSet()));
        if (hashSet.size() > 0) {
            long[] jArr = new long[hashSet.size()];
            int i = 0;
            for (String str : hashSet) {
                try {
                    jArr[i] = Long.parseLong(str);
                    i++;
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            return jArr;
        }
        return null;
    }

    public static void putResumeDownloadTaskIds(long[] jArr) {
        if (jArr != null && jArr.length > 0) {
            HashSet hashSet = new HashSet();
            for (long j : jArr) {
                hashSet.add(String.valueOf(j));
            }
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putStringSet(APPSEARCH_DOWNLOAD_RESUME_IDS_KEY, hashSet).apply();
        }
    }

    public static void showNetworkDialog(Context context, final DialogClickCallback dialogClickCallback) {
        Activity realTopActivity;
        if (context != null && (context instanceof Activity)) {
            realTopActivity = (Activity) context;
        } else {
            realTopActivity = BdBoxActivityManager.getRealTopActivity();
        }
        new BdAlertDialog.Builder(realTopActivity).setTitle(R.string.obfuscated_res_0x7f0f0607).setMessage(R.string.obfuscated_res_0x7f0f0606).setButton(new BdAlertDialog.ButtonItem(realTopActivity.getResources().getString(R.string.obfuscated_res_0x7f0f05cc), new BdAlertDialog.OnItemClickListener() { // from class: com.baidu.searchbox.download.util.DownloadNetworkHelper.2
            @Override // com.baidu.android.ext.widget.dialog.BdAlertDialog.OnItemClickListener
            public void onItemClick(View view2) {
                DialogClickCallback dialogClickCallback2 = DialogClickCallback.this;
                if (dialogClickCallback2 != null) {
                    dialogClickCallback2.callback(false);
                }
                DownloadStatisticUtil.ubc("tool", "click", "network_change", "", "close", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
            }
        })).setButton(new BdAlertDialog.ButtonItem(realTopActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0605), new BdAlertDialog.OnItemClickListener() { // from class: com.baidu.searchbox.download.util.DownloadNetworkHelper.1
            @Override // com.baidu.android.ext.widget.dialog.BdAlertDialog.OnItemClickListener
            public void onItemClick(View view2) {
                DialogClickCallback dialogClickCallback2 = DialogClickCallback.this;
                if (dialogClickCallback2 != null) {
                    dialogClickCallback2.callback(true);
                }
                DownloadStatisticUtil.ubc("tool", "click", "network_change", "", "download", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
            }
        })).create().show();
        DownloadStatisticUtil.ubc("tool", "show", "network_change", "", "", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
    }
}
