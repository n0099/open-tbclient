package com.baidu.mobads.container.widget;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.landingpage.AppPriActivity;
import com.baidu.mobads.container.landingpage.LpCloseController;
import com.baidu.mobads.container.util.ActivityUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DisplayInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTH_TEXT = "权限";
    public static final String LP_ACTIVITY_CLOSE_ACTION = "lp_close";
    public static final String PRI_TEXT = "隐私";
    public transient /* synthetic */ FieldHolder $fh;
    public String authUrl;
    public final Context context;
    public String devText;
    public boolean hideNavigation;
    public OnDisplayListener listener;
    public IOAdEventListener lpCloseListener;
    public String priUrl;
    public double sideMarginPercent;
    public int textColor;
    public double textPercent;
    public String verText;

    /* loaded from: classes3.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public DisplayInfoView view;

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.view = new DisplayInfoView(context);
        }

        public Builder addContent(String str, String str2, String str3, String str4) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, str4)) == null) {
                String str5 = "版本 " + str;
                if (str.indexOf("版本") == -1) {
                    str = str5;
                }
                this.view.verText = str;
                this.view.devText = str2;
                this.view.priUrl = str3;
                this.view.authUrl = str4;
                return this;
            }
            return (Builder) invokeLLLL.objValue;
        }

        public Builder addHideNavigation(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.view.hideNavigation = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder addListener(OnDisplayListener onDisplayListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onDisplayListener)) == null) {
                this.view.listener = onDisplayListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addSideMarginPercent(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2)})) == null) {
                this.view.sideMarginPercent = d2;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder addTextColor(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.view.textColor = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder addTextPercent(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Double.valueOf(d2)})) == null) {
                this.view.textPercent = d2;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public DisplayInfoView build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.view : (DisplayInfoView) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class LpCloseListener implements IOAdEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DisplayInfoView this$0;

        public LpCloseListener(DisplayInfoView displayInfoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {displayInfoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = displayInfoView;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, iOAdEvent) == null) && "AdLpClosed".equals(iOAdEvent.getType())) {
                if (this.this$0.listener != null) {
                    this.this$0.listener.onDismiss(false);
                }
                if (this.this$0.lpCloseListener != null) {
                    this.this$0.lpCloseListener = null;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface OnDisplayListener {
        void onDismiss(boolean z);

        void onShow(boolean z);
    }

    private TextView addItem(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, str)) == null) {
            TextView textView = new TextView(this.context);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            textView.setText(str);
            textView.setTextColor(this.textColor);
            textView.setTextSize(1, (int) ((this.textPercent * displayMetrics.widthPixels) / displayMetrics.density));
            addView(textView, getTextLayoutParams(this.sideMarginPercent));
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    private LinearLayout.LayoutParams getTextLayoutParams(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, this, new Object[]{Double.valueOf(d2)})) == null) {
            int i2 = (int) (d2 * getResources().getDisplayMetrics().widthPixels);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i2, 0, i2, 0);
            layoutParams.gravity = 17;
            return layoutParams;
        }
        return (LinearLayout.LayoutParams) invokeCommon.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            addItem(this.verText);
            addItem(this.devText);
            addItem(PRI_TEXT).setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.widget.DisplayInfoView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DisplayInfoView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        Intent intent = new Intent();
                        intent.putExtra(AppPriActivity.PRIVACY_LINK, this.this$0.priUrl);
                        if (this.this$0.listener != null) {
                            this.this$0.listener.onShow(false);
                        }
                        ActivityUtils.startAppPriActivity(this.this$0.context, intent);
                        DisplayInfoView displayInfoView = this.this$0;
                        displayInfoView.registerLpCloseReceiver(displayInfoView.context);
                    }
                }
            });
            addItem(AUTH_TEXT).setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.widget.DisplayInfoView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DisplayInfoView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        VerifyPerDialog createVerPerDialog = VerifyPerDialog.createVerPerDialog(this.this$0.context, this.this$0.authUrl);
                        createVerPerDialog.setHideNavigation(this.this$0.hideNavigation);
                        createVerPerDialog.setOnDialogListener(new OnDialogListener(this) { // from class: com.baidu.mobads.container.widget.DisplayInfoView.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.baidu.mobads.container.widget.OnDialogListener
                            public void onDismiss() {
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.this$0.listener == null) {
                                    return;
                                }
                                this.this$1.this$0.listener.onDismiss(true);
                            }

                            @Override // com.baidu.mobads.container.widget.OnDialogListener
                            public void onShow() {
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.this$1.this$0.listener == null) {
                                    return;
                                }
                                this.this$1.this$0.listener.onShow(true);
                            }
                        });
                        createVerPerDialog.show();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerLpCloseReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, this, context) == null) || this.listener == null) {
            return;
        }
        this.lpCloseListener = new LpCloseListener();
        LpCloseController.getInstance(context).startListener();
        LpCloseController.getInstance(context).addEventListener("AdLpClosed", this.lpCloseListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onAttachedToWindow();
            init();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDetachedFromWindow();
            Context context = this.context;
            if (context == null || this.lpCloseListener == null) {
                return;
            }
            LpCloseController.getInstance(context).stopListener();
            this.lpCloseListener = null;
            this.listener = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayInfoView(Context context) {
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
        this.textPercent = 0.027777777777777776d;
        this.sideMarginPercent = 0.0196078431372549d;
        this.textColor = -1728053248;
        this.hideNavigation = false;
        setOrientation(0);
        this.context = context;
        removeAllViews();
    }
}
