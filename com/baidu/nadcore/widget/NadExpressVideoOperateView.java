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
import c.a.b0.h0.f;
import c.a.b0.s.d;
import c.a.b0.s.q;
import c.a.b0.s.s;
import c.a.b0.v.p;
import c.a.b0.v.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes4.dex */
public class NadExpressVideoOperateView extends NadExpressNaBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public AdImageView f35892h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public ImageView f35893i;

    /* renamed from: j  reason: collision with root package name */
    public p f35894j;
    @Nullable
    public ViewGroup k;
    public final t l;
    @Nullable
    public TextView mVideoLength;

    /* loaded from: classes4.dex */
    public class a extends t {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadExpressVideoOperateView;
        }

        @Override // c.a.b0.v.i
        public void onEnd(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.f((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.b0.v.i
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.e((AdBaseModel) this.a.getTag(), str);
            }
        }

        @Override // c.a.b0.v.i
        public void onPause() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.c((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.b0.v.i
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.d((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.b0.v.i
        public void onResume() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.a((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.b0.v.i
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.a.f35893i != null) {
                    this.a.f35893i.setVisibility(8);
                }
                TextView textView = this.a.mVideoLength;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                if (this.a.f35892h != null) {
                    this.a.f35892h.setVisibility(8);
                }
                if (this.a.mVideoMediaListener == null || !(this.a.getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.a.mVideoMediaListener.b((AdBaseModel) this.a.getTag());
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadExpressVideoOperateView;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, outline) == null) {
                outline.setRoundRect(new Rect(0, 0, this.a.k.getWidth(), this.a.k.getHeight()), f.c.a(this.a.getContext(), 8.0f));
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.dispatchWindowVisibilityChanged(i2);
            if (this.f35894j == null) {
                return;
            }
            boolean z = i2 == 0;
            if (z && this.f35894j.isPause()) {
                this.f35894j.resume();
            }
            if (z || !this.f35894j.isPlaying()) {
                return;
            }
            this.f35894j.pause();
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void initInflate(LayoutInflater layoutInflater, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater, sVar) == null) {
            layoutInflater.inflate((sVar == null || sVar.a(AdBaseModel.STYLE.VIDEO) == 0) ? R.layout.nad_feed_video : sVar.a(AdBaseModel.STYLE.VIDEO), this);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void initLayout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f35892h = (AdImageView) findViewById(R.id.nad_feed_template_cover_image);
            this.mVideoLength = (TextView) findViewById(R.id.nad_feed_template_big_video_length_id);
            this.f35893i = (ImageView) findViewById(R.id.nad_feed_template_big_image_video_icon_id);
            this.k = (ViewGroup) findViewById(R.id.nad_feed_template_video_id);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            w();
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            p pVar = this.f35894j;
            if (pVar != null) {
                pVar.release();
                this.f35894j = null;
            }
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void updateSubViewData(AdBaseModel adBaseModel) {
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adBaseModel) == null) {
            if ((adBaseModel instanceof q) && adBaseModel.f35665j != null) {
                q qVar = (q) adBaseModel;
                TextView textView = this.mVideoLength;
                if (textView != null) {
                    int i2 = qVar.f35665j.f1932b;
                    if (i2 != 0) {
                        this.mVideoLength.setText(String.format(Locale.ENGLISH, "%02d:%02d", Integer.valueOf((i2 / 60) % 60), Integer.valueOf(i2 % 60)));
                        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.nad_template_m8);
                        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.nad_template_m10);
                        this.mVideoLength.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
                        this.mVideoLength.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        this.mVideoLength.setCompoundDrawablePadding(dimensionPixelSize2);
                        this.mVideoLength.setGravity(16);
                        this.mVideoLength.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                }
                if (this.k != null) {
                    if (this.f35894j == null) {
                        c.a.b0.v.q qVar2 = new c.a.b0.v.q();
                        qVar2.a = 1;
                        this.f35894j = p.a.b(getContext(), 0, qVar2);
                        c.a.b0.v.s0.a aVar = new c.a.b0.v.s0.a();
                        aVar.i(1);
                        this.f35894j.d(aVar);
                        this.f35894j.attachToContainer(this.k);
                    }
                    this.f35894j.c(adBaseModel.f35665j);
                    this.f35894j.a(this.l);
                }
                if (this.f35892h == null || qVar.f35661f.k.size() <= 0 || (dVar = (d) c.a.b0.x.a.d(qVar.f35661f.k, 0)) == null) {
                    return;
                }
                this.f35892h.displayImage(dVar.a);
                return;
            }
            setVisibility(8);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void updateSubViewUi(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) {
            setMaxTitleLine(2);
            TextView textView = this.mVideoLength;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.NAD_FC6));
                this.mVideoLength.setBackground(getResources().getDrawable(R.drawable.nad_feed_video_tips_bg));
            }
            ImageView imageView = this.f35893i;
            if (imageView != null) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.nad_feed_video_play));
            }
            v();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Resources resources = getContext().getResources();
            int e2 = f.c.e(getContext()) - (resources.getDimensionPixelSize(R.dimen.NAD_F_M_W_X001) * 2);
            ViewGroup viewGroup = this.k;
            if (viewGroup != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.width = e2;
                layoutParams.height = Math.round((e2 / resources.getInteger(R.integer.nad_list_big_image_width)) * resources.getInteger(R.integer.nad_list_big_image_height));
                this.k.setLayoutParams(layoutParams);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.k.setOutlineProvider(new b(this));
                    this.k.setClipToOutline(true);
                }
            }
            AdImageView adImageView = this.f35892h;
            if (adImageView != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) adImageView.getLayoutParams();
                layoutParams2.width = e2;
                layoutParams2.height = Math.round((e2 / resources.getInteger(R.integer.nad_list_big_image_width)) * resources.getInteger(R.integer.nad_list_big_image_height));
                this.f35892h.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!(getTag() instanceof q)) {
                AdImageView adImageView = this.f35892h;
                if (adImageView != null) {
                    adImageView.setVisibility(0);
                }
                ImageView imageView = this.f35893i;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                TextView textView = this.mVideoLength;
                if (textView != null && !TextUtils.isEmpty(textView.getText())) {
                    this.mVideoLength.setVisibility(0);
                }
                ViewGroup viewGroup = this.k;
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                    return;
                }
                return;
            }
            q qVar = (q) getTag();
            if (this.k == null) {
                return;
            }
            if (this.f35894j == null) {
                c.a.b0.v.q qVar2 = new c.a.b0.v.q();
                qVar2.a = 1;
                this.f35894j = p.a.b(getContext(), 0, qVar2);
                c.a.b0.v.s0.a aVar = new c.a.b0.v.s0.a();
                aVar.i(1);
                this.f35894j.d(aVar);
                this.f35894j.attachToContainer(this.k);
                c.a.b0.s.p pVar = qVar.f35665j;
                if (pVar != null) {
                    this.f35894j.c(pVar);
                }
                this.f35894j.a(this.l);
            }
            if (this.f35894j.isPlaying()) {
                return;
            }
            AdImageView adImageView2 = this.f35892h;
            if (adImageView2 != null) {
                adImageView2.setVisibility(8);
            }
            ImageView imageView2 = this.f35893i;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            TextView textView2 = this.mVideoLength;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.k;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
            }
            this.f35894j.start();
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressVideoOperateView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (s) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadExpressVideoOperateView(Context context, AttributeSet attributeSet, int i2, s sVar) {
        super(context, attributeSet, i2, sVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), sVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (s) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.l = new a(this);
    }
}
