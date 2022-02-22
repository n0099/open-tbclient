package c.a.u0.p2.h.f;

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
/* loaded from: classes8.dex */
public class a implements View.OnClickListener, c.a.u0.z0.x.d.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f21124e;

    /* renamed from: f  reason: collision with root package name */
    public View f21125f;

    /* renamed from: g  reason: collision with root package name */
    public View f21126g;

    /* renamed from: h  reason: collision with root package name */
    public View f21127h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f21128i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f21129j;
    public TextView k;
    public TextView l;
    public Animation m;
    public TbPageContext n;
    public int o;
    public c.a.u0.z0.x.d.a p;

    /* renamed from: c.a.u0.p2.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1300a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21130e;

        /* renamed from: c.a.u0.p2.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1301a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f21131e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC1300a f21132f;

            public RunnableC1301a(RunnableC1300a runnableC1300a, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1300a, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21132f = runnableC1300a;
                this.f21131e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f21131e >= 30) {
                        n.N(this.f21132f.f21130e.n.getPageActivity(), String.format(this.f21132f.f21130e.n.getString(R.string.emotion_create_tip), 30));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f21132f.f21130e.n.getPageActivity(), true, 25021)));
                    }
                }
            }
        }

        public RunnableC1300a(a aVar) {
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
            this.f21130e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f2 = c.a.u0.p2.c.i().f();
                c.a.d.f.m.e.a().post(new RunnableC1301a(this, f2 == null ? 0 : f2.size()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21133e;

        /* renamed from: c.a.u0.p2.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1302a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f21134e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f21135f;

            public RunnableC1302a(b bVar, int i2) {
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
                this.f21135f = bVar;
                this.f21134e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f21134e >= 30) {
                        n.N(this.f21135f.f21133e.n.getPageActivity(), String.format(this.f21135f.f21133e.n.getString(R.string.emotion_create_tip), 30));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f21135f.f21133e.n.getPageActivity(), 25021)));
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
            this.f21133e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f2 = c.a.u0.p2.c.i().f();
                c.a.d.f.m.e.a().post(new RunnableC1302a(this, f2 == null ? 0 : f2.size()));
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
        this.f21126g = inflate;
        this.f21124e = inflate.findViewById(R.id.emotion_manager_add_layout);
        View findViewById = this.f21126g.findViewById(R.id.emotion_manager_create);
        this.f21125f = findViewById;
        findViewById.setOnClickListener(this);
        this.f21124e.setVisibility(0);
        View findViewById2 = this.f21126g.findViewById(R.id.emotion_manager_upload_status);
        this.f21127h = findViewById2;
        findViewById2.setClickable(false);
        this.f21127h.setOnClickListener(this);
        this.f21127h.setVisibility(8);
        this.f21128i = (ImageView) this.f21126g.findViewById(R.id.uploading_status_img);
        this.f21129j = (ImageView) this.f21126g.findViewById(R.id.icon_add);
        this.k = (TextView) this.f21126g.findViewById(R.id.add_emotion_tv);
        this.l = (TextView) this.f21126g.findViewById(R.id.add_emotion_manager_upload_status);
    }

    @Override // c.a.u0.z0.x.d.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.u0.p2.a.b().a(new b(this));
        }
    }

    @Override // c.a.u0.z0.x.d.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.u0.p2.a.b().a(new RunnableC1300a(this));
        }
    }

    public void d() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (imageView = this.f21128i) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21126g : (View) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            View view = this.f21124e;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i2);
            }
            TextView textView = this.l;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i2);
            }
            ImageView imageView = this.f21129j;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
            }
            TextView textView2 = this.k;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, i2);
            }
            View view2 = this.f21127h;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.cp_bg_line_d_alpha90, i2);
            }
            ImageView imageView2 = this.f21128i;
            if (imageView2 != null) {
                SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
            }
        }
    }

    public void h() {
        c.a.u0.z0.x.d.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (aVar = this.p) != null && aVar.isShowing()) {
            this.p.dismiss();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.u0.z0.x.d.a aVar = this.p;
            if (aVar != null) {
                aVar.dismiss();
            }
            d();
            this.f21127h.setVisibility(8);
            this.f21124e.setVisibility(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.u0.z0.x.d.a aVar = this.p;
            if (aVar != null) {
                aVar.dismiss();
            }
            k();
            this.f21127h.setVisibility(0);
            this.f21124e.setVisibility(8);
            SkinManager.setBackgroundColor(this.f21127h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.f21128i, R.drawable.emotion_uploading_bar_refresh);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0302);
            this.l.setText(R.string.emotion_uploading);
            this.f21127h.setClickable(false);
        }
    }

    public void k() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (imageView = this.f21128i) == null) {
            return;
        }
        imageView.startAnimation(e());
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            FaceGroupDraft k = c.a.u0.p2.g.e.l().k();
            if (k != null && TextUtils.isEmpty(k.getFailMsg())) {
                n.N(this.n.getPageActivity(), k.getFailMsg());
            }
            m(null);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            c.a.u0.z0.x.d.a aVar = this.p;
            if (aVar != null) {
                aVar.dismiss();
            }
            d();
            this.f21127h.setVisibility(0);
            this.f21124e.setVisibility(8);
            SkinManager.setBackgroundColor(this.f21127h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.f21128i, R.drawable.emotion_update_fail);
            SkinManager.setViewTextColor(this.l, R.color.common_color_10037);
            if (!TextUtils.isEmpty(str)) {
                this.l.setText(str);
            } else {
                this.l.setText(R.string.emotion_center_upload_failed);
            }
            this.f21127h.setClickable(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            if (this.f21125f != null && view.getId() == this.f21125f.getId() && this.f21125f.isShown()) {
                if (this.o == 1) {
                    if (this.p == null) {
                        c.a.u0.z0.x.d.a aVar = new c.a.u0.z0.x.d.a(this.n.getPageActivity(), this.o);
                        this.p = aVar;
                        aVar.d(this);
                    }
                    this.p.c(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.n.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.p.showAtLocation(this.f21126g, 81, 0, this.n.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                } else {
                    a();
                }
            }
            if (this.f21127h != null && view.getId() == this.f21127h.getId() && this.f21127h.isShown()) {
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
