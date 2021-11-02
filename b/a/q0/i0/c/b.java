package b.a.q0.i0.c;

import android.text.TextUtils;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public d2 f12640a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public PbContent f12641b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12642c;

    /* renamed from: d  reason: collision with root package name */
    public int f12643d;

    /* renamed from: e  reason: collision with root package name */
    public int f12644e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public PostData f12645f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public HotTopicStat.Locate f12646g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public String f12647h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12648i;

    public b(@NonNull d2 d2Var, @NonNull PbContent pbContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d2Var, pbContent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12646g = HotTopicStat.Locate.UNDEFINED;
        this.f12640a = d2Var;
        this.f12641b = pbContent;
        this.f12642c = TextUtils.equals(UrlUtils.getParamValue(pbContent.link, IntentConfig.IS_VIDEO_TOPIC), "1");
    }

    @NonNull
    public static b f(@NonNull d2 d2Var, @NonNull PbContent pbContent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, d2Var, pbContent)) == null) ? new b(d2Var, pbContent) : (b) invokeLL.objValue;
    }

    @NonNull
    public b a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.f12648i = z;
            return this;
        }
        return (b) invokeZ.objValue;
    }

    @NonNull
    public b b(@NonNull HotTopicStat.Locate locate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locate)) == null) {
            this.f12646g = locate;
            return this;
        }
        return (b) invokeL.objValue;
    }

    @NonNull
    public b c(@Nullable PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData)) == null) {
            this.f12645f = postData;
            return this;
        }
        return (b) invokeL.objValue;
    }

    @NonNull
    public b d(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.f12643d = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    @NonNull
    public b e(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f12644e = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    @NonNull
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? String.valueOf(this.f12640a.T()) : (String) invokeV.objValue;
    }

    @NonNull
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f12647h == null) {
                this.f12647h = UrlUtils.appendParam(this.f12641b.link, "locate", i().toString());
            }
            return this.f12647h;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public HotTopicStat.Locate i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12646g : (HotTopicStat.Locate) invokeV.objValue;
    }

    @NonNull
    public PbContent j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f12641b : (PbContent) invokeV.objValue;
    }

    @Nullable
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PostData postData = this.f12645f;
            if (postData == null) {
                return null;
            }
            return postData.G();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public d2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f12640a : (d2) invokeV.objValue;
    }

    @ColorRes
    public int m() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i3 = R.color.CAM_X0304;
            if (o()) {
                i2 = this.f12644e;
                if (i2 == 0) {
                    return i3;
                }
            } else {
                i2 = this.f12643d;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f12648i : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f12642c : invokeV.booleanValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f12642c = z;
        }
    }
}
