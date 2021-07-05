package com.baidu.mobads.container.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class RoundRectButton extends Button {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mLeftBottomCorner;
    public int mLeftTopCorner;
    public int mRightBottomCorner;
    public int mRightTopCorner;
    public Context mViewContext;

    /* loaded from: classes3.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mBtnBackgroundAlpha;
        public int mBtnBackgroundColor;
        public View.OnClickListener mBtnListener;
        public int mBtnTextColor;
        public String mBtnTextMsg;
        public int mBtnTextSizeSp;
        public int mLeftBottomCorner;
        public int mLeftTopCorner;
        public int mRightBottomCorner;
        public int mRightTopCorner;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mBtnBackgroundColor = Color.parseColor("#3789FD");
            this.mBtnBackgroundAlpha = 255;
            this.mBtnTextMsg = "";
            this.mBtnTextSizeSp = 14;
            this.mBtnTextColor = Color.parseColor("#ffffffff");
        }

        public RoundRectButton create(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? new RoundRectButton(context, this) : (RoundRectButton) invokeL.objValue;
        }

        public Builder setBtnBackgroundAlpha(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.mBtnBackgroundAlpha = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setBtnBackgroundColor(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.mBtnBackgroundColor = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setBtnClickListener(View.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, onClickListener)) == null) {
                this.mBtnListener = onClickListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBtnTextColor(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.mBtnTextColor = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setBtnTextMsg(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.mBtnTextMsg = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBtnTextSizeSp(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.mBtnTextSizeSp = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setLeftBottomCorner(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.mLeftBottomCorner = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setLeftTopCorner(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.mLeftTopCorner = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setRightBottomCorner(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.mRightBottomCorner = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setRightTopCorner(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.mRightTopCorner = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundRectButton(Context context, Builder builder) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, builder};
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
        this.mViewContext = context;
        if (builder == null) {
            return;
        }
        this.mLeftTopCorner = builder.mLeftTopCorner;
        this.mRightBottomCorner = builder.mRightBottomCorner;
        this.mLeftBottomCorner = builder.mLeftBottomCorner;
        this.mRightTopCorner = builder.mRightTopCorner;
        setOnClickListener(builder.mBtnListener);
        setText(builder.mBtnTextMsg);
        setGravity(17);
        setTextColor(builder.mBtnTextColor);
        setTextSize(2, builder.mBtnTextSizeSp);
        int textSize = (int) getTextSize();
        setPadding(textSize, 0, textSize, 0);
        setBackgroundDrawable(getDrawable(builder.mBtnBackgroundColor, builder.mBtnBackgroundAlpha));
        if (Build.VERSION.SDK_INT >= 21) {
            setStateListAnimator(null);
        }
    }

    private GradientDrawable getDrawable(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i2, i3)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            try {
                gradientDrawable.setAlpha(i3);
                gradientDrawable.setColor(i2);
                gradientDrawable.setCornerRadii(new float[]{this.mLeftTopCorner, this.mLeftTopCorner, this.mRightTopCorner, this.mRightTopCorner, this.mRightBottomCorner, this.mRightBottomCorner, this.mLeftBottomCorner, this.mLeftBottomCorner});
            } catch (Exception unused) {
            }
            return gradientDrawable;
        }
        return (GradientDrawable) invokeII.objValue;
    }
}
