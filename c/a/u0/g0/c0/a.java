package c.a.u0.g0.c0;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.s.r.e2;
import c.a.u0.b3.e;
import c.a.u0.b3.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AlaVideoContainer f17880e;

    /* renamed from: f  reason: collision with root package name */
    public e2 f17881f;

    /* renamed from: g  reason: collision with root package name */
    public AlaInfoData f17882g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17883h;

    /* renamed from: i  reason: collision with root package name */
    public h f17884i;

    /* renamed from: j  reason: collision with root package name */
    public h.b f17885j;

    /* renamed from: c.a.u0.g0.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1115a implements h.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1115a(a aVar) {
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

        @Override // c.a.u0.b3.h.b
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
        this.f17883h = false;
        this.f17885j = new C1115a(this);
        this.f17880e = alaVideoContainer;
        if (alaVideoContainer != null) {
            h hVar = new h();
            this.f17884i = hVar;
            hVar.l(this.f17880e.getVideoView());
            this.f17884i.i(this.f17885j);
        }
    }

    public final void b() {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (e2Var = this.f17881f) == null || e2Var.u1() == null) {
        }
    }

    public void c() {
        AlaVideoContainer alaVideoContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alaVideoContainer = this.f17880e) == null) {
            return;
        }
        alaVideoContainer.startPlayAnimation();
    }

    public void d(e2 e2Var, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{e2Var, str, str2, Boolean.valueOf(z)}) == null) || e2Var == null) {
            return;
        }
        this.f17881f = e2Var;
        if (this.f17880e == null || e2Var.p1() == null) {
            return;
        }
        AlaInfoData p1 = this.f17881f.p1();
        this.f17882g = p1;
        this.f17880e.setVideoThumbnail(p1.cover);
        if (z) {
            this.f17880e.setTitle(this.f17881f.getTitle());
        } else {
            this.f17880e.setTitle("");
        }
        this.f17880e.setPlayCount(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.f17881f.p1().audience_count)));
    }

    @Override // c.a.u0.b3.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f17880e;
            if (alaVideoContainer == null || alaVideoContainer.getVideoView() == null) {
                return 0;
            }
            return this.f17880e.getVideoView().getCurrentPositionSync();
        }
        return invokeV.intValue;
    }

    @Override // c.a.u0.b3.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e2 e2Var = this.f17881f;
            if (e2Var == null || e2Var.u1() == null) {
                return null;
            }
            return this.f17881f.u1().video_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.u0.b3.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f17880e;
            if (alaVideoContainer != null) {
                return alaVideoContainer.getView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.u0.b3.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.u0.b3.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f17883h : invokeV.booleanValue;
    }

    @Override // c.a.u0.b3.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.u0.b3.e
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // c.a.u0.b3.e
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AlaVideoContainer alaVideoContainer = this.f17880e;
            if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
                this.f17880e.getVideoView().stopPlayback();
                this.f17880e.resetUI();
                h hVar = this.f17884i;
                if (hVar != null) {
                    hVar.n();
                }
            }
            this.f17883h = false;
        }
    }
}
