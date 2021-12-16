package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.b.e;
import c.a.c0.b.g;
import c.a.c0.p.l;
import c.a.c0.p.o;
import c.a.c0.s.p;
import c.a.c0.s.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class PortraitVideoView extends AdFeedBaseView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public p f38532h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f38533i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f38534j;

    /* renamed from: k  reason: collision with root package name */
    public final t f38535k;
    public NadVideoAdOverContainer mAdUiLayout;

    /* loaded from: classes10.dex */
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

        @Override // c.a.c0.s.i
        public void onEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.mVideoMediaListener.f((AdBaseModel) this.a.getTag());
                }
                this.a.showTailFrame();
            }
        }

        @Override // c.a.c0.s.i
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.e((AdBaseModel) this.a.getTag(), str);
            }
        }

        @Override // c.a.c0.s.i
        public void onPause() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.c((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.c0.s.i
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.d((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.c0.s.i
        public void onResume() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.a((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.c0.s.i
        public void onStart() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.mVideoMediaListener.b((AdBaseModel) this.a.getTag());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoView f38536e;

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
            this.f38536e = portraitVideoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f38536e.hideTailFrameAndReplay();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.h0.c0.b f38537e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoView f38538f;

        public c(PortraitVideoView portraitVideoView, c.a.c0.h0.c0.b bVar) {
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
            this.f38538f = portraitVideoView;
            this.f38537e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f38538f.getTag() instanceof AdBaseModel)) {
                this.f38537e.b((AdBaseModel) this.f38538f.getTag());
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
                if (this.f38532h != null) {
                    startVideo();
                    return;
                }
                return;
            }
            p pVar = this.f38532h;
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
            this.f38534j.setVisibility(0);
        }
    }

    public void hideTailFrameAndReplay() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.mAdUiLayout.isShowingTailFrame()) {
            hideAdTailFrame();
            reStartVideo();
        }
    }

    public void initInflate(LayoutInflater layoutInflater, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, layoutInflater, oVar) == null) {
            int i2 = g.nad_portrait_video;
            if (oVar != null && oVar.a(AdBaseModel.STYLE.PORTRAIT_VIDEO) != 0) {
                i2 = oVar.a(AdBaseModel.STYLE.PORTRAIT_VIDEO);
            }
            layoutInflater.inflate(i2, this);
        }
    }

    public void initLayout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            NadVideoAdOverContainer nadVideoAdOverContainer = (NadVideoAdOverContainer) findViewById(e.nad_ui_layout);
            this.mAdUiLayout = nadVideoAdOverContainer;
            nadVideoAdOverContainer.setOnClickListener(this);
            ImageView imageView = (ImageView) findViewById(e.video_pause_icon);
            this.f38533i = imageView;
            imageView.setOnClickListener(this);
            this.f38534j = (ViewGroup) findViewById(e.nad_mini_video_player_container);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (view.getId() == e.nad_ui_layout || view.getId() == e.video_pause_icon) {
                if (this.f38532h.isPlaying()) {
                    this.f38532h.pause();
                    this.f38533i.setVisibility(0);
                    return;
                }
                this.f38532h.resume();
                this.f38533i.setVisibility(4);
            }
        }
    }

    public void pauseVideo() {
        p pVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (pVar = this.f38532h) != null && pVar.isPlaying()) {
            this.f38532h.pause();
            this.f38533i.setVisibility(0);
        }
    }

    public void reStartVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f38534j.setVisibility(0);
            p pVar = this.f38532h;
            if (pVar != null) {
                pVar.start();
            }
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewStatChangeListener(c.a.c0.h0.c0.b bVar) {
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
            this.f38534j.setVisibility(4);
        }
    }

    public void startVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.mAdUiLayout.isShowingTailFrame()) {
                hideAdTailFrame();
            }
            p pVar = this.f38532h;
            if (pVar != null) {
                if (pVar.isPause()) {
                    this.f38532h.resume();
                } else {
                    this.f38532h.start();
                }
                this.f38533i.setVisibility(4);
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
            this.mAdUiLayout.setTag(e.nad_mini_video_model, adBaseModel);
        }
    }

    public void updateSubViewUi(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, adBaseModel) == null) {
            hideTailFrameAndReplay();
            this.mAdUiLayout.setOnNewTailFrameReplayClickListener(new b(this));
            if (this.f38532h == null) {
                p a2 = p.a.a(c.a.c0.e.a.b(), 0);
                this.f38532h = a2;
                a2.a(this.f38535k);
            }
            l lVar = adBaseModel.f38067h;
            if (lVar != null) {
                this.f38532h.c(lVar);
            }
            this.f38532h.attachToContainer(this.f38534j);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (o) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortraitVideoView(Context context, AttributeSet attributeSet, int i2, o oVar) {
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
        initInflate(LayoutInflater.from(context), oVar);
        initLayout(context);
        this.f38535k = new a(this);
    }
}
