package b.a.r0.y1.h.b;

import androidx.core.view.InputDeviceCompat;
import b.a.r0.y1.h.a.g;
import b.a.r0.y1.h.f.d;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f27655a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27656b;

    /* renamed from: c  reason: collision with root package name */
    public TailData f27657c;

    /* renamed from: d  reason: collision with root package name */
    public TailData f27658d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f27659e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.y1.h.f.a<Integer> f27660f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.y1.h.f.a<Integer> f27661g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.e.c.g.a f27662h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.e.c.g.a f27663i;

    /* renamed from: b.a.r0.y1.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1352a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27664a;

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
            this.f27664a = aVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.a.r0.y1.h.a.b resultData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f27664a.f27655a = false;
                if (this.f27664a.f27660f != null) {
                    Integer num = null;
                    if (responsedMessage instanceof AddTailHttpResponseMessage) {
                        resultData = ((AddTailHttpResponseMessage) responsedMessage).getResultData();
                    } else {
                        resultData = responsedMessage instanceof AddTailSocketResponseMessage ? ((AddTailSocketResponseMessage) responsedMessage).getResultData() : null;
                    }
                    if (resultData != null) {
                        num = Integer.valueOf(resultData.a());
                        if (this.f27664a.f27656b) {
                            this.f27664a.p(num.intValue());
                        }
                    }
                    this.f27664a.f27660f.a(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27665a;

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
            this.f27665a = aVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g resultData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f27665a.f27655a = false;
                if (this.f27665a.f27661g != null) {
                    if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                        resultData = ((UpdateTailHttpResponseMessage) responsedMessage).getResultData();
                    } else {
                        resultData = responsedMessage instanceof UpdateTailSocketResponseMessage ? ((UpdateTailSocketResponseMessage) responsedMessage).getResultData() : null;
                    }
                    this.f27665a.f27661g.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
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
        this.f27655a = false;
        this.f27656b = false;
        this.f27662h = new C1352a(this, CmdConfigHttp.CMD_TAIL_ADD, 305101);
        this.f27663i = new b(this, CmdConfigHttp.CMD_TAIL_UPDATE, 305102);
        this.f27659e = tbPageContext;
        tbPageContext.registerListener(this.f27662h);
        this.f27659e.registerListener(this.f27663i);
        this.f27658d = new TailData();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27658d.getFontColor() : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27658d : (TailData) invokeV.objValue;
    }

    public void j(int i2, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), str, str2, Boolean.valueOf(z)}) == null) {
            TailData tailData = new TailData();
            this.f27658d = tailData;
            if (i2 != 0) {
                TailData tailData2 = new TailData();
                this.f27657c = tailData2;
                tailData2.setId(i2);
                this.f27657c.setContent(str);
                this.f27657c.setFontColor(str2);
                this.f27658d.setId(i2);
                this.f27658d.setContent(str);
                this.f27658d.setFontColor(str2);
                return;
            }
            tailData.setContent("");
            this.f27658d.setFontColor("7a7c80");
            this.f27656b = z;
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TailData tailData = this.f27658d;
            if (tailData != null && tailData.getFontColor() != null) {
                TailData tailData2 = this.f27657c;
                if (tailData2 == null) {
                    if (!StringUtils.isNull(this.f27658d.getContent()) || !this.f27658d.getFontColor().equals("7a7c80")) {
                        return true;
                    }
                } else if (tailData2.getContent() != null && this.f27657c.getFontColor() != null && (!this.f27657c.getContent().equals(this.f27658d.getContent()) || !this.f27657c.getFontColor().equals(this.f27658d.getFontColor()))) {
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

    public void n(b.a.r0.y1.h.f.a<Integer> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f27660f = aVar;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f27658d.setFontColor(str);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            MessageManager.getInstance().sendMessage(new SetTailNetMessage(i2, 1));
        }
    }

    public void q(b.a.r0.y1.h.f.a<Integer> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.f27661g = aVar;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || this.f27655a) {
            return;
        }
        String f2 = d.f(str);
        if (!StringUtils.isNull(f2)) {
            this.f27659e.showToast(f2);
            return;
        }
        String b2 = d.b(str);
        this.f27658d.setContent(b2);
        this.f27655a = true;
        TailData tailData = this.f27657c;
        if (tailData != null && tailData.getId() > 0) {
            this.f27659e.sendMessage(new UpdateTailNetMessage(this.f27657c.getId(), b2, this.f27658d.getFontColor(), this.f27659e.getString(R.string.tail_default_font)));
        } else {
            this.f27659e.sendMessage(new AddTailNetMessage(b2, this.f27658d.getFontColor(), this.f27659e.getString(R.string.tail_default_font)));
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? !StringUtils.isNull(this.f27658d.getContent()) && k() && StringUtils.isNull(d.f(this.f27658d.getContent())) : invokeV.booleanValue;
    }
}
