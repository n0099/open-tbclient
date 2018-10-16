package com.baidu.searchbox.ng.ai.apps.console;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.view.decorate.AiAppsDialogDecorate;
/* loaded from: classes2.dex */
public class ConsoleController {
    private static boolean sConsoleSwitch;

    public static void switchConsole(Context context, boolean z) {
        if (AiApp.get() != null) {
            ConsolePrefsIPCWrapper.saveConsoleSwitch(z);
            new AiAppAlertDialog.Builder(context).setTitle(context.getString(R.string.aiapps_debug_switch_title)).setMessage(context.getString(z ? R.string.aiapps_open_debug : R.string.aiapps_close_debug)).setDecorate(new AiAppsDialogDecorate()).setCancelable(false).setPositiveButton(R.string.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.console.ConsoleController.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.exit(0);
                }
            }).show();
        }
    }

    public static void toggleConsole(Context context) {
        switchConsole(context, !isConsoleEnabled());
    }

    public static boolean isConsoleEnabled() {
        return sConsoleSwitch;
    }

    public static void setConsoleEnabled(boolean z) {
        sConsoleSwitch = z;
    }
}
