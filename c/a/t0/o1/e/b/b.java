package c.a.t0.o1.e.b;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.o1.e.f.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f20844b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.o1.e.f.a f20845c;

    /* renamed from: d  reason: collision with root package name */
    public GameVideoGridView f20846d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.o1.e.a.b f20847e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f20848f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f20849g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f20850h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f20851i;

    /* renamed from: j  reason: collision with root package name */
    public f f20852j;

    /* renamed from: k  reason: collision with root package name */
    public TranslateAnimation f20853k;
    public TranslateAnimation l;
    public BdUniqueId m;
    public boolean n;
    public Animation.AnimationListener o;
    public AdapterView.OnItemClickListener p;
    public View.OnClickListener q;
    public PopupWindow.OnDismissListener r;
    public a.InterfaceC1262a s;

    /* loaded from: classes7.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.n = false;
                this.a.f();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                this.a.n = true;
            }
        }
    }

    /* renamed from: c.a.t0.o1.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1259b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20854e;

        public C1259b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20854e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f20854e.f20847e == null || i2 >= this.f20854e.f20847e.getCount() || this.f20854e.f20847e.getItem(i2) == null || !(this.f20854e.f20847e.getItem(i2) instanceof c.a.t0.o1.e.c.a)) {
                return;
            }
            c.a.t0.o1.e.c.a aVar = (c.a.t0.o1.e.c.a) this.f20854e.f20847e.getItem(i2);
            if (aVar.f20874d == 1) {
                if (this.f20854e.f20852j != null) {
                    this.f20854e.f20852j.a(aVar);
                }
                c.a.s0.s.g0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.a);
                c.a.s0.s.g0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f20872b);
                this.f20854e.f();
                TiebaStatic.log(new StatisticItem("c13489").param("obj_type", aVar.a));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20855e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20855e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20855e.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20856e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20856e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20856e.f20852j == null) {
                return;
            }
            this.f20856e.f20852j.b();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.InterfaceC1262a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.t0.o1.e.f.a.InterfaceC1262a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a(c.a.t0.o1.e.c.a aVar);

        void b();

        void c();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = false;
        this.o = new a(this);
        this.p = new C1259b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
        this.a = tbPageContext;
        this.m = bdUniqueId;
        g();
    }

    public void e() {
        c.a.t0.o1.e.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f20845c) == null) {
            return;
        }
        aVar.dismiss();
    }

    public void f() {
        c.a.t0.o1.e.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f20845c) == null) {
            return;
        }
        aVar.a();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
            this.f20844b = inflate;
            this.f20848f = (RelativeLayout) inflate.findViewById(R.id.id_game_video_choose_half_wrapper);
            this.f20849g = (RelativeLayout) this.f20844b.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
            this.f20850h = (ImageView) this.f20844b.findViewById(R.id.id_game_video_choose_half_empty_img);
            this.f20851i = (TextView) this.f20844b.findViewById(R.id.id_game_video_choose_half_empty_txt);
            GameVideoGridView gameVideoGridView = (GameVideoGridView) this.f20844b.findViewById(R.id.id_game_video_choose_half_gridview);
            this.f20846d = gameVideoGridView;
            gameVideoGridView.setMaxHeight(n.k(this.a.getPageActivity()));
            this.f20846d.setNumColumns(4);
            this.f20846d.setEmptyView(this.f20849g);
            c.a.t0.o1.e.a.b bVar = new c.a.t0.o1.e.a.b(this.a, 102, this.m);
            this.f20847e = bVar;
            this.f20846d.setAdapter((ListAdapter) bVar);
            this.f20846d.setOnItemClickListener(this.p);
            this.f20844b.setOnClickListener(this.q);
            h();
            j();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
            this.f20853k = translateAnimation;
            translateAnimation.setDuration(300L);
            this.f20853k.setFillAfter(true);
            this.f20853k.setInterpolator(new AccelerateDecelerateInterpolator());
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            this.l = translateAnimation2;
            translateAnimation2.setDuration(200L);
            this.l.setFillAfter(true);
            this.l.setInterpolator(new AccelerateDecelerateInterpolator());
            this.l.setAnimationListener(this.o);
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.t0.o1.e.f.a aVar = this.f20845c;
            if (aVar != null) {
                return aVar.isShowing();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RelativeLayout relativeLayout = this.f20848f;
            if (relativeLayout != null) {
                SkinManager.setBackgroundResource(relativeLayout, R.color.CAM_X0201);
            }
            TextView textView = this.f20851i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            }
            ImageView imageView = this.f20850h;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.new_pic_emotion_08);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            f();
            TranslateAnimation translateAnimation = this.f20853k;
            if (translateAnimation != null) {
                translateAnimation.cancel();
            }
            TranslateAnimation translateAnimation2 = this.l;
            if (translateAnimation2 != null) {
                translateAnimation2.cancel();
            }
            GameVideoGridView gameVideoGridView = this.f20846d;
            if (gameVideoGridView != null) {
                gameVideoGridView.onDestroy();
            }
        }
    }

    public void l(List<c.a.t0.o1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f20847e.b(list);
        }
    }

    public void m(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.f20852j = fVar;
        }
    }

    public void n(View view) {
        TranslateAnimation translateAnimation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || view == null) {
            return;
        }
        this.f20847e.notifyDataSetChanged();
        if (this.f20845c == null) {
            c.a.t0.o1.e.f.a aVar = new c.a.t0.o1.e.f.a(this.a, this.f20844b, -1, -1);
            this.f20845c = aVar;
            aVar.setBackgroundDrawable(new ColorDrawable(this.a.getResources().getColor(R.color.black_alpha66)));
            this.f20845c.setAnimationStyle(0);
            this.f20845c.b(this.s);
            this.f20845c.setFocusable(true);
            this.f20845c.setOnDismissListener(this.r);
        }
        if (this.f20845c.isShowing()) {
            this.f20845c.dismiss();
        }
        this.f20845c.showAsDropDown(view, 0, 0);
        this.f20846d.showAppearAnim();
        RelativeLayout relativeLayout = this.f20848f;
        if (relativeLayout != null && (translateAnimation = this.f20853k) != null) {
            relativeLayout.startAnimation(translateAnimation);
        }
        f fVar = this.f20852j;
        if (fVar != null) {
            fVar.c();
        }
    }

    public final void o() {
        TranslateAnimation translateAnimation;
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (translateAnimation = this.l) == null || (relativeLayout = this.f20848f) == null || this.n) {
            return;
        }
        relativeLayout.startAnimation(translateAnimation);
    }

    public void p(int i2) {
        c.a.t0.o1.e.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (bVar = this.f20847e) == null) {
            return;
        }
        bVar.c(i2);
    }
}
