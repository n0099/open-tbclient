package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.d.e;
import c.a.c0.k0.x.a;
import c.a.c0.k0.z.b;
import c.a.c0.k0.z.c;
import c.a.c0.s.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedBaseView;
import com.baidu.nadcore.widget.uitemplate.NadExpressBottomView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public abstract class NadExpressNaBaseView extends AdFeedBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final c mCreator;
    @Nullable
    public NadExpressBottomView mLabelView;
    @Nullable
    public b mNadExpressOperateBar;
    @Nullable
    public TextView mTitle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressNaBaseView(Context context) {
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

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.destroy();
            b bVar = this.mNadExpressOperateBar;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void doInitLayout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.mTitle = (TextView) findViewById(e.nad_feed_template_base_title_id);
            this.mLabelView = (NadExpressBottomView) findViewById(e.nad_feed_ad_label_view);
            initLayout(context);
        }
    }

    public b getOperateBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mNadExpressOperateBar : (b) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    public abstract void initInflate(LayoutInflater layoutInflater, o oVar);

    public abstract void initLayout(Context context);

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            super.onClick(view);
            if (getTag() instanceof AdBaseModel) {
                updateTitleColor((AdBaseModel) getTag());
            }
        }
    }

    public void setMaxTitleLine(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (textView = this.mTitle) == null) {
            return;
        }
        textView.setMaxLines(i2);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewDownloadListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            super.setViewDownloadListener(aVar);
            b bVar = this.mNadExpressOperateBar;
            if (bVar != null) {
                bVar.h(aVar);
            }
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewStatChangeListener(c.a.c0.k0.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            super.setViewStatChangeListener(bVar);
            b bVar2 = this.mNadExpressOperateBar;
            if (bVar2 != null) {
                bVar2.f(bVar);
            }
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adBaseModel) == null) {
            super.update(adBaseModel);
            updateSubViewData(adBaseModel);
            NadExpressBottomView nadExpressBottomView = this.mLabelView;
            if (nadExpressBottomView != null) {
                nadExpressBottomView.update(adBaseModel);
            }
            updateOperateBar(adBaseModel);
            updateSubViewUi(adBaseModel);
            updateTitleColor(adBaseModel);
            TextView textView = this.mTitle;
            if (textView != null) {
                textView.setText(adBaseModel.f37016d.f2236e);
            }
        }
    }

    public void updateOperateBar(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, adBaseModel) == null) {
            b c2 = this.mCreator.c(adBaseModel);
            this.mNadExpressOperateBar = c2;
            if (c2 != null) {
                c2.i(0);
                this.mNadExpressOperateBar.update(adBaseModel, this);
                this.mNadExpressOperateBar.j();
                a aVar = this.mNadDownloadListener;
                if (aVar != null) {
                    this.mNadExpressOperateBar.h(aVar);
                }
                c.a.c0.k0.x.b bVar = this.mFeedListener;
                if (bVar != null) {
                    this.mNadExpressOperateBar.f(bVar);
                }
            }
        }
    }

    public abstract void updateSubViewData(AdBaseModel adBaseModel);

    public abstract void updateSubViewUi(AdBaseModel adBaseModel);

    public void updateTitleColor(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, adBaseModel) == null) || adBaseModel == null || this.mTitle == null) {
            return;
        }
        int i2 = adBaseModel.f37014b ? c.a.c0.d.b.NAD_FC4 : c.a.c0.d.b.NAD_FC1;
        TextView textView = this.mTitle;
        textView.setTextColor(textView.getContext().getResources().getColor(i2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressNaBaseView(Context context, AttributeSet attributeSet) {
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
    public NadExpressNaBaseView(Context context, AttributeSet attributeSet, int i2) {
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
    public NadExpressNaBaseView(Context context, AttributeSet attributeSet, int i2, @Nullable o oVar) {
        super(context, attributeSet, i2);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        initInflate(LayoutInflater.from(context), oVar);
        doInitLayout(context);
        this.mCreator = new c(this);
    }
}
