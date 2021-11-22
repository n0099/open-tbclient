package b.a.q0.s.g0.o.c;

import android.view.View;
import b.a.e.a.e;
import b.a.e.f.p.j;
import b.a.r0.m3.s0.k;
import b.a.r0.m3.x;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f13775e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f13776f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.s.g0.o.b f13777g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.s.g0.o.c.b f13778h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f13779i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public e l;

    /* renamed from: b.a.q0.s.g0.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0713a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f13780a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0713a(a aVar, int i2) {
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
            this.f13780a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                String l = Long.toString(kVar.f22724a);
                if (this.f13780a.f13778h != null && l.equals(this.f13780a.f13778h.getForumId()) && kVar.f22725b) {
                    this.f13780a.f13778h.setIsLike(true);
                    this.f13780a.f13778h.a(true);
                    this.f13780a.f13777g.updateLikeStatus(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f13781a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
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
            this.f13781a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                String l = Long.toString(kVar.f22724a);
                if (this.f13781a.f13778h != null && l.equals(this.f13781a.f13778h.getForumId()) && kVar.f22725b) {
                    this.f13781a.f13778h.setIsLike(false);
                    this.f13781a.f13778h.a(false);
                    this.f13781a.f13777g.updateLikeStatus(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f13782a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13782a = aVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof x) && ((x) obj).d() != 0) {
                if (AntiHelper.m(this.f13782a.f13776f.getErrorCode(), this.f13782a.f13776f.getErrorString())) {
                    AntiHelper.u(this.f13782a.f13775e.getPageActivity(), this.f13782a.f13776f.getErrorString());
                } else {
                    this.f13782a.f13775e.showToast(this.f13782a.f13776f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, b.a.q0.s.g0.o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new C0713a(this, 2001437);
        this.k = new b(this, 2001438);
        this.l = new c(this);
        this.f13775e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f13776f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f13777g = bVar;
        bVar.bindOnClickListener(this);
        tbPageContext.registerListener(this.j);
        tbPageContext.registerListener(this.k);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f13779i = onClickListener;
        }
    }

    public void f(b.a.q0.s.g0.o.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f13778h = bVar;
        this.f13777g.updateLikeStatus(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.j.setTag(bdUniqueId);
            this.k.setTag(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            b.a.q0.s.g0.o.b bVar = this.f13777g;
            if (bVar != null) {
                bVar.onClickEvent(view);
            }
            if (!j.z()) {
                this.f13775e.showToast(R.string.neterror);
                return;
            }
            if (ViewHelper.checkUpIsLogin(this.f13775e.getPageActivity())) {
                b.a.q0.s.g0.o.c.b bVar2 = this.f13778h;
                if (bVar2 == null) {
                    return;
                }
                this.f13776f.L(bVar2.getForumName(), this.f13778h.getForumId());
            }
            View.OnClickListener onClickListener = this.f13779i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }
}
