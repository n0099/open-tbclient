package c.a.t0.a0.l.g.c.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.l.d;
import c.a.t0.a0.l.g.c.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaLiveMarkData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f14983b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f14984c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.a0.l.g.c.a f14985d;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f14986e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14987f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14988g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f14989h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f14990i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f14991j;
    public TextView k;
    public LinearLayout l;
    public AlaNetRefreshView m;
    public RelativeLayout n;
    public TextView o;
    public View p;
    public c q;
    public List<AlaLiveMarkData> r;
    public a.d s;

    /* renamed from: c.a.t0.a0.l.g.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0950a extends c.a.d.f.l.c<c.a.d.n.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0950a(a aVar) {
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
                super.onLoaded((C0950a) aVar, str, i2);
                if (aVar == null || aVar.p() == null) {
                    return;
                }
                this.a.f14989h.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.a.f14989h.setImageBitmap(BitmapHelper.fastblur(aVar.p(), 15, 0.75f));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.t0.a0.l.g.c.a.d
        public void a(c.a.t0.a0.l.g.c.b.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || this.a.q == null) {
                return;
            }
            this.a.q.a(bVar);
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(c.a.t0.a0.l.g.c.b.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new ArrayList();
        this.s = new b(this);
        this.f14983b = tbPageContext;
        this.q = cVar;
        e();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void d() {
        AlaNetRefreshView alaNetRefreshView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alaNetRefreshView = this.m) == null) {
            return;
        }
        alaNetRefreshView.dettachView(this.n);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f14983b.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
            this.a = inflate;
            inflate.setPadding(0, (int) this.f14983b.getResources().getDimension(R.dimen.ds80), 0, 0);
            this.f14986e = (HeadImageView) this.a.findViewById(R.id.ala_person_center_privilege_header_iv);
            this.f14987f = (TextView) this.a.findViewById(R.id.ala_person_center_privilege_header_name_tv);
            this.f14988g = (TextView) this.a.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
            this.f14989h = (TbImageView) this.a.findViewById(R.id.ala_person_center_privilege_header_container_bg);
            this.n = (RelativeLayout) this.a.findViewById(R.id.ala_person_center_privilege_mark_list_container);
            this.l = (LinearLayout) this.a.findViewById(R.id.ala_person_center_privilege_header_has_wears);
            this.o = (TextView) this.a.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
            this.f14991j = (ImageView) this.a.findViewById(R.id.empty_image);
            this.k = (TextView) this.a.findViewById(R.id.empty_text);
            this.p = this.a.findViewById(R.id.ala_person_center_privilege_mask);
            this.f14984c = (BdListView) this.a.findViewById(R.id.ala_person_center_privilege_mark_list);
            c.a.t0.a0.l.g.c.a aVar = new c.a.t0.a0.l.g.c.a(this.f14983b, this.s);
            this.f14985d = aVar;
            this.f14984c.setAdapter((ListAdapter) aVar);
            RelativeLayout relativeLayout = (RelativeLayout) this.a.findViewById(R.id.emptyview);
            this.f14990i = relativeLayout;
            this.f14984c.setEmptyView(relativeLayout);
            this.f14986e.setIsRound(true);
            this.f14986e.setDefaultBgResource(R.color.transparent);
            this.f14986e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14989h.setDefaultBgResource(R.color.transparent);
            this.f14989h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f14987f, R.color.common_color_10310);
            SkinManager.setViewTextColor(this.f14988g, R.color.white_alpha70);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0106);
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.f14991j.setAlpha(0.4f);
                this.p.setBackgroundColor(this.f14983b.getResources().getColor(R.color.black_alpha60));
                return;
            }
            this.f14991j.setAlpha(1.0f);
            this.p.setBackgroundColor(this.f14983b.getResources().getColor(R.color.black_alpha30));
        }
    }

    public void g(AlaUserInfoData alaUserInfoData, List<c.a.t0.a0.l.g.c.b.c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, alaUserInfoData, list) == null) {
            c.a.t0.a0.l.g.c.a aVar = this.f14985d;
            if (aVar != null && list != null) {
                aVar.d(list);
            }
            i(alaUserInfoData);
        }
    }

    public void h(int i2, int i3, boolean z, View.OnClickListener onClickListener) {
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), onClickListener}) == null) || (tbPageContext = this.f14983b) == null) {
            return;
        }
        if (this.m == null) {
            this.m = new AlaNetRefreshView(tbPageContext.getPageActivity());
        }
        this.m.setImageResource(i2);
        this.m.setNetFailTipText(this.f14983b.getString(i3));
        this.m.onChangeSkinType();
        this.m.setIsShowRefreshButton(z);
        if (z) {
            this.m.setOnRefreshClickListener(onClickListener);
        }
        this.m.attachView(this.n);
    }

    public final void i(AlaUserInfoData alaUserInfoData) {
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, alaUserInfoData) == null) {
            if (alaUserInfoData != null) {
                String str = alaUserInfoData.user_nickname;
                String str2 = alaUserInfoData.user_name;
                if (str == null) {
                    str = str2 != null ? str2 : TbadkCoreApplication.getCurrentAccountNameShow();
                }
                String str3 = alaUserInfoData.portrait;
                if (str3 == null) {
                    str3 = TbadkCoreApplication.getCurrentPortrait();
                }
                if (alaUserInfoData.mark_count == null) {
                    format = String.format(this.f14983b.getString(R.string.ala_achievement_mark_get_text), 0);
                } else {
                    format = String.format(this.f14983b.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
                }
                j(str3, str, format);
                int dimension = (int) this.f14983b.getResources().getDimension(R.dimen.ds32);
                List<AlaLiveMarkData> list = this.r;
                if (list != null && list.size() > 0) {
                    this.r.clear();
                }
                LinearLayout linearLayout = this.l;
                if (linearLayout != null) {
                    linearLayout.removeAllViews();
                    List<AlaLiveMarkData> list2 = alaUserInfoData.live_mark_info_new;
                    this.r = list2;
                    if (list2 != null) {
                        for (int i2 = 0; i2 < this.r.size(); i2++) {
                            TbImageView tbImageView = new TbImageView(this.f14983b.getPageActivity());
                            tbImageView.setDefaultBgResource(R.color.transparent);
                            tbImageView.startLoad(this.r.get(i2).mark_pic, 21, false);
                            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.f14983b.getResources().getDimension(R.dimen.ds12);
                            this.l.addView(tbImageView);
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            j(TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountNameShow(), String.format(this.f14983b.getString(R.string.ala_achievement_mark_get_text), 0));
            List<AlaLiveMarkData> list3 = this.r;
            if (list3 != null && list3.size() > 0) {
                this.r.clear();
            }
            LinearLayout linearLayout2 = this.l;
            if (linearLayout2 != null) {
                linearLayout2.removeAllViews();
            }
        }
    }

    public final void j(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            if (!StringUtils.isNull(str)) {
                this.f14986e.startLoad(str, 25, false);
                d.h().m(str, 25, new C0950a(this), null);
            } else {
                this.f14986e.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
                this.f14989h.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            }
            if (!StringUtils.isNull(str2)) {
                this.f14987f.setText(str2);
            } else {
                this.f14987f.setText("");
            }
            if (!StringUtils.isNull(str3)) {
                this.f14988g.setText(str3);
            } else {
                this.f14988g.setText("");
            }
        }
    }
}
