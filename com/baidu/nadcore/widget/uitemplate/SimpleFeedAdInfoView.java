package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRatingBar;
import c.a.d0.d.b;
import c.a.d0.d.d;
import c.a.d0.d.e;
import c.a.d0.s.s;
import c.a.d0.s.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SimpleFeedAdInfoView extends SimpleAdInfoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mAdNameView;
    public AppCompatRatingBar mRatingBarView;
    public TextView mRatingTextView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleFeedAdInfoView(@NonNull Context context) {
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

    @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView
    public void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            super.init(attributeSet);
            this.mAdNameView = (TextView) findViewById(e.nad_operate_ad_name);
            this.mRatingBarView = (AppCompatRatingBar) findViewById(e.nad_operate_ad_rating_bar);
            this.mRatingTextView = (TextView) findViewById(e.nad_operate_ad_rating_text);
            initSkin();
            setRatingBarViewLP(d.nad_feed_ad_operate_rating_star_full);
        }
    }

    public void initSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TextView textView = this.mAdNameView;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(b.NAD_FC1));
            }
            AppCompatRatingBar appCompatRatingBar = this.mRatingBarView;
            if (appCompatRatingBar != null) {
                appCompatRatingBar.getProgressDrawable().setColorFilter(getResources().getColor(b.NAD_FC74), PorterDuff.Mode.SRC_ATOP);
            }
            TextView textView2 = this.mRatingTextView;
            if (textView2 != null) {
                textView2.setTextColor(getResources().getColor(b.NAD_FC2));
            }
            TextView textView3 = this.mVersionView;
            if (textView3 != null) {
                textView3.setTextColor(getResources().getColor(b.NAD_FC2));
            }
            TextView textView4 = this.mAuthorNameView;
            if (textView4 != null) {
                textView4.setTextColor(getResources().getColor(b.NAD_FC2));
            }
            TextView textView5 = this.mPrivacyTagView;
            if (textView5 != null) {
                textView5.setTextColor(getResources().getColor(b.NAD_FC2));
            }
            TextView textView6 = this.mPermissionTagView;
            if (textView6 != null) {
                textView6.setTextColor(getResources().getColor(b.NAD_FC2));
            }
        }
    }

    @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView
    public void setAdInfo(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tVar) == null) {
            super.setAdInfo(tVar);
            if (this.mAdNameView != null) {
                if (!TextUtils.isEmpty(tVar.f3138c)) {
                    this.mAdNameView.setText(tVar.f3138c);
                    this.mAdNameView.setVisibility(0);
                } else {
                    this.mAdNameView.setVisibility(8);
                }
            }
            TextView textView = this.mRatingTextView;
            if (textView != null) {
                double d2 = tVar.f3140e;
                if (d2 != -1.0d) {
                    textView.setText(String.valueOf(d2));
                    this.mRatingTextView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
            }
            AppCompatRatingBar appCompatRatingBar = this.mRatingBarView;
            if (appCompatRatingBar != null) {
                double d3 = tVar.f3140e;
                if (d3 != -1.0d) {
                    appCompatRatingBar.setRating((float) d3);
                    this.mRatingBarView.setVisibility(0);
                    return;
                }
                appCompatRatingBar.setVisibility(8);
            }
        }
    }

    public void setRatingBarViewLP(int i2) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.mRatingBarView == null || (drawable = getResources().getDrawable(i2)) == null) {
            return;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        ViewGroup.LayoutParams layoutParams = this.mRatingBarView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = intrinsicHeight;
        this.mRatingBarView.setLayoutParams(layoutParams);
    }

    public void update(AdBaseModel adBaseModel) {
        t tVar;
        s.a aVar;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, adBaseModel) == null) || adBaseModel == null || (tVar = adBaseModel.f37261i) == null) {
            return;
        }
        setAdInfo(tVar);
        initSkin();
        s sVar = adBaseModel.q;
        if (sVar == null || (aVar = sVar.f3126j) == null || (i2 = aVar.f3133h) == 0) {
            return;
        }
        setRatingBarViewLP(i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleFeedAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public SimpleFeedAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
}
