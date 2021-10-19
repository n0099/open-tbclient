package c.a.r0.b0;

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
/* loaded from: classes3.dex */
public class h extends b<c.a.r0.h0.g> {
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
    public c.a.r0.h0.g y;
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
        p(j());
    }

    @Override // c.a.r0.b0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_frs_game_score_view_item : invokeV.intValue;
    }

    @Override // c.a.r0.b0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f15707e != i2) {
                SkinManager.setBackgroundResource(j(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.z, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0107, 1);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0107, 1);
                s(this.y);
            }
            this.f15707e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || g() == null) {
            return;
        }
        g().a(j(), this.y);
    }

    public final void p(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
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
            this.m.setBorderWidth(this.f15709g.getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.m.setRadius(d().getResources().getDimensionPixelSize(R.dimen.tbds26));
            j().setOnClickListener(this);
            this.z = view.findViewById(R.id.divider_line);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.b0.b
    /* renamed from: q */
    public void k(c.a.r0.h0.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || gVar == null || gVar.g() == null) {
            return;
        }
        this.y = gVar;
        this.m.startLoad(gVar.g().avatar, 10, false);
        this.o.setText(gVar.g().game_name);
        this.p.setText(gVar.g().title_small);
        this.q.setText(String.valueOf(gVar.g().game_score));
        s(gVar);
        this.x.setText(this.f15709g.getResources().getString(R.string.frs_game_score_user_score_num, StringHelper.numberUniform(gVar.g().game_score_num)));
    }

    public final void s(c.a.r0.h0.g gVar) {
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
