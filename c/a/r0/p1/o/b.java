package c.a.r0.p1.o;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final List<e> f23533c;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.p1.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1100b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f23534a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1949049054, "Lc/a/r0/p1/o/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1949049054, "Lc/a/r0/p1/o/b$b;");
                    return;
                }
            }
            f23534a = new b(null);
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C1100b.f23534a : (b) invokeV.objValue;
    }

    public static ICardInfo i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                ICardInfo j2 = j(new JSONObject(str));
                if (j2 != null) {
                    if (j2.isValid()) {
                        return j2;
                    }
                }
                return null;
            } catch (CardParseException e2) {
                BdLog.detailException("CardFactory.getPageCardInfo", e2);
                return null;
            } catch (JSONException e3) {
                BdLog.detailException("CardFactory.getPageCardInfo", e3);
                return null;
            }
        }
        return (ICardInfo) invokeL.objValue;
    }

    public static ICardInfo j(JSONObject jSONObject) throws CardParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) ? h().b(jSONObject, jSONObject.optInt("card_type")) : (ICardInfo) invokeL.objValue;
    }

    @Override // c.a.r0.p1.o.e
    public <T> c.a.r0.p1.o.l.e a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, tbPageContext, iCardInfo, i2)) == null) {
            c.a.r0.p1.o.l.e e2 = e(tbPageContext, iCardInfo, i2);
            if (e2 != null) {
                e2.setBusinessType(i2);
            }
            return e2;
        }
        return (c.a.r0.p1.o.l.e) invokeLLI.objValue;
    }

    @Override // c.a.r0.p1.o.e
    public ICardInfo b(JSONObject jSONObject, int i2) throws CardParseException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i2)) == null) ? f(jSONObject, i2) : (ICardInfo) invokeLI.objValue;
    }

    @Override // c.a.r0.p1.o.e
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // c.a.r0.p1.o.e
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "lego_main" : (String) invokeV.objValue;
    }

    public final <T> c.a.r0.p1.o.l.e e(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i2) {
        InterceptResult invokeLLI;
        c.a.r0.p1.o.l.e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, tbPageContext, iCardInfo, i2)) == null) {
            for (e eVar : this.f23533c) {
                try {
                    a2 = eVar.a(tbPageContext, iCardInfo, i2);
                } catch (Throwable th) {
                    BdLog.detailException("factory <" + eVar.d() + "> respond exception", th);
                }
                if (a2 != null) {
                    return a2;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("No card factory for card type ");
            sb.append(iCardInfo == null ? -1 : iCardInfo.getCardType());
            BdLog.e(sb.toString());
            return null;
        }
        return (c.a.r0.p1.o.l.e) invokeLLI.objValue;
    }

    public final ICardInfo f(JSONObject jSONObject, int i2) throws CardParseException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, jSONObject, i2)) == null) {
            for (e eVar : this.f23533c) {
                try {
                    ICardInfo b2 = eVar.b(jSONObject, i2);
                    if (b2 != null) {
                        return b2;
                    }
                } catch (Throwable th) {
                    throw new CardParseException("Card type " + i2 + ", factory <" + eVar.d() + "> respond exception", th);
                }
            }
            BdLog.e("No card factory for card type " + i2);
            return null;
        }
        return (ICardInfo) invokeLI.objValue;
    }

    public synchronized void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            synchronized (this) {
                this.f23533c.add(eVar);
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23533c = new ArrayList(4);
    }
}
