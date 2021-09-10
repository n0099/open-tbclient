package c.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class p implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final SimpleDateFormat l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f31391e;

    /* renamed from: f  reason: collision with root package name */
    public long f31392f;

    /* renamed from: g  reason: collision with root package name */
    public String f31393g;

    /* renamed from: h  reason: collision with root package name */
    public String f31394h;

    /* renamed from: i  reason: collision with root package name */
    public String f31395i;

    /* renamed from: j  reason: collision with root package name */
    public String f31396j;
    public String k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1868020930, "Lc/b/a/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1868020930, "Lc/b/a/p;");
                return;
            }
        }
        l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31391e = System.currentTimeMillis();
    }

    public static p c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return q.f31411e.get(jSONObject.optString("k_cls", "")).clone().i(jSONObject);
            } catch (Throwable th) {
                h0.b(th);
                return null;
            }
        }
        return (p) invokeL.objValue;
    }

    public static String d(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j2)) == null) ? l.format(new Date(j2)) : (String) invokeJ.objValue;
    }

    @NonNull
    public abstract p a(@NonNull Cursor cursor);

    public abstract void e(@NonNull ContentValues contentValues);

    public abstract void f(@NonNull JSONObject jSONObject);

    public abstract String[] g();

    public final ContentValues h(@Nullable ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, contentValues)) == null) {
            if (contentValues == null) {
                contentValues = new ContentValues();
            } else {
                contentValues.clear();
            }
            e(contentValues);
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public abstract p i(@NonNull JSONObject jSONObject);

    public abstract JSONObject j();

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String[] g2 = g();
            if (g2 != null) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("create table if not exists ");
                sb.append(l());
                sb.append("(");
                for (int i2 = 0; i2 < g2.length; i2 += 2) {
                    sb.append(g2[i2]);
                    sb.append(" ");
                    sb.append(g2[i2 + 1]);
                    sb.append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                return sb.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public abstract String l();

    @NonNull
    public final JSONObject m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("k_cls", l());
                f(jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public final JSONObject n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                this.k = d(this.f31391e);
                return j();
            } catch (JSONException e2) {
                h0.b(e2);
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: o */
    public p clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            try {
                return (p) super.clone();
            } catch (CloneNotSupportedException e2) {
                h0.b(e2);
                return null;
            }
        }
        return (p) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "sid:" + this.f31393g;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (h0.f31347b) {
                String l2 = l();
                if (!getClass().getSimpleName().equalsIgnoreCase(l2)) {
                    l2 = l2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + getClass().getSimpleName();
                }
                String str = this.f31393g;
                String str2 = "-";
                if (str != null) {
                    int indexOf = str.indexOf("-");
                    if (indexOf >= 0) {
                        str = str.substring(0, indexOf);
                    }
                    str2 = str;
                }
                return StringUtil.ARRAY_START + l2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + p() + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f31391e + "}";
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}
