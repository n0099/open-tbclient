package com.baidu.searchbox.ng.ai.apps.shortcut;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.data.AiAppsSpHelper;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchParams;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchType;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.util.AiAppAPIUtils;
import com.baidu.searchbox.ng.ai.apps.view.decorate.AiAppsDialogDecorate;
/* loaded from: classes2.dex */
public final class AiAppsShortcutHelper {
    private static final boolean DEBUG = false;
    private static final String INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final String INTENT_DUPLICATE_KEY = "duplicate";
    private static final String PREF_ADDED_SHORTCUT_KEY = "aiapps_added_shortcut_key";
    private static final String TAG = "AiAppsShortcutHelper";

    public static void addShortcut(Context context, AiAppsLaunchInfo aiAppsLaunchInfo) {
        adjustLaunchInfo(aiAppsLaunchInfo);
        AiAppsLaunchParams aiAppsLaunchParams = new AiAppsLaunchParams();
        aiAppsLaunchParams.mAppId = aiAppsLaunchInfo.mAppId;
        aiAppsLaunchParams.mFrom = aiAppsLaunchInfo.mLaunchFrom;
        aiAppsLaunchParams.mNotInHistory = aiAppsLaunchInfo.mNotInHistory;
        aiAppsLaunchParams.mPage = aiAppsLaunchInfo.mPage;
        aiAppsLaunchParams.mClickId = aiAppsLaunchInfo.mClickId;
        aiAppsLaunchParams.mIsDebug = aiAppsLaunchInfo.mIsDebug;
        aiAppsLaunchParams.mTargetSwanVersion = aiAppsLaunchInfo.mTargetSwanVersion;
        aiAppsLaunchParams.mLaunchScheme = AiAppsLaunchParams.getDefaultScheme(aiAppsLaunchInfo.mAppId, aiAppsLaunchInfo.mLaunchFrom);
        if (AiAppAPIUtils.hasOreo()) {
            requestPinShortcut(context, aiAppsLaunchInfo.mAppId, aiAppsLaunchInfo.mAppTitle, aiAppsLaunchInfo.mAppIcon, AiAppsLaunchParams.createLaunchParamsIntent(context, aiAppsLaunchParams));
        } else {
            context.sendBroadcast(createAddToHomeIntent(aiAppsLaunchInfo.mAppTitle, aiAppsLaunchInfo.mAppIcon, AiAppsLaunchParams.createLaunchParamsIntent(context, aiAppsLaunchParams)));
        }
        if (!isAddedShortcutOnce()) {
            markAddedShortcutFlag();
            showAddedNoteDialog(context);
        }
    }

    private static void adjustLaunchInfo(AiAppsLaunchInfo aiAppsLaunchInfo) {
        aiAppsLaunchInfo.mPage = null;
        aiAppsLaunchInfo.mLaunchFrom = AiAppsLaunchType.LAUNCH_FROM_SHORTCUT;
    }

    private static boolean isAddedShortcutOnce() {
        return AiAppsSpHelper.getsInstance().getBoolean(PREF_ADDED_SHORTCUT_KEY, false);
    }

    private static void markAddedShortcutFlag() {
        AiAppsSpHelper.getsInstance().putBoolean(PREF_ADDED_SHORTCUT_KEY, true);
    }

    private static void showAddedNoteDialog(Context context) {
        if (context instanceof Activity) {
            new AiAppAlertDialog.Builder(context).setCancelable(false).setTitle(R.string.aiapps_add_shortcut_note_dialog_title).setMessage(R.string.aiapps_add_shortcut_note_dialog_content).setPositiveButton(R.string.aiapps_add_shortcut_note_dialog_button, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.shortcut.AiAppsShortcutHelper.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setDecorate(new AiAppsDialogDecorate()).show();
        }
    }

    private static Intent createAddToHomeIntent(String str, Bitmap bitmap, Intent intent) {
        Intent intent2 = new Intent(INSTALL_SHORTCUT);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        intent2.putExtra(INTENT_DUPLICATE_KEY, false);
        return intent2;
    }

    @TargetApi(26)
    private static void requestPinShortcut(Context context, String str, String str2, Bitmap bitmap, Intent intent) {
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager.isRequestPinShortcutSupported()) {
            try {
                shortcutManager.requestPinShortcut(new ShortcutInfo.Builder(context, str).setShortLabel(str2).setLongLabel(str2).setIcon(Icon.createWithBitmap(bitmap)).setIntent(intent).build(), null);
                return;
            } catch (IllegalStateException e) {
                return;
            }
        }
        UniversalToast.makeText(context, R.string.aiapps_shortcut_not_supported_text).showToast();
    }
}
