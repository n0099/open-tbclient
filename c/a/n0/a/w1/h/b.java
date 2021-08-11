package c.a.n0.a.w1.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import c.a.n0.a.k;
import c.a.n0.a.w1.j.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f9245d;

    /* renamed from: e  reason: collision with root package name */
    public static b f9246e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f9247a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f9248b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f9249c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1285015520, "Lc/a/n0/a/w1/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1285015520, "Lc/a/n0/a/w1/h/b;");
                return;
            }
        }
        f9245d = k.f6803a;
    }

    public b() {
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
        this.f9248b = new HashMap<>();
        this.f9249c = new ArrayList();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f9246e == null) {
                synchronized (b.class) {
                    if (f9246e == null) {
                        f9246e = new b();
                    }
                }
            }
            return f9246e;
        }
        return (b) invokeV.objValue;
    }

    public Bitmap a(String str) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            HashMap<String, c> hashMap = this.f9248b;
            if (hashMap == null || (cVar = hashMap.get(str)) == null) {
                return null;
            }
            return cVar.a();
        }
        return (Bitmap) invokeL.objValue;
    }

    public List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f9249c : (List) invokeV.objValue;
    }

    public Bitmap d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9247a : (Bitmap) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<String> list = this.f9249c;
            return list != null && list.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (f9245d) {
                String str2 = "get emoji info from " + str;
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                String D = c.a.n0.t.d.D(new File(str + File.separator + "emoji.json"));
                if (TextUtils.isEmpty(D)) {
                    boolean z = f9245d;
                    return;
                }
                try {
                    JSONArray optJSONArray = new JSONObject(D).optJSONArray("packages");
                    if (optJSONArray == null) {
                        return;
                    }
                    JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                    if (optJSONObject == null) {
                        return;
                    }
                    String optString = optJSONObject.optString("package_icon");
                    if (!TextUtils.isEmpty(optString)) {
                        this.f9247a = BitmapFactory.decodeFile(str + File.separator + optString);
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("emoticons");
                    this.f9249c.clear();
                    this.f9248b.clear();
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject jSONObject = (JSONObject) optJSONArray2.get(i2);
                            String optString2 = jSONObject.optString("id");
                            String optString3 = jSONObject.optString("text");
                            Bitmap decodeFile = BitmapFactory.decodeFile(str + File.separator + jSONObject.optString("icon"));
                            if (!TextUtils.isEmpty(optString3) && decodeFile != null) {
                                this.f9249c.add(optString3);
                                this.f9248b.put(optString3, new c(optString2, optString3, decodeFile));
                            }
                        }
                        return;
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            boolean z2 = f9245d;
        }
    }

    public SpannableString g(Context context, CharSequence charSequence, TextView textView) {
        InterceptResult invokeLLL;
        Object aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, charSequence, textView)) == null) {
            boolean z = f9245d;
            SpannableString spannableString = new SpannableString(charSequence);
            Matcher matcher = Pattern.compile("\\[([一-龥\\w])+\\]").matcher(spannableString);
            while (matcher.find()) {
                String group = matcher.group();
                int start = matcher.start();
                Bitmap a2 = c().a(group);
                if (a2 == null) {
                    break;
                }
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a2, textSize, textSize, true);
                if (createScaledBitmap != null) {
                    if (textView instanceof EditText) {
                        aVar = new f.b(context.getApplicationContext(), createScaledBitmap);
                    } else {
                        aVar = new f.a(context.getApplicationContext(), createScaledBitmap);
                    }
                    spannableString.setSpan(aVar, start, group.length() + start, 33);
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}
