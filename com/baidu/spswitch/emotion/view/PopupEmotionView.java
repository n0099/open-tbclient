package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.spswitch.R;
import com.baidu.spswitch.utils.UIUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PopupEmotionView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HEIGHT_DP = 85;
    public static final int WIDTH_DP = 75;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mCtx;
    public ImageView mIcon;
    public TextView mText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupEmotionView(Context context) {
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
        init(context);
    }

    private String filter(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.indexOf(PreferencesUtil.LEFT_MOUNT) == 0) {
                str = str.substring(1);
            }
            return str.indexOf(PreferencesUtil.RIGHT_MOUNT) == str.length() - 1 ? str.substring(0, str.length() - 1) : str;
        }
        return (String) invokeL.objValue;
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            this.mCtx = context;
            setLayoutParams(new ViewGroup.LayoutParams((int) UIUtils.dp2px(this.mCtx, 75.0f), (int) UIUtils.dp2px(this.mCtx, 85.0f)));
            setBackground(this.mCtx.getResources().getDrawable(R.drawable.emotion_vertical_long_pressed_bg));
            setPadding(0, 0, 0, 0);
            LayoutInflater.from(this.mCtx).inflate(R.layout.emotion_vertical_long_pressed_layout, (ViewGroup) this, true);
            this.mIcon = (ImageView) findViewById(R.id.icon);
            this.mText = (TextView) findViewById(R.id.text);
        }
    }

    public void configView(String str, Bitmap bitmap) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) || this.mIcon == null || (textView = this.mText) == null) {
            return;
        }
        textView.setText(filter(str));
        this.mText.setTextColor(this.mCtx.getResources().getColor(R.color.GC4));
        this.mIcon.setImageBitmap(bitmap);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupEmotionView(Context context, @Nullable AttributeSet attributeSet) {
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
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupEmotionView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        init(context);
    }
}
