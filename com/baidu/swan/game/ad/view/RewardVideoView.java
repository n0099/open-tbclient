package com.baidu.swan.game.ad.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.f.i.m.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.VideoReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes6.dex */
public class RewardVideoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f46932e;

    /* renamed from: f  reason: collision with root package name */
    public Context f46933f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46934g;

    /* renamed from: h  reason: collision with root package name */
    public VolumeBroadcastReceiver f46935h;

    /* renamed from: i  reason: collision with root package name */
    public a f46936i;

    /* loaded from: classes6.dex */
    public class VolumeBroadcastReceiver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RewardVideoView this$0;

        public VolumeBroadcastReceiver(RewardVideoView rewardVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rewardVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = rewardVideoView;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                this.this$0.f46936i.onVolumeChanged(((AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).getStreamVolume(3));
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface a {
        void onVolumeChanged(int i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RewardVideoView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @NonNull
    public final c.a.p0.f.i.j.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.p0.f.i.j.a aVar = new c.a.p0.f.i.j.a();
            aVar.f10560f = true;
            aVar.f10556b = this.f46934g;
            aVar.o = false;
            aVar.z = false;
            aVar.v = false;
            return aVar;
        }
        return (c.a.p0.f.i.j.a) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c c2 = c.a.p0.f.i.m.a.c();
            c2.e(getContext(), b());
            this.f46932e = c2;
            AudioManager audioManager = (AudioManager) this.f46933f.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.f46934g = audioManager.getStreamVolume(3) <= (Build.VERSION.SDK_INT >= 28 ? audioManager.getStreamMinVolume(3) : 0);
            FrameLayout frameLayout = new FrameLayout(this.f46933f);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            c cVar = this.f46932e;
            if (cVar != null) {
                cVar.a(frameLayout);
            }
        }
    }

    public c getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46932e : (c) invokeV.objValue;
    }

    public boolean isMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f46934g : invokeV.booleanValue;
    }

    public void mute(boolean z) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (cVar = this.f46932e) == null) {
            return;
        }
        this.f46934g = z;
        cVar.mute(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            VolumeBroadcastReceiver volumeBroadcastReceiver = this.f46935h;
            if (volumeBroadcastReceiver == null || (context = this.f46933f) == null) {
                return;
            }
            context.unregisterReceiver(volumeBroadcastReceiver);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setVolumeChangeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f46936i = aVar;
        }
    }

    public void start(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.p0.f.i.j.a b2 = b();
            b2.p = str;
            this.f46932e.h(b2);
            this.f46932e.d(false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RewardVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f46933f = context;
        c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        VolumeBroadcastReceiver volumeBroadcastReceiver = new VolumeBroadcastReceiver(this);
        this.f46935h = volumeBroadcastReceiver;
        this.f46933f.registerReceiver(volumeBroadcastReceiver, intentFilter);
    }
}
