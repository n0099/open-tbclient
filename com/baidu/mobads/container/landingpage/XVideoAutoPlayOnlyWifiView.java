package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class XVideoAutoPlayOnlyWifiView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUTTON_HEIGHT = 30;
    public static final int BUTTON_WIDTH = 90;
    public static final int RADIUS_BUTTON = 7;
    public static final int TEXT_VIEW_ID = 289342983;
    public transient /* synthetic */ FieldHolder $fh;
    public OnListener listener;

    /* loaded from: classes5.dex */
    public interface OnListener {
        void onClick();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XVideoAutoPlayOnlyWifiView(Context context) {
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
        setBackgroundColor(-16777216);
        TextView textView = new TextView(context);
        textView.setText("正在使用非Wi-Fi网络，播放将产生流量费用");
        textView.setId(TEXT_VIEW_ID);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(textView, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ScreenUtils.getPixel(context, 90), ScreenUtils.getPixel(context, 30));
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        layoutParams2.topMargin = ScreenUtils.getPixel(context, 10);
        Button button = new Button(context);
        button.setText("继续播放");
        button.setBackgroundColor(0);
        button.setTextColor(-1);
        button.setPadding(0, 0, 0, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(2, -1);
        gradientDrawable.setCornerRadius(ScreenUtils.getPixel(context, 7));
        button.setBackground(gradientDrawable);
        button.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.landingpage.XVideoAutoPlayOnlyWifiView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XVideoAutoPlayOnlyWifiView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnListener onListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (onListener = this.this$0.listener) == null) {
                    return;
                }
                onListener.onClick();
            }
        });
        addView(button, layoutParams2);
    }

    public void setListener(OnListener onListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onListener) == null) {
            this.listener = onListener;
        }
    }
}
