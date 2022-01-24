package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import c.a.c0.d.c;
import c.a.c0.d.e;
import c.a.c0.d.g;
import c.a.c0.s.l;
import c.a.c0.s.n;
import c.a.c0.s.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.player.tail.AdBaseTailFrameView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class HorizontalVideoTailView extends AdBaseTailFrameView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public p f37380i;

    /* renamed from: j  reason: collision with root package name */
    public SimpleAdInfoView f37381j;

    /* loaded from: classes10.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HorizontalVideoTailView f37382b;

        public a(HorizontalVideoTailView horizontalVideoTailView, n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalVideoTailView, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37382b = horizontalVideoTailView;
            this.a = nVar;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f37382b.h(ClogBuilder.LogType.FREE_CLICK, str, this.a);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HorizontalVideoTailView(Context context) {
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

    public final void h(ClogBuilder.LogType logType, String str, n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, logType, str, nVar) == null) || nVar == null) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.r(logType);
        clogBuilder.g(str);
        clogBuilder.m(nVar.l);
        c.a.c0.a0.a.b(clogBuilder);
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            super.init(context);
            this.f37381j = (SimpleAdInfoView) findViewById(e.ad_app_info_view);
        }
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public int layoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? g.nad_horizontal_video_tail_view : invokeV.intValue;
    }

    public void setAdInfo(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) {
            this.f37380i = pVar;
        }
    }

    public boolean showTailFrame(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, adBaseModel)) == null) {
            if (adBaseModel == null || (lVar = adBaseModel.f37048h) == null) {
                return false;
            }
            return showTailFrame(lVar.f2242c);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HorizontalVideoTailView(Context context, @Nullable AttributeSet attributeSet) {
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
    public HorizontalVideoTailView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public boolean showTailFrame(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, nVar)) == null) {
            nVar.o = false;
            boolean showTailFrame = super.showTailFrame(nVar);
            p pVar = this.f37380i;
            if (pVar != null && pVar.k) {
                Resources resources = getContext().getResources();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f37381j.getLayoutParams();
                layoutParams.leftMargin = resources.getDimensionPixelOffset(c.nad_dimen_15dp);
                layoutParams.rightMargin = resources.getDimensionPixelOffset(c.nad_dimen_15dp);
                this.f37381j.setLayoutParams(layoutParams);
                this.f37381j.setAdInfo(this.f37380i);
                this.f37381j.setVisibility(0);
                this.f37381j.setAfterListener(new a(this, nVar));
            } else {
                this.f37381j.setVisibility(8);
            }
            return showTailFrame;
        }
        return invokeL.booleanValue;
    }
}
