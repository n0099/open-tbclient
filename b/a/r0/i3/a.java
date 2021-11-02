package b.a.r0.i3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
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
    public final TbPageContext f17986a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f17987b;

    /* renamed from: c  reason: collision with root package name */
    public ForumSquareModel f17988c;

    /* renamed from: d  reason: collision with root package name */
    public b f17989d;

    /* renamed from: e  reason: collision with root package name */
    public c f17990e;

    /* renamed from: f  reason: collision with root package name */
    public String f17991f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f17992g;

    /* renamed from: b.a.r0.i3.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0918a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17993a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0918a(a aVar, int i2) {
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
            this.f17993a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                a aVar = this.f17993a;
                if (aVar.f17989d == null || aVar.f17988c == null) {
                    return;
                }
                this.f17993a.f17991f = "";
                this.f17993a.f17988c.clearData();
                this.f17993a.o();
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
        this.f17991f = "";
        this.f17992g = new C0918a(this, 2921589);
        this.f17986a = tbPageContext;
        this.f17987b = context;
        this.f17988c = new ForumSquareModel(context, this);
        this.f17989d = new b(context, this.f17986a);
        this.f17986a.registerListener(this.f17992g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r5.equals(r1) == false) goto L11;
     */
    @Override // b.a.r0.i3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, List<String> list, List<n> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, list, list2) == null) || this.f17988c == null || this.f17989d == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.equals(this.f17991f)) {
            String e2 = this.f17989d.e();
            if (!TextUtils.isEmpty(str)) {
            }
            this.f17991f = str;
            this.f17989d.J();
            this.f17989d.r(str, list, z);
            this.f17989d.t(list2, this.f17988c.O(list2, 300));
            f(str, list2);
        }
        z = true;
        this.f17991f = str;
        this.f17989d.J();
        this.f17989d.r(str, list, z);
        this.f17989d.t(list2, this.f17988c.O(list2, 300));
        f(str, list2);
    }

    @Override // b.a.r0.i3.d
    public void b(ErrorData errorData) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorData) == null) || (bVar = this.f17989d) == null) {
            return;
        }
        bVar.I();
    }

    @Override // b.a.r0.i3.d
    public void c(String str, ErrorData errorData) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, errorData) == null) || (bVar = this.f17989d) == null || this.f17988c == null) {
            return;
        }
        bVar.J();
        b.a.r0.i3.f.c I = this.f17988c.I(str);
        if (I != null && (!I.f18034d || !ListUtils.isEmpty(I.a()))) {
            this.f17989d.s(I.a());
            f(str, I.a());
            return;
        }
        this.f17989d.f();
        this.f17989d.u();
    }

    public final void f(String str, List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) || this.f17989d == null || this.f17988c == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.f17989d.f();
        } else if (ListUtils.getCount(list) < 10) {
            this.f17989d.n();
        } else {
            this.f17989d.E(this.f17988c.J(str));
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f17989d.b();
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f17991f : (String) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String h2 = h();
            ForumSquareModel forumSquareModel = this.f17988c;
            if (forumSquareModel == null || this.f17989d == null) {
                return;
            }
            boolean K = forumSquareModel.K();
            boolean E = this.f17989d.E(this.f17988c.J(h2));
            if (K || !E) {
                return;
            }
            this.f17988c.L(h2);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b bVar = this.f17989d;
            if (bVar != null) {
                bVar.F();
            }
            ForumSquareModel forumSquareModel = this.f17988c;
            if (forumSquareModel != null) {
                forumSquareModel.L(h());
            }
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            m(this.f17991f);
            this.f17991f = str;
            ForumSquareModel forumSquareModel = this.f17988c;
            if (forumSquareModel == null || this.f17989d == null) {
                return;
            }
            b.a.r0.i3.f.c I = forumSquareModel.I(str);
            if (I != null && (!I.f18034d || !ListUtils.isEmpty(I.a()))) {
                this.f17989d.J();
                f(str, I.a());
                this.f17989d.s(I.a());
                this.f17989d.q(I.f18036f, I.f18037g);
                return;
            }
            this.f17989d.D();
            f(str, null);
            this.f17988c.L(str);
            this.f17989d.q(0, 0);
        }
    }

    public void l(Intent intent) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
        this.f17991f = stringExtra;
        if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            this.f17991f = uri.getQueryParameter("tab_name");
        }
        this.f17989d.C(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
    }

    public void m(String str) {
        b.a.r0.i3.f.c I;
        Pair<Integer, Integer> c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f17989d == null || this.f17988c == null || TextUtils.isEmpty(str) || (I = this.f17988c.I(str)) == null || (c2 = this.f17989d.c()) == null) {
            return;
        }
        I.f18036f = ((Integer) c2.first).intValue();
        I.f18037g = ((Integer) c2.second).intValue();
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f17989d.B(str);
        k(str);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c cVar = new c(this.f17987b, this, this.f17989d);
            this.f17990e = cVar;
            cVar.e();
            p();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f17989d.F();
            this.f17988c.L(this.f17991f);
        }
    }
}
