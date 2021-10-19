package c.a.r0.y1.h.b;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.y1.h.a.g;
import c.a.r0.y1.h.f.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.message.AddTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.AddTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.AddTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f28939a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28940b;

    /* renamed from: c  reason: collision with root package name */
    public TailData f28941c;

    /* renamed from: d  reason: collision with root package name */
    public TailData f28942d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f28943e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.y1.h.f.a<Integer> f28944f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.y1.h.f.a<Integer> f28945g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.c.g.a f28946h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.e.c.g.a f28947i;

    /* renamed from: c.a.r0.y1.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1352a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28948a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1352a(a aVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28948a = aVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.a.r0.y1.h.a.b resultData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f28948a.f28939a = false;
                if (this.f28948a.f28944f != null) {
                    Integer num = null;
                    if (responsedMessage instanceof AddTailHttpResponseMessage) {
                        resultData = ((AddTailHttpResponseMessage) responsedMessage).getResultData();
                    } else {
                        resultData = responsedMessage instanceof AddTailSocketResponseMessage ? ((AddTailSocketResponseMessage) responsedMessage).getResultData() : null;
                    }
                    if (resultData != null) {
                        num = Integer.valueOf(resultData.a());
                        if (this.f28948a.f28940b) {
                            this.f28948a.p(num.intValue());
                        }
                    }
                    this.f28948a.f28944f.a(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28949a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28949a = aVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g resultData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f28949a.f28939a = false;
                if (this.f28949a.f28945g != null) {
                    if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                        resultData = ((UpdateTailHttpResponseMessage) responsedMessage).getResultData();
                    } else {
                        resultData = responsedMessage instanceof UpdateTailSocketResponseMessage ? ((UpdateTailSocketResponseMessage) responsedMessage).getResultData() : null;
                    }
                    this.f28949a.f28945g.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
                }
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28939a = false;
        this.f28940b = false;
        this.f28946h = new C1352a(this, CmdConfigHttp.CMD_TAIL_ADD, 305101);
        this.f28947i = new b(this, CmdConfigHttp.CMD_TAIL_UPDATE, 305102);
        this.f28943e = tbPageContext;
        tbPageContext.registerListener(this.f28946h);
        this.f28943e.registerListener(this.f28947i);
        this.f28942d = new TailData();
    }

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Pattern.compile("#\\([^#\\)\\(]+\\)").matcher(str).replaceAll(" ").length() : invokeL.intValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? (str == null || str.length() <= 0) ? "" : str.substring(0, str.length() - 1) : (String) invokeL.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28942d.getFontColor() : (String) invokeV.objValue;
    }

    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            while (e(str) > 50) {
                str = f(str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public TailData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28942d : (TailData) invokeV.objValue;
    }

    public void j(int i2, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), str, str2, Boolean.valueOf(z)}) == null) {
            TailData tailData = new TailData();
            this.f28942d = tailData;
            if (i2 != 0) {
                TailData tailData2 = new TailData();
                this.f28941c = tailData2;
                tailData2.setId(i2);
                this.f28941c.setContent(str);
                this.f28941c.setFontColor(str2);
                this.f28942d.setId(i2);
                this.f28942d.setContent(str);
                this.f28942d.setFontColor(str2);
                return;
            }
            tailData.setContent("");
            this.f28942d.setFontColor("7a7c80");
            this.f28940b = z;
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TailData tailData = this.f28942d;
            if (tailData != null && tailData.getFontColor() != null) {
                TailData tailData2 = this.f28941c;
                if (tailData2 == null) {
                    if (!StringUtils.isNull(this.f28942d.getContent()) || !this.f28942d.getFontColor().equals("7a7c80")) {
                        return true;
                    }
                } else if (tailData2.getContent() != null && this.f28941c.getFontColor() != null && (!this.f28941c.getContent().equals(this.f28942d.getContent()) || !this.f28941c.getFontColor().equals(this.f28942d.getFontColor()))) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 == 50 : invokeI.booleanValue;
    }

    public boolean m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? i2 > 50 : invokeI.booleanValue;
    }

    public void n(c.a.r0.y1.h.f.a<Integer> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f28944f = aVar;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f28942d.setFontColor(str);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            MessageManager.getInstance().sendMessage(new SetTailNetMessage(i2, 1));
        }
    }

    public void q(c.a.r0.y1.h.f.a<Integer> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.f28945g = aVar;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || this.f28939a) {
            return;
        }
        String f2 = d.f(str);
        if (!StringUtils.isNull(f2)) {
            this.f28943e.showToast(f2);
            return;
        }
        String b2 = d.b(str);
        this.f28942d.setContent(b2);
        this.f28939a = true;
        TailData tailData = this.f28941c;
        if (tailData != null && tailData.getId() > 0) {
            this.f28943e.sendMessage(new UpdateTailNetMessage(this.f28941c.getId(), b2, this.f28942d.getFontColor(), this.f28943e.getString(R.string.tail_default_font)));
        } else {
            this.f28943e.sendMessage(new AddTailNetMessage(b2, this.f28942d.getFontColor(), this.f28943e.getString(R.string.tail_default_font)));
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? !StringUtils.isNull(this.f28942d.getContent()) && k() && StringUtils.isNull(d.f(this.f28942d.getContent())) : invokeV.booleanValue;
    }
}
