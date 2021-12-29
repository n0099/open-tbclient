package c.a.t0.d1.g2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TbImageView B;
    public LinearLayout C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public h I;
    public BlurDrawable J;
    public FrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f16415b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f16416c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f16417d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f16418e;

    /* renamed from: f  reason: collision with root package name */
    public ColumnLayout f16419f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16420g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f16421h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16422i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f16423j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f16424k;
    public RadioButton l;
    public RadioButton m;
    public RadioButton n;
    public RadioButton o;
    public RadioButton p;
    public RadioButton[] q;
    public TextView r;
    public TbImageView s;
    public TextView t;
    public RadioButton u;
    public RadioButton v;
    public RadioButton w;
    public RadioButton x;
    public RadioButton y;
    public RadioButton[] z;

    /* renamed from: c.a.t0.d1.g2.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1011a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1011a(a aVar) {
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
            this.a = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.a.f16420g.setVisibility(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16425e;

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
            this.f16425e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f16425e.g()) == null || this.f16425e.I == null) {
                return;
            }
            this.f16425e.I.onWeixinShare(g2);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16426e;

        public c(a aVar) {
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
            this.f16426e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f16426e.g()) == null || this.f16426e.I == null) {
                return;
            }
            this.f16426e.I.onWxFriendsShare(g2);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16427e;

        public d(a aVar) {
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
            this.f16427e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f16427e.g()) == null || this.f16427e.I == null) {
                return;
            }
            this.f16427e.I.onQQShare(g2);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16428e;

        public e(a aVar) {
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
            this.f16428e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f16428e.g()) == null || this.f16428e.I == null) {
                return;
            }
            this.f16428e.I.onSinaShare(g2);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16429e;

        public f(a aVar) {
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
            this.f16429e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16429e.I == null) {
                return;
            }
            this.f16429e.I.onCancel();
        }
    }

    /* loaded from: classes7.dex */
    public class g extends c.a.d.f.l.c<c.a.d.n.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public g(a aVar) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.n.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((g) aVar, str, i2);
                if (aVar == null || aVar.p() == null) {
                    UtilHelper.showToast(this.a.a.getContext(), R.string.share_failed);
                    if (this.a.I != null) {
                        this.a.I.onCancel();
                    }
                }
                this.a.J = new BlurDrawable(this.a.a.getContext());
                this.a.J.init(2, 4, aVar.p());
                this.a.J.drawBlur();
                this.a.f16416c.setImageBitmap(this.a.J.getBlurredBitmap());
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface h {
        void onCancel();

        void onQQShare(Bitmap bitmap);

        void onSinaShare(Bitmap bitmap);

        void onWeixinShare(Bitmap bitmap);

        void onWxFriendsShare(Bitmap bitmap);
    }

    public a(Context context, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.I = hVar;
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.a = frameLayout;
        this.f16415b = (FrameLayout) frameLayout.findViewById(R.id.game_share_content_layout);
        this.f16416c = (ImageView) this.a.findViewById(R.id.game_share_content_bg_view);
        this.f16417d = (LinearLayout) this.a.findViewById(R.id.game_share_card_layout);
        this.f16418e = (FrameLayout) this.a.findViewById(R.id.game_share_header_root);
        this.f16419f = (ColumnLayout) this.a.findViewById(R.id.game_share_header_layout);
        TbImageView tbImageView = (TbImageView) this.a.findViewById(R.id.game_share_header_bg_view);
        this.f16420g = tbImageView;
        tbImageView.setVisibility(4);
        this.f16420g.setDefaultBg(new ColorDrawable(this.a.getResources().getColor(R.color.transparent)));
        this.f16420g.setDrawerType(1);
        this.f16420g.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f16420g.setEvent(new C1011a(this));
        TbImageView tbImageView2 = (TbImageView) this.a.findViewById(R.id.game_share_game_icon);
        this.f16421h = tbImageView2;
        tbImageView2.setDrawerType(1);
        this.f16421h.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f16422i = (TextView) this.a.findViewById(R.id.game_share_game_name);
        this.f16423j = (TextView) this.a.findViewById(R.id.game_share_game_description);
        this.f16424k = (TextView) this.a.findViewById(R.id.game_share_game_score);
        this.l = (RadioButton) this.a.findViewById(R.id.game_share_score_grade_1);
        this.m = (RadioButton) this.a.findViewById(R.id.game_share_score_grade_2);
        this.n = (RadioButton) this.a.findViewById(R.id.game_share_score_grade_3);
        this.o = (RadioButton) this.a.findViewById(R.id.game_share_score_grade_4);
        RadioButton radioButton = (RadioButton) this.a.findViewById(R.id.game_share_score_grade_5);
        this.p = radioButton;
        this.q = new RadioButton[]{this.l, this.m, this.n, this.o, radioButton};
        this.r = (TextView) this.a.findViewById(R.id.game_share_comment);
        TbImageView tbImageView3 = (TbImageView) this.a.findViewById(R.id.game_share_user_protrait);
        this.s = tbImageView3;
        tbImageView3.setDrawerType(1);
        this.s.setIsRound(true);
        this.t = (TextView) this.a.findViewById(R.id.game_share_user_name);
        this.u = (RadioButton) this.a.findViewById(R.id.game_share_user_score_grade_1);
        this.v = (RadioButton) this.a.findViewById(R.id.game_share_user_score_grade_2);
        this.w = (RadioButton) this.a.findViewById(R.id.game_share_user_score_grade_3);
        this.x = (RadioButton) this.a.findViewById(R.id.game_share_user_score_grade_4);
        RadioButton radioButton2 = (RadioButton) this.a.findViewById(R.id.game_share_user_score_grade_5);
        this.y = radioButton2;
        this.z = new RadioButton[]{this.u, this.v, this.w, this.x, radioButton2};
        this.A = (TextView) this.a.findViewById(R.id.game_share_qr_txt);
        this.B = (TbImageView) this.a.findViewById(R.id.game_share_qr_img);
        this.C = (LinearLayout) this.a.findViewById(R.id.game_share_entry_layout);
        TextView textView = (TextView) this.a.findViewById(R.id.game_share_entry_weixin);
        this.D = textView;
        textView.setOnClickListener(new b(this));
        TextView textView2 = (TextView) this.a.findViewById(R.id.game_share_entry_wxfriends);
        this.E = textView2;
        textView2.setOnClickListener(new c(this));
        TextView textView3 = (TextView) this.a.findViewById(R.id.game_share_entry_qq);
        this.F = textView3;
        textView3.setOnClickListener(new d(this));
        TextView textView4 = (TextView) this.a.findViewById(R.id.game_share_entry_sina);
        this.G = textView4;
        textView4.setOnClickListener(new e(this));
        TextView textView5 = (TextView) this.a.findViewById(R.id.game_share_cancel);
        this.H = textView5;
        textView5.setOnClickListener(new f(this));
    }

    public Bitmap g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f16415b.buildDrawingCache();
            return this.f16415b.getDrawingCache();
        }
        return (Bitmap) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16417d.getBottom() : invokeV.intValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void j() {
        BlurDrawable blurDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (blurDrawable = this.J) == null) {
            return;
        }
        blurDrawable.onDestroy();
        this.J = null;
    }

    public final void k(int i2, RadioButton[] radioButtonArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i2, radioButtonArr) == null) && radioButtonArr != null && radioButtonArr.length == 5) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > 10) {
                i2 = 10;
            }
            int i3 = i2 / 2;
            for (int i4 = 0; i4 < radioButtonArr.length; i4++) {
                if (radioButtonArr[i4] != null) {
                    if (i4 < i3) {
                        radioButtonArr[i4].setChecked(true);
                    } else {
                        radioButtonArr[i4].setChecked(false);
                    }
                }
            }
        }
    }

    public final void l(GameShareData gameShareData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gameShareData) == null) || gameShareData == null) {
            return;
        }
        this.f16421h.startLoad(gameShareData.gameIconUrl, 10, false);
        this.f16422i.setText(gameShareData.gameName);
        this.f16423j.setText(gameShareData.gameDescription);
        this.f16424k.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
        k((int) gameShareData.gameScore, this.q);
    }

    public void m(GameShareData gameShareData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gameShareData) == null) {
            l(gameShareData);
            n(gameShareData);
            StringBuilder sb = new StringBuilder();
            sb.append("“ ");
            sb.append(gameShareData.gameComment);
            sb.append(" ”");
            this.r.setText(sb);
            if (this.J == null) {
                c.a.d.f.l.d.h().m(gameShareData.gameIconUrl, 10, new g(this), null);
            }
            this.f16420g.startLoad(gameShareData.headBgUrl, 10, false);
            this.B.startLoad(gameShareData.shareQRCodeUrl, 10, false);
        }
    }

    public final void n(GameShareData gameShareData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, gameShareData) == null) || gameShareData == null) {
            return;
        }
        this.s.startLoad(gameShareData.userPortrait, 12, false);
        this.t.setText(gameShareData.userName);
        k((int) gameShareData.userScore, this.z);
    }
}
