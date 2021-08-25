package c.a.q0.i3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f20562a;

    /* renamed from: b  reason: collision with root package name */
    public int f20563b;

    /* renamed from: c  reason: collision with root package name */
    public int f20564c;

    /* renamed from: d  reason: collision with root package name */
    public int f20565d;

    /* renamed from: e  reason: collision with root package name */
    public int f20566e;

    /* renamed from: f  reason: collision with root package name */
    public String f20567f;

    /* renamed from: g  reason: collision with root package name */
    public String f20568g;

    /* renamed from: h  reason: collision with root package name */
    public List<FeedForumData> f20569h;

    /* renamed from: i  reason: collision with root package name */
    public String f20570i;

    /* renamed from: j  reason: collision with root package name */
    public BlockPopInfoData f20571j;
    public int k;
    public String l;

    public w() {
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
        this.f20569h = new ArrayList();
        this.f20563b = 0;
        this.f20564c = 0;
        t("");
        v(0);
        r(0);
        u(0);
    }

    public BlockPopInfoData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20571j : (BlockPopInfoData) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20570i : (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20565d : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public List<FeedForumData> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20569h : (List) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20567f : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20568g : (String) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f20566e : invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f20563b : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f20564c : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f20562a : invokeV.intValue;
    }

    public final void m(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f20570i = jSONObject.optString("block_dealurl");
        String optString = jSONObject.optString("block_content");
        if (StringUtils.isNull(optString)) {
            return;
        }
        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
        this.f20571j = blockPopInfoData;
        blockPopInfoData.block_info = optString;
        blockPopInfoData.ahead_url = this.f20570i;
        blockPopInfoData.ahead_info = jSONObject.optString("block_confirm");
        this.f20571j.ok_info = jSONObject.optString("block_cancel");
    }

    public void n(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONArray) == null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
                    FeedForumData feedForumData = new FeedForumData();
                    feedForumData.setForumId(jSONObject.optString("forum_id"));
                    feedForumData.setForumName(jSONObject.optString("forum_name"));
                    feedForumData.setMemberCount(jSONObject.optInt("member_count", 0));
                    feedForumData.setPostNum(jSONObject.optInt("post_num", 0));
                    feedForumData.setAvatar(jSONObject.optString("avatar"));
                    feedForumData.setReason(jSONObject.optString("reason"));
                    feedForumData.setIsLike(jSONObject.optInt("is_like", 0));
                    feedForumData.setPos(jSONObject.optInt(IAdRequestParam.POS, 0));
                    this.f20569h.add(feedForumData);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                p(jSONObject.optJSONObject("info"));
                n(jSONObject.optJSONArray("feed_forum"));
                this.k = jSONObject.optInt("error_code");
                this.l = jSONObject.optString("error_msg");
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public void p(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.optInt("is_black", 0);
            this.f20563b = jSONObject.optInt("like_num", 0);
            this.f20564c = jSONObject.optInt("level_id", 0);
            v(jSONObject.optInt("is_like", 0));
            t(jSONObject.optString("level_name", ""));
            u(jSONObject.optInt("levelup_score", 0));
            r(jSONObject.optInt("cur_score", 0));
            m(jSONObject);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void q(BlockPopInfoData blockPopInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, blockPopInfoData) == null) {
            this.f20571j = blockPopInfoData;
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f20565d = i2;
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f20567f = str;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f20568g = str;
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f20566e = i2;
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f20562a = i2;
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || i2 < 0) {
            return;
        }
        this.f20564c = i2;
    }
}
