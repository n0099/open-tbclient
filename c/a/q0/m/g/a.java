package c.a.q0.m.g;

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
import c.a.e.e.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
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

    /* renamed from: a  reason: collision with root package name */
    public final View f13584a;

    /* renamed from: b  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f13585b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f13586c;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadAchievementShareInfo.ThreadListBean> f13587d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13588e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13589f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13590g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13591h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13592i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f13593j;
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
        this.f13586c = context;
        this.f13584a = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        ThreadAchievementShareInfo.ParamBean params = threadAchievementShareInfo.getParams();
        this.f13585b = params;
        if (params != null) {
            this.f13587d = params.getThread_list();
        }
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13584a : (View) invokeV.objValue;
    }

    public final void b() {
        List<ThreadAchievementShareInfo.ThreadListBean> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f13585b == null || (list = this.f13587d) == null || list.size() < 2) {
            return;
        }
        int rank = this.f13585b.getRank();
        if (rank == 0) {
            ThreadAchievementShareInfo.ThreadListBean threadListBean = this.f13587d.get(rank);
            threadListBean.setDuration(500);
            int i2 = rank + 1;
            e(i2, threadListBean);
            f(rank + 2, this.f13587d.get(i2));
            this.u.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.w.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = l.g(this.f13586c, R.dimen.tbds8);
        } else if (rank == 1) {
            d(rank, this.f13587d.get(rank - 1));
            f(rank + 1, this.f13587d.get(rank));
            this.v.setVisibility(4);
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = l.g(this.f13586c, R.dimen.tbds5);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0310);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0310);
            SkinManager.setBackgroundColor(this.p, R.color.cp_other_b_alpha20);
        } else {
            int i3 = rank - 1;
            e(i3, this.f13587d.get(rank - 2));
            d(rank, this.f13587d.get(i3));
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = l.g(this.f13586c, R.dimen.tbds230);
            this.w.setVisibility(4);
        }
    }

    @SuppressLint({"CutPasteId"})
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q = (TextView) this.f13584a.findViewById(R.id.title);
            this.f13588e = (TextView) this.f13584a.findViewById(R.id.first_rank_num);
            this.f13589f = (TextView) this.f13584a.findViewById(R.id.first_thread_content);
            this.r = (TbImageView) this.f13584a.findViewById(R.id.first_thread_img);
            this.f13590g = (TextView) this.f13584a.findViewById(R.id.first_heat_degree);
            this.n = this.f13584a.findViewById(R.id.first_heat_degree_bg);
            this.f13591h = (TextView) this.f13584a.findViewById(R.id.second_rank_num);
            this.f13592i = (TextView) this.f13584a.findViewById(R.id.second_thread_content);
            this.s = (TbImageView) this.f13584a.findViewById(R.id.second_thread_img);
            this.f13593j = (TextView) this.f13584a.findViewById(R.id.second_heat_degree);
            this.o = this.f13584a.findViewById(R.id.second_heat_degree_bg);
            this.k = (TextView) this.f13584a.findViewById(R.id.current_rank_num);
            this.l = (TextView) this.f13584a.findViewById(R.id.current_thread_content);
            this.t = (TbImageView) this.f13584a.findViewById(R.id.current_thread_img);
            this.m = (TextView) this.f13584a.findViewById(R.id.current_heat_degree);
            this.p = this.f13584a.findViewById(R.id.current_heat_degree_bg);
            this.v = this.f13584a.findViewById(R.id.first_item_layout);
            this.w = this.f13584a.findViewById(R.id.second_item_layout);
            this.u = this.f13584a.findViewById(R.id.current_item_layout);
            this.I = this.f13584a.findViewById(R.id.first_thread_img_overlay);
            this.H = this.f13584a.findViewById(R.id.second_thread_img_overlay);
            this.G = this.f13584a.findViewById(R.id.current_thread_img_overlay);
            this.x = (LinearLayout) this.f13584a.findViewById(R.id.first_video_during_container);
            this.y = (ImageView) this.f13584a.findViewById(R.id.first_vidoe_play_iv);
            this.z = (TextView) this.f13584a.findViewById(R.id.first_video_during_tv);
            this.A = (LinearLayout) this.f13584a.findViewById(R.id.second_video_during_container);
            this.B = (ImageView) this.f13584a.findViewById(R.id.second_vidoe_play_iv);
            this.C = (TextView) this.f13584a.findViewById(R.id.second_video_during_tv);
            this.D = (LinearLayout) this.f13584a.findViewById(R.id.current_video_during_container);
            this.E = (ImageView) this.f13584a.findViewById(R.id.current_vidoe_play_iv);
            this.F = (TextView) this.f13584a.findViewById(R.id.current_video_during_tv);
            this.r.setRadius(l.g(this.f13586c, R.dimen.tbds10));
            this.r.setConrers(15);
            this.r.setPlaceHolder(2);
            this.s.setRadius(l.g(this.f13586c, R.dimen.tbds10));
            this.s.setConrers(15);
            this.s.setPlaceHolder(2);
            this.t.setRadius(l.g(this.f13586c, R.dimen.tbds10));
            this.t.setConrers(15);
            this.t.setPlaceHolder(2);
            this.f13589f.setLineSpacing(l.g(this.f13586c, R.dimen.tbds13), 1.0f);
            this.f13592i.setLineSpacing(l.g(this.f13586c, R.dimen.tbds13), 1.0f);
            this.l.setLineSpacing(l.g(this.f13586c, R.dimen.tbds13), 1.0f);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f13588e, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f13588e, R.drawable.cp_other_d_round_bg);
            SkinManager.setBackgroundResource(this.n, R.drawable.cp_other_b_alpha20_round_bg);
            SkinManager.setViewTextColor(this.f13589f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f13590g, R.color.CAM_X0310);
            SkinManager.setViewTextColor(this.f13591h, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f13591h, R.drawable.cp_link_tip_d_round_bg);
            SkinManager.setBackgroundResource(this.o, R.drawable.cp_link_tip_d_alpha20_round_bg);
            SkinManager.setViewTextColor(this.f13592i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f13593j, R.color.CAM_X0305);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.k, R.drawable.cp_link_tip_d_round_bg);
            SkinManager.setBackgroundResource(this.p, R.drawable.cp_link_tip_d_alpha20_round_bg);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0305);
            SkinManager.setBackgroundColor(this.f13584a, R.color.CAM_X0201);
            TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(0).setBgColor(SkinManager.getResourceId(R.color.CAM_X0201)).setShadowColor(SkinManager.getResourceId(R.color.CAM_X0806)).setShadowSide(UIMsg.k_event.MV_MAP_CHANGETO2D).setShadowRadius(l.g(this.f13586c, R.dimen.tbds16)).setOffsetX(0).setOffsetY(l.g(this.f13586c, R.dimen.tbds5)).into(this.u);
            this.y.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            this.B.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            this.E.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            SkinManager.setViewTextColor(this.z, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.F, R.color.CAM_X0101);
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
            ((RelativeLayout.LayoutParams) this.l.getLayoutParams()).rightMargin = l.g(this.f13586c, R.dimen.tbds44);
        }
    }

    public final void e(int i2, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, threadListBean) == null) {
            this.v.setVisibility(0);
            this.f13588e.setText(String.valueOf(i2));
            this.f13589f.setText(threadListBean.getTitle());
            if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
                this.n.setVisibility(0);
                TextView textView = this.f13590g;
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
            ((RelativeLayout.LayoutParams) this.f13589f.getLayoutParams()).rightMargin = l.g(this.f13586c, R.dimen.tbds44);
        }
    }

    public final void f(int i2, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, threadListBean) == null) {
            this.w.setVisibility(0);
            this.f13591h.setText(String.valueOf(i2));
            this.f13592i.setText(threadListBean.getTitle());
            if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
                this.o.setVisibility(0);
                TextView textView = this.f13593j;
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
            ((RelativeLayout.LayoutParams) this.f13592i.getLayoutParams()).rightMargin = l.g(this.f13586c, R.dimen.tbds44);
        }
    }
}
