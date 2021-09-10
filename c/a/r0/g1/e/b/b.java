package c.a.r0.g1.e.b;

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
import c.a.e.e.p.l;
import c.a.r0.g1.e.f.a;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17983a;

    /* renamed from: b  reason: collision with root package name */
    public View f17984b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.g1.e.f.a f17985c;

    /* renamed from: d  reason: collision with root package name */
    public GameVideoGridView f17986d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.g1.e.a.b f17987e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f17988f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f17989g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f17990h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17991i;

    /* renamed from: j  reason: collision with root package name */
    public f f17992j;
    public TranslateAnimation k;
    public TranslateAnimation l;
    public BdUniqueId m;
    public boolean n;
    public Animation.AnimationListener o;
    public AdapterView.OnItemClickListener p;
    public View.OnClickListener q;
    public PopupWindow.OnDismissListener r;
    public a.InterfaceC0879a s;

    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17993a;

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
            this.f17993a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f17993a.n = false;
                this.f17993a.f();
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
                this.f17993a.n = true;
            }
        }
    }

    /* renamed from: c.a.r0.g1.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0876b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17994e;

        public C0876b(b bVar) {
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
            this.f17994e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f17994e.f17987e == null || i2 >= this.f17994e.f17987e.getCount() || this.f17994e.f17987e.getItem(i2) == null || !(this.f17994e.f17987e.getItem(i2) instanceof c.a.r0.g1.e.c.a)) {
                return;
            }
            c.a.r0.g1.e.c.a aVar = (c.a.r0.g1.e.c.a) this.f17994e.f17987e.getItem(i2);
            if (aVar.f18021d == 1) {
                if (this.f17994e.f17992j != null) {
                    this.f17994e.f17992j.a(aVar);
                }
                c.a.q0.s.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f18018a);
                c.a.q0.s.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f18019b);
                this.f17994e.f();
                TiebaStatic.log(new StatisticItem("c13489").param("obj_type", aVar.f18018a));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17995e;

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
            this.f17995e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17995e.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17996e;

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
            this.f17996e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17996e.f17992j == null) {
                return;
            }
            this.f17996e.f17992j.b();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.InterfaceC0879a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17997a;

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
            this.f17997a = bVar;
        }

        @Override // c.a.r0.g1.e.f.a.InterfaceC0879a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17997a.o();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(c.a.r0.g1.e.c.a aVar);

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
        this.p = new C0876b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
        this.f17983a = tbPageContext;
        this.m = bdUniqueId;
        g();
    }

    public void e() {
        c.a.r0.g1.e.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f17985c) == null) {
            return;
        }
        aVar.dismiss();
    }

    public void f() {
        c.a.r0.g1.e.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f17985c) == null) {
            return;
        }
        aVar.a();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f17983a.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
            this.f17984b = inflate;
            this.f17988f = (RelativeLayout) inflate.findViewById(R.id.id_game_video_choose_half_wrapper);
            this.f17989g = (RelativeLayout) this.f17984b.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
            this.f17990h = (ImageView) this.f17984b.findViewById(R.id.id_game_video_choose_half_empty_img);
            this.f17991i = (TextView) this.f17984b.findViewById(R.id.id_game_video_choose_half_empty_txt);
            GameVideoGridView gameVideoGridView = (GameVideoGridView) this.f17984b.findViewById(R.id.id_game_video_choose_half_gridview);
            this.f17986d = gameVideoGridView;
            gameVideoGridView.setMaxHeight(l.k(this.f17983a.getPageActivity()));
            this.f17986d.setNumColumns(4);
            this.f17986d.setEmptyView(this.f17989g);
            c.a.r0.g1.e.a.b bVar = new c.a.r0.g1.e.a.b(this.f17983a, 102, this.m);
            this.f17987e = bVar;
            this.f17986d.setAdapter((ListAdapter) bVar);
            this.f17986d.setOnItemClickListener(this.p);
            this.f17984b.setOnClickListener(this.q);
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
            c.a.r0.g1.e.f.a aVar = this.f17985c;
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
            RelativeLayout relativeLayout = this.f17988f;
            if (relativeLayout != null) {
                SkinManager.setBackgroundResource(relativeLayout, R.color.CAM_X0201);
            }
            TextView textView = this.f17991i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            }
            ImageView imageView = this.f17990h;
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
            GameVideoGridView gameVideoGridView = this.f17986d;
            if (gameVideoGridView != null) {
                gameVideoGridView.onDestroy();
            }
        }
    }

    public void l(List<c.a.r0.g1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f17987e.b(list);
        }
    }

    public void m(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.f17992j = fVar;
        }
    }

    public void n(View view) {
        TranslateAnimation translateAnimation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || view == null) {
            return;
        }
        this.f17987e.notifyDataSetChanged();
        if (this.f17985c == null) {
            c.a.r0.g1.e.f.a aVar = new c.a.r0.g1.e.f.a(this.f17983a, this.f17984b, -1, -1);
            this.f17985c = aVar;
            aVar.setBackgroundDrawable(new ColorDrawable(this.f17983a.getResources().getColor(R.color.black_alpha66)));
            this.f17985c.setAnimationStyle(0);
            this.f17985c.b(this.s);
            this.f17985c.setFocusable(true);
            this.f17985c.setOnDismissListener(this.r);
        }
        if (this.f17985c.isShowing()) {
            this.f17985c.dismiss();
        }
        this.f17985c.showAsDropDown(view, 0, 0);
        this.f17986d.showAppearAnim();
        RelativeLayout relativeLayout = this.f17988f;
        if (relativeLayout != null && (translateAnimation = this.k) != null) {
            relativeLayout.startAnimation(translateAnimation);
        }
        f fVar = this.f17992j;
        if (fVar != null) {
            fVar.c();
        }
    }

    public final void o() {
        TranslateAnimation translateAnimation;
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (translateAnimation = this.l) == null || (relativeLayout = this.f17988f) == null || this.n) {
            return;
        }
        relativeLayout.startAnimation(translateAnimation);
    }

    public void p(int i2) {
        c.a.r0.g1.e.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (bVar = this.f17987e) == null) {
            return;
        }
        bVar.c(i2);
    }
}
