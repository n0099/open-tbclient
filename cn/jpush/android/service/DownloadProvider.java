package cn.jpush.android.service;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
/* loaded from: classes3.dex */
public class DownloadProvider extends ContentProvider {
    private static final String TAG = "DownloadProvider";

    private void init() {
        try {
            if (cn.jiguang.d.a.d(getContext().getApplicationContext())) {
                cn.jiguang.api.e.register(getContext());
            }
        } catch (Throwable th) {
        }
    }

    private void report(int i, boolean z, Uri uri) {
        if (cn.jiguang.d.i.c.a(getContext())) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (uri != null) {
                try {
                    str = uri.getQueryParameter(EmotionDetailActivityConfig.EMOTION_FROM_PACKAGE);
                    str2 = uri.getQueryParameter("from_uid");
                    str3 = uri.getQueryParameter("awake_sequence");
                } catch (Throwable th) {
                    return;
                }
            }
            cn.jiguang.d.i.f.cj().ck().a(getContext(), i, z, str, str2, str3);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        init();
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        init();
        return cn.jiguang.d.f.a.ce().a(getContext(), uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        init();
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        report(4, cn.jiguang.d.a.i, uri);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        init();
        return 0;
    }
}
