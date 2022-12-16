package com.baidu.tbadk.core.view.commonGroupChatCard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.rw4;
import com.baidu.tieba.ss4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbGroupChatCardLinkLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int k;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public View b;
    public TbImageView c;
    public TextView d;
    public View e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public ImageView i;
    public ImageView j;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1354547538, "Lcom/baidu/tbadk/core/view/commonGroupChatCard/TbGroupChatCardLinkLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1354547538, "Lcom/baidu/tbadk/core/view/commonGroupChatCard/TbGroupChatCardLinkLayout;");
                return;
            }
        }
        k = UtilHelper.getDimenPixelSize(R.dimen.tbds735);
        l = UtilHelper.getDimenPixelSize(R.dimen.tbds52) * 2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbGroupChatCardLinkLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbGroupChatCardLinkLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbGroupChatCardLinkLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        d();
    }

    public static void c(TextView textView, View view2, TextView textView2, String str, String str2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, textView, view2, textView2, str, str2) == null) && !TextUtils.isEmpty(str)) {
            String string = textView.getResources().getString(R.string.ellipsis_suffix_bar);
            if (!TextUtils.isEmpty(str2)) {
                i = (int) textView2.getPaint().measureText(str2);
            } else {
                i = 0;
            }
            int i2 = (k - l) - i;
            if (i2 < 0) {
                textView.setVisibility(8);
                view2.setVisibility(8);
                return;
            }
            float f = i2;
            if (textView.getPaint().measureText(str) > f) {
                int length = str.length() - 1;
                while (length > 0) {
                    if (textView.getPaint().measureText(str.substring(0, length) + string) <= f) {
                        break;
                    }
                    length--;
                }
                if (length > 0) {
                    textView.setText(str.substring(0, length) + string);
                    return;
                }
                textView.setVisibility(8);
                view2.setVisibility(8);
            }
        }
    }

    public void a(@NonNull ss4 ss4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ss4Var) == null) {
            b(ss4Var);
            e();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2.getId() == R.id.group_chat_close_button) {
                a aVar = this.a;
                if (aVar != null) {
                    aVar.a(1);
                    return;
                }
                return;
            }
            a aVar2 = this.a;
            if (aVar2 != null) {
                aVar2.a(0);
            }
        }
    }

    public void setClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public final void b(@NonNull ss4 ss4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ss4Var) == null) {
            this.c.K(ss4Var.e, 10, false);
            this.d.setText(ss4Var.c);
            CardLinkInfoData cardLinkInfoData = ss4Var.p;
            if (cardLinkInfoData != null && (!TextUtils.isEmpty(cardLinkInfoData.content1) || !TextUtils.isEmpty(ss4Var.p.content2))) {
                this.e.setVisibility(0);
                if (TextUtils.isEmpty(ss4Var.p.content1)) {
                    this.f.setVisibility(8);
                    this.h.setVisibility(8);
                } else {
                    this.f.setVisibility(0);
                    this.h.setVisibility(0);
                    this.f.setText(ss4Var.p.content1);
                }
                if (TextUtils.isEmpty(ss4Var.p.content2)) {
                    this.g.setVisibility(8);
                    this.i.setVisibility(8);
                } else {
                    this.g.setVisibility(0);
                    this.i.setVisibility(0);
                    this.g.setText(ss4Var.p.content2);
                }
                TextView textView = this.f;
                ImageView imageView = this.h;
                TextView textView2 = this.g;
                CardLinkInfoData cardLinkInfoData2 = ss4Var.p;
                c(textView, imageView, textView2, cardLinkInfoData2.content1, cardLinkInfoData2.content2);
                return;
            }
            this.e.setVisibility(8);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.tb_group_chat_link_card_layout, (ViewGroup) this, true);
            this.b = findViewById(R.id.group_chat_main_view);
            this.c = (TbImageView) findViewById(R.id.group_chat_icon);
            this.d = (TextView) findViewById(R.id.group_chat_link_title);
            this.e = findViewById(R.id.group_chat_extra_info_container);
            this.f = (TextView) findViewById(R.id.group_chat_content1);
            this.g = (TextView) findViewById(R.id.group_chat_content2);
            this.h = (ImageView) findViewById(R.id.group_chat_content1_icon);
            this.i = (ImageView) findViewById(R.id.group_chat_content2_icon);
            this.j = (ImageView) findViewById(R.id.group_chat_close_button);
            this.c.setDrawCorner(true);
            this.c.setDefaultBgResource(R.drawable.icon_pure_group_chat_card_link_default);
            this.c.setRadiusById(R.string.J_X04);
            this.c.setConrers(15);
            this.c.setUseNightOrDarkMask(true);
            setOnClickListener(this);
            this.b.setOnClickListener(this);
            this.j.setOnClickListener(this);
            e();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            rw4 d = rw4.d(this.b);
            d.n(R.string.J_X05);
            d.f(R.color.CAM_X0206);
            rw4 d2 = rw4.d(this.d);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X07);
            d2.v(R.color.CAM_X0107);
            rw4 d3 = rw4.d(this.f);
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0109);
            rw4 d4 = rw4.d(this.g);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X09);
            d4.v(R.color.CAM_X0109);
            WebPManager.setPureDrawable(this.h, R.drawable.icon_group_chat_bar_icon, R.color.CAM_X0109, null);
            WebPManager.setPureDrawable(this.i, R.drawable.icon_group_chat_icon, R.color.CAM_X0109, null);
            WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_mount_card_link_right_del, R.color.CAM_X0108, null);
        }
    }
}
