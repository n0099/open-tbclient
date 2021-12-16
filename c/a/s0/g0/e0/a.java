package c.a.s0.g0.e0;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.s.r.d2;
import c.a.s0.z2.e;
import c.a.s0.z2.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AlaVideoContainer f17721e;

    /* renamed from: f  reason: collision with root package name */
    public d2 f17722f;

    /* renamed from: g  reason: collision with root package name */
    public AlaInfoData f17723g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17724h;

    /* renamed from: i  reason: collision with root package name */
    public f f17725i;

    /* renamed from: j  reason: collision with root package name */
    public f.b f17726j;

    /* renamed from: c.a.s0.g0.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1075a implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1075a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.s0.z2.f.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b();
            }
        }
    }

    public a(AlaVideoContainer alaVideoContainer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {alaVideoContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17724h = false;
        this.f17726j = new C1075a(this);
        this.f17721e = alaVideoContainer;
        if (alaVideoContainer != null) {
            f fVar = new f();
            this.f17725i = fVar;
            fVar.l(this.f17721e.getVideoView());
            this.f17725i.i(this.f17726j);
        }
    }

    public final void b() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (d2Var = this.f17722f) == null || d2Var.t1() == null) {
        }
    }

    public void c() {
        AlaVideoContainer alaVideoContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alaVideoContainer = this.f17721e) == null) {
            return;
        }
        alaVideoContainer.startPlayAnimation();
    }

    public void d(d2 d2Var, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{d2Var, str, str2, Boolean.valueOf(z)}) == null) || d2Var == null) {
            return;
        }
        this.f17722f = d2Var;
        if (this.f17721e == null || d2Var.o1() == null) {
            return;
        }
        AlaInfoData o1 = this.f17722f.o1();
        this.f17723g = o1;
        this.f17721e.setVideoThumbnail(o1.cover);
        if (z) {
            this.f17721e.setTitle(this.f17722f.getTitle());
        } else {
            this.f17721e.setTitle("");
        }
        AlaVideoContainer alaVideoContainer = this.f17721e;
        alaVideoContainer.setPlayCount(String.format(alaVideoContainer.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.f17722f.o1().audience_count)));
    }

    @Override // c.a.s0.z2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f17721e;
            if (alaVideoContainer == null || alaVideoContainer.getVideoView() == null) {
                return 0;
            }
            return this.f17721e.getVideoView().getCurrentPositionSync();
        }
        return invokeV.intValue;
    }

    @Override // c.a.s0.z2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d2 d2Var = this.f17722f;
            if (d2Var == null || d2Var.t1() == null) {
                return null;
            }
            return this.f17722f.t1().video_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.z2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f17721e;
            if (alaVideoContainer != null) {
                return alaVideoContainer.getView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.s0.z2.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.z2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f17724h : invokeV.booleanValue;
    }

    @Override // c.a.s0.z2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.z2.e
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // c.a.s0.z2.e
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AlaVideoContainer alaVideoContainer = this.f17721e;
            if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
                this.f17721e.getVideoView().stopPlayback();
                this.f17721e.resetUI();
                f fVar = this.f17725i;
                if (fVar != null) {
                    fVar.n();
                }
            }
            this.f17724h = false;
        }
    }
}
