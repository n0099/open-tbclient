package c.a.b0.s.o0;

import androidx.core.view.InputDeviceCompat;
import c.a.b0.j.d;
import c.a.b0.s.c0.p;
import c.a.b0.s.m0.i;
import c.a.b0.s.v0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.model.HistoryCache;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes.dex */
public class e extends c.a.b0.s.o0.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final HistoryCache f2072i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.b0.s.m0.f f2073h;

    /* loaded from: classes.dex */
    public static final class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdVideoSeries a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BdVideoSeries f2074b;

        public a(BdVideoSeries bdVideoSeries, e eVar, BdVideoSeries bdVideoSeries2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdVideoSeries, eVar, bdVideoSeries2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdVideoSeries;
            this.f2074b = bdVideoSeries2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1923109395, "Lc/a/b0/s/o0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1923109395, "Lc/a/b0/s/o0/e;");
                return;
            }
        }
        f2072i = new HistoryCache();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void A(c.a.b0.s.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null) {
            return;
        }
        h.a("seekToTarget(player@" + System.identityHashCode(fVar) + "),  position is " + fVar.K().f2044f + " ms .[" + this + ']');
        if (fVar.K().f2044f > 0) {
            fVar.p0(fVar.K().f2044f);
        }
    }

    public final void B(BdVideoSeries bdVideoSeries) {
        c.a.b0.s.f j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries) == null) || (j2 = j()) == null) {
            return;
        }
        i videoTask = j2.K();
        Intrinsics.checkNotNullExpressionValue(videoTask, "videoTask");
        q(videoTask, bdVideoSeries);
        if (j2.Z() || j2.Y() || j2.W()) {
            A(j2);
        }
    }

    @Override // c.a.b0.s.f0.j
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new int[]{4, 5, 7} : (int[]) invokeV.objValue;
    }

    @Override // c.a.b0.s.o0.a, c.a.b0.s.o0.c
    public void h(p event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.h(event);
            String c2 = event.c();
            int hashCode = c2.hashCode();
            if (hashCode != -1026415353) {
                if (hashCode == 1671611006 && c2.equals("plugin_event_load_player_history")) {
                    Object f2 = event.f(1);
                    x((BdVideoSeries) (f2 instanceof BdVideoSeries ? f2 : null));
                }
            } else if (c2.equals("plugin_event_save_player_history")) {
                Object f3 = event.f(1);
                BdVideoSeries bdVideoSeries = (BdVideoSeries) (f3 instanceof BdVideoSeries ? f3 : null);
                if (bdVideoSeries != null) {
                    z(bdVideoSeries);
                }
            }
        }
    }

    @Override // c.a.b0.s.o0.a, c.a.b0.s.f0.j
    public void i(PlayerStatus status, PlayerStatus old) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, status, old) == null) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(old, "old");
            super.i(status, old);
            int i2 = d.$EnumSwitchMapping$0[status.ordinal()];
            if (i2 == 1) {
                A(j());
            } else if (i2 != 2) {
            } else {
                s();
            }
        }
    }

    @Override // c.a.b0.s.o0.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.n();
            this.f2073h = null;
        }
    }

    public final void q(i iVar, BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, iVar, bdVideoSeries) == null) {
            iVar.f2042d = Math.max(0, bdVideoSeries.getPosition());
            iVar.f2044f = Math.max(0, bdVideoSeries.getPositionMs());
            int max = Math.max(0, bdVideoSeries.getDuration());
            iVar.f2043e = max;
            if (iVar.f2042d > max) {
                iVar.f2043e = 0;
                iVar.f2042d = 0;
                iVar.f2044f = 0;
            }
        }
    }

    public final void s() {
        c.a.b0.s.f j2;
        BdVideoSeries videoSeries;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (j2 = j()) == null || (videoSeries = j2.o1()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(videoSeries, "videoSeries");
        c.a.b0.s.m0.e.b(videoSeries, 0, videoSeries.getDurationMs());
        z(videoSeries);
    }

    public final boolean t(BdVideoSeries bdVideoSeries, String str) {
        InterceptResult invokeLL;
        c.a.b0.s.m0.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bdVideoSeries, str)) == null) {
            c.a.b0.s.m0.f findCache = f2072i.findCache(str, bdVideoSeries.getVid());
            int positionMs = bdVideoSeries.getPositionMs();
            if (findCache == null || positionMs != findCache.g()) {
                c.a.b0.s.m0.f fVar2 = this.f2073h;
                return Intrinsics.areEqual(fVar2 != null ? fVar2.e() : null, bdVideoSeries.getVid()) && (fVar = this.f2073h) != null && fVar.g() == bdVideoSeries.getPositionMs();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.b0.s.o0.a
    /* renamed from: u */
    public c.a.b0.s.f j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.b0.s.e j2 = super.j();
            if (!(j2 instanceof c.a.b0.s.f)) {
                j2 = null;
            }
            return (c.a.b0.s.f) j2;
        }
        return (c.a.b0.s.f) invokeV.objValue;
    }

    public String v(BdVideoSeries videoSeries) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, videoSeries)) == null) {
            Intrinsics.checkNotNullParameter(videoSeries, "videoSeries");
            BdVideo selectedVideo = videoSeries.getSelectedVideo();
            String a2 = c.a.b0.s.m0.f.a(selectedVideo != null ? selectedVideo.getSourceUrl() : null);
            return a2 != null ? a2 : "";
        }
        return (String) invokeL.objValue;
    }

    public final boolean w(BdVideoSeries bdVideoSeries) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bdVideoSeries)) == null) ? bdVideoSeries.getStartPosition() >= 0 : invokeL.booleanValue;
    }

    public final void x(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bdVideoSeries) == null) || j() == null || bdVideoSeries == null) {
            return;
        }
        if (w(bdVideoSeries)) {
            bdVideoSeries.setPosition(bdVideoSeries.getStartPosition());
            bdVideoSeries.setStartPosition(-1);
            B(bdVideoSeries);
            return;
        }
        String v = v(bdVideoSeries);
        c.a.b0.s.m0.f findCache = f2072i.findCache(v, bdVideoSeries.getVid());
        if (findCache != null) {
            y(findCache, bdVideoSeries);
            B(bdVideoSeries);
            return;
        }
        d.b.a().a(v, bdVideoSeries.getVid(), new a(bdVideoSeries, this, bdVideoSeries));
    }

    public void y(c.a.b0.s.m0.f info, BdVideoSeries videoSeries) {
        Integer intOrNull;
        Integer intOrNull2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, info, videoSeries) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(videoSeries, "videoSeries");
            String f2 = info.f();
            int i2 = 0;
            int intValue = (f2 == null || (intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(f2)) == null) ? 0 : intOrNull2.intValue();
            String h2 = info.h();
            int intValue2 = (h2 == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(h2)) == null) ? 0 : intOrNull.intValue();
            if (videoSeries.getDuration() <= 0) {
                videoSeries.setDurationMs(intValue2 * 1000);
            }
            if (intValue <= 0 || intValue != intValue2) {
                i2 = intValue;
            } else {
                info.q("0");
            }
            if (info.g() > 0) {
                videoSeries.setPositionMs(info.g());
            } else {
                videoSeries.setPositionMs(i2 * 1000);
            }
            BdVideo selectedVideo = videoSeries.getSelectedVideo();
            if (selectedVideo != null) {
                selectedVideo.setCurrentLength(info.f());
            }
            BdVideo selectedVideo2 = videoSeries.getSelectedVideo();
            if (selectedVideo2 != null) {
                selectedVideo2.setTotalLength(String.valueOf(videoSeries.getDuration()));
            }
        }
    }

    public final void z(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdVideoSeries) == null) {
            h.a("savePlayProgress(series@" + System.identityHashCode(bdVideoSeries) + ") begin, save history" + bdVideoSeries + ".[" + this + ']');
            BdVideo selectedVideo = bdVideoSeries.getSelectedVideo();
            if (selectedVideo != null) {
                Intrinsics.checkNotNullExpressionValue(selectedVideo, "videoSeries.selectedVideo ?: return");
                String v = v(bdVideoSeries);
                if (Intrinsics.areEqual(selectedVideo.getCurrentLength(), "0")) {
                    h.a("savePlayProgress(series@" + System.identityHashCode(bdVideoSeries) + "), del when currentLength is 0,  history" + bdVideoSeries + ".[" + this + ']');
                    c.a.b0.e0.a.c.b().b(v, bdVideoSeries.getVid());
                    f2072i.removeCache(v, bdVideoSeries.getVid());
                } else if (t(bdVideoSeries, v)) {
                } else {
                    c.a.b0.s.m0.f info = c.a.b0.s.d0.c.a(bdVideoSeries, selectedVideo, selectedVideo.getSourceUrl(), v);
                    Intrinsics.checkNotNullExpressionValue(info, "info");
                    if (info.i()) {
                        this.f2073h = info;
                        String vid = bdVideoSeries.getVid();
                        Intrinsics.checkNotNullExpressionValue(vid, "videoSeries.vid");
                        if ((!StringsKt__StringsJVMKt.isBlank(vid)) || (!StringsKt__StringsJVMKt.isBlank(v))) {
                            f2072i.add(info);
                        }
                        h.a("savePlayProgress(series@" + System.identityHashCode(bdVideoSeries) + "), info is {" + info + "}.[" + this + ']');
                        c.a.b0.e0.a.c.b().a(c.a.b0.e.a.b(), info, false);
                    }
                }
            }
        }
    }
}
