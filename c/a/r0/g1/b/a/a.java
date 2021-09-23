package c.a.r0.g1.b.a;

import c.a.q0.s.q.d2;
import c.a.q0.s.q.l0;
import c.a.q0.s.q.n;
import c.a.r0.g1.j.h.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.BannerImage;
import tbclient.RecomTopicList;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f17771a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d2> f17772b;

    /* renamed from: c  reason: collision with root package name */
    public n f17773c;

    /* renamed from: d  reason: collision with root package name */
    public l0 f17774d;

    /* renamed from: e  reason: collision with root package name */
    public b f17775e;

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
        this.f17771a = true;
    }

    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17773c : (n) invokeV.objValue;
    }

    public l0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17774d : (l0) invokeV.objValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17775e : (b) invokeV.objValue;
    }

    public ArrayList<d2> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17772b : (ArrayList) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f17771a : invokeV.booleanValue;
    }

    public void f(JSONObject jSONObject) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                this.f17772b = new ArrayList<>(optJSONArray.length());
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    if (jSONObject2 != null) {
                        d2 d2Var = new d2();
                        d2Var.X2(jSONObject2);
                        d2Var.G1();
                        this.f17772b.add(d2Var);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("banner_list");
            if (optJSONArray2 != null) {
                this.f17773c = new n();
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i4);
                    if (optJSONObject != null) {
                        BannerImage.Builder builder = new BannerImage.Builder();
                        builder.ahead_url = optJSONObject.optString("ahead_url");
                        builder.img_url = optJSONObject.optString(BigdayActivityConfig.IMG_URL);
                        builder.title = optJSONObject.optString("title");
                        arrayList.add(builder.build(true));
                    }
                }
                this.f17773c.parserProtobuf(arrayList);
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("grid");
            if (optJSONArray3 != null && optJSONArray3.length() >= 4) {
                this.f17774d = new l0();
                ArrayList arrayList2 = new ArrayList();
                for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i5);
                    if (optJSONObject2 != null) {
                        BannerImage.Builder builder2 = new BannerImage.Builder();
                        builder2.ahead_url = optJSONObject2.optString("ahead_url");
                        builder2.img_url = optJSONObject2.optString(BigdayActivityConfig.IMG_URL);
                        builder2.title = optJSONObject2.optString("title");
                        arrayList2.add(builder2.build(true));
                    }
                }
                this.f17774d.parserProtobuf(arrayList2);
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("module_list");
            JSONArray jSONArray = null;
            int i6 = 0;
            while (true) {
                if (i6 >= optJSONArray4.length()) {
                    i2 = 0;
                    break;
                }
                JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i6);
                if ("hot_topic".equals(optJSONObject3.optString("type"))) {
                    jSONArray = optJSONObject3.optJSONArray("hot_topic");
                    i2 = optJSONObject3.optInt("position");
                    break;
                }
                i6++;
            }
            if (jSONArray == null || jSONArray.length() < 4) {
                return;
            }
            ArrayList arrayList3 = new ArrayList();
            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                JSONObject optJSONObject4 = jSONArray.optJSONObject(i7);
                if (optJSONObject4 != null && i7 < 6) {
                    RecomTopicList.Builder builder3 = new RecomTopicList.Builder();
                    builder3.topic_id = Long.valueOf(c.a.e.e.m.b.g(optJSONObject4.optString("topic_id"), 0L));
                    builder3.topic_name = optJSONObject4.optString(IntentConfig.TOPIC_NAME);
                    builder3.topic_desc = optJSONObject4.optString("topic_desc");
                    builder3.tag = Integer.valueOf(optJSONObject4.optInt("tag"));
                    builder3.topic_pic = optJSONObject4.optString("topic_pic");
                    builder3.type = Integer.valueOf(optJSONObject4.optInt("type"));
                    builder3.discuss_num = Long.valueOf(c.a.e.e.m.b.g(optJSONObject4.optString("discuss_num"), 0L));
                    arrayList3.add(builder3.build(true));
                }
                b bVar = new b();
                this.f17775e = bVar;
                bVar.floorPosition = i2;
                bVar.parserProtobuf(arrayList3);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
