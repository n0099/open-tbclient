package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.l.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class LocationExtendLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f33165e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33166f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33167g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33168h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f33169i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocationExtendLayout(Context context) {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            WebPManager.setPureDrawable(this.f33165e, R.drawable.icon_pure_location, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f33166f, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f33169i, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f33167g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f33168h, R.color.CAM_X0109);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(0);
            LayoutInflater.from(context).inflate(R.layout.layout_location_extend, (ViewGroup) this, true);
            this.f33165e = (ImageView) findViewById(R.id.channel_location_icon);
            this.f33166f = (TextView) findViewById(R.id.channel_location);
            this.f33169i = (TextView) findViewById(R.id.channel_location_distance);
            this.f33167g = (TextView) findViewById(R.id.channel_location_split_one);
            this.f33168h = (TextView) findViewById(R.id.channel_location_split_two);
        }
    }

    public final void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            setVisibility(0);
            if (!TextUtils.isEmpty(str)) {
                this.f33166f.setText(str);
                this.f33166f.setVisibility(0);
                this.f33165e.setVisibility(0);
                if (!TextUtils.isEmpty(str2)) {
                    this.f33168h.setVisibility(0);
                } else {
                    this.f33168h.setVisibility(8);
                }
            } else {
                this.f33166f.setVisibility(8);
                this.f33165e.setVisibility(8);
                this.f33168h.setVisibility(8);
            }
            this.f33169i.setText(str2);
            a();
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            a();
        }
    }

    public void setLocationAndDistance(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                setVisibility(8);
            } else {
                c(UtilHelper.getAddressInfo(str), str2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocationExtendLayout(Context context, @Nullable AttributeSet attributeSet) {
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
    public LocationExtendLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        b(context);
    }
}
