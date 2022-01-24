package com.baidu.nadcore.widget.view;

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
import c.a.c0.d.c;
import c.a.c0.d.e;
import c.a.c0.d.g;
import c.a.c0.g0.f;
import c.a.c0.s.d;
import c.a.c0.s.l;
import c.a.c0.s.m;
import c.a.c0.s.o;
import c.a.c0.v.p;
import c.a.c0.v.q;
import c.a.c0.v.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes10.dex */
public class NadExpressVideoOperateView extends NadExpressNaBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public AdImageView f37433h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public ImageView f37434i;

    /* renamed from: j  reason: collision with root package name */
    public p f37435j;
    @Nullable
    public ViewGroup k;
    public final t l;
    @Nullable
    public TextView mVideoLength;

    /* loaded from: classes10.dex */
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

        @Override // c.a.c0.v.i
        public void onEnd(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.f((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.c0.v.i
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.e((AdBaseModel) this.a.getTag(), str);
            }
        }

        @Override // c.a.c0.v.i
        public void onPause() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.c((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.c0.v.i
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.d((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.c0.v.i
        public void onResume() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.a((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.c0.v.i
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.a.f37434i != null) {
                    this.a.f37434i.setVisibility(8);
                }
                TextView textView = this.a.mVideoLength;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                if (this.a.f37433h != null) {
                    this.a.f37433h.setVisibility(8);
                }
                if (this.a.mVideoMediaListener == null || !(this.a.getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.a.mVideoMediaListener.b((AdBaseModel) this.a.getTag());
            }
        }
    }

    /* loaded from: classes10.dex */
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
            if (this.f37435j == null) {
                return;
            }
            boolean z = i2 == 0;
            if (z && this.f37435j.isPause()) {
                this.f37435j.resume();
            }
            if (z || !this.f37435j.isPlaying()) {
                return;
            }
            this.f37435j.pause();
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void initInflate(LayoutInflater layoutInflater, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater, oVar) == null) {
            int i2 = g.nad_feed_video;
            if (oVar != null && oVar.a(AdBaseModel.STYLE.VIDEO) != 0) {
                i2 = oVar.a(AdBaseModel.STYLE.VIDEO);
            }
            layoutInflater.inflate(i2, this);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void initLayout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f37433h = (AdImageView) findViewById(e.nad_feed_template_cover_image);
            this.mVideoLength = (TextView) findViewById(e.nad_feed_template_big_video_length_id);
            this.f37434i = (ImageView) findViewById(e.nad_feed_template_big_image_video_icon_id);
            this.k = (ViewGroup) findViewById(e.nad_feed_template_video_id);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            x();
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            p pVar = this.f37435j;
            if (pVar != null) {
                pVar.release();
                this.f37435j = null;
            }
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void updateSubViewData(AdBaseModel adBaseModel) {
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adBaseModel) == null) {
            if ((adBaseModel instanceof m) && adBaseModel.f37048h != null) {
                m mVar = (m) adBaseModel;
                TextView textView = this.mVideoLength;
                if (textView != null) {
                    int i2 = mVar.f37048h.a;
                    if (i2 != 0) {
                        this.mVideoLength.setText(String.format(Locale.ENGLISH, "%02d:%02d", Integer.valueOf((i2 / 60) % 60), Integer.valueOf(i2 % 60)));
                        int dimensionPixelSize = getResources().getDimensionPixelSize(c.nad_template_m8);
                        int dimensionPixelSize2 = getResources().getDimensionPixelSize(c.nad_template_m10);
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
                    if (this.f37435j == null) {
                        q qVar = new q();
                        qVar.a = 1;
                        this.f37435j = p.a.b(getContext(), 0, qVar);
                        c.a.c0.v.s0.a aVar = new c.a.c0.v.s0.a();
                        aVar.i(1);
                        this.f37435j.d(aVar);
                        this.f37435j.attachToContainer(this.k);
                    }
                    this.f37435j.c(adBaseModel.f37048h);
                    this.f37435j.a(this.l);
                }
                if (this.f37433h == null || mVar.f37044d.f2239h.size() <= 0 || (dVar = (d) c.a.c0.x.a.d(mVar.f37044d.f2239h, 0)) == null) {
                    return;
                }
                this.f37433h.displayImage(dVar.a);
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
                textView.setTextColor(getResources().getColor(c.a.c0.d.b.NAD_FC6));
                this.mVideoLength.setBackground(getResources().getDrawable(c.a.c0.d.d.nad_feed_video_tips_bg));
            }
            ImageView imageView = this.f37434i;
            if (imageView != null) {
                imageView.setImageDrawable(getResources().getDrawable(c.a.c0.d.d.nad_feed_video_play));
            }
            w();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Resources resources = getContext().getResources();
            int e2 = f.c.e(getContext()) - (resources.getDimensionPixelSize(c.NAD_F_M_W_X001) * 2);
            ViewGroup viewGroup = this.k;
            if (viewGroup != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.width = e2;
                layoutParams.height = Math.round((e2 / resources.getInteger(c.a.c0.d.f.nad_list_big_image_width)) * resources.getInteger(c.a.c0.d.f.nad_list_big_image_height));
                this.k.setLayoutParams(layoutParams);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.k.setOutlineProvider(new b(this));
                    this.k.setClipToOutline(true);
                }
            }
            AdImageView adImageView = this.f37433h;
            if (adImageView != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) adImageView.getLayoutParams();
                layoutParams2.width = e2;
                layoutParams2.height = Math.round((e2 / resources.getInteger(c.a.c0.d.f.nad_list_big_image_width)) * resources.getInteger(c.a.c0.d.f.nad_list_big_image_height));
                this.f37433h.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!(getTag() instanceof m)) {
                AdImageView adImageView = this.f37433h;
                if (adImageView != null) {
                    adImageView.setVisibility(0);
                }
                ImageView imageView = this.f37434i;
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
            m mVar = (m) getTag();
            if (this.k == null) {
                return;
            }
            if (this.f37435j == null) {
                q qVar = new q();
                qVar.a = 1;
                this.f37435j = p.a.b(getContext(), 0, qVar);
                c.a.c0.v.s0.a aVar = new c.a.c0.v.s0.a();
                aVar.i(1);
                this.f37435j.d(aVar);
                this.f37435j.attachToContainer(this.k);
                l lVar = mVar.f37048h;
                if (lVar != null) {
                    this.f37435j.c(lVar);
                }
                this.f37435j.a(this.l);
            }
            if (this.f37435j.isPlaying()) {
                return;
            }
            AdImageView adImageView2 = this.f37433h;
            if (adImageView2 != null) {
                adImageView2.setVisibility(8);
            }
            ImageView imageView2 = this.f37434i;
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
            this.f37435j.start();
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (o) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadExpressVideoOperateView(Context context, AttributeSet attributeSet, int i2, o oVar) {
        super(context, attributeSet, i2, oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), oVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (o) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.l = new a(this);
    }
}
