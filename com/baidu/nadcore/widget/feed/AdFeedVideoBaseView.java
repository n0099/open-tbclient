package com.baidu.nadcore.widget.feed;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jp0;
import com.repackage.mn0;
import com.repackage.np0;
import com.repackage.pn0;
/* loaded from: classes2.dex */
public abstract class AdFeedVideoBaseView extends AdFeedBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jp0 i;

    /* loaded from: classes2.dex */
    public class a extends np0 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adFeedVideoBaseView;
        }

        @Override // com.repackage.np0, com.repackage.gp0
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                AdFeedVideoBaseView adFeedVideoBaseView = this.a;
                if (adFeedVideoBaseView.b == null || !(adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedVideoBaseView adFeedVideoBaseView2 = this.a;
                adFeedVideoBaseView2.b.f((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.repackage.np0, com.repackage.gp0
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) {
                AdFeedVideoBaseView adFeedVideoBaseView = this.a;
                if (adFeedVideoBaseView.b == null || !(adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedVideoBaseView adFeedVideoBaseView2 = this.a;
                adFeedVideoBaseView2.b.e((AdBaseModel) adFeedVideoBaseView2.getTag(), str);
            }
        }

        @Override // com.repackage.np0, com.repackage.gp0
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                AdFeedVideoBaseView adFeedVideoBaseView = this.a;
                if (adFeedVideoBaseView.b == null || !(adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedVideoBaseView adFeedVideoBaseView2 = this.a;
                adFeedVideoBaseView2.b.c((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.repackage.np0, com.repackage.gp0
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                AdFeedVideoBaseView adFeedVideoBaseView = this.a;
                if (adFeedVideoBaseView.b == null || !(adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedVideoBaseView adFeedVideoBaseView2 = this.a;
                adFeedVideoBaseView2.b.d((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.repackage.np0, com.repackage.gp0
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                AdFeedVideoBaseView adFeedVideoBaseView = this.a;
                if (adFeedVideoBaseView.b == null || !(adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedVideoBaseView adFeedVideoBaseView2 = this.a;
                adFeedVideoBaseView2.b.a((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.repackage.np0, com.repackage.gp0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                AdFeedVideoBaseView adFeedVideoBaseView = this.a;
                if (adFeedVideoBaseView.b == null || !(adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedVideoBaseView adFeedVideoBaseView2 = this.a;
                adFeedVideoBaseView2.b.b((AdBaseModel) adFeedVideoBaseView2.getTag());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.c();
            jp0 jp0Var = this.i;
            if (jp0Var != null) {
                jp0Var.release();
                this.i = null;
            }
        }
    }

    public long getVideoPosMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            jp0 jp0Var = this.i;
            if (jp0Var == null) {
                return -1L;
            }
            return jp0Var.b();
        }
        return invokeV.longValue;
    }

    public final void i(@NonNull AdBaseModel adBaseModel) {
        jp0 jp0Var;
        mn0 mn0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel) == null) || (jp0Var = this.i) == null || (mn0Var = adBaseModel.j) == null) {
            return;
        }
        jp0Var.c(mn0Var);
        this.i.a(new a(this));
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) {
            super.update(adBaseModel);
            i(adBaseModel);
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
    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i) {
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (pn0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i, pn0 pn0Var) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), pn0Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }
}
