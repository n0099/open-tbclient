package c.a.t0.n2.h.f;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener, c.a.t0.y0.x.d.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f20249e;

    /* renamed from: f  reason: collision with root package name */
    public View f20250f;

    /* renamed from: g  reason: collision with root package name */
    public View f20251g;

    /* renamed from: h  reason: collision with root package name */
    public View f20252h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f20253i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f20254j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f20255k;
    public TextView l;
    public Animation m;
    public TbPageContext n;
    public int o;
    public c.a.t0.y0.x.d.a p;

    /* renamed from: c.a.t0.n2.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1220a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20256e;

        /* renamed from: c.a.t0.n2.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1221a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f20257e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC1220a f20258f;

            public RunnableC1221a(RunnableC1220a runnableC1220a, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1220a, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20258f = runnableC1220a;
                this.f20257e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f20257e >= 30) {
                        n.M(this.f20258f.f20256e.n.getPageActivity(), String.format(this.f20258f.f20256e.n.getString(R.string.emotion_create_tip), 30));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f20258f.f20256e.n.getPageActivity(), true, 25021)));
                    }
                }
            }
        }

        public RunnableC1220a(a aVar) {
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
            this.f20256e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f2 = c.a.t0.n2.c.i().f();
                c.a.d.f.m.e.a().post(new RunnableC1221a(this, f2 == null ? 0 : f2.size()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20259e;

        /* renamed from: c.a.t0.n2.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1222a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f20260e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f20261f;

            public RunnableC1222a(b bVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20261f = bVar;
                this.f20260e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f20260e >= 30) {
                        n.M(this.f20261f.f20259e.n.getPageActivity(), String.format(this.f20261f.f20259e.n.getString(R.string.emotion_create_tip), 30));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f20261f.f20259e.n.getPageActivity(), 25021)));
                    }
                }
            }
        }

        public b(a aVar) {
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
            this.f20259e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f2 = c.a.t0.n2.c.i().f();
                c.a.d.f.m.e.a().post(new RunnableC1222a(this, f2 == null ? 0 : f2.size()));
            }
        }
    }

    public a(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = null;
        this.n = tbPageContext;
        this.o = i2;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_native_manager_create_layout, (ViewGroup) null);
        this.f20251g = inflate;
        this.f20249e = inflate.findViewById(R.id.emotion_manager_add_layout);
        View findViewById = this.f20251g.findViewById(R.id.emotion_manager_create);
        this.f20250f = findViewById;
        findViewById.setOnClickListener(this);
        this.f20249e.setVisibility(0);
        View findViewById2 = this.f20251g.findViewById(R.id.emotion_manager_upload_status);
        this.f20252h = findViewById2;
        findViewById2.setClickable(false);
        this.f20252h.setOnClickListener(this);
        this.f20252h.setVisibility(8);
        this.f20253i = (ImageView) this.f20251g.findViewById(R.id.uploading_status_img);
        this.f20254j = (ImageView) this.f20251g.findViewById(R.id.icon_add);
        this.f20255k = (TextView) this.f20251g.findViewById(R.id.add_emotion_tv);
        this.l = (TextView) this.f20251g.findViewById(R.id.add_emotion_manager_upload_status);
    }

    @Override // c.a.t0.y0.x.d.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.t0.n2.a.b().a(new b(this));
        }
    }

    @Override // c.a.t0.y0.x.d.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.t0.n2.a.b().a(new RunnableC1220a(this));
        }
    }

    public void d() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (imageView = this.f20253i) == null) {
            return;
        }
        imageView.clearAnimation();
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.m == null) {
                this.m = AnimationUtils.loadAnimation(this.n.getPageActivity(), R.anim.refresh_rotate);
                this.m.setInterpolator(new LinearInterpolator());
                this.m.setFillAfter(true);
            }
            return this.m;
        }
        return (Animation) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20251g : (View) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            View view = this.f20249e;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i2);
            }
            TextView textView = this.l;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i2);
            }
            ImageView imageView = this.f20254j;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
            }
            TextView textView2 = this.f20255k;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, i2);
            }
            View view2 = this.f20252h;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.cp_bg_line_d_alpha90, i2);
            }
            ImageView imageView2 = this.f20253i;
            if (imageView2 != null) {
                SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
            }
        }
    }

    public void h() {
        c.a.t0.y0.x.d.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (aVar = this.p) != null && aVar.isShowing()) {
            this.p.dismiss();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.t0.y0.x.d.a aVar = this.p;
            if (aVar != null) {
                aVar.dismiss();
            }
            d();
            this.f20252h.setVisibility(8);
            this.f20249e.setVisibility(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.t0.y0.x.d.a aVar = this.p;
            if (aVar != null) {
                aVar.dismiss();
            }
            k();
            this.f20252h.setVisibility(0);
            this.f20249e.setVisibility(8);
            SkinManager.setBackgroundColor(this.f20252h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.f20253i, R.drawable.emotion_uploading_bar_refresh);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0302);
            this.l.setText(R.string.emotion_uploading);
            this.f20252h.setClickable(false);
        }
    }

    public void k() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (imageView = this.f20253i) == null) {
            return;
        }
        imageView.startAnimation(e());
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            FaceGroupDraft k2 = c.a.t0.n2.g.e.l().k();
            if (k2 != null && TextUtils.isEmpty(k2.getFailMsg())) {
                n.M(this.n.getPageActivity(), k2.getFailMsg());
            }
            m(null);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            c.a.t0.y0.x.d.a aVar = this.p;
            if (aVar != null) {
                aVar.dismiss();
            }
            d();
            this.f20252h.setVisibility(0);
            this.f20249e.setVisibility(8);
            SkinManager.setBackgroundColor(this.f20252h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.f20253i, R.drawable.emotion_update_fail);
            SkinManager.setViewTextColor(this.l, R.color.common_color_10037);
            if (!TextUtils.isEmpty(str)) {
                this.l.setText(str);
            } else {
                this.l.setText(R.string.emotion_center_upload_failed);
            }
            this.f20252h.setClickable(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            if (this.f20250f != null && view.getId() == this.f20250f.getId() && this.f20250f.isShown()) {
                if (this.o == 1) {
                    if (this.p == null) {
                        c.a.t0.y0.x.d.a aVar = new c.a.t0.y0.x.d.a(this.n.getPageActivity(), this.o);
                        this.p = aVar;
                        aVar.d(this);
                    }
                    this.p.c(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.n.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.p.showAtLocation(this.f20251g, 81, 0, this.n.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                } else {
                    a();
                }
            }
            if (this.f20252h != null && view.getId() == this.f20252h.getId() && this.f20252h.isShown()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.n.getPageActivity(), this.o == 1, 25021)));
            }
        }
    }

    public void update(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
        }
    }
}
