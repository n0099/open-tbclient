package c.a.p0.s.f0.o.c;

import android.view.View;
import c.a.e.a.e;
import c.a.e.e.p.j;
import c.a.q0.i3.r0.k;
import c.a.q0.i3.w;
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
    public TbPageContext f13899e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f13900f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.s.f0.o.b f13901g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.s.f0.o.c.b f13902h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f13903i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f13904j;
    public CustomMessageListener k;
    public e l;

    /* renamed from: c.a.p0.s.f0.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0682a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f13905a;

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
            this.f13905a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                String l = Long.toString(kVar.f20549a);
                if (this.f13905a.f13902h != null && l.equals(this.f13905a.f13902h.getForumId()) && kVar.f20550b) {
                    this.f13905a.f13902h.setIsLike(true);
                    this.f13905a.f13902h.a(true);
                    this.f13905a.f13901g.updateLikeStatus(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f13906a;

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
            this.f13906a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                String l = Long.toString(kVar.f20549a);
                if (this.f13906a.f13902h != null && l.equals(this.f13906a.f13902h.getForumId()) && kVar.f20550b) {
                    this.f13906a.f13902h.setIsLike(false);
                    this.f13906a.f13902h.a(false);
                    this.f13906a.f13901g.updateLikeStatus(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f13907a;

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
            this.f13907a = aVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof w) && ((w) obj).d() != 0) {
                if (AntiHelper.m(this.f13907a.f13900f.getErrorCode(), this.f13907a.f13900f.getErrorString())) {
                    AntiHelper.u(this.f13907a.f13899e.getPageActivity(), this.f13907a.f13900f.getErrorString());
                } else {
                    this.f13907a.f13899e.showToast(this.f13907a.f13900f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, c.a.p0.s.f0.o.b bVar) {
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
        this.f13904j = new C0682a(this, 2001437);
        this.k = new b(this, 2001438);
        this.l = new c(this);
        this.f13899e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f13900f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f13901g = bVar;
        bVar.bindOnClickListener(this);
        tbPageContext.registerListener(this.f13904j);
        tbPageContext.registerListener(this.k);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f13903i = onClickListener;
        }
    }

    public void f(c.a.p0.s.f0.o.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f13902h = bVar;
        this.f13901g.updateLikeStatus(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f13904j.setTag(bdUniqueId);
            this.k.setTag(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            c.a.p0.s.f0.o.b bVar = this.f13901g;
            if (bVar != null) {
                bVar.onClickEvent(view);
            }
            if (!j.z()) {
                this.f13899e.showToast(R.string.neterror);
                return;
            }
            if (ViewHelper.checkUpIsLogin(this.f13899e.getPageActivity())) {
                c.a.p0.s.f0.o.c.b bVar2 = this.f13902h;
                if (bVar2 == null) {
                    return;
                }
                this.f13900f.L(bVar2.getForumName(), this.f13902h.getForumId());
            }
            View.OnClickListener onClickListener = this.f13903i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }
}
