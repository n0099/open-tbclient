package c.a.p0.d1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.forumSquare.model.ForumSquareModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f13611b;

    /* renamed from: c  reason: collision with root package name */
    public ForumSquareModel f13612c;

    /* renamed from: d  reason: collision with root package name */
    public b f13613d;

    /* renamed from: e  reason: collision with root package name */
    public c f13614e;

    /* renamed from: f  reason: collision with root package name */
    public String f13615f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f13616g;

    /* renamed from: c.a.p0.d1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1027a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1027a(a aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                a aVar = this.a;
                if (aVar.f13613d == null || aVar.f13612c == null) {
                    return;
                }
                this.a.f13615f = "推荐";
                this.a.f13612c.clearData();
                this.a.p();
            }
        }
    }

    public a(Context context, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13615f = "推荐";
        this.f13616g = new C1027a(this, 2921589);
        this.a = tbPageContext;
        this.f13611b = context;
        this.f13612c = new ForumSquareModel(context, this);
        this.f13613d = new b(context, this.a);
        this.a.registerListener(this.f13616g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r5.equals(r1) == false) goto L11;
     */
    @Override // c.a.p0.d1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, List<String> list, List<n> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, list, list2) == null) || this.f13612c == null || this.f13613d == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.equals(this.f13615f)) {
            String f2 = this.f13613d.f();
            if (!TextUtils.isEmpty(str)) {
            }
            this.f13615f = str;
            this.f13613d.K();
            this.f13613d.s(str, list, z);
            this.f13613d.u(list2, this.f13612c.R(list2, 300));
            f(str, list2);
        }
        z = true;
        this.f13615f = str;
        this.f13613d.K();
        this.f13613d.s(str, list, z);
        this.f13613d.u(list2, this.f13612c.R(list2, 300));
        f(str, list2);
    }

    @Override // c.a.p0.d1.d
    public void b(ErrorData errorData) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorData) == null) || (bVar = this.f13613d) == null) {
            return;
        }
        bVar.J();
    }

    @Override // c.a.p0.d1.d
    public void c(String str, ErrorData errorData) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, errorData) == null) || (bVar = this.f13613d) == null || this.f13612c == null) {
            return;
        }
        bVar.K();
        c.a.p0.d1.f.b L = this.f13612c.L(str);
        if (L != null && (!L.f13645d || !ListUtils.isEmpty(L.a()))) {
            this.f13613d.t(L.a());
            f(str, L.a());
            return;
        }
        this.f13613d.g();
        this.f13613d.v();
    }

    public final void f(String str, List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) || this.f13613d == null || this.f13612c == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.f13613d.g();
        } else if (ListUtils.getCount(list) < 10) {
            this.f13613d.o();
        } else {
            this.f13613d.F(this.f13612c.M(str));
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f13613d.c();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f13613d.b();
        }
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13615f : (String) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String i = i();
            ForumSquareModel forumSquareModel = this.f13612c;
            if (forumSquareModel == null || this.f13613d == null) {
                return;
            }
            boolean N = forumSquareModel.N();
            boolean F = this.f13613d.F(this.f13612c.M(i));
            if (N || !F) {
                return;
            }
            this.f13612c.O(i);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b bVar = this.f13613d;
            if (bVar != null) {
                bVar.G();
            }
            ForumSquareModel forumSquareModel = this.f13612c;
            if (forumSquareModel != null) {
                forumSquareModel.O(i());
            }
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            o(this.f13615f);
            this.f13615f = str;
            ForumSquareModel forumSquareModel = this.f13612c;
            if (forumSquareModel == null || this.f13613d == null) {
                return;
            }
            c.a.p0.d1.f.b L = forumSquareModel.L(str);
            if (L != null && (!L.f13645d || !ListUtils.isEmpty(L.a()))) {
                this.f13613d.K();
                f(str, L.a());
                this.f13613d.t(L.a());
                this.f13613d.r(L.f13647f, L.f13648g);
                return;
            }
            this.f13613d.E();
            f(str, null);
            this.f13612c.O(str);
            this.f13613d.r(0, 0);
        }
    }

    public void m(String str) {
        ForumSquareModel forumSquareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (forumSquareModel = this.f13612c) == null || this.f13613d == null || !forumSquareModel.K(str)) {
            return;
        }
        this.f13613d.C(str);
        l(str);
    }

    public void n(Intent intent) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
        this.f13615f = stringExtra;
        if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            this.f13615f = uri.getQueryParameter("tab_name");
        }
        this.f13613d.D(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
    }

    public void o(String str) {
        c.a.p0.d1.f.b L;
        Pair<Integer, Integer> d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || this.f13613d == null || this.f13612c == null || TextUtils.isEmpty(str) || (L = this.f13612c.L(str)) == null || (d2 = this.f13613d.d()) == null) {
            return;
        }
        L.f13647f = ((Integer) d2.first).intValue();
        L.f13648g = ((Integer) d2.second).intValue();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c cVar = new c(this.f13611b, this, this.f13613d);
            this.f13614e = cVar;
            cVar.e();
            q();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f13613d.G();
            this.f13612c.O(this.f13615f);
        }
    }
}
