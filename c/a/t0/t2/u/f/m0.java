package c.a.t0.t2.u.f;

import android.graphics.Rect;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class m0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23248b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f23249c;

    /* renamed from: d  reason: collision with root package name */
    public int f23250d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.t2.r.f f23251e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23252f;

    /* renamed from: g  reason: collision with root package name */
    public Parcelable f23253g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23254h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23255i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f23256j;
    public PostData k;
    public PostData l;
    public int m;

    /* loaded from: classes8.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                m0.b().m();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                m0.b().m();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                m0.b().l(1, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                m0.b().l(0, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                m0.b().v((UserPendantData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.t0.x3.j0.e)) {
                m0.b().u((c.a.t0.x3.j0.e) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.t0.x3.j0.e)) {
                m0.b().w((c.a.t0.x3.j0.e) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public static m0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-482978963, "Lc/a/t0/t2/u/f/m0$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-482978963, "Lc/a/t0/t2/u/f/m0$h;");
                    return;
                }
            }
            a = new m0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1855249103, "Lc/a/t0/t2/u/f/m0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1855249103, "Lc/a/t0/t2/u/f/m0;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2005016));
        MessageManager.getInstance().registerListener(new b(2004006));
        MessageManager.getInstance().registerListener(new c(2001335));
        MessageManager.getInstance().registerListener(new d(2001336));
        MessageManager.getInstance().registerListener(new e(2016485));
        MessageManager.getInstance().registerListener(new f(2016528));
        MessageManager.getInstance().registerListener(new g(2016530));
    }

    public /* synthetic */ m0(a aVar) {
        this();
    }

    public static m0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? h.a : (m0) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23255i : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23256j : invokeV.booleanValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : invokeV.intValue;
    }

    public Parcelable e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f23252f) {
                this.f23252f = false;
                Parcelable parcelable = this.f23253g;
                this.f23253g = null;
                return parcelable;
            }
            this.f23253g = null;
            return null;
        }
        return (Parcelable) invokeV.objValue;
    }

    public c.a.t0.t2.r.f f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.f23248b) {
                this.f23252f = false;
                return null;
            }
            c.a.t0.t2.r.f fVar = this.f23251e;
            if (fVar != null && fVar.F() != null && this.f23251e.F().size() > 0) {
                this.f23252f = true;
                c.a.t0.t2.r.f fVar2 = this.f23251e;
                this.f23251e = null;
                return fVar2;
            }
            this.f23252f = false;
            this.f23251e = null;
            return null;
        }
        return (c.a.t0.t2.r.f) invokeV.objValue;
    }

    public PostData g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (PostData) invokeV.objValue;
    }

    public PostData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (PostData) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f23254h : invokeV.booleanValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f23250d : invokeV.intValue;
    }

    public Rect k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f23249c : (Rect) invokeV.objValue;
    }

    public void l(int i2, CustomResponsedMessage<?> customResponsedMessage) {
        c.a.t0.t2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048586, this, i2, customResponsedMessage) == null) || customResponsedMessage == null || (fVar = this.f23251e) == null || fVar.l() == null) {
            return;
        }
        Object data = customResponsedMessage.getData();
        if ((data instanceof Long) && ((Long) data).longValue() == c.a.d.f.m.b.g(this.f23251e.l().getId(), 0L)) {
            this.f23251e.l().setLike(i2);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f23248b = false;
            this.f23251e = null;
            this.f23252f = false;
            this.f23253g = null;
            this.f23249c = null;
            this.f23250d = 0;
        }
    }

    public boolean n(c.a.t0.t2.r.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{fVar, parcelable, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            this.f23248b = false;
            if (this.a == null) {
                m();
                return false;
            } else if (fVar == null) {
                m();
                return false;
            } else if (fVar.F() == null) {
                m();
                return false;
            } else if (fVar.F().size() < 1) {
                m();
                return false;
            } else {
                this.f23251e = fVar;
                this.f23252f = false;
                this.f23253g = parcelable;
                this.f23254h = z;
                this.f23255i = z2;
                this.f23256j = z3;
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.m = i2;
        }
    }

    public void p(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) {
            this.f23248b = false;
            if (z) {
                str = null;
            }
            if (str != null && str.length() >= 1) {
                if (!str.equals(this.a)) {
                    m();
                    this.a = str;
                    return;
                }
                this.f23248b = true;
                return;
            }
            m();
            this.a = null;
        }
    }

    public void q(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, postData) == null) {
            this.k = postData;
        }
    }

    public void r(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, postData) == null) {
            this.l = postData;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f23250d = i2;
        }
    }

    public void t(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, rect) == null) {
            this.f23249c = rect;
        }
    }

    public void u(c.a.t0.x3.j0.e eVar) {
        c.a.t0.t2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) || (fVar = this.f23251e) == null || fVar.O() == null || this.f23251e.O().B() == null || eVar == null) {
            return;
        }
        AgreeData agreeData = eVar.f25095b;
        AgreeData B = this.f23251e.O().B();
        if (agreeData == null || B == null) {
            return;
        }
        String str = agreeData.nid;
        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
            BaijiahaoData L = this.f23251e.O().L();
            if (L == null || !TextUtils.equals(str, L.oriUgcNid)) {
                return;
            }
            B.agreeType = agreeData.agreeType;
            B.hasAgree = agreeData.hasAgree;
            B.diffAgreeNum = agreeData.diffAgreeNum;
            B.agreeNum = agreeData.agreeNum;
            B.disAgreeNum = agreeData.disAgreeNum;
            return;
        }
        String str2 = agreeData.threadId;
        if ("0".equals(str2) || TextUtils.isEmpty(str2) || !str2.equals(B.threadId)) {
            return;
        }
        B.agreeType = agreeData.agreeType;
        B.hasAgree = agreeData.hasAgree;
        B.diffAgreeNum = agreeData.diffAgreeNum;
        B.agreeNum = agreeData.agreeNum;
        B.disAgreeNum = agreeData.disAgreeNum;
    }

    public void v(UserPendantData userPendantData) {
        c.a.t0.t2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, userPendantData) == null) || userPendantData == null || (fVar = this.f23251e) == null || fVar.F() == null || this.f23251e.F().size() <= 0) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        int size = this.f23251e.F().size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f23251e.F().get(i2) != null && this.f23251e.F().get(i2).t() != null && currentAccount.equals(this.f23251e.F().get(i2).t().getUserId()) && this.f23251e.F().get(i2).t().getPendantData() != null) {
                this.f23251e.F().get(i2).t().getPendantData().setImgUrl(userPendantData.getImgUrl());
                this.f23251e.F().get(i2).t().getPendantData().setPropsId(userPendantData.getPropsId());
            }
        }
    }

    public void w(c.a.t0.x3.j0.e eVar) {
        c.a.t0.t2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) || (fVar = this.f23251e) == null || eVar == null) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        if (ListUtils.isEmpty(F)) {
            return;
        }
        AgreeData agreeData = eVar.f25095b;
        for (PostData postData : F) {
            if (postData != null && TextUtils.equals(postData.G(), agreeData.postId)) {
                AgreeData q = postData.q();
                q.agreeType = agreeData.agreeType;
                q.hasAgree = agreeData.hasAgree;
                q.diffAgreeNum = agreeData.diffAgreeNum;
                q.agreeNum = agreeData.agreeNum;
                q.disAgreeNum = agreeData.disAgreeNum;
                return;
            }
        }
    }

    public m0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f23248b = false;
        this.f23250d = 0;
        this.f23251e = null;
        this.f23252f = false;
        this.f23253g = null;
        this.f23254h = true;
        this.f23255i = false;
        this.f23256j = false;
    }
}
