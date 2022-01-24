package c.a.t0.x3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f25299b;

    /* renamed from: c  reason: collision with root package name */
    public int f25300c;

    /* renamed from: d  reason: collision with root package name */
    public int f25301d;

    /* renamed from: e  reason: collision with root package name */
    public int f25302e;

    /* renamed from: f  reason: collision with root package name */
    public String f25303f;

    /* renamed from: g  reason: collision with root package name */
    public String f25304g;

    /* renamed from: h  reason: collision with root package name */
    public String f25305h;

    /* renamed from: i  reason: collision with root package name */
    public List<FeedForumData> f25306i;

    /* renamed from: j  reason: collision with root package name */
    public String f25307j;
    public BlockPopInfoData k;
    public int l;
    public String m;

    public x() {
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
        this.f25306i = new ArrayList();
        this.f25299b = 0;
        this.f25300c = 0;
        u("");
        w(0);
        s(0);
        v(0);
    }

    public BlockPopInfoData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (BlockPopInfoData) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25307j : (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25301d : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public List<FeedForumData> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f25306i : (List) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f25304g : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f25305h : (String) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f25302e : invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f25299b : invokeV.intValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f25303f : (String) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f25300c : invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a : invokeV.intValue;
    }

    public final void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f25307j = jSONObject.optString("block_dealurl");
        String optString = jSONObject.optString("block_content");
        if (StringUtils.isNull(optString)) {
            return;
        }
        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
        this.k = blockPopInfoData;
        blockPopInfoData.block_info = optString;
        blockPopInfoData.ahead_url = this.f25307j;
        blockPopInfoData.ahead_info = jSONObject.optString("block_confirm");
        this.k.ok_info = jSONObject.optString("block_cancel");
    }

    public void o(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONArray) == null) {
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
                    feedForumData.setPos(jSONObject.optInt("pos", 0));
                    this.f25306i.add(feedForumData);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                q(jSONObject.optJSONObject("info"));
                o(jSONObject.optJSONArray("feed_forum"));
                this.l = jSONObject.optInt("error_code");
                this.m = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public void q(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.optInt("is_black", 0);
            this.f25299b = jSONObject.optInt("like_num", 0);
            this.f25300c = jSONObject.optInt("level_id", 0);
            this.f25303f = jSONObject.optString("member_sum");
            w(jSONObject.optInt("is_like", 0));
            u(jSONObject.optString("level_name", ""));
            v(jSONObject.optInt("levelup_score", 0));
            s(jSONObject.optInt("cur_score", 0));
            n(jSONObject);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void r(BlockPopInfoData blockPopInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, blockPopInfoData) == null) {
            this.k = blockPopInfoData;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f25301d = i2;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f25304g = str;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f25305h = str;
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f25302e = i2;
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.a = i2;
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || i2 < 0) {
            return;
        }
        this.f25300c = i2;
    }
}
