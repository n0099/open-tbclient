package com.baidu.nadcore.download.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.c0.e;
import c.a.b0.c0.f;
import c.a.b0.c0.g;
import c.a.b0.d0.q;
import c.a.b0.g.j.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AdInstallTipsView extends LinearLayout implements d, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f37548e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37549f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f37550g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f37551h;

    /* renamed from: i  reason: collision with root package name */
    public CountDownTextView f37552i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout f37553j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f37554k;
    public CountDownTextView l;
    public c.a.b0.g.j.b<AdInstallTipsView> m;
    public c n;

    /* loaded from: classes8.dex */
    public class a implements c.a.b0.o.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdInstallTipsView a;

        public a(AdInstallTipsView adInstallTipsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adInstallTipsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adInstallTipsView;
        }

        @Override // c.a.b0.o.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.b0.o.b
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.a.f37548e.setImageBitmap(bitmap);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c.a.b0.o.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdInstallTipsView a;

        public b(AdInstallTipsView adInstallTipsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adInstallTipsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adInstallTipsView;
        }

        @Override // c.a.b0.o.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.b0.o.b
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.a.f37548e.setImageBitmap(bitmap);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(ClogBuilder.Area area, boolean z, long j2, long j3);

        void onCancel();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdInstallTipsView(Context context) {
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

    public final CountDownTextView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.l.getVisibility() == 0) {
                return this.l;
            }
            return this.f37552i;
        }
        return (CountDownTextView) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d(LayoutInflater.from(getContext()).inflate(f.nad_install_tips_view, this));
            setBackground(getResources().getDrawable(c.a.b0.c0.d.nad_install_tips_bg));
            setOrientation(0);
            setGravity(16);
            this.m = new c.a.b0.g.j.b<>(this);
        }
    }

    public final void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.f37548e = (ImageView) view.findViewById(e.ad_install_tips_apk_icon);
            this.f37549f = (TextView) view.findViewById(e.ad_install_tips_apk_name);
            this.f37551h = (TextView) view.findViewById(e.ad_install_tips_delay_install_text);
            this.f37552i = (CountDownTextView) view.findViewById(e.ad_install_tips_delay_install_count_down);
            this.f37554k = (TextView) view.findViewById(e.ad_install_tips_install_now_text);
            this.l = (CountDownTextView) view.findViewById(e.ad_install_tips_install_now_count_down);
            this.f37550g = (FrameLayout) findViewById(e.ad_install_tips_delay_install_layout);
            this.f37553j = (FrameLayout) findViewById(e.ad_install_tips_install_now_layout);
            this.f37552i.setLabelText(getResources().getString(g.nad_apk_delay_install));
            this.l.setLabelText(getResources().getString(g.nad_button_install));
            this.f37552i.setTimerTextFormat(null, "s");
            this.l.setTimerTextFormat(null, "s");
            this.f37552i.setTextColor(Color.parseColor("#FF4141"));
            this.l.setTextColor(Color.parseColor("#FFFFFF"));
            this.f37552i.setTextSize(12);
            this.l.setTextSize(12);
            this.f37548e.setOnClickListener(this);
            this.f37549f.setOnClickListener(this);
            this.f37551h.setOnClickListener(this);
            this.f37552i.setOnClickListener(this);
            this.f37554k.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.f37550g.setOnClickListener(this);
            this.f37553j.setOnClickListener(this);
            setOnClickListener(this);
            q.a(getContext(), this.f37550g, 10.0f);
        }
    }

    public void dismissTips() {
        c.a.b0.g.j.b<AdInstallTipsView> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.m) == null) {
            return;
        }
        bVar.i();
    }

    @Override // c.a.b0.g.j.d
    public void onCancel(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            b().onCancel(j2, j3);
            c cVar = this.n;
            if (cVar != null) {
                cVar.onCancel();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ClogBuilder.Area area;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            int id = view.getId();
            if (id == e.ad_install_tips_apk_icon) {
                area = ClogBuilder.Area.ICON;
            } else if (id == e.ad_install_tips_apk_name) {
                area = ClogBuilder.Area.NAME;
            } else if (id != e.ad_install_tips_delay_install_text && id != e.ad_install_tips_delay_install_count_down && id != e.ad_install_tips_delay_install_layout) {
                if (id != e.ad_install_tips_install_now_text && id != e.ad_install_tips_install_now_count_down && id != e.ad_install_tips_install_now_layout) {
                    area = ClogBuilder.Area.HOTAREA;
                } else {
                    area = ClogBuilder.Area.INSTALL_NOW_BUTTON;
                }
            } else {
                area = ClogBuilder.Area.INSTALL_LATER_BUTTON;
            }
            ClogBuilder.Area area2 = area;
            c cVar = this.n;
            if (cVar != null) {
                cVar.a(area2, true, this.m.e(), this.m.j());
            }
        }
    }

    @Override // c.a.b0.g.j.d
    public void onFinish(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            b().onFinish(j2);
            ClogBuilder.Area area = this.l.getVisibility() == 0 ? ClogBuilder.Area.INSTALL_NOW_BUTTON : ClogBuilder.Area.INSTALL_LATER_BUTTON;
            c cVar = this.n;
            if (cVar != null) {
                cVar.a(area, false, this.m.e(), this.m.j());
            }
        }
    }

    @Override // c.a.b0.g.j.d
    public void onProgress(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            b().onProgress(j2, j3);
        }
    }

    @Override // c.a.b0.g.j.d
    public void onStart(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            b().onStart(j2, j3);
        }
    }

    public void setAction(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.n = cVar;
        }
    }

    public void update(String str, String str2, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            c.a.b0.o.a.a().b(str, new a(this));
            this.f37549f.setText(str2);
            if (z) {
                this.f37551h.setVisibility(8);
                this.f37552i.setVisibility(0);
                this.f37554k.setVisibility(0);
                this.l.setVisibility(8);
            } else {
                this.f37551h.setVisibility(0);
                this.f37552i.setVisibility(8);
                this.f37554k.setVisibility(8);
                this.l.setVisibility(0);
            }
            this.m.h(j2);
        }
    }

    public void updateStartTips(String str, String str2, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            c.a.b0.o.a.a().b(str, new b(this));
            this.f37549f.setText(str2);
            if (z) {
                this.f37551h.setVisibility(8);
                this.f37552i.setVisibility(0);
                this.f37554k.setVisibility(0);
                this.l.setVisibility(8);
                this.m.h(j2);
                return;
            }
            this.f37551h.setVisibility(0);
            this.f37552i.setVisibility(8);
            this.f37554k.setVisibility(0);
            this.l.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdInstallTipsView(Context context, @Nullable AttributeSet attributeSet) {
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
    public AdInstallTipsView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        c();
    }
}
