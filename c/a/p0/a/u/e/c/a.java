package c.a.p0.a.u.e.c;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.e2.c.i;
import c.a.p0.a.e2.c.j.b;
import c.a.p0.a.s1.e;
import c.a.p0.a.s1.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final String f8779e;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f8780f;

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f8781g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public int f8782d;

    /* renamed from: c.a.p0.a.u.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0387a implements c.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8783e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f8784f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8785g;

        public C0387a(a aVar, String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8785g = aVar;
            this.f8783e = str;
            this.f8784f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    this.f8785g.B(this.f8783e, this.f8784f);
                } else {
                    this.f8785g.d(this.f8783e, new c.a.p0.a.u.h.b(iVar.b(), c.a.p0.a.e2.c.d.f(iVar.b())));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8786e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f8787f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8788g;

        public b(a aVar, String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8788g = aVar;
            this.f8786e = str;
            this.f8787f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    this.f8788g.B(this.f8786e, this.f8787f);
                } else {
                    this.f8788g.d(this.f8786e, new c.a.p0.a.u.h.b(iVar.b(), c.a.p0.a.e2.c.d.f(iVar.b())));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f8789a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8790b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f8791c;

        public c(a aVar, d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8791c = aVar;
            this.f8789a = dVar;
            this.f8790b = str;
        }

        @Override // c.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d dVar = this.f8789a;
                int i2 = dVar.f8799h;
                if (i2 == 0) {
                    this.f8791c.v(dVar, this.f8790b);
                } else if (i2 != 1) {
                } else {
                    this.f8791c.y(dVar, this.f8790b);
                }
            }
        }

        @Override // c.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f8791c.d(this.f8790b, new c.a.p0.a.u.h.b(i2, str));
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f8792a;

        /* renamed from: b  reason: collision with root package name */
        public long f8793b;

        /* renamed from: c  reason: collision with root package name */
        public long f8794c;

        /* renamed from: d  reason: collision with root package name */
        public String f8795d;

        /* renamed from: e  reason: collision with root package name */
        public int f8796e;

        /* renamed from: f  reason: collision with root package name */
        public long f8797f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.p0.a.u.h.b f8798g;

        /* renamed from: h  reason: collision with root package name */
        public int f8799h;

        public d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8799h = i2;
            this.f8797f = -1L;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.a.u.h.b bVar = this.f8798g;
                return bVar != null && bVar.isSuccess();
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1123143521, "Lc/a/p0/a/u/e/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1123143521, "Lc/a/p0/a/u/e/c/a;");
                return;
            }
        }
        f8779e = SchemeConfig.getSchemeHead() + "://swan/";
        f8780f = new String[]{"_id", "account_name", "calendar_displayName"};
        f8781g = new String[]{"_id", "calendar_id", "title", "dtstart", "dtend"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8782d = -1;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION, THROW, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final long A(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            Cursor query = i().getContentResolver().query(CalendarContract.Events.CONTENT_URI, f8781g, "((account_name = ?))", new String[]{"智能小程序"}, null);
            if (query != null) {
                try {
                    if (query.getCount() >= 1) {
                        query.moveToFirst();
                        do {
                            long j2 = query.getLong(query.getColumnIndex("_id"));
                            String string = query.getString(query.getColumnIndex("title"));
                            long j3 = query.getLong(query.getColumnIndex("dtstart"));
                            long j4 = query.getLong(query.getColumnIndex("dtend"));
                            if (TextUtils.equals(dVar.f8792a, string) && j3 == dVar.f8793b && j4 == dVar.f8794c) {
                                if (query != null) {
                                    query.close();
                                }
                                return j2;
                            }
                        } while (query.moveToNext());
                        if (query != null) {
                            query.close();
                        }
                        return -1L;
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public final void B(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
            e.g(new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"}, 4, i(), new c(this, dVar, str));
        }
    }

    public final void C(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TbEnum.SystemMessage.KEY_EVENT_ID, j2 + "");
            } catch (JSONException e2) {
                if (c.a.p0.a.u.c.d.f8735c) {
                    e2.printStackTrace();
                }
            }
            d(str, new c.a.p0.a.u.h.b(0, jSONObject));
        }
    }

    public final d D(JSONObject jSONObject, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, jSONObject, i2)) == null) {
            d dVar = new d(i2);
            if (i2 == 0) {
                String optString = jSONObject.optString("title");
                dVar.f8792a = optString;
                if (TextUtils.isEmpty(optString)) {
                    c.a.p0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar requires a valid title");
                    dVar.f8798g = new c.a.p0.a.u.h.b(1001, "addEventOnCalendar requires a valid title");
                    return dVar;
                }
                long optLong = jSONObject.optLong("startTime", -1L);
                dVar.f8793b = optLong;
                if (optLong == -1) {
                    c.a.p0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar requires a valid startTime");
                    dVar.f8798g = new c.a.p0.a.u.h.b(1001, "addEventOnCalendar requires a valid startTime");
                    return dVar;
                }
                long optLong2 = jSONObject.optLong("endTime", -1L);
                dVar.f8794c = optLong2;
                if (optLong2 < dVar.f8793b) {
                    c.a.p0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar requires a valid endTime");
                    dVar.f8798g = new c.a.p0.a.u.h.b(1001, "addEventOnCalendar requires a valid endTime");
                    return dVar;
                }
                dVar.f8796e = jSONObject.optInt("remindMinutesBefore", 10);
                dVar.f8795d = jSONObject.optString("location");
                String optString2 = jSONObject.optString("url");
                if (!TextUtils.isEmpty(optString2)) {
                    if (optString2.startsWith(f8779e)) {
                        dVar.f8792a += " " + optString2;
                    } else {
                        dVar.f8798g = new c.a.p0.a.u.h.b(2002, "invalid url");
                        return dVar;
                    }
                }
                dVar.f8798g = new c.a.p0.a.u.h.b(0);
            } else if (i2 == 1) {
                long optLong3 = jSONObject.optLong(TbEnum.SystemMessage.KEY_EVENT_ID, -1L);
                dVar.f8797f = optLong3;
                if (optLong3 == -1) {
                    c.a.p0.a.e0.d.b("Api-CalendarApi", "deleteEventOnCalendar requires a valid eventId");
                    dVar.f8798g = new c.a.p0.a.u.h.b(1001, "deleteEventOnCalendar requires a valid eventId");
                } else {
                    dVar.f8798g = new c.a.p0.a.u.h.b(0);
                }
            }
            return dVar;
        }
        return (d) invokeLI.objValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context i2 = i();
            Cursor query = i2.getContentResolver().query(CalendarContract.Calendars.CONTENT_URI, f8780f, "((account_name = ?) AND (calendar_displayName = ?))", new String[]{"智能小程序", "智能小程序"}, null);
            if (query != null) {
                try {
                    if (query.getCount() >= 1) {
                        query.moveToFirst();
                        int i3 = query.getInt(query.getColumnIndex("_id"));
                        if (query != null) {
                            query.close();
                        }
                        return i3;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
            int w = w(i2);
            if (query != null) {
                query.close();
            }
            return w;
        }
        return invokeV.intValue;
    }

    public c.a.p0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            boolean z = c.a.p0.a.u.c.d.f8735c;
            if (l()) {
                c.a.p0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar does not supported when app is invisible.");
                return new c.a.p0.a.u.h.b(1001, "addEventOnCalendar does not supported when app is invisible.");
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-CalendarApi", str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) b2.first;
            if (bVar.isSuccess() && (obj = b2.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                d D = D(jSONObject, 0);
                if (!D.a()) {
                    return D.f8798g;
                }
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.p0.a.u.h.b(1001, "addEventOnCalendar requires cb");
                }
                c.a.p0.a.a2.e.i().T().g(i(), "scope_calendar", new C0387a(this, optString, D));
                return new c.a.p0.a.u.h.b(0);
            }
            c.a.p0.a.e0.d.b("Api-CalendarApi", "parse fail");
            return bVar;
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void v(d dVar, String str) {
        String lastPathSegment;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, dVar, str) == null) {
            int z = z();
            if (z == -1) {
                d(str, new c.a.p0.a.u.h.b(2003, "addEventOnCalendar fail , system error"));
                return;
            }
            long A = A(dVar);
            if (A > 0) {
                C(str, A);
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("calendar_id", Integer.valueOf(z));
            contentValues.put("accessLevel", (Integer) 3);
            contentValues.put("eventTimezone", "Asia/Shanghai");
            contentValues.put("eventEndTimezone", "Asia/Shanghai");
            contentValues.put("dtstart", Long.valueOf(dVar.f8793b));
            contentValues.put("dtend", Long.valueOf(dVar.f8794c));
            contentValues.put("title", dVar.f8792a);
            if (!TextUtils.isEmpty(dVar.f8795d)) {
                contentValues.put("eventLocation", dVar.f8795d);
            }
            ContentResolver contentResolver = i().getContentResolver();
            Uri insert = contentResolver.insert(CalendarContract.Events.CONTENT_URI, contentValues);
            if (insert != null && (lastPathSegment = insert.getLastPathSegment()) != null) {
                try {
                    j2 = Long.parseLong(lastPathSegment);
                } catch (NumberFormatException e2) {
                    if (c.a.p0.a.u.c.d.f8735c) {
                        e2.printStackTrace();
                    }
                    j2 = -1;
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(j2));
                contentValues2.put("minutes", Integer.valueOf(dVar.f8796e));
                contentValues2.put("method", (Integer) 1);
                Uri insert2 = contentResolver.insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
                if (insert2 != null && ContentUris.parseId(insert2) != 0) {
                    C(str, j2);
                    return;
                } else {
                    d(str, new c.a.p0.a.u.h.b(2003, "addEventOnCalendar fail , system error"));
                    return;
                }
            }
            d(str, new c.a.p0.a.u.h.b(2003, "addEventOnCalendar fail , system error"));
        }
    }

    public final int w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("account_name", "智能小程序");
            contentValues.put("account_type", "LOCAL");
            contentValues.put("calendar_displayName", "智能小程序");
            contentValues.put("visible", (Integer) 1);
            contentValues.put("calendar_access_level", (Integer) 700);
            contentValues.put("sync_events", (Integer) 1);
            contentValues.put("calendar_timezone", "Asia/Shanghai");
            contentValues.put("ownerAccount", "智能小程序");
            Uri insert = context.getContentResolver().insert(CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", "智能小程序").appendQueryParameter("account_type", "LOCAL").build(), contentValues);
            if (insert == null) {
                return -1;
            }
            return (int) ContentUris.parseId(insert);
        }
        return invokeL.intValue;
    }

    public c.a.p0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            boolean z = c.a.p0.a.u.c.d.f8735c;
            if (l()) {
                c.a.p0.a.e0.d.b("Api-CalendarApi", "deleteEventOnCalendar does not supported when app is invisible.");
                return new c.a.p0.a.u.h.b(1001, "deleteEventOnCalendar does not supported when app is invisible.");
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-CalendarApi", str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) b2.first;
            if (bVar.isSuccess() && (obj = b2.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                d D = D(jSONObject, 1);
                if (!D.a()) {
                    return D.f8798g;
                }
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.p0.a.u.h.b(1001, "deleteEventOnCalendar requires cb");
                }
                c.a.p0.a.a2.e.i().T().g(i(), "scope_calendar", new b(this, optString, D));
                return new c.a.p0.a.u.h.b(0);
            }
            c.a.p0.a.e0.d.b("Api-CalendarApi", "parse fail");
            return bVar;
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void y(d dVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, dVar, str) == null) {
            if (z() == -1) {
                d(str, new c.a.p0.a.u.h.b(2102, "deleteEventOnCalendar fail , system error"));
                return;
            }
            int delete = i().getContentResolver().delete(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, dVar.f8797f), null, null);
            if (delete < 0) {
                d(str, new c.a.p0.a.u.h.b(2102, "deleteEventOnCalendar fail , system error"));
            } else if (delete == 0) {
                d(str, new c.a.p0.a.u.h.b(2101, "deleteEventOnCalendar fail , event not found"));
            } else {
                d(str, new c.a.p0.a.u.h.b(0));
            }
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f8782d == -1) {
                this.f8782d = E();
            }
            return this.f8782d;
        }
        return invokeV.intValue;
    }
}
