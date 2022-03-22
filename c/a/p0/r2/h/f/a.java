package c.a.p0.r2.h.f;

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
/* loaded from: classes2.dex */
public class a implements View.OnClickListener, c.a.p0.a1.y.d.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f18075b;

    /* renamed from: c  reason: collision with root package name */
    public View f18076c;

    /* renamed from: d  reason: collision with root package name */
    public View f18077d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f18078e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f18079f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18080g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18081h;
    public Animation i;
    public TbPageContext j;
    public int k;
    public c.a.p0.a1.y.d.a l;

    /* renamed from: c.a.p0.r2.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1362a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.p0.r2.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1363a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC1362a f18082b;

            public RunnableC1363a(RunnableC1362a runnableC1362a, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1362a, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18082b = runnableC1362a;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a >= 30) {
                        n.N(this.f18082b.a.j.getPageActivity(), String.format(this.f18082b.a.j.getString(R.string.obfuscated_res_0x7f0f052e), 30));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f18082b.a.j.getPageActivity(), true, 25021)));
                    }
                }
            }
        }

        public RunnableC1362a(a aVar) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f2 = c.a.p0.r2.c.i().f();
                c.a.d.f.m.e.a().post(new RunnableC1363a(this, f2 == null ? 0 : f2.size()));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.p0.r2.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1364a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f18083b;

            public RunnableC1364a(b bVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18083b = bVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a >= 30) {
                        n.N(this.f18083b.a.j.getPageActivity(), String.format(this.f18083b.a.j.getString(R.string.obfuscated_res_0x7f0f052e), 30));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f18083b.a.j.getPageActivity(), 25021)));
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f2 = c.a.p0.r2.c.i().f();
                c.a.d.f.m.e.a().post(new RunnableC1364a(this, f2 == null ? 0 : f2.size()));
            }
        }
    }

    public a(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = null;
        this.j = tbPageContext;
        this.k = i;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0264, (ViewGroup) null);
        this.f18076c = inflate;
        this.a = inflate.findViewById(R.id.obfuscated_res_0x7f09089b);
        View findViewById = this.f18076c.findViewById(R.id.obfuscated_res_0x7f09089c);
        this.f18075b = findViewById;
        findViewById.setOnClickListener(this);
        this.a.setVisibility(0);
        View findViewById2 = this.f18076c.findViewById(R.id.obfuscated_res_0x7f0908a0);
        this.f18077d = findViewById2;
        findViewById2.setClickable(false);
        this.f18077d.setOnClickListener(this);
        this.f18077d.setVisibility(8);
        this.f18078e = (ImageView) this.f18076c.findViewById(R.id.obfuscated_res_0x7f092291);
        this.f18079f = (ImageView) this.f18076c.findViewById(R.id.obfuscated_res_0x7f090e14);
        this.f18080g = (TextView) this.f18076c.findViewById(R.id.obfuscated_res_0x7f090105);
        this.f18081h = (TextView) this.f18076c.findViewById(R.id.obfuscated_res_0x7f090104);
    }

    @Override // c.a.p0.a1.y.d.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.p0.r2.a.b().a(new b(this));
        }
    }

    @Override // c.a.p0.a1.y.d.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.r2.a.b().a(new RunnableC1362a(this));
        }
    }

    public void d() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (imageView = this.f18078e) == null) {
            return;
        }
        imageView.clearAnimation();
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.i == null) {
                this.i = AnimationUtils.loadAnimation(this.j.getPageActivity(), R.anim.obfuscated_res_0x7f0100f8);
                this.i.setInterpolator(new LinearInterpolator());
                this.i.setFillAfter(true);
            }
            return this.i;
        }
        return (Animation) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18076c : (View) invokeV.objValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            View view = this.a;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i);
            }
            TextView textView = this.f18081h;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i);
            }
            ImageView imageView = this.f18079f;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
            }
            TextView textView2 = this.f18080g;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, i);
            }
            View view2 = this.f18077d;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.cp_bg_line_d_alpha90, i);
            }
            ImageView imageView2 = this.f18078e;
            if (imageView2 != null) {
                SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
            }
        }
    }

    public void h() {
        c.a.p0.a1.y.d.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (aVar = this.l) != null && aVar.isShowing()) {
            this.l.dismiss();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.a1.y.d.a aVar = this.l;
            if (aVar != null) {
                aVar.dismiss();
            }
            d();
            this.f18077d.setVisibility(8);
            this.a.setVisibility(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.p0.a1.y.d.a aVar = this.l;
            if (aVar != null) {
                aVar.dismiss();
            }
            k();
            this.f18077d.setVisibility(0);
            this.a.setVisibility(8);
            SkinManager.setBackgroundColor(this.f18077d, R.color.CAM_X0201);
            SkinManager.setImageResource(this.f18078e, R.drawable.emotion_uploading_bar_refresh);
            SkinManager.setViewTextColor(this.f18081h, (int) R.color.CAM_X0302);
            this.f18081h.setText(R.string.obfuscated_res_0x7f0f0552);
            this.f18077d.setClickable(false);
        }
    }

    public void k() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (imageView = this.f18078e) == null) {
            return;
        }
        imageView.startAnimation(e());
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            FaceGroupDraft k = c.a.p0.r2.g.e.l().k();
            if (k != null && TextUtils.isEmpty(k.getFailMsg())) {
                n.N(this.j.getPageActivity(), k.getFailMsg());
            }
            m(null);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            c.a.p0.a1.y.d.a aVar = this.l;
            if (aVar != null) {
                aVar.dismiss();
            }
            d();
            this.f18077d.setVisibility(0);
            this.a.setVisibility(8);
            SkinManager.setBackgroundColor(this.f18077d, R.color.CAM_X0201);
            SkinManager.setImageResource(this.f18078e, R.drawable.emotion_update_fail);
            SkinManager.setViewTextColor(this.f18081h, (int) R.color.common_color_10037);
            if (!TextUtils.isEmpty(str)) {
                this.f18081h.setText(str);
            } else {
                this.f18081h.setText(R.string.obfuscated_res_0x7f0f052b);
            }
            this.f18077d.setClickable(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            if (this.f18075b != null && view.getId() == this.f18075b.getId() && this.f18075b.isShown()) {
                if (this.k == 1) {
                    if (this.l == null) {
                        c.a.p0.a1.y.d.a aVar = new c.a.p0.a1.y.d.a(this.j.getPageActivity(), this.k);
                        this.l = aVar;
                        aVar.d(this);
                    }
                    this.l.c(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.j.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.l.showAtLocation(this.f18076c, 81, 0, this.j.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                } else {
                    a();
                }
            }
            if (this.f18077d != null && view.getId() == this.f18077d.getId() && this.f18077d.isShown()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.j.getPageActivity(), this.k == 1, 25021)));
            }
        }
    }

    public void update(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
        }
    }
}
