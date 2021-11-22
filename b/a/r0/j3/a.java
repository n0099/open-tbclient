package b.a.r0.j3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.square.model.ForumSquareModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext f19930a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f19931b;

    /* renamed from: c  reason: collision with root package name */
    public ForumSquareModel f19932c;

    /* renamed from: d  reason: collision with root package name */
    public b f19933d;

    /* renamed from: e  reason: collision with root package name */
    public c f19934e;

    /* renamed from: f  reason: collision with root package name */
    public String f19935f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f19936g;

    /* renamed from: b.a.r0.j3.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1002a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19937a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1002a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f19937a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                a aVar = this.f19937a;
                if (aVar.f19933d == null || aVar.f19932c == null) {
                    return;
                }
                this.f19937a.f19935f = "";
                this.f19937a.f19932c.clearData();
                this.f19937a.o();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19935f = "";
        this.f19936g = new C1002a(this, 2921589);
        this.f19930a = tbPageContext;
        this.f19931b = context;
        this.f19932c = new ForumSquareModel(context, this);
        this.f19933d = new b(context, this.f19930a);
        this.f19930a.registerListener(this.f19936g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r5.equals(r1) == false) goto L11;
     */
    @Override // b.a.r0.j3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, List<String> list, List<n> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, list, list2) == null) || this.f19932c == null || this.f19933d == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.equals(this.f19935f)) {
            String e2 = this.f19933d.e();
            if (!TextUtils.isEmpty(str)) {
            }
            this.f19935f = str;
            this.f19933d.J();
            this.f19933d.r(str, list, z);
            this.f19933d.t(list2, this.f19932c.O(list2, 300));
            f(str, list2);
        }
        z = true;
        this.f19935f = str;
        this.f19933d.J();
        this.f19933d.r(str, list, z);
        this.f19933d.t(list2, this.f19932c.O(list2, 300));
        f(str, list2);
    }

    @Override // b.a.r0.j3.d
    public void b(ErrorData errorData) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorData) == null) || (bVar = this.f19933d) == null) {
            return;
        }
        bVar.I();
    }

    @Override // b.a.r0.j3.d
    public void c(String str, ErrorData errorData) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, errorData) == null) || (bVar = this.f19933d) == null || this.f19932c == null) {
            return;
        }
        bVar.J();
        b.a.r0.j3.f.c I = this.f19932c.I(str);
        if (I != null && (!I.f19978d || !ListUtils.isEmpty(I.a()))) {
            this.f19933d.s(I.a());
            f(str, I.a());
            return;
        }
        this.f19933d.f();
        this.f19933d.u();
    }

    public final void f(String str, List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) || this.f19933d == null || this.f19932c == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.f19933d.f();
        } else if (ListUtils.getCount(list) < 10) {
            this.f19933d.n();
        } else {
            this.f19933d.E(this.f19932c.J(str));
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f19933d.b();
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19935f : (String) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String h2 = h();
            ForumSquareModel forumSquareModel = this.f19932c;
            if (forumSquareModel == null || this.f19933d == null) {
                return;
            }
            boolean K = forumSquareModel.K();
            boolean E = this.f19933d.E(this.f19932c.J(h2));
            if (K || !E) {
                return;
            }
            this.f19932c.L(h2);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b bVar = this.f19933d;
            if (bVar != null) {
                bVar.F();
            }
            ForumSquareModel forumSquareModel = this.f19932c;
            if (forumSquareModel != null) {
                forumSquareModel.L(h());
            }
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            m(this.f19935f);
            this.f19935f = str;
            ForumSquareModel forumSquareModel = this.f19932c;
            if (forumSquareModel == null || this.f19933d == null) {
                return;
            }
            b.a.r0.j3.f.c I = forumSquareModel.I(str);
            if (I != null && (!I.f19978d || !ListUtils.isEmpty(I.a()))) {
                this.f19933d.J();
                f(str, I.a());
                this.f19933d.s(I.a());
                this.f19933d.q(I.f19980f, I.f19981g);
                return;
            }
            this.f19933d.D();
            f(str, null);
            this.f19932c.L(str);
            this.f19933d.q(0, 0);
        }
    }

    public void l(Intent intent) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
        this.f19935f = stringExtra;
        if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            this.f19935f = uri.getQueryParameter("tab_name");
        }
        this.f19933d.C(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
    }

    public void m(String str) {
        b.a.r0.j3.f.c I;
        Pair<Integer, Integer> c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f19933d == null || this.f19932c == null || TextUtils.isEmpty(str) || (I = this.f19932c.I(str)) == null || (c2 = this.f19933d.c()) == null) {
            return;
        }
        I.f19980f = ((Integer) c2.first).intValue();
        I.f19981g = ((Integer) c2.second).intValue();
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f19933d.B(str);
        k(str);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c cVar = new c(this.f19931b, this, this.f19933d);
            this.f19934e = cVar;
            cVar.e();
            p();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f19933d.F();
            this.f19932c.L(this.f19935f);
        }
    }
}
