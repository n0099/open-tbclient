package c.a.o0.r;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SyntheticAccessor"})
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f12181a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.o0.r.o f12182b;

    /* renamed from: c.a.o0.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0629a extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public long f12183c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SparseIntArray f12184d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12185e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f12186f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f12187g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f12188h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0629a(a aVar, SparseIntArray sparseIntArray, String str, ArrayList arrayList, boolean z) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseIntArray, str, arrayList, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12188h = aVar;
            this.f12184d = sparseIntArray;
            this.f12185e = str;
            this.f12186f = arrayList;
            this.f12187g = z;
            this.f12183c = System.currentTimeMillis();
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            ArrayList arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                SparseIntArray sparseIntArray = this.f12184d;
                if (sparseIntArray != null && sparseIntArray.size() > 0) {
                    int size = this.f12184d.size();
                    ArrayList arrayList2 = new ArrayList(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList2.add(Integer.valueOf(this.f12184d.keyAt(i2)));
                    }
                    String str = "flowhandle in (" + this.f12188h.t(arrayList2) + SmallTailInfo.EMOTION_SUFFIX;
                    s.a("delete flow table flow count:" + sQLiteDatabase.delete("flow", str, null));
                    s.a("delete flow table event count:" + sQLiteDatabase.delete("event", str, null));
                }
                ArrayList arrayList3 = this.f12186f;
                if (arrayList3 != null && arrayList3.size() > 0) {
                    int delete = sQLiteDatabase.delete("event", "eventid in (" + this.f12188h.t(this.f12186f) + ") AND flowhandle = -1", null);
                    StringBuilder sb = new StringBuilder();
                    sb.append("delete event table event count:");
                    sb.append(delete);
                    s.a(sb.toString());
                }
                SparseIntArray sparseIntArray2 = this.f12184d;
                if ((sparseIntArray2 != null && sparseIntArray2.size() > 0) || ((arrayList = this.f12186f) != null && arrayList.size() > 0)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("filename", this.f12185e);
                    contentValues.put("state", "0");
                    contentValues.put("reserve1", this.f12187g ? "1" : "0");
                    sQLiteDatabase.replace("file", null, contentValues);
                }
                s.a("delete total time:" + (System.currentTimeMillis() - this.f12183c));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f12189c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f12190d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str, boolean z) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12189c = str;
            this.f12190d = z;
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "1");
                contentValues.put("filename", this.f12189c);
                contentValues.put("reserve1", this.f12190d ? "1" : "0");
                sQLiteDatabase.replace("file", null, contentValues);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f12191c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, String str) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12191c = str;
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                sQLiteDatabase.delete("file", "filename=\"" + this.f12191c + "\"", null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                sQLiteDatabase.delete("file", null, null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f12192c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, String str) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12192c = str;
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "1");
                sQLiteDatabase.update("file", contentValues, "filename=\"" + this.f12192c + "\"", null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f12193c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f12194d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar, String str, String str2) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12193c = str;
            this.f12194d = str2;
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", this.f12194d);
                sQLiteDatabase.update("file", contentValues, "filename=\"" + this.f12193c + "\"", null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "1");
                sQLiteDatabase.update("file", contentValues, null, null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f12195c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f12196d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f12197e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ContentValues f12198f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f12199g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(a aVar, String str, String str2, int i2, ContentValues contentValues) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, Integer.valueOf(i2), contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12199g = aVar;
            this.f12195c = str;
            this.f12196d = str2;
            this.f12197e = i2;
            this.f12198f = contentValues;
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) ? this.f12199g.e(this.f12195c, this.f12196d, this.f12197e, sQLiteDatabase) && sQLiteDatabase.insert("event", null, this.f12198f) != -1 : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class i extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f12200c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f12201d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(a aVar, List list) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12201d = aVar;
            this.f12200c = list;
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                boolean z = true;
                for (c.a.o0.r.i iVar : this.f12200c) {
                    if (!TextUtils.isEmpty(iVar.f12256a) && this.f12201d.e(iVar.f12257b, iVar.f12256a, iVar.f12258c, sQLiteDatabase)) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("flowhandle", Integer.valueOf(iVar.f12258c));
                        contentValues.put("eventid", iVar.f12256a);
                        contentValues.put("begintime", Long.valueOf(iVar.f12261f));
                        if (!TextUtils.isEmpty(iVar.f12259d)) {
                            contentValues.put("content", iVar.f12259d);
                        } else {
                            JSONObject jSONObject = iVar.f12260e;
                            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
                                contentValues.put("content", iVar.f12260e.toString());
                            }
                        }
                        contentValues.put("reserve1", iVar.f12263h);
                        if (!TextUtils.isEmpty(iVar.f12264i)) {
                            contentValues.put("reserve2", iVar.f12264i);
                        }
                        if (iVar.f12265j) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("ctr", "1");
                                contentValues.put("extend", jSONObject2.toString());
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (sQLiteDatabase.insert("event", null, contentValues) < 0) {
                            z = false;
                        }
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class j extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ContentValues f12202c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(a aVar, ContentValues contentValues) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12202c = contentValues;
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) ? sQLiteDatabase.insert("flow", null, this.f12202c) != -1 : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class k extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ContentValues f12203c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f12204d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(a aVar, ContentValues contentValues, String str) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, contentValues, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12203c = contentValues;
            this.f12204d = str;
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) ? sQLiteDatabase.update("flow", this.f12203c, this.f12204d, null) == 1 : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class l extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ContentValues f12205c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f12206d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(a aVar, ContentValues contentValues, String str) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, contentValues, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12205c = contentValues;
            this.f12206d = str;
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) ? sQLiteDatabase.update("flow", this.f12205c, this.f12206d, null) == 1 : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class m extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f12207c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f12208d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(a aVar, String str, int i2) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12207c = str;
            this.f12208d = i2;
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                sQLiteDatabase.delete("flow", this.f12207c, null);
                sQLiteDatabase.delete("event", "flowhandle = " + this.f12208d, null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class n extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f12209c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(a aVar) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12209c = aVar;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x00a5 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00b6 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x007e */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00c0 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r0v21, types: [android.database.Cursor] */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r0v23 */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r9v0, types: [android.database.sqlite.SQLiteDatabase, java.lang.Object] */
        @Override // c.a.o0.r.a.q
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            boolean moveToNext;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                long currentTimeMillis = System.currentTimeMillis() - c.a.o0.r.d.g().e();
                Closeable closeable = null;
                a.x(currentTimeMillis, sQLiteDatabase.delete("flow", "endtime < " + currentTimeMillis, null), "flow");
                a.x(currentTimeMillis, sQLiteDatabase.delete("event", "begintime < " + currentTimeMillis, null), "event");
                String str = "SELECT flowhandle FROM flow WHERE begintime < " + (System.currentTimeMillis() - 86400000) + " AND endtime is NULL  AND " + SpeedStatsUtils.UBC_KEY_OPTION + " = 0";
                ArrayList arrayList = new ArrayList();
                try {
                    try {
                        str = sQLiteDatabase.rawQuery(str, null);
                    } catch (Throwable th) {
                        th = th;
                        closeable = str;
                        c.a.o0.t.d.d(closeable);
                        throw th;
                    }
                } catch (SQLiteFullException unused) {
                    str = 0;
                } catch (RuntimeException e2) {
                    e = e2;
                    str = 0;
                } catch (Throwable th2) {
                    th = th2;
                    c.a.o0.t.d.d(closeable);
                    throw th;
                }
                if (str != 0) {
                    try {
                        int count = str.getCount();
                        str = str;
                        if (count > 0) {
                            str.moveToFirst();
                            do {
                                arrayList.add(Integer.valueOf(str.getInt(str.getColumnIndex("flowhandle"))));
                                moveToNext = str.moveToNext();
                                str = str;
                            } while (moveToNext);
                        }
                    } catch (SQLiteFullException unused2) {
                    } catch (RuntimeException e3) {
                        e = e3;
                        e.printStackTrace();
                        str = str;
                        c.a.o0.t.d.d(str);
                        if (arrayList.size() != 0) {
                        }
                    }
                }
                c.a.o0.t.d.d(str);
                if (arrayList.size() != 0) {
                    return true;
                }
                String str2 = "flowhandle in (" + this.f12209c.t(arrayList) + SmallTailInfo.EMOTION_SUFFIX;
                sQLiteDatabase.delete("flow", str2, null);
                sQLiteDatabase.delete("event", str2, null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class o extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f12210c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f12211d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(a aVar, String str, int i2) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12210c = str;
            this.f12211d = i2;
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                String str = this.f12210c;
                int delete = sQLiteDatabase.delete(str, "_id < " + this.f12211d, null);
                c.a.o0.r.e.i(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "delLimit");
                return delete > 0;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class p extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f12212c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(a aVar, List list) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12212c = list;
        }

        @Override // c.a.o0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                for (c.a.o0.r.g gVar : this.f12212c) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("eventid", gVar.f12241a);
                    contentValues.put("type", gVar.f12245e);
                    contentValues.put("cycle", Integer.valueOf("1".equals(gVar.f12243c) ? 0 : gVar.f12244d));
                    contentValues.put(SetImageWatermarkTypeReqMsg.SWITCH, gVar.f12242b);
                    contentValues.put("reserve1", gVar.f12246f);
                    if (!TextUtils.isEmpty(gVar.f12248h)) {
                        contentValues.put("reserve2", gVar.f12248h);
                    }
                    contentValues.put("sample", Integer.valueOf(gVar.f12247g));
                    int i2 = gVar.f12249i;
                    if (i2 != 0 && gVar.f12250j != 0) {
                        contentValues.put("recordrule", Integer.valueOf(i2));
                        contentValues.put("uploadrule", Integer.valueOf(gVar.f12250j));
                    }
                    if (TextUtils.equals(gVar.k, "1")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(Constant.ID_TYPE, "1");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        contentValues.put("extend", jSONObject.toString());
                    }
                    sQLiteDatabase.replace("config", null, contentValues);
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12182b = new c.a.o0.r.o(context);
    }

    public static void x(long j2, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), str}) == null) || i2 <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", ContentUtil.RESULT_KEY_EXPIRE);
            jSONObject.put("ubc_type", str);
            jSONObject.put("expire_time", j2);
            jSONObject.put("count", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c.a.o0.r.e.i(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
    }

    public void A(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            new b(this, str, z).c(this.f12182b.getWritableDatabase());
        }
    }

    public void B(c.a.o0.r.k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar) == null) || kVar == null || TextUtils.isEmpty(kVar.f12267a)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("flowid", kVar.f12267a);
        contentValues.put("flowhandle", Integer.valueOf(kVar.f12268b));
        contentValues.put("state", kVar.f12274h);
        contentValues.put("begintime", Long.valueOf(kVar.f12271e));
        JSONObject jSONObject = kVar.f12270d;
        if (jSONObject != null) {
            contentValues.put("content", jSONObject.toString());
        } else {
            contentValues.put("content", kVar.f12269c);
        }
        contentValues.put(SpeedStatsUtils.UBC_KEY_OPTION, Integer.valueOf(kVar.f12273g));
        contentValues.put("reserve1", kVar.f12275i);
        if (!TextUtils.isEmpty(kVar.f12276j)) {
            contentValues.put("reserve2", kVar.f12276j);
        }
        if (kVar.l) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ctr", "1");
                contentValues.put("extend", jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        new j(this, contentValues).c(this.f12182b.getWritableDatabase());
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
            new g(this).c(this.f12182b.getWritableDatabase());
        }
    }

    public void D(List<c.a.o0.r.g> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        new p(this, list).c(this.f12182b.getWritableDatabase());
    }

    public void E(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, str2) == null) || i2 < 0 || TextUtils.isEmpty(str)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("content", str2);
        new k(this, contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2).c(this.f12182b.getWritableDatabase());
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            new e(this, str).c(this.f12182b.getWritableDatabase());
        }
    }

    public void G(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            new f(this, str, str2).c(this.f12182b.getWritableDatabase());
        }
    }

    public void d(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) || i2 < 0 || TextUtils.isEmpty(str)) {
            return;
        }
        new m(this, "flowid=\"" + str + "\" AND flowhandle = " + i2, i2).c(this.f12182b.getWritableDatabase());
    }

    public final boolean e(String str, String str2, int i2, SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, i2, sQLiteDatabase)) == null) {
            boolean equals = str.equals(str2);
            boolean z = false;
            if (equals) {
                return true;
            }
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("SELECT state FROM flow WHERE flowhandle = " + i2, null);
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        String string = cursor.getString(0);
                        if (!TextUtils.isEmpty(string)) {
                            if ("1".equals(string)) {
                                z = true;
                            }
                        }
                    }
                } catch (SQLiteFullException unused) {
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                }
                return z;
            } finally {
                c.a.o0.t.d.d(cursor);
            }
        }
        return invokeLLIL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            new n(this).c(this.f12182b.getWritableDatabase());
            k("flow");
            k("event");
        }
    }

    public boolean g(SparseIntArray sparseIntArray, ArrayList<String> arrayList, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{sparseIntArray, arrayList, Boolean.valueOf(z), str})) == null) {
            C0629a c0629a = new C0629a(this, sparseIntArray, str, arrayList, z);
            c0629a.c(this.f12182b.getWritableDatabase());
            return c0629a.a();
        }
        return invokeCommon.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            new d(this).c(this.f12182b.getWritableDatabase());
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            new c(this, str).c(this.f12182b.getWritableDatabase());
        }
    }

    public void j(String str, int i2, long j2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j2), jSONArray}) == null) || i2 < 0 || TextUtils.isEmpty(str)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", "2");
        contentValues.put("endtime", Long.valueOf(j2));
        if (jSONArray != null && jSONArray.length() > 0) {
            contentValues.put("slot", jSONArray.toString());
        }
        new l(this, contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2).c(this.f12182b.getWritableDatabase());
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            SQLiteDatabase writableDatabase = this.f12182b.getWritableDatabase();
            int i2 = 0;
            Cursor cursor = null;
            try {
                try {
                    cursor = writableDatabase.rawQuery("SELECT COUNT(*), MIN(_id), MAX(_id)  FROM " + str, null);
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        if (cursor.getInt(0) > c.a.o0.r.d.g().f()) {
                            i2 = (cursor.getInt(1) + cursor.getInt(2)) / 2;
                        }
                    }
                } catch (SQLiteFullException unused) {
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                }
                if (i2 > 0) {
                    new o(this, str, i2).c(writableDatabase);
                }
            } finally {
                c.a.o0.t.d.d(cursor);
            }
        }
    }

    public int l(u uVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, uVar)) == null) {
            this.f12181a = 0L;
            int q2 = q(" SELECT * FROM flow", uVar);
            if (this.f12181a >= 2097152) {
                return 1;
            }
            return p("SELECT * FROM event WHERE flowhandle = -1", uVar) | q2;
        }
        return invokeL.intValue;
    }

    public int m(ArrayList<c.a.o0.r.f> arrayList, u uVar) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, arrayList, uVar)) == null) {
            this.f12181a = 0L;
            String s = s(arrayList, true);
            if (TextUtils.isEmpty(s)) {
                i2 = 0;
            } else {
                i2 = q("SELECT *  FROM flow WHERE flowid in (" + s + SmallTailInfo.EMOTION_SUFFIX, uVar);
            }
            String s2 = s(arrayList, false);
            if (TextUtils.isEmpty(s2)) {
                return i2;
            }
            return i2 | p("SELECT *  FROM event WHERE eventid in (" + s2 + ") AND flowhandle = -1", uVar);
        }
        return invokeLL.intValue;
    }

    public final long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f12182b.g() : invokeV.longValue;
    }

    public final long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f12182b.n() : invokeV.longValue;
    }

    public final int p(String str, u uVar) {
        InterceptResult invokeLL;
        u uVar2;
        long j2;
        long j3;
        int i2;
        int i3;
        String str2;
        long j4;
        int i4;
        String string;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, uVar)) == null) {
            u uVar3 = uVar;
            String str3 = "content";
            Cursor cursor = null;
            long j5 = Long.MAX_VALUE;
            try {
                try {
                    cursor = this.f12182b.getReadableDatabase().rawQuery(str, null);
                    if (cursor == null || cursor.getCount() <= 0) {
                        uVar2 = uVar3;
                        j2 = 0;
                        i2 = 0;
                    } else {
                        cursor.moveToFirst();
                        int columnIndex = cursor.getColumnIndex("eventid");
                        int columnIndex2 = cursor.getColumnIndex("begintime");
                        int columnIndex3 = cursor.getColumnIndex("content");
                        int columnIndex4 = cursor.getColumnIndex("reserve1");
                        int columnIndex5 = cursor.getColumnIndex("reserve2");
                        int columnIndex6 = cursor.getColumnIndex("extend");
                        j2 = 0;
                        while (true) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                String string2 = cursor.getString(columnIndex3);
                                int i6 = columnIndex3;
                                int i7 = columnIndex6;
                                if (TextUtils.isEmpty(string2)) {
                                    i3 = columnIndex5;
                                    str2 = str3;
                                } else {
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(string2);
                                        if (jSONObject2.has("bizId")) {
                                            JSONObject jSONObject3 = jSONObject2.getJSONObject(str3);
                                            i3 = columnIndex5;
                                            JSONObject jSONObject4 = jSONObject2.getJSONObject(DI.APP_INFO_NAME);
                                            if (jSONObject3 != null && jSONObject4 != null) {
                                                jSONObject3.put(DI.APP_INFO_NAME, jSONObject4);
                                                jSONObject2.remove(DI.APP_INFO_NAME);
                                            }
                                            jSONObject = jSONObject2;
                                        } else {
                                            i3 = columnIndex5;
                                            jSONObject.put(str3, jSONObject2);
                                        }
                                        str2 = str3;
                                        this.f12181a += string2.getBytes("UTF-8").length;
                                    } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused) {
                                        uVar2 = uVar;
                                        c.a.o0.t.d.d(cursor);
                                        j3 = j2;
                                        i2 = 0;
                                        uVar2.g(j5, j3);
                                        return i2;
                                    } catch (RuntimeException e2) {
                                        e = e2;
                                        uVar2 = uVar;
                                        e.printStackTrace();
                                        c.a.o0.t.d.d(cursor);
                                        j3 = j2;
                                        i2 = 0;
                                        uVar2.g(j5, j3);
                                        return i2;
                                    }
                                }
                                String string3 = cursor.getString(columnIndex);
                                jSONObject.put("bizId", string3);
                                long j6 = cursor.getLong(columnIndex2);
                                jSONObject.put("timestamp", Long.toString(j6));
                                if (j6 > 0) {
                                    if (j6 < j5) {
                                        j5 = j6;
                                    }
                                    if (j6 > j2) {
                                        j2 = j6;
                                    }
                                }
                                try {
                                    try {
                                        jSONObject.put("eventType", "0");
                                        String string4 = cursor.getString(columnIndex4);
                                        if (TextUtils.isEmpty(string4)) {
                                            uVar2 = uVar;
                                            j4 = j5;
                                            i4 = columnIndex2;
                                        } else {
                                            jSONObject.put("abtest", string4);
                                            uVar2 = uVar;
                                            try {
                                                uVar2.f12347f = "1";
                                                j4 = j5;
                                                try {
                                                    i4 = columnIndex2;
                                                    this.f12181a += string4.getBytes("UTF-8").length;
                                                } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused2) {
                                                    j5 = j4;
                                                    c.a.o0.t.d.d(cursor);
                                                    j3 = j2;
                                                    i2 = 0;
                                                    uVar2.g(j5, j3);
                                                    return i2;
                                                } catch (RuntimeException e3) {
                                                    e = e3;
                                                    j5 = j4;
                                                    e.printStackTrace();
                                                    c.a.o0.t.d.d(cursor);
                                                    j3 = j2;
                                                    i2 = 0;
                                                    uVar2.g(j5, j3);
                                                    return i2;
                                                }
                                            } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused3) {
                                                c.a.o0.t.d.d(cursor);
                                                j3 = j2;
                                                i2 = 0;
                                                uVar2.g(j5, j3);
                                                return i2;
                                            } catch (RuntimeException e4) {
                                                e = e4;
                                                e.printStackTrace();
                                                c.a.o0.t.d.d(cursor);
                                                j3 = j2;
                                                i2 = 0;
                                                uVar2.g(j5, j3);
                                                return i2;
                                            }
                                        }
                                        int i8 = i3;
                                        if (!TextUtils.isEmpty(cursor.getString(i8))) {
                                            jSONObject.put("c", cursor.getString(i8));
                                        }
                                        if (TextUtils.isEmpty(cursor.getString(i7))) {
                                            i5 = i7;
                                        } else {
                                            if (new JSONObject(cursor.getString(i7)).has("ctr")) {
                                                jSONObject.put("of", "1");
                                            }
                                            i5 = i7;
                                            this.f12181a += string.getBytes("UTF-8").length;
                                        }
                                        jSONObject.put(Constant.ID_TYPE, c.a.o0.r.d.g().j(string3));
                                        r.a(jSONObject);
                                        uVar2.a(jSONObject);
                                        uVar2.e(cursor.getString(columnIndex));
                                        if (this.f12181a >= 2097152 || !cursor.moveToNext()) {
                                            break;
                                        }
                                        columnIndex3 = i6;
                                        uVar3 = uVar2;
                                        columnIndex6 = i5;
                                        j5 = j4;
                                        columnIndex2 = i4;
                                        String str4 = str2;
                                        columnIndex5 = i8;
                                        str3 = str4;
                                    } catch (SQLiteFullException | UnsupportedEncodingException unused4) {
                                        uVar2 = uVar;
                                    }
                                } catch (RuntimeException e5) {
                                    e = e5;
                                    uVar2 = uVar;
                                } catch (JSONException unused5) {
                                    uVar2 = uVar;
                                }
                            } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused6) {
                                uVar2 = uVar3;
                            } catch (RuntimeException e6) {
                                e = e6;
                                uVar2 = uVar3;
                            }
                        }
                        i2 = 1;
                        j5 = j4;
                    }
                    c.a.o0.t.d.d(cursor);
                    j3 = j2;
                } catch (Throwable th) {
                    c.a.o0.t.d.d(null);
                    throw th;
                }
            } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused7) {
                uVar2 = uVar3;
                j2 = 0;
            } catch (RuntimeException e7) {
                e = e7;
                uVar2 = uVar3;
                j2 = 0;
            }
            uVar2.g(j5, j3);
            return i2;
        }
        return invokeLL.intValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:75:0x01bd
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final int q(java.lang.String r30, c.a.o0.r.u r31) {
        /*
            r29 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = c.a.o0.r.a.$ic
            if (r0 != 0) goto L209
        L4:
            r1 = r29
            r2 = r31
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            c.a.o0.r.o r0 = r1.f12182b
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()
            r4 = 0
            r10 = r30
            android.database.Cursor r4 = r0.rawQuery(r10, r4)     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            if (r4 == 0) goto L1c6
            int r0 = r4.getCount()     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            if (r0 <= 0) goto L1c6
            r4.moveToFirst()     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            java.lang.String r0 = "flowid"
            int r11 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            java.lang.String r0 = "flowhandle"
            int r12 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            java.lang.String r0 = "state"
            int r13 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            java.lang.String r0 = "begintime"
            int r14 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            java.lang.String r0 = "endtime"
            int r15 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            java.lang.String r0 = "content"
            int r7 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            java.lang.String r0 = "option"
            int r8 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            java.lang.String r0 = "reserve1"
            int r9 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            java.lang.String r0 = "reserve2"
            int r10 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            java.lang.String r0 = "slot"
            int r5 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            java.lang.String r0 = "extend"
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d7 java.lang.RuntimeException -> L1d9 java.lang.Throwable -> L1ec
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r20 = 0
        L6e:
            java.lang.String r0 = "2"
            java.lang.String r2 = r4.getString(r13)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            boolean r0 = r0.equals(r2)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            if (r0 != 0) goto Laa
            long r22 = r4.getLong(r14)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            long r24 = java.lang.System.currentTimeMillis()     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            long r22 = r22 - r24
            long r22 = java.lang.Math.abs(r22)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r24 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r0 <= 0) goto L98
            int r0 = r4.getInt(r8)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r0 = r0 & 4
            if (r0 == 0) goto L98
            goto Laa
        L98:
            r24 = r8
            r22 = r11
            r23 = r12
            r25 = r13
            r26 = r14
            r18 = 0
            r8 = r31
            r11 = r7
            r7 = 1
            goto L19d
        Laa:
            c.a.o0.r.k r2 = new c.a.o0.r.k     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r2.<init>()     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            java.lang.String r0 = r4.getString(r11)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r2.f12267a = r0     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            int r0 = r4.getInt(r12)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r2.f12268b = r0     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r22 = r11
            r23 = r12
            long r11 = r4.getLong(r14)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r2.f12271e = r11     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            long r11 = r4.getLong(r15)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r2.f12272f = r11     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r18 = 0
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 <= 0) goto Ld7
            int r0 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r0 <= 0) goto Ld7
            r20 = r11
        Ld7:
            long r11 = r2.f12271e     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r18 = 0
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 <= 0) goto Le9
            long r11 = r2.f12271e     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            int r0 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r0 >= 0) goto Le9
            long r11 = r2.f12271e     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r16 = r11
        Le9:
            java.lang.String r0 = r4.getString(r7)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            java.lang.String r12 = "UTF-8"
            if (r11 != 0) goto L103
            r2.f12269c = r0     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            byte[] r0 = r0.getBytes(r12)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r11 = r7
            r24 = r8
            long r7 = (long) r0     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r1.f12181a = r7     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            goto L106
        L103:
            r11 = r7
            r24 = r8
        L106:
            java.lang.String r0 = r4.getString(r9)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            if (r7 != 0) goto L122
            r2.f12275i = r0     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            long r7 = r1.f12181a     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            byte[] r0 = r0.getBytes(r12)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r25 = r13
            r26 = r14
            long r13 = (long) r0     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            long r7 = r7 + r13
            r1.f12181a = r7     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            goto L126
        L122:
            r25 = r13
            r26 = r14
        L126:
            java.lang.String r0 = r4.getString(r10)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            if (r0 != 0) goto L136
            java.lang.String r0 = r4.getString(r10)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r2.f12276j = r0     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
        L136:
            java.lang.String r0 = r4.getString(r5)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            if (r5 < 0) goto L150
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            if (r7 != 0) goto L150
            r2.b(r0)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            long r7 = r1.f12181a     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            byte[] r0 = r0.getBytes(r12)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            long r13 = (long) r0     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            long r7 = r7 + r13
            r1.f12181a = r7     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
        L150:
            java.lang.String r0 = r4.getString(r6)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            if (r7 != 0) goto L182
            long r7 = r1.f12181a     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            byte[] r0 = r0.getBytes(r12)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            long r12 = (long) r0     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            long r7 = r7 + r12
            r1.f12181a = r7     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L17c java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            java.lang.String r7 = r4.getString(r6)     // Catch: org.json.JSONException -> L17c java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r0.<init>(r7)     // Catch: org.json.JSONException -> L17c java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            java.lang.String r7 = "ctr"
            boolean r0 = r0.has(r7)     // Catch: org.json.JSONException -> L17c java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            if (r0 == 0) goto L182
            r7 = 1
            r2.l = r7     // Catch: org.json.JSONException -> L17a java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            goto L183
        L17a:
            r0 = move-exception
            goto L17e
        L17c:
            r0 = move-exception
            r7 = 1
        L17e:
            r0.printStackTrace()     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            goto L183
        L182:
            r7 = 1
        L183:
            r3.add(r2)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            int r0 = r2.f12268b     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            java.lang.String r2 = r2.f12267a     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1ba java.lang.Throwable -> L1d7
            r8 = r31
            r8.f(r0, r2)     // Catch: java.lang.RuntimeException -> L1b4 java.lang.Throwable -> L1c3 java.lang.Throwable -> L1d7
            long r12 = r1.f12181a     // Catch: java.lang.RuntimeException -> L1b4 java.lang.Throwable -> L1c3 java.lang.Throwable -> L1d7
            r27 = 2097152(0x200000, double:1.036131E-317)
            int r0 = (r12 > r27 ? 1 : (r12 == r27 ? 0 : -1))
            if (r0 < 0) goto L19d
            goto L1a3
        L19d:
            boolean r0 = r4.moveToNext()     // Catch: java.lang.RuntimeException -> L1b4 java.lang.Throwable -> L1c3 java.lang.Throwable -> L1d7
            if (r0 != 0) goto L1a6
        L1a3:
            r5 = r20
            goto L1d1
        L1a6:
            r2 = r8
            r7 = r11
            r11 = r22
            r12 = r23
            r8 = r24
            r13 = r25
            r14 = r26
            goto L6e
        L1b4:
            r0 = move-exception
            goto L1bf
        L1b6:
            r0 = move-exception
            r8 = r31
            goto L1bf
        L1ba:
            r8 = r31
            goto L1c3
        L1bd:
            r0 = move-exception
            r8 = r2
        L1bf:
            r5 = r20
            goto L1e4
        L1c2:
            r8 = r2
        L1c3:
            r5 = r20
            goto L1f6
        L1c6:
            r8 = r2
            r18 = 0
            r5 = r18
            r7 = 0
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L1d1:
            c.a.o0.t.d.d(r4)
            r9 = r16
            goto L1fc
        L1d7:
            r0 = move-exception
            goto L1e8
        L1d9:
            r0 = move-exception
            r8 = r2
            r18 = 0
            r5 = r18
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L1e4:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L1d7
            goto L1f6
        L1e8:
            c.a.o0.t.d.d(r4)
            throw r0
        L1ec:
            r8 = r2
            r18 = 0
            r5 = r18
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L1f6:
            c.a.o0.t.d.d(r4)
            r9 = r16
            r7 = 0
        L1fc:
            int r0 = r3.size()
            if (r0 <= 0) goto L205
            r1.r(r3, r8)
        L205:
            r8.g(r9, r5)
            return r7
        L209:
            r27 = r0
            r28 = 1048596(0x100014, float:1.469396E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r27.invokeLL(r28, r29, r30, r31)
            if (r0 == 0) goto L4
            int r1 = r0.intValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.o0.r.a.q(java.lang.String, c.a.o0.r.u):int");
    }

    public final void r(ArrayList<c.a.o0.r.k> arrayList, u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, arrayList, uVar) == null) {
            JSONObject jSONObject = new JSONObject();
            SQLiteDatabase readableDatabase = this.f12182b.getReadableDatabase();
            try {
                Iterator<c.a.o0.r.k> it = arrayList.iterator();
                String[] strArr = null;
                Cursor cursor = null;
                while (it.hasNext()) {
                    c.a.o0.r.k next = it.next();
                    if (next.f12268b >= 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("bizId", next.f12267a);
                        jSONObject2.put(LaunchedTaskSpeedStats.KEY_START_TIME, Long.toString(next.f12271e));
                        jSONObject2.put("endtime", Long.toString(next.f12272f));
                        jSONObject2.put("eventType", "1");
                        if (!TextUtils.isEmpty(next.f12269c)) {
                            jSONObject = new JSONObject(next.f12269c);
                        }
                        if (!TextUtils.isEmpty(next.f12275i)) {
                            jSONObject2.put("abtest", next.f12275i);
                            uVar.f12347f = "1";
                        }
                        if (!TextUtils.isEmpty(next.f12276j)) {
                            jSONObject2.put("c", next.f12276j);
                        }
                        if (next.k != null) {
                            jSONObject2.put(SpeedStatsMainTable.PART, next.k);
                        }
                        if (next.l) {
                            jSONObject2.put("of", "1");
                        }
                        jSONObject2.put(Constant.ID_TYPE, c.a.o0.r.d.g().j(next.f12267a));
                        JSONArray jSONArray = new JSONArray();
                        try {
                            cursor = readableDatabase.rawQuery("SELECT eventid , begintime , content FROM event WHERE flowhandle = " + next.f12268b, strArr);
                            if (cursor != null && cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex("eventid");
                                int columnIndex2 = cursor.getColumnIndex("begintime");
                                int columnIndex3 = cursor.getColumnIndex("content");
                                while (true) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put("id", cursor.getString(columnIndex));
                                    jSONObject3.put("timestamp", Long.toString(cursor.getLong(columnIndex2)));
                                    jSONObject3.put("content", cursor.getString(columnIndex3));
                                    jSONArray.put(jSONObject3);
                                    if (!cursor.moveToNext()) {
                                        break;
                                    }
                                }
                                jSONObject.put("eventlist", jSONArray);
                            }
                        } catch (SQLiteFullException unused) {
                        } catch (Throwable th) {
                            c.a.o0.t.d.d(cursor);
                            throw th;
                        }
                        c.a.o0.t.d.d(cursor);
                        jSONObject2.put("content", jSONObject);
                        r.a(jSONObject2);
                        uVar.a(jSONObject2);
                    }
                    strArr = null;
                }
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            } catch (JSONException unused2) {
            }
        }
    }

    public final String s(ArrayList<c.a.o0.r.f> arrayList, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048598, this, arrayList, z)) == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<c.a.o0.r.f> it = arrayList.iterator();
            String str = "";
            while (it.hasNext()) {
                c.a.o0.r.f next = it.next();
                if ((z && !"0".equals(next.f12240b)) || (!z && "0".equals(next.f12240b))) {
                    sb.append(str);
                    sb.append(next.f12239a);
                    str = ",";
                }
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public final String t(ArrayList arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, arrayList)) == null) {
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            String str = "";
            while (it.hasNext()) {
                Object next = it.next();
                sb.append(str);
                sb.append(next);
                str = ",";
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0057 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0023 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.database.Cursor] */
    public c.a.o0.r.j u(String str) {
        InterceptResult invokeL;
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            String str2 = "SELECT state , reserve1 FROM file WHERE filename=\"" + str + "\"";
            Closeable closeable2 = null;
            r3 = null;
            r3 = null;
            c.a.o0.r.j jVar = null;
            try {
                try {
                    str2 = this.f12182b.getReadableDatabase().rawQuery(str2, null);
                    closeable = str2;
                    if (str2 != 0) {
                        try {
                            int count = str2.getCount();
                            closeable = str2;
                            if (count > 0) {
                                str2.moveToFirst();
                                jVar = new c.a.o0.r.j(str, str2.getString(str2.getColumnIndex("state")), str2.isNull(str2.getColumnIndex("reserve1")) ? "" : str2.getString(str2.getColumnIndex("reserve1")));
                                closeable = str2;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("type", "DBError");
                                jSONObject.put("exception", Log.getStackTraceString(e));
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            c.a.o0.r.e.i(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                            closeable = str2;
                            c.a.o0.t.d.d(closeable);
                            return jVar;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable2 = str2;
                    c.a.o0.t.d.d(closeable2);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                str2 = 0;
            } catch (Throwable th2) {
                th = th2;
                c.a.o0.t.d.d(closeable2);
                throw th;
            }
            c.a.o0.t.d.d(closeable);
            return jVar;
        }
        return (c.a.o0.r.j) invokeL.objValue;
    }

    public void v(SparseArray<ArrayList> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, sparseArray) == null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = this.f12182b.getReadableDatabase().rawQuery("SELECT eventid , type , cycle FROM config WHERE switch=\"1\"", null);
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        int columnIndex = cursor.getColumnIndex("eventid");
                        int columnIndex2 = cursor.getColumnIndex("type");
                        int columnIndex3 = cursor.getColumnIndex("cycle");
                        do {
                            String string = cursor.getString(columnIndex);
                            String string2 = cursor.getString(columnIndex2);
                            int i2 = cursor.getInt(columnIndex3);
                            if (i2 != 0) {
                                if (i2 < 6) {
                                    i2 = 6;
                                } else if (i2 > 720) {
                                    i2 = 720;
                                }
                            }
                            if (string != null) {
                                ArrayList arrayList = sparseArray.get(i2);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    sparseArray.put(i2, arrayList);
                                }
                                arrayList.add(new c.a.o0.r.f(string, string2));
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                }
            } finally {
                c.a.o0.t.d.d(cursor);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0097 A[Catch: all -> 0x0105, RuntimeException -> 0x0107, SQLiteFullException -> 0x0110, TryCatch #5 {SQLiteFullException -> 0x0110, RuntimeException -> 0x0107, blocks: (B:8:0x0011, B:10:0x0017, B:12:0x001d, B:13:0x0020, B:17:0x0085, B:23:0x0097, B:25:0x009f, B:27:0x00a5, B:30:0x00af, B:32:0x00bb, B:34:0x00c1, B:38:0x00cd, B:40:0x00da, B:42:0x00e0, B:45:0x00ef, B:53:0x00fe, B:51:0x00f8, B:19:0x008a, B:21:0x0091), top: B:73:0x0011, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a5 A[Catch: all -> 0x0105, RuntimeException -> 0x0107, SQLiteFullException -> 0x0110, TryCatch #5 {SQLiteFullException -> 0x0110, RuntimeException -> 0x0107, blocks: (B:8:0x0011, B:10:0x0017, B:12:0x001d, B:13:0x0020, B:17:0x0085, B:23:0x0097, B:25:0x009f, B:27:0x00a5, B:30:0x00af, B:32:0x00bb, B:34:0x00c1, B:38:0x00cd, B:40:0x00da, B:42:0x00e0, B:45:0x00ef, B:53:0x00fe, B:51:0x00f8, B:19:0x008a, B:21:0x0091), top: B:73:0x0011, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00af A[Catch: all -> 0x0105, RuntimeException -> 0x0107, SQLiteFullException -> 0x0110, TryCatch #5 {SQLiteFullException -> 0x0110, RuntimeException -> 0x0107, blocks: (B:8:0x0011, B:10:0x0017, B:12:0x001d, B:13:0x0020, B:17:0x0085, B:23:0x0097, B:25:0x009f, B:27:0x00a5, B:30:0x00af, B:32:0x00bb, B:34:0x00c1, B:38:0x00cd, B:40:0x00da, B:42:0x00e0, B:45:0x00ef, B:53:0x00fe, B:51:0x00f8, B:19:0x008a, B:21:0x0091), top: B:73:0x0011, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1 A[Catch: all -> 0x0105, RuntimeException -> 0x0107, SQLiteFullException -> 0x0110, TryCatch #5 {SQLiteFullException -> 0x0110, RuntimeException -> 0x0107, blocks: (B:8:0x0011, B:10:0x0017, B:12:0x001d, B:13:0x0020, B:17:0x0085, B:23:0x0097, B:25:0x009f, B:27:0x00a5, B:30:0x00af, B:32:0x00bb, B:34:0x00c1, B:38:0x00cd, B:40:0x00da, B:42:0x00e0, B:45:0x00ef, B:53:0x00fe, B:51:0x00f8, B:19:0x008a, B:21:0x0091), top: B:73:0x0011, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(HashSet<String> hashSet, HashSet<String> hashSet2, HashSet<String> hashSet3, HashSet<String> hashSet4, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashMap<String, c.a.o0.r.h> hashMap3, HashSet<String> hashSet5) {
        SQLiteDatabase readableDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{hashSet, hashSet2, hashSet3, hashSet4, hashMap, hashMap2, hashMap3, hashSet5}) == null) || (readableDatabase = this.f12182b.getReadableDatabase()) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = readableDatabase.rawQuery("SELECT * FROM config", null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    do {
                        String string = cursor.getString(cursor.getColumnIndex("eventid"));
                        String string2 = cursor.getString(cursor.getColumnIndex(SetImageWatermarkTypeReqMsg.SWITCH));
                        int i2 = cursor.getInt(cursor.getColumnIndex("sample"));
                        String string3 = cursor.getString(cursor.getColumnIndex("reserve1"));
                        String string4 = cursor.getString(cursor.getColumnIndex("reserve2"));
                        int i3 = cursor.getInt(cursor.getColumnIndex("cycle"));
                        int i4 = cursor.getInt(cursor.getColumnIndex("uploadrule"));
                        int i5 = cursor.getInt(cursor.getColumnIndex("recordrule"));
                        String string5 = cursor.getString(cursor.getColumnIndex("extend"));
                        if (TextUtils.equals(string2, "0")) {
                            hashSet.add(string);
                        } else if (TextUtils.equals(string2, "1")) {
                            hashSet2.add(string);
                            if (i3 != 0) {
                                hashSet3.add(string);
                            }
                            if (!TextUtils.equals(string3, "1")) {
                                hashSet4.add(string);
                            }
                            if (i2 <= 0) {
                                hashMap.put(string, String.valueOf(i2));
                            }
                            if (TextUtils.isEmpty(string4)) {
                                hashMap2.put(string, string4);
                            }
                            if (i4 == 0 && i5 != 0) {
                                hashMap3.put(string, new c.a.o0.r.h(string, i5, i4));
                            }
                            if (!TextUtils.isEmpty(string5)) {
                                try {
                                } catch (JSONException e2) {
                                    e = e2;
                                }
                                if (new JSONObject(string5).has(Constant.ID_TYPE)) {
                                    try {
                                        hashSet5.add(string);
                                    } catch (JSONException e3) {
                                        e = e3;
                                        e.printStackTrace();
                                        if (!cursor.moveToNext()) {
                                        }
                                    }
                                }
                            }
                        }
                        if (i3 != 0) {
                        }
                        if (!TextUtils.equals(string3, "1")) {
                        }
                        if (i2 <= 0) {
                        }
                        if (TextUtils.isEmpty(string4)) {
                        }
                        if (i4 == 0) {
                        }
                        if (!TextUtils.isEmpty(string5)) {
                        }
                    } while (!cursor.moveToNext());
                }
            } catch (SQLiteFullException unused) {
            } catch (RuntimeException e4) {
                e4.printStackTrace();
            }
        } finally {
            c.a.o0.t.d.d(cursor);
        }
    }

    public void y(c.a.o0.r.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, iVar) == null) || iVar == null || TextUtils.isEmpty(iVar.f12256a)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("flowhandle", Integer.valueOf(iVar.f12258c));
        contentValues.put("eventid", iVar.f12256a);
        contentValues.put("begintime", Long.valueOf(iVar.f12261f));
        JSONObject jSONObject = iVar.f12260e;
        if (jSONObject != null) {
            contentValues.put("content", jSONObject.toString());
        } else {
            contentValues.put("content", iVar.f12259d);
        }
        contentValues.put("reserve1", iVar.f12263h);
        if (!TextUtils.isEmpty(iVar.f12264i)) {
            contentValues.put("reserve2", iVar.f12264i);
        }
        if (iVar.f12265j) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ctr", "1");
                contentValues.put("extend", jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        new h(this, iVar.f12257b, iVar.f12256a, iVar.f12258c, contentValues).c(this.f12182b.getWritableDatabase());
    }

    public void z(List<c.a.o0.r.i> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        new i(this, list).c(this.f12182b.getWritableDatabase());
    }

    /* loaded from: classes3.dex */
    public abstract class q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f12213a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f12214b;

        public q(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12214b = aVar;
            this.f12213a = false;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12213a : invokeV.booleanValue;
        }

        public abstract boolean b(SQLiteDatabase sQLiteDatabase);

        public void c(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
                return;
            }
            this.f12213a = false;
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    if (b(sQLiteDatabase)) {
                        sQLiteDatabase.setTransactionSuccessful();
                        this.f12213a = true;
                    }
                } catch (RuntimeException e2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "DBError");
                        jSONObject.put("db_size", this.f12214b.o());
                        jSONObject.put("db_log_size", this.f12214b.n());
                        jSONObject.put("exception", Log.getStackTraceString(e2));
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    c.a.o0.r.e.i(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (RuntimeException unused) {
                }
            } catch (Throwable th) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (RuntimeException unused2) {
                }
                throw th;
            }
        }

        public /* synthetic */ q(a aVar, h hVar) {
            this(aVar);
        }
    }
}
