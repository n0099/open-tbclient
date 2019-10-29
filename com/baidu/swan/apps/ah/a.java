package com.baidu.swan.apps.ah;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Toast;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.an.r;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.v.b.c;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static void d(Context context, final com.baidu.swan.apps.v.b.b bVar) {
        Uri jb;
        String iconUrl = bVar.getIconUrl();
        if (!TextUtils.isEmpty(iconUrl) && (jb = ac.jb(iconUrl)) != null) {
            q(bVar);
            final c cVar = new c();
            cVar.mAppId = bVar.getAppId();
            cVar.mFrom = bVar.KE();
            cVar.aTj = bVar.KK();
            cVar.aTe = bVar.getPage();
            cVar.aTh = bVar.KJ();
            cVar.aTf = bVar.isDebug();
            cVar.aTk = bVar.KN();
            cVar.aTl = bVar.KO();
            cVar.aTm = bVar.getOrientation();
            cVar.aTi = c.c(bVar.getAppId(), bVar.KE(), bVar.KO());
            if (m.g(jb)) {
                a(context, bVar, cVar, m.b(jb, context));
            } else {
                com.baidu.swan.apps.core.a.b.a(iconUrl, new m.a() { // from class: com.baidu.swan.apps.ah.a.1
                    @Override // com.baidu.swan.apps.an.m.a
                    public void e(String str, Bitmap bitmap) {
                        if (com.baidu.swan.apps.ae.b.QZ() != null) {
                            a.a(com.baidu.swan.apps.ae.b.QZ().getActivity(), com.baidu.swan.apps.v.b.b.this, cVar, bitmap);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, com.baidu.swan.apps.v.b.b bVar, c cVar, Bitmap bitmap) {
        if (context != null) {
            if (bitmap == null) {
                Toast.makeText(context, a.h.aiapps_common_emptyview_detail_text, 0).show();
                return;
            }
            if (com.baidu.swan.apps.an.a.Uc()) {
                a(context, bVar.getAppId(), bVar.Ht(), bitmap, c.c(context, cVar));
            } else {
                context.sendBroadcast(a(bVar.Ht(), bitmap, c.c(context, cVar)));
            }
            bE(context);
        }
    }

    private static void q(com.baidu.swan.apps.v.b.b bVar) {
        bVar.setPage(null);
        bVar.fv("1230000000000000");
    }

    private static void bE(Context context) {
        if (!(context instanceof Activity)) {
            if (DEBUG) {
                throw new IllegalArgumentException("context must be activity.");
            }
            return;
        }
        g.a aVar = new g.a(context);
        g FW = aVar.FW();
        aVar.dj(a.h.aiapps_add_shortcut_note_dialog_title).a(a(context, FW)).Qq().b(a.h.aiapps_add_shortcut_note_dialog_button, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.ah.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).cw(com.baidu.swan.apps.u.a.JD().Kc()).a(new com.baidu.swan.apps.view.b.a());
        FW.setCancelable(false);
        FW.show();
    }

    private static SpannableStringBuilder a(final Context context, final g gVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = context.getString(a.h.aiapps_add_shortcut_note_dialog_content);
        String string2 = context.getString(a.h.aiapps_add_shortcut_permission_setting);
        int indexOf = string.indexOf(string2);
        int length = string2.length() + indexOf;
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.baidu.swan.apps.ah.a.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                g.this.dismiss();
                r.bI(context);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, indexOf, length, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(a.c.aiapps_go_permission_color)), indexOf, length, 33);
        return spannableStringBuilder;
    }

    private static Intent a(String str, Bitmap bitmap, Intent intent) {
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        intent2.putExtra("duplicate", false);
        return intent2;
    }

    @TargetApi(26)
    private static void a(Context context, String str, String str2, Bitmap bitmap, Intent intent) {
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager.isRequestPinShortcutSupported() && bitmap != null) {
            try {
                shortcutManager.requestPinShortcut(new ShortcutInfo.Builder(context, str).setShortLabel(str2).setLongLabel(str2).setIcon(Icon.createWithBitmap(bitmap)).setIntent(intent).build(), null);
                return;
            } catch (IllegalStateException e) {
                if (DEBUG) {
                    throw e;
                }
                return;
            }
        }
        d.i(context, a.h.aiapps_shortcut_not_supported_text).QN();
    }
}
