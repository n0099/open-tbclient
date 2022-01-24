package c.a.s0.j0.d;

import android.text.TextUtils;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.e2;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PbContent;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public e2 a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public PbContent f12954b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12955c;

    /* renamed from: d  reason: collision with root package name */
    public int f12956d;

    /* renamed from: e  reason: collision with root package name */
    public int f12957e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public PostData f12958f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public HotTopicStat.Locate f12959g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public String f12960h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12961i;

    public b(@NonNull e2 e2Var, @NonNull PbContent pbContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e2Var, pbContent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12959g = HotTopicStat.Locate.UNDEFINED;
        this.a = e2Var;
        this.f12954b = pbContent;
        this.f12955c = TextUtils.equals(UrlUtils.getParamValue(pbContent.link, "is_video_topic"), "1");
    }

    @NonNull
    public static b f(@NonNull e2 e2Var, @NonNull PbContent pbContent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, e2Var, pbContent)) == null) ? new b(e2Var, pbContent) : (b) invokeLL.objValue;
    }

    @NonNull
    public b a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.f12961i = z;
            return this;
        }
        return (b) invokeZ.objValue;
    }

    @NonNull
    public b b(@NonNull HotTopicStat.Locate locate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locate)) == null) {
            this.f12959g = locate;
            return this;
        }
        return (b) invokeL.objValue;
    }

    @NonNull
    public b c(@Nullable PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData)) == null) {
            this.f12958f = postData;
            return this;
        }
        return (b) invokeL.objValue;
    }

    @NonNull
    public b d(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.f12956d = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    @NonNull
    public b e(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f12957e = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    @NonNull
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? String.valueOf(this.a.U()) : (String) invokeV.objValue;
    }

    @NonNull
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f12960h == null) {
                this.f12960h = UrlUtils.appendParam(this.f12954b.link, "locate", i().toString());
            }
            return this.f12960h;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public HotTopicStat.Locate i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12959g : (HotTopicStat.Locate) invokeV.objValue;
    }

    @NonNull
    public PbContent j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f12954b : (PbContent) invokeV.objValue;
    }

    @Nullable
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PostData postData = this.f12958f;
            if (postData == null) {
                return null;
            }
            return postData.G();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public e2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a : (e2) invokeV.objValue;
    }

    @ColorRes
    public int m() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i3 = R.color.CAM_X0304;
            if (o()) {
                i2 = this.f12957e;
                if (i2 == 0) {
                    return i3;
                }
            } else {
                i2 = this.f12956d;
                if (i2 == 0) {
                    return i3;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f12961i : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f12955c : invokeV.booleanValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f12955c = z;
        }
    }
}
