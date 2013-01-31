package com.baidu.browser.explorer.share;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.baidu.browser.core.util.BdLog;
import com.baidu.browser.explorer.share.BdTinyUrlGenerator;
/* loaded from: classes.dex */
public class BdSharer {
    public static final long IMAGE_MIN_SIZE_TO_SHARE = 10240;
    public static final int SHARE_RERQUEST_CODE_DEFAULT = 1996;
    public static final int SHARE_RERQUEST_CODE_DOWNLOAD = 1998;
    public static final int SHARE_RERQUEST_CODE_SCREENSHOT = 1997;
    public static final int SHARE_RERQUEST_CODE_WEB = 1999;
    private static final int SHARE_TEXT_SIZE_LIMIT = 140;
    private static boolean sendOk;
    private static BdWaitingDialog waitProgressDialog;
    private static BdWaitingDialog waitTinyUrlDialog;
    private static boolean willCancelShare = false;
    private static Object cancelLock = new Object();

    public static boolean sendTextShare(Context context, String str, String str2) {
        return sendTextShare(context, context.getResources().getIdentifier("browser_share_content", "string", context.getPackageName()), str, str2);
    }

    public static boolean sendTextShare(final Context context, final int i, final String str, String str2) {
        BdLog.d(String.valueOf(str) + ", " + str2);
        final BdSharerOM bdSharerOM = new BdSharerOM();
        bdSharerOM.setContentType(1);
        waitTinyUrlDialog = new BdWaitingDialog(context);
        waitTinyUrlDialog.setMessage(context.getString(context.getResources().getIdentifier("browser_share_waiting", "string", context.getPackageName())));
        waitTinyUrlDialog.setCancelable(true);
        waitTinyUrlDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.browser.explorer.share.BdSharer.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                BdSharer.willCancelShare = true;
            }
        });
        waitTinyUrlDialog.show();
        willCancelShare = false;
        BdTinyUrlGenerator bdTinyUrlGenerator = new BdTinyUrlGenerator();
        bdTinyUrlGenerator.setEventListener(new BdTinyUrlGenerator.BdTinyUrlRecievedListener() { // from class: com.baidu.browser.explorer.share.BdSharer.2
            @Override // com.baidu.browser.explorer.share.BdTinyUrlGenerator.BdTinyUrlRecievedListener
            public void onTinyUrlRecieved(String str3) {
                String str4 = str;
                if (str == null) {
                    str4 = "";
                }
                String str5 = str3 == null ? "" : str3;
                if (!"".equals(str4) && "".equals(str5)) {
                    str4 = str;
                }
                BdLog.d(String.valueOf(str4) + ", " + str5);
                bdSharerOM.setContent(context.getString(i, str4, str5));
                bdSharerOM.setExtra1(str);
                bdSharerOM.setExtra2(str3);
                bdSharerOM.setContent(BdSharer.preProcContent(context, bdSharerOM));
                if (!BdSharer.willCancelShare) {
                    BdSharer.sendOk = BdSharer.sendShare(context, bdSharerOM, false, BdSharer.SHARE_RERQUEST_CODE_DEFAULT, false);
                }
                if (BdSharer.waitTinyUrlDialog != null) {
                    BdSharer.waitTinyUrlDialog.cancel();
                    BdSharer.waitTinyUrlDialog = null;
                }
            }
        });
        bdTinyUrlGenerator.generate(str2);
        return sendOk;
    }

    public static boolean sendShare(Context context, BdSharerOM bdSharerOM, boolean z, int i, boolean z2) {
        if (bdSharerOM == null || bdSharerOM.getContent() == null) {
            BdLog.e("shareContentMeta is null.");
            return false;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", bdSharerOM.getContent());
        BdLog.d(bdSharerOM.getContent());
        if (bdSharerOM.getContentType() == 1) {
            intent.setType("text/plain");
        }
        Intent createChooser = Intent.createChooser(intent, context.getString(context.getResources().getIdentifier("browser_share_channel", "string", context.getPackageName())));
        try {
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(createChooser, i);
                return true;
            }
            return true;
        } catch (ActivityNotFoundException e) {
            BdLog.e("share app not found.", e);
            return false;
        } catch (Exception e2) {
            BdLog.e("share exception.", e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String preProcContent(Context context, BdSharerOM bdSharerOM) {
        String content = bdSharerOM.getContent();
        if (content.length() > SHARE_TEXT_SIZE_LIMIT) {
            String string = context.getString(context.getResources().getIdentifier("browser_share_content", "string", context.getPackageName()), "...", bdSharerOM.getExtra2());
            if (string.length() > SHARE_TEXT_SIZE_LIMIT) {
                String string2 = context.getString(context.getResources().getIdentifier("browser_share_content", "string", context.getPackageName()), bdSharerOM.getExtra1(), "");
                if (string2.length() > SHARE_TEXT_SIZE_LIMIT) {
                    return String.valueOf(string2.substring(0, 140 - "...".length())) + "...";
                }
                return string2;
            }
            return string;
        }
        return content;
    }

    public static void showShareWaitDialog(Context context) {
        if (waitProgressDialog == null) {
            waitProgressDialog = new BdWaitingDialog(context);
            waitProgressDialog.setMessage(context.getResources().getIdentifier("browser_share_waiting", "string", context.getPackageName()));
            waitProgressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.browser.explorer.share.BdSharer.3
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i == 4) {
                        return BdSharer.cancelShare();
                    }
                    return false;
                }
            });
        }
        waitProgressDialog.show();
    }

    public static boolean cancelShare() {
        if (waitProgressDialog.isShowing()) {
            waitProgressDialog.dismiss();
            waitProgressDialog = null;
            return true;
        }
        return false;
    }

    public static BdWaitingDialog getWaitProgressDialog() {
        return waitProgressDialog;
    }

    public static BdWaitingDialog getWaitTinyUrlDialog() {
        return waitTinyUrlDialog;
    }

    public static boolean dismissWatiTinyUrlDialog() {
        if (waitTinyUrlDialog != null) {
            waitTinyUrlDialog.cancel();
            waitTinyUrlDialog.dismiss();
            waitTinyUrlDialog = null;
            return true;
        }
        return false;
    }

    public static void setWaitProgressDialog(BdWaitingDialog bdWaitingDialog) {
        waitProgressDialog = bdWaitingDialog;
    }

    public static Object getCancelLock() {
        return cancelLock;
    }
}
