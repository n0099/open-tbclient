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
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.l;
import com.baidu.swan.apps.an.p;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.v.b.b;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = c.DEBUG;

    public static void d(Context context, final b bVar) {
        Uri hL;
        if (!TextUtils.isEmpty(bVar.axD) && (hL = aa.hL(bVar.axD)) != null) {
            q(bVar);
            final com.baidu.swan.apps.v.b.c cVar = new com.baidu.swan.apps.v.b.c();
            cVar.mAppId = bVar.mAppId;
            cVar.mFrom = bVar.axF;
            cVar.axS = bVar.axS;
            cVar.axH = bVar.axH;
            cVar.axQ = bVar.axQ;
            cVar.axR = bVar.axR;
            cVar.axV = bVar.axV;
            cVar.axW = bVar.axW;
            cVar.ayd = bVar.orientation;
            cVar.axG = com.baidu.swan.apps.v.b.c.d(bVar.mAppId, bVar.axF, bVar.axW);
            if (l.i(hL)) {
                a(context, bVar, cVar, l.b(hL, context));
            } else {
                com.baidu.swan.apps.core.a.b.a(bVar.axD, new l.a() { // from class: com.baidu.swan.apps.ah.a.1
                    @Override // com.baidu.swan.apps.an.l.a
                    public void d(String str, Bitmap bitmap) {
                        if (com.baidu.swan.apps.ae.b.IX() != null) {
                            a.a(com.baidu.swan.apps.ae.b.IX().getActivity(), b.this, cVar, bitmap);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, b bVar, com.baidu.swan.apps.v.b.c cVar, Bitmap bitmap) {
        if (context != null) {
            if (bitmap == null) {
                Toast.makeText(context, b.h.aiapps_common_emptyview_detail_text, 0).show();
                return;
            }
            if (com.baidu.swan.apps.an.a.LO()) {
                a(context, bVar.mAppId, bVar.axC, bitmap, com.baidu.swan.apps.v.b.c.c(context, cVar));
            } else {
                context.sendBroadcast(a(bVar.axC, bitmap, com.baidu.swan.apps.v.b.c.c(context, cVar)));
            }
            cd(context);
        }
    }

    private static void q(com.baidu.swan.apps.v.b.b bVar) {
        bVar.axH = null;
        bVar.axF = "1230000000000000";
    }

    private static void cd(Context context) {
        if (!(context instanceof Activity)) {
            if (DEBUG) {
                throw new IllegalArgumentException("context must be activity.");
            }
            return;
        }
        e.a aVar = new e.a(context);
        e zr = aVar.zr();
        aVar.cn(b.h.aiapps_add_shortcut_note_dialog_title).a(a(context, zr)).Is().b(b.h.aiapps_add_shortcut_note_dialog_button, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.ah.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).bS(com.baidu.swan.apps.u.a.CT().Ds()).a(new com.baidu.swan.apps.view.b.a());
        zr.setCancelable(false);
        zr.show();
    }

    private static SpannableStringBuilder a(final Context context, final e eVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = context.getString(b.h.aiapps_add_shortcut_note_dialog_content);
        String string2 = context.getString(b.h.aiapps_add_shortcut_permission_setting);
        int indexOf = string.indexOf(string2);
        int length = string2.length() + indexOf;
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.baidu.swan.apps.ah.a.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                e.this.dismiss();
                p.cf(context);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, indexOf, length, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(b.c.aiapps_go_permission_color)), indexOf, length, 33);
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
        d.l(context, b.h.aiapps_shortcut_not_supported_text).IK();
    }
}
