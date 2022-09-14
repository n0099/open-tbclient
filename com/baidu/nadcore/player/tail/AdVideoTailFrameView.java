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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.player.tail.AdBaseTailFrameView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.g21;
import com.baidu.tieba.uz0;
import com.baidu.tieba.xs0;
import com.baidu.tieba.yo0;
import com.baidu.tieba.ys0;
import com.baidu.tieba.yv0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class AdVideoTailFrameView extends AdEmbeddedTailFrameView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yo0 m;
    public int n;
    public int o;
    public boolean p;
    public Handler q;
    public b r;
    public View s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public View x;
    public yv0 y;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.u(str, str2, "");
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
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
                if (adVideoTailFrameView == null || message.what != 1 || adVideoTailFrameView.p) {
                    return;
                }
                adVideoTailFrameView.o++;
                Message message2 = new Message();
                message2.what = 1;
                if (adVideoTailFrameView.w.getVisibility() == 0) {
                    adVideoTailFrameView.w.setText(String.format("%ds", Integer.valueOf(adVideoTailFrameView.n - adVideoTailFrameView.o)));
                }
                sendMessageDelayed(message2, 1000L);
                adVideoTailFrameView.o();
            }
        }

        public c(AdVideoTailFrameView adVideoTailFrameView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoTailFrameView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(adVideoTailFrameView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoTailFrameView(Context context, yv0 yv0Var, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, yv0Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 5;
        this.o = 0;
        this.y = yv0Var;
        p();
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            t();
            this.o = 0;
            yv0 yv0Var = this.y;
            if (yv0Var != null) {
                yv0Var.N();
                this.y.P(8);
            }
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            yo0 yo0Var = this.m;
            if (yo0Var != null && TextUtils.equals(yo0Var.n, "ad_full_video")) {
                x(z);
            }
            r(z);
        }
    }

    public final void o() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i = this.o;
            int i2 = this.n;
            if (i == i2) {
                b bVar2 = this.r;
                if (bVar2 != null) {
                    bVar2.b();
                }
                d();
            } else if (i2 - i > 3 || i2 - i <= 0 || (bVar = this.r) == null) {
            } else {
                bVar.a();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        yv0 yv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f092505 && (yv0Var = this.y) != null) {
            yv0Var.P(8);
            this.y.N();
            this.y.F(xs0.w("layer_event_ad_finish"));
            if (!this.y.u().a0()) {
                this.y.F(ys0.w(PlayerEvent.ACTION_ON_COMPLETE));
            }
            u(ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.BUTTON.type, "");
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            s(false);
            setAlsHandler(new a(this));
            this.x = findViewById(R.id.obfuscated_res_0x7f092505);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f092504);
            this.s = findViewById(R.id.obfuscated_res_0x7f092506);
            this.t = (ImageView) findViewById(R.id.obfuscated_res_0x7f092501);
            this.u = (TextView) findViewById(R.id.obfuscated_res_0x7f092502);
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f092503);
            this.s.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e35));
            this.t.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e34));
            this.x.setOnClickListener(this);
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            yo0 yo0Var = this.m;
            return yo0Var != null && yo0Var.i();
        }
        return invokeV.booleanValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            if (z) {
                layoutParams.width = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07057a);
                layoutParams.height = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07057a);
                layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070578);
                layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07057c);
                layoutParams3.width = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070580);
                layoutParams3.height = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07057e);
                this.c.setTextSize(14.0f);
                this.d.setTextSize(13.0f);
                this.e.setTextSize(g21.c.a(getContext(), 13.0f));
            } else {
                layoutParams.width = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070579);
                layoutParams.height = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070579);
                layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070577);
                layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07057b);
                layoutParams3.width = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07057f);
                layoutParams3.height = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07057d);
                this.c.setTextSize(17.0f);
                this.d.setTextSize(14.0f);
                this.e.setTextSize(14);
            }
            this.b.setLayoutParams(layoutParams);
            this.c.setLayoutParams(layoutParams2);
            this.f.setLayoutParams(layoutParams3);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            g();
        }
    }

    public void setCallBack(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public void setData(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, obj) == null) && (obj instanceof yo0)) {
            this.m = (yo0) obj;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.p = true;
            Handler handler = this.q;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
    }

    public void u(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, str, str2, str3) == null) && this.m != null && NetUtil.a(getContext())) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.z(str);
            clogBuilder.u(ClogBuilder.Page.AD_TAIL);
            if (!TextUtils.isEmpty(str2)) {
                clogBuilder.j(str2);
            }
            clogBuilder.p(this.m.l);
            if (!TextUtils.isEmpty(str3)) {
                clogBuilder.m(str3);
            }
            uz0.b(clogBuilder);
        }
    }

    public void v() {
        yo0 yo0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (yo0Var = this.m) == null) {
            return;
        }
        this.n = yo0Var.f;
        k(yo0Var);
        if (this.m.q) {
            w();
        } else {
            t();
        }
        if (TextUtils.equals(this.m.n, "ad_full_video")) {
            this.x.setVisibility(0);
            x(!this.y.u().V0());
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Handler handler = this.q;
            if (handler != null) {
                handler.removeMessages(1);
            } else {
                this.q = new c(this, null);
            }
            this.p = false;
            this.q.sendMessage(this.q.obtainMessage(1));
        }
    }

    public final void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.gravity = BadgeDrawable.BOTTOM_START;
                    layoutParams2.setMargins(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070536), 0, 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070531));
                    this.x.setLayoutParams(layoutParams2);
                }
                this.w.setGravity(8388629);
                this.u.setVisibility(0);
                this.v.setVisibility(0);
                this.t.setVisibility(0);
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = this.x.getLayoutParams();
            if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                layoutParams4.gravity = BadgeDrawable.TOP_END;
                layoutParams4.setMargins(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070531), getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070536), 0);
                this.x.setLayoutParams(layoutParams3);
            }
            this.w.setGravity(17);
            this.u.setVisibility(8);
            this.v.setVisibility(8);
            this.t.setVisibility(8);
        }
    }
}
