package c.a.t0.e2.p;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.player.helper.SimpleStyleSwitchHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.tieba.medialive.player.strategy.IVideoUpdateStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class g extends e implements LivePlayer {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final Integer f17154f;

    /* renamed from: g  reason: collision with root package name */
    public static final Integer f17155g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public List<LivePlayer.OnProgressChangeListener> f17156b;

    /* renamed from: c  reason: collision with root package name */
    public IVideoUpdateStrategy f17157c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f17158d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final List<LivePlayer.OnInfoListener> f17159e;

    /* loaded from: classes7.dex */
    public class a extends c.a.t0.e2.p.l.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.medialive.player.strategy.IVideoUpdateStrategy
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17160e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f17161f;

        public b(g gVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17161f = gVar;
            this.f17160e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f17160e;
                if (i2 == -2) {
                    if (this.f17161f.isPlaying()) {
                        this.f17161f.pause(2);
                    }
                    this.f17161f.mHasAudioFocus = false;
                } else if (i2 != -1) {
                    if (i2 == 1 && this.f17161f.isPause() && this.f17161f.isForeground()) {
                        this.f17161f.resume();
                    }
                } else {
                    if (this.f17161f.isPlaying()) {
                        this.f17161f.pause(2);
                    }
                    this.f17161f.abandonAudioFocus();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676846040, "Lc/a/t0/e2/p/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-676846040, "Lc/a/t0/e2/p/g;");
                return;
            }
        }
        f17154f = 0;
        f17155g = 115;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String str) {
        super(null, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f17156b = new ArrayList();
        this.f17158d = false;
        this.f17159e = new ArrayList();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void addOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onInfoListener) == null) {
            this.f17159e.add(onInfoListener);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void addProgressListener(@NonNull LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onProgressChangeListener) == null) {
            this.f17156b.add(onProgressChangeListener);
        }
    }

    public final IVideoUpdateStrategy b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f17157c == null) {
                this.f17157c = new a(this);
            }
            return this.f17157c;
        }
        return (IVideoUpdateStrategy) invokeV.objValue;
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || isPlayerMute()) {
            return;
        }
        c.a.t0.i0.f.b(new b(this, i2));
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean checkMode(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? TextUtils.equals(this.mCurrentMode, str) : invokeL.booleanValue;
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f17158d = z;
            this.mVideoSession.getControlEventTrigger().pause(z);
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                baseKernelLayer.pause();
            }
            getStatDispatcher().pause();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public Object getInfo(Object obj, Object obj2, LivePlayer.InfoCallback infoCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, obj, obj2, infoCallback)) == null) {
            return null;
        }
        return invokeLLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void imCloseTimeStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void onAudioFocusChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            c(i2);
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, obj)) == null) {
            for (LivePlayer.OnInfoListener onInfoListener : this.f17159e) {
                onInfoListener.onInfo(i2, i3, obj);
            }
            return super.onInfo(i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void pauseInternal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            d(z);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void prePlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // c.a.t0.e2.p.e, com.baidu.searchbox.player.UniversalPlayer, com.baidu.searchbox.player.BDVideoPlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.release();
            this.f17156b.clear();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void removeOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onInfoListener) == null) {
            this.f17159e.remove(onInfoListener);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void removeProgressListener(@NonNull LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onProgressChangeListener) == null) {
            this.f17156b.remove(onProgressChangeListener);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resetDefaultSwitchHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mStyleSwitchHelper = new SimpleStyleSwitchHelper(this);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resume(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && isPause()) {
            if (z) {
                super.resume();
            } else if (this.f17158d) {
            } else {
                resume();
            }
        }
    }

    public void saveProgressToDb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void seekTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i2, i3) == null) {
            super.seekTo(i2);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setAcceptVolumeChange(boolean z) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setAcceptVolumeChange(Boolean.valueOf(z));
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setExtInfoStatistics(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hashMap) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setMode(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.mCurrentMode = str;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setVideoInfo(@Nullable HashMap<Integer, String> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, hashMap) == null) || hashMap == null) {
            return;
        }
        String str = hashMap.get(f17154f);
        if (!TextUtils.isEmpty(str)) {
            setVideoUrl(str);
        }
        String str2 = hashMap.get(f17155g);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        setLooping(TextUtils.equals(str2, "1"));
    }

    @Override // com.baidu.searchbox.player.UniversalPlayer, com.baidu.searchbox.player.BDVideoPlayer
    public void setupPlayer(Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, context, baseKernelLayer) == null) {
            super.setupPlayer(context, baseKernelLayer);
            this.mLayerContainer.setClickable(false);
            addPlugin(new c.a.t0.e2.p.a(context));
        }
    }

    @Override // c.a.t0.e2.p.e, com.baidu.searchbox.player.BDVideoPlayer
    public void setupPlugin(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, context) == null) {
            super.setupPlugin(context);
        }
    }

    @Override // c.a.t0.e2.p.e, com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.start();
            if (this.mVideoTask.videoUrl.isEmpty()) {
                return;
            }
            if (!l.H() && !l.z()) {
                if (l.v() || l.u()) {
                    if (b().a()) {
                        doPlay();
                        return;
                    } else {
                        this.mVideoSession.getControlEventTrigger().showNetTip();
                        return;
                    }
                }
                return;
            }
            doPlay();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void stopTimeStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@Nullable Context context, String str) {
        super(context, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f17156b = new ArrayList();
        this.f17158d = false;
        this.f17159e = new ArrayList();
    }
}
