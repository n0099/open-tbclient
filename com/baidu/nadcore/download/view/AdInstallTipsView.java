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
import c.a.a0.h0.t;
import c.a.a0.j.j.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AdInstallTipsView extends LinearLayout implements d, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27515b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f27516c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27517d;

    /* renamed from: e  reason: collision with root package name */
    public CountDownTextView f27518e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f27519f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f27520g;

    /* renamed from: h  reason: collision with root package name */
    public CountDownTextView f27521h;
    public c.a.a0.j.j.b<AdInstallTipsView> i;
    public b j;

    /* loaded from: classes4.dex */
    public class a implements c.a.a0.r.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adInstallTipsView;
        }

        @Override // c.a.a0.r.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.a0.r.b
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.a.a.setImageBitmap(bitmap);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(ClogBuilder.Area area, boolean z, long j, long j2);

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.a0.j.j.d
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            e().a(j);
            ClogBuilder.Area area = this.f27521h.getVisibility() == 0 ? ClogBuilder.Area.INSTALL_NOW_BUTTON : ClogBuilder.Area.INSTALL_LATER_BUTTON;
            b bVar = this.j;
            if (bVar != null) {
                bVar.a(area, false, this.i.e(), this.i.j());
            }
        }
    }

    @Override // c.a.a0.j.j.d
    public void b(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            e().b(j, j2);
        }
    }

    @Override // c.a.a0.j.j.d
    public void c(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            e().c(j, j2);
            b bVar = this.j;
            if (bVar != null) {
                bVar.onCancel();
            }
        }
    }

    public final CountDownTextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f27521h.getVisibility() == 0) {
                return this.f27521h;
            }
            return this.f27518e;
        }
        return (CountDownTextView) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            g(LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05b5, this));
            setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080db3));
            setOrientation(0);
            setGravity(16);
            this.i = new c.a.a0.j.j.b<>(this);
        }
    }

    public final void g(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.a = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0900b1);
            this.f27515b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0900b2);
            this.f27517d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0900b6);
            this.f27518e = (CountDownTextView) view.findViewById(R.id.obfuscated_res_0x7f0900b4);
            this.f27520g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0900b9);
            this.f27521h = (CountDownTextView) view.findViewById(R.id.obfuscated_res_0x7f0900b7);
            this.f27516c = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0900b5);
            this.f27519f = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0900b8);
            this.f27518e.setLabelText(getResources().getString(R.string.obfuscated_res_0x7f0f0b41));
            this.f27521h.setLabelText(getResources().getString(R.string.obfuscated_res_0x7f0f0b50));
            this.f27518e.setTimerTextFormat(null, "s");
            this.f27521h.setTimerTextFormat(null, "s");
            this.f27518e.setTextColor(Color.parseColor("#FF4141"));
            this.f27521h.setTextColor(Color.parseColor("#FFFFFF"));
            this.f27518e.setTextSize(12);
            this.f27521h.setTextSize(12);
            this.a.setOnClickListener(this);
            this.f27515b.setOnClickListener(this);
            this.f27517d.setOnClickListener(this);
            this.f27518e.setOnClickListener(this);
            this.f27520g.setOnClickListener(this);
            this.f27521h.setOnClickListener(this);
            this.f27516c.setOnClickListener(this);
            this.f27519f.setOnClickListener(this);
            setOnClickListener(this);
            t.a(getContext(), this.f27516c, 10.0f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ClogBuilder.Area area;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            int id = view.getId();
            if (id == R.id.obfuscated_res_0x7f0900b1) {
                area = ClogBuilder.Area.ICON;
            } else if (id == R.id.obfuscated_res_0x7f0900b2) {
                area = ClogBuilder.Area.NAME;
            } else if (id == R.id.obfuscated_res_0x7f0900b6 || id == R.id.obfuscated_res_0x7f0900b4 || id == R.id.obfuscated_res_0x7f0900b5) {
                area = ClogBuilder.Area.INSTALL_LATER_BUTTON;
            } else if (id != R.id.obfuscated_res_0x7f0900b9 && id != R.id.obfuscated_res_0x7f0900b7 && id != R.id.obfuscated_res_0x7f0900b8) {
                area = ClogBuilder.Area.HOTAREA;
            } else {
                area = ClogBuilder.Area.INSTALL_NOW_BUTTON;
            }
            ClogBuilder.Area area2 = area;
            b bVar = this.j;
            if (bVar != null) {
                bVar.a(area2, true, this.i.e(), this.i.j());
            }
        }
    }

    @Override // c.a.a0.j.j.d
    public void onProgress(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            e().onProgress(j, j2);
        }
    }

    public void setAction(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.j = bVar;
        }
    }

    public void update(String str, String str2, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            c.a.a0.r.a.a().b(str, new a(this));
            this.f27515b.setText(str2);
            if (z) {
                this.f27517d.setVisibility(8);
                this.f27518e.setVisibility(0);
                this.f27520g.setVisibility(0);
                this.f27521h.setVisibility(8);
            } else {
                this.f27517d.setVisibility(0);
                this.f27518e.setVisibility(8);
                this.f27520g.setVisibility(8);
                this.f27521h.setVisibility(0);
            }
            this.i.h(j);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdInstallTipsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        f();
    }
}
