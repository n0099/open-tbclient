package com.baidu.android.pushservice;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PushInfoProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f36865a;

    /* renamed from: b  reason: collision with root package name */
    public UriMatcher f36866b;

    public PushInfoProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36866b = new UriMatcher(-1);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, uri, str, strArr)) == null) {
            return 0;
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, contentValues)) == null) {
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = getContext();
            this.f36865a = context;
            String str = m.o(context) ? "pushinfo_v3" : "pushinfo";
            if (this.f36866b == null) {
                this.f36866b = new UriMatcher(-1);
            }
            try {
                UriMatcher uriMatcher = this.f36866b;
                uriMatcher.addURI(this.f36865a.getPackageName() + ".bdpush", str, 1);
                UriMatcher uriMatcher2 = this.f36866b;
                uriMatcher2.addURI(this.f36865a.getPackageName() + ".bdpush", "verif", 2);
                UriMatcher uriMatcher3 = this.f36866b;
                uriMatcher3.addURI(this.f36865a.getPackageName() + ".bdpush", "msgInfo", 3);
                UriMatcher uriMatcher4 = this.f36866b;
                uriMatcher4.addURI(this.f36865a.getPackageName() + ".bdpush", "appstatus", 4);
            } catch (Throwable th) {
                new b.c(this.f36865a).a(Log.getStackTraceString(th)).a();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Cursor cursor;
        int match;
        Cursor query;
        SQLiteDatabase a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, uri, strArr, str, strArr2, str2)) == null) {
            synchronized (com.baidu.android.pushservice.c.c.a()) {
                cursor = null;
                try {
                    match = this.f36866b.match(uri);
                } catch (Exception e2) {
                    new b.c(this.f36865a).a(Log.getStackTraceString(e2)).a();
                }
                if (match == 1) {
                    SQLiteDatabase a3 = com.baidu.android.pushservice.c.c.a(this.f36865a);
                    if (a3 != null) {
                        query = a3.query("PushShareInfo", null, null, null, null, null, null);
                    }
                } else if (match == 2) {
                    SQLiteDatabase a4 = com.baidu.android.pushservice.c.c.a(this.f36865a);
                    if (a4 != null) {
                        query = a4.query("PushVerifInfo", strArr, str, strArr2, null, null, str2);
                    }
                } else if (match == 3) {
                    SQLiteDatabase a5 = com.baidu.android.pushservice.c.c.a(this.f36865a);
                    if (a5 != null) {
                        query = a5.query("PushMsgInfos", strArr, str, strArr2, null, null, str2);
                    }
                } else if (match == 4 && (a2 = com.baidu.android.pushservice.c.c.a(this.f36865a)) != null) {
                    query = a2.query("PushAppStatus", strArr, str, strArr2, null, null, str2);
                }
                cursor = query;
            }
            return cursor;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
        if (r12 != null) goto L13;
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        long j2;
        SQLiteDatabase sQLiteDatabase;
        long update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, uri, contentValues, str, strArr)) == null) {
            synchronized (com.baidu.android.pushservice.c.c.a()) {
                Cursor cursor = null;
                j2 = -1;
                try {
                    try {
                        if (this.f36866b.match(uri) != 1) {
                            sQLiteDatabase = null;
                        } else {
                            sQLiteDatabase = com.baidu.android.pushservice.c.c.a(this.f36865a);
                            if (sQLiteDatabase != null) {
                                try {
                                    try {
                                        Cursor query = sQLiteDatabase.query("PushShareInfo", null, null, null, null, null, null);
                                        if (query != null) {
                                            try {
                                                if (query.getCount() != 0) {
                                                    update = sQLiteDatabase.update("PushShareInfo", contentValues, str, null);
                                                    j2 = update;
                                                    cursor = query;
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                                cursor = query;
                                                new b.c(this.f36865a).a(Log.getStackTraceString(e)).a();
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                if (sQLiteDatabase != null) {
                                                    sQLiteDatabase.close();
                                                }
                                                return (int) j2;
                                            } catch (Throwable th) {
                                                th = th;
                                                cursor = query;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                if (sQLiteDatabase != null) {
                                                    sQLiteDatabase.close();
                                                }
                                                throw th;
                                            }
                                        }
                                        update = sQLiteDatabase.insert("PushShareInfo", null, contentValues);
                                        j2 = update;
                                        cursor = query;
                                    } catch (Exception e3) {
                                        e = e3;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } finally {
                    }
                } catch (Exception e4) {
                    e = e4;
                    sQLiteDatabase = null;
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabase = null;
                }
            }
            return (int) j2;
        }
        return invokeLLLL.intValue;
    }
}
