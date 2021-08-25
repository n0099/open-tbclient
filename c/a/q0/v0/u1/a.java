package c.a.q0.v0.u1;

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
/* loaded from: classes4.dex */
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

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f27212a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f27213b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f27214c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f27215d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f27216e;

    /* renamed from: f  reason: collision with root package name */
    public ColumnLayout f27217f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f27218g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f27219h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f27220i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f27221j;
    public TextView k;
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

    /* renamed from: c.a.q0.v0.u1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1274a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27222a;

        public C1274a(a aVar) {
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
            this.f27222a = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.f27222a.f27218g.setVisibility(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27223e;

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
            this.f27223e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f27223e.g()) == null || this.f27223e.I == null) {
                return;
            }
            this.f27223e.I.onWeixinShare(g2);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27224e;

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
            this.f27224e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f27224e.g()) == null || this.f27224e.I == null) {
                return;
            }
            this.f27224e.I.onWxFriendsShare(g2);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27225e;

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
            this.f27225e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f27225e.g()) == null || this.f27225e.I == null) {
                return;
            }
            this.f27225e.I.onQQShare(g2);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27226e;

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
            this.f27226e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f27226e.g()) == null || this.f27226e.I == null) {
                return;
            }
            this.f27226e.I.onSinaShare(g2);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27227e;

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
            this.f27227e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f27227e.I == null) {
                return;
            }
            this.f27227e.I.onCancel();
        }
    }

    /* loaded from: classes4.dex */
    public class g extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27228a;

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
            this.f27228a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((g) aVar, str, i2);
                if (aVar == null || aVar.p() == null) {
                    UtilHelper.showToast(this.f27228a.f27212a.getContext(), R.string.share_failed);
                    if (this.f27228a.I != null) {
                        this.f27228a.I.onCancel();
                    }
                }
                this.f27228a.J = new BlurDrawable(this.f27228a.f27212a.getContext());
                this.f27228a.J.init(2, 4, aVar.p());
                this.f27228a.J.drawBlur();
                this.f27228a.f27214c.setImageBitmap(this.f27228a.J.getBlurredBitmap());
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f27212a = frameLayout;
        this.f27213b = (FrameLayout) frameLayout.findViewById(R.id.game_share_content_layout);
        this.f27214c = (ImageView) this.f27212a.findViewById(R.id.game_share_content_bg_view);
        this.f27215d = (LinearLayout) this.f27212a.findViewById(R.id.game_share_card_layout);
        this.f27216e = (FrameLayout) this.f27212a.findViewById(R.id.game_share_header_root);
        this.f27217f = (ColumnLayout) this.f27212a.findViewById(R.id.game_share_header_layout);
        TbImageView tbImageView = (TbImageView) this.f27212a.findViewById(R.id.game_share_header_bg_view);
        this.f27218g = tbImageView;
        tbImageView.setVisibility(4);
        this.f27218g.setDefaultBg(new ColorDrawable(this.f27212a.getResources().getColor(R.color.transparent)));
        this.f27218g.setDrawerType(1);
        this.f27218g.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f27218g.setEvent(new C1274a(this));
        TbImageView tbImageView2 = (TbImageView) this.f27212a.findViewById(R.id.game_share_game_icon);
        this.f27219h = tbImageView2;
        tbImageView2.setDrawerType(1);
        this.f27219h.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f27220i = (TextView) this.f27212a.findViewById(R.id.game_share_game_name);
        this.f27221j = (TextView) this.f27212a.findViewById(R.id.game_share_game_description);
        this.k = (TextView) this.f27212a.findViewById(R.id.game_share_game_score);
        this.l = (RadioButton) this.f27212a.findViewById(R.id.game_share_score_grade_1);
        this.m = (RadioButton) this.f27212a.findViewById(R.id.game_share_score_grade_2);
        this.n = (RadioButton) this.f27212a.findViewById(R.id.game_share_score_grade_3);
        this.o = (RadioButton) this.f27212a.findViewById(R.id.game_share_score_grade_4);
        RadioButton radioButton = (RadioButton) this.f27212a.findViewById(R.id.game_share_score_grade_5);
        this.p = radioButton;
        this.q = new RadioButton[]{this.l, this.m, this.n, this.o, radioButton};
        this.r = (TextView) this.f27212a.findViewById(R.id.game_share_comment);
        TbImageView tbImageView3 = (TbImageView) this.f27212a.findViewById(R.id.game_share_user_protrait);
        this.s = tbImageView3;
        tbImageView3.setDrawerType(1);
        this.s.setIsRound(true);
        this.t = (TextView) this.f27212a.findViewById(R.id.game_share_user_name);
        this.u = (RadioButton) this.f27212a.findViewById(R.id.game_share_user_score_grade_1);
        this.v = (RadioButton) this.f27212a.findViewById(R.id.game_share_user_score_grade_2);
        this.w = (RadioButton) this.f27212a.findViewById(R.id.game_share_user_score_grade_3);
        this.x = (RadioButton) this.f27212a.findViewById(R.id.game_share_user_score_grade_4);
        RadioButton radioButton2 = (RadioButton) this.f27212a.findViewById(R.id.game_share_user_score_grade_5);
        this.y = radioButton2;
        this.z = new RadioButton[]{this.u, this.v, this.w, this.x, radioButton2};
        this.A = (TextView) this.f27212a.findViewById(R.id.game_share_qr_txt);
        this.B = (TbImageView) this.f27212a.findViewById(R.id.game_share_qr_img);
        this.C = (LinearLayout) this.f27212a.findViewById(R.id.game_share_entry_layout);
        TextView textView = (TextView) this.f27212a.findViewById(R.id.game_share_entry_weixin);
        this.D = textView;
        textView.setOnClickListener(new b(this));
        TextView textView2 = (TextView) this.f27212a.findViewById(R.id.game_share_entry_wxfriends);
        this.E = textView2;
        textView2.setOnClickListener(new c(this));
        TextView textView3 = (TextView) this.f27212a.findViewById(R.id.game_share_entry_qq);
        this.F = textView3;
        textView3.setOnClickListener(new d(this));
        TextView textView4 = (TextView) this.f27212a.findViewById(R.id.game_share_entry_sina);
        this.G = textView4;
        textView4.setOnClickListener(new e(this));
        TextView textView5 = (TextView) this.f27212a.findViewById(R.id.game_share_cancel);
        this.H = textView5;
        textView5.setOnClickListener(new f(this));
    }

    public Bitmap g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f27213b.buildDrawingCache();
            return this.f27213b.getDrawingCache();
        }
        return (Bitmap) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27215d.getBottom() : invokeV.intValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27212a : (View) invokeV.objValue;
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
        this.f27219h.startLoad(gameShareData.gameIconUrl, 10, false);
        this.f27220i.setText(gameShareData.gameName);
        this.f27221j.setText(gameShareData.gameDescription);
        this.k.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
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
                c.a.e.e.l.d.h().m(gameShareData.gameIconUrl, 10, new g(this), null);
            }
            this.f27218g.startLoad(gameShareData.headBgUrl, 10, false);
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
