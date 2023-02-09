package com.baidu.live.business;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LiveFeedReserveHeaderInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.tieba.R;
import com.baidu.tieba.bd0;
import com.baidu.tieba.fd0;
import com.baidu.tieba.oa0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LiveReserveHeaderView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View h;
    public TextView i;
    public ImageView j;

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, liveRoomEntity, i) == null) {
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setIsCurViewing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveReserveHeaderView(Context context) {
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
        e();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bd0.h(this.i, 1, 13.0f);
            bd0.f(this.j, oa0.c(getContext().getResources(), 12.0f), oa0.c(getContext().getResources(), 12.0f));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d055d, this);
            this.h = inflate.findViewById(R.id.layout_bg);
            this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092569);
            this.j = (ImageView) inflate.findViewById(R.id.iv_arrow);
            d();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 7.0f, getResources().getDisplayMetrics()));
            this.h.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            View view2 = this.h;
            if (view2 != null) {
                Drawable background = view2.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setColor(fd0.f().a(getContext(), this.c, "color_F5F5F53"));
                    this.h.setBackgroundDrawable(background);
                }
            }
            TextView textView = this.i;
            if (textView != null) {
                textView.setTextColor(fd0.f().a(getContext(), this.c, "color_white4"));
            }
            ImageView imageView = this.j;
            if (imageView != null) {
                imageView.setImageResource(fd0.f().p(this.c));
            }
        }
    }

    public String getTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView = this.i;
            if (textView != null && textView.getText() != null) {
                return this.i.getText().toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void setData(LiveFeedReserveHeaderInfo liveFeedReserveHeaderInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, liveFeedReserveHeaderInfo) != null) || liveFeedReserveHeaderInfo == null) {
            return;
        }
        d();
        if (this.i != null && !TextUtils.isEmpty(liveFeedReserveHeaderInfo.tip)) {
            this.i.setText(liveFeedReserveHeaderInfo.tip);
        }
    }
}
