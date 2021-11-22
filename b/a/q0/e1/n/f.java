package b.a.q0.e1.n;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
/* loaded from: classes4.dex */
public class f extends ClickableSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f13141e;

    /* renamed from: f  reason: collision with root package name */
    public int f13142f;

    /* renamed from: g  reason: collision with root package name */
    public int f13143g;

    /* renamed from: h  reason: collision with root package name */
    public String f13144h;

    /* renamed from: i  reason: collision with root package name */
    public String f13145i;
    public int j;
    public int k;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f13146a;

        /* renamed from: b  reason: collision with root package name */
        public String f13147b;

        /* renamed from: c  reason: collision with root package name */
        public String f13148c;

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
            this.f13146a = i2;
            this.f13147b = str;
            this.f13148c = str2;
        }
    }

    public f(int i2, String str) {
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
        this.f13141e = -1;
        this.f13142f = -1;
        this.k = 0;
        this.f13144h = str;
        this.f13143g = i2;
    }

    public static void a(Context context, i iVar, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, iVar, Integer.valueOf(i2), str, str2}) == null) || iVar == null) {
            return;
        }
        if (i2 == 2) {
            iVar.onLinkClicked(context, str, false);
        } else if (i2 == 16) {
            iVar.onAtClicked(context, str);
        } else if (i2 == 18) {
            iVar.onLinkClicked(context, str, true);
        } else if (i2 == 32) {
            iVar.onVideoClicked(context, str);
        } else if (i2 == 64) {
            iVar.onSongClicked(context, str);
        } else if (i2 == 128) {
            iVar.onVideoP2PClicked(context, str);
        } else if (i2 == 256) {
            iVar.onPhoneClicked(context, str, str2);
        } else if (i2 == 1024) {
            iVar.onLinkButtonClicked(context, str);
        } else if (i2 != 1282) {
        } else {
            iVar.onLinkClicked(context, str, true);
        }
    }

    public static void b(TbPageContext<?> tbPageContext, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65538, null, tbPageContext, i2, str, str2) == null) && tbPageContext != null && (tbPageContext.getOrignalPage() instanceof i)) {
            a(tbPageContext.getPageActivity(), (i) tbPageContext.getOrignalPage(), i2, str, str2);
        }
    }

    public static void c(TbPageContext<?> tbPageContext, i iVar, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, iVar, Integer.valueOf(i2), str, str2}) == null) || tbPageContext == null || iVar == null) {
            return;
        }
        a(tbPageContext.getPageActivity(), iVar, i2, str, str2);
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13144h : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f13143g;
            return i2 == 2 || i2 == 16 || i2 == 18 || i2 == 35 || i2 == 39;
        }
        return invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f13143g;
            return i2 == 2 || i2 == 16 || i2 == 18 || i2 == 35 || i2 == 39 || i2 == 1282;
        }
        return invokeV.booleanValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f13141e = i2;
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13143g : invokeV.intValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.j = i2;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f13145i = str;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f13142f = i2;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.k = i2;
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001332, new a(this.f13143g, this.f13144h, this.f13145i));
            int i2 = 2;
            if (this.f13143g == 2) {
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
        if (interceptable == null || interceptable.invokeL(1048586, this, textPaint) == null) {
            int i2 = this.f13142f;
            if (i2 != -1) {
                textPaint.setColor(SkinManager.getColor(i2));
            } else if (f()) {
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
            } else {
                textPaint.setColor(textPaint.linkColor);
            }
            textPaint.setUnderlineText(false);
            int i3 = this.f13141e;
            if (i3 != -1) {
                textPaint.bgColor = i3;
            } else if (this.j == 1 && e()) {
                textPaint.bgColor = SkinManager.getColor(R.color.CAM_X0210);
            } else if (this.j == 2) {
                textPaint.bgColor = SkinManager.getColor(R.color.transparent);
            }
        }
    }
}
