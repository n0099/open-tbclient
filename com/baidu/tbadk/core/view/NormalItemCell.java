package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.fj;
import com.baidu.tieba.nv4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NormalItemCell extends ConstraintLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int h;
    public static final int i;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public a f;
    public String g;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
        public CharSequence e;
        public CharSequence f;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.b = 0;
            this.c = -1;
            this.d = fj.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1455544418, "Lcom/baidu/tbadk/core/view/NormalItemCell;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1455544418, "Lcom/baidu/tbadk/core/view/NormalItemCell;");
                return;
            }
        }
        h = fj.f(TbadkCoreApplication.getInst(), R.dimen.T_X08);
        i = fj.f(TbadkCoreApplication.getInst(), R.dimen.T_X09);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NormalItemCell(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.g = str;
            this.d.setText(str);
            CharSequence charSequence = "";
            if (!TextUtils.isEmpty(str)) {
                this.d.setHint("");
            } else {
                TextView textView = this.d;
                a aVar = this.f;
                if (aVar != null) {
                    charSequence = aVar.f;
                }
                textView.setHint(charSequence);
            }
            d();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NormalItemCell(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalItemCell(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        b(context);
    }

    private void setupDivider(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            if ((i2 & 1) == 1) {
                this.a.setVisibility(0);
            } else {
                this.a.setVisibility(8);
            }
            if ((i2 & 2) == 2) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.setVisibility(8);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e.setVisibility(0);
        }
    }

    public String getSubTitleContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0667, this);
            this.a = findViewById(R.id.obfuscated_res_0x7f090825);
            this.b = findViewById(R.id.obfuscated_res_0x7f09080c);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091481);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091fa1);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f0902ba);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.forum_selected_view_bg);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.e, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0210);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0210);
            a aVar = this.f;
            if (aVar != null && aVar.a != -1) {
                this.d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0107);
            } else {
                this.d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            }
            a aVar2 = this.f;
            if (aVar2 != null && aVar2.a != -1) {
                nv4 d = nv4.d(this.d);
                d.n(R.string.J_X06);
                d.f(this.f.a);
            }
            d();
        }
    }

    public final void d() {
        int i2;
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (TextUtils.isEmpty(this.g)) {
                this.d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            a aVar = this.f;
            if (aVar != null && (i2 = aVar.c) != -1 && (pureDrawable = WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0107), null)) != null) {
                int f = fj.f(getContext(), R.dimen.tbds32);
                pureDrawable.setBounds(0, 0, f, f);
                this.d.setCompoundDrawables(pureDrawable, null, null, null);
            }
        }
    }

    public void setConfig(a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f = aVar;
            if (aVar != null) {
                int i4 = aVar.d;
                setPadding(i4, 0, i4, 0);
                if (aVar.a != -1) {
                    i2 = fj.f(getContext(), R.dimen.M_W_X004);
                } else {
                    i2 = 0;
                }
                if (aVar.a != -1) {
                    i3 = fj.f(getContext(), R.dimen.tbds8);
                } else {
                    i3 = 0;
                }
                this.d.setPadding(i2, i3, i2, i3);
                if (aVar.a != -1) {
                    this.d.setTextSize(0, i);
                } else {
                    this.d.setTextSize(0, h);
                }
                this.c.setText(aVar.e);
                this.d.setHint(aVar.f);
                setupDivider(aVar.b);
            }
        }
    }
}
