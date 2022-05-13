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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b21;
import com.repackage.om0;
import com.repackage.pm0;
import com.repackage.tk0;
import com.repackage.vk0;
/* loaded from: classes2.dex */
public class AdInstallTipsView extends LinearLayout implements vk0, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public FrameLayout c;
    public TextView d;
    public CountDownTextView e;
    public FrameLayout f;
    public TextView g;
    public CountDownTextView h;
    public tk0<AdInstallTipsView> i;
    public b j;

    /* loaded from: classes2.dex */
    public class a implements pm0 {
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

        @Override // com.repackage.pm0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.pm0
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.a.a.setImageBitmap(bitmap);
            }
        }
    }

    /* loaded from: classes2.dex */
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

    @Override // com.repackage.vk0
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            e().a(j);
            ClogBuilder.Area area = this.h.getVisibility() == 0 ? ClogBuilder.Area.INSTALL_NOW_BUTTON : ClogBuilder.Area.INSTALL_LATER_BUTTON;
            b bVar = this.j;
            if (bVar != null) {
                bVar.a(area, false, this.i.e(), this.i.j());
            }
        }
    }

    @Override // com.repackage.vk0
    public void b(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            e().b(j, j2);
        }
    }

    @Override // com.repackage.vk0
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
            if (this.h.getVisibility() == 0) {
                return this.h;
            }
            return this.e;
        }
        return (CountDownTextView) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            g(LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05a4, this));
            setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080dd3));
            setOrientation(0);
            setGravity(16);
            this.i = new tk0<>(this);
        }
    }

    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.a = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0900b0);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0900b1);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0900b5);
            this.e = (CountDownTextView) view2.findViewById(R.id.obfuscated_res_0x7f0900b3);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0900b8);
            this.h = (CountDownTextView) view2.findViewById(R.id.obfuscated_res_0x7f0900b6);
            this.c = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0900b4);
            this.f = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0900b7);
            this.e.setLabelText(getResources().getString(R.string.obfuscated_res_0x7f0f0b56));
            this.h.setLabelText(getResources().getString(R.string.obfuscated_res_0x7f0f0b65));
            this.e.setTimerTextFormat(null, "s");
            this.h.setTimerTextFormat(null, "s");
            this.e.setTextColor(Color.parseColor("#FF4141"));
            this.h.setTextColor(Color.parseColor("#FFFFFF"));
            this.e.setTextSize(12);
            this.h.setTextSize(12);
            this.a.setOnClickListener(this);
            this.b.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.h.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.f.setOnClickListener(this);
            setOnClickListener(this);
            b21.a(getContext(), this.c, 10.0f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ClogBuilder.Area area;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0900b0) {
                area = ClogBuilder.Area.ICON;
            } else if (id == R.id.obfuscated_res_0x7f0900b1) {
                area = ClogBuilder.Area.NAME;
            } else if (id == R.id.obfuscated_res_0x7f0900b5 || id == R.id.obfuscated_res_0x7f0900b3 || id == R.id.obfuscated_res_0x7f0900b4) {
                area = ClogBuilder.Area.INSTALL_LATER_BUTTON;
            } else if (id != R.id.obfuscated_res_0x7f0900b8 && id != R.id.obfuscated_res_0x7f0900b6 && id != R.id.obfuscated_res_0x7f0900b7) {
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

    @Override // com.repackage.vk0
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
            om0.a().b(str, new a(this));
            this.b.setText(str2);
            if (z) {
                this.d.setVisibility(8);
                this.e.setVisibility(0);
                this.g.setVisibility(0);
                this.h.setVisibility(8);
            } else {
                this.d.setVisibility(0);
                this.e.setVisibility(8);
                this.g.setVisibility(8);
                this.h.setVisibility(0);
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
