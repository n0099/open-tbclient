package com.baidu.nadcore.player.tail;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.d.d;
import c.a.c0.d.e;
import c.a.c0.g0.f;
import c.a.c0.s.n;
import c.a.c0.v.c0.g;
import c.a.c0.v.j0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.player.tail.AdBaseTailFrameView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class AdVideoTailFrameView extends AdEmbeddedTailFrameView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public n f37100i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37101j;
    public Handler k;
    public b l;
    public View m;
    public int mDurationTime;
    public boolean mHalfFlag;
    public int mHasPlayTime;
    public View mVideoADClose;
    public TextView mVideoADTimer;
    public ImageView n;
    public TextView o;
    public TextView p;
    public f q;

    /* loaded from: classes10.dex */
    public class a implements AdBaseTailFrameView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoTailFrameView a;

        public a(AdVideoTailFrameView adVideoTailFrameView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoTailFrameView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoTailFrameView;
        }

        @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView.d
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                this.a.sendALS(str, str2, "");
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes10.dex */
    public static class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<AdVideoTailFrameView> a;

        public /* synthetic */ c(AdVideoTailFrameView adVideoTailFrameView, a aVar) {
            this(adVideoTailFrameView);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                AdVideoTailFrameView adVideoTailFrameView = this.a.get();
                if (adVideoTailFrameView == null || message.what != 1 || adVideoTailFrameView.f37101j) {
                    return;
                }
                adVideoTailFrameView.mHasPlayTime++;
                Message message2 = new Message();
                message2.what = 1;
                if (adVideoTailFrameView.mVideoADTimer.getVisibility() == 0) {
                    adVideoTailFrameView.mVideoADTimer.setText(String.format("%ds", Integer.valueOf(adVideoTailFrameView.mDurationTime - adVideoTailFrameView.mHasPlayTime)));
                }
                sendMessageDelayed(message2, 1000L);
                adVideoTailFrameView.i();
            }
        }

        public c(AdVideoTailFrameView adVideoTailFrameView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoTailFrameView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(adVideoTailFrameView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoTailFrameView(Context context, f fVar, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDurationTime = 5;
        this.mHasPlayTime = 0;
        this.q = fVar;
        this.mHalfFlag = z;
        init();
    }

    public void changeHalfVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.mHalfFlag = z;
            n nVar = this.f37100i;
            if (nVar != null && TextUtils.equals(nVar.n, "ad_full_video")) {
                j(z);
            }
            onPlayerModeChange(z);
        }
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public void hideTailFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            pauseCountDown();
            this.mHasPlayTime = 0;
            f fVar = this.q;
            if (fVar != null) {
                fVar.M();
                this.q.O(8);
            }
        }
    }

    public final void i() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.mHasPlayTime;
            int i3 = this.mDurationTime;
            if (i2 == i3) {
                b bVar2 = this.l;
                if (bVar2 != null) {
                    bVar2.b();
                }
                hideTailFrame();
            } else if (i3 - i2 > 3 || i3 - i2 <= 0 || (bVar = this.l) == null) {
            } else {
                bVar.a();
            }
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            onVPlayerNightModeChanged(false);
            setAlsHandler(new a(this));
            this.mVideoADClose = findViewById(e.video_ad_suffix_timer_close);
            this.mVideoADTimer = (TextView) findViewById(e.video_ad_suffix_timer);
            this.m = findViewById(e.video_ad_suffix_timer_close_area);
            this.n = (ImageView) findViewById(e.video_ad_suffix_close);
            this.o = (TextView) findViewById(e.video_ad_suffix_close_divider);
            this.p = (TextView) findViewById(e.video_ad_suffix_close_txt);
            this.m.setBackground(getResources().getDrawable(d.nad_videoplayer_video_ad_tip_bg));
            this.n.setImageDrawable(getResources().getDrawable(d.nad_videoplayer_video_ad_icon_close));
            this.mVideoADClose.setOnClickListener(this);
        }
    }

    public boolean isDataValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            n nVar = this.f37100i;
            return nVar != null && nVar.b();
        }
        return invokeV.booleanValue;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                ViewGroup.LayoutParams layoutParams = this.mVideoADClose.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.gravity = BadgeDrawable.BOTTOM_START;
                    layoutParams2.setMargins(getResources().getDimensionPixelSize(c.a.c0.d.c.nad_dimen_15dp), 0, 0, getResources().getDimensionPixelSize(c.a.c0.d.c.nad_dimen_10dp));
                    this.mVideoADClose.setLayoutParams(layoutParams2);
                }
                this.mVideoADTimer.setGravity(8388629);
                this.o.setVisibility(0);
                this.p.setVisibility(0);
                this.n.setVisibility(0);
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = this.mVideoADClose.getLayoutParams();
            if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                layoutParams4.gravity = BadgeDrawable.TOP_END;
                layoutParams4.setMargins(0, getResources().getDimensionPixelSize(c.a.c0.d.c.nad_dimen_10dp), getResources().getDimensionPixelSize(c.a.c0.d.c.nad_dimen_15dp), 0);
                this.mVideoADClose.setLayoutParams(layoutParams3);
            }
            this.mVideoADTimer.setGravity(17);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.n.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view) == null) && view.getId() == e.video_ad_suffix_timer_close && (fVar = this.q) != null) {
            fVar.O(8);
            this.q.M();
            this.q.F(c.a.c0.v.c0.f.w("layer_event_ad_finish"));
            if (!this.q.u().a0()) {
                this.q.F(g.w(PlayerEvent.ACTION_ON_COMPLETE));
            }
            sendALS(ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.BUTTON.type, "");
        }
    }

    public void onPlayerModeChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mAvatarView.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mNameView.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mOperateRootView.getLayoutParams();
            if (z) {
                layoutParams.width = (int) getResources().getDimension(c.a.c0.d.c.nad_suffix_video_tail_frame_avatar_width_half);
                layoutParams.height = (int) getResources().getDimension(c.a.c0.d.c.nad_suffix_video_tail_frame_avatar_width_half);
                layoutParams.bottomMargin = (int) getResources().getDimension(c.a.c0.d.c.nad_suffix_video_tail_frame_avatar_margin_bottom_half);
                layoutParams2.bottomMargin = (int) getResources().getDimension(c.a.c0.d.c.nad_suffix_video_tail_frame_name_margin_bottom_half);
                layoutParams3.width = (int) getResources().getDimension(c.a.c0.d.c.nad_suffix_video_tail_frame_operate_btn_width_half);
                layoutParams3.height = (int) getResources().getDimension(c.a.c0.d.c.nad_suffix_video_tail_frame_operate_btn_height_half);
                this.mNameView.setTextSize(14.0f);
                this.mCheckBtn.setTextSize(13.0f);
                this.mDownloadBtn.setTextSize(f.c.a(getContext(), 13.0f));
            } else {
                layoutParams.width = (int) getResources().getDimension(c.a.c0.d.c.nad_suffix_video_tail_frame_avatar_width_full);
                layoutParams.height = (int) getResources().getDimension(c.a.c0.d.c.nad_suffix_video_tail_frame_avatar_width_full);
                layoutParams.bottomMargin = (int) getResources().getDimension(c.a.c0.d.c.nad_suffix_video_tail_frame_avatar_margin_bottom_full);
                layoutParams2.bottomMargin = (int) getResources().getDimension(c.a.c0.d.c.nad_suffix_video_tail_frame_name_margin_bottom_full);
                layoutParams3.width = (int) getResources().getDimension(c.a.c0.d.c.nad_suffix_video_tail_frame_operate_btn_width_full);
                layoutParams3.height = (int) getResources().getDimension(c.a.c0.d.c.nad_suffix_video_tail_frame_operate_btn_height_full);
                this.mNameView.setTextSize(17.0f);
                this.mCheckBtn.setTextSize(14.0f);
                this.mDownloadBtn.setTextSize(14);
            }
            this.mAvatarView.setLayoutParams(layoutParams);
            this.mNameView.setLayoutParams(layoutParams2);
            this.mOperateRootView.setLayoutParams(layoutParams3);
        }
    }

    public void onVPlayerNightModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            onNightModeChanged();
        }
    }

    public void pauseCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f37101j = true;
            Handler handler = this.k;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
    }

    public void sendALS(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, str3) == null) && this.f37100i != null && NetUtil.a(getContext())) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.s(str);
            clogBuilder.p(ClogBuilder.Page.AD_TAIL);
            if (!TextUtils.isEmpty(str2)) {
                clogBuilder.g(str2);
            }
            clogBuilder.m(this.f37100i.l);
            if (!TextUtils.isEmpty(str3)) {
                clogBuilder.j(str3);
            }
            c.a.c0.a0.a.b(clogBuilder);
        }
    }

    public void setCallBack(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void setData(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, obj) == null) && (obj instanceof n)) {
            this.f37100i = (n) obj;
        }
    }

    public void showTail() {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (nVar = this.f37100i) == null) {
            return;
        }
        this.mDurationTime = nVar.f2248f;
        showTailFrame(nVar);
        if (this.f37100i.q) {
            startCountDown();
        } else {
            pauseCountDown();
        }
        if (TextUtils.equals(this.f37100i.n, "ad_full_video")) {
            this.mVideoADClose.setVisibility(0);
            j(!this.q.u().V0());
        }
    }

    public void startCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Handler handler = this.k;
            if (handler != null) {
                handler.removeMessages(1);
            } else {
                this.k = new c(this, null);
            }
            this.f37101j = false;
            this.k.sendMessage(this.k.obtainMessage(1));
        }
    }
}
