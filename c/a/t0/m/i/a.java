package c.a.t0.m.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public ImageView B;
    public TextView C;
    public LinearLayout D;
    public ImageView E;
    public TextView F;
    public View G;
    public View H;
    public View I;
    public final View a;

    /* renamed from: b  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f13309b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f13310c;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadAchievementShareInfo.ThreadListBean> f13311d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13312e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13313f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13314g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13315h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13316i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f13317j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public View o;
    public View p;
    public TextView q;
    public TbImageView r;
    public TbImageView s;
    public TbImageView t;
    public View u;
    public View v;
    public View w;
    public LinearLayout x;
    public ImageView y;
    public TextView z;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, threadAchievementShareInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13310c = context;
        this.a = LayoutInflater.from(context).inflate(h.hot_thread_rank_list, (ViewGroup) null);
        ThreadAchievementShareInfo.ParamBean params = threadAchievementShareInfo.getParams();
        this.f13309b = params;
        if (params != null) {
            this.f13311d = params.getThread_list();
        }
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public final void b() {
        List<ThreadAchievementShareInfo.ThreadListBean> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f13309b == null || (list = this.f13311d) == null || list.size() < 2) {
            return;
        }
        int rank = this.f13309b.getRank();
        if (rank == 0) {
            ThreadAchievementShareInfo.ThreadListBean threadListBean = this.f13311d.get(rank);
            threadListBean.setDuration(500);
            int i2 = rank + 1;
            e(i2, threadListBean);
            f(rank + 2, this.f13311d.get(i2));
            this.u.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.w.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = n.f(this.f13310c, e.tbds8);
        } else if (rank == 1) {
            d(rank, this.f13311d.get(rank - 1));
            f(rank + 1, this.f13311d.get(rank));
            this.v.setVisibility(4);
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = n.f(this.f13310c, e.tbds5);
            SkinManager.setBackgroundColor(this.k, d.CAM_X0310);
            SkinManager.setViewTextColor(this.m, d.CAM_X0310);
            SkinManager.setBackgroundColor(this.p, d.cp_other_b_alpha20);
        } else {
            int i3 = rank - 1;
            e(i3, this.f13311d.get(rank - 2));
            d(rank, this.f13311d.get(i3));
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = n.f(this.f13310c, e.tbds230);
            this.w.setVisibility(4);
        }
    }

    @SuppressLint({"CutPasteId"})
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q = (TextView) this.a.findViewById(g.title);
            this.f13312e = (TextView) this.a.findViewById(g.first_rank_num);
            this.f13313f = (TextView) this.a.findViewById(g.first_thread_content);
            this.r = (TbImageView) this.a.findViewById(g.first_thread_img);
            this.f13314g = (TextView) this.a.findViewById(g.first_heat_degree);
            this.n = this.a.findViewById(g.first_heat_degree_bg);
            this.f13315h = (TextView) this.a.findViewById(g.second_rank_num);
            this.f13316i = (TextView) this.a.findViewById(g.second_thread_content);
            this.s = (TbImageView) this.a.findViewById(g.second_thread_img);
            this.f13317j = (TextView) this.a.findViewById(g.second_heat_degree);
            this.o = this.a.findViewById(g.second_heat_degree_bg);
            this.k = (TextView) this.a.findViewById(g.current_rank_num);
            this.l = (TextView) this.a.findViewById(g.current_thread_content);
            this.t = (TbImageView) this.a.findViewById(g.current_thread_img);
            this.m = (TextView) this.a.findViewById(g.current_heat_degree);
            this.p = this.a.findViewById(g.current_heat_degree_bg);
            this.v = this.a.findViewById(g.first_item_layout);
            this.w = this.a.findViewById(g.second_item_layout);
            this.u = this.a.findViewById(g.current_item_layout);
            this.I = this.a.findViewById(g.first_thread_img_overlay);
            this.H = this.a.findViewById(g.second_thread_img_overlay);
            this.G = this.a.findViewById(g.current_thread_img_overlay);
            this.x = (LinearLayout) this.a.findViewById(g.first_video_during_container);
            this.y = (ImageView) this.a.findViewById(g.first_vidoe_play_iv);
            this.z = (TextView) this.a.findViewById(g.first_video_during_tv);
            this.A = (LinearLayout) this.a.findViewById(g.second_video_during_container);
            this.B = (ImageView) this.a.findViewById(g.second_vidoe_play_iv);
            this.C = (TextView) this.a.findViewById(g.second_video_during_tv);
            this.D = (LinearLayout) this.a.findViewById(g.current_video_during_container);
            this.E = (ImageView) this.a.findViewById(g.current_vidoe_play_iv);
            this.F = (TextView) this.a.findViewById(g.current_video_during_tv);
            this.r.setRadius(n.f(this.f13310c, e.tbds10));
            this.r.setConrers(15);
            this.r.setPlaceHolder(2);
            this.s.setRadius(n.f(this.f13310c, e.tbds10));
            this.s.setConrers(15);
            this.s.setPlaceHolder(2);
            this.t.setRadius(n.f(this.f13310c, e.tbds10));
            this.t.setConrers(15);
            this.t.setPlaceHolder(2);
            this.f13313f.setLineSpacing(n.f(this.f13310c, e.tbds13), 1.0f);
            this.f13316i.setLineSpacing(n.f(this.f13310c, e.tbds13), 1.0f);
            this.l.setLineSpacing(n.f(this.f13310c, e.tbds13), 1.0f);
            SkinManager.setViewTextColor(this.q, d.CAM_X0105);
            SkinManager.setViewTextColor(this.f13312e, d.CAM_X0101);
            SkinManager.setBackgroundResource(this.f13312e, f.cp_other_d_round_bg);
            SkinManager.setBackgroundResource(this.n, f.cp_other_b_alpha20_round_bg);
            SkinManager.setViewTextColor(this.f13313f, d.CAM_X0105);
            SkinManager.setViewTextColor(this.f13314g, d.CAM_X0310);
            SkinManager.setViewTextColor(this.f13315h, d.CAM_X0101);
            SkinManager.setBackgroundResource(this.f13315h, f.cp_link_tip_d_round_bg);
            SkinManager.setBackgroundResource(this.o, f.cp_link_tip_d_alpha20_round_bg);
            SkinManager.setViewTextColor(this.f13316i, d.CAM_X0105);
            SkinManager.setViewTextColor(this.f13317j, d.CAM_X0305);
            SkinManager.setViewTextColor(this.k, d.CAM_X0101);
            SkinManager.setBackgroundResource(this.k, f.cp_link_tip_d_round_bg);
            SkinManager.setBackgroundResource(this.p, f.cp_link_tip_d_alpha20_round_bg);
            SkinManager.setViewTextColor(this.l, d.CAM_X0105);
            SkinManager.setViewTextColor(this.m, d.CAM_X0305);
            SkinManager.setBackgroundColor(this.a, d.CAM_X0201);
            TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(0).setBgColor(SkinManager.getResourceId(d.CAM_X0201)).setShadowColor(SkinManager.getResourceId(d.CAM_X0806)).setShadowSide(UIMsg.k_event.MV_MAP_CHANGETO2D).setShadowRadius(n.f(this.f13310c, e.tbds16)).setOffsetX(0).setOffsetY(n.f(this.f13310c, e.tbds5)).into(this.u);
            this.y.setImageDrawable(SvgManager.getInstance().getPureDrawable(f.ic_icon_pure_video_play12_svg, d.CAM_X0101, null));
            this.B.setImageDrawable(SvgManager.getInstance().getPureDrawable(f.ic_icon_pure_video_play12_svg, d.CAM_X0101, null));
            this.E.setImageDrawable(SvgManager.getInstance().getPureDrawable(f.ic_icon_pure_video_play12_svg, d.CAM_X0101, null));
            SkinManager.setViewTextColor(this.z, d.CAM_X0101);
            SkinManager.setViewTextColor(this.C, d.CAM_X0101);
            SkinManager.setViewTextColor(this.F, d.CAM_X0101);
        }
    }

    public final void d(int i2, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, threadListBean) == null) {
            this.u.setVisibility(0);
            this.k.setText(String.valueOf(i2));
            this.l.setText(threadListBean.getTitle());
            if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
                this.p.setVisibility(0);
                TextView textView = this.m;
                textView.setText("热度 " + StringHelper.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
            }
            if (threadListBean.getDuration() > 0) {
                this.D.setVisibility(0);
                this.G.setVisibility(0);
                this.F.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
            }
            if (!TextUtils.isEmpty(threadListBean.getImg())) {
                this.t.setVisibility(0);
                this.t.startLoad(threadListBean.getImg(), 10, false);
                return;
            }
            this.t.setVisibility(8);
            this.D.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.l.getLayoutParams()).rightMargin = n.f(this.f13310c, e.tbds44);
        }
    }

    public final void e(int i2, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, threadListBean) == null) {
            this.v.setVisibility(0);
            this.f13312e.setText(String.valueOf(i2));
            this.f13313f.setText(threadListBean.getTitle());
            if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
                this.n.setVisibility(0);
                TextView textView = this.f13314g;
                textView.setText("热度 " + StringHelper.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
            }
            if (threadListBean.getDuration() > 0) {
                this.x.setVisibility(0);
                this.I.setVisibility(0);
                this.z.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
            }
            if (!TextUtils.isEmpty(threadListBean.getImg())) {
                this.r.setVisibility(0);
                this.r.startLoad(threadListBean.getImg(), 10, false);
                return;
            }
            this.r.setVisibility(8);
            this.x.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.f13313f.getLayoutParams()).rightMargin = n.f(this.f13310c, e.tbds44);
        }
    }

    public final void f(int i2, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, threadListBean) == null) {
            this.w.setVisibility(0);
            this.f13315h.setText(String.valueOf(i2));
            this.f13316i.setText(threadListBean.getTitle());
            if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
                this.o.setVisibility(0);
                TextView textView = this.f13317j;
                textView.setText("热度 " + StringHelper.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
            }
            if (threadListBean.getDuration() > 0) {
                this.A.setVisibility(0);
                this.H.setVisibility(0);
                this.C.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
            }
            if (!TextUtils.isEmpty(threadListBean.getImg())) {
                this.s.setVisibility(0);
                this.s.startLoad(threadListBean.getImg(), 10, false);
                return;
            }
            this.s.setVisibility(8);
            this.A.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.f13316i.getLayoutParams()).rightMargin = n.f(this.f13310c, e.tbds44);
        }
    }
}
