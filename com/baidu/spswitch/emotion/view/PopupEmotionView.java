package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.spswitch.utils.UIUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes4.dex */
public class PopupEmotionView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IMG_BIG_SIZE_DP = 94;
    public static final int TRIANGLE_OFFSET_DP = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout mContentView;
    public Context mCtx;
    public SimpleDraweeView mIcon;
    public TextView mText;
    public ImageView mTriangleView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupEmotionView(Context context) {
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
            if (str.indexOf(PreferencesUtil.RIGHT_MOUNT) == str.length() - 1) {
                return str.substring(0, str.length() - 1);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public void setTriangleViewTran(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i == 3) {
                this.mTriangleView.setTranslationX(-UIUtils.dip2px(getContext(), 20.0f));
            } else if (i == 5) {
                this.mTriangleView.setTranslationX(UIUtils.dip2px(getContext(), 20.0f));
            } else {
                this.mTriangleView.setTranslationX(UIUtils.dip2px(getContext(), 0.0f));
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public PopupEmotionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init(context);
    }

    public void configView(String str, Bitmap bitmap, String str2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, str, bitmap, str2) == null) && this.mIcon != null && (textView = this.mText) != null) {
            textView.setText(filter(str));
            this.mText.setTextColor(this.mCtx.getResources().getColor(R.color.emotion_vertical_long_pressed_title));
            if (bitmap != null) {
                setCornersRadius(0);
                this.mIcon.setImageBitmap(bitmap);
                return;
            }
            setCornersRadius(9);
            resetBigImgMargin();
            this.mIcon.setImageURI(str2);
            this.mIcon.setController(Fresco.newDraweeControllerBuilder().setUri(str2).setAutoPlayAnimations(true).build());
        }
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            this.mCtx = context;
            setPadding(0, 0, 0, 0);
            LayoutInflater.from(this.mCtx).inflate(R.layout.emotion_vertical_long_pressed_layout, (ViewGroup) this, true);
            this.mIcon = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f090ffc);
            this.mText = (TextView) findViewById(R.id.obfuscated_res_0x7f0924c8);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.preview_content);
            this.mContentView = relativeLayout;
            relativeLayout.setBackground(ContextCompat.getDrawable(this.mCtx, R.drawable.emotion_preview_shape));
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0926f7);
            this.mTriangleView = imageView;
            imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.emotion_preview_triangle));
        }
    }

    private void resetBigImgMargin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (this.mIcon.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mIcon.getLayoutParams();
                layoutParams.width = UIUtils.dip2px(getContext(), 94.0f);
                layoutParams.height = UIUtils.dip2px(getContext(), 94.0f);
                layoutParams.leftMargin = UIUtils.dip2px(getContext(), 9.0f);
                layoutParams.rightMargin = UIUtils.dip2px(getContext(), 9.0f);
                this.mIcon.setLayoutParams(layoutParams);
            }
            if (this.mText.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mText.getLayoutParams();
                layoutParams2.topMargin = UIUtils.dip2px(getContext(), 7.0f);
                layoutParams2.bottomMargin = UIUtils.dip2px(getContext(), 8.0f);
                this.mText.setLayoutParams(layoutParams2);
            }
        }
    }

    private void setCornersRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i) == null) {
            GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(getResources()).build();
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.setOverlayColor(this.mCtx.getResources().getColor(R.color.emotion_preview_corner_color));
            roundingParams.setCornersRadius(UIUtils.dip2px(getContext(), i));
            build.setPlaceholderImage(ContextCompat.getDrawable(getContext(), R.drawable.emotion_preview_placeholder));
            build.setRoundingParams(roundingParams);
            this.mIcon.setHierarchy(build);
        }
    }
}
