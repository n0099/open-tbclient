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
import c.a.d.f.p.l;
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
/* loaded from: classes5.dex */
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
    public final ThreadAchievementShareInfo.ParamBean f12430b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f12431c;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadAchievementShareInfo.ThreadListBean> f12432d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f12433e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12434f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12435g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12436h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12437i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f12438j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f12439k;
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
        this.f12431c = context;
        this.a = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        ThreadAchievementShareInfo.ParamBean params = threadAchievementShareInfo.getParams();
        this.f12430b = params;
        if (params != null) {
            this.f12432d = params.getThread_list();
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f12430b == null || (list = this.f12432d) == null || list.size() < 2) {
            return;
        }
        int rank = this.f12430b.getRank();
        if (rank == 0) {
            ThreadAchievementShareInfo.ThreadListBean threadListBean = this.f12432d.get(rank);
            threadListBean.setDuration(500);
            int i2 = rank + 1;
            e(i2, threadListBean);
            f(rank + 2, this.f12432d.get(i2));
            this.u.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.w.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = l.f(this.f12431c, R.dimen.tbds8);
        } else if (rank == 1) {
            d(rank, this.f12432d.get(rank - 1));
            f(rank + 1, this.f12432d.get(rank));
            this.v.setVisibility(4);
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = l.f(this.f12431c, R.dimen.tbds5);
            SkinManager.setBackgroundColor(this.f12439k, R.color.CAM_X0310);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0310);
            SkinManager.setBackgroundColor(this.p, R.color.cp_other_b_alpha20);
        } else {
            int i3 = rank - 1;
            e(i3, this.f12432d.get(rank - 2));
            d(rank, this.f12432d.get(i3));
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = l.f(this.f12431c, R.dimen.tbds230);
            this.w.setVisibility(4);
        }
    }

    @SuppressLint({"CutPasteId"})
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q = (TextView) this.a.findViewById(R.id.title);
            this.f12433e = (TextView) this.a.findViewById(R.id.first_rank_num);
            this.f12434f = (TextView) this.a.findViewById(R.id.first_thread_content);
            this.r = (TbImageView) this.a.findViewById(R.id.first_thread_img);
            this.f12435g = (TextView) this.a.findViewById(R.id.first_heat_degree);
            this.n = this.a.findViewById(R.id.first_heat_degree_bg);
            this.f12436h = (TextView) this.a.findViewById(R.id.second_rank_num);
            this.f12437i = (TextView) this.a.findViewById(R.id.second_thread_content);
            this.s = (TbImageView) this.a.findViewById(R.id.second_thread_img);
            this.f12438j = (TextView) this.a.findViewById(R.id.second_heat_degree);
            this.o = this.a.findViewById(R.id.second_heat_degree_bg);
            this.f12439k = (TextView) this.a.findViewById(R.id.current_rank_num);
            this.l = (TextView) this.a.findViewById(R.id.current_thread_content);
            this.t = (TbImageView) this.a.findViewById(R.id.current_thread_img);
            this.m = (TextView) this.a.findViewById(R.id.current_heat_degree);
            this.p = this.a.findViewById(R.id.current_heat_degree_bg);
            this.v = this.a.findViewById(R.id.first_item_layout);
            this.w = this.a.findViewById(R.id.second_item_layout);
            this.u = this.a.findViewById(R.id.current_item_layout);
            this.I = this.a.findViewById(R.id.first_thread_img_overlay);
            this.H = this.a.findViewById(R.id.second_thread_img_overlay);
            this.G = this.a.findViewById(R.id.current_thread_img_overlay);
            this.x = (LinearLayout) this.a.findViewById(R.id.first_video_during_container);
            this.y = (ImageView) this.a.findViewById(R.id.first_vidoe_play_iv);
            this.z = (TextView) this.a.findViewById(R.id.first_video_during_tv);
            this.A = (LinearLayout) this.a.findViewById(R.id.second_video_during_container);
            this.B = (ImageView) this.a.findViewById(R.id.second_vidoe_play_iv);
            this.C = (TextView) this.a.findViewById(R.id.second_video_during_tv);
            this.D = (LinearLayout) this.a.findViewById(R.id.current_video_during_container);
            this.E = (ImageView) this.a.findViewById(R.id.current_vidoe_play_iv);
            this.F = (TextView) this.a.findViewById(R.id.current_video_during_tv);
            this.r.setRadius(l.f(this.f12431c, R.dimen.tbds10));
            this.r.setConrers(15);
            this.r.setPlaceHolder(2);
            this.s.setRadius(l.f(this.f12431c, R.dimen.tbds10));
            this.s.setConrers(15);
            this.s.setPlaceHolder(2);
            this.t.setRadius(l.f(this.f12431c, R.dimen.tbds10));
            this.t.setConrers(15);
            this.t.setPlaceHolder(2);
            this.f12434f.setLineSpacing(l.f(this.f12431c, R.dimen.tbds13), 1.0f);
            this.f12437i.setLineSpacing(l.f(this.f12431c, R.dimen.tbds13), 1.0f);
            this.l.setLineSpacing(l.f(this.f12431c, R.dimen.tbds13), 1.0f);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f12433e, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f12433e, R.drawable.cp_other_d_round_bg);
            SkinManager.setBackgroundResource(this.n, R.drawable.cp_other_b_alpha20_round_bg);
            SkinManager.setViewTextColor(this.f12434f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f12435g, R.color.CAM_X0310);
            SkinManager.setViewTextColor(this.f12436h, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f12436h, R.drawable.cp_link_tip_d_round_bg);
            SkinManager.setBackgroundResource(this.o, R.drawable.cp_link_tip_d_alpha20_round_bg);
            SkinManager.setViewTextColor(this.f12437i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f12438j, R.color.CAM_X0305);
            SkinManager.setViewTextColor(this.f12439k, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f12439k, R.drawable.cp_link_tip_d_round_bg);
            SkinManager.setBackgroundResource(this.p, R.drawable.cp_link_tip_d_alpha20_round_bg);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0305);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(0).setBgColor(SkinManager.getResourceId(R.color.CAM_X0201)).setShadowColor(SkinManager.getResourceId(R.color.CAM_X0806)).setShadowSide(UIMsg.k_event.MV_MAP_CHANGETO2D).setShadowRadius(l.f(this.f12431c, R.dimen.tbds16)).setOffsetX(0).setOffsetY(l.f(this.f12431c, R.dimen.tbds5)).into(this.u);
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
            this.f12439k.setText(String.valueOf(i2));
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
            ((RelativeLayout.LayoutParams) this.l.getLayoutParams()).rightMargin = l.f(this.f12431c, R.dimen.tbds44);
        }
    }

    public final void e(int i2, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, threadListBean) == null) {
            this.v.setVisibility(0);
            this.f12433e.setText(String.valueOf(i2));
            this.f12434f.setText(threadListBean.getTitle());
            if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
                this.n.setVisibility(0);
                TextView textView = this.f12435g;
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
            ((RelativeLayout.LayoutParams) this.f12434f.getLayoutParams()).rightMargin = l.f(this.f12431c, R.dimen.tbds44);
        }
    }

    public final void f(int i2, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, threadListBean) == null) {
            this.w.setVisibility(0);
            this.f12436h.setText(String.valueOf(i2));
            this.f12437i.setText(threadListBean.getTitle());
            if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
                this.o.setVisibility(0);
                TextView textView = this.f12438j;
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
            ((RelativeLayout.LayoutParams) this.f12437i.getLayoutParams()).rightMargin = l.f(this.f12431c, R.dimen.tbds44);
        }
    }
}
