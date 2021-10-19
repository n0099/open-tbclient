package c.a.q0.i0.c;

import android.text.TextUtils;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public d2 f13499a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public PbContent f13500b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13501c;

    /* renamed from: d  reason: collision with root package name */
    public int f13502d;

    /* renamed from: e  reason: collision with root package name */
    public int f13503e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public PostData f13504f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public HotTopicStat.Locate f13505g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public String f13506h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13507i;

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
        this.f13505g = HotTopicStat.Locate.UNDEFINED;
        this.f13499a = d2Var;
        this.f13500b = pbContent;
        this.f13501c = TextUtils.equals(UrlUtils.getParamValue(pbContent.link, IntentConfig.IS_VIDEO_TOPIC), "1");
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
            this.f13507i = z;
            return this;
        }
        return (b) invokeZ.objValue;
    }

    @NonNull
    public b b(@NonNull HotTopicStat.Locate locate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locate)) == null) {
            this.f13505g = locate;
            return this;
        }
        return (b) invokeL.objValue;
    }

    @NonNull
    public b c(@Nullable PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData)) == null) {
            this.f13504f = postData;
            return this;
        }
        return (b) invokeL.objValue;
    }

    @NonNull
    public b d(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.f13502d = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    @NonNull
    public b e(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f13503e = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    @NonNull
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? String.valueOf(this.f13499a.T()) : (String) invokeV.objValue;
    }

    @NonNull
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f13506h == null) {
                this.f13506h = UrlUtils.appendParam(this.f13500b.link, "locate", i().toString());
            }
            return this.f13506h;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public HotTopicStat.Locate i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f13505g : (HotTopicStat.Locate) invokeV.objValue;
    }

    @NonNull
    public PbContent j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f13500b : (PbContent) invokeV.objValue;
    }

    @Nullable
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PostData postData = this.f13504f;
            if (postData == null) {
                return null;
            }
            return postData.E();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public d2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f13499a : (d2) invokeV.objValue;
    }

    @ColorRes
    public int m() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i3 = R.color.CAM_X0304;
            if (o()) {
                i2 = this.f13503e;
                if (i2 == 0) {
                    return i3;
                }
            } else {
                i2 = this.f13502d;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f13507i : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f13501c : invokeV.booleanValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f13501c = z;
        }
    }
}
