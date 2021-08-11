package c.a.o0.d1.m;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e extends ClickableSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f12943e;

    /* renamed from: f  reason: collision with root package name */
    public int f12944f;

    /* renamed from: g  reason: collision with root package name */
    public int f12945g;

    /* renamed from: h  reason: collision with root package name */
    public String f12946h;

    /* renamed from: i  reason: collision with root package name */
    public String f12947i;

    /* renamed from: j  reason: collision with root package name */
    public int f12948j;
    public int k;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f12949a;

        /* renamed from: b  reason: collision with root package name */
        public String f12950b;

        /* renamed from: c  reason: collision with root package name */
        public String f12951c;

        public a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12949a = i2;
            this.f12950b = str;
            this.f12951c = str2;
        }
    }

    public e(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12943e = -1;
        this.f12944f = -1;
        this.k = 0;
        this.f12946h = str;
        this.f12945g = i2;
    }

    public static void a(Context context, g gVar, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, gVar, Integer.valueOf(i2), str, str2}) == null) || gVar == null) {
            return;
        }
        if (i2 == 2) {
            gVar.onLinkClicked(context, str, false);
        } else if (i2 == 16) {
            gVar.onAtClicked(context, str);
        } else if (i2 == 18) {
            gVar.onLinkClicked(context, str, true);
        } else if (i2 == 32) {
            gVar.onVideoClicked(context, str);
        } else if (i2 == 64) {
            gVar.onSongClicked(context, str);
        } else if (i2 == 128) {
            gVar.onVideoP2PClicked(context, str);
        } else if (i2 == 256) {
            gVar.onPhoneClicked(context, str, str2);
        } else if (i2 != 1024) {
        } else {
            gVar.onLinkButtonClicked(context, str);
        }
    }

    public static void b(TbPageContext<?> tbPageContext, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65538, null, tbPageContext, i2, str, str2) == null) && tbPageContext != null && (tbPageContext.getOrignalPage() instanceof g)) {
            a(tbPageContext.getPageActivity(), (g) tbPageContext.getOrignalPage(), i2, str, str2);
        }
    }

    public static void c(TbPageContext<?> tbPageContext, g gVar, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, gVar, Integer.valueOf(i2), str, str2}) == null) || tbPageContext == null || gVar == null) {
            return;
        }
        a(tbPageContext.getPageActivity(), gVar, i2, str, str2);
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12946h : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f12945g;
            return i2 == 2 || i2 == 16 || i2 == 18 || i2 == 39 || i2 == 30 || i2 == 31;
        }
        return invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f12945g;
            return i2 == 2 || i2 == 16 || i2 == 18 || i2 == 39 || i2 == 30 || i2 == 31;
        }
        return invokeV.booleanValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f12943e = i2;
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f12948j = i2;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f12947i = str;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f12944f = i2;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.k = i2;
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001332, new a(this.f12945g, this.f12946h, this.f12947i));
            int i2 = 2;
            if (this.f12945g == 2) {
                int i3 = this.k;
                int i4 = 1;
                if (i3 == 1) {
                    i2 = 1;
                    i4 = 2;
                } else if (i3 == 2) {
                    i2 = 1;
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PB_URL_CLICK_KEY).param("obj_source", i2).param("obj_type", i4));
            }
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, textPaint) == null) {
            int i2 = this.f12944f;
            if (i2 != -1) {
                textPaint.setColor(SkinManager.getColor(i2));
            } else if (f()) {
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
            } else {
                textPaint.setColor(textPaint.linkColor);
            }
            textPaint.setUnderlineText(false);
            int i3 = this.f12943e;
            if (i3 != -1) {
                textPaint.bgColor = i3;
            } else if (this.f12948j == 1 && e()) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    textPaint.bgColor = SkinManager.getColor(R.color.CAM_X0204);
                } else {
                    textPaint.bgColor = SkinManager.getColor(R.color.cp_bg_line_z);
                }
            } else if (this.f12948j == 2) {
                textPaint.bgColor = SkinManager.getColor(R.color.transparent);
            }
        }
    }
}
