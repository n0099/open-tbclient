package com.baidu.swan.apps.aj;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.aq.s;
import com.baidu.swan.apps.aq.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.f.c;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.u.c.c;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    /* renamed from: com.baidu.swan.apps.aj.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0293a {
        void hl(int i);
    }

    public static void a(Context context, com.baidu.swan.apps.u.c.b bVar) {
        a(context, bVar, (InterfaceC0293a) null);
    }

    public static void a(Context context, final com.baidu.swan.apps.u.c.b bVar, final InterfaceC0293a interfaceC0293a) {
        Uri uri;
        String iconUrl = bVar.getIconUrl();
        if (!TextUtils.isEmpty(iconUrl) && (uri = al.getUri(iconUrl)) != null) {
            m(bVar);
            final c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().lE(bVar.getAppId())).lH(bVar.ajg())).lL(bVar.ajo())).lJ(bVar.getPage())).lK(bVar.ajn())).em(bVar.isDebug())).lM(bVar.ajr())).fY(bVar.getAppFrameType())).fX(bVar.getOrientation())).lI(c.c(bVar.getAppId(), bVar.ajg(), bVar.getAppFrameType()));
            if (s.i(uri)) {
                a(context, bVar, aVar, s.b(uri, context));
                b(context, bVar, interfaceC0293a);
                return;
            }
            com.baidu.swan.apps.core.pms.f.c.a(iconUrl, aVar.getAppFrameType(), new c.a() { // from class: com.baidu.swan.apps.aj.a.1
                @Override // com.baidu.swan.apps.core.pms.f.c.a
                public void k(Bitmap bitmap) {
                    if (e.arv() != null) {
                        SwanAppActivity arp = d.arr().arp();
                        a.a(arp, com.baidu.swan.apps.u.c.b.this, aVar, bitmap);
                        a.b(arp, com.baidu.swan.apps.u.c.b.this, interfaceC0293a);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.u.c.c cVar, Bitmap bitmap) {
        if (context != null) {
            if (bitmap == null) {
                Toast.makeText(context, a.h.aiapps_common_emptyview_detail_text, 0).show();
                return;
            }
            if (com.baidu.swan.apps.aq.c.hasOreo()) {
                a(context, bVar.getAppId(), bVar.aee(), bitmap, com.baidu.swan.apps.u.c.c.a(context, cVar));
            } else {
                context.sendBroadcast(a(bVar.aee(), bitmap, com.baidu.swan.apps.u.c.c.a(context, cVar)));
            }
            cn(context);
        }
    }

    private static void m(com.baidu.swan.apps.u.c.b bVar) {
        bVar.lJ(null);
        bVar.lH("1230000000000000");
    }

    private static void cn(Context context) {
        if (!(context instanceof Activity)) {
            if (DEBUG) {
                throw new IllegalArgumentException("context must be activity.");
            }
            return;
        }
        g.a aVar = new g.a(context);
        aVar.a(new com.baidu.swan.apps.view.c.a());
        g abN = aVar.abN();
        aVar.fi(a.h.aiapps_add_shortcut_note_dialog_title).a(a(context, abN)).ara().e(a.h.aiapps_add_shortcut_note_dialog_button, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.aj.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).fi(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState()).aqZ();
        abN.setCancelable(false);
        abN.show();
    }

    private static SpannableStringBuilder a(final Context context, final g gVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = context.getString(a.h.aiapps_add_shortcut_note_dialog_content);
        String string2 = context.getString(a.h.aiapps_add_shortcut_permission_setting);
        int indexOf = string.indexOf(string2);
        int length = string2.length() + indexOf;
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.baidu.swan.apps.aj.a.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                g.this.dismiss();
                x.cr(context);
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
        com.baidu.swan.apps.res.widget.b.d.k(context, a.h.aiapps_shortcut_not_supported_text).showToast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, final com.baidu.swan.apps.u.c.b bVar, final InterfaceC0293a interfaceC0293a) {
        if (interfaceC0293a != null) {
            if (context == null) {
                interfaceC0293a.hl(-1);
            } else {
                p.a(new Runnable() { // from class: com.baidu.swan.apps.aj.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        InterfaceC0293a.this.hl(a.o(context, bVar.aee(), bVar.getAppId()));
                    }
                }, "SwanAppShortcutHelper", 1000L, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [377=5] */
    public static int o(@NonNull Context context, String str, String str2) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(String.format("content://%s/favorites?notify=true", co(context))), new String[]{"title", "intent"}, "title = ?", new String[]{str}, null);
            while (query != null && query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("intent"));
                if (string != null && string.contains(str2)) {
                    if (query != null) {
                        if (0 != 0) {
                            query.close();
                        } else {
                            query.close();
                        }
                    }
                    return 1;
                }
            }
            if (query != null) {
                if (0 != 0) {
                    query.close();
                } else {
                    query.close();
                }
            }
            return 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("SwanAppShortcutHelper", "fail: " + e);
            }
            return -1;
        }
    }

    @NonNull
    private static String co(Context context) {
        List<ProviderInfo> queryContentProviders;
        String[] split;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null || resolveActivity.activityInfo == null || "android".equals(resolveActivity.activityInfo.packageName) || (queryContentProviders = context.getPackageManager().queryContentProviders(resolveActivity.activityInfo.processName, resolveActivity.activityInfo.applicationInfo.uid, 65536)) == null) {
            return "com.android.launcher3.settings";
        }
        for (ProviderInfo providerInfo : queryContentProviders) {
            if (!TextUtils.isEmpty(providerInfo.authority) && !TextUtils.isEmpty(providerInfo.readPermission) && Pattern.matches(".*launcher.*permission\\.READ_SETTINGS", providerInfo.readPermission)) {
                for (String str : providerInfo.authority.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
                    if (str != null && str.endsWith(".settings")) {
                        return str;
                    }
                }
                continue;
            }
        }
        return "com.android.launcher3.settings";
    }
}
