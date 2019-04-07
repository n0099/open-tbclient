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
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.l;
import com.baidu.swan.apps.an.p;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.v.b.c;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static void d(Context context, final com.baidu.swan.apps.v.b.b bVar) {
        Uri hM;
        if (!TextUtils.isEmpty(bVar.axH) && (hM = aa.hM(bVar.axH)) != null) {
            q(bVar);
            final c cVar = new c();
            cVar.mAppId = bVar.mAppId;
            cVar.mFrom = bVar.axJ;
            cVar.axW = bVar.axW;
            cVar.axL = bVar.axL;
            cVar.axU = bVar.axU;
            cVar.axV = bVar.axV;
            cVar.axZ = bVar.axZ;
            cVar.aya = bVar.aya;
            cVar.ayh = bVar.orientation;
            cVar.axK = c.d(bVar.mAppId, bVar.axJ, bVar.aya);
            if (l.i(hM)) {
                a(context, bVar, cVar, l.b(hM, context));
            } else {
                com.baidu.swan.apps.core.a.b.a(bVar.axH, new l.a() { // from class: com.baidu.swan.apps.ah.a.1
                    @Override // com.baidu.swan.apps.an.l.a
                    public void d(String str, Bitmap bitmap) {
                        if (com.baidu.swan.apps.ae.b.IV() != null) {
                            a.a(com.baidu.swan.apps.ae.b.IV().getActivity(), com.baidu.swan.apps.v.b.b.this, cVar, bitmap);
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
            if (com.baidu.swan.apps.an.a.LM()) {
                a(context, bVar.mAppId, bVar.axG, bitmap, c.c(context, cVar));
            } else {
                context.sendBroadcast(a(bVar.axG, bitmap, c.c(context, cVar)));
            }
            cd(context);
        }
    }

    private static void q(com.baidu.swan.apps.v.b.b bVar) {
        bVar.axL = null;
        bVar.axJ = "1230000000000000";
    }

    private static void cd(Context context) {
        if (!(context instanceof Activity)) {
            if (DEBUG) {
                throw new IllegalArgumentException("context must be activity.");
            }
            return;
        }
        e.a aVar = new e.a(context);
        e zq = aVar.zq();
        aVar.cm(a.h.aiapps_add_shortcut_note_dialog_title).a(a(context, zq)).Iq().b(a.h.aiapps_add_shortcut_note_dialog_button, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.ah.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).bS(com.baidu.swan.apps.u.a.CR().Dq()).a(new com.baidu.swan.apps.view.b.a());
        zq.setCancelable(false);
        zq.show();
    }

    private static SpannableStringBuilder a(final Context context, final e eVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = context.getString(a.h.aiapps_add_shortcut_note_dialog_content);
        String string2 = context.getString(a.h.aiapps_add_shortcut_permission_setting);
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
        d.l(context, a.h.aiapps_shortcut_not_supported_text).II();
    }
}
