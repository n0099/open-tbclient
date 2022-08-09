package com.baidu.live.business.view.tool;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.view.CircleIndicator;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import com.repackage.ab0;
import com.repackage.m80;
import com.repackage.wa0;
/* loaded from: classes2.dex */
public class LiveFeedPageToolItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SimpleDraweeView a;
    public TextView b;
    public View c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFeedPageToolItemView(Context context) {
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d053a, (ViewGroup) this, true);
            this.a = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f090e05);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f092369);
            this.c = findViewById(R.id.obfuscated_res_0x7f0907e3);
            c();
        }
    }

    public void b(String str, boolean z) {
        float applyDimension;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) || this.a == null) {
            return;
        }
        int i = 0;
        if ((this.b == null) || (this.c == null)) {
            return;
        }
        if (this.a.getHierarchy() != null) {
            this.a.getHierarchy().setUseGlobalColorFilter(false);
        }
        if (z) {
            if (this.a.getTag() instanceof Boolean) {
                this.a.setColorFilter(-1694498817);
            } else if (this.a.getHierarchy() != null) {
                this.a.getHierarchy().setActualImageColorFilter(new PorterDuffColorFilter(-1694498817, PorterDuff.Mode.SRC_ATOP));
            }
            this.b.setTextColor(-1694498817);
            this.c.setBackgroundColor(-13619152);
            applyDimension = TypedValue.applyDimension(1, 0.6f, getResources().getDisplayMetrics());
        } else {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 99228) {
                if (hashCode == 104817688 && str.equals("night")) {
                    c = 1;
                }
            } else if (str.equals("day")) {
                c = 0;
            }
            if (c == 0) {
                if (this.a.getTag() instanceof Boolean) {
                    this.a.setColorFilter(-11382190);
                } else if (this.a.getHierarchy() != null) {
                    this.a.getHierarchy().setActualImageColorFilter(new PorterDuffColorFilter(-11382190, PorterDuff.Mode.SRC_ATOP));
                }
                this.b.setTextColor(-11382190);
                this.c.setBackgroundColor(-1118482);
                applyDimension = TypedValue.applyDimension(1, 0.4f, getResources().getDisplayMetrics());
            } else {
                if (c == 1) {
                    if (this.a.getTag() instanceof Boolean) {
                        this.a.setColorFilter(CircleIndicator.NIGHT_COLOR_EMOTION_CIRCLE_INDICATOR_HIGHLIGHT);
                    } else if (this.a.getHierarchy() != null) {
                        this.a.getHierarchy().setActualImageColorFilter(new PorterDuffColorFilter(CircleIndicator.NIGHT_COLOR_EMOTION_CIRCLE_INDICATOR_HIGHLIGHT, PorterDuff.Mode.SRC_ATOP));
                    }
                    this.b.setTextColor(CircleIndicator.NIGHT_COLOR_EMOTION_CIRCLE_INDICATOR_HIGHLIGHT);
                    this.c.setBackgroundColor(-13619152);
                    applyDimension = TypedValue.applyDimension(1, 0.6f, getResources().getDisplayMetrics());
                }
                layoutParams = this.c.getLayoutParams();
                if (layoutParams != null || i <= 0 || layoutParams.height == i) {
                    return;
                }
                layoutParams.height = i;
                this.c.setLayoutParams(layoutParams);
                return;
            }
        }
        i = (int) applyDimension;
        layoutParams = this.c.getLayoutParams();
        if (layoutParams != null) {
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            wa0.f(this.a, m80.c(getContext().getResources(), 19.0f), m80.c(getContext().getResources(), 19.0f));
            wa0.h(this.b, 1, 9.0f);
        }
    }

    public void d() {
        SimpleDraweeView simpleDraweeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (simpleDraweeView = this.a) == null) {
            return;
        }
        simpleDraweeView.setImageDrawable(null);
    }

    public void setData(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            SimpleDraweeView simpleDraweeView = this.a;
            if (simpleDraweeView != null && str != null) {
                simpleDraweeView.setImageURI(str);
            }
            setData(str2);
            b(ab0.f().q(), z);
        }
    }

    public void setDividerShowing(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (view2 = this.c) == null) {
            return;
        }
        view2.setVisibility(z ? 0 : 8);
    }

    public void setData(boolean z, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str}) == null) {
            SimpleDraweeView simpleDraweeView = this.a;
            if (simpleDraweeView != null) {
                simpleDraweeView.setTag(Boolean.TRUE);
                this.a.setImageResource(i);
            }
            setData(str);
            b(ab0.f().q(), z);
        }
    }

    private void setData(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, str) == null) || (textView = this.b) == null || str == null) {
            return;
        }
        textView.setText(str);
    }
}
