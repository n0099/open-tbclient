package c.a.t0.g0.e0;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.e2;
import c.a.t0.z2.e;
import c.a.t0.z2.h;
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
/* loaded from: classes7.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AlaVideoContainer f17772e;

    /* renamed from: f  reason: collision with root package name */
    public e2 f17773f;

    /* renamed from: g  reason: collision with root package name */
    public AlaInfoData f17774g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17775h;

    /* renamed from: i  reason: collision with root package name */
    public h f17776i;

    /* renamed from: j  reason: collision with root package name */
    public h.b f17777j;

    /* renamed from: c.a.t0.g0.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
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

        @Override // c.a.t0.z2.h.b
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
        this.f17775h = false;
        this.f17777j = new C1115a(this);
        this.f17772e = alaVideoContainer;
        if (alaVideoContainer != null) {
            h hVar = new h();
            this.f17776i = hVar;
            hVar.l(this.f17772e.getVideoView());
            this.f17776i.i(this.f17777j);
        }
    }

    public final void b() {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (e2Var = this.f17773f) == null || e2Var.t1() == null) {
        }
    }

    public void c() {
        AlaVideoContainer alaVideoContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alaVideoContainer = this.f17772e) == null) {
            return;
        }
        alaVideoContainer.startPlayAnimation();
    }

    public void d(e2 e2Var, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{e2Var, str, str2, Boolean.valueOf(z)}) == null) || e2Var == null) {
            return;
        }
        this.f17773f = e2Var;
        if (this.f17772e == null || e2Var.o1() == null) {
            return;
        }
        AlaInfoData o1 = this.f17773f.o1();
        this.f17774g = o1;
        this.f17772e.setVideoThumbnail(o1.cover);
        if (z) {
            this.f17772e.setTitle(this.f17773f.getTitle());
        } else {
            this.f17772e.setTitle("");
        }
        this.f17772e.setPlayCount(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.f17773f.o1().audience_count)));
    }

    @Override // c.a.t0.z2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f17772e;
            if (alaVideoContainer == null || alaVideoContainer.getVideoView() == null) {
                return 0;
            }
            return this.f17772e.getVideoView().getCurrentPositionSync();
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.z2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e2 e2Var = this.f17773f;
            if (e2Var == null || e2Var.t1() == null) {
                return null;
            }
            return this.f17773f.t1().video_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.t0.z2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f17772e;
            if (alaVideoContainer != null) {
                return alaVideoContainer.getView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.t0.z2.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f17775h : invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.e
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // c.a.t0.z2.e
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AlaVideoContainer alaVideoContainer = this.f17772e;
            if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
                this.f17772e.getVideoView().stopPlayback();
                this.f17772e.resetUI();
                h hVar = this.f17776i;
                if (hVar != null) {
                    hVar.n();
                }
            }
            this.f17775h = false;
        }
    }
}
