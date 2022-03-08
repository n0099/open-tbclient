package com.baidu.nadcore.widget.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.b0.s.s;
import c.a.b0.v.p;
import c.a.b0.v.q;
import c.a.b0.v.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class AdFeedVideoBaseView extends AdFeedBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p mNativePlayer;

    /* loaded from: classes4.dex */
    public class a extends t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdFeedVideoBaseView a;

        public a(AdFeedVideoBaseView adFeedVideoBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedVideoBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adFeedVideoBaseView;
        }

        @Override // c.a.b0.v.i
        public void onEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                AdFeedVideoBaseView adFeedVideoBaseView = this.a;
                if (adFeedVideoBaseView.mVideoMediaListener == null || !(adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedVideoBaseView adFeedVideoBaseView2 = this.a;
                adFeedVideoBaseView2.mVideoMediaListener.f((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // c.a.b0.v.i
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
                AdFeedVideoBaseView adFeedVideoBaseView = this.a;
                if (adFeedVideoBaseView.mVideoMediaListener == null || !(adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedVideoBaseView adFeedVideoBaseView2 = this.a;
                adFeedVideoBaseView2.mVideoMediaListener.e((AdBaseModel) adFeedVideoBaseView2.getTag(), str);
            }
        }

        @Override // c.a.b0.v.i
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                AdFeedVideoBaseView adFeedVideoBaseView = this.a;
                if (adFeedVideoBaseView.mVideoMediaListener == null || !(adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedVideoBaseView adFeedVideoBaseView2 = this.a;
                adFeedVideoBaseView2.mVideoMediaListener.c((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // c.a.b0.v.i
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                AdFeedVideoBaseView adFeedVideoBaseView = this.a;
                if (adFeedVideoBaseView.mVideoMediaListener == null || !(adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedVideoBaseView adFeedVideoBaseView2 = this.a;
                adFeedVideoBaseView2.mVideoMediaListener.d((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // c.a.b0.v.i
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                AdFeedVideoBaseView adFeedVideoBaseView = this.a;
                if (adFeedVideoBaseView.mVideoMediaListener == null || !(adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedVideoBaseView adFeedVideoBaseView2 = this.a;
                adFeedVideoBaseView2.mVideoMediaListener.a((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // c.a.b0.v.i
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                AdFeedVideoBaseView adFeedVideoBaseView = this.a;
                if (adFeedVideoBaseView.mVideoMediaListener == null || !(adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedVideoBaseView adFeedVideoBaseView2 = this.a;
                adFeedVideoBaseView2.mVideoMediaListener.b((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFeedVideoBaseView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    public void bindVideoView(@NonNull ViewGroup viewGroup, @Nullable q qVar, @Nullable IVideoUpdateStrategy iVideoUpdateStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, viewGroup, qVar, iVideoUpdateStrategy) == null) {
            p pVar = this.mNativePlayer;
            if (pVar != null) {
                pVar.release();
                this.mNativePlayer = null;
            }
            p.a aVar = p.a;
            Context context = getContext();
            if (qVar == null) {
                qVar = q.f2236b;
            }
            p b2 = aVar.b(context, 0, qVar);
            this.mNativePlayer = b2;
            if (iVideoUpdateStrategy != null) {
                b2.d(iVideoUpdateStrategy);
            }
            this.mNativePlayer.attachToContainer(viewGroup);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.destroy();
            p pVar = this.mNativePlayer;
            if (pVar != null) {
                pVar.release();
                this.mNativePlayer = null;
            }
        }
    }

    public final void g(@NonNull AdBaseModel adBaseModel) {
        p pVar;
        c.a.b0.s.p pVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel) == null) || (pVar = this.mNativePlayer) == null || (pVar2 = adBaseModel.f35665j) == null) {
            return;
        }
        pVar.c(pVar2);
        this.mNativePlayer.a(new a(this));
    }

    public long getVideoPosMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            p pVar = this.mNativePlayer;
            if (pVar == null) {
                return -1L;
            }
            return pVar.b();
        }
        return invokeV.longValue;
    }

    public boolean playVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            p pVar = this.mNativePlayer;
            if (pVar == null || pVar.isPlaying()) {
                return false;
            }
            this.mNativePlayer.start();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean stopVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            p pVar = this.mNativePlayer;
            if (pVar == null) {
                return false;
            }
            pVar.stop();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) {
            super.update(adBaseModel);
            g(adBaseModel);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdFeedVideoBaseView(@NonNull Context context, AttributeSet attributeSet) {
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
    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i2) {
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
    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i2, s sVar) {
        super(context, attributeSet, i2);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }
}
