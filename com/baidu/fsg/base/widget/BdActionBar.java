package com.baidu.fsg.base.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BdActionBar extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float FOCUS_ALPHA_VALUE = 0.5f;
    public static final float NORMAL_ALPHA_VALUE = 1.0f;
    public static final int TEXT_ALIGN_CENTER = 1;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_RIGHT = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f5487a;

    /* renamed from: b  reason: collision with root package name */
    public View f5488b;

    /* renamed from: c  reason: collision with root package name */
    public View f5489c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f5490d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f5491e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f5492f;

    /* renamed from: g  reason: collision with root package name */
    public View f5493g;

    /* renamed from: h  reason: collision with root package name */
    public View f5494h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f5495i;
    public View j;
    public ImageView k;
    public TextView l;
    public View m;
    public TextView mTitleCenterText;
    public TextView n;
    public ImageView o;
    public ImageView p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdActionBar(Context context) {
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
        this.f5487a = "";
        a();
    }

    public String getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "rim_base_action_bar" : (String) invokeV.objValue;
    }

    public View getRightImgZone1ImgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5495i : (View) invokeV.objValue;
    }

    public View getRightImgZone2ImgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public View getRightImgZone2NotifyView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public int getRightImgZone2NotifyVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l.getVisibility() : invokeV.intValue;
    }

    public View getRightZone1View() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5494h : (View) invokeV.objValue;
    }

    public View getRightZoneView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f5487a : (String) invokeV.objValue;
    }

    public void hideLeftZone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f5489c.setVisibility(8);
        }
    }

    public boolean isLeftZoneImageSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f5489c.isSelected() : invokeV.booleanValue;
    }

    public void setBottomSeperatorvisible(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (imageView = this.p) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void setCloseOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.f5493g.setVisibility(0);
            this.f5493g.setOnClickListener(onClickListener);
            this.mTitleCenterText.setMaxEms(ResUtils.getInteger(getContext(), "wallet_base_titlebar_centertext_maxems_1"));
        }
    }

    public void setImgZoneBackgroundResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f5494h.setBackgroundResource(i2);
            this.j.setBackgroundResource(i2);
        }
    }

    public void setLeftImgZone2NotifyText(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048589, this, str, f2) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.f5491e.setVisibility(0);
            }
            if (f2 < 0.0f) {
                return;
            }
            this.f5491e.setText(str);
            this.f5491e.setTextSize(f2);
        }
    }

    public void setLeftImgZone2NotifyTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f5491e.setTextColor(i2);
        }
    }

    public void setLeftImgZone2NotifyTextColorStateList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, colorStateList) == null) {
            this.f5491e.setTextColor(colorStateList);
        }
    }

    public void setLeftZoneImageSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    public void setLeftZoneImageSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            }
            this.f5490d.setImageDrawable(drawable);
        }
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            this.f5489c.setVisibility(0);
            this.f5489c.setOnClickListener(onClickListener);
        }
    }

    public void setRightImgZone1Enable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f5495i.setEnabled(z);
            this.f5494h.setEnabled(z);
        }
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            this.f5494h.setOnClickListener(onClickListener);
        }
    }

    public void setRightImgZone1Src(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f5494h.setVisibility(0);
            this.f5495i.setVisibility(0);
            this.f5495i.setImageResource(i2);
        }
    }

    public void setRightImgZone1Visibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.f5494h.setVisibility(i2);
        }
    }

    public void setRightImgZone2Enable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.k.setEnabled(z);
            this.j.setEnabled(z);
        }
    }

    public void setRightImgZone2NotifyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onClickListener) == null) {
            if (onClickListener != null) {
                this.l.setVisibility(0);
            }
            this.l.setOnClickListener(onClickListener);
        }
    }

    public void setRightImgZone2NotifyText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                setRightImgZone2NotifyVisibility(0);
            }
            this.l.setText(str);
        }
    }

    public void setRightImgZone2NotifyTextBg(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.l.setBackgroundResource(i2);
            this.l.setPadding(12, 6, 12, 6);
        }
    }

    public void setRightImgZone2NotifyTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.l.setTextColor(i2);
        }
    }

    public void setRightImgZone2NotifyTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
            this.l.setTextSize(f2);
        }
    }

    public void setRightImgZone2NotifyTextViewPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048607, this, i2, i3, i4, i5) == null) {
            this.l.setPadding(i2, i3, i4, i5);
        }
    }

    public void setRightImgZone2NotifyVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.l.setVisibility(i2);
        }
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) {
            if (onClickListener != null) {
                this.j.setVisibility(0);
            }
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void setRightImgZone2Src(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.k.setVisibility(0);
            this.k.setImageResource(i2);
        }
    }

    public void setRightImgZone2Visibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.j.setVisibility(i2);
        }
    }

    public void setSafeIconVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            if (z) {
                this.o.setVisibility(0);
            } else {
                this.o.setVisibility(8);
            }
        }
    }

    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            setTitle(getResources().getString(i2));
        }
    }

    public void setTitleCenterSafeTipColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.n.setTextColor(i2);
        }
    }

    public void setTitleCenterSafeTipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.m.setVisibility(8);
                return;
            }
            this.m.setVisibility(0);
            this.n.setText(str);
        }
    }

    public void setTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.mTitleCenterText.setTextColor(i2);
        }
    }

    public void setTitleShadowLayer(float f2, float f3, float f4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2)}) == null) {
            this.mTitleCenterText.setShadowLayer(f2, f3, f4, i2);
        }
    }

    public void setTitlebgColor(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048620, this, i2) == null) || (view = this.f5488b) == null) {
            return;
        }
        view.setBackgroundColor(i2);
    }

    public void setbackBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, drawable) == null) {
            this.f5489c.setBackgroundDrawable(drawable);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), getLayoutId()), this);
            this.f5488b = findViewById(ResUtils.id(getContext(), "title"));
            this.f5489c = findViewById(ResUtils.id(getContext(), "title_left_imgzone2"));
            this.f5490d = (ImageView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_img"));
            this.f5492f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_titlebar_left_imgzone2_close"));
            this.f5491e = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
            this.f5489c.setOnTouchListener(new a(this));
            View findViewById = findViewById(ResUtils.id(getContext(), "title_close"));
            this.f5493g = findViewById;
            findViewById.setOnTouchListener(new b(this));
            this.mTitleCenterText = (TextView) findViewById(ResUtils.id(getContext(), "title_center_text"));
            this.m = findViewById(ResUtils.id(getContext(), "title_center_safe_layout"));
            this.n = (TextView) findViewById(ResUtils.id(getContext(), "title_center_safe_tip"));
            this.o = (ImageView) findViewById(ResUtils.id(getContext(), "safe_icon"));
            this.f5494h = findViewById(ResUtils.id(getContext(), "title_right_imgzone1"));
            this.f5495i = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img1"));
            this.j = findViewById(ResUtils.id(getContext(), "title_right_imgzone2"));
            this.k = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img"));
            this.l = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify"));
            if (!TextUtils.isEmpty(this.f5487a)) {
                setTitle(this.f5487a);
            }
            this.p = (ImageView) findViewById(ResUtils.id(getContext(), "title_bottom_seperator"));
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.f5487a = str;
            this.mTitleCenterText.setText(str);
        }
    }

    public void setRightImgZone2Src(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.k.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdActionBar(Context context, AttributeSet attributeSet) {
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
        this.f5487a = "";
        a();
    }

    public void setLeftZoneImageSrc(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, drawable) == null) {
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            }
            this.f5490d.setImageDrawable(drawable);
        }
    }

    public void setRightImgZone1Src(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.f5494h.setVisibility(0);
            this.f5495i.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdActionBar(Context context, AttributeSet attributeSet, int i2) {
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
        this.f5487a = "";
        a();
    }
}
