package c.a.r0.w.l.d;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.ala.data.AlaLiveInfoData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.services.vod.VodClient;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AlaUserInfoData f26339a;

    /* renamed from: b  reason: collision with root package name */
    public i f26340b;

    /* renamed from: c  reason: collision with root package name */
    public q f26341c;

    /* renamed from: d  reason: collision with root package name */
    public List<AlaLiveInfoData> f26342d;

    /* renamed from: e  reason: collision with root package name */
    public List<p> f26343e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26344f;

    /* renamed from: g  reason: collision with root package name */
    public final a f26345g;

    /* renamed from: h  reason: collision with root package name */
    public r f26346h;

    public c() {
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
        this.f26344f = false;
        this.f26339a = new AlaUserInfoData();
        this.f26340b = new i();
        this.f26341c = new q();
        this.f26345g = new a();
        this.f26342d = new ArrayList();
        this.f26343e = new ArrayList();
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26345g : (a) invokeV.objValue;
    }

    public AlaUserInfoData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26339a : (AlaUserInfoData) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26344f : invokeV.booleanValue;
    }

    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            JSONObject optJSONObject = jSONObject2.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.f26339a = (AlaUserInfoData) OrmObject.objectWithJson(optJSONObject, AlaUserInfoData.class);
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray("watch_list");
            for (int i2 = 0; optJSONArray != null && i2 < optJSONArray.length(); i2++) {
                p pVar = new p();
                pVar.a(optJSONArray.getJSONObject(i2));
                this.f26343e.add(pVar);
            }
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("live_list");
            for (int i3 = 0; optJSONArray2 != null && optJSONArray2.length() < i3; i3++) {
                AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                alaLiveInfoData.parserJson(optJSONArray2.getJSONObject(i3));
                this.f26342d.add(alaLiveInfoData);
            }
            this.f26340b.a(jSONObject2.optJSONObject(VodClient.PATH_MEDIA));
            this.f26341c.parserJson(jSONObject2.optJSONObject("privacy_set"));
            this.f26345g.parserJson(jSONObject2.optJSONObject("authority_info"));
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("dating_room");
            if (optJSONObject2 != null) {
                r rVar = new r();
                this.f26346h = rVar;
                rVar.a(optJSONObject2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f26344f = z;
        }
    }
}
