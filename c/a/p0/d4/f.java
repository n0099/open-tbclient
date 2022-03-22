package c.a.p0.d4;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import c.a.d.f.m.g;
import c.a.p0.a4.i0;
import c.a.p0.a4.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class f implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewUserGuideActivity a;

    /* renamed from: b  reason: collision with root package name */
    public InterestFrsData.Tag f13702b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.d4.a f13703c;

    /* renamed from: d  reason: collision with root package name */
    public LikeModel f13704d;

    /* renamed from: e  reason: collision with root package name */
    public i0 f13705e;

    /* loaded from: classes2.dex */
    public class a extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj == null) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c15);
                } else if (obj instanceof y) {
                    int e2 = c.a.d.f.m.b.e(((y) obj).g(), 0);
                    this.a.f13703c.b(e2);
                    this.a.c(e2, true);
                    this.a.a.setHasLike(true);
                    this.a.a.setIsChanged(true);
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements i0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.p0.a4.i0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f056e);
            }
        }

        @Override // c.a.p0.a4.i0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                int e2 = c.a.d.f.m.b.e(String.valueOf(j), 0);
                this.a.f13703c.a(e2);
                this.a.c(e2, false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewUserGuideMainFragment.b a;

        public c(f fVar, NewUserGuideMainFragment.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.a();
            }
        }
    }

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, NewUserGuideMainFragment.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newUserGuideActivity, tag, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = newUserGuideActivity;
        this.f13702b = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.f13703c = new e(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f100138);
        } else if (btype == 2) {
            this.f13703c = new c.a.p0.d4.b(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f100138);
        } else if (btype == 3) {
            this.f13703c = new d(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f100138);
        }
        LikeModel likeModel = new LikeModel(newUserGuideActivity.getPageContext());
        this.f13704d = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
        i0 i0Var = new i0();
        this.f13705e = i0Var;
        i0Var.b(new b(this));
        this.f13703c.setOnClickListener(this);
        this.f13703c.c(this.f13702b);
        ((Dialog) this.f13703c).setOnDismissListener(new c(this, bVar));
    }

    public void c(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            for (int i2 = 0; i2 < this.f13702b.getCard_list().size(); i2++) {
                if (this.f13702b.getCard_list().get(i2).getFid() == i) {
                    this.f13702b.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                    return;
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NewUserGuideActivity newUserGuideActivity = this.a;
            if (newUserGuideActivity == null || g.e(newUserGuideActivity.getPageContext().getPageActivity())) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
                scaleAnimation.setDuration(350L);
                this.f13703c.getRootView().setAnimation(scaleAnimation);
                this.f13703c.show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view.getId() == R.id.obfuscated_res_0x7f0903e5) {
                this.f13703c.hide();
            } else if ((view.getId() == R.id.obfuscated_res_0x7f0912fc || view.getId() == R.id.obfuscated_res_0x7f091834) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
                InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
                if (card.getIs_like() == 1) {
                    this.f13705e.c(card.getFname(), card.getFid());
                } else {
                    this.f13704d.Q(card.getFname(), String.valueOf(card.getFid()), "newuser");
                }
            }
        }
    }
}
