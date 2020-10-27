package com.baidu.helios.bridge.multiprocess;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.helios.bridge.a;
import com.baidu.helios.bridge.multiprocess.e;
/* loaded from: classes17.dex */
public abstract class BaseIPCProvider extends ContentProvider {
    private e awM;
    private UriMatcher awN = new UriMatcher(-1);

    private String a(String str) {
        return str + Af();
    }

    private synchronized void a() {
        if (this.awM == null) {
            this.awM = new e.a() { // from class: com.baidu.helios.bridge.multiprocess.BaseIPCProvider.1
                private g e;

                {
                    this.e = new g(BaseIPCProvider.this.getContext().getApplicationContext());
                }

                @Override // com.baidu.helios.bridge.multiprocess.e
                public Bundle a(String str, Bundle bundle) {
                    a.d c = this.e.Ag().c(str, bundle);
                    if (c == null) {
                        return null;
                    }
                    return h.a(c);
                }

                @Override // com.baidu.helios.bridge.multiprocess.e
                public void a(String str, Bundle bundle, final f fVar) {
                    this.e.Ag().a(str, bundle, new a.c<String>() { // from class: com.baidu.helios.bridge.multiprocess.BaseIPCProvider.1.1
                        @Override // com.baidu.helios.bridge.a.c
                        public void a(int i, Exception exc, Bundle bundle2) {
                            try {
                                fVar.a(i, bundle2);
                            } catch (RemoteException e) {
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.helios.bridge.a.c
                        public void a(String str2, Bundle bundle2) {
                            try {
                                fVar.a(str2, bundle2);
                            } catch (RemoteException e) {
                            }
                        }
                    });
                }

                @Override // com.baidu.helios.bridge.multiprocess.e
                public boolean a(String str) {
                    return this.e.Ag().fx(str);
                }
            };
        }
    }

    public abstract String Af();

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        Log.i("Helios", "provider call");
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle2 = new Bundle();
            char c = 65535;
            switch (str.hashCode()) {
                case -1722610639:
                    if (str.equals("_method_get_bridge")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    a();
                    h.a(bundle2, this.awM.asBinder());
                    return bundle2;
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.awN.addURI(a(getContext().getPackageName()), "ipc/method/get_bridge", 0);
        Log.i("Helios", "provider onCreate");
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int match = this.awN.match(uri);
        Log.i("Helios", "provider query, code = " + match);
        switch (match) {
            case 0:
                a();
                Bundle bundle = new Bundle();
                h.a(bundle, this.awM.asBinder());
                return new d(bundle);
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
