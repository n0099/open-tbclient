package b.a.p0.a.u.e.c;

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
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.s1.e;
import b.a.p0.a.s1.f;
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
public class a extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final String f8042e;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f8043f;

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f8044g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public int f8045d;

    /* renamed from: b.a.p0.a.u.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0382a implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8046e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f8047f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8048g;

        public C0382a(a aVar, String str, d dVar) {
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
            this.f8048g = aVar;
            this.f8046e = str;
            this.f8047f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    this.f8048g.A(this.f8046e, this.f8047f);
                } else {
                    this.f8048g.d(this.f8046e, new b.a.p0.a.u.h.b(iVar.b(), b.a.p0.a.e2.c.d.f(iVar.b())));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8049e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f8050f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8051g;

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
            this.f8051g = aVar;
            this.f8049e = str;
            this.f8050f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    this.f8051g.A(this.f8049e, this.f8050f);
                } else {
                    this.f8051g.d(this.f8049e, new b.a.p0.a.u.h.b(iVar.b(), b.a.p0.a.e2.c.d.f(iVar.b())));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f8052a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8053b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f8054c;

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
            this.f8054c = aVar;
            this.f8052a = dVar;
            this.f8053b = str;
        }

        @Override // b.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d dVar = this.f8052a;
                int i2 = dVar.f8062h;
                if (i2 == 0) {
                    this.f8054c.u(dVar, this.f8053b);
                } else if (i2 != 1) {
                } else {
                    this.f8054c.x(dVar, this.f8053b);
                }
            }
        }

        @Override // b.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f8054c.d(this.f8053b, new b.a.p0.a.u.h.b(i2, str));
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f8055a;

        /* renamed from: b  reason: collision with root package name */
        public long f8056b;

        /* renamed from: c  reason: collision with root package name */
        public long f8057c;

        /* renamed from: d  reason: collision with root package name */
        public String f8058d;

        /* renamed from: e  reason: collision with root package name */
        public int f8059e;

        /* renamed from: f  reason: collision with root package name */
        public long f8060f;

        /* renamed from: g  reason: collision with root package name */
        public b.a.p0.a.u.h.b f8061g;

        /* renamed from: h  reason: collision with root package name */
        public int f8062h;

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
            this.f8062h = i2;
            this.f8060f = -1L;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.p0.a.u.h.b bVar = this.f8061g;
                return bVar != null && bVar.isSuccess();
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-230166176, "Lb/a/p0/a/u/e/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-230166176, "Lb/a/p0/a/u/e/c/a;");
                return;
            }
        }
        f8042e = SchemeConfig.getSchemeHead() + "://swan/";
        f8043f = new String[]{"_id", "account_name", "calendar_displayName"};
        f8044g = new String[]{"_id", "calendar_id", "title", "dtstart", "dtend"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8045d = -1;
    }

    public final void A(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            e.h(new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"}, 4, getContext(), new c(this, dVar, str));
        }
    }

    public final void B(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TbEnum.SystemMessage.KEY_EVENT_ID, j + "");
            } catch (JSONException e2) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    e2.printStackTrace();
                }
            }
            d(str, new b.a.p0.a.u.h.b(0, jSONObject));
        }
    }

    public final d C(JSONObject jSONObject, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i2)) == null) {
            d dVar = new d(i2);
            if (i2 == 0) {
                String optString = jSONObject.optString("title");
                dVar.f8055a = optString;
                if (TextUtils.isEmpty(optString)) {
                    b.a.p0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar requires a valid title");
                    dVar.f8061g = new b.a.p0.a.u.h.b(1001, "addEventOnCalendar requires a valid title");
                    return dVar;
                }
                long optLong = jSONObject.optLong("startTime", -1L);
                dVar.f8056b = optLong;
                if (optLong == -1) {
                    b.a.p0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar requires a valid startTime");
                    dVar.f8061g = new b.a.p0.a.u.h.b(1001, "addEventOnCalendar requires a valid startTime");
                    return dVar;
                }
                long optLong2 = jSONObject.optLong("endTime", -1L);
                dVar.f8057c = optLong2;
                if (optLong2 < dVar.f8056b) {
                    b.a.p0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar requires a valid endTime");
                    dVar.f8061g = new b.a.p0.a.u.h.b(1001, "addEventOnCalendar requires a valid endTime");
                    return dVar;
                }
                dVar.f8059e = jSONObject.optInt("remindMinutesBefore", 10);
                dVar.f8058d = jSONObject.optString("location");
                String optString2 = jSONObject.optString("url");
                if (!TextUtils.isEmpty(optString2)) {
                    if (optString2.startsWith(f8042e)) {
                        dVar.f8055a += " " + optString2;
                    } else {
                        dVar.f8061g = new b.a.p0.a.u.h.b(2002, "invalid url");
                        return dVar;
                    }
                }
                dVar.f8061g = new b.a.p0.a.u.h.b(0);
            } else if (i2 == 1) {
                long optLong3 = jSONObject.optLong(TbEnum.SystemMessage.KEY_EVENT_ID, -1L);
                dVar.f8060f = optLong3;
                if (optLong3 == -1) {
                    b.a.p0.a.e0.d.b("Api-CalendarApi", "deleteEventOnCalendar requires a valid eventId");
                    dVar.f8061g = new b.a.p0.a.u.h.b(1001, "deleteEventOnCalendar requires a valid eventId");
                } else {
                    dVar.f8061g = new b.a.p0.a.u.h.b(0);
                }
            }
            return dVar;
        }
        return (d) invokeLI.objValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = getContext();
            Cursor query = context.getContentResolver().query(CalendarContract.Calendars.CONTENT_URI, f8043f, "((account_name = ?) AND (calendar_displayName = ?))", new String[]{"智能小程序", "智能小程序"}, null);
            if (query != null) {
                try {
                    if (query.getCount() >= 1) {
                        query.moveToFirst();
                        int i2 = query.getInt(query.getColumnIndex("_id"));
                        if (query != null) {
                            query.close();
                        }
                        return i2;
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
            int v = v(context);
            if (query != null) {
                query.close();
            }
            return v;
        }
        return invokeV.intValue;
    }

    public b.a.p0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            if (k()) {
                b.a.p0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar does not supported when app is invisible.");
                return new b.a.p0.a.u.h.b(1001, "addEventOnCalendar does not supported when app is invisible.");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-CalendarApi", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (bVar.isSuccess() && (obj = b2.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                d C = C(jSONObject, 0);
                if (!C.a()) {
                    return C.f8061g;
                }
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(1001, "addEventOnCalendar requires cb");
                }
                b.a.p0.a.a2.e.i().S().g(getContext(), "scope_calendar", new C0382a(this, optString, C));
                return new b.a.p0.a.u.h.b(0);
            }
            b.a.p0.a.e0.d.b("Api-CalendarApi", "parse fail");
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void u(d dVar, String str) {
        String lastPathSegment;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, dVar, str) == null) {
            int y = y();
            if (y == -1) {
                d(str, new b.a.p0.a.u.h.b(2003, "addEventOnCalendar fail , system error"));
                return;
            }
            long z = z(dVar);
            if (z > 0) {
                B(str, z);
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("calendar_id", Integer.valueOf(y));
            contentValues.put("accessLevel", (Integer) 3);
            contentValues.put("eventTimezone", "Asia/Shanghai");
            contentValues.put("eventEndTimezone", "Asia/Shanghai");
            contentValues.put("dtstart", Long.valueOf(dVar.f8056b));
            contentValues.put("dtend", Long.valueOf(dVar.f8057c));
            contentValues.put("title", dVar.f8055a);
            if (!TextUtils.isEmpty(dVar.f8058d)) {
                contentValues.put("eventLocation", dVar.f8058d);
            }
            ContentResolver contentResolver = getContext().getContentResolver();
            Uri insert = contentResolver.insert(CalendarContract.Events.CONTENT_URI, contentValues);
            if (insert != null && (lastPathSegment = insert.getLastPathSegment()) != null) {
                try {
                    j = Long.parseLong(lastPathSegment);
                } catch (NumberFormatException e2) {
                    if (b.a.p0.a.u.c.d.f8000c) {
                        e2.printStackTrace();
                    }
                    j = -1;
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(j));
                contentValues2.put("minutes", Integer.valueOf(dVar.f8059e));
                contentValues2.put("method", (Integer) 1);
                Uri insert2 = contentResolver.insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
                if (insert2 != null && ContentUris.parseId(insert2) != 0) {
                    B(str, j);
                    return;
                } else {
                    d(str, new b.a.p0.a.u.h.b(2003, "addEventOnCalendar fail , system error"));
                    return;
                }
            }
            d(str, new b.a.p0.a.u.h.b(2003, "addEventOnCalendar fail , system error"));
        }
    }

    public final int v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
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

    public b.a.p0.a.u.h.b w(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            if (k()) {
                b.a.p0.a.e0.d.b("Api-CalendarApi", "deleteEventOnCalendar does not supported when app is invisible.");
                return new b.a.p0.a.u.h.b(1001, "deleteEventOnCalendar does not supported when app is invisible.");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-CalendarApi", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (bVar.isSuccess() && (obj = b2.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                d C = C(jSONObject, 1);
                if (!C.a()) {
                    return C.f8061g;
                }
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(1001, "deleteEventOnCalendar requires cb");
                }
                b.a.p0.a.a2.e.i().S().g(getContext(), "scope_calendar", new b(this, optString, C));
                return new b.a.p0.a.u.h.b(0);
            }
            b.a.p0.a.e0.d.b("Api-CalendarApi", "parse fail");
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void x(d dVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar, str) == null) {
            if (y() == -1) {
                d(str, new b.a.p0.a.u.h.b(2102, "deleteEventOnCalendar fail , system error"));
                return;
            }
            int delete = getContext().getContentResolver().delete(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, dVar.f8060f), null, null);
            if (delete < 0) {
                d(str, new b.a.p0.a.u.h.b(2102, "deleteEventOnCalendar fail , system error"));
            } else if (delete == 0) {
                d(str, new b.a.p0.a.u.h.b(2101, "deleteEventOnCalendar fail , event not found"));
            } else {
                d(str, new b.a.p0.a.u.h.b(0));
            }
        }
    }

    public final int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f8045d == -1) {
                this.f8045d = D();
            }
            return this.f8045d;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION, THROW, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final long z(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, dVar)) == null) {
            Cursor query = getContext().getContentResolver().query(CalendarContract.Events.CONTENT_URI, f8044g, "((account_name = ?))", new String[]{"智能小程序"}, null);
            if (query != null) {
                try {
                    if (query.getCount() >= 1) {
                        query.moveToFirst();
                        do {
                            long j = query.getLong(query.getColumnIndex("_id"));
                            String string = query.getString(query.getColumnIndex("title"));
                            long j2 = query.getLong(query.getColumnIndex("dtstart"));
                            long j3 = query.getLong(query.getColumnIndex("dtend"));
                            if (TextUtils.equals(dVar.f8055a, string) && j2 == dVar.f8056b && j3 == dVar.f8057c) {
                                if (query != null) {
                                    query.close();
                                }
                                return j;
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
}
