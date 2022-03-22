package c.a.o0.r.l0.o.c;

import android.view.View;
import c.a.d.a.e;
import c.a.d.f.p.l;
import c.a.p0.a4.t0.f;
import c.a.p0.a4.y;
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
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public LikeModel f10645b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.r.l0.o.b f10646c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.r.l0.o.c.b f10647d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f10648e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f10649f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f10650g;

    /* renamed from: h  reason: collision with root package name */
    public e f10651h;

    /* renamed from: c.a.o0.r.l0.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0829a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0829a(a aVar, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f)) {
                f fVar = (f) customResponsedMessage.getData();
                String l = Long.toString(fVar.a);
                if (this.a.f10647d != null && l.equals(this.a.f10647d.c()) && fVar.f12402b) {
                    this.a.f10647d.setIsLike(true);
                    this.a.f10647d.d(true);
                    this.a.f10646c.c(true);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f)) {
                f fVar = (f) customResponsedMessage.getData();
                String l = Long.toString(fVar.a);
                if (this.a.f10647d != null && l.equals(this.a.f10647d.c()) && fVar.f12402b) {
                    this.a.f10647d.setIsLike(false);
                    this.a.f10647d.d(false);
                    this.a.f10646c.c(false);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (AntiHelper.m(this.a.f10645b.getErrorCode(), this.a.f10645b.getErrorString())) {
                    AntiHelper.u(this.a.a.getPageActivity(), this.a.f10645b.getErrorString());
                } else {
                    this.a.a.showToast(this.a.f10645b.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, c.a.o0.r.l0.o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10649f = new C0829a(this, 2001437);
        this.f10650g = new b(this, 2001438);
        this.f10651h = new c(this);
        this.a = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f10645b = likeModel;
        likeModel.setLoadDataCallBack(this.f10651h);
        this.f10646c = bVar;
        bVar.b(this);
        tbPageContext.registerListener(this.f10649f);
        tbPageContext.registerListener(this.f10650g);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f10648e = onClickListener;
        }
    }

    public void f(c.a.o0.r.l0.o.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f10647d = bVar;
        this.f10646c.c(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f10649f.setTag(bdUniqueId);
            this.f10650g.setTag(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            c.a.o0.r.l0.o.b bVar = this.f10646c;
            if (bVar != null) {
                bVar.a(view);
            }
            if (!l.z()) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c15);
                return;
            }
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                c.a.o0.r.l0.o.c.b bVar2 = this.f10647d;
                if (bVar2 == null) {
                    return;
                }
                this.f10645b.P(bVar2.a(), this.f10647d.c());
            }
            View.OnClickListener onClickListener = this.f10648e;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }
}
