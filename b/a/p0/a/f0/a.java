package b.a.p0.a.f0;

import android.content.ContentValues;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;

    /* renamed from: a  reason: collision with root package name */
    public String f4999a;

    /* renamed from: b  reason: collision with root package name */
    public String f5000b;

    /* renamed from: c  reason: collision with root package name */
    public String f5001c;

    /* renamed from: d  reason: collision with root package name */
    public String f5002d;

    /* renamed from: e  reason: collision with root package name */
    public String f5003e;

    /* renamed from: f  reason: collision with root package name */
    public String f5004f;

    /* renamed from: g  reason: collision with root package name */
    public String f5005g;

    /* renamed from: h  reason: collision with root package name */
    public String f5006h;

    /* renamed from: i  reason: collision with root package name */
    public String f5007i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            a aVar = new a();
            if (jSONObject != null) {
                jSONObject.optString("photoFilePath");
                aVar.f4999a = jSONObject.optString("nickName");
                aVar.f5000b = jSONObject.optString("lastName");
                aVar.f5001c = jSONObject.optString("middleName");
                aVar.f5002d = jSONObject.optString("firstName");
                aVar.f5003e = jSONObject.optString("remark");
                aVar.f5004f = jSONObject.optString("mobilePhoneNumber");
                aVar.f5005g = jSONObject.optString("weChatNumber");
                aVar.f5006h = jSONObject.optString("addressCountry");
                aVar.f5007i = jSONObject.optString("addressState");
                aVar.j = jSONObject.optString("addressCity");
                aVar.k = jSONObject.optString("addressStreet");
                aVar.l = jSONObject.optString("addressPostalCode");
                aVar.m = jSONObject.optString("organization");
                aVar.n = jSONObject.optString("title");
                aVar.o = jSONObject.optString("workFaxNumber");
                aVar.p = jSONObject.optString("workPhoneNumber");
                aVar.q = jSONObject.optString("hostNumber");
                aVar.r = jSONObject.optString("email");
                aVar.s = jSONObject.optString("url");
                aVar.t = jSONObject.optString("workAddressCountry");
                aVar.u = jSONObject.optString("workAddressState");
                aVar.v = jSONObject.optString("workAddressCity");
                aVar.w = jSONObject.optString("workAddressStreet");
                aVar.x = jSONObject.optString("workAddressPostalCode");
                aVar.y = jSONObject.optString("homeFaxNumber");
                aVar.z = jSONObject.optString("homePhoneNumber");
                aVar.A = jSONObject.optString("homeAddressCountry");
                aVar.B = jSONObject.optString("homeAddressState");
                aVar.C = jSONObject.optString("homeAddressCity");
                aVar.D = jSONObject.optString("homeAddressStreet");
                aVar.E = jSONObject.optString("homeAddressPostalCode");
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public ContentValues b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data2", (Integer) 3);
            contentValues.put("data1", c());
            contentValues.put("data9", this.l);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.f5006h)) {
                sb.append(this.f5006h);
            }
            if (!TextUtils.isEmpty(this.f5007i)) {
                sb.append(this.f5007i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                sb.append(this.j);
            }
            if (!TextUtils.isEmpty(this.k)) {
                sb.append(this.k);
            }
            if (!TextUtils.isEmpty(this.l)) {
                sb.append(" ");
                sb.append(this.l);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.f5000b)) {
                sb.append(this.f5000b);
            }
            if (!TextUtils.isEmpty(this.f5001c)) {
                sb.append(this.f5001c);
            }
            if (!TextUtils.isEmpty(this.f5002d)) {
                sb.append(this.f5002d);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public ContentValues e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", f());
            contentValues.put("data9", this.E);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.A)) {
                sb.append(this.A);
            }
            if (!TextUtils.isEmpty(this.B)) {
                sb.append(this.B);
            }
            if (!TextUtils.isEmpty(this.C)) {
                sb.append(this.C);
            }
            if (!TextUtils.isEmpty(this.D)) {
                sb.append(this.D);
            }
            if (!TextUtils.isEmpty(this.E)) {
                sb.append(" ");
                sb.append(this.E);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public ContentValues g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 5);
            contentValues.put("data1", this.y);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", this.z);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 10);
            contentValues.put("data1", this.q);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 2);
            contentValues.put("data1", this.f5004f);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", this.f4999a);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/organization");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", this.m);
            contentValues.put("data4", this.n);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/note");
            contentValues.put("data1", this.f5003e);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/website");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", this.s);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/im");
            contentValues.put("data5", (Integer) (-1));
            contentValues.put("data6", AppRuntime.getAppContext().getString(h.aiapps_cantact_wechat_lable));
            contentValues.put("data1", this.f5005g);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data2", (Integer) 2);
            contentValues.put("data1", q());
            contentValues.put("data9", this.x);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.t)) {
                sb.append(this.t);
            }
            if (!TextUtils.isEmpty(this.u)) {
                sb.append(this.u);
            }
            if (!TextUtils.isEmpty(this.v)) {
                sb.append(this.v);
            }
            if (!TextUtils.isEmpty(this.w)) {
                sb.append(this.w);
            }
            if (!TextUtils.isEmpty(this.x)) {
                sb.append(" ");
                sb.append(this.x);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public ContentValues r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 4);
            contentValues.put("data1", this.o);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 3);
            contentValues.put("data1", this.p);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? !TextUtils.isEmpty(this.f5002d) : invokeV.booleanValue;
    }
}
