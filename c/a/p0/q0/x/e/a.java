package c.a.p0.q0.x.e;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.o0.f0.g;
import c.a.o0.s.f0.f;
import c.a.o0.s.s.a;
import c.a.p0.q0.x.d.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionCenterChangeView;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionCenterForumView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener, c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public g B;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f23515e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f23516f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.s.f0.g f23517g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f23518h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f23519i;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f23520j;
    public View k;
    public RelativeLayout l;
    public TextView m;
    public ImageView n;
    public c.a.p0.q0.x.a o;
    public EmotionCenterForumView p;
    public EmotionCenterChangeView q;
    public c.a.p0.q0.x.b.a r;
    public EmotionCenterData s;
    public c.a.p0.q0.x.d.a t;
    public LinearLayout u;
    public ImageView v;
    public TextView w;
    public Animation x;
    public boolean y;
    public int z;

    /* renamed from: c.a.p0.q0.x.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1091a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1091a(a aVar) {
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
                }
            }
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.x = null;
        this.y = true;
        this.z = 0;
        this.A = "";
        this.f23515e = tbPageContext;
        this.f23518h = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_emotion_center_layout, (ViewGroup) null);
        this.f23519i = new NoNetworkView(tbPageContext.getPageActivity());
        this.f23519i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (j.z()) {
            this.f23519i.setVisibility(8);
        }
        this.f23518h.addView(this.f23519i);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f23518h.findViewById(R.id.emotion_center_list);
        this.f23516f = bdTypeListView;
        bdTypeListView.setDivider(null);
        c.a.o0.s.f0.g gVar = new c.a.o0.s.f0.g(this.f23515e);
        this.f23517g = gVar;
        gVar.V(bdUniqueId);
        this.f23516f.setPullRefresh(this.f23517g);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f23520j = pbListView;
        pbListView.a();
        c.a.p0.q0.x.a aVar = new c.a.p0.q0.x.a(this.f23515e);
        this.o = aVar;
        aVar.c().setVisibility(8);
        EmotionCenterForumView emotionCenterForumView = new EmotionCenterForumView(this.f23515e);
        this.p = emotionCenterForumView;
        emotionCenterForumView.setVisibility(8);
        this.r = new c.a.p0.q0.x.b.a(this.f23515e, this.f23516f);
        EmotionCenterChangeView emotionCenterChangeView = new EmotionCenterChangeView(this.f23515e);
        this.q = emotionCenterChangeView;
        emotionCenterChangeView.setVisibility(8);
        this.f23516f.addHeaderView(this.o.c());
        this.f23516f.addHeaderView(this.p);
        this.f23516f.addHeaderView(this.q);
        this.k = this.f23518h.findViewById(R.id.emotion_add_layout);
        this.l = (RelativeLayout) this.f23518h.findViewById(R.id.emotion_add_layout);
        this.m = (TextView) this.f23518h.findViewById(R.id.add_emotion_tv);
        this.n = (ImageView) this.f23518h.findViewById(R.id.icon_add);
        this.k.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.f23518h.findViewById(R.id.emotion_upload_status);
        this.u = linearLayout;
        linearLayout.setClickable(false);
        this.u.setOnClickListener(this);
        this.u.setVisibility(8);
        this.v = (ImageView) this.f23518h.findViewById(R.id.uploading_status_img);
        this.w = (TextView) this.f23518h.findViewById(R.id.add_emotion_upload_status);
        t();
    }

    @Override // c.a.p0.q0.x.d.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f23515e.getPageActivity(), 25021)));
        }
    }

    @Override // c.a.p0.q0.x.d.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.z == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f23515e.getPageActivity(), true, 25021)));
            } else if (TextUtils.isEmpty(this.A)) {
            } else {
                c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(this.f23515e.getPageActivity());
                aVar.setMessage(this.A);
                aVar.setPositiveButton(R.string.confirm, new C1091a(this));
                aVar.setNegativeButton(R.string.cancel, new b(this));
                aVar.create(this.f23515e).show();
            }
        }
    }

    public void c(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, emotionCenterData) == null) || emotionCenterData == null) {
            return;
        }
        this.s = emotionCenterData;
        if (!ListUtils.isEmpty(emotionCenterData.package_list)) {
            ArrayList arrayList = new ArrayList();
            for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                c.a.p0.q0.x.c.b bVar = new c.a.p0.q0.x.c.b();
                bVar.f23504e = emotionPackageData;
                arrayList.add(bVar);
            }
            this.r.a(arrayList);
        }
        this.r.c();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23516f.completePullRefresh();
        }
    }

    public void e() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (imageView = this.v) == null) {
            return;
        }
        imageView.clearAnimation();
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.z : invokeV.intValue;
    }

    public final Animation g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.x == null) {
                this.x = AnimationUtils.loadAnimation(this.f23515e.getPageActivity(), R.anim.refresh_rotate);
                this.x.setInterpolator(new LinearInterpolator());
                this.x.setFillAfter(true);
            }
            return this.x;
        }
        return (Animation) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f23519i : (View) invokeV.objValue;
    }

    public ViewGroup i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f23518h : (ViewGroup) invokeV.objValue;
    }

    public EmotionCenterChangeView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.q : (EmotionCenterChangeView) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            PbListView pbListView = this.f23520j;
            if (pbListView != null) {
                pbListView.f();
            }
            this.f23516f.setNextPage(null);
        }
    }

    public void l() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (gVar = this.B) == null) {
            return;
        }
        gVar.dettachView(this.f23518h);
        this.B = null;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f23520j.o(R.color.CAM_X0204);
            this.f23520j.d(i2);
            this.f23517g.D(i2);
            this.r.c();
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            this.f23516f.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.f23518h, R.color.CAM_X0201);
            this.f23519i.onChangeSkinType(this.f23515e, i2);
            EmotionCenterForumView emotionCenterForumView = this.p;
            if (emotionCenterForumView != null) {
                emotionCenterForumView.onChangeSkin(i2);
            }
            RelativeLayout relativeLayout = this.l;
            if (relativeLayout != null) {
                SkinManager.setBackgroundColor(relativeLayout, R.color.cp_bg_line_d_alpha90, i2);
            }
            TextView textView = this.m;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i2);
            }
            ImageView imageView = this.n;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
            }
            if (this.u != null) {
                SkinManager.setBackgroundColor(this.l, R.color.cp_bg_line_d_alpha90, i2);
            }
            ImageView imageView2 = this.v;
            if (imageView2 != null) {
                SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.p0.q0.x.d.a aVar = this.t;
            if (aVar != null) {
                aVar.dismiss();
            }
            e();
            this.u.setVisibility(8);
            this.k.setVisibility(0);
        }
    }

    public void o(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, emotionCenterData) == null) || emotionCenterData == null) {
            return;
        }
        l();
        if (ListUtils.isEmpty(this.q.getDataList())) {
            this.q.refreshNetData();
            this.q.setVisibility(0);
        }
        this.s = emotionCenterData;
        if (this.y) {
            this.z = c.a.e.e.m.b.d(emotionCenterData.is_bazhu, 0);
            this.A = emotionCenterData.bazhu_message;
            this.y = false;
        }
        if (emotionCenterData.banner != null) {
            this.o.c().setVisibility(0);
            this.o.f(this.f23515e.getUniqueId());
            this.o.e(new c.a.p0.q0.x.c.c(emotionCenterData.banner));
            this.o.g();
        }
        if (emotionCenterData.forum != null) {
            this.p.setVisibility(0);
            this.p.setData(emotionCenterData.forum);
        }
        if (!ListUtils.isEmpty(emotionCenterData.package_list)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new c.a.p0.q0.x.c.a());
            for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                c.a.p0.q0.x.c.b bVar = new c.a.p0.q0.x.c.b();
                bVar.f23504e = emotionPackageData;
                arrayList.add(bVar);
            }
            this.r.d(arrayList);
        }
        this.r.c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            if (view == this.k) {
                if (this.s == null) {
                    return;
                }
                if (this.z != 0) {
                    if (this.t == null) {
                        c.a.p0.q0.x.d.a aVar = new c.a.p0.q0.x.d.a(this.f23515e.getPageActivity(), this.z);
                        this.t = aVar;
                        aVar.d(this);
                    }
                    this.t.c(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.f23515e.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.t.showAtLocation(this.f23518h, 81, 0, this.f23515e.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                    return;
                }
                a();
            } else if (view == this.u) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f23515e.getPageActivity(), this.z == 1, 25021)));
            }
        }
    }

    public void p(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) {
            this.f23517g.a(gVar);
        }
    }

    public void q(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pVar) == null) {
            this.f23516f.setOnSrollToBottomListener(pVar);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.p0.q0.x.d.a aVar = this.t;
            if (aVar != null) {
                aVar.dismiss();
            }
            v();
            this.u.setVisibility(0);
            this.k.setVisibility(8);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
            SkinManager.setImageResource(this.v, R.drawable.emotion_uploading_bar_refresh);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0302);
            this.w.setText(R.string.emotion_uploading);
            this.u.setClickable(false);
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (pbListView = this.f23520j) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f23516f.setNextPage(this.f23520j);
        }
        this.f23520j.M();
        this.f23520j.O();
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (tbPageContext = this.f23515e) == null || this.f23518h == null) {
            return;
        }
        g gVar = new g(tbPageContext.getPageActivity());
        this.B = gVar;
        gVar.attachView(this.f23518h, false);
        this.B.onChangeSkinType();
    }

    public void u() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (pbListView = this.f23520j) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f23516f.setNextPage(this.f23520j);
        }
        this.f23520j.A(this.f23515e.getResources().getString(R.string.list_no_more));
        this.f23520j.f();
    }

    public void v() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (imageView = this.v) == null) {
            return;
        }
        imageView.startAnimation(g());
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c.a.p0.q0.x.d.a aVar = this.t;
            if (aVar != null) {
                aVar.dismiss();
            }
            e();
            this.u.setVisibility(0);
            this.k.setVisibility(8);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
            SkinManager.setImageResource(this.v, R.drawable.emotion_update_fail);
            SkinManager.setViewTextColor(this.w, R.color.common_color_10037);
            this.w.setText(R.string.emotion_center_upload_failed);
            this.u.setClickable(true);
        }
    }

    public void x(EmotionPackageData emotionPackageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, emotionPackageData) == null) || emotionPackageData == null) {
            return;
        }
        EmotionCenterChangeView emotionCenterChangeView = this.q;
        if (emotionCenterChangeView != null) {
            emotionCenterChangeView.updataData(emotionPackageData);
        }
        c.a.p0.q0.x.b.a aVar = this.r;
        if (aVar != null) {
            aVar.e(emotionPackageData);
        }
    }
}
