package c.a.q0.s.q;

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
/* loaded from: classes3.dex */
public class i1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<UserData> f14233a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<UserData> f14234b;

    /* renamed from: c  reason: collision with root package name */
    public b1 f14235c;

    /* renamed from: d  reason: collision with root package name */
    public int f14236d;

    /* renamed from: e  reason: collision with root package name */
    public int f14237e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14238f;

    /* renamed from: g  reason: collision with root package name */
    public String f14239g;

    /* renamed from: h  reason: collision with root package name */
    public int f14240h;

    /* renamed from: i  reason: collision with root package name */
    public String f14241i;

    /* renamed from: j  reason: collision with root package name */
    public int f14242j;

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
        this.f14233a = new ArrayList<>();
        this.f14234b = new ArrayList<>();
        this.f14235c = new b1();
    }

    public ArrayList<UserData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14234b : (ArrayList) invokeV.objValue;
    }

    public ArrayList<UserData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14233a : (ArrayList) invokeV.objValue;
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
                        this.f14233a.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i3));
                        userData2.mAttentionType = 1;
                        this.f14234b.add(userData2);
                    }
                }
                this.f14235c.i(jSONObject.optJSONObject("page"));
                if (this.f14235c != null) {
                    this.f14236d = this.f14235c.a();
                    this.f14237e = this.f14235c.f();
                    if (this.f14235c.b() != 1) {
                        z = false;
                    }
                    this.f14238f = z;
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
                        this.f14233a.add(userData3);
                    }
                }
                if (optJSONArray4 != null) {
                    for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                        UserData userData4 = new UserData();
                        userData4.parserJson(optJSONArray4.getJSONObject(i5));
                        userData4.mAttentionType = 1;
                        userData4.setHave_attention(1);
                        this.f14234b.add(userData4);
                    }
                }
                this.f14236d = jSONObject.optInt("pn");
                this.f14237e = jSONObject.optInt("total_follow_num", 0);
                if (jSONObject.optInt("has_more", 0) != 1) {
                    z = false;
                }
                this.f14238f = z;
                this.f14242j = jSONObject.optInt("follow_list_switch", 0);
            }
            this.f14241i = jSONObject.optString("tips_text");
            this.f14240h = jSONObject.optInt("type", 0);
            this.f14239g = jSONObject.optString("block_text");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
