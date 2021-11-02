package com.baidu.android.lbspay.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes6.dex */
public class ChannelFootView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View layoutView;
    public TextView logoDesc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFootView(Context context) {
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
        initView();
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            int layout = ResUtils.layout(getContext(), "wallet_juhe_channel_foot");
            if (this.layoutView == null) {
                this.layoutView = LayoutInflater.from(getContext()).inflate(layout, (ViewGroup) this, true);
            }
            TextView textView = (TextView) this.layoutView.findViewById(ResUtils.id(getContext(), "lbspay_powerby_tx"));
            this.logoDesc = textView;
            textView.setText(ResUtils.getString(getContext(), "lbspay_pay_brand_desc"));
        }
    }

    public void initBrandData(NewCashierContent.Brand brand) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, brand) == null) || brand == null || TextUtils.isEmpty(brand.desc)) {
            return;
        }
        this.logoDesc.setVisibility(0);
        this.logoDesc.setText(brand.desc);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        initView();
    }
}
