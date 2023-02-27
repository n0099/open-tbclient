package com.baidu.android.pushservice;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class PushInfoProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public UriMatcher b;

    public PushInfoProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new UriMatcher(-1);
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
            this.a = context;
            String str = Utility.D(context) ? "pushinfo_v3" : "pushinfo";
            if (this.b == null) {
                this.b = new UriMatcher(-1);
            }
            try {
                UriMatcher uriMatcher = this.b;
                uriMatcher.addURI(this.a.getPackageName() + ".bdpush", str, 1);
                UriMatcher uriMatcher2 = this.b;
                uriMatcher2.addURI(this.a.getPackageName() + ".bdpush", "verif", 2);
                UriMatcher uriMatcher3 = this.b;
                uriMatcher3.addURI(this.a.getPackageName() + ".bdpush", "msgInfo", 3);
                UriMatcher uriMatcher4 = this.b;
                uriMatcher4.addURI(this.a.getPackageName() + ".bdpush", "appstatus", 4);
            } catch (Throwable unused) {
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x007e -> B:30:0x007e). Please submit an issue!!! */
    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Cursor cursor;
        int match;
        SQLiteDatabase d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, uri, strArr, str, strArr2, str2)) == null) {
            com.baidu.android.pushservice.t.a.a(getContext()).a(0);
            synchronized (com.baidu.android.pushservice.m.d.b()) {
                try {
                    match = this.b.match(uri);
                } catch (Exception unused) {
                }
                if (match == 1) {
                    SQLiteDatabase d2 = com.baidu.android.pushservice.m.d.d(this.a);
                    if (d2 != null) {
                        cursor = d2.query("PushShareInfo", null, null, null, null, null, null);
                    }
                    cursor = null;
                } else if (match == 2) {
                    SQLiteDatabase d3 = com.baidu.android.pushservice.m.d.d(this.a);
                    if (d3 != null) {
                        cursor = d3.query("PushVerifInfo", strArr, str, strArr2, null, null, str2);
                    }
                    cursor = null;
                } else if (match != 3) {
                    if (match == 4 && (d = com.baidu.android.pushservice.m.d.d(this.a)) != null) {
                        cursor = d.query("PushAppStatus", strArr, str, strArr2, null, null, str2);
                    }
                    cursor = null;
                } else {
                    SQLiteDatabase d4 = com.baidu.android.pushservice.m.d.d(this.a);
                    if (d4 != null) {
                        cursor = d4.query("PushMsgInfos", strArr, str, strArr2, null, null, str2);
                    }
                    cursor = null;
                }
            }
            return cursor;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0078, code lost:
        if (r12 != null) goto L14;
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        long j;
        SQLiteDatabase sQLiteDatabase;
        long update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, uri, contentValues, str, strArr)) == null) {
            com.baidu.android.pushservice.t.a.a(getContext()).a(0);
            synchronized (com.baidu.android.pushservice.m.d.b()) {
                Cursor cursor = null;
                j = -1;
                try {
                    try {
                        if (this.b.match(uri) != 1) {
                            sQLiteDatabase = null;
                        } else {
                            sQLiteDatabase = com.baidu.android.pushservice.m.d.d(this.a);
                            if (sQLiteDatabase != null) {
                                try {
                                    Cursor query = sQLiteDatabase.query("PushShareInfo", null, null, null, null, null, null);
                                    if (query != null) {
                                        try {
                                            if (query.getCount() != 0) {
                                                update = sQLiteDatabase.update("PushShareInfo", contentValues, str, null);
                                                j = update;
                                                cursor = query;
                                            }
                                        } catch (Exception unused) {
                                            cursor = query;
                                            if (cursor != null) {
                                                cursor.close();
                                            }
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
                                    j = update;
                                    cursor = query;
                                } catch (Exception unused2) {
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
                } catch (Exception unused3) {
                    sQLiteDatabase = null;
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabase = null;
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
            return (int) j;
        }
        return invokeLLLL.intValue;
    }
}
