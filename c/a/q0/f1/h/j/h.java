package c.a.q0.f1.h.j;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes3.dex */
public class h extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f17822i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f17823e;

    /* renamed from: f  reason: collision with root package name */
    public int f17824f;

    /* renamed from: g  reason: collision with root package name */
    public String f17825g;

    /* renamed from: h  reason: collision with root package name */
    public String f17826h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1780480487, "Lc/a/q0/f1/h/j/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1780480487, "Lc/a/q0/f1/h/j/h;");
                return;
            }
        }
        f17822i = BdUniqueId.gen();
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void g(LiveAnswer liveAnswer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, liveAnswer) == null) || liveAnswer == null) {
            return;
        }
        this.f17825g = liveAnswer.banner_url;
        this.f17823e = liveAnswer.banner_high.intValue();
        this.f17824f = liveAnswer.banner_width.intValue();
        this.f17826h = liveAnswer.jump_url;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f17822i : (BdUniqueId) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("img_width", this.f17824f);
                jSONObject.put(BigdayActivityConfig.IMG_URL, this.f17825g);
                jSONObject.put("img_height", this.f17823e);
                jSONObject.put("jump_url", this.f17826h);
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
