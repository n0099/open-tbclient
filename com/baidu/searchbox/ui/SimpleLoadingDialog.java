package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SimpleLoadingDialog extends BaseLoadingDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView mCloseImgView;
    public boolean mHasCloseBtn;
    public TextView mMsgTxtView;
    public SmoothProgressBar mProgressBar;
    public View mRootView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleLoadingDialog(@NonNull Context context, @NonNull CharSequence charSequence) {
        super(context, charSequence);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, charSequence};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (CharSequence) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHasCloseBtn = false;
    }

    @Override // com.baidu.searchbox.ui.BaseLoadingDialog
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setContentView(R.layout.d20_loading_dialog);
            this.mRootView = findViewById(R.id.root_container);
            this.mProgressBar = (SmoothProgressBar) findViewById(R.id.loading_bar);
            this.mMsgTxtView = (TextView) findViewById(R.id.message);
            this.mCloseImgView = (ImageView) findViewById(R.id.close);
            this.mMsgTxtView.setText(this.mMsgText);
            this.mCloseImgView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.ui.SimpleLoadingDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SimpleLoadingDialog this$0;

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
                        SimpleLoadingDialog simpleLoadingDialog = this.this$0;
                        simpleLoadingDialog.mDismissType = 4;
                        simpleLoadingDialog.dismiss();
                    }
                }
            });
            this.mCloseImgView.setVisibility(this.mHasCloseBtn ? 0 : 8);
            setPageResources();
        }
    }

    public SimpleLoadingDialog setCloseButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.mHasCloseBtn = true;
            return this;
        }
        return (SimpleLoadingDialog) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.BaseLoadingDialog
    public void setPageResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Resources resources = AppRuntime.getAppContext().getResources();
            View view = this.mRootView;
            if (view != null) {
                view.setBackground(resources.getDrawable(R.drawable.d20_loading_bg));
            }
            SmoothProgressBar smoothProgressBar = this.mProgressBar;
            if (smoothProgressBar != null) {
                smoothProgressBar.setIndeterminateDrawable(resources.getDrawable(R.drawable.d20_loading_animation));
            }
            TextView textView = this.mMsgTxtView;
            if (textView != null) {
                textView.setTextColor(resources.getColor(R.color.GC6));
            }
            ImageView imageView = this.mCloseImgView;
            if (imageView != null) {
                imageView.setBackground(resources.getDrawable(R.drawable.d20_selector_close));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleLoadingDialog(@NonNull Context context, @StringRes int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHasCloseBtn = false;
    }
}
