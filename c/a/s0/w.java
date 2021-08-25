package c.a.s0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29976a;

    /* renamed from: b  reason: collision with root package name */
    public int f29977b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f29978c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f29979d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f29980e;

    /* renamed from: f  reason: collision with root package name */
    public String f29981f;

    /* renamed from: g  reason: collision with root package name */
    public int f29982g;

    /* renamed from: h  reason: collision with root package name */
    public int f29983h;

    /* renamed from: i  reason: collision with root package name */
    public int f29984i;

    /* renamed from: j  reason: collision with root package name */
    public int f29985j;
    public List<j> k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1349982256, "Lc/a/s0/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1349982256, "Lc/a/s0/w;");
                return;
            }
        }
        l = AppConfig.isDebug();
    }

    public w(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.f29978c = jSONObject;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29980e : (JSONObject) invokeV.objValue;
    }

    public List<j> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29982g : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29985j : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29984i : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29983h : invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29981f : (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f29976a : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f29977b : invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                if (this.f29978c != null && this.f29978c.length() != 0) {
                    JSONObject jSONObject = this.f29978c;
                    this.f29979d = jSONObject.optJSONObject("set");
                    this.f29976a = jSONObject.optInt("threshold", 10000);
                    this.f29977b = jSONObject.optInt("timeup", 604800000);
                    this.f29981f = jSONObject.optString(ShaderParams.VALUE_TYPE_STEP);
                    jSONObject.optString(StickerDataChangeType.REPLACE);
                    this.f29980e = jSONObject.optJSONObject("del");
                    this.f29982g = jSONObject.optInt("all_size", 614400);
                    this.f29983h = jSONObject.optInt("single_size", 153600);
                    this.f29984i = jSONObject.optInt("real_size", 614400);
                    this.f29985j = jSONObject.optInt("non_real_size", 614400);
                    int i2 = 1;
                    if (this.f29979d != null) {
                        Iterator<String> keys = this.f29979d.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next) && (optJSONObject = this.f29979d.optJSONObject(next)) != null && optJSONObject.length() != 0) {
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                                String optString = optJSONObject.optString("version");
                                if (optJSONObject2 != null && !TextUtils.isEmpty(optString)) {
                                    Iterator<String> it = keys;
                                    j jVar = new j(next, optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH, i2) != 0, optJSONObject2.optInt(Constant.IS_REAL, 0) == 1, optJSONObject2.optInt("timeout", 60), optJSONObject2.optInt("type", 0), optJSONObject2.optInt("isAbtest", 0) == 1);
                                    if (m.a(next)) {
                                        jVar.z(optJSONObject2.optInt("isSend", 1) == 1);
                                    }
                                    if (optJSONObject2.has("rate")) {
                                        jVar.E(optJSONObject2.getInt("rate"));
                                    }
                                    if (optJSONObject2.has("c")) {
                                        jVar.v(optJSONObject2.getString("c"));
                                    }
                                    if (optJSONObject2.has("limitUnit")) {
                                        jVar.B(optJSONObject2.getInt("limitUnit"));
                                    }
                                    if (optJSONObject2.has("limitCnt")) {
                                        jVar.A(optJSONObject2.getInt("limitCnt"));
                                    }
                                    if (optJSONObject2.has(Constant.ID_TYPE)) {
                                        jVar.x(optJSONObject2.getInt(Constant.ID_TYPE));
                                    }
                                    jVar.D(optJSONObject2.optInt("ch", 0) == 1);
                                    if (optJSONObject2.has("dfc")) {
                                        jVar.y(optJSONObject2.getInt("dfc") == 1);
                                    }
                                    if (optJSONObject2.has("reallog")) {
                                        jVar.F(optJSONObject2.getInt("reallog") == 1);
                                    }
                                    if (optJSONObject2.has("gflow")) {
                                        jVar.w(optJSONObject2.getInt("gflow"));
                                    }
                                    if (optJSONObject2.has("uploadType")) {
                                        jVar.G(optJSONObject2.optInt("uploadType", -1));
                                    }
                                    int optInt = optJSONObject2.optInt("lcache", 2);
                                    if (optInt == 1 || optInt == 0) {
                                        jVar.C(optInt);
                                    }
                                    jVar.H(optString);
                                    this.k.add(jVar);
                                    keys = it;
                                    i2 = 1;
                                }
                            }
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            } catch (JSONException e2) {
                if (l) {
                    e2.printStackTrace();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void k(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.k = list;
        }
    }

    public w(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.k.addAll(list);
    }
}
