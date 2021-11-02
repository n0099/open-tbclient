package b.a.q0.s.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<UserData> f13349a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<UserData> f13350b;

    /* renamed from: c  reason: collision with root package name */
    public b1 f13351c;

    /* renamed from: d  reason: collision with root package name */
    public int f13352d;

    /* renamed from: e  reason: collision with root package name */
    public int f13353e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13354f;

    /* renamed from: g  reason: collision with root package name */
    public String f13355g;

    /* renamed from: h  reason: collision with root package name */
    public int f13356h;

    /* renamed from: i  reason: collision with root package name */
    public String f13357i;
    public int j;

    public i1() {
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
        this.f13349a = new ArrayList<>();
        this.f13350b = new ArrayList<>();
        this.f13351c = new b1();
    }

    public ArrayList<UserData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13350b : (ArrayList) invokeV.objValue;
    }

    public ArrayList<UserData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13349a : (ArrayList) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            boolean z = true;
            if (jSONObject.optJSONObject("page") != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i2));
                        this.f13349a.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i3));
                        userData2.mAttentionType = 1;
                        this.f13350b.add(userData2);
                    }
                }
                this.f13351c.i(jSONObject.optJSONObject("page"));
                if (this.f13351c != null) {
                    this.f13352d = this.f13351c.a();
                    this.f13353e = this.f13351c.f();
                    if (this.f13351c.b() != 1) {
                        z = false;
                    }
                    this.f13354f = z;
                }
                jSONObject.optInt("tafriendnum", 0);
                jSONObject.optInt("commonfriendnum", 0);
            } else {
                JSONArray optJSONArray3 = jSONObject.optJSONArray("follow_list");
                JSONArray optJSONArray4 = jSONObject.optJSONArray("common_follow_list");
                if (optJSONArray3 != null) {
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        UserData userData3 = new UserData();
                        userData3.parserJson(optJSONArray3.getJSONObject(i4));
                        this.f13349a.add(userData3);
                    }
                }
                if (optJSONArray4 != null) {
                    for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                        UserData userData4 = new UserData();
                        userData4.parserJson(optJSONArray4.getJSONObject(i5));
                        userData4.mAttentionType = 1;
                        userData4.setHave_attention(1);
                        this.f13350b.add(userData4);
                    }
                }
                this.f13352d = jSONObject.optInt("pn");
                this.f13353e = jSONObject.optInt("total_follow_num", 0);
                if (jSONObject.optInt("has_more", 0) != 1) {
                    z = false;
                }
                this.f13354f = z;
                this.j = jSONObject.optInt("follow_list_switch", 0);
            }
            this.f13357i = jSONObject.optString("tips_text");
            this.f13356h = jSONObject.optInt("type", 0);
            this.f13355g = jSONObject.optString("block_text");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
