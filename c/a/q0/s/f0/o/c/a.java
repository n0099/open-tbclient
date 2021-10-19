package c.a.q0.s.f0.o.c;

import android.view.View;
import c.a.e.a.e;
import c.a.e.e.p.j;
import c.a.r0.k3.r0.k;
import c.a.r0.k3.x;
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
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f13870e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f13871f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.f0.o.b f13872g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.s.f0.o.c.b f13873h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f13874i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f13875j;
    public CustomMessageListener k;
    public e l;

    /* renamed from: c.a.q0.s.f0.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0682a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f13876a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0682a(a aVar, int i2) {
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
            this.f13876a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                String l = Long.toString(kVar.f21309a);
                if (this.f13876a.f13873h != null && l.equals(this.f13876a.f13873h.getForumId()) && kVar.f21310b) {
                    this.f13876a.f13873h.setIsLike(true);
                    this.f13876a.f13873h.a(true);
                    this.f13876a.f13872g.updateLikeStatus(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f13877a;

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
            this.f13877a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                String l = Long.toString(kVar.f21309a);
                if (this.f13877a.f13873h != null && l.equals(this.f13877a.f13873h.getForumId()) && kVar.f21310b) {
                    this.f13877a.f13873h.setIsLike(false);
                    this.f13877a.f13873h.a(false);
                    this.f13877a.f13872g.updateLikeStatus(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f13878a;

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
            this.f13878a = aVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof x) && ((x) obj).d() != 0) {
                if (AntiHelper.m(this.f13878a.f13871f.getErrorCode(), this.f13878a.f13871f.getErrorString())) {
                    AntiHelper.u(this.f13878a.f13870e.getPageActivity(), this.f13878a.f13871f.getErrorString());
                } else {
                    this.f13878a.f13870e.showToast(this.f13878a.f13871f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, c.a.q0.s.f0.o.b bVar) {
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
        this.f13875j = new C0682a(this, 2001437);
        this.k = new b(this, 2001438);
        this.l = new c(this);
        this.f13870e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f13871f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f13872g = bVar;
        bVar.bindOnClickListener(this);
        tbPageContext.registerListener(this.f13875j);
        tbPageContext.registerListener(this.k);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f13874i = onClickListener;
        }
    }

    public void f(c.a.q0.s.f0.o.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f13873h = bVar;
        this.f13872g.updateLikeStatus(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f13875j.setTag(bdUniqueId);
            this.k.setTag(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            c.a.q0.s.f0.o.b bVar = this.f13872g;
            if (bVar != null) {
                bVar.onClickEvent(view);
            }
            if (!j.z()) {
                this.f13870e.showToast(R.string.neterror);
                return;
            }
            if (ViewHelper.checkUpIsLogin(this.f13870e.getPageActivity())) {
                c.a.q0.s.f0.o.c.b bVar2 = this.f13873h;
                if (bVar2 == null) {
                    return;
                }
                this.f13871f.L(bVar2.getForumName(), this.f13873h.getForumId());
            }
            View.OnClickListener onClickListener = this.f13874i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }
}
