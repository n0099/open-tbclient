package com.baidu.swan.apps.ah;

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
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.a.h;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.s;
import com.baidu.swan.apps.ao.y;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.f.c;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.u.c.c;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    /* renamed from: com.baidu.swan.apps.ah.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0361a {
        void jt(int i);
    }

    public static void a(Context context, com.baidu.swan.apps.u.c.b bVar) {
        a(context, bVar, (InterfaceC0361a) null);
    }

    public static void a(Context context, com.baidu.swan.apps.u.c.b bVar, InterfaceC0361a interfaceC0361a) {
        a(context, bVar, 0, interfaceC0361a);
    }

    public static void a(Context context, final com.baidu.swan.apps.u.c.b bVar, final int i, final InterfaceC0361a interfaceC0361a) {
        Uri uc;
        String iconUrl = bVar.getIconUrl();
        if (!TextUtils.isEmpty(iconUrl) && (uc = ak.uc(iconUrl)) != null) {
            m(bVar);
            final c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().oY(bVar.getAppId())).pb(bVar.azd())).pf(bVar.azl())).pd(bVar.getPage())).pe(bVar.azk())).fU(bVar.isDebug())).pg(bVar.azo())).hR(bVar.getAppFrameType())).hQ(bVar.getOrientation())).pc(c.i(bVar.getAppId(), bVar.azd(), bVar.getAppFrameType()));
            if (s.k(uc)) {
                a(context, bVar, aVar, s.b(uc, context), i);
                b(context, bVar, interfaceC0361a);
                return;
            }
            com.baidu.swan.apps.core.pms.f.c.a(iconUrl, aVar.getAppFrameType(), new c.a() { // from class: com.baidu.swan.apps.ah.a.1
                @Override // com.baidu.swan.apps.core.pms.f.c.a
                public void k(Bitmap bitmap) {
                    if (e.aIN() != null) {
                        SwanAppActivity aIH = d.aIJ().aIH();
                        a.a(aIH, com.baidu.swan.apps.u.c.b.this, aVar, bitmap, i);
                        a.b(aIH, com.baidu.swan.apps.u.c.b.this, interfaceC0361a);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final Context context, final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.u.c.c cVar, final Bitmap bitmap, final int i) {
        if (context != null) {
            if (bitmap == null) {
                Toast.makeText(context, a.h.aiapps_common_emptyview_detail_text, 0).show();
            } else if (e.aIO() != null) {
                final b.a aIR = e.aIO().aIR();
                ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.ah.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        h aye = com.baidu.swan.apps.t.a.aye();
                        String ayV = com.baidu.swan.apps.u.c.b.this.ayV();
                        if (!TextUtils.isEmpty(ayV) && aye.U(context, ayV)) {
                            a.sE("click");
                            if (aye.V(context, ayV)) {
                                if (i != 1) {
                                    a.dq(context);
                                    return;
                                }
                                return;
                            } else if (aye.W(context, ayV)) {
                                a.sE("show");
                                if (i != 1) {
                                    a.dq(context);
                                    return;
                                }
                                return;
                            }
                        }
                        if (com.baidu.swan.apps.ao.c.hasOreo()) {
                            a.a(context, bVar.getAppId(), bVar.atf(), bitmap, com.baidu.swan.apps.u.c.c.a(context, cVar));
                        } else {
                            context.sendBroadcast(a.a(bVar.atf(), bitmap, com.baidu.swan.apps.u.c.c.a(context, cVar)));
                        }
                        if (i != 1) {
                            a.dq(context);
                        }
                    }
                }, "add quick app shortcut", 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sE(String str) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mAppId = d.aIJ().getAppId();
        eVar.mType = str;
        eVar.mFrom = com.baidu.swan.apps.statistic.h.jv(d.aIJ().getFrameType());
        if (e.aIO() != null && e.aIO().aIR() != null) {
            eVar.mSource = e.aIO().aIR().azd();
        }
        com.baidu.swan.apps.statistic.h.a("1591", eVar);
    }

    private static void m(com.baidu.swan.apps.u.c.b bVar) {
        bVar.pd(null);
        bVar.pb("1230000000000000");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dq(final Context context) {
        if (!(context instanceof Activity)) {
            if (DEBUG) {
                throw new IllegalArgumentException("context must be activity.");
            }
            return;
        }
        ak.j(new Runnable() { // from class: com.baidu.swan.apps.ah.a.3
            @Override // java.lang.Runnable
            public void run() {
                g.a aVar = new g.a(context);
                aVar.a(new com.baidu.swan.apps.view.c.a());
                g aqn = aVar.aqn();
                aVar.gS(a.h.aiapps_add_shortcut_note_dialog_title).a(a.a(context, aqn)).aHW().e(a.h.aiapps_add_shortcut_note_dialog_button, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.ah.a.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).gU(com.baidu.swan.apps.t.a.axv().ail()).aHV();
                aqn.setCancelable(false);
                aqn.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SpannableStringBuilder a(final Context context, final g gVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = context.getString(a.h.aiapps_add_shortcut_note_dialog_content);
        String string2 = context.getString(a.h.aiapps_add_shortcut_permission_setting);
        int indexOf = string.indexOf(string2);
        int length = string2.length() + indexOf;
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.baidu.swan.apps.ah.a.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                g.this.dismiss();
                y.dw(context);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, indexOf, length, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(a.c.aiapps_go_permission_color)), indexOf, length, 33);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent a(String str, Bitmap bitmap, Intent intent) {
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        intent2.putExtra("duplicate", false);
        return intent2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(26)
    public static void a(Context context, String str, String str2, Bitmap bitmap, Intent intent) {
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
        com.baidu.swan.apps.res.widget.b.d.u(context, a.h.aiapps_shortcut_not_supported_text).aIv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, final com.baidu.swan.apps.u.c.b bVar, final InterfaceC0361a interfaceC0361a) {
        if (interfaceC0361a != null) {
            if (context == null) {
                interfaceC0361a.jt(-1);
            } else {
                p.a(new Runnable() { // from class: com.baidu.swan.apps.ah.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        InterfaceC0361a.this.jt(a.r(context, bVar.atf(), bVar.getAppId()));
                    }
                }, "SwanAppShortcutHelper", 1000L, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [458=5] */
    public static int r(@NonNull Context context, String str, String str2) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(String.format("content://%s/favorites?notify=true", dr(context))), new String[]{"title", "intent"}, "title = ?", new String[]{str}, null);
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
    private static String dr(Context context) {
        List<ProviderInfo> queryContentProviders;
        String[] split;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null || resolveActivity.activityInfo == null || HttpConstants.OS_TYPE_VALUE.equals(resolveActivity.activityInfo.packageName) || (queryContentProviders = context.getPackageManager().queryContentProviders(resolveActivity.activityInfo.processName, resolveActivity.activityInfo.applicationInfo.uid, 65536)) == null) {
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
