package c.a.n0.a.f0.b;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import c.a.n0.a.a2.e;
import c.a.n0.a.c2.f.a0;
import c.a.n0.a.e2.c.d;
import c.a.n0.a.e2.c.i;
import c.a.n0.a.e2.c.j.b;
import c.a.n0.a.j2.k;
import c.a.n0.a.s1.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.f0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0169a implements c.a.n0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5373e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f5374f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f5375g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5376h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5377i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f5378j;
        public final /* synthetic */ Activity k;
        public final /* synthetic */ a l;

        public C0169a(a aVar, e eVar, Context context, boolean z, String str, CallbackHandler callbackHandler, String str2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, context, Boolean.valueOf(z), str, callbackHandler, str2, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = aVar;
            this.f5373e = eVar;
            this.f5374f = context;
            this.f5375g = z;
            this.f5376h = str;
            this.f5377i = callbackHandler;
            this.f5378j = str2;
            this.k = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                boolean e2 = this.f5373e.j().e(this.f5374f);
                if (!d.h(iVar)) {
                    if (!e2 && !this.f5375g) {
                        k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 7, this.f5376h);
                    }
                    d.p(iVar, this.f5377i, this.f5378j);
                    return;
                }
                if (e2 && !this.f5375g) {
                    k.M("success", 7, this.f5376h);
                }
                c.a.n0.a.e0.d.g("ReadContacts", "request authorize success");
                this.l.p(this.k, this.f5377i, this.f5378j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f5379a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5380b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5381c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f5382d;

        public b(a aVar, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5382d = aVar;
            this.f5379a = activity;
            this.f5380b = callbackHandler;
            this.f5381c = str;
        }

        @Override // c.a.n0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f5382d.m(this.f5379a, this.f5380b, this.f5381c);
                c.a.n0.a.e0.d.b("ReadContacts", str + "");
            }
        }

        @Override // c.a.n0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                d.n(10005, this.f5380b, this.f5381c);
                c.a.n0.a.e0.d.b("ReadContacts", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getPhoneContacts");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.n0.a.e0.d.b("ReadContacts", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.a.n0.a.e0.d.b("ReadContacts", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                return false;
            }
            c.a.n0.a.e0.d.g("ReadContacts", "params is:" + optParamsAsJo.toString());
            if (!(context instanceof Activity)) {
                c.a.n0.a.e0.d.b("ReadContacts", "the context is error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the context is error");
                return false;
            }
            Activity activity = (Activity) context;
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.n0.a.e0.d.b("ReadContacts", "the callback is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the callback is null");
                return false;
            }
            String optString2 = optParamsAsJo.optString("invokeFrom");
            boolean e2 = eVar.j().e(context);
            if (!e2) {
                k.M("show", 7, optString2);
            }
            eVar.T().g(activity, "mapp_i_read_contacts", new C0169a(this, eVar, context, e2, optString2, callbackHandler, optString, activity));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final JSONObject l(Context context) throws JSONException {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            JSONArray jSONArray = new JSONArray();
            Cursor query = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, null, null, "raw_contact_id");
            if (query != null && query.getCount() > 0) {
                JSONObject jSONObject = null;
                JSONArray jSONArray2 = null;
                int i2 = -1;
                while (query.moveToNext()) {
                    int i3 = query.getInt(query.getColumnIndex("raw_contact_id"));
                    if (i2 != i3) {
                        if (jSONObject != null && jSONArray2 != null && jSONArray2.length() > 0) {
                            jSONArray.put(jSONObject);
                        }
                        jSONObject = new JSONObject();
                        jSONArray2 = new JSONArray();
                        i2 = i3;
                    }
                    if (jSONObject != null) {
                        String string = query.getString(query.getColumnIndex("mimetype"));
                        switch (string.hashCode()) {
                            case -1079224304:
                                if (string.equals("vnd.android.cursor.item/name")) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1079210633:
                                if (string.equals("vnd.android.cursor.item/note")) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 684173810:
                                if (string.equals("vnd.android.cursor.item/phone_v2")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2034973555:
                                if (string.equals("vnd.android.cursor.item/nickname")) {
                                    c2 = 3;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        if (c2 == 0) {
                            String string2 = query.getString(query.getColumnIndex("data1"));
                            String string3 = query.getString(query.getColumnIndex("data3"));
                            String string4 = query.getString(query.getColumnIndex("data2"));
                            String string5 = query.getString(query.getColumnIndex("data5"));
                            if (string2 == null) {
                                string2 = "";
                            }
                            jSONObject.put("name", string2);
                            if (string3 == null) {
                                string3 = "";
                            }
                            jSONObject.put("lastName", string3);
                            if (string4 == null) {
                                string4 = "";
                            }
                            jSONObject.put("firstName", string4);
                            jSONObject.put("middleName", string5 != null ? string5 : "");
                        } else if (c2 == 1) {
                            String string6 = query.getString(query.getColumnIndex("data1"));
                            jSONObject.put("remark", string6 != null ? string6 : "");
                        } else if (c2 == 2) {
                            String string7 = query.getString(query.getColumnIndex("data1"));
                            if (!TextUtils.isEmpty(string7) && jSONArray2 != null) {
                                jSONArray2.put(string7);
                            }
                            jSONObject.put("phoneNumbers", jSONArray2);
                        } else if (c2 == 3) {
                            jSONObject.put("nickName", query.getString(query.getColumnIndex("data1")));
                        }
                    }
                }
                if (jSONObject != null && jSONArray2 != null && jSONArray2.length() > 0) {
                    jSONArray.put(jSONObject);
                }
                c.a.n0.a.i1.e.a.a(query);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("contacts", jSONArray);
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void m(Activity activity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, callbackHandler, str) == null) {
            try {
                JSONObject l = l(activity);
                if (a0.f4492b) {
                    String str2 = "read contacts:" + l.toString();
                }
                c.a.n0.a.e0.d.b("ReadContacts", "read contacts:" + l.toString());
                o(callbackHandler, str, 0, l);
            } catch (JSONException e2) {
                if (a0.f4492b) {
                    e2.printStackTrace();
                }
                c.a.n0.a.e0.d.b("ReadContacts", "read contacts error caused by JsonException");
                n(callbackHandler, str, 1001, "json parse error");
            }
        }
    }

    public final void n(CallbackHandler callbackHandler, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, callbackHandler, str, i2, str2) == null) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i2, str2).toString());
        }
    }

    public final void o(CallbackHandler callbackHandler, String str, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048580, this, callbackHandler, str, i2, jSONObject) == null) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i2).toString());
        }
    }

    public final void p(Activity activity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, callbackHandler, str) == null) {
            c.a.n0.a.s1.e.e("android.permission.READ_CONTACTS", new String[]{"android.permission.READ_CONTACTS"}, 5, activity, new b(this, activity, callbackHandler, str));
        }
    }
}
