package com.baidu.location.e;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.location.BDLocation;
import com.baidu.location.e.j;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Callable<BDLocation> {
    final /* synthetic */ d PN;
    final /* synthetic */ String[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar, String[] strArr) {
        this.PN = dVar;
        this.a = strArr;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    /* renamed from: nC */
    public BDLocation call() {
        Context context;
        h hVar;
        ProviderInfo providerInfo;
        Context context2;
        Cursor cursor;
        BDLocation bDLocation;
        Context context3;
        Uri bY;
        e eVar;
        Cursor cursor2 = null;
        BDLocation bDLocation2 = new BDLocation();
        if (this.a.length > 0) {
            context = d.c;
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(d.b, 0);
            if (resolveContentProvider == null) {
                hVar = this.PN.Pp;
                String[] nB = hVar.nB();
                providerInfo = resolveContentProvider;
                for (String str : nB) {
                    context2 = d.c;
                    providerInfo = context2.getPackageManager().resolveContentProvider(str, 0);
                    if (providerInfo != null) {
                        break;
                    }
                }
            } else {
                providerInfo = resolveContentProvider;
            }
            if (providerInfo != null) {
                try {
                    context3 = d.c;
                    ContentResolver contentResolver = context3.getContentResolver();
                    bY = d.bY(providerInfo.authority);
                    Cursor query = contentResolver.query(bY, this.a, null, null, null);
                    try {
                        bDLocation = j.f(query);
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e2) {
                        cursor = query;
                        if (cursor != null) {
                            try {
                                cursor.close();
                                bDLocation = bDLocation2;
                            } catch (Exception e3) {
                                bDLocation = bDLocation2;
                            }
                        } else {
                            bDLocation = bDLocation2;
                        }
                        bDLocation2 = bDLocation;
                        if (bDLocation2 != null) {
                            bDLocation2.setLocType(66);
                        }
                        return bDLocation2;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = query;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                bDLocation2 = bDLocation;
            } else {
                j.a aVar = new j.a(this.a);
                try {
                    eVar = this.PN.Pn;
                    cursor2 = eVar.a(aVar);
                    bDLocation2 = j.f(cursor2);
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e6) {
                        }
                    }
                } catch (Exception e7) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e8) {
                        }
                    }
                } catch (Throwable th3) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e9) {
                        }
                    }
                    throw th3;
                }
            }
            if (bDLocation2 != null && bDLocation2.getLocType() != 67) {
                bDLocation2.setLocType(66);
            }
        }
        return bDLocation2;
    }
}
