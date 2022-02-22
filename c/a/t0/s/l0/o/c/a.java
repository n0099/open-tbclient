package c.a.t0.s.l0.o.c;

import android.view.View;
import c.a.d.a.e;
import c.a.d.f.p.l;
import c.a.u0.a4.j;
import c.a.u0.z3.t0.f;
import c.a.u0.z3.y;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f13580e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f13581f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.s.l0.o.b f13582g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.s.l0.o.c.b f13583h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f13584i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f13585j;
    public CustomMessageListener k;
    public e l;

    /* renamed from: c.a.t0.s.l0.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0890a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0890a(a aVar, int i2) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f)) {
                f fVar = (f) customResponsedMessage.getData();
                String l = Long.toString(fVar.a);
                if (this.a.f13583h != null && l.equals(this.a.f13583h.getForumId()) && fVar.f26402b) {
                    this.a.f13583h.setIsLike(true);
                    this.a.f13583h.a(true);
                    this.a.f13582g.updateLikeStatus(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f)) {
                f fVar = (f) customResponsedMessage.getData();
                String l = Long.toString(fVar.a);
                if (this.a.f13583h != null && l.equals(this.a.f13583h.getForumId()) && fVar.f26402b) {
                    this.a.f13583h.setIsLike(false);
                    this.a.f13583h.a(false);
                    this.a.f13582g.updateLikeStatus(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof y) && ((y) obj).d() != 0) {
                if (AntiHelper.m(this.a.f13581f.getErrorCode(), this.a.f13581f.getErrorString())) {
                    AntiHelper.u(this.a.f13580e.getPageActivity(), this.a.f13581f.getErrorString());
                } else {
                    this.a.f13580e.showToast(this.a.f13581f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, c.a.t0.s.l0.o.b bVar) {
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
        this.f13585j = new C0890a(this, 2001437);
        this.k = new b(this, 2001438);
        this.l = new c(this);
        this.f13580e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f13581f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f13582g = bVar;
        bVar.bindOnClickListener(this);
        tbPageContext.registerListener(this.f13585j);
        tbPageContext.registerListener(this.k);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f13584i = onClickListener;
        }
    }

    public void f(c.a.t0.s.l0.o.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f13583h = bVar;
        this.f13582g.updateLikeStatus(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f13585j.setTag(bdUniqueId);
            this.k.setTag(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            c.a.t0.s.l0.o.b bVar = this.f13582g;
            if (bVar != null) {
                bVar.onClickEvent(view);
            }
            if (!l.z()) {
                this.f13580e.showToast(j.neterror);
                return;
            }
            if (ViewHelper.checkUpIsLogin(this.f13580e.getPageActivity())) {
                c.a.t0.s.l0.o.c.b bVar2 = this.f13583h;
                if (bVar2 == null) {
                    return;
                }
                this.f13581f.N(bVar2.getForumName(), this.f13583h.getForumId());
            }
            View.OnClickListener onClickListener = this.f13584i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }
}
