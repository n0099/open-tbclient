package c.a.o0.i0.d;

import android.text.TextUtils;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public ThreadData a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public PbContent f10329b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10330c;

    /* renamed from: d  reason: collision with root package name */
    public int f10331d;

    /* renamed from: e  reason: collision with root package name */
    public int f10332e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public PostData f10333f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public HotTopicStat.Locate f10334g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public String f10335h;
    public boolean i;

    public b(@NonNull ThreadData threadData, @NonNull PbContent pbContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadData, pbContent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10334g = HotTopicStat.Locate.UNDEFINED;
        this.a = threadData;
        this.f10329b = pbContent;
        this.f10330c = TextUtils.equals(UrlUtils.getParamValue(pbContent.link, "is_video_topic"), "1");
    }

    @NonNull
    public static b f(@NonNull ThreadData threadData, @NonNull PbContent pbContent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, threadData, pbContent)) == null) ? new b(threadData, pbContent) : (b) invokeLL.objValue;
    }

    @NonNull
    public b a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.i = z;
            return this;
        }
        return (b) invokeZ.objValue;
    }

    @NonNull
    public b b(@NonNull HotTopicStat.Locate locate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locate)) == null) {
            this.f10334g = locate;
            return this;
        }
        return (b) invokeL.objValue;
    }

    @NonNull
    public b c(@Nullable PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData)) == null) {
            this.f10333f = postData;
            return this;
        }
        return (b) invokeL.objValue;
    }

    @NonNull
    public b d(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.f10331d = i;
            return this;
        }
        return (b) invokeI.objValue;
    }

    @NonNull
    public b e(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.f10332e = i;
            return this;
        }
        return (b) invokeI.objValue;
    }

    @NonNull
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? String.valueOf(this.a.getFid()) : (String) invokeV.objValue;
    }

    @NonNull
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f10335h == null) {
                this.f10335h = UrlUtils.appendParam(this.f10329b.link, "locate", i().toString());
            }
            return this.f10335h;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public HotTopicStat.Locate i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f10334g : (HotTopicStat.Locate) invokeV.objValue;
    }

    @NonNull
    public PbContent j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f10329b : (PbContent) invokeV.objValue;
    }

    @Nullable
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PostData postData = this.f10333f;
            if (postData == null) {
                return null;
            }
            return postData.G();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public ThreadData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a : (ThreadData) invokeV.objValue;
    }

    @ColorRes
    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (o()) {
                int i = this.f10332e;
                if (i != 0) {
                    return i;
                }
            } else {
                int i2 = this.f10331d;
                if (i2 != 0) {
                    return i2;
                }
            }
            return R.color.CAM_X0304;
        }
        return invokeV.intValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f10330c : invokeV.booleanValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f10330c = z;
        }
    }
}
