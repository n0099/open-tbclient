package b.a.r0.h1.e.b;

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
import b.a.e.f.p.l;
import b.a.r0.h1.e.f.a;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f18573a;

    /* renamed from: b  reason: collision with root package name */
    public View f18574b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.h1.e.f.a f18575c;

    /* renamed from: d  reason: collision with root package name */
    public GameVideoGridView f18576d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.h1.e.a.b f18577e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f18578f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f18579g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f18580h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18581i;
    public f j;
    public TranslateAnimation k;
    public TranslateAnimation l;
    public BdUniqueId m;
    public boolean n;
    public Animation.AnimationListener o;
    public AdapterView.OnItemClickListener p;
    public View.OnClickListener q;
    public PopupWindow.OnDismissListener r;
    public a.InterfaceC0949a s;

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f18582a;

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
            this.f18582a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f18582a.n = false;
                this.f18582a.f();
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
                this.f18582a.n = true;
            }
        }
    }

    /* renamed from: b.a.r0.h1.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0946b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18583e;

        public C0946b(b bVar) {
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
            this.f18583e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f18583e.f18577e == null || i2 >= this.f18583e.f18577e.getCount() || this.f18583e.f18577e.getItem(i2) == null || !(this.f18583e.f18577e.getItem(i2) instanceof b.a.r0.h1.e.c.a)) {
                return;
            }
            b.a.r0.h1.e.c.a aVar = (b.a.r0.h1.e.c.a) this.f18583e.f18577e.getItem(i2);
            if (aVar.f18609d == 1) {
                if (this.f18583e.j != null) {
                    this.f18583e.j.a(aVar);
                }
                b.a.q0.s.e0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f18606a);
                b.a.q0.s.e0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f18607b);
                this.f18583e.f();
                TiebaStatic.log(new StatisticItem("c13489").param("obj_type", aVar.f18606a));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18584e;

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
            this.f18584e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18584e.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18585e;

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
            this.f18585e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18585e.j == null) {
                return;
            }
            this.f18585e.j.b();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.InterfaceC0949a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f18586a;

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
            this.f18586a = bVar;
        }

        @Override // b.a.r0.h1.e.f.a.InterfaceC0949a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18586a.o();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(b.a.r0.h1.e.c.a aVar);

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
        this.p = new C0946b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
        this.f18573a = tbPageContext;
        this.m = bdUniqueId;
        g();
    }

    public void e() {
        b.a.r0.h1.e.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f18575c) == null) {
            return;
        }
        aVar.dismiss();
    }

    public void f() {
        b.a.r0.h1.e.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f18575c) == null) {
            return;
        }
        aVar.a();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f18573a.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
            this.f18574b = inflate;
            this.f18578f = (RelativeLayout) inflate.findViewById(R.id.id_game_video_choose_half_wrapper);
            this.f18579g = (RelativeLayout) this.f18574b.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
            this.f18580h = (ImageView) this.f18574b.findViewById(R.id.id_game_video_choose_half_empty_img);
            this.f18581i = (TextView) this.f18574b.findViewById(R.id.id_game_video_choose_half_empty_txt);
            GameVideoGridView gameVideoGridView = (GameVideoGridView) this.f18574b.findViewById(R.id.id_game_video_choose_half_gridview);
            this.f18576d = gameVideoGridView;
            gameVideoGridView.setMaxHeight(l.k(this.f18573a.getPageActivity()));
            this.f18576d.setNumColumns(4);
            this.f18576d.setEmptyView(this.f18579g);
            b.a.r0.h1.e.a.b bVar = new b.a.r0.h1.e.a.b(this.f18573a, 102, this.m);
            this.f18577e = bVar;
            this.f18576d.setAdapter((ListAdapter) bVar);
            this.f18576d.setOnItemClickListener(this.p);
            this.f18574b.setOnClickListener(this.q);
            h();
            j();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
            this.k = translateAnimation;
            translateAnimation.setDuration(300L);
            this.k.setFillAfter(true);
            this.k.setInterpolator(new AccelerateDecelerateInterpolator());
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
            b.a.r0.h1.e.f.a aVar = this.f18575c;
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
            RelativeLayout relativeLayout = this.f18578f;
            if (relativeLayout != null) {
                SkinManager.setBackgroundResource(relativeLayout, R.color.CAM_X0201);
            }
            TextView textView = this.f18581i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            }
            ImageView imageView = this.f18580h;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.new_pic_emotion_08);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            f();
            TranslateAnimation translateAnimation = this.k;
            if (translateAnimation != null) {
                translateAnimation.cancel();
            }
            TranslateAnimation translateAnimation2 = this.l;
            if (translateAnimation2 != null) {
                translateAnimation2.cancel();
            }
            GameVideoGridView gameVideoGridView = this.f18576d;
            if (gameVideoGridView != null) {
                gameVideoGridView.onDestroy();
            }
        }
    }

    public void l(List<b.a.r0.h1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f18577e.b(list);
        }
    }

    public void m(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.j = fVar;
        }
    }

    public void n(View view) {
        TranslateAnimation translateAnimation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || view == null) {
            return;
        }
        this.f18577e.notifyDataSetChanged();
        if (this.f18575c == null) {
            b.a.r0.h1.e.f.a aVar = new b.a.r0.h1.e.f.a(this.f18573a, this.f18574b, -1, -1);
            this.f18575c = aVar;
            aVar.setBackgroundDrawable(new ColorDrawable(this.f18573a.getResources().getColor(R.color.black_alpha66)));
            this.f18575c.setAnimationStyle(0);
            this.f18575c.b(this.s);
            this.f18575c.setFocusable(true);
            this.f18575c.setOnDismissListener(this.r);
        }
        if (this.f18575c.isShowing()) {
            this.f18575c.dismiss();
        }
        this.f18575c.showAsDropDown(view, 0, 0);
        this.f18576d.showAppearAnim();
        RelativeLayout relativeLayout = this.f18578f;
        if (relativeLayout != null && (translateAnimation = this.k) != null) {
            relativeLayout.startAnimation(translateAnimation);
        }
        f fVar = this.j;
        if (fVar != null) {
            fVar.c();
        }
    }

    public final void o() {
        TranslateAnimation translateAnimation;
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (translateAnimation = this.l) == null || (relativeLayout = this.f18578f) == null || this.n) {
            return;
        }
        relativeLayout.startAnimation(translateAnimation);
    }

    public void p(int i2) {
        b.a.r0.h1.e.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (bVar = this.f18577e) == null) {
            return;
        }
        bVar.c(i2);
    }
}
