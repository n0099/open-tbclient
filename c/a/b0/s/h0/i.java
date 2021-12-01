package c.a.b0.s.h0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.tail.AdVideoTailFrameView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class i extends a implements AdVideoTailFrameView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdVideoTailFrameView f1954b;

    /* renamed from: c  reason: collision with root package name */
    public Object f1955c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.b0.s.j0.f fVar, Object obj) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.b0.s.j0.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1955c = obj;
    }

    @Override // com.baidu.nadcore.player.tail.AdVideoTailFrameView.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = this.f1955c instanceof c.a.b0.p.n;
        }
    }

    @Override // com.baidu.nadcore.player.tail.AdVideoTailFrameView.b
    public void b() {
        c.a.b0.s.j0.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Object obj = this.f1955c;
            if (obj instanceof c.a.b0.p.n) {
                if ("ad_full_video".equals(((c.a.b0.p.n) obj).n)) {
                    if (this.a != null && h() && this.a.S()) {
                        if (this.a.v().V0()) {
                            this.a.G(c.a.b0.s.c0.g.w(PlayerEvent.ACTION_ON_COMPLETE));
                        } else {
                            this.a.v().y().G(0);
                        }
                    }
                } else if ("ad_append_video".equals(((c.a.b0.p.n) this.f1955c).n) && (fVar = this.a) != null && fVar.S()) {
                    this.f1954b.sendALS(ClogBuilder.LogType.CLOSE.type, "", "");
                    this.a.W(8);
                    this.a.T();
                    this.a.G(c.a.b0.s.c0.f.w("layer_event_ad_finish"));
                    if (this.a.v().a0()) {
                        return;
                    }
                    this.a.G(c.a.b0.s.c0.g.w(PlayerEvent.ACTION_ON_COMPLETE));
                }
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == null || this.f1955c == null) {
            return;
        }
        g();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == null) {
            return;
        }
        if (this.f1954b == null) {
            AdVideoTailFrameView adVideoTailFrameView = new AdVideoTailFrameView(this.a.getContentView().getContext(), this.a, d());
            this.f1954b = adVideoTailFrameView;
            this.a.Q(adVideoTailFrameView);
        }
        this.f1954b.changeHalfVisibility(d());
        this.f1954b.setCallBack(this);
        Object obj = this.f1955c;
        if (obj != null) {
            this.f1954b.setData(obj);
            this.f1954b.showTail();
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.b0.s.j0.f fVar = this.a;
            return (fVar == null || fVar.v().o1() == null || this.a.v().o1().getVideoAd() == null || this.a.v().o1().getVideoAd().fullItemAdData == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AdVideoTailFrameView adVideoTailFrameView = this.f1954b;
            return adVideoTailFrameView != null && adVideoTailFrameView.isDataValid();
        }
        return invokeV.booleanValue;
    }

    public void j(boolean z) {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (adVideoTailFrameView = this.f1954b) == null) {
            return;
        }
        adVideoTailFrameView.onVPlayerNightModeChanged(z);
    }

    public void k(boolean z) {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (adVideoTailFrameView = this.f1954b) == null) {
            return;
        }
        adVideoTailFrameView.changeHalfVisibility(z);
    }

    public void l() {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (adVideoTailFrameView = this.f1954b) == null) {
            return;
        }
        adVideoTailFrameView.startCountDown();
    }

    public void m() {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (adVideoTailFrameView = this.f1954b) == null) {
            return;
        }
        adVideoTailFrameView.pauseCountDown();
    }
}
