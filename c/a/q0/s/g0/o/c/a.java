package c.a.q0.s.g0.o.c;

import android.view.View;
import c.a.d.a.e;
import c.a.d.f.p.j;
import c.a.r0.t3.s0.k;
import c.a.r0.t3.x;
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
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f12660e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f12661f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.g0.o.b f12662g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.s.g0.o.c.b f12663h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f12664i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f12665j;

    /* renamed from: k  reason: collision with root package name */
    public CustomMessageListener f12666k;
    public e l;

    /* renamed from: c.a.q0.s.g0.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0797a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0797a(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                String l = Long.toString(kVar.a);
                if (this.a.f12663h != null && l.equals(this.a.f12663h.getForumId()) && kVar.f24044b) {
                    this.a.f12663h.setIsLike(true);
                    this.a.f12663h.a(true);
                    this.a.f12662g.updateLikeStatus(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                String l = Long.toString(kVar.a);
                if (this.a.f12663h != null && l.equals(this.a.f12663h.getForumId()) && kVar.f24044b) {
                    this.a.f12663h.setIsLike(false);
                    this.a.f12663h.a(false);
                    this.a.f12662g.updateLikeStatus(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof x) && ((x) obj).d() != 0) {
                if (AntiHelper.m(this.a.f12661f.getErrorCode(), this.a.f12661f.getErrorString())) {
                    AntiHelper.u(this.a.f12660e.getPageActivity(), this.a.f12661f.getErrorString());
                } else {
                    this.a.f12660e.showToast(this.a.f12661f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, c.a.q0.s.g0.o.b bVar) {
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
        this.f12665j = new C0797a(this, 2001437);
        this.f12666k = new b(this, 2001438);
        this.l = new c(this);
        this.f12660e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f12661f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f12662g = bVar;
        bVar.bindOnClickListener(this);
        tbPageContext.registerListener(this.f12665j);
        tbPageContext.registerListener(this.f12666k);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f12664i = onClickListener;
        }
    }

    public void f(c.a.q0.s.g0.o.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f12663h = bVar;
        this.f12662g.updateLikeStatus(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f12665j.setTag(bdUniqueId);
            this.f12666k.setTag(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            c.a.q0.s.g0.o.b bVar = this.f12662g;
            if (bVar != null) {
                bVar.onClickEvent(view);
            }
            if (!j.z()) {
                this.f12660e.showToast(R.string.neterror);
                return;
            }
            if (ViewHelper.checkUpIsLogin(this.f12660e.getPageActivity())) {
                c.a.q0.s.g0.o.c.b bVar2 = this.f12663h;
                if (bVar2 == null) {
                    return;
                }
                this.f12661f.L(bVar2.getForumName(), this.f12663h.getForumId());
            }
            View.OnClickListener onClickListener = this.f12664i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }
}
