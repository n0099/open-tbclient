package c.a.o0.e1.n;

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
/* loaded from: classes2.dex */
public class f extends ClickableSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f10179b;

    /* renamed from: c  reason: collision with root package name */
    public int f10180c;

    /* renamed from: d  reason: collision with root package name */
    public String f10181d;

    /* renamed from: e  reason: collision with root package name */
    public String f10182e;

    /* renamed from: f  reason: collision with root package name */
    public int f10183f;

    /* renamed from: g  reason: collision with root package name */
    public int f10184g;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f10185b;

        /* renamed from: c  reason: collision with root package name */
        public String f10186c;

        public a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.f10185b = str;
            this.f10186c = str2;
        }
    }

    public f(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.f10179b = -1;
        this.f10184g = 0;
        this.f10181d = str;
        this.f10180c = i;
    }

    public static void a(Context context, i iVar, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, iVar, Integer.valueOf(i), str, str2}) == null) || iVar == null) {
            return;
        }
        if (i == 2) {
            iVar.onLinkClicked(context, str, false);
        } else if (i == 16) {
            iVar.onAtClicked(context, str);
        } else if (i == 18) {
            iVar.onLinkClicked(context, str, true);
        } else if (i == 32) {
            iVar.onVideoClicked(context, str);
        } else if (i == 64) {
            iVar.onSongClicked(context, str);
        } else if (i == 128) {
            iVar.onVideoP2PClicked(context, str);
        } else if (i == 256) {
            iVar.onPhoneClicked(context, str, str2);
        } else if (i == 1024) {
            iVar.onLinkButtonClicked(context, str);
        } else if (i != 1282) {
        } else {
            iVar.onLinkClicked(context, str, true);
        }
    }

    public static void b(TbPageContext<?> tbPageContext, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65538, null, tbPageContext, i, str, str2) == null) && tbPageContext != null && (tbPageContext.getOrignalPage() instanceof i)) {
            a(tbPageContext.getPageActivity(), (i) tbPageContext.getOrignalPage(), i, str, str2);
        }
    }

    public static void c(TbPageContext<?> tbPageContext, i iVar, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, iVar, Integer.valueOf(i), str, str2}) == null) || tbPageContext == null || iVar == null) {
            return;
        }
        a(tbPageContext.getPageActivity(), iVar, i, str, str2);
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10181d : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.f10180c;
            return i == 2 || i == 16 || i == 18 || i == 35 || i == 39;
        }
        return invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.f10180c;
            return i == 2 || i == 16 || i == 18 || i == 35 || i == 39 || i == 1282;
        }
        return invokeV.booleanValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a = i;
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f10180c : invokeV.intValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f10183f = i;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f10182e = str;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f10179b = i;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f10184g = i;
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001332, new a(this.f10180c, this.f10181d, this.f10182e));
            int i = 2;
            if (this.f10180c == 2) {
                int i2 = this.f10184g;
                int i3 = 1;
                if (i2 == 1) {
                    i = 1;
                    i3 = 2;
                } else if (i2 == 2) {
                    i = 1;
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PB_URL_CLICK_KEY).param("obj_source", i).param("obj_type", i3));
            }
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, textPaint) == null) {
            int i = this.f10179b;
            if (i != -1) {
                textPaint.setColor(SkinManager.getColor(i));
            } else if (f()) {
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
            } else {
                textPaint.setColor(textPaint.linkColor);
            }
            textPaint.setUnderlineText(false);
            int i2 = this.a;
            if (i2 != -1) {
                textPaint.bgColor = i2;
            } else if (this.f10183f == 1 && e()) {
                textPaint.bgColor = SkinManager.getColor(R.color.CAM_X0210);
            } else if (this.f10183f == 2) {
                textPaint.bgColor = SkinManager.getColor(R.color.transparent);
            }
        }
    }
}
