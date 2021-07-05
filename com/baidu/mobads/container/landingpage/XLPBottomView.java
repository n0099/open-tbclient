package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class XLPBottomView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GAP_FIRST = 2;
    public static final int GAP_SECOND = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppCtx;
    public OnBottomButtonClickListener mListener;

    /* loaded from: classes3.dex */
    public class CustomButton extends TextView {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BUTTON_HEIGHT = 50;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XLPBottomView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomButton(XLPBottomView xLPBottomView, Context context, String str) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xLPBottomView, context, str};
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
            this.this$0 = xLPBottomView;
            initTextView(str);
        }

        private void initTextView(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
                setText(str);
                setTextColor(-16777216);
                setGravity(17);
                setBackgroundColor(-1);
                setTextSize(19.0f);
                setLayoutParams(new LinearLayout.LayoutParams(-1, ScreenUtils.getPixel(this.this$0.mAppCtx, 50)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface OnBottomButtonClickListener {
        void onCancel();

        void onCopyUrl();

        void onRefresh();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XLPBottomView(Context context) {
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
        this.mAppCtx = context.getApplicationContext();
        setBackgroundColor(-2236963);
        setOrientation(1);
        CustomButton customButton = new CustomButton(this, this.mAppCtx, "刷新");
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) customButton.getLayoutParams();
        layoutParams.bottomMargin = ScreenUtils.getPixel(this.mAppCtx, 2);
        addView(customButton, layoutParams);
        CustomButton customButton2 = new CustomButton(this, this.mAppCtx, "复制网址");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) customButton2.getLayoutParams();
        layoutParams2.bottomMargin = ScreenUtils.getPixel(this.mAppCtx, 4);
        addView(customButton2, layoutParams2);
        CustomButton customButton3 = new CustomButton(this, this.mAppCtx, "取消");
        addView(customButton3);
        customButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.landingpage.XLPBottomView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XLPBottomView this$0;

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
                OnBottomButtonClickListener onBottomButtonClickListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (onBottomButtonClickListener = this.this$0.mListener) == null) {
                    return;
                }
                onBottomButtonClickListener.onRefresh();
            }
        });
        customButton2.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.landingpage.XLPBottomView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XLPBottomView this$0;

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
                OnBottomButtonClickListener onBottomButtonClickListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (onBottomButtonClickListener = this.this$0.mListener) == null) {
                    return;
                }
                onBottomButtonClickListener.onCopyUrl();
            }
        });
        customButton3.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.landingpage.XLPBottomView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XLPBottomView this$0;

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
                OnBottomButtonClickListener onBottomButtonClickListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (onBottomButtonClickListener = this.this$0.mListener) == null) {
                    return;
                }
                onBottomButtonClickListener.onCancel();
            }
        });
    }

    public void setOnBottomButtonClickListener(OnBottomButtonClickListener onBottomButtonClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onBottomButtonClickListener) == null) {
            this.mListener = onBottomButtonClickListener;
        }
    }
}
