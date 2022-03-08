package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.s.s;
import c.a.b0.v.p;
import c.a.b0.v.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedBaseView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PortraitVideoView extends AdFeedBaseView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public p f36073h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f36074i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f36075j;
    public final t k;
    public NadVideoAdOverContainer mAdUiLayout;

    /* loaded from: classes4.dex */
    public class a extends t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PortraitVideoView a;

        public a(PortraitVideoView portraitVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = portraitVideoView;
        }

        @Override // c.a.b0.v.i
        public void onEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.mVideoMediaListener.f((AdBaseModel) this.a.getTag());
                }
                this.a.showTailFrame();
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
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.b((AdBaseModel) this.a.getTag());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoView f36076e;

        public b(PortraitVideoView portraitVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36076e = portraitVideoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f36076e.hideTailFrameAndReplay();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.b0.l0.p.b f36077e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoView f36078f;

        public c(PortraitVideoView portraitVideoView, c.a.b0.l0.p.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoView, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36078f = portraitVideoView;
            this.f36077e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f36078f.getTag() instanceof AdBaseModel)) {
                this.f36077e.b((AdBaseModel) this.f36078f.getTag());
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortraitVideoView(Context context) {
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
    public void dispatchVisibilityChanged(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            super.dispatchVisibilityChanged(view, i2);
            if (i2 == 0) {
                if (this.f36073h != null) {
                    startVideo();
                    return;
                }
                return;
            }
            p pVar = this.f36073h;
            if (pVar == null || !pVar.isPlaying()) {
                return;
            }
            pauseVideo();
        }
    }

    public void hideAdTailFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mAdUiLayout.showNewTailFrame(false);
            this.f36075j.setVisibility(0);
        }
    }

    public void hideTailFrameAndReplay() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.mAdUiLayout.isShowingTailFrame()) {
            hideAdTailFrame();
            reStartVideo();
        }
    }

    public void initInflate(LayoutInflater layoutInflater, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, layoutInflater, sVar) == null) {
            layoutInflater.inflate((sVar == null || sVar.a(AdBaseModel.STYLE.PORTRAIT_VIDEO) == 0) ? R.layout.nad_portrait_video : sVar.a(AdBaseModel.STYLE.PORTRAIT_VIDEO), this);
        }
    }

    public void initLayout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            NadVideoAdOverContainer nadVideoAdOverContainer = (NadVideoAdOverContainer) findViewById(R.id.nad_ui_layout);
            this.mAdUiLayout = nadVideoAdOverContainer;
            nadVideoAdOverContainer.setOnClickListener(this);
            ImageView imageView = (ImageView) findViewById(R.id.video_pause_icon);
            this.f36074i = imageView;
            imageView.setOnClickListener(this);
            this.f36075j = (ViewGroup) findViewById(R.id.nad_mini_video_player_container);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (view.getId() == R.id.nad_ui_layout || view.getId() == R.id.video_pause_icon) {
                if (this.f36073h.isPlaying()) {
                    this.f36073h.pause();
                    this.f36074i.setVisibility(0);
                    return;
                }
                this.f36073h.resume();
                this.f36074i.setVisibility(4);
            }
        }
    }

    public void pauseVideo() {
        p pVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (pVar = this.f36073h) != null && pVar.isPlaying()) {
            this.f36073h.pause();
            this.f36074i.setVisibility(0);
        }
    }

    public void reStartVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f36075j.setVisibility(0);
            p pVar = this.f36073h;
            if (pVar != null) {
                pVar.start();
            }
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewStatChangeListener(c.a.b0.l0.p.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            super.setViewStatChangeListener(bVar);
            this.mAdUiLayout.setOnUiClickListener(new c(this, bVar));
        }
    }

    public final void showTailFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mAdUiLayout.showNewTailFrame(true);
            this.f36075j.setVisibility(4);
        }
    }

    public void startVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.mAdUiLayout.isShowingTailFrame()) {
                hideAdTailFrame();
            }
            p pVar = this.f36073h;
            if (pVar != null) {
                if (pVar.isPause()) {
                    this.f36073h.resume();
                } else {
                    this.f36073h.start();
                }
                this.f36074i.setVisibility(4);
            }
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, adBaseModel) == null) {
            super.update(adBaseModel);
            updateSubViewData(adBaseModel);
            updateSubViewUi(adBaseModel);
        }
    }

    public void updateSubViewData(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adBaseModel) == null) {
            this.mAdUiLayout.setVisibility(0);
            this.mAdUiLayout.setData(adBaseModel);
            this.mAdUiLayout.setTag(R.id.nad_mini_video_model, adBaseModel);
        }
    }

    public void updateSubViewUi(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, adBaseModel) == null) {
            hideTailFrameAndReplay();
            this.mAdUiLayout.setOnNewTailFrameReplayClickListener(new b(this));
            if (this.f36073h == null) {
                p a2 = p.a.a(c.a.b0.h.a.b(), 0);
                this.f36073h = a2;
                a2.a(this.k);
            }
            c.a.b0.s.p pVar = adBaseModel.f35665j;
            if (pVar != null) {
                this.f36073h.c(pVar);
            }
            this.f36073h.attachToContainer(this.f36075j);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortraitVideoView(Context context, AttributeSet attributeSet) {
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
    public PortraitVideoView(Context context, AttributeSet attributeSet, int i2) {
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
    public PortraitVideoView(Context context, AttributeSet attributeSet, int i2, s sVar) {
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
        initInflate(LayoutInflater.from(context), sVar);
        initLayout(context);
        this.k = new a(this);
    }
}
