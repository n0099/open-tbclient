package com.baidu.nadcore.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.tieba.R;
import com.baidu.tieba.aq0;
import com.baidu.tieba.bq0;
import com.baidu.tieba.bs0;
import com.baidu.tieba.cs0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.fs0;
import com.baidu.tieba.lz0;
import com.baidu.tieba.mp0;
import com.baidu.tieba.n31;
import com.baidu.tieba.p01;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes2.dex */
public class NadExpressVideoOperateView extends NadExpressNaBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public AdImageView m;
    @Nullable
    public TextView n;
    @Nullable
    public ImageView o;
    public bs0 p;
    @Nullable
    public ViewGroup q;
    public final fs0 r;

    /* loaded from: classes2.dex */
    public class a extends fs0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadExpressVideoOperateView a;

        public a(NadExpressVideoOperateView nadExpressVideoOperateView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadExpressVideoOperateView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadExpressVideoOperateView;
        }

        @Override // com.baidu.tieba.fs0, com.baidu.tieba.yr0
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.b.f((AdBaseModel) this.a.getTag());
            }
        }

        @Override // com.baidu.tieba.fs0, com.baidu.tieba.yr0
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) && this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.b.e((AdBaseModel) this.a.getTag(), str);
            }
        }

        @Override // com.baidu.tieba.fs0, com.baidu.tieba.yr0
        public void onPause() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.b.c((AdBaseModel) this.a.getTag());
            }
        }

        @Override // com.baidu.tieba.fs0, com.baidu.tieba.yr0
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.b.d((AdBaseModel) this.a.getTag());
            }
        }

        @Override // com.baidu.tieba.fs0, com.baidu.tieba.yr0
        public void onResume() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.b.a((AdBaseModel) this.a.getTag());
            }
        }

        @Override // com.baidu.tieba.fs0, com.baidu.tieba.yr0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.a.o != null) {
                    this.a.o.setVisibility(8);
                }
                TextView textView = this.a.n;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                if (this.a.m != null) {
                    this.a.m.setVisibility(8);
                }
                if (this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.b.b((AdBaseModel) this.a.getTag());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadExpressVideoOperateView a;

        public b(NadExpressVideoOperateView nadExpressVideoOperateView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadExpressVideoOperateView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadExpressVideoOperateView;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) {
                outline.setRoundRect(new Rect(0, 0, this.a.q.getWidth(), this.a.q.getHeight()), n31.c.a(this.a.getContext(), 8.0f));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressVideoOperateView(Context context) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.dispatchWindowVisibilityChanged(i);
            if (this.p == null) {
                return;
            }
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && this.p.isPause()) {
                this.p.resume();
            }
            if (!z && this.p.isPlaying()) {
                this.p.pause();
            }
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.m = (AdImageView) findViewById(R.id.obfuscated_res_0x7f09162d);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f09162c);
            this.o = (ImageView) findViewById(R.id.obfuscated_res_0x7f09162b);
            this.q = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091633);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressVideoOperateView(Context context, AttributeSet attributeSet) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressVideoOperateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (dq0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadExpressVideoOperateView(Context context, AttributeSet attributeSet, int i, dq0 dq0Var) {
        super(context, attributeSet, i, dq0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), dq0Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (dq0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.r = new a(this);
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Resources resources = getContext().getResources();
            int e = n31.c.e(getContext()) - (resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070043) * 2);
            ViewGroup viewGroup = this.q;
            if (viewGroup != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.width = e;
                layoutParams.height = Math.round((e / resources.getInteger(R.integer.obfuscated_res_0x7f0a0021)) * resources.getInteger(R.integer.obfuscated_res_0x7f0a0020));
                this.q.setLayoutParams(layoutParams);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.q.setOutlineProvider(new b(this));
                    this.q.setClipToOutline(true);
                }
            }
            AdImageView adImageView = this.m;
            if (adImageView != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) adImageView.getLayoutParams();
                layoutParams2.width = e;
                layoutParams2.height = Math.round((e / resources.getInteger(R.integer.obfuscated_res_0x7f0a0021)) * resources.getInteger(R.integer.obfuscated_res_0x7f0a0020));
                this.m.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!(getTag() instanceof bq0)) {
                AdImageView adImageView = this.m;
                if (adImageView != null) {
                    adImageView.setVisibility(0);
                }
                ImageView imageView = this.o;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                TextView textView = this.n;
                if (textView != null && !TextUtils.isEmpty(textView.getText())) {
                    this.n.setVisibility(0);
                }
                ViewGroup viewGroup = this.q;
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                    return;
                }
                return;
            }
            bq0 bq0Var = (bq0) getTag();
            if (this.q == null) {
                return;
            }
            if (this.p == null) {
                cs0 cs0Var = new cs0();
                cs0Var.a = 1;
                this.p = bs0.a.b(getContext(), 0, cs0Var);
                lz0 lz0Var = new lz0();
                lz0Var.j(1);
                this.p.d(lz0Var);
                this.p.attachToContainer(this.q);
                aq0 aq0Var = bq0Var.j;
                if (aq0Var != null) {
                    this.p.c(aq0Var);
                }
                this.p.a(this.r);
            }
            if (!this.p.isPlaying()) {
                AdImageView adImageView2 = this.m;
                if (adImageView2 != null) {
                    adImageView2.setVisibility(8);
                }
                ImageView imageView2 = this.o;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                TextView textView2 = this.n;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                ViewGroup viewGroup2 = this.q;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(0);
                }
                this.p.start();
            }
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void j(LayoutInflater layoutInflater, dq0 dq0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, layoutInflater, dq0Var) == null) {
            if (dq0Var != null && dq0Var.a(AdBaseModel.STYLE.VIDEO) != 0) {
                i = dq0Var.a(AdBaseModel.STYLE.VIDEO);
            } else {
                i = R.layout.obfuscated_res_0x7f0d0601;
            }
            layoutInflater.inflate(i, this);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void m(AdBaseModel adBaseModel) {
        mp0 mp0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adBaseModel) == null) {
            if ((adBaseModel instanceof bq0) && adBaseModel.j != null) {
                bq0 bq0Var = (bq0) adBaseModel;
                TextView textView = this.n;
                if (textView != null) {
                    int i = bq0Var.j.b;
                    if (i != 0) {
                        this.n.setText(String.format(Locale.ENGLISH, "%02d:%02d", Integer.valueOf((i / 60) % 60), Integer.valueOf(i % 60)));
                        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070584);
                        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070583);
                        this.n.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
                        this.n.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        this.n.setCompoundDrawablePadding(dimensionPixelSize2);
                        this.n.setGravity(16);
                        this.n.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                }
                if (this.q != null) {
                    if (this.p == null) {
                        cs0 cs0Var = new cs0();
                        cs0Var.a = 1;
                        this.p = bs0.a.b(getContext(), 0, cs0Var);
                        lz0 lz0Var = new lz0();
                        lz0Var.j(1);
                        this.p.d(lz0Var);
                        this.p.attachToContainer(this.q);
                    }
                    this.p.c(adBaseModel.j);
                    this.p.a(this.r);
                }
                if (this.m != null && bq0Var.f.k.size() > 0 && (mp0Var = (mp0) p01.d(bq0Var.f.k, 0)) != null) {
                    this.m.g(mp0Var.a);
                    return;
                }
                return;
            }
            setVisibility(8);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void n(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) {
            setMaxTitleLine(2);
            TextView textView = this.n;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0602a9));
                this.n.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080dff));
            }
            ImageView imageView = this.o;
            if (imageView != null) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080dfe));
            }
            E();
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            F();
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            bs0 bs0Var = this.p;
            if (bs0Var != null) {
                bs0Var.release();
                this.p = null;
            }
        }
    }
}
