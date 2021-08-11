package c.a.p0.a0.c0;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.c2;
import c.a.p0.o2.e;
import c.a.p0.o2.f;
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
/* loaded from: classes3.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AlaVideoContainer f14952e;

    /* renamed from: f  reason: collision with root package name */
    public c2 f14953f;

    /* renamed from: g  reason: collision with root package name */
    public AlaInfoData f14954g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14955h;

    /* renamed from: i  reason: collision with root package name */
    public f f14956i;

    /* renamed from: j  reason: collision with root package name */
    public f.b f14957j;

    /* renamed from: c.a.p0.a0.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0715a implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f14958a;

        public C0715a(a aVar) {
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
            this.f14958a = aVar;
        }

        @Override // c.a.p0.o2.f.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14958a.b();
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
        this.f14955h = false;
        this.f14957j = new C0715a(this);
        this.f14952e = alaVideoContainer;
        if (alaVideoContainer != null) {
            f fVar = new f();
            this.f14956i = fVar;
            fVar.l(this.f14952e.getVideoView());
            this.f14956i.i(this.f14957j);
        }
    }

    public final void b() {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (c2Var = this.f14953f) == null || c2Var.o1() == null) {
        }
    }

    public void c() {
        AlaVideoContainer alaVideoContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alaVideoContainer = this.f14952e) == null) {
            return;
        }
        alaVideoContainer.startPlayAnimation();
    }

    public void d(c2 c2Var, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{c2Var, str, str2, Boolean.valueOf(z)}) == null) || c2Var == null) {
            return;
        }
        this.f14953f = c2Var;
        if (this.f14952e == null || c2Var.j1() == null) {
            return;
        }
        AlaInfoData j1 = this.f14953f.j1();
        this.f14954g = j1;
        this.f14952e.setVideoThumbnail(j1.cover);
        if (z) {
            this.f14952e.setTitle(this.f14953f.getTitle());
        } else {
            this.f14952e.setTitle("");
        }
        AlaVideoContainer alaVideoContainer = this.f14952e;
        alaVideoContainer.setPlayCount(String.format(alaVideoContainer.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.f14953f.j1().audience_count)));
    }

    @Override // c.a.p0.o2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f14952e;
            if (alaVideoContainer == null || alaVideoContainer.getVideoView() == null) {
                return 0;
            }
            return this.f14952e.getVideoView().getCurrentPositionSync();
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.o2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c2 c2Var = this.f14953f;
            if (c2Var == null || c2Var.o1() == null) {
                return null;
            }
            return this.f14953f.o1().video_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.o2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f14952e;
            if (alaVideoContainer != null) {
                return alaVideoContainer.getView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.p0.o2.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.o2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14955h : invokeV.booleanValue;
    }

    @Override // c.a.p0.o2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.o2.e
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // c.a.p0.o2.e
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AlaVideoContainer alaVideoContainer = this.f14952e;
            if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
                this.f14952e.getVideoView().stopPlayback();
                this.f14952e.resetUI();
                f fVar = this.f14956i;
                if (fVar != null) {
                    fVar.n();
                }
            }
            this.f14955h = false;
        }
    }
}
