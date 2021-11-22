package b.a.r0.b0;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h extends b<b.a.r0.h0.g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView m;
    public LinearLayout n;
    public TextView o;
    public TextView p;
    public TextView q;
    public LinearLayout r;
    public ImageView s;
    public ImageView t;
    public ImageView u;
    public ImageView v;
    public ImageView w;
    public TextView x;
    public b.a.r0.h0.g y;
    public View z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(i());
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_frs_game_score_view_item : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f16223e != i2) {
                SkinManager.setBackgroundResource(i(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.z, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0107, 1);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0107, 1);
                q(this.y);
            }
            this.f16223e = i2;
        }
    }

    public final void o(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.m = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
            this.n = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
            this.o = (TextView) view.findViewById(R.id.card_frs_game_score_title);
            this.p = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
            this.q = (TextView) view.findViewById(R.id.card_frs_game_score_num);
            this.r = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
            this.s = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
            this.t = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
            this.u = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
            this.v = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
            this.w = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
            this.x = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
            this.m.setDefaultResource(17170445);
            this.m.setDefaultBgResource(R.color.CAM_X0205);
            this.m.setDrawBorder(true);
            this.m.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.m.setBorderWidth(this.f16225g.getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.m.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
            i().setOnClickListener(this);
            this.z = view.findViewById(R.id.divider_line);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || f() == null) {
            return;
        }
        f().a(i(), this.y);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: p */
    public void j(b.a.r0.h0.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || gVar == null || gVar.g() == null) {
            return;
        }
        this.y = gVar;
        this.m.startLoad(gVar.g().avatar, 10, false);
        this.o.setText(gVar.g().game_name);
        this.p.setText(gVar.g().title_small);
        this.q.setText(String.valueOf(gVar.g().game_score));
        q(gVar);
        this.x.setText(this.f16225g.getResources().getString(R.string.frs_game_score_user_score_num, StringHelper.numberUniform(gVar.g().game_score_num)));
    }

    public final void q(b.a.r0.h0.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) || gVar == null) {
            return;
        }
        SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_empty_bg);
        SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_empty_bg);
        SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_empty_bg);
        SkinManager.setImageResource(this.v, R.drawable.game_comment_score_btn_small_empty_bg);
        SkinManager.setImageResource(this.w, R.drawable.game_comment_score_btn_small_empty_bg);
        if (gVar.g().game_score > 0.0d) {
            if (gVar.g().game_score < 2.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (gVar.g().game_score == 2.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
            } else if (gVar.g().game_score < 4.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (gVar.g().game_score == 4.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
            } else if (gVar.g().game_score < 6.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (gVar.g().game_score == 6.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_full_bg);
            } else if (gVar.g().game_score < 8.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.v, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (gVar.g().game_score == 8.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.v, R.drawable.game_comment_score_btn_small_full_bg);
            } else if (gVar.g().game_score < 10.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.v, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.w, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (gVar.g().game_score == 10.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.v, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.w, R.drawable.game_comment_score_btn_small_full_bg);
            }
        }
    }
}
