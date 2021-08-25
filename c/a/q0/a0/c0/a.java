package c.a.q0.a0.c0;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
import c.a.q0.o2.e;
import c.a.q0.o2.f;
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
    public AlaVideoContainer f15238e;

    /* renamed from: f  reason: collision with root package name */
    public c2 f15239f;

    /* renamed from: g  reason: collision with root package name */
    public AlaInfoData f15240g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15241h;

    /* renamed from: i  reason: collision with root package name */
    public f f15242i;

    /* renamed from: j  reason: collision with root package name */
    public f.b f15243j;

    /* renamed from: c.a.q0.a0.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0725a implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f15244a;

        public C0725a(a aVar) {
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
            this.f15244a = aVar;
        }

        @Override // c.a.q0.o2.f.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15244a.b();
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
        this.f15241h = false;
        this.f15243j = new C0725a(this);
        this.f15238e = alaVideoContainer;
        if (alaVideoContainer != null) {
            f fVar = new f();
            this.f15242i = fVar;
            fVar.l(this.f15238e.getVideoView());
            this.f15242i.i(this.f15243j);
        }
    }

    public final void b() {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (c2Var = this.f15239f) == null || c2Var.o1() == null) {
        }
    }

    public void c() {
        AlaVideoContainer alaVideoContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alaVideoContainer = this.f15238e) == null) {
            return;
        }
        alaVideoContainer.startPlayAnimation();
    }

    public void d(c2 c2Var, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{c2Var, str, str2, Boolean.valueOf(z)}) == null) || c2Var == null) {
            return;
        }
        this.f15239f = c2Var;
        if (this.f15238e == null || c2Var.j1() == null) {
            return;
        }
        AlaInfoData j1 = this.f15239f.j1();
        this.f15240g = j1;
        this.f15238e.setVideoThumbnail(j1.cover);
        if (z) {
            this.f15238e.setTitle(this.f15239f.getTitle());
        } else {
            this.f15238e.setTitle("");
        }
        AlaVideoContainer alaVideoContainer = this.f15238e;
        alaVideoContainer.setPlayCount(String.format(alaVideoContainer.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.f15239f.j1().audience_count)));
    }

    @Override // c.a.q0.o2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f15238e;
            if (alaVideoContainer == null || alaVideoContainer.getVideoView() == null) {
                return 0;
            }
            return this.f15238e.getVideoView().getCurrentPositionSync();
        }
        return invokeV.intValue;
    }

    @Override // c.a.q0.o2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c2 c2Var = this.f15239f;
            if (c2Var == null || c2Var.o1() == null) {
                return null;
            }
            return this.f15239f.o1().video_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.q0.o2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f15238e;
            if (alaVideoContainer != null) {
                return alaVideoContainer.getView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.q0.o2.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.o2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f15241h : invokeV.booleanValue;
    }

    @Override // c.a.q0.o2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.o2.e
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // c.a.q0.o2.e
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AlaVideoContainer alaVideoContainer = this.f15238e;
            if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
                this.f15238e.getVideoView().stopPlayback();
                this.f15238e.resetUI();
                f fVar = this.f15242i;
                if (fVar != null) {
                    fVar.n();
                }
            }
            this.f15241h = false;
        }
    }
}
