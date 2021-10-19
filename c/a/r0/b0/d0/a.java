package c.a.r0.b0.d0;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import c.a.r0.q2.e;
import c.a.r0.q2.f;
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
    public AlaVideoContainer f15714e;

    /* renamed from: f  reason: collision with root package name */
    public d2 f15715f;

    /* renamed from: g  reason: collision with root package name */
    public AlaInfoData f15716g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15717h;

    /* renamed from: i  reason: collision with root package name */
    public f f15718i;

    /* renamed from: j  reason: collision with root package name */
    public f.b f15719j;

    /* renamed from: c.a.r0.b0.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0754a implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f15720a;

        public C0754a(a aVar) {
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
            this.f15720a = aVar;
        }

        @Override // c.a.r0.q2.f.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15720a.b();
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
        this.f15717h = false;
        this.f15719j = new C0754a(this);
        this.f15714e = alaVideoContainer;
        if (alaVideoContainer != null) {
            f fVar = new f();
            this.f15718i = fVar;
            fVar.l(this.f15714e.getVideoView());
            this.f15718i.i(this.f15719j);
        }
    }

    public final void b() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (d2Var = this.f15715f) == null || d2Var.q1() == null) {
        }
    }

    public void c() {
        AlaVideoContainer alaVideoContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alaVideoContainer = this.f15714e) == null) {
            return;
        }
        alaVideoContainer.startPlayAnimation();
    }

    public void d(d2 d2Var, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{d2Var, str, str2, Boolean.valueOf(z)}) == null) || d2Var == null) {
            return;
        }
        this.f15715f = d2Var;
        if (this.f15714e == null || d2Var.l1() == null) {
            return;
        }
        AlaInfoData l1 = this.f15715f.l1();
        this.f15716g = l1;
        this.f15714e.setVideoThumbnail(l1.cover);
        if (z) {
            this.f15714e.setTitle(this.f15715f.getTitle());
        } else {
            this.f15714e.setTitle("");
        }
        AlaVideoContainer alaVideoContainer = this.f15714e;
        alaVideoContainer.setPlayCount(String.format(alaVideoContainer.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.f15715f.l1().audience_count)));
    }

    @Override // c.a.r0.q2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f15714e;
            if (alaVideoContainer == null || alaVideoContainer.getVideoView() == null) {
                return 0;
            }
            return this.f15714e.getVideoView().getCurrentPositionSync();
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.q2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d2 d2Var = this.f15715f;
            if (d2Var == null || d2Var.q1() == null) {
                return null;
            }
            return this.f15715f.q1().video_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.q2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f15714e;
            if (alaVideoContainer != null) {
                return alaVideoContainer.getView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.r0.q2.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.q2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f15717h : invokeV.booleanValue;
    }

    @Override // c.a.r0.q2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.q2.e
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // c.a.r0.q2.e
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AlaVideoContainer alaVideoContainer = this.f15714e;
            if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
                this.f15714e.getVideoView().stopPlayback();
                this.f15714e.resetUI();
                f fVar = this.f15718i;
                if (fVar != null) {
                    fVar.n();
                }
            }
            this.f15717h = false;
        }
    }
}
