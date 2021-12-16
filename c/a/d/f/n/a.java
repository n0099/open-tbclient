package c.a.d.f.n;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.Typography;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<BasicNameValuePair> a;

    /* renamed from: b  reason: collision with root package name */
    public String f2486b;

    /* renamed from: c  reason: collision with root package name */
    public StringBuilder f2487c;

    /* renamed from: d  reason: collision with root package name */
    public long f2488d;

    /* renamed from: e  reason: collision with root package name */
    public h f2489e;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f2486b = null;
        this.f2487c = new StringBuilder(100);
        this.f2486b = str;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str.replace(" ", "_").replace(PreferencesUtil.LEFT_MOUNT, "(").replace(PreferencesUtil.RIGHT_MOUNT, SmallTailInfo.EMOTION_SUFFIX).replace("&", "|") : (String) invokeL.objValue;
    }

    public void a(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, obj, obj2) == null) || obj == null || obj2 == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        this.a.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (this.f2487c.length() > 0) {
            this.f2487c.append(Typography.amp);
        }
        this.f2487c.append(str);
        this.f2487c.append("=");
        try {
            this.f2487c.append(URLEncoder.encode(i(str2), "utf-8"));
        } catch (Throwable th) {
            BdLog.e(th);
            this.f2487c.append(i(str2));
        }
    }

    public void c(Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) == null) || objArr == null) {
            return;
        }
        for (int i2 = 0; i2 < objArr.length / 2; i2++) {
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            if (i4 < objArr.length) {
                a(objArr[i3], objArr[i4]);
            }
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            if (this.f2489e == null) {
                this.f2489e = new h();
            }
            this.f2489e.f(dVar);
            ArrayList<BasicNameValuePair> arrayList = this.a;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<BasicNameValuePair> it = this.a.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if ("module".equals(next.getName())) {
                        this.f2489e.i(next.getValue());
                    } else if ("st".equals(next.getName())) {
                        this.f2489e.e(next.getValue());
                    } else if ("errNo".equals(next.getName())) {
                        this.f2489e.g(next.getValue());
                    } else if ("errMsg".equals(next.getName())) {
                        this.f2489e.h(next.getValue());
                    } else {
                        this.f2489e.b(next.getName(), next.getValue());
                    }
                }
            }
            StringBuilder sb = this.f2487c;
            if (sb != null) {
                this.f2489e.a(sb.toString());
            }
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? System.currentTimeMillis() - this.f2488d : invokeV.longValue;
    }

    public h f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2489e : (h) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f2488d = System.currentTimeMillis();
        }
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2486b : (String) invokeV.objValue;
    }

    public JSONObject h() {
        InterceptResult invokeV;
        String[] split;
        String[] split2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.f2487c.length() > 0 && (split = this.f2487c.toString().split("&")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && (split2 = str.split("=")) != null && split2.length == 2) {
                        try {
                            jSONObject.put(split2[0], URLDecoder.decode(split2[1], "utf-8"));
                        } catch (UnsupportedEncodingException | JSONException e2) {
                            BdLog.e(e2);
                        }
                    }
                }
            }
            ArrayList<BasicNameValuePair> arrayList = this.a;
            if (arrayList != null) {
                Iterator<BasicNameValuePair> it = arrayList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                        try {
                            jSONObject.put(next.getName(), URLEncoder.encode(i(next.getValue()), "utf-8"));
                        } catch (UnsupportedEncodingException | JSONException e3) {
                            BdLog.e(e3);
                        }
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder(200);
            if (this.f2487c.length() > 0) {
                sb.append((CharSequence) this.f2487c);
            }
            ArrayList<BasicNameValuePair> arrayList = this.a;
            if (arrayList != null) {
                Iterator<BasicNameValuePair> it = arrayList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                        if (sb.length() > 0) {
                            sb.append(Typography.amp);
                        }
                        sb.append(next.getName());
                        sb.append(com.alipay.sdk.encrypt.a.f31721h);
                        try {
                            sb.append(URLEncoder.encode(i(next.getValue()), "utf-8"));
                        } catch (UnsupportedEncodingException e2) {
                            BdLog.e(e2);
                            sb.append(i(next.getValue()));
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

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
                return;
            }
        }
        this.f2486b = null;
        this.f2487c = new StringBuilder(100);
    }
}
