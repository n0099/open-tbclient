package c.a.r0.y3.c;

import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.l.d;
import c.a.e.e.p.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public VideoEasterEggData f29700a;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.r0.y3.c.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.f29700a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getPopText();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.y3.c.a
    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) || intent == null) {
            return;
        }
        intent.getStringExtra("from");
        if (intent.hasExtra(IntentConfig.VIDEO_EASTER_EGG_DATA)) {
            this.f29700a = (VideoEasterEggData) intent.getSerializableExtra(IntentConfig.VIDEO_EASTER_EGG_DATA);
        }
    }

    @Override // c.a.r0.y3.c.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.f29700a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getActivityID();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.y3.c.a
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.f29700a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getShareTitle();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.y3.c.a
    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || k.isEmpty(g())) {
            return;
        }
        d.h().m(g(), 10, null, bdUniqueId);
    }

    @Override // c.a.r0.y3.c.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.f29700a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getShareUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.y3.c.a
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.f29700a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getPopImageUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.y3.c.a
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.f29700a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getVideoUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.y3.c.a
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.f29700a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getShareImageUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.y3.c.a
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.f29700a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getShareContent();
        }
        return (String) invokeV.objValue;
    }
}
